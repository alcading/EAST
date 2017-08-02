/**
 * 
 */
package com.huateng.report.imports.model;

import java.util.ArrayList;

/**
 * 节点信息类
 * 
 * @author chl_seu
 * 
 */
@SuppressWarnings("unchecked")
public class TNodeInfo {
	public TNodeKeyInfo keyinfo; // 键值，包含uid,fuid
	public String brc; // 分行号
	public String guid;
	public String node_name; // 节点名称
	public int node_order; // 节点拼接顺序号
	public String node_xpath; // 节点相对xpath
	public String node_property; // 节点性质：是否存在相同性质兄弟节点：0-不存在 1-存在
	public String node_getval; // 是否取值
	public String node_rtval; // 0-不返回结果 1-返回结果
	public String node_value; // 节点读取的值
	public String node_tmpval; // 临时值
	public boolean child_exist; // 存在子节点

	private ArrayList childListOrder = new ArrayList(); // 子节点按序排列
	public TNodeInfo pNode = null; // 父节点

	/**
	 * @author chl_seu 取得子节点信息
	 * @param xpath
	 *            同一节点的子节点xpath唯一
	 * @return 子节点信息
	 */
	public TNodeInfo getchild(String xpath) {
		if (xpath != null) {
			return null;
		} else {
			return null;
		}
	}

	/**
	 * @author chl_seu 添加子节点信息
	 * @param ni
	 *            包含子节点信息的对象
	 * @return true-成功 false-失败
	 */
	public boolean addChild(TNodeInfo ni) {
		if (ni != null) {
			childListOrder.add(childListOrder.size(), ni); // 先后顺序与node_order先后一致
			child_exist = true;
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @author chl_seu 返回子节点列表
	 * @return 子节点列表
	 */
	public ArrayList getArrayList() {
		return childListOrder;
	}

}
