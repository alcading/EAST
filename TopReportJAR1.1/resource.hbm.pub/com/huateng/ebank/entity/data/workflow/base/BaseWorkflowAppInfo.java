package com.huateng.ebank.entity.data.workflow.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the WORKFLOW_APP_INFO table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="WORKFLOW_APP_INFO"
 */

public abstract class BaseWorkflowAppInfo  implements Serializable {

	public static String REF = "WorkflowAppInfo";
	public static String PROP_TLRNO = "tlrno";
	public static String PROP_MISC = "misc";
	public static String PROP_CUSTNO = "custno";
	public static String PROP_APPTYPE = "apptype";
	public static String PROP_PIID = "piid";
	public static String PROP_CUST_NAME = "custName";
	public static String PROP_STATUS = "status";
	public static String PROP_BRCODE = "brcode";
	public static String PROP_TIMESTAMPS = "timestamps";
	public static String PROP_APPNO = "appno";
	public static String PROP_PROC_NAME = "procName";
	public static String PROP_START_TIME = "startTime";
	public static String PROP_CURR_ROLE = "currRole";


	// constructors
	public BaseWorkflowAppInfo () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseWorkflowAppInfo (java.lang.String appno) {
		this.setAppno(appno);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseWorkflowAppInfo (
		java.lang.String appno,
		java.lang.String apptype,
		java.lang.String piid,
		java.lang.String procName,
		java.util.Date startTime,
		java.lang.String status) {

		this.setAppno(appno);
		this.setApptype(apptype);
		this.setPiid(piid);
		this.setProcName(procName);
		this.setStartTime(startTime);
		this.setStatus(status);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String appno;

	// fields
	private java.lang.String apptype;
	private java.lang.String piid;
	private java.lang.String procName;
	private java.util.Date startTime;
	private java.lang.String custno;
	private java.lang.String custName;
	private java.lang.String brcode;
	private java.lang.String tlrno;
	private java.lang.String status;
	private java.lang.String currRole;
	private java.lang.String misc;
	private java.util.Date timestamps;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="assigned"
     *  column="APPNO"
     */
	public java.lang.String getAppno () {
		return appno;
	}

	/**
	 * Set the unique identifier of this class
	 * @param appno the new ID
	 */
	public void setAppno (java.lang.String appno) {
		this.appno = appno;
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
	 * Return the value associated with the column: PIID
	 */
	public java.lang.String getPiid () {
		return piid;
	}

	/**
	 * Set the value related to the column: PIID
	 * @param piid the PIID value
	 */
	public void setPiid (java.lang.String piid) {
		this.piid = piid;
	}



	/**
	 * Return the value associated with the column: PROC_NAME
	 */
	public java.lang.String getProcName () {
		return procName;
	}

	/**
	 * Set the value related to the column: PROC_NAME
	 * @param procName the PROC_NAME value
	 */
	public void setProcName (java.lang.String procName) {
		this.procName = procName;
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
	 * Return the value associated with the column: CUSTNO
	 */
	public java.lang.String getCustno () {
		return custno;
	}

	/**
	 * Set the value related to the column: CUSTNO
	 * @param custno the CUSTNO value
	 */
	public void setCustno (java.lang.String custno) {
		this.custno = custno;
	}



	/**
	 * Return the value associated with the column: CUST_NAME
	 */
	public java.lang.String getCustName () {
		return custName;
	}

	/**
	 * Set the value related to the column: CUST_NAME
	 * @param custName the CUST_NAME value
	 */
	public void setCustName (java.lang.String custName) {
		this.custName = custName;
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
	 * Return the value associated with the column: CURR_ROLE
	 */
	public java.lang.String getCurrRole () {
		return currRole;
	}

	/**
	 * Set the value related to the column: CURR_ROLE
	 * @param currRole the CURR_ROLE value
	 */
	public void setCurrRole (java.lang.String currRole) {
		this.currRole = currRole;
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
		if (!(obj instanceof com.huateng.ebank.entity.data.workflow.WorkflowAppInfo)) return false;
		else {
			com.huateng.ebank.entity.data.workflow.WorkflowAppInfo workflowAppInfo = (com.huateng.ebank.entity.data.workflow.WorkflowAppInfo) obj;
			if (null == this.getAppno() || null == workflowAppInfo.getAppno()) return false;
			else return (this.getAppno().equals(workflowAppInfo.getAppno()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getAppno()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getAppno().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}