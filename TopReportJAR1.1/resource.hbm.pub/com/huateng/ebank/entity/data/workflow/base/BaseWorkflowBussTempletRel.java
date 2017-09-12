package com.huateng.ebank.entity.data.workflow.base;


import java.io.Serializable;

import com.huateng.ebank.entity.data.workflow.WorkflowBussTempletRel;


/**
 * This is an object that contains data related to the WORKFLOW_ROUTE_PARAM table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="WORKFLOW_ROUTE_PARAM"
 */

public abstract class BaseWorkflowBussTempletRel  implements Serializable {

	public static String REF = "WorkflowBussTempletRel";
	public static String PROP_BUSS_PROC = "bussProc";
	public static String PROP_STATUS = "status";
	public static String PROP_TEMPLET_NAME = "templetName";
	public static String PROP_TEMPLET_TYPE = "templetType";
	public static String PROP_ID = "id";
	public static String PROP_TEMPLET_ID = "templetId";
	public static String PROP_DESCRIPTION = "description";
	public static String PROP_TEMPLET_DESC = "templetDesc";


	// constructors
	public BaseWorkflowBussTempletRel () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseWorkflowBussTempletRel (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseWorkflowBussTempletRel (
		java.lang.Integer id,
		java.lang.Integer templetId,
		java.lang.String templetName,
		java.lang.String templetType,
		java.lang.String bussProc,
		java.lang.String status,
		java.lang.String description,
		java.lang.String templetDesc) {

		this.setId(id);
		this.setBussProc(bussProc);
		this.setStatus(status);
		this.setTempletId(templetId);
		this.setTempletName(templetName);
		this.setTempletType(templetType);
		this.setDescription(description);
		this.setTempletDesc(templetDesc);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer templetId;
	private java.lang.String templetName;
	private java.lang.String templetType;
	private java.lang.String bussProc;
	private java.lang.String status;
	private java.lang.String description;
	private java.lang.String templetDesc;


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




	public java.lang.String getTempletDesc() {
		return templetDesc;
	}

	public void setTempletDesc(java.lang.String templetDesc) {
		this.templetDesc = templetDesc;
	}

	public java.lang.String getDescription() {
		return description;
	}

	public void setDescription(java.lang.String description) {
		this.description = description;
	}

	public java.lang.Integer getTempletId() {
		return templetId;
	}

	public void setTempletId(java.lang.Integer templetId) {
		this.templetId = templetId;
	}

	public java.lang.String getTempletName() {
		return templetName;
	}

	public void setTempletName(java.lang.String templetName) {
		this.templetName = templetName;
	}

	public java.lang.String getTempletType() {
		return templetType;
	}

	public void setTempletType(java.lang.String templetType) {
		this.templetType = templetType;
	}

	public java.lang.String getBussProc() {
		return bussProc;
	}

	public void setBussProc(java.lang.String bussProc) {
		this.bussProc = bussProc;
	}

	public java.lang.String getStatus() {
		return status;
	}

	public void setStatus(java.lang.String status) {
		this.status = status;
	}

	@Override
	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof WorkflowBussTempletRel)) return false;
		else {
			WorkflowBussTempletRel workflowBussTempletRel = (WorkflowBussTempletRel) obj;
			if (null == this.getId() || null == workflowBussTempletRel.getId()) return false;
			else return (this.getId().equals(workflowBussTempletRel.getId()));
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