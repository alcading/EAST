package com.huateng.report.vaild.bop.impl;

import java.math.BigDecimal;

import org.apache.commons.lang.StringUtils;

import resource.bean.report.MtsBopDrDs;

import com.huateng.report.vaild.absbean.AbsReportDataVaild;

public class ReportBopDVaild extends AbsReportDataVaild {

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
		result.append(this.valLenByNotNull(ds.getRptno(), 22, "申报号码"));
		result.append(this.valLenByNotNull(ds.getCustype(), 1, "收款人类型"));
		result.append(this.lessLenNull(ds.getIdcode(), 32, "个人身份证件号码"));
		result.append(this.valLenByNull(ds.getCustcod(), 9, "组织机构代码"));
		result.append(this.lessLen(ds.getCustnm(), 128, "收款人名称"));
		result.append(this.lessLen(ds.getOppuser(), 128, "付款人名称"));
		result.append(this.isAmount22_0NotNull(ds.getTxamt(), "收入款金额"));
		result.append(this.valLenByNotNull(ds.getTxccy(), 3, "收入款币种"));
		result.append(this.isRates13_8(ds.getExrate(), "结汇汇率"));
		result.append(this.isAmount22_0(ds.getLcyamt(), "结汇金额"));
		result.append(this.lessLenNull(ds.getLcyacc(), 32, "人民币帐号/银行卡号"));
		result.append(this.isAmount22_0(ds.getFcyamt(), "现汇金额"));
		result.append(this.lessLenNull(ds.getFcyacc(), 32, "外汇帐号/银行卡号"));
		result.append(this.isAmount22_0(ds.getOthamt(), "其他金额"));
		result.append(this.lessLenNull(ds.getOthacc(), 32, "其它帐号/银行卡号"));
		result.append(this.valLenByNull(ds.getMethod(), 1, "结算方式"));
		result.append(this.lessLen(ds.getBuscode(), 22, "银行业务编号"));
		result.append(this.valLenByNotNull(ds.getInchargeccy(), 3, "国内银行扣费币种"));
		result.append(this.isAmount22_0(ds.getInchargeamt(), "国内银行扣费金额"));
		
		//CUSTYPE<>c时 个人身份证件号码IDCODE必输  CUSTYPE=c时 组织机构代码CUSTCOD必输 

		result.append(this.valCusttype(ds.getCustype(), ds.getCustcod(), ds.getIdcode(), "购汇申请人主体类型"));


		//结汇汇率 EXRATE 当结汇金额大于0时必填，否则不应该填写
//		if(ds.getLcyamt()==null||ds.getLcyamt().compareTo(new BigDecimal(0)) ==0){
//			if(ds.getExrate()!=null){
//			result.append("结汇金额为空或为0时，结汇汇率应该空! ");
//			}
//		}else{
//			if(ds.getExrate()==null){
//				result.append("结汇金额大于0，结汇汇率必填! ");
//			}
//		}
		//LCYAMT  结汇金额  若账号不为空则对应金额必须>0；若金额>0，则对应账号不能为空。
//		if(ds.getLcyamt()!=null&&ds.getLcyamt().compareTo(new BigDecimal(0))>0&&StringUtils.isEmpty(ds.getLcyacc())){
//			result.append("结汇金额大于0时，人民币账号/银行卡号不能为空! ");
//		}
//		if(StringUtils.isNotEmpty(ds.getLcyacc())){
//			if(ds.getLcyamt()==null||ds.getLcyamt().compareTo(new BigDecimal(0))==0){
//				result.append("人民币账号/银行卡号不为空时，结汇金额必须大于0! ");
//			}
//		}
		//LCYACC人民币帐号/银行卡号   OTHAMT  结汇汇率 EXRATE  LCYAMT 人民币帐号/银行卡号,结汇汇率,结汇金额 要么全为空 ,要么全有值 
		if(StringUtils.isNotBlank(ds.getLcyacc())&&ds.getLcyamt()!=null &&ds.getExrate()!=null){
			;
		}else if(StringUtils.isBlank(ds.getLcyacc())&&ds.getLcyamt()==null&&ds.getExrate()==null){
			;
		}else{
			result.append("人民币帐号/银行卡号,结汇汇率,结汇金额 要么全为空 ,要么全有值! ");
		}
		//FCYAMT  现汇金额  若账号不为空则对应金额必须>0；若金额>0，则对应账号不能为空。  现汇金额 和账号要么同时有值 要么同时没值
	
		if(ds.getFcyamt()!=null&&ds.getFcyamt().compareTo(new BigDecimal(0))>0&&StringUtils.isEmpty(ds.getFcyacc())){
			result.append(" 现汇金额大于0时，外汇账号/银行卡号不能为空! ");
		}
		if(StringUtils.isNotEmpty(ds.getFcyacc())){
			if(ds.getFcyamt()==null||ds.getFcyamt().compareTo(new BigDecimal(0))==0){
				result.append("外汇账号/银行卡号不为空时， 现汇金额必须大于0! ");
			}
		}
		//OTHAMT 选输项，但不能小于0。
	    //若账号不为空则对应金额必须>0；若金额>0，则对应账号不能为空。
		//结汇金额, 现汇金额, 其它金额至少输入一项。
		//结汇金额、现汇金额、其它金额之和不能大于收入款金额。
	
		if(ds.getOthamt()!=null&&ds.getOthamt().compareTo(new BigDecimal(0))>0&&StringUtils.isEmpty(ds.getOthacc())){
				result.append(" 其它金额大于0时，其它帐号/银行卡号不能为空! ");
			}
		if(StringUtils.isNotEmpty(ds.getOthacc())){
			if(ds.getOthamt()==null||ds.getOthamt().compareTo(new BigDecimal(0))==0){
				result.append("其它帐号/银行卡号不为空时，其它金额必须大于0! ");
			}
		}
	
		result.append(this.threeOptionOne(ds.getOthamt(), ds.getLcyamt(), ds.getFcyamt(), "结汇金额,现汇金额,其他金额"));
		
		if(ds.getTxamt()!=null){
			BigDecimal bd = new BigDecimal(0) ;
			if(ds.getOthamt()!=null){
				bd = ds.getOthamt();
			}
			if(ds.getLcyamt()!=null){
				bd = bd.add(ds.getLcyamt());
			}
			if(ds.getFcyamt()!=null){
				bd = bd.add(ds.getFcyamt());
			}
			if(bd.compareTo(ds.getTxamt())>0){
				result.append("结汇金额,现汇金额,其他金额之和不能大于收入金额！ ");
			}
		}
		
		//国内银行扣费币种  INCHARGECCY 国内银行扣费金额 INCHARGEAMT 若币种不为空则对应金额必须>0；若金额>0，则对应币种不能为空。
		if(ds.getInchargeccy()!=null){
			if(ds.getInchargeamt()==null||ds.getInchargeamt().compareTo(new BigDecimal(0))==0){
				result.append("国内银行扣费币种不为空时,国内银行扣费金额必须大于0");
			}
		}
		if(ds.getInchargeamt()!=null&&StringUtils.isEmpty(ds.getInchargeccy())){
				result.append("国内银行扣费金额大于0时,国内银行扣费币种不能为空");
		}

		return result.toString();
	}
}
