package resources.east.data.base;

import java.io.Serializable;

import resources.east.data.pub.EastGrkhgxxxPK;

public class BaseEastGrkhgxxx implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7897173337433530607L;
	private EastGrkhgxxxPK id;
	private String yxjgdm;
	private String jrxkzh;
	private String nbjgh;
	private String dygrkhtybh;
	private String shgx;
	private String dygrkhxm;
	private String dygrkhgzdwmc;
	private String dygrkhgzdwdz;
	private String dygrkhgzdwdh;

	public BaseEastGrkhgxxx() {
	}

	public BaseEastGrkhgxxx(EastGrkhgxxxPK id) {
		this.setId(id);
	}

	public EastGrkhgxxxPK getId() {
		return id;
	}

	public void setId(EastGrkhgxxxPK id) {
		this.id = id;
	}

	public String getYxjgdm() {
		return yxjgdm;
	}

	public void setYxjgdm(String yxjgdm) {
		this.yxjgdm = yxjgdm;
	}

	public String getJrxkzh() {
		return jrxkzh;
	}

	public void setJrxkzh(String jrxkzh) {
		this.jrxkzh = jrxkzh;
	}

	public String getNbjgh() {
		return nbjgh;
	}

	public void setNbjgh(String nbjgh) {
		this.nbjgh = nbjgh;
	}

	public String getDygrkhtybh() {
		return dygrkhtybh;
	}

	public void setDygrkhtybh(String dygrkhtybh) {
		this.dygrkhtybh = dygrkhtybh;
	}

	public String getShgx() {
		return shgx;
	}

	public void setShgx(String shgx) {
		this.shgx = shgx;
	}

	public String getDygrkhxm() {
		return dygrkhxm;
	}

	public void setDygrkhxm(String dygrkhxm) {
		this.dygrkhxm = dygrkhxm;
	}

	public String getDygrkhgzdwmc() {
		return dygrkhgzdwmc;
	}

	public void setDygrkhgzdwmc(String dygrkhgzdwmc) {
		this.dygrkhgzdwmc = dygrkhgzdwmc;
	}

	public String getDygrkhgzdwdz() {
		return dygrkhgzdwdz;
	}

	public void setDygrkhgzdwdz(String dygrkhgzdwdz) {
		this.dygrkhgzdwdz = dygrkhgzdwdz;
	}

	public String getDygrkhgzdwdh() {
		return dygrkhgzdwdh;
	}

	public void setDygrkhgzdwdh(String dygrkhgzdwdh) {
		this.dygrkhgzdwdh = dygrkhgzdwdh;
	}

}
