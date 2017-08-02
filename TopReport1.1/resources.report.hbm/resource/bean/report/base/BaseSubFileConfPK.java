package resource.bean.report.base;

import java.io.Serializable;


public abstract class BaseSubFileConfPK implements Serializable {

	protected int hashCode = Integer.MIN_VALUE;

	private java.lang.String fileType;
	private java.lang.String busiType;
	private java.lang.String appType;


	public BaseSubFileConfPK () {}
	
	public BaseSubFileConfPK (
		java.lang.String fileType,
		java.lang.String busiType,
		java.lang.String appType) {

		this.setFileType(fileType);
		this.setBusiType(busiType);
		this.setAppType(appType);
	}


	/**
	 * Return the value associated with the column: FILE_TYPE
	 */
	public java.lang.String getFileType () {
		return fileType;
	}

	/**
	 * Set the value related to the column: FILE_TYPE
	 * @param fileType the FILE_TYPE value
	 */
	public void setFileType (java.lang.String fileType) {
		this.fileType = fileType;
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
	 * Return the value associated with the column: APP_TYPE
	 */
	public java.lang.String getAppType () {
		return appType;
	}

	/**
	 * Set the value related to the column: APP_TYPE
	 * @param appType the APP_TYPE value
	 */
	public void setAppType (java.lang.String appType) {
		this.appType = appType;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof resource.bean.report.SubFileConfPK)) return false;
		else {
			resource.bean.report.SubFileConfPK mObj = (resource.bean.report.SubFileConfPK) obj;
			if (null != this.getFileType() && null != mObj.getFileType()) {
				if (!this.getFileType().equals(mObj.getFileType())) {
					return false;
				}
			}
			else {
				return false;
			}
			if (null != this.getBusiType() && null != mObj.getBusiType()) {
				if (!this.getBusiType().equals(mObj.getBusiType())) {
					return false;
				}
			}
			else {
				return false;
			}
			if (null != this.getAppType() && null != mObj.getAppType()) {
				if (!this.getAppType().equals(mObj.getAppType())) {
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
			if (null != this.getFileType()) {
				sb.append(this.getFileType().hashCode());
				sb.append(":");
			}
			else {
				return super.hashCode();
			}
			if (null != this.getBusiType()) {
				sb.append(this.getBusiType().hashCode());
				sb.append(":");
			}
			else {
				return super.hashCode();
			}
			if (null != this.getAppType()) {
				sb.append(this.getAppType().hashCode());
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