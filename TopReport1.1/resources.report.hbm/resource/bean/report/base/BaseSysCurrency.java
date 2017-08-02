package resource.bean.report.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the SYS_CURRENCY table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="SYS_CURRENCY"
 */

public abstract class BaseSysCurrency  implements Serializable {

	public static String REF = "SysCurrency";
	public static String PROP_CURRENCY_NAME = "currencyName";
	public static String PROP_ID = "id";
	public static String PROP_FILLER1 = "filler1";
	public static String PROP_DOT_NUM = "dotNum";
	public static String PROP_FILLER3 = "filler3";
	public static String PROP_FILLER2 = "filler2";
	public static String PROP_CRT_DT = "crtDt";
	public static String PROP_LAST_UPD_TMS = "lastUpdTms";
	public static String PROP_ST = "st";
	public static String PROP_LOCK = "lock";
	public static String PROP_LAST_UPD_OPER = "lastUpdOper";
	public static String PROP_DEL ="del";

	// constructors
	public BaseSysCurrency () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseSysCurrency (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;

	// fields
	private java.lang.String currencyName;
	private java.lang.Integer dotNum;
	private java.lang.String filler1;
	private java.lang.String filler2;
	private java.lang.String filler3;
	private java.lang.String crtDt;
	private java.lang.String lastUpdTms;
	private boolean lock;
	private java.lang.String st;
	private java.lang.String lastUpdOper;
	private boolean del;


	public java.lang.String getCrtDt() {
		return crtDt;
	}

	public void setCrtDt(java.lang.String crtDt) {
		this.crtDt = crtDt;
	}

	public java.lang.String getLastUpdTms() {
		return lastUpdTms;
	}

	public void setLastUpdTms(java.lang.String lastUpdTms) {
		this.lastUpdTms = lastUpdTms;
	}

	public boolean isLock() {
		return lock;
	}

	public void setLock(boolean lock) {
		this.lock = lock;
	}

	public java.lang.String getSt() {
		return st;
	}

	public void setSt(java.lang.String st) {
		this.st = st;
	}

	public java.lang.String getLastUpdOper() {
		return lastUpdOper;
	}

	public void setLastUpdOper(java.lang.String lastUpdOper) {
		this.lastUpdOper = lastUpdOper;
	}

	public boolean isDel() {
		return del;
	}

	public void setDel(boolean del) {
		this.del = del;
	}

	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  column="CURRENCY_CODE"
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
	 * Return the value associated with the column: CURRENCY_NAME
	 */
	public java.lang.String getCurrencyName () {
		return currencyName;
	}

	/**
	 * Set the value related to the column: CURRENCY_NAME
	 * @param currencyName the CURRENCY_NAME value
	 */
	public void setCurrencyName (java.lang.String currencyName) {
		this.currencyName = currencyName;
	}



	/**
	 * Return the value associated with the column: DOT_NUM
	 */
	public java.lang.Integer getDotNum () {
		return dotNum;
	}

	/**
	 * Set the value related to the column: DOT_NUM
	 * @param dotNum the DOT_NUM value
	 */
	public void setDotNum (java.lang.Integer dotNum) {
		this.dotNum = dotNum;
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
		if (!(obj instanceof resource.bean.report.SysCurrency)) return false;
		else {
			resource.bean.report.SysCurrency sysCurrency = (resource.bean.report.SysCurrency) obj;
			if (null == this.getId() || null == sysCurrency.getId()) return false;
			else return (this.getId().equals(sysCurrency.getId()));
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