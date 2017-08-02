package resource.bean.report.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the BOP_CFA_EXDEBT_DS table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="BOP_CFA_EXDEBT_DS"
 */

public abstract class BaseBopCfaExdebtDs  implements Serializable {

	public static String REF = "BopCfaExdebtDs";
	public static String PROP_APPCODE = "appcode";
	public static String PROP_EXDEBTCODE = "exdebtcode";
	public static String PROP_FAIRVALUE = "fairvalue";
	public static String PROP_INPRIAMOUNT = "inpriamount";
	public static String PROP_CHAMOUNT = "chamount";
	public static String PROP_BUSCODE = "buscode";
	public static String PROP_WORK_DATE = "workDate";
	public static String PROP_APPROVE_RESULT = "approveResult";
	public static String PROP_APPROVE_STATUS = "approveStatus";
	public static String PROP_LST_UPD_TM = "lstUpdTm";
	public static String PROP_FLOATRATE = "floatrate";
	public static String PROP_ACCOAMOUNT = "accoamount";
	public static String PROP_LST_UPD_TLR = "lstUpdTlr";
	public static String PROP_VALUEDATE = "valuedate";
	public static String PROP_CHANGENO = "changeno";
	public static String PROP_LIMIT_TYPE = "limitType";
	public static String PROP_CONTRACTDATE = "contractdate";
	public static String PROP_CHCURRENCY = "chcurrency";
	public static String PROP_REC_STATUS = "recStatus";
	public static String PROP_MATURITY = "maturity";
	public static String PROP_CONTRACTCURR = "contractcurr";
	public static String PROP_INPRTERM = "inprterm";
	public static String PROP_ACTIONTYPE = "actiontype";
	public static String PROP_DEBTYPE = "debtype";
	public static String PROP_CHANGTYPE = "changtype";
	public static String PROP_SPAPFEBOINDEX = "spapfeboindex";
	public static String PROP_SUB_SUCCESS = "subSuccess";
	public static String PROP_DEBTORCODE = "debtorcode";
	public static String PROP_APPTYPE = "apptype";
	public static String PROP_CHDATE = "chdate";
	public static String PROP_CURRENTFILE = "currentfile";
	public static String PROP_ACTIONDESC = "actiondesc";
	public static String PROP_DEBTYPEREMA = "debtyperema";
	public static String PROP_APPNAME = "appname";
	public static String PROP_ANNINRATE = "anninrate";
	public static String PROP_INLTCABUSCODE = "inltcabuscode";
	public static String PROP_ID = "id";
	public static String PROP_CONTRACTAMOUNT = "contractamount";
	public static String PROP_FILLER1 = "filler1";
	public static String PROP_REMARK = "remark";
	public static String PROP_REP_STATUS = "repStatus";
	public static String PROP_BR_NO = "brNo";
	public static String PROP_FILLER3 = "filler3";
	public static String PROP_CRT_TM = "crtTm";
	public static String PROP_FILLER2 = "filler2";
	public static String PROP_ISINCODE = "isincode";
	public static String PROP_CHANGE_FILE_TYPE="changeFileType";
	public static String PROP_BALANCE_FILE_TYPE="balanceFileType";

	

