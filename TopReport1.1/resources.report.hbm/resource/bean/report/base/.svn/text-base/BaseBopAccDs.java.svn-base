package resource.bean.report.base;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * This is an object that contains data related to the BOP_ACC_DS table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="BOP_ACC_DS"
 */

public abstract class BaseBopAccDs  implements Serializable {

	public static String REF = "BopAccDs";
	public static String PROP_ACCOUNTNO = "accountno";
	public static String PROP_FILE_NUMBER = "fileNumber";
	public static String PROP_ACCOUNTSTAT = "accountstat";
	public static String PROP_DEAL_DATE = "dealDate";
	public static String PROP_CREDIT = "credit";
	public static String PROP_AMTYPE = "amtype";
	public static String PROP_BRANCH_CODE = "branchCode";
	public static String PROP_WORK_DATE = "workDate";
	public static String PROP_REMARK2 = "remark2";
	public static String PROP_APPROVE_RESULT = "approveResult";
	public static String PROP_APPROVE_STATUS = "approveStatus";
	public static String PROP_REMARK1 = "remark1";
	public static String PROP_LST_UPD_TM = "lstUpdTm";
	public static String PROP_BRANCH_NAME = "branchName";
	public static String PROP_LST_UPD_TLR = "lstUpdTlr";
	public static String PROP_LIMIT_TYPE = "limitType";
	public static String PROP_REC_STATUS = "recStatus";
	public static String PROP_EN_NAME = "enName";
	public static String PROP_ACTIONTYPE = "actiontype";
	public static String PROP_EN_CODE = "enCode";
	public static String PROP_BALANCE = "balance";
	public static String PROP_ACCOUNT_TYPE = "accountType";
	public static String PROP_ACCOUNT_CATA = "accountCata";
	public static String PROP_SUB_SUCCESS = "subSuccess";
	public static String PROP_BUSINESS_DATE = "businessDate";
	public static String PROP_APPTYPE = "apptype";
	public static String PROP_CURRENCY_CODE = "currencyCode";
	public static String PROP_ACCOUNT_LIMIT = "accountLimit";
	public static String PROP_CURRENTFILE = "currentfile";
	public static String PROP_ACTIONDESC = "actiondesc";
	public static String PROP_ID = "id";
	public static String PROP_FILLER1 = "filler1";
	public static String PROP_REP_STATUS = "repStatus";
	public static String PROP_BR_NO = "brNo";
	public static String PROP_FILLER3 = "filler3";
	public static String PROP_DEBIT = "debit";
	public static String PROP_CRT_TM = "crtTm";
	public static String PROP_FILLER2 = "filler2";


