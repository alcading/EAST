package resources.east.data.base;

import java.io.Serializable;

public class BaseEastJjkxxPK implements Serializable {
	// Fields

	/**
	* 
	*/
	private static final long serialVersionUID = -6586018064334972879L;
	private String kh;
	private String hqckzh;
	private String cjrq;

	// Constructors

	/** default constructor */
	public BaseEastJjkxxPK() {
	}

	public BaseEastJjkxxPK(String kh, String hqckzh, String cjrq) {
		super();
		this.kh = kh;
		this.hqckzh = hqckzh;
		this.cjrq = cjrq;
	}

	public String getKh() {
		return kh;
	}

	public void setKh(String kh) {
		this.kh = kh;
	}

	public String getHqckzh() {
		return hqckzh;
	}

	public void setHqckzh(String hqckzh) {
		this.hqckzh = hqckzh;
	}

	public String getCjrq() {
		return cjrq;
	}

	public void setCjrq(String cjrq) {
		this.cjrq = cjrq;
	}

	
	
}
