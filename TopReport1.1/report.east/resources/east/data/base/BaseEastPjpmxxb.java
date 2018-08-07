package resources.east.data.base;

import java.io.Serializable;
import java.math.BigDecimal;

import resources.east.data.pub.EastPjpmxxbPK;

public class BaseEastPjpmxxb implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7897173337433530607L;
	private EastPjpmxxbPK id;
	private String cprbh;
	private String fkxdm;
	private String yxjgdm;
	private String jrxkzh;
	private String nbjgh;
	private String pjlx;
	private String cprqc;
	private String cprzh;
	private String fkxmc;
	private String bz;
	private BigDecimal pmje;
	private String qfrq;
	private String pjdqrq;
	private String skrmc;
	private String skrzh;
	private String skrkhx;
	private String syfphm;
	private String syfpbz;
	private BigDecimal syfpje;
	private String syfpzl;
	
	/** default constructor */
	public BaseEastPjpmxxb() {
	}
	
	public BaseEastPjpmxxb(EastPjpmxxbPK id) {
		this.setId(id);
	}
	
	public EastPjpmxxbPK getId() {
		return id;
	}
	public void setId(EastPjpmxxbPK id) {
		this.id = id;
	}

	public String getCprbh() {
		return cprbh;
	}

	public void setCprbh(String cprbh) {
		this.cprbh = cprbh;
	}

	public String getFkxdm() {
		return fkxdm;
	}

	public void setFkxdm(String fkxdm) {
		this.fkxdm = fkxdm;
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

	public String getPjlx() {
		return pjlx;
	}

	public void setPjlx(String pjlx) {
		this.pjlx = pjlx;
	}

	public String getCprqc() {
		return cprqc;
	}

	public void setCprqc(String cprqc) {
		this.cprqc = cprqc;
	}

	public String getCprzh() {
		return cprzh;
	}

	public void setCprzh(String cprzh) {
		this.cprzh = cprzh;
	}

	public String getFkxmc() {
		return fkxmc;
	}

	public void setFkxmc(String fkxmc) {
		this.fkxmc = fkxmc;
	}

	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	public BigDecimal getPmje() {
		return pmje;
	}

	public void setPmje(BigDecimal pmje) {
		this.pmje = pmje;
	}

	public String getQfrq() {
		return qfrq;
	}

	public void setQfrq(String qfrq) {
		this.qfrq = qfrq;
	}

	public String getPjdqrq() {
		return pjdqrq;
	}

	public void setPjdqrq(String pjdqrq) {
		this.pjdqrq = pjdqrq;
	}

	public String getSkrmc() {
		return skrmc;
	}

	public void setSkrmc(String skrmc) {
		this.skrmc = skrmc;
	}

	public String getSkrzh() {
		return skrzh;
	}

	public void setSkrzh(String skrzh) {
		this.skrzh = skrzh;
	}

	public String getSkrkhx() {
		return skrkhx;
	}

	public void setSkrkhx(String skrkhx) {
		this.skrkhx = skrkhx;
	}

	public String getSyfphm() {
		return syfphm;
	}

	public void setSyfphm(String syfphm) {
		this.syfphm = syfphm;
	}

	public String getSyfpbz() {
		return syfpbz;
	}

	public void setSyfpbz(String syfpbz) {
		this.syfpbz = syfpbz;
	}

	public BigDecimal getSyfpje() {
		return syfpje;
	}

	public void setSyfpje(BigDecimal syfpje) {
		this.syfpje = syfpje;
	}

	public String getSyfpzl() {
		return syfpzl;
	}

	public void setSyfpzl(String syfpzl) {
		this.syfpzl = syfpzl;
	}
	
}
