package com.huateng.ebank.entity.data.workflow.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the WORKFLOW_TASK_INFO table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="WORKFLOW_TASK_INFO"
 */

public abstract class BaseWorkflowTaskInfo  implements Serializable {

	public static String REF = "WorkflowTaskInfo";
	public static String PROP_TLRNO = "tlrno";
	public static String PROP_PROC_END_TIME = "procEndTime";
	public static String PROP_TASK_START_TIME = "taskStartTime";
	public static String PROP_TASK_END_FLAG = "taskEndFlag";
	public static String PROP_MISC = "misc";
	public static String PROP_APPTYPE = "apptype";
	public static String PROP_MISCFLGS = "miscflgs";
	public static String PROP_TLRNO_LIST = "tlrnoList";
	public static String PROP_TASK_NAME = "taskName";
	public static String PROP_CONTRACTNO = "contractno";
	public static String PROP_PROC_END_FLAG = "procEndFlag";
	public static String PROP_PROC_INS_ID = "procInsId";
	public static String PROP_CUSTCD = "custcd";
	public static String PROP_PROC_START_TIME = "procStartTime";
	public static String PROP_WORKFLOW_ROLE = "workflowRole";
	public static String PROP_PROCESS_TEMPLATE = "processTemplate";
	public static String PROP_ID = "id";
	public static String PROP_TIMESTAMPS = "timestamps";
	public static String PROP_APPNO = "appno";
	public static String PROP_TASK_END_TIME = "taskEndTime";


