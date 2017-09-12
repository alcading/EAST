package com.huateng.report.vaild.impl;

import resource.bean.report.BopCfaExplrmbloDs;

import com.huateng.report.vaild.absbean.AbsReportDataVaild;

public class ReportCfaEAVaild extends AbsReportDataVaild {

	@Override
	public String executeDataVaild(Object obj) {
		// TODO Auto-generated method stub

		BopCfaExplrmbloDs ea = (BopCfaExplrmbloDs) obj;
		StringBuffer result = new StringBuffer();
		// 操作类型 不为空
		result.append(this.isEmpty(ea.getActiontype(), "操作类型"));

		// 删除原因
		result.append(this.isDelRemarkVaild(ea.getActiontype(),
				ea.getActiondesc()));

		// EXPLRMBLONO 外汇质押人民币贷款编号
		result.append(this.valLenByNotNull(ea.getExplrmblono(), 28,
				"外汇质押人民币贷款编号"));
		result.append(this.exbuiSeNumVaild(ea.getApptype(),
				ea.getCurrentfile(), ea.getFiller2(), ea.getBrNo()));

		// CREDITORCODE 债权人代码
		result.append(this.isEmpty(ea.getCreditorcode(), "债权人代码"));

		// 债务人代码
		result.append(this.isEmpty(ea.getDebtorcode(), "债务人代码"));

		// DEBTORNAME 债务人中文名称
		result.append(this.isEmpty(ea.getDebtorname(), "债务人中文名称"));

		// 贷款起息日 VALUEDATE
		result.append(this.checkDateFormat(ea.getValuedate(), "yyyyMMdd",
				"贷款起息日"));

		// CREDCONCURR 贷款签约币种
		result.append(this.isEmpty(ea.getCredconcurr(), "贷款签约币种"));

		// CREDCONAMOUNT 贷款签约金额
		result.append(this.isAmountAndZero22_2(ea.getCredconamount(), "贷款签约金额"));

		// MATURITY 贷款到期日
		result.append(this.dateLessCheckDateOrEqual(ea.getValuedate(),
				ea.getMaturity(), "贷款起息日", "贷款到期日"));
		if (ea.getExplbalainfos() != null) {
			for (int i = 0; i < ea.getExplbalainfos().size(); i++) {
				result.append(this.isEmpty(ea.getExplbalainfos().get(i)
						.getExplcurr(), "质押外汇币种"));
				result.append(this.isAmountAndZero22_2(ea.getExplbalainfos()
						.get(i).getExplamount(), "质押外汇金额"));
			}
		}
		return result.toString();

	}

}
