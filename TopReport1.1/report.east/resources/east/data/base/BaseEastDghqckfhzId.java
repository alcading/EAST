package resources.east.data.base;

/**
 * AbstractEastDghqckfhzId entity provides the base persistence definition of
 * the EastDghqckfhzId entity. @author MyEclipse Persistence Tools
 */

public abstract class BaseEastDghqckfhzId implements java.io.Serializable {

	// Fields

	/**
	* 
	*/
	private static final long serialVersionUID = 6601150795827383809L;
	private String hqckzh;
	private String bz;
	private String chlb;
	private String cjrq;

	// Constructors

	/** default constructor */
	public BaseEastDghqckfhzId() {
	}

	/** full constructor */
	public BaseEastDghqckfhzId(String hqckzh, String bz, String chlb, String cjrq) {
		this.hqckzh = hqckzh;
		this.bz = bz;
		this.chlb = chlb;
		this.cjrq = cjrq;
	}

	// Property accessors

	public String getHqckzh() {
		return this.hqckzh;
	}

	public void setHqckzh(String hqckzh) {
		this.hqckzh = hqckzh;
	}

	public String getBz() {
		return this.bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	public String getChlb() {
		return this.chlb;
	}

	public void setChlb(String chlb) {
		this.chlb = chlb;
	}

	public String getCjrq() {
		return this.cjrq;
	}

	public void setCjrq(String cjrq) {
		this.cjrq = cjrq;
	}

}