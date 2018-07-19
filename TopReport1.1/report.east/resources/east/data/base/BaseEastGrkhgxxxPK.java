package resources.east.data.base;

import java.io.Serializable;

public class BaseEastGrkhgxxxPK implements Serializable {
	// Fields

	/**
	* 
	*/
	private static final long serialVersionUID = -6586018064334972879L;
	private String khtybh;
	private String dygrkhtybh;
	private String cjrq;

	// Constructors

	/** default constructor */
	public BaseEastGrkhgxxxPK() {
	}

	/** full constructor */
	public BaseEastGrkhgxxxPK(String khtybh, String dygrkhtybh, String cjrq) {
		this.khtybh = khtybh;
		this.dygrkhtybh = dygrkhtybh;
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

	public String getDygrkhtybh() {
		return dygrkhtybh;
	}

	public void setDygrkhtybh(String dygrkhtybh) {
		this.dygrkhtybh = dygrkhtybh;
	}

}
