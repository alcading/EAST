package resource.bean.report.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the BOP_CFA_EXPLRMBLO_DS table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="BOP_CFA_EXPLRMBLO_DS"
 */

public abstract class BaseBopCfaExplrmbloDs  implements Serializable {

	public static String REF = "BopCfaExplrmbloDs";
	public static String PROP_BUOCMONTH = "buocmonth";
	public static String PROP_EXPLRMBLONO = "explrmblono";
	public static String PROP_CREDCONCURR = "credconcurr";
	public static String PROP_PLCOSEAMOUNT = "plcoseamount";
	public static String PROP_CREDREPAYAMOUNT = "credrepayamount";
	public static String PROP_MONENLOADBAL = "monenloadbal";
	public static String PROP_WORK_DATE = "workDate";
	public static String PROP_CREDCONAMOUNT = "credconamount";
	public static String PROP_APPROVE_RESULT = "approveResult";
	public static String PROP_CREDITORCODE = "creditorcode";
	public static String PROP_APPROVE_STATUS = "approveStatus";
	public static String PROP_LST_UPD_TM = "lstUpdTm";
	public static String PROP_DEBTORNAME = "debtorname";
	public static String PROP_VALUEDATE = "valuedate";
	public static String PROP_LST_UPD_TLR = "lstUpdTlr";
	public static String PROP_CHANGENO = "changeno";
	public static String PROP_MONBELOADBAL = "monbeloadbal";
	public static String PROP_EXPLBALA = "explbala";
	public static String PROP_REC_STATUS = "recStatus";
	public static String PROP_MATURITY = "maturity";
	public static String PROP_ACTIONTYPE = "actiontype";
	public static String PROP_EXPLAMOUNT = "explamount";
	public static String PROP_EXPLCURR = "explcurr";
	public static String PROP_SUB_SUCCESS = "subSuccess";
	public static String PROP_DEBTORCODE = "debtorcode";
	public static String PROP_APPTYPE = "apptype";
	public static String PROP_PICAMOUNT = "picamount";
	public static String PROP_CURRENTFILE = "currentfile";
	public static String PROP_EXPLPERAMOUNT = "explperamount";
	public static String PROP_ACTIONDESC = "actiondesc";
	public static String PROP_ID = "id";
	public static String PROP_FILLER1 = "filler1";
	public static String PROP_REMARK = "remark";
	public static String PROP_REP_STATUS = "repStatus";
	public static String PROP_BR_NO = "brNo";
	public static String PROP_FILLER3 = "filler3";
	public static String PROP_CRT_TM = "crtTm";
	public static String PROP_FILLER2 = "filler2";
	public static String PROP_CREDWITHAMOUNT = "credwithamount";
	public static String PROP_BUSCODE = "buscode";



