package resources.east.data.base;

import java.io.Serializable;

public class BaseEastXdzczrPK implements Serializable {
	// Fields

	/**
	* 
	*/
	private static final long serialVersionUID = -6586018064334972879L;
	private String zrhth;
	private String cjrq;

	// Constructors

	/** default constructor */
	public BaseEastXdzczrPK() {
	}

	public BaseEastXdzczrPK(String zrhth, String cjrq) {
		super();
		this.zrhth = zrhth;
		this.cjrq = cjrq;
	}

	public String getZrhth() {
		return zrhth;
	}

	public void setZrhth(String zrhth) {
		this.zrhth = zrhth;
	}

	public String getCjrq() {
		return cjrq;
	}

	public void setCjrq(String cjrq) {
		this.cjrq = cjrq;
	}
	
}
