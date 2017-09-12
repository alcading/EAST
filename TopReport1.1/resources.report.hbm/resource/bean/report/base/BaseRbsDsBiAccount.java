package resource.bean.report.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the RBS_DS_BI_ACCOUNT table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="RBS_DS_BI_ACCOUNT"
 */

public abstract class BaseRbsDsBiAccount  implements Serializable {

	public static String REF = "RbsDsBiAccount";
	public static String PROP_CURRENCYCODE = "currencycode";
	public static String PROP_REFERENCENUMBER = "referencenumber";
	public static String PROP_ACCOUNTCATA = "accountcata";
	public static String PROP_REFERENCENAME = "referencename";
	public static String PROP_PARTYBRANCHCODE = "partybranchcode";
	public static String PROP_LOCALEXTENTION = "localextention";
	public static String PROP_PARTYNUMBER = "partynumber";
	public static String PROP_ACCOUNTSTAT = "accountstat";
	public static String PROP_OPENDATE = "opendate";
	public static String PROP_ACCOUNTNUMBER = "accountnumber";
	public static String PROP_BOOKBLANACE = "bookblanace";
	public static String PROP_BRANCHCODE = "branchcode";
	public static String PROP_ACCOUNTTYPE = "accounttype";
	public static String PROP_PRODUCTCODE = "productcode";
	public static String PROP_LIMITTYPE = "limittype";
	public static String PROP_ACCOUNTSTATUS = "accountstatus";
	public static String PROP_CLOSEDATE = "closedate";
	public static String PROP_ID = "id";
	public static String PROP_BOPBRANCHCODE = "bopbranchcode";
	public static String PROP_VALUEBALANCE = "valuebalance";
	public static String PROP_CREDITCARDNUMBER = "creditcardnumber";
	public static String PROP_WORKDATE = "workdate";


