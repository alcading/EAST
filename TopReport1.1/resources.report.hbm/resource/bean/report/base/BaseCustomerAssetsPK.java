package resource.bean.report.base;

import java.io.Serializable;


public abstract class BaseCustomerAssetsPK implements Serializable {

	protected int hashCode = Integer.MIN_VALUE;

	private java.lang.String cnum;
	private java.util.Date updt;


	public BaseCustomerAssetsPK () {}
	
	public BaseCustomerAssetsPK (
		java.lang.String cnum,
		java.util.Date updt) {

		this.setCnum(cnum);
		this.setUpdt(updt);
	}


	/**
	 * Return the value associated with the column: cnum
	 */
	public java.lang.String getCnum () {
		return cnum;
	}

	/**
	 * Set the value related to the column: cnum
	 * @param cnum the cnum value
	 */
	public void setCnum (java.lang.String cnum) {
		this.cnum = cnum;
	}



	/**
	 * Return the value associated with the column: updt
	 */
	public java.util.Date getUpdt () {
		return updt;
	}

	/**
	 * Set the value related to the column: updt
	 * @param updt the updt value
	 */
	public void setUpdt (java.util.Date updt) {
		this.updt = updt;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof resource.bean.report.CustomerAssetsPK)) return false;
		else {
			resource.bean.report.CustomerAssetsPK mObj = (resource.bean.report.CustomerAssetsPK) obj;
			if (null != this.getCnum() && null != mObj.getCnum()) {
				if (!this.getCnum().equals(mObj.getCnum())) {
					return false;
				}
			}
			else {
				return false;
			}
			if (null != this.getUpdt() && null != mObj.getUpdt()) {
				if (!this.getUpdt().equals(mObj.getUpdt())) {
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
			if (null != this.getCnum()) {
				sb.append(this.getCnum().hashCode());
				sb.append(":");
			}
			else {
				return super.hashCode();
			}
			if (null != this.getUpdt()) {
				sb.append(this.getUpdt().hashCode());
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