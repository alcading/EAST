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

public abstract class BaseRbsDsBiMovement  implements Serializable {

	public static String REF = "RbsDsBiMovement";
	public static String PROP_ID = "id";
	public static String PROP_CHANGEDATE = "changedate";
	public static String PROP_CHANGETIME = "changetime";
	public static String PROP_CHANGETYPE = "changetype";
	public static String PROP_CHANGEOBJECT = "changeobject";
	public static String PROP_CHANGEFIELD = "changefield";
	public static String PROP_DATABEFORECHANGE = "databeforechange";
	public static String PROP_DATAAFTERCHANGE = "dataafterchange";
	public static String PROP_ENTRIEDBY = "entriedby";
	public static String PROP_AUTHORIZEDBY = "authorizedby";

	// primary key
	private java.lang.String id;
	// fields
	private java.lang.String changedate;
	private java.lang.String changetime;
	private java.lang.String changetype;
	private java.lang.String changeobject;
	private java.lang.String changefield;
	private java.lang.String databeforechange;
	private java.lang.String dataafterchange;
	private java.lang.String entriedby;
	private java.lang.String authorizedby;




	// constructors
	public BaseRbsDsBiMovement () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseRbsDsBiMovement (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseRbsDsBiMovement (
		java.lang.String id,
		java.lang.String changedate,
		java.lang.String changetime) {

		this.setId(id);
		this.setChangedate(changedate);
		this.setChangetime(changetime);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;




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


	public java.lang.String getChangedate() {
		return changedate;
	}

	public void setChangedate(java.lang.String changedate) {
		this.changedate = changedate;
	}

	public java.lang.String getChangetime() {
		return changetime;
	}

	public void setChangetime(java.lang.String changetime) {
		this.changetime = changetime;
	}

	public java.lang.String getChangetype() {
		return changetype;
	}

	public void setChangetype(java.lang.String changetype) {
		this.changetype = changetype;
	}

	public java.lang.String getChangeobject() {
		return changeobject;
	}

	public void setChangeobject(java.lang.String changeobject) {
		this.changeobject = changeobject;
	}

	public java.lang.String getChangefield() {
		return changefield;
	}

	public void setChangefield(java.lang.String changefield) {
		this.changefield = changefield;
	}

	public java.lang.String getDatabeforechange() {
		return databeforechange;
	}

	public void setDatabeforechange(java.lang.String databeforechange) {
		this.databeforechange = databeforechange;
	}

	public java.lang.String getDataafterchange() {
		return dataafterchange;
	}

	public void setDataafterchange(java.lang.String dataafterchange) {
		this.dataafterchange = dataafterchange;
	}

	public java.lang.String getEntriedby() {
		return entriedby;
	}

	public void setEntriedby(java.lang.String entriedby) {
		this.entriedby = entriedby;
	}

	public java.lang.String getAuthorizedby() {
		return authorizedby;
	}

	public void setAuthorizedby(java.lang.String authorizedby) {
		this.authorizedby = authorizedby;
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