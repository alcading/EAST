package resources.east.data.base;

import java.math.BigDecimal;

import resources.east.data.pub.EastGrhqckfhzId;


/**
 * AbstractEastGrhqckfhz entity provides the base persistence definition of the EastGrhqckfhz entity. @author MyEclipse Persistence Tools
 */

public abstract class BaseEastGrhqckfhz  implements java.io.Serializable {


    // Fields    

     /**
	 * 
	 */
	private static final long serialVersionUID = -5952256342399577010L;
	public static final String KHTYBH = "khtybh";
	public static final String YXJGDM = "yxjgdm";
	public static final String JRXKZH = "jrxkzh";
	public static final String NBJGH = "nbjgh";
	public static final String MXKMBH = "mxkmbh";
	public static final String YXJGMC = "yxjgmc";
	public static final String MXKMMC = "mxkmmc";
	public static final String TJKMBH = "tjkmbh";
	public static final String ZHMC = "zhmc";
	public static final String GRHQCKZHLX = "grhqckzhlx";
	public static final String JYJZMC = "jyjzmc";
	public static final String BZJZHBZ = "bzjzhbz";
	public static final String LL = "ll";
	public static final String CKYE = "ckye";
	public static final String KHRQ = "khrq";
	public static final String KHGYH = "khgyh";
	public static final String XHRQ = "xhrq";
	public static final String ZHZT = "zhzt";
	public static final String SCDHRQ = "scdhrq";

	private EastGrhqckfhzId id;
     private String khtybh;
     private String yxjgdm;
     private String jrxkzh;
     private String nbjgh;
     private String mxkmbh;
     private String yxjgmc;
     private String mxkmmc;
     private String tjkmbh;
     private String zhmc;
     private String grhqckzhlx;
     private String jyjzmc;
     private String bzjzhbz;
     private BigDecimal ll;
     private BigDecimal ckye;
     private String khrq;
     private String khgyh;
     private String xhrq;
     private String zhzt;
     private String scdhrq;


    // Constructors

    /** default constructor */
    public BaseEastGrhqckfhz() {
    }

	/** minimal constructor */
    public BaseEastGrhqckfhz(EastGrhqckfhzId id) {
        this.id = id;
    }
    
    /** full constructor */
    public BaseEastGrhqckfhz(EastGrhqckfhzId id, String khtybh, String yxjgdm, String jrxkzh, String nbjgh, String mxkmbh, String yxjgmc, String mxkmmc, String tjkmbh, String zhmc, String grhqckzhlx, String jyjzmc, String bzjzhbz, BigDecimal ll, BigDecimal ckye, String khrq, String khgyh, String xhrq, String zhzt, String scdhrq) {
        this.id = id;
        this.khtybh = khtybh;
        this.yxjgdm = yxjgdm;
        this.jrxkzh = jrxkzh;
        this.nbjgh = nbjgh;
        this.mxkmbh = mxkmbh;
        this.yxjgmc = yxjgmc;
        this.mxkmmc = mxkmmc;
        this.tjkmbh = tjkmbh;
        this.zhmc = zhmc;
        this.grhqckzhlx = grhqckzhlx;
        this.jyjzmc = jyjzmc;
        this.bzjzhbz = bzjzhbz;
        this.ll = ll;
        this.ckye = ckye;
        this.khrq = khrq;
        this.khgyh = khgyh;
        this.xhrq = xhrq;
        this.zhzt = zhzt;
        this.scdhrq = scdhrq;
    }

   
    // Property accessors

    public EastGrhqckfhzId getId() {
        return this.id;
    }
    
    public void setId(EastGrhqckfhzId id) {
        this.id = id;
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

    public String getMxkmbh() {
        return this.mxkmbh;
    }
    
    public void setMxkmbh(String mxkmbh) {
        this.mxkmbh = mxkmbh;
    }

    public String getYxjgmc() {
        return this.yxjgmc;
    }
    
    public void setYxjgmc(String yxjgmc) {
        this.yxjgmc = yxjgmc;
    }

    public String getMxkmmc() {
        return this.mxkmmc;
    }
    
    public void setMxkmmc(String mxkmmc) {
        this.mxkmmc = mxkmmc;
    }

    public String getTjkmbh() {
        return this.tjkmbh;
    }
    
    public void setTjkmbh(String tjkmbh) {
        this.tjkmbh = tjkmbh;
    }

    public String getZhmc() {
        return this.zhmc;
    }
    
    public void setZhmc(String zhmc) {
        this.zhmc = zhmc;
    }

    public String getGrhqckzhlx() {
        return this.grhqckzhlx;
    }
    
    public void setGrhqckzhlx(String grhqckzhlx) {
        this.grhqckzhlx = grhqckzhlx;
    }

    public String getJyjzmc() {
        return this.jyjzmc;
    }
    
    public void setJyjzmc(String jyjzmc) {
        this.jyjzmc = jyjzmc;
    }

    public String getBzjzhbz() {
        return this.bzjzhbz;
    }
    
    public void setBzjzhbz(String bzjzhbz) {
        this.bzjzhbz = bzjzhbz;
    }

    public BigDecimal getLl() {
        return this.ll;
    }
    
    public void setLl(BigDecimal ll) {
        this.ll = ll;
    }

    public BigDecimal getCkye() {
        return this.ckye;
    }
    
    public void setCkye(BigDecimal ckye) {
        this.ckye = ckye;
    }

    public String getKhrq() {
        return this.khrq;
    }
    
    public void setKhrq(String khrq) {
        this.khrq = khrq;
    }

    public String getKhgyh() {
        return this.khgyh;
    }
    
    public void setKhgyh(String khgyh) {
        this.khgyh = khgyh;
    }

    public String getXhrq() {
        return this.xhrq;
    }
    
    public void setXhrq(String xhrq) {
        this.xhrq = xhrq;
    }

    public String getZhzt() {
        return this.zhzt;
    }
    
    public void setZhzt(String zhzt) {
        this.zhzt = zhzt;
    }

    public String getScdhrq() {
        return this.scdhrq;
    }
    
    public void setScdhrq(String scdhrq) {
        this.scdhrq = scdhrq;
    }
   








}