package resource.bean.pub.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the GLOBALINFO table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="GLOBALINFO"
 */

public abstract class BaseSystemBszq  implements Serializable {

	// constructors
	public BaseSystemBszq () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseSystemBszq (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;
	
	private java.lang.String systemName;
	private java.lang.String bszq;



	


	public java.lang.String getId() {
		return id;
	}

	public void setId(java.lang.String id) {
		this.id = id;
	}

	public java.lang.String getSystemName() {
		return systemName;
	}

	public void setSystemName(java.lang.String systemName) {
		this.systemName = systemName;
	}

	public java.lang.String getBszq() {
		return bszq;
	}

	public void setBszq(java.lang.String bszq) {
		this.bszq = bszq;
	}

	public String toString () {
		return super.toString();
	}


}