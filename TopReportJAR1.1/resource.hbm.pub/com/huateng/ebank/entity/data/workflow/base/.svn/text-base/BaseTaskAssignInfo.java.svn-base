package com.huateng.ebank.entity.data.workflow.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the TASK_ASSIGN_INFO table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="TASK_ASSIGN_INFO"
 */

public abstract class BaseTaskAssignInfo  implements Serializable {

	public static String REF = "TaskAssignInfo";
	public static String PROP_TLRNO = "tlrno";
	public static String PROP_ASSIGN = "assign";
	public static String PROP_TASK_DESC = "taskDesc";
	public static String PROP_TASK_ID = "taskId";
	public static String PROP_PROC_INS_ID = "procInsId";
	public static String PROP_STATUS = "status";
	public static String PROP_BRCODE = "brcode";
	public static String PROP_ASSIGN_TYPE = "assignType";
	public static String PROP_ASSIGN_MODE = "assignMode";
	public static String PROP_ID = "id";
	public static String PROP_END_TIME = "endTime";
	public static String PROP_TIMESTAMPS = "timestamps";
	public static String PROP_START_TIME = "startTime";
	public static String PROP_WORK_TYPE = "workType";


	// constructors
	public BaseTaskAssignInfo () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseTaskAssignInfo (long id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseTaskAssignInfo (
		long id,
		java.lang.String procInsId,
		java.lang.String taskId,
		java.lang.String tlrno) {

		this.setId(id);
		this.setProcInsId(procInsId);
		this.setTaskId(taskId);
		this.setTlrno(tlrno);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private long id;

	// fields
	private java.lang.String procInsId;
	private java.lang.String taskId;
	private java.lang.String tlrno;
	private java.lang.String brcode;
	private java.lang.String workType;
	private java.lang.String taskDesc;
	private java.lang.String assignType;
	private java.lang.String assignMode;
	private java.lang.String assign;
	private java.lang.String status;
	private java.util.Date startTime;
	private java.util.Date endTime;
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
	 * Return the value associated with the column: TASK_ID
	 */
	public java.lang.String getTaskId () {
		return taskId;
	}

	/**
	 * Set the value related to the column: TASK_ID
	 * @param taskId the TASK_ID value
	 */
	public void setTaskId (java.lang.String taskId) {
		this.taskId = taskId;
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
	 * Return the value associated with the column: BRCODE
	 */
	public java.lang.String getBrcode () {
		return brcode;
	}

	/**
	 * Set the value related to the column: BRCODE
	 * @param brcode the BRCODE value
	 */
	public void setBrcode (java.lang.String brcode) {
		this.brcode = brcode;
	}



	/**
	 * Return the value associated with the column: WORK_TYPE
	 */
	public java.lang.String getWorkType () {
		return workType;
	}

	/**
	 * Set the value related to the column: WORK_TYPE
	 * @param workType the WORK_TYPE value
	 */
	public void setWorkType (java.lang.String workType) {
		this.workType = workType;
	}



	/**
	 * Return the value associated with the column: TASK_DESC
	 */
	public java.lang.String getTaskDesc () {
		return taskDesc;
	}

	/**
	 * Set the value related to the column: TASK_DESC
	 * @param taskDesc the TASK_DESC value
	 */
	public void setTaskDesc (java.lang.String taskDesc) {
		this.taskDesc = taskDesc;
	}



	/**
	 * Return the value associated with the column: ASSIGN_TYPE
	 */
	public java.lang.String getAssignType () {
		return assignType;
	}

	/**
	 * Set the value related to the column: ASSIGN_TYPE
	 * @param assignType the ASSIGN_TYPE value
	 */
	public void setAssignType (java.lang.String assignType) {
		this.assignType = assignType;
	}



	/**
	 * Return the value associated with the column: ASSIGN_MODE
	 */
	public java.lang.String getAssignMode () {
		return assignMode;
	}

	/**
	 * Set the value related to the column: ASSIGN_MODE
	 * @param assignMode the ASSIGN_MODE value
	 */
	public void setAssignMode (java.lang.String assignMode) {
		this.assignMode = assignMode;
	}



	/**
	 * Return the value associated with the column: ASSIGN
	 */
	public java.lang.String getAssign () {
		return assign;
	}

	/**
	 * Set the value related to the column: ASSIGN
	 * @param assign the ASSIGN value
	 */
	public void setAssign (java.lang.String assign) {
		this.assign = assign;
	}



	/**
	 * Return the value associated with the column: STATUS
	 */
	public java.lang.String getStatus () {
		return status;
	}

	/**
	 * Set the value related to the column: STATUS
	 * @param status the STATUS value
	 */
	public void setStatus (java.lang.String status) {
		this.status = status;
	}



	/**
	 * Return the value associated with the column: START_TIME
	 */
	public java.util.Date getStartTime () {
		return startTime;
	}

	/**
	 * Set the value related to the column: START_TIME
	 * @param startTime the START_TIME value
	 */
	public void setStartTime (java.util.Date startTime) {
		this.startTime = startTime;
	}



	/**
	 * Return the value associated with the column: END_TIME
	 */
	public java.util.Date getEndTime () {
		return endTime;
	}

	/**
	 * Set the value related to the column: END_TIME
	 * @param endTime the END_TIME value
	 */
	public void setEndTime (java.util.Date endTime) {
		this.endTime = endTime;
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
		if (!(obj instanceof com.huateng.ebank.entity.data.workflow.TaskAssignInfo)) return false;
		else {
			com.huateng.ebank.entity.data.workflow.TaskAssignInfo taskAssignInfo = (com.huateng.ebank.entity.data.workflow.TaskAssignInfo) obj;
			return (this.getId() == taskAssignInfo.getId());
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