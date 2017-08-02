package com.huateng.report.vaild.bop.impl;

import java.math.BigDecimal;

import org.apache.commons.lang.StringUtils;

import resource.bean.report.MtsBopBhnDs;

import com.huateng.report.vaild.absbean.AbsReportDataVaild;

public class ReportBopHValid extends AbsReportDataVaild {

	@Override
	public String executeDataVaild(Object obj) {
		MtsBopBhnDs ds = (MtsBopBhnDs)obj;
		StringBuffer result = new StringBuffer();
		// ACTIONTYPE	操作类型	字符型，1	A－新建 C－修改 D－删除 R-申报无误（银行反馈），预留，暂不用。
		result.append(checkActiontype(ds.getActiontype()));
		// ACTIONDESC	修改/删除原因 或申报无误理由	字符型，128
		result.append(isModDelRemarkVaild(ds.getSubSuccess(), ds.getActiondesc()));
		//申报号码
		result.append(valLenByNotNull(ds.getRptno(), 22, "申报号码"));
		//收款人常驻国家/地区代码
		result.append(valLenByNotNull(ds.getCountry(), 3, "款人常驻国家/地区代码"));
		//付款类型
		result.append(valLenByNull(ds.getPaytype(), 1, "付款类型"));
		//交易编码1
		result.append(valLenByNotNull(ds.getTxcode(), 6, "交易编码1"));
		//相应金额1
		result.append(isAmount22_0NotNull(ds.getTc1amt(), "相应金额1"));
		//交易附言1
		result.append(lessLen(ds.getTxrem(), 50, "交易附言1"));
		//交易编码2 选输
		/*
		 * 	必须在国际收支交易编码表中存在
		 *	不能与交易编码1相同，
		 *	没有输入交易编码时，相应金额及交易附言不应该填写。
		 *	有交易金额2或交易附言2时必填。
		 *
		 */
		result.append(valLenByNull(ds.getTxcode2(), 6, "交易编码2"));
		if(ds.getTxcode() != null) {
			if(ds.getTxcode().equals(ds.getTxcode2())) {
				result.append("交易编码2不能和交易编码1相同！");
			}
		}
		//交易编码2，相应金额，交易附言2三个或同时为空或同时有值
		boolean tx2Flag1 = StringUtils.isEmpty(ds.getTxcode2()) && ds.getTc2amt() == null && StringUtils.isEmpty(ds.getTx2rem());
		boolean tx2Flag2 = StringUtils.isNotEmpty(ds.getTxcode2()) && ds.getTc2amt() != null && StringUtils.isNotEmpty(ds.getTx2rem());
		if(!(tx2Flag1 || tx2Flag2)) {
			result.append("交易编码2，相应金额2，交易附言2三个或同时为空或同时有值！");
		} else if(tx2Flag2) {
			result.append(valLenByNotNull(ds.getTxcode2(), 6, "交易编码2"));
			result.append(isAmount22_0NotNull(ds.getTc2amt(), "相应金额2"));
			result.append(lessLen(ds.getTx2rem(), 50, "交易附言2"));
		}
		//两个交易编码对应的金额之和必须等于汇款金额。
		BigDecimal txamt = ds.getTxamt();
		BigDecimal totalAmt = new BigDecimal(0);
		if(ds.getTc1amt() != null && ds.getTc1amt().doubleValue() >= 0) {
			totalAmt = totalAmt.add(ds.getTc1amt());
		}
		if(ds.getTc2amt() != null && ds.getTc2amt().doubleValue() >= 0) {
			totalAmt = totalAmt.add(ds.getTc2amt());
		}
		if(txamt.doubleValue() != totalAmt.doubleValue()) {
			result.append("两个交易编码对应的金额之和应等于汇款金额!");
		}
		//是否保税货物项下付款
		result.append(valLenByNull(ds.getIsref(), 1, "是否保税货物项下付款"));
		//申请人
		result.append(lessLen(ds.getCrtuser(), 20, "申请人"));
		//申请人电话
		result.append(lessLen(ds.getInptelc(), 20, "申请人电话"));
		//申报日期(和申报号码中的比较，申报号码里的格式是yyMMdd)
		result.append(checkDateFormat(ds.getRptdate(), "yyyyMMdd", "申报日期"));
		String checkDate = "";
		if(ds.getRptno() != null) {
			checkDate = ds.getRptno().substring(12,18);
		}
		String rptDate = ds.getRptdate().substring(2);
		if(rptDate.compareTo(checkDate) > 0) {
			result.append("申报日期需小于等于申报号码中的日期");
		}
		//外汇局批件号/备案表号/业务编号
		result.append(lessLenNull(ds.getRegno(), 20, "外汇局批件号/备案表号/业务编号"));
		return result.toString();
	}
}