	// constructors
	public BaseBopCfaExdebtDs () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBopCfaExdebtDs (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseBopCfaExdebtDs (
		java.lang.String id,
		java.lang.String apptype,
		java.lang.String currentfile,
		java.lang.String buscode) {

		this.setId(id);
		this.setApptype(apptype);
		this.setCurrentfile(currentfile);
		this.setBuscode(buscode);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;

	// fields
	private java.lang.String apptype;
	private java.lang.String currentfile;
	private java.lang.String exdebtcode;
	private java.lang.String debtorcode;
	private java.lang.String debtype;
	private java.lang.String debtyperema;
	private java.lang.String contractdate;
	private java.lang.String valuedate;
	private java.lang.String contractcurr;
	private java.math.BigDecimal contractamount;
	private java.lang.String maturity;
	private java.lang.String floatrate;
	private java.math.BigDecimal anninrate;
	private java.lang.String inprterm;
	private java.lang.String spapfeboindex;
	private java.lang.String remark;
	private java.lang.String appcode;
	private java.lang.String appname;
	private java.lang.String inltcabuscode;
	private java.math.BigDecimal inpriamount;
	private java.lang.String isincode;
	private java.lang.String limitType;
	private java.lang.String buscode;
	private java.lang.String changeno;
	private java.lang.String changtype;
	private java.lang.String chdate;
	private java.lang.String chcurrency;
	private java.math.BigDecimal chamount;
	private java.math.BigDecimal fairvalue;
	private java.math.BigDecimal accoamount;
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
	private java.lang.String changeFileType;
	private java.lang.String balanceFileType;




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
	 * Return the value associated with the column: EXDEBTCODE
	 */
	public java.lang.String getExdebtcode () {
		return exdebtcode;
	}

	/**
	 * Set the value related to the column: EXDEBTCODE
	 * @param exdebtcode the EXDEBTCODE value
	 */
	public void setExdebtcode (java.lang.String exdebtcode) {
		this.exdebtcode = exdebtcode;
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
	 * Return the value associated with the column: DEBTYPE
	 */
	public java.lang.String getDebtype () {
		return debtype;
	}

	/**
	 * Set the value related to the column: DEBTYPE
	 * @param debtype the DEBTYPE value
	 */
	public void setDebtype (java.lang.String debtype) {
		this.debtype = debtype;
	}



	/**
	 * Return the value associated with the column: DEBTYPEREMA
	 */
	public java.lang.String getDebtyperema () {
		return debtyperema;
	}

	/**
	 * Set the value related to the column: DEBTYPEREMA
	 * @param debtyperema the DEBTYPEREMA value
	 */
	public void setDebtyperema (java.lang.String debtyperema) {
		this.debtyperema = debtyperema;
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
	 * Return the value associated with the column: CONTRACTCURR
	 */
	public java.lang.String getContractcurr () {
		return contractcurr;
	}

	/**
	 * Set the value related to the column: CONTRACTCURR
	 * @param contractcurr the CONTRACTCURR value
	 */
	public void setContractcurr (java.lang.String contractcurr) {
		this.contractcurr = contractcurr;
	}



	/**
	 * Return the value associated with the column: CONTRACTAMOUNT
	 */
	public java.math.BigDecimal getContractamount () {
		return contractamount;
	}

	/**
	 * Set the value related to the column: CONTRACTAMOUNT
	 * @param contractamount the CONTRACTAMOUNT value
	 */
	public void setContractamount (java.math.BigDecimal contractamount) {
		this.contractamount = contractamount;
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
	 * Return the value associated with the column: FLOATRATE
	 */
	public java.lang.String getFloatrate () {
		return floatrate;
	}

	/**
	 * Set the value related to the column: FLOATRATE
	 * @param floatrate the FLOATRATE value
	 */
	public void setFloatrate (java.lang.String floatrate) {
		this.floatrate = floatrate;
	}



	/**
	 * Return the value associated with the column: ANNINRATE
	 */
	public java.math.BigDecimal getAnninrate () {
		return anninrate;
	}

	/**
	 * Set the value related to the column: ANNINRATE
	 * @param anninrate the ANNINRATE value
	 */
	public void setAnninrate (java.math.BigDecimal anninrate) {
		this.anninrate = anninrate;
	}



	/**
	 * Return the value associated with the column: INPRTERM
	 */
	public java.lang.String getInprterm () {
		return inprterm;
	}

	/**
	 * Set the value related to the column: INPRTERM
	 * @param inprterm the INPRTERM value
	 */
	public void setInprterm (java.lang.String inprterm) {
		this.inprterm = inprterm;
	}



	/**
	 * Return the value associated with the column: SPAPFEBOINDEX
	 */
	public java.lang.String getSpapfeboindex () {
		return spapfeboindex;
	}

	/**
	 * Set the value related to the column: SPAPFEBOINDEX
	 * @param spapfeboindex the SPAPFEBOINDEX value
	 */
	public void setSpapfeboindex (java.lang.String spapfeboindex) {
		this.spapfeboindex = spapfeboindex;
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
	 * Return the value associated with the column: APPCODE
	 */
	public java.lang.String getAppcode () {
		return appcode;
	}

	/**
	 * Set the value related to the column: APPCODE
	 * @param appcode the APPCODE value
	 */
	public void setAppcode (java.lang.String appcode) {
		this.appcode = appcode;
	}



	/**
	 * Return the value associated with the column: APPNAME
	 */
	public java.lang.String getAppname () {
		return appname;
	}

	/**
	 * Set the value related to the column: APPNAME
	 * @param appname the APPNAME value
	 */
	public void setAppname (java.lang.String appname) {
		this.appname = appname;
	}



	/**
	 * Return the value associated with the column: INLTCABUSCODE
	 */
	public java.lang.String getInltcabuscode () {
		return inltcabuscode;
	}

	/**
	 * Set the value related to the column: INLTCABUSCODE
	 * @param inltcabuscode the INLTCABUSCODE value
	 */
	public void setInltcabuscode (java.lang.String inltcabuscode) {
		this.inltcabuscode = inltcabuscode;
	}



	/**
	 * Return the value associated with the column: INPRIAMOUNT
	 */
	public java.math.BigDecimal getInpriamount () {
		return inpriamount;
	}

	/**
	 * Set the value related to the column: INPRIAMOUNT
	 * @param inpriamount the INPRIAMOUNT value
	 */
	public void setInpriamount (java.math.BigDecimal inpriamount) {
		this.inpriamount = inpriamount;
	}



	/**
	 * Return the value associated with the column: ISINCODE
	 */
	public java.lang.String getIsincode () {
		return isincode;
	}

	/**
	 * Set the value related to the column: ISINCODE
	 * @param isincode the ISINCODE value
	 */
	public void setIsincode (java.lang.String isincode) {
		this.isincode = isincode;
	}



	/**
	 * Return the value associated with the column: LIMIT_TYPE
	 */
	public java.lang.String getLimitType () {
		return limitType;
	}

	/**
	 * Set the value related to the column: LIMIT_TYPE
	 * @param limitType the LIMIT_TYPE value
	 */
	public void setLimitType (java.lang.String limitType) {
		this.limitType = limitType;
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
	 * Return the value associated with the column: CHANGTYPE
	 */
	public java.lang.String getChangtype () {
		return changtype;
	}

	/**
	 * Set the value related to the column: CHANGTYPE
	 * @param changtype the CHANGTYPE value
	 */
	public void setChangtype (java.lang.String changtype) {
		this.changtype = changtype;
	}



	/**
	 * Return the value associated with the column: CHDATE
	 */
	public java.lang.String getChdate () {
		return chdate;
	}

	/**
	 * Set the value related to the column: CHDATE
	 * @param chdate the CHDATE value
	 */
	public void setChdate (java.lang.String chdate) {
		this.chdate = chdate;
	}



	/**
	 * Return the value associated with the column: CHCURRENCY
	 */
	public java.lang.String getChcurrency () {
		return chcurrency;
	}

	/**
	 * Set the value related to the column: CHCURRENCY
	 * @param chcurrency the CHCURRENCY value
	 */
	public void setChcurrency (java.lang.String chcurrency) {
		this.chcurrency = chcurrency;
	}



	/**
	 * Return the value associated with the column: CHAMOUNT
	 */
	public java.math.BigDecimal getChamount () {
		return chamount;
	}

	/**
	 * Set the value related to the column: CHAMOUNT
	 * @param chamount the CHAMOUNT value
	 */
	public void setChamount (java.math.BigDecimal chamount) {
		this.chamount = chamount;
	}



	/**
	 * Return the value associated with the column: FAIRVALUE
	 */
	public java.math.BigDecimal getFairvalue () {
		return fairvalue;
	}

	/**
	 * Set the value related to the column: FAIRVALUE
	 * @param fairvalue the FAIRVALUE value
	 */
	public void setFairvalue (java.math.BigDecimal fairvalue) {
		this.fairvalue = fairvalue;
	}



	/**
	 * Return the value associated with the column: ACCOAMOUNT
	 */
	public java.math.BigDecimal getAccoamount () {
		return accoamount;
	}

	/**
	 * Set the value related to the column: ACCOAMOUNT
	 * @param accoamount the ACCOAMOUNT value
	 */
	public void setAccoamount (java.math.BigDecimal accoamount) {
		this.accoamount = accoamount;
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

	public java.lang.String getChangeFileType() {
		return changeFileType;
	}

	public void setChangeFileType(java.lang.String changeFileType) {
		this.changeFileType = changeFileType;
	}

	public java.lang.String getBalanceFileType() {
		return balanceFileType;
	}

	public void setBalanceFileType(java.lang.String balanceFileType) {
		this.balanceFileType = balanceFileType;
	}

	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof resource.bean.report.BopCfaExdebtDs)) return false;
		else {
			resource.bean.report.BopCfaExdebtDs bopCfaExdebtDs = (resource.bean.report.BopCfaExdebtDs) obj;
			if (null == this.getId() || null == bopCfaExdebtDs.getId()) return false;
			else return (this.getId().equals(bopCfaExdebtDs.getId()));
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