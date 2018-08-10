package resources.east.data.base;

import java.io.Serializable;
import java.math.BigDecimal;

import resources.east.data.pub.EastKhlczhxxbPK;
import resources.east.data.pub.EastKhlczhxxb;


public abstract class BaseEastKhlczhxxb implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1002935104280583096L;
	
	private EastKhlczhxxbPK id;
	private String yxjgdm;
	private String jrxkzh;
	private String nbjgh;
	private String mxkmbh;
	private String yxjgmc;
	private String mxkmmc;
	private String bz;
	private String khtybh;
	private String khxm;
	private String lccpmc;
	private BigDecimal fezs;
	private BigDecimal djfe;
	private String hlztzbz;
	private BigDecimal bqsy;
	private BigDecimal ljsy;
	private BigDecimal mrcb;
	private String bqqsrq;
	private String bqdqrq;
	private String khrq;
	private String scdhrq;
	private String cjrq;
	
	private int hashCode = Integer.MIN_VALUE;
	/** default constructor */
	public BaseEastKhlczhxxb() {
	}
	
	public BaseEastKhlczhxxb(EastKhlczhxxbPK id) {
		this.setId(id);
	}


	/** full constructor 
	 * @return */
	public  BaseEastKhlczhxxb(EastKhlczhxxbPK id,String yxjgdm, String jrxkzh, String nbjgh, String mxkmbh, String yxjgmc, String mxkmmc,
			String bz, String khtybh, String khxm, String lccpmc, BigDecimal fezs, BigDecimal djfe, String hlztzbz, BigDecimal bqsy,
			BigDecimal ljsy, BigDecimal mrcb, String bqqsrq, String bqdqrq, String khrq, String scdhrq, String cjrq) {
		this.setId(id);
		this.yxjgdm = yxjgdm;
		this.jrxkzh = jrxkzh;
		this.nbjgh = nbjgh;
		this.mxkmbh = mxkmbh;
		this.yxjgmc = yxjgmc;
		this.mxkmmc = mxkmmc;
		this.bz = bz;
		this.khtybh = khtybh;
		this.khxm = khxm;
		this.lccpmc = lccpmc;
		this.fezs = fezs;
		this.djfe = djfe;
		this.hlztzbz = hlztzbz;
		this.bqsy = bqsy;
		this.ljsy = ljsy;
		this.mrcb = mrcb;
		this.bqqsrq = bqqsrq;
		this.bqdqrq = bqdqrq;
		this.khrq = khrq;
		this.scdhrq = scdhrq;
		this.cjrq = cjrq;
	}
	
	
	

	public EastKhlczhxxbPK getId() {
		return id;
	}

	public void setId(EastKhlczhxxbPK id) {
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

	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
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

	public String getLccpmc() {
		return lccpmc;
	}

	public void setLccpmc(String lccpmc) {
		this.lccpmc = lccpmc;
	}

	public BigDecimal getFezs() {
		return fezs;
	}

	public void setFezs(BigDecimal fezs) {
		this.fezs = fezs;
	}

	public BigDecimal getDjfe() {
		return djfe;
	}

	public void setDjfe(BigDecimal djfe) {
		this.djfe = djfe;
	}

	public String getHlztzbz() {
		return hlztzbz;
	}

	public void setHlztzbz(String hlztzbz) {
		this.hlztzbz = hlztzbz;
	}

	public BigDecimal getBqsy() {
		return bqsy;
	}

	public void setBqsy(BigDecimal bqsy) {
		this.bqsy = bqsy;
	}

	public BigDecimal getLjsy() {
		return ljsy;
	}

	public void setLjsy(BigDecimal ljsy) {
		this.ljsy = ljsy;
	}

	public BigDecimal getMrcb() {
		return mrcb;
	}

	public void setMrcb(BigDecimal mrcb) {
		this.mrcb = mrcb;
	}

	public String getBqqsrq() {
		return bqqsrq;
	}

	public void setBqqsrq(String bqqsrq) {
		this.bqqsrq = bqqsrq;
	}

	public String getBqdqrq() {
		return bqdqrq;
	}

	public void setBqdqrq(String bqdqrq) {
		this.bqdqrq = bqdqrq;
	}

	public String getKhrq() {
		return khrq;
	}

	public void setKhrq(String khrq) {
		this.khrq = khrq;
	}

	public String getScdhrq() {
		return scdhrq;
	}

	public void setScdhrq(String scdhrq) {
		this.scdhrq = scdhrq;
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
		if (!(obj instanceof EastKhlczhxxb)) return false;
		else {
			EastKhlczhxxb eastKhlczhxxb= (EastKhlczhxxb) obj;
			if (null == this.getId() || null == eastKhlczhxxb.getId()) return false;
			else return (this.getId().equals(eastKhlczhxxb.getId()));
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
