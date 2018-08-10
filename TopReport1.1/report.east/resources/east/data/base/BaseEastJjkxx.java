package resources.east.data.base;

import java.io.Serializable;

import resources.east.data.pub.EastJjkxxPK;

public class BaseEastJjkxx implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7897173337433530607L;
	private EastJjkxxPK id;
	private String khtybh;
	private String yxjgdm;
	private String jrxkzh;
	private String nbjgh;
	private String zjlb;
	private String zjhm;
	private String jjkcpmc;
	private String kpzt;
	private String ygbz;
	private String kkrq;
	private String kkgyh;
	
	/** default constructor */
	public BaseEastJjkxx() {
	}
	
	public BaseEastJjkxx(EastJjkxxPK id) {
		this.setId(id);
	}
	
	public EastJjkxxPK getId() {
		return id;
	}
	public void setId(EastJjkxxPK id) {
		this.id = id;
	}

	public String getKhtybh() {
		return khtybh;
	}

	public void setKhtybh(String khtybh) {
		this.khtybh = khtybh;
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

	public String getZjlb() {
		return zjlb;
	}

	public void setZjlb(String zjlb) {
		this.zjlb = zjlb;
	}

	public String getZjhm() {
		return zjhm;
	}

	public void setZjhm(String zjhm) {
		this.zjhm = zjhm;
	}

	public String getJjkcpmc() {
		return jjkcpmc;
	}

	public void setJjkcpmc(String jjkcpmc) {
		this.jjkcpmc = jjkcpmc;
	}

	public String getKpzt() {
		return kpzt;
	}

	public void setKpzt(String kpzt) {
		this.kpzt = kpzt;
	}

	public String getYgbz() {
		return ygbz;
	}

	public void setYgbz(String ygbz) {
		this.ygbz = ygbz;
	}

	public String getKkrq() {
		return kkrq;
	}

	public void setKkrq(String kkrq) {
		this.kkrq = kkrq;
	}

	public String getKkgyh() {
		return kkgyh;
	}

	public void setKkgyh(String kkgyh) {
		this.kkgyh = kkgyh;
	}
	
}
