package resource.bean.report;

import resource.bean.report.base.BaseMtsBopCkpDs;



public class MtsBopCkpDs extends BaseMtsBopCkpDs {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public MtsBopCkpDs () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public MtsBopCkpDs (java.lang.String id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public MtsBopCkpDs (
		java.lang.String id,
		java.lang.String apptype,
		java.lang.String currentfile) {

		super (
			id,
			apptype,
			currentfile);
	}

/*[CONSTRUCTOR MARKER END]*/

	private String cfiller2;

	public String getCfiller2() {
		return cfiller2;
	}

	public void setCfiller2(String cfiller2) {
		this.cfiller2 = cfiller2;
	}

}