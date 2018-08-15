package resources.east.data.base;

import java.io.Serializable;
import java.math.BigDecimal;

import resources.east.data.pub.EastZjjyxxb;
import resources.east.data.pub.EastZjjyxxbPK;

public class BaseEastZjjyxxb implements Serializable {

	private EastZjjyxxbPK id;
	private String yxjgdm;
	private String jrxkzh;
	private String nbjgh;
	private String mxkmbh;
	private String yxjgmc;
	private String mxkmmc;
	private String lccpdjbm;
	private String jylx;
	private String jyzl;
	private String jyzhlx;
	private String hth;
	private BigDecimal htje;
	private String bz;
	private String jczckhmc;
	private String jczcsshy;
	private String jczcsfwbhkh;
	private String jczczxfs;
	private String jczczxr;
	private String jygy;
	private String spr;
	private String jydsdm;
	private String jydsmc;
	private String jyrq;
	private String qsrq;
	private String dqrq;
	private String mmbz;
	private String jyqbz;
	private String mrbz;
	private BigDecimal mrje;
	private String mcbz;
	private BigDecimal mcje;
	private String cjjg;
	private String ywzt;
	private String fhrq;
	private String qxrq;
	private String sjjgrq;
	private String qsbz;
	private String jfzh;
	private String dfzh;
	private BigDecimal jfje;
	private BigDecimal dfje;
	private String jfbz;
	private String dfbz;
	private BigDecimal jfll;
	private BigDecimal dfll;
	private String bzjjybz;
	private String glbzjzh;
	private String glywbh;
	private String wbglxtmc;
	private int hashCode = Integer.MIN_VALUE;
	/** default constructor */
	public BaseEastZjjyxxb() {}
	
	public BaseEastZjjyxxb(EastZjjyxxbPK id) {
		this.setId(id);
	}
	
	public BaseEastZjjyxxb(EastZjjyxxbPK id, String yxjgdm, String jrxkzh, String nbjgh, String mxkmbh, String yxjgmc, String mxkmmc, 
			String lccpdjbm, String jylx, String jyzl, String jyzhlx, String hth, BigDecimal htje, String bz, String jczckhmc, 
			String jczcsshy, String jczcsfwbhkh, String jczczxfs, String jczczxr, String jygy, String spr, String jydsdm, String jydsmc, 
			String jyrq, String qsrq, String dqrq, String mmbz, String jyqbz, String mrbz, BigDecimal mrje, String mcbz, BigDecimal mcje, 
			String cjjg, String ywzt, String fhrq, String qxrq, String sjjgrq, String qsbz, String jfzh, String dfzh, BigDecimal jfje, 
			BigDecimal dfje, String jfbz, String dfbz, BigDecimal jfll, BigDecimal dfll, String bzjjybz, String glbzjzh, String glywbh, 
			String wbglxtmc) {
		this.setId(id);
		this.yxjgdm = yxjgdm;
		this.jrxkzh = jrxkzh;
		this.nbjgh = nbjgh;
		this.mxkmbh = mxkmbh;
		this.yxjgmc = yxjgmc;
		this.mxkmmc = mxkmmc;
		this.lccpdjbm = lccpdjbm;
		this.jylx = jylx;
		this.jyzl = jyzl;
		this.jyzhlx = jyzhlx;
		this.hth = hth;
		this.htje = htje;
		this.bz = bz;
		this.jczckhmc = jczckhmc;
		this.jczcsshy = jczcsshy;
		this.jczcsfwbhkh = jczcsfwbhkh;
		this.jczczxfs = jczczxfs;
		this.jczczxr = jczczxr;
		this.jygy = jygy;
		this.spr = spr;
		this.jydsdm = jydsdm;
		this.jydsmc = jydsmc;
		this.jyrq = jyrq;
		this.qsrq = qsrq;
		this.dqrq = dqrq;
		this.mmbz = mmbz;
		this.jyqbz = jyqbz;
		this.mrbz = mrbz;
		this.mrje = mrje;
		this.mcbz = mcbz;
		this.mcje = mcje;
		this.cjjg = cjjg;
		this.ywzt = ywzt;
		this.fhrq = fhrq;
		this.qxrq = qxrq;
		this.sjjgrq = sjjgrq;
		this.qsbz = qsbz;
		this.jfzh = jfzh;
		this.dfzh = dfzh;
		this.jfje = jfje;
		this.dfje = dfje;
		this.jfbz = jfbz;
		this.dfbz = dfbz;
		this.jfll = jfll;
		this.dfll = dfll;
		this.bzjjybz = bzjjybz;
		this.glbzjzh = glbzjzh;
		this.glywbh = glywbh;
		this.wbglxtmc = wbglxtmc;
	}

