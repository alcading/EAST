package resource.bean.report.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the BI_EXEC_CONFIRM table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="BI_EXEC_CONFIRM"
 */

public abstract class BaseBiExecConfirm  implements Serializable {

	public static String REF = "BiExecConfirm";
	public static String PROP_LST_UPD_TLR = "lstUpdTlr";
	public static String PROP_SUBFILE_REMARK = "subfileRemark";
	public static String PROP_CONFIRM_STATUS = "confirmStatus";
	public static String PROP_ID = "id";
	public static String PROP_CONFIRM_REMARK = "confirmRemark";
	public static String PROP_SUBFILE_TM = "subfileTm";
	public static String PROP_CONFIRM_TM = "confirmTm";
	public static String PROP_CONFIRM_TLR_NO = "confirmTlrNo";
	public static String PROP_SUBFILE_TLR_NO = "subfileTlrNo";
	public static String PROP_SUBFILE_STATUS = "subfileStatus";
	public static String PROP_LST_UPD_TM = "lstUpdTm";


	// constructors
	public BaseBiExecConfirm () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBiExecConfirm (resource.bean.report.BiExecConfirmPK id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private resource.bean.report.BiExecConfirmPK id;

	// fields
	private java.lang.String confirmStatus;
	private java.lang.String subfileStatus;
	private java.lang.String confirmTlrNo;
	private java.util.Date confirmTm;
	private java.lang.String subfileTlrNo;
	private java.util.Date subfileTm;
	private java.lang.String confirmRemark;
	private java.lang.String subfileRemark;
	private java.util.Date lstUpdTm;
	private java.lang.String lstUpdTlr;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     */
	public resource.bean.report.BiExecConfirmPK getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (resource.bean.report.BiExecConfirmPK id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: CONFIRM_STATUS
	 */
	public java.lang.String getConfirmStatus () {
		return confirmStatus;
	}

	/**
	 * Set the value related to the column: CONFIRM_STATUS
	 * @param confirmStatus the CONFIRM_STATUS value
	 */
	public void setConfirmStatus (java.lang.String confirmStatus) {
		this.confirmStatus = confirmStatus;
	}



	/**
	 * Return the value associated with the column: SUBFILE_STATUS
	 */
	public java.lang.String getSubfileStatus () {
		return subfileStatus;
	}

	/**
	 * Set the value related to the column: SUBFILE_STATUS
	 * @param subfileStatus the SUBFILE_STATUS value
	 */
	public void setSubfileStatus (java.lang.String subfileStatus) {
		this.subfileStatus = subfileStatus;
	}



	/**
	 * Return the value associated with the column: CONFIRM_TLR_NO
	 */
	public java.lang.String getConfirmTlrNo () {
		return confirmTlrNo;
	}

	/**
	 * Set the value related to the column: CONFIRM_TLR_NO
	 * @param confirmTlrNo the CONFIRM_TLR_NO value
	 */
	public void setConfirmTlrNo (java.lang.String confirmTlrNo) {
		this.confirmTlrNo = confirmTlrNo;
	}



	/**
	 * Return the value associated with the column: CONFIRM_TM
	 */
	public java.util.Date getConfirmTm () {
		return confirmTm;
	}

	/**
	 * Set the value related to the column: CONFIRM_TM
	 * @param confirmTm the CONFIRM_TM value
	 */
	public void setConfirmTm (java.util.Date confirmTm) {
		this.confirmTm = confirmTm;
	}



	/**
	 * Return the value associated with the column: SUBFILE_TLR_NO
	 */
	public java.lang.String getSubfileTlrNo () {
		return subfileTlrNo;
	}

	/**
	 * Set the value related to the column: SUBFILE_TLR_NO
	 * @param subfileTlrNo the SUBFILE_TLR_NO value
	 */
	public void setSubfileTlrNo (java.lang.String subfileTlrNo) {
		this.subfileTlrNo = subfileTlrNo;
	}



	/**
	 * Return the value associated with the column: SUBFILE_TM
	 */
	public java.util.Date getSubfileTm () {
		return subfileTm;
	}

	/**
	 * Set the value related to the column: SUBFILE_TM
	 * @param subfileTm the SUBFILE_TM value
	 */
	public void setSubfileTm (java.util.Date subfileTm) {
		this.subfileTm = subfileTm;
	}



	/**
	 * Return the value associated with the column: CONFIRM_REMARK
	 */
	public java.lang.String getConfirmRemark () {
		return confirmRemark;
	}

	/**
	 * Set the value related to the column: CONFIRM_REMARK
	 * @param confirmRemark the CONFIRM_REMARK value
	 */
	public void setConfirmRemark (java.lang.String confirmRemark) {
		this.confirmRemark = confirmRemark;
	}



	/**
	 * Return the value associated with the column: SUBFILE_REMARK
	 */
	public java.lang.String getSubfileRemark () {
		return subfileRemark;
	}

	/**
	 * Set the value related to the column: SUBFILE_REMARK
	 * @param subfileRemark the SUBFILE_REMARK value
	 */
	public void setSubfileRemark (java.lang.String subfileRemark) {
		this.subfileRemark = subfileRemark;
	}



	/**
	 * Return the value associated with the column: LST_UPD_TM
	 */
	public java.util.Date getLstUpdTm () {
		return lstUpdTm;
	}

	/**
	 * Set the value related to the column: LST_UPD_TM
	 * @param lstUpdTm the LST_UPD_TM value
	 */
	public void setLstUpdTm (java.util.Date lstUpdTm) {
		this.lstUpdTm = lstUpdTm;
	}



	/**
	 * Return the value associated with the column: LST_UPD_TLR
	 */
	public java.lang.String getLstUpdTlr () {
		return lstUpdTlr;
	}

	/**
	 * Set the value related to the column: LST_UPD_TLR
	 * @param lstUpdTlr the LST_UPD_TLR value
	 */
	public void setLstUpdTlr (java.lang.String lstUpdTlr) {
		this.lstUpdTlr = lstUpdTlr;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof resource.bean.report.BiExecConfirm)) return false;
		else {
			resource.bean.report.BiExecConfirm biExecConfirm = (resource.bean.report.BiExecConfirm) obj;
			if (null == this.getId() || null == biExecConfirm.getId()) return false;
			else return (this.getId().equals(biExecConfirm.getId()));
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