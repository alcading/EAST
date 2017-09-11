package resources.east.data.base;

/**
 * AbstractEastCzxxTmpId entity provides the base persistence definition of the
 * EastCzxxTmpId entity. @author MyEclipse Persistence Tools
 */

public abstract class BaseEastCzxxTmpId implements java.io.Serializable {

	// Fields

	private String czh;
	private String cjrq;

	// Constructors

	/** default constructor */
	public BaseEastCzxxTmpId() {
	}

	/** full constructor */
	public BaseEastCzxxTmpId(String czh, String cjrq) {
		this.czh = czh;
		this.cjrq = cjrq;
	}

	// Property accessors

	public String getCzh() {
		return this.czh;
	}

	public void setCzh(String czh) {
		this.czh = czh;
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
		if (!(other instanceof BaseEastCzxxTmpId))
			return false;
		BaseEastCzxxTmpId castOther = (BaseEastCzxxTmpId) other;

		return ((this.getCzh() == castOther.getCzh())
				|| (this.getCzh() != null && castOther.getCzh() != null && this.getCzh().equals(castOther.getCzh())))
				&& ((this.getCjrq() == castOther.getCjrq()) || (this.getCjrq() != null && castOther.getCjrq() != null
						&& this.getCjrq().equals(castOther.getCjrq())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getCzh() == null ? 0 : this.getCzh().hashCode());
		result = 37 * result + (getCjrq() == null ? 0 : this.getCjrq().hashCode());
		return result;
	}
	

	

}