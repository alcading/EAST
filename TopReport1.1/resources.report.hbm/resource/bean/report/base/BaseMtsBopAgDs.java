package resource.bean.report.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the MTS_BOP_AG_DS table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="MTS_BOP_AG_DS"
 */

public abstract class BaseMtsBopAgDs  implements Serializable {

	public static String REF = "MtsBopAgDs";
	public static String PROP_METHOD = "method";
	public static String PROP_CUSTCOD = "custcod";
	public static String PROP_OUTCHARGECCY = "outchargeccy";
	public static String PROP_BUSCODE = "buscode";
	public static String PROP_APPROVE_RESULT = "approveResult";
	public static String PROP_ISREF = "isref";
	public static String PROP_INPTELC = "inptelc";
	public static String PROP_REC_STATUS = "recStatus";
	public static String PROP_LST_UPD_TLR = "lstUpdTlr";
	public static String PROP_INCHARGECCY = "inchargeccy";
	public static String PROP_FCYACC = "fcyacc";
	public static String PROP_ACTIONTYPE = "actiontype";
	public static String PROP_BILLNO = "billno";
	public static String PROP_TXCCY = "txccy";
	public static String PROP_SUB_SUCCESS = "subSuccess";
	public static String PROP_APPTYPE = "apptype";
	public static String PROP_COUNTRY = "country";
	public static String PROP_OTHACC = "othacc";
	public static String PROP_ACTIONDESC = "actiondesc";
	public static String PROP_RPTNO = "rptno";
	public static String PROP_FCYAMT = "fcyamt";
	public static String PROP_OPPUSER = "oppuser";
	public static String PROP_ID = "id";
	public static String PROP_FILLER1 = "filler1";
	public static String PROP_REP_STATUS = "repStatus";
	public static String PROP_TC2AMT = "tc2amt";
	public static String PROP_FILLER3 = "filler3";
	public static String PROP_BR_NO = "brNo";
	public static String PROP_FILLER2 = "filler2";
	public static String PROP_CUSTNM = "custnm";
	public static String PROP_OTHAMT = "othamt";
	public static String PROP_CUSTYPE = "custype";
	public static String PROP_PAYATTR = "payattr";
	public static String PROP_TC1AMT = "tc1amt";
	public static String PROP_TXREM = "txrem";
	public static String PROP_WORK_DATE = "workDate";
	public static String PROP_LST_UPD_TM = "lstUpdTm";
	public static String PROP_APPROVE_STATUS = "approveStatus";
	public static String PROP_IDCODE = "idcode";
	public static String PROP_EXRATE = "exrate";
	public static String PROP_LCYACC = "lcyacc";
	public static String PROP_PAYTYPE = "paytype";
	public static String PROP_TXCODE2 = "txcode2";
	public static String PROP_TX2REM = "tx2rem";
	public static String PROP_RPTDATE = "rptdate";
	public static String PROP_CRTUSER = "crtuser";
	public static String PROP_LCYAMT = "lcyamt";
	public static String PROP_OUTCHARGEAMT = "outchargeamt";
	public static String PROP_TXAMT = "txamt";
	public static String PROP_CURRENTFILE = "currentfile";
	public static String PROP_INCHARGEAMT = "inchargeamt";
	public static String PROP_TXCODE = "txcode";
	public static String PROP_CRT_TM = "crtTm";


