package resources.east.data.base;

import java.io.Serializable;
import java.math.BigDecimal;

import resources.east.data.pub.EastJrgjxxb;
import resources.east.data.pub.EastJrgjxxbPK;

public class BaseEastJrgjxxb implements Serializable {

	private EastJrgjxxbPK id;
	private String yxjgdm;
	private String jrxkzh;
	private String nbjgh;
	private String yxjgmc;
	private String zqmc;
	private String zclx;
	private String bz;
	private String fxjg;
	private String yxczqydm;
	private String fxgb;
	private String dbjg;
	private String cppj;
	private String pjjg;
	private String fxztpj;
	private String jyzhlx;
	private BigDecimal pmll;
	private BigDecimal fxjge;
	private String fxrq;
	private String ssrq;
	private String qxrq;
	private String dqrq;
	private String lllx;
	private String hqbs;
	private BigDecimal zjpgjg;
	private String pgjgsj;
	private BigDecimal ye;
	
	private int hashCode = Integer.MIN_VALUE;
	
	/** default constructor */
	
	public BaseEastJrgjxxb() {}
	
	public BaseEastJrgjxxb(EastJrgjxxbPK id) {
		this.setId(id);
	}
	
	public BaseEastJrgjxxb(EastJrgjxxbPK id, String yxjgdm, String jrxkzh, String nbjgh, String yxjgmc, String zqmc, String zclx, 
			String bz, String fxjg, String yxczqydm, String fxgb, String dbjg, String cppj, String pjjg, String fxztpj, String jyzhlx, 
			BigDecimal pmll, BigDecimal fxjge, String fxrq, String ssrq, String qxrq, String dqrq, String lllx, String hqbs, 
			BigDecimal zjpgjg, String pgjgsj, BigDecimal ye) {
		this.setId(id);
		this.yxjgdm = yxjgdm;
		this.jrxkzh = jrxkzh;
		this.nbjgh = nbjgh;
		this.yxjgmc = yxjgmc;
		this.zqmc = zqmc;
		this.zclx = zclx;
		this.bz = bz;
		this.fxjg = fxjg;
		this.yxczqydm = yxczqydm;
		this.fxgb = fxgb;
		this.dbjg = dbjg;
		this.cppj = cppj;
		this.pjjg = pjjg;
		this.fxztpj = fxztpj;
		this.jyzhlx = jyzhlx;
		this.pmll = pmll;
		this.fxjge = fxjge;
		this.fxrq = fxrq;
		this.ssrq = ssrq;
		this.qxrq = qxrq;
		this.dqrq = dqrq;
		this.lllx = lllx;
		this.hqbs = hqbs;
		this.zjpgjg = zjpgjg;
		this.pgjgsj = pgjgsj;
		this.ye = ye;
	}
	
	public EastJrgjxxbPK getId() {
		return id;
	}

	public void setId(EastJrgjxxbPK id) {
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

	public String getYxjgmc() {
		return yxjgmc;
	}

	public void setYxjgmc(String yxjgmc) {
		this.yxjgmc = yxjgmc;
	}

	public String getZqmc() {
		return zqmc;
	}

	public void setZqmc(String zqmc) {
		this.zqmc = zqmc;
	}

	public String getZclx() {
		return zclx;
	}

	public void setZclx(String zclx) {
		this.zclx = zclx;
	}

	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	public String getFxjg() {
		return fxjg;
	}

	public void setFxjg(String fxjg) {
		this.fxjg = fxjg;
	}

	public String getYxczqydm() {
		return yxczqydm;
	}

	public void setYxczqydm(String yxczqydm) {
		this.yxczqydm = yxczqydm;
	}

	public String getFxgb() {
		return fxgb;
	}

	public void setFxgb(String fxgb) {
		this.fxgb = fxgb;
	}

	public String getDbjg() {
		return dbjg;
	}

	public void setDbjg(String dbjg) {
		this.dbjg = dbjg;
	}

	public String getCppj() {
		return cppj;
	}

	public void setCppj(String cppj) {
		this.cppj = cppj;
	}

	public String getPjjg() {
		return pjjg;
	}

	public void setPjjg(String pjjg) {
		this.pjjg = pjjg;
	}

	public String getFxztpj() {
		return fxztpj;
	}

	public void setFxztpj(String fxztpj) {
		this.fxztpj = fxztpj;
	}

	public String getJyzhlx() {
		return jyzhlx;
	}

	public void setJyzhlx(String jyzhlx) {
		this.jyzhlx = jyzhlx;
	}

	public BigDecimal getPmll() {
		return pmll;
	}

	public void setPmll(BigDecimal pmll) {
		this.pmll = pmll;
	}

	public BigDecimal getFxjge() {
		return fxjge;
	}

	public void setFxjge(BigDecimal fxjge) {
		this.fxjge = fxjge;
	}

	public String getFxrq() {
		return fxrq;
	}

	public void setFxrq(String fxrq) {
		this.fxrq = fxrq;
	}

	public String getSsrq() {
		return ssrq;
	}

	public void setSsrq(String ssrq) {
		this.ssrq = ssrq;
	}

	public String getQxrq() {
		return qxrq;
	}

	public void setQxrq(String qxrq) {
		this.qxrq = qxrq;
	}

	public String getDqrq() {
		return dqrq;
	}

	public void setDqrq(String dqrq) {
		this.dqrq = dqrq;
	}

	public String getLllx() {
		return lllx;
	}

	public void setLllx(String lllx) {
		this.lllx = lllx;
	}

	public String getHqbs() {
		return hqbs;
	}

	public void setHqbs(String hqbs) {
		this.hqbs = hqbs;
	}

	public BigDecimal getZjpgjg() {
		return zjpgjg;
	}

	public void setZjpgjg(BigDecimal zjpgjg) {
		this.zjpgjg = zjpgjg;
	}

	public String getPgjgsj() {
		return pgjgsj;
	}

	public void setPgjgsj(String pgjgsj) {
		this.pgjgsj = pgjgsj;
	}

	public BigDecimal getYe() {
		return ye;
	}

	public void setYe(BigDecimal ye) {
		this.ye = ye;
	}

	public int getHashCode() {
		return hashCode;
	}

	public void setHashCode(int hashCode) {
		this.hashCode = hashCode;
	}

	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof EastJrgjxxb)) return false;
		else {
			EastJrgjxxb eastJrgjxxb= (EastJrgjxxb) obj;
			if (null == this.getId() || null == eastJrgjxxb.getId()) return false;
			else return (this.getId().equals(eastJrgjxxb.getId()));
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
