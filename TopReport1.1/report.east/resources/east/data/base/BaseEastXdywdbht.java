package resources.east.data.base;

import java.io.Serializable;
import java.math.BigDecimal;

import resources.east.data.pub.EastXdywdbhtPK;

public class BaseEastXdywdbht implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7897173337433530607L;
	private EastXdywdbhtPK id;
	private String jrxkzh;
	private String yxjgdm;
	private String nbjgh;
	private String dblx;
	private String dbhtlx;
	private String bzrlb;
	private String bzrmc;
	private String zjlb;
	private BigDecimal bzrjzc;
	private String dbqsrq;
	private String dbdqrq;
	private String dbhtzt;
	private String dbhtqdrq;
	private String dbhtsxrq;
	private String dbhtdqrq;
	private String dbbz;
	private BigDecimal dbzje;
	private String dbwpxh;
	private String jlygh;
	
	/** default constructor */
	public BaseEastXdywdbht() {
	}
	
	public BaseEastXdywdbht(EastXdywdbhtPK id) {
		this.setId(id);
	}
	
	public EastXdywdbhtPK getId() {
		return id;
	}
	public void setId(EastXdywdbhtPK id) {
		this.id = id;
	}

	public String getJrxkzh() {
		return jrxkzh;
	}

	public void setJrxkzh(String jrxkzh) {
		this.jrxkzh = jrxkzh;
	}

	public String getYxjgdm() {
		return yxjgdm;
	}

	public void setYxjgdm(String yxjgdm) {
		this.yxjgdm = yxjgdm;
	}

	public String getNbjgh() {
		return nbjgh;
	}

	public void setNbjgh(String nbjgh) {
		this.nbjgh = nbjgh;
	}

	public String getDblx() {
		return dblx;
	}

	public void setDblx(String dblx) {
		this.dblx = dblx;
	}

	public String getDbhtlx() {
		return dbhtlx;
	}

	public void setDbhtlx(String dbhtlx) {
		this.dbhtlx = dbhtlx;
	}

	public String getBzrlb() {
		return bzrlb;
	}

	public void setBzrlb(String bzrlb) {
		this.bzrlb = bzrlb;
	}

	public String getBzrmc() {
		return bzrmc;
	}

	public void setBzrmc(String bzrmc) {
		this.bzrmc = bzrmc;
	}

	public String getZjlb() {
		return zjlb;
	}

	public void setZjlb(String zjlb) {
		this.zjlb = zjlb;
	}

	public BigDecimal getBzrjzc() {
		return bzrjzc;
	}

	public void setBzrjzc(BigDecimal bzrjzc) {
		this.bzrjzc = bzrjzc;
	}

	public String getDbqsrq() {
		return dbqsrq;
	}

	public void setDbqsrq(String dbqsrq) {
		this.dbqsrq = dbqsrq;
	}

	public String getDbdqrq() {
		return dbdqrq;
	}

	public void setDbdqrq(String dbdqrq) {
		this.dbdqrq = dbdqrq;
	}

	public String getDbhtzt() {
		return dbhtzt;
	}

	public void setDbhtzt(String dbhtzt) {
		this.dbhtzt = dbhtzt;
	}

	public String getDbhtqdrq() {
		return dbhtqdrq;
	}

	public void setDbhtqdrq(String dbhtqdrq) {
		this.dbhtqdrq = dbhtqdrq;
	}

	public String getDbhtsxrq() {
		return dbhtsxrq;
	}

	public void setDbhtsxrq(String dbhtsxrq) {
		this.dbhtsxrq = dbhtsxrq;
	}

	public String getDbhtdqrq() {
		return dbhtdqrq;
	}

	public void setDbhtdqrq(String dbhtdqrq) {
		this.dbhtdqrq = dbhtdqrq;
	}

	public String getDbbz() {
		return dbbz;
	}

	public void setDbbz(String dbbz) {
		this.dbbz = dbbz;
	}

	public BigDecimal getDbzje() {
		return dbzje;
	}

	public void setDbzje(BigDecimal dbzje) {
		this.dbzje = dbzje;
	}

	public String getDbwpxh() {
		return dbwpxh;
	}

	public void setDbwpxh(String dbwpxh) {
		this.dbwpxh = dbwpxh;
	}

	public String getJlygh() {
		return jlygh;
	}

	public void setJlygh(String jlygh) {
		this.jlygh = jlygh;
	}

	
}
