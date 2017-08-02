package resource.bean.report.base;

import java.io.Serializable;


public abstract class BaseBiExecConfirmPK implements Serializable {

	protected int hashCode = Integer.MIN_VALUE;

	private java.lang.String busiType;
	private java.lang.String apptype;
	private java.lang.String brNo;
	private java.lang.String workDate;


	public BaseBiExecConfirmPK () {}
	
	public BaseBiExecConfirmPK (
		java.lang.String busiType,
		java.lang.String apptype,
		java.lang.String brNo,
		java.lang.String workDate) {

		this.setBusiType(busiType);
		this.setApptype(apptype);
		this.setBrNo(brNo);
		this.setWorkDate(workDate);
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

	public java.lang.String getApptype() {
		return apptype;
	}

	public void setApptype(java.lang.String apptype) {
		this.apptype = apptype;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof resource.bean.report.BiExecConfirmPK)) return false;
		else {
			resource.bean.report.BiExecConfirmPK mObj = (resource.bean.report.BiExecConfirmPK) obj;
			if (null != this.getBusiType() && null != mObj.getBusiType()) {
				if (!this.getBusiType().equals(mObj.getBusiType())) {
					return false;
				}
			}
			else {
				return false;
			}
			if (null != this.getBrNo() && null != mObj.getBrNo()) {
				if (!this.getBrNo().equals(mObj.getBrNo())) {
					return false;
				}
			}
			else {
				return false;
			}
			if (null != this.getWorkDate() && null != mObj.getWorkDate()) {
				if (!this.getWorkDate().equals(mObj.getWorkDate())) {
					return false;
				}
			}
			else {
				return false;
			}
			return true;
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			StringBuilder sb = new StringBuilder();
			if (null != this.getBusiType()) {
				sb.append(this.getBusiType().hashCode());
				sb.append(":");
			}
			else {
				return super.hashCode();
			}
			if (null != this.getBrNo()) {
				sb.append(this.getBrNo().hashCode());
				sb.append(":");
			}
			else {
				return super.hashCode();
			}
			if (null != this.getWorkDate()) {
				sb.append(this.getWorkDate().hashCode());
				sb.append(":");
			}
			else {
				return super.hashCode();
			}
			this.hashCode = sb.toString().hashCode();
		}
		return this.hashCode;
	}


}