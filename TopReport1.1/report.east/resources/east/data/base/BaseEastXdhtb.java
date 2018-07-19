package resources.east.data.base;

import java.io.Serializable;
import java.math.BigDecimal;

import resources.east.data.pub.EastXdhtbPK;

public class BaseEastXdhtb implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7897173337433530607L;
	private EastXdhtbPK id;
	private String zhth;
	private String khtybh;
	private String yxjgdm;
	private String jrxkzh;
	private String nbjgh;
	private String khmc;
	private String cpmc;
	private String dkxgzl;
	private String xdywzl;
	private String bz;
	private BigDecimal je;
	private String htydrq;
	private String htdqrq;
	private String lllx;
	private BigDecimal jzll;
	private Integer llfd;
	private String zydbfs;
	private String ghjlgh;
	private Integer dkqx;
	private String fkfs;
	private String zjly;
	private String dkyt;
	private String dktxdq;
	private String dktxxy;
	private String sfgjxzxy;

	/** default constructor */
	public BaseEastXdhtb() {
	}

	public BaseEastXdhtb(EastXdhtbPK id) {
		this.setId(id);
	}

	public EastXdhtbPK getId() {
		return id;
	}

	public void setId(EastXdhtbPK id) {
		this.id = id;
	}

	public String getZhth() {
		return zhth;
	}

	public void setZhth(String zhth) {
		this.zhth = zhth;
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

	public String getKhmc() {
		return khmc;
	}

	public void setKhmc(String khmc) {
		this.khmc = khmc;
	}

	public String getCpmc() {
		return cpmc;
	}

	public void setCpmc(String cpmc) {
		this.cpmc = cpmc;
	}

	public String getDkxgzl() {
		return dkxgzl;
	}

	public void setDkxgzl(String dkxgzl) {
		this.dkxgzl = dkxgzl;
	}

	public String getXdywzl() {
		return xdywzl;
	}

	public void setXdywzl(String xdywzl) {
		this.xdywzl = xdywzl;
	}

	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	public BigDecimal getJe() {
		return je;
	}

	public void setJe(BigDecimal je) {
		this.je = je;
	}

	public String getHtydrq() {
		return htydrq;
	}

	public void setHtydrq(String htydrq) {
		this.htydrq = htydrq;
	}

	public String getHtdqrq() {
		return htdqrq;
	}

	public void setHtdqrq(String htdqrq) {
		this.htdqrq = htdqrq;
	}

	public String getLllx() {
		return lllx;
	}

	public void setLllx(String lllx) {
		this.lllx = lllx;
	}

	public BigDecimal getJzll() {
		return jzll;
	}

	public void setJzll(BigDecimal jzll) {
		this.jzll = jzll;
	}

	public Integer getLlfd() {
		return llfd;
	}

	public void setLlfd(Integer llfd) {
		this.llfd = llfd;
	}

	public String getZydbfs() {
		return zydbfs;
	}

	public void setZydbfs(String zydbfs) {
		this.zydbfs = zydbfs;
	}

	public String getGhjlgh() {
		return ghjlgh;
	}

	public void setGhjlgh(String ghjlgh) {
		this.ghjlgh = ghjlgh;
	}

	public Integer getDkqx() {
		return dkqx;
	}

	public void setDkqx(Integer dkqx) {
		this.dkqx = dkqx;
	}

	public String getFkfs() {
		return fkfs;
	}

	public void setFkfs(String fkfs) {
		this.fkfs = fkfs;
	}

	public String getZjly() {
		return zjly;
	}

	public void setZjly(String zjly) {
		this.zjly = zjly;
	}

	public String getDkyt() {
		return dkyt;
	}

	public void setDkyt(String dkyt) {
		this.dkyt = dkyt;
	}

	public String getDktxdq() {
		return dktxdq;
	}

	public void setDktxdq(String dktxdq) {
		this.dktxdq = dktxdq;
	}

	public String getDktxxy() {
		return dktxxy;
	}

	public void setDktxxy(String dktxxy) {
		this.dktxxy = dktxxy;
	}

	public String getSfgjxzxy() {
		return sfgjxzxy;
	}

	public void setSfgjxzxy(String sfgjxzxy) {
		this.sfgjxzxy = sfgjxzxy;
	}

}