	// constructors
	public BaseWorkflowTaskInfo () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseWorkflowTaskInfo (long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private long id;

	// fields
	private java.lang.String apptype;
	private java.lang.String appno;
	private java.lang.String custcd;
	private java.lang.String contractno;
	private java.lang.String processTemplate;
	private java.lang.String procInsId;
	private java.lang.String taskName;
	private java.util.Date procStartTime;
	private java.util.Date procEndTime;
	private java.lang.String procEndFlag;
	private java.util.Date taskStartTime;
	private java.util.Date taskEndTime;
	private java.lang.String taskEndFlag;
	private java.lang.String tlrnoList;
	private java.lang.String tlrno;
	private java.lang.String workflowRole;
	private java.lang.String miscflgs;
	private java.lang.String misc;
	private java.util.Date timestamps;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="ID"
     */
	public long getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (long id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: APPTYPE
	 */
	public java.lang.String getApptype () {
		return apptype;
	}

	/**
	 * Set the value related to the column: APPTYPE
	 * @param apptype the APPTYPE value
	 */
	public void setApptype (java.lang.String apptype) {
		this.apptype = apptype;
	}



	/**
	 * Return the value associated with the column: APPNO
	 */
	public java.lang.String getAppno () {
		return appno;
	}

	/**
	 * Set the value related to the column: APPNO
	 * @param appno the APPNO value
	 */
	public void setAppno (java.lang.String appno) {
		this.appno = appno;
	}



	/**
	 * Return the value associated with the column: CUSTCD
	 */
	public java.lang.String getCustcd () {
		return custcd;
	}

	/**
	 * Set the value related to the column: CUSTCD
	 * @param custcd the CUSTCD value
	 */
	public void setCustcd (java.lang.String custcd) {
		this.custcd = custcd;
	}



	/**
	 * Return the value associated with the column: CONTRACTNO
	 */
	public java.lang.String getContractno () {
		return contractno;
	}

	/**
	 * Set the value related to the column: CONTRACTNO
	 * @param contractno the CONTRACTNO value
	 */
	public void setContractno (java.lang.String contractno) {
		this.contractno = contractno;
	}



	/**
	 * Return the value associated with the column: PROCESS_TEMPLATE
	 */
	public java.lang.String getProcessTemplate () {
		return processTemplate;
	}

	/**
	 * Set the value related to the column: PROCESS_TEMPLATE
	 * @param processTemplate the PROCESS_TEMPLATE value
	 */
	public void setProcessTemplate (java.lang.String processTemplate) {
		this.processTemplate = processTemplate;
	}



	/**
	 * Return the value associated with the column: PROC_INS_ID
	 */
	public java.lang.String getProcInsId () {
		return procInsId;
	}

	/**
	 * Set the value related to the column: PROC_INS_ID
	 * @param procInsId the PROC_INS_ID value
	 */
	public void setProcInsId (java.lang.String procInsId) {
		this.procInsId = procInsId;
	}



	/**
	 * Return the value associated with the column: TASK_NAME
	 */
	public java.lang.String getTaskName () {
		return taskName;
	}

	/**
	 * Set the value related to the column: TASK_NAME
	 * @param taskName the TASK_NAME value
	 */
	public void setTaskName (java.lang.String taskName) {
		this.taskName = taskName;
	}



	/**
	 * Return the value associated with the column: PROC_START_TIME
	 */
	public java.util.Date getProcStartTime () {
		return procStartTime;
	}

	/**
	 * Set the value related to the column: PROC_START_TIME
	 * @param procStartTime the PROC_START_TIME value
	 */
	public void setProcStartTime (java.util.Date procStartTime) {
		this.procStartTime = procStartTime;
	}



	/**
	 * Return the value associated with the column: PROC_END_TIME
	 */
	public java.util.Date getProcEndTime () {
		return procEndTime;
	}

	/**
	 * Set the value related to the column: PROC_END_TIME
	 * @param procEndTime the PROC_END_TIME value
	 */
	public void setProcEndTime (java.util.Date procEndTime) {
		this.procEndTime = procEndTime;
	}



	/**
	 * Return the value associated with the column: PROC_END_FLAG
	 */
	public java.lang.String getProcEndFlag () {
		return procEndFlag;
	}

	/**
	 * Set the value related to the column: PROC_END_FLAG
	 * @param procEndFlag the PROC_END_FLAG value
	 */
	public void setProcEndFlag (java.lang.String procEndFlag) {
		this.procEndFlag = procEndFlag;
	}



	/**
	 * Return the value associated with the column: TASK_START_TIME
	 */
	public java.util.Date getTaskStartTime () {
		return taskStartTime;
	}

	/**
	 * Set the value related to the column: TASK_START_TIME
	 * @param taskStartTime the TASK_START_TIME value
	 */
	public void setTaskStartTime (java.util.Date taskStartTime) {
		this.taskStartTime = taskStartTime;
	}



	/**
	 * Return the value associated with the column: TASK_END_TIME
	 */
	public java.util.Date getTaskEndTime () {
		return taskEndTime;
	}

	/**
	 * Set the value related to the column: TASK_END_TIME
	 * @param taskEndTime the TASK_END_TIME value
	 */
	public void setTaskEndTime (java.util.Date taskEndTime) {
		this.taskEndTime = taskEndTime;
	}



	/**
	 * Return the value associated with the column: TASK_END_FLAG
	 */
	public java.lang.String getTaskEndFlag () {
		return taskEndFlag;
	}

	/**
	 * Set the value related to the column: TASK_END_FLAG
	 * @param taskEndFlag the TASK_END_FLAG value
	 */
	public void setTaskEndFlag (java.lang.String taskEndFlag) {
		this.taskEndFlag = taskEndFlag;
	}



	/**
	 * Return the value associated with the column: TLRNO_LIST
	 */
	public java.lang.String getTlrnoList () {
		return tlrnoList;
	}

	/**
	 * Set the value related to the column: TLRNO_LIST
	 * @param tlrnoList the TLRNO_LIST value
	 */
	public void setTlrnoList (java.lang.String tlrnoList) {
		this.tlrnoList = tlrnoList;
	}



	/**
	 * Return the value associated with the column: TLRNO
	 */
	public java.lang.String getTlrno () {
		return tlrno;
	}

	/**
	 * Set the value related to the column: TLRNO
	 * @param tlrno the TLRNO value
	 */
	public void setTlrno (java.lang.String tlrno) {
		this.tlrno = tlrno;
	}



	/**
	 * Return the value associated with the column: WORKFLOW_ROLE
	 */
	public java.lang.String getWorkflowRole () {
		return workflowRole;
	}

	/**
	 * Set the value related to the column: WORKFLOW_ROLE
	 * @param workflowRole the WORKFLOW_ROLE value
	 */
	public void setWorkflowRole (java.lang.String workflowRole) {
		this.workflowRole = workflowRole;
	}



	/**
	 * Return the value associated with the column: MISCFLGS
	 */
	public java.lang.String getMiscflgs () {
		return miscflgs;
	}

	/**
	 * Set the value related to the column: MISCFLGS
	 * @param miscflgs the MISCFLGS value
	 */
	public void setMiscflgs (java.lang.String miscflgs) {
		this.miscflgs = miscflgs;
	}



	/**
	 * Return the value associated with the column: MISC
	 */
	public java.lang.String getMisc () {
		return misc;
	}

	/**
	 * Set the value related to the column: MISC
	 * @param misc the MISC value
	 */
	public void setMisc (java.lang.String misc) {
		this.misc = misc;
	}



	/**
	 * Return the value associated with the column: TIMESTAMPS
	 */
	public java.util.Date getTimestamps () {
		return timestamps;
	}

	/**
	 * Set the value related to the column: TIMESTAMPS
	 * @param timestamps the TIMESTAMPS value
	 */
	public void setTimestamps (java.util.Date timestamps) {
		this.timestamps = timestamps;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.huateng.ebank.entity.data.workflow.WorkflowTaskInfo)) return false;
		else {
			com.huateng.ebank.entity.data.workflow.WorkflowTaskInfo workflowTaskInfo = (com.huateng.ebank.entity.data.workflow.WorkflowTaskInfo) obj;
			return (this.getId() == workflowTaskInfo.getId());
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			return (int) this.getId();
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}