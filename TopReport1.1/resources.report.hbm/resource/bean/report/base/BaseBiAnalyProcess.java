package resource.bean.report.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the BI_ANALY_PROCESS table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="BI_ANALY_PROCESS"
 */

public abstract class BaseBiAnalyProcess  implements Serializable {

	public static String REF = "BiAnalyProcess";
	public static String PROP_OPER_TM = "operTm";
	public static String PROP_EXECUTE_TM = "executeTm";
	public static String PROP_OPER_TLR = "operTlr";
	public static String PROP_ID = "id";
	public static String PROP_WORK_DATE = "workDate";
	public static String PROP_BR_NO = "brNo";
	public static String PROP_BUSI_TYPE = "busiType";
	public static String PROP_APP_TYPE = "appType";

	// constructors
	public BaseBiAnalyProcess () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBiAnalyProcess (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;

	// fields
	private java.lang.String brNo;
	private java.lang.String workDate;
	private java.lang.String busiType;
	private java.util.Date operTm;
	private java.lang.String operTlr;
	private java.util.Date executeTm;
	private java.lang.String appType;


	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  column="ANALY_NO"
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
	 * Return the value associated with the column: BR_NO
	 */
	public java.lang.String getBrNo () {
		return brNo;
	}

	/**
	 * Set the value related to the column: BR_NO
	 * @param brNo the BR_NO value
	 */
	public void setBrNo (java.lang.String brNo) {
		this.brNo = brNo;
	}



	/**
	 * Return the value associated with the column: WORK_DATE
	 */
	public java.lang.String getWorkDate () {
		return workDate;
	}

	/**
	 * Set the value related to the column: WORK_DATE
	 * @param workDate the WORK_DATE value
	 */
	public void setWorkDate (java.lang.String workDate) {
		this.workDate = workDate;
	}



	/**
	 * Return the value associated with the column: BUSI_TYPE
	 */
	public java.lang.String getBusiType () {
		return busiType;
	}

	/**
	 * Set the value related to the column: BUSI_TYPE
	 * @param busiType the BUSI_TYPE value
	 */
	public void setBusiType (java.lang.String busiType) {
		this.busiType = busiType;
	}



	/**
	 * Return the value associated with the column: OPER_TM
	 */
	public java.util.Date getOperTm () {
		return operTm;
	}

	/**
	 * Set the value related to the column: OPER_TM
	 * @param operTm the OPER_TM value
	 */
	public void setOperTm (java.util.Date operTm) {
		this.operTm = operTm;
	}



	/**
	 * Return the value associated with the column: OPER_TLR
	 */
	public java.lang.String getOperTlr () {
		return operTlr;
	}

	/**
	 * Set the value related to the column: OPER_TLR
	 * @param operTlr the OPER_TLR value
	 */
	public void setOperTlr (java.lang.String operTlr) {
		this.operTlr = operTlr;
	}


	public java.lang.String getAppType() {
		return appType;
	}

	public void setAppType(java.lang.String appType) {
		this.appType = appType;
	}

	/**
	 * Return the value associated with the column: EXECUTE_TM
	 */
	public java.util.Date getExecuteTm () {
		return executeTm;
	}

	/**
	 * Set the value related to the column: EXECUTE_TM
	 * @param executeTm the EXECUTE_TM value
	 */
	public void setExecuteTm (java.util.Date executeTm) {
		this.executeTm = executeTm;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof resource.bean.report.BiAnalyProcess)) return false;
		else {
			resource.bean.report.BiAnalyProcess biAnalyProcess = (resource.bean.report.BiAnalyProcess) obj;
			if (null == this.getId() || null == biAnalyProcess.getId()) return false;
			else return (this.getId().equals(biAnalyProcess.getId()));
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