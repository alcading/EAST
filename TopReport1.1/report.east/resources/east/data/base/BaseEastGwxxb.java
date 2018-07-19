package resources.east.data.base;

import java.io.Serializable;

import resources.east.data.pub.EastGwxxb;
import resources.east.data.pub.EastGwxxbPK;

public class BaseEastGwxxb implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7897173337433530607L;
	private EastGwxxbPK id;
	private String yxjgdm;
	private String jrxkzh;
	private String gwzl;
	private String gwmc;
	private String gwsm;
	private String gwzt;
	private String cjrq;

	private int hashCode = Integer.MIN_VALUE;

	/** default constructor */
	public BaseEastGwxxb() {
	}

	public BaseEastGwxxb(EastGwxxbPK id) {
		this.setId(id);
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

	public String getGwzl() {
		return gwzl;
	}

	public void setGwzl(String gwzl) {
		this.gwzl = gwzl;
	}

	public String getGwmc() {
		return gwmc;
	}

	public void setGwmc(String gwmc) {
		this.gwmc = gwmc;
	}

	public String getGwsm() {
		return gwsm;
	}

	public void setGwsm(String gwsm) {
		this.gwsm = gwsm;
	}

	public String getGwzt() {
		return gwzt;
	}

	public void setGwzt(String gwzt) {
		this.gwzt = gwzt;
	}

	public String getCjrq() {
		return this.cjrq;
	}

	public void setCjrq(String cjrq) {
		this.cjrq = cjrq;
	}

	public EastGwxxbPK getId() {
		return id;
	}

	public void setId(EastGwxxbPK id) {
		this.id = id;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof EastGwxxb))
			return false;
		else {
			EastGwxxb eastGwxxb = (EastGwxxb) obj;
			if (null == this.getId() || null == eastGwxxb.getId())
				return false;
			else
				return (this.getId().equals(eastGwxxb.getId()));
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

}
