package com.huateng.report.genupreportfile.bean;

import java.util.ArrayList;
import java.util.List;

public class ReportShowCreateFileBean {
	private String appType;
	private String appTypeName;
	private String packName;
	private List<String> fileNameList = new ArrayList<String>();
	private boolean isSendSuccess;

	public boolean isSendSuccess() {
		return isSendSuccess;
	}

	public void setSendSuccess(boolean isSendSuccess) {
		this.isSendSuccess = isSendSuccess;
	}

	public String getAppType() {
		return appType;
	}

	public void setAppType(String appType) {
		this.appType = appType;
	}

	public String getAppTypeName() {
		return appTypeName;
	}

	public void setAppTypeName(String appTypeName) {
		this.appTypeName = appTypeName;
	}

	public String getPackName() {
		return packName;
	}

	public void setPackName(String packName) {
		this.packName = packName;
	}

	public List<String> getFileNameList() {
		return fileNameList;
	}

	public void setFileNameList(List<String> fileNameList) {
		this.fileNameList = fileNameList;
	}

	public ReportShowCreateFileBean(String appType, String appTypeName, String packName, List<String> fileNameList) {
		super();
		this.appType = appType;
		this.appTypeName = appTypeName;
		this.packName = packName;
		this.fileNameList = fileNameList;
	}

	public ReportShowCreateFileBean() {
		super();
		// TODO Auto-generated constructor stub
	}

}
