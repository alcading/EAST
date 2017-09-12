package com.huateng.report.send.bean;

import java.util.ArrayList;
import java.util.List;

public class ReportFeedBackInfo {
	public static final String ID = "BUF_TT_FEEDBACK_DTLS";
	private String appType;
	private String currentFile;
	private String inOut;
	private Integer formatErrs;
	private List<String> formats = new ArrayList<String>();
	private Integer totalRecords;
	private Integer sucRecords;
	private Integer falRecords;
	private List<ReportFeedBackErrRec> errRecords = new ArrayList<ReportFeedBackErrRec>();

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

	public Integer getFormatErrs() {
		return formatErrs;
	}

	public void setFormatErrs(Integer formatErrs) {
		this.formatErrs = formatErrs;
	}

	public List<String> getFormats() {
		return formats;
	}

	public void setFormats(List<String> formats) {
		this.formats = formats;
	}

	public Integer getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(Integer totalRecords) {
		this.totalRecords = totalRecords;
	}

	public Integer getSucRecords() {
		return sucRecords;
	}

	public void setSucRecords(Integer sucRecords) {
		this.sucRecords = sucRecords;
	}

	public Integer getFalRecords() {
		return falRecords;
	}

	public void setFalRecords(Integer falRecords) {
		this.falRecords = falRecords;
	}

	public List<ReportFeedBackErrRec> getErrRecords() {
		return errRecords;
	}

	public void setErrRecords(List<ReportFeedBackErrRec> errRecords) {
		this.errRecords = errRecords;
	}

}
