package com.huateng.report.vaild.jsh.impl;

import org.apache.commons.lang.StringUtils;

import resource.bean.report.MtsJshDefgDs;

import com.huateng.report.vaild.absbean.AbsReportDataVaild;

public class ReportJshDValid extends AbsReportDataVaild {

	private static final String C_CUSTYPE = "C";
	@Override
	public String executeDataVaild(Object obj) {
		// TODO Auto-generated method stub
		MtsJshDefgDs ds = (MtsJshDefgDs)obj;
		StringBuffer result = new StringBuffer();
		//操作类型
		result.append(checkActiontype(ds.getActiontype()));
		//修改/删除原因或申报无误理由
		result.append(isModDelRemarkVaild(ds.getSubSuccess(), ds.getActiondesc()));
		//申报号码
		result.append(valLenByNotNull(ds.getRptno(), 22, "申报号码"));
		//银行业务编号
		result.append(lessLen(ds.getBuscode(), 22, "银行业务编号"));
		//结汇申请人主体类型 	结汇申请人组织机构代码	结汇申请人个人身份证件号码
		result.append(valCusttype(ds.getCustype(), ds.getCustcod(), ds.getIdcode(), "结汇申请人主体类型 "));
		//结汇申请人名称
		result.append(lessLen(ds.getCustnm(), 128, "结汇申请人名称"));
		//外汇账户账号
		result.append(lessLen(ds.getFcyacc(), 32, "外汇账户账号"));
		//人民币账户账号
		result.append(lessLenNull(ds.getLcyacc(), 32, "人民币账户账号"));
		//人民币收款人名称
		result.append(lessLen(ds.getOppuser(), 128, "人民币收款人名称"));
		//人民币账户开户行
		if(StringUtils.isNotEmpty(ds.getLcyacc())) {
			if(StringUtils.isEmpty(ds.getOppbank())) {
				result.append("存在人民币账户账号时，人民币账户开户行必填！");
			}
		}
		//结汇金额
		result.append(isAmount22_0NotNull(ds.getFcyamt(), "结汇金额"));
		//币别
		result.append(valLenByNotNull(ds.getFcyccy(), 3, "币别"));
		//汇率
		result.append(isRatesAndZero13_8NotNull(ds.getExrate(), "汇率"));
		return result.toString();
	}

}