	// constructors
	public BaseRbsDsBiAccount () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseRbsDsBiAccount (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseRbsDsBiAccount (
		java.lang.String id,
		java.lang.String branchcode,
		java.lang.String accountnumber,
		java.lang.String currencycode) {

		this.setId(id);
		this.setBranchcode(branchcode);
		this.setAccountnumber(accountnumber);
		this.setCurrencycode(currencycode);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;

	// fields
	private java.lang.String branchcode;
	private java.lang.String accountnumber;
	private java.lang.String currencycode;
	private java.lang.String accountstatus;
	private java.lang.String opendate;
	private java.lang.String closedate;
	private java.lang.String productcode;
	private java.lang.String accounttype;
	private java.lang.String partybranchcode;
	private java.lang.String partynumber;
	private java.math.BigDecimal bookblanace;
	private java.math.BigDecimal valuebalance;
	private java.lang.String referencenumber;
	private java.lang.String referencename;
	private java.lang.String creditcardnumber;
	private java.math.BigDecimal localextention;
	private java.lang.String bopbranchcode;
	private java.lang.String limittype;
	private java.lang.String accountstat;
	private java.lang.String accountcata;
	private java.lang.String workdate;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="ID"
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
	 * Return the value associated with the column: BRANCHCODE
	 */
	public java.lang.String getBranchcode () {
		return branchcode;
	}

	/**
	 * Set the value related to the column: BRANCHCODE
	 * @param branchcode the BRANCHCODE value
	 */
	public void setBranchcode (java.lang.String branchcode) {
		this.branchcode = branchcode;
	}



	/**
	 * Return the value associated with the column: ACCOUNTNUMBER
	 */
	public java.lang.String getAccountnumber () {
		return accountnumber;
	}

	/**
	 * Set the value related to the column: ACCOUNTNUMBER
	 * @param accountnumber the ACCOUNTNUMBER value
	 */
	public void setAccountnumber (java.lang.String accountnumber) {
		this.accountnumber = accountnumber;
	}



	/**
	 * Return the value associated with the column: CURRENCYCODE
	 */
	public java.lang.String getCurrencycode () {
		return currencycode;
	}

	/**
	 * Set the value related to the column: CURRENCYCODE
	 * @param currencycode the CURRENCYCODE value
	 */
	public void setCurrencycode (java.lang.String currencycode) {
		this.currencycode = currencycode;
	}



	/**
	 * Return the value associated with the column: ACCOUNTSTATUS
	 */
	public java.lang.String getAccountstatus () {
		return accountstatus;
	}

	/**
	 * Set the value related to the column: ACCOUNTSTATUS
	 * @param accountstatus the ACCOUNTSTATUS value
	 */
	public void setAccountstatus (java.lang.String accountstatus) {
		this.accountstatus = accountstatus;
	}



	/**
	 * Return the value associated with the column: OPENDATE
	 */
	public java.lang.String getOpendate () {
		return opendate;
	}

	/**
	 * Set the value related to the column: OPENDATE
	 * @param opendate the OPENDATE value
	 */
	public void setOpendate (java.lang.String opendate) {
		this.opendate = opendate;
	}



	/**
	 * Return the value associated with the column: CLOSEDATE
	 */
	public java.lang.String getClosedate () {
		return closedate;
	}

	/**
	 * Set the value related to the column: CLOSEDATE
	 * @param closedate the CLOSEDATE value
	 */
	public void setClosedate (java.lang.String closedate) {
		this.closedate = closedate;
	}



	/**
	 * Return the value associated with the column: PRODUCTCODE
	 */
	public java.lang.String getProductcode () {
		return productcode;
	}

	/**
	 * Set the value related to the column: PRODUCTCODE
	 * @param productcode the PRODUCTCODE value
	 */
	public void setProductcode (java.lang.String productcode) {
		this.productcode = productcode;
	}



	/**
	 * Return the value associated with the column: ACCOUNTTYPE
	 */
	public java.lang.String getAccounttype () {
		return accounttype;
	}

	/**
	 * Set the value related to the column: ACCOUNTTYPE
	 * @param accounttype the ACCOUNTTYPE value
	 */
	public void setAccounttype (java.lang.String accounttype) {
		this.accounttype = accounttype;
	}



	/**
	 * Return the value associated with the column: PARTYBRANCHCODE
	 */
	public java.lang.String getPartybranchcode () {
		return partybranchcode;
	}

	/**
	 * Set the value related to the column: PARTYBRANCHCODE
	 * @param partybranchcode the PARTYBRANCHCODE value
	 */
	public void setPartybranchcode (java.lang.String partybranchcode) {
		this.partybranchcode = partybranchcode;
	}



	/**
	 * Return the value associated with the column: PARTYNUMBER
	 */
	public java.lang.String getPartynumber () {
		return partynumber;
	}

	/**
	 * Set the value related to the column: PARTYNUMBER
	 * @param partynumber the PARTYNUMBER value
	 */
	public void setPartynumber (java.lang.String partynumber) {
		this.partynumber = partynumber;
	}



	/**
	 * Return the value associated with the column: BOOKBLANACE
	 */
	public java.math.BigDecimal getBookblanace () {
		return bookblanace;
	}

	/**
	 * Set the value related to the column: BOOKBLANACE
	 * @param bookblanace the BOOKBLANACE value
	 */
	public void setBookblanace (java.math.BigDecimal bookblanace) {
		this.bookblanace = bookblanace;
	}



	/**
	 * Return the value associated with the column: VALUEBALANCE
	 */
	public java.math.BigDecimal getValuebalance () {
		return valuebalance;
	}

	/**
	 * Set the value related to the column: VALUEBALANCE
	 * @param valuebalance the VALUEBALANCE value
	 */
	public void setValuebalance (java.math.BigDecimal valuebalance) {
		this.valuebalance = valuebalance;
	}



	/**
	 * Return the value associated with the column: REFERENCENUMBER
	 */
	public java.lang.String getReferencenumber () {
		return referencenumber;
	}

	/**
	 * Set the value related to the column: REFERENCENUMBER
	 * @param referencenumber the REFERENCENUMBER value
	 */
	public void setReferencenumber (java.lang.String referencenumber) {
		this.referencenumber = referencenumber;
	}



	/**
	 * Return the value associated with the column: REFERENCENAME
	 */
	public java.lang.String getReferencename () {
		return referencename;
	}

	/**
	 * Set the value related to the column: REFERENCENAME
	 * @param referencename the REFERENCENAME value
	 */
	public void setReferencename (java.lang.String referencename) {
		this.referencename = referencename;
	}



	/**
	 * Return the value associated with the column: CREDITCARDNUMBER
	 */
	public java.lang.String getCreditcardnumber () {
		return creditcardnumber;
	}

	/**
	 * Set the value related to the column: CREDITCARDNUMBER
	 * @param creditcardnumber the CREDITCARDNUMBER value
	 */
	public void setCreditcardnumber (java.lang.String creditcardnumber) {
		this.creditcardnumber = creditcardnumber;
	}



	/**
	 * Return the value associated with the column: LOCALEXTENTION
	 */
	public java.math.BigDecimal getLocalextention () {
		return localextention;
	}

	/**
	 * Set the value related to the column: LOCALEXTENTION
	 * @param localextention the LOCALEXTENTION value
	 */
	public void setLocalextention (java.math.BigDecimal localextention) {
		this.localextention = localextention;
	}



	/**
	 * Return the value associated with the column: BOPBRANCHCODE
	 */
	public java.lang.String getBopbranchcode () {
		return bopbranchcode;
	}

	/**
	 * Set the value related to the column: BOPBRANCHCODE
	 * @param bopbranchcode the BOPBRANCHCODE value
	 */
	public void setBopbranchcode (java.lang.String bopbranchcode) {
		this.bopbranchcode = bopbranchcode;
	}



	/**
	 * Return the value associated with the column: LIMITTYPE
	 */
	public java.lang.String getLimittype () {
		return limittype;
	}

	/**
	 * Set the value related to the column: LIMITTYPE
	 * @param limittype the LIMITTYPE value
	 */
	public void setLimittype (java.lang.String limittype) {
		this.limittype = limittype;
	}



	/**
	 * Return the value associated with the column: ACCOUNTSTAT
	 */
	public java.lang.String getAccountstat () {
		return accountstat;
	}

	/**
	 * Set the value related to the column: ACCOUNTSTAT
	 * @param accountstat the ACCOUNTSTAT value
	 */
	public void setAccountstat (java.lang.String accountstat) {
		this.accountstat = accountstat;
	}



	/**
	 * Return the value associated with the column: ACCOUNTCATA
	 */
	public java.lang.String getAccountcata () {
		return accountcata;
	}

	/**
	 * Set the value related to the column: ACCOUNTCATA
	 * @param accountcata the ACCOUNTCATA value
	 */
	public void setAccountcata (java.lang.String accountcata) {
		this.accountcata = accountcata;
	}

	public java.lang.String getWorkdate() {
		return workdate;
	}

	public void setWorkdate(java.lang.String workdate) {
		this.workdate = workdate;
	}

	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof resource.bean.report.RbsDsBiAccount)) return false;
		else {
			resource.bean.report.RbsDsBiAccount rbsDsBiAccount = (resource.bean.report.RbsDsBiAccount) obj;
			if (null == this.getId() || null == rbsDsBiAccount.getId()) return false;
			else return (this.getId().equals(rbsDsBiAccount.getId()));
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