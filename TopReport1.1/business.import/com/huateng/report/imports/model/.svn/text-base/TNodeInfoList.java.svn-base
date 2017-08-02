/**
 * 
 */
package com.huateng.report.imports.model;

import java.util.Hashtable;
import java.util.ArrayList;

/**
 * 每条记录的结构体，即转换为txt后的1行数据
 * 
 * @author chl_seu
 * 
 */
@SuppressWarnings("unchecked")
public class TNodeInfoList {

	public  Hashtable nl = new Hashtable(); // 节点列表，快查

	/**
	 * @author chl_seu 初始化列表，清空列表，初始化根节点
	 * 
	 */
	public  void init() {
		nl.clear();
		// 创建一个默认根节点
		TNodeKeyInfo nki = new TNodeKeyInfo();
		nki.fuid = "first";
		nki.uid = "root";
		TNodeInfo ni = new TNodeInfo();
		ni.keyinfo = nki;
		ni.node_getval = "0"; // 不取值
		nl.put(ni.keyinfo, ni);
	}

	/**
	 * @author chl_seu 节点信息入列表
	 * 
	 */
	public  boolean addNodeInfo(TNodeInfo ni) {
		if (ni != null) {
			nl.put(ni.keyinfo, ni);
			TNodeKeyInfo nki = new TNodeKeyInfo();
			nki.fuid = "";
			nki.uid = ni.keyinfo.fuid;
			// 寻找父节点并加入到父节点的子节点列表中
			TNodeInfo tmpni = (TNodeInfo) nl.get(nki);
			if (tmpni != null) {
				tmpni.addChild(ni);
				ni.pNode = tmpni;
			}
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @author chl_seu 取节点信息
	 * @param nki
	 *            键信息
	 * @return 节点信息
	 */
	public  TNodeInfo getNodeInfo(TNodeKeyInfo nki) {
		if (nki != null) {
			return (TNodeInfo) nl.get(nki);
		} else {
			return null;
		}
	}

	/**
	 * @author chl_seu 取节点信息
	 * @param i
	 *            顺序信息
	 * @return 节点信息
	 */
	public static TNodeInfo getNodeInfo(int i) {
		try {
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @author chl_seu 返回HashTable
	 * 
	 */
	public  Hashtable rtnl() {
		return nl;
	}

	/**
	 * @author chl_seu 返回ArrayList
	 * 
	 */
	public ArrayList rtnlorder() {
		return null;
	}

}
