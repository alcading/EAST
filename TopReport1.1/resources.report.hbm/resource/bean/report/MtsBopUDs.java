package resource.bean.report;

import java.util.List;

import resource.bean.report.base.BaseMtsBopUDs;



public class MtsBopUDs extends BaseMtsBopUDs {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public MtsBopUDs () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public MtsBopUDs (java.lang.String id) {
		super(id);
	}

/*[CONSTRUCTOR MARKER END]*/
	/**
	 * 该字段不许上报，只是用于在单位基本情况表未上报至外管局时删除该记录
	 */
	private String actiontype;

	private List<String>invcountry;
	private List<MtsBopOpenAccount>bankinfos;

	public String getActiontype() {
		return actiontype;
	}

	public void setActiontype(String actiontype) {
		this.actiontype = actiontype;
	}

	public List<String> getInvcountry() {
		return invcountry;
	}

	public void setInvcountry(List<String> invcountry) {
		this.invcountry = invcountry;
	}

	public List<MtsBopOpenAccount> getBankinfos() {
		return bankinfos;
	}

	public void setBankinfos(List<MtsBopOpenAccount> bankinfos) {
		this.bankinfos = bankinfos;
	}

}