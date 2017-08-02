package resource.bean.report.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the BOP_CFA_STRDE_DS table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="BOP_CFA_STRDE_DS"
 */

public abstract class BaseBopCfaStrdeDs  implements Serializable {

	public static String REF = "BopCfaStrdeDs";
	public static String PROP_TERPAYAMTORMB = "terpayamtormb";
	public static String PROP_TERPAYCODE = "terpaycode";
	public static String PROP_APPROVE_RESULT = "approveResult";
	public static String PROP_BRANCHCODE = "branchcode";
	public static String PROP_LST_UPD_TLR = "lstUpdTlr";
	public static String PROP_TERPAYCURR = "terpaycurr";
	public static String PROP_TERPAYCURRAM = "terpaycurram";
	public static String PROP_REC_STATUS = "recStatus";
	public static String PROP_TERDATE = "terdate";
	public static String PROP_CURRENCY = "currency";
	public static String PROP_ACTIONTYPE = "actiontype";
	public static String PROP_AGINRALOINPAY = "aginraloinpay";
	public static String PROP_INPAYCURR = "inpaycurr";
	public static String PROP_SUB_SUCCESS = "subSuccess";
	public static String PROP_APPTYPE = "apptype";
	public static String PROP_MOEXAMUSD = "moexamusd";
	public static String PROP_ACTIONDESC = "actiondesc";
	public static String PROP_ID = "id";
	public static String PROP_CONTRACTAMOUNT = "contractamount";
	public static String PROP_FILLER1 = "filler1";
	public static String PROP_INPAYCODE = "inpaycode";
	public static String PROP_REP_STATUS = "repStatus";
	public static String PROP_FILLER3 = "filler3";
	public static String PROP_BR_NO = "brNo";
	public static String PROP_FILLER2 = "filler2";
	public static String PROP_BUOCMONTH = "buocmonth";
	public static String PROP_WORK_DATE = "workDate";
	public static String PROP_STRDECODE = "strdecode";
	public static String PROP_CLIENTCODE = "clientcode";
	public static String PROP_LST_UPD_TM = "lstUpdTm";
	public static String PROP_APPROVE_STATUS = "approveStatus";
	public static String PROP_MOAMREUSD = "moamreusd";
	public static String PROP_INPAYRMBAM = "inpayrmbam";
	public static String PROP_CONTRACTDATE = "contractdate";
	public static String PROP_TERTYPE = "tertype";
	public static String PROP_MATURITY = "maturity";
	public static String PROP_LINCAME = "lincame";
	public static String PROP_AGINRALO = "aginralo";
	public static String PROP_MOPFEXAMUSD = "mopfexamusd";
	public static String PROP_TERRMBPAYAM = "terrmbpayam";
	public static String PROP_LINCAMETHOD = "lincamethod";
	public static String PROP_AGINRAUP = "aginraup";
	public static String PROP_MOSETTAMUSD = "mosettamusd";
	public static String PROP_CONTRACT = "contract";
	public static String PROP_CURRENTFILE = "currentfile";
	public static String PROP_CLIENTNAME = "clientname";
	public static String PROP_INPAYCURRAM = "inpaycurram";
	public static String PROP_REMARK = "remark";
	public static String PROP_CRT_TM = "crtTm";
	public static String PROP_INPAYMONTH = "inpaymonth";


