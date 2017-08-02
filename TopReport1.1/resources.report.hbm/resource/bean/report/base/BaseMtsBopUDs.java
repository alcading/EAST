package resource.bean.report.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the MTS_BOP_FS_DS table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="MTS_BOP_FS_DS"
 */

public abstract class BaseMtsBopUDs  implements Serializable {

	public static String REF = "BaseMtsBopUDs";
	public static String PROP_ID = "id";
	public static String PROP_CUSTCODE = "custcode";
	public static String PROP_CUSTNAME = "custname";
	public static String PROP_AREACODE = "areacode";
	public static String PROP_CUSTADDR = "custaddr";
	public static String PROP_POSTCODE = "postcode";
	public static String PROP_INDUSTRYCODE = "industrycode";
	public static String PROP_ATTRCODE = "attrcode";
	public static String PROP_COUNTRYCODE = "countrycode";
	public static String PROP_ISTAXFREE = "istaxfree";
	public static String PROP_TAXFREECODE = "taxfreecode";
	public static String PROP_EMAIL = "email";
	public static String PROP_RPTMETHOD = "rptmethod";
	public static String PROP_ECEXADDR = "ecexaddr";
	public static String PROP_REMARKS = "remarks";
	public static String PROP_SUB_SUCCESS = "subSuccess";

	public static String PROP_APPTYPE = "apptype";
	public static String PROP_CURRENTFILE = "currentfile";

	public static String PROP_REP_STATUS = "repStatus";
	public static String PROP_REC_STATUS = "recStatus";

	public static String PROP_WORK_DATE = "workDate";
	public static String PROP_APPROVE_STATUS = "approveStatus";
	public static String PROP_APPROVE_RESULT = "approveResult";

	public static String PROP_LST_UPD_TLR = "lstUpdTlr";
	public static String PROP_LST_UPD_TM = "lstUpdTm";

	public static String PROP_CRTUSER = "crtuser";
	public static String PROP_CRT_TM = "crtTm";
	public static String PROP_BR_NO = "brNo";


