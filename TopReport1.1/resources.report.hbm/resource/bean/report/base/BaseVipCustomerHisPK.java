package resource.bean.report.base;

import java.io.Serializable;


public abstract class BaseVipCustomerHisPK implements Serializable {

	protected int hashCode = Integer.MIN_VALUE;

	private java.lang.String yearMonth;
	private java.lang.String cnum;


	public BaseVipCustomerHisPK () {}
	
	public BaseVipCustomerHisPK (
		java.lang.String yearMonth,
		java.lang.String cnum) {

		this.setYearMonth(yearMonth);
		this.setCnum(cnum);
	}


	/**
	 * Return the value associated with the column: year_month
	 */
	public java.lang.String getYearMonth () {
		return yearMonth;
	}

	/**
	 * Set the value related to the column: year_month
	 * @param yearMonth the year_month value
	 */
	public void setYearMonth (java.lang.String yearMonth) {
		this.yearMonth = yearMonth;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof resource.bean.report.VipCustomerHisPK)) return false;
		else {
			resource.bean.report.VipCustomerHisPK mObj = (resource.bean.report.VipCustomerHisPK) obj;
			if (null != this.getYearMonth() && null != mObj.getYearMonth()) {
				if (!this.getYearMonth().equals(mObj.getYearMonth())) {
					return false;
				}
			}
			else {
				return false;
			}
			if (null != this.getCnum() && null != mObj.getCnum()) {
				if (!this.getCnum().equals(mObj.getCnum())) {
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
			if (null != this.getYearMonth()) {
				sb.append(this.getYearMonth().hashCode());
				sb.append(":");
			}
			else {
				return super.hashCode();
			}
			if (null != this.getCnum()) {
				sb.append(this.getCnum().hashCode());
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