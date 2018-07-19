package resources.east.data.base;

/**
 * AbstractEastDgdqckfhzmxjlTmpId entity provides the base persistence
 * definition of the EastDgdqckfhzmxjlTmpId entity. @author MyEclipse
 * Persistence Tools
 */

public abstract class BaseEastDgdqckfhzmxjlId implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 8039505415290666133L;
	private String hxjylsh;
	private String zjylsh;
	private Integer bcxh;
	private String dqckzh;
	private String hxjyrq;
	private String cjrq;

	// Constructors

	/** default constructor */
	public BaseEastDgdqckfhzmxjlId() {
	}

	/** full constructor */
	public BaseEastDgdqckfhzmxjlId(String hxjylsh, String zjylsh, Integer bcxh, String dqckzh, String hxjyrq,
			String cjrq) {
		this.hxjylsh = hxjylsh;
		this.zjylsh = zjylsh;
		this.bcxh = bcxh;
		this.dqckzh = dqckzh;
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

	public String getDqckzh() {
		return this.dqckzh;
	}

	public void setDqckzh(String hqckzh) {
		this.dqckzh = hqckzh;
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

}