package resource.bean.report.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the products_info table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="products_info"
 */

public abstract class BaseProductsInfo  implements Serializable {

	public static String REF = "ProductsInfo";
	public static String PROP_HIGH_LIMIT = "highLimit";
	public static String PROP_STATUS = "status";
	public static String PROP_DESC2 = "desc2";
	public static String PROP_LOW_LIMIT = "lowLimit";
	public static String PROP_DESC1 = "desc1";
	public static String PROP_TERM_TYPE = "termType";
	public static String PROP_EFFECT_DATE = "effectDate";
	public static String PROP_MISCFLG = "miscflg";
	public static String PROP_LAST_UPDT = "lastUpdt";
	public static String PROP_PNAME = "pname";
	public static String PROP_EXPIRE_DATE = "expireDate";
	public static String PROP_ID = "id";
	public static String PROP_TERM = "term";


	// constructors
	public BaseProductsInfo () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseProductsInfo (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;

	// fields
	private java.lang.String pname;
	private java.lang.String termType;
	private java.lang.String term;
	private java.math.BigDecimal lowLimit;
	private java.math.BigDecimal highLimit;
	private java.lang.String status;
	private java.util.Date effectDate;
	private java.util.Date expireDate;
	private java.util.Date lastUpdt;
	private java.lang.String miscflg;
	private java.lang.String desc1;
	private java.lang.String desc2;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  column="pid"
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
	 * Return the value associated with the column: pname
	 */
	public java.lang.String getPname () {
		return pname;
	}

	/**
	 * Set the value related to the column: pname
	 * @param pname the pname value
	 */
	public void setPname (java.lang.String pname) {
		this.pname = pname;
	}



	/**
	 * Return the value associated with the column: term_type
	 */
	public java.lang.String getTermType () {
		return termType;
	}

	/**
	 * Set the value related to the column: term_type
	 * @param termType the term_type value
	 */
	public void setTermType (java.lang.String termType) {
		this.termType = termType;
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
	 * Return the value associated with the column: low_limit
	 */
	public java.math.BigDecimal getLowLimit () {
		return lowLimit;
	}

	/**
	 * Set the value related to the column: low_limit
	 * @param lowLimit the low_limit value
	 */
	public void setLowLimit (java.math.BigDecimal lowLimit) {
		this.lowLimit = lowLimit;
	}



	/**
	 * Return the value associated with the column: high_limit
	 */
	public java.math.BigDecimal getHighLimit () {
		return highLimit;
	}

	/**
	 * Set the value related to the column: high_limit
	 * @param highLimit the high_limit value
	 */
	public void setHighLimit (java.math.BigDecimal highLimit) {
		this.highLimit = highLimit;
	}



	/**
	 * Return the value associated with the column: status
	 */
	public java.lang.String getStatus () {
		return status;
	}

	/**
	 * Set the value related to the column: status
	 * @param status the status value
	 */
	public void setStatus (java.lang.String status) {
		this.status = status;
	}



	/**
	 * Return the value associated with the column: effect_date
	 */
	public java.util.Date getEffectDate () {
		return effectDate;
	}

	/**
	 * Set the value related to the column: effect_date
	 * @param effectDate the effect_date value
	 */
	public void setEffectDate (java.util.Date effectDate) {
		this.effectDate = effectDate;
	}



	/**
	 * Return the value associated with the column: expire_date
	 */
	public java.util.Date getExpireDate () {
		return expireDate;
	}

	/**
	 * Set the value related to the column: expire_date
	 * @param expireDate the expire_date value
	 */
	public void setExpireDate (java.util.Date expireDate) {
		this.expireDate = expireDate;
	}



	/**
	 * Return the value associated with the column: last_updt
	 */
	public java.util.Date getLastUpdt () {
		return lastUpdt;
	}

	/**
	 * Set the value related to the column: last_updt
	 * @param lastUpdt the last_updt value
	 */
	public void setLastUpdt (java.util.Date lastUpdt) {
		this.lastUpdt = lastUpdt;
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
		if (!(obj instanceof resource.bean.report.ProductsInfo)) return false;
		else {
			resource.bean.report.ProductsInfo productsInfo = (resource.bean.report.ProductsInfo) obj;
			if (null == this.getId() || null == productsInfo.getId()) return false;
			else return (this.getId().equals(productsInfo.getId()));
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