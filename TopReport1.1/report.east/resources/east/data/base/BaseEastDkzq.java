package resources.east.data.base;

import java.io.Serializable;
import java.math.BigDecimal;

import resources.east.data.pub.EastDkzqPK;

public class BaseEastDkzq implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7897173337433530607L;
	private EastDkzqPK id;
	private String xdjjh;
	private String xdhth;
	private String khtybh;
	private String yxjgdm;
	private String jrxkzh;
	private String nbjgh;
	private String zqrq;
	private String zqdqrq;
	private BigDecimal zqje;
	private BigDecimal yll;
	private String lllx;
	private BigDecimal zqjzll;
	private Integer llfd;
	private String yhth;
	private String yjjh;
	private String jygyh;
	private String sqgyh;
	
	/** default constructor */
	public BaseEastDkzq() {
	}
	
	public BaseEastDkzq(EastDkzqPK id) {
		this.setId(id);
	}

	public EastDkzqPK getId() {
		return id;
	}

	public void setId(EastDkzqPK id) {
		this.id = id;
	}

	public String getXdjjh() {
		return xdjjh;
	}

	public void setXdjjh(String xdjjh) {
		this.xdjjh = xdjjh;
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

	public String getZqrq() {
		return zqrq;
	}

	public void setZqrq(String zqrq) {
		this.zqrq = zqrq;
	}

	public String getZqdqrq() {
		return zqdqrq;
	}

	public void setZqdqrq(String zqdqrq) {
		this.zqdqrq = zqdqrq;
	}

	public BigDecimal getZqje() {
		return zqje;
	}

	public void setZqje(BigDecimal zqje) {
		this.zqje = zqje;
	}

	public BigDecimal getYll() {
		return yll;
	}

	public void setYll(BigDecimal yll) {
		this.yll = yll;
	}

	public String getLllx() {
		return lllx;
	}

	public void setLllx(String lllx) {
		this.lllx = lllx;
	}

	public BigDecimal getZqjzll() {
		return zqjzll;
	}

	public void setZqjzll(BigDecimal zqjzll) {
		this.zqjzll = zqjzll;
	}

	public Integer getLlfd() {
		return llfd;
	}

	public void setLlfd(Integer llfd) {
		this.llfd = llfd;
	}

	public String getYhth() {
		return yhth;
	}

	public void setYhth(String yhth) {
		this.yhth = yhth;
	}

	public String getYjjh() {
		return yjjh;
	}

	public void setYjjh(String yjjh) {
		this.yjjh = yjjh;
	}

	public String getJygyh() {
		return jygyh;
	}

	public void setJygyh(String jygyh) {
		this.jygyh = jygyh;
	}

	public String getSqgyh() {
		return sqgyh;
	}

	public void setSqgyh(String sqgyh) {
		this.sqgyh = sqgyh;
	}
	
}
