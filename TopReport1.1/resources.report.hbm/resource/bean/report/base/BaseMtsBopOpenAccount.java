package resource.bean.report.base;

import java.io.Serializable;

public class BaseMtsBopOpenAccount implements Serializable {

	public static String REF = "BaseMtsBopOpenAccount";
	public static String PROP_ID = "id";
	public static String PROP_BRANCHCODE = "branchcode";
	public static String PROP_CONTACT = "contact";
	public static String PROP_TEL = "tel";
	public static String PROP_FAX = "fax";
	public static String PROP_REC_ID = "recId";

	// constructors
	public BaseMtsBopOpenAccount () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMtsBopOpenAccount (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;
	// primary key
	private java.lang.String id;
	// fields
	private java.lang.String branchcode;
	private java.lang.String contact;
	private java.lang.String tel;
	private java.lang.String fax;
	private java.lang.String recId;


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

	public java.lang.String getContact() {
		return contact;
	}

	public void setContact(java.lang.String contact) {
		this.contact = contact;
	}

	public java.lang.String getTel() {
		return tel;
	}

	public void setTel(java.lang.String tel) {
		this.tel = tel;
	}

	public java.lang.String getFax() {
		return fax;
	}

	public void setFax(java.lang.String fax) {
		this.fax = fax;
	}

	public java.lang.String getRecId() {
		return recId;
	}

	public void setRecId(java.lang.String recId) {
		this.recId = recId;
	}


	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof resource.bean.report.MtsBopFsDs)) return false;
		else {
			resource.bean.report.MtsBopFsDs mtsBopFsDs = (resource.bean.report.MtsBopFsDs) obj;
			if (null == this.getId() || null == mtsBopFsDs.getId()) return false;
			else return (this.getId().equals(mtsBopFsDs.getId()));
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
