package resources.east.data.base;

import java.io.Serializable;

public class BaseEastDkwjxtbdPK implements Serializable {
	// Fields

	/**
	* 
	*/
	private static final long serialVersionUID = -6586018064334972879L;
	private String tzrq;
	private String xdjjh;
	private String cjrq;

	// Constructors

	/** default constructor */
	public BaseEastDkwjxtbdPK() {
	}

	public BaseEastDkwjxtbdPK(String tzrq, String xdjjh, String cjrq) {
		super();
		this.tzrq = tzrq;
		this.xdjjh = xdjjh;
		this.cjrq = cjrq;
	}

	public String getTzrq() {
		return tzrq;
	}

	public void setTzrq(String tzrq) {
		this.tzrq = tzrq;
	}

	public String getXdjjh() {
		return xdjjh;
	}

	public void setXdjjh(String xdjjh) {
		this.xdjjh = xdjjh;
	}

	public String getCjrq() {
		return cjrq;
	}

	public void setCjrq(String cjrq) {
		this.cjrq = cjrq;
	}
	
}
