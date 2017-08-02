package com.huateng.report.vaild.bop.impl;

import java.math.BigDecimal;

import org.apache.commons.lang.StringUtils;

import resource.bean.report.MtsBopCkpDs;

import com.huateng.report.constants.TopReportConstants;
import com.huateng.report.vaild.absbean.AbsReportDataVaild;

public class ReportBopCKPVaild extends AbsReportDataVaild {

	@Override
	public String executeDataVaild( Object obj) {
		MtsBopCkpDs ds = (MtsBopCkpDs) obj;
		StringBuffer result = new StringBuffer();
		if (ds.getCurrentfile().equals(TopReportConstants.REPORT_FILE_TYPE_BOP_C)) {
			// ACTIONTYPE	操作类型	字符型，1	A－新建 C－修改 D－删除 R-申报无误（银行反馈），预留，暂不用。
			result.append(checkActiontype(ds.getActiontype()));
			// ACTIONDESC	修改/删除原因 或申报无误理由	字符型，128
			result.append(isModDelRemarkVaild(ds.getSubSuccess(), ds.getActiondesc()));
			result.append(this.valLenByNotNull(ds.getRptno(), 22, "申报号码"));
			result.append(this.valCusttype(ds.getCustype(), ds.getCustcod(), ds.getIdcode(), "客户类型"));
			result.append(this.lessLen(ds.getCustnm(), 128, "付款人名称"));
			result.append(this.valOppuser(ds.getOppuser(), ds.getCurrentfile(), "收款人名称"));
			result.append(this.valLenByNotNull(ds.getTxccy(), 3, "付款币种"));
			result.append(this.valGtZeroNotNull(ds.getTxamt(), "付款金额"));
			result.append(this.isAmount22_0NotNull(ds.getTxamt(), "付款金额"));
			if(ds.getExrate() != null && ds.getLcyamt() != null && StringUtils.isNotEmpty(ds.getLcyacc())){
				result.append(this.isRatesAndZero13_8NotNull(ds.getExrate(), "购汇汇率"));
				result.append(this.valGtZeroNotNull(ds.getLcyamt(), "购汇金额"));
				result.append(this.isAmount22_0NotNull(ds.getLcyamt(), "购汇金额"));
				result.append(this.lessLen(ds.getLcyacc(), 32, "人民币帐号/银行卡号"));
			} else if (ds.getExrate() == null&&ds.getLcyamt()==null&&StringUtils.isEmpty(ds.getLcyacc())){
			} else {
				result.append("购汇金额、购汇汇率、购汇帐号三个或同时空或同时有值。");
			}
			if(StringUtils.isNotEmpty(ds.getFcyacc()) && ds.getFcyamt() != null){
				result.append(this.valGtZeroNotNull(ds.getFcyamt(), "现汇金额"));
				result.append(this.isAmount22_0NotNull(ds.getFcyamt(), "现汇金额"));
				result.append(this.lessLen(ds.getFcyacc(), 32, "外汇帐号/银行卡号"));
			} else if(StringUtils.isEmpty(ds.getFcyacc())&&ds.getFcyamt()==null){
			} else {
				result.append("现汇金额、现汇帐号或同时空，或同时有值");
			}
			if(StringUtils.isNotEmpty(ds.getOthacc()) && ds.getOthamt() != null){
				result.append(this.valGtZeroNotNull(ds.getOthamt(), "其它金额"));
				result.append(this.isAmount22_0NotNull(ds.getOthamt(), "其它金额"));
				result.append(this.lessLen(ds.getFcyacc(), 32, "其它帐号/银行卡号"));
			} else if (StringUtils.isEmpty(ds.getOthacc())&&ds.getOthamt()==null){
			} else {
				result.append("其它金额、其它帐号或同时空，或同时有值。");
			}
			if(ds.getOthamt()==null && ds.getFcyamt()==null && ds.getLcyamt()==null){
				result.append("购汇金额, 现汇金额, 其它金额至少输入一项。");
			}
			BigDecimal talAmt = new BigDecimal(0);
			talAmt = talAmt.add(ds.getOthamt() != null ? ds.getOthamt() : new BigDecimal(0));
			talAmt = talAmt.add(ds.getFcyamt() != null ? ds.getFcyamt() : new BigDecimal(0));
			talAmt = talAmt.add(ds.getLcyamt() != null ? ds.getLcyamt() : new BigDecimal(0));
			if(ds.getTxamt().compareTo(talAmt) != 0){
				result.append("购汇金额、现汇金额、其它金额之和应等于付款金额。");
			}
			result.append(this.valLenByNull(ds.getMethod(), 1, "结算方式"));
			result.append(this.lessLen(ds.getBuscode(), 22, "银行业务编号"));
			result.append(this.valLenByNotNull(ds.getActuccy(), 3, "实际付款币种"));
			result.append(this.valGtZeroNotNull(ds.getActuamt(), "实际付款金额"));
			result.append(this.isAmount22_0NotNull(ds.getActuamt(), "实际付款金额"));
			if(ds.getOutchargeamt() != null && StringUtils.isNotEmpty(ds.getOutchargeccy())){
				result.append(this.valLenByNotNull(ds.getOutchargeccy(), 3, "扣费币种"));
				result.append(this.valGEZeroNull(ds.getOutchargeamt(), "扣费金额"));
				result.append(this.isAmount22_0NotNull(ds.getOutchargeamt(), "扣费金额"));
			} else if(ds.getOutchargeamt()==null&&StringUtils.isEmpty(ds.getOutchargeccy())){
			} else {
				result.append("扣费金额,扣费币种或同时空，或同时有值。");
			}
			if(StringUtils.isNotEmpty(ds.getIssdate())&& StringUtils.isNotEmpty(ds.getLcbgno()) && ds.getTenor() != null){
				result.append(this.valLenByNotNull(ds.getIssdate(), 8, "开证日期"));
				result.append(this.lessLen(ds.getLcbgno(), 20, "信用证/保函编号"));
				result.append(this.valGtZeroNotNull(ds.getTenor(), "期限"));
			} else if(StringUtils.isEmpty(ds.getIssdate())&&StringUtils.isEmpty(ds.getLcbgno())&&ds.getTenor()==null){
			} else {
				result.append("信用证/保函编号,开证日期,期限或同时空，或同时有值。");
			}
		} else if(ds.getCurrentfile().equals(TopReportConstants.REPORT_FILE_TYPE_BOP_K)){
			// ACTIONTYPE	操作类型	字符型，1	A－新建 C－修改 D－删除 R-申报无误（银行反馈），预留，暂不用。
			result.append(checkActiontype(ds.getActiontype()));
			// ACTIONDESC	修改/删除原因 或申报无误理由	字符型，128
			result.append(isModDelRemarkVaild(ds.getSubSuccess(), ds.getActiondesc()));
			result.append(this.valLenByNotNull(ds.getRptno(), 22, "申报号码"));
			result.append(this.valLenByNotNull(ds.getCountry(), 3, "收款人常驻国家/地区代码"));
			result.append(this.valLenByNull(ds.getPaytype(), 1, "付款类型"));
			result.append(this.valLenByNull(ds.getTxcode(), 6, "交易编码1"));
			result.append(this.lessLenNull(ds.getTxrem(), 50, "交易附言1"));
			result.append(this.amtNotNull(ds.getTc1amt(), "相应金额1"));
			result.append(this.isAmount22_0NotNull(ds.getTc1amt(), "相应金额1"));
			if(StringUtils.isNotEmpty(ds.getTxcode2()) && ds.getTc2amt() != null && StringUtils.isNotEmpty(ds.getTx2rem())){
				result.append(this.isAmount22_0NotNull(ds.getTc2amt(), "相应金额2"));
				result.append(this.valLenByNull(ds.getTxcode2(), 6, "交易编码2"));
				result.append(this.lessLenNull(ds.getTx2rem(), 50, "交易附言2"));
				if(ds.getTxcode().equals(ds.getTxcode2())){
					result.append("交易编码2不能与交易编码1相同。");
				}
			} else if (StringUtils.isEmpty(ds.getTxcode2()) && ds.getTc2amt() == null && StringUtils.isEmpty(ds.getTx2rem())){
			} else {
				result.append("交易编码2、相应金额2、交易附言2三个或同时空或同时有值。");
			}
			//两个交易编码对应的金额之和必须等于付款金额。
			BigDecimal talAmt = new BigDecimal(0);
			talAmt = talAmt.add(ds.getTc1amt() != null ? ds.getTc1amt() : new BigDecimal(0));
			talAmt = talAmt.add(ds.getTc2amt() != null ? ds.getTc2amt() : new BigDecimal(0));
			if(ds.getTxamt().compareTo(talAmt) != 0){
				result.append("两个交易编码对应的金额之和必须等于付款金额。");
			}
			result.append(this.valLenByNull(ds.getIsref(), 1, "是否保税货物项下付款"));
			result.append(this.lessLen(ds.getCrtuser(), 20, "联系人"));
			result.append(this.lessLen(ds.getInptelc(), 20, "联系人电话"));
			result.append(this.valLenByNotNull(ds.getRptdate(), 8, "申报日期"));
			result.append(this.lessLenNull(ds.getRegno(), 20, "外汇局批件号/备案表号/业务编号"));
		} else {
			// ACTIONTYPE	操作类型	字符型，1	A－新建 C－修改 D－删除 R-申报无误（银行反馈），预留，暂不用。
			result.append(checkActiontype(ds.getActiontype()));
			// ACTIONDESC	修改/删除原因 或申报无误理由	字符型，128
			result.append(isModDelRemarkVaild(ds.getSubSuccess(), ds.getActiondesc()));
			result.append(this.valLenByNotNull(ds.getRptno(), 22, "申报号码"));
			result.append(this.lessLen(ds.getContrno(), 20, "合同号"));
			result.append(this.lessLen(ds.getInvoino(), 35, "发票号"));
			result.append(this.lessLenNull(ds.getBillno(), 20, "提运单号"));
			result.append(this.lessLen(ds.getCrtuser(), 20, "填报人"));
			result.append(this.lessLen(ds.getInptelc(), 20, "填报人电话"));
			result.append(this.valLenByNotNull(ds.getRptdate(), 8, "申报日期"));
		}
		return result.toString();
	}
	
