package com.huateng.ebank.entity.data.workflow.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the BRH_WORKFLOW_DEF table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="BRH_WORKFLOW_DEF"
 */

public abstract class BaseBrhWorkflowDef  implements Serializable {

	public static String REF = "BrhWorkflowDef";
	public static String PROP_STATUS = "status";
	public static String PROP_BIZ_SUBCLASS = "bizSubclass";
	public static String PROP_EXPIRE_DATE = "expireDate";
	public static String PROP_BIZ_CLASS = "bizClass";
	public static String PROP_PROCESS_TEMPLATE = "processTemplate";
	public static String PROP_EFFECT_DATE = "effectDate";
	public static String PROP_ID = "id";
	public static String PROP_APPTYPE = "apptype";
	public static String PROP_BRCODE = "brcode";


	// constructors
	public BaseBrhWorkflowDef () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBrhWorkflowDef (long id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseBrhWorkflowDef (
		long id,
		java.lang.String brcode,
		java.lang.String apptype,
		java.lang.String bizSubclass) {

		this.setId(id);
		this.setBrcode(brcode);
		this.setApptype(apptype);
		this.setBizSubclass(bizSubclass);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private long id;

	// fields
	private java.lang.String brcode;
	private java.lang.String apptype;
	private java.lang.String bizClass;
	private java.lang.String bizSubclass;
	private java.lang.String processTemplate;
	private java.util.Date effectDate;
	private java.util.Date expireDate;
	private java.lang.String status;



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
	 * Return the value associated with the column: EFFECT_DATE
	 */
	public java.util.Date getEffectDate () {
		return effectDate;
	}

	/**
	 * Set the value related to the column: EFFECT_DATE
	 * @param effectDate the EFFECT_DATE value
	 */
	public void setEffectDate (java.util.Date effectDate) {
		this.effectDate = effectDate;
	}



	/**
	 * Return the value associated with the column: EXPIRE_DATE
	 */
	public java.util.Date getExpireDate () {
		return expireDate;
	}

	/**
	 * Set the value related to the column: EXPIRE_DATE
	 * @param expireDate the EXPIRE_DATE value
	 */
	public void setExpireDate (java.util.Date expireDate) {
		this.expireDate = expireDate;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.huateng.ebank.entity.data.workflow.BrhWorkflowDef)) return false;
		else {
			com.huateng.ebank.entity.data.workflow.BrhWorkflowDef brhWorkflowDef = (com.huateng.ebank.entity.data.workflow.BrhWorkflowDef) obj;
			return (this.getId() == brhWorkflowDef.getId());
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