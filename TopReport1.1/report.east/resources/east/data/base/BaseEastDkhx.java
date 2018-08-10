package resources.east.data.base;

import java.io.Serializable;
import java.math.BigDecimal;

import resources.east.data.pub.EastDkhxPK;

public class BaseEastDkhx implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7897173337433530607L;
	private EastDkhxPK id;
	private String xdhth;
	private String khtybh;
	private String yxjgdm;
	private String jrxkzh;
	private String nbjgh;
	private String mxkmbh;
	private String mxkmmc;
	private String kmgsjg;
	private String bz;
	private BigDecimal shdkbj;
	private BigDecimal shbnlx;
	private BigDecimal shbwlx;
	private BigDecimal hxshbj;
	private BigDecimal hxshbnlx;
	private BigDecimal hxshbwlx;
	private String shbz;
	private String hxshgyh;
	private String bzh;
	
	/** default constructor */
	public BaseEastDkhx() {
	}
	
	public BaseEastDkhx(EastDkhxPK id) {
		this.setId(id);
	}

	public EastDkhxPK getId() {
		return id;
	}

	public void setId(EastDkhxPK id) {
		this.id = id;
	}

	public String getXdhth() {
		return xdhth;
	}

	public void setXdhth(String xdhth) {
		this.xdhth = xdhth;
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

	public String getMxkmbh() {
		return mxkmbh;
	}

	public void setMxkmbh(String mxkmbh) {
		this.mxkmbh = mxkmbh;
	}

	public String getMxkmmc() {
		return mxkmmc;
	}

	public void setMxkmmc(String mxkmmc) {
		this.mxkmmc = mxkmmc;
	}

	public String getKmgsjg() {
		return kmgsjg;
	}

	public void setKmgsjg(String kmgsjg) {
		this.kmgsjg = kmgsjg;
	}

	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	public BigDecimal getShdkbj() {
		return shdkbj;
	}

	public void setShdkbj(BigDecimal shdkbj) {
		this.shdkbj = shdkbj;
	}

	public BigDecimal getShbnlx() {
		return shbnlx;
	}

	public void setShbnlx(BigDecimal shbnlx) {
		this.shbnlx = shbnlx;
	}

	public BigDecimal getShbwlx() {
		return shbwlx;
	}

	public void setShbwlx(BigDecimal shbwlx) {
		this.shbwlx = shbwlx;
	}

	public BigDecimal getHxshbj() {
		return hxshbj;
	}

	public void setHxshbj(BigDecimal hxshbj) {
		this.hxshbj = hxshbj;
	}

	public BigDecimal getHxshbnlx() {
		return hxshbnlx;
	}

	public void setHxshbnlx(BigDecimal hxshbnlx) {
		this.hxshbnlx = hxshbnlx;
	}

	public BigDecimal getHxshbwlx() {
		return hxshbwlx;
	}

	public void setHxshbwlx(BigDecimal hxshbwlx) {
		this.hxshbwlx = hxshbwlx;
	}

	public String getShbz() {
		return shbz;
	}

	public void setShbz(String shbz) {
		this.shbz = shbz;
	}

	public String getHxshgyh() {
		return hxshgyh;
	}

	public void setHxshgyh(String hxshgyh) {
		this.hxshgyh = hxshgyh;
	}

	public String getBzh() {
		return bzh;
	}

	public void setBzh(String bzh) {
		this.bzh = bzh;
	}

	
}
