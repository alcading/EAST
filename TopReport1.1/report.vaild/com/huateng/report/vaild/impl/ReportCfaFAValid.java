package com.huateng.report.vaild.impl;

import resource.bean.report.BopCfaStrdeDs;

import com.huateng.report.vaild.absbean.AbsReportDataVaild;


/**
 * @author ZHUhongyong
 * 商业银行人民币结构性存款签约信息验证
 */
public class ReportCfaFAValid extends AbsReportDataVaild {

	@Override
	public String executeDataVaild(Object obj) {
		// TODO Auto-generated method stub
		StringBuffer result = new StringBuffer();
		BopCfaStrdeDs bopCfaStrdeDs = (BopCfaStrdeDs)obj;
		//0.业务流水号
		result.append(this.exbuiSeNumVaild(bopCfaStrdeDs.getApptype(), bopCfaStrdeDs.getCurrentfile(), 
				bopCfaStrdeDs.getFiller2(), bopCfaStrdeDs.getBrNo()));
		//1.必填项。操作类型
		result.append(checkActiontype(bopCfaStrdeDs.getActiontype()));
		//2.如果ACTIONTYPE字段值为D，则此字段为必填字段。
		result.append(this.isDelRemarkVaild(bopCfaStrdeDs.getActiontype(), bopCfaStrdeDs.getActiondesc()));
		//3.必填项，人民币结构性存款唯一性编码。
		result.append(this.valLenByNotNull(bopCfaStrdeDs.getStrdecode(), 28, "人民币结构性存款编号"));
		//4.必填项，商业银行金融机构标识码。
		result.append(this.valLenByNotNull(bopCfaStrdeDs.getBrNo(), 12, "金融机构标识码"));
		//5.6.客户代码，客户名称暂时只验证必填（999999999和个人等待验证确认）
		result.append(this.isNull(bopCfaStrdeDs.getClientcode(), "客户代码"));
		result.append(this.isNull(bopCfaStrdeDs.getClientname(),"客户名称"));
		//7.必填项，格式YYYYMMDD，签约日期小于等于当前日期。
		/*当前日期*/
		result.append(AbsReportDataVaild.checkDateFormat(bopCfaStrdeDs.getContractdate(), "yyyyMMdd", "签约日期"));
		result.append(this.dateltCheckDateOrEqual(bopCfaStrdeDs.getContractdate(),"签约日期"));
		//8.必填项。合同号
		result.append(this.valLenByNotNull(bopCfaStrdeDs.getContract(), 32, "合同号"));
		//9.必填项，大于等于0。签约金额
		result.append(this.isAmountAndZero22_2(bopCfaStrdeDs.getContractamount(),"签约金额"));
		//10.必填项，格式YYYYMMDD，到期日大于等于签约日期。
		result.append(AbsReportDataVaild.checkDateFormat(bopCfaStrdeDs.getMaturity(), "yyyyMMdd", "签约日期"));
		result.append(this.dateLessCheckDateOrEqual(bopCfaStrdeDs.getContractdate(),bopCfaStrdeDs.getMaturity(),"签约日期","到期日"));
		//11.必填项。挂钩指标
		result.append(this.lessLen(bopCfaStrdeDs.getLincame(), 256, "挂钩指标"));
		//12.必填项。挂钩指标计算方法
		result.append(this.lessLen(bopCfaStrdeDs.getLincamethod(), 256, "挂钩指标计算方法"));
		//13.必填项，按小数填写，如利率为3.21%，则填写0.0321。可能小于0  约定的利率上限
		result.append(this.isRates13_8(bopCfaStrdeDs.getAginraup(), "约定的利率上限"));
		//14.必填项，按小数填写，如利率为3.21%，则填写0.0321。可能小于0 约定的利率下限
		result.append(this.isRates13_8(bopCfaStrdeDs.getAginralo(), "约定的利率下限"));
		//15.必填项，利息给付方式
		result.append(this.isNull(bopCfaStrdeDs.getAginraloinpay(), "利息给付方式"));
		//16.非必填项。备注
		result.append(this.lessLenNull(bopCfaStrdeDs.getRemark(), 256, "备注"));
		return result.toString();
	}
	
}
