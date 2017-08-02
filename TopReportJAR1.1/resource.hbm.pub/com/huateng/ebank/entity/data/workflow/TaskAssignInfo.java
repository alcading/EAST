package com.huateng.ebank.entity.data.workflow;

import com.huateng.ebank.entity.data.workflow.base.BaseTaskAssignInfo;



public class TaskAssignInfo extends BaseTaskAssignInfo {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public TaskAssignInfo () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public TaskAssignInfo (long id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public TaskAssignInfo (
		long id,
		java.lang.String procInsId,
		java.lang.String taskId,
		java.lang.String tlrno) {

		super (
			id,
			procInsId,
			taskId,
			tlrno);
	}

/*[CONSTRUCTOR MARKER END]*/


}