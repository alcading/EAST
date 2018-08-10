package resources.finstandard.data.pub;

import java.math.BigDecimal;

import resources.finstandard.data.base.BaseDepositBalance;

public class DepositBalance extends BaseDepositBalance {
	private static final long serialVersionUID = 1L;

	public DepositBalance() {
		super();
	}

	public DepositBalance(String jrjgbm, String khlx, String cplb, String ckbz, BigDecimal ckye, String llsfgd) {
		super(jrjgbm, khlx, cplb, ckbz, ckye, llsfgd);
	}
}
