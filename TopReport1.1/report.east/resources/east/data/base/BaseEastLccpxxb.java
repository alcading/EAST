package resources.east.data.base;

import java.io.Serializable;
import java.math.BigDecimal;

public abstract class BaseEastLccpxxb implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3199034090593310603L;
	private String id;
	private String yxjgdm;
	private String jrxkzh;
	private String nbjgh;
	private String mxkmbh;
	private String yxjgmc;
	private String mxkmmc;
	private String cpmc;
	private String cpdjbm;
	private String cppp;
	private Integer cpqc;
	private String cpsprsfzh;
	private String cpsprxm;
	private String cpsjrsfzh;
	private String cpsjrxm;
	private String tzjlsfzh;
	private String tzjlxm;
	private String cpsylx;
	private String cpqx;
	private String tzzlx;
	private String zjtxdq;
	private String cptzgjhdq;
	private String lcywfwms;
	private String cpyzms;
	private String kjhsfs;
	private String cpzcpzfs;
	private String cpglms;
	private String sjgllmc;
	private String cpdjfs;
	private String tzlx;
	private String hzms;
	private String hzjgmc;
	private String tzzczljbl;
	private String sfyyqsyl;
	private BigDecimal yjkhzgnsyl;
	private BigDecimal yjkhzdnsyl;
	private String sfysylcsyj;
	private String tzzfxph;
	private String cpxsqy;
	private String mjbz;
	private String dfbjbz;
	private String dfsybz;
	private BigDecimal qdxsje;
	private BigDecimal jhmjje;
	private String mjqsrq;
	private String tzbjdzr;
	private String tzsydzr;
	private BigDecimal xssxfl;
	private String jntgjgmc;
	private String jntgjgdm;
	private String jwtgjggb;
	private String jwtgjgmc;
	private String lccpzjtgzh;
	private String lccpzjtgzhmc;
	private BigDecimal tgfl;
	private String cpfxdj;
	private String fxjgtqzzqbs;
	private String khshqbs;
	private String cpzxbs;
	private String cpzxjglx;
	private String cpzxxs;
	private String cjrq;
	// Constructors

	public BaseEastLccpxxb() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseEastLccpxxb(java.lang.String id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

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

	public String getCpmc() {
		return cpmc;
	}

	public void setCpmc(String cpmc) {
		this.cpmc = cpmc;
	}

	public String getCpdjbm() {
		return cpdjbm;
	}

	public void setCpdjbm(String cpdjbm) {
		this.cpdjbm = cpdjbm;
	}

	public String getCppp() {
		return cppp;
	}

	public void setCppp(String cppp) {
		this.cppp = cppp;
	}

	public Integer getCpqc() {
		return cpqc;
	}

	public void setCpqc(Integer cpqc) {
		this.cpqc = cpqc;
	}

	public String getCpsprsfzh() {
		return cpsprsfzh;
	}

	public void setCpsprsfzh(String cpsprsfzh) {
		this.cpsprsfzh = cpsprsfzh;
	}

	public String getCpsprxm() {
		return cpsprxm;
	}

	public void setCpsprxm(String cpsprxm) {
		this.cpsprxm = cpsprxm;
	}

	public String getCpsjrsfzh() {
		return cpsjrsfzh;
	}

	public void setCpsjrsfzh(String cpsjrsfzh) {
		this.cpsjrsfzh = cpsjrsfzh;
	}

	public String getCpsjrxm() {
		return cpsjrxm;
	}

	public void setCpsjrxm(String cpsjrxm) {
		this.cpsjrxm = cpsjrxm;
	}

	public String getTzjlsfzh() {
		return tzjlsfzh;
	}

	public void setTzjlsfzh(String tzjlsfzh) {
		this.tzjlsfzh = tzjlsfzh;
	}

	public String getTzjlxm() {
		return tzjlxm;
	}

	public void setTzjlxm(String tzjlxm) {
		this.tzjlxm = tzjlxm;
	}

	public String getCpsylx() {
		return cpsylx;
	}

	public void setCpsylx(String cpsylx) {
		this.cpsylx = cpsylx;
	}

	public String getCpqx() {
		return cpqx;
	}

	public void setCpqx(String cpqx) {
		this.cpqx = cpqx;
	}

	public String getTzzlx() {
		return tzzlx;
	}

	public void setTzzlx(String tzzlx) {
		this.tzzlx = tzzlx;
	}

	public String getZjtxdq() {
		return zjtxdq;
	}

	public void setZjtxdq(String zjtxdq) {
		this.zjtxdq = zjtxdq;
	}

	public String getCptzgjhdq() {
		return cptzgjhdq;
	}

	public void setCptzgjhdq(String cptzgjhdq) {
		this.cptzgjhdq = cptzgjhdq;
	}

	public String getLcywfwms() {
		return lcywfwms;
	}

	public void setLcywfwms(String lcywfwms) {
		this.lcywfwms = lcywfwms;
	}

	public String getCpyzms() {
		return cpyzms;
	}

	public void setCpyzms(String cpyzms) {
		this.cpyzms = cpyzms;
	}

	public String getKjhsfs() {
		return kjhsfs;
	}

	public void setKjhsfs(String kjhsfs) {
		this.kjhsfs = kjhsfs;
	}

	public String getCpzcpzfs() {
		return cpzcpzfs;
	}

	public void setCpzcpzfs(String cpzcpzfs) {
		this.cpzcpzfs = cpzcpzfs;
	}

	public String getCpglms() {
		return cpglms;
	}

	public void setCpglms(String cpglms) {
		this.cpglms = cpglms;
	}

	public String getSjgllmc() {
		return sjgllmc;
	}

	public void setSjgllmc(String sjgllmc) {
		this.sjgllmc = sjgllmc;
	}

	public String getCpdjfs() {
		return cpdjfs;
	}

	public void setCpdjfs(String cpdjfs) {
		this.cpdjfs = cpdjfs;
	}

	public String getTzlx() {
		return tzlx;
	}

	public void setTzlx(String tzlx) {
		this.tzlx = tzlx;
	}

	public String getHzms() {
		return hzms;
	}

	public void setHzms(String hzms) {
		this.hzms = hzms;
	}

	public String getHzjgmc() {
		return hzjgmc;
	}

	public void setHzjgmc(String hzjgmc) {
		this.hzjgmc = hzjgmc;
	}

	public String getTzzczljbl() {
		return tzzczljbl;
	}

	public void setTzzczljbl(String tzzczljbl) {
		this.tzzczljbl = tzzczljbl;
	}

	public String getSfyyqsyl() {
		return sfyyqsyl;
	}

	public void setSfyyqsyl(String sfyyqsyl) {
		this.sfyyqsyl = sfyyqsyl;
	}

	public BigDecimal getYjkhzgnsyl() {
		return yjkhzgnsyl;
	}

	public void setYjkhzgnsyl(BigDecimal yjkhzgnsyl) {
		this.yjkhzgnsyl = yjkhzgnsyl;
	}

	public BigDecimal getYjkhzdnsyl() {
		return yjkhzdnsyl;
	}

	public void setYjkhzdnsyl(BigDecimal yjkhzdnsyl) {
		this.yjkhzdnsyl = yjkhzdnsyl;
	}

	public String getSfysylcsyj() {
		return sfysylcsyj;
	}

	public void setSfysylcsyj(String sfysylcsyj) {
		this.sfysylcsyj = sfysylcsyj;
	}

	public String getTzzfxph() {
		return tzzfxph;
	}

	public void setTzzfxph(String tzzfxph) {
		this.tzzfxph = tzzfxph;
	}

	public String getCpxsqy() {
		return cpxsqy;
	}

	public void setCpxsqy(String cpxsqy) {
		this.cpxsqy = cpxsqy;
	}

	public String getMjbz() {
		return mjbz;
	}

	public void setMjbz(String mjbz) {
		this.mjbz = mjbz;
	}

	public String getDfbjbz() {
		return dfbjbz;
	}

	public void setDfbjbz(String dfbjbz) {
		this.dfbjbz = dfbjbz;
	}

	public String getDfsybz() {
		return dfsybz;
	}

	public void setDfsybz(String dfsybz) {
		this.dfsybz = dfsybz;
	}

	public BigDecimal getQdxsje() {
		return qdxsje;
	}

	public void setQdxsje(BigDecimal qdxsje) {
		this.qdxsje = qdxsje;
	}

	public BigDecimal getJhmjje() {
		return jhmjje;
	}

	public void setJhmjje(BigDecimal jhmjje) {
		this.jhmjje = jhmjje;
	}

	public String getMjqsrq() {
		return mjqsrq;
	}

	public void setMjqsrq(String mjqsrq) {
		this.mjqsrq = mjqsrq;
	}

	public String getTzbjdzr() {
		return tzbjdzr;
	}

	public void setTzbjdzr(String tzbjdzr) {
		this.tzbjdzr = tzbjdzr;
	}

	public String getTzsydzr() {
		return tzsydzr;
	}

	public void setTzsydzr(String tzsydzr) {
		this.tzsydzr = tzsydzr;
	}

	public BigDecimal getXssxfl() {
		return xssxfl;
	}

	public void setXssxfl(BigDecimal xssxfl) {
		this.xssxfl = xssxfl;
	}

	public String getJntgjgmc() {
		return jntgjgmc;
	}

	public void setJntgjgmc(String jntgjgmc) {
		this.jntgjgmc = jntgjgmc;
	}

	public String getJntgjgdm() {
		return jntgjgdm;
	}

	public void setJntgjgdm(String jntgjgdm) {
		this.jntgjgdm = jntgjgdm;
	}

	public String getJwtgjggb() {
		return jwtgjggb;
	}

	public void setJwtgjggb(String jwtgjggb) {
		this.jwtgjggb = jwtgjggb;
	}

	public String getJwtgjgmc() {
		return jwtgjgmc;
	}

	public void setJwtgjgmc(String jwtgjgmc) {
		this.jwtgjgmc = jwtgjgmc;
	}

	public String getLccpzjtgzh() {
		return lccpzjtgzh;
	}

	public void setLccpzjtgzh(String lccpzjtgzh) {
		this.lccpzjtgzh = lccpzjtgzh;
	}

	public String getLccpzjtgzhmc() {
		return lccpzjtgzhmc;
	}

	public void setLccpzjtgzhmc(String lccpzjtgzhmc) {
		this.lccpzjtgzhmc = lccpzjtgzhmc;
	}

	public BigDecimal getTgfl() {
		return tgfl;
	}

	public void setTgfl(BigDecimal tgfl) {
		this.tgfl = tgfl;
	}

	public String getCpfxdj() {
		return cpfxdj;
	}

	public void setCpfxdj(String cpfxdj) {
		this.cpfxdj = cpfxdj;
	}

	public String getFxjgtqzzqbs() {
		return fxjgtqzzqbs;
	}

	public void setFxjgtqzzqbs(String fxjgtqzzqbs) {
		this.fxjgtqzzqbs = fxjgtqzzqbs;
	}

	public String getKhshqbs() {
		return khshqbs;
	}

	public void setKhshqbs(String khshqbs) {
		this.khshqbs = khshqbs;
	}

	public String getCpzxbs() {
		return cpzxbs;
	}

	public void setCpzxbs(String cpzxbs) {
		this.cpzxbs = cpzxbs;
	}

	public String getCpzxjglx() {
		return cpzxjglx;
	}

	public void setCpzxjglx(String cpzxjglx) {
		this.cpzxjglx = cpzxjglx;
	}

	public String getCpzxxs() {
		return cpzxxs;
	}

	public void setCpzxxs(String cpzxxs) {
		this.cpzxxs = cpzxxs;
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

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof resources.east.data.pub.EastLccpxxb))
			return false;
		else {
			resources.east.data.pub.EastLccpxxb eastLccpxxb = (resources.east.data.pub.EastLccpxxb) obj;
			if (null == this.getId() || null == eastLccpxxb.getId())
				return false;
			else
				return (this.getId().equals(eastLccpxxb.getId()));
		}
	}

	public int hashCode() {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId())
				return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}

	public String toString() {
		return super.toString();
	}

}