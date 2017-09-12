package com.huateng.report.vaild.bop.impl;

import java.math.BigDecimal;

import org.apache.commons.lang.StringUtils;

import resource.bean.report.MtsBopEqDs;

import com.huateng.report.constants.TopReportConstants;
import com.huateng.report.vaild.absbean.AbsReportDataVaild;

public class ReportBopEqVaild extends AbsReportDataVaild {
	
	@Override
	public String executeDataVaild( Object obj) {
		MtsBopEqDs ds = (MtsBopEqDs) obj;
		StringBuffer result = new StringBuffer();
		if (ds.getCurrentfile().equals(TopReportConstants.REPORT_FILE_TYPE_BOP_E)) {
			// ACTIONTYPE	操作类型	字符型，1	A－新建 C－修改 D－删除 R-申报无误（银行反馈），预留，暂不用。
			result.append(checkActiontype(ds.getActiontype()));
			// ACTIONDESC	修改/删除原因 或申报无误理由	字符型，128
			result.append(isModDelRemarkVaild(ds.getSubSuccess(), ds.getActiondesc()));
			// RPTNO	申报号码	字符型，22	
			// 编码规则：6位地区标识码+4位银行代码+2位银行顺序码+ 支付日期（yymmdd）+4位银行业务流水码。支付日期不能大于系统日期。
			// 银行业务流水码规则：001A—>999A—>001B—>……999J
			result.append(valLenByNotNull(ds.getRptno(), 22, "申报号码"));
			// CUSTYPE	汇款人类型	字符型，1	C－对公用户 D－对私中国居民 F－对私中国非居民
			// IDCODE	个人身份证件号码	字符型，32	CUSTYPE<>C时必输
			// CUSTCOD	组织机构代码	字符型，9	CUSTYPE=C时必输 技监局代码，代码必须符合技监局的机构代码编制规则。
			result.append(valCusttype(ds.getCustype(), ds.getCustcod(), ds.getIdcode(), "汇款人类型"));
			// CUSTNM	汇款人名称	字符型，128	必输项
			result.append(lessLen(ds.getCustnm(), 128, "汇款人名称"));
			// OPPUSER	收款人名称	字符型，128	必输项
			result.append(valOppuser(ds.getOppuser(), TopReportConstants.REPORT_FILE_TYPE_BOP_E, "收款人名称"));
			// OPPACC	收款人帐号	字符型，32	必输项
			result.append(lessLen(ds.getOppacc(), 32, "收款人账号"));
			// TXCCY	汇款币种	字符型，3	必输项。字母代码,必须在币种代码表里存在
			result.append(lessLen(ds.getTxccy(), 3, "汇款币种"));
			// TXAMT	汇款金额	数值型，22.0	必须大于0。 无小数位。
			result.append(isAmount22_0(ds.getTxamt(), "汇款金额"));
			// EXRATE	购汇汇率	数值型，13.8	当购汇金额大于0时必填，否则不应该填写
			// LCYAMT	购汇金额	数值型，22.0	选输项，但不能小于0。
			// 若账号不为空则对应金额必须>0；若金额>0，则对应账号不能为空。
			// LCYACC	人民币帐号/银行卡号	字符型， 32	购汇金额、购汇汇率、购汇帐号三个或同时空或同时有值。
			if (ds.getExrate() != null && ds.getLcyamt() != null && StringUtils.isNotEmpty(ds.getLcyacc())) {
				result.append(isRatesAndZero13_8NotNull(ds.getExrate(), "购汇汇率"));
				result.append(isAmount22_0(ds.getLcyamt(), "购汇金额"));
				result.append(lessLen(ds.getLcyacc(), 32, "人民币帐号/银行卡号"));
			} else if (ds.getExrate() == null && ds.getLcyamt() == null && StringUtils.isEmpty(ds.getLcyacc())) {
				// 允许三者同时为空
			} else {
				result.append("购汇金额、购汇汇率、 购汇帐号三个或同时空或同时有值。");
			}
			// FCYAMT	现汇金额 数值型，22.0	选输项，但不能小于0。
			// 若账号不为空则对应金额必须>0；若金额>0，则对应账号不能为空。
			// FCYACC	外汇帐号/银行卡号	字符型，32	如果有现汇金额，则该字段不能为空。 现汇金额、现汇帐号或同时空，或同时有值。
			if (ds.getFcyamt() != null && StringUtils.isNotEmpty(ds.getFcyacc())) {
				result.append(isAmount22_0(ds.getFcyamt(), "购汇金额"));
				result.append(lessLen(ds.getFcyacc(), 32, "人民币帐号/银行卡号"));
			} else if (ds.getFcyamt() == null && StringUtils.isEmpty(ds.getFcyacc())) {
				// 允许两者同时为空
			} else {
				result.append("现汇金额、现汇帐号或同时空，或同时有值。");
			}
			// OTHAMT	其它金额	数值型，22.0	选输项，但不能小于0。 若账号不为空则对应金额必须>0；若金额>0，则对应账号不能为空。
			// OTHACC	其它帐号/银行卡号 字符型，32	如果有其他金额，则该字段不能为空，其他金额为0，则该字段不应该填写，其它金额、其它帐号或同时空，或同时有值。
			if (ds.getOthamt() != null && StringUtils.isNotEmpty(ds.getOthacc())) {
				result.append(isAmount22_0(ds.getOthamt(), "购汇金额"));
				result.append(lessLen(ds.getOthacc(), 32, "人民币帐号/银行卡号"));
			} else if (ds.getOthamt() == null && StringUtils.isEmpty(ds.getOthacc())) {
				// 允许两者同时为空
			} else {
				result.append("其它金额、其它帐号或同时空，或同时有值。");
			}
			// 购汇金额, 现汇金额, 其它金额至少输入一项。
			result.append(threeOptionOne(ds.getLcyamt(), ds.getFcyamt(), ds.getOthamt(), "结汇金额、现汇金额、其他金额"));
			// 购汇金额、现汇金额、其它金额之和应等于汇款金额。
			BigDecimal talAmt = new BigDecimal(0);
			talAmt = talAmt.add(ds.getOthamt() != null ? ds.getOthamt() : new BigDecimal(0));
			talAmt = talAmt.add(ds.getFcyamt() != null ? ds.getFcyamt() : new BigDecimal(0));
			talAmt = talAmt.add(ds.getLcyamt() != null ? ds.getLcyamt() : new BigDecimal(0));
			if(ds.getTxamt().compareTo(talAmt) != 0){
				result.append("购汇金额、现汇金额、其它金额之和应等于汇款金额。");
			}
			// METHOD	结算方式	字符型，1	T－电汇 D－票汇  M－信汇
			result.append(valLenByNull(ds.getMethod(), 1, "结算方式"));
			// BUSCODE	银行业务编号	字符型，22	必输项
			result.append(lessLen(ds.getBuscode(), 22, "银行业务编号"));
		} else if (ds.getCurrentfile().equals(TopReportConstants.REPORT_FILE_TYPE_BOP_Q)) {
			// ACTIONTYPE	操作类型	字符型，1	A－新建 C－修改 D－删除 R-申报无误（银行反馈），预留，暂不用。
			result.append(checkActiontype(ds.getActiontype()));
			// ACTIONDESC	修改/删除原因 或申报无误理由	字符型，128
			result.append(isModDelRemarkVaild(ds.getSubSuccess(), ds.getActiondesc()));
			// RPTNO	申报号码	字符型，22	应与基础数据一致
			result.append(this.valLenByNotNull(ds.getRptno(), 22, "申报号码"));
			// IMPDATE	最迟装运日期	日期型， 8 YYYYMMDD	空，不赋值。
			// CONTRNO	合同号	字符型，20	必输项
			result.append(this.lessLen(ds.getContrno(), 20, "合同号"));
			// INVOINO	发票号	字符型，35	必输项
			result.append(this.lessLen(ds.getInvoino(), 35, "发票号"));
			// REGNO	外汇局批件/备案表号	字符型，20	空，不赋值。
			// CUSMNO	报关单经营单位代码	字符型，12	空，不赋值。
			// 报关单信息			空，不赋值。
			// CUSTOMN	报关单号  字符型，50	空，不赋值。
			// CUSTCCY	报关单币种	字符型， 3	空，不赋值。
			// CUSTAMT	报关金额	数值型，22.0	空，不赋值。
			// OFFAMT	本次核注金额	数值型，22.0	空，不赋值。
			// CRTUSER	填报人	字符型，20	必输项
			result.append(this.lessLen(ds.getCrtuser(), 20, "填报人"));
			// INPTELC	填报人电话	字符型，20	必输项
			result.append(this.lessLen(ds.getInptelc(), 20, "填报人电话"));
			// RPTDATE	申报日期	日期型， 8 YYYYMMDD	必填项，按申报主体真实申报日期填写
			result.append(this.lessLen(ds.getRptdate(), 8, "申报日期"));
		}
		return result.toString();
	}
}
