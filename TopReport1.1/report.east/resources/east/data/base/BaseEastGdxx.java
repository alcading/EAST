package resources.east.data.base;

import java.io.Serializable;
import java.math.BigDecimal;

import resources.east.data.pub.EastGdxxPK;

public class BaseEastGdxx implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7897173337433530607L;
	private EastGdxxPK id;
	private String zzjgdm;
	private String yxjgdm;
	private String jrxkzh;
	private String nbjgh;
	private String gdmc;
	private String gdzjlb;
	private String gdzt;
	private BigDecimal cgbl;
	private String rgsj;

	/** default constructor */
	public BaseEastGdxx() {
	}

	public BaseEastGdxx(EastGdxxPK id) {
		this.setId(id);
	}

	public EastGdxxPK getId() {
		return id;
	}

	public void setId(EastGdxxPK id) {
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

	public String getGdmc() {
		return gdmc;
	}

	public void setGdmc(String gdmc) {
		this.gdmc = gdmc;
	}

	public String getGdzjlb() {
		return gdzjlb;
	}

	public void setGdzjlb(String gdzjlb) {
		this.gdzjlb = gdzjlb;
	}

	public String getGdzt() {
		return gdzt;
	}

	public void setGdzt(String gdzt) {
		this.gdzt = gdzt;
	}

	public BigDecimal getCgbl() {
		return cgbl;
	}

	public void setCgbl(BigDecimal cgbl) {
		this.cgbl = cgbl;
	}

	public String getRgsj() {
		return rgsj;
	}

	public void setRgsj(String rgsj) {
		this.rgsj = rgsj;
	}

}
