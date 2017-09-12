package com.huateng.ebank.entity.data.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the TLR_WORKLOAD table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="TLR_WORKLOAD"
 */

public abstract class BaseTlrWorkload  implements Serializable {

	public static String REF = "TlrWorkload";
	public static String PROP_TODAY_WL = "todayWl";
	public static String PROP_TLRNO = "tlrno";
	public static String PROP_MISC = "misc";
	public static String PROP_MISCFLGS = "miscflgs";
	public static String PROP_MAX_WL = "maxWl";
	public static String PROP_YTD_WL = "ytdWl";
	public static String PROP_BRCODE = "brcode";
	public static String PROP_MTD_WL = "mtdWl";
	public static String PROP_REST_WL = "restWl";
	public static String PROP_TIMESTAMPS = "timestamps";
	public static String PROP_WORK_TYPE = "workType";
	public static String PROP_WTD_WL = "wtdWl";
	public static String PROP_LTD_WL = "ltdWl";


	// constructors
	public BaseTlrWorkload () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseTlrWorkload (java.lang.String tlrno) {
		this.setTlrno(tlrno);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String tlrno;

	// fields
	private java.lang.String workType;
	private java.lang.String brcode;
	private long maxWl;
	private long restWl;
	private long todayWl;
	private long wtdWl;
	private long mtdWl;
	private long ytdWl;
	private long ltdWl;
	private java.lang.String miscflgs;
	private java.lang.String misc;
	private java.util.Date timestamps;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  column="TLRNO"
     */
	public java.lang.String getTlrno () {
		return tlrno;
	}

	/**
	 * Set the unique identifier of this class
	 * @param tlrno the new ID
	 */
	public void setTlrno (java.lang.String tlrno) {
		this.tlrno = tlrno;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: WORK_TYPE
	 */
	public java.lang.String getWorkType () {
		return workType;
	}

	/**
	 * Set the value related to the column: WORK_TYPE
	 * @param workType the WORK_TYPE value
	 */
	public void setWorkType (java.lang.String workType) {
		this.workType = workType;
	}



	/**
	 * Return the value associated with the column: BRCODE
	 */
	public java.lang.String getBrcode () {
		return brcode;
	}

	/**
	 * Set the value related to the column: BRCODE
	 * @param brcode the BRCODE value
	 */
	public void setBrcode (java.lang.String brcode) {
		this.brcode = brcode;
	}



	/**
	 * Return the value associated with the column: MAX_WL
	 */
	public long getMaxWl () {
		return maxWl;
	}

	/**
	 * Set the value related to the column: MAX_WL
	 * @param maxWl the MAX_WL value
	 */
	public void setMaxWl (long maxWl) {
		this.maxWl = maxWl;
	}



	/**
	 * Return the value associated with the column: REST_WL
	 */
	public long getRestWl () {
		return restWl;
	}

	/**
	 * Set the value related to the column: REST_WL
	 * @param restWl the REST_WL value
	 */
	public void setRestWl (long restWl) {
		this.restWl = restWl;
	}



	/**
	 * Return the value associated with the column: TODAY_WL
	 */
	public long getTodayWl () {
		return todayWl;
	}

	/**
	 * Set the value related to the column: TODAY_WL
	 * @param todayWl the TODAY_WL value
	 */
	public void setTodayWl (long todayWl) {
		this.todayWl = todayWl;
	}



	/**
	 * Return the value associated with the column: WTD_WL
	 */
	public long getWtdWl () {
		return wtdWl;
	}

	/**
	 * Set the value related to the column: WTD_WL
	 * @param wtdWl the WTD_WL value
	 */
	public void setWtdWl (long wtdWl) {
		this.wtdWl = wtdWl;
	}



	/**
	 * Return the value associated with the column: MTD_WL
	 */
	public long getMtdWl () {
		return mtdWl;
	}

	/**
	 * Set the value related to the column: MTD_WL
	 * @param mtdWl the MTD_WL value
	 */
	public void setMtdWl (long mtdWl) {
		this.mtdWl = mtdWl;
	}



	/**
	 * Return the value associated with the column: YTD_WL
	 */
	public long getYtdWl () {
		return ytdWl;
	}

	/**
	 * Set the value related to the column: YTD_WL
	 * @param ytdWl the YTD_WL value
	 */
	public void setYtdWl (long ytdWl) {
		this.ytdWl = ytdWl;
	}



	/**
	 * Return the value associated with the column: LTD_WL
	 */
	public long getLtdWl () {
		return ltdWl;
	}

	/**
	 * Set the value related to the column: LTD_WL
	 * @param ltdWl the LTD_WL value
	 */
	public void setLtdWl (long ltdWl) {
		this.ltdWl = ltdWl;
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
		if (!(obj instanceof com.huateng.ebank.entity.data.TlrWorkload)) return false;
		else {
			com.huateng.ebank.entity.data.TlrWorkload tlrWorkload = (com.huateng.ebank.entity.data.TlrWorkload) obj;
			if (null == this.getTlrno() || null == tlrWorkload.getTlrno()) return false;
			else return (this.getTlrno().equals(tlrWorkload.getTlrno()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getTlrno()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getTlrno().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}