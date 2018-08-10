package resources.east.data.base;

import java.io.Serializable;
import java.math.BigDecimal;

import resources.east.data.pub.EastPjpmxxbPK;
import resources.east.data.pub.EastSxxxPK;

public class BaseEastSxxx implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7897173337433530607L;
	private EastSxxxPK id;
	private String khtybh;
	private String yxjgdm;
	private String jrxkzh;
	private String nbjgh;
	private String fsrq;
	private String khmc;
	private String sxzl;
	private String sxxymc;
	private BigDecimal edje;
	private String bz;
	private String sxrq;
	private String sxzt;
	private String sxksrq;
	private String sxdqrq;
	private String scsxrq;
	private String jcdyj;
	private String zzspr;
	private String sfxhed;
	private String sflsed;
	private String sxygh;
	
	/** default constructor */
	public BaseEastSxxx() {
	}
	
	public BaseEastSxxx(EastSxxxPK id) {
		this.setId(id);
	}

	public EastSxxxPK getId() {
		return id;
	}

	public void setId(EastSxxxPK id) {
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

	public String getFsrq() {
		return fsrq;
	}

	public void setFsrq(String fsrq) {
		this.fsrq = fsrq;
	}

	public String getKhmc() {
		return khmc;
	}

	public void setKhmc(String khmc) {
		this.khmc = khmc;
	}

	public String getSxzl() {
		return sxzl;
	}

	public void setSxzl(String sxzl) {
		this.sxzl = sxzl;
	}

	public String getSxxymc() {
		return sxxymc;
	}

	public void setSxxymc(String sxxymc) {
		this.sxxymc = sxxymc;
	}

	public BigDecimal getEdje() {
		return edje;
	}

	public void setEdje(BigDecimal edje) {
		this.edje = edje;
	}

	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	public String getSxrq() {
		return sxrq;
	}

	public void setSxrq(String sxrq) {
		this.sxrq = sxrq;
	}

	public String getSxzt() {
		return sxzt;
	}

	public void setSxzt(String sxzt) {
		this.sxzt = sxzt;
	}

	public String getSxksrq() {
		return sxksrq;
	}

	public void setSxksrq(String sxksrq) {
		this.sxksrq = sxksrq;
	}

	public String getSxdqrq() {
		return sxdqrq;
	}

	public void setSxdqrq(String sxdqrq) {
		this.sxdqrq = sxdqrq;
	}

	public String getScsxrq() {
		return scsxrq;
	}

	public void setScsxrq(String scsxrq) {
		this.scsxrq = scsxrq;
	}

	public String getJcdyj() {
		return jcdyj;
	}

	public void setJcdyj(String jcdyj) {
		this.jcdyj = jcdyj;
	}

	public String getZzspr() {
		return zzspr;
	}

	public void setZzspr(String zzspr) {
		this.zzspr = zzspr;
	}

	public String getSfxhed() {
		return sfxhed;
	}

	public void setSfxhed(String sfxhed) {
		this.sfxhed = sfxhed;
	}

	public String getSflsed() {
		return sflsed;
	}

	public void setSflsed(String sflsed) {
		this.sflsed = sflsed;
	}

	public String getSxygh() {
		return sxygh;
	}

	public void setSxygh(String sxygh) {
		this.sxygh = sxygh;
	}
	
	
}
