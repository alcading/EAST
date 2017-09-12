package com.huateng.report.vaild.impl;

import java.math.BigDecimal;

import resource.bean.report.BopCfaStrdeDs;

import com.huateng.report.vaild.absbean.AbsReportDataVaild;

public class ReportCfaFDValid extends AbsReportDataVaild {

	@Override
	public String executeDataVaild(Object obj) {
		// TODO Auto-generated method stub
		StringBuffer result = new StringBuffer();
		BopCfaStrdeDs bopCfaStrdeDs = (BopCfaStrdeDs)obj;
		//0.业务流水号
		result.append(this.exbuiSeNumVaild(bopCfaStrdeDs.getApptype(), bopCfaStrdeDs.getCurrentfile(), 
				bopCfaStrdeDs.getFiller2(), bopCfaStrdeDs.getBrNo()));
		//1.必填项，	操作类型
		result.append(checkActiontype(bopCfaStrdeDs.getActiontype()));
		//2.如果ACTIONTYPE字段值为D，则此字段为必填字段。	删除原因
		result.append(this.isDelRemarkVaild(bopCfaStrdeDs.getActiontype(), bopCfaStrdeDs.getActiondesc()));
		//3.必填项，金融机构标识码。
		result.append(this.valLenByNotNull(bopCfaStrdeDs.getBrNo(), 12, "金融机构标识码"));
		//4.必填项，格式为YYYYMM。
		result.append(AbsReportDataVaild.checkDateFormat(bopCfaStrdeDs.getBuocmonth(), "yyyyMM", "报告期"));
		//5.必填项，默认美元。	币种
		result.append(this.valLenByNotNull(bopCfaStrdeDs.getCurrency(), 3, "币种"));
		//6.非必填项，大于等于0。汇出、汇入、购汇、结汇金额折美元至少填一个。	本月汇出金额折美元
		result.append(this.isAmount22_2(bopCfaStrdeDs.getMoexamusd(), "本月汇出金额折美元"));
		result.append(atLeastOne(bopCfaStrdeDs));
		//7.非必填项，大于等于0。本月汇入金额折美元
		result.append(this.isAmount22_2(bopCfaStrdeDs.getMoamreusd(), "本月汇入金额折美元"));
		//8.非必填项，大于等于0。本月购汇金额折美元
		result.append(this.isAmount22_2(bopCfaStrdeDs.getMopfexamusd(), "本月购汇金额折美元"));
		//9.非必填项，大于等于0。本月结汇金额折美元
		result.append(this.isAmount22_2(bopCfaStrdeDs.getMosettamusd(), "本月结汇金额折美元"));
		//10.备注
		result.append(this.lessLenNull(bopCfaStrdeDs.getRemark(), 256, "备注"));
		return result.toString();
	}
	
	/*
	 * 汇出、汇入、购汇、结汇金额折美元至少填一个
	 */
	public String atLeastOne(BopCfaStrdeDs bopCfaStrdeDs) {
		StringBuffer buff = new StringBuffer();
		BigDecimal moexamusd = bopCfaStrdeDs.getMoexamusd();
		BigDecimal moamreusd = bopCfaStrdeDs.getMoamreusd();
		BigDecimal mopfexamusd = bopCfaStrdeDs.getMopfexamusd();
		BigDecimal mosettamusd = bopCfaStrdeDs.getMosettamusd();
		if(moexamusd == null && moamreusd == null && mopfexamusd == null && mosettamusd == null) {
			buff.append("汇出、汇入、购汇、结汇金额折美元至少填一个!");
		}
		return buff.toString();
	}
}
