package resource.bean.report.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the MTS_IN_OUT_CODE table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="MTS_IN_OUT_CODE"
 */

public abstract class BaseMtsInOutCode  implements Serializable {

	public static String REF = "MtsInOutCode";
	public static String PROP_PARENT_ID = "parentId";
	public static String PROP_CODE_NAME = "codeName";
	public static String PROP_ID = "id";
	public static String PROP_FILLER1 = "filler1";
	public static String PROP_FILLER3 = "filler3";
	public static String PROP_FILLER2 = "filler2";


	// constructors
	public BaseMtsInOutCode () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMtsInOutCode (resource.bean.report.MtsInOutCodePK id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private resource.bean.report.MtsInOutCodePK id;

	// fields
	private java.lang.String parentId;
	private java.lang.String codeName;
	private java.lang.String filler1;
	private java.lang.String filler2;
	private java.lang.String filler3;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     */
	public resource.bean.report.MtsInOutCodePK getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (resource.bean.report.MtsInOutCodePK id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: PARENT_ID
	 */
	public java.lang.String getParentId () {
		return parentId;
	}

	/**
	 * Set the value related to the column: PARENT_ID
	 * @param parentId the PARENT_ID value
	 */
	public void setParentId (java.lang.String parentId) {
		this.parentId = parentId;
	}



	/**
	 * Return the value associated with the column: CODE_NAME
	 */
	public java.lang.String getCodeName () {
		return codeName;
	}

	/**
	 * Set the value related to the column: CODE_NAME
	 * @param codeName the CODE_NAME value
	 */
	public void setCodeName (java.lang.String codeName) {
		this.codeName = codeName;
	}



	/**
	 * Return the value associated with the column: FILLER1
	 */
	public java.lang.String getFiller1 () {
		return filler1;
	}

	/**
	 * Set the value related to the column: FILLER1
	 * @param filler1 the FILLER1 value
	 */
	public void setFiller1 (java.lang.String filler1) {
		this.filler1 = filler1;
	}



	/**
	 * Return the value associated with the column: FILLER2
	 */
	public java.lang.String getFiller2 () {
		return filler2;
	}

	/**
	 * Set the value related to the column: FILLER2
	 * @param filler2 the FILLER2 value
	 */
	public void setFiller2 (java.lang.String filler2) {
		this.filler2 = filler2;
	}



	/**
	 * Return the value associated with the column: FILLER3
	 */
	public java.lang.String getFiller3 () {
		return filler3;
	}

	/**
	 * Set the value related to the column: FILLER3
	 * @param filler3 the FILLER3 value
	 */
	public void setFiller3 (java.lang.String filler3) {
		this.filler3 = filler3;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof resource.bean.report.MtsInOutCode)) return false;
		else {
			resource.bean.report.MtsInOutCode mtsInOutCode = (resource.bean.report.MtsInOutCode) obj;
			if (null == this.getId() || null == mtsInOutCode.getId()) return false;
			else return (this.getId().equals(mtsInOutCode.getId()));
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