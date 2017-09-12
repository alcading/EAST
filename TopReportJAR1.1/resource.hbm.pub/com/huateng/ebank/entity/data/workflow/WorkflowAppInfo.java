package com.huateng.ebank.entity.data.workflow;

import com.huateng.ebank.entity.data.workflow.base.BaseWorkflowAppInfo;



public class WorkflowAppInfo extends BaseWorkflowAppInfo {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public WorkflowAppInfo () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public WorkflowAppInfo (java.lang.String appno) {
		super(appno);
	}

	/**
	 * Constructor for required fields
	 */
	public WorkflowAppInfo (
		java.lang.String appno,
		java.lang.String apptype,
		java.lang.String piid,
		java.lang.String procName,
		java.util.Date startTime,
		java.lang.String status) {

		super (
			appno,
			apptype,
			piid,
			procName,
			startTime,
			status);
	}

/*[CONSTRUCTOR MARKER END]*/


}