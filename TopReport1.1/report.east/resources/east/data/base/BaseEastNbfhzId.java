package resources.east.data.base;

/**
 * AbstractEastNbfhzId entity provides the base persistence definition of the
 * EastNbfhzId entity. @author MyEclipse Persistence Tools
 */

public abstract class BaseEastNbfhzId implements java.io.Serializable {

	// Fields

	/**
	* 
	*/
	private static final long serialVersionUID = 6601150795827383809L;
	private String nbfhzzh;
	private String bz;
	private String cjrq;

	// Constructors

	/** default constructor */
	public BaseEastNbfhzId() {
	}

	/** full constructor */
	public BaseEastNbfhzId(String nbfhzzh, String bz, String cjrq) {
		this.nbfhzzh = nbfhzzh;
		this.bz = bz;
		this.cjrq = cjrq;
	}

	// Property accessors

	public String getNbfhzzh() {
		return this.nbfhzzh;
	}

	public void setNbfhzzh(String nbfhzzh) {
		this.nbfhzzh = nbfhzzh;
	}

	public String getBz() {
		return this.bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	public String getCjrq() {
		return this.cjrq;
	}

	public void setCjrq(String cjrq) {
		this.cjrq = cjrq;
	}

}