package resource.bean.report.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the BOP_EXGU_TOR_DS table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="BOP_EXGU_TOR_DS"
 */

public abstract class BaseBopExguTorDs  implements Serializable {

	public static String REF = "BopExguTorDs";
	public static String PROP_TOR_CODE = "torCode";
	public static String PROP_TOR_NAME = "torName";
	public static String PROP_ID = "id";
	public static String PROP_TOR_TYPE = "torType";
	public static String PROP_TOR_ENNAME = "torEnname";
	public static String PROP_COUNTRY_CODE = "countryCode";
	public static String PROP_CRT_TM = "crtTm";
	public static String PROP_REC_ID = "recId";
	public static String PROP_TOR_TYPE_CODE = "torTypeCode";
	

	// constructors
	public BaseBopExguTorDs () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBopExguTorDs (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;

	// fields
	private java.lang.String torCode;
	private java.lang.String torName;
	private java.lang.String torEnname;
	private java.lang.String torType;
	private java.lang.String countryCode;
	private java.util.Date crtTm;
	private java.lang.String recId;
	private java.lang.String torTypeCode;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  column="TOR_ID"
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




	public java.lang.String getTorTypeCode() {
		return torTypeCode;
	}

	public void setTorTypeCode(java.lang.String torTypeCode) {
		this.torTypeCode = torTypeCode;
	}

	/**
	 * Return the value associated with the column: TOR_CODE
	 */
	public java.lang.String getTorCode () {
		return torCode;
	}

	/**
	 * Set the value related to the column: TOR_CODE
	 * @param torCode the TOR_CODE value
	 */
	public void setTorCode (java.lang.String torCode) {
		this.torCode = torCode;
	}



	/**
	 * Return the value associated with the column: TOR_NAME
	 */
	public java.lang.String getTorName () {
		return torName;
	}

	/**
	 * Set the value related to the column: TOR_NAME
	 * @param torName the TOR_NAME value
	 */
	public void setTorName (java.lang.String torName) {
		this.torName = torName;
	}



	/**
	 * Return the value associated with the column: TOR_ENNAME
	 */
	public java.lang.String getTorEnname () {
		return torEnname;
	}

	/**
	 * Set the value related to the column: TOR_ENNAME
	 * @param torEnname the TOR_ENNAME value
	 */
	public void setTorEnname (java.lang.String torEnname) {
		this.torEnname = torEnname;
	}



	/**
	 * Return the value associated with the column: TOR_TYPE
	 */
	public java.lang.String getTorType () {
		return torType;
	}

	/**
	 * Set the value related to the column: TOR_TYPE
	 * @param torType the TOR_TYPE value
	 */
	public void setTorType (java.lang.String torType) {
		this.torType = torType;
	}



	/**
	 * Return the value associated with the column: COUNTRY_CODE
	 */
	public java.lang.String getCountryCode () {
		return countryCode;
	}

	/**
	 * Set the value related to the column: COUNTRY_CODE
	 * @param countryCode the COUNTRY_CODE value
	 */
	public void setCountryCode (java.lang.String countryCode) {
		this.countryCode = countryCode;
	}







	public java.util.Date getCrtTm() {
		return crtTm;
	}

	public void setCrtTm(java.util.Date crtTm) {
		this.crtTm = crtTm;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof resource.bean.report.BopExguTorDs)) return false;
		else {
			resource.bean.report.BopExguTorDs bopExguTorDs = (resource.bean.report.BopExguTorDs) obj;
			if (null == this.getId() || null == bopExguTorDs.getId()) return false;
			else return (this.getId().equals(bopExguTorDs.getId()));
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