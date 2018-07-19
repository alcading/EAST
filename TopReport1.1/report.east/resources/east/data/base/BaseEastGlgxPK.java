package resources.east.data.base;

import java.io.Serializable;

public class BaseEastGlgxPK implements Serializable {
	// Fields

	/**
	* 
	*/
	private static final long serialVersionUID = -6586018064334972879L;
	private String khtybh;
	private String glrkhtybh;
	private String cjrq;

	// Constructors

	/** default constructor */
	public BaseEastGlgxPK() {
	}

	/** full constructor */
	public BaseEastGlgxPK(String khtybh, String glrkhtybh, String cjrq) {
		this.khtybh = khtybh;
		this.glrkhtybh = glrkhtybh;
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

	public String getGlrkhtybh() {
		return glrkhtybh;
	}

	public void setGlrkhtybh(String glrkhtybh) {
		this.glrkhtybh = glrkhtybh;
	}

}
