/**
 * 
 */
package com.huateng.report.imports.model;

/**
 * 节点标识
 * 
 * @author chl_seu
 * 
 */
public class TNodeKeyInfo {
	public String uid;
	public String fuid;

	// 重写eauals方法
	public boolean equals(Object anObject) {
		try {
			TNodeKeyInfo tmpobj = (TNodeKeyInfo) anObject;
			if (this.uid.equals(tmpobj.uid)) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}

	public int hashCode() {
		return this.uid.hashCode();
	}
}
