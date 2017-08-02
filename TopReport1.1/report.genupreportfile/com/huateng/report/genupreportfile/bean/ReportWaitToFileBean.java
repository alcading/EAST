package com.huateng.report.genupreportfile.bean;

public class ReportWaitToFileBean {
	private String fileDate;

	private String appType;

	private String fileType;

	private int recCount;

	private int fileCount;

	public String getFileDate() {
		return fileDate;
	}

	public void setFileDate(String fileDate) {
		this.fileDate = fileDate;
	}

	public String getAppType() {
		return appType;
	}

	public void setAppType(String appType) {
		this.appType = appType;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public int getRecCount() {
		return recCount;
	}

	public void setRecCount(int recCount) {
		this.recCount = recCount;
	}

	public int getFileCount() {
		return fileCount;
	}

	public void setFileCount(int fileCount) {
		this.fileCount = fileCount;
	}

	public ReportWaitToFileBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReportWaitToFileBean(String appType, String fileType, int recCount, int fileCount) {
		super();
		this.appType = appType;
		this.fileType = fileType;
		this.recCount = recCount;
		this.fileCount = fileCount;
	}

}
