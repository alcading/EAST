package com.huateng.report.vaild.bop.impl;

import java.math.BigDecimal;

import org.apache.commons.lang.StringUtils;

import resource.bean.report.MtsBopAgDs;

import com.huateng.report.constants.TopReportConstants;
import com.huateng.report.vaild.absbean.AbsReportDataVaild;

public class ReportBopAgVaild extends AbsReportDataVaild {

	@Override
	public String executeDataVaild( Object obj) {
	    MtsBopAgDs ds = (MtsBopAgDs) obj;
		StringBuffer result = new StringBuffer();
		if (ds.getCurrentfile().equals(TopReportConstants.REPORT_FILE_TYPE_BOP_A)) {
			// ACTIONTYPE	操作类型	字符型，1	A－新建 C－修改 D－删除 R-申报无误（银行反馈），预留，暂不用。
			result.append(checkActiontype(ds.getActiontype()));
			// ACTIONDESC	修改/删除原因 或申报无误理由	字符型，128
			result.append(isModDelRemarkVaild(ds.getSubSuccess(), ds.getActiondesc()));
			// RPTNO	申报号码	字符型，22	编码规则：6位地区标识码+4位银行代码+2位银行顺序码+支付日期（yymmdd）+4位银行业务流水码。
			//支付日期不能大于系统日期
			//银行业务流水码规则：
			//对公为N001—>N999，P001—>……T999
			//对私为U001—>U999—>V001—>……W999
			// RPTNO	申报号码	字符型，22
			result.append(valLenByNotNull(ds.getRptno(), 22, "申报号码"));
			// CUSTYPE	收款人类型	字符型，1	"C－对公用户	D－对私中国居民 F－对私中国非居民 需与申报号码中第19位字母所表明的含义一致。"
			// IDCODE	个人身份证件号码	字符型，32	CUSTYPE<>C时必输
			// CUSTCOD	组织机构代码	字符型，9	"CUSTYPE=C时必输	技监局代码，代码必须符合技监局的机构代码编制规则。"
			result.append(valCusttype(ds.getCustype(), ds.getCustcod(), ds.getIdcode(), "收款人类型"));
			// CUSTNM	收款人名称	字符型，128	必输项
			result.append(lessLen(ds.getCustnm(), 128, "收款人名称"));
			// OPPUSER	付款人名称	字符型，128	必输项,必须以大写英文字符 “(JW)”或“(JN)”开头。
			result.append(valOppuser(ds.getOppuser(), TopReportConstants.REPORT_FILE_TYPE_BOP_A, "付款人名称"));
			// TXCCY	收入款币种	字符型，3	必填项。字母代码,必须在币种代码表里存在
			result.append(valLenByNotNull(ds.getTxccy(), 3, "收入款币种"));
			// TXAMT	收入款金额	数值型，22.0	必须大于0。无小数位。
			result.append(isAmount22_0NotNull(ds.getTxamt(), "收入款金额"));			
			// EXRATE	结汇汇率	数值型，13.8	当结汇金额大于0时必填，否则不应该填写
			// LCYAMT	结汇金额	数值型，22.0	选输项，但不能小于0。若账号不为空则对应金额必须>0；若金额>0，则对应账号不能为空。
			// LCYACC	人民币帐号/银行卡号	字符型， 32	结汇金额、结汇汇率、结汇帐号三个或同时空或同时有值。
			if (ds.getExrate() != null && ds.getLcyamt() != null && StringUtils.isNotEmpty(ds.getLcyacc())) {
				result.append(isRatesAndZero13_8NotNull(ds.getExrate(), "结汇汇率"));
				result.append(isAmount22_0NotNull(ds.getLcyamt(), "结汇金额"));
				result.append(lessLen(ds.getLcyacc(), 32, "人民币帐号/银行卡号"));
			} else if (ds.getExrate() == null && ds.getLcyamt() == null && StringUtils.isEmpty(ds.getLcyacc())) {
				// 允许三者同时为空
			} else {
				result.append("结汇金额、 结汇汇率、 结汇帐号三个或同时空或同时有值。");
			}
			// FCYAMT	现汇金额	数值型，22.0	选输项，但不能小于0。若账号不为空则对应金额必须>0；若金额>0，则对应账号不能为空。
			// FCYACC	外汇帐号/银行卡号	字符型，32	如果有现汇金额，则该字段不能为空。现汇金额、现汇帐号或同时空，或同时有值。
			if(StringUtils.isNotEmpty(ds.getFcyacc()) && ds.getFcyamt() != null){
				result.append(isAmount22_0NotNull(ds.getFcyamt(), "现汇金额"));
				result.append(lessLen(ds.getFcyacc(), 32, "外汇帐号/银行卡号"));
			} else if(StringUtils.isEmpty(ds.getFcyacc()) && ds.getFcyamt()==null){
				// 允许两者同时为空
			} else {
				result.append("现汇金额、现汇帐号或同时空，或同时有值");
			}	
			// OTHAMT	其它金额	数值型，22.0	"选输项，但不能小于0。 若账号不为空则对应金额必须>0；若金额>0，则对应账号不能为空。
			// OTHACC	其它帐号/银行卡号	字符型，32	如果有其他金额，则该字段不能为空，其他金额为0，则该字段不应该填写，其它金额、其它帐号或同时空，或同时有值。
			if(StringUtils.isNotEmpty(ds.getOthacc()) && ds.getOthamt() != null){
				result.append(valGtZeroNotNull(ds.getOthamt(), "其它金额"));
				result.append(lessLen(ds.getOthacc(), 32, "其它帐号/银行卡号"));
			} else if (StringUtils.isEmpty(ds.getOthacc()) && ds.getOthamt()==null){
				// 允许两者同时为空
			} else {
				result.append("其它金额、其它帐号或同时空，或同时有值。");
			}
			// 结汇金额, 现汇金额, 其它金额至少输入一项。
			result.append(threeOptionOne(ds.getLcyamt(), ds.getFcyamt(), ds.getOthamt(), "结汇金额、现汇金额、其他金额"));
			// 结汇金额、现汇金额、其它金额之和不能大于收入款金额。
			BigDecimal talAmt = new BigDecimal(0);
			talAmt = talAmt.add(ds.getOthamt() != null ? ds.getOthamt() : new BigDecimal(0));
			talAmt = talAmt.add(ds.getFcyamt() != null ? ds.getFcyamt() : new BigDecimal(0));
			talAmt = talAmt.add(ds.getLcyamt() != null ? ds.getLcyamt() : new BigDecimal(0));
			if(ds.getTxamt().compareTo(talAmt) < 0){
				result.append("结汇金额、现汇金额、其它金额之和不能大于收入款金额。");
			}
			// METHOD	结算方式	字符型，1	"L－信用证G－保函C－托收T－电汇D－票汇M－信汇O－其他"
			result.append(valLenByNull(ds.getMethod(), 1, "结算方式"));
			// BUSCODE	银行业务编号	字符型，22	必输项
			result.append(lessLen(ds.getBuscode(), 22, "银行业务编号"));
			// INCHARGECCY	国内银行扣费币种	字符型，3	选输项，必须在币种代码表里存在
			// INCHARGEAMT	国内银行扣费金额	数值型，22.0	选输项，若输入，则输入的金额必须大于0，且没有小数位。
			// 国内扣费币种、金额必须同时输入。若币种不为空则对应金额必须>0；若金额>0，则对应币种不能为空。
			if(ds.getInchargeamt() != null && StringUtils.isNotEmpty(ds.getInchargeccy())){
				result.append(valLenByNotNull(ds.getInchargeccy(), 3, "国内银行扣费币种"));
				result.append(valGEZeroNull(ds.getInchargeamt(), "国内银行扣费金额"));
			} else if(ds.getInchargeamt()==null && StringUtils.isEmpty(ds.getInchargeccy())){
				// 允许两者同时为空
			} else {
				result.append("国内扣费币种、金额必须同时输入。");
			}			
			// OUTCHARGECCY	国外银行扣费币种	字符型，3	选输项，必须在币种代码表里存在
			// OUTCHARGEAMT	国外银行扣费金额	数值型，22.0	选输项，若输入，则输入的金额必须大于0，且没有小数位。
			// 国外扣费币种、金额必须同时输入。若币种不为空则对应金额必须>0；若金额>0，则对应币种不能为空。
			if(ds.getOutchargeamt() != null && StringUtils.isNotEmpty(ds.getOutchargeccy())){
				result.append(valLenByNotNull(ds.getOutchargeccy(), 3, "国外银行扣费币种"));
				result.append(valGEZeroNull(ds.getOutchargeamt(), "国外银行扣费金额"));
			} else if(ds.getOutchargeamt()==null&&StringUtils.isEmpty(ds.getOutchargeccy())){
				// 允许两者同时为空
			} else {
				result.append("国外扣费币种、金额必须同时输入。");
			}
		} else if (ds.getCurrentfile().equals(TopReportConstants.REPORT_FILE_TYPE_BOP_G)){
			// ACTIONTYPE	操作类型	字符型，1	A－新建 C－修改 D－删除，预留，暂不用。
			result.append(checkActiontype(ds.getActiontype()));
			// ACTIONDESC	修改/删除原因	字符型，128
			result.append(isModDelRemarkVaild(ds.getSubSuccess(), ds.getActiondesc()));
			// RPTNO	申报号码	字符型，22	应与基础数据一致
			result.append(valLenByNotNull(ds.getRptno(), 22, "申报号码"));
			// COUNTRY	付款人常驻国家/地区代码	字符型，3	必输项 使用国家/地区代码表中的3位字母代码
			result.append(valLenByNotNull(ds.getCountry(), 3, "收款人常驻国家/地区代码"));
			// PAYTYPE	收款性质	字符型，1	A－预收货款 R－退款  O-其它
			result.append(valLenByNull(ds.getPaytype(), 1, "收款性质"));
			//TXCODE	交易编码1	字符型，6	必输 必须在国际收支交易编码表中存在
			result.append(valLenByNull(ds.getTxcode(), 6, "交易编码1"));
			// TXREM	交易附言1	字符型，50	必输
			result.append(lessLenNull(ds.getTxrem(), 50, "交易附言1"));
			// TC1AMT	相应金额1	数值型，22.0	必输
			result.append(amtNotNull(ds.getTc1amt(), "相应金额1"));
			// TXCODE2	交易编码2	字符型，6	选输 
			// 必须在国际收支交易编码表中存在 不能与交易编码1相同， 没有输入交易编码时，相应金额及交易附言不应该填写。有交易金额2或交易附言2时必填。
			// TC2AMT	相应金额2	数值型，22.0	选输
			// 有交易编码2时必填。
			// TX2REM	交易附言2	字符型，50	选输 有交易编码2时必填。
			if(StringUtils.isNotEmpty(ds.getTxcode2()) && ds.getTc2amt() != null && StringUtils.isNotEmpty(ds.getTx2rem())){
				result.append(valLenByNull(ds.getTxcode2(), 6, "交易编码2"));
				result.append(lessLenNull(ds.getTx2rem(), 50, "交易附言2"));
			} else if (StringUtils.isEmpty(ds.getTxcode2()) && ds.getTc2amt() == null && StringUtils.isEmpty(ds.getTx2rem())){
				// 允许三者同时为空
			} else {
				result.append("交易编码2、相应金额2、交易附言2三个或同时空或同时有值。");
			}
			//两个交易编码对应的金额之和必须等于付款金额。
			BigDecimal talAmt = new BigDecimal(0);
			talAmt = talAmt.add(ds.getTc1amt() != null ? ds.getTc1amt() : new BigDecimal(0));
			talAmt = talAmt.add(ds.getTc2amt() != null ? ds.getTc2amt() : new BigDecimal(0));
			if(ds.getTxamt().compareTo(talAmt) != 0){
				result.append("两个交易编码对应的金额之和必须等于收入款金额。");
			}
			// ISREF	是否保税货物项下收汇	字符型，1	Y－是 	N－否
			result.append(isYorNAndNotNull(ds.getIsref(), "是否保税货物项下付款"));
			// BILLNO	外汇局批件号/备案表号/业务编号	字符型，50	选输项，资本项目项下交易（涉外收支交易编码以“5”、“6”、“7”、“8”和部分“9”开头，具体见10.2.3和10.2.4）的“外汇局批件号/备案表号/业务编号”为必输项。对于资本项目项下交易，如果确实没有对应的“外汇局批件号/备案表号/业务编号”，应填写“N/A”（大写英文字符）。
			result.append(lessLenNull(ds.getBillno(), 50, "外汇局批件号/备案表号/业务编号"));
			// PAYATTR	收入类型	字符型，1	选输项  F-福费廷 T-出口保理 N-出口押汇  D-出口贴现 O-其它
			result.append(valLenByNull(ds.getIsref(), 1, "收入类型"));
			// CRTUSER	填报人	字符型，20	必输项
			result.append(lessLen(ds.getCrtuser(), 20, "填报人"));
			// INPTELC	填报人电话	字符型，20	必输项
			result.append(lessLen(ds.getInptelc(), 20, "联系人电话"));
			// RPTDATE	申报日期	日期型， 8 YYYYMMDD	必填项，按申报主体真实申报日期填写。申报日期>=申报号码中的日期。
			result.append(valLenByNotNull(ds.getRptdate(), 8, "申报日期"));
		}
		return result.toString();
	}
}