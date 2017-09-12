package resource.bean.report.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the BI_ANALY_CONF table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="BI_ANALY_CONF"
 */

public abstract class BaseBiAnalyConf  implements Serializable {

	public static String REF = "BiAnalyConf";
	public static String PROP_CONF_DATE = "confDate";
	public static String PROP_CONF_VAILD = "confVaild";
	public static String PROP_CONF_INFO = "confInfo";
	public static String PROP_CONF_SEQ = "confSeq";
	public static String PROP_ID = "id";
	public static String PROP_CONF_CLASS_PATH = "confClassPath";
	public static String PROP_BUSI_TYPE = "busiType";
	public static String PROP_APP_TYPE = "appType";
	public static String PROP_CONF_TYPE = "confType";
	public static String PROP_CONF_IS_RET = "confIsRet";
	public static String PROP_CONF_RET_CLASS = "confRetClass";
	public static String PROP_CONF_PARAM_IDS = "confParamIds";
	public static String PROP_ERR_IS_NEXT = "errIsNext";
	// constructors
	public BaseBiAnalyConf () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBiAnalyConf (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;

	// fields
	private java.lang.Integer confSeq;
	private java.lang.String confClassPath;
	private java.lang.String confInfo;
	private java.lang.String busiType;
	private java.lang.String confDate;
	private java.lang.String confVaild;
	private java.lang.String appType;
	private java.lang.String confType;
	private java.lang.String confIsRet;
	private java.lang.String confRetClass;
	private java.lang.String confParamIds;
	private java.lang.String errIsNext;

	public java.lang.String getErrIsNext() {
		return errIsNext;
	}

	public void setErrIsNext(java.lang.String errIsNext) {
		this.errIsNext = errIsNext;
	}

	public java.lang.String getConfParamIds() {
		return confParamIds;
	}

	public void setConfParamIds(java.lang.String confParamIds) {
		this.confParamIds = confParamIds;
	}

	public java.lang.String getConfType() {
		return confType;
	}

	public void setConfType(java.lang.String confType) {
		this.confType = confType;
	}

	public java.lang.String getConfIsRet() {
		return confIsRet;
	}

	public void setConfIsRet(java.lang.String confIsRet) {
		this.confIsRet = confIsRet;
	}

	public java.lang.String getConfRetClass() {
		return confRetClass;
	}

	public void setConfRetClass(java.lang.String confRetClass) {
		this.confRetClass = confRetClass;
	}

	public java.lang.String getAppType() {
		return appType;
	}

	public void setAppType(java.lang.String appType) {
		this.appType = appType;
	}

	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="CONF_ID"
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
	 * Return the value associated with the column: CONF_SEQ
	 */
	public java.lang.Integer getConfSeq () {
		return confSeq;
	}

	/**
	 * Set the value related to the column: CONF_SEQ
	 * @param confSeq the CONF_SEQ value
	 */
	public void setConfSeq (java.lang.Integer confSeq) {
		this.confSeq = confSeq;
	}



	/**
	 * Return the value associated with the column: CONF_CLASS_PATH
	 */
	public java.lang.String getConfClassPath () {
		return confClassPath;
	}

	/**
	 * Set the value related to the column: CONF_CLASS_PATH
	 * @param confClassPath the CONF_CLASS_PATH value
	 */
	public void setConfClassPath (java.lang.String confClassPath) {
		this.confClassPath = confClassPath;
	}



	/**
	 * Return the value associated with the column: CONF_INFO
	 */
	public java.lang.String getConfInfo () {
		return confInfo;
	}

	/**
	 * Set the value related to the column: CONF_INFO
	 * @param confInfo the CONF_INFO value
	 */
	public void setConfInfo (java.lang.String confInfo) {
		this.confInfo = confInfo;
	}



	/**
	 * Return the value associated with the column: BUSI_TYPE
	 */
	public java.lang.String getBusiType () {
		return busiType;
	}

	/**
	 * Set the value related to the column: BUSI_TYPE
	 * @param busiType the BUSI_TYPE value
	 */
	public void setBusiType (java.lang.String busiType) {
		this.busiType = busiType;
	}



	/**
	 * Return the value associated with the column: CONF_DATE
	 */
	public java.lang.String getConfDate () {
		return confDate;
	}

	/**
	 * Set the value related to the column: CONF_DATE
	 * @param confDate the CONF_DATE value
	 */
	public void setConfDate (java.lang.String confDate) {
		this.confDate = confDate;
	}



	/**
	 * Return the value associated with the column: CONF_VAILD
	 */
	public java.lang.String getConfVaild () {
		return confVaild;
	}

	/**
	 * Set the value related to the column: CONF_VAILD
	 * @param confVaild the CONF_VAILD value
	 */
	public void setConfVaild (java.lang.String confVaild) {
		this.confVaild = confVaild;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof resource.bean.report.BiAnalyConf)) return false;
		else {
			resource.bean.report.BiAnalyConf biAnalyConf = (resource.bean.report.BiAnalyConf) obj;
			if (null == this.getId() || null == biAnalyConf.getId()) return false;
			else return (this.getId().equals(biAnalyConf.getId()));
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