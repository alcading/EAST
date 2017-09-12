package resource.bean.report.base;

import java.io.Serializable;


public abstract class BaseMtsInOutCodePK implements Serializable {

	protected int hashCode = Integer.MIN_VALUE;

	private java.lang.String id;
	private java.lang.String codeType;


	public BaseMtsInOutCodePK () {}
	
	public BaseMtsInOutCodePK (
		java.lang.String id,
		java.lang.String codeType) {

		this.setId(id);
		this.setCodeType(codeType);
	}


	/**
	 * Return the value associated with the column: ID
	 */
	public java.lang.String getId () {
		return id;
	}

	/**
	 * Set the value related to the column: ID
	 * @param id the ID value
	 */
	public void setId (java.lang.String id) {
		this.id = id;
	}



	/**
	 * Return the value associated with the column: CODE_TYPE
	 */
	public java.lang.String getCodeType () {
		return codeType;
	}

	/**
	 * Set the value related to the column: CODE_TYPE
	 * @param codeType the CODE_TYPE value
	 */
	public void setCodeType (java.lang.String codeType) {
		this.codeType = codeType;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof resource.bean.report.MtsInOutCodePK)) return false;
		else {
			resource.bean.report.MtsInOutCodePK mObj = (resource.bean.report.MtsInOutCodePK) obj;
			if (null != this.getId() && null != mObj.getId()) {
				if (!this.getId().equals(mObj.getId())) {
					return false;
				}
			}
			else {
				return false;
			}
			if (null != this.getCodeType() && null != mObj.getCodeType()) {
				if (!this.getCodeType().equals(mObj.getCodeType())) {
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
			if (null != this.getId()) {
				sb.append(this.getId().hashCode());
				sb.append(":");
			}
			else {
				return super.hashCode();
			}
			if (null != this.getCodeType()) {
				sb.append(this.getCodeType().hashCode());
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