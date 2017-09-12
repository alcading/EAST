package resource.bean.report.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the BI_PROCESS_LOG table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="BI_PROCESS_LOG"
 */

public abstract class BaseBiProcessLog  implements Serializable {

	public static String REF = "BiProcessLog";
	public static String PROP_EXECUTE_TM = "executeTm";
	public static String PROP_OPER_TYPE = "operType";
	public static String PROP_EXECUTE_TYPE = "executeType";
	public static String PROP_START_TM = "startTm";
	public static String PROP_ID = "id";
	public static String PROP_EXECUTE_ID = "executeId";
	public static String PROP_WORK_DATE = "workDate";
	public static String PROP_END_TM = "endTm";
	public static String PROP_BR_NO = "brNo";
	public static String PROP_BUSI_TYPE = "busiType";
	public static String PROP_IP = "ip";

	// constructors
	public BaseBiProcessLog () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBiProcessLog (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;

	// fields
	private java.lang.String workDate;
	private java.lang.String busiType;
	private java.lang.String brNo;
	private java.lang.String executeType;
	private java.util.Date executeTm;
	private java.lang.String executeId;
	private java.util.Date startTm;
	private java.util.Date endTm;
	private java.lang.String operType;
	private java.lang.String ip;


	public java.lang.String getIp() {
		return ip;
	}

	public void setIp(java.lang.String ip) {
		this.ip = ip;
	}

	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  column="PRO_ID"
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
	 * Return the value associated with the column: EXECUTE_TYPE
	 */
	public java.lang.String getExecuteType () {
		return executeType;
	}

	/**
	 * Set the value related to the column: EXECUTE_TYPE
	 * @param executeType the EXECUTE_TYPE value
	 */
	public void setExecuteType (java.lang.String executeType) {
		this.executeType = executeType;
	}

	public java.util.Date getExecuteTm() {
		return executeTm;
	}

	public void setExecuteTm(java.util.Date executeTm) {
		this.executeTm = executeTm;
	}

	public java.util.Date getStartTm() {
		return startTm;
	}

	public void setStartTm(java.util.Date startTm) {
		this.startTm = startTm;
	}

	public java.util.Date getEndTm() {
		return endTm;
	}

	public void setEndTm(java.util.Date endTm) {
		this.endTm = endTm;
	}

	/**
	 * Return the value associated with the column: EXECUTE_ID
	 */
	public java.lang.String getExecuteId () {
		return executeId;
	}

	/**
	 * Set the value related to the column: EXECUTE_ID
	 * @param executeId the EXECUTE_ID value
	 */
	public void setExecuteId (java.lang.String executeId) {
		this.executeId = executeId;
	}



	




	/**
	 * Return the value associated with the column: OPER_TYPE
	 */
	public java.lang.String getOperType () {
		return operType;
	}

	/**
	 * Set the value related to the column: OPER_TYPE
	 * @param operType the OPER_TYPE value
	 */
	public void setOperType (java.lang.String operType) {
		this.operType = operType;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof resource.bean.report.BiProcessLog)) return false;
		else {
			resource.bean.report.BiProcessLog biProcessLog = (resource.bean.report.BiProcessLog) obj;
			if (null == this.getId() || null == biProcessLog.getId()) return false;
			else return (this.getId().equals(biProcessLog.getId()));
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