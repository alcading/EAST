package resources.east.data.base;

import java.io.Serializable;
import java.math.BigDecimal;

import resources.east.data.pub.EastWtdkPK;

public class BaseEastWtdk implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7897173337433530607L;
	private EastWtdkPK id;
	private String xdhth;
	private String khtybh;
	private String yxjgdm;
	private String jrxkzh;
	private String nbjgh;
	private String wtrkhtybh;
	private String wtrkhmc;
	private String syrmc;
	private String wtjjkhxh;
	private String wtjjkhxmc;
	private String wtjjzh;
	private String wtzhlx;
	private BigDecimal wtje;
	private BigDecimal sjwtdkje;
	private String wtdkyt;
	private String sfsx;
	private String sxffs;
	private BigDecimal sxfje;
	private String xyqsrq;
	private String xydqrq;
	private String jbrxm;
	private String khjlgh;
	private String jbjgmc;
	private String xyzt;
	
	/** default constructor */
	public BaseEastWtdk() {
	}
	
	public BaseEastWtdk(EastWtdkPK id) {
		this.setId(id);
	}
	
	public EastWtdkPK getId() {
		return id;
	}
	public void setId(EastWtdkPK id) {
		this.id = id;
	}

	public String getXdhth() {
		return xdhth;
	}

	public void setXdhth(String xdhth) {
		this.xdhth = xdhth;
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

	public String getWtrkhtybh() {
		return wtrkhtybh;
	}

	public void setWtrkhtybh(String wtrkhtybh) {
		this.wtrkhtybh = wtrkhtybh;
	}

	public String getWtrkhmc() {
		return wtrkhmc;
	}

	public void setWtrkhmc(String wtrkhmc) {
		this.wtrkhmc = wtrkhmc;
	}

	public String getSyrmc() {
		return syrmc;
	}

	public void setSyrmc(String syrmc) {
		this.syrmc = syrmc;
	}

	public String getWtjjkhxh() {
		return wtjjkhxh;
	}

	public void setWtjjkhxh(String wtjjkhxh) {
		this.wtjjkhxh = wtjjkhxh;
	}

	public String getWtjjkhxmc() {
		return wtjjkhxmc;
	}

	public void setWtjjkhxmc(String wtjjkhxmc) {
		this.wtjjkhxmc = wtjjkhxmc;
	}

	public String getWtjjzh() {
		return wtjjzh;
	}

	public void setWtjjzh(String wtjjzh) {
		this.wtjjzh = wtjjzh;
	}

	public String getWtzhlx() {
		return wtzhlx;
	}

	public void setWtzhlx(String wtzhlx) {
		this.wtzhlx = wtzhlx;
	}

	public BigDecimal getWtje() {
		return wtje;
	}

	public void setWtje(BigDecimal wtje) {
		this.wtje = wtje;
	}

	public BigDecimal getSjwtdkje() {
		return sjwtdkje;
	}

	public void setSjwtdkje(BigDecimal sjwtdkje) {
		this.sjwtdkje = sjwtdkje;
	}

	public String getWtdkyt() {
		return wtdkyt;
	}

	public void setWtdkyt(String wtdkyt) {
		this.wtdkyt = wtdkyt;
	}

	public String getSfsx() {
		return sfsx;
	}

	public void setSfsx(String sfsx) {
		this.sfsx = sfsx;
	}

	public String getSxffs() {
		return sxffs;
	}

	public void setSxffs(String sxffs) {
		this.sxffs = sxffs;
	}

	public BigDecimal getSxfje() {
		return sxfje;
	}

	public void setSxfje(BigDecimal sxfje) {
		this.sxfje = sxfje;
	}

	public String getXyqsrq() {
		return xyqsrq;
	}

	public void setXyqsrq(String xyqsrq) {
		this.xyqsrq = xyqsrq;
	}

	public String getXydqrq() {
		return xydqrq;
	}

	public void setXydqrq(String xydqrq) {
		this.xydqrq = xydqrq;
	}

	public String getJbrxm() {
		return jbrxm;
	}

	public void setJbrxm(String jbrxm) {
		this.jbrxm = jbrxm;
	}

	public String getKhjlgh() {
		return khjlgh;
	}

	public void setKhjlgh(String khjlgh) {
		this.khjlgh = khjlgh;
	}

	public String getJbjgmc() {
		return jbjgmc;
	}

	public void setJbjgmc(String jbjgmc) {
		this.jbjgmc = jbjgmc;
	}

	public String getXyzt() {
		return xyzt;
	}

	public void setXyzt(String xyzt) {
		this.xyzt = xyzt;
	}

	
	
	
}
