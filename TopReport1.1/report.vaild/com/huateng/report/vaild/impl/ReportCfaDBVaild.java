package com.huateng.report.vaild.impl;

import org.apache.commons.lang.StringUtils;

import resource.bean.report.BopCfaLounexguDs;

import com.huateng.report.constants.TopReportConstants;
import com.huateng.report.vaild.absbean.AbsReportDataVaild;

public class ReportCfaDBVaild extends AbsReportDataVaild {

	@Override
	public String executeDataVaild(Object obj) {
		// TODO Auto-generated method stub
		BopCfaLounexguDs da = (BopCfaLounexguDs) obj;
		StringBuffer result = new StringBuffer();
		if(!StringUtils.equals(TopReportConstants.REPORT_ACTIONTYPE_D, da.getActiontype())){
			// 操作类型 不为空
			result.append(isEmpty(da.getActiontype(), "操作类型"));
			// 删除原因
			result.append(isDelRemarkVaild(da.getActiontype(),
					da.getActiondesc()));
			result.append(isDelRemarkVaild(da.getActiontype(),
					da.getActiondesc()));
			isDelRemarkVaild(da.getActiontype(), da.getActiondesc());
			// 必填项，境外担保项下境内贷款唯一性编码
			result.append(valLenByNotNull(da.getLounexgucode(), 28, "外保内贷编号"));
			// 银行业务参号 必填
			result.append(isEmpty(da.getBuscode(), "银行业务参号"));
			// 变动编号 必填
			result.append(isEmpty(da.getChangeno(), "变动编号"));
			result.append(exbuiSeNumVaild(da.getApptype(),
					da.getCurrentfile(), da.getFiller2(), da.getBrNo()));
			// 变动日期
			result.append(checkDateFormat(da.getChangedate(), "yyyyMMdd",
					"变动日期"));
			// 变动币种
			result.append(isEmpty(da.getCredcurrcode(), "变动币种"));
			// 提款金额 还本金额 付息费金额 担保履约金额至少有一个
			result.append(fourOptionOne(da.getCredwithamount(),
					da.getCredrepayamount(), da.getPicamount(), da.getActiondesc(),
					"提款金额 、还本金额 、付息费金额、 担保履约金额"));
			// 贷款余额 必填项，大于等于0
			result.append(isAmountAndZero22_2(da.getCredprinbala(), "贷款余额"));
			// 担保责任余额
			result.append(isEmpty(da.getGuarantlibala(), "担保责任余额"));
		}
		return result.toString();
	}

}
