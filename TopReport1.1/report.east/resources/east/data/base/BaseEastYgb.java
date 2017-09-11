package resources.east.data.base;

import java.io.Serializable;

import resources.east.data.pub.EastYgb;
import resources.east.data.pub.EastYgbPK;

public class BaseEastYgb implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7897173337433530607L;
	private EastYgbPK id;
	private String yxjgdm;
	private String jrxkzh;
	private String yxjgmc;
	private String xm;
	private String sfzh;
	private String lxdh;
	private String wdh;
	private String ssbm;
	private String zw;
	private String ygzt;
	private String gwbh;
	private String cjrq;

	private int hashCode = Integer.MIN_VALUE;
	/** default constructor */
	public BaseEastYgb() {
	}
	
	public BaseEastYgb(EastYgbPK id) {
		this.setId(id);
	}


	/** full constructor 
	 * @return */
	public  BaseEastYgb(EastYgbPK id,String yxjgdm, String jrxkzh, String yxjgmc, String xm, String sfzh, String lxdh,
			String wdh, String ssbm, String zw, String ygzt, String gwbh, String cjrq) {
		this.setId(id);
		this.yxjgdm = yxjgdm;
		this.jrxkzh = jrxkzh;
		this.yxjgmc = yxjgmc;
		this.xm = xm;
		this.sfzh = sfzh;
		this.lxdh = lxdh;
		this.wdh = wdh;
		this.ssbm = ssbm;
		this.zw = zw;
		this.ygzt = ygzt;
		this.gwbh = gwbh;
		this.cjrq = cjrq;
	}



	public String getYxjgdm() {
		return this.yxjgdm;
	}

	public void setYxjgdm(String yxjgdm) {
		this.yxjgdm = yxjgdm;
	}

	public String getJrxkzh() {
		return this.jrxkzh;
	}

	public void setJrxkzh(String jrxkzh) {
		this.jrxkzh = jrxkzh;
	}

	public String getYxjgmc() {
		return this.yxjgmc;
	}

	public void setYxjgmc(String yxjgmc) {
		this.yxjgmc = yxjgmc;
	}

	public String getXm() {
		return this.xm;
	}

	public void setXm(String xm) {
		this.xm = xm;
	}

	public String getSfzh() {
		return this.sfzh;
	}

	public void setSfzh(String sfzh) {
		this.sfzh = sfzh;
	}

	public String getLxdh() {
		return this.lxdh;
	}

	public void setLxdh(String lxdh) {
		this.lxdh = lxdh;
	}

	public String getWdh() {
		return this.wdh;
	}

	public void setWdh(String wdh) {
		this.wdh = wdh;
	}

	public String getSsbm() {
		return this.ssbm;
	}

	public void setSsbm(String ssbm) {
		this.ssbm = ssbm;
	}

	public String getZw() {
		return this.zw;
	}

	public void setZw(String zw) {
		this.zw = zw;
	}

	public String getYgzt() {
		return this.ygzt;
	}

	public void setYgzt(String ygzt) {
		this.ygzt = ygzt;
	}

	public String getGwbh() {
		return this.gwbh;
	}

	public void setGwbh(String gwbh) {
		this.gwbh = gwbh;
	}

	public String getCjrq() {
		return this.cjrq;
	}

	public void setCjrq(String cjrq) {
		this.cjrq = cjrq;
	}

	public EastYgbPK getId() {
		return id;
	}

	public void setId(EastYgbPK id) {
		this.id = id;
	}

	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof EastYgb)) return false;
		else {
			EastYgb eastYgb= (EastYgb) obj;
			if (null == this.getId() || null == eastYgb.getId()) return false;
			else return (this.getId().equals(eastYgb.getId()));
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
