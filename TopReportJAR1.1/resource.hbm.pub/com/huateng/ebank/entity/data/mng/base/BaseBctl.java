package com.huateng.ebank.entity.data.mng.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the BCTL table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="BCTL"
 */

public abstract class BaseBctl  implements Serializable {

	public static String REF = "Bctl";
	public static String PROP_LAST_UPD_FUNC = "lastUpdFunc";
	public static String PROP_BRNO = "brno";
	public static String PROP_BR_MANAGE_TYPE = "brManageType";
	public static String PROP_IP = "ip";
	public static String PROP_BLN_MANAGE_BRCODE = "blnManageBrcode";
	public static String PROP_MISC = "misc";
	public static String PROP_BRCLASS = "brclass";
	public static String PROP_AUTHLVL = "authlvl";
	public static String PROP_DELETE_FLAG = "deleteFlag";
	public static String PROP_BLN_BRANCH_CLASS = "blnBranchClass";
	public static String PROP_MISCFLGS = "miscflgs";
	public static String PROP_RPT_BRANCH_BRCODE = "rptBranchBrcode";
	public static String PROP_EXPIRE_DATE = "expireDate";
	public static String PROP_BRTYPE = "brtype";
	public static String PROP_REG_ID = "regId";
	public static String PROP_TIMESTAMPS = "timestamps";
	public static String PROP_RPT_MNG_BRANCH_BRCODE = "rptMngBranchBrcode";
	public static String PROP_POSTNO = "postno";
	public static String PROP_TXN_BRCODE = "txnBrcode";
	public static String PROP_BLN_BRANCH_BRCODE = "blnBranchBrcode";
	public static String PROP_EFFECT_DATE = "effectDate";
	public static String PROP_LAST_UPD_TLR = "lastUpdTlr";
	public static String PROP_BLN_UP_BRCODE = "blnUpBrcode";
	public static String PROP_BRATTR = "brattr";
	public static String PROP_BRNAME = "brname";
	public static String PROP_TELENO = "teleno";
	public static String PROP_STATUS = "status";
	public static String PROP_OTHER_AREA_FLAG = "otherAreaFlag";
	public static String PROP_BRCODE = "brcode";
	public static String PROP_LAST_UPD_DATE = "lastUpdDate";
	public static String PROP_ADDRESS = "address";
	public static String PROP_LINKMAN = "linkman";
	public static String PROP_RPT_BRCLASS = "rptBrclass";
	public static String PROP_RPT_IS_BOCOM = "rptIsBocom";


