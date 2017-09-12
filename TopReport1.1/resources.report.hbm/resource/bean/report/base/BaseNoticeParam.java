package resource.bean.report.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the notice_param table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="notice_param"
 */

public abstract class BaseNoticeParam  implements Serializable {

	public static String REF = "NoticeParam";
	public static String PROP_NOTICE_TOTPERI = "noticeTotperi";
	public static String PROP_MISCFLGS = "miscflgs";
	public static String PROP_NOTICE_AMT = "noticeAmt";
	public static String PROP_UPDT = "updt";
	public static String PROP_CREATEDT = "createdt";
	public static String PROP_MISC_ONE = "miscOne";
	public static String PROP_MISC_TWO = "miscTwo";
	public static String PROP_ID = "id";
	public static String PROP_NOTICE_FLG = "noticeFlg";
	public static String PROP_NOTICE_VALUE = "noticeValue";
	public static String PROP_NOTICE_NAME = "noticeName";
	public static String PROP_BRCODE = "brcode";


	// constructors
	public BaseNoticeParam () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseNoticeParam (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String brcode;
	private java.util.Date createdt;
	private java.lang.String noticeName;
	private java.math.BigDecimal noticeValue;
	private java.math.BigDecimal noticeAmt;
	private java.lang.Integer noticeTotperi;
	private java.lang.String noticeFlg;
	private java.util.Date updt;
	private java.lang.String miscOne;
	private java.lang.String miscTwo;
	private java.lang.String miscflgs;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  column="id"
     */
	public java.lang.Integer getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (java.lang.Integer id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: brcode
	 */
	public java.lang.String getBrcode () {
		return brcode;
	}

	/**
	 * Set the value related to the column: brcode
	 * @param brcode the brcode value
	 */
	public void setBrcode (java.lang.String brcode) {
		this.brcode = brcode;
	}



	/**
	 * Return the value associated with the column: createdt
	 */
	public java.util.Date getCreatedt () {
		return createdt;
	}

	/**
	 * Set the value related to the column: createdt
	 * @param createdt the createdt value
	 */
	public void setCreatedt (java.util.Date createdt) {
		this.createdt = createdt;
	}



	/**
	 * Return the value associated with the column: notice_name
	 */
	public java.lang.String getNoticeName () {
		return noticeName;
	}

	/**
	 * Set the value related to the column: notice_name
	 * @param noticeName the notice_name value
	 */
	public void setNoticeName (java.lang.String noticeName) {
		this.noticeName = noticeName;
	}



	/**
	 * Return the value associated with the column: notice_value
	 */
	public java.math.BigDecimal getNoticeValue () {
		return noticeValue;
	}

	/**
	 * Set the value related to the column: notice_value
	 * @param noticeValue the notice_value value
	 */
	public void setNoticeValue (java.math.BigDecimal noticeValue) {
		this.noticeValue = noticeValue;
	}



	/**
	 * Return the value associated with the column: notice_amt
	 */
	public java.math.BigDecimal getNoticeAmt () {
		return noticeAmt;
	}

	/**
	 * Set the value related to the column: notice_amt
	 * @param noticeAmt the notice_amt value
	 */
	public void setNoticeAmt (java.math.BigDecimal noticeAmt) {
		this.noticeAmt = noticeAmt;
	}



	/**
	 * Return the value associated with the column: notice_totperi
	 */
	public java.lang.Integer getNoticeTotperi () {
		return noticeTotperi;
	}

	/**
	 * Set the value related to the column: notice_totperi
	 * @param noticeTotperi the notice_totperi value
	 */
	public void setNoticeTotperi (java.lang.Integer noticeTotperi) {
		this.noticeTotperi = noticeTotperi;
	}



	/**
	 * Return the value associated with the column: notice_flg
	 */
	public java.lang.String getNoticeFlg () {
		return noticeFlg;
	}

	/**
	 * Set the value related to the column: notice_flg
	 * @param noticeFlg the notice_flg value
	 */
	public void setNoticeFlg (java.lang.String noticeFlg) {
		this.noticeFlg = noticeFlg;
	}



	/**
	 * Return the value associated with the column: updt
	 */
	public java.util.Date getUpdt () {
		return updt;
	}

	/**
	 * Set the value related to the column: updt
	 * @param updt the updt value
	 */
	public void setUpdt (java.util.Date updt) {
		this.updt = updt;
	}



	/**
	 * Return the value associated with the column: misc_one
	 */
	public java.lang.String getMiscOne () {
		return miscOne;
	}

	/**
	 * Set the value related to the column: misc_one
	 * @param miscOne the misc_one value
	 */
	public void setMiscOne (java.lang.String miscOne) {
		this.miscOne = miscOne;
	}



	/**
	 * Return the value associated with the column: misc_two
	 */
	public java.lang.String getMiscTwo () {
		return miscTwo;
	}

	/**
	 * Set the value related to the column: misc_two
	 * @param miscTwo the misc_two value
	 */
	public void setMiscTwo (java.lang.String miscTwo) {
		this.miscTwo = miscTwo;
	}



	/**
	 * Return the value associated with the column: miscflgs
	 */
	public java.lang.String getMiscflgs () {
		return miscflgs;
	}

	/**
	 * Set the value related to the column: miscflgs
	 * @param miscflgs the miscflgs value
	 */
	public void setMiscflgs (java.lang.String miscflgs) {
		this.miscflgs = miscflgs;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof resource.bean.report.NoticeParam)) return false;
		else {
			resource.bean.report.NoticeParam noticeParam = (resource.bean.report.NoticeParam) obj;
			if (null == this.getId() || null == noticeParam.getId()) return false;
			else return (this.getId().equals(noticeParam.getId()));
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