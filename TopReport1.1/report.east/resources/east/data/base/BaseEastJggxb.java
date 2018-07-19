package resources.east.data.base;

import java.io.Serializable;

public abstract class BaseEastJggxb implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1632710590687246483L;
	private String id;
	private String yhjgdm;
	private String jrxkzh;
	private String yhjgmc;
	private String yzbm;
	private String sjgljgdm;
	private String sjgljgmc;
	private String cjrq;
	// Constructors

	public BaseEastJggxb() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseEastJggxb(java.lang.String id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	public String getYhjgdm() {
		return yhjgdm;
	}

	public void setYhjgdm(String yhjgdm) {
		this.yhjgdm = yhjgdm;
	}

	public String getYhjgmc() {
		return yhjgmc;
	}

	public void setYhjgmc(String yhjgmc) {
		this.yhjgmc = yhjgmc;
	}

	public String getSjgljgdm() {
		return sjgljgdm;
	}

	public void setSjgljgdm(String sjgljgdm) {
		this.sjgljgdm = sjgljgdm;
	}

	public String getSjgljgmc() {
		return sjgljgmc;
	}

	public void setSjgljgmc(String sjgljgmc) {
		this.sjgljgmc = sjgljgmc;
	}

	public String getJrxkzh() {
		return this.jrxkzh;
	}

	public void setJrxkzh(String jrxkzh) {
		this.jrxkzh = jrxkzh;
	}

	public String getYzbm() {
		return this.yzbm;
	}

	public void setYzbm(String yzbm) {
		this.yzbm = yzbm;
	}

	public String getCjrq() {
		return this.cjrq;
	}

	public void setCjrq(String cjrq) {
		this.cjrq = cjrq;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof resources.east.data.pub.EastJggxb))
			return false;
		else {
			resources.east.data.pub.EastJggxb eastJggxb = (resources.east.data.pub.EastJggxb) obj;
			if (null == this.getId() || null == eastJggxb.getId())
				return false;
			else
				return (this.getId().equals(eastJggxb.getId()));
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