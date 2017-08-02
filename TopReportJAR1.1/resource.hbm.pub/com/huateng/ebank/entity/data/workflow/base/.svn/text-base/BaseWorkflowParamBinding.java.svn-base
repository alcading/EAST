package com.huateng.ebank.entity.data.workflow.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the WORKFLOW_PARAM_BINDING table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="WORKFLOW_PARAM_BINDING"
 */

public abstract class BaseWorkflowParamBinding  implements Serializable {

	public static String REF = "WorkflowParamBinding";
	public static String PROP_START_BRHID = "startBrhid";
	public static String PROP_BRH_CLASS = "brhClass";
	public static String PROP_MAX_AMT = "maxAmt";
	public static String PROP_BIZ_SUBCLASS = "bizSubclass";
	public static String PROP_TASK_NAME = "taskName";
	public static String PROP_BIZ_CLASS = "bizClass";
	public static String PROP_PROCESS_TEMPLATE = "processTemplate";
	public static String PROP_ID = "id";
	public static String PROP_ROLE_ID = "roleId";
	public static String PROP_APPTYPE = "apptype";


	// constructors
	public BaseWorkflowParamBinding () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseWorkflowParamBinding (long id) {
		this.setId(id);
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
	private java.lang.String bizClass;
	private java.lang.String bizSubclass;
	private java.math.BigDecimal maxAmt;
	private java.lang.String startBrhid;
	private java.lang.String brhClass;
	private java.lang.Integer roleId;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
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
	 * Return the value associated with the column: BIZ_CLASS
	 */
	public java.lang.String getBizClass () {
		return bizClass;
	}

	/**
	 * Set the value related to the column: BIZ_CLASS
	 * @param bizClass the BIZ_CLASS value
	 */
	public void setBizClass (java.lang.String bizClass) {
		this.bizClass = bizClass;
	}



	/**
	 * Return the value associated with the column: BIZ_SUBCLASS
	 */
	public java.lang.String getBizSubclass () {
		return bizSubclass;
	}

	/**
	 * Set the value related to the column: BIZ_SUBCLASS
	 * @param bizSubclass the BIZ_SUBCLASS value
	 */
	public void setBizSubclass (java.lang.String bizSubclass) {
		this.bizSubclass = bizSubclass;
	}



	/**
	 * Return the value associated with the column: MAX_AMT
	 */
	public java.math.BigDecimal getMaxAmt () {
		return maxAmt;
	}

	/**
	 * Set the value related to the column: MAX_AMT
	 * @param maxAmt the MAX_AMT value
	 */
	public void setMaxAmt (java.math.BigDecimal maxAmt) {
		this.maxAmt = maxAmt;
	}



	/**
	 * Return the value associated with the column: START_BRHID
	 */
	public java.lang.String getStartBrhid () {
		return startBrhid;
	}

	/**
	 * Set the value related to the column: START_BRHID
	 * @param startBrhid the START_BRHID value
	 */
	public void setStartBrhid (java.lang.String startBrhid) {
		this.startBrhid = startBrhid;
	}



	/**
	 * Return the value associated with the column: BRH_CLASS
	 */
	public java.lang.String getBrhClass () {
		return brhClass;
	}

	/**
	 * Set the value related to the column: BRH_CLASS
	 * @param brhClass the BRH_CLASS value
	 */
	public void setBrhClass (java.lang.String brhClass) {
		this.brhClass = brhClass;
	}



	/**
	 * Return the value associated with the column: ROLE_ID
	 */
	public java.lang.Integer getRoleId () {
		return roleId;
	}

	/**
	 * Set the value related to the column: ROLE_ID
	 * @param roleId the ROLE_ID value
	 */
	public void setRoleId (java.lang.Integer roleId) {
		this.roleId = roleId;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.huateng.ebank.entity.data.workflow.WorkflowParamBinding)) return false;
		else {
			com.huateng.ebank.entity.data.workflow.WorkflowParamBinding workflowParamBinding = (com.huateng.ebank.entity.data.workflow.WorkflowParamBinding) obj;
			return (this.getId() == workflowParamBinding.getId());
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