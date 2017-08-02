package resource.bean.report.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the solder_performance table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="solder_performance"
 */

public abstract class BaseSolderPerformance  implements Serializable {

	public static String REF = "SolderPerformance";
	public static String PROP_AMT = "amt";
	public static String PROP_LOCK = "lock";
	public static String PROP_SOL_ID = "solId";
	public static String PROP_UPDT = "updt";
	public static String PROP_DEL = "del";
	public static String PROP_ST = "st";
	public static String PROP_ID = "id";
	public static String PROP_LAST_OPERATOR = "lastOperator";


	// constructors
	public BaseSolderPerformance () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseSolderPerformance (resource.bean.report.SolderPerformancePK id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private resource.bean.report.SolderPerformancePK id;

	// fields
	private java.lang.String solId;
	private java.math.BigDecimal amt;
	private java.lang.String st;
	private boolean lock;
	private boolean del;
	private java.util.Date updt;
	private java.lang.String lastOperator;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     */
	public resource.bean.report.SolderPerformancePK getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (resource.bean.report.SolderPerformancePK id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: sol_id
	 */
	public java.lang.String getSolId () {
		return solId;
	}

	/**
	 * Set the value related to the column: sol_id
	 * @param solId the sol_id value
	 */
	public void setSolId (java.lang.String solId) {
		this.solId = solId;
	}



	/**
	 * Return the value associated with the column: amt
	 */
	public java.math.BigDecimal getAmt () {
		return amt;
	}

	/**
	 * Set the value related to the column: amt
	 * @param amt the amt value
	 */
	public void setAmt (java.math.BigDecimal amt) {
		this.amt = amt;
	}



	/**
	 * Return the value associated with the column: ST
	 */
	public java.lang.String getSt () {
		return st;
	}

	/**
	 * Set the value related to the column: ST
	 * @param st the ST value
	 */
	public void setSt (java.lang.String st) {
		this.st = st;
	}



	/**
	 * Return the value associated with the column: IS_LOCK
	 */
	public boolean isLock () {
		return lock;
	}

	/**
	 * Set the value related to the column: IS_LOCK
	 * @param lock the IS_LOCK value
	 */
	public void setLock (boolean lock) {
		this.lock = lock;
	}



	/**
	 * Return the value associated with the column: IS_DEL
	 */
	public boolean isDel () {
		return del;
	}

	/**
	 * Set the value related to the column: IS_DEL
	 * @param del the IS_DEL value
	 */
	public void setDel (boolean del) {
		this.del = del;
	}



	/**
	 * Return the value associated with the column: updt
	 */
	public java.util.Date getUpdt () {
		return updt;
	}

	/**
	 * Set the value related to the column: updt
	 * @param updt the updt value
	 */
	public void setUpdt (java.util.Date updt) {
		this.updt = updt;
	}



	/**
	 * Return the value associated with the column: last_operator
	 */
	public java.lang.String getLastOperator () {
		return lastOperator;
	}

	/**
	 * Set the value related to the column: last_operator
	 * @param lastOperator the last_operator value
	 */
	public void setLastOperator (java.lang.String lastOperator) {
		this.lastOperator = lastOperator;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof resource.bean.report.SolderPerformance)) return false;
		else {
			resource.bean.report.SolderPerformance solderPerformance = (resource.bean.report.SolderPerformance) obj;
			if (null == this.getId() || null == solderPerformance.getId()) return false;
			else return (this.getId().equals(solderPerformance.getId()));
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