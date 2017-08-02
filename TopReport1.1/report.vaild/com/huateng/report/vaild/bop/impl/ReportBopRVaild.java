package com.huateng.report.vaild.bop.impl;

import java.math.BigDecimal;

import org.apache.commons.lang.StringUtils;

import resource.bean.report.MtsBopDrDs;

import com.huateng.report.vaild.absbean.AbsReportDataVaild;

public class ReportBopRVaild extends AbsReportDataVaild {

	@Override
	public String executeDataVaild(Object obj) {
		// TODO Auto-generated method stub
		MtsBopDrDs ds = (MtsBopDrDs)obj;
		StringBuffer result = new StringBuffer();
		// ACTIONTYPE	操作类型	字符型，1	A－新建 C－修改 D－删除 R-申报无误（银行反馈），预留，暂不用。
		result.append(checkActiontype(ds.getActiontype()));
		// ACTIONDESC	修改/删除原因 或申报无误理由	字符型，128
		result.append(isModDelRemarkVaild(ds.getSubSuccess(), ds.getActiondesc()));
		//长度验证
		result.append(this.valLenByNull(ds.getIsref(), 1, "是否保税货物项下收汇"));
		result.append(this.valLenByNull(ds.getPayattr(), 1, "境内收入类型"));
		result.append(this.valLenByNull(ds.getPaytype(), 1, "收款性质"));
		result.append(this.valLenByNotNull(ds.getTxcode(), 6, "交易编码1"));
		result.append(this.isAmount22_0NotNull(ds.getTc1amt(), "相应金额1"));
		result.append(this.lessLen(ds.getTxrem(), 50, "交易附言1"));
		result.append(this.valLenByNull(ds.getTxcode2(), 6, "交易编码2"));
		result.append(this.isAmount22_0(ds.getTc2amt(), "相应金额2"));
		result.append(this.lessLenNull(ds.getTx2rem(), 50, "交易附言2"));
		result.append(this.lessLen(ds.getInptelc(), 20, "申报人电话"));
		result.append(this.lessLen(ds.getCrtuser(), 20, "申报人"));
		result.append(this.checkDateFormat(ds.getRptdate(), "yyyyMMdd", "申报日期"));
		result.append(this.lessLenNull(ds.getRegno(), 20, "外汇局批件号/登记表号/业务编号"));
		//交易编码2不能与交易编码1相同，没有输入交易编码时，相应金额及交易附言不应该填写。有交易金额2或交易附言2时必填。
		
		if(StringUtils.isNotEmpty(ds.getTxcode())&&StringUtils.isNotEmpty(ds.getTxcode2())&&ds.getTxcode().equals(ds.getTxcode2())){
			result.append("交易编码2和交易编码1不能相同! ");
		}
		
		if(StringUtils.isEmpty(ds.getTxcode2())&&ds.getTc2amt()==null&&StringUtils.isEmpty(ds.getTx2rem())){
			
		}else if(StringUtils.isNotEmpty(ds.getTxcode2())&&ds.getTc2amt()!=null&&StringUtils.isNotEmpty(ds.getTx2rem())){
			
		}else{
			result.append("交易编码2,相应金额及交易附言要么同时填写  要么都为空! ");	
		}
			
		//相应金额2 有交易编码2时必填。两个交易编码对应的金额之和必须等于收入款金额
		if(ds.getTc1amt()!=null&&ds.getTxamt()!=null){
			BigDecimal bd = new BigDecimal(0);
			bd = bd.add(ds.getTc1amt());
			if(ds.getTc2amt()!=null){
			  bd = bd.add(ds.getTc2amt());
			}
		  if(bd.doubleValue()!=ds.getTxamt().doubleValue()){
			result.append("相应金额1和相应金额2之和必须等于收入款金额 ");
		}
		}
		/*外汇局批件号/登记表号/业务编号  资本项目项下交易（涉外收支交易编码以“5”、“6”、“7”、“8”和
		      部分“9”开头，具体见10.2.3和10.2.4）的“外汇局批件号/备案表号/业务编号”为必输项。
	                 对于资本项目项下交易，如果确实没有对应的“外汇局批件号/备案表号/业务编号”，应填写“N/A”（大写英文字符）
        */

		
		return result.toString();
		
	}
	


}
