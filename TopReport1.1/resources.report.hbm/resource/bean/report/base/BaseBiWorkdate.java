package resource.bean.report.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the BI_WORKDATE table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="BI_WORKDATE"
 */

public abstract class BaseBiWorkdate  implements Serializable {

	public static String REF = "BiWorkdate";
	public static String PROP_OPERATOR_ID = "operatorId";
	public static String PROP_WORK_FLAG = "workFlag";
	public static String PROP_ID = "id";
	public static String PROP_FILLER1 = "filler1";
	public static String PROP_FILLER3 = "filler3";
	public static String PROP_FILLER2 = "filler2";


	// constructors
	public BaseBiWorkdate () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBiWorkdate (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;

	// fields
	private java.lang.Integer workFlag;
	private java.lang.String operatorId;
	private java.lang.String filler1;
	private java.lang.String filler2;
	private java.lang.String filler3;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  column="WORK_DATE"
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
	 * Return the value associated with the column: WORK_FLAG
	 */
	public java.lang.Integer getWorkFlag () {
		return workFlag;
	}

	/**
	 * Set the value related to the column: WORK_FLAG
	 * @param workFlag the WORK_FLAG value
	 */
	public void setWorkFlag (java.lang.Integer workFlag) {
		this.workFlag = workFlag;
	}



	/**
	 * Return the value associated with the column: OPERATOR_ID
	 */
	public java.lang.String getOperatorId () {
		return operatorId;
	}

	/**
	 * Set the value related to the column: OPERATOR_ID
	 * @param operatorId the OPERATOR_ID value
	 */
	public void setOperatorId (java.lang.String operatorId) {
		this.operatorId = operatorId;
	}



	/**
	 * Return the value associated with the column: FILLER1
	 */
	public java.lang.String getFiller1 () {
		return filler1;
	}

	/**
	 * Set the value related to the column: FILLER1
	 * @param filler1 the FILLER1 value
	 */
	public void setFiller1 (java.lang.String filler1) {
		this.filler1 = filler1;
	}



	/**
	 * Return the value associated with the column: FILLER2
	 */
	public java.lang.String getFiller2 () {
		return filler2;
	}

	/**
	 * Set the value related to the column: FILLER2
	 * @param filler2 the FILLER2 value
	 */
	public void setFiller2 (java.lang.String filler2) {
		this.filler2 = filler2;
	}



	/**
	 * Return the value associated with the column: FILLER3
	 */
	public java.lang.String getFiller3 () {
		return filler3;
	}

	/**
	 * Set the value related to the column: FILLER3
	 * @param filler3 the FILLER3 value
	 */
	public void setFiller3 (java.lang.String filler3) {
		this.filler3 = filler3;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof resource.bean.report.BiWorkdate)) return false;
		else {
			resource.bean.report.BiWorkdate biWorkdate = (resource.bean.report.BiWorkdate) obj;
			if (null == this.getId() || null == biWorkdate.getId()) return false;
			else return (this.getId().equals(biWorkdate.getId()));
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