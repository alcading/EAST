package resource.bean.report;

import java.util.ArrayList;
import java.util.List;

import resource.bean.report.base.BaseMtsBopEqDs;



public class MtsBopEqDs extends BaseMtsBopEqDs {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public MtsBopEqDs () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public MtsBopEqDs (java.lang.String id) {
		super(id);
	}
/*[CONSTRUCTOR MARKER END]*/
	private List<MtsBopCustom> customs = new ArrayList<MtsBopCustom>();

	public List<MtsBopCustom> getCustoms() {
		return customs;
	}

	public void setCustoms(List<MtsBopCustom> customs) {
		this.customs = customs;
	}
	


}