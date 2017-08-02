package com.huateng.ebank.business.workflow.bean;

public class TaskBean {

	/** 当前节点处理机构号.*/
	private String brcode;
	/** 当前节点机构类型(用于请求下一个任务分配时，回送给个贷系统.*/
	private String brclass;
	/** 申请号.*/
	private String appno;
	/** 申请类型.*/
	private String appType;
	/** 申请合同号.*/
	private String contractno;
	/** 申请金额.*/
	private String txnamt;
	/** 操作动作列表(以逗号分割).*/
	private String statusList;

	/** 审批留言 .*/
	private String comment;
	/** 审批意见.*/
	private String status;

	/** 流程实例唯一标识.*/
	private String piid;
	 /** 流程模板名.*/
	private String procName;
    /** 流程任务唯一标识.*/
	private String taskId;
	/** 流程任务名称.*/
	private String taskName;
	/** 流程任务执行者.*/
	private String userName;
	/** 任务启动时间.*/
	private String taskStartTime;
	/** 任务结束时间.*/
	private String taskEndTime;
	/** 审批时效截止时间.*/
	private String limitEndTime;
	/** 审批时效剩余时间.*/
	private String limitLeftTime;
	/** 任务状态.*/
	private String taskState;
	/** 客户号.*/
	private String custno;
	/*
	 * author:yangyong
	 * start data:20100722
	 * 工作流拥有者
	 */
	private String owner;

	private String systype;
	/*
	 * author:yangyong
	 * end data:20100722
	 * 工作流拥有者
	 */

	public String getSystype() {
		return systype;
	}


	public void setSystype(String systype) {
		this.systype = systype;
	}


	public TaskBean() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getBrcode() {
		return brcode;
	}


	public void setBrcode(String brcode) {
		this.brcode = brcode;
	}


	public String getBrclass() {
		return brclass;
	}


	public void setBrclass(String brclass) {
		this.brclass = brclass;
	}


	public String getAppno() {
		return appno;
	}


	public void setAppno(String appno) {
		this.appno = appno;
	}


	public String getAppType() {
		return appType;
	}


	public void setAppType(String appType) {
		this.appType = appType;
	}


	public String getContractno() {
		return contractno;
	}


	public void setContractno(String contractno) {
		this.contractno = contractno;
	}


	public String getTxnamt() {
		return txnamt;
	}


	public void setTxnamt(String txnamt) {
		this.txnamt = txnamt;
	}


	public String getStatusList() {
		return statusList;
	}


	public void setStatusList(String statusList) {
		this.statusList = statusList;
	}


	public String getTaskId() {
		return taskId;
	}


	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}


	public String getTaskName() {
		return taskName;
	}


	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getTaskStartTime() {
		return taskStartTime;
	}


	public void setTaskStartTime(String taskStartTime) {
		this.taskStartTime = taskStartTime;
	}


	public String getTaskEndTime() {
		return taskEndTime;
	}


	public void setTaskEndTime(String taskEndTime) {
		this.taskEndTime = taskEndTime;
	}


	public String getTaskState() {
		return taskState;
	}


	public void setTaskState(String taskState) {
		this.taskState = taskState;
	}


	public String getPiid() {
		return piid;
	}


	public void setPiid(String piid) {
		this.piid = piid;
	}


	public String getProcName() {
		return procName;
	}


	public void setProcName(String procName) {
		this.procName = procName;
	}


	public String getComment() {
		return comment;
	}


	public void setComment(String comment) {
		this.comment = comment;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getCustno() {
		return custno;
	}


	public void setCustno(String custno) {
		this.custno = custno;
	}


	public String getOwner() {
		return owner;
	}


	public void setOwner(String owner) {
		this.owner = owner;
	}


	public String getLimitEndTime() {
		return limitEndTime;
	}


	public void setLimitEndTime(String limitEndTime) {
		this.limitEndTime = limitEndTime;
	}


	public String getLimitLeftTime() {
		return limitLeftTime;
	}


	public void setLimitLeftTime(String limitLeftTime) {
		this.limitLeftTime = limitLeftTime;
	}




}
