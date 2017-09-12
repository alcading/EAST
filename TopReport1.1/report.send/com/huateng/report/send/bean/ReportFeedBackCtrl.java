package com.huateng.report.send.bean;

import java.util.ArrayList;
import java.util.List;

public class ReportFeedBackCtrl {
	public static final String ID = "BUF_TT_FEEDBACK";
	private String appType;
	private String currentFile;
	private String inOut;
	private Integer totalFiles;
	private List<String> files = new ArrayList<String>();

	public String getAppType() {
		return appType;
	}

	public void setAppType(String appType) {
		this.appType = appType;
	}

	public String getCurrentFile() {
		if (this.currentFile!=null) {
			return currentFile.replaceAll(this.appType, "");
		}
		return currentFile;
	}

	public void setCurrentFile(String currentFile) {
		this.currentFile = currentFile;
	}

	public String getInOut() {
		return inOut;
	}

	public void setInOut(String inOut) {
		this.inOut = inOut;
	}

	public Integer getTotalFiles() {
		return totalFiles;
	}

	public void setTotalFiles(Integer totalFiles) {
		this.totalFiles = totalFiles;
	}

	public List<String> getFiles() {
		return files;
	}

	public void setFiles(List<String> files) {
		this.files = files;
	}

}
