package resources.east.data.base;

import java.io.Serializable;

public class BaseEastXmdkxxbPK implements Serializable {
	// Fields

	/**
	* 
	*/
	private static final long serialVersionUID = -6586018064334972879L;
	private String xdhth;
	private String cjrq;

	// Constructors

	/** default constructor */
	public BaseEastXmdkxxbPK() {
	}

	/** full constructor */
	public BaseEastXmdkxxbPK(String khtybh, String cjrq) {
		this.xdhth = khtybh;
		this.cjrq = cjrq;
	}

	public String getXdhth() {
		return xdhth;
	}

	public void setXdhth(String xdhth) {
		this.xdhth = xdhth;
	}

	public String getCjrq() {
		return cjrq;
	}

	public void setCjrq(String cjrq) {
		this.cjrq = cjrq;
	}

}
