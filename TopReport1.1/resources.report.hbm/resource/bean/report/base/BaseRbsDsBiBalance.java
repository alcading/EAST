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

public abstract class BaseRbsDsBiBalance  implements Serializable {

	public static String REF = "RbsDsBiBalance";
	
	public static String PROP_BRANCHCODE = "branchcode";
	public static String PROP_PARTYNUMBER = "partynumber";
	public static String PROP_CURRENCYCODE = "currencycode";
	public static String PROP_TOTALDTBAL = "totaldtbal";
	public static String PROP_TOTALCRBAL = "totalcrbal";
	public static String PROP_VALUEBAL = "valuebal";
	public static String PROP_DEALDATE = "dealdate";
	public static String PROP_ID = "id";
	public static String PROP_WORKDATE="workdate";

	// constructors
	public BaseRbsDsBiBalance () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseRbsDsBiBalance (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseRbsDsBiBalance (
		java.lang.String id,
		java.lang.String branchcode,
		java.lang.String partynumber,
		java.lang.String currencycode) {

		this.setId(id);
		this.setBranchcode(branchcode);
		this.setPartynumber(partynumber);
		this.setCurrencycode(currencycode);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;

	// fields
	private java.lang.String branchcode;
	
	private java.lang.String partynumber;
	private java.lang.String currencycode;
	
	private java.math.BigDecimal totaldtbal;
	private java.math.BigDecimal totalcrbal;
	private java.math.BigDecimal valuebal;
	private java.lang.String dealdate;
	private java.lang.String workdate;


	
	
	public java.lang.String getWorkdate() {
		return workdate;
	}

	public void setWorkdate(java.lang.String workdate) {
		this.workdate = workdate;
	}

	public int getHashCode() {
		return hashCode;
	}

	public void setHashCode(int hashCode) {
		this.hashCode = hashCode;
	}

	public java.lang.String getId() {
		return id;
	}

	public void setId(java.lang.String id) {
		this.id = id;
	}

	public java.lang.String getBranchcode() {
		return branchcode;
	}

	public void setBranchcode(java.lang.String branchcode) {
		this.branchcode = branchcode;
	}

	public java.lang.String getPartynumber() {
		return partynumber;
	}

	public void setPartynumber(java.lang.String partynumber) {
		this.partynumber = partynumber;
	}

	public java.lang.String getCurrencycode() {
		return currencycode;
	}

	public void setCurrencycode(java.lang.String currencycode) {
		this.currencycode = currencycode;
	}

	public java.math.BigDecimal getTotaldtbal() {
		return totaldtbal;
	}

	public void setTotaldtbal(java.math.BigDecimal totaldtbal) {
		this.totaldtbal = totaldtbal;
	}

	public java.math.BigDecimal getTotalcrbal() {
		return totalcrbal;
	}

	public void setTotalcrbal(java.math.BigDecimal totalcrbal) {
		this.totalcrbal = totalcrbal;
	}

	public java.math.BigDecimal getValuebal() {
		return valuebal;
	}

	public void setValuebal(java.math.BigDecimal valuebal) {
		this.valuebal = valuebal;
	}

	public java.lang.String getDealdate() {
		return dealdate;
	}

	public void setDealdate(java.lang.String dealdate) {
		this.dealdate = dealdate;
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