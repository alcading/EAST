/**
 * 
 */
package com.huateng.report.imports.logic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import resource.bean.report.BiImportXmlConfig;

import com.huateng.report.imports.model.TFileDataInfo;
import com.huateng.report.imports.model.TNodeInfo;
import com.huateng.report.imports.model.TNodeInfoList;
import com.huateng.report.imports.model.TNodeKeyInfo;
import com.huateng.report.imports.service.FileImportService;




/**
 * @author chl_seu 操作XML文件
 * @version 1.00
 */
@SuppressWarnings("unchecked")
public class XmlOp {
	private TFileDataInfo FileInfo = null;
	private List fileContentList = new ArrayList();
	private InputStream xmlResource;
	private Document doc;
	private String separator;
	private TNodeInfoList nodeInfoList=new TNodeInfoList();
	

	/**
	 * @author chl_seu 打开XML文件/初始化静态成员
	 * @param finfo 当前Xml文件信息
	 */
	public boolean init(TFileDataInfo finfo, String sPath) {
		if (finfo != null) {
			// 传入导入文件信息
			FileInfo = finfo;
		} else {
			return false;
		}

		try {
			File vFile = new File(sPath + finfo.getFileFullName());
			if (!vFile.exists()) {
				return false;
			}
			xmlResource = new FileInputStream(vFile);
			separator = "|";
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	/**
	 * @author chl_seu 操作XML文件
	 * 
	 */
	public boolean readXml() {
		fileContentList.clear();
		if (!readXmlConfig()) {
			return false;
		}
		TNodeKeyInfo nki = new TNodeKeyInfo();
		nki.fuid = "first";
		nki.uid = "root";
		
		TNodeInfo ni = nodeInfoList.getNodeInfo(nki);
		
		SAXReader reader = new SAXReader();
		try {
			doc = reader.read(xmlResource);

			if (!readXmlNode(ni)) {
				return false;
			}
		} catch (Exception e) {
			return false;
		} finally {
			xmlResource = null;
		}
		
		return true;
	}

	private boolean readXmlNode(TNodeInfo ni) {
		if (ni.child_exist) {
			ArrayList nl = ni.getArrayList();
			TNodeInfo rootNode = (TNodeInfo) nl.get(0); // 根节点
			List<Node> nodes = doc.selectNodes(rootNode.node_xpath);

			if (nodes.size()==0){
				return false;
			}
			
			for (int i = 0; i < nodes.size(); i++) {
				List<String> listStr = new ArrayList<String>();
				listStr.add("");
				List<String> rtnList = parseNode(rootNode, nodes.get(i), listStr);
				for (int j = 0; j < rtnList.size(); j++) {
					if (rtnList.get(j).equals(""))
						continue;
					fileContentList.add(rtnList.get(j).substring(1));
					//kycCommon.readLineCount++;
				}
			}
		} else {
			return false;
		}
		

		return true;
	}
	
	private List<String> parseNode(TNodeInfo ni, Node node, List<String> listStr){
		if (ni.child_exist){
			List<String> rtnList = new ArrayList<String>();  //返回值
			ArrayList<TNodeInfo> children = ni.getArrayList();  //当前节点子节点
			for (int j=0; j< listStr.size(); j++){ //单记录递归子节点
				List<String> branchList = new ArrayList<String>(); //单记录递归结果
				branchList.add(listStr.get(j));
				
				for (int i=0; i<children.size(); i++){ //遍历兄弟子节点
					if (children.get(i).node_property.equals("1")) { // 重复节点 
						List<Node> childNodes = node.selectNodes(children.get(i).node_xpath);
						List<String> branchTmpList = new ArrayList<String>();   //分节点记录
						for (int k=0;k<childNodes.size();k++){
							List<String> tmpList = parseNode(children.get(i), childNodes.get(k), branchList);
							for (int m=0; m< tmpList.size(); m++){
								branchTmpList.add(tmpList.get(m));					
							}
						}
						if (branchTmpList.size()>0){
							branchList.clear();
							for (int n=0;n<branchTmpList.size();n++){
								branchList.add(branchTmpList.get(n));
							}
						}
					}else{
						if (children.get(i).node_getval.equals("1")){//取值
							for (int x=0; x< branchList.size(); x++){
								branchList.set(x, branchList.get(x)+this.separator+getNodeValue(children.get(i), node));
							}
						}
					}
				}
				
				for (int l=0; l<branchList.size(); l++){
					rtnList.add(branchList.get(l));//.substring(1));
				}
			}
			return rtnList;
		}else{
			return listStr;
		}
	}
	

	
	/**
	 * @author chl_seu 操作XML文件
	 * 
	 */
	private boolean readXmlConfig() {
		boolean flg = false;
		// 按顺序号取节点配置
		try {
			List rstList = FileImportService.getInstance().getXmlConfig(FileInfo.getGuid());
			// 初始化节点列表
			nodeInfoList.init();
			for (Object o : rstList) {
				BiImportXmlConfig rst = (BiImportXmlConfig) o;
				flg = true;
				TNodeKeyInfo nki = new TNodeKeyInfo();
				TNodeInfo ni = new TNodeInfo();
				nki.fuid = rst.getPid();
				nki.uid = rst.getId();
				ni.keyinfo = nki;
				ni.node_name = rst.getNodeName();
				ni.guid=rst.getGuid();
				ni.node_order = rst.getNodeOrder()==null?0:rst.getNodeOrder();
				ni.node_property = rst.getNodeProperty();
				ni.node_xpath = rst.getNodeXpath();
				ni.node_getval = rst.getNodeGetval();
				ni.node_rtval = rst.getNodeRtval();
				if (!nodeInfoList.addNodeInfo(ni)) {
					return false;
				}
			}
			if (!flg) {
			//	kycCommon.setErrMsg("导入失败,原因:没有读到配置"); 
				return false; // 没有读到配置
			}
		} catch (Exception e) {
//			Log.error("数据库中目的表不存在.");
			e.printStackTrace();
	//		kycCommon.setErrMsg("导入失败,原因:"+e.getMessage()); 
			return false;
		}
		return true;
	}

	/**
	 * 取得导入文件内容列表
	 * 
	 * @param sFileFullName 文件路径名称
	 * @throws IOException
	 */
	public List getFileContentList() {
		return fileContentList;
	}

	/**
	 * 返回文件行数
	 * 
	 * @return 文件行数
	 */
	public int getFileRowCount() {
		return fileContentList.size();
	}
	
	private String parseString(Object obj) {
		if (obj == null) {
			return "";
		} else {
			return String.valueOf(obj);
		}
	}
	
	private String getNodeValue(TNodeInfo ni, Node node) {
		String rtnValue = "";
		if (ni.node_xpath.indexOf("/") != -1) {
			String[] arrPath = ni.node_xpath.split("/");
			Element tmpEl = (Element) node;
			for (int i = 0; i < arrPath.length; i++) {
				if (i != arrPath.length - 1) {
					Iterator<Element> it = tmpEl.elementIterator(arrPath[i]);
					if (it.hasNext()) {
						tmpEl = it.next();
					}
				} else {
					if (arrPath[i].indexOf("@") != -1){
						rtnValue = parseString(tmpEl.attributeValue(arrPath[i]).replaceAll("@", ""));
					}else{
						rtnValue = parseString(tmpEl.elementText(arrPath[i]));
					}
				}
			}
		} else {
			if (ni.node_xpath.indexOf("@") != -1){
				rtnValue = parseString(((Element) node).attributeValue(ni.node_xpath.replaceAll("@", "")));
			}else{
				rtnValue = parseString(((Element) node).elementText(ni.node_xpath));
			}
		}
		return rtnValue;
	}

	
}