	// constructors
	public BaseMtsBopAgDs () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMtsBopAgDs (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseMtsBopAgDs (
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
	private java.lang.String actiontype;
	private java.lang.String actiondesc;
	private java.lang.String rptno;
	private java.lang.String custype;
	private java.lang.String idcode;
	private java.lang.String custcod;
	private java.lang.String custnm;
	private java.lang.String oppuser;
	private java.lang.String txccy;
	private java.math.BigDecimal txamt;
	private java.math.BigDecimal exrate;
	private java.math.BigDecimal lcyamt;
	private java.lang.String lcyacc;
	private java.math.BigDecimal fcyamt;
	private java.lang.String fcyacc;
	private java.math.BigDecimal othamt;
	private java.lang.String othacc;
	private java.lang.String method;
	private java.lang.String buscode;
	private java.lang.String inchargeccy;
	private java.math.BigDecimal inchargeamt;
	private java.lang.String outchargeccy;
	private java.math.BigDecimal outchargeamt;
	private java.lang.String country;
	private java.lang.String paytype;
	private java.lang.String txcode;
	private java.math.BigDecimal tc1amt;
	private java.lang.String txrem;
	private java.lang.String txcode2;
	private java.math.BigDecimal tc2amt;
	private java.lang.String tx2rem;
	private java.lang.String isref;
	private java.lang.String billno;
	private java.lang.String payattr;
	private java.lang.String crtuser;
	private java.lang.String inptelc;
	private java.lang.String rptdate;
	private java.lang.String filler1;
	private java.lang.String filler2;
	private java.lang.String filler3;
	private java.lang.String brNo;
	private java.lang.String recStatus;
	private java.lang.String repStatus;
	private java.lang.String approveStatus;
	private java.lang.String approveResult;
	private java.lang.String workDate;
	private java.lang.String subSuccess;
	private java.util.Date crtTm;
	private java.lang.String lstUpdTlr;
	private java.util.Date lstUpdTm;



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
	 * Return the value associated with the column: RPTNO
	 */
	public java.lang.String getRptno () {
		return rptno;
	}

	/**
	 * Set the value related to the column: RPTNO
	 * @param rptno the RPTNO value
	 */
	public void setRptno (java.lang.String rptno) {
		this.rptno = rptno;
	}



	/**
	 * Return the value associated with the column: CUSTYPE
	 */
	public java.lang.String getCustype () {
		return custype;
	}

	/**
	 * Set the value related to the column: CUSTYPE
	 * @param custype the CUSTYPE value
	 */
	public void setCustype (java.lang.String custype) {
		this.custype = custype;
	}



	/**
	 * Return the value associated with the column: IDCODE
	 */
	public java.lang.String getIdcode () {
		return idcode;
	}

	/**
	 * Set the value related to the column: IDCODE
	 * @param idcode the IDCODE value
	 */
	public void setIdcode (java.lang.String idcode) {
		this.idcode = idcode;
	}



	/**
	 * Return the value associated with the column: CUSTCOD
	 */
	public java.lang.String getCustcod () {
		return custcod;
	}

	/**
	 * Set the value related to the column: CUSTCOD
	 * @param custcod the CUSTCOD value
	 */
	public void setCustcod (java.lang.String custcod) {
		this.custcod = custcod;
	}



	/**
	 * Return the value associated with the column: CUSTNM
	 */
	public java.lang.String getCustnm () {
		return custnm;
	}

	/**
	 * Set the value related to the column: CUSTNM
	 * @param custnm the CUSTNM value
	 */
	public void setCustnm (java.lang.String custnm) {
		this.custnm = custnm;
	}



	/**
	 * Return the value associated with the column: OPPUSER
	 */
	public java.lang.String getOppuser () {
		return oppuser;
	}

	/**
	 * Set the value related to the column: OPPUSER
	 * @param oppuser the OPPUSER value
	 */
	public void setOppuser (java.lang.String oppuser) {
		this.oppuser = oppuser;
	}



	/**
	 * Return the value associated with the column: TXCCY
	 */
	public java.lang.String getTxccy () {
		return txccy;
	}

	/**
	 * Set the value related to the column: TXCCY
	 * @param txccy the TXCCY value
	 */
	public void setTxccy (java.lang.String txccy) {
		this.txccy = txccy;
	}



	/**
	 * Return the value associated with the column: TXAMT
	 */
	public java.math.BigDecimal getTxamt () {
		return txamt;
	}

	/**
	 * Set the value related to the column: TXAMT
	 * @param txamt the TXAMT value
	 */
	public void setTxamt (java.math.BigDecimal txamt) {
		this.txamt = txamt;
	}



	/**
	 * Return the value associated with the column: EXRATE
	 */
	public java.math.BigDecimal getExrate () {
		return exrate;
	}

	/**
	 * Set the value related to the column: EXRATE
	 * @param exrate the EXRATE value
	 */
	public void setExrate (java.math.BigDecimal exrate) {
		this.exrate = exrate;
	}



	/**
	 * Return the value associated with the column: LCYAMT
	 */
	public java.math.BigDecimal getLcyamt () {
		return lcyamt;
	}

	/**
	 * Set the value related to the column: LCYAMT
	 * @param lcyamt the LCYAMT value
	 */
	public void setLcyamt (java.math.BigDecimal lcyamt) {
		this.lcyamt = lcyamt;
	}



	/**
	 * Return the value associated with the column: LCYACC
	 */
	public java.lang.String getLcyacc () {
		return lcyacc;
	}

	/**
	 * Set the value related to the column: LCYACC
	 * @param lcyacc the LCYACC value
	 */
	public void setLcyacc (java.lang.String lcyacc) {
		this.lcyacc = lcyacc;
	}



	/**
	 * Return the value associated with the column: FCYAMT
	 */
	public java.math.BigDecimal getFcyamt () {
		return fcyamt;
	}

	/**
	 * Set the value related to the column: FCYAMT
	 * @param fcyamt the FCYAMT value
	 */
	public void setFcyamt (java.math.BigDecimal fcyamt) {
		this.fcyamt = fcyamt;
	}



	/**
	 * Return the value associated with the column: FCYACC
	 */
	public java.lang.String getFcyacc () {
		return fcyacc;
	}

	/**
	 * Set the value related to the column: FCYACC
	 * @param fcyacc the FCYACC value
	 */
	public void setFcyacc (java.lang.String fcyacc) {
		this.fcyacc = fcyacc;
	}



	/**
	 * Return the value associated with the column: OTHAMT
	 */
	public java.math.BigDecimal getOthamt () {
		return othamt;
	}

	/**
	 * Set the value related to the column: OTHAMT
	 * @param othamt the OTHAMT value
	 */
	public void setOthamt (java.math.BigDecimal othamt) {
		this.othamt = othamt;
	}



	/**
	 * Return the value associated with the column: OTHACC
	 */
	public java.lang.String getOthacc () {
		return othacc;
	}

	/**
	 * Set the value related to the column: OTHACC
	 * @param othacc the OTHACC value
	 */
	public void setOthacc (java.lang.String othacc) {
		this.othacc = othacc;
	}



	/**
	 * Return the value associated with the column: METHOD
	 */
	public java.lang.String getMethod () {
		return method;
	}

	/**
	 * Set the value related to the column: METHOD
	 * @param method the METHOD value
	 */
	public void setMethod (java.lang.String method) {
		this.method = method;
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
	 * Return the value associated with the column: INCHARGECCY
	 */
	public java.lang.String getInchargeccy () {
		return inchargeccy;
	}

	/**
	 * Set the value related to the column: INCHARGECCY
	 * @param inchargeccy the INCHARGECCY value
	 */
	public void setInchargeccy (java.lang.String inchargeccy) {
		this.inchargeccy = inchargeccy;
	}



	/**
	 * Return the value associated with the column: INCHARGEAMT
	 */
	public java.math.BigDecimal getInchargeamt () {
		return inchargeamt;
	}

	/**
	 * Set the value related to the column: INCHARGEAMT
	 * @param inchargeamt the INCHARGEAMT value
	 */
	public void setInchargeamt (java.math.BigDecimal inchargeamt) {
		this.inchargeamt = inchargeamt;
	}



	/**
	 * Return the value associated with the column: OUTCHARGECCY
	 */
	public java.lang.String getOutchargeccy () {
		return outchargeccy;
	}

	/**
	 * Set the value related to the column: OUTCHARGECCY
	 * @param outchargeccy the OUTCHARGECCY value
	 */
	public void setOutchargeccy (java.lang.String outchargeccy) {
		this.outchargeccy = outchargeccy;
	}



	/**
	 * Return the value associated with the column: OUTCHARGEAMT
	 */
	public java.math.BigDecimal getOutchargeamt () {
		return outchargeamt;
	}

	/**
	 * Set the value related to the column: OUTCHARGEAMT
	 * @param outchargeamt the OUTCHARGEAMT value
	 */
	public void setOutchargeamt (java.math.BigDecimal outchargeamt) {
		this.outchargeamt = outchargeamt;
	}



	/**
	 * Return the value associated with the column: COUNTRY
	 */
	public java.lang.String getCountry () {
		return country;
	}

	/**
	 * Set the value related to the column: COUNTRY
	 * @param country the COUNTRY value
	 */
	public void setCountry (java.lang.String country) {
		this.country = country;
	}



	/**
	 * Return the value associated with the column: PAYTYPE
	 */
	public java.lang.String getPaytype () {
		return paytype;
	}

	/**
	 * Set the value related to the column: PAYTYPE
	 * @param paytype the PAYTYPE value
	 */
	public void setPaytype (java.lang.String paytype) {
		this.paytype = paytype;
	}



	/**
	 * Return the value associated with the column: TXCODE
	 */
	public java.lang.String getTxcode () {
		return txcode;
	}

	/**
	 * Set the value related to the column: TXCODE
	 * @param txcode the TXCODE value
	 */
	public void setTxcode (java.lang.String txcode) {
		this.txcode = txcode;
	}



	/**
	 * Return the value associated with the column: TC1AMT
	 */
	public java.math.BigDecimal getTc1amt () {
		return tc1amt;
	}

	/**
	 * Set the value related to the column: TC1AMT
	 * @param tc1amt the TC1AMT value
	 */
	public void setTc1amt (java.math.BigDecimal tc1amt) {
		this.tc1amt = tc1amt;
	}



	/**
	 * Return the value associated with the column: TXREM
	 */
	public java.lang.String getTxrem () {
		return txrem;
	}

	/**
	 * Set the value related to the column: TXREM
	 * @param txrem the TXREM value
	 */
	public void setTxrem (java.lang.String txrem) {
		this.txrem = txrem;
	}



	/**
	 * Return the value associated with the column: TXCODE2
	 */
	public java.lang.String getTxcode2 () {
		return txcode2;
	}

	/**
	 * Set the value related to the column: TXCODE2
	 * @param txcode2 the TXCODE2 value
	 */
	public void setTxcode2 (java.lang.String txcode2) {
		this.txcode2 = txcode2;
	}



	/**
	 * Return the value associated with the column: TC2AMT
	 */
	public java.math.BigDecimal getTc2amt () {
		return tc2amt;
	}

	/**
	 * Set the value related to the column: TC2AMT
	 * @param tc2amt the TC2AMT value
	 */
	public void setTc2amt (java.math.BigDecimal tc2amt) {
		this.tc2amt = tc2amt;
	}



	/**
	 * Return the value associated with the column: TX2REM
	 */
	public java.lang.String getTx2rem () {
		return tx2rem;
	}

	/**
	 * Set the value related to the column: TX2REM
	 * @param tx2rem the TX2REM value
	 */
	public void setTx2rem (java.lang.String tx2rem) {
		this.tx2rem = tx2rem;
	}



	/**
	 * Return the value associated with the column: ISREF
	 */
	public java.lang.String getIsref () {
		return isref;
	}

	/**
	 * Set the value related to the column: ISREF
	 * @param isref the ISREF value
	 */
	public void setIsref (java.lang.String isref) {
		this.isref = isref;
	}



	/**
	 * Return the value associated with the column: BILLNO
	 */
	public java.lang.String getBillno () {
		return billno;
	}

	/**
	 * Set the value related to the column: BILLNO
	 * @param billno the BILLNO value
	 */
	public void setBillno (java.lang.String billno) {
		this.billno = billno;
	}



	/**
	 * Return the value associated with the column: PAYATTR
	 */
	public java.lang.String getPayattr () {
		return payattr;
	}

	/**
	 * Set the value related to the column: PAYATTR
	 * @param payattr the PAYATTR value
	 */
	public void setPayattr (java.lang.String payattr) {
		this.payattr = payattr;
	}



	/**
	 * Return the value associated with the column: CRTUSER
	 */
	public java.lang.String getCrtuser () {
		return crtuser;
	}

	/**
	 * Set the value related to the column: CRTUSER
	 * @param crtuser the CRTUSER value
	 */
	public void setCrtuser (java.lang.String crtuser) {
		this.crtuser = crtuser;
	}



	/**
	 * Return the value associated with the column: INPTELC
	 */
	public java.lang.String getInptelc () {
		return inptelc;
	}

	/**
	 * Set the value related to the column: INPTELC
	 * @param inptelc the INPTELC value
	 */
	public void setInptelc (java.lang.String inptelc) {
		this.inptelc = inptelc;
	}



	/**
	 * Return the value associated with the column: RPTDATE
	 */
	public java.lang.String getRptdate () {
		return rptdate;
	}

	/**
	 * Set the value related to the column: RPTDATE
	 * @param rptdate the RPTDATE value
	 */
	public void setRptdate (java.lang.String rptdate) {
		this.rptdate = rptdate;
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
	public java.lang.String getSubSuccess () {
		return subSuccess;
	}

	/**
	 * Set the value related to the column: IS_SUB_SUCCESS
	 * @param subSuccess the IS_SUB_SUCCESS value
	 */
	public void setSubSuccess (java.lang.String subSuccess) {
		this.subSuccess = subSuccess;
	}



	/**
	 * Return the value associated with the column: CRT_TM
	 */
	public java.util.Date getCrtTm () {
		return crtTm;
	}

	/**
	 * Set the value related to the column: CRT_TM
	 * @param crtTm the CRT_TM value
	 */
	public void setCrtTm (java.util.Date crtTm) {
		this.crtTm = crtTm;
	}



	/**
	 * Return the value associated with the column: LST_UPD_TLR
	 */
	public java.lang.String getLstUpdTlr () {
		return lstUpdTlr;
	}

	/**
	 * Set the value related to the column: LST_UPD_TLR
	 * @param lstUpdTlr the LST_UPD_Tlr value
	 */
	public void setLstUpdTlr (java.lang.String lstUpdTlr) {
		this.lstUpdTlr = lstUpdTlr;
	}



	/**
	 * Return the value associated with the column: LST_UPD_TM
	 */
	public java.util.Date getLstUpdTm () {
		return lstUpdTm;
	}

	/**
	 * Set the value related to the column: LST_UPD_TM
	 * @param lstUpdTm the LST_UPD_TM value
	 */
	public void setLstUpdTm (java.util.Date lstUpdTm) {
		this.lstUpdTm = lstUpdTm;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof resource.bean.report.MtsBopAgDs)) return false;
		else {
			resource.bean.report.MtsBopAgDs mtsBopAgDs = (resource.bean.report.MtsBopAgDs) obj;
			if (null == this.getId() || null == mtsBopAgDs.getId()) return false;
			else return (this.getId().equals(mtsBopAgDs.getId()));
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