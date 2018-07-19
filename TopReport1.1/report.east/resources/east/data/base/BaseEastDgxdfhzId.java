package resources.east.data.base;

/**
 * AbstractEastGrdqckfhzId entity provides the base persistence definition of
 * the EastGrdqckfhzId entity. @author MyEclipse Persistence Tools
 */

public abstract class BaseEastDgxdfhzId implements java.io.Serializable {

	// Fields

	/**
	* 
	*/
	private static final long serialVersionUID = 6601150795827383809L;
	private String dkfhzh;
	private String bz;
	private String xdjjh;
	private String cjrq;

	// Constructors

	/** default constructor */
	public BaseEastDgxdfhzId() {
	}

	/** full constructor */
	public BaseEastDgxdfhzId(String dkfhzh, String bz, String xdjjh, String cjrq) {
		this.dkfhzh = dkfhzh;
		this.bz = bz;
		this.xdjjh = xdjjh;
		this.cjrq = cjrq;
	}

	public String getDkfhzh() {
		return dkfhzh;
	}

	public void setDkfhzh(String dkfhzh) {
		this.dkfhzh = dkfhzh;
	}

	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	public String getXdjjh() {
		return xdjjh;
	}

	public void setXdjjh(String xdjjh) {
		this.xdjjh = xdjjh;
	}

	public String getCjrq() {
		return cjrq;
	}

	public void setCjrq(String cjrq) {
		this.cjrq = cjrq;
	}

}