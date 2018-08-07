package resources.east.data.base;

import java.io.Serializable;

public class BaseEastXdywdbhtPK implements Serializable {
	// Fields

	/**
	* 
	*/
	private static final long serialVersionUID = -6586018064334972879L;
	private String dbhth;
	private String zjhm;
	private String cjrq;

	// Constructors

	/** default constructor */
	public BaseEastXdywdbhtPK() {
	}

	public BaseEastXdywdbhtPK(String dbhth, String zjhm, String cjrq) {
		super();
		this.dbhth = dbhth;
		this.zjhm = zjhm;
		this.cjrq = cjrq;
	}

	public String getDbhth() {
		return dbhth;
	}

	public void setDbhth(String dbhth) {
		this.dbhth = dbhth;
	}

	public String getZjhm() {
		return zjhm;
	}

	public void setZjhm(String zjhm) {
		this.zjhm = zjhm;
	}

	public String getCjrq() {
		return cjrq;
	}

	public void setCjrq(String cjrq) {
		this.cjrq = cjrq;
	}

	
}
