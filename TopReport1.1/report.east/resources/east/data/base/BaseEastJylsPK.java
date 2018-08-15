package resources.east.data.base;

import java.io.Serializable;

public class BaseEastJylsPK implements Serializable {
	// Fields
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6586018064334972879L;
	private String hxjylsh;
	private String zjylsh;
	private Integer bcxh;
	private String jyrq;
	private String jyzh;
	private String cjrq;

	// Constructors

	/** default constructor */
	public BaseEastJylsPK() {
	}

	/** full constructor */
	public BaseEastJylsPK(String hxjylsh, String zjylsh, Integer bcxh, String jyrq, String jyzh, String cjrq) {
		this.hxjylsh = hxjylsh;
		this.zjylsh = zjylsh;
		this.bcxh = bcxh;
		this.jyrq = jyrq;
		this.jyzh = jyzh;
		this.cjrq = cjrq;
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

	public String getJyrq() {
		return jyrq;
	}

	public void setJyrq(String jyrq) {
		this.jyrq = jyrq;
	}

	public String getJyzh() {
		return jyzh;
	}

	public void setJyzh(String jyzh) {
		this.jyzh = jyzh;
	}

	public String getCjrq() {
		return cjrq;
	}

	public void setCjrq(String cjrq) {
		this.cjrq = cjrq;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof resources.east.data.pub.EastJylsPK)) return false;
		else {
			resources.east.data.pub.EastJylsPK mObj = (resources.east.data.pub.EastJylsPK) obj;
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
			else {
				return false;
			}
			if (null != this.getBcxh() && null != mObj.getBcxh()) {
				if (!this.getBcxh().equals(mObj.getBcxh())) {
					return false;
				}
			}
			else {
				return false;
			}
			if (null != this.getJyrq() && null != mObj.getJyrq()) {
				if (!this.getJyrq().equals(mObj.getJyrq())) {
					return false;
				}
			}
			else {
				return false;
			}
			if (null != this.getJyzh() && null != mObj.getJyzh()) {
				if (!this.getJyzh().equals(mObj.getJyzh())) {
					return false;
				}
			}
			else {
				return false;
			}
			if (null != this.getCjrq() && null != mObj.getCjrq()) {
				if (!this.getCjrq().equals(mObj.getCjrq())) {
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
		result = 37 * result + (getJyrq() == null ? 0 : this.getJyrq().hashCode());
		result = 37 * result + (getJyzh() == null ? 0 : this.getJyzh().hashCode());
		result = 37 * result + (getCjrq() == null ? 0 : this.getCjrq().hashCode());
		return result;
	}

}
