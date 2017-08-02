package com.huateng.report.vaild.impl;

import resource.bean.report.BopCfaDofoexloDs;

import com.huateng.report.vaild.absbean.AbsReportDataVaild;

public class ReportCfaCBVaild extends AbsReportDataVaild {

	@Override
	public String executeDataVaild( Object obj) {
		BopCfaDofoexloDs ds = (BopCfaDofoexloDs) obj;
		StringBuffer result = new StringBuffer();
		/*result.append(this.lessLen(ds.getBename(), 128, "受益人名称"));
		result.append(this.lessLen(ds.getBencode(),32,"受益人代码"));
		result.append(this.valLenByNotNull(ds.getActiontype(),2, "操作类型"));*/
		/*result.append(this.lessLen(ds.getActiontype(), 1, "操作类型"));
		result.append(this.isDelRemarkVaild(ds.getActiontype(), ds.getActiondesc()));
		result.append(this.isAmount22_2(ds.getMaindebtamount(), "主债务金额"));
		result.append(this.isAmount22_2(ds.getGuaranamount(), "保函金额"));
		result.append(this.lessLenNull(ds.getRemark(), 256, "备注"));
		result.append(this.optionOne(ds.getBename(), ds.getBenamen(), "中文名称和英文名称"));
		result.append(this.optionOne(ds.getGuappname(), ds.getGuappnamen(), "中文名称和英文名称"));*/
		/*result.append(this.isAmount22_2(ds.getBasere(), "担保责任余额"));
		result.append(this.isDelRemarkVaild(ds.getActiontype(), ds.getActiondesc()));
		result.append(this.lessLen(ds.getExguarancode(),28,"对外担保编号"));
		result.append(this.lessLenNull(ds.getRemark(), 256, "备注"));
		result.append(this.lessLenNull(ds.getComplianceno(), 4, "履约编号"));
		result.append(this.valLenByNotNull(ds.getGuarantorcode(), 12, "担保人代码"));
		result.append(this.lessLen(ds.getBuscode(),32,"银行业务参号"));
		result.append(this.optionOne(ds.getBename(), ds.getBenamen(), "中文名称和英文名称"));
		result.append(this.dateLessCheckDateOrEqual(ds.getGuperdate(),ds.getContractdate(),"履约日期","签约日期"));
		result.append(this.isAmount22_2(ds.getGuperamount(), "履约金额"));
		result.append(this.isAmount22_2(ds.getPguperamount(), "购汇履约金额"));*/
		result.append(this.isDelRemarkVaild(ds.getActiontype(), ds.getActiondesc()));
		result.append(this.lessLen(ds.getDofoexlocode(),28,"国内外汇贷款编号"));
		result.append(this.lessLenNull(ds.getBuscode(), 32, "银行业务参号"));
		result.append(this.lessLenNull(ds.getActiondesc(), 4, "变动编号"));
		result.append(this.isAmount22_2(ds.getLoanopenbalan(),"期末余额"));
		result.append(this.dateLessCheckDate(ds.getValuedate(),ds.getChangedate(),  "起息日", "变动日期"));
		result.append(this.notZeroNotNull(ds.getWithamount(),ds.getWithcurrence(),"提款币种","提款金额" ));
		result.append(this.isAmountAndZero22_2(ds.getWithamount(), "提款金额"));
		result.append(this.isAmountAndZero22_2(ds.getSettamount(), "结汇金额"));
		result.append(this.notZeroNotNull2(ds.getWithamount(),ds.getSettamount(),ds.getWithcurrence(),"提款币种","提款金额" ,"结汇金额"));
		result.append(this.notZeroNotNull(ds.getWithamount(),ds.getPrincurr(),"还本币种","还本金额" ));
		//付息
		result.append(this.isAmountAndZero22_2(ds.getInpayamount(), "付息金额"));
		result.append(this.isAmountAndZero22_2(ds.getPrepayamount(), "购汇付息金额"));
		
		
		result.append(this.isAmountAndZero22_2(ds.getPrepayamount(), "购汇还本金额"));
		result.append(this.isAmountAndZero22_2(ds.getRepayamount(), "还本金额"));
		result.append(this.isAmountAndPare22_2(ds.getPrepayamount(), ds.getRepayamount(), "还本金额", "购汇还本金额"));
		result.append(this.isAmountAndPare22_2(ds.getPinpayamount(), ds.getInpayamount(), "付息金额", "购汇付息金额"));
		
		result.append(this.isAmount22_2(ds.getEndbalan(),"期末余额"));
		result.append(this.lessLenNull(ds.getRemark(), 256, "备注"));
		result.append(this.exbuiSeNumVaild(ds.getApptype(),ds.getCurrentfile(),ds.getFiller2(),ds.getBrNo()));
		return result.toString();
	}

	

}
