package resources.east.data.base;



/**
 * AbstractEastDghqckfhzmxjlId entity provides the base persistence definition
 * of the EastDghqckfhzmxjlId entity. @author MyEclipse Persistence Tools
 */

public abstract class BaseEastDghqckfhzmxjlId implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 6687766318270877133L;
	private String hxjylsh;
	private String zjylsh;
	private Integer bcxh;
	private String hqckzh;
	private String hxjyrq;
	private String cjrq;

	// Constructors

	/** default constructor */
	public BaseEastDghqckfhzmxjlId() {
	}

	/** full constructor */
	public BaseEastDghqckfhzmxjlId(String hxjylsh, String zjylsh, Integer bcxh, String hqckzh, String hxjyrq,
			String cjrq) {
		this.hxjylsh = hxjylsh;
		this.zjylsh = zjylsh;
		this.setBcxh(bcxh);
		this.hqckzh = hqckzh;
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



	public String getHqckzh() {
		return this.hqckzh;
	}

	public void setHqckzh(String hqckzh) {
		this.hqckzh = hqckzh;
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

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof BaseEastDghqckfhzmxjlId))
			return false;
		BaseEastDghqckfhzmxjlId castOther = (BaseEastDghqckfhzmxjlId) other;

		return ((this.getHxjylsh() == castOther.getHxjylsh()) || (this.getHxjylsh() != null
				&& castOther.getHxjylsh() != null && this.getHxjylsh().equals(castOther.getHxjylsh())))
				&& ((this.getZjylsh() == castOther.getZjylsh()) || (this.getZjylsh() != null
						&& castOther.getZjylsh() != null && this.getZjylsh().equals(castOther.getZjylsh())))
				&& ((this.getBcxh() == castOther.getBcxh()) || (this.getBcxh() != null && castOther.getBcxh() != null
						&& this.getBcxh().equals(castOther.getBcxh())))
				&& ((this.getHqckzh() == castOther.getHqckzh()) || (this.getHqckzh() != null
						&& castOther.getHqckzh() != null && this.getHqckzh().equals(castOther.getHqckzh())))
				&& ((this.getHxjyrq() == castOther.getHxjyrq()) || (this.getHxjyrq() != null
						&& castOther.getHxjyrq() != null && this.getHxjyrq().equals(castOther.getHxjyrq())))
				&& ((this.getCjrq() == castOther.getCjrq()) || (this.getCjrq() != null && castOther.getCjrq() != null
						&& this.getCjrq().equals(castOther.getCjrq())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getHxjylsh() == null ? 0 : this.getHxjylsh().hashCode());
		result = 37 * result + (getZjylsh() == null ? 0 : this.getZjylsh().hashCode());
		result = 37 * result + (getBcxh() == null ? 0 : this.getBcxh().hashCode());
		result = 37 * result + (getHqckzh() == null ? 0 : this.getHqckzh().hashCode());
		result = 37 * result + (getHxjyrq() == null ? 0 : this.getHxjyrq().hashCode());
		result = 37 * result + (getCjrq() == null ? 0 : this.getCjrq().hashCode());
		return result;
	}

	public Integer getBcxh() {
		return bcxh;
	}

	public void setBcxh(Integer bcxh) {
		this.bcxh = bcxh;
	}

}