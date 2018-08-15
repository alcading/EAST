package resources.east.data.base;

import java.io.Serializable;
public class BaseEastJrgjxxbPK implements Serializable {

	private String jrgjbh;
	private String cjrq;

	// Constructors

	/** default constructor */
	private int hashCode = Integer.MIN_VALUE;
	/** default constructor */
	public BaseEastJrgjxxbPK() {}


	public BaseEastJrgjxxbPK(String jrgjbh, String cjrq) {
		this.jrgjbh = jrgjbh;
		this.cjrq = cjrq;
	}
	// Property accessors
	
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
		if (!(obj instanceof resources.east.data.pub.EastJrgjxxbPK)) return false;
		else {
			resources.east.data.pub.EastJrgjxxbPK mObj = (resources.east.data.pub.EastJrgjxxbPK) obj;
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

		result = 37 * result + (getJrgjbh() == null ? 0 : this.getJrgjbh().hashCode());
		result = 37 * result + (getCjrq() == null ? 0 : this.getCjrq().hashCode());
		return result;
	}
}


