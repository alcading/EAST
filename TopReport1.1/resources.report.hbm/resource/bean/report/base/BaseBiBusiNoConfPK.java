package resource.bean.report.base;

import java.io.Serializable;


public abstract class BaseBiBusiNoConfPK implements Serializable {

	protected int hashCode = Integer.MIN_VALUE;

	private java.lang.String apptype;
	private java.lang.String filetype;
	private java.lang.String busitype;


	public BaseBiBusiNoConfPK () {}
	
	public BaseBiBusiNoConfPK (
		java.lang.String apptype,
		java.lang.String filetype,
		java.lang.String busitype) {

		this.setApptype(apptype);
		this.setFiletype(filetype);
		this.setBusitype(busitype);
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
	 * Return the value associated with the column: FILETYPE
	 */
	public java.lang.String getFiletype () {
		return filetype;
	}

	/**
	 * Set the value related to the column: FILETYPE
	 * @param filetype the FILETYPE value
	 */
	public void setFiletype (java.lang.String filetype) {
		this.filetype = filetype;
	}



	/**
	 * Return the value associated with the column: BUSITYPE
	 */
	public java.lang.String getBusitype () {
		return busitype;
	}

	/**
	 * Set the value related to the column: BUSITYPE
	 * @param busitype the BUSITYPE value
	 */
	public void setBusitype (java.lang.String busitype) {
		this.busitype = busitype;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof resource.bean.report.BiBusiNoConfPK)) return false;
		else {
			resource.bean.report.BiBusiNoConfPK mObj = (resource.bean.report.BiBusiNoConfPK) obj;
			if (null != this.getApptype() && null != mObj.getApptype()) {
				if (!this.getApptype().equals(mObj.getApptype())) {
					return false;
				}
			}
			else {
				return false;
			}
			if (null != this.getFiletype() && null != mObj.getFiletype()) {
				if (!this.getFiletype().equals(mObj.getFiletype())) {
					return false;
				}
			}
			else {
				return false;
			}
			if (null != this.getBusitype() && null != mObj.getBusitype()) {
				if (!this.getBusitype().equals(mObj.getBusitype())) {
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
			if (null != this.getApptype()) {
				sb.append(this.getApptype().hashCode());
				sb.append(":");
			}
			else {
				return super.hashCode();
			}
			if (null != this.getFiletype()) {
				sb.append(this.getFiletype().hashCode());
				sb.append(":");
			}
			else {
				return super.hashCode();
			}
			if (null != this.getBusitype()) {
				sb.append(this.getBusitype().hashCode());
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