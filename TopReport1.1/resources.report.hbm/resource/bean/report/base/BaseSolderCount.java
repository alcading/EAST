package resource.bean.report.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the solder_count table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="solder_count"
 */

public abstract class BaseSolderCount  implements Serializable {

	public static String REF = "SolderCount";
	public static String PROP_ONLYAMT = "onlyamt";
	public static String PROP_INAMT = "inamt";
	public static String PROP_OUTAMT = "outamt";
	public static String PROP_OUTCUST = "outcust";
	public static String PROP_INCUST = "incust";
	public static String PROP_ID = "id";


	// constructors
	public BaseSolderCount () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseSolderCount (resource.bean.report.SolderCountPK id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private resource.bean.report.SolderCountPK id;

	// fields
	private java.math.BigDecimal incust;
	private java.math.BigDecimal outcust;
	private java.math.BigDecimal inamt;
	private java.math.BigDecimal outamt;
	private java.math.BigDecimal onlyamt;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     */
	public resource.bean.report.SolderCountPK getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (resource.bean.report.SolderCountPK id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: incust
	 */
	public java.math.BigDecimal getIncust () {
		return incust;
	}

	/**
	 * Set the value related to the column: incust
	 * @param incust the incust value
	 */
	public void setIncust (java.math.BigDecimal incust) {
		this.incust = incust;
	}



	/**
	 * Return the value associated with the column: outcust
	 */
	public java.math.BigDecimal getOutcust () {
		return outcust;
	}

	/**
	 * Set the value related to the column: outcust
	 * @param outcust the outcust value
	 */
	public void setOutcust (java.math.BigDecimal outcust) {
		this.outcust = outcust;
	}



	/**
	 * Return the value associated with the column: inamt
	 */
	public java.math.BigDecimal getInamt () {
		return inamt;
	}

	/**
	 * Set the value related to the column: inamt
	 * @param inamt the inamt value
	 */
	public void setInamt (java.math.BigDecimal inamt) {
		this.inamt = inamt;
	}



	/**
	 * Return the value associated with the column: outamt
	 */
	public java.math.BigDecimal getOutamt () {
		return outamt;
	}

	/**
	 * Set the value related to the column: outamt
	 * @param outamt the outamt value
	 */
	public void setOutamt (java.math.BigDecimal outamt) {
		this.outamt = outamt;
	}



	/**
	 * Return the value associated with the column: onlyamt
	 */
	public java.math.BigDecimal getOnlyamt () {
		return onlyamt;
	}

	/**
	 * Set the value related to the column: onlyamt
	 * @param onlyamt the onlyamt value
	 */
	public void setOnlyamt (java.math.BigDecimal onlyamt) {
		this.onlyamt = onlyamt;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof resource.bean.report.SolderCount)) return false;
		else {
			resource.bean.report.SolderCount solderCount = (resource.bean.report.SolderCount) obj;
			if (null == this.getId() || null == solderCount.getId()) return false;
			else return (this.getId().equals(solderCount.getId()));
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