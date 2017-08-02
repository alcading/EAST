package com.huateng.ebank.entity.data.workflow.base;


import java.io.Serializable;

import com.huateng.ebank.entity.data.workflow.WorkflowRouteParam;


/**
 * This is an object that contains data related to the WORKFLOW_ROUTE_PARAM table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="WORKFLOW_ROUTE_PARAM"
 */

public abstract class BaseWorkflowRouteParam  implements Serializable {

	public static String REF = "WorkflowRouteParam";
	public static String PROP_APPROVE_AMT = "approveAmt";
	public static String PROP_STOP_ID = "stopId";
	public static String PROP_BRH_CLASS = "brhClass";
	public static String PROP_NEED = "need";
	public static String PROP_ID = "id";
	public static String PROP_AMT_TYPE = "amtType";
	public static String PROP_ROUTE_ID = "routeId";
	public static String PROP_PASS = "pass";
	public static String PROP_ROLE_ID = "roleId";


	// constructors
	public BaseWorkflowRouteParam () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseWorkflowRouteParam (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseWorkflowRouteParam (
		java.lang.Integer id,
		java.lang.Integer stopId,
		java.lang.Integer routeId) {

		this.setId(id);
		this.setStopId(stopId);
		this.setRouteId(routeId);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer stopId;
	private java.lang.Integer routeId;
	private java.lang.String brhClass;
	private java.lang.Integer roleId;
	private java.lang.String need;
	private java.lang.String pass;
	private java.lang.String amtType;
	private java.math.BigDecimal approveAmt;



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
	 * Return the value associated with the column: STOP_ID
	 */
	public java.lang.Integer getStopId () {
		return stopId;
	}

	/**
	 * Set the value related to the column: STOP_ID
	 * @param stopId the STOP_ID value
	 */
	public void setStopId (java.lang.Integer stopId) {
		this.stopId = stopId;
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



	/**
	 * Return the value associated with the column: NEED
	 */
	public java.lang.String getNeed () {
		return need;
	}

	/**
	 * Set the value related to the column: NEED
	 * @param need the NEED value
	 */
	public void setNeed (java.lang.String need) {
		this.need = need;
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
	 * Return the value associated with the column: APPROVE_AMT
	 */
	public java.math.BigDecimal getApproveAmt () {
		return approveAmt;
	}

	/**
	 * Set the value related to the column: APPROVE_AMT
	 * @param approveAmt the APPROVE_AMT value
	 */
	public void setApproveAmt (java.math.BigDecimal approveAmt) {
		this.approveAmt = approveAmt;
	}




	@Override
	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof WorkflowRouteParam)) return false;
		else {
			WorkflowRouteParam workflowRouteParam = (WorkflowRouteParam) obj;
			if (null == this.getId() || null == workflowRouteParam.getId()) return false;
			else return (this.getId().equals(workflowRouteParam.getId()));
		}
	}

	@Override
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


	@Override
	public String toString () {
		return super.toString();
	}


}