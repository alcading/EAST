package com.huateng.ebank.entity.data.workflow.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the LIMIT_PARAM table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="LIMIT_PARAM"
 */

public abstract class BaseLimitParam  implements Comparable, Serializable {

	public static String REF = "LimitParam";
	public static String PROP_LAST_UPD_FUNC = "lastUpdFunc";
	public static String PROP_BIZ_SUBCLASS = "bizSubclass";
	public static String PROP_LIMIT_MODE = "limitMode";
	public static String PROP_TLRNO = "tlrno";
	public static String PROP_LIMIT_MAXAMOUNT = "limitMaxamount";
	public static String PROP_LIMIT_MINAMOUNT = "limitMinamount";
	public static String PROP_EFFECT_DATE = "effectDate";
	public static String PROP_MISC = "misc";
	public static String PROP_BIZ_CLASS = "bizClass";
	public static String PROP_LAST_UPD_TLR = "lastUpdTlr";
	public static String PROP_MISCFLGS = "miscflgs";
	public static String PROP_STATUS = "status";
	public static String PROP_EXPIRE_DATE = "expireDate";
	public static String PROP_LAST_UPD_DATE = "lastUpdDate";
	public static String PROP_PRECONDITION = "precondition";
	public static String PROP_ID = "id";
	public static String PROP_TIMESTAMPS = "timestamps";


