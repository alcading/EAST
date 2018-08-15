package resources.east.data.base;

import java.io.Serializable;

import resources.east.data.pub.EastZczrgxbPK;

public class BaseEastZczrgxb implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7897173337433530607L;
	private EastZczrgxbPK id;
	private String zrhth;
	private String yxjgdm;
	private String jrxkzh;
	private String nbjgh;
	
	/** default constructor */
	public BaseEastZczrgxb() {
	}
	
	public BaseEastZczrgxb(EastZczrgxbPK id) {
		this.setId(id);
	}

	public EastZczrgxbPK getId() {
		return id;
	}

	public void setId(EastZczrgxbPK id) {
		this.id = id;
	}

	public String getZrhth() {
		return zrhth;
	}

	public void setZrhth(String zrhth) {
		this.zrhth = zrhth;
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
	
}
