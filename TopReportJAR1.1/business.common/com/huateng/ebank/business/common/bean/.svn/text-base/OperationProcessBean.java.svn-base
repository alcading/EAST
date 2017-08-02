package com.huateng.ebank.business.common.bean;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;



/**
 * 操作流程描述 所定义的bean
 * @author lizh
 *
 */
public class OperationProcessBean {

public static final String FILE_URL_PATH="/WEB-INF/Reindeer-Config/";	


/************操作类型定义*************/



 /*******业务类型**承兑业务**********/
/**操作类型定义-承兑业务-承兑批次录入*/	
public static final String CHD_CONTRACT_INFO_ADD="1001";
/**操作类型定义-承兑业务-承兑明细录入*/	
public static final String CHD_CONTRACT_MXINFO_ADD="1002";
/**操作类型定义-承兑业务-授信检查*/	
public static final String CHD_CREDIT_INFO_CHECK="1003";
/**操作类型定义-承兑业务-逻辑检查*/	
public static final String CHD_LOGIC_INFO_CHECK="1004";
/**操作类型定义-承兑业务-提交审核*/	
public static final String CHD_SUMITAUDIT_INFO_CHECK="1005";
/**操作类型定义-承兑业务-审核*/	
public static final String CHD_AUDIT_INFO_CHECK="1006";

/*******业务类型**买入业务**********/

/**操作类型定义-买入业务-买入批次录入*/	
public static final String BUYIN_CONTRACT_INFO_ADD="2001";
/**操作类型定义-买入业务-买入明细录入*/	
public static final String BUYIN_CONTRACT_MXINFO_ADD="2002";
/**操作类型定义-买入业务-风险票据检查*/	
public static final String BUYIN_RISKDRAFT_INFO_CHECK="2003";
/**操作类型定义-买入业务-授信检查*/	
public static final String BUYIN_CREDIT_INFO_CHECK="2004";
/**操作类型定义-买入业务-业务逻辑检查*/	
public static final String BUYIN_LOGIC_INFO_CHECK="2005";
/**操作类型定义-买入业务-收票*/	
public static final String BUYIN_RECEIVE_INFO="2006";
/**操作类型定义-买入业务-利息计算*/	
public static final String BUYIN_INTEREST_INFO_CALCULATE="2007";
/**操作类型定义-买入业务-提交审核*/	
public static final String BUYIN_SUMITAUDIT_MXINFO_CHECK="2008";
/**操作类型定义-买入业务-审核*/	
public static final String BUYIN_AUDIT_INFO_CHECK="2009";


/*******业务类型**转卖申请业务**********/

/**操作类型定义-转卖业务-转卖批次录入*/	
public static final String SELL_CONTRACT_INFO_ADD="3001";
/**操作类型定义-转卖业务-转卖明细录入*/	
public static final String SELL_CONTRACT_MXINFO_ADD="3002";
/**操作类型定义-转卖业务-逻辑检查*/	
public static final String SELL_LOGIC_INFO_CHECK="3003";
/**操作类型定义-转卖业务-利率复核*/	
public static final String SELL_INTEREST_AUDITINFO_CHECK="3004";

/*******业务类型**转卖挑票业务**********/

/**操作类型定义-转卖挑票业务-转卖挑票批次录入*/	
public static final String SELL_TEMP_CONTRACT_INFO_ADD="4001";
/**操作类型定义-转卖挑票业务-转卖挑票明细录入*/	
public static final String SELL_TEMP_CONTRACT_MXINFO_ADD="4002";
/**操作类型定义-转卖挑票业务-导出挑票清单*/	
public static final String SELL_TEMP_EXPORT="4003";


/************操作状态定义******/

/**操作状态定义-成功*/	
public static final String OPERATION_STATUS_SUCCESS="01";
/**操作状态定义-失败*/	
public static final String OPERATION_STATUS_FAILURE="00";


/************业务类型定义******/

/**业务类型定义-承兑业务*/	
public static final String BUSINESS_TYPE_CHD="1";
/**业务类型定义-买入业务*/	
public static final String BUSINESS_TYPE_BUY="2";
/**业务类型定义-转卖业务*/	
public static final String BUSINESS_TYPE_SELL="3";
/**业务类型定义-转卖挑票业务*/	
public static final String BUSINESS_TYPE_SELL_TMP="4";

/**操作员ID*/	
private Integer operatorId;
/**操作员名称*/	
private String operatorName;
/**操作员IP*/	
private String operatorIp;
/**操作类型*/	
private String operateType;
/**操作名称*/	
private String operateName;
/**操作状态*/	
private String operateStatus;
/**操作日期*/	
private String operateDate;
/**操作时间*/	
private String operateTime;
/**操作对象ID*/	
private Integer operateObjectId;
/**操作业务类型*/	
private String businessType;

public OperationProcessBean(){
	
}
public OperationProcessBean(Integer operatorId,String operatorIp,String operateType,String operateName,
		String operateStatus,String operateDate,String operateTime,Integer operateObjectId,String businessType){
	this.operatorId = operatorId;
	this.operatorIp = operatorIp;
	this.operateType = operateType;
	this.operateName = operateName;
	this.operateStatus = operateStatus;
	this.operateDate = operateDate;
	this.operateTime = operateTime;
	this.operateObjectId = operateObjectId;
	this.businessType = businessType;	
}


public Integer getOperatorId() {
	return operatorId;
}


public void setOperatorId(Integer operatorId) {
	this.operatorId = operatorId;
}


public String getOperatorIp() {
	return operatorIp;
}


public void setOperatorIp(String operatorIp) {
	this.operatorIp = operatorIp;
}


public String getOperateType() {
	return operateType;
}


public void setOperateType(String operateType) {
	this.operateType = operateType;
}


public String getOperateName() {
	return operateName;
}


public void setOperateName(String operateName) {
	this.operateName = operateName;
}


public String getOperateStatus() {
	return operateStatus;
}


public void setOperateStatus(String operateStatus) {
	this.operateStatus = operateStatus;
}


public String getOperateDate() {
	return operateDate;
}


public void setOperateDate(String operateDate) {
	this.operateDate = operateDate;
}


public String getOperateTime() {
	return operateTime;
}


public void setOperateTime(String operateTime) {
	this.operateTime = operateTime;
}


public Integer getOperateObjectId() {
	return operateObjectId;
}


public void setOperateObjectId(Integer operateObjectId) {
	this.operateObjectId = operateObjectId;
}


public String getBusinessType() {
	return businessType;
}


public void setBusinessType(String businessType) {
	this.businessType = businessType;
}

/**
 * 通过操作类型代码转换中文名称
 * @param operationTypeValue
 * @return
 * @author lizh
 */
 public static String getOperationTypeName(String operationTypeValue){
	 if(CHD_CONTRACT_INFO_ADD.equals(operationTypeValue)){
		 	return "承兑批次录入";
	 }else if(CHD_CONTRACT_MXINFO_ADD.equals(operationTypeValue)){
		 	return "承兑明细录入";
	 }else if(CHD_CREDIT_INFO_CHECK.equals(operationTypeValue)){
		 	return "授信检查";
	 }else if(CHD_LOGIC_INFO_CHECK.equals(operationTypeValue)){
		 	return "逻辑检查";
	 }else if(CHD_SUMITAUDIT_INFO_CHECK.equals(operationTypeValue)){
		 	return "提交审核";
	 }else if(CHD_AUDIT_INFO_CHECK.equals(operationTypeValue)){
		    return "审核";
	 }else if(BUYIN_CONTRACT_INFO_ADD.equals(operationTypeValue)){
			 return "买入批次录入";
	 }else if(BUYIN_CONTRACT_MXINFO_ADD.equals(operationTypeValue)){
			 return "买入明细录入";
	 }else if(BUYIN_RISKDRAFT_INFO_CHECK.equals(operationTypeValue)){
			 return "风险票据检查";
	 }else if(BUYIN_CREDIT_INFO_CHECK.equals(operationTypeValue)){
			 return "授信检查";
	 }else if(BUYIN_LOGIC_INFO_CHECK.equals(operationTypeValue)){
			 return "业务逻辑检查";
	 }else  if(BUYIN_RECEIVE_INFO.equals(operationTypeValue)){
			 return "收票";
	 }else if(BUYIN_INTEREST_INFO_CALCULATE.equals(operationTypeValue)){
			 return "利息计算";
	 }else if(BUYIN_SUMITAUDIT_MXINFO_CHECK.equals(operationTypeValue)){
			 return "提交审核";
	 }else if(BUYIN_AUDIT_INFO_CHECK.equals(operationTypeValue)){
			 return "审核";
	 }else if(SELL_CONTRACT_INFO_ADD.equals(operationTypeValue)){
			 return "转卖批次录入";
	 }else if(SELL_CONTRACT_MXINFO_ADD.equals(operationTypeValue)){
			 return "转卖明细录入";
	 }else if(SELL_LOGIC_INFO_CHECK.equals(operationTypeValue)){
			 return "逻辑检查";
	 }else if(SELL_INTEREST_AUDITINFO_CHECK.equals(operationTypeValue)){
			 return "利率复核";
	 }else if(SELL_TEMP_CONTRACT_INFO_ADD.equals(operationTypeValue)){
			 return "转卖挑票批次录入";
	 }else if(SELL_TEMP_CONTRACT_MXINFO_ADD.equals(operationTypeValue)){
			 return "转卖挑票明细录入";
	 }else if(SELL_TEMP_EXPORT.equals(operationTypeValue)){
			 return "导出挑票清单";
	 }else{
		 return "";
	 }
 }

