package com.huateng.ebank.entity.data.workflow.base;


import java.io.Serializable;

import com.huateng.ebank.entity.data.workflow.WorkflowRouteDef;


/**
 * This is an object that contains data related to the WORKFLOW_ROUTE_DEF table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="WORKFLOW_ROUTE_DEF"
 */

public abstract class BaseWorkflowRouteDef  implements Serializable {

	public static String REF = "WorkflowRouteDef";
	public static String PROP_STATUS = "status";
	public static String PROP_IS_BAND = "isBand";
	public static String PROP_IS_SET = "isSet";
	public static String PROP_BRH_CLASS = "brhClass";
	public static String PROP_ROUTE_NAME = "routeName";
	public static String PROP_ID = "id";


	// constructors
	public BaseWorkflowRouteDef () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseWorkflowRouteDef (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseWorkflowRouteDef (
		java.lang.Integer id,
		java.lang.String routeName,
		java.lang.String brhClass) {

		this.setId(id);
		this.setRouteName(routeName);
		this.setBrhClass(brhClass);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String routeName;
	private java.lang.String brhClass;
	private java.lang.String isBand;
	private java.lang.String status;
	private java.lang.String isSet;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="ROUTE_ID"
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
	 * Return the value associated with the column: ROUTE_NAME
	 */
	public java.lang.String getRouteName () {
		return routeName;
	}

	/**
	 * Set the value related to the column: ROUTE_NAME
	 * @param routeName the ROUTE_NAME value
	 */
	public void setRouteName (java.lang.String routeName) {
		this.routeName = routeName;
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
	 * Return the value associated with the column: IS_BAND
	 */
	public java.lang.String getIsBand () {
		return isBand;
	}

	/**
	 * Set the value related to the column: IS_BAND
	 * @param isBand the IS_BAND value
	 */
	public void setIsBand (java.lang.String isBand) {
		this.isBand = isBand;
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
	 * Return the value associated with the column: IS_SET
	 */
	public java.lang.String getIsSet () {
		return isSet;
	}

	/**
	 * Set the value related to the column: IS_SET
	 * @param isSet the IS_SET value
	 */
	public void setIsSet (java.lang.String isSet) {
		this.isSet = isSet;
	}




	@Override
	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof WorkflowRouteDef)) return false;
		else {
			WorkflowRouteDef workflowRouteDef = (WorkflowRouteDef) obj;
			if (null == this.getId() || null == workflowRouteDef.getId()) return false;
			else return (this.getId().equals(workflowRouteDef.getId()));
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