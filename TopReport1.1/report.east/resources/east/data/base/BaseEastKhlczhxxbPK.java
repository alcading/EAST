package resources.east.data.base;

import java.io.Serializable;

public class BaseEastKhlczhxxbPK implements Serializable {
	// Fields

		/**
	 * 
	 */
	private static final long serialVersionUID = -6586018064334972879L;
	private String lczh;
	private String glhqckzh;
	private String hnbsm;

	// Constructors

	/** default constructor */
	public BaseEastKhlczhxxbPK() {
	}

	/** full constructor */
	public BaseEastKhlczhxxbPK(String lczh, String glhqckzh, String hnbsm) {
		this.lczh = lczh;
		this.glhqckzh = glhqckzh;
		this.hnbsm = hnbsm;
	}

	// Property accessors
	

	public String getLczh() {
		return lczh;
	}

	public void setLczh(String lczh) {
		this.lczh = lczh;
	}

	public String getGlhqckzh() {
		return glhqckzh;
	}

	public void setGlhqckzh(String glhqckzh) {
		this.glhqckzh = glhqckzh;
	}

	public String getHnbsm() {
		return hnbsm;
	}

	public void setHnbsm(String hnbsm) {
		this.hnbsm = hnbsm;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof resources.east.data.pub.EastKhlczhxxbPK)) return false;
		else {
			resources.east.data.pub.EastKhlczhxxbPK mObj = (resources.east.data.pub.EastKhlczhxxbPK) obj;
			if (null != this.getLczh() && null != mObj.getLczh()) {
				if (!this.getLczh().equals(mObj.getLczh())) {
					return false;
				}
			}
			else {
				return false;
			}
			if (null != this.getGlhqckzh() && null != mObj.getGlhqckzh()) {
				if (!this.getGlhqckzh().equals(mObj.getGlhqckzh())) {
					return false;
				}
			}
			else {
				return false;
			}
			if (null != this.getHnbsm() && null != mObj.getHnbsm()) {
				if (!this.getHnbsm().equals(mObj.getHnbsm())) {
					return false;
				}
			}
			else {
				return false;
			}
			return true;
		}
	}
	public int hashCode() {
		int result = 17;
		
		result = 37 * result + (getLczh() == null ? 0 : this.getLczh().hashCode());
		result = 37 * result + (getGlhqckzh() == null ? 0 : this.getGlhqckzh().hashCode());
		result = 37 * result + (getHnbsm() == null ? 0 : this.getHnbsm().hashCode());
		return result;
	}

}
