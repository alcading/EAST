package resources.east.data.base;

import java.io.Serializable;

public class BaseEastSxxxPK implements Serializable {
	// Fields

	/**
	* 
	*/
	private static final long serialVersionUID = -6586018064334972879L;
	private String sxxyh;
	private String cjrq;

	// Constructors

	/** default constructor */
	public BaseEastSxxxPK() {
	}

	public BaseEastSxxxPK(String sxxyh, String cjrq) {
		super();
		this.sxxyh = sxxyh;
		this.cjrq = cjrq;
	}

	public String getSxxyh() {
		return sxxyh;
	}

	public void setSxxyh(String sxxyh) {
		this.sxxyh = sxxyh;
	}

	public String getCjrq() {
		return cjrq;
	}

	public void setCjrq(String cjrq) {
		this.cjrq = cjrq;
	}
	
}
