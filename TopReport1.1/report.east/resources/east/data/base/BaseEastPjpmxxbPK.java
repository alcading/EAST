package resources.east.data.base;

import java.io.Serializable;

public class BaseEastPjpmxxbPK implements Serializable {
	// Fields

	/**
	* 
	*/
	private static final long serialVersionUID = -6586018064334972879L;
	private String pjhm;
	private String cjrq;

	// Constructors

	/** default constructor */
	public BaseEastPjpmxxbPK() {
	}

	public BaseEastPjpmxxbPK(String pjhm, String cjrq) {
		super();
		this.pjhm = pjhm;
		this.cjrq = cjrq;
	}

	public String getPjhm() {
		return pjhm;
	}

	public void setPjhm(String pjhm) {
		this.pjhm = pjhm;
	}

	public String getCjrq() {
		return cjrq;
	}

	public void setCjrq(String cjrq) {
		this.cjrq = cjrq;
	}

	
}