	// constructors
	public BaseMtsBopUDs () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMtsBopUDs (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;

	// fields
	private java.lang.String apptype;
	private java.lang.String currentfile;
	private java.lang.String custcode;
	private java.lang.String custname;
	private java.lang.String areacode;
	private java.lang.String custaddr;
	private java.lang.String postcode;
	private java.lang.String industrycode;
	private java.lang.String attrcode;
	private java.lang.String countrycode;
	private java.lang.String istaxfree;
	private java.lang.String taxfreecode;
	private java.lang.String email;
	private java.lang.String rptmethod;
	private java.lang.String ecexaddr;
	private java.lang.String remarks;
	private java.lang.String subSuccess;

	private java.lang.String repStatus;
	private java.lang.String recStatus;

	private java.lang.String workDate;
	private java.lang.String approveStatus;
	private java.lang.String approveResult;

	private java.lang.String lstUpdTlr;
	private java.util.Date lstUpdTm;

	private java.lang.String crtuser;
	private java.util.Date crtTm;
	private java.lang.String brNo;




	public java.lang.String getId () {
		return id;
	}

	public void setId (java.lang.String id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	public java.lang.String getApptype () {
		return apptype;
	}

	public void setApptype (java.lang.String apptype) {
		this.apptype = apptype;
	}



	public java.lang.String getCurrentfile () {
		return currentfile;
	}

	public void setCurrentfile (java.lang.String currentfile) {
		this.currentfile = currentfile;
	}

	public java.lang.String getCustcode() {
		return custcode;
	}

	public void setCustcode(java.lang.String custcode) {
		this.custcode = custcode;
	}

	public java.lang.String getCustname() {
		return custname;
	}

	public void setCustname(java.lang.String custname) {
		this.custname = custname;
	}

	public java.lang.String getAreacode() {
		return areacode;
	}

	public void setAreacode(java.lang.String areacode) {
		this.areacode = areacode;
	}

	public java.lang.String getCustaddr() {
		return custaddr;
	}

	public void setCustaddr(java.lang.String custaddr) {
		this.custaddr = custaddr;
	}

	public java.lang.String getPostcode() {
		return postcode;
	}

	public void setPostcode(java.lang.String postcode) {
		this.postcode = postcode;
	}

	public java.lang.String getIndustrycode() {
		return industrycode;
	}

	public void setIndustrycode(java.lang.String industrycode) {
		this.industrycode = industrycode;
	}

	public java.lang.String getAttrcode() {
		return attrcode;
	}

	public void setAttrcode(java.lang.String attrcode) {
		this.attrcode = attrcode;
	}

	public java.lang.String getCountrycode() {
		return countrycode;
	}

	public void setCountrycode(java.lang.String countrycode) {
		this.countrycode = countrycode;
	}

	public java.lang.String getIstaxfree() {
		return istaxfree;
	}

	public void setIstaxfree(java.lang.String istaxfree) {
		this.istaxfree = istaxfree;
	}

	public java.lang.String getTaxfreecode() {
		return taxfreecode;
	}

	public void setTaxfreecode(java.lang.String taxfreecode) {
		this.taxfreecode = taxfreecode;
	}

	public java.lang.String getEmail() {
		return email;
	}

	public void setEmail(java.lang.String email) {
		this.email = email;
	}

	public java.lang.String getRptmethod() {
		return rptmethod;
	}

	public void setRptmethod(java.lang.String rptmethod) {
		this.rptmethod = rptmethod;
	}

	public java.lang.String getEcexaddr() {
		return ecexaddr;
	}

	public void setEcexaddr(java.lang.String ecexaddr) {
		this.ecexaddr = ecexaddr;
	}

	public java.lang.String getRemarks() {
		return remarks;
	}

	public void setRemarks(java.lang.String remarks) {
		this.remarks = remarks;
	}

	public java.util.Date getLstUpdTm () {
		return lstUpdTm;
	}

	public void setLstUpdTm (java.util.Date lstUpdTm) {
		this.lstUpdTm = lstUpdTm;
	}



	public java.util.Date getCrtTm () {
		return crtTm;
	}

	public void setCrtTm (java.util.Date crtTm) {
		this.crtTm = crtTm;
	}




	public java.lang.String getRecStatus () {
		return recStatus;
	}

	public void setRecStatus (java.lang.String recStatus) {
		this.recStatus = recStatus;
	}



	public java.lang.String getRepStatus () {
		return repStatus;
	}

	public void setRepStatus (java.lang.String repStatus) {
		this.repStatus = repStatus;
	}



	public java.lang.String getApproveStatus () {
		return approveStatus;
	}

	public void setApproveStatus (java.lang.String approveStatus) {
		this.approveStatus = approveStatus;
	}


	public java.lang.String getApproveResult () {
		return approveResult;
	}

	public void setApproveResult (java.lang.String approveResult) {
		this.approveResult = approveResult;
	}



	public java.lang.String getWorkDate () {
		return workDate;
	}

	public void setWorkDate (java.lang.String workDate) {
		this.workDate = workDate;
	}


	public java.lang.String getSubSuccess () {
		return subSuccess;
	}

	public void setSubSuccess (java.lang.String subSuccess) {
		this.subSuccess = subSuccess;
	}

	public java.lang.String getLstUpdTlr() {
		return lstUpdTlr;
	}

	public void setLstUpdTlr(java.lang.String lstUpdTlr) {
		this.lstUpdTlr = lstUpdTlr;
	}

	public java.lang.String getCrtuser() {
		return crtuser;
	}

	public void setCrtuser(java.lang.String crtuser) {
		this.crtuser = crtuser;
	}

	public java.lang.String getBrNo() {
		return brNo;
	}

	public void setBrNo(java.lang.String brNo) {
		this.brNo = brNo;
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof resource.bean.report.MtsBopFsDs)) return false;
		else {
			resource.bean.report.MtsBopFsDs mtsBopFsDs = (resource.bean.report.MtsBopFsDs) obj;
			if (null == this.getId() || null == mtsBopFsDs.getId()) return false;
			else return (this.getId().equals(mtsBopFsDs.getId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}