	// constructors
	public BaseBopCfaExplrmbloDs () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBopCfaExplrmbloDs (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseBopCfaExplrmbloDs (
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
	private java.lang.String explrmblono;
	private java.lang.String creditorcode;
	private java.lang.String debtorcode;
	private java.lang.String debtorname;
	private java.lang.String valuedate;
	private java.lang.String credconcurr;
	private java.math.BigDecimal credconamount;
	private java.lang.String maturity;
	private java.lang.String explcurr;
	private java.math.BigDecimal explamount;
	private java.lang.String remark;
	private java.lang.String buocmonth;
	private java.lang.String changeno;
	private java.math.BigDecimal monbeloadbal;
	private java.math.BigDecimal credwithamount;
	private java.math.BigDecimal credrepayamount;
	private java.math.BigDecimal picamount;
	private java.math.BigDecimal explbala;
	private java.math.BigDecimal explperamount;
	private java.math.BigDecimal plcoseamount;
	private java.math.BigDecimal monenloadbal;
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
	private java.lang.String buscode;
	private String subSuccess;

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
	 * Return the value associated with the column: EXPLRMBLONO
	 */
	public java.lang.String getExplrmblono () {
		return explrmblono;
	}

	/**
	 * Set the value related to the column: EXPLRMBLONO
	 * @param explrmblono the EXPLRMBLONO value
	 */
	public void setExplrmblono (java.lang.String explrmblono) {
		this.explrmblono = explrmblono;
	}



	/**
	 * Return the value associated with the column: CREDITORCODE
	 */
	public java.lang.String getCreditorcode () {
		return creditorcode;
	}

	/**
	 * Set the value related to the column: CREDITORCODE
	 * @param creditorcode the CREDITORCODE value
	 */
	public void setCreditorcode (java.lang.String creditorcode) {
		this.creditorcode = creditorcode;
	}



	/**
	 * Return the value associated with the column: DEBTORCODE
	 */
	public java.lang.String getDebtorcode () {
		return debtorcode;
	}

	/**
	 * Set the value related to the column: DEBTORCODE
	 * @param debtorcode the DEBTORCODE value
	 */
	public void setDebtorcode (java.lang.String debtorcode) {
		this.debtorcode = debtorcode;
	}



	/**
	 * Return the value associated with the column: DEBTORNAME
	 */
	public java.lang.String getDebtorname () {
		return debtorname;
	}

	/**
	 * Set the value related to the column: DEBTORNAME
	 * @param debtorname the DEBTORNAME value
	 */
	public void setDebtorname (java.lang.String debtorname) {
		this.debtorname = debtorname;
	}



	/**
	 * Return the value associated with the column: VALUEDATE
	 */
	public java.lang.String getValuedate () {
		return valuedate;
	}

	/**
	 * Set the value related to the column: VALUEDATE
	 * @param valuedate the VALUEDATE value
	 */
	public void setValuedate (java.lang.String valuedate) {
		this.valuedate = valuedate;
	}



	/**
	 * Return the value associated with the column: CREDCONCURR
	 */
	public java.lang.String getCredconcurr () {
		return credconcurr;
	}

	/**
	 * Set the value related to the column: CREDCONCURR
	 * @param credconcurr the CREDCONCURR value
	 */
	public void setCredconcurr (java.lang.String credconcurr) {
		this.credconcurr = credconcurr;
	}



	/**
	 * Return the value associated with the column: CREDCONAMOUNT
	 */
	public java.math.BigDecimal getCredconamount () {
		return credconamount;
	}

	/**
	 * Set the value related to the column: CREDCONAMOUNT
	 * @param credconamount the CREDCONAMOUNT value
	 */
	public void setCredconamount (java.math.BigDecimal credconamount) {
		this.credconamount = credconamount;
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
	 * Return the value associated with the column: EXPLCURR
	 */
	public java.lang.String getExplcurr () {
		return explcurr;
	}

	/**
	 * Set the value related to the column: EXPLCURR
	 * @param explcurr the EXPLCURR value
	 */
	public void setExplcurr (java.lang.String explcurr) {
		this.explcurr = explcurr;
	}



	/**
	 * Return the value associated with the column: EXPLAMOUNT
	 */
	public java.math.BigDecimal getExplamount () {
		return explamount;
	}

	/**
	 * Set the value related to the column: EXPLAMOUNT
	 * @param explamount the EXPLAMOUNT value
	 */
	public void setExplamount (java.math.BigDecimal explamount) {
		this.explamount = explamount;
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
	 * Return the value associated with the column: BUOCMONTH
	 */
	public java.lang.String getBuocmonth () {
		return buocmonth;
	}

	/**
	 * Set the value related to the column: BUOCMONTH
	 * @param buocmonth the BUOCMONTH value
	 */
	public void setBuocmonth (java.lang.String buocmonth) {
		this.buocmonth = buocmonth;
	}



	/**
	 * Return the value associated with the column: CHANGENO
	 */
	public java.lang.String getChangeno () {
		return changeno;
	}

	/**
	 * Set the value related to the column: CHANGENO
	 * @param changeno the CHANGENO value
	 */
	public void setChangeno (java.lang.String changeno) {
		this.changeno = changeno;
	}



	/**
	 * Return the value associated with the column: MONBELOADBAL
	 */
	public java.math.BigDecimal getMonbeloadbal () {
		return monbeloadbal;
	}

	/**
	 * Set the value related to the column: MONBELOADBAL
	 * @param monbeloadbal the MONBELOADBAL value
	 */
	public void setMonbeloadbal (java.math.BigDecimal monbeloadbal) {
		this.monbeloadbal = monbeloadbal;
	}



	/**
	 * Return the value associated with the column: CREDWITHAMOUNT
	 */
	public java.math.BigDecimal getCredwithamount () {
		return credwithamount;
	}

	/**
	 * Set the value related to the column: CREDWITHAMOUNT
	 * @param credwithamount the CREDWITHAMOUNT value
	 */
	public void setCredwithamount (java.math.BigDecimal credwithamount) {
		this.credwithamount = credwithamount;
	}



	/**
	 * Return the value associated with the column: CREDREPAYAMOUNT
	 */
	public java.math.BigDecimal getCredrepayamount () {
		return credrepayamount;
	}

	/**
	 * Set the value related to the column: CREDREPAYAMOUNT
	 * @param credrepayamount the CREDREPAYAMOUNT value
	 */
	public void setCredrepayamount (java.math.BigDecimal credrepayamount) {
		this.credrepayamount = credrepayamount;
	}



	/**
	 * Return the value associated with the column: PICAMOUNT
	 */
	public java.math.BigDecimal getPicamount () {
		return picamount;
	}

	/**
	 * Set the value related to the column: PICAMOUNT
	 * @param picamount the PICAMOUNT value
	 */
	public void setPicamount (java.math.BigDecimal picamount) {
		this.picamount = picamount;
	}



	/**
	 * Return the value associated with the column: EXPLBALA
	 */
	public java.math.BigDecimal getExplbala () {
		return explbala;
	}

	/**
	 * Set the value related to the column: EXPLBALA
	 * @param explbala the EXPLBALA value
	 */
	public void setExplbala (java.math.BigDecimal explbala) {
		this.explbala = explbala;
	}



	/**
	 * Return the value associated with the column: EXPLPERAMOUNT
	 */
	public java.math.BigDecimal getExplperamount () {
		return explperamount;
	}

	/**
	 * Set the value related to the column: EXPLPERAMOUNT
	 * @param explperamount the EXPLPERAMOUNT value
	 */
	public void setExplperamount (java.math.BigDecimal explperamount) {
		this.explperamount = explperamount;
	}



	/**
	 * Return the value associated with the column: PLCOSEAMOUNT
	 */
	public java.math.BigDecimal getPlcoseamount () {
		return plcoseamount;
	}

	/**
	 * Set the value related to the column: PLCOSEAMOUNT
	 * @param plcoseamount the PLCOSEAMOUNT value
	 */
	public void setPlcoseamount (java.math.BigDecimal plcoseamount) {
		this.plcoseamount = plcoseamount;
	}



	/**
	 * Return the value associated with the column: MONENLOADBAL
	 */
	public java.math.BigDecimal getMonenloadbal () {
		return monenloadbal;
	}

	/**
	 * Set the value related to the column: MONENLOADBAL
	 * @param monenloadbal the MONENLOADBAL value
	 */
	public void setMonenloadbal (java.math.BigDecimal monenloadbal) {
		this.monenloadbal = monenloadbal;
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

	public String getSubSuccess() {
		return subSuccess;
	}

	public void setSubSuccess(String subSuccess) {
		this.subSuccess = subSuccess;
	}

	public java.lang.String getBuscode() {
		return buscode;
	}

	public void setBuscode(java.lang.String buscode) {
		this.buscode = buscode;
	}

	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof resource.bean.report.BopCfaExplrmbloDs)) return false;
		else {
			resource.bean.report.BopCfaExplrmbloDs bopCfaExplrmbloDs = (resource.bean.report.BopCfaExplrmbloDs) obj;
			if (null == this.getId() || null == bopCfaExplrmbloDs.getId()) return false;
			else return (this.getId().equals(bopCfaExplrmbloDs.getId()));
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