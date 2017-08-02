package resource.bean.report.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the TLR_MAN_REL table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="TLR_MAN_REL"
 */

public abstract class BaseTlrManRel  implements Serializable {

	public static String REF = "TlrManRel";
	public static String PROP_TIMESTAMPS = "timestamps";
	public static String PROP_STATUS = "status";
	public static String PROP_MANAGE = "manage";
	public static String PROP_MISC2 = "misc2";
	public static String PROP_TLR_ID = "tlrId";
	public static String PROP_MISC1 = "misc1";
	public static String PROP_ID = "id";


	// constructors
	public BaseTlrManRel () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseTlrManRel (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String manage;
	private java.lang.String tlrId;
	private java.lang.String status;
	private java.util.Date timestamps;
	private java.lang.String misc1;
	private java.lang.String misc2;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="ID"
     */
	public java.lang.Integer getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (java.lang.Integer id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: Manage
	 */
	public java.lang.String getManage () {
		return manage;
	}

	/**
	 * Set the value related to the column: Manage
	 * @param manage the Manage value
	 */
	public void setManage (java.lang.String manage) {
		this.manage = manage;
	}



	/**
	 * Return the value associated with the column: TLR_ID
	 */
	public java.lang.String getTlrId () {
		return tlrId;
	}

	/**
	 * Set the value related to the column: TLR_ID
	 * @param tlrId the TLR_ID value
	 */
	public void setTlrId (java.lang.String tlrId) {
		this.tlrId = tlrId;
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
	 * Return the value associated with the column: timestamps
	 */
	public java.util.Date getTimestamps () {
		return timestamps;
	}

	/**
	 * Set the value related to the column: timestamps
	 * @param timestamps the timestamps value
	 */
	public void setTimestamps (java.util.Date timestamps) {
		this.timestamps = timestamps;
	}



	/**
	 * Return the value associated with the column: misc1
	 */
	public java.lang.String getMisc1 () {
		return misc1;
	}

	/**
	 * Set the value related to the column: misc1
	 * @param misc1 the misc1 value
	 */
	public void setMisc1 (java.lang.String misc1) {
		this.misc1 = misc1;
	}



	/**
	 * Return the value associated with the column: misc2
	 */
	public java.lang.String getMisc2 () {
		return misc2;
	}

	/**
	 * Set the value related to the column: misc2
	 * @param misc2 the misc2 value
	 */
	public void setMisc2 (java.lang.String misc2) {
		this.misc2 = misc2;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof resource.bean.report.TlrManRel)) return false;
		else {
			resource.bean.report.TlrManRel tlrManRel = (resource.bean.report.TlrManRel) obj;
			if (null == this.getId() || null == tlrManRel.getId()) return false;
			else return (this.getId().equals(tlrManRel.getId()));
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