package resources.east.data.pub;

import resources.east.data.base.BaseEastCzxx;


/**
 * EastCzxxTmp entity. @author MyEclipse Persistence Tools
 */
public class EastCzxx extends BaseEastCzxx implements java.io.Serializable {

	// Constructors

	/**
	 * 
	 */
	private static final long serialVersionUID = -2706219516978970536L;

	/** default constructor */
	public EastCzxx() {
	}

	/** minimal constructor */
	public EastCzxx(EastCzxxTmpId id) {
		super(id);
	}

	/** full constructor */
	public EastCzxx(EastCzxxTmpId id, String hqckzh, String khtybh, String yxjgdm, String jrxkzh, String nbjgh,
			String zjlb, String zjhm, String czlx, String czzt, String ygbz, String qyrq, String qygyh) {
		super(id, hqckzh, khtybh, yxjgdm, jrxkzh, nbjgh, zjlb, zjhm, czlx, czzt, ygbz, qyrq, qygyh);
	}

}
