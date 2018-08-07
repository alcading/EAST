package resources.east.data.base;

import java.io.Serializable;

public class BaseEastMyrzywxxbPK implements Serializable {
	// Fields

	/**
	* 
	*/
	private static final long serialVersionUID = -6586018064334972879L;
	private String dgxdjjh;
	private String cjrq;

	// Constructors

	/** default constructor */
	public BaseEastMyrzywxxbPK() {
	}

	public BaseEastMyrzywxxbPK(String dgxdjjh, String cjrq) {
		super();
		this.dgxdjjh = dgxdjjh;
		this.cjrq = cjrq;
	}

	

	public String getDgxdjjh() {
		return dgxdjjh;
	}

	public void setDgxdjjh(String dgxdjjh) {
		this.dgxdjjh = dgxdjjh;
	}

	public String getCjrq() {
		return cjrq;
	}

	public void setCjrq(String cjrq) {
		this.cjrq = cjrq;
	}

	
	
}