	// constructors
	public BaseBctl () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBctl (java.lang.String brcode) {
		this.setBrcode(brcode);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseBctl (
		java.lang.String brcode,
		java.lang.String brno) {

		this.setBrcode(brcode);
		this.setBrno(brno);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String brcode;

	// fields
	private java.lang.String brno;
	private java.lang.String brname;
	private java.lang.String brclass;
	private java.lang.String brtype;
	private java.lang.String brattr;
	private java.lang.String brManageType;
	private java.lang.String blnBranchClass;
	private java.lang.String blnBranchBrcode;
	private java.lang.String blnManageBrcode;
	private java.lang.String blnUpBrcode;
	private java.lang.String txnBrcode;
	private java.lang.String authlvl;
	private java.lang.String linkman;
	private java.lang.String teleno;
	private java.lang.String address;
	private java.lang.String postno;
	private java.lang.String otherAreaFlag;
	private java.lang.String ip;
	private java.lang.String deleteFlag;
	private java.lang.String regId;
	private java.lang.String status;
	private java.util.Date effectDate;
	private java.util.Date expireDate;
	private java.lang.String rptBrclass;
	private java.lang.String rptBranchBrcode;
	private java.lang.String rptMngBranchBrcode;
	private java.lang.String rptIsBocom;
	private java.lang.String miscflgs;
	private java.lang.String misc;
	private java.lang.String lastUpdTlr;
	private java.lang.String lastUpdFunc;
	private java.util.Date lastUpdDate;
	private java.util.Date timestamps;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="assigned"
     *  column="BRCODE"
     */
	public java.lang.String getBrcode () {
		return brcode;
	}

	/**
	 * Set the unique identifier of this class
	 * @param brcode the new ID
	 */
	public void setBrcode (java.lang.String brcode) {
		this.brcode = brcode;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: BRNO
	 */
	public java.lang.String getBrno () {
		return brno;
	}

	/**
	 * Set the value related to the column: BRNO
	 * @param brno the BRNO value
	 */
	public void setBrno (java.lang.String brno) {
		this.brno = brno;
	}



	/**
	 * Return the value associated with the column: BRNAME
	 */
	public java.lang.String getBrname () {
		return brname;
	}

	/**
	 * Set the value related to the column: BRNAME
	 * @param brname the BRNAME value
	 */
	public void setBrname (java.lang.String brname) {
		this.brname = brname;
	}



	/**
	 * Return the value associated with the column: BRCLASS
	 */
	public java.lang.String getBrclass () {
		return brclass;
	}

	/**
	 * Set the value related to the column: BRCLASS
	 * @param brclass the BRCLASS value
	 */
	public void setBrclass (java.lang.String brclass) {
		this.brclass = brclass;
	}



	/**
	 * Return the value associated with the column: BRTYPE
	 */
	public java.lang.String getBrtype () {
		return brtype;
	}

	/**
	 * Set the value related to the column: BRTYPE
	 * @param brtype the BRTYPE value
	 */
	public void setBrtype (java.lang.String brtype) {
		this.brtype = brtype;
	}



	/**
	 * Return the value associated with the column: BRATTR
	 */
	public java.lang.String getBrattr () {
		return brattr;
	}

	/**
	 * Set the value related to the column: BRATTR
	 * @param brattr the BRATTR value
	 */
	public void setBrattr (java.lang.String brattr) {
		this.brattr = brattr;
	}



	/**
	 * Return the value associated with the column: BR_MANAGE_TYPE
	 */
	public java.lang.String getBrManageType () {
		return brManageType;
	}

	/**
	 * Set the value related to the column: BR_MANAGE_TYPE
	 * @param brManageType the BR_MANAGE_TYPE value
	 */
	public void setBrManageType (java.lang.String brManageType) {
		this.brManageType = brManageType;
	}



	/**
	 * Return the value associated with the column: BLN_BRANCH_CLASS
	 */
	public java.lang.String getBlnBranchClass () {
		return blnBranchClass;
	}

	/**
	 * Set the value related to the column: BLN_BRANCH_CLASS
	 * @param blnBranchClass the BLN_BRANCH_CLASS value
	 */
	public void setBlnBranchClass (java.lang.String blnBranchClass) {
		this.blnBranchClass = blnBranchClass;
	}



	/**
	 * Return the value associated with the column: BLN_BRANCH_BRCODE
	 */
	public java.lang.String getBlnBranchBrcode () {
		return blnBranchBrcode;
	}

	/**
	 * Set the value related to the column: BLN_BRANCH_BRCODE
	 * @param blnBranchBrcode the BLN_BRANCH_BRCODE value
	 */
	public void setBlnBranchBrcode (java.lang.String blnBranchBrcode) {
		this.blnBranchBrcode = blnBranchBrcode;
	}



	/**
	 * Return the value associated with the column: BLN_MANAGE_BRCODE
	 */
	public java.lang.String getBlnManageBrcode () {
		return blnManageBrcode;
	}

	/**
	 * Set the value related to the column: BLN_MANAGE_BRCODE
	 * @param blnManageBrcode the BLN_MANAGE_BRCODE value
	 */
	public void setBlnManageBrcode (java.lang.String blnManageBrcode) {
		this.blnManageBrcode = blnManageBrcode;
	}



	/**
	 * Return the value associated with the column: BLN_UP_BRCODE
	 */
	public java.lang.String getBlnUpBrcode () {
		return blnUpBrcode;
	}

	/**
	 * Set the value related to the column: BLN_UP_BRCODE
	 * @param blnUpBrcode the BLN_UP_BRCODE value
	 */
	public void setBlnUpBrcode (java.lang.String blnUpBrcode) {
		this.blnUpBrcode = blnUpBrcode;
	}



	/**
	 * Return the value associated with the column: TXN_BRCODE
	 */
	public java.lang.String getTxnBrcode () {
		return txnBrcode;
	}

	/**
	 * Set the value related to the column: TXN_BRCODE
	 * @param txnBrcode the TXN_BRCODE value
	 */
	public void setTxnBrcode (java.lang.String txnBrcode) {
		this.txnBrcode = txnBrcode;
	}



	/**
	 * Return the value associated with the column: AUTHLVL
	 */
	public java.lang.String getAuthlvl () {
		return authlvl;
	}

	/**
	 * Set the value related to the column: AUTHLVL
	 * @param authlvl the AUTHLVL value
	 */
	public void setAuthlvl (java.lang.String authlvl) {
		this.authlvl = authlvl;
	}



	/**
	 * Return the value associated with the column: LINKMAN
	 */
	public java.lang.String getLinkman () {
		return linkman;
	}

	/**
	 * Set the value related to the column: LINKMAN
	 * @param linkman the LINKMAN value
	 */
	public void setLinkman (java.lang.String linkman) {
		this.linkman = linkman;
	}



	/**
	 * Return the value associated with the column: TELENO
	 */
	public java.lang.String getTeleno () {
		return teleno;
	}

	/**
	 * Set the value related to the column: TELENO
	 * @param teleno the TELENO value
	 */
	public void setTeleno (java.lang.String teleno) {
		this.teleno = teleno;
	}



	/**
	 * Return the value associated with the column: ADDRESS
	 */
	public java.lang.String getAddress () {
		return address;
	}

	/**
	 * Set the value related to the column: ADDRESS
	 * @param address the ADDRESS value
	 */
	public void setAddress (java.lang.String address) {
		this.address = address;
	}



	/**
	 * Return the value associated with the column: POSTNO
	 */
	public java.lang.String getPostno () {
		return postno;
	}

	/**
	 * Set the value related to the column: POSTNO
	 * @param postno the POSTNO value
	 */
	public void setPostno (java.lang.String postno) {
		this.postno = postno;
	}



	/**
	 * Return the value associated with the column: OTHER_AREA_FLAG
	 */
	public java.lang.String getOtherAreaFlag () {
		return otherAreaFlag;
	}

	/**
	 * Set the value related to the column: OTHER_AREA_FLAG
	 * @param otherAreaFlag the OTHER_AREA_FLAG value
	 */
	public void setOtherAreaFlag (java.lang.String otherAreaFlag) {
		this.otherAreaFlag = otherAreaFlag;
	}



	/**
	 * Return the value associated with the column: IP
	 */
	public java.lang.String getIp () {
		return ip;
	}

	/**
	 * Set the value related to the column: IP
	 * @param ip the IP value
	 */
	public void setIp (java.lang.String ip) {
		this.ip = ip;
	}



	/**
	 * Return the value associated with the column: DELETE_FLAG
	 */
	public java.lang.String getDeleteFlag () {
		return deleteFlag;
	}

	/**
	 * Set the value related to the column: DELETE_FLAG
	 * @param deleteFlag the DELETE_FLAG value
	 */
	public void setDeleteFlag (java.lang.String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}



	/**
	 * Return the value associated with the column: REG_ID
	 */
	public java.lang.String getRegId () {
		return regId;
	}

	/**
	 * Set the value related to the column: REG_ID
	 * @param regId the REG_ID value
	 */
	public void setRegId (java.lang.String regId) {
		this.regId = regId;
	}



	/**
	 * Return the value associated with the column: STATUS
	 */
	public java.lang.String getStatus () {
		return status;
	}

	/**
	 * Set the value related to the column: STATUS
	 * @param status the STATUS value
	 */
	public void setStatus (java.lang.String status) {
		this.status = status;
	}



	/**
	 * Return the value associated with the column: EFFECT_DATE
	 */
	public java.util.Date getEffectDate () {
		return effectDate;
	}

	/**
	 * Set the value related to the column: EFFECT_DATE
	 * @param effectDate the EFFECT_DATE value
	 */
	public void setEffectDate (java.util.Date effectDate) {
		this.effectDate = effectDate;
	}



	/**
	 * Return the value associated with the column: EXPIRE_DATE
	 */
	public java.util.Date getExpireDate () {
		return expireDate;
	}

	/**
	 * Set the value related to the column: EXPIRE_DATE
	 * @param expireDate the EXPIRE_DATE value
	 */
	public void setExpireDate (java.util.Date expireDate) {
		this.expireDate = expireDate;
	}



	/**
	 * Return the value associated with the column: RPT_BRCLASS
	 */
	public java.lang.String getRptBrclass () {
		return rptBrclass;
	}

	/**
	 * Set the value related to the column: RPT_BRCLASS
	 * @param rptBrclass the RPT_BRCLASS value
	 */
	public void setRptBrclass (java.lang.String rptBrclass) {
		this.rptBrclass = rptBrclass;
	}



	/**
	 * Return the value associated with the column: RPT_BRANCH_BRCODE
	 */
	public java.lang.String getRptBranchBrcode () {
		return rptBranchBrcode;
	}

	/**
	 * Set the value related to the column: RPT_BRANCH_BRCODE
	 * @param rptBranchBrcode the RPT_BRANCH_BRCODE value
	 */
	public void setRptBranchBrcode (java.lang.String rptBranchBrcode) {
		this.rptBranchBrcode = rptBranchBrcode;
	}



	/**
	 * Return the value associated with the column: RPT_MNG_BRANCH_BRCODE
	 */
	public java.lang.String getRptMngBranchBrcode () {
		return rptMngBranchBrcode;
	}

	/**
	 * Set the value related to the column: RPT_MNG_BRANCH_BRCODE
	 * @param rptMngBranchBrcode the RPT_MNG_BRANCH_BRCODE value
	 */
	public void setRptMngBranchBrcode (java.lang.String rptMngBranchBrcode) {
		this.rptMngBranchBrcode = rptMngBranchBrcode;
	}



	/**
	 * Return the value associated with the column: RPT_IS_BOCOM
	 */
	public java.lang.String getRptIsBocom () {
		return rptIsBocom;
	}

	/**
	 * Set the value related to the column: RPT_IS_BOCOM
	 * @param rptIsBocom the RPT_IS_BOCOM value
	 */
	public void setRptIsBocom (java.lang.String rptIsBocom) {
		this.rptIsBocom = rptIsBocom;
	}



	/**
	 * Return the value associated with the column: MISCFLGS
	 */
	public java.lang.String getMiscflgs () {
		return miscflgs;
	}

	/**
	 * Set the value related to the column: MISCFLGS
	 * @param miscflgs the MISCFLGS value
	 */
	public void setMiscflgs (java.lang.String miscflgs) {
		this.miscflgs = miscflgs;
	}



	/**
	 * Return the value associated with the column: MISC
	 */
	public java.lang.String getMisc () {
		return misc;
	}

	/**
	 * Set the value related to the column: MISC
	 * @param misc the MISC value
	 */
	public void setMisc (java.lang.String misc) {
		this.misc = misc;
	}



	/**
	 * Return the value associated with the column: LAST_UPD_TLR
	 */
	public java.lang.String getLastUpdTlr () {
		return lastUpdTlr;
	}

	/**
	 * Set the value related to the column: LAST_UPD_TLR
	 * @param lastUpdTlr the LAST_UPD_TLR value
	 */
	public void setLastUpdTlr (java.lang.String lastUpdTlr) {
		this.lastUpdTlr = lastUpdTlr;
	}



	/**
	 * Return the value associated with the column: LAST_UPD_FUNC
	 */
	public java.lang.String getLastUpdFunc () {
		return lastUpdFunc;
	}

	/**
	 * Set the value related to the column: LAST_UPD_FUNC
	 * @param lastUpdFunc the LAST_UPD_FUNC value
	 */
	public void setLastUpdFunc (java.lang.String lastUpdFunc) {
		this.lastUpdFunc = lastUpdFunc;
	}



	/**
	 * Return the value associated with the column: LAST_UPD_DATE
	 */
	public java.util.Date getLastUpdDate () {
		return lastUpdDate;
	}

	/**
	 * Set the value related to the column: LAST_UPD_DATE
	 * @param lastUpdDate the LAST_UPD_DATE value
	 */
	public void setLastUpdDate (java.util.Date lastUpdDate) {
		this.lastUpdDate = lastUpdDate;
	}



	/**
	 * Return the value associated with the column: TIMESTAMPS
	 */
	public java.util.Date getTimestamps () {
		return timestamps;
	}

	/**
	 * Set the value related to the column: TIMESTAMPS
	 * @param timestamps the TIMESTAMPS value
	 */
	public void setTimestamps (java.util.Date timestamps) {
		this.timestamps = timestamps;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.huateng.ebank.entity.data.mng.Bctl)) return false;
		else {
			com.huateng.ebank.entity.data.mng.Bctl bctl = (com.huateng.ebank.entity.data.mng.Bctl) obj;
			if (null == this.getBrcode() || null == bctl.getBrcode()) return false;
			else return (this.getBrcode().equals(bctl.getBrcode()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getBrcode()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getBrcode().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}