	// constructors
	public BaseBopCfaStrdeDs () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBopCfaStrdeDs (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseBopCfaStrdeDs (
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
	private java.lang.String strdecode;
	private java.lang.String branchcode;
	private java.lang.String clientcode;
	private java.lang.String clientname;
	private java.lang.String contractdate;
	private java.lang.String contract;
	private java.math.BigDecimal contractamount;
	private java.lang.String maturity;
	private java.lang.String lincame;
	private java.lang.String lincamethod;
	private java.math.BigDecimal aginraup;
	private java.math.BigDecimal aginralo;
	private java.lang.String aginraloinpay;
	private java.lang.String terdate;
	private java.lang.String tertype;
	private java.lang.String remark;
	private java.lang.String terpaycode;
	private java.math.BigDecimal terpayamtormb;
	private java.math.BigDecimal terrmbpayam;
	private java.lang.String terpaycurr;
	private java.math.BigDecimal terpaycurram;
	private java.lang.String inpaycode;
	private java.lang.String inpaymonth;
	private java.math.BigDecimal inpayrmbam;
	private java.lang.String inpaycurr;
	private java.math.BigDecimal inpaycurram;
	private java.lang.String buocmonth;
	private java.lang.String currency;
	private java.math.BigDecimal moexamusd;
	private java.math.BigDecimal moamreusd;
	private java.math.BigDecimal mosettamusd;
	private java.math.BigDecimal mopfexamusd;
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
	 * Return the value associated with the column: STRDECODE
	 */
	public java.lang.String getStrdecode () {
		return strdecode;
	}

	/**
	 * Set the value related to the column: STRDECODE
	 * @param strdecode the STRDECODE value
	 */
	public void setStrdecode (java.lang.String strdecode) {
		this.strdecode = strdecode;
	}



	/**
	 * Return the value associated with the column: BRANCHCODE
	 */
	public java.lang.String getBranchcode () {
		return branchcode;
	}

	/**
	 * Set the value related to the column: BRANCHCODE
	 * @param branchcode the BRANCHCODE value
	 */
	public void setBranchcode (java.lang.String branchcode) {
		this.branchcode = branchcode;
	}



	/**
	 * Return the value associated with the column: CLIENTCODE
	 */
	public java.lang.String getClientcode () {
		return clientcode;
	}

	/**
	 * Set the value related to the column: CLIENTCODE
	 * @param clientcode the CLIENTCODE value
	 */
	public void setClientcode (java.lang.String clientcode) {
		this.clientcode = clientcode;
	}



	/**
	 * Return the value associated with the column: CLIENTNAME
	 */
	public java.lang.String getClientname () {
		return clientname;
	}

	/**
	 * Set the value related to the column: CLIENTNAME
	 * @param clientname the CLIENTNAME value
	 */
	public void setClientname (java.lang.String clientname) {
		this.clientname = clientname;
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
	 * Return the value associated with the column: CONTRACT
	 */
	public java.lang.String getContract () {
		return contract;
	}

	/**
	 * Set the value related to the column: CONTRACT
	 * @param contract the CONTRACT value
	 */
	public void setContract (java.lang.String contract) {
		this.contract = contract;
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
	 * Return the value associated with the column: LINCAME
	 */
	public java.lang.String getLincame () {
		return lincame;
	}

	/**
	 * Set the value related to the column: LINCAME
	 * @param lincame the LINCAME value
	 */
	public void setLincame (java.lang.String lincame) {
		this.lincame = lincame;
	}



	/**
	 * Return the value associated with the column: LINCAMETHOD
	 */
	public java.lang.String getLincamethod () {
		return lincamethod;
	}

	/**
	 * Set the value related to the column: LINCAMETHOD
	 * @param lincamethod the LINCAMETHOD value
	 */
	public void setLincamethod (java.lang.String lincamethod) {
		this.lincamethod = lincamethod;
	}



	/**
	 * Return the value associated with the column: AGINRAUP
	 */
	public java.math.BigDecimal getAginraup () {
		return aginraup;
	}

	/**
	 * Set the value related to the column: AGINRAUP
	 * @param aginraup the AGINRAUP value
	 */
	public void setAginraup (java.math.BigDecimal aginraup) {
		this.aginraup = aginraup;
	}



	/**
	 * Return the value associated with the column: AGINRALO
	 */
	public java.math.BigDecimal getAginralo () {
		return aginralo;
	}

	/**
	 * Set the value related to the column: AGINRALO
	 * @param aginralo the AGINRALO value
	 */
	public void setAginralo (java.math.BigDecimal aginralo) {
		this.aginralo = aginralo;
	}



	/**
	 * Return the value associated with the column: AGINRALOINPAY
	 */
	public java.lang.String getAginraloinpay () {
		return aginraloinpay;
	}

	/**
	 * Set the value related to the column: AGINRALOINPAY
	 * @param aginraloinpay the AGINRALOINPAY value
	 */
	public void setAginraloinpay (java.lang.String aginraloinpay) {
		this.aginraloinpay = aginraloinpay;
	}



	/**
	 * Return the value associated with the column: TERDATE
	 */
	public java.lang.String getTerdate () {
		return terdate;
	}

	/**
	 * Set the value related to the column: TERDATE
	 * @param terdate the TERDATE value
	 */
	public void setTerdate (java.lang.String terdate) {
		this.terdate = terdate;
	}



	/**
	 * Return the value associated with the column: TERTYPE
	 */
	public java.lang.String getTertype () {
		return tertype;
	}

	/**
	 * Set the value related to the column: TERTYPE
	 * @param tertype the TERTYPE value
	 */
	public void setTertype (java.lang.String tertype) {
		this.tertype = tertype;
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
	 * Return the value associated with the column: TERPAYCODE
	 */
	public java.lang.String getTerpaycode () {
		return terpaycode;
	}

	/**
	 * Set the value related to the column: TERPAYCODE
	 * @param terpaycode the TERPAYCODE value
	 */
	public void setTerpaycode (java.lang.String terpaycode) {
		this.terpaycode = terpaycode;
	}



	/**
	 * Return the value associated with the column: TERPAYAMTORMB
	 */
	public java.math.BigDecimal getTerpayamtormb () {
		return terpayamtormb;
	}

	/**
	 * Set the value related to the column: TERPAYAMTORMB
	 * @param terpayamtormb the TERPAYAMTORMB value
	 */
	public void setTerpayamtormb (java.math.BigDecimal terpayamtormb) {
		this.terpayamtormb = terpayamtormb;
	}



	/**
	 * Return the value associated with the column: TERRMBPAYAM
	 */
	public java.math.BigDecimal getTerrmbpayam () {
		return terrmbpayam;
	}

	/**
	 * Set the value related to the column: TERRMBPAYAM
	 * @param terrmbpayam the TERRMBPAYAM value
	 */
	public void setTerrmbpayam (java.math.BigDecimal terrmbpayam) {
		this.terrmbpayam = terrmbpayam;
	}



	/**
	 * Return the value associated with the column: TERPAYCURR
	 */
	public java.lang.String getTerpaycurr () {
		return terpaycurr;
	}

	/**
	 * Set the value related to the column: TERPAYCURR
	 * @param terpaycurr the TERPAYCURR value
	 */
	public void setTerpaycurr (java.lang.String terpaycurr) {
		this.terpaycurr = terpaycurr;
	}



	/**
	 * Return the value associated with the column: TERPAYCURRAM
	 */
	public java.math.BigDecimal getTerpaycurram () {
		return terpaycurram;
	}

	/**
	 * Set the value related to the column: TERPAYCURRAM
	 * @param terpaycurram the TERPAYCURRAM value
	 */
	public void setTerpaycurram (java.math.BigDecimal terpaycurram) {
		this.terpaycurram = terpaycurram;
	}



	/**
	 * Return the value associated with the column: INPAYCODE
	 */
	public java.lang.String getInpaycode () {
		return inpaycode;
	}

	/**
	 * Set the value related to the column: INPAYCODE
	 * @param inpaycode the INPAYCODE value
	 */
	public void setInpaycode (java.lang.String inpaycode) {
		this.inpaycode = inpaycode;
	}



	/**
	 * Return the value associated with the column: INPAYMONTH
	 */
	public java.lang.String getInpaymonth () {
		return inpaymonth;
	}

	/**
	 * Set the value related to the column: INPAYMONTH
	 * @param inpaymonth the INPAYMONTH value
	 */
	public void setInpaymonth (java.lang.String inpaymonth) {
		this.inpaymonth = inpaymonth;
	}



	/**
	 * Return the value associated with the column: INPAYRMBAM
	 */
	public java.math.BigDecimal getInpayrmbam () {
		return inpayrmbam;
	}

	/**
	 * Set the value related to the column: INPAYRMBAM
	 * @param inpayrmbam the INPAYRMBAM value
	 */
	public void setInpayrmbam (java.math.BigDecimal inpayrmbam) {
		this.inpayrmbam = inpayrmbam;
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
	 * Return the value associated with the column: INPAYCURRAM
	 */
	public java.math.BigDecimal getInpaycurram () {
		return inpaycurram;
	}

	/**
	 * Set the value related to the column: INPAYCURRAM
	 * @param inpaycurram the INPAYCURRAM value
	 */
	public void setInpaycurram (java.math.BigDecimal inpaycurram) {
		this.inpaycurram = inpaycurram;
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
	 * Return the value associated with the column: CURRENCY
	 */
	public java.lang.String getCurrency () {
		return currency;
	}

	/**
	 * Set the value related to the column: CURRENCY
	 * @param currency the CURRENCY value
	 */
	public void setCurrency (java.lang.String currency) {
		this.currency = currency;
	}



	/**
	 * Return the value associated with the column: MOEXAMUSD
	 */
	public java.math.BigDecimal getMoexamusd () {
		return moexamusd;
	}

	/**
	 * Set the value related to the column: MOEXAMUSD
	 * @param moexamusd the MOEXAMUSD value
	 */
	public void setMoexamusd (java.math.BigDecimal moexamusd) {
		this.moexamusd = moexamusd;
	}



	/**
	 * Return the value associated with the column: MOAMREUSD
	 */
	public java.math.BigDecimal getMoamreusd () {
		return moamreusd;
	}

	/**
	 * Set the value related to the column: MOAMREUSD
	 * @param moamreusd the MOAMREUSD value
	 */
	public void setMoamreusd (java.math.BigDecimal moamreusd) {
		this.moamreusd = moamreusd;
	}



	/**
	 * Return the value associated with the column: MOSETTAMUSD
	 */
	public java.math.BigDecimal getMosettamusd () {
		return mosettamusd;
	}

	/**
	 * Set the value related to the column: MOSETTAMUSD
	 * @param mosettamusd the MOSETTAMUSD value
	 */
	public void setMosettamusd (java.math.BigDecimal mosettamusd) {
		this.mosettamusd = mosettamusd;
	}



	/**
	 * Return the value associated with the column: MOPFEXAMUSD
	 */
	public java.math.BigDecimal getMopfexamusd () {
		return mopfexamusd;
	}

	/**
	 * Set the value related to the column: MOPFEXAMUSD
	 * @param mopfexamusd the MOPFEXAMUSD value
	 */
	public void setMopfexamusd (java.math.BigDecimal mopfexamusd) {
		this.mopfexamusd = mopfexamusd;
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



	/**
	 * Return the value associated with the column: IS_SUB_SUCCESS
	 */
	public String getSubSuccess () {
		return subSuccess;
	}

	/**
	 * Set the value related to the column: IS_SUB_SUCCESS
	 * @param subSuccess the IS_SUB_SUCCESS value
	 */
	public void setSubSuccess (String subSuccess) {
		this.subSuccess = subSuccess;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof resource.bean.report.BopCfaStrdeDs)) return false;
		else {
			resource.bean.report.BopCfaStrdeDs bopCfaStrdeDs = (resource.bean.report.BopCfaStrdeDs) obj;
			if (null == this.getId() || null == bopCfaStrdeDs.getId()) return false;
			else return (this.getId().equals(bopCfaStrdeDs.getId()));
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