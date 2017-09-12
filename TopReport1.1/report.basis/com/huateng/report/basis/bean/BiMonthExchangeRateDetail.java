package com.huateng.report.basis.bean;

import resource.bean.report.BiMonthexchangerate;

/**
 * 
 * author  by  计翔 2012.9.5
 * 月币新旧信息的对比的bean
 */
public class BiMonthExchangeRateDetail {
	private BiMonthexchangerate   old_bimonthexchangerate;
	private BiMonthexchangerate   bimonthexchangerate;
	public BiMonthexchangerate getOld_bimonthexchangerate() {
		return old_bimonthexchangerate;
	}
	public void setOld_bimonthexchangerate(
			BiMonthexchangerate oldBimonthexchangerate) {
		old_bimonthexchangerate = oldBimonthexchangerate;
	}
	public BiMonthexchangerate getBimonthexchangerate() {
		return bimonthexchangerate;
	}
	public void setBimonthexchangerate(BiMonthexchangerate bimonthexchangerate) {
		this.bimonthexchangerate = bimonthexchangerate;
	}

}
