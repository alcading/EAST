package resource.bean.report.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the BOP_CFA_EXGU_DS table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="BOP_CFA_EXGU_DS"
 */

public abstract class BaseBopCfaExguDs  implements Serializable {

	public static String REF = "BopCfaExguDs";
	public static String PROP_APPDOCUNO = "appdocuno";
	public static String PROP_GUARANTORCODE = "guarantorcode";
	public static String PROP_BUSCODE = "buscode";
	public static String PROP_WORK_DATE = "workDate";
	public static String PROP_APPROVE_RESULT = "approveResult";
	public static String PROP_EXGUARANCODE = "exguarancode";
	public static String PROP_GUARANAMOUNT = "guaranamount";
	public static String PROP_APPROVE_STATUS = "approveStatus";
	public static String PROP_LST_UPD_TM = "lstUpdTm";
	public static String PROP_LST_UPD_TLR = "lstUpdTlr";
	public static String PROP_CONTRACTDATE = "contractdate";
	public static String PROP_GUARANTYPE = "guarantype";
	public static String PROP_REC_STATUS = "recStatus";
	public static String PROP_MATURITY = "maturity";
	public static String PROP_ACTIONTYPE = "actiontype";
	public static String PROP_WABACHANDATE = "wabachandate";
	public static String PROP_MAINDEBTAMOUNT = "maindebtamount";
	public static String PROP_SUB_SUCCESS = "subSuccess";
	public static String PROP_APPTYPE = "apptype";
	public static String PROP_MAINDEBTCURR = "maindebtcurr";
	public static String PROP_GUARANCURR = "guarancurr";
	public static String PROP_CURRENTFILE = "currentfile";
	public static String PROP_ACTIONDESC = "actiondesc";
	public static String PROP_BASERE = "basere";
	public static String PROP_ID = "id";
	public static String PROP_COMPLIANCENO = "complianceno";
	public static String PROP_REMARK = "remark";
	public static String PROP_FILLER1 = "filler1";
	public static String PROP_REP_STATUS = "repStatus";
	public static String PROP_CRT_TM = "crtTm";
	public static String PROP_FILLER3 = "filler3";
	public static String PROP_BR_NO = "brNo";
	public static String PROP_FILLER2 = "filler2";
	public static String PROP_PGUPERAMOUNT = "pguperamount";
	public static String PROP_GUPERDATE = "guperdate";
	public static String PROP_GUPERAMOUNT = "guperamount";
	public static String PROP_GUPERCURR = "gupercurr";

