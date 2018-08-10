package resources.east.data.base;

import java.io.Serializable;
import java.math.BigDecimal;


public abstract class BaseEastLccpztb implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -5714960743835284053L;
	
	private String id;
	private String yxjgdm;
	private String jrxkzh;
	private String nbjgh;
	private String yxjgmc;
	private String lccpmc;
	private BigDecimal sjmjje;
	private String cpqsrq;
	private String cpyjzzrq;
	private String fxdjr;
	private BigDecimal yhdsjsxsr;
	private BigDecimal dfkhsy;
	private BigDecimal khdsjnhsyl;
	private BigDecimal cpdsjnhsyl;
	private String zzdjr;
	private String cjrq;
	
	public BaseEastLccpztb () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseEastLccpztb (java.lang.String id) {
		this.setId(id);
		initialize();
	}
	
	protected void initialize () {}

	private int hashCode = Integer.MIN_VALUE;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public String getYxjgmc() {
		return yxjgmc;
	}

	public void setYxjgmc(String yxjgmc) {
		this.yxjgmc = yxjgmc;
	}

	public String getLccpmc() {
		return lccpmc;
	}

	public void setLccpmc(String lccpmc) {
		this.lccpmc = lccpmc;
	}

	public BigDecimal getSjmjje() {
		return sjmjje;
	}

	public void setSjmjje(BigDecimal sjmjje) {
		this.sjmjje = sjmjje;
	}

	public String getCpqsrq() {
		return cpqsrq;
	}

	public void setCpqsrq(String cpqsrq) {
		this.cpqsrq = cpqsrq;
	}

	public String getCpyjzzrq() {
		return cpyjzzrq;
	}

	public void setCpyjzzrq(String cpyjzzrq) {
		this.cpyjzzrq = cpyjzzrq;
	}

	public String getFxdjr() {
		return fxdjr;
	}

	public void setFxdjr(String fxdjr) {
		this.fxdjr = fxdjr;
	}

	public BigDecimal getYhdsjsxsr() {
		return yhdsjsxsr;
	}

	public void setYhdsjsxsr(BigDecimal yhdsjsxsr) {
		this.yhdsjsxsr = yhdsjsxsr;
	}

	public BigDecimal getDfkhsy() {
		return dfkhsy;
	}

	public void setDfkhsy(BigDecimal dfkhsy) {
		this.dfkhsy = dfkhsy;
	}

	public BigDecimal getKhdsjnhsyl() {
		return khdsjnhsyl;
	}

	public void setKhdsjnhsyl(BigDecimal khdsjnhsyl) {
		this.khdsjnhsyl = khdsjnhsyl;
	}

	public BigDecimal getCpdsjnhsyl() {
		return cpdsjnhsyl;
	}

	public void setCpdsjnhsyl(BigDecimal cpdsjnhsyl) {
		this.cpdsjnhsyl = cpdsjnhsyl;
	}

	public String getZzdjr() {
		return zzdjr;
	}

	public void setZzdjr(String zzdjr) {
		this.zzdjr = zzdjr;
	}

	public String getCjrq() {
		return cjrq;
	}

	public void setCjrq(String cjrq) {
		this.cjrq = cjrq;
	}

	public String getNbjgh() {
		return nbjgh;
	}

	public void setNbjgh(String nbjgh) {
		this.nbjgh = nbjgh;
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
		if (!(obj instanceof resources.east.data.pub.EastLccpztb)) return false;
		else {
			resources.east.data.pub.EastLccpztb eastLccpztb = (resources.east.data.pub.EastLccpztb) obj;
			if (null == this.getId() || null == eastLccpztb.getId()) return false;
			else return (this.getId().equals(eastLccpztb.getId()));
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


	public String toString () {
		return super.toString();
	}

}
