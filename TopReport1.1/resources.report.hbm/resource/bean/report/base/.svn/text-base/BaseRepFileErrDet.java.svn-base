package resource.bean.report.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the REP_FILE_ERR_DET table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="REP_FILE_ERR_DET"
 */

public abstract class BaseRepFileErrDet  implements Serializable {

	public static String REF = "RepFileErrDet";
	public static String PROP_ERRDESC = "errdesc";
	public static String PROP_REP_FILE_NAME = "repFileName";
	public static String PROP_BUSSNO = "bussno";
	public static String PROP_REP_ERR_TYPE = "repErrType";
	public static String PROP_ID = "id";
	public static String PROP_APPTYPE = "apptype";
	public static String PROP_ERRFIELDCN = "errfieldcn";
	public static String PROP_ERRFIELD = "errfield";
	public static String PROP_CURRENTFILE = "currentfile";


	// constructors
	public BaseRepFileErrDet () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseRepFileErrDet (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;

	// fields
	private java.lang.String repFileName;
	private java.lang.String apptype;
	private java.lang.String currentfile;
	private java.lang.String repErrType;
	private java.lang.String errdesc;
	private java.lang.String bussno;
	private java.lang.String errfield;
	private java.lang.String errfieldcn;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  column="DET_ID"
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
	 * Return the value associated with the column: ERRDESC
	 */
	public java.lang.String getErrdesc () {
		return errdesc;
	}

	/**
	 * Set the value related to the column: ERRDESC
	 * @param errdesc the ERRDESC value
	 */
	public void setErrdesc (java.lang.String errdesc) {
		this.errdesc = errdesc;
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
	 * Return the value associated with the column: ERRFIELD
	 */
	public java.lang.String getErrfield () {
		return errfield;
	}

	/**
	 * Set the value related to the column: ERRFIELD
	 * @param errfield the ERRFIELD value
	 */
	public void setErrfield (java.lang.String errfield) {
		this.errfield = errfield;
	}



	/**
	 * Return the value associated with the column: ERRFIELDCN
	 */
	public java.lang.String getErrfieldcn () {
		return errfieldcn;
	}

	/**
	 * Set the value related to the column: ERRFIELDCN
	 * @param errfieldcn the ERRFIELDCN value
	 */
	public void setErrfieldcn (java.lang.String errfieldcn) {
		this.errfieldcn = errfieldcn;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof resource.bean.report.RepFileErrDet)) return false;
		else {
			resource.bean.report.RepFileErrDet repFileErrDet = (resource.bean.report.RepFileErrDet) obj;
			if (null == this.getId() || null == repFileErrDet.getId()) return false;
			else return (this.getId().equals(repFileErrDet.getId()));
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