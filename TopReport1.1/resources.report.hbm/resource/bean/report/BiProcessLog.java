package resource.bean.report;

import resource.bean.report.base.BaseBiProcessLog;



public class BiProcessLog extends BaseBiProcessLog {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public BiProcessLog () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public BiProcessLog (java.lang.String id) {
		super(id);
	}

/*[CONSTRUCTOR MARKER END]*/

	private String brName;

	public String getBrName() {
		return brName;
	}

	public void setBrName(String brName) {
		this.brName = brName;
	}


}