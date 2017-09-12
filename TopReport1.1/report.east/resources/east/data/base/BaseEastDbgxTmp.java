package resources.east.data.base;

import java.math.BigDecimal;

import resources.east.data.pub.EastDbgxId;

/**
 * AbstractEastDbgx entity provides the base persistence definition of the
 * EastDbgx entity. @author MyEclipse Persistence Tools
 */

public  class BaseEastDbgxTmp implements java.io.Serializable {

	// Fields

	private EastDbgxId id;
	private String yxjgdm;
	private String jrxkzh;
	private String nbjgh;
	private String dblx;
	private BigDecimal dbje;
	private String dbqsrq;
	private String dbdqrq;
	private String dbzt;
	private String jldbygh;
	private String errmsg;

	// Constructors

	/** default constructor */
	public BaseEastDbgxTmp() {
	}

	/** minimal constructor */
	public BaseEastDbgxTmp(EastDbgxId id) {
		this.id = id;
	}

	/** full constructor */
	public BaseEastDbgxTmp(EastDbgxId id, String yxjgdm, String jrxkzh, String nbjgh, String dblx, BigDecimal dbje,
			String dbqsrq, String dbdqrq, String dbzt, String jldbygh,String errmsg) {
		this.id = id;
		this.yxjgdm = yxjgdm;
		this.jrxkzh = jrxkzh;
		this.nbjgh = nbjgh;
		this.dblx = dblx;
		this.dbje = dbje;
		this.dbqsrq = dbqsrq;
		this.dbdqrq = dbdqrq;
		this.dbzt = dbzt;
		this.jldbygh = jldbygh;
		this.errmsg = errmsg;
	}

	// Property accessors

	public EastDbgxId getId() {
		return this.id;
	}

	public void setId(EastDbgxId id) {
		this.id = id;
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

	public String getDblx() {
		return this.dblx;
	}

	public void setDblx(String dblx) {
		this.dblx = dblx;
	}

	public BigDecimal getDbje() {
		return this.dbje;
	}

	public void setDbje(BigDecimal dbje) {
		this.dbje = dbje;
	}

	public String getDbqsrq() {
		return this.dbqsrq;
	}

	public void setDbqsrq(String dbqsrq) {
		this.dbqsrq = dbqsrq;
	}

	public String getDbdqrq() {
		return this.dbdqrq;
	}

	public void setDbdqrq(String dbdqrq) {
		this.dbdqrq = dbdqrq;
	}

	public String getDbzt() {
		return this.dbzt;
	}

	public void setDbzt(String dbzt) {
		this.dbzt = dbzt;
	}

	public String getJldbygh() {
		return this.jldbygh;
	}

	public void setJldbygh(String jldbygh) {
		this.jldbygh = jldbygh;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

}