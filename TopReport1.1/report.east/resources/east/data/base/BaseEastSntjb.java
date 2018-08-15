package resources.east.data.base;

import java.io.Serializable;
import java.math.BigDecimal;

import resources.east.data.pub.EastSntjb;
import resources.east.data.pub.EastSntjbPK;

public class BaseEastSntjb implements Serializable {

	private EastSntjbPK id;
	private String jrjgdm;
	private String jrxkzh;
	private String tjkmmc;
	private BigDecimal tjkmje;
	private String dqmc;
	private String xzqhdm;
	
	private int hashCode = Integer.MIN_VALUE;
	
	/** default constructor */
	
	public BaseEastSntjb() {}
	
	public BaseEastSntjb(EastSntjbPK id) {
		this.setId(id);
	}
	
	public BaseEastSntjb(EastSntjbPK id, String jrjgdm, String jrxkzh, String tjkmmc, BigDecimal tjkmje, String dqmc, String xzqhdm) {
		this.setId(id);
		this.jrjgdm = jrjgdm;
		this.jrxkzh = jrxkzh;
		this.tjkmmc = tjkmmc;
		this.tjkmje = tjkmje;
		this.dqmc = dqmc;
		this.xzqhdm = xzqhdm;
	}
	
	public EastSntjbPK getId() {
		return id;
	}

	public void setId(EastSntjbPK id) {
		this.id = id;
	}

	public String getJrjgdm() {
		return jrjgdm;
	}

	public void setJrjgdm(String jrjgdm) {
		this.jrjgdm = jrjgdm;
	}

	public String getJrxkzh() {
		return jrxkzh;
	}

	public void setJrxkzh(String jrxkzh) {
		this.jrxkzh = jrxkzh;
	}

	public String getTjkmmc() {
		return tjkmmc;
	}

	public void setTjkmmc(String tjkmmc) {
		this.tjkmmc = tjkmmc;
	}

	public BigDecimal getTjkmje() {
		return tjkmje;
	}

	public void setTjkmje(BigDecimal tjkmje) {
		this.tjkmje = tjkmje;
	}

	public String getDqmc() {
		return dqmc;
	}

	public void setDqmc(String dqmc) {
		this.dqmc = dqmc;
	}

	public String getXzqhdm() {
		return xzqhdm;
	}

	public void setXzqhdm(String xzqhdm) {
		this.xzqhdm = xzqhdm;
	}

	public int getHashCode() {
		return hashCode;
	}

	public void setHashCode(int hashCode) {
		this.hashCode = hashCode;
	}

	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof EastSntjb)) return false;
		else {
			EastSntjb eastSntjb= (EastSntjb) obj;
			if (null == this.getId() || null == eastSntjb.getId()) return false;
			else return (this.getId().equals(eastSntjb.getId()));
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