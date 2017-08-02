package resource.bean.report.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the customer_info table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="customer_info"
 */

public abstract class BaseCustomerInfo  implements Serializable {

	public static String REF = "CustomerInfo";
	public static String PROP_BIRTHDAY = "birthday";
	public static String PROP_ZIP_CODE = "zipCode";
	public static String PROP_UPDT = "updt";
	public static String PROP_CRUM = "crum";
	public static String PROP_CLOSEDT = "closedt";
	public static String PROP_CMRM = "cmrm";
	public static String PROP_MOBILE_PHONE_NUMBER = "mobilePhoneNumber";
	public static String PROP_ADDRESS = "address";
	public static String PROP_VIPFLG = "vipflg";
	public static String PROP_DESC2 = "desc2";
	public static String PROP_LAST_UPDT_VIP = "lastUpdtVip";
	public static String PROP_LAST_VIPFLG = "lastVipflg";
	public static String PROP_CLOC = "cloc";
	public static String PROP_DESC1 = "desc1";
	public static String PROP_HOME_PHONE_NUMBER = "homePhoneNumber";
	public static String PROP_CREATEDATE = "createdate";
	public static String PROP_IDNO = "idno";
	public static String PROP_MISCFLG = "miscflg";
	public static String PROP_CLOSEFLG = "closeflg";
	public static String PROP_LAST_UPDT_ACRM = "lastUpdtAcrm";
	public static String PROP_SOL_ID = "solId";
	public static String PROP_ACRM = "acrm";
	public static String PROP_VIP_CLASS = "vipClass";
	public static String PROP_CHINESE_NAME = "chineseName";
	public static String PROP_ID = "id";


