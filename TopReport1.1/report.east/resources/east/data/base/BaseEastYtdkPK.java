package resources.east.data.base;

import java.io.Serializable;

public class BaseEastYtdkPK implements Serializable {
	// Fields

	/**
	* 
	*/
	private static final long serialVersionUID = -6586018064334972879L;
	private String xdhth;
	private String cjrq;

	// Constructors

	/** default constructor */
	public BaseEastYtdkPK() {
	}

	public BaseEastYtdkPK(String xdhth, String cjrq) {
		super();
		this.xdhth = xdhth;
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
