package com.huateng.report.vaild.jsh.impl;

import resource.bean.report.MtsJshDefgDs;

import com.huateng.report.vaild.absbean.AbsReportDataVaild;

public class ReportJshEVaild extends AbsReportDataVaild {

	@Override
	public String executeDataVaild(Object obj) {
		// TODO Auto-generated method stub
		
		MtsJshDefgDs ds = (MtsJshDefgDs)obj;
		StringBuffer result = new StringBuffer();
		// ACTIONTYPE	操作类型	字符型，1	A－新建 C－修改 D－删除 R-申报无误（银行反馈），预留，暂不用。
		result.append(checkActiontype(ds.getActiontype()));
		//修改/删除原因或申报无误理由
		result.append(isModDelRemarkVaild(ds.getSubSuccess(), ds.getActiondesc()));
		//长度验证
		result.append(this.valLenByNotNull(ds.getRptno(), 22, "申报号码"));
		result.append(this.lessLenNull(ds.getBuscode(), 22, "银行业务编号"));
		result.append(this.valLenByNotNull(ds.getCustype(), 1, "购汇申请人主体类型"));
		result.append(this.valLenByNull(ds.getCustcod(), 9, "购汇申请人组织机构代码"));
		result.append(this.lessLenNull(ds.getIdcode(), 32, "购汇申请人个人身份证件号码"));
		result.append(this.lessLen(ds.getCustnm(), 128, "购汇申请人名称"));
		result.append(this.lessLenNull(ds.getLcyacc(), 32, "人民币账户账号"));
		result.append(this.lessLen(ds.getFcyacc(), 32, "外汇账户账号"));
		result.append(this.lessLen(ds.getOppuser(), 128, "外汇收款人名称"));
		result.append(this.lessLen(ds.getOppbank(), 256, "外汇账户开户行"));
		result.append(this.isAmount22_0NotNull(ds.getLcyamt(), "购汇金额（人民币）"));
		result.append(this.valLenByNotNull(ds.getLcyccy(), 3, "购汇币别购汇币别"));
		result.append(this.isRatesAndZero13_8NotNull(ds.getExrate(), "汇率"));		
		//CUSTYPE=C时 购汇申请人组织机构代码 CUSTCOD 必输   CUSTYPE<>C时 购汇申请人个人身份证件号码 IDCODE必输
		result.append(this.valCusttype(ds.getCustype(), ds.getCustcod(), ds.getIdcode(), "购汇申请人主体类型"));
		 //OPPUSER “外汇收款人名称”应与Custnm“购汇申请人名称”相同。
		 if(ds.getOppuser()!=null&&ds.getOppuser().equalsIgnoreCase(ds.getCustnm())){
			; 
		 }else{
			 result.append("外汇收款人名称应与购汇申请人名称相同");
		 }
		 
		 
		return result.toString();
	}

	

}
