package resource.bean.report.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the BOP_CRA_EXPLBALAINFO table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="BOP_CRA_EXPLBALAINFO"
 */

public abstract class BaseBopCraExplbalainfo  implements Serializable {

	public static String REF = "BopCfaExplbalainfo";
	public static String PROP_EXPLPERAMOUNT = "explperamount";
	public static String PROP_PLCOSEAMOUNT = "plcoseamount";
	public static String PROP_EXPLBALA = "explbala";
	public static String PROP_EXPLAMOUNT = "explamount";
	public static String PROP_EXPLCURR = "explcurr";
	public static String PROP_CRT_TM = "crtTm";
	public static String PROP_REC_ID = "recId";
	public static String PROP_EXPLBALAINFO_ID = "explbalainfoId";


	// constructors
	public BaseBopCraExplbalainfo () {
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseBopCraExplbalainfo (
		java.lang.String explbalainfoId) {

		this.setExplbalainfoId(explbalainfoId);
		initialize();
	}

	protected void initialize () {}



	// fields
	private java.lang.String explbalainfoId;
	private java.lang.String explcurr;
	private java.math.BigDecimal explamount;
	private java.math.BigDecimal explbala;
	private java.math.BigDecimal explperamount;
	private java.math.BigDecimal plcoseamount;
	private java.util.Date crtTm;
	private java.lang.String recId;






	/**
	 * Return the value associated with the column: EXPLBALAINFO_ID
	 */
	public java.lang.String getExplbalainfoId () {
		return explbalainfoId;
	}

	/**
	 * Set the value related to the column: EXPLBALAINFO_ID
	 * @param explbalainfoId the EXPLBALAINFO_ID value
	 */
	public void setExplbalainfoId (java.lang.String explbalainfoId) {
		this.explbalainfoId = explbalainfoId;
	}



	/**
	 * Return the value associated with the column: EXPLCURR
	 */
	public java.lang.String getExplcurr () {
		return explcurr;
	}

	/**
	 * Set the value related to the column: EXPLCURR
	 * @param explcurr the EXPLCURR value
	 */
	public void setExplcurr (java.lang.String explcurr) {
		this.explcurr = explcurr;
	}



	/**
	 * Return the value associated with the column: EXPLAMOUNT
	 */
	public java.math.BigDecimal getExplamount () {
		return explamount;
	}

	/**
	 * Set the value related to the column: EXPLAMOUNT
	 * @param explamount the EXPLAMOUNT value
	 */
	public void setExplamount (java.math.BigDecimal explamount) {
		this.explamount = explamount;
	}



	/**
	 * Return the value associated with the column: EXPLBALA
	 */
	public java.math.BigDecimal getExplbala () {
		return explbala;
	}

	/**
	 * Set the value related to the column: EXPLBALA
	 * @param explbala the EXPLBALA value
	 */
	public void setExplbala (java.math.BigDecimal explbala) {
		this.explbala = explbala;
	}



	/**
	 * Return the value associated with the column: EXPLPERAMOUNT
	 */
	public java.math.BigDecimal getExplperamount () {
		return explperamount;
	}

	/**
	 * Set the value related to the column: EXPLPERAMOUNT
	 * @param explperamount the EXPLPERAMOUNT value
	 */
	public void setExplperamount (java.math.BigDecimal explperamount) {
		this.explperamount = explperamount;
	}



	/**
	 * Return the value associated with the column: PLCOSEAMOUNT
	 */
	public java.math.BigDecimal getPlcoseamount () {
		return plcoseamount;
	}

	/**
	 * Set the value related to the column: PLCOSEAMOUNT
	 * @param plcoseamount the PLCOSEAMOUNT value
	 */
	public void setPlcoseamount (java.math.BigDecimal plcoseamount) {
		this.plcoseamount = plcoseamount;
	}



	/**
	 * Return the value associated with the column: CRT_TM
	 */
	public java.util.Date getCrtTm () {
		return crtTm;
	}

	/**
	 * Set the value related to the column: CRT_TM
	 * @param crtTm the CRT_TM value
	 */
	public void setCrtTm (java.util.Date crtTm) {
		this.crtTm = crtTm;
	}



	/**
	 * Return the value associated with the column: REC_ID
	 */
	public java.lang.String getRecId () {
		return recId;
	}

	/**
	 * Set the value related to the column: REC_ID
	 * @param recId the REC_ID value
	 */
	public void setRecId (java.lang.String recId) {
		this.recId = recId;
	}







	public String toString () {
		return super.toString();
	}


}