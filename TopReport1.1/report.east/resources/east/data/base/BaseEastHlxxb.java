package resources.east.data.base;

import java.io.Serializable;
import java.math.BigDecimal;

import resources.east.data.pub.EastHlxxb;
import resources.east.data.pub.EastHlxxbPK;

public class BaseEastHlxxb implements Serializable {

	private EastHlxxbPK id;
	private String yxjgdm;
	private String jrxkzh;
	private String nbjgh;
	private String yxjgmc;
	private BigDecimal zjj;
	private BigDecimal jzj;
	private int hashCode = Integer.MIN_VALUE;
	
	/** default constructor */
	
	public BaseEastHlxxb() {}
	
	public BaseEastHlxxb(EastHlxxbPK id) {
		this.setId(id);
	}
	
	public BaseEastHlxxb(EastHlxxbPK id, String yxjgdm, String jrxkzh, String nbjgh, String yxjgmc, BigDecimal zjj, BigDecimal jzj) {
		this.setId(id);
		this.yxjgdm = yxjgdm;
		this.jrxkzh = jrxkzh;
		this.nbjgh = nbjgh;
		this.yxjgmc = yxjgmc;
		this.zjj = zjj;
		this.jzj = jzj;
	}
	
	public EastHlxxbPK getId() {
		return id;
	}

	public void setId(EastHlxxbPK id) {
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

	public BigDecimal getZjj() {
		return zjj;
	}

	public void setZjj(BigDecimal zjj) {
		this.zjj = zjj;
	}

	public BigDecimal getJzj() {
		return jzj;
	}

	public void setJzj(BigDecimal jzj) {
		this.jzj = jzj;
	}

	public int getHashCode() {
		return hashCode;
	}

	public void setHashCode(int hashCode) {
		this.hashCode = hashCode;
	}

	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof EastHlxxb)) return false;
		else {
			EastHlxxb eastHlxxb= (EastHlxxb) obj;
			if (null == this.getId() || null == eastHlxxb.getId()) return false;
			else return (this.getId().equals(eastHlxxb.getId()));
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