 /**
  * 通过操作状态代码转换中文名称
  * @param operationStatusValue
  * @return
  * @author lizh
  */
  public static String getOperationStatusName(String operationStatusValue){
 	 if(OPERATION_STATUS_SUCCESS.equals(operationStatusValue)){
 		 return "成功";
 	 }else if(OPERATION_STATUS_FAILURE.equals(operationStatusValue)){
 		 return "失败";
 	 }else{
 		 return "";
 	 }
  }


	/**
	 *  通过解析XML获得状态中文值 只适用于commonEnum.xml的解析
	 *  例 <enum id="blankVoucher.voucherState">
	 * 	<keyValuePair key="0" value="未使用"></keyValuePair>
	 * 	<keyValuePair key="1" value="已使用"></keyValuePair>
	 * 	<keyValuePair key="2" value="已作废"></keyValuePair>
	 * 	<keyValuePair key="3" value="未领用"></keyValuePair>
	 * </enum>
	 * @param fileName XML文件名
	 * @param nodeAttributeName 父级结点属性值 如：blankVoucher.voucherState
	 * @param AttributeValue 子结点属性值 key中的值或者value的值
	 * @return 
	 */

	public static  String getStatusName(HttpServletRequest request,String fileName,String nodeAttributeName,String AttributeValue ){
			String path=request.getRealPath("/");	
			try {
				Document doc=getDocument(path+FILE_URL_PATH+fileName);
				Element root=doc.getDocumentElement();
				NodeList children=root.getChildNodes();
				for(int i=0;i<children.getLength();i++){
					Node node=children.item(i);
					if(node.getNodeType()!=1){
						continue;
					}
				 Element element=(Element)(node);				
				 if(nodeAttributeName.equals(element.getAttribute("id"))){
					 NodeList childNodeList=element.getChildNodes();					 
					 for(int j=0;j<childNodeList.getLength();j++){
						 Node childNone=childNodeList.item(j);
						 if(childNone.getNodeType()!=1){
							 continue;
						 }
						 Element childElement=(Element)childNone;										
						 if(AttributeValue.equals(childElement.getAttribute("key"))){							
							 return childElement.getAttribute("value");
						 }
					 }
				  }
				}
			} catch (ParserConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SAXException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   
		return "";
	}


	/**
	 * 建Document对象
	 * @param url
	 * @return
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 */
	public static Document getDocument(String url)
	throws ParserConfigurationException, SAXException, IOException {
	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    //factory.setValidating(true); // 打开dtd验证
	factory.setIgnoringElementContentWhitespace(true);// 忽略空白符
	factory.setIgnoringComments(true); // 忽略注释	
	DocumentBuilder builder = factory.newDocumentBuilder();
	File f = new File(url);
	return builder.parse(f);

}

	/**
	 * 获得某个结点元素的所有属性
	 * @param element
	 */
	public static void getAttributes(Element element){
		NamedNodeMap attributes = element.getAttributes();
		for (int i = 0;i<attributes.getLength();i++){
		        Node attribute = attributes.item(i);
		        String name = attribute.getNodeName();//获得属性名
		        String value = attribute.getNodeValue();//获得属性值
		}
	}
	public String getOperatorName() {
		return operatorName;
	}
	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}
	
	
}
