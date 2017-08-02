package resource.bean.report.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the BI_BOPJSH_RET_NO table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="BI_BOPJSH_RET_NO"
 */

public abstract class BaseBiBopjshRetNo  implements Serializable {

	public static String REF = "BiBopjshRetNo";
	public static String PROP_CUS_TYPES = "cusTypes";
	public static String PROP_NO_COMB = "noComb";
	public static String PROP_ID = "id";
	public static String PROP_SEQ_MAX = "seqMax";
	public static String PROP_DIST_CUS_TYPE = "distCusType";


	// constructors
	public BaseBiBopjshRetNo () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBiBopjshRetNo (resource.bean.report.BiBopjshRetNoPK id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private resource.bean.report.BiBopjshRetNoPK id;

	// fields
	private java.lang.String distCusType;
	private java.lang.String cusTypes;
	private java.lang.Integer seqMax;
	private java.lang.String noComb;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     */
	public resource.bean.report.BiBopjshRetNoPK getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (resource.bean.report.BiBopjshRetNoPK id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: DIST_CUS_TYPE
	 */
	public java.lang.String getDistCusType () {
		return distCusType;
	}

	/**
	 * Set the value related to the column: DIST_CUS_TYPE
	 * @param distCusType the DIST_CUS_TYPE value
	 */
	public void setDistCusType (java.lang.String distCusType) {
		this.distCusType = distCusType;
	}



	/**
	 * Return the value associated with the column: CUS_TYPES
	 */
	public java.lang.String getCusTypes () {
		return cusTypes;
	}

	/**
	 * Set the value related to the column: CUS_TYPES
	 * @param cusTypes the CUS_TYPES value
	 */
	public void setCusTypes (java.lang.String cusTypes) {
		this.cusTypes = cusTypes;
	}



	/**
	 * Return the value associated with the column: SEQ_MAX
	 */
	public java.lang.Integer getSeqMax () {
		return seqMax;
	}

	/**
	 * Set the value related to the column: SEQ_MAX
	 * @param seqMax the SEQ_MAX value
	 */
	public void setSeqMax (java.lang.Integer seqMax) {
		this.seqMax = seqMax;
	}



	/**
	 * Return the value associated with the column: NO_COMB
	 */
	public java.lang.String getNoComb () {
		return noComb;
	}

	/**
	 * Set the value related to the column: NO_COMB
	 * @param noComb the NO_COMB value
	 */
	public void setNoComb (java.lang.String noComb) {
		this.noComb = noComb;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof resource.bean.report.BiBopjshRetNo)) return false;
		else {
			resource.bean.report.BiBopjshRetNo biBopjshRetNo = (resource.bean.report.BiBopjshRetNo) obj;
			if (null == this.getId() || null == biBopjshRetNo.getId()) return false;
			else return (this.getId().equals(biBopjshRetNo.getId()));
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