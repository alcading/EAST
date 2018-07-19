package resources.east.data.base;

/**
 * AbstractEastGrxdfhzmxjlTmpId entity provides the base persistence definition
 * of the EastGrxdfhzmxjlTmpId entity. @author MyEclipse Persistence Tools
 */

public abstract class BaseEastGrxdfhzmxjlId implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 8039505415290666133L;
	private String hxjylsh;
	private String zjylsh;
	private Integer bcxh;
	private String dkfhzh;
	private String hxjyrq;
	private String xdjjh;
	private String cjrq;

	// Constructors

	/** default constructor */
	public BaseEastGrxdfhzmxjlId() {
	}

	/** full constructor */
	public BaseEastGrxdfhzmxjlId(String hxjylsh, String zjylsh, Integer bcxh, String dkfhzh, String hxjyrq, String cjrq,
			String xdjjh) {
		this.hxjylsh = hxjylsh;
		this.zjylsh = zjylsh;
		this.bcxh = bcxh;
		this.dkfhzh = dkfhzh;
		this.hxjyrq = hxjyrq;
		this.xdjjh = xdjjh;
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

	public String getDkfhzh() {
		return dkfhzh;
	}

	public void setDkfhzh(String dkfhzh) {
		this.dkfhzh = dkfhzh;
	}

	public String getXdjjh() {
		return xdjjh;
	}

	public void setXdjjh(String xdjjh) {
		this.xdjjh = xdjjh;
	}

}