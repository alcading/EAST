package resources.east.data.base;

import java.io.Serializable;

public abstract class BaseEastJgxxbTmp implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1632710590687246483L;
	private String id;
	private String yxjgdm;
	private String jrxkzh;
	private String yxjgmc;
	private String jglb;
	private String yzbm;
	private String wdh;
	private String yyzt;
	private String clsj;
	private String jggzkssj;
	private String jggzzzsj;
	private String jgdz;
	private String fzrxm;
	private String fzrzw;
	private String fzrlxdh;
	private String cjrq;
	private String errmsg;
	// Constructors

	
	
	public BaseEastJgxxbTmp () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseEastJgxxbTmp (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;



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

	public String getJglb() {
		return this.jglb;
	}

	public void setJglb(String jglb) {
		this.jglb = jglb;
	}

	public String getYzbm() {
		return this.yzbm;
	}

	public void setYzbm(String yzbm) {
		this.yzbm = yzbm;
	}

	public String getWdh() {
		return this.wdh;
	}

	public void setWdh(String wdh) {
		this.wdh = wdh;
	}

	public String getYyzt() {
		return this.yyzt;
	}

	public void setYyzt(String yyzt) {
		this.yyzt = yyzt;
	}

	public String getClsj() {
		return this.clsj;
	}

	public void setClsj(String clsj) {
		this.clsj = clsj;
	}

	public String getJggzkssj() {
		return this.jggzkssj;
	}

	public void setJggzkssj(String jggzkssj) {
		this.jggzkssj = jggzkssj;
	}

	public String getJggzzzsj() {
		return this.jggzzzsj;
	}

	public void setJggzzzsj(String jggzzzsj) {
		this.jggzzzsj = jggzzzsj;
	}

	public String getJgdz() {
		return this.jgdz;
	}

	public void setJgdz(String jgdz) {
		this.jgdz = jgdz;
	}

	public String getFzrxm() {
		return this.fzrxm;
	}

	public void setFzrxm(String fzrxm) {
		this.fzrxm = fzrxm;
	}

	public String getFzrzw() {
		return this.fzrzw;
	}

	public void setFzrzw(String fzrzw) {
		this.fzrzw = fzrzw;
	}

	public String getFzrlxdh() {
		return this.fzrlxdh;
	}

	public void setFzrlxdh(String fzrlxdh) {
		this.fzrlxdh = fzrlxdh;
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

	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof resources.east.data.pub.EastJgxxbTmp)) return false;
		else {
			resources.east.data.pub.EastJgxxbTmp eastJgxxb = (resources.east.data.pub.EastJgxxbTmp) obj;
			if (null == this.getId() || null == eastJgxxb.getId()) return false;
			else return (this.getId().equals(eastJgxxb.getId()));
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

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

}