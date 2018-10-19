package resources.finstandard.data.base;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public abstract class BaseLoanAmount implements Serializable {

	private static final long serialVersionUID = 1L;

	public static String REF = "LoanAmount";
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
	public static String PROP_DKSJZZRQ = "dksjzzrq";
	public static String PROP_DKBZ = "dkbz";
	public static String PROP_DKFSJE = "dkfsje";
	public static String PROP_LLSFGD = "llsfgd";
	public static String PROP_LLSP = "llsp";
	public static String PROP_DKDBFS = "dkdbfs";
	public static String PROP_DKZT = "dkzt";
	public static String PROP_DKFFSHBZ = "dkffshbz";


	// constructors
	public BaseLoanAmount() {
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseLoanAmount(String jrjgbm, String khlx, String jkrbm, String dkzthylx, String dkjjbh, String cplb,
			Date dkffrq, Date dkdqrq, String dkbz, BigDecimal dkfsje, String llsfgd, String llsp, String dkdbfs,
			String dkzt, String dkffshbz) {
		this.setJrjgbm(jrjgbm);
		this.setKhlx(khlx);
		this.setJkrbm(jkrbm);
		this.setDkzthylx(dkzthylx);
		this.setDkjjbh(dkjjbh);
		this.setCplb(cplb);
		this.setDkffrq(dkffrq);
		this.setDkdqrq(dkdqrq);
		this.setDkbz(dkbz);
		this.setDkfsje(dkfsje);
		this.setLlsfgd(llsfgd);
		this.setLlsp(llsp);
		this.setDkdbfs(dkdbfs);
		this.setDkzt(dkzt);
		this.setDkffshbz(dkffshbz);
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
	private Date dksjzzrq;
	private String dkbz;
	private BigDecimal dkfsje;
	private String llsfgd;
	private String llsp;
	private String dkdbfs;
	private String dkzt;
	private String dkffshbz;
	private BigDecimal sxje;
	private String sxbz;


	public BaseLoanAmount(Date sjrq, String jrjgbm, String khlx, String jkrbm, String dkzthylx, String jkrzcdbm,
			String qyczrjjcf, String qygm, String dkjjbh, String cplb, String dksjtx, Date dkffrq, Date dkdqrq,
			Date dksjzzrq, String dkbz, BigDecimal dkfsje, String llsfgd, String llsp, String dkdbfs, String dkzt,
			String dkffshbz, BigDecimal sxje, String sxbz) {
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
		this.dksjzzrq = dksjzzrq;
		this.dkbz = dkbz;
		this.dkfsje = dkfsje;
		this.llsfgd = llsfgd;
		this.llsp = llsp;
		this.dkdbfs = dkdbfs;
		this.dkzt = dkzt;
		this.dkffshbz = dkffshbz;
		this.sxje = sxje;
		this.sxbz = sxbz;
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

	public Date getDksjzzrq() {
		return dksjzzrq;
	}

	public void setDksjzzrq(Date dksjzzrq) {
		this.dksjzzrq = dksjzzrq;
	}

	public String getDkbz() {
		return dkbz;
	}

	public void setDkbz(String dkbz) {
		this.dkbz = dkbz;
	}

	public BigDecimal getDkfsje() {
		return dkfsje;
	}

	public void setDkfsje(BigDecimal dkfsje) {
		this.dkfsje = dkfsje;
	}

	public String getLlsfgd() {
		return llsfgd;
	}

	public void setLlsfgd(String llsfgd) {
		this.llsfgd = llsfgd;
	}

	public String getLlsp() {
		return llsp;
	}

	public void setLlsp(String llsp) {
		this.llsp = llsp;
	}

	public String getDkdbfs() {
		return dkdbfs;
	}

	public void setDkdbfs(String dkdbfs) {
		this.dkdbfs = dkdbfs;
	}

	public String getDkzt() {
		return dkzt;
	}

	public void setDkzt(String dkzt) {
		this.dkzt = dkzt;
	}

	public String getDkffshbz() {
		return dkffshbz;
	}

	public void setDkffshbz(String dkffshbz) {
		this.dkffshbz = dkffshbz;
	}

	public BigDecimal getSxje() {
		return sxje;
	}

	public void setSxje(BigDecimal sxje) {
		this.sxje = sxje;
	}

	public String getSxbz() {
		return sxbz;
	}

	public void setSxbz(String sxbz) {
		this.sxbz = sxbz;
	}

	
}
