package com.huateng.report.common.bean;

import java.io.Serializable;

public class ReportApproveResultBean implements Serializable {

	private static final long serialVersionUID = 5020601688330791522L;
	
	private String approveStatus;
	
	private String approveResult;

	public String getApproveStatus() {
		return approveStatus;
	}

	public void setApproveStatus(String approveStatus) {
		this.approveStatus = approveStatus;
	}

	public String getApproveResult() {
		return approveResult;
	}

	public void setApproveResult(String approveResult) {
		this.approveResult = approveResult;
	}

	public ReportApproveResultBean(String approveStatus, String approveResult) {
		super();
		this.approveStatus = approveStatus;
		this.approveResult = approveResult;
	}

	public ReportApproveResultBean() {
		super();
	}

}
