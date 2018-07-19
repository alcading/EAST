package resources.east.data.base;

import java.io.Serializable;

public abstract class BaseEastGyb implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1632710590687246483L;
	private String id;
	private String gh;
	private String yxjgdm;
	private String nbjgh;
	private String zxjgdm;
	private String jrxkzh;
	private String yxjgmc;
	private String gylx;
	private String sfstgy;
	private String khjlbz;
	private String jbzwbz;
	private String qxglbz;
	private String ybglbz;
	private String xdybz;
	private String kgybz;
	private String zhgybz;
	private String sqbz;
	private String sqfw;
	private String gwbh;
	private String gyyhjb;
	private String gyqxjb;
	private String sgrq;
	private String gwzt;
	private String cjrq;

	// Constructors

	public BaseEastGyb() {
		initialize();
	}

	public BaseEastGyb(java.lang.String id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getGh() {
		return gh;
	}

	public void setGh(String gh) {
		this.gh = gh;
	}

	public String getYxjgdm() {
		return yxjgdm;
	}

	public void setYxjgdm(String yxjgdm) {
		this.yxjgdm = yxjgdm;
	}

	public String getNbjgh() {
		return nbjgh;
	}

	public void setNbjgh(String nbjgh) {
		this.nbjgh = nbjgh;
	}

	public String getZxjgdm() {
		return zxjgdm;
	}

	public void setZxjgdm(String zxjgdm) {
		this.zxjgdm = zxjgdm;
	}

	public String getJrxkzh() {
		return jrxkzh;
	}

	public void setJrxkzh(String jrxkzh) {
		this.jrxkzh = jrxkzh;
	}

	public String getYxjgmc() {
		return yxjgmc;
	}

	public void setYxjgmc(String yxjgmc) {
		this.yxjgmc = yxjgmc;
	}

	public String getGylx() {
		return gylx;
	}

	public void setGylx(String gylx) {
		this.gylx = gylx;
	}

	public String getSfstgy() {
		return sfstgy;
	}

	public void setSfstgy(String sfstgy) {
		this.sfstgy = sfstgy;
	}

	public String getKhjlbz() {
		return khjlbz;
	}

	public void setKhjlbz(String khjlbz) {
		this.khjlbz = khjlbz;
	}

	public String getJbzwbz() {
		return jbzwbz;
	}

	public void setJbzwbz(String jbzwbz) {
		this.jbzwbz = jbzwbz;
	}

	public String getQxglbz() {
		return qxglbz;
	}

	public void setQxglbz(String qxglbz) {
		this.qxglbz = qxglbz;
	}

	public String getYbglbz() {
		return ybglbz;
	}

	public void setYbglbz(String ybglbz) {
		this.ybglbz = ybglbz;
	}

	public String getXdybz() {
		return xdybz;
	}

	public void setXdybz(String xdybz) {
		this.xdybz = xdybz;
	}

	public String getKgybz() {
		return kgybz;
	}

	public void setKgybz(String kgybz) {
		this.kgybz = kgybz;
	}

	public String getZhgybz() {
		return zhgybz;
	}

	public void setZhgybz(String zhgybz) {
		this.zhgybz = zhgybz;
	}

	public String getSqbz() {
		return sqbz;
	}

	public void setSqbz(String sqbz) {
		this.sqbz = sqbz;
	}

	public String getSqfw() {
		return sqfw;
	}

	public void setSqfw(String sqfw) {
		this.sqfw = sqfw;
	}

	public String getGwbh() {
		return gwbh;
	}

	public void setGwbh(String gwbh) {
		this.gwbh = gwbh;
	}

	public String getGyyhjb() {
		return gyyhjb;
	}

	public void setGyyhjb(String gyyhjb) {
		this.gyyhjb = gyyhjb;
	}

	public String getGyqxjb() {
		return gyqxjb;
	}

	public void setGyqxjb(String gyqxjb) {
		this.gyqxjb = gyqxjb;
	}

	public String getSgrq() {
		return sgrq;
	}

	public void setSgrq(String sgrq) {
		this.sgrq = sgrq;
	}

	public String getGwzt() {
		return gwzt;
	}

	public void setGwzt(String gwzt) {
		this.gwzt = gwzt;
	}

	public String getCjrq() {
		return cjrq;
	}

	public void setCjrq(String cjrq) {
		this.cjrq = cjrq;
	}

}