	public String amtNotNull(BigDecimal val, String errField){
		StringBuffer result = new StringBuffer();

		if (null == val) {
			result.append(errField + "不可为空");
		}
		return result.toString();
	}

	/**
	 * val的值大于0的值，可为空
	 * @param val
	 * @param errField
	 * @return
	 */
	public String valGtZeroNull(BigDecimal val, String errField){
		StringBuffer result = new StringBuffer();

		if (null != val) {
			if (val.compareTo(new BigDecimal(0)) < 1) {
				result.append(errField + "必须大于零");
			}
		}
		return result.toString();
	}
	
	/**
	 * val的值大于等于0的值，可为空
	 * @param val
	 * @param errField
	 * @return
	 */
	public String valGEZeroNull(BigDecimal val, String errField){
		StringBuffer result = new StringBuffer();

		if (null != val) {
			if (val.compareTo(new BigDecimal(0)) < 0) {
				result.append(errField + "必须大于等于零");
			}
		}
		return result.toString();
	}
	
	/**
	 * val的值大于0的值， 不可为空
	 * @param val
	 * @param errField
	 * @return
	 */
	public String valGtZeroNotNull(BigDecimal val, String errField){
		StringBuffer result = new StringBuffer();
		
		if(null == val){
			result.append(errField + "不可空");
		}
		
		if (null != val) {
			if (val.compareTo(new BigDecimal(0)) < 1) {
				result.append(errField + "必须大于零");
			}
		}
		return result.toString();
	}
}
