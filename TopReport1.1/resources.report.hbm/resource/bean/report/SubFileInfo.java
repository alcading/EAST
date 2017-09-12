package resource.bean.report;

import resource.bean.report.base.BaseSubFileInfo;



public class SubFileInfo extends BaseSubFileInfo {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public SubFileInfo () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public SubFileInfo (java.lang.String id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public SubFileInfo (
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