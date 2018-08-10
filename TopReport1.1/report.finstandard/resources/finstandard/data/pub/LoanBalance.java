package resources.finstandard.data.pub;

import java.math.BigDecimal;
import java.util.Date;

import resources.finstandard.data.base.BaseLoanBalance;

public class LoanBalance extends BaseLoanBalance {

	private static final long serialVersionUID = 1L;

	public LoanBalance(){
		super();
	}
	
	/**
	 * Constructor for required fields
	 */
	public LoanBalance(String jrjgbm, String khlx, String jkrbm, String dkzthylx, String dkjjbh, String cplb,
			Date dkffrq, Date dkdqrq, String dkbz, BigDecimal dkye, String llsfgd, BigDecimal llsp, String dkzbfs,
			String dkzt, String dkzl) {
		super(jrjgbm, khlx, jkrbm, dkzthylx, dkjjbh, cplb, dkffrq, dkdqrq, dkbz, dkye, llsfgd, llsp, dkzbfs, dkzt, dkzl);
	}
}