	// constructors
	public BaseBopCfaExguDs () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBopCfaExguDs (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseBopCfaExguDs (
		java.lang.String id,
		java.lang.String apptype,
		java.lang.String currentfile) {

		this.setId(id);
		this.setApptype(apptype);
		this.setCurrentfile(currentfile);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;

	// fields
	private java.lang.String apptype;
	private java.lang.String currentfile;
	private java.lang.String exguarancode;
	private java.lang.String guarantorcode;
	private java.lang.String contractdate;
	private java.math.BigDecimal guaranamount;
	private java.lang.String guarancurr;
	private java.lang.String maturity;
	private java.lang.String guarantype;
	private java.lang.String maindebtcurr;
	private java.math.BigDecimal maindebtamount;
	private java.lang.String appdocuno;
	private java.lang.String remark;
	private java.lang.String wabachandate;
	private java.math.BigDecimal basere;
	private java.lang.String complianceno;
	private java.lang.String buscode;
	private java.lang.String lstUpdTlr;
	private java.util.Date lstUpdTm;
	private java.util.Date crtTm;
	private java.lang.String filler1;
	private java.lang.String filler2;
	private java.lang.String filler3;
	private java.lang.String brNo;
	private java.lang.String actiontype;
	private java.lang.String actiondesc;
	private java.lang.String recStatus;
	private java.lang.String repStatus;
	private java.lang.String approveStatus;
	private java.lang.String approveResult;
	private java.lang.String workDate;
	private java.lang.String subSuccess;
	private java.lang.String guperdate;
	private java.lang.String gupercurr;
	private java.math.BigDecimal guperamount;
	private java.math.BigDecimal pguperamount;


	public java.lang.String getGuperdate() {
		return guperdate;
	}

	public void setGuperdate(java.lang.String guperdate) {
		this.guperdate = guperdate;
	}

	public java.lang.String getGupercurr() {
		return gupercurr;
	}

	public void setGupercurr(java.lang.String gupercurr) {
		this.gupercurr = gupercurr;
	}

	public java.math.BigDecimal getGuperamount() {
		return guperamount;
	}

	public void setGuperamount(java.math.BigDecimal guperamount) {
		this.guperamount = guperamount;
	}

	public java.math.BigDecimal getPguperamount() {
		return pguperamount;
	}

	public void setPguperamount(java.math.BigDecimal pguperamount) {
		this.pguperamount = pguperamount;
	}

	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  column="REC_ID"
     */
	public java.lang.String getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (java.lang.String id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: APPTYPE
	 */
	public java.lang.String getApptype () {
		return apptype;
	}

	/**
	 * Set the value related to the column: APPTYPE
	 * @param apptype the APPTYPE value
	 */
	public void setApptype (java.lang.String apptype) {
		this.apptype = apptype;
	}



	/**
	 * Return the value associated with the column: CURRENTFILE
	 */
	public java.lang.String getCurrentfile () {
		return currentfile;
	}

	/**
	 * Set the value related to the column: CURRENTFILE
	 * @param currentfile the CURRENTFILE value
	 */
	public void setCurrentfile (java.lang.String currentfile) {
		this.currentfile = currentfile;
	}



	/**
	 * Return the value associated with the column: EXGUARANCODE
	 */
	public java.lang.String getExguarancode () {
		return exguarancode;
	}

	/**
	 * Set the value related to the column: EXGUARANCODE
	 * @param exguarancode the EXGUARANCODE value
	 */
	public void setExguarancode (java.lang.String exguarancode) {
		this.exguarancode = exguarancode;
	}



	/**
	 * Return the value associated with the column: GUARANTORCODE
	 */
	public java.lang.String getGuarantorcode () {
		return guarantorcode;
	}

	/**
	 * Set the value related to the column: GUARANTORCODE
	 * @param guarantorcode the GUARANTORCODE value
	 */
	public void setGuarantorcode (java.lang.String guarantorcode) {
		this.guarantorcode = guarantorcode;
	}



	/**
	 * Return the value associated with the column: CONTRACTDATE
	 */
	public java.lang.String getContractdate () {
		return contractdate;
	}

	/**
	 * Set the value related to the column: CONTRACTDATE
	 * @param contractdate the CONTRACTDATE value
	 */
	public void setContractdate (java.lang.String contractdate) {
		this.contractdate = contractdate;
	}



	/**
	 * Return the value associated with the column: GUARANAMOUNT
	 */
	public java.math.BigDecimal getGuaranamount () {
		return guaranamount;
	}

	/**
	 * Set the value related to the column: GUARANAMOUNT
	 * @param guaranamount the GUARANAMOUNT value
	 */
	public void setGuaranamount (java.math.BigDecimal guaranamount) {
		this.guaranamount = guaranamount;
	}



	/**
	 * Return the value associated with the column: GUARANCURR
	 */
	public java.lang.String getGuarancurr () {
		return guarancurr;
	}

	/**
	 * Set the value related to the column: GUARANCURR
	 * @param guarancurr the GUARANCURR value
	 */
	public void setGuarancurr (java.lang.String guarancurr) {
		this.guarancurr = guarancurr;
	}



	/**
	 * Return the value associated with the column: MATURITY
	 */
	public java.lang.String getMaturity () {
		return maturity;
	}

	/**
	 * Set the value related to the column: MATURITY
	 * @param maturity the MATURITY value
	 */
	public void setMaturity (java.lang.String maturity) {
		this.maturity = maturity;
	}



	/**
	 * Return the value associated with the column: GUARANTYPE
	 */
	public java.lang.String getGuarantype () {
		return guarantype;
	}

	/**
	 * Set the value related to the column: GUARANTYPE
	 * @param guarantype the GUARANTYPE value
	 */
	public void setGuarantype (java.lang.String guarantype) {
		this.guarantype = guarantype;
	}



	/**
	 * Return the value associated with the column: MAINDEBTCURR
	 */
	public java.lang.String getMaindebtcurr () {
		return maindebtcurr;
	}

	/**
	 * Set the value related to the column: MAINDEBTCURR
	 * @param maindebtcurr the MAINDEBTCURR value
	 */
	public void setMaindebtcurr (java.lang.String maindebtcurr) {
		this.maindebtcurr = maindebtcurr;
	}



	/**
	 * Return the value associated with the column: MAINDEBTAMOUNT
	 */
	public java.math.BigDecimal getMaindebtamount () {
		return maindebtamount;
	}

	/**
	 * Set the value related to the column: MAINDEBTAMOUNT
	 * @param maindebtamount the MAINDEBTAMOUNT value
	 */
	public void setMaindebtamount (java.math.BigDecimal maindebtamount) {
		this.maindebtamount = maindebtamount;
	}



	/**
	 * Return the value associated with the column: APPDOCUNO
	 */
	public java.lang.String getAppdocuno () {
		return appdocuno;
	}

	/**
	 * Set the value related to the column: APPDOCUNO
	 * @param appdocuno the APPDOCUNO value
	 */
	public void setAppdocuno (java.lang.String appdocuno) {
		this.appdocuno = appdocuno;
	}



	/**
	 * Return the value associated with the column: REMARK
	 */
	public java.lang.String getRemark () {
		return remark;
	}

	/**
	 * Set the value related to the column: REMARK
	 * @param remark the REMARK value
	 */
	public void setRemark (java.lang.String remark) {
		this.remark = remark;
	}



	/**
	 * Return the value associated with the column: WABACHANDATE
	 */
	public java.lang.String getWabachandate () {
		return wabachandate;
	}

	/**
	 * Set the value related to the column: WABACHANDATE
	 * @param wabachandate the WABACHANDATE value
	 */
	public void setWabachandate (java.lang.String wabachandate) {
		this.wabachandate = wabachandate;
	}



	/**
	 * Return the value associated with the column: BASERE
	 */
	public java.math.BigDecimal getBasere () {
		return basere;
	}

	/**
	 * Set the value related to the column: BASERE
	 * @param basere the BASERE value
	 */
	public void setBasere (java.math.BigDecimal basere) {
		this.basere = basere;
	}



	/**
	 * Return the value associated with the column: COMPLIANCENO
	 */
	public java.lang.String getComplianceno () {
		return complianceno;
	}

	/**
	 * Set the value related to the column: COMPLIANCENO
	 * @param complianceno the COMPLIANCENO value
	 */
	public void setComplianceno (java.lang.String complianceno) {
		this.complianceno = complianceno;
	}



	/**
	 * Return the value associated with the column: BUSCODE
	 */
	public java.lang.String getBuscode () {
		return buscode;
	}

	/**
	 * Set the value related to the column: BUSCODE
	 * @param buscode the BUSCODE value
	 */
	public void setBuscode (java.lang.String buscode) {
		this.buscode = buscode;
	}



	/**
	 * Return the value associated with the column: LST_UPD_TLR
	 */
	public java.lang.String getLstUpdTlr () {
		return lstUpdTlr;
	}

	/**
	 * Set the value related to the column: LST_UPD_TLR
	 * @param lstUpdTlr the LST_UPD_TLR value
	 */
	public void setLstUpdTlr (java.lang.String lstUpdTlr) {
		this.lstUpdTlr = lstUpdTlr;
	}






	public java.util.Date getLstUpdTm() {
		return lstUpdTm;
	}

	public void setLstUpdTm(java.util.Date lstUpdTm) {
		this.lstUpdTm = lstUpdTm;
	}

	public java.util.Date getCrtTm() {
		return crtTm;
	}

	public void setCrtTm(java.util.Date crtTm) {
		this.crtTm = crtTm;
	}

	/**
	 * Return the value associated with the column: FILLER1
	 */
	public java.lang.String getFiller1 () {
		return filler1;
	}

	/**
	 * Set the value related to the column: FILLER1
	 * @param filler1 the FILLER1 value
	 */
	public void setFiller1 (java.lang.String filler1) {
		this.filler1 = filler1;
	}



	/**
	 * Return the value associated with the column: FILLER2
	 */
	public java.lang.String getFiller2 () {
		return filler2;
	}

	/**
	 * Set the value related to the column: FILLER2
	 * @param filler2 the FILLER2 value
	 */
	public void setFiller2 (java.lang.String filler2) {
		this.filler2 = filler2;
	}



	/**
	 * Return the value associated with the column: FILLER3
	 */
	public java.lang.String getFiller3 () {
		return filler3;
	}

	/**
	 * Set the value related to the column: FILLER3
	 * @param filler3 the FILLER3 value
	 */
	public void setFiller3 (java.lang.String filler3) {
		this.filler3 = filler3;
	}



	/**
	 * Return the value associated with the column: BR_NO
	 */
	public java.lang.String getBrNo () {
		return brNo;
	}

	/**
	 * Set the value related to the column: BR_NO
	 * @param brNo the BR_NO value
	 */
	public void setBrNo (java.lang.String brNo) {
		this.brNo = brNo;
	}



	/**
	 * Return the value associated with the column: ACTIONTYPE
	 */
	public java.lang.String getActiontype () {
		return actiontype;
	}

	/**
	 * Set the value related to the column: ACTIONTYPE
	 * @param actiontype the ACTIONTYPE value
	 */
	public void setActiontype (java.lang.String actiontype) {
		this.actiontype = actiontype;
	}



	/**
	 * Return the value associated with the column: ACTIONDESC
	 */
	public java.lang.String getActiondesc () {
		return actiondesc;
	}

	/**
	 * Set the value related to the column: ACTIONDESC
	 * @param actiondesc the ACTIONDESC value
	 */
	public void setActiondesc (java.lang.String actiondesc) {
		this.actiondesc = actiondesc;
	}



	/**
	 * Return the value associated with the column: REC_STATUS
	 */
	public java.lang.String getRecStatus () {
		return recStatus;
	}

	/**
	 * Set the value related to the column: REC_STATUS
	 * @param recStatus the REC_STATUS value
	 */
	public void setRecStatus (java.lang.String recStatus) {
		this.recStatus = recStatus;
	}



	/**
	 * Return the value associated with the column: REP_STATUS
	 */
	public java.lang.String getRepStatus () {
		return repStatus;
	}

	/**
	 * Set the value related to the column: REP_STATUS
	 * @param repStatus the REP_STATUS value
	 */
	public void setRepStatus (java.lang.String repStatus) {
		this.repStatus = repStatus;
	}



	/**
	 * Return the value associated with the column: APPROVE_STATUS
	 */
	public java.lang.String getApproveStatus () {
		return approveStatus;
	}

	/**
	 * Set the value related to the column: APPROVE_STATUS
	 * @param approveStatus the APPROVE_STATUS value
	 */
	public void setApproveStatus (java.lang.String approveStatus) {
		this.approveStatus = approveStatus;
	}



	/**
	 * Return the value associated with the column: APPROVE_RESULT
	 */
	public java.lang.String getApproveResult () {
		return approveResult;
	}

	/**
	 * Set the value related to the column: APPROVE_RESULT
	 * @param approveResult the APPROVE_RESULT value
	 */
	public void setApproveResult (java.lang.String approveResult) {
		this.approveResult = approveResult;
	}



	/**
	 * Return the value associated with the column: WORK_DATE
	 */
	public java.lang.String getWorkDate () {
		return workDate;
	}

	/**
	 * Set the value related to the column: WORK_DATE
	 * @param workDate the WORK_DATE value
	 */
	public void setWorkDate (java.lang.String workDate) {
		this.workDate = workDate;
	}







	public java.lang.String getSubSuccess() {
		return subSuccess;
	}

	public void setSubSuccess(java.lang.String subSuccess) {
		this.subSuccess = subSuccess;
	}

	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof resource.bean.report.BopCfaExguDs)) return false;
		else {
			resource.bean.report.BopCfaExguDs bopCfaExguDs = (resource.bean.report.BopCfaExguDs) obj;
			if (null == this.getId() || null == bopCfaExguDs.getId()) return false;
			else return (this.getId().equals(bopCfaExguDs.getId()));
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