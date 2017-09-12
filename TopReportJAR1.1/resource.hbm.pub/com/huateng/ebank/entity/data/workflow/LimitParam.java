package com.huateng.ebank.entity.data.workflow;

import com.huateng.ebank.entity.data.workflow.base.BaseLimitParam;



public class LimitParam extends BaseLimitParam {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public LimitParam () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public LimitParam (long id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public LimitParam (
		long id,
		java.lang.String tlrno,
		java.lang.String bizClass,
		java.lang.String bizSubclass) {

		super (
			id,
			tlrno,
			bizClass,
			bizSubclass);
	}

/*[CONSTRUCTOR MARKER END]*/


}