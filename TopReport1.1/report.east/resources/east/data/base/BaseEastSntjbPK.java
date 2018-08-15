package resources.east.data.base;

import java.io.Serializable;

public class BaseEastSntjbPK implements Serializable {

	private String nbjgh;
	private String tjkmbh;
	private String qxlx;
	private String tjrq;
	private String bz;
	private String cjrq;

	// Constructors

	/** default constructor */
	private int hashCode = Integer.MIN_VALUE;
	
	/** default constructor */
	public BaseEastSntjbPK() {}


	public BaseEastSntjbPK(String nbjgh, String tjkmbh, String qxlx, String tjrq, String bz, String cjrq) {
		this.nbjgh = nbjgh;
		this.tjkmbh = tjkmbh;
		this.qxlx = qxlx;
		this.tjrq = tjrq;
		this.bz = bz;
		this.cjrq = cjrq;
	}
	// Property accessors


	public String getNbjgh() {
		return nbjgh;
	}


	public void setNbjgh(String nbjgh) {
		this.nbjgh = nbjgh;
	}


	public String getTjkmbh() {
		return tjkmbh;
	}


	public void setTjkmbh(String tjkmbh) {
		this.tjkmbh = tjkmbh;
	}


	public String getQxlx() {
		return qxlx;
	}


	public void setQxlx(String qxlx) {
		this.qxlx = qxlx;
	}


	public String getTjrq() {
		return tjrq;
	}


	public void setTjrq(String tjrq) {
		this.tjrq = tjrq;
	}


	public String getBz() {
		return bz;
	}


	public void setBz(String bz) {
		this.bz = bz;
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
		if (!(obj instanceof resources.east.data.pub.EastSntjbPK)) return false;
		else {
			resources.east.data.pub.EastSntjbPK mObj = (resources.east.data.pub.EastSntjbPK) obj;
			if (null != this.getTjkmbh() && null != mObj.getTjkmbh()) {
				if (!this.getTjkmbh().equals(mObj.getTjkmbh())) {
					return false;
				}
			}
			else {
				return false;
			}
			if (null != this.getQxlx() && null != mObj.getQxlx()) {
				if (!this.getQxlx().equals(mObj.getQxlx())) {
					return false;
				}
			}
			else {
				return false;
			}
			if (null != this.getTjrq() && null != mObj.getTjrq()) {
				if (!this.getTjrq().equals(mObj.getTjrq())) {
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
			if (null != this.getBz() && null != mObj.getBz()) {
				if (!this.getBz().equals(mObj.getBz())) {
					return false;
				}
			}
			else {
				return false;
			}
			if (null != this.getNbjgh() && null != mObj.getNbjgh()) {
				if (!this.getNbjgh().equals(mObj.getNbjgh())) {
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

		result = 37 * result + (getTjkmbh() == null ? 0 : this.getTjkmbh().hashCode());
		result = 37 * result + (getQxlx() == null ? 0 : this.getQxlx().hashCode());
		result = 37 * result + (getTjrq() == null ? 0 : this.getTjrq().hashCode());
		result = 37 * result + (getBz() == null ? 0 : this.getBz().hashCode());
		result = 37 * result + (getCjrq() == null ? 0 : this.getCjrq().hashCode());
		result = 37 * result + (getNbjgh() == null ? 0 : this.getNbjgh().hashCode());
		return result;
	}
}


