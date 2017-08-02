package com.huateng.ebank.entity.data.workflow.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the WORKFLOW_PARAM table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="WORKFLOW_PARAM"
 */

public abstract class BaseWorkflowParam  implements Serializable {

	public static String REF = "WorkflowParam";
	public static String PROP_LAST_UPD_FUNC = "lastUpdFunc";
	public static String PROP_BIZ_SUBCLASS = "bizSubclass";
	public static String PROP_MISC = "misc";
	public static String PROP_BRCLASS = "brclass";
	public static String PROP_BIZ_CLASS = "bizClass";
	public static String PROP_TLRNO_LIST = "tlrnoList";
	public static String PROP_MISCFLGS = "miscflgs";
	public static String PROP_BRCODE_TYPE = "brcodeType";
	public static String PROP_CREATE_DATE = "createDate";
	public static String PROP_BRCODE_LIST = "brcodeList";
	public static String PROP_WORKFLOW_ROLE = "workflowRole";
	public static String PROP_PROCESS_TEMPLATE = "processTemplate";
	public static String PROP_TIMESTAMPS = "timestamps";
	public static String PROP_LAST_UPD_TLR = "lastUpdTlr";
	public static String PROP_AMT_TYPE = "amtType";
	public static String PROP_APPTYPE = "apptype";
	public static String PROP_TASK_NAME = "taskName";
	public static String PROP_CREATE_TLR = "createTlr";
	public static String PROP_ASSIGN_TYPE = "assignType";
	public static String PROP_LAST_UPD_DATE = "lastUpdDate";
	public static String PROP_ASSIGN_MODE = "assignMode";
	public static String PROP_ID = "id";
	public static String PROP_LIMITATION = "limitation";
	public static String PROP_WORK_TYPE = "workType";
	public static String PROP_PASS = "pass";


	// constructors
	public BaseWorkflowParam () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseWorkflowParam (long id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseWorkflowParam (
		long id,
		java.lang.String processTemplate,
		java.lang.String taskName,
		java.lang.String apptype,
		java.lang.String brclass,
		java.lang.String bizClass,
		java.lang.String bizSubclass) {

		this.setId(id);
		this.setProcessTemplate(processTemplate);
		this.setTaskName(taskName);
		this.setApptype(apptype);
		this.setBrclass(brclass);
		this.setBizClass(bizClass);
		this.setBizSubclass(bizSubclass);
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
	private java.lang.String workType;
	private java.lang.String brclass;
	private java.lang.String bizClass;
	private java.lang.String bizSubclass;
	private java.lang.String brcodeType;
	private java.lang.String brcodeList;
	private java.lang.String assignType;
	private java.lang.String amtType;
	private java.lang.String tlrnoList;
	private java.lang.String workflowRole;
	private java.lang.String assignMode;
	private java.lang.String pass;
	private java.lang.String miscflgs;
	private java.lang.String misc;
	private java.lang.String createTlr;
	private java.util.Date createDate;
	private java.util.Date lastUpdDate;
	private java.lang.String lastUpdFunc;
	private java.lang.String lastUpdTlr;
	private java.util.Date timestamps;
	private java.lang.Integer limitation;



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
	 * Return the value associated with the column: BRCLASS
	 */
	public java.lang.String getBrclass () {
		return brclass;
	}

	/**
	 * Set the value related to the column: BRCLASS
	 * @param brclass the BRCLASS value
	 */
	public void setBrclass (java.lang.String brclass) {
		this.brclass = brclass;
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
	 * Return the value associated with the column: BRCODE_TYPE
	 */
	public java.lang.String getBrcodeType () {
		return brcodeType;
	}

	/**
	 * Set the value related to the column: BRCODE_TYPE
	 * @param brcodeType the BRCODE_TYPE value
	 */
	public void setBrcodeType (java.lang.String brcodeType) {
		this.brcodeType = brcodeType;
	}



	/**
	 * Return the value associated with the column: BRCODE_LIST
	 */
	public java.lang.String getBrcodeList () {
		return brcodeList;
	}

	/**
	 * Set the value related to the column: BRCODE_LIST
	 * @param brcodeList the BRCODE_LIST value
	 */
	public void setBrcodeList (java.lang.String brcodeList) {
		this.brcodeList = brcodeList;
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
	 * Return the value associated with the column: AMT_TYPE
	 */
	public java.lang.String getAmtType () {
		return amtType;
	}

	/**
	 * Set the value related to the column: AMT_TYPE
	 * @param amtType the AMT_TYPE value
	 */
	public void setAmtType (java.lang.String amtType) {
		this.amtType = amtType;
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
	 * Return the value associated with the column: PASS
	 */
	public java.lang.String getPass () {
		return pass;
	}

	/**
	 * Set the value related to the column: PASS
	 * @param pass the PASS value
	 */
	public void setPass (java.lang.String pass) {
		this.pass = pass;
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
	 * Return the value associated with the column: CREATE_TLR
	 */
	public java.lang.String getCreateTlr () {
		return createTlr;
	}

	/**
	 * Set the value related to the column: CREATE_TLR
	 * @param createTlr the CREATE_TLR value
	 */
	public void setCreateTlr (java.lang.String createTlr) {
		this.createTlr = createTlr;
	}



	/**
	 * Return the value associated with the column: CREATE_DATE
	 */
	public java.util.Date getCreateDate () {
		return createDate;
	}

	/**
	 * Set the value related to the column: CREATE_DATE
	 * @param createDate the CREATE_DATE value
	 */
	public void setCreateDate (java.util.Date createDate) {
		this.createDate = createDate;
	}



	/**
	 * Return the value associated with the column: LAST_UPD_DATE
	 */
	public java.util.Date getLastUpdDate () {
		return lastUpdDate;
	}

	/**
	 * Set the value related to the column: LAST_UPD_DATE
	 * @param lastUpdDate the LAST_UPD_DATE value
	 */
	public void setLastUpdDate (java.util.Date lastUpdDate) {
		this.lastUpdDate = lastUpdDate;
	}



	/**
	 * Return the value associated with the column: LAST_UPD_FUNC
	 */
	public java.lang.String getLastUpdFunc () {
		return lastUpdFunc;
	}

	/**
	 * Set the value related to the column: LAST_UPD_FUNC
	 * @param lastUpdFunc the LAST_UPD_FUNC value
	 */
	public void setLastUpdFunc (java.lang.String lastUpdFunc) {
		this.lastUpdFunc = lastUpdFunc;
	}



	/**
	 * Return the value associated with the column: LAST_UPD_TLR
	 */
	public java.lang.String getLastUpdTlr () {
		return lastUpdTlr;
	}

	/**
	 * Set the value related to the column: LAST_UPD_TLR
	 * @param lastUpdTlr the LAST_UPD_TLR value
	 */
	public void setLastUpdTlr (java.lang.String lastUpdTlr) {
		this.lastUpdTlr = lastUpdTlr;
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



	/**
	 * Return the value associated with the column: LIMITATION
	 */
	public java.lang.Integer getLimitation () {
		return limitation;
	}

	/**
	 * Set the value related to the column: LIMITATION
	 * @param limitation the LIMITATION value
	 */
	public void setLimitation (java.lang.Integer limitation) {
		this.limitation = limitation;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.huateng.ebank.entity.data.workflow.WorkflowParam)) return false;
		else {
			com.huateng.ebank.entity.data.workflow.WorkflowParam workflowParam = (com.huateng.ebank.entity.data.workflow.WorkflowParam) obj;
			return (this.getId() == workflowParam.getId());
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