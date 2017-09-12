package resource.bean.report.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the SYS_BUSINAV_CONF table.
 * Do not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 *
 * @hibernate.class table="SYS_BUSINAV_CONF"
 */

public abstract class BaseSysBusinavConf implements Serializable {

	public static String REF = "SysBusinavConf";
	public static String PROP_BUSI_NM = "busiNm";
	public static String PROP_URL_PATH = "urlPath";
	public static String PROP_PARENT_CODE = "parentCode";
	public static String PROP_ID = "id";
	public static String PROP_SHOW_SEQ = "showSeq";
	public static String PROP_APPROVE_URL = "approveUrl";
	public static String PROP_QUERY_URL = "queryUrl";
	public static String PROP_MAKEFILE_URL = "makefileUrl";
	public static String PROP_BUSI_TYPE = "busiType";

	// constructors
	public BaseSysBusinavConf() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseSysBusinavConf(java.lang.String id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;

	// fields
	private java.lang.String busiNm;
	private java.lang.String parentCode;
	private java.lang.Integer showSeq;
	private java.lang.String urlPath;
	private java.lang.String approveUrl;
	private java.lang.String queryUrl;
	private java.lang.String makefileUrl;
	private java.lang.String busiType;
	/**
	 * Return the unique identifier of this class
	 *
	 * @hibernate.id column="BUSI_CODE"
	 */
	public java.lang.String getId() {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 *
	 * @param id
	 *            the new ID
	 */
	public void setId(java.lang.String id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}

	public java.lang.String getBusiType() {
		return busiType;
	}

	public void setBusiType(java.lang.String busiType) {
		this.busiType = busiType;
	}

	/**
	 * Return the value associated with the column: BUSI_NM
	 */
	public java.lang.String getBusiNm() {
		return busiNm;
	}

	/**
	 * Set the value related to the column: BUSI_NM
	 *
	 * @param busiNm
	 *            the BUSI_NM value
	 */
	public void setBusiNm(java.lang.String busiNm) {
		this.busiNm = busiNm;
	}

	/**
	 * Return the value associated with the column: PARENT_CODE
	 */
	public java.lang.String getParentCode() {
		return parentCode;
	}

	/**
	 * Set the value related to the column: PARENT_CODE
	 *
	 * @param parentCode
	 *            the PARENT_CODE value
	 */
	public void setParentCode(java.lang.String parentCode) {
		this.parentCode = parentCode;
	}

	/**
	 * Return the value associated with the column: SHOW_SEQ
	 */
	public java.lang.Integer getShowSeq() {
		return showSeq;
	}

	/**
	 * Set the value related to the column: SHOW_SEQ
	 *
	 * @param showSeq
	 *            the SHOW_SEQ value
	 */
	public void setShowSeq(java.lang.Integer showSeq) {
		this.showSeq = showSeq;
	}

	/**
	 * Return the value associated with the column: URL_PATH
	 */
	public java.lang.String getUrlPath() {
		return urlPath;
	}

	/**
	 * Set the value related to the column: URL_PATH
	 *
	 * @param urlPath
	 *            the URL_PATH value
	 */
	public void setUrlPath(java.lang.String urlPath) {
		this.urlPath = urlPath;
	}

	public int getHashCode() {
		return hashCode;
	}

	public void setHashCode(int hashCode) {
		this.hashCode = hashCode;
	}

	public java.lang.String getApproveUrl() {
		return approveUrl;
	}

	public void setApproveUrl(java.lang.String approveUrl) {
		this.approveUrl = approveUrl;
	}

	public java.lang.String getQueryUrl() {
		return queryUrl;
	}

	public void setQueryUrl(java.lang.String queryUrl) {
		this.queryUrl = queryUrl;
	}

	public java.lang.String getMakefileUrl() {
		return makefileUrl;
	}

	public void setMakefileUrl(java.lang.String makefileUrl) {
		this.makefileUrl = makefileUrl;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof resource.bean.report.SysBusinavConf))
			return false;
		else {
			resource.bean.report.SysBusinavConf sysBusinavConf = (resource.bean.report.SysBusinavConf) obj;
			if (null == this.getId() || null == sysBusinavConf.getId())
				return false;
			else
				return (this.getId().equals(sysBusinavConf.getId()));
		}
	}

	public int hashCode() {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId())
				return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}

	public String toString() {
		return super.toString();
	}

}