	public EastZjjyxxbPK getId() {
		return id;
	}

	public void setId(EastZjjyxxbPK id) {
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

	public String getMxkmbh() {
		return mxkmbh;
	}

	public void setMxkmbh(String mxkmbh) {
		this.mxkmbh = mxkmbh;
	}

	public String getYxjgmc() {
		return yxjgmc;
	}

	public void setYxjgmc(String yxjgmc) {
		this.yxjgmc = yxjgmc;
	}

	public String getMxkmmc() {
		return mxkmmc;
	}

	public void setMxkmmc(String mxkmmc) {
		this.mxkmmc = mxkmmc;
	}

	public String getLccpdjbm() {
		return lccpdjbm;
	}

	public void setLccpdjbm(String lccpdjbm) {
		this.lccpdjbm = lccpdjbm;
	}

	public String getJylx() {
		return jylx;
	}

	public void setJylx(String jylx) {
		this.jylx = jylx;
	}

	public String getJyzl() {
		return jyzl;
	}

	public void setJyzl(String jyzl) {
		this.jyzl = jyzl;
	}

	public String getJyzhlx() {
		return jyzhlx;
	}

	public void setJyzhlx(String jyzhlx) {
		this.jyzhlx = jyzhlx;
	}

	public String getHth() {
		return hth;
	}

	public void setHth(String hth) {
		this.hth = hth;
	}

	public BigDecimal getHtje() {
		return htje;
	}

	public void setHtje(BigDecimal htje) {
		this.htje = htje;
	}

	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	public String getJczckhmc() {
		return jczckhmc;
	}

	public void setJczckhmc(String jczckhmc) {
		this.jczckhmc = jczckhmc;
	}

	public String getJczcsshy() {
		return jczcsshy;
	}

	public void setJczcsshy(String jczcsshy) {
		this.jczcsshy = jczcsshy;
	}

	public String getJczcsfwbhkh() {
		return jczcsfwbhkh;
	}

	public void setJczcsfwbhkh(String jczcsfwbhkh) {
		this.jczcsfwbhkh = jczcsfwbhkh;
	}

	public String getJczczxfs() {
		return jczczxfs;
	}

	public void setJczczxfs(String jczczxfs) {
		this.jczczxfs = jczczxfs;
	}

	public String getJczczxr() {
		return jczczxr;
	}

	public void setJczczxr(String jczczxr) {
		this.jczczxr = jczczxr;
	}

	public String getJygy() {
		return jygy;
	}

	public void setJygy(String jygy) {
		this.jygy = jygy;
	}

	public String getSpr() {
		return spr;
	}

	public void setSpr(String spr) {
		this.spr = spr;
	}

	public String getJydsdm() {
		return jydsdm;
	}

	public void setJydsdm(String jydsdm) {
		this.jydsdm = jydsdm;
	}

	public String getJydsmc() {
		return jydsmc;
	}

	public void setJydsmc(String jydsmc) {
		this.jydsmc = jydsmc;
	}

	public String getJyrq() {
		return jyrq;
	}

	public void setJyrq(String jyrq) {
		this.jyrq = jyrq;
	}

	public String getQsrq() {
		return qsrq;
	}

	public void setQsrq(String qsrq) {
		this.qsrq = qsrq;
	}

	public String getDqrq() {
		return dqrq;
	}

	public void setDqrq(String dqrq) {
		this.dqrq = dqrq;
	}

	public String getMmbz() {
		return mmbz;
	}

	public void setMmbz(String mmbz) {
		this.mmbz = mmbz;
	}

	public String getJyqbz() {
		return jyqbz;
	}

	public void setJyqbz(String jyqbz) {
		this.jyqbz = jyqbz;
	}

	public String getMrbz() {
		return mrbz;
	}

	public void setMrbz(String mrbz) {
		this.mrbz = mrbz;
	}

	public BigDecimal getMrje() {
		return mrje;
	}

	public void setMrje(BigDecimal mrje) {
		this.mrje = mrje;
	}

	public String getMcbz() {
		return mcbz;
	}

	public void setMcbz(String mcbz) {
		this.mcbz = mcbz;
	}

	public BigDecimal getMcje() {
		return mcje;
	}

	public void setMcje(BigDecimal mcje) {
		this.mcje = mcje;
	}

	public String getCjjg() {
		return cjjg;
	}

	public void setCjjg(String cjjg) {
		this.cjjg = cjjg;
	}

	public String getYwzt() {
		return ywzt;
	}

	public void setYwzt(String ywzt) {
		this.ywzt = ywzt;
	}

	public String getFhrq() {
		return fhrq;
	}

	public void setFhrq(String fhrq) {
		this.fhrq = fhrq;
	}

	public String getQxrq() {
		return qxrq;
	}

	public void setQxrq(String qxrq) {
		this.qxrq = qxrq;
	}

	public String getSjjgrq() {
		return sjjgrq;
	}

	public void setSjjgrq(String sjjgrq) {
		this.sjjgrq = sjjgrq;
	}

	public String getQsbz() {
		return qsbz;
	}

	public void setQsbz(String qsbz) {
		this.qsbz = qsbz;
	}

	public String getJfzh() {
		return jfzh;
	}

	public void setJfzh(String jfzh) {
		this.jfzh = jfzh;
	}

	public String getDfzh() {
		return dfzh;
	}

	public void setDfzh(String dfzh) {
		this.dfzh = dfzh;
	}

	public BigDecimal getJfje() {
		return jfje;
	}

	public void setJfje(BigDecimal jfje) {
		this.jfje = jfje;
	}

	public BigDecimal getDfje() {
		return dfje;
	}

	public void setDfje(BigDecimal dfje) {
		this.dfje = dfje;
	}

	public String getJfbz() {
		return jfbz;
	}

	public void setJfbz(String jfbz) {
		this.jfbz = jfbz;
	}

	public String getDfbz() {
		return dfbz;
	}

	public void setDfbz(String dfbz) {
		this.dfbz = dfbz;
	}

	public BigDecimal getJfll() {
		return jfll;
	}

	public void setJfll(BigDecimal jfll) {
		this.jfll = jfll;
	}

	public BigDecimal getDfll() {
		return dfll;
	}

	public void setDfll(BigDecimal dfll) {
		this.dfll = dfll;
	}

	public String getBzjjybz() {
		return bzjjybz;
	}

	public void setBzjjybz(String bzjjybz) {
		this.bzjjybz = bzjjybz;
	}

	public String getGlbzjzh() {
		return glbzjzh;
	}

	public void setGlbzjzh(String glbzjzh) {
		this.glbzjzh = glbzjzh;
	}

	public String getGlywbh() {
		return glywbh;
	}

	public void setGlywbh(String glywbh) {
		this.glywbh = glywbh;
	}

	public String getWbglxtmc() {
		return wbglxtmc;
	}

	public void setWbglxtmc(String wbglxtmc) {
		this.wbglxtmc = wbglxtmc;
	}

	public int getHashCode() {
		return hashCode;
	}

	public void setHashCode(int hashCode) {
		this.hashCode = hashCode;
	}
	
	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof EastZjjyxxb)) return false;
		else {
			EastZjjyxxb eastZjjyxxb= (EastZjjyxxb) obj;
			if (null == this.getId() || null == eastZjjyxxb.getId()) return false;
			else return (this.getId().equals(eastZjjyxxb.getId()));
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
