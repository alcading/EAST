package com.huateng.report.bean;

import org.apache.commons.lang.StringUtils;

public class ExecuteResultBean {
	private String workDate;
	private String brNo;
	private String brName;
	private String apptype;
	private String currentfile;
	private String executeResult;
	public String getWorkDate() {
		return workDate;
	}
	public void setWorkDate(String workDate) {
		this.workDate = workDate;
	}
	public String getBrNo() {
		return brNo;
	}
	public void setBrNo(String brNo) {
		this.brNo = brNo;
	}
	public String getBrName() {
		return brName;
	}
	public void setBrName(String brName) {
		this.brName = brName;
	}
	public String getApptype() {
		return apptype;
	}
	public void setApptype(String apptype) {
		this.apptype = apptype;
	}
	public String getCurrentfile() {
		return currentfile;
	}
	public void setCurrentfile(String currentfile) {
		this.currentfile = currentfile;
	}
	public String getExecuteResult() {
		return executeResult;
	}
	public void setExecuteResult(String executeResult) {
		this.executeResult = executeResult;
	}
	/*
	 * 当apptype和currentfile相同时，两对象相等
	 */
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return currentfile.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(obj instanceof ExecuteResultBean) {
			ExecuteResultBean bean = (ExecuteResultBean)obj;
			String apptype = bean.getApptype();
			String currentfile = bean.getCurrentfile();
			if(StringUtils.isNotBlank(apptype) && StringUtils.isNotBlank(currentfile)) {
				if(apptype.equals(this.apptype) && currentfile.equals(this.currentfile)) {
					return true;
				}
			}
		}
		return false;
	}
}
