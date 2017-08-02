/**
 *
 */
package com.huateng.ebank.business.workflow.bean;

/**
 * Title: WorkFlowForwardTaskBean
 * Description: 工作流工作移交Bean
 * Copyright: Copyright (c) 2008
 * Company: Shanghai Huateng Software Systems Co., Ltd.
 * @author shen_antonio
 * @version 1.1, 2008-3-31
 */
public class WorkFlowForwardTaskBean {

	/** memeber variable: String　oTlrno. */
	private String oTlrno;
	/** memeber variable: String　procInsId. */
	private String procInsId;
	/** memeber variable: String　taskId. */
	private String taskId;
	/** memeber variable: String　tlrno. */
	private String tlrno;
	/** memeber variable: String　brcode. */
	private String brcode;
	/** memeber variable: String　brcode. */
	private String taskName;
	public String getProcInsId() {
		return procInsId;
	}
	public void setProcInsId(String procInsId) {
		this.procInsId = procInsId;
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
	public String getBrcode() {
		return brcode;
	}
	public void setBrcode(String brcode) {
		this.brcode = brcode;
	}
	public String getOTlrno() {
		return oTlrno;
	}
	public void setOTlrno(String tlrno) {
		oTlrno = tlrno;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	/**
	 * 工作流工作移交Bean构造方法,用于移交指定任务
	 * @param procInsId 工作流实例号
	 * @param taskId 工作流实例任务号
	 * @param tlrno 接受任务操作员号
	 * @param brcode 机构号
	 * 2008-3-31
	 */
	public WorkFlowForwardTaskBean(String procInsId, String taskId,String tlrno, String brcode) {
		super();
		this.procInsId = procInsId;
		this.taskId = taskId;
		this.tlrno = tlrno;
		this.brcode = brcode;
	}

	/**
	 * 工作流工作移交Bean构造方法,用于移交操作员所有任务
	 * @param oTlrno 原操作员号
	 * @param tlrno 接受任务操作员号
	 * @param brcode 机构号
	 * 2008-3-31
	 */
	public WorkFlowForwardTaskBean(String oTlrno, String tlrno, String brcode){
		super();
		this.oTlrno = oTlrno;
		this.tlrno = tlrno;
		this.brcode = brcode;
	}



}
