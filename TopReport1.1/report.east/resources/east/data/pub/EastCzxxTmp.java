package resources.east.data.pub;

import resources.east.data.base.BaseEastCzxxTmp;

/**
 * EastCzxxTmp entity. @author MyEclipse Persistence Tools
 */
public class EastCzxxTmp extends BaseEastCzxxTmp implements java.io.Serializable {

	// Constructors

	/**
	 * 
	 */
	private static final long serialVersionUID = -2706219516978970536L;

	/** default constructor */
	public EastCzxxTmp() {
	}

	/** minimal constructor */
	public EastCzxxTmp(EastCzxxTmpId id) {
		super(id);
	}

	/** full constructor */
	public EastCzxxTmp(EastCzxxTmpId id, String hqckzh, String khtybh, String yxjgdm, String jrxkzh, String nbjgh,
			String zjlb, String zjhm, String czlx, String czzt, String ygbz, String qyrq, String qygyh, String errmsg) {
		super(id, hqckzh, khtybh, yxjgdm, jrxkzh, nbjgh, zjlb, zjhm, czlx, czzt, ygbz, qyrq, qygyh, errmsg);
	}

}
