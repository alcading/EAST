package resources.east.data.base;

import java.io.Serializable;

public class BaseEastXdywzhdywPK implements Serializable {
	// Fields

	/**
	* 
	*/
	private static final long serialVersionUID = -6586018064334972879L;
	private String zhdywbh;
	private String cjrq;

	// Constructors

	/** default constructor */
	public BaseEastXdywzhdywPK() {
	}

	public BaseEastXdywzhdywPK(String zhdywbh, String cjrq) {
		super();
		this.zhdywbh = zhdywbh;
		this.cjrq = cjrq;
	}

	

	public String getZhdywbh() {
		return zhdywbh;
	}

	public void setZhdywbh(String zhdywbh) {
		this.zhdywbh = zhdywbh;
	}

	public String getCjrq() {
		return cjrq;
	}

	public void setCjrq(String cjrq) {
		this.cjrq = cjrq;
	}

	
	
}
