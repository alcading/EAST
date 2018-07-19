package resources.east.data.base;

import java.io.Serializable;

public class BaseEastDgkhPK implements Serializable {
	// Fields

	/**
	* 
	*/
	private static final long serialVersionUID = -6586018064334972879L;
	private String khtybh;
	private String cjrq;

	// Constructors

	/** default constructor */
	public BaseEastDgkhPK() {
	}

	/** full constructor */
	public BaseEastDgkhPK(String khtybh, String cjrq) {
		this.khtybh = khtybh;
		this.cjrq = cjrq;
	}

	public String getKhtybh() {
		return khtybh;
	}

	public void setKhtybh(String khtybh) {
		this.khtybh = khtybh;
	}

	public String getCjrq() {
		return cjrq;
	}

	public void setCjrq(String cjrq) {
		this.cjrq = cjrq;
	}

}
