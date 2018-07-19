package resources.east.data.base;

import java.io.Serializable;
import java.math.BigDecimal;

import resources.east.data.pub.EastGlgxPK;

public class BaseEastGlgx implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7897173337433530607L;
	private EastGlgxPK id;
	private String yxjgdm;
	private String jrxkzh;
	private String nbjgh;
	private String khsbm;
	private String khlb;
	private String glrsbm;
	private String glrmc;
	private String glrlb;
	private String gxlx;
	private String glgxzt;
	private String lrsj;

	/** default constructor */
	public BaseEastGlgx() {
	}

	public BaseEastGlgx(EastGlgxPK id) {
		this.setId(id);
	}

	public EastGlgxPK getId() {
		return id;
	}

	public void setId(EastGlgxPK id) {
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

	public String getKhsbm() {
		return khsbm;
	}

	public void setKhsbm(String khsbm) {
		this.khsbm = khsbm;
	}

	public String getKhlb() {
		return khlb;
	}

	public void setKhlb(String khlb) {
		this.khlb = khlb;
	}

	public String getGlrsbm() {
		return glrsbm;
	}

	public void setGlrsbm(String glrsbm) {
		this.glrsbm = glrsbm;
	}

	public String getGlrmc() {
		return glrmc;
	}

	public void setGlrmc(String glrmc) {
		this.glrmc = glrmc;
	}

	public String getGlrlb() {
		return glrlb;
	}

	public void setGlrlb(String glrlb) {
		this.glrlb = glrlb;
	}

	public String getGxlx() {
		return gxlx;
	}

	public void setGxlx(String gxlx) {
		this.gxlx = gxlx;
	}

	public String getGlgxzt() {
		return glgxzt;
	}

	public void setGlgxzt(String glgxzt) {
		this.glgxzt = glgxzt;
	}

	public String getLrsj() {
		return lrsj;
	}

	public void setLrsj(String lrsj) {
		this.lrsj = lrsj;
	}

}
