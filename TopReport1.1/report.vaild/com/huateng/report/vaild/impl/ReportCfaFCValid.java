package com.huateng.report.vaild.impl;

import java.math.BigDecimal;

import resource.bean.report.BopCfaStrdeDs;

import com.huateng.report.vaild.absbean.AbsReportDataVaild;

public class ReportCfaFCValid extends AbsReportDataVaild {

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
		//3.必填项，唯一性编码。 人民币结构性存款编号
		result.append(this.valLenByNotNull(bopCfaStrdeDs.getStrdecode(),28,"人民币结构性存款编号"));
		//4.必填项，金融机构标识码。
		result.append(this.valLenByNotNull(bopCfaStrdeDs.getBrNo(), 12, "金融机构标识码"));
		//5.必填项，合同号
		result.append(this.valLenByNotNull(bopCfaStrdeDs.getContract(), 32, "合同号"));
		//6.必填项，记录付息情况编号	付息编号
		result.append(this.valLenByNotNull(bopCfaStrdeDs.getInpaycode(), 4, "付息编号"));
		//7.必填项，格式为YYYYMM。 	付息年月 	
		result.append(AbsReportDataVaild.checkDateFormat(bopCfaStrdeDs.getInpaymonth(), "yyyyMM", "付息年月"));
		//8.非必填项，大于等于0。付息人民币支付金额与付息外币支付金额至少填一个。付息人民币支付金额
		result.append(this.isAmount22_2(bopCfaStrdeDs.getInpayrmbam(), "付息人民币支付金额"));
		result.append(atLeastOne(bopCfaStrdeDs));
		//9.非必填项。付息外币支付币种和付息外币支付金额为一组数据，两者同时为空或者不为空。 付息外币支付币种
		result.append(this.valLenByNull(bopCfaStrdeDs.getInpaycurr(), 3, "付息外币支付币种"));
		result.append(sameOrNotSynchronic(bopCfaStrdeDs));
		//10.非必填项，大于等于0。	付息外币支付金额
		result.append(this.isAmount22_2(bopCfaStrdeDs.getInpaycurram(), "付息外币支付金额"));
		//11.非必填项。备注
		result.append(this.lessLenNull(bopCfaStrdeDs.getRemark(), 256, "备注"));
		return result.toString();
	}
	
	/*
	 * 付息人民币支付金额与付息外币支付金额至少填一个
	 */
	public String atLeastOne(BopCfaStrdeDs bopCfaStrdeDs) {
		StringBuffer buff = new StringBuffer();
		BigDecimal inpayrmbam = bopCfaStrdeDs.getInpayrmbam();
		BigDecimal inpaycurram = bopCfaStrdeDs.getInpaycurram();
		if(inpayrmbam == null && inpaycurram == null) {
			buff.append("付息人民币支付金额与付息外币支付金额至少填一个!");
		}
		return buff.toString();
	}
	/*
	 * 付息外币支付币种和付息外币支付金额为一组数据，两者同时为空或者不为空
	 */
	public String sameOrNotSynchronic(BopCfaStrdeDs bopCfaStrdeDs) {
		StringBuffer buff = new StringBuffer();
		String inpaycurr = bopCfaStrdeDs.getInpaycurr();
		BigDecimal inpaycurram  = bopCfaStrdeDs.getInpaycurram();
		if(!(((inpaycurr == null || inpaycurr.length() == 0) && inpaycurram == null) || ((inpaycurr != null && inpaycurr.length() != 0) && inpaycurram != null))) {
			buff.append("付息外币支付币种和付息外币支付金额为一组数据，两者同时为空或者不为空!");
		}
		return buff.toString();
	}
}
