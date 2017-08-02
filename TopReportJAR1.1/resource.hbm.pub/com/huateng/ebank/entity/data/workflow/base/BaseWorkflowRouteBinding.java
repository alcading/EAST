package com.huateng.ebank.entity.data.workflow.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the WORKFLOW_ROUTE_BINDING table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="WORKFLOW_ROUTE_BINDING"
 */

public abstract class BaseWorkflowRouteBinding  implements Serializable {

	public static String REF = "WorkflowRouteBinding";
	public static String PROP_MAX_AMT = "maxAmt";
	public static String PROP_START_BRHID = "startBrhid";
	public static String PROP_DRAFT_TYPE = "draftType";
	public static String PROP_BRH_CLASS = "brhClass";
	public static String PROP_START_BRHNO = "startBrhno";
	public static String PROP_ID = "id";
	public static String PROP_ROUTE_ID = "routeId";
	public static String PROP_BUSS_TYPE = "bussType";


	// constructors
	public BaseWorkflowRouteBinding () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseWorkflowRouteBinding (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String bussType;
	private java.lang.String draftType;
	private java.math.BigDecimal maxAmt;
	private java.lang.String startBrhid;
	private java.lang.String startBrhno;
	private java.lang.String brhClass;
	private java.lang.Integer routeId;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="ID"
     */
	public java.lang.Integer getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (java.lang.Integer id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: BUSS_TYPE
	 */
	public java.lang.String getBussType () {
		return bussType;
	}

	/**
	 * Set the value related to the column: BUSS_TYPE
	 * @param bussType the BUSS_TYPE value
	 */
	public void setBussType (java.lang.String bussType) {
		this.bussType = bussType;
	}



	/**
	 * Return the value associated with the column: DRAFT_TYPE
	 */
	public java.lang.String getDraftType () {
		return draftType;
	}

	/**
	 * Set the value related to the column: DRAFT_TYPE
	 * @param draftType the DRAFT_TYPE value
	 */
	public void setDraftType (java.lang.String draftType) {
		this.draftType = draftType;
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
	 * Return the value associated with the column: START_BRHNO
	 */
	public java.lang.String getStartBrhno () {
		return startBrhno;
	}

	/**
	 * Set the value related to the column: START_BRHNO
	 * @param startBrhno the START_BRHNO value
	 */
	public void setStartBrhno (java.lang.String startBrhno) {
		this.startBrhno = startBrhno;
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
	 * Return the value associated with the column: ROUTE_ID
	 */
	public java.lang.Integer getRouteId () {
		return routeId;
	}

	/**
	 * Set the value related to the column: ROUTE_ID
	 * @param routeId the ROUTE_ID value
	 */
	public void setRouteId (java.lang.Integer routeId) {
		this.routeId = routeId;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.huateng.ebank.entity.data.workflow.WorkflowRouteBinding)) return false;
		else {
			com.huateng.ebank.entity.data.workflow.WorkflowRouteBinding workflowRouteBinding = (com.huateng.ebank.entity.data.workflow.WorkflowRouteBinding) obj;
			if (null == this.getId() || null == workflowRouteBinding.getId()) return false;
			else return (this.getId().equals(workflowRouteBinding.getId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}