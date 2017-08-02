package resource.bean.report.base;

import java.io.Serializable;


public abstract class BaseSolderPerformancePK implements Serializable {

	protected int hashCode = Integer.MIN_VALUE;

	private java.lang.String cmrm;
	private java.lang.String moths;
	private java.lang.String dtyp;


	public BaseSolderPerformancePK () {}
	
	public BaseSolderPerformancePK (
		java.lang.String cmrm,
		java.lang.String moths,
		java.lang.String dtyp) {

		this.setCmrm(cmrm);
		this.setMoths(moths);
		this.setDtyp(dtyp);
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



	/**
	 * Return the value associated with the column: moths
	 */
	public java.lang.String getMoths () {
		return moths;
	}

	/**
	 * Set the value related to the column: moths
	 * @param moths the moths value
	 */
	public void setMoths (java.lang.String moths) {
		this.moths = moths;
	}



	/**
	 * Return the value associated with the column: dtyp
	 */
	public java.lang.String getDtyp () {
		return dtyp;
	}

	/**
	 * Set the value related to the column: dtyp
	 * @param dtyp the dtyp value
	 */
	public void setDtyp (java.lang.String dtyp) {
		this.dtyp = dtyp;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof resource.bean.report.SolderPerformancePK)) return false;
		else {
			resource.bean.report.SolderPerformancePK mObj = (resource.bean.report.SolderPerformancePK) obj;
			if (null != this.getCmrm() && null != mObj.getCmrm()) {
				if (!this.getCmrm().equals(mObj.getCmrm())) {
					return false;
				}
			}
			else {
				return false;
			}
			if (null != this.getMoths() && null != mObj.getMoths()) {
				if (!this.getMoths().equals(mObj.getMoths())) {
					return false;
				}
			}
			else {
				return false;
			}
			if (null != this.getDtyp() && null != mObj.getDtyp()) {
				if (!this.getDtyp().equals(mObj.getDtyp())) {
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
			if (null != this.getCmrm()) {
				sb.append(this.getCmrm().hashCode());
				sb.append(":");
			}
			else {
				return super.hashCode();
			}
			if (null != this.getMoths()) {
				sb.append(this.getMoths().hashCode());
				sb.append(":");
			}
			else {
				return super.hashCode();
			}
			if (null != this.getDtyp()) {
				sb.append(this.getDtyp().hashCode());
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