package resources.east.data.base;

import java.io.Serializable;

public class BaseEastXykzhjymxbPK implements Serializable {
	// Fields

	/**
	* 
	*/
	private static final long serialVersionUID = -6586018064334972879L;
	private String jyjzrq;
	private String hxjylsh;
	private String zjylsh;
	private Integer bcxh;
	private String cjrq;

	// Constructors
	/** default constructor */
	public BaseEastXykzhjymxbPK() {
	}

	public BaseEastXykzhjymxbPK(String jyjzrq, String hxjylsh, String zjylsh, Integer bcxh, String cjrq) {
		super();
		this.jyjzrq = jyjzrq;
		this.hxjylsh = hxjylsh;
		this.zjylsh = zjylsh;
		this.bcxh = bcxh;
		this.cjrq = cjrq;
	}

	public String getJyjzrq() {
		return jyjzrq;
	}

	public void setJyjzrq(String jyjzrq) {
		this.jyjzrq = jyjzrq;
	}

	public String getHxjylsh() {
		return hxjylsh;
	}

	public void setHxjylsh(String hxjylsh) {
		this.hxjylsh = hxjylsh;
	}

	public String getZjylsh() {
		return zjylsh;
	}

	public void setZjylsh(String zjylsh) {
		this.zjylsh = zjylsh;
	}

	public Integer getBcxh() {
		return bcxh;
	}

	public void setBcxh(Integer bcxh) {
		this.bcxh = bcxh;
	}

	public String getCjrq() {
		return cjrq;
	}

	public void setCjrq(String cjrq) {
		this.cjrq = cjrq;
	}
	
	
}
