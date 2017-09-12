package resources.east.data.base;

import java.math.BigDecimal;

import resources.east.data.pub.EastDghqckfhzmxjlId;

/**
 * AbstractEastDghqckfhzmxjl entity provides the base persistence definition of
 * the EastDghqckfhzmxjl entity. @author MyEclipse Persistence Tools
 */

public abstract class BaseEastDghqckfhzmxjlTmp implements java.io.Serializable {

	// Fields

	private EastDghqckfhzmxjlId id;
	private String khtybh;
	private String yxjgdm;
	private String jrxkzh;
	private String nbjgh;
	private String mxkmbh;
	private String yxjgmc;
	private String mxkmmc;
	private String hxjysj;
	private String zhmc;
	private String jylx;
	private BigDecimal jyje;
	private String khhjgh;
	private String ywbljgh;
	private BigDecimal zhye;
	private String dfzh;
	private String dfhm;
	private String dfxh;
	private String dfxm;
	private String jyqd;
	private String bz;
	private String xzbz;
	private String dbrxm;
	private String dbrzjlb;
	private String dbrzjhm;
	private String jygyh;
	private String gylsh;
	private String sqgyh;
	private String zy;
	private String cbmbz;
	private String jyjdbz;
	private String errmsg;

	// Constructors

	/** default constructor */
	public BaseEastDghqckfhzmxjlTmp() {
	}

	/** minimal constructor */
	public BaseEastDghqckfhzmxjlTmp(EastDghqckfhzmxjlId id) {
		this.id = id;
	}

	/** full constructor */
	public BaseEastDghqckfhzmxjlTmp(EastDghqckfhzmxjlId id, String khtybh, String yxjgdm, String jrxkzh, String nbjgh,
			String mxkmbh, String yxjgmc, String mxkmmc, String hxjysj, String zhmc, String jylx, BigDecimal jyje,
			String khhjgh, String ywbljgh, BigDecimal zhye, String dfzh, String dfhm, String dfxh, String dfxm, String jyqd,
			String bz, String xzbz, String dbrxm, String dbrzjlb, String dbrzjhm, String jygyh, String gylsh,
			String sqgyh, String zy, String cbmbz, String jyjdbz,String errmsg) {
		this.id = id;
		this.khtybh = khtybh;
		this.yxjgdm = yxjgdm;
		this.jrxkzh = jrxkzh;
		this.nbjgh = nbjgh;
		this.mxkmbh = mxkmbh;
		this.yxjgmc = yxjgmc;
		this.mxkmmc = mxkmmc;
		this.hxjysj = hxjysj;
		this.zhmc = zhmc;
		this.jylx = jylx;
		this.setJyje(jyje);
		this.khhjgh = khhjgh;
		this.ywbljgh = ywbljgh;
		this.setZhye(zhye);
		this.dfzh = dfzh;
		this.dfhm = dfhm;
		this.dfxh = dfxh;
		this.dfxm = dfxm;
		this.jyqd = jyqd;
		this.bz = bz;
		this.xzbz = xzbz;
		this.dbrxm = dbrxm;
		this.dbrzjlb = dbrzjlb;
		this.dbrzjhm = dbrzjhm;
		this.jygyh = jygyh;
		this.gylsh = gylsh;
		this.sqgyh = sqgyh;
		this.zy = zy;
		this.cbmbz = cbmbz;
		this.jyjdbz = jyjdbz;
		this.errmsg= errmsg;
	}

	// Property accessors

	public EastDghqckfhzmxjlId getId() {
		return this.id;
	}

	public void setId(EastDghqckfhzmxjlId id) {
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

	public String getHxjysj() {
		return this.hxjysj;
	}

	public void setHxjysj(String hxjysj) {
		this.hxjysj = hxjysj;
	}

	public String getZhmc() {
		return this.zhmc;
	}

	public void setZhmc(String zhmc) {
		this.zhmc = zhmc;
	}

	public String getJylx() {
		return this.jylx;
	}

	public void setJylx(String jylx) {
		this.jylx = jylx;
	}

	public String getKhhjgh() {
		return this.khhjgh;
	}

	public void setKhhjgh(String khhjgh) {
		this.khhjgh = khhjgh;
	}

	public String getYwbljgh() {
		return this.ywbljgh;
	}

	public void setYwbljgh(String ywbljgh) {
		this.ywbljgh = ywbljgh;
	}



	public String getDfzh() {
		return this.dfzh;
	}

	public void setDfzh(String dfzh) {
		this.dfzh = dfzh;
	}

	public String getDfhm() {
		return this.dfhm;
	}

	public void setDfhm(String dfhm) {
		this.dfhm = dfhm;
	}

	public String getDfxh() {
		return this.dfxh;
	}

	public void setDfxh(String dfxh) {
		this.dfxh = dfxh;
	}

	public String getDfxm() {
		return this.dfxm;
	}

	public void setDfxm(String dfxm) {
		this.dfxm = dfxm;
	}

	public String getJyqd() {
		return this.jyqd;
	}

	public void setJyqd(String jyqd) {
		this.jyqd = jyqd;
	}

	public String getBz() {
		return this.bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	public String getXzbz() {
		return this.xzbz;
	}

	public void setXzbz(String xzbz) {
		this.xzbz = xzbz;
	}

	public String getDbrxm() {
		return this.dbrxm;
	}

	public void setDbrxm(String dbrxm) {
		this.dbrxm = dbrxm;
	}

	public String getDbrzjlb() {
		return this.dbrzjlb;
	}

	public void setDbrzjlb(String dbrzjlb) {
		this.dbrzjlb = dbrzjlb;
	}

	public String getDbrzjhm() {
		return this.dbrzjhm;
	}

	public void setDbrzjhm(String dbrzjhm) {
		this.dbrzjhm = dbrzjhm;
	}

	public String getJygyh() {
		return this.jygyh;
	}

	public void setJygyh(String jygyh) {
		this.jygyh = jygyh;
	}

	public String getGylsh() {
		return this.gylsh;
	}

	public void setGylsh(String gylsh) {
		this.gylsh = gylsh;
	}

	public String getSqgyh() {
		return this.sqgyh;
	}

	public void setSqgyh(String sqgyh) {
		this.sqgyh = sqgyh;
	}

	public String getZy() {
		return this.zy;
	}

	public void setZy(String zy) {
		this.zy = zy;
	}

	public String getCbmbz() {
		return this.cbmbz;
	}

	public void setCbmbz(String cbmbz) {
		this.cbmbz = cbmbz;
	}

	public String getJyjdbz() {
		return this.jyjdbz;
	}

	public void setJyjdbz(String jyjdbz) {
		this.jyjdbz = jyjdbz;
	}

	public BigDecimal getJyje() {
		return jyje;
	}

	public void setJyje(BigDecimal jyje) {
		this.jyje = jyje;
	}

	public BigDecimal getZhye() {
		return zhye;
	}

	public void setZhye(BigDecimal zhye) {
		this.zhye = zhye;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

}