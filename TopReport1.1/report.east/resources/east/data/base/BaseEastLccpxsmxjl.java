package resources.east.data.base;

import java.io.Serializable;
import java.math.BigDecimal;

import resources.east.data.pub.EastLccpxsmxjl;
import resources.east.data.pub.EastLccpxsmxjlPK;

public class BaseEastLccpxsmxjl implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7897173337433530607L;
	private EastLccpxsmxjlPK id;
	private String jyh;
	private String yxjgdm;
	private String jrxkzh;
	private String nbjgh;
	private String mxkmbh;
	private String yxjgmc;
	private String mxkmmc;
	private String lczh;
	private String khtybh;
	private String khxm;
	private String glhqckzh;
	private String lccpmc;
	private String hnbsm;
	private String sgshbz;
	private String bz;
	private BigDecimal jyje;
	private BigDecimal jyfe;
	private BigDecimal jyfy;
	private String jyqd;
	private String khjlgh;
	private String khjlxm;
	private String jygyh;
	private String cjrq;

	private int hashCode = Integer.MIN_VALUE;
	/** default constructor */
	public BaseEastLccpxsmxjl() {
	}
	
	public BaseEastLccpxsmxjl(EastLccpxsmxjlPK id) {
		this.setId(id);
	}


	/** full constructor 
	 * @return */
	public  BaseEastLccpxsmxjl(EastLccpxsmxjlPK id,String jyh, String yxjgdm, String jrxkzh, String nbjgh, String mxkmbh, String yxjgmc,
			String mxkmmc, String lczh, String khtybh, String khxm, String glhqckzh, String lccpmc, String hnbsm, String sgshbz, 
			String bz, BigDecimal jyje, BigDecimal jyfe, BigDecimal jyfy, String jyqd, String khjlgh, String khjlxm, String jygyh, String cjrq) {
		this.setId(id);
		this.jyh = jyh;
		this.yxjgdm = yxjgdm;
		this.jrxkzh = jrxkzh;
		this.nbjgh = nbjgh;
		this.mxkmbh = mxkmbh;
		this.yxjgmc = yxjgmc;
		this.mxkmmc = mxkmmc;
		this.lczh = lczh;
		this.khtybh = khtybh;
		this.khxm = khxm;
		this.glhqckzh = glhqckzh;
		this.lccpmc = lccpmc;
		this.hnbsm = hnbsm;
		this.sgshbz = sgshbz;
		this.bz = bz;
		this.jyje = jyje;
		this.jyfe = jyfe;
		this.jyfy = jyfy;
		this.jyqd = jyqd;
		this.khjlgh = khjlgh;
		this.khjlxm = khjlxm;
		this.jygyh = jygyh;
		this.cjrq = cjrq;
	}


	public EastLccpxsmxjlPK getId() {
		return id;
	}

	public void setId(EastLccpxsmxjlPK id) {
		this.id = id;
	}

	public String getJyh() {
		return jyh;
	}

	public void setJyh(String jyh) {
		this.jyh = jyh;
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

	public String getLczh() {
		return lczh;
	}

	public void setLczh(String lczh) {
		this.lczh = lczh;
	}

	public String getKhtybh() {
		return khtybh;
	}

	public void setKhtybh(String khtybh) {
		this.khtybh = khtybh;
	}

	public String getKhxm() {
		return khxm;
	}

	public void setKhxm(String khxm) {
		this.khxm = khxm;
	}

	public String getGlhqckzh() {
		return glhqckzh;
	}

	public void setGlhqckzh(String glhqckzh) {
		this.glhqckzh = glhqckzh;
	}

	public String getLccpmc() {
		return lccpmc;
	}

	public void setLccpmc(String lccpmc) {
		this.lccpmc = lccpmc;
	}

	public String getHnbsm() {
		return hnbsm;
	}

	public void setHnbsm(String hnbsm) {
		this.hnbsm = hnbsm;
	}

	public String getSgshbz() {
		return sgshbz;
	}

	public void setSgshbz(String sgshbz) {
		this.sgshbz = sgshbz;
	}

	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	public BigDecimal getJyje() {
		return jyje;
	}

	public void setJyje(BigDecimal jyje) {
		this.jyje = jyje;
	}

	public BigDecimal getJyfe() {
		return jyfe;
	}

	public void setJyfe(BigDecimal jyfe) {
		this.jyfe = jyfe;
	}

	public BigDecimal getJyfy() {
		return jyfy;
	}

	public void setJyfy(BigDecimal jyfy) {
		this.jyfy = jyfy;
	}

	public String getJyqd() {
		return jyqd;
	}

	public void setJyqd(String jyqd) {
		this.jyqd = jyqd;
	}

	public String getKhjlgh() {
		return khjlgh;
	}

	public void setKhjlgh(String khjlgh) {
		this.khjlgh = khjlgh;
	}

	public String getKhjlxm() {
		return khjlxm;
	}

	public void setKhjlxm(String khjlxm) {
		this.khjlxm = khjlxm;
	}

	public String getJygyh() {
		return jygyh;
	}

	public void setJygyh(String jygyh) {
		this.jygyh = jygyh;
	}

	public String getCjrq() {
		return cjrq;
	}

	public void setCjrq(String cjrq) {
		this.cjrq = cjrq;
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
		if (!(obj instanceof EastLccpxsmxjl)) return false;
		else {
			EastLccpxsmxjl eastLccpxsmxjl= (EastLccpxsmxjl) obj;
			if (null == this.getId() || null == eastLccpxsmxjl.getId()) return false;
			else return (this.getId().equals(eastLccpxsmxjl.getId()));
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