	// constructors
	public BaseBopAccDs () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBopAccDs (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseBopAccDs (
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
	private java.lang.String branchCode;
	private java.lang.String branchName;
	private java.lang.String accountno;
	private java.lang.String accountstat;
	private java.lang.String amtype;
	private java.lang.String enCode;
	private java.lang.String enName;
	private java.lang.String accountType;
	private java.lang.String accountCata;
	private java.lang.String currencyCode;
	private java.lang.String businessDate;
	private java.lang.String fileNumber;
	private java.lang.String limitType;
	private java.math.BigDecimal accountLimit;
	private java.lang.String remark1;
	private java.lang.String dealDate;
	private java.math.BigDecimal credit;
	private java.math.BigDecimal debit;
	private java.math.BigDecimal balance;
	private java.lang.String remark2;
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



	public BaseBopAccDs(String id,String accountno, String accountstat, String amtype,
			String enCode, String enName, String accountType,
			String accountCata, String currencyCode, String businessDate,
			String fileNumber, String limitType, BigDecimal accountLimit,
			String workDate) {
		super();
		this.id = id;
		this.accountno = accountno;
		this.accountstat = accountstat;
		this.amtype = amtype;
		this.enCode = enCode;
		this.enName = enName;
		this.accountType = accountType;
		this.accountCata = accountCata;
		this.currencyCode = currencyCode;
		this.businessDate = businessDate;
		this.fileNumber = fileNumber;
		this.limitType = limitType;
		this.accountLimit = accountLimit;
		this.workDate = workDate;
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
	 * Return the value associated with the column: BRANCH_CODE
	 */
	public java.lang.String getBranchCode () {
		return branchCode;
	}

	/**
	 * Set the value related to the column: BRANCH_CODE
	 * @param branchCode the BRANCH_CODE value
	 */
	public void setBranchCode (java.lang.String branchCode) {
		this.branchCode = branchCode;
	}



	/**
	 * Return the value associated with the column: BRANCH_NAME
	 */
	public java.lang.String getBranchName () {
		return branchName;
	}

	/**
	 * Set the value related to the column: BRANCH_NAME
	 * @param branchName the BRANCH_NAME value
	 */
	public void setBranchName (java.lang.String branchName) {
		this.branchName = branchName;
	}



	/**
	 * Return the value associated with the column: ACCOUNTNO
	 */
	public java.lang.String getAccountno () {
		return accountno;
	}

	/**
	 * Set the value related to the column: ACCOUNTNO
	 * @param accountno the ACCOUNTNO value
	 */
	public void setAccountno (java.lang.String accountno) {
		this.accountno = accountno;
	}



	/**
	 * Return the value associated with the column: ACCOUNTSTAT
	 */
	public java.lang.String getAccountstat () {
		return accountstat;
	}

	/**
	 * Set the value related to the column: ACCOUNTSTAT
	 * @param accountstat the ACCOUNTSTAT value
	 */
	public void setAccountstat (java.lang.String accountstat) {
		this.accountstat = accountstat;
	}



	/**
	 * Return the value associated with the column: AMTYPE
	 */
	public java.lang.String getAmtype () {
		return amtype;
	}

	/**
	 * Set the value related to the column: AMTYPE
	 * @param amtype the AMTYPE value
	 */
	public void setAmtype (java.lang.String amtype) {
		this.amtype = amtype;
	}



	/**
	 * Return the value associated with the column: EN_CODE
	 */
	public java.lang.String getEnCode () {
		return enCode;
	}

	/**
	 * Set the value related to the column: EN_CODE
	 * @param enCode the EN_CODE value
	 */
	public void setEnCode (java.lang.String enCode) {
		this.enCode = enCode;
	}



	/**
	 * Return the value associated with the column: EN_NAME
	 */
	public java.lang.String getEnName () {
		return enName;
	}

	/**
	 * Set the value related to the column: EN_NAME
	 * @param enName the EN_NAME value
	 */
	public void setEnName (java.lang.String enName) {
		this.enName = enName;
	}



	/**
	 * Return the value associated with the column: ACCOUNT_TYPE
	 */
	public java.lang.String getAccountType () {
		return accountType;
	}

	/**
	 * Set the value related to the column: ACCOUNT_TYPE
	 * @param accountType the ACCOUNT_TYPE value
	 */
	public void setAccountType (java.lang.String accountType) {
		this.accountType = accountType;
	}



	/**
	 * Return the value associated with the column: ACCOUNT_CATA
	 */
	public java.lang.String getAccountCata () {
		return accountCata;
	}

	/**
	 * Set the value related to the column: ACCOUNT_CATA
	 * @param accountCata the ACCOUNT_CATA value
	 */
	public void setAccountCata (java.lang.String accountCata) {
		this.accountCata = accountCata;
	}



	/**
	 * Return the value associated with the column: CURRENCY_CODE
	 */
	public java.lang.String getCurrencyCode () {
		return currencyCode;
	}

	/**
	 * Set the value related to the column: CURRENCY_CODE
	 * @param currencyCode the CURRENCY_CODE value
	 */
	public void setCurrencyCode (java.lang.String currencyCode) {
		this.currencyCode = currencyCode;
	}



	/**
	 * Return the value associated with the column: BUSINESS_DATE
	 */
	public java.lang.String getBusinessDate () {
		return businessDate;
	}

	/**
	 * Set the value related to the column: BUSINESS_DATE
	 * @param businessDate the BUSINESS_DATE value
	 */
	public void setBusinessDate (java.lang.String businessDate) {
		this.businessDate = businessDate;
	}



	/**
	 * Return the value associated with the column: FILE_NUMBER
	 */
	public java.lang.String getFileNumber () {
		return fileNumber;
	}

	/**
	 * Set the value related to the column: FILE_NUMBER
	 * @param fileNumber the FILE_NUMBER value
	 */
	public void setFileNumber (java.lang.String fileNumber) {
		this.fileNumber = fileNumber;
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
	 * Return the value associated with the column: ACCOUNT_LIMIT
	 */
	public java.math.BigDecimal getAccountLimit () {
		return accountLimit;
	}

	/**
	 * Set the value related to the column: ACCOUNT_LIMIT
	 * @param accountLimit the ACCOUNT_LIMIT value
	 */
	public void setAccountLimit (java.math.BigDecimal accountLimit) {
		this.accountLimit = accountLimit;
	}



	/**
	 * Return the value associated with the column: REMARK1
	 */
	public java.lang.String getRemark1 () {
		return remark1;
	}

	/**
	 * Set the value related to the column: REMARK1
	 * @param remark1 the REMARK1 value
	 */
	public void setRemark1 (java.lang.String remark1) {
		this.remark1 = remark1;
	}



	/**
	 * Return the value associated with the column: DEAL_DATE
	 */
	public java.lang.String getDealDate () {
		return dealDate;
	}

	/**
	 * Set the value related to the column: DEAL_DATE
	 * @param dealDate the DEAL_DATE value
	 */
	public void setDealDate (java.lang.String dealDate) {
		this.dealDate = dealDate;
	}



	/**
	 * Return the value associated with the column: CREDIT
	 */
	public java.math.BigDecimal getCredit () {
		return credit;
	}

	/**
	 * Set the value related to the column: CREDIT
	 * @param credit the CREDIT value
	 */
	public void setCredit (java.math.BigDecimal credit) {
		this.credit = credit;
	}



	/**
	 * Return the value associated with the column: DEBIT
	 */
	public java.math.BigDecimal getDebit () {
		return debit;
	}

	/**
	 * Set the value related to the column: DEBIT
	 * @param debit the DEBIT value
	 */
	public void setDebit (java.math.BigDecimal debit) {
		this.debit = debit;
	}



	/**
	 * Return the value associated with the column: BALANCE
	 */
	public java.math.BigDecimal getBalance () {
		return balance;
	}

	/**
	 * Set the value related to the column: BALANCE
	 * @param balance the BALANCE value
	 */
	public void setBalance (java.math.BigDecimal balance) {
		this.balance = balance;
	}



	/**
	 * Return the value associated with the column: REMARK2
	 */
	public java.lang.String getRemark2 () {
		return remark2;
	}

	/**
	 * Set the value related to the column: REMARK2
	 * @param remark2 the REMARK2 value
	 */
	public void setRemark2 (java.lang.String remark2) {
		this.remark2 = remark2;
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
		if (!(obj instanceof resource.bean.report.BopAccDs)) return false;
		else {
			resource.bean.report.BopAccDs bopAccDs = (resource.bean.report.BopAccDs) obj;
			if (null == this.getId() || null == bopAccDs.getId()) return false;
			else return (this.getId().equals(bopAccDs.getId()));
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