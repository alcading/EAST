package resources.east.data.base;

import resources.east.data.pub.EastCzxx;
import resources.east.data.pub.EastCzxxTmp;
import resources.east.data.pub.EastCzxxTmpId;

/**
 * AbstractEastCzxxTmp entity provides the base persistence definition of the
 * EastCzxxTmp entity. @author MyEclipse Persistence Tools
 */

public abstract class BaseEastCzxx implements java.io.Serializable {

	// Fields

	private EastCzxxTmpId id;
	private String hqckzh;
	private String khtybh;
	private String yxjgdm;
	private String jrxkzh;
	private String nbjgh;
	private String zjlb;
	private String zjhm;
	private String czlx;
	private String czzt;
	private String ygbz;
	private String qyrq;
	private String qygyh;


	// Constructors

	/** default constructor */
	public BaseEastCzxx() {
	}

	/** minimal constructor */
	public BaseEastCzxx(EastCzxxTmpId id) {
		this.id = id;
	}

	/** full constructor */
	public BaseEastCzxx(EastCzxxTmpId id, String hqckzh, String khtybh, String yxjgdm, String jrxkzh,
			String nbjgh, String zjlb, String zjhm, String czlx, String czzt, String ygbz, String qyrq, String qygyh) {
		this.id = id;
		this.hqckzh = hqckzh;
		this.khtybh = khtybh;
		this.yxjgdm = yxjgdm;
		this.jrxkzh = jrxkzh;
		this.nbjgh = nbjgh;
		this.zjlb = zjlb;
		this.zjhm = zjhm;
		this.czlx = czlx;
		this.czzt = czzt;
		this.ygbz = ygbz;
		this.qyrq = qyrq;
		this.qygyh = qygyh;
	}

	// Property accessors

	public EastCzxxTmpId getId() {
		return this.id;
	}

	public void setId(EastCzxxTmpId id) {
		this.id = id;
	}

	public String getHqckzh() {
		return this.hqckzh;
	}

	public void setHqckzh(String hqckzh) {
		this.hqckzh = hqckzh;
	}

	public String getKhtybh() {
		return this.khtybh;
	}

	public void setKhtybh(String khtybh) {
		this.khtybh = khtybh;
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

	public String getNbjgh() {
		return this.nbjgh;
	}

	public void setNbjgh(String nbjgh) {
		this.nbjgh = nbjgh;
	}

	public String getZjlb() {
		return this.zjlb;
	}

	public void setZjlb(String zjlb) {
		this.zjlb = zjlb;
	}

	public String getZjhm() {
		return this.zjhm;
	}

	public void setZjhm(String zjhm) {
		this.zjhm = zjhm;
	}

	public String getCzlx() {
		return this.czlx;
	}

	public void setCzlx(String czlx) {
		this.czlx = czlx;
	}

	public String getCzzt() {
		return this.czzt;
	}

	public void setCzzt(String czzt) {
		this.czzt = czzt;
	}

	public String getYgbz() {
		return this.ygbz;
	}

	public void setYgbz(String ygbz) {
		this.ygbz = ygbz;
	}

	public String getQyrq() {
		return this.qyrq;
	}

	public void setQyrq(String qyrq) {
		this.qyrq = qyrq;
	}

	public String getQygyh() {
		return this.qygyh;
	}

	public void setQygyh(String qygyh) {
		this.qygyh = qygyh;
	}

	

	private int hashCode = Integer.MIN_VALUE;
	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof EastCzxx)) return false;
		else {
			EastCzxx eastCzxx = (EastCzxx) obj;
			if (null == this.getId() || null == eastCzxx.getId()) return false;
			else return (this.getId().equals(eastCzxx.getId()));
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