package resources.east.data.base;

import java.io.Serializable;

import resources.east.data.pub.EastZzhjqkmb;
import resources.east.data.pub.EastZzhjqkmbPK;

public class BaseEastZzhjqkmb implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7897173337433530607L;
	private EastZzhjqkmbPK id;
	private String yhjgdm;
	private String jrxkzh;
	private String yhjgmc;
	private String kmmc;
	private String kmjc;
	private String kmlx;
	private String qcjfye;
	private String qcdfye;
	private String jffse;
	private String dffse;
	private String qmjfye;
	private String qmdfye;

	private int hashCode = Integer.MIN_VALUE;

	/** default constructor */
	public BaseEastZzhjqkmb() {
	}

	public BaseEastZzhjqkmb(EastZzhjqkmbPK id) {
		this.setId(id);
	}

	public String getJrxkzh() {
		return this.jrxkzh;
	}

	public void setJrxkzh(String jrxkzh) {
		this.jrxkzh = jrxkzh;
	}

	public String getYhjgdm() {
		return yhjgdm;
	}

	public void setYhjgdm(String yhjgdm) {
		this.yhjgdm = yhjgdm;
	}

	public String getYhjgmc() {
		return yhjgmc;
	}

	public void setYhjgmc(String yhjgmc) {
		this.yhjgmc = yhjgmc;
	}

	public String getKmmc() {
		return kmmc;
	}

	public void setKmmc(String kmmc) {
		this.kmmc = kmmc;
	}

	public String getKmjc() {
		return kmjc;
	}

	public void setKmjc(String kmjc) {
		this.kmjc = kmjc;
	}

	public String getKmlx() {
		return kmlx;
	}

	public void setKmlx(String kmlx) {
		this.kmlx = kmlx;
	}

	public String getQcjfye() {
		return qcjfye;
	}

	public void setQcjfye(String qcjfye) {
		this.qcjfye = qcjfye;
	}

	public String getQcdfye() {
		return qcdfye;
	}

	public void setQcdfye(String qcdfye) {
		this.qcdfye = qcdfye;
	}

	public String getJffse() {
		return jffse;
	}

	public void setJffse(String jffse) {
		this.jffse = jffse;
	}

	public String getDffse() {
		return dffse;
	}

	public void setDffse(String dffse) {
		this.dffse = dffse;
	}

	public String getQmjfye() {
		return qmjfye;
	}

	public void setQmjfye(String qmjfye) {
		this.qmjfye = qmjfye;
	}

	public String getQmdfye() {
		return qmdfye;
	}

	public void setQmdfye(String qmdfye) {
		this.qmdfye = qmdfye;
	}

	public EastZzhjqkmbPK getId() {
		return id;
	}

	public void setId(EastZzhjqkmbPK id) {
		this.id = id;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof EastZzhjqkmb))
			return false;
		else {
			EastZzhjqkmb eastZzhjqkmb = (EastZzhjqkmb) obj;
			if (null == this.getId() || null == eastZzhjqkmb.getId())
				return false;
			else
				return (this.getId().equals(eastZzhjqkmb.getId()));
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
