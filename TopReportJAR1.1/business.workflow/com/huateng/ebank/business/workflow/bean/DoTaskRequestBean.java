package com.huateng.ebank.business.workflow.bean;

public class DoTaskRequestBean {

	private String tlrno;
	private String status;
	private String comment;
	private String brcode;
	private String taskId;

	public DoTaskRequestBean(String tlrno, String status, String comment,
			String brcode, String taskId) {
		super();
		this.tlrno = tlrno;
		this.status = status;
		this.comment = comment;
		this.brcode = brcode;
		this.taskId = taskId;
	}
	public String getTaskId() {
		return taskId;
	}
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	public String getTlrno() {
		return tlrno;
	}
	public void setTlrno(String tlrno) {
		this.tlrno = tlrno;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getBrcode() {
		return brcode;
	}
	public void setBrcode(String brcode) {
		this.brcode = brcode;
	}
}
