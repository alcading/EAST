package resource.bean.report.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the MTS_JSH_DEFG_DS table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="MTS_JSH_DEFG_DS"
 */

public abstract class BaseMtsJshDefgDs  implements Serializable {

	public static String REF = "MtsJshDefgDs";
	public static String PROP_CUSTNM = "custnm";
	public static String PROP_LCYCCY = "lcyccy";
	public static String PROP_CUSTYPE = "custype";
	public static String PROP_CUSTCOD = "custcod";
	public static String PROP_BUSCODE = "buscode";
	public static String PROP_WORK_DATE = "workDate";
	public static String PROP_APPROVE_RESULT = "approveResult";
	public static String PROP_APPROVE_STATUS = "approveStatus";
	public static String PROP_LST_UPD_TM = "lstUpdTm";
	public static String PROP_OPPBANK = "oppbank";
	public static String PROP_USETYPE = "usetype";
	public static String PROP_LST_UPD_TLR = "lstUpdTlr";
	public static String PROP_INPTELC = "inptelc";
	public static String PROP_IDCODE = "idcode";
	public static String PROP_EXRATE = "exrate";
	public static String PROP_USEDETAIL = "usedetail";
	public static String PROP_LCYACC = "lcyacc";
	public static String PROP_REC_STATUS = "recStatus";
	public static String PROP_FCYACC = "fcyacc";
	public static String PROP_ACTIONTYPE = "actiontype";
	public static String PROP_RPTDATE = "rptdate";
	public static String PROP_CRTUSER = "crtuser";
	public static String PROP_LCYAMT = "lcyamt";
	public static String PROP_SUB_SUCCESS = "subSuccess";
	public static String PROP_APPTYPE = "apptype";
	public static String PROP_CURRENTFILE = "currentfile";
	public static String PROP_RPTNO = "rptno";
	public static String PROP_ACTIONDESC = "actiondesc";
	public static String PROP_FCYAMT = "fcyamt";
	public static String PROP_OPPUSER = "oppuser";
	public static String PROP_ID = "id";
	public static String PROP_TXCODE = "txcode";
	public static String PROP_FILLER1 = "filler1";
	public static String PROP_REP_STATUS = "repStatus";
	public static String PROP_FCYCCY = "fcyccy";
	public static String PROP_BR_NO = "brNo";
	public static String PROP_FILLER3 = "filler3";
	public static String PROP_CRT_TM = "crtTm";
	public static String PROP_REGNO = "regno";
	public static String PROP_FILLER2 = "filler2";


	// constructors
	public BaseMtsJshDefgDs () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMtsJshDefgDs (java.lang.String id) {
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
	private java.lang.String actiontype;
	private java.lang.String actiondesc;
	private java.lang.String rptno;
	private java.lang.String buscode;
	private java.lang.String custype;
	private java.lang.String custcod;
	private java.lang.String idcode;
	private java.lang.String custnm;
	private java.lang.String fcyacc;
	private java.lang.String lcyacc;
	private java.lang.String oppuser;
	private java.lang.String oppbank;
	private java.math.BigDecimal fcyamt;
	private java.lang.String fcyccy;
	private java.math.BigDecimal lcyamt;
	private java.lang.String lcyccy;
	private java.math.BigDecimal exrate;
	private java.lang.String regno;
	private java.lang.String txcode;
	private java.lang.String usetype;
	private java.lang.String usedetail;
	private java.lang.String crtuser;
	private java.lang.String inptelc;
	private java.lang.String rptdate;
	private java.lang.String lstUpdTlr;
	private java.util.Date lstUpdTm;
	private java.util.Date crtTm;
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
	 * Return the value associated with the column: OPPBANK
	 */
	public java.lang.String getOppbank () {
		return oppbank;
	}

	/**
	 * Set the value related to the column: OPPBANK
	 * @param oppbank the OPPBANK value
	 */
	public void setOppbank (java.lang.String oppbank) {
		this.oppbank = oppbank;
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
	 * Return the value associated with the column: FCYCCY
	 */
	public java.lang.String getFcyccy () {
		return fcyccy;
	}

	/**
	 * Set the value related to the column: FCYCCY
	 * @param fcyccy the FCYCCY value
	 */
	public void setFcyccy (java.lang.String fcyccy) {
		this.fcyccy = fcyccy;
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
	 * Return the value associated with the column: LCYCCY
	 */
	public java.lang.String getLcyccy () {
		return lcyccy;
	}

	/**
	 * Set the value related to the column: LCYCCY
	 * @param lcyccy the LCYCCY value
	 */
	public void setLcyccy (java.lang.String lcyccy) {
		this.lcyccy = lcyccy;
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
	 * Return the value associated with the column: REGNO
	 */
	public java.lang.String getRegno () {
		return regno;
	}

	/**
	 * Set the value related to the column: REGNO
	 * @param regno the REGNO value
	 */
	public void setRegno (java.lang.String regno) {
		this.regno = regno;
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
	 * Return the value associated with the column: USETYPE
	 */
	public java.lang.String getUsetype () {
		return usetype;
	}

	/**
	 * Set the value related to the column: USETYPE
	 * @param usetype the USETYPE value
	 */
	public void setUsetype (java.lang.String usetype) {
		this.usetype = usetype;
	}



	/**
	 * Return the value associated with the column: USEDETAIL
	 */
	public java.lang.String getUsedetail () {
		return usedetail;
	}

	/**
	 * Set the value related to the column: USEDETAIL
	 * @param usedetail the USEDETAIL value
	 */
	public void setUsedetail (java.lang.String usedetail) {
		this.usedetail = usedetail;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof resource.bean.report.MtsJshDefgDs)) return false;
		else {
			resource.bean.report.MtsJshDefgDs mtsJshDefgDs = (resource.bean.report.MtsJshDefgDs) obj;
			if (null == this.getId() || null == mtsJshDefgDs.getId()) return false;
			else return (this.getId().equals(mtsJshDefgDs.getId()));
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