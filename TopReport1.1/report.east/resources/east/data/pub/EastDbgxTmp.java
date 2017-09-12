package resources.east.data.pub;

import java.math.BigDecimal;

import resources.east.data.base.BaseEastDbgxTmp;

/**
 * EastDbgx entity. @author MyEclipse Persistence Tools
 */
public class EastDbgxTmp extends BaseEastDbgxTmp implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public EastDbgxTmp() {
	}

	/** minimal constructor */
	public EastDbgxTmp(EastDbgxId id) {
		super(id);
	}

	/** full constructor */
	public EastDbgxTmp(EastDbgxId id, String yxjgdm, String jrxkzh, String nbjgh, String dblx, BigDecimal dbje, String dbqsrq,
			String dbdqrq, String dbzt, String jldbygh,String errmsg) {
		super(id, yxjgdm, jrxkzh, nbjgh, dblx, dbje, dbqsrq, dbdqrq, dbzt, jldbygh,errmsg);
	}

}
