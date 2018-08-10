package resources.east.data.base;

import java.io.Serializable;

public class BaseEastLccpxsmxjlPK implements Serializable {
	// Fields

		/**
	 * 
	 */
	private static final long serialVersionUID = -6586018064334972879L;
	private String hxjylsh;
	private String zjylsh;
	private Integer bcxh;
	private String hxjyrq;

	// Constructors

	/** default constructor */
	public BaseEastLccpxsmxjlPK() {
	}

	/** full constructor */
	public BaseEastLccpxsmxjlPK(String hxjylsh, String zjylsh, Integer bcxh, String hxjyrq) {
		this.hxjylsh = hxjylsh;
		this.zjylsh = zjylsh;
		this.bcxh = bcxh;
		this.hxjyrq = hxjyrq;
	}

	// Property accessors
	public String getHxjylsh() {
		return hxjylsh;
	}

	public void setHxjylsh(String hxjylsh) {
		this.hxjylsh = hxjylsh;
	}

	public String getZjylsh() {
		return zjylsh;
	}

	public void setZjylsh(String zjylsh) {
		this.zjylsh = zjylsh;
	}

	public Integer getBcxh() {
		return bcxh;
	}

	public void setBcxh(Integer bcxh) {
		this.bcxh = bcxh;
	}

	public String getHxjyrq() {
		return hxjyrq;
	}

	public void setHxjyrq(String hxjyrq) {
		this.hxjyrq = hxjyrq;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof resources.east.data.pub.EastLccpxsmxjlPK)) return false;
		else {
			resources.east.data.pub.EastLccpxsmxjlPK mObj = (resources.east.data.pub.EastLccpxsmxjlPK) obj;
			if (null != this.getHxjylsh() && null != mObj.getHxjylsh()) {
				if (!this.getHxjylsh().equals(mObj.getHxjylsh())) {
					return false;
				}
			}
			else {
				return false;
			}
			if (null != this.getZjylsh() && null != mObj.getZjylsh()) {
				if (!this.getZjylsh().equals(mObj.getZjylsh())) {
					return false;
				}
			}
			if (null != this.getBcxh() && null != mObj.getBcxh()) {
				if (!this.getBcxh().equals(mObj.getBcxh())) {
					return false;
				}
			}
			if (null != this.getHxjyrq() && null != mObj.getHxjyrq()) {
				if (!this.getHxjyrq().equals(mObj.getHxjyrq())) {
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
		result = 37 * result + (getHxjylsh() == null ? 0 : this.getHxjylsh().hashCode());
		result = 37 * result + (getZjylsh() == null ? 0 : this.getZjylsh().hashCode());
		result = 37 * result + (getBcxh() == null ? 0 : this.getBcxh().hashCode());
		result = 37 * result + (getHxjyrq() == null ? 0 : this.getHxjyrq().hashCode());
		return result;
	}

}
