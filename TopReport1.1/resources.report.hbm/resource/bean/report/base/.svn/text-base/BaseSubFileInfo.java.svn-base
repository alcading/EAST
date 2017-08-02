package resource.bean.report.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the SUB_FILE_INFO table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="SUB_FILE_INFO"
 */

public abstract class BaseSubFileInfo  implements Serializable {

	public static String REF = "SubFileInfo";
	public static String PROP_TOTALRECORDS = "totalrecords";
	public static String PROP_REP_FILE_NAME = "repFileName";
	public static String PROP_REP_ERR_TYPE = "repErrType";
	public static String PROP_APPTYPE = "apptype";
	public static String PROP_WORKDATE = "workdate";
	public static String PROP_CURRENTFILE = "currentfile";
	public static String PROP_REP_TM = "repTm";
	public static String PROP_FILE_PACK = "filePack";
	public static String PROP_ID = "id";
	public static String PROP_IS_IMP_REP = "isImpRep";
	public static String PROP_FALRECORDS = "falrecords";
	public static String PROP_BR_NO = "brNo";
	public static String PROP_CRT_TM = "crtTm";
	public static String PROP_SUCRECORDS = "sucrecords";
	public static String PROP_SUB_FILE_SEQ="subFileSeq";
	public static String PROP_FILE_DATE="fileDate";
	public static String BUSI_TYPE="busiType";
	public static String PROP_SUB = "isSub";
	public static String PROP_SUB_TYPE = "subType";
	public static String PROP_SUB_TM = "subTm";
	public static String PROP_SUB_TLR = "subTlr";
	// constructors
	public BaseSubFileInfo () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseSubFileInfo (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseSubFileInfo (
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
	private java.lang.String brNo;
	private java.util.Date crtTm;
	private java.lang.String repFileName;
	private java.util.Date repTm;
	private java.lang.String filePack;
	private java.lang.String repErrType;
	private java.lang.String workdate;
	private java.lang.String  isImpRep;
	private java.lang.Integer totalrecords;
	private java.lang.Integer sucrecords;
	private java.lang.Integer falrecords;
	private java.lang.String subFileSeq;//文件序号
	private java.lang.String fileDate;//文件日期
	private java.lang.String busiType;//所属业务类型
	private java.lang.String isSub;
	private java.util.Date subTm;
	private java.lang.String subType;
	private java.lang.String subTlr;


	public java.lang.String getIsSub() {
		return isSub;
	}

	public void setIsSub(java.lang.String isSub) {
		this.isSub = isSub;
	}

	public java.util.Date getSubTm() {
		return subTm;
	}

	public void setSubTm(java.util.Date subTm) {
		this.subTm = subTm;
	}

	public java.lang.String getSubType() {
		return subType;
	}

	public void setSubType(java.lang.String subType) {
		this.subType = subType;
	}

	public java.lang.String getSubTlr() {
		return subTlr;
	}

	public void setSubTlr(java.lang.String subTlr) {
		this.subTlr = subTlr;
	}

	public java.lang.String getBusiType() {
		return busiType;
	}

	public void setBusiType(java.lang.String busiType) {
		this.busiType = busiType;
	}

	public java.lang.String getFileDate() {
		return fileDate;
	}

	public void setFileDate(java.lang.String fileDate) {
		this.fileDate = fileDate;
	}

	public java.lang.String getSubFileSeq() {
		return subFileSeq;
	}

	public void setSubFileSeq(java.lang.String subFileSeq) {
		this.subFileSeq = subFileSeq;
	}

	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  column="FILE_NAME"
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
	 * Return the value associated with the column: REP_FILE_NAME
	 */
	public java.lang.String getRepFileName () {
		return repFileName;
	}

	/**
	 * Set the value related to the column: REP_FILE_NAME
	 * @param repFileName the REP_FILE_NAME value
	 */
	public void setRepFileName (java.lang.String repFileName) {
		this.repFileName = repFileName;
	}






	public java.util.Date getCrtTm() {
		return crtTm;
	}

	public void setCrtTm(java.util.Date crtTm) {
		this.crtTm = crtTm;
	}

	public java.util.Date getRepTm() {
		return repTm;
	}

	public void setRepTm(java.util.Date repTm) {
		this.repTm = repTm;
	}

	/**
	 * Return the value associated with the column: FILE_PACK
	 */
	public java.lang.String getFilePack () {
		return filePack;
	}

	/**
	 * Set the value related to the column: FILE_PACK
	 * @param filePack the FILE_PACK value
	 */
	public void setFilePack (java.lang.String filePack) {
		this.filePack = filePack;
	}



	/**
	 * Return the value associated with the column: REP_ERR_TYPE
	 */
	public java.lang.String getRepErrType () {
		return repErrType;
	}

	/**
	 * Set the value related to the column: REP_ERR_TYPE
	 * @param repErrType the REP_ERR_TYPE value
	 */
	public void setRepErrType (java.lang.String repErrType) {
		this.repErrType = repErrType;
	}



	/**
	 * Return the value associated with the column: WORKDATE
	 */
	public java.lang.String getWorkdate () {
		return workdate;
	}

	/**
	 * Set the value related to the column: WORKDATE
	 * @param workdate the WORKDATE value
	 */
	public void setWorkdate (java.lang.String workdate) {
		this.workdate = workdate;
	}






	public java.lang.String getIsImpRep() {
		return isImpRep;
	}

	public void setIsImpRep(java.lang.String isImpRep) {
		this.isImpRep = isImpRep;
	}

	/**
	 * Return the value associated with the column: TOTALRECORDS
	 */
	public java.lang.Integer getTotalrecords () {
		return totalrecords;
	}

	/**
	 * Set the value related to the column: TOTALRECORDS
	 * @param totalrecords the TOTALRECORDS value
	 */
	public void setTotalrecords (java.lang.Integer totalrecords) {
		this.totalrecords = totalrecords;
	}



	/**
	 * Return the value associated with the column: SUCRECORDS
	 */
	public java.lang.Integer getSucrecords () {
		return sucrecords;
	}

	/**
	 * Set the value related to the column: SUCRECORDS
	 * @param sucrecords the SUCRECORDS value
	 */
	public void setSucrecords (java.lang.Integer sucrecords) {
		this.sucrecords = sucrecords;
	}



	/**
	 * Return the value associated with the column: FALRECORDS
	 */
	public java.lang.Integer getFalrecords () {
		return falrecords;
	}

	/**
	 * Set the value related to the column: FALRECORDS
	 * @param falrecords the FALRECORDS value
	 */
	public void setFalrecords (java.lang.Integer falrecords) {
		this.falrecords = falrecords;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof resource.bean.report.SubFileInfo)) return false;
		else {
			resource.bean.report.SubFileInfo subFileInfo = (resource.bean.report.SubFileInfo) obj;
			if (null == this.getId() || null == subFileInfo.getId()) return false;
			else return (this.getId().equals(subFileInfo.getId()));
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