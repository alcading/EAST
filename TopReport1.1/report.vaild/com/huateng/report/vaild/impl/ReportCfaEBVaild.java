package com.huateng.report.vaild.impl;

import resource.bean.report.BopCfaExplrmbloDs;

import com.huateng.report.vaild.absbean.AbsReportDataVaild;

public class ReportCfaEBVaild extends AbsReportDataVaild {

	@Override
	public String executeDataVaild(Object obj) {
		// TODO Auto-generated method stub
		BopCfaExplrmbloDs eb = (BopCfaExplrmbloDs) obj;
		StringBuffer result = new StringBuffer();
		// 操作类型 不为空
		result.append(this.isEmpty(eb.getActiontype(), "操作类型"));

		// 删除原因
		result.append(this.isDelRemarkVaild(eb.getActiontype(),
				eb.getActiondesc()));

		// EXPLRMBLONO 外汇质押人民币贷款编号
		result.append(this.valLenByNotNull(eb.getExplrmblono(), 28,
				"外汇质押人民币贷款编号"));
		result.append(this.exbuiSeNumVaild(eb.getApptype(),
				eb.getCurrentfile(), eb.getFiller2(), eb.getBrNo()));

		// BUOCMONTH 必填项，格式为YYYYMM 报告期
		result.append(this.checkDateFormat(eb.getBuocmonth(), "yyyyMM", "报告期"));

		// CHANGENO 变动编号 必填项
		result.append(this.isEmpty(eb.getChangeno(), "变动编号"));

		// MONBELOADBAL 月初贷款余额 必填项，大于等于0
		result.append(this.isAmountAndZero22_2(eb.getMonbeloadbal(), "月初贷款余额"));

		// CREDWITHAMOUNT 本月提款金额 必填项，大于等于0
		result.append(this.isAmountAndZero22_2(eb.getCredwithamount(), "本月提款金额"));

		// CREDREPAYAMOUNT 本月还本金额 必填项，大于等于0
		result.append(this.isAmountAndZero22_2(eb.getCredrepayamount(),
				"本月还本金额"));

		// PICAMOUNT 本月付息费金额 必填项，大于等于0
		result.append(this.isAmountAndZero22_2(eb.getPicamount(), "本月付息费金额"));

		// MONENLOADBAL 月末贷款余额 必填项，大于等于0
		result.append(this.isAmountAndZero22_2(eb.getMonenloadbal(), "月末贷款余额"));

		if (eb.getExplbalainfos() != null) {

			for (int i = 0; i < eb.getExplbalainfos().size(); i++) {

				// EXPLBALA 质押外汇余额 必填项，大于等于0
				result.append(this.isAmountAndZero22_2(eb.getExplbalainfos()
						.get(i).getExplbala(), "质押外汇余额"));

				// EXPLPERAMOUNT 质押外汇履约金额 必填项，大于等于0
				result.append(this.isAmountAndZero22_2(eb.getExplbalainfos()
						.get(i).getExplperamount(), "质押外汇履约金额"));

				// PLCOSEAMOUNT 质押履约结汇金额 必填项，大于等于0
				result.append(this.isAmountAndZero22_2(eb.getExplbalainfos()
						.get(i).getPlcoseamount(), "质押履约结汇金额"));
			}
		}

		return result.toString();
	}

}
