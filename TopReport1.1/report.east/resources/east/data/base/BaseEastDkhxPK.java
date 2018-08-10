package resources.east.data.base;

import java.io.Serializable;

public class BaseEastDkhxPK implements Serializable {
	// Fields

	/**
	* 
	*/
	private static final long serialVersionUID = -6586018064334972879L;
	private String xdjjh;
	private String hxrq;
	private String hxshrq;
	private String cjrq;

	// Constructors

	/** default constructor */
	public BaseEastDkhxPK() {
	}

	public BaseEastDkhxPK(String xdjjh, String hxrq, String hxshrq, String cjrq) {
		super();
		this.xdjjh = xdjjh;
		this.hxrq = hxrq;
		this.hxshrq = hxshrq;
		this.cjrq = cjrq;
	}

	public String getXdjjh() {
		return xdjjh;
	}

	public void setXdjjh(String xdjjh) {
		this.xdjjh = xdjjh;
	}

	public String getHxrq() {
		return hxrq;
	}

	public void setHxrq(String hxrq) {
		this.hxrq = hxrq;
	}

	public String getHxshrq() {
		return hxshrq;
	}

	public void setHxshrq(String hxshrq) {
		this.hxshrq = hxshrq;
	}

	public String getCjrq() {
		return cjrq;
	}

	public void setCjrq(String cjrq) {
		this.cjrq = cjrq;
	}
	
}
