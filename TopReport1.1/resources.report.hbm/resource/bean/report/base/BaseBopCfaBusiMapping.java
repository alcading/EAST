package resource.bean.report.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the BOP_CFA_BUSI_MAPPING table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="BOP_CFA_BUSI_MAPPING"
 */

public abstract class BaseBopCfaBusiMapping  implements Serializable {

	public static String REF = "BopCfaBusiMapping";
	public static String PROP_EXP3 = "exp3";
	public static String PROP_EXP2 = "exp2";
	public static String PROP_EXP1 = "exp1";
	public static String PROP_ID = "id";
	public static String PROP_BUSI_CODE = "busiCode";
	public static String PROP_OTHER_MAPPING = "otherMapping";


	// constructors
	public BaseBopCfaBusiMapping () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBopCfaBusiMapping (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;

	// fields
	private java.lang.String busiCode;
	private java.lang.String otherMapping;
	private java.lang.String exp1;
	private java.lang.String exp2;
	private java.lang.String exp3;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  column="FILE_TYPE"
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
	 * Return the value associated with the column: BUSI_CODE
	 */
	public java.lang.String getBusiCode () {
		return busiCode;
	}

	/**
	 * Set the value related to the column: BUSI_CODE
	 * @param busiCode the BUSI_CODE value
	 */
	public void setBusiCode (java.lang.String busiCode) {
		this.busiCode = busiCode;
	}



	/**
	 * Return the value associated with the column: OTHER_MAPPING
	 */
	public java.lang.String getOtherMapping () {
		return otherMapping;
	}

	/**
	 * Set the value related to the column: OTHER_MAPPING
	 * @param otherMapping the OTHER_MAPPING value
	 */
	public void setOtherMapping (java.lang.String otherMapping) {
		this.otherMapping = otherMapping;
	}



	/**
	 * Return the value associated with the column: EXP_1
	 */
	public java.lang.String getExp1 () {
		return exp1;
	}

	/**
	 * Set the value related to the column: EXP_1
	 * @param exp1 the EXP_1 value
	 */
	public void setExp1 (java.lang.String exp1) {
		this.exp1 = exp1;
	}



	/**
	 * Return the value associated with the column: EXP_2
	 */
	public java.lang.String getExp2 () {
		return exp2;
	}

	/**
	 * Set the value related to the column: EXP_2
	 * @param exp2 the EXP_2 value
	 */
	public void setExp2 (java.lang.String exp2) {
		this.exp2 = exp2;
	}



	/**
	 * Return the value associated with the column: EXP_3
	 */
	public java.lang.String getExp3 () {
		return exp3;
	}

	/**
	 * Set the value related to the column: EXP_3
	 * @param exp3 the EXP_3 value
	 */
	public void setExp3 (java.lang.String exp3) {
		this.exp3 = exp3;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof resource.bean.report.BopCfaBusiMapping)) return false;
		else {
			resource.bean.report.BopCfaBusiMapping bopCfaBusiMapping = (resource.bean.report.BopCfaBusiMapping) obj;
			if (null == this.getId() || null == bopCfaBusiMapping.getId()) return false;
			else return (this.getId().equals(bopCfaBusiMapping.getId()));
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