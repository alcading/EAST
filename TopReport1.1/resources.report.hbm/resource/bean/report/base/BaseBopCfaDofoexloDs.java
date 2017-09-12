package resource.bean.report.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the BOP_CFA_DOFOEXLO_DS table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="BOP_CFA_DOFOEXLO_DS"
 */

public abstract class BaseBopCfaDofoexloDs  implements Serializable {

	public static String REF = "BopCfaDofoexloDs";
	public static String PROP_WITHCURRENCE = "withcurrence";
	public static String PROP_INPAYAMOUNT = "inpayamount";
	public static String PROP_WITHAMOUNT = "withamount";
	public static String PROP_CHANGEDATE = "changedate";
	public static String PROP_PRINCURR = "princurr";
	public static String PROP_DOFOEXLOCODE = "dofoexlocode";
	public static String PROP_BUSCODE = "buscode";
	public static String PROP_WORK_DATE = "workDate";
	public static String PROP_SETTAMOUNT = "settamount";
	public static String PROP_APPROVE_RESULT = "approveResult";
	public static String PROP_CREDITORCODE = "creditorcode";
	public static String PROP_APPROVE_STATUS = "approveStatus";
	public static String PROP_LST_UPD_TM = "lstUpdTm";
	public static String PROP_DEBTORNAME = "debtorname";
	public static String PROP_LST_UPD_TLR = "lstUpdTlr";
	public static String PROP_VALUEDATE = "valuedate";
	public static String PROP_CHANGENO = "changeno";
	public static String PROP_PINPAYAMOUNT = "pinpayamount";
	public static String PROP_LOANOPENBALAN = "loanopenbalan";
	public static String PROP_REC_STATUS = "recStatus";
	public static String PROP_MATURITY = "maturity";
	public static String PROP_ACTIONTYPE = "actiontype";
	public static String PROP_ENDBALAN = "endbalan";
	public static String PROP_REPAYAMOUNT = "repayamount";
	public static String PROP_LENPRONAME = "lenproname";
	public static String PROP_SUB_SUCCESS = "subSuccess";
	public static String PROP_INPAYCURR = "inpaycurr";
	public static String PROP_LENAGREE = "lenagree";
	public static String PROP_DEBTORCODE = "debtorcode";
	public static String PROP_APPTYPE = "apptype";
	public static String PROP_CURRENTFILE = "currentfile";
	public static String PROP_ACTIONDESC = "actiondesc";
	public static String PROP_USEOFUNDS = "useofunds";
	public static String PROP_CURRENCE = "currence";
	public static String PROP_DOFOEXLOTYPE = "dofoexlotype";
	public static String PROP_ANNINRATE = "anninrate";
	public static String PROP_ID = "id";
	public static String PROP_CONTRACTAMOUNT = "contractamount";
	public static String PROP_FILLER1 = "filler1";
	public static String PROP_PREPAYAMOUNT = "prepayamount";
	public static String PROP_REMARK = "remark";
	public static String PROP_REP_STATUS = "repStatus";
	public static String PROP_BR_NO = "brNo";
	public static String PROP_FILLER3 = "filler3";
	public static String PROP_CRT_TM = "crtTm";
	public static String PROP_FILLER2 = "filler2";


