package resources.east.data.base;

import java.math.BigDecimal;

import resources.east.data.pub.EastDghqckfhzId;

/**
 * AbstractEastDghqckfhz entity provides the base persistence definition of the
 * EastDghqckfhz entity. @author MyEclipse Persistence Tools
 */

public abstract class BaseEastDghqckfhz implements java.io.Serializable {

	// Fields

	/**
	* 
	*/
	private static final long serialVersionUID = -5952256342399577010L;

	private EastDghqckfhzId id;
	private String khtybh;
	private String yxjgdm;
	private String jrxkzh;
	private String nbjgh;
	private String mxkmbh;
	private String yxjgmc;
	private String mxkmmc;
	private String tjkmbh;
	private String zhmc;
	private String dghqckzhlx;
	private String bzjzhbz;
	private BigDecimal ll;
	private BigDecimal ckye;
	private String khrq;
	private String khgyh;
	private String xhrq;
	private String zhzt;
	private String scdhrq;

	// Constructors

	/** default constructor */
	public BaseEastDghqckfhz() {
	}

	/** minimal constructor */
	public BaseEastDghqckfhz(EastDghqckfhzId id) {
		this.id = id;
	}

	// Property accessors

	public EastDghqckfhzId getId() {
		return this.id;
	}

	public void setId(EastDghqckfhzId id) {
		this.id = id;
	}

	public String getKhtybh() {
		return this.khtybh;
	}

	public void setKhtybh(String khtybh) {
		this.khtybh = khtybh;
	}

	public String getYxjgdm() {
		return this.yxjgdm;
	}

	public void setYxjgdm(String yxjgdm) {
		this.yxjgdm = yxjgdm;
	}

	public String getJrxkzh() {
		return this.jrxkzh;
	}

	public void setJrxkzh(String jrxkzh) {
		this.jrxkzh = jrxkzh;
	}

	public String getNbjgh() {
		return this.nbjgh;
	}

	public void setNbjgh(String nbjgh) {
		this.nbjgh = nbjgh;
	}

	public String getMxkmbh() {
		return this.mxkmbh;
	}

	public void setMxkmbh(String mxkmbh) {
		this.mxkmbh = mxkmbh;
	}

	public String getYxjgmc() {
		return this.yxjgmc;
	}

	public void setYxjgmc(String yxjgmc) {
		this.yxjgmc = yxjgmc;
	}

	public String getMxkmmc() {
		return this.mxkmmc;
	}

	public void setMxkmmc(String mxkmmc) {
		this.mxkmmc = mxkmmc;
	}

	public String getTjkmbh() {
		return this.tjkmbh;
	}

	public void setTjkmbh(String tjkmbh) {
		this.tjkmbh = tjkmbh;
	}

	public String getZhmc() {
		return this.zhmc;
	}

	public void setZhmc(String zhmc) {
		this.zhmc = zhmc;
	}

	public String getDghqckzhlx() {
		return this.dghqckzhlx;
	}

	public void setDghqckzhlx(String dghqckzhlx) {
		this.dghqckzhlx = dghqckzhlx;
	}

	public String getBzjzhbz() {
		return this.bzjzhbz;
	}

	public void setBzjzhbz(String bzjzhbz) {
		this.bzjzhbz = bzjzhbz;
	}

	public BigDecimal getLl() {
		return this.ll;
	}

	public void setLl(BigDecimal ll) {
		this.ll = ll;
	}

	public BigDecimal getCkye() {
		return this.ckye;
	}

	public void setCkye(BigDecimal ckye) {
		this.ckye = ckye;
	}

	public String getKhrq() {
		return this.khrq;
	}

	public void setKhrq(String khrq) {
		this.khrq = khrq;
	}

	public String getKhgyh() {
		return this.khgyh;
	}

	public void setKhgyh(String khgyh) {
		this.khgyh = khgyh;
	}

	public String getXhrq() {
		return this.xhrq;
	}

	public void setXhrq(String xhrq) {
		this.xhrq = xhrq;
	}

	public String getZhzt() {
		return this.zhzt;
	}

	public void setZhzt(String zhzt) {
		this.zhzt = zhzt;
	}

	public String getScdhrq() {
		return this.scdhrq;
	}

	public void setScdhrq(String scdhrq) {
		this.scdhrq = scdhrq;
	}

}