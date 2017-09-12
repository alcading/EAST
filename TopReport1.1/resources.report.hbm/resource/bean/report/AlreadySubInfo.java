package resource.bean.report;

import resource.bean.report.base.BaseAlreadySubInfo;



public class AlreadySubInfo extends BaseAlreadySubInfo {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public AlreadySubInfo () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public AlreadySubInfo (java.lang.String id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public AlreadySubInfo (
		java.lang.String id,
		java.lang.String apptype,
		java.lang.String currentfile) {

		super (
			id,
			apptype,
			currentfile);
	}

/*[CONSTRUCTOR MARKER END]*/


}