	// constructors
	public BaseCustomerInfo () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseCustomerInfo (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;

	// fields
	private java.lang.String acrm;
	private java.lang.String address;
	private java.util.Date birthday;
	private java.lang.String chineseName;
	private java.lang.String cloc;
	private java.util.Date closedt;
	private java.lang.String closeflg;
	private java.lang.String cmrm;
	private java.util.Date createdate;
	private java.lang.String crum;
	private java.lang.String desc1;
	private java.lang.String desc2;
	private java.lang.String homePhoneNumber;
	private java.lang.String idno;
	private java.util.Date lastUpdtAcrm;
	private java.util.Date lastUpdtVip;
	private java.lang.String lastVipflg;
	private java.lang.String miscflg;
	private java.lang.String mobilePhoneNumber;
	private java.lang.String solId;
	private java.util.Date updt;
	private java.lang.String vipClass;
	private java.lang.String vipflg;
	private java.lang.String zipCode;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  column="cnum"
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
	 * Return the value associated with the column: acrm
	 */
	public java.lang.String getAcrm () {
		return acrm;
	}

	/**
	 * Set the value related to the column: acrm
	 * @param acrm the acrm value
	 */
	public void setAcrm (java.lang.String acrm) {
		this.acrm = acrm;
	}



	/**
	 * Return the value associated with the column: address
	 */
	public java.lang.String getAddress () {
		return address;
	}

	/**
	 * Set the value related to the column: address
	 * @param address the address value
	 */
	public void setAddress (java.lang.String address) {
		this.address = address;
	}



	/**
	 * Return the value associated with the column: birthday
	 */
	public java.util.Date getBirthday () {
		return birthday;
	}

	/**
	 * Set the value related to the column: birthday
	 * @param birthday the birthday value
	 */
	public void setBirthday (java.util.Date birthday) {
		this.birthday = birthday;
	}



	/**
	 * Return the value associated with the column: chinese_name
	 */
	public java.lang.String getChineseName () {
		return chineseName;
	}

	/**
	 * Set the value related to the column: chinese_name
	 * @param chineseName the chinese_name value
	 */
	public void setChineseName (java.lang.String chineseName) {
		this.chineseName = chineseName;
	}



	/**
	 * Return the value associated with the column: cloc
	 */
	public java.lang.String getCloc () {
		return cloc;
	}

	/**
	 * Set the value related to the column: cloc
	 * @param cloc the cloc value
	 */
	public void setCloc (java.lang.String cloc) {
		this.cloc = cloc;
	}



	/**
	 * Return the value associated with the column: closedt
	 */
	public java.util.Date getClosedt () {
		return closedt;
	}

	/**
	 * Set the value related to the column: closedt
	 * @param closedt the closedt value
	 */
	public void setClosedt (java.util.Date closedt) {
		this.closedt = closedt;
	}



	/**
	 * Return the value associated with the column: closeflg
	 */
	public java.lang.String getCloseflg () {
		return closeflg;
	}

	/**
	 * Set the value related to the column: closeflg
	 * @param closeflg the closeflg value
	 */
	public void setCloseflg (java.lang.String closeflg) {
		this.closeflg = closeflg;
	}



	/**
	 * Return the value associated with the column: cmrm
	 */
	public java.lang.String getCmrm () {
		return cmrm;
	}

	/**
	 * Set the value related to the column: cmrm
	 * @param cmrm the cmrm value
	 */
	public void setCmrm (java.lang.String cmrm) {
		this.cmrm = cmrm;
	}



	/**
	 * Return the value associated with the column: createdate
	 */
	public java.util.Date getCreatedate () {
		return createdate;
	}

	/**
	 * Set the value related to the column: createdate
	 * @param createdate the createdate value
	 */
	public void setCreatedate (java.util.Date createdate) {
		this.createdate = createdate;
	}



	/**
	 * Return the value associated with the column: crum
	 */
	public java.lang.String getCrum () {
		return crum;
	}

	/**
	 * Set the value related to the column: crum
	 * @param crum the crum value
	 */
	public void setCrum (java.lang.String crum) {
		this.crum = crum;
	}



	/**
	 * Return the value associated with the column: desc1
	 */
	public java.lang.String getDesc1 () {
		return desc1;
	}

	/**
	 * Set the value related to the column: desc1
	 * @param desc1 the desc1 value
	 */
	public void setDesc1 (java.lang.String desc1) {
		this.desc1 = desc1;
	}



	/**
	 * Return the value associated with the column: desc2
	 */
	public java.lang.String getDesc2 () {
		return desc2;
	}

	/**
	 * Set the value related to the column: desc2
	 * @param desc2 the desc2 value
	 */
	public void setDesc2 (java.lang.String desc2) {
		this.desc2 = desc2;
	}



	/**
	 * Return the value associated with the column: home_phone_number
	 */
	public java.lang.String getHomePhoneNumber () {
		return homePhoneNumber;
	}

	/**
	 * Set the value related to the column: home_phone_number
	 * @param homePhoneNumber the home_phone_number value
	 */
	public void setHomePhoneNumber (java.lang.String homePhoneNumber) {
		this.homePhoneNumber = homePhoneNumber;
	}



	/**
	 * Return the value associated with the column: idno
	 */
	public java.lang.String getIdno () {
		return idno;
	}

	/**
	 * Set the value related to the column: idno
	 * @param idno the idno value
	 */
	public void setIdno (java.lang.String idno) {
		this.idno = idno;
	}



	/**
	 * Return the value associated with the column: last_updt_acrm
	 */
	public java.util.Date getLastUpdtAcrm () {
		return lastUpdtAcrm;
	}

	/**
	 * Set the value related to the column: last_updt_acrm
	 * @param lastUpdtAcrm the last_updt_acrm value
	 */
	public void setLastUpdtAcrm (java.util.Date lastUpdtAcrm) {
		this.lastUpdtAcrm = lastUpdtAcrm;
	}



	/**
	 * Return the value associated with the column: last_updt_vip
	 */
	public java.util.Date getLastUpdtVip () {
		return lastUpdtVip;
	}

	/**
	 * Set the value related to the column: last_updt_vip
	 * @param lastUpdtVip the last_updt_vip value
	 */
	public void setLastUpdtVip (java.util.Date lastUpdtVip) {
		this.lastUpdtVip = lastUpdtVip;
	}



	/**
	 * Return the value associated with the column: last_vipflg
	 */
	public java.lang.String getLastVipflg () {
		return lastVipflg;
	}

	/**
	 * Set the value related to the column: last_vipflg
	 * @param lastVipflg the last_vipflg value
	 */
	public void setLastVipflg (java.lang.String lastVipflg) {
		this.lastVipflg = lastVipflg;
	}



	/**
	 * Return the value associated with the column: miscflg
	 */
	public java.lang.String getMiscflg () {
		return miscflg;
	}

	/**
	 * Set the value related to the column: miscflg
	 * @param miscflg the miscflg value
	 */
	public void setMiscflg (java.lang.String miscflg) {
		this.miscflg = miscflg;
	}



	/**
	 * Return the value associated with the column: mobile_phone_number
	 */
	public java.lang.String getMobilePhoneNumber () {
		return mobilePhoneNumber;
	}

	/**
	 * Set the value related to the column: mobile_phone_number
	 * @param mobilePhoneNumber the mobile_phone_number value
	 */
	public void setMobilePhoneNumber (java.lang.String mobilePhoneNumber) {
		this.mobilePhoneNumber = mobilePhoneNumber;
	}



	/**
	 * Return the value associated with the column: sol_id
	 */
	public java.lang.String getSolId () {
		return solId;
	}

	/**
	 * Set the value related to the column: sol_id
	 * @param solId the sol_id value
	 */
	public void setSolId (java.lang.String solId) {
		this.solId = solId;
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
	 * Return the value associated with the column: vip_class
	 */
	public java.lang.String getVipClass () {
		return vipClass;
	}

	/**
	 * Set the value related to the column: vip_class
	 * @param vipClass the vip_class value
	 */
	public void setVipClass (java.lang.String vipClass) {
		this.vipClass = vipClass;
	}



	/**
	 * Return the value associated with the column: vipflg
	 */
	public java.lang.String getVipflg () {
		return vipflg;
	}

	/**
	 * Set the value related to the column: vipflg
	 * @param vipflg the vipflg value
	 */
	public void setVipflg (java.lang.String vipflg) {
		this.vipflg = vipflg;
	}



	/**
	 * Return the value associated with the column: zip_code
	 */
	public java.lang.String getZipCode () {
		return zipCode;
	}

	/**
	 * Set the value related to the column: zip_code
	 * @param zipCode the zip_code value
	 */
	public void setZipCode (java.lang.String zipCode) {
		this.zipCode = zipCode;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof resource.bean.report.CustomerInfo)) return false;
		else {
			resource.bean.report.CustomerInfo customerInfo = (resource.bean.report.CustomerInfo) obj;
			if (null == this.getId() || null == customerInfo.getId()) return false;
			else return (this.getId().equals(customerInfo.getId()));
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