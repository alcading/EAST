package resources.east.data.base;

import java.io.Serializable;

public class BaseEastWtdkPK implements Serializable {
	// Fields

	/**
	* 
	*/
	private static final long serialVersionUID = -6586018064334972879L;
	private String xdjjh;
	private String cjrq;

	// Constructors

	/** default constructor */
	public BaseEastWtdkPK() {
	}

	public BaseEastWtdkPK(String xdjjh, String cjrq) {
		super();
		this.xdjjh = xdjjh;
		this.cjrq = cjrq;
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
