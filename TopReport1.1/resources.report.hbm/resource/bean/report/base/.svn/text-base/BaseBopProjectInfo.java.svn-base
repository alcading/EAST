package resource.bean.report.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the BOP_PROJECT_INFO table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="BOP_PROJECT_INFO"
 */

public abstract class BaseBopProjectInfo  implements Serializable {

	public static String REF = "BopProjectInfo";
	public static String PROP_PROJECTNAME = "projectname";
	public static String PROP_ID = "id";
	public static String PROP_CRT_TM = "crtTm";
	public static String PROP_REC_ID = "recId";


	// constructors
	public BaseBopProjectInfo () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBopProjectInfo (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;

	// fields
	private java.lang.String projectname;
	private java.lang.String recId;
	private java.util.Date crtTm;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  column="PROJ_ID"
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
	 * Return the value associated with the column: PROJECTNAME
	 */
	public java.lang.String getProjectname () {
		return projectname;
	}

	/**
	 * Set the value related to the column: PROJECTNAME
	 * @param projectname the PROJECTNAME value
	 */
	public void setProjectname (java.lang.String projectname) {
		this.projectname = projectname;
	}



	/**
	 * Return the value associated with the column: REC_ID
	 */
	public java.lang.String getRecId () {
		return recId;
	}

	/**
	 * Set the value related to the column: REC_ID
	 * @param recId the REC_ID value
	 */
	public void setRecId (java.lang.String recId) {
		this.recId = recId;
	}


	public java.util.Date getCrtTm() {
		return crtTm;
	}

	public void setCrtTm(java.util.Date crtTm) {
		this.crtTm = crtTm;
	}

	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof resource.bean.report.BopProjectInfo)) return false;
		else {
			resource.bean.report.BopProjectInfo bopProjectInfo = (resource.bean.report.BopProjectInfo) obj;
			if (null == this.getId() || null == bopProjectInfo.getId()) return false;
			else return (this.getId().equals(bopProjectInfo.getId()));
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