package resources.east.data.base;

/**
 * AbstractEastDgxdfhzmxjlTmpId entity provides the base persistence definition
 * of the EastDgxdfhzmxjlTmpId entity. @author MyEclipse Persistence Tools
 */

public abstract class BaseEastDgxdfhzmxjlId implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 8039505415290666133L;
	private String hxjylsh;
	private String zjylsh;
	private Integer bcxh;
	private String dkzh;
	private String hxjyrq;
	private String cjrq;

	// Constructors

	/** default constructor */
	public BaseEastDgxdfhzmxjlId() {
	}

	/** full constructor */
	public BaseEastDgxdfhzmxjlId(String hxjylsh, String zjylsh, Integer bcxh, String dkzh, String hxjyrq, String cjrq) {
		this.hxjylsh = hxjylsh;
		this.zjylsh = zjylsh;
		this.bcxh = bcxh;
		this.dkzh = dkzh;
		this.hxjyrq = hxjyrq;
		this.cjrq = cjrq;
	}

	// Property accessors

	public String getHxjylsh() {
		return this.hxjylsh;
	}

	public void setHxjylsh(String hxjylsh) {
		this.hxjylsh = hxjylsh;
	}

	public String getZjylsh() {
		return this.zjylsh;
	}

	public void setZjylsh(String zjylsh) {
		this.zjylsh = zjylsh;
	}

	public Integer getBcxh() {
		return this.bcxh;
	}

	public void setBcxh(Integer bcxh) {
		this.bcxh = bcxh;
	}

	public String getHxjyrq() {
		return this.hxjyrq;
	}

	public void setHxjyrq(String hxjyrq) {
		this.hxjyrq = hxjyrq;
	}

	public String getCjrq() {
		return this.cjrq;
	}

	public void setCjrq(String cjrq) {
		this.cjrq = cjrq;
	}

	public String getDkzh() {
		return dkzh;
	}

	public void setDkzh(String dkzh) {
		this.dkzh = dkzh;
	}

}