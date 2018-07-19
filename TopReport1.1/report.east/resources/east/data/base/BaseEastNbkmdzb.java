package resources.east.data.base;

import java.io.Serializable;

import resources.east.data.pub.EastNbkmdzb;
import resources.east.data.pub.EastNbkmdzbPK;

public class BaseEastNbkmdzb implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7897173337433530607L;
	private EastNbkmdzbPK id;
	private String kmmc;
	private String kjkmjc;
	private String sjkmbh;
	private String sjkmmc;
	private String gsywdl;
	private String gsywzl;

	private int hashCode = Integer.MIN_VALUE;

	/** default constructor */
	public BaseEastNbkmdzb() {
	}

	public BaseEastNbkmdzb(EastNbkmdzbPK id) {
		this.setId(id);
	}

	public String getKmmc() {
		return kmmc;
	}

	public void setKmmc(String kmmc) {
		this.kmmc = kmmc;
	}

	public String getKjkmjc() {
		return kjkmjc;
	}

	public void setKjkmjc(String kjkmjc) {
		this.kjkmjc = kjkmjc;
	}

	public String getSjkmbh() {
		return sjkmbh;
	}

	public void setSjkmbh(String sjkmbh) {
		this.sjkmbh = sjkmbh;
	}

	public String getSjkmmc() {
		return sjkmmc;
	}

	public void setSjkmmc(String sjkmmc) {
		this.sjkmmc = sjkmmc;
	}

	public String getGsywdl() {
		return gsywdl;
	}

	public void setGsywdl(String gsywdl) {
		this.gsywdl = gsywdl;
	}

	public int getHashCode() {
		return hashCode;
	}

	public void setHashCode(int hashCode) {
		this.hashCode = hashCode;
	}

	public String getGsywzl() {
		return gsywzl;
	}

	public void setGsywzl(String gsywzl) {
		this.gsywzl = gsywzl;
	}

	public EastNbkmdzbPK getId() {
		return id;
	}

	public void setId(EastNbkmdzbPK id) {
		this.id = id;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof EastNbkmdzb))
			return false;
		else {
			EastNbkmdzb eastNbkmdzb = (EastNbkmdzb) obj;
			if (null == this.getId() || null == eastNbkmdzb.getId())
				return false;
			else
				return (this.getId().equals(eastNbkmdzb.getId()));
		}
	}

	public int hashCode() {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId())
				return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}

}
