package resource.bean.pub.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the DATA_DIC table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="DATA_DIC"
 */

public abstract class BaseDataDic  implements Serializable {

	public static String REF = "DataDic";
	public static String PROP_HIGH_LIMIT = "highLimit";
	public static String PROP_EFFECT_DATE = "effectDate";
	public static String PROP_DATA_NAME = "dataName";
	public static String PROP_MISCFLGS = "miscflgs";
	public static String PROP_DATA_TYPE_NO = "dataTypeNo";
	public static String PROP_DATA_TYPE_NAME = "dataTypeName";
	public static String PROP_LOW_LIMIT = "lowLimit";
	public static String PROP_EXPIRE_DATE = "expireDate";
	public static String PROP_TIMESTAMPS = "timestamps";
	public static String PROP_ID = "id";
	public static String PROP_LIMIT_FLAG = "limitFlag";
	public static String PROP_DATA_NO = "dataNo";
	public static String PROP_DATA_NO_LEN = "dataNoLen";


	// constructors
	public BaseDataDic () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseDataDic (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseDataDic (
		java.lang.Integer id,
		java.lang.Integer dataTypeNo,
		java.lang.String dataNo) {

		this.setId(id);
		this.setDataTypeNo(dataTypeNo);
		this.setDataNo(dataNo);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer dataTypeNo;
	private java.lang.String dataNo;
	private java.lang.String dataTypeName;
	private java.lang.Integer dataNoLen;
	private java.lang.String dataName;
	private java.lang.String limitFlag;
	private java.lang.String highLimit;
	private java.lang.String lowLimit;
	private java.util.Date effectDate;
	private java.util.Date expireDate;
	private java.sql.Timestamp timestamps;
	private java.lang.String miscflgs;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
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
	 * Return the value associated with the column: DATA_TYPE_NO
	 */
	public java.lang.Integer getDataTypeNo () {
		return dataTypeNo;
	}

	/**
	 * Set the value related to the column: DATA_TYPE_NO
	 * @param dataTypeNo the DATA_TYPE_NO value
	 */
	public void setDataTypeNo (java.lang.Integer dataTypeNo) {
		this.dataTypeNo = dataTypeNo;
	}



	/**
	 * Return the value associated with the column: DATA_NO
	 */
	public java.lang.String getDataNo () {
		return dataNo;
	}

	/**
	 * Set the value related to the column: DATA_NO
	 * @param dataNo the DATA_NO value
	 */
	public void setDataNo (java.lang.String dataNo) {
		this.dataNo = dataNo;
	}



	/**
	 * Return the value associated with the column: DATA_TYPE_NAME
	 */
	public java.lang.String getDataTypeName () {
		return dataTypeName;
	}

	/**
	 * Set the value related to the column: DATA_TYPE_NAME
	 * @param dataTypeName the DATA_TYPE_NAME value
	 */
	public void setDataTypeName (java.lang.String dataTypeName) {
		this.dataTypeName = dataTypeName;
	}



	/**
	 * Return the value associated with the column: DATA_NO_LEN
	 */
	public java.lang.Integer getDataNoLen () {
		return dataNoLen;
	}

	/**
	 * Set the value related to the column: DATA_NO_LEN
	 * @param dataNoLen the DATA_NO_LEN value
	 */
	public void setDataNoLen (java.lang.Integer dataNoLen) {
		this.dataNoLen = dataNoLen;
	}



	/**
	 * Return the value associated with the column: DATA_NAME
	 */
	public java.lang.String getDataName () {
		return dataName;
	}

	/**
	 * Set the value related to the column: DATA_NAME
	 * @param dataName the DATA_NAME value
	 */
	public void setDataName (java.lang.String dataName) {
		this.dataName = dataName;
	}



	/**
	 * Return the value associated with the column: LIMIT_FLAG
	 */
	public java.lang.String getLimitFlag () {
		return limitFlag;
	}

	/**
	 * Set the value related to the column: LIMIT_FLAG
	 * @param limitFlag the LIMIT_FLAG value
	 */
	public void setLimitFlag (java.lang.String limitFlag) {
		this.limitFlag = limitFlag;
	}



	/**
	 * Return the value associated with the column: HIGH_LIMIT
	 */
	public java.lang.String getHighLimit () {
		return highLimit;
	}

	/**
	 * Set the value related to the column: HIGH_LIMIT
	 * @param highLimit the HIGH_LIMIT value
	 */
	public void setHighLimit (java.lang.String highLimit) {
		this.highLimit = highLimit;
	}



	/**
	 * Return the value associated with the column: LOW_LIMIT
	 */
	public java.lang.String getLowLimit () {
		return lowLimit;
	}

	/**
	 * Set the value related to the column: LOW_LIMIT
	 * @param lowLimit the LOW_LIMIT value
	 */
	public void setLowLimit (java.lang.String lowLimit) {
		this.lowLimit = lowLimit;
	}



	/**
	 * Return the value associated with the column: EFFECT_DATE
	 */
	public java.util.Date getEffectDate () {
		return effectDate;
	}

	/**
	 * Set the value related to the column: EFFECT_DATE
	 * @param effectDate the EFFECT_DATE value
	 */
	public void setEffectDate (java.util.Date effectDate) {
		this.effectDate = effectDate;
	}



	/**
	 * Return the value associated with the column: EXPIRE_DATE
	 */
	public java.util.Date getExpireDate () {
		return expireDate;
	}

	/**
	 * Set the value related to the column: EXPIRE_DATE
	 * @param expireDate the EXPIRE_DATE value
	 */
	public void setExpireDate (java.util.Date expireDate) {
		this.expireDate = expireDate;
	}



	/**
	 * Return the value associated with the column: TIMESTAMPS
	 */
	public java.sql.Timestamp getTimestamps () {
		return timestamps;
	}

	/**
	 * Set the value related to the column: TIMESTAMPS
	 * @param timestamps the TIMESTAMPS value
	 */
	public void setTimestamps (java.sql.Timestamp timestamps) {
		this.timestamps = timestamps;
	}



	/**
	 * Return the value associated with the column: MISCFLGS
	 */
	public java.lang.String getMiscflgs () {
		return miscflgs;
	}

	/**
	 * Set the value related to the column: MISCFLGS
	 * @param miscflgs the MISCFLGS value
	 */
	public void setMiscflgs (java.lang.String miscflgs) {
		this.miscflgs = miscflgs;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof resource.bean.pub.DataDic)) return false;
		else {
			resource.bean.pub.DataDic dataDic = (resource.bean.pub.DataDic) obj;
			if (null == this.getId() || null == dataDic.getId()) return false;
			else return (this.getId().equals(dataDic.getId()));
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