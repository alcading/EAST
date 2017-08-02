/**
 *
 */
package com.huateng.ebank.business.taskassign.bean;

/**
 * Title: TaskFinishBean
 * Description: 完成任务结点Bean
 * Copyright: Copyright (c) 2008
 * Company: Shanghai Huateng Software Systems Co., Ltd.
 * @author shen_antonio
 * @version 1.1, 2008-3-29
 */
public class TaskFinishBean {

	/** memeber variable: String　processId 进程号. */
	private String processId;
	/** memeber variable: String　taskId 任务号. */
	private String taskId;
	/** memeber variable: String　tlrno 操作员号. */
	private String tlrno;
	/** memeber variable: int　assignMode 任务分配模式. */
	private String assignMode;
	/** memeber variable: String　workType 工作类型. */
	private String workType;
	/** memeber variable: String　brcode 操作员机构号. */
	private String brcode; 
	
	/**
	 * 完成任务Bean构造方法
	 * @param processId 进程号
	 * @param taskId 任务号
	 * @param assignMode 任务分配模式:工作流任务分配模式(0-分配到岗位，1-分配到人(按工作两分配),2-完全随机分配)
	 * @param workType 工作类型:工作类型（允许为空，默认为全部工作99）01-贷前 02-贷后
	 * @param brcode 操作员机构号
	 * @param tlrno 操作员号
	 * 2008-3-29
	 */
	public TaskFinishBean(String processId, String taskId, String assignMode,
			String tlrno,String workType,String brcode) {
		super();
		this.processId = processId;
		this.taskId = taskId;
		this.tlrno = tlrno;
		this.assignMode = assignMode;
		this.workType = workType;
		this.brcode = brcode;
	}

	public String getProcessId() {
		return processId;
	}
	public void setProcessId(String processId) {
		this.processId = processId;
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

	public String getAssignMode() {
		return assignMode;
	}

	public void setAssignMode(String assignMode) {
		this.assignMode = assignMode;
	}

	public String getWorkType() {
		return workType;
	}

	public void setWorkType(String workType) {
		this.workType = workType;
	}

	public String getBrcode() {
		return brcode;
	}

	public void setBrcode(String brcode) {
		this.brcode = brcode;
	}

}
