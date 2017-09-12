package com.huateng.report.vaild.impl;

import resource.bean.report.BopCfaExguDs;

import com.huateng.report.vaild.absbean.AbsReportDataVaild;

public class ReportCfaBCVaild extends AbsReportDataVaild {

	@Override
	public String executeDataVaild( Object obj) {
		BopCfaExguDs ds = (BopCfaExguDs) obj;
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
		result.append(this.isAmount22_2(ds.getBasere(), "担保责任余额"));
		result.append(this.isDelRemarkVaild(ds.getActiontype(), ds.getActiondesc()));
		result.append(this.lessLen(ds.getExguarancode(),28,"对外担保编号"));
		result.append(this.lessLenNull(ds.getRemark(), 256, "备注"));
		result.append(this.lessLen(ds.getComplianceno(), 4, "履约编号"));
		result.append(this.valLenByNotNull(ds.getGuarantorcode(), 12, "担保人代码"));
		result.append(this.lessLen(ds.getBuscode(),32,"银行业务参号"));
		result.append(this.optionOne(ds.getBename(), ds.getBenamen(), "中文名称和英文名称"));
		result.append(this.dateLessCheckDateOrEqual(ds.getContractdate(),ds.getGuperdate(),"签约日期","履约日期"));
		result.append(this.isAmountAndZero22_2(ds.getGuperamount(), "履约金额"));
		result.append(this.isAmountAndZero22_2(ds.getPguperamount(), "购汇履约金额"));
		result.append(this.isAmountAndPare22_2(ds.getGuperamount(), ds.getGuaranamount(), "履约金额", "保函金额"));
		result.append(this.isAmountAndPare22_2( ds.getGuperamount(),ds.getPguperamount(), "购汇履约金额", "履约金额"));
		ds.getGuarantores();ds.getBeneficiarys();
	//	result.append(this.exguTlrCodeVaild(ds.getBencountrycode(), ds.getBentype(), "受益人代码"));
		/*Iterator it = ds.getBeneficiarys().iterator();
		if(it.hasNext()){
			Beneficiary ben = (Beneficiary)it.next();
			result.append(this.exguTlrCodeVaild(ben.getBencountrycode(), ben.getBentype(), "受益人代码"));
			
		}*/
		result.append(this.exbuiSeNumVaild(ds.getApptype(),ds.getCurrentfile(),ds.getFiller2(),ds.getBrNo()));
		return result.toString();
	}

}
