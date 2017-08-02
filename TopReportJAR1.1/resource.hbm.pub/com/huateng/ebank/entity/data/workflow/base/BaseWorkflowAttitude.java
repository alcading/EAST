package com.huateng.ebank.entity.data.workflow.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the WORKFLOW_ATTITUDE table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="WORKFLOW_ATTITUDE"
 */

public abstract class BaseWorkflowAttitude  implements Serializable {

	public static String REF = "WorkflowAttitude";
	public static String PROP_OVER_FLAG = "overFlag";
	public static String PROP_PROCESS_TEMPLATE = "processTemplate";
	public static String PROP_ID = "id";
	public static String PROP_APPTYPE = "apptype";
	public static String PROP_TASK_NAME = "taskName";
	public static String PROP_ATTITUDELIST = "attitudelist";


	// constructors
	public BaseWorkflowAttitude () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseWorkflowAttitude (long id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseWorkflowAttitude (
		long id,
		java.lang.String processTemplate,
		java.lang.String taskName,
		java.lang.String apptype,
		java.lang.String overFlag,
		java.lang.String attitudelist) {

		this.setId(id);
		this.setProcessTemplate(processTemplate);
		this.setTaskName(taskName);
		this.setApptype(apptype);
		this.setOverFlag(overFlag);
		this.setAttitudelist(attitudelist);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private long id;

	// fields
	private java.lang.String processTemplate;
	private java.lang.String taskName;
	private java.lang.String apptype;
	private java.lang.String overFlag;
	private java.lang.String attitudelist;



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
	 * Return the value associated with the column: OVER_FLAG
	 */
	public java.lang.String getOverFlag () {
		return overFlag;
	}

	/**
	 * Set the value related to the column: OVER_FLAG
	 * @param overFlag the OVER_FLAG value
	 */
	public void setOverFlag (java.lang.String overFlag) {
		this.overFlag = overFlag;
	}



	/**
	 * Return the value associated with the column: ATTITUDELIST
	 */
	public java.lang.String getAttitudelist () {
		return attitudelist;
	}

	/**
	 * Set the value related to the column: ATTITUDELIST
	 * @param attitudelist the ATTITUDELIST value
	 */
	public void setAttitudelist (java.lang.String attitudelist) {
		this.attitudelist = attitudelist;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.huateng.ebank.entity.data.workflow.WorkflowAttitude)) return false;
		else {
			com.huateng.ebank.entity.data.workflow.WorkflowAttitude workflowAttitude = (com.huateng.ebank.entity.data.workflow.WorkflowAttitude) obj;
			return (this.getId() == workflowAttitude.getId());
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