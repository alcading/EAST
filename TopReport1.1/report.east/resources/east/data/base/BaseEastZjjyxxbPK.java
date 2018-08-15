package resources.east.data.base;

import java.io.Serializable;

public class BaseEastZjjyxxbPK implements Serializable {

	private String jybh;
	private String jrgjbh;
	private String cjrq;

	// Constructors

	/** default constructor */
	private int hashCode = Integer.MIN_VALUE;
	
	/** default constructor */
	public BaseEastZjjyxxbPK() {}


	public BaseEastZjjyxxbPK(String jybh, String jrgjbh, String cjrq) {
		this.jybh = jybh;
		this.jrgjbh = jrgjbh;
		this.cjrq = cjrq;
	}
	// Property accessors


	public String getJybh() {
		return jybh;
	}


	public void setJybh(String jybh) {
		this.jybh = jybh;
	}


	public String getJrgjbh() {
		return jrgjbh;
	}


	public void setJrgjbh(String jrgjbh) {
		this.jrgjbh = jrgjbh;
	}


	public String getCjrq() {
		return cjrq;
	}


	public void setCjrq(String cjrq) {
		this.cjrq = cjrq;
	}


	public int getHashCode() {
		return hashCode;
	}


	public void setHashCode(int hashCode) {
		this.hashCode = hashCode;
	}
	
	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof resources.east.data.pub.EastZjjyxxbPK)) return false;
		else {
			resources.east.data.pub.EastZjjyxxbPK mObj = (resources.east.data.pub.EastZjjyxxbPK) obj;
			if (null != this.getJybh() && null != mObj.getJybh()) {
				if (!this.getJybh().equals(mObj.getJybh())) {
					return false;
				}
			}
			else {
				return false;
			}
			if (null != this.getJrgjbh() && null != mObj.getJrgjbh()) {
				if (!this.getJrgjbh().equals(mObj.getJrgjbh())) {
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

		result = 37 * result + (getJybh() == null ? 0 : this.getJybh().hashCode());
		result = 37 * result + (getJrgjbh() == null ? 0 : this.getJrgjbh().hashCode());
		result = 37 * result + (getCjrq() == null ? 0 : this.getCjrq().hashCode());
		return result;
	}
}


