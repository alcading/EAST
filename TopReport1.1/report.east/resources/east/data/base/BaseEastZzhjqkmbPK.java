package resources.east.data.base;

import java.io.Serializable;

public class BaseEastZzhjqkmbPK implements Serializable {
	// Fields

	/**
	* 
	*/
	private static final long serialVersionUID = -6586018064334972879L;
	private String nbjgh;
	private String kmbh;
	private String bz;
	private String kjrq;
	private String bszq;

	// Constructors

	/** default constructor */
	public BaseEastZzhjqkmbPK() {
	}

	/** full constructor */
	public BaseEastZzhjqkmbPK(String nbjgh, String kmbh, String bz, String kjrq, String bszq) {
		this.nbjgh = nbjgh;
		this.kmbh = kmbh;
		this.bz = bz;
		this.kjrq = kjrq;
		this.bszq = bszq;
	}

	public String getNbjgh() {
		return this.nbjgh;
	}

	public void setNbjgh(String nbjgh) {
		this.nbjgh = nbjgh;
	}

	public String getKmbh() {
		return kmbh;
	}

	public void setKmbh(String kmbh) {
		this.kmbh = kmbh;
	}

	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	public String getKjrq() {
		return kjrq;
	}

	public void setKjrq(String kjrq) {
		this.kjrq = kjrq;
	}

	public String getBszq() {
		return bszq;
	}

	public void setBszq(String bszq) {
		this.bszq = bszq;
	}

}
