package resources.east.data.base;

/**
 * AbstractEastDbgxId entity provides the base persistence definition of the
 * EastDbgxId entity. @author MyEclipse Persistence Tools
 */

public class BaseEastDbgxId implements java.io.Serializable {

	// Fields

	private String dbhth;
	private String bdbhth;
	private String cjrq;

	// Constructors

	/** default constructor */
	public BaseEastDbgxId() {
	}

	/** full constructor */
	public BaseEastDbgxId(String dbhth, String bdbhth, String cjrq) {
		this.dbhth = dbhth;
		this.bdbhth = bdbhth;
		this.cjrq = cjrq;
	}

	// Property accessors

	public String getDbhth() {
		return this.dbhth;
	}

	public void setDbhth(String dbhth) {
		this.dbhth = dbhth;
	}

	public String getBdbhth() {
		return this.bdbhth;
	}

	public void setBdbhth(String bdbhth) {
		this.bdbhth = bdbhth;
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
		if (!(other instanceof BaseEastDbgxId))
			return false;
		BaseEastDbgxId castOther = (BaseEastDbgxId) other;

		return ((this.getDbhth() == castOther.getDbhth()) || (this.getDbhth() != null && castOther.getDbhth() != null
				&& this.getDbhth().equals(castOther.getDbhth())))
				&& ((this.getBdbhth() == castOther.getBdbhth()) || (this.getBdbhth() != null
						&& castOther.getBdbhth() != null && this.getBdbhth().equals(castOther.getBdbhth())))
				&& ((this.getCjrq() == castOther.getCjrq()) || (this.getCjrq() != null && castOther.getCjrq() != null
						&& this.getCjrq().equals(castOther.getCjrq())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getDbhth() == null ? 0 : this.getDbhth().hashCode());
		result = 37 * result + (getBdbhth() == null ? 0 : this.getBdbhth().hashCode());
		result = 37 * result + (getCjrq() == null ? 0 : this.getCjrq().hashCode());
		return result;
	}

}