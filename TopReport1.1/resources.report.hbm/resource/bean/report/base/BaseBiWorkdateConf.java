package resource.bean.report.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the BI_WORKDATE_CONF table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="BI_WORKDATE_CONF"
 */

public abstract class BaseBiWorkdateConf  implements Serializable {

	public static String REF = "BiWorkdateConf";
	public static String PROP_CRT_DT = "crtDt";
	public static String PROP_DEL = "del";
	public static String PROP_LAST_UPD_TMS = "lastUpdTms";
	public static String PROP_ID = "id";
	public static String PROP_LOCK = "lock";
	public static String PROP_ST = "st";
	public static String PROP_LAST_UPD_OPER = "lastUpdOper";


	// constructors
	public BaseBiWorkdateConf () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBiWorkdateConf (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;

	// fields
	private java.lang.String st;
	private boolean lock;
	private boolean del;
	private java.lang.String crtDt;
	private java.lang.String lastUpdOper;
	private java.lang.String lastUpdTms;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  column="WORKDATE_YEAR"
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
	 * Return the value associated with the column: CRT_DT
	 */
	public java.lang.String getCrtDt () {
		return crtDt;
	}

	/**
	 * Set the value related to the column: CRT_DT
	 * @param crtDt the CRT_DT value
	 */
	public void setCrtDt (java.lang.String crtDt) {
		this.crtDt = crtDt;
	}



	/**
	 * Return the value associated with the column: LAST_UPD_OPER
	 */
	public java.lang.String getLastUpdOper () {
		return lastUpdOper;
	}

	/**
	 * Set the value related to the column: LAST_UPD_OPER
	 * @param lastUpdOper the LAST_UPD_OPER value
	 */
	public void setLastUpdOper (java.lang.String lastUpdOper) {
		this.lastUpdOper = lastUpdOper;
	}



	/**
	 * Return the value associated with the column: LAST_UPD_TMS
	 */
	public java.lang.String getLastUpdTms () {
		return lastUpdTms;
	}

	/**
	 * Set the value related to the column: LAST_UPD_TMS
	 * @param lastUpdTms the LAST_UPD_TMS value
	 */
	public void setLastUpdTms (java.lang.String lastUpdTms) {
		this.lastUpdTms = lastUpdTms;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof resource.bean.report.BiWorkdateConf)) return false;
		else {
			resource.bean.report.BiWorkdateConf biWorkdateConf = (resource.bean.report.BiWorkdateConf) obj;
			if (null == this.getId() || null == biWorkdateConf.getId()) return false;
			else return (this.getId().equals(biWorkdateConf.getId()));
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