	// constructors
	public BaseBopCfaDofoexloDs () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBopCfaDofoexloDs (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseBopCfaDofoexloDs (
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
	private java.lang.String dofoexlocode;
	private java.lang.String creditorcode;
	private java.lang.String debtorcode;
	private java.lang.String debtorname;
	private java.lang.String dofoexlotype;
	private java.lang.String lenproname;
	private java.lang.String lenagree;
	private java.lang.String valuedate;
	private java.lang.String maturity;
	private java.lang.String currence;
	private java.math.BigDecimal contractamount;
	private java.math.BigDecimal anninrate;
	private java.lang.String remark;
	private java.lang.String buscode;
	private java.lang.String changeno;
	private java.math.BigDecimal loanopenbalan;
	private java.lang.String changedate;
	private java.lang.String withcurrence;
	private java.math.BigDecimal withamount;
	private java.math.BigDecimal settamount;
	private java.lang.String useofunds;
	private java.lang.String princurr;
	private java.math.BigDecimal repayamount;
	private java.math.BigDecimal prepayamount;
	private java.lang.String inpaycurr;
	private java.math.BigDecimal inpayamount;
	private java.math.BigDecimal pinpayamount;
	private java.math.BigDecimal endbalan;
	private java.lang.String lstUpdTlr;
	private java.util.Date lstUpdTm;
	private java.util.Date  crtTm;
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
	 * Return the value associated with the column: DOFOEXLOCODE
	 */
	public java.lang.String getDofoexlocode () {
		return dofoexlocode;
	}

	/**
	 * Set the value related to the column: DOFOEXLOCODE
	 * @param dofoexlocode the DOFOEXLOCODE value
	 */
	public void setDofoexlocode (java.lang.String dofoexlocode) {
		this.dofoexlocode = dofoexlocode;
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
	 * Return the value associated with the column: DOFOEXLOTYPE
	 */
	public java.lang.String getDofoexlotype () {
		return dofoexlotype;
	}

	/**
	 * Set the value related to the column: DOFOEXLOTYPE
	 * @param dofoexlotype the DOFOEXLOTYPE value
	 */
	public void setDofoexlotype (java.lang.String dofoexlotype) {
		this.dofoexlotype = dofoexlotype;
	}



	/**
	 * Return the value associated with the column: LENPRONAME
	 */
	public java.lang.String getLenproname () {
		return lenproname;
	}

	/**
	 * Set the value related to the column: LENPRONAME
	 * @param lenproname the LENPRONAME value
	 */
	public void setLenproname (java.lang.String lenproname) {
		this.lenproname = lenproname;
	}



	/**
	 * Return the value associated with the column: LENAGREE
	 */
	public java.lang.String getLenagree () {
		return lenagree;
	}

	/**
	 * Set the value related to the column: LENAGREE
	 * @param lenagree the LENAGREE value
	 */
	public void setLenagree (java.lang.String lenagree) {
		this.lenagree = lenagree;
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
	 * Return the value associated with the column: CURRENCE
	 */
	public java.lang.String getCurrence () {
		return currence;
	}

	/**
	 * Set the value related to the column: CURRENCE
	 * @param currence the CURRENCE value
	 */
	public void setCurrence (java.lang.String currence) {
		this.currence = currence;
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
	 * Return the value associated with the column: LOANOPENBALAN
	 */
	public java.math.BigDecimal getLoanopenbalan () {
		return loanopenbalan;
	}

	/**
	 * Set the value related to the column: LOANOPENBALAN
	 * @param loanopenbalan the LOANOPENBALAN value
	 */
	public void setLoanopenbalan (java.math.BigDecimal loanopenbalan) {
		this.loanopenbalan = loanopenbalan;
	}



	/**
	 * Return the value associated with the column: CHANGEDATE
	 */
	public java.lang.String getChangedate () {
		return changedate;
	}

	/**
	 * Set the value related to the column: CHANGEDATE
	 * @param changedate the CHANGEDATE value
	 */
	public void setChangedate (java.lang.String changedate) {
		this.changedate = changedate;
	}



	/**
	 * Return the value associated with the column: WITHCURRENCE
	 */
	public java.lang.String getWithcurrence () {
		return withcurrence;
	}

	/**
	 * Set the value related to the column: WITHCURRENCE
	 * @param withcurrence the WITHCURRENCE value
	 */
	public void setWithcurrence (java.lang.String withcurrence) {
		this.withcurrence = withcurrence;
	}



	/**
	 * Return the value associated with the column: WITHAMOUNT
	 */
	public java.math.BigDecimal getWithamount () {
		return withamount;
	}

	/**
	 * Set the value related to the column: WITHAMOUNT
	 * @param withamount the WITHAMOUNT value
	 */
	public void setWithamount (java.math.BigDecimal withamount) {
		this.withamount = withamount;
	}



	/**
	 * Return the value associated with the column: SETTAMOUNT
	 */
	public java.math.BigDecimal getSettamount () {
		return settamount;
	}

	/**
	 * Set the value related to the column: SETTAMOUNT
	 * @param settamount the SETTAMOUNT value
	 */
	public void setSettamount (java.math.BigDecimal settamount) {
		this.settamount = settamount;
	}



	/**
	 * Return the value associated with the column: USEOFUNDS
	 */
	public java.lang.String getUseofunds () {
		return useofunds;
	}

	/**
	 * Set the value related to the column: USEOFUNDS
	 * @param useofunds the USEOFUNDS value
	 */
	public void setUseofunds (java.lang.String useofunds) {
		this.useofunds = useofunds;
	}



	/**
	 * Return the value associated with the column: PRINCURR
	 */
	public java.lang.String getPrincurr () {
		return princurr;
	}

	/**
	 * Set the value related to the column: PRINCURR
	 * @param princurr the PRINCURR value
	 */
	public void setPrincurr (java.lang.String princurr) {
		this.princurr = princurr;
	}



	/**
	 * Return the value associated with the column: REPAYAMOUNT
	 */
	public java.math.BigDecimal getRepayamount () {
		return repayamount;
	}

	/**
	 * Set the value related to the column: REPAYAMOUNT
	 * @param repayamount the REPAYAMOUNT value
	 */
	public void setRepayamount (java.math.BigDecimal repayamount) {
		this.repayamount = repayamount;
	}



	/**
	 * Return the value associated with the column: PREPAYAMOUNT
	 */
	public java.math.BigDecimal getPrepayamount () {
		return prepayamount;
	}

	/**
	 * Set the value related to the column: PREPAYAMOUNT
	 * @param prepayamount the PREPAYAMOUNT value
	 */
	public void setPrepayamount (java.math.BigDecimal prepayamount) {
		this.prepayamount = prepayamount;
	}



	/**
	 * Return the value associated with the column: INPAYCURR
	 */
	public java.lang.String getInpaycurr () {
		return inpaycurr;
	}

	/**
	 * Set the value related to the column: INPAYCURR
	 * @param inpaycurr the INPAYCURR value
	 */
	public void setInpaycurr (java.lang.String inpaycurr) {
		this.inpaycurr = inpaycurr;
	}



	/**
	 * Return the value associated with the column: INPAYAMOUNT
	 */
	public java.math.BigDecimal getInpayamount () {
		return inpayamount;
	}

	/**
	 * Set the value related to the column: INPAYAMOUNT
	 * @param inpayamount the INPAYAMOUNT value
	 */
	public void setInpayamount (java.math.BigDecimal inpayamount) {
		this.inpayamount = inpayamount;
	}



	/**
	 * Return the value associated with the column: PINPAYAMOUNT
	 */
	public java.math.BigDecimal getPinpayamount () {
		return pinpayamount;
	}

	/**
	 * Set the value related to the column: PINPAYAMOUNT
	 * @param pinpayamount the PINPAYAMOUNT value
	 */
	public void setPinpayamount (java.math.BigDecimal pinpayamount) {
		this.pinpayamount = pinpayamount;
	}



	/**
	 * Return the value associated with the column: ENDBALAN
	 */
	public java.math.BigDecimal getEndbalan () {
		return endbalan;
	}

	/**
	 * Set the value related to the column: ENDBALAN
	 * @param endbalan the ENDBALAN value
	 */
	public void setEndbalan (java.math.BigDecimal endbalan) {
		this.endbalan = endbalan;
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

	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof resource.bean.report.BopCfaDofoexloDs)) return false;
		else {
			resource.bean.report.BopCfaDofoexloDs bopCfaDofoexloDs = (resource.bean.report.BopCfaDofoexloDs) obj;
			if (null == this.getId() || null == bopCfaDofoexloDs.getId()) return false;
			else return (this.getId().equals(bopCfaDofoexloDs.getId()));
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