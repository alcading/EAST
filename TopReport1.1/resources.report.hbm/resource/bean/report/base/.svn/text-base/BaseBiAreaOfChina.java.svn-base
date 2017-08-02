package resource.bean.report.base;

import java.io.Serializable;

public class BaseBiAreaOfChina implements Serializable {

	public static String REF = "BaseBiAreaOfChina";
	public static String PROP_AREA_CODE = "areacode";
	public static String PROP_AREA_NAME = "areaname";

	public static String PROP_FILLER1 = "filler1";
	public static String PROP_FILLER2 = "filler2";
	public static String PROP_FILLER3 = "filler3";

	public static String PROP_ST = "st";
	public static String PROP_LOCK = "lock";
	public static String PROP_DEL ="del";

	public static String PROP_CRT_DT = "crtDt";
	public static String PROP_LAST_UPD_TMS = "lastUpdTms";
	public static String PROP_LAST_UPD_OPER = "lastUpdOper";

	// constructors
	public BaseBiAreaOfChina () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBiAreaOfChina (java.lang.String areacode) {
		setAreacode(areacode);
		initialize();
	}

	protected void initialize () {}


	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String areacode;

	// fields
	private java.lang.String areaname;
	private java.lang.String filler1;
	private java.lang.String filler2;
	private java.lang.String filler3;

	private boolean lock;
	private java.lang.String st;
	private boolean del;

	private java.lang.String crtDt;
	private java.lang.String lastUpdTms;
	private java.lang.String lastUpdOper;



	public java.lang.String getAreacode() {
		return areacode;
	}

	public void setAreacode(java.lang.String areacode) {
		this.areacode = areacode;
	}

	public java.lang.String getAreaname() {
		return areaname;
	}

	public void setAreaname(java.lang.String areaname) {
		this.areaname = areaname;
	}

	public java.lang.String getFiller1() {
		return filler1;
	}

	public void setFiller1(java.lang.String filler1) {
		this.filler1 = filler1;
	}

	public java.lang.String getFiller2() {
		return filler2;
	}

	public void setFiller2(java.lang.String filler2) {
		this.filler2 = filler2;
	}

	public java.lang.String getFiller3() {
		return filler3;
	}

	public void setFiller3(java.lang.String filler3) {
		this.filler3 = filler3;
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

	public boolean isDel() {
		return del;
	}

	public void setDel(boolean del) {
		this.del = del;
	}

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

	public java.lang.String getLastUpdOper() {
		return lastUpdOper;
	}

	public void setLastUpdOper(java.lang.String lastUpdOper) {
		this.lastUpdOper = lastUpdOper;
	}


	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof resource.bean.report.BiAreaOfChina)) return false;
		else {
			resource.bean.report.BiAreaOfChina biAreaOfChina = (resource.bean.report.BiAreaOfChina) obj;
			if (null == this.getAreacode() || null == biAreaOfChina.getAreacode()) return false;
			else return (this.getAreacode().equals(biAreaOfChina.getAreacode()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getAreacode()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getAreacode().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}

	public String toString () {
		return super.toString();
	}

}
