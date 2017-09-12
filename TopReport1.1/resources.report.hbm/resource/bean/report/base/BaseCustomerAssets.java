package resource.bean.report.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the customer_assets table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="customer_assets"
 */

public abstract class BaseCustomerAssets  implements Serializable {

	public static String REF = "CustomerAssets";
	public static String PROP_LIVEOUTAMT = "liveoutamt";
	public static String PROP_INAMT = "inamt";
	public static String PROP_OUTAMT = "outamt";
	public static String PROP_LIVEINAMT = "liveinamt";
	public static String PROP_STILLINAMT = "stillinamt";
	public static String PROP_ID = "id";
	public static String PROP_STILLOUTAMT = "stilloutamt";


	// constructors
	public BaseCustomerAssets () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseCustomerAssets (resource.bean.report.CustomerAssetsPK id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private resource.bean.report.CustomerAssetsPK id;

	// fields
	private java.math.BigDecimal inamt;
	private java.math.BigDecimal liveinamt;
	private java.math.BigDecimal liveoutamt;
	private java.math.BigDecimal outamt;
	private java.math.BigDecimal stillinamt;
	private java.math.BigDecimal stilloutamt;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     */
	public resource.bean.report.CustomerAssetsPK getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (resource.bean.report.CustomerAssetsPK id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: inamt
	 */
	public java.math.BigDecimal getInamt () {
		return inamt;
	}

	/**
	 * Set the value related to the column: inamt
	 * @param inamt the inamt value
	 */
	public void setInamt (java.math.BigDecimal inamt) {
		this.inamt = inamt;
	}



	/**
	 * Return the value associated with the column: liveinamt
	 */
	public java.math.BigDecimal getLiveinamt () {
		return liveinamt;
	}

	/**
	 * Set the value related to the column: liveinamt
	 * @param liveinamt the liveinamt value
	 */
	public void setLiveinamt (java.math.BigDecimal liveinamt) {
		this.liveinamt = liveinamt;
	}



	/**
	 * Return the value associated with the column: liveoutamt
	 */
	public java.math.BigDecimal getLiveoutamt () {
		return liveoutamt;
	}

	/**
	 * Set the value related to the column: liveoutamt
	 * @param liveoutamt the liveoutamt value
	 */
	public void setLiveoutamt (java.math.BigDecimal liveoutamt) {
		this.liveoutamt = liveoutamt;
	}



	/**
	 * Return the value associated with the column: outamt
	 */
	public java.math.BigDecimal getOutamt () {
		return outamt;
	}

	/**
	 * Set the value related to the column: outamt
	 * @param outamt the outamt value
	 */
	public void setOutamt (java.math.BigDecimal outamt) {
		this.outamt = outamt;
	}



	/**
	 * Return the value associated with the column: stillinamt
	 */
	public java.math.BigDecimal getStillinamt () {
		return stillinamt;
	}

	/**
	 * Set the value related to the column: stillinamt
	 * @param stillinamt the stillinamt value
	 */
	public void setStillinamt (java.math.BigDecimal stillinamt) {
		this.stillinamt = stillinamt;
	}



	/**
	 * Return the value associated with the column: stilloutamt
	 */
	public java.math.BigDecimal getStilloutamt () {
		return stilloutamt;
	}

	/**
	 * Set the value related to the column: stilloutamt
	 * @param stilloutamt the stilloutamt value
	 */
	public void setStilloutamt (java.math.BigDecimal stilloutamt) {
		this.stilloutamt = stilloutamt;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof resource.bean.report.CustomerAssets)) return false;
		else {
			resource.bean.report.CustomerAssets customerAssets = (resource.bean.report.CustomerAssets) obj;
			if (null == this.getId() || null == customerAssets.getId()) return false;
			else return (this.getId().equals(customerAssets.getId()));
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