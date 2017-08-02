package resource.bean.report;

import java.util.List;

import resource.bean.report.base.BaseBopCfaExplrmbloDs;



public class BopCfaExplrmbloDs extends BaseBopCfaExplrmbloDs {
	private static final long serialVersionUID = 1L;

	private List<BopCfaExplbalainfo> explcurrinfos;//签约
	private List<BopCfaExplbalainfo> explbalainfos;//变动
	
	private String explcurrinfo;/*add for 补录信息查询的excel导出显示  签约信息*/
	private String explbalainfo;/*add for 补录信息查询的excel导出显示  变动信息*/
	
/*[CONSTRUCTOR MARKER BEGIN]*/
	public BopCfaExplrmbloDs () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public BopCfaExplrmbloDs (java.lang.String id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public BopCfaExplrmbloDs (
		java.lang.String id,
		java.lang.String apptype,
		java.lang.String currentfile) {

		super (
			id,
			apptype,
			currentfile);
	}

	public List<BopCfaExplbalainfo> getExplcurrinfos() {
		return explcurrinfos;
	}

	public void setExplcurrinfos(List<BopCfaExplbalainfo> explcurrinfos) {
		this.explcurrinfos = explcurrinfos;
	}

	public List<BopCfaExplbalainfo> getExplbalainfos() {
		return explbalainfos;
	}

	public void setExplbalainfos(List<BopCfaExplbalainfo> explbalainfos) {
		this.explbalainfos = explbalainfos;
	}

	public String getExplcurrinfo() {
		return explcurrinfo;
	}

	public void setExplcurrinfo(String explcurrinfo) {
		this.explcurrinfo = explcurrinfo;
	}

	public String getExplbalainfo() {
		return explbalainfo;
	}

	public void setExplbalainfo(String explbalainfo) {
		this.explbalainfo = explbalainfo;
	}

/*[CONSTRUCTOR MARKER END]*/
	
	

}