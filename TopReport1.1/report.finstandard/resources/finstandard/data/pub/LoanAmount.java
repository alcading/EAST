package resources.finstandard.data.pub;

import java.math.BigDecimal;
import java.util.Date;

import resources.finstandard.data.base.BaseLoanAmount;

public class LoanAmount extends BaseLoanAmount {
	private static final long serialVersionUID = 1L;

	public LoanAmount() {
		super();
	}

	/**
	 * Constructor for required fields
	 */
	public LoanAmount(String jrjgbm, String khlx, String jkrbm, String dkzthylx, String dkjjbh, String cplb,
			Date dkffrq, Date dkdqrq, String dkbz, BigDecimal dkfsje, String llsfgd, BigDecimal llsp, String dkdbfs,
			String dkzt, String dkffshbz) {
		super(jrjgbm, khlx, jkrbm, dkzthylx, dkjjbh, cplb, dkffrq, dkdqrq, dkbz, dkfsje, llsfgd, llsp, dkdbfs, dkzt,
				dkffshbz);
	}

}
