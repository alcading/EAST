package resource.bean.report.base;

import java.io.Serializable;

public class BaseMtsBopInvcountrycode implements Serializable {

	public static String REF = "BaseMtsBopInvcountrycode";
	public static String PROP_ID = "id";
	public static String PROP_INVCOUNTRYCODE = "invcountrycode";
	public static String PROP_REC_ID = "recId";

	// constructors
	public BaseMtsBopInvcountrycode () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMtsBopInvcountrycode (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;
	// fields
	private java.lang.String invcountrycode;
	private java.lang.String recId;


	public java.lang.String getId() {
		return id;
	}

	public void setId(java.lang.String id) {
		this.id = id;
	}

	public java.lang.String getInvcountrycode() {
		return invcountrycode;
	}

	public void setInvcountrycode(java.lang.String invcountrycode) {
		this.invcountrycode = invcountrycode;
	}

	public java.lang.String getRecId() {
		return recId;
	}

	public void setRecId(java.lang.String recId) {
		this.recId = recId;
	}

	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof resource.bean.report.MtsBopFsDs)) return false;
		else {
			resource.bean.report.MtsBopFsDs mtsBopFsDs = (resource.bean.report.MtsBopFsDs) obj;
			if (null == this.getId() || null == mtsBopFsDs.getId()) return false;
			else return (this.getId().equals(mtsBopFsDs.getId()));
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
