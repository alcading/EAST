package resources.finstandard.data.base;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public abstract class BaseDepositBalance implements Serializable{

	private static final long serialVersionUID = 1L;

	public static String REF = "BaseLoanBalance";
	public static String PROP_SJRQ = "sjrq";
	public static String PROP_JRJGBM = "jrjgbm";
	public static String PROP_KHLX = "khlx";
	public static String PROP_CKZHDM = "ckzhdm";
	public static String PROP_CKXYDM = "ckxydm";
	public static String PROP_CPLB = "cplb";
	public static String PROP_CKXYQSRQ = "ckxyqsrq";
	public static String PROP_CKXYDQRQ = "ckxydqrq";
	public static String PROP_CKBZ = "ckbz";
	public static String PROP_CKYE = "ckye";
	public static String PROP_LLSFGD = "llsfgd";
	public static String PROP_LLSP = "llsp";



	// constructors
	public BaseDepositBalance() {
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseDepositBalance(String jrjgbm,String khlx,String cplb,String ckbz, BigDecimal ckye, String llsfgd){
		this.setJrjgbm(jrjgbm);
		this.setKhlx(khlx);
		this.setCplb(cplb);
		this.setCkbz(ckbz);
		this.setCkye(ckye);
		this.setLlsfgd(llsfgd);
		initialize();	
	}
	
	protected void initialize() {
	}
	
	public BaseDepositBalance(Date sjrq, String jrjgbm, String khlx, String ckzhdm, String ckxydm, String cplb,
			Date ckxyqsrq, Date ckxydqrq, String ckbz, BigDecimal ckye, String llsfgd, BigDecimal llsp) {
		super();
		this.sjrq = sjrq;
		this.jrjgbm = jrjgbm;
		this.khlx = khlx;
		this.ckzhdm = ckzhdm;
		this.ckxydm = ckxydm;
		this.cplb = cplb;
		this.ckxyqsrq = ckxyqsrq;
		this.ckxydqrq = ckxydqrq;
		this.ckbz = ckbz;
		this.ckye = ckye;
		this.llsfgd = llsfgd;
		this.llsp = llsp;
	}

	private Date sjrq;
	private String jrjgbm;
	private String khlx;
	private String ckzhdm;
	private String ckxydm;
	private String cplb;
	private Date ckxyqsrq;
	private Date ckxydqrq;
	private String ckbz;
	private BigDecimal ckye;
	private String llsfgd;
	private BigDecimal llsp;

	public String getCkzhdm() {
		return ckzhdm;
	}

	public void setCkzhdm(String ckzhdm) {
		this.ckzhdm = ckzhdm;
	}

	public String getCkxydm() {
		return ckxydm;
	}

	public void setCkxydm(String ckxydm) {
		this.ckxydm = ckxydm;
	}

	public Date getCkxyqsrq() {
		return ckxyqsrq;
	}

	public void setCkxyqsrq(Date ckxyqsrq) {
		this.ckxyqsrq = ckxyqsrq;
	}

	public Date getCkxydqrq() {
		return ckxydqrq;
	}

	public void setCkxydqrq(Date ckxydqrq) {
		this.ckxydqrq = ckxydqrq;
	}

	public String getCkbz() {
		return ckbz;
	}

	public void setCkbz(String ckbz) {
		this.ckbz = ckbz;
	}

	public BigDecimal getCkye() {
		return ckye;
	}

	public void setCkye(BigDecimal ckye) {
		this.ckye = ckye;
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

	public String getCplb() {
		return cplb;
	}

	public void setCplb(String cplb) {
		this.cplb = cplb;
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

}
