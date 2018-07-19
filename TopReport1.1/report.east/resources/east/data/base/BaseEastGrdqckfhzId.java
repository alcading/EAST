package resources.east.data.base;

/**
 * AbstractEastGrdqckfhzId entity provides the base persistence definition of
 * the EastGrdqckfhzId entity. @author MyEclipse Persistence Tools
 */

public abstract class BaseEastGrdqckfhzId implements java.io.Serializable {

	// Fields

	/**
	* 
	*/
	private static final long serialVersionUID = 6601150795827383809L;
	private String dqckzh;
	private String bz;
	private String jyjzh;
	private String chlb;
	private String cjrq;

	// Constructors

	/** default constructor */
	public BaseEastGrdqckfhzId() {
	}

	/** full constructor */
	public BaseEastGrdqckfhzId(String dqckzh, String bz, String jyjzh, String chlb, String cjrq) {
		this.dqckzh = dqckzh;
		this.bz = bz;
		this.jyjzh = jyjzh;
		this.chlb = chlb;
		this.cjrq = cjrq;
	}

	// Property accessors

	public String getDqckzh() {
		return this.dqckzh;
	}

	public void setDqckzh(String dqckzh) {
		this.dqckzh = dqckzh;
	}

	public String getBz() {
		return this.bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	public String getJyjzh() {
		return this.jyjzh;
	}

	public void setJyjzh(String jyjzh) {
		this.jyjzh = jyjzh;
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