package com.huateng.ebank.entity.data.workflow;

import com.huateng.ebank.entity.data.workflow.base.BaseWorkflowParam;

public class WorkflowParam extends BaseWorkflowParam {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public WorkflowParam () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public WorkflowParam (long id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public WorkflowParam (
		long id,
		java.lang.String processTemplate,
		java.lang.String taskName,
		java.lang.String apptype,
		java.lang.String brclass,
		java.lang.String bizClass,
		java.lang.String bizSubclass) {

		super (
			id,
			processTemplate,
			taskName,
			apptype,
			brclass,
			bizClass,
			bizSubclass);
	}

/*[CONSTRUCTOR MARKER END]*/
	/*工作流模板名 */
	private String processTemplateName;
	/* 任务名*/
	private String taskNameLable;
	/* 贷款品种类型 */
	private String bizSubclassName;
	/*申请类型*/
	private String appTypeName;
	/* 审批类型*/
	private String bizClassName;

	private String taskNameName;

	private String brclassName;
	
	private String workflowRoleName;

	public String getProcessTemplateName() {
		return processTemplateName;
	}

	public void setProcessTemplateName(String processTemplateName) {
		this.processTemplateName = processTemplateName;
	}

	public String getTaskNameLable() {
		return taskNameLable;
	}

	public void setTaskNameLable(String taskNameLable) {
		this.taskNameLable = taskNameLable;
	}

	public String getBizSubclassName() {
		return bizSubclassName;
	}

	public void setBizSubclassName(String bizSubclassName) {
		this.bizSubclassName = bizSubclassName;
	}

	public String getAppTypeName() {
		return appTypeName;
	}

	public void setAppTypeName(String appTypeName) {
		this.appTypeName = appTypeName;
	}

	public String getBizClassName() {
		return bizClassName;
	}

	public void setBizClassName(String bizClassName) {
		this.bizClassName = bizClassName;
	}

	public String getTaskNameName() {
		return taskNameName;
	}

	public void setTaskNameName(String taskNameName) {
		this.taskNameName = taskNameName;
	}

	public String getBrclassName() {
		return brclassName;
	}

	public void setBrclassName(String brclassName) {
		this.brclassName = brclassName;
	}

	public String getWorkflowRoleName() {
		return workflowRoleName;
	}

	public void setWorkflowRoleName(String workflowRoleName) {
		this.workflowRoleName = workflowRoleName;
	}
	
	

}