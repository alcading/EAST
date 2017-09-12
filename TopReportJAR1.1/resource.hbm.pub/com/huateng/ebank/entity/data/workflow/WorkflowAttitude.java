package com.huateng.ebank.entity.data.workflow;

import com.huateng.ebank.entity.data.workflow.base.BaseWorkflowAttitude;



public class WorkflowAttitude extends BaseWorkflowAttitude {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public WorkflowAttitude () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public WorkflowAttitude (long id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public WorkflowAttitude (
		long id,
		java.lang.String processTemplate,
		java.lang.String taskName,
		java.lang.String apptype,
		java.lang.String overFlag,
		java.lang.String attitudelist) {

		super (
			id,
			processTemplate,
			taskName,
			apptype,
			overFlag,
			attitudelist);
	}

/*[CONSTRUCTOR MARKER END]*/


}