package resources.east.data.base;

import java.io.Serializable;

public class BaseEastHlxxbPK implements Serializable {

	private String wb;
	private String bb;
	private String hlrq;
	private String cjrq;

	// Constructors

	/** default constructor */
	private int hashCode = Integer.MIN_VALUE;
	
	/** default constructor */
	public BaseEastHlxxbPK() {}


	public BaseEastHlxxbPK(String wb, String bb, String hlrq, String cjrq) {
		this.wb = wb;
		this.bb = bb;
		this.hlrq = hlrq;
		this.cjrq = cjrq;
	}

	// Property accessors
	
	public String getWb() {
		return wb;
	}


	public void setWb(String wb) {
		this.wb = wb;
	}


	public String getBb() {
		return bb;
	}


	public void setBb(String bb) {
		this.bb = bb;
	}


	public String getHlrq() {
		return hlrq;
	}


	public void setHlrq(String hlrq) {
		this.hlrq = hlrq;
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
		if (!(obj instanceof resources.east.data.pub.EastHlxxbPK)) return false;
		else {
			resources.east.data.pub.EastHlxxbPK mObj = (resources.east.data.pub.EastHlxxbPK) obj;
			if (null != this.getWb() && null != mObj.getWb()) {
				if (!this.getWb().equals(mObj.getWb())) {
					return false;
				}
			}
			else {
				return false;
			}
			if (null != this.getBb() && null != mObj.getBb()) {
				if (!this.getBb().equals(mObj.getBb())) {
					return false;
				}
			}
			else {
				return false;
			}
			if (null != this.getHlrq() && null != mObj.getHlrq()) {
				if (!this.getHlrq().equals(mObj.getHlrq())) {
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

		result = 37 * result + (getWb() == null ? 0 : this.getWb().hashCode());
		result = 37 * result + (getBb() == null ? 0 : this.getBb().hashCode());
		result = 37 * result + (getHlrq() == null ? 0 : this.getHlrq().hashCode());
		result = 37 * result + (getCjrq() == null ? 0 : this.getCjrq().hashCode());
		return result;
	}
}


