package com.huateng.report.vaild.bop.impl;

import java.math.BigDecimal;

import org.apache.commons.lang.StringUtils;

import resource.bean.report.MtsBopBhnDs;

import com.huateng.report.constants.TopReportConstants;
import com.huateng.report.vaild.absbean.AbsReportDataVaild;
/*
 * 境外汇款申请书验证
 */
public class ReportBopBValid extends AbsReportDataVaild {
	private static final String C_CUSTYPE = "C";
	@Override
	public String executeDataVaild(Object obj) {
		// TODO Auto-generated method stub
		MtsBopBhnDs ds = (MtsBopBhnDs)obj;
		StringBuffer result = new StringBuffer();
		//操作类型
		result.append(checkActiontype(ds.getActiontype()));
		//修改/删除原因或申报无误理由
		result.append(isModDelRemarkVaild(ds.getSubSuccess(), ds.getActiondesc()));
		//申报号码
		result.append(this.valLenByNotNull(ds.getRptno(), 22, "申报号码"));
		//汇款人类型	组织机构代码	人身份证件号码
		result.append(valCusttype(ds.getCustype(), ds.getCustcod(), ds.getIdcode(), "汇款人类型"));
		//汇款人名称	
		result.append(lessLen(ds.getCustnm(), 128, "汇款人名称"));
		//收款人名称	字符型，128  必输项,必须以大写英文字符 “（JW）”或“（JN）”开头。 必输
		//result.append(this.lessLen(ds.getCustnm(), 128, "收款人名称"));
		result.append(valOppuser(ds.getOppuser(), TopReportConstants.REPORT_FILE_TYPE_BOP_B, "收款人名称"));
		//汇款币种		必输
		result.append(this.valLenByNotNull(ds.getTxccy(), 3, "汇款币种"));
		//汇款金额	必须大于0。	无小数位。
		result.append(isAmount22_0NotNull(ds.getTxamt(), "汇款金额"));
		result.append(valGtZeroNotNull(ds.getTxamt(),"汇款金额"));
		//购汇汇率	当购汇金额大于0时必填，否则不应该填写
		//购汇金额		选输项，但不能小于0。若账号不为空则对应金额必须>0；若金额>0，则对应账号不能为空。
		//购汇金额、购汇汇率、人民币帐号/银行卡号三个或同时空或同时有值
		boolean lcy1Flag = ds.getExrate() == null && ds.getLcyamt() == null && StringUtils.isEmpty(ds.getLcyacc());
		boolean lcy2Flag = ds.getExrate() != null && ds.getLcyamt() != null && StringUtils.isNotEmpty(ds.getLcyacc());
		if(!(lcy1Flag || lcy2Flag)) {
			result.append("购汇金额、购汇汇率、人民币帐号/银行卡号三个或同时空或同时有值！");
		} else if(lcy2Flag) {
			result.append(isRatesAndZero13_8NotNull(ds.getExrate(), "购汇汇率"));
			result.append(isAmount22_0NotNull(ds.getLcyamt(), "购汇金额"));
			result.append(lessLen(ds.getLcyacc(), 32, "人民币帐号/银行卡号"));
		}
		//现汇金额
		//外汇帐号/银行卡号
		boolean fcy1Flag = StringUtils.isEmpty(ds.getFcyacc()) && ds.getFcyamt() == null;
		boolean fcy2Flag = StringUtils.isNotEmpty(ds.getFcyacc()) && ds.getFcyamt() != null;
		if(!(fcy1Flag || fcy2Flag)) {
			result.append("现汇金额、现汇帐号或同时空，或同时有值。");
		} else if(fcy2Flag) {
			result.append(isAmount22_0NotNull(ds.getFcyamt(), "现汇金额"));
			result.append(lessLen(ds.getFcyacc(), 32, "外汇帐号/银行卡号"));
		}
		/*
		 * 	其它金额	选输项，但不能小于0。
		 *	若账号不为空则对应金额必须>0；若金额>0，则对应账号不能为空。
		 *	购汇金额, 现汇金额, 其它金额至少输入一项。
		 *	购汇金额、现汇金额、其它金额之和应等于汇款金额。
		 */
		boolean oth1Flag = StringUtils.isEmpty(ds.getOthacc()) && (ds.getOthamt() == null);
		boolean oth2Flag = StringUtils.isNotEmpty(ds.getOthacc()) && (ds.getOthamt() != null);
		if(!(oth1Flag || oth2Flag)) {
			result.append("其它金额、其它账号/银行卡号或同时空，或同时有值。");
		} else if(oth2Flag) {
			result.append(isAmount22_0NotNull(ds.getOthamt(), "其他金额"));
			result.append(lessLen(ds.getOthacc(), 32, "其它账号/银行卡号"));
		}
		/*
		 * 购汇金额、现汇金额、其他金额三选一
		 */
		result.append(threeOptionOne(ds.getLcyamt(), ds.getFcyamt(), ds.getOthamt(), "购汇金额、现汇金额、其他金额"));
		/*
		 * 购汇金额、现汇金额、其它金额之和应等于汇款金额。
		 */
		BigDecimal txamt = ds.getTxamt();
		BigDecimal totalAmt = new BigDecimal(0);
		if(ds.getLcyamt() != null && ds.getLcyamt().doubleValue() >= 0) {
			totalAmt = totalAmt.add(ds.getLcyamt());
		}
		if(ds.getFcyamt() != null && ds.getFcyamt().doubleValue() >= 0) {
			totalAmt = totalAmt.add(ds.getFcyamt());
		}
		if(ds.getOthamt() != null && ds.getOthamt().doubleValue() >= 0) {
			totalAmt = totalAmt.add(ds.getOthamt());
		}
		if(txamt.doubleValue() != totalAmt.doubleValue()) {
			result.append("购汇金额、现汇金额、其它金额之和应等于汇款金额!");
		}
		//结算方式
		result.append(valLenByNull(ds.getMethod(), 1, "结算方式"));
		//银行业务编号
		result.append(lessLen(ds.getBuscode(), 22, "银行业务编号"));
		return result.toString();
	}
}
