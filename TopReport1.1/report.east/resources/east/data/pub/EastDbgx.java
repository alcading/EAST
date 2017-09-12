package resources.east.data.pub;

import java.math.BigDecimal;

import resources.east.data.base.BaseEastDbgx;

/**
 * EastDbgx entity. @author MyEclipse Persistence Tools
 */
public class EastDbgx extends BaseEastDbgx implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public EastDbgx() {
	}

	/** minimal constructor */
	public EastDbgx(EastDbgxId id) {
		super(id);
	}

	/** full constructor */
	public EastDbgx(EastDbgxId id, String yxjgdm, String jrxkzh, String nbjgh, String dblx, BigDecimal dbje, String dbqsrq,
			String dbdqrq, String dbzt, String jldbygh) {
		super(id, yxjgdm, jrxkzh, nbjgh, dblx, dbje, dbqsrq, dbdqrq, dbzt, jldbygh);
	}

}
