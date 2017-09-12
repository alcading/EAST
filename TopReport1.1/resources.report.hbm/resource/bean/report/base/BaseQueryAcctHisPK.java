package resource.bean.report.base;

import java.io.Serializable;


public abstract class BaseQueryAcctHisPK implements Serializable {

	protected int hashCode = Integer.MIN_VALUE;

	private java.util.Date updt;
	private java.lang.String actno;


	public BaseQueryAcctHisPK () {}
	
	public BaseQueryAcctHisPK (
		java.util.Date updt,
		java.lang.String actno) {

		this.setUpdt(updt);
		this.setActno(actno);
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



	/**
	 * Return the value associated with the column: actno
	 */
	public java.lang.String getActno () {
		return actno;
	}

	/**
	 * Set the value related to the column: actno
	 * @param actno the actno value
	 */
	public void setActno (java.lang.String actno) {
		this.actno = actno;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof resource.bean.report.QueryAcctHisPK)) return false;
		else {
			resource.bean.report.QueryAcctHisPK mObj = (resource.bean.report.QueryAcctHisPK) obj;
			if (null != this.getUpdt() && null != mObj.getUpdt()) {
				if (!this.getUpdt().equals(mObj.getUpdt())) {
					return false;
				}
			}
			else {
				return false;
			}
			if (null != this.getActno() && null != mObj.getActno()) {
				if (!this.getActno().equals(mObj.getActno())) {
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
			if (null != this.getUpdt()) {
				sb.append(this.getUpdt().hashCode());
				sb.append(":");
			}
			else {
				return super.hashCode();
			}
			if (null != this.getActno()) {
				sb.append(this.getActno().hashCode());
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