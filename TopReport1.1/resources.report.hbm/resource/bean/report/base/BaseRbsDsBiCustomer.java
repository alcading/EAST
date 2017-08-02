package resource.bean.report.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the RBS_DS_BI_CUSTOMER table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="RBS_DS_BI_CUSTOMER"
 */

public abstract class BaseRbsDsBiCustomer  implements Serializable {

	public static String REF = "RbsDsBiCustomer";
	public static String PROP_PARTYSTATUS = "partystatus";
	public static String PROP_PARTYTYPE = "partytype";
	public static String PROP_RISKCOUNTRY = "riskcountry";
	public static String PROP_PARTYNUMBER = "partynumber";
	public static String PROP_OPENDATE = "opendate";
	public static String PROP_NATIONALITY = "nationality";
	public static String PROP_BRANCHCODE = "branchcode";
	public static String PROP_PARTYNAMEINLOCAL = "partynameinlocal";
	public static String PROP_CLOSEDATE = "closedate";
	public static String PROP_IDCARDNUMBER = "idcardnumber";
	public static String PROP_RESIDENTIALCOUNTRY = "residentialcountry";
	public static String PROP_PARTYNAME = "partyname";
	public static String PROP_WORKDATE = "workdate";
	public static String PROP_ID = "id";


	// constructors
	public BaseRbsDsBiCustomer () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseRbsDsBiCustomer (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseRbsDsBiCustomer (
		java.lang.String id,
		java.lang.String branchcode,
		java.lang.String partynumber) {

		this.setId(id);
		this.setBranchcode(branchcode);
		this.setPartynumber(partynumber);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;

	// fields
	private java.lang.String branchcode;
	private java.lang.String partynumber;
	private java.lang.String partystatus;
	private java.lang.String opendate;
	private java.lang.String closedate;
	private java.lang.String partytype;
	private java.lang.String partyname;
	private java.lang.String partynameinlocal;
	private java.lang.String nationality;
	private java.lang.String residentialcountry;
	private java.lang.String riskcountry;
	private java.lang.String idcardnumber;
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
	 * Return the value associated with the column: PARTYSTATUS
	 */
	public java.lang.String getPartystatus () {
		return partystatus;
	}

	/**
	 * Set the value related to the column: PARTYSTATUS
	 * @param partystatus the PARTYSTATUS value
	 */
	public void setPartystatus (java.lang.String partystatus) {
		this.partystatus = partystatus;
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
	 * Return the value associated with the column: PARTYTYPE
	 */
	public java.lang.String getPartytype () {
		return partytype;
	}

	/**
	 * Set the value related to the column: PARTYTYPE
	 * @param partytype the PARTYTYPE value
	 */
	public void setPartytype (java.lang.String partytype) {
		this.partytype = partytype;
	}



	/**
	 * Return the value associated with the column: PARTYNAME
	 */
	public java.lang.String getPartyname () {
		return partyname;
	}

	/**
	 * Set the value related to the column: PARTYNAME
	 * @param partyname the PARTYNAME value
	 */
	public void setPartyname (java.lang.String partyname) {
		this.partyname = partyname;
	}



	/**
	 * Return the value associated with the column: PARTYNAMEINLOCAL
	 */
	public java.lang.String getPartynameinlocal () {
		return partynameinlocal;
	}

	/**
	 * Set the value related to the column: PARTYNAMEINLOCAL
	 * @param partynameinlocallanguage the PARTYNAMEINLOCAL value
	 */
	public void setPartynameinlocal (java.lang.String partynameinlocal) {
		this.partynameinlocal = partynameinlocal;
	}



	/**
	 * Return the value associated with the column: NATIONALITY
	 */
	public java.lang.String getNationality () {
		return nationality;
	}

	/**
	 * Set the value related to the column: NATIONALITY
	 * @param nationality the NATIONALITY value
	 */
	public void setNationality (java.lang.String nationality) {
		this.nationality = nationality;
	}



	/**
	 * Return the value associated with the column: RESIDENTIALCOUNTRY
	 */
	public java.lang.String getResidentialcountry () {
		return residentialcountry;
	}

	/**
	 * Set the value related to the column: RESIDENTIALCOUNTRY
	 * @param residentialcountry the RESIDENTIALCOUNTRY value
	 */
	public void setResidentialcountry (java.lang.String residentialcountry) {
		this.residentialcountry = residentialcountry;
	}



	/**
	 * Return the value associated with the column: RISKCOUNTRY
	 */
	public java.lang.String getRiskcountry () {
		return riskcountry;
	}

	/**
	 * Set the value related to the column: RISKCOUNTRY
	 * @param riskcountry the RISKCOUNTRY value
	 */
	public void setRiskcountry (java.lang.String riskcountry) {
		this.riskcountry = riskcountry;
	}



	/**
	 * Return the value associated with the column: IDCARDNUMBER
	 */
	public java.lang.String getIdcardnumber () {
		return idcardnumber;
	}

	/**
	 * Set the value related to the column: IDCARDNUMBER
	 * @param idcardnumber the IDCARDNUMBER value
	 */
	public void setIdcardnumber (java.lang.String idcardnumber) {
		this.idcardnumber = idcardnumber;
	}

	public java.lang.String getWorkdate() {
		return workdate;
	}

	public void setWorkdate(java.lang.String workdate) {
		this.workdate = workdate;
	}


	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof resource.bean.report.RbsDsBiCustomer)) return false;
		else {
			resource.bean.report.RbsDsBiCustomer rbsDsBiCustomer = (resource.bean.report.RbsDsBiCustomer) obj;
			if (null == this.getId() || null == rbsDsBiCustomer.getId()) return false;
			else return (this.getId().equals(rbsDsBiCustomer.getId()));
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