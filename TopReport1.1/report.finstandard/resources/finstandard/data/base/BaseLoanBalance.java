package resources.finstandard.data.base;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public abstract class BaseLoanBalance implements Serializable{

	private static final long serialVersionUID = 1L;

	public static String REF = "BaseLoanBalance";
	public static String PROP_SJRQ = "sjrq";
	public static String PROP_JRJGBM = "jrjgbm";
	public static String PROP_KHLX = "khlx";
	public static String PROP_JKRBM = "jkrbm";
	public static String PROP_DKZTHYLX = "dkzthylx";
	public static String PROP_JKRZCDBM = "jkrzcdbm";
	public static String PROP_QYCZRJJCF = "qyczrjjcf";
	public static String PROP_QYGM = "qygm";
	public static String PROP_DKJJBH = "dkjjbh";
	public static String PROP_CPLB = "cplb";
	public static String PROP_DKSJTX = "dksjtx";
	public static String PROP_DKFFRQ = "dkffrq";
	public static String PROP_DKDQRQ = "dkdqrq";
	public static String PROP_ZQDQRQ = "zqdqrq";
	public static String PROP_DKBZ = "dkbz";
	public static String PROP_DKye = "dkye";
	public static String PROP_LLSFGD = "llsfgd";
	public static String PROP_LLSP = "llsp";
	public static String PROP_DKDBFS = "dkdbfs";
	public static String PROP_DKZL = "dkzl";
	public static String PROP_DKZT = "dkzt";



	// constructors
	public BaseLoanBalance() {
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseLoanBalance(String jrjgbm, String khlx, String jkrbm, String dkzthylx, String dkjjbh, String cplb,
			Date dkffrq, Date dkdqrq, String dkbz, BigDecimal dkye, String llsfgd, BigDecimal llsp, String dkzbfs,
			String dkzt, String dkzl) {
		this.setJrjgbm(jrjgbm);
		this.setKhlx(khlx);
		this.setJkrbm(jkrbm);
		this.setDkzthylx(dkzthylx);
		this.setDkjjbh(dkjjbh);
		this.setCplb(cplb);
		this.setDkffrq(dkffrq);
		this.setDkdqrq(dkdqrq);
		this.setDkbz(dkbz);
		this.setDkye(dkye);
		this.setLlsfgd(llsfgd);
		this.setLlsp(llsp);
		this.setDkdbfs(dkzbfs);
		this.setDkzt(dkzt);
		this.setDkzl(dkzl);
		initialize();
	}

	protected void initialize() {
	}

	private Date sjrq;
	private String jrjgbm;
	private String khlx;
	private String jkrbm;
	private String dkzthylx;
	private String jkrzcdbm;
	private String qyczrjjcf;
	private String qygm;
	private String dkjjbh;
	private String cplb;
	private String dksjtx;
	private Date dkffrq;
	private Date dkdqrq;
	private Date zqdqrq;
	private String dkbz;
	private BigDecimal dkye;
	private String llsfgd;
	private BigDecimal llsp;
	private String dkdbfs;
	private String dkzl;
	private String dkzt;
	

	public BaseLoanBalance(Date sjrq, String jrjgbm, String khlx, String jkrbm, String dkzthylx, String jkrzcdbm,
			String qyczrjjcf, String qygm, String dkjjbh, String cplb, String dksjtx, Date dkffrq, Date dkdqrq,
			Date zqdqrq, String dkbz, BigDecimal dkye, String llsfgd, BigDecimal llsp, String dkdbfs, String dkzl,
			String dkzt) {
		super();
		this.sjrq = sjrq;
		this.jrjgbm = jrjgbm;
		this.khlx = khlx;
		this.jkrbm = jkrbm;
		this.dkzthylx = dkzthylx;
		this.jkrzcdbm = jkrzcdbm;
		this.qyczrjjcf = qyczrjjcf;
		this.qygm = qygm;
		this.dkjjbh = dkjjbh;
		this.cplb = cplb;
		this.dksjtx = dksjtx;
		this.dkffrq = dkffrq;
		this.dkdqrq = dkdqrq;
		this.zqdqrq = zqdqrq;
		this.dkbz = dkbz;
		this.dkye = dkye;
		this.llsfgd = llsfgd;
		this.llsp = llsp;
		this.dkdbfs = dkdbfs;
		this.dkzl = dkzl;
		this.dkzt = dkzt;
	}

	public Date getSjrq() {
		return sjrq;
	}

	public void setSjrq(Date sjrq) {
		this.sjrq = sjrq;
	}

	public String getJrjgbm() {
		return jrjgbm;
	}

	public void setJrjgbm(String jrjgbm) {
		this.jrjgbm = jrjgbm;
	}

	public String getKhlx() {
		return khlx;
	}

	public void setKhlx(String khlx) {
		this.khlx = khlx;
	}

	public String getJkrbm() {
		return jkrbm;
	}

	public void setJkrbm(String jkrbm) {
		this.jkrbm = jkrbm;
	}

	public String getDkzthylx() {
		return dkzthylx;
	}

	public void setDkzthylx(String dkzthylx) {
		this.dkzthylx = dkzthylx;
	}

	public String getJkrzcdbm() {
		return jkrzcdbm;
	}

	public void setJkrzcdbm(String jkrzcdbm) {
		this.jkrzcdbm = jkrzcdbm;
	}

	public String getQyczrjjcf() {
		return qyczrjjcf;
	}

	public void setQyczrjjcf(String qyczrjjcf) {
		this.qyczrjjcf = qyczrjjcf;
	}

	public String getQygm() {
		return qygm;
	}

	public void setQygm(String qygm) {
		this.qygm = qygm;
	}

	public String getDkjjbh() {
		return dkjjbh;
	}

	public void setDkjjbh(String dkjjbh) {
		this.dkjjbh = dkjjbh;
	}

	public String getCplb() {
		return cplb;
	}

	public void setCplb(String cplb) {
		this.cplb = cplb;
	}

	public String getDksjtx() {
		return dksjtx;
	}

	public void setDksjtx(String dksjtx) {
		this.dksjtx = dksjtx;
	}

	public Date getDkffrq() {
		return dkffrq;
	}

	public void setDkffrq(Date dkffrq) {
		this.dkffrq = dkffrq;
	}

	public Date getDkdqrq() {
		return dkdqrq;
	}

	public void setDkdqrq(Date dkdqrq) {
		this.dkdqrq = dkdqrq;
	}

	public Date getZqdqrq() {
		return zqdqrq;
	}

	public void setZqdqrq(Date zqdqrq) {
		this.zqdqrq = zqdqrq;
	}

	public String getDkbz() {
		return dkbz;
	}

	public void setDkbz(String dkbz) {
		this.dkbz = dkbz;
	}

	public BigDecimal getDkye() {
		return dkye;
	}

	public void setDkye(BigDecimal dkye) {
		this.dkye = dkye;
	}

	public String getLlsfgd() {
		return llsfgd;
	}

	public void setLlsfgd(String llsfgd) {
		this.llsfgd = llsfgd;
	}

	public BigDecimal getLlsp() {
		return llsp;
	}

	public void setLlsp(BigDecimal llsp) {
		this.llsp = llsp;
	}

	public String getDkdbfs() {
		return dkdbfs;
	}

	public void setDkdbfs(String dkdbfs) {
		this.dkdbfs = dkdbfs;
	}

	public String getDkzl() {
		return dkzl;
	}

	public void setDkzl(String dkzl) {
		this.dkzl = dkzl;
	}

	public String getDkzt() {
		return dkzt;
	}

	public void setDkzt(String dkzt) {
		this.dkzt = dkzt;
	}
}
