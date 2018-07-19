package resources.east.data.base;

/**
 * AbstractEastNbfhzmxjlTmpId entity provides the base persistence definition of
 * the EastNbfhzmxjlTmpId entity. @author MyEclipse Persistence Tools
 */

public abstract class BaseEastNbfhzmxjlId implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 8039505415290666133L;
	private String hxjylsh;
	private String zjylsh;
	private Integer bcxh;
	private String nbfhzzh;
	private String hxjyrq;
	private String cjrq;

	// Constructors

	/** default constructor */
	public BaseEastNbfhzmxjlId() {
	}

	/** full constructor */
	public BaseEastNbfhzmxjlId(String hxjylsh, String zjylsh, Integer bcxh, String nbfhzzh, String hxjyrq,
			String cjrq) {
		this.hxjylsh = hxjylsh;
		this.zjylsh = zjylsh;
		this.bcxh = bcxh;
		this.nbfhzzh = nbfhzzh;
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

	public String getNbfhzzh() {
		return nbfhzzh;
	}

	public void setNbfhzzh(String nbfhzzh) {
		this.nbfhzzh = nbfhzzh;
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