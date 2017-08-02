package resource.bean.report;

import java.util.List;

import resource.bean.report.base.BaseBiWorkdateConf;

import com.huateng.report.utils.RepList;



public class BiWorkdateConf extends BaseBiWorkdateConf {
	private static final long serialVersionUID = 1L;
	private List<String> workDateList = new RepList<String>();

/*[CONSTRUCTOR MARKER BEGIN]*/
	public BiWorkdateConf () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public BiWorkdateConf (java.lang.String id) {
		super(id);
	}

	public List<String> getWorkDateList() {
		return workDateList;
	}

	public void setWorkDateList(List<String> workDateList) {
		this.workDateList = workDateList;
	}

/*[CONSTRUCTOR MARKER END]*/


}