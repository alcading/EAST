package resource.bean.pub.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the TLR_LOGIN_LOG table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="TLR_LOGIN_LOG"
 */

public abstract class BaseTlrLoginLog  implements Serializable {

	public static String REF = "TlrLoginLog";
	public static String PROP_SESSION_ID = "sessionId";
	public static String PROP_LOGIN_FAIL_TM = "loginFailTm";
	public static String PROP_LOGIN_OUT_TM = "loginOutTm";
	public static String PROP_LOGIN_REMARK = "loginRemark";
	public static String PROP_LOGIN_ADDR = "loginAddr";
	public static String PROP_TLR_NO = "tlrNo";
	public static String PROP_ID = "id";
	public static String PROP_LOGIN_SUC_TM = "loginSucTm";
	public static String PROP_CRT_TM = "crtTm";
	public static String PROP_BR_NO = "brNo";


	// constructors
	public BaseTlrLoginLog () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseTlrLoginLog (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;

	// fields
	private java.lang.String tlrNo;
	private java.lang.String brNo;
	private java.util.Date loginSucTm;
	private java.util.Date loginOutTm;
	private java.util.Date loginFailTm;
	private java.lang.String loginAddr;
	private java.lang.String loginRemark;
	private java.lang.String sessionId;
	private java.util.Date crtTm;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  column="LOG_ID"
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
	 * Return the value associated with the column: TLR_NO
	 */
	public java.lang.String getTlrNo () {
		return tlrNo;
	}

	/**
	 * Set the value related to the column: TLR_NO
	 * @param tlrNo the TLR_NO value
	 */
	public void setTlrNo (java.lang.String tlrNo) {
		this.tlrNo = tlrNo;
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
	 * Return the value associated with the column: LOGIN_SUC_TM
	 */
	public java.util.Date getLoginSucTm () {
		return loginSucTm;
	}

	/**
	 * Set the value related to the column: LOGIN_SUC_TM
	 * @param loginSucTm the LOGIN_SUC_TM value
	 */
	public void setLoginSucTm (java.util.Date loginSucTm) {
		this.loginSucTm = loginSucTm;
	}



	/**
	 * Return the value associated with the column: LOGIN_OUT_TM
	 */
	public java.util.Date getLoginOutTm () {
		return loginOutTm;
	}

	/**
	 * Set the value related to the column: LOGIN_OUT_TM
	 * @param loginOutTm the LOGIN_OUT_TM value
	 */
	public void setLoginOutTm (java.util.Date loginOutTm) {
		this.loginOutTm = loginOutTm;
	}



	/**
	 * Return the value associated with the column: LOGIN_FAIL_TM
	 */
	public java.util.Date getLoginFailTm () {
		return loginFailTm;
	}

	/**
	 * Set the value related to the column: LOGIN_FAIL_TM
	 * @param loginFailTm the LOGIN_FAIL_TM value
	 */
	public void setLoginFailTm (java.util.Date loginFailTm) {
		this.loginFailTm = loginFailTm;
	}



	/**
	 * Return the value associated with the column: LOGIN_ADDR
	 */
	public java.lang.String getLoginAddr () {
		return loginAddr;
	}

	/**
	 * Set the value related to the column: LOGIN_ADDR
	 * @param loginAddr the LOGIN_ADDR value
	 */
	public void setLoginAddr (java.lang.String loginAddr) {
		this.loginAddr = loginAddr;
	}



	/**
	 * Return the value associated with the column: LOGIN_REMARK
	 */
	public java.lang.String getLoginRemark () {
		return loginRemark;
	}

	/**
	 * Set the value related to the column: LOGIN_REMARK
	 * @param loginRemark the LOGIN_REMARK value
	 */
	public void setLoginRemark (java.lang.String loginRemark) {
		this.loginRemark = loginRemark;
	}



	/**
	 * Return the value associated with the column: SESSION_ID
	 */
	public java.lang.String getSessionId () {
		return sessionId;
	}

	/**
	 * Set the value related to the column: SESSION_ID
	 * @param sessionId the SESSION_ID value
	 */
	public void setSessionId (java.lang.String sessionId) {
		this.sessionId = sessionId;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof resource.bean.pub.TlrLoginLog)) return false;
		else {
			resource.bean.pub.TlrLoginLog tlrLoginLog = (resource.bean.pub.TlrLoginLog) obj;
			if (null == this.getId() || null == tlrLoginLog.getId()) return false;
			else return (this.getId().equals(tlrLoginLog.getId()));
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