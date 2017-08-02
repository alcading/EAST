package resource.bean.report.base;

import java.io.Serializable;


public abstract class BaseTradeLogPK implements Serializable {

	protected int hashCode = Integer.MIN_VALUE;

	private java.util.Date txdate;
	private java.lang.String id;


	public BaseTradeLogPK () {}
	
	public BaseTradeLogPK (
		java.util.Date txdate,
		java.lang.String id) {

		this.setTxdate(txdate);
		this.setId(id);
	}


	/**
	 * Return the value associated with the column: txdate
	 */
	public java.util.Date getTxdate () {
		return txdate;
	}

	/**
	 * Set the value related to the column: txdate
	 * @param txdate the txdate value
	 */
	public void setTxdate (java.util.Date txdate) {
		this.txdate = txdate;
	}



	/**
	 * Return the value associated with the column: id
	 */
	public java.lang.String getId () {
		return id;
	}

	/**
	 * Set the value related to the column: id
	 * @param id the id value
	 */
	public void setId (java.lang.String id) {
		this.id = id;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof resource.bean.report.TradeLogPK)) return false;
		else {
			resource.bean.report.TradeLogPK mObj = (resource.bean.report.TradeLogPK) obj;
			if (null != this.getTxdate() && null != mObj.getTxdate()) {
				if (!this.getTxdate().equals(mObj.getTxdate())) {
					return false;
				}
			}
			else {
				return false;
			}
			if (null != this.getId() && null != mObj.getId()) {
				if (!this.getId().equals(mObj.getId())) {
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
			if (null != this.getTxdate()) {
				sb.append(this.getTxdate().hashCode());
				sb.append(":");
			}
			else {
				return super.hashCode();
			}
			if (null != this.getId()) {
				sb.append(this.getId().hashCode());
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