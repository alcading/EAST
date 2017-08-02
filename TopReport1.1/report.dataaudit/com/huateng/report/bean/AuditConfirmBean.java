package com.huateng.report.bean;

import java.io.Serializable;

public class AuditConfirmBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private String busiType;
	private String apptype;
	private String currentfile;
	private int noApprove;
	private int approvePass;
	private int approveUnPass;
	private String workDate;

	public String getBusiType() {
		return busiType;
	}

	public void setBusiType(String busiType) {
		this.busiType = busiType;
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

	public int getNoApprove() {
		return noApprove;
	}

	public void setNoApprove(int noApprove) {
		this.noApprove = noApprove;
	}

	public int getApprovePass() {
		return approvePass;
	}

	public void setApprovePass(int approvePass) {
		this.approvePass = approvePass;
	}

	public int getApproveUnPass() {
		return approveUnPass;
	}

	public void setApproveUnPass(int approveUnPass) {
		this.approveUnPass = approveUnPass;
	}

	public String getWorkDate() {
		return workDate;
	}

	public void setWorkDate(String workDate) {
		this.workDate = workDate;
	}

	public AuditConfirmBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AuditConfirmBean(String busiType, String apptype, String currentfile, int noApprove, int approvePass,
			int approveUnPass, String workDate) {
		super();
		this.busiType = busiType;
		this.apptype = apptype;
		this.currentfile = currentfile;
		this.noApprove = noApprove;
		this.approvePass = approvePass;
		this.approveUnPass = approveUnPass;
		this.workDate = workDate;
	}

}
