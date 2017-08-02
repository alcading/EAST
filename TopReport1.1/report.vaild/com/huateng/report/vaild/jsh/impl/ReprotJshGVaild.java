package com.huateng.report.vaild.jsh.impl;

import org.apache.commons.lang.StringUtils;

import resource.bean.report.MtsJshDefgDs;

import com.huateng.report.vaild.absbean.AbsReportDataVaild;

public class ReprotJshGVaild extends AbsReportDataVaild{

	@Override
	public String executeDataVaild(Object obj) {
		MtsJshDefgDs  ds  = (MtsJshDefgDs) obj;
		StringBuffer result = new StringBuffer();
		//操作类型
		result.append(checkActiontype(ds.getActiontype()));
		//修改/删除原因
		result.append(isModDelRemarkVaild(ds.getSubSuccess(), ds.getActiondesc()));
		//长度验证
		result.append(this.valLenByNotNull(ds.getRptno(), 22, "申报号码"));
		result.append(this.lessLenNull(ds.getRegno(), 20, "外汇局批件号/备案表号/业务编号"));
		result.append(this.valLenByNotNull(ds.getTxcode(), 6, "交易编码"));
		result.append(this.lessLenNull(ds.getCrtuser(), 20, "填报人"));
		result.append(this.lessLenNull(ds.getInptelc(), 20, "填报人电话"));
		result.append(this.checkDateFormat(ds.getRptdate(), "yyyyMMdd", "申报日期"));
	    if(StringUtils.isEmpty(ds.getRptdate())){
	    	result.append("申报日期不能为空 ");
	    }
		return result.toString();
	}

}
