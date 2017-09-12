package resource.bean.report.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the ALREADY_SUB_INFO table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="ALREADY_SUB_INFO"
 */

public abstract class BaseAlreadySubInfo  implements Serializable {

	private static final long serialVersionUID = -6461049724247333542L;
	public static String REF = "AlreadySubInfo";
	public static String PROP_FILE_SEQ = "fileSeq";
	public static String PROP_FILE_NAME = "fileName";
	public static String PROP_REC_DATE = "recDate";
	public static String PROP_BUSSNO = "bussno";
	public static String PROP_ID = "id";
	public static String PROP_APPTYPE = "apptype";
	public static String PROP_BR_NO = "brNo";
	public static String PROP_REC_ID = "recId";
	public static String PROP_CURRENTFILE = "currentfile";


	// constructors
	public BaseAlreadySubInfo () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseAlreadySubInfo (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseAlreadySubInfo (
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
	private java.lang.String recId;
	private java.lang.String bussno;
	private java.lang.String recDate;
	private java.lang.String brNo;
	private java.lang.String fileName;
	private java.lang.String fileSeq;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  column="ID"
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
	 * Return the value associated with the column: REC_ID
	 */
	public java.lang.String getRecId () {
		return recId;
	}

	/**
	 * Set the value related to the column: REC_ID
	 * @param recId the REC_ID value
	 */
	public void setRecId (java.lang.String recId) {
		this.recId = recId;
	}



	/**
	 * Return the value associated with the column: BUSSNO
	 */
	public java.lang.String getBussno () {
		return bussno;
	}

	/**
	 * Set the value related to the column: BUSSNO
	 * @param bussno the BUSSNO value
	 */
	public void setBussno (java.lang.String bussno) {
		this.bussno = bussno;
	}



	/**
	 * Return the value associated with the column: REC_DATE
	 */
	public java.lang.String getRecDate () {
		return recDate;
	}

	/**
	 * Set the value related to the column: REC_DATE
	 * @param recDate the REC_DATE value
	 */
	public void setRecDate (java.lang.String recDate) {
		this.recDate = recDate;
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
	 * Return the value associated with the column: FILE_NAME
	 */
	public java.lang.String getFileName () {
		return fileName;
	}

	/**
	 * Set the value related to the column: FILE_NAME
	 * @param fileName the FILE_NAME value
	 */
	public void setFileName (java.lang.String fileName) {
		this.fileName = fileName;
	}



	/**
	 * Return the value associated with the column: FILE_SEQ
	 */
	public java.lang.String getFileSeq () {
		return fileSeq;
	}

	/**
	 * Set the value related to the column: FILE_SEQ
	 * @param fileSeq the FILE_SEQ value
	 */
	public void setFileSeq (java.lang.String fileSeq) {
		this.fileSeq = fileSeq;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof resource.bean.report.AlreadySubInfo)) return false;
		else {
			resource.bean.report.AlreadySubInfo alreadySubInfo = (resource.bean.report.AlreadySubInfo) obj;
			if (null == this.getId() || null == alreadySubInfo.getId()) return false;
			else return (this.getId().equals(alreadySubInfo.getId()));
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