package resource.bean.report.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the MTS_BOP_CUSTOM table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="MTS_BOP_CUSTOM"
 */

public abstract class BaseMtsBopCustom  implements Serializable {

	public static String REF = "MtsBopCustom";
	public static String PROP_CUSTAMT = "custamt";
	public static String PROP_CUSTOMN = "customn";
	public static String PROP_ID = "id";
	public static String PROP_CRT_TM = "crtTm";
	public static String PROP_OFFAMT = "offamt";
	public static String PROP_CUSTCCY = "custccy";
	public static String PROP_REC_ID = "recId";


	// constructors
	public BaseMtsBopCustom () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMtsBopCustom (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;

	// fields
	private java.lang.String recId;
	private java.util.Date crtTm;
	private java.lang.String customn;
	private java.lang.String custccy;
	private java.lang.Integer custamt;
	private java.lang.Integer offamt;



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



	/**
	 * Return the value associated with the column: CUSTOMN
	 */
	public java.lang.String getCustomn () {
		return customn;
	}

	/**
	 * Set the value related to the column: CUSTOMN
	 * @param customn the CUSTOMN value
	 */
	public void setCustomn (java.lang.String customn) {
		this.customn = customn;
	}



	/**
	 * Return the value associated with the column: CUSTCCY
	 */
	public java.lang.String getCustccy () {
		return custccy;
	}

	/**
	 * Set the value related to the column: CUSTCCY
	 * @param custccy the CUSTCCY value
	 */
	public void setCustccy (java.lang.String custccy) {
		this.custccy = custccy;
	}



	/**
	 * Return the value associated with the column: CUSTAMT
	 */
	public java.lang.Integer getCustamt () {
		return custamt;
	}

	/**
	 * Set the value related to the column: CUSTAMT
	 * @param custamt the CUSTAMT value
	 */
	public void setCustamt (java.lang.Integer custamt) {
		this.custamt = custamt;
	}



	/**
	 * Return the value associated with the column: OFFAMT
	 */
	public java.lang.Integer getOffamt () {
		return offamt;
	}

	/**
	 * Set the value related to the column: OFFAMT
	 * @param offamt the OFFAMT value
	 */
	public void setOffamt (java.lang.Integer offamt) {
		this.offamt = offamt;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof resource.bean.report.MtsBopCustom)) return false;
		else {
			resource.bean.report.MtsBopCustom mtsBopCustom = (resource.bean.report.MtsBopCustom) obj;
			if (null == this.getId() || null == mtsBopCustom.getId()) return false;
			else return (this.getId().equals(mtsBopCustom.getId()));
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