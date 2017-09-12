package resource.bean.report;

import java.util.ArrayList;

import resource.bean.report.base.BaseBopCfaExguDs;





public class BopCfaExguDs extends BaseBopCfaExguDs {
	private static final long serialVersionUID = 1L;
	private java.util.List  beneficiarys = new ArrayList<Beneficiary>() ;//受益人列表
	private java.util.List guarantores = new ArrayList<Guarantor>();//被担保人列表
	private java.lang.String  beneficiary ;//受益人
	private java.lang.String guarantore ;//被担保人
//担保申请人
	private java.lang.String guappnamen;
	private java.lang.String guappcode;
	private java.lang.String guappname;
//受益人
	private java.lang.String bencode;
	private java.lang.String bename;
	private java.lang.String benamen;

	/*[CONSTRUCTOR MARKER BEGIN]*/
	public BopCfaExguDs () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public BopCfaExguDs (java.lang.String id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public BopCfaExguDs (
		java.lang.String id,
		java.lang.String apptype,
		java.lang.String currentfile) {

		super (
			id,
			apptype,
			currentfile);
	}



	public java.lang.String getGuappname() {
		return guappname;
	}







	public void setGuappname(java.lang.String guappname) {
		this.guappname = guappname;
	}

	public java.lang.String getBencode() {
		return bencode;
	}

	public void setBencode(java.lang.String bencode) {
		this.bencode = bencode;
	}

	public java.lang.String getBename() {
		return bename;
	}

	public void setBename(java.lang.String bename) {
		this.bename = bename;
	}

	public java.lang.String getBenamen() {
		return benamen;
	}

	public void setBenamen(java.lang.String benamen) {
		this.benamen = benamen;
	}

	public java.lang.String getGuappnamen() {
		return guappnamen;
	}

	public void setGuappnamen(java.lang.String guappnamen) {
		this.guappnamen = guappnamen;
	}

	public java.lang.String getGuappcode() {
		return guappcode;
	}

	public void setGuappcode(java.lang.String guappcode) {
		this.guappcode = guappcode;
	}

	public java.util.List getBeneficiarys() {
		return beneficiarys;
	}

	public void setBeneficiarys(java.util.List beneficiarys) {
		this.beneficiarys = beneficiarys;
	}

	public java.util.List getGuarantores() {
		return guarantores;
	}

	public void setGuarantores(java.util.List guarantores) {
		this.guarantores = guarantores;
	}

	public java.lang.String getBeneficiary() {
		return beneficiary;
	}

	public void setBeneficiary(java.lang.String beneficiary) {
		this.beneficiary = beneficiary;
	}

	public java.lang.String getGuarantore() {
		return guarantore;
	}

	public void setGuarantore(java.lang.String guarantore) {
		this.guarantore = guarantore;
	}




/*[CONSTRUCTOR MARKER END]*/


}