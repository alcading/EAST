package resources.east.data.base;

import java.math.BigDecimal;

import resources.east.data.pub.EastGrxdfhzId;

/**
 * AbstractEastGrxdfhz entity provides the base persistence definition of the
 * EastGrxdfhz entity. @author MyEclipse Persistence Tools
 */

public abstract class BaseEastGrxdfhz implements java.io.Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = -5952256342399577010L;

	private EastGrxdfhzId id;
	private String khtybh;
	private String yxjgdm;
	private String jrxkzh;
	private String nbjgh;
	private String mxkmbh;
	private String yxjgmc;
	private String mxkmmc;
	private String tjkmbh;
	private String zhmc;
	private String zjhkrq;
	private String dkhth;
	private String xdyxm;
	private String dkwjfl;
	private String hkzh;
	private String dkrzzh;
	private BigDecimal dkll;
	private BigDecimal dkbjze;
	private BigDecimal dkzcye;
	private BigDecimal dkyqye;
	private BigDecimal qbye;
	private BigDecimal bwqxye;
	private int dkqx;
	private String dqrq;
	private String qxrq;
	private String khrq;
	private String xhrq;
	private String yqrq;
	private String zhzt;

	// Constructors

	/** default constructor */
	public BaseEastGrxdfhz() {
	}

	/** minimal constructor */
	public BaseEastGrxdfhz(EastGrxdfhzId id) {
		this.id = id;
	}

	public EastGrxdfhzId getId() {
		return id;
	}

	public void setId(EastGrxdfhzId id) {
		this.id = id;
	}

	public String getKhtybh() {
		return khtybh;
	}

	public void setKhtybh(String khtybh) {
		this.khtybh = khtybh;
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

	public String getZjhkrq() {
		return zjhkrq;
	}

	public void setZjhkrq(String zjhkrq) {
		this.zjhkrq = zjhkrq;
	}

	public String getDkhth() {
		return dkhth;
	}

	public void setDkhth(String dkhth) {
		this.dkhth = dkhth;
	}

	public String getXdyxm() {
		return xdyxm;
	}

	public void setXdyxm(String xdyxm) {
		this.xdyxm = xdyxm;
	}

	public String getDkwjfl() {
		return dkwjfl;
	}

	public void setDkwjfl(String dkwjfl) {
		this.dkwjfl = dkwjfl;
	}

	public String getHkzh() {
		return hkzh;
	}

	public void setHkzh(String hkzh) {
		this.hkzh = hkzh;
	}

	public String getDkrzzh() {
		return dkrzzh;
	}

	public void setDkrzzh(String dkrzzh) {
		this.dkrzzh = dkrzzh;
	}

	public BigDecimal getDkll() {
		return dkll;
	}

	public void setDkll(BigDecimal dkll) {
		this.dkll = dkll;
	}

	public BigDecimal getDkbjze() {
		return dkbjze;
	}

	public void setDkbjze(BigDecimal dkbjze) {
		this.dkbjze = dkbjze;
	}

	public BigDecimal getDkzcye() {
		return dkzcye;
	}

	public void setDkzcye(BigDecimal dkzcye) {
		this.dkzcye = dkzcye;
	}

	public BigDecimal getDkyqye() {
		return dkyqye;
	}

	public void setDkyqye(BigDecimal dkyqye) {
		this.dkyqye = dkyqye;
	}

	public BigDecimal getQbye() {
		return qbye;
	}

	public void setQbye(BigDecimal qbye) {
		this.qbye = qbye;
	}

	public BigDecimal getBwqxye() {
		return bwqxye;
	}

	public void setBwqxye(BigDecimal bwqxye) {
		this.bwqxye = bwqxye;
	}

	public int getDkqx() {
		return dkqx;
	}

	public void setDkqx(int dkqx) {
		this.dkqx = dkqx;
	}

	public String getDqrq() {
		return dqrq;
	}

	public void setDqrq(String dqrq) {
		this.dqrq = dqrq;
	}

	public String getQxrq() {
		return qxrq;
	}

	public void setQxrq(String qxrq) {
		this.qxrq = qxrq;
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

	public String getYqrq() {
		return yqrq;
	}

	public void setYqrq(String yqrq) {
		this.yqrq = yqrq;
	}

	public String getZhzt() {
		return zhzt;
	}

	public void setZhzt(String zhzt) {
		this.zhzt = zhzt;
	}

}