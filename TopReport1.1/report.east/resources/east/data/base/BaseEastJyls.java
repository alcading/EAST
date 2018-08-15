package resources.east.data.base;

import java.io.Serializable;
import java.math.BigDecimal;

import resources.east.data.pub.EastJyls;
import resources.east.data.pub.EastJylsPK;

public class BaseEastJyls implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7897173337433530607L;
	private EastJylsPK id;
	private String yxjgdm;
	private String nbjgh;
	private String jrxkzh;
	private String mxkmbh;
	private String jysj;
	private String jzrq;
	private String jzsj;
	private String jyjgmc;
	private String jyhm;
	private String jyxtmc;
	private String dfxh;
	private String dfjgmc;
	private String dfzh;
	private String dfhm;
	private BigDecimal jyje;
	private BigDecimal zhye;
	private String jyjdbz;
	private String xzbz;
	private String bz;
	private Integer ywlx;
	private String jylx;
	private String jyqd;
	private String jyjzmc;
	private String jyjzh;
	private String czgyh;
	private String gylsh;
	private String fhgyh;
	private String zy;
	private String zpzzl;
	private String zpzh;
	private String fpzzl;
	private String fpzh;
	private String cbmbz;
	private String sjc;
	private String zhbz;
	private String kxhbz;

	private int hashCode = Integer.MIN_VALUE;
	/** default constructor */
	public BaseEastJyls() {
	}
	
	public BaseEastJyls(EastJylsPK id) {
		this.setId(id);
	}


	/** full constructor 
	 * @return */
	public  BaseEastJyls(EastJylsPK id,String yxjgdm,String nbjgh,String jrxkzh,String mxkmbh,String jysj,
			String jzrq,String jzsj,String jyjgmc,String jyhm,String jyxtmc,String dfxh,String dfjgmc,
			String dfzh,String dfhm,BigDecimal jyje, BigDecimal zhye, String jyjdbz,String xzbz,String bz,
			Integer ywlx, String jylx,String jyqd,String jyjzmc,String jyjzh,String czgyh,String gylsh,
			String fhgyh,String zy,String zpzzl,String zpzh,String fpzzl,String fpzh,String cbmbz,String sjc,
			String zhbz,String kxhbz) {
		this.setId(id);
		this.yxjgdm = yxjgdm;
		this.nbjgh = nbjgh;
		this.jrxkzh = jrxkzh;
		this.mxkmbh = mxkmbh;
		this.jysj = jysj;
		this.jzrq = jzrq;
		this.jzsj = jzsj;
		this.jyjgmc = jyjgmc;
		this.jyhm = jyhm;
		this.jyxtmc = jyxtmc;
		this.dfxh = dfxh;
		this.dfjgmc = dfjgmc;
		this.dfzh = dfzh;
		this.dfhm = dfhm;
		this.jyje = jyje;
		this.zhye = zhye;
		this.jyjdbz = jyjdbz;
		this.xzbz = xzbz;
		this.bz = bz;
		this.ywlx = ywlx;
		this.jylx = jylx;
		this.jyqd = jyqd;
		this.jyjzmc = jyjzmc;
		this.jyjzh = jyjzh;
		this.czgyh = czgyh;
		this.gylsh = gylsh;
		this.fhgyh = fhgyh;
		this.zy = zy;
		this.zpzzl = zpzzl;
		this.zpzh = zpzh;
		this.fpzzl = fpzzl;
		this.fpzh = fpzh;
		this.cbmbz = cbmbz;
		this.sjc = sjc;
		this.zhbz = zhbz;
		this.kxhbz = kxhbz;
	}

	public EastJylsPK getId() {
		return id;
	}

	public void setId(EastJylsPK id) {
		this.id = id;
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

	public String getJrxkzh() {
		return jrxkzh;
	}

	public void setJrxkzh(String jrxkzh) {
		this.jrxkzh = jrxkzh;
	}

	public String getMxkmbh() {
		return mxkmbh;
	}

	public void setMxkmbh(String mxkmbh) {
		this.mxkmbh = mxkmbh;
	}

	public String getJysj() {
		return jysj;
	}

	public void setJysj(String jysj) {
		this.jysj = jysj;
	}

	public String getJzrq() {
		return jzrq;
	}

	public void setJzrq(String jzrq) {
		this.jzrq = jzrq;
	}

	public String getJzsj() {
		return jzsj;
	}

	public void setJzsj(String jzsj) {
		this.jzsj = jzsj;
	}

	public String getJyjgmc() {
		return jyjgmc;
	}

	public void setJyjgmc(String jyjgmc) {
		this.jyjgmc = jyjgmc;
	}

	public String getJyhm() {
		return jyhm;
	}

	public void setJyhm(String jyhm) {
		this.jyhm = jyhm;
	}

	public String getJyxtmc() {
		return jyxtmc;
	}

	public void setJyxtmc(String jyxtmc) {
		this.jyxtmc = jyxtmc;
	}

	public String getDfxh() {
		return dfxh;
	}

	public void setDfxh(String dfxh) {
		this.dfxh = dfxh;
	}

	public String getDfjgmc() {
		return dfjgmc;
	}

	public void setDfjgmc(String dfjgmc) {
		this.dfjgmc = dfjgmc;
	}

	public String getDfzh() {
		return dfzh;
	}

	public void setDfzh(String dfzh) {
		this.dfzh = dfzh;
	}

	public String getDfhm() {
		return dfhm;
	}

	public void setDfhm(String dfhm) {
		this.dfhm = dfhm;
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

	public String getJyjdbz() {
		return jyjdbz;
	}

	public void setJyjdbz(String jyjdbz) {
		this.jyjdbz = jyjdbz;
	}

	public String getXzbz() {
		return xzbz;
	}

	public void setXzbz(String xzbz) {
		this.xzbz = xzbz;
	}

	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	public Integer getYwlx() {
		return ywlx;
	}

	public void setYwlx(Integer ywlx) {
		this.ywlx = ywlx;
	}

	public String getJylx() {
		return jylx;
	}

	public void setJylx(String jylx) {
		this.jylx = jylx;
	}

	public String getJyqd() {
		return jyqd;
	}

	public void setJyqd(String jyqd) {
		this.jyqd = jyqd;
	}

	public String getJyjzmc() {
		return jyjzmc;
	}

	public void setJyjzmc(String jyjzmc) {
		this.jyjzmc = jyjzmc;
	}

	public String getJyjzh() {
		return jyjzh;
	}

	public void setJyjzh(String jyjzh) {
		this.jyjzh = jyjzh;
	}

	public String getCzgyh() {
		return czgyh;
	}

	public void setCzgyh(String czgyh) {
		this.czgyh = czgyh;
	}

	public String getGylsh() {
		return gylsh;
	}

	public void setGylsh(String gylsh) {
		this.gylsh = gylsh;
	}

	public String getFhgyh() {
		return fhgyh;
	}

	public void setFhgyh(String fhgyh) {
		this.fhgyh = fhgyh;
	}

	public String getZy() {
		return zy;
	}

	public void setZy(String zy) {
		this.zy = zy;
	}

	public String getZpzzl() {
		return zpzzl;
	}

	public void setZpzzl(String zpzzl) {
		this.zpzzl = zpzzl;
	}

	public String getZpzh() {
		return zpzh;
	}

	public void setZpzh(String zpzh) {
		this.zpzh = zpzh;
	}

	public String getFpzzl() {
		return fpzzl;
	}

	public void setFpzzl(String fpzzl) {
		this.fpzzl = fpzzl;
	}

	public String getFpzh() {
		return fpzh;
	}

	public void setFpzh(String fpzh) {
		this.fpzh = fpzh;
	}

	public String getCbmbz() {
		return cbmbz;
	}

	public void setCbmbz(String cbmbz) {
		this.cbmbz = cbmbz;
	}

	public String getSjc() {
		return sjc;
	}

	public void setSjc(String sjc) {
		this.sjc = sjc;
	}

	public String getZhbz() {
		return zhbz;
	}

	public void setZhbz(String zhbz) {
		this.zhbz = zhbz;
	}

	public String getKxhbz() {
		return kxhbz;
	}

	public void setKxhbz(String kxhbz) {
		this.kxhbz = kxhbz;
	}

	public int getHashCode() {
		return hashCode;
	}

	public void setHashCode(int hashCode) {
		this.hashCode = hashCode;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof EastJyls)) return false;
		else {
			EastJyls eastJyls= (EastJyls) obj;
			if (null == this.getId() || null == eastJyls.getId()) return false;
			else return (this.getId().equals(eastJyls.getId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}

}
