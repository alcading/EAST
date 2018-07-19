package resources.east.data.base;

import java.io.Serializable;
import java.math.BigDecimal;

import resources.east.data.pub.EastDgkhPK;

public class BaseEastDgkh implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7897173337433530607L;
	private EastDgkhPK id;
	private String zzjgdm;
	private String yxjgdm;
	private String jrxkzh;
	private String nbjgh;
	private String khmc;
	private String khywmc;
	private String frdb;
	private String frdbzjlb;
	private String frdbzjhm;
	private String cwry;
	private String cwryzjlb;
	private String cwryzjhm;
	private String jbckzh;
	private String jbzhkhxmc;
	private BigDecimal zczb;
	private String zcdz;
	private String lxdh;
	private String yyzzh;
	private String yyzzyxjzrq;
	private String jyfw;
	private String clrq;
	private String ssxy;
	private String khlb;
	private String dkzh;
	private String gszh;
	private String dszh;
	private String mgskhtybh;
	private String tysxbz;
	private BigDecimal sxed;
	private BigDecimal yyed;
	private String ssgsbz;
	private String xydjbh;
	private String zczbbz;
	private String sszbbz;
	private BigDecimal sszb;
	private BigDecimal zzc;
	private BigDecimal jzc;
	private BigDecimal nsr;
	private String scjlxdgxny;
	private String yzbm;
	private String czhm;
	private Integer ygrs;
	private String xzqhdm;
	private String khlx;
	private String fxyjxh;

	private int hashCode = Integer.MIN_VALUE;

	/** default constructor */
	public BaseEastDgkh() {
	}

	public BaseEastDgkh(EastDgkhPK id) {
		this.setId(id);
	}

	public EastDgkhPK getId() {
		return id;
	}

	public void setId(EastDgkhPK id) {
		this.id = id;
	}

	public String getZzjgdm() {
		return zzjgdm;
	}

	public void setZzjgdm(String zzjgdm) {
		this.zzjgdm = zzjgdm;
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

	public String getKhywmc() {
		return khywmc;
	}

	public void setKhywmc(String khywmc) {
		this.khywmc = khywmc;
	}

	public String getFrdb() {
		return frdb;
	}

	public void setFrdb(String frdb) {
		this.frdb = frdb;
	}

	public String getFrdbzjlb() {
		return frdbzjlb;
	}

	public void setFrdbzjlb(String frdbzjlb) {
		this.frdbzjlb = frdbzjlb;
	}

	public String getFrdbzjhm() {
		return frdbzjhm;
	}

	public void setFrdbzjhm(String frdbzjhm) {
		this.frdbzjhm = frdbzjhm;
	}

	public String getCwry() {
		return cwry;
	}

	public void setCwry(String cwry) {
		this.cwry = cwry;
	}

	public String getCwryzjlb() {
		return cwryzjlb;
	}

	public void setCwryzjlb(String cwryzjlb) {
		this.cwryzjlb = cwryzjlb;
	}

	public String getCwryzjhm() {
		return cwryzjhm;
	}

	public void setCwryzjhm(String cwryzjhm) {
		this.cwryzjhm = cwryzjhm;
	}

	public String getJbckzh() {
		return jbckzh;
	}

	public void setJbckzh(String jbckzh) {
		this.jbckzh = jbckzh;
	}

	public String getJbzhkhxmc() {
		return jbzhkhxmc;
	}

	public void setJbzhkhxmc(String jbzhkhxmc) {
		this.jbzhkhxmc = jbzhkhxmc;
	}

	public BigDecimal getZczb() {
		return zczb;
	}

	public void setZczb(BigDecimal zczb) {
		this.zczb = zczb;
	}

	public String getZcdz() {
		return zcdz;
	}

	public void setZcdz(String zcdz) {
		this.zcdz = zcdz;
	}

	public String getLxdh() {
		return lxdh;
	}

	public void setLxdh(String lxdh) {
		this.lxdh = lxdh;
	}

	public String getYyzzh() {
		return yyzzh;
	}

	public void setYyzzh(String yyzzh) {
		this.yyzzh = yyzzh;
	}

	public String getYyzzyxjzrq() {
		return yyzzyxjzrq;
	}

	public void setYyzzyxjzrq(String yyzzyxjzrq) {
		this.yyzzyxjzrq = yyzzyxjzrq;
	}

	public String getJyfw() {
		return jyfw;
	}

	public void setJyfw(String jyfw) {
		this.jyfw = jyfw;
	}

	public String getClrq() {
		return clrq;
	}

	public void setClrq(String clrq) {
		this.clrq = clrq;
	}

	public String getSsxy() {
		return ssxy;
	}

	public void setSsxy(String ssxy) {
		this.ssxy = ssxy;
	}

	public String getKhlb() {
		return khlb;
	}

	public void setKhlb(String khlb) {
		this.khlb = khlb;
	}

	public String getDkzh() {
		return dkzh;
	}

	public void setDkzh(String dkzh) {
		this.dkzh = dkzh;
	}

	public String getGszh() {
		return gszh;
	}

	public void setGszh(String gszh) {
		this.gszh = gszh;
	}

	public String getDszh() {
		return dszh;
	}

	public void setDszh(String dszh) {
		this.dszh = dszh;
	}

	public String getMgskhtybh() {
		return mgskhtybh;
	}

	public void setMgskhtybh(String mgskhtybh) {
		this.mgskhtybh = mgskhtybh;
	}

	public String getTysxbz() {
		return tysxbz;
	}

	public void setTysxbz(String tysxbz) {
		this.tysxbz = tysxbz;
	}

	public BigDecimal getSxed() {
		return sxed;
	}

	public void setSxed(BigDecimal sxed) {
		this.sxed = sxed;
	}

	public BigDecimal getYyed() {
		return yyed;
	}

	public void setYyed(BigDecimal yyed) {
		this.yyed = yyed;
	}

	public String getSsgsbz() {
		return ssgsbz;
	}

	public void setSsgsbz(String ssgsbz) {
		this.ssgsbz = ssgsbz;
	}

	public String getXydjbh() {
		return xydjbh;
	}

	public void setXydjbh(String xydjbh) {
		this.xydjbh = xydjbh;
	}

	public String getZczbbz() {
		return zczbbz;
	}

	public void setZczbbz(String zczbbz) {
		this.zczbbz = zczbbz;
	}

	public String getSszbbz() {
		return sszbbz;
	}

	public void setSszbbz(String sszbbz) {
		this.sszbbz = sszbbz;
	}

	public BigDecimal getSszb() {
		return sszb;
	}

	public void setSszb(BigDecimal sszb) {
		this.sszb = sszb;
	}

	public BigDecimal getZzc() {
		return zzc;
	}

	public void setZzc(BigDecimal zzc) {
		this.zzc = zzc;
	}

	public BigDecimal getJzc() {
		return jzc;
	}

	public void setJzc(BigDecimal jzc) {
		this.jzc = jzc;
	}

	public BigDecimal getNsr() {
		return nsr;
	}

	public void setNsr(BigDecimal nsr) {
		this.nsr = nsr;
	}

	public String getScjlxdgxny() {
		return scjlxdgxny;
	}

	public void setScjlxdgxny(String scjlxdgxny) {
		this.scjlxdgxny = scjlxdgxny;
	}

	public String getYzbm() {
		return yzbm;
	}

	public void setYzbm(String yzbm) {
		this.yzbm = yzbm;
	}

	public String getCzhm() {
		return czhm;
	}

	public void setCzhm(String czhm) {
		this.czhm = czhm;
	}

	public String getXzqhdm() {
		return xzqhdm;
	}

	public void setXzqhdm(String xzqhdm) {
		this.xzqhdm = xzqhdm;
	}

	public String getKhlx() {
		return khlx;
	}

	public void setKhlx(String khlx) {
		this.khlx = khlx;
	}

	public String getFxyjxh() {
		return fxyjxh;
	}

	public void setFxyjxh(String fxyjxh) {
		this.fxyjxh = fxyjxh;
	}

	public Integer getYgrs() {
		return ygrs;
	}

	public void setYgrs(Integer ygrs) {
		this.ygrs = ygrs;
	}

}
