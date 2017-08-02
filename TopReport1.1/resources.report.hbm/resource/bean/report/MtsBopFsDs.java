package resource.bean.report;

import resource.bean.report.base.BaseMtsBopFsDs;



public class MtsBopFsDs extends BaseMtsBopFsDs {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public MtsBopFsDs () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public MtsBopFsDs (java.lang.String id) {
		super(id);
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