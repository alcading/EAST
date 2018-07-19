package resources.east.data.base;

import java.io.Serializable;

public class BaseEastNbkmdzbPK implements Serializable {
	// Fields

	/**
	* 
	*/
	private static final long serialVersionUID = -6586018064334972879L;
	private String kmbh;
	private String cjrq;

	// Constructors

	/** default constructor */
	public BaseEastNbkmdzbPK() {
	}

	/** full constructor */
	public BaseEastNbkmdzbPK(String kmbh, String cjrq) {
		this.kmbh = kmbh;
		this.cjrq = cjrq;
	}

	public String getKmbh() {
		return kmbh;
	}

	public void setKmbh(String kmbh) {
		this.kmbh = kmbh;
	}

	public String getCjrq() {
		return cjrq;
	}

	public void setCjrq(String cjrq) {
		this.cjrq = cjrq;
	}

}