	// constructors
	public BaseLimitParam () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseLimitParam (long id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseLimitParam (
		long id,
		java.lang.String tlrno,
		java.lang.String bizClass,
		java.lang.String bizSubclass) {

		this.setId(id);
		this.setTlrno(tlrno);
		this.setBizClass(bizClass);
		this.setBizSubclass(bizSubclass);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private long id;

	// fields
	private java.lang.String tlrno;
	private java.lang.String bizClass;
	private java.lang.String bizSubclass;
	private java.lang.String limitMode;
	private java.math.BigDecimal limitMinamount;
	private java.math.BigDecimal limitMaxamount;
	private java.lang.String precondition;
	private java.lang.String status;
	private java.util.Date effectDate;
	private java.util.Date expireDate;
	private java.lang.String miscflgs;
	private java.lang.String misc;
	private java.util.Date lastUpdDate;
	private java.lang.String lastUpdFunc;
	private java.lang.String lastUpdTlr;
	private java.util.Date timestamps;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="ID"
     */
	public long getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (long id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: TLRNO
	 */
	public java.lang.String getTlrno () {
		return tlrno;
	}

	/**
	 * Set the value related to the column: TLRNO
	 * @param tlrno the TLRNO value
	 */
	public void setTlrno (java.lang.String tlrno) {
		this.tlrno = tlrno;
	}



	/**
	 * Return the value associated with the column: BIZ_CLASS
	 */
	public java.lang.String getBizClass () {
		return bizClass;
	}

	/**
	 * Set the value related to the column: BIZ_CLASS
	 * @param bizClass the BIZ_CLASS value
	 */
	public void setBizClass (java.lang.String bizClass) {
		this.bizClass = bizClass;
	}



	/**
	 * Return the value associated with the column: BIZ_SUBCLASS
	 */
	public java.lang.String getBizSubclass () {
		return bizSubclass;
	}

	/**
	 * Set the value related to the column: BIZ_SUBCLASS
	 * @param bizSubclass the BIZ_SUBCLASS value
	 */
	public void setBizSubclass (java.lang.String bizSubclass) {
		this.bizSubclass = bizSubclass;
	}



	/**
	 * Return the value associated with the column: LIMIT_MODE
	 */
	public java.lang.String getLimitMode () {
		return limitMode;
	}

	/**
	 * Set the value related to the column: LIMIT_MODE
	 * @param limitMode the LIMIT_MODE value
	 */
	public void setLimitMode (java.lang.String limitMode) {
		this.limitMode = limitMode;
	}



	/**
	 * Return the value associated with the column: LIMIT_MINAMOUNT
	 */
	public java.math.BigDecimal getLimitMinamount () {
		return limitMinamount;
	}

	/**
	 * Set the value related to the column: LIMIT_MINAMOUNT
	 * @param limitMinamount the LIMIT_MINAMOUNT value
	 */
	public void setLimitMinamount (java.math.BigDecimal limitMinamount) {
		this.limitMinamount = limitMinamount;
	}



	/**
	 * Return the value associated with the column: LIMIT_MAXAMOUNT
	 */
	public java.math.BigDecimal getLimitMaxamount () {
		return limitMaxamount;
	}

	/**
	 * Set the value related to the column: LIMIT_MAXAMOUNT
	 * @param limitMaxamount the LIMIT_MAXAMOUNT value
	 */
	public void setLimitMaxamount (java.math.BigDecimal limitMaxamount) {
		this.limitMaxamount = limitMaxamount;
	}



	/**
	 * Return the value associated with the column: PRECONDITION
	 */
	public java.lang.String getPrecondition () {
		return precondition;
	}

	/**
	 * Set the value related to the column: PRECONDITION
	 * @param precondition the PRECONDITION value
	 */
	public void setPrecondition (java.lang.String precondition) {
		this.precondition = precondition;
	}



	/**
	 * Return the value associated with the column: STATUS
	 */
	public java.lang.String getStatus () {
		return status;
	}

	/**
	 * Set the value related to the column: STATUS
	 * @param status the STATUS value
	 */
	public void setStatus (java.lang.String status) {
		this.status = status;
	}



	/**
	 * Return the value associated with the column: EFFECT_DATE
	 */
	public java.util.Date getEffectDate () {
		return effectDate;
	}

	/**
	 * Set the value related to the column: EFFECT_DATE
	 * @param effectDate the EFFECT_DATE value
	 */
	public void setEffectDate (java.util.Date effectDate) {
		this.effectDate = effectDate;
	}



	/**
	 * Return the value associated with the column: EXPIRE_DATE
	 */
	public java.util.Date getExpireDate () {
		return expireDate;
	}

	/**
	 * Set the value related to the column: EXPIRE_DATE
	 * @param expireDate the EXPIRE_DATE value
	 */
	public void setExpireDate (java.util.Date expireDate) {
		this.expireDate = expireDate;
	}



	/**
	 * Return the value associated with the column: MISCFLGS
	 */
	public java.lang.String getMiscflgs () {
		return miscflgs;
	}

	/**
	 * Set the value related to the column: MISCFLGS
	 * @param miscflgs the MISCFLGS value
	 */
	public void setMiscflgs (java.lang.String miscflgs) {
		this.miscflgs = miscflgs;
	}



	/**
	 * Return the value associated with the column: MISC
	 */
	public java.lang.String getMisc () {
		return misc;
	}

	/**
	 * Set the value related to the column: MISC
	 * @param misc the MISC value
	 */
	public void setMisc (java.lang.String misc) {
		this.misc = misc;
	}



	/**
	 * Return the value associated with the column: LAST_UPD_DATE
	 */
	public java.util.Date getLastUpdDate () {
		return lastUpdDate;
	}

	/**
	 * Set the value related to the column: LAST_UPD_DATE
	 * @param lastUpdDate the LAST_UPD_DATE value
	 */
	public void setLastUpdDate (java.util.Date lastUpdDate) {
		this.lastUpdDate = lastUpdDate;
	}



	/**
	 * Return the value associated with the column: LAST_UPD_FUNC
	 */
	public java.lang.String getLastUpdFunc () {
		return lastUpdFunc;
	}

	/**
	 * Set the value related to the column: LAST_UPD_FUNC
	 * @param lastUpdFunc the LAST_UPD_FUNC value
	 */
	public void setLastUpdFunc (java.lang.String lastUpdFunc) {
		this.lastUpdFunc = lastUpdFunc;
	}



	/**
	 * Return the value associated with the column: LAST_UPD_TLR
	 */
	public java.lang.String getLastUpdTlr () {
		return lastUpdTlr;
	}

	/**
	 * Set the value related to the column: LAST_UPD_TLR
	 * @param lastUpdTlr the LAST_UPD_TLR value
	 */
	public void setLastUpdTlr (java.lang.String lastUpdTlr) {
		this.lastUpdTlr = lastUpdTlr;
	}



	/**
	 * Return the value associated with the column: TIMESTAMPS
	 */
	public java.util.Date getTimestamps () {
		return timestamps;
	}

	/**
	 * Set the value related to the column: TIMESTAMPS
	 * @param timestamps the TIMESTAMPS value
	 */
	public void setTimestamps (java.util.Date timestamps) {
		this.timestamps = timestamps;
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.huateng.ebank.entity.data.workflow.LimitParam)) return false;
		else {
			com.huateng.ebank.entity.data.workflow.LimitParam limitParam = (com.huateng.ebank.entity.data.workflow.LimitParam) obj;
			return (this.getId() == limitParam.getId());
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			return (int) this.getId();
		}
		return this.hashCode;
	}

	public int compareTo (Object obj) {
		if (obj.hashCode() > hashCode()) return 1;
		else if (obj.hashCode() < hashCode()) return -1;
		else return 0;
	}

	public String toString () {
		return super.toString();
	}


}