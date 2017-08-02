package resource.bean.report.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the RBS_BRANCE_CODE_MAPP table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="RBS_BRANCE_CODE_MAPP"
 */

public abstract class BaseRbsBranchCodeMapp  implements Serializable {

	public static String REF = "RbsBranchCodeMapp";
	public static String PROP_CRT_TLR = "CrtTlr";
	public static String PROP_STATUS = "Status";
	public static String PROP_BRANCHCODE = "Branchcode";
	public static String PROP_BUSI_TYPE = "BusiType";
	public static String PROP_LST_UPD_TLR = "LstUpdTlr";
	public static String PROP_ID = "Id";
	public static String PROP_CRT_TM = "CrtTm";
	public static String PROP_LST_UPD_TM = "LstUpdTm";
	public static String PROP_RBSBRANCHCODE = "Rbsbranchcode";


	// constructors
	public BaseRbsBranchCodeMapp () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseRbsBranchCodeMapp (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;

	// fields
	private java.lang.String rbsbranchcode;
	private java.lang.String busitype;
	private java.lang.String branchcode;
	private java.lang.String status;
	private java.util.Date crtTm;
	private java.lang.String crtTlr;
	private java.util.Date lstUpdTm;
	private java.lang.String lstUpdTlr;


	public java.lang.String getId() {
		return id;
	}

	public void setId(java.lang.String id) {
		this.id = id;
	}


	public java.lang.String getStatus() {
		return status;
	}

	public void setStatus(java.lang.String status) {
		this.status = status;
	}

	public java.util.Date getCrtTm() {
		return crtTm;
	}

	public void setCrtTm(java.util.Date crtTm) {
		this.crtTm = crtTm;
	}

	public java.lang.String getCrtTlr() {
		return crtTlr;
	}

	public void setCrtTlr(java.lang.String crtTlr) {
		this.crtTlr = crtTlr;
	}

	public java.util.Date getLstUpdTm() {
		return lstUpdTm;
	}

	public void setLstUpdTm(java.util.Date lstUpdTm) {
		this.lstUpdTm = lstUpdTm;
	}

	public java.lang.String getLstUpdTlr() {
		return lstUpdTlr;
	}

	public void setLstUpdTlr(java.lang.String lstUpdTlr) {
		this.lstUpdTlr = lstUpdTlr;
	}

	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof resource.bean.report.RbsBranchCodeMapp)) return false;
		else {
			resource.bean.report.RbsBranchCodeMapp rbsBranceCodeMapp = (resource.bean.report.RbsBranchCodeMapp) obj;
			if (null == this.getId() || null == rbsBranceCodeMapp.getId()) return false;
			else return (this.getId().equals(rbsBranceCodeMapp.getId()));
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

	public java.lang.String getRbsbranchcode() {
		return rbsbranchcode;
	}

	public void setRbsbranchcode(java.lang.String rbsbranchcode) {
		this.rbsbranchcode = rbsbranchcode;
	}

	public java.lang.String getBusitype() {
		return busitype;
	}

	public void setBusitype(java.lang.String busitype) {
		this.busitype = busitype;
	}

	public java.lang.String getBranchcode() {
		return branchcode;
	}

	public void setBranchcode(java.lang.String branchcode) {
		this.branchcode = branchcode;
	}

}