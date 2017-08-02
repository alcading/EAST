package resource.bean.report.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the BI_DATA_PROCESS_LOG table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="BI_DATA_PROCESS_LOG"
 */

public abstract class BaseBiDataProcessLog  implements Serializable {

	public static String REF = "BiDataProcessLog";
	public static String PROP_EXEC_RESULT = "execResult";
	public static String PROP_EXEC_TLR = "execTlr";
	public static String PROP_EXEC_TM = "execTm";
	public static String PROP_APPTYPE = "apptype";
	public static String PROP_CURRENTFILE = "currentfile";
	public static String PROP_REC_ID = "recId";
	public static String PROP_EXEC_TYPE = "execType";
	public static String PROP_EXEC_REMARK = "execRemark";
	public static String PROP_BUSI_NO = "busiNo";
	public static String PROP_ID = "id";
	public static String PROP_FILLER1 = "filler1";
	public static String PROP_FILLER3 = "filler3";
	public static String PROP_FILLER2 = "filler2";


	// constructors
	public BaseBiDataProcessLog () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBiDataProcessLog (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;

	// fields
	private java.lang.String apptype;
	private java.lang.String currentfile;
	private java.lang.String recId;
	private java.lang.String busiNo;
	private java.lang.String execType;
	private java.lang.String execResult;
	private java.lang.String execRemark;
	private java.util.Date execTm;
	private java.lang.String execTlr;
	private java.lang.String filler1;
	private java.lang.String filler2;
	private java.lang.String filler3;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  column="PROC_ID"
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
	 * Return the value associated with the column: APPTYPE
	 */
	public java.lang.String getApptype () {
		return apptype;
	}

	/**
	 * Set the value related to the column: APPTYPE
	 * @param apptype the APPTYPE value
	 */
	public void setApptype (java.lang.String apptype) {
		this.apptype = apptype;
	}



	/**
	 * Return the value associated with the column: CURRENTFILE
	 */
	public java.lang.String getCurrentfile () {
		return currentfile;
	}

	/**
	 * Set the value related to the column: CURRENTFILE
	 * @param currentfile the CURRENTFILE value
	 */
	public void setCurrentfile (java.lang.String currentfile) {
		this.currentfile = currentfile;
	}



	/**
	 * Return the value associated with the column: REC_ID
	 */
	public java.lang.String getRecId () {
		return recId;
	}

	/**
	 * Set the value related to the column: REC_ID
	 * @param recId the REC_ID value
	 */
	public void setRecId (java.lang.String recId) {
		this.recId = recId;
	}



	/**
	 * Return the value associated with the column: BUSI_NO
	 */
	public java.lang.String getBusiNo () {
		return busiNo;
	}

	/**
	 * Set the value related to the column: BUSI_NO
	 * @param busiNo the BUSI_NO value
	 */
	public void setBusiNo (java.lang.String busiNo) {
		this.busiNo = busiNo;
	}



	/**
	 * Return the value associated with the column: EXEC_TYPE
	 */
	public java.lang.String getExecType () {
		return execType;
	}

	/**
	 * Set the value related to the column: EXEC_TYPE
	 * @param execType the EXEC_TYPE value
	 */
	public void setExecType (java.lang.String execType) {
		this.execType = execType;
	}



	/**
	 * Return the value associated with the column: EXEC_RESULT
	 */
	public java.lang.String getExecResult () {
		return execResult;
	}

	/**
	 * Set the value related to the column: EXEC_RESULT
	 * @param execResult the EXEC_RESULT value
	 */
	public void setExecResult (java.lang.String execResult) {
		this.execResult = execResult;
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






	public java.util.Date getExecTm() {
		return execTm;
	}

	public void setExecTm(java.util.Date execTm) {
		this.execTm = execTm;
	}

	/**
	 * Return the value associated with the column: EXEC_TLR
	 */
	public java.lang.String getExecTlr () {
		return execTlr;
	}

	/**
	 * Set the value related to the column: EXEC_TLR
	 * @param execTlr the EXEC_TLR value
	 */
	public void setExecTlr (java.lang.String execTlr) {
		this.execTlr = execTlr;
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
		if (!(obj instanceof resource.bean.report.BiDataProcessLog)) return false;
		else {
			resource.bean.report.BiDataProcessLog biDataProcessLog = (resource.bean.report.BiDataProcessLog) obj;
			if (null == this.getId() || null == biDataProcessLog.getId()) return false;
			else return (this.getId().equals(biDataProcessLog.getId()));
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