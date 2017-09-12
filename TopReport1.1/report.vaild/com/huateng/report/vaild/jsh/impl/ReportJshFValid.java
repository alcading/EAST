package com.huateng.report.vaild.jsh.impl;

import org.apache.commons.lang.StringUtils;

import resource.bean.report.MtsJshDefgDs;

import com.huateng.report.vaild.absbean.AbsReportDataVaild;

public class ReportJshFValid extends AbsReportDataVaild {

	@Override
	public String executeDataVaild(Object obj) {
		// TODO Auto-generated method stub
		MtsJshDefgDs ds = (MtsJshDefgDs) obj;
		StringBuffer result = new StringBuffer();
		//操作类型
		result.append(checkActiontype(ds.getActiontype()));
		//修改/删除原因
		result.append(isModDelRemarkVaild(ds.getSubSuccess(), ds.getActiondesc()));
		//申报号码
		result.append(valLenByNotNull(ds.getRptno(), 22, "申报号码"));
		//外汇局批件号/备案表号/业务编号
		result.append(lessLenNull(ds.getRegno(), 20, "外汇局批件号/备案表号/业务编号"));
		//交易编码
		/*
		 * 必须在涉外收支交易代码中存在。
		 */
		result.append(valLenByNotNull(ds.getTxcode(), 6, "交易编码"));
		//结汇用途
		result.append(valLenByNull(ds.getUsetype(), 3, "结汇用途"));
		/*
		 * 结汇详细用途
		 * 如果结汇用途选择“005”或“099”，则应填列详细用途。
		 */
		result.append(lessLenNull(ds.getUsedetail(), 100, "结汇详细用途"));
		if((StringUtils.isNotEmpty(ds.getUsetype())) && ((ds.getUsetype().equals("005") || (ds.getUsetype().equals("099"))))) {
			if(StringUtils.isEmpty(ds.getUsedetail())) {
				result.append("当结汇用途是支付其他服务费用或其他时，请填写结汇详细用途！");
			}
		}
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
