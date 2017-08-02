package resource.bean.report.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the tla_ln_acct table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="tla_ln_acct"
 */

public abstract class BaseTlaLnAcct  implements Serializable {

	public static String REF = "TlaLnAcct";
	public static String PROP_DESC2 = "desc2";
	public static String PROP_CCY = "ccy";
	public static String PROP_DESC1 = "desc1";
	public static String PROP_DTYP = "dtyp";
	public static String PROP_VDAT = "vdat";
	public static String PROP_CNUM = "cnum";
	public static String PROP_MISCFLG = "miscflg";
	public static String PROP_AMT = "amt";
	public static String PROP_SOL_ID = "solId";
	public static String PROP_CMRM = "cmrm";
	public static String PROP_DDAT = "ddat";
	public static String PROP_ACRM = "acrm";
	public static String PROP_MDAT = "mdat";
	public static String PROP_PCPL = "pcpl";
	public static String PROP_ID = "id";
	public static String PROP_INTR = "intr";
	public static String PROP_TERM = "term";


	// constructors
	public BaseTlaLnAcct () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseTlaLnAcct (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;

	// fields
	private java.lang.String cnum;
	private java.lang.String solId;
	private java.lang.String ccy;
	private java.math.BigDecimal pcpl;
	private java.math.BigDecimal intr;
	private java.lang.String dtyp;
	private java.util.Date ddat;
	private java.util.Date vdat;
	private java.util.Date mdat;
	private java.lang.String term;
	private java.math.BigDecimal amt;
	private java.lang.String acrm;
	private java.lang.String cmrm;
	private java.lang.String miscflg;
	private java.lang.String desc1;
	private java.lang.String desc2;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  column="actno"
     */
	public java.lang.String getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (java.lang.String id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: cnum
	 */
	public java.lang.String getCnum () {
		return cnum;
	}

	/**
	 * Set the value related to the column: cnum
	 * @param cnum the cnum value
	 */
	public void setCnum (java.lang.String cnum) {
		this.cnum = cnum;
	}



	/**
	 * Return the value associated with the column: sol_id
	 */
	public java.lang.String getSolId () {
		return solId;
	}

	/**
	 * Set the value related to the column: sol_id
	 * @param solId the sol_id value
	 */
	public void setSolId (java.lang.String solId) {
		this.solId = solId;
	}



	/**
	 * Return the value associated with the column: ccy
	 */
	public java.lang.String getCcy () {
		return ccy;
	}

	/**
	 * Set the value related to the column: ccy
	 * @param ccy the ccy value
	 */
	public void setCcy (java.lang.String ccy) {
		this.ccy = ccy;
	}



	/**
	 * Return the value associated with the column: pcpl
	 */
	public java.math.BigDecimal getPcpl () {
		return pcpl;
	}

	/**
	 * Set the value related to the column: pcpl
	 * @param pcpl the pcpl value
	 */
	public void setPcpl (java.math.BigDecimal pcpl) {
		this.pcpl = pcpl;
	}



	/**
	 * Return the value associated with the column: intr
	 */
	public java.math.BigDecimal getIntr () {
		return intr;
	}

	/**
	 * Set the value related to the column: intr
	 * @param intr the intr value
	 */
	public void setIntr (java.math.BigDecimal intr) {
		this.intr = intr;
	}



	/**
	 * Return the value associated with the column: dtyp
	 */
	public java.lang.String getDtyp () {
		return dtyp;
	}

	/**
	 * Set the value related to the column: dtyp
	 * @param dtyp the dtyp value
	 */
	public void setDtyp (java.lang.String dtyp) {
		this.dtyp = dtyp;
	}



	/**
	 * Return the value associated with the column: ddat
	 */
	public java.util.Date getDdat () {
		return ddat;
	}

	/**
	 * Set the value related to the column: ddat
	 * @param ddat the ddat value
	 */
	public void setDdat (java.util.Date ddat) {
		this.ddat = ddat;
	}



	/**
	 * Return the value associated with the column: vdat
	 */
	public java.util.Date getVdat () {
		return vdat;
	}

	/**
	 * Set the value related to the column: vdat
	 * @param vdat the vdat value
	 */
	public void setVdat (java.util.Date vdat) {
		this.vdat = vdat;
	}



	/**
	 * Return the value associated with the column: mdat
	 */
	public java.util.Date getMdat () {
		return mdat;
	}

	/**
	 * Set the value related to the column: mdat
	 * @param mdat the mdat value
	 */
	public void setMdat (java.util.Date mdat) {
		this.mdat = mdat;
	}



	/**
	 * Return the value associated with the column: term
	 */
	public java.lang.String getTerm () {
		return term;
	}

	/**
	 * Set the value related to the column: term
	 * @param term the term value
	 */
	public void setTerm (java.lang.String term) {
		this.term = term;
	}



	/**
	 * Return the value associated with the column: amt
	 */
	public java.math.BigDecimal getAmt () {
		return amt;
	}

	/**
	 * Set the value related to the column: amt
	 * @param amt the amt value
	 */
	public void setAmt (java.math.BigDecimal amt) {
		this.amt = amt;
	}



	/**
	 * Return the value associated with the column: acrm
	 */
	public java.lang.String getAcrm () {
		return acrm;
	}

	/**
	 * Set the value related to the column: acrm
	 * @param acrm the acrm value
	 */
	public void setAcrm (java.lang.String acrm) {
		this.acrm = acrm;
	}



	/**
	 * Return the value associated with the column: cmrm
	 */
	public java.lang.String getCmrm () {
		return cmrm;
	}

	/**
	 * Set the value related to the column: cmrm
	 * @param cmrm the cmrm value
	 */
	public void setCmrm (java.lang.String cmrm) {
		this.cmrm = cmrm;
	}



	/**
	 * Return the value associated with the column: miscflg
	 */
	public java.lang.String getMiscflg () {
		return miscflg;
	}

	/**
	 * Set the value related to the column: miscflg
	 * @param miscflg the miscflg value
	 */
	public void setMiscflg (java.lang.String miscflg) {
		this.miscflg = miscflg;
	}



	/**
	 * Return the value associated with the column: desc1
	 */
	public java.lang.String getDesc1 () {
		return desc1;
	}

	/**
	 * Set the value related to the column: desc1
	 * @param desc1 the desc1 value
	 */
	public void setDesc1 (java.lang.String desc1) {
		this.desc1 = desc1;
	}



	/**
	 * Return the value associated with the column: desc2
	 */
	public java.lang.String getDesc2 () {
		return desc2;
	}

	/**
	 * Set the value related to the column: desc2
	 * @param desc2 the desc2 value
	 */
	public void setDesc2 (java.lang.String desc2) {
		this.desc2 = desc2;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof resource.bean.report.TlaLnAcct)) return false;
		else {
			resource.bean.report.TlaLnAcct tlaLnAcct = (resource.bean.report.TlaLnAcct) obj;
			if (null == this.getId() || null == tlaLnAcct.getId()) return false;
			else return (this.getId().equals(tlaLnAcct.getId()));
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


	public String toString () {
		return super.toString();
	}


}