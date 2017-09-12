package resource.bean.report;

import resource.bean.report.base.BaseMtsBopAgDs;



public class MtsBopAgDs extends BaseMtsBopAgDs {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public MtsBopAgDs () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public MtsBopAgDs (java.lang.String id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public MtsBopAgDs (
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