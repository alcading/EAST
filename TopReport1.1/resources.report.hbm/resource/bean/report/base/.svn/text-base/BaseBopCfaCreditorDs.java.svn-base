package resource.bean.report.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the BOP_CFA_CREDITOR_DS table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="BOP_CFA_CREDITOR_DS"
 */

public abstract class BaseBopCfaCreditorDs  implements Serializable {

	public static String REF = "BopCfaCreditorDs";
	public static String PROP_CREDITORCA = "creditorca";
	public static String PROP_CREDITORNAMEN = "creditornamen";
	public static String PROP_OPERCODE = "opercode";
	public static String PROP_ID = "id";
	public static String PROP_CREDITORTYPE = "creditortype";
	public static String PROP_CREHQCODE = "crehqcode";
	public static String PROP_CREDITORCODE = "creditorcode";
	public static String PROP_CRT_TM = "crtTm";
	public static String PROP_CREDITORNAME = "creditorname";
	public static String PROP_REC_ID = "recId";


	// constructors
	public BaseBopCfaCreditorDs () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBopCfaCreditorDs (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;

	// fields
	private java.lang.String creditorcode;
	private java.lang.String creditorname;
	private java.lang.String creditornamen;
	private java.math.BigDecimal creditorca;
	private java.lang.String creditortype;
	private java.lang.String crehqcode;
	private java.lang.String opercode;
	private java.util.Date crtTm;
	private java.lang.String recId;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  column="CREDITOR_ID"
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
	 * Return the value associated with the column: CREDITORCODE
	 */
	public java.lang.String getCreditorcode () {
		return creditorcode;
	}

	/**
	 * Set the value related to the column: CREDITORCODE
	 * @param creditorcode the CREDITORCODE value
	 */
	public void setCreditorcode (java.lang.String creditorcode) {
		this.creditorcode = creditorcode;
	}



	/**
	 * Return the value associated with the column: CREDITORNAME
	 */
	public java.lang.String getCreditorname () {
		return creditorname;
	}

	/**
	 * Set the value related to the column: CREDITORNAME
	 * @param creditorname the CREDITORNAME value
	 */
	public void setCreditorname (java.lang.String creditorname) {
		this.creditorname = creditorname;
	}



	/**
	 * Return the value associated with the column: CREDITORNAMEN
	 */
	public java.lang.String getCreditornamen () {
		return creditornamen;
	}

	/**
	 * Set the value related to the column: CREDITORNAMEN
	 * @param creditornamen the CREDITORNAMEN value
	 */
	public void setCreditornamen (java.lang.String creditornamen) {
		this.creditornamen = creditornamen;
	}



	/**
	 * Return the value associated with the column: CREDITORCA
	 */
	public java.math.BigDecimal getCreditorca () {
		return creditorca;
	}

	/**
	 * Set the value related to the column: CREDITORCA
	 * @param creditorca the CREDITORCA value
	 */
	public void setCreditorca (java.math.BigDecimal creditorca) {
		this.creditorca = creditorca;
	}



	/**
	 * Return the value associated with the column: CREDITORTYPE
	 */
	public java.lang.String getCreditortype () {
		return creditortype;
	}

	/**
	 * Set the value related to the column: CREDITORTYPE
	 * @param creditortype the CREDITORTYPE value
	 */
	public void setCreditortype (java.lang.String creditortype) {
		this.creditortype = creditortype;
	}



	/**
	 * Return the value associated with the column: CREHQCODE
	 */
	public java.lang.String getCrehqcode () {
		return crehqcode;
	}

	/**
	 * Set the value related to the column: CREHQCODE
	 * @param crehqcode the CREHQCODE value
	 */
	public void setCrehqcode (java.lang.String crehqcode) {
		this.crehqcode = crehqcode;
	}



	/**
	 * Return the value associated with the column: OPERCODE
	 */
	public java.lang.String getOpercode () {
		return opercode;
	}

	/**
	 * Set the value related to the column: OPERCODE
	 * @param opercode the OPERCODE value
	 */
	public void setOpercode (java.lang.String opercode) {
		this.opercode = opercode;
	}


	public java.util.Date getCrtTm() {
		return crtTm;
	}

	public void setCrtTm(java.util.Date crtTm) {
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof resource.bean.report.BopCfaCreditorDs)) return false;
		else {
			resource.bean.report.BopCfaCreditorDs bopCfaCreditorDs = (resource.bean.report.BopCfaCreditorDs) obj;
			if (null == this.getId() || null == bopCfaCreditorDs.getId()) return false;
			else return (this.getId().equals(bopCfaCreditorDs.getId()));
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