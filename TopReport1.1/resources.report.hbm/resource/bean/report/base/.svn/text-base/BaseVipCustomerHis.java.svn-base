package resource.bean.report.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the vip_customer_his table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="vip_customer_his"
 */

public abstract class BaseVipCustomerHis  implements Serializable {

	public static String REF = "VipCustomerHis";
	public static String PROP_DESC2 = "desc2";
	public static String PROP_DESC1 = "desc1";
	public static String PROP_CREATEDT = "createdt";
	public static String PROP_LAST_MONTH_VIP = "lastMonthVip";
	public static String PROP_MONTH_VIP = "monthVip";
	public static String PROP_ID = "id";
	public static String PROP_MISCFLG = "miscflg";
	public static String PROP_LAST_MONTH_CLASS = "lastMonthClass";
	public static String PROP_MONTH_VIP_CLASS = "monthVipClass";


	// constructors
	public BaseVipCustomerHis () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseVipCustomerHis (resource.bean.report.VipCustomerHisPK id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private resource.bean.report.VipCustomerHisPK id;

	// fields
	private java.lang.String monthVip;
	private java.lang.String lastMonthVip;
	private java.lang.String monthVipClass;
	private java.lang.String lastMonthClass;
	private java.util.Date createdt;
	private java.lang.String miscflg;
	private java.lang.String desc1;
	private java.lang.String desc2;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     */
	public resource.bean.report.VipCustomerHisPK getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (resource.bean.report.VipCustomerHisPK id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: month_vip
	 */
	public java.lang.String getMonthVip () {
		return monthVip;
	}

	/**
	 * Set the value related to the column: month_vip
	 * @param monthVip the month_vip value
	 */
	public void setMonthVip (java.lang.String monthVip) {
		this.monthVip = monthVip;
	}



	/**
	 * Return the value associated with the column: last_month_vip
	 */
	public java.lang.String getLastMonthVip () {
		return lastMonthVip;
	}

	/**
	 * Set the value related to the column: last_month_vip
	 * @param lastMonthVip the last_month_vip value
	 */
	public void setLastMonthVip (java.lang.String lastMonthVip) {
		this.lastMonthVip = lastMonthVip;
	}



	/**
	 * Return the value associated with the column: month_vip_class
	 */
	public java.lang.String getMonthVipClass () {
		return monthVipClass;
	}

	/**
	 * Set the value related to the column: month_vip_class
	 * @param monthVipClass the month_vip_class value
	 */
	public void setMonthVipClass (java.lang.String monthVipClass) {
		this.monthVipClass = monthVipClass;
	}



	/**
	 * Return the value associated with the column: last_month_class
	 */
	public java.lang.String getLastMonthClass () {
		return lastMonthClass;
	}

	/**
	 * Set the value related to the column: last_month_class
	 * @param lastMonthClass the last_month_class value
	 */
	public void setLastMonthClass (java.lang.String lastMonthClass) {
		this.lastMonthClass = lastMonthClass;
	}



	/**
	 * Return the value associated with the column: createdt
	 */
	public java.util.Date getCreatedt () {
		return createdt;
	}

	/**
	 * Set the value related to the column: createdt
	 * @param createdt the createdt value
	 */
	public void setCreatedt (java.util.Date createdt) {
		this.createdt = createdt;
	}



	/**
	 * Return the value associated with the column: miscflg
	 */
	public java.lang.String getMiscflg () {
		return miscflg;
	}

	/**
	 * Set the value related to the column: miscflg
	 * @param miscflg the miscflg value
	 */
	public void setMiscflg (java.lang.String miscflg) {
		this.miscflg = miscflg;
	}



	/**
	 * Return the value associated with the column: desc1
	 */
	public java.lang.String getDesc1 () {
		return desc1;
	}

	/**
	 * Set the value related to the column: desc1
	 * @param desc1 the desc1 value
	 */
	public void setDesc1 (java.lang.String desc1) {
		this.desc1 = desc1;
	}



	/**
	 * Return the value associated with the column: desc2
	 */
	public java.lang.String getDesc2 () {
		return desc2;
	}

	/**
	 * Set the value related to the column: desc2
	 * @param desc2 the desc2 value
	 */
	public void setDesc2 (java.lang.String desc2) {
		this.desc2 = desc2;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof resource.bean.report.VipCustomerHis)) return false;
		else {
			resource.bean.report.VipCustomerHis vipCustomerHis = (resource.bean.report.VipCustomerHis) obj;
			if (null == this.getId() || null == vipCustomerHis.getId()) return false;
			else return (this.getId().equals(vipCustomerHis.getId()));
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