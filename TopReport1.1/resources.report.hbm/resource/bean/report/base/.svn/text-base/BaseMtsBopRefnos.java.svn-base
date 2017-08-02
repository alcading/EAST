package resource.bean.report.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the MTS_BOP_REFNOS table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="MTS_BOP_REFNOS"
 */

public abstract class BaseMtsBopRefnos  implements Serializable {

	public static String REF = "MtsBopRefnos";
	public static String PROP_ID = "id";
	public static String PROP_REFNO = "refno";
	public static String PROP_CRT_TM = "crtTm";
	public static String PROP_REC_ID = "recId";


	// constructors
	public BaseMtsBopRefnos () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMtsBopRefnos (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;

	// fields
	private java.lang.String refno;
	private java.lang.String recId;
	private java.util.Date crtTm;



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
	 * Return the value associated with the column: REFNO
	 */
	public java.lang.String getRefno () {
		return refno;
	}

	/**
	 * Set the value related to the column: REFNO
	 * @param refno the REFNO value
	 */
	public void setRefno (java.lang.String refno) {
		this.refno = refno;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof resource.bean.report.MtsBopRefnos)) return false;
		else {
			resource.bean.report.MtsBopRefnos mtsBopRefnos = (resource.bean.report.MtsBopRefnos) obj;
			if (null == this.getId() || null == mtsBopRefnos.getId()) return false;
			else return (this.getId().equals(mtsBopRefnos.getId()));
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