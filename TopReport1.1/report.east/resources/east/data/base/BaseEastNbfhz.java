package resources.east.data.base;

import java.math.BigDecimal;

import resources.east.data.pub.EastNbfhzId;

/**
 * AbstractEastNbfhz entity provides the base persistence definition of the
 * EastNbfhz entity. @author MyEclipse Persistence Tools
 */

public abstract class BaseEastNbfhz implements java.io.Serializable {

	// Fields

	/**
	* 
	*/
	private static final long serialVersionUID = -5952256342399577010L;

	private EastNbfhzId id;
	private String yxjgdm;
	private String jrxkzh;
	private String nbjgh;
	private String mxkmbh;
	private String yxjgmc;
	private String mxkmmc;
	private String tjkmbh;
	private String zhmc;
	private String nbfhzzhlx;
	private String jdbz;
	private BigDecimal ll;
	private BigDecimal jfye;
	private BigDecimal dfye;
	private String jxbz;
	private String jxfs;
	private String khrq;
	private String xhrq;
	private String zhzt;

	// Constructors

	/** default constructor */
	public BaseEastNbfhz() {
	}

	/** minimal constructor */
	public BaseEastNbfhz(EastNbfhzId id) {
		this.id = id;
	}

	public EastNbfhzId getId() {
		return this.id;
	}

	public void setId(EastNbfhzId id) {
		this.id = id;
	}

	public String getYxjgdm() {
		return yxjgdm;
	}

	public void setYxjgdm(String yxjgdm) {
		this.yxjgdm = yxjgdm;
	}

	public String getJrxkzh() {
		return jrxkzh;
	}

	public void setJrxkzh(String jrxkzh) {
		this.jrxkzh = jrxkzh;
	}

	public String getNbjgh() {
		return nbjgh;
	}

	public void setNbjgh(String nbjgh) {
		this.nbjgh = nbjgh;
	}

	public String getMxkmbh() {
		return mxkmbh;
	}

	public void setMxkmbh(String mxkmbh) {
		this.mxkmbh = mxkmbh;
	}

	public String getYxjgmc() {
		return yxjgmc;
	}

	public void setYxjgmc(String yxjgmc) {
		this.yxjgmc = yxjgmc;
	}

	public String getMxkmmc() {
		return mxkmmc;
	}

	public void setMxkmmc(String mxkmmc) {
		this.mxkmmc = mxkmmc;
	}

	public String getTjkmbh() {
		return tjkmbh;
	}

	public void setTjkmbh(String tjkmbh) {
		this.tjkmbh = tjkmbh;
	}

	public String getZhmc() {
		return zhmc;
	}

	public void setZhmc(String zhmc) {
		this.zhmc = zhmc;
	}

	public String getNbfhzzhlx() {
		return nbfhzzhlx;
	}

	public void setNbfhzzhlx(String nbfhzzhlx) {
		this.nbfhzzhlx = nbfhzzhlx;
	}

	public String getJdbz() {
		return jdbz;
	}

	public void setJdbz(String jdbz) {
		this.jdbz = jdbz;
	}

	public BigDecimal getLl() {
		return ll;
	}

	public void setLl(BigDecimal ll) {
		this.ll = ll;
	}

	public BigDecimal getJfye() {
		return jfye;
	}

	public void setJfye(BigDecimal jfye) {
		this.jfye = jfye;
	}

	public BigDecimal getDfye() {
		return dfye;
	}

	public void setDfye(BigDecimal dfye) {
		this.dfye = dfye;
	}

	public String getJxbz() {
		return jxbz;
	}

	public void setJxbz(String jxbz) {
		this.jxbz = jxbz;
	}

	public String getJxfs() {
		return jxfs;
	}

	public void setJxfs(String jxfs) {
		this.jxfs = jxfs;
	}

	public String getKhrq() {
		return khrq;
	}

	public void setKhrq(String khrq) {
		this.khrq = khrq;
	}

	public String getXhrq() {
		return xhrq;
	}

	public void setXhrq(String xhrq) {
		this.xhrq = xhrq;
	}

	public String getZhzt() {
		return zhzt;
	}

	public void setZhzt(String zhzt) {
		this.zhzt = zhzt;
	}

}