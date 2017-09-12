package resource.bean.report.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the SUB_FILE_CONF table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="SUB_FILE_CONF"
 */

public abstract class BaseSubFileConf  implements Serializable {

	public static String REF = "SubFileConf";
	public static String PROP_XML_FILE_ID = "xmlFileId";
	public static String PROP_EXEC_SEQ = "execSeq";
	public static String PROP_ID = "id";
	public static String PROP_FILE_RESULT_PATH = "fileResultPath";
	public static String PROP_BUSI_PK_STR = "busiPkStr";
	public static String PROP_PK_SPLIT = "pkSplit";
	public static String PROP_DATA_VALID_PATH = "dataValidPath";
	public static String PROP_CONF_IS_CONTROL = "confIsControl";
	// constructors
	public BaseSubFileConf () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseSubFileConf (resource.bean.report.SubFileConfPK id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private resource.bean.report.SubFileConfPK id;

	// fields
	private java.lang.String xmlFileId;
	private java.lang.String fileResultPath;
	private java.lang.Integer execSeq;
	private java.lang.String busiPkStr;
	private java.lang.String pkSplit;
	private java.lang.String dataValidPath;
	private java.lang.String confIsControl;
	

	public java.lang.String getConfIsControl() {
		return confIsControl;
	}

	public void setConfIsControl(java.lang.String confIsControl) {
		this.confIsControl = confIsControl;
	}

	public java.lang.String getDataValidPath() {
		return dataValidPath;
	}

	public void setDataValidPath(java.lang.String dataValidPath) {
		this.dataValidPath = dataValidPath;
	}

	public java.lang.String getPkSplit() {
		return pkSplit;
	}

	public void setPkSplit(java.lang.String pkSplit) {
		this.pkSplit = pkSplit;
	}

	public java.lang.String getBusiPkStr() {
		return busiPkStr;
	}

	public void setBusiPkStr(java.lang.String busiPkStr) {
		this.busiPkStr = busiPkStr;
	}

	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     */
	public resource.bean.report.SubFileConfPK getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (resource.bean.report.SubFileConfPK id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: XML_FILE_ID
	 */
	public java.lang.String getXmlFileId () {
		return xmlFileId;
	}

	/**
	 * Set the value related to the column: XML_FILE_ID
	 * @param xmlFileId the XML_FILE_ID value
	 */
	public void setXmlFileId (java.lang.String xmlFileId) {
		this.xmlFileId = xmlFileId;
	}



	/**
	 * Return the value associated with the column: FILE_RESULT_PATH
	 */
	public java.lang.String getFileResultPath () {
		return fileResultPath;
	}

	/**
	 * Set the value related to the column: FILE_RESULT_PATH
	 * @param fileResultPath the FILE_RESULT_PATH value
	 */
	public void setFileResultPath (java.lang.String fileResultPath) {
		this.fileResultPath = fileResultPath;
	}



	/**
	 * Return the value associated with the column: EXEC_SEQ
	 */
	public java.lang.Integer getExecSeq () {
		return execSeq;
	}

	/**
	 * Set the value related to the column: EXEC_SEQ
	 * @param execSeq the EXEC_SEQ value
	 */
	public void setExecSeq (java.lang.Integer execSeq) {
		this.execSeq = execSeq;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof resource.bean.report.SubFileConf)) return false;
		else {
			resource.bean.report.SubFileConf subFileConf = (resource.bean.report.SubFileConf) obj;
			if (null == this.getId() || null == subFileConf.getId()) return false;
			else return (this.getId().equals(subFileConf.getId()));
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