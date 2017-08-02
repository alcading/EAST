package resource.bean.report.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the BI_ANALY_DETAIL_PARS table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="BI_ANALY_DETAIL_PARS"
 */

public abstract class BaseBiAnalyDetailPars  implements Serializable {

	public static String REF = "BiAnalyDetailPars";
	public static String PROP_PAR_NAME = "parName";
	public static String PROP_PAR_VALUE = "parValue";
	public static String PROP_DET_ID = "detId";
	public static String PROP_PAR_SEQ = "parSeq";
	public static String PROP_ID = "id";


	// constructors
	public BaseBiAnalyDetailPars () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBiAnalyDetailPars (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;

	// fields
	private java.lang.String detId;
	private java.lang.Integer parSeq;
	private java.lang.String parName;
	private java.lang.String parValue;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  column="PAR_ID"
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
	 * Return the value associated with the column: DET_ID
	 */
	public java.lang.String getDetId () {
		return detId;
	}

	/**
	 * Set the value related to the column: DET_ID
	 * @param detId the DET_ID value
	 */
	public void setDetId (java.lang.String detId) {
		this.detId = detId;
	}



	/**
	 * Return the value associated with the column: PAR_SEQ
	 */
	public java.lang.Integer getParSeq () {
		return parSeq;
	}

	/**
	 * Set the value related to the column: PAR_SEQ
	 * @param parSeq the PAR_SEQ value
	 */
	public void setParSeq (java.lang.Integer parSeq) {
		this.parSeq = parSeq;
	}



	/**
	 * Return the value associated with the column: PAR_NAME
	 */
	public java.lang.String getParName () {
		return parName;
	}

	/**
	 * Set the value related to the column: PAR_NAME
	 * @param parName the PAR_NAME value
	 */
	public void setParName (java.lang.String parName) {
		this.parName = parName;
	}



	/**
	 * Return the value associated with the column: PAR_VALUE
	 */
	public java.lang.String getParValue () {
		return parValue;
	}

	/**
	 * Set the value related to the column: PAR_VALUE
	 * @param parValue the PAR_VALUE value
	 */
	public void setParValue (java.lang.String parValue) {
		this.parValue = parValue;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof resource.bean.report.BiAnalyDetailPars)) return false;
		else {
			resource.bean.report.BiAnalyDetailPars biAnalyDetailPars = (resource.bean.report.BiAnalyDetailPars) obj;
			if (null == this.getId() || null == biAnalyDetailPars.getId()) return false;
			else return (this.getId().equals(biAnalyDetailPars.getId()));
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