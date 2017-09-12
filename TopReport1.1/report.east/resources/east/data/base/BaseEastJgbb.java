/**
 * 
 */
package resources.east.data.base;

import java.io.Serializable;

/**
 * @author ThinkPad
 *
 */
public class BaseEastJgbb implements Serializable {

	/**
	 * 
	 */
	private int hashCode = Integer.MIN_VALUE;
	private String id;
	private String eastTableName;
	private String ftlPath;

	public BaseEastJgbb () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseEastJgbb (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}

	/** full constructor */
	public BaseEastJgbb(String id, String eastTableName, String ftlPath) {
		this.setId(id);
		this.eastTableName = eastTableName;
		this.ftlPath = ftlPath;
	}

	public String getEastTableName() {
		return this.eastTableName;
	}

	public void setEastTableName(String eastTableName) {
		this.eastTableName = eastTableName;
	}

	public String getFtlPath() {
		return this.ftlPath;
	}

	public void setFtlPath(String ftlPath) {
		this.ftlPath = ftlPath;
	}

	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof resources.east.data.pub.EastJgbb)) return false;
		else {
			resources.east.data.pub.EastJgbb eastJgbb = (resources.east.data.pub.EastJgbb) obj;
			if (null == this.getId() || null == eastJgbb.getId()) return false;
			else return (this.getId().equals(eastJgbb.getId()));
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}

}
