package resources.east.data.base;

import java.io.Serializable;

public class BaseEastGdxxPK implements Serializable {
	// Fields

	/**
	* 
	*/
	private static final long serialVersionUID = -6586018064334972879L;
	private String khtybh;
	private String gdzjhm;
	private String cjrq;

	// Constructors

	/** default constructor */
	public BaseEastGdxxPK() {
	}

	/** full constructor */
	public BaseEastGdxxPK(String khtybh,String gdzjhm, String cjrq) {
		this.khtybh = khtybh;
		this.gdzjhm = gdzjhm;
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

	public String getGdzjhm() {
		return gdzjhm;
	}

	public void setGdzjhm(String gdzjhm) {
		this.gdzjhm = gdzjhm;
	}
	
	
}
