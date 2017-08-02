package resource.bean.report.base;

import java.io.Serializable;


public abstract class BaseSolderCountPK implements Serializable {

	protected int hashCode = Integer.MIN_VALUE;

	private java.util.Date updt;
	private java.lang.String solId;
	private java.lang.String cmrm;


	public BaseSolderCountPK () {}
	
	public BaseSolderCountPK (
		java.util.Date updt,
		java.lang.String solId,
		java.lang.String cmrm) {

		this.setUpdt(updt);
		this.setSolId(solId);
		this.setCmrm(cmrm);
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
	 * Return the value associated with the column: sol_id
	 */
	public java.lang.String getSolId () {
		return solId;
	}

	/**
	 * Set the value related to the column: sol_id
	 * @param solId the sol_id value
	 */
	public void setSolId (java.lang.String solId) {
		this.solId = solId;
	}



	/**
	 * Return the value associated with the column: cmrm
	 */
	public java.lang.String getCmrm () {
		return cmrm;
	}

	/**
	 * Set the value related to the column: cmrm
	 * @param cmrm the cmrm value
	 */
	public void setCmrm (java.lang.String cmrm) {
		this.cmrm = cmrm;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof resource.bean.report.SolderCountPK)) return false;
		else {
			resource.bean.report.SolderCountPK mObj = (resource.bean.report.SolderCountPK) obj;
			if (null != this.getUpdt() && null != mObj.getUpdt()) {
				if (!this.getUpdt().equals(mObj.getUpdt())) {
					return false;
				}
			}
			else {
				return false;
			}
			if (null != this.getSolId() && null != mObj.getSolId()) {
				if (!this.getSolId().equals(mObj.getSolId())) {
					return false;
				}
			}
			else {
				return false;
			}
			if (null != this.getCmrm() && null != mObj.getCmrm()) {
				if (!this.getCmrm().equals(mObj.getCmrm())) {
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
			if (null != this.getSolId()) {
				sb.append(this.getSolId().hashCode());
				sb.append(":");
			}
			else {
				return super.hashCode();
			}
			if (null != this.getCmrm()) {
				sb.append(this.getCmrm().hashCode());
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