package com.huateng.report.vaild.bop.impl;

import resource.bean.report.MtsBopBhnDs;

import com.huateng.report.vaild.absbean.AbsReportDataVaild;

public class ReportBopNValid extends AbsReportDataVaild {

	@Override
	public String executeDataVaild(Object obj) {
		MtsBopBhnDs ds = (MtsBopBhnDs) obj;
		StringBuffer result = new StringBuffer();
		// ACTIONTYPE	操作类型	字符型，1	A－新建 C－修改 D－删除 R-申报无误（银行反馈），预留，暂不用。
		result.append(checkActiontype(ds.getActiontype()));
		// ACTIONDESC	修改/删除原因 或申报无误理由	字符型，128
		result.append(isModDelRemarkVaild(ds.getSubSuccess(), ds.getActiondesc()));
		//申报号码
		result.append(valLenByNotNull(ds.getRptno(), 22, "申报号码"));
		//合同号
		result.append(lessLen(ds.getContrno(), 20, "合同号"));
		//发票号
		result.append(lessLen(ds.getInvoino(), 35, "发票号"));
		//填报人
		result.append(lessLen(ds.getCrtuser(), 20, "填报人"));
		//填报人电话
		result.append(lessLen(ds.getInptelc(), 20, "填报人电话"));
		//申报日期
		result.append(isNull(ds.getRptdate(), "申报日期"));
		result.append(checkDateFormat(ds.getRptdate(), "yyyyMMdd", "申报日期"));
		return result.toString();
	}

}
