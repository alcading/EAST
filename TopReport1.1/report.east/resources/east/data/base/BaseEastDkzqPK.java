package resources.east.data.base;

import java.io.Serializable;

public class BaseEastDkzqPK implements Serializable {
	// Fields

	/**
	* 
	*/
	private static final long serialVersionUID = -6586018064334972879L;
	private String dkzqbh;
	private String cjrq;

	// Constructors

	/** default constructor */
	public BaseEastDkzqPK() {
	}

	public BaseEastDkzqPK(String dkzqbh, String cjrq) {
		super();
		this.dkzqbh = dkzqbh;
		this.cjrq = cjrq;
	}

	public String getDkzqbh() {
		return dkzqbh;
	}

	public void setDkzqbh(String dkzqbh) {
		this.dkzqbh = dkzqbh;
	}

	public String getCjrq() {
		return cjrq;
	}

	public void setCjrq(String cjrq) {
		this.cjrq = cjrq;
	}
	
}
