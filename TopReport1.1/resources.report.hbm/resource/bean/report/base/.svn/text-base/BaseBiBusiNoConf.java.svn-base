package resource.bean.report.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the BI_BUSI_NO_CONF table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="BI_BUSI_NO_CONF"
 */

public abstract class BaseBiBusiNoConf  implements Serializable {

	public static String REF = "BiBusiNoConf";
	public static String PROP_CONFPATH = "confpath";
	public static String PROP_ID = "id";


	// constructors
	public BaseBiBusiNoConf () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBiBusiNoConf (resource.bean.report.BiBusiNoConfPK id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private resource.bean.report.BiBusiNoConfPK id;

	// fields
	private java.lang.String confpath;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     */
	public resource.bean.report.BiBusiNoConfPK getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (resource.bean.report.BiBusiNoConfPK id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: CONFPATH
	 */
	public java.lang.String getConfpath () {
		return confpath;
	}

	/**
	 * Set the value related to the column: CONFPATH
	 * @param confpath the CONFPATH value
	 */
	public void setConfpath (java.lang.String confpath) {
		this.confpath = confpath;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof resource.bean.report.BiBusiNoConf)) return false;
		else {
			resource.bean.report.BiBusiNoConf biBusiNoConf = (resource.bean.report.BiBusiNoConf) obj;
			if (null == this.getId() || null == biBusiNoConf.getId()) return false;
			else return (this.getId().equals(biBusiNoConf.getId()));
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