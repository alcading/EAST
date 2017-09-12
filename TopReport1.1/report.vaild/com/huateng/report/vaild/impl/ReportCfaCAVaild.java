package com.huateng.report.vaild.impl;

import resource.bean.report.BopCfaDofoexloDs;

import com.huateng.report.vaild.absbean.AbsReportDataVaild;

public class ReportCfaCAVaild extends AbsReportDataVaild {

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
		result.append(this.lessLen(ds.getCreditorcode(),12,"债权人代码"));
		result.append(this.lessLen(ds.getDebtorcode(),9,"债务人代码"));
		result.append(this.lessLen(ds.getDebtorname(),128,"债务人中文名称"));
		result.append(this.lessLen(ds.getDofoexlotype(),4,"国内外汇贷款类型"));
		result.append(this.lenproName(ds.getLenproname(), ds.getDofoexlotype(),"转贷项目名称"));
		result.append(this.lenproName(ds.getLenagree(), ds.getDofoexlotype(),"转贷协议号"));
		result.append(this.dateLessCheckDateOrEqual(ds.getValuedate(),ds.getMaturity(),"起息日","到期日"));
		result.append(this.isAmountAndZero22_2(ds.getContractamount(), "签约金额"));
		result.append(this.isRates13_8(ds.getAnninrate(), "年化利率值"));
		result.append(this.lessLenNull(ds.getRemark(), 256, "备注"));
		result.append(this.exbuiSeNumVaild(ds.getApptype(),ds.getCurrentfile(),ds.getFiller2(),ds.getBrNo()));
		return result.toString();
	}
	/**
	 * 当国内外汇贷款类型为“外债转贷款”时为必填
	 *
	 * @param val
	 * @param errField
	 * @return
	 */
	public String lenproName(String val, String errField,String errStr) {
		StringBuffer result = new StringBuffer();
		if(val==null || val.length()==0){
			if(errField=="13"){
				result.append( "当国内外汇贷款类型为“外债转贷款”时"+errStr+"为必填");
			}
		}
		return result.toString();
	}

}
