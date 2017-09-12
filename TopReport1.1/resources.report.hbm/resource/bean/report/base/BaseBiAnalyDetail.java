package resource.bean.report.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the BI_ANALY_DETAIL table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="BI_ANALY_DETAIL"
 */

public abstract class BaseBiAnalyDetail  implements Serializable {

	public static String REF = "BiAnalyDetail";
	public static String PROP_CONF_RET_CLASS = "confRetClass";
	public static String PROP_CONF_IS_RET = "confIsRet";
	public static String PROP_CONF_TYPE = "confType";
	public static String PROP_EXEC_REMARK = "execRemark";
	public static String PROP_EXEC_STA = "execSta";
	public static String PROP_START_TM = "startTm";
	public static String PROP_EXECUTE_RESULT = "executeResult";
	public static String PROP_ANALY_NO = "analyNo";
	public static String PROP_ID = "id";
	public static String PROP_END_TM = "endTm";
	public static String PROP_CONF_CLASS_PATH = "confClassPath";
	public static String PROP_CONF_SEQ = "confSeq";
	public static String PROP_CONF_ID = "confId";
	public static String PROP_CONF_DESC = "confDesc";
	// constructors
	public BaseBiAnalyDetail () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBiAnalyDetail (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseBiAnalyDetail (
		java.lang.String id,
		java.lang.String analyNo) {

		this.setId(id);
		this.setAnalyNo(analyNo);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;

	// fields
	private java.lang.String analyNo;
	private java.lang.String executeResult;
	private java.lang.String confType;
	private java.lang.String confClassPath;
	private java.lang.String confIsRet;
	private java.lang.String confRetClass;
	private java.lang.String startTm;
	private java.lang.String endTm;
	private java.lang.String execSta;
	private java.lang.String execRemark;
	private java.lang.Integer confSeq;
	private java.lang.String confId;
	private java.lang.String confDesc;


	public java.lang.String getConfDesc() {
		return confDesc;
	}

	public void setConfDesc(java.lang.String confDesc) {
		this.confDesc = confDesc;
	}

	public java.lang.Integer getConfSeq() {
		return confSeq;
	}

	public void setConfSeq(java.lang.Integer confSeq) {
		this.confSeq = confSeq;
	}

	public java.lang.String getConfId() {
		return confId;
	}

	public void setConfId(java.lang.String confId) {
		this.confId = confId;
	}

	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  column="DET_ID"
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
	 * Return the value associated with the column: ANALY_NO
	 */
	public java.lang.String getAnalyNo () {
		return analyNo;
	}

	/**
	 * Set the value related to the column: ANALY_NO
	 * @param analyNo the ANALY_NO value
	 */
	public void setAnalyNo (java.lang.String analyNo) {
		this.analyNo = analyNo;
	}



	/**
	 * Return the value associated with the column: EXECUTE_RESULT
	 */
	public java.lang.String getExecuteResult () {
		return executeResult;
	}

	/**
	 * Set the value related to the column: EXECUTE_RESULT
	 * @param executeResult the EXECUTE_RESULT value
	 */
	public void setExecuteResult (java.lang.String executeResult) {
		this.executeResult = executeResult;
	}



	/**
	 * Return the value associated with the column: CONF_TYPE
	 */
	public java.lang.String getConfType () {
		return confType;
	}

	/**
	 * Set the value related to the column: CONF_TYPE
	 * @param confType the CONF_TYPE value
	 */
	public void setConfType (java.lang.String confType) {
		this.confType = confType;
	}



	/**
	 * Return the value associated with the column: CONF_CLASS_PATH
	 */
	public java.lang.String getConfClassPath () {
		return confClassPath;
	}

	/**
	 * Set the value related to the column: CONF_CLASS_PATH
	 * @param confClassPath the CONF_CLASS_PATH value
	 */
	public void setConfClassPath (java.lang.String confClassPath) {
		this.confClassPath = confClassPath;
	}



	/**
	 * Return the value associated with the column: CONF_IS_RET
	 */
	public java.lang.String getConfIsRet () {
		return confIsRet;
	}

	/**
	 * Set the value related to the column: CONF_IS_RET
	 * @param confIsRet the CONF_IS_RET value
	 */
	public void setConfIsRet (java.lang.String confIsRet) {
		this.confIsRet = confIsRet;
	}


	/**
	 * Return the value associated with the column: CONF_RET_CLASS
	 */
	public java.lang.String getConfRetClass () {
		return confRetClass;
	}

	/**
	 * Set the value related to the column: CONF_RET_CLASS
	 * @param confRetClass the CONF_RET_CLASS value
	 */
	public void setConfRetClass (java.lang.String confRetClass) {
		this.confRetClass = confRetClass;
	}



	/**
	 * Return the value associated with the column: START_TM
	 */
	public java.lang.String getStartTm () {
		return startTm;
	}

	/**
	 * Set the value related to the column: START_TM
	 * @param startTm the START_TM value
	 */
	public void setStartTm (java.lang.String startTm) {
		this.startTm = startTm;
	}



	/**
	 * Return the value associated with the column: END_TM
	 */
	public java.lang.String getEndTm () {
		return endTm;
	}

	/**
	 * Set the value related to the column: END_TM
	 * @param endTm the END_TM value
	 */
	public void setEndTm (java.lang.String endTm) {
		this.endTm = endTm;
	}



	/**
	 * Return the value associated with the column: EXEC_STA
	 */
	public java.lang.String getExecSta () {
		return execSta;
	}

	/**
	 * Set the value related to the column: EXEC_STA
	 * @param execSta the EXEC_STA value
	 */
	public void setExecSta (java.lang.String execSta) {
		this.execSta = execSta;
	}



	/**
	 * Return the value associated with the column: EXEC_REMARK
	 */
	public java.lang.String getExecRemark () {
		return execRemark;
	}

	/**
	 * Set the value related to the column: EXEC_REMARK
	 * @param execRemark the EXEC_REMARK value
	 */
	public void setExecRemark (java.lang.String execRemark) {
		this.execRemark = execRemark;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof resource.bean.report.BiAnalyDetail)) return false;
		else {
			resource.bean.report.BiAnalyDetail biAnalyDetail = (resource.bean.report.BiAnalyDetail) obj;
			if (null == this.getId() || null == biAnalyDetail.getId()) return false;
			else return (this.getId().equals(biAnalyDetail.getId()));
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