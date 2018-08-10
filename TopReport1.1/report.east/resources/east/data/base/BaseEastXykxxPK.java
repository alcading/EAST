package resources.east.data.base;

import java.io.Serializable;

public class BaseEastXykxxPK implements Serializable {
	// Fields

	/**
	* 
	*/
	private static final long serialVersionUID = -6586018064334972879L;
	private String kh;
	private String cjrq;

	// Constructors

	/** default constructor */
	public BaseEastXykxxPK() {
	}

	public BaseEastXykxxPK(String kh, String cjrq) {
		super();
		this.kh = kh;
		this.cjrq = cjrq;
	}

	public String getKh() {
		return kh;
	}

	public void setKh(String kh) {
		this.kh = kh;
	}

	public String getCjrq() {
		return cjrq;
	}

	public void setCjrq(String cjrq) {
		this.cjrq = cjrq;
	}

	
}
