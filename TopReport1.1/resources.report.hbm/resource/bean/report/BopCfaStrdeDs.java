package resource.bean.report;

import resource.bean.report.base.BaseBopCfaStrdeDs;



public class BopCfaStrdeDs extends BaseBopCfaStrdeDs {
	private static final long serialVersionUID = 1L;

	private String aginrapay;
	
/*[CONSTRUCTOR MARKER BEGIN]*/
	public BopCfaStrdeDs () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public BopCfaStrdeDs (java.lang.String id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public BopCfaStrdeDs (
		java.lang.String id,
		java.lang.String apptype,
		java.lang.String currentfile) {

		super (
			id,
			apptype,
			currentfile);
	}

/*[CONSTRUCTOR MARKER END]*/
	public void setAginrapay(String aginrapay) {
		this.aginrapay = aginrapay;
	}
	
	public String getAginrapay() {
		return aginrapay;
	}

}