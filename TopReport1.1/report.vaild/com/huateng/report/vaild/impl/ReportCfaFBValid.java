package com.huateng.report.vaild.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import resource.bean.report.BiDayexchangerate;
import resource.bean.report.BopCfaStrdeDs;
import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;

import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.report.vaild.absbean.AbsReportDataVaild;

/**
 * @author Administrator
 *	商业银行人民币结构性存款终止信息验证
 */
public class ReportCfaFBValid extends AbsReportDataVaild {

	@Override
	public String executeDataVaild(Object obj) {
		// TODO Auto-generated method stub
		StringBuffer result = new StringBuffer();
		BopCfaStrdeDs bopCfaStrdeDs = (BopCfaStrdeDs)obj;
		//0.业务流水号
		result.append(this.exbuiSeNumVaild(bopCfaStrdeDs.getApptype(), bopCfaStrdeDs.getCurrentfile(),
				bopCfaStrdeDs.getFiller2(), bopCfaStrdeDs.getBrNo()));
		//1.必填项	操作类型
		result.append(checkActiontype(bopCfaStrdeDs.getActiontype()));
		//2.如果ACTIONTYPE字段值为D，则此字段为必填字段。	删除原因
		result.append(this.isDelRemarkVaild(bopCfaStrdeDs.getActiontype(), bopCfaStrdeDs.getActiondesc()));
		//3.必填项，唯一性编码。 人民币结构性存款编号
		result.append(this.valLenByNotNull(bopCfaStrdeDs.getStrdecode(),28,"人民币结构性存款编号"));
		//4.必填项，金融机构标识码。
		result.append(this.valLenByNotNull(bopCfaStrdeDs.getBrNo(), 12, "金融机构标识码"));
		//5.终止类型  11：期满终止  12：提前终止	这里指验证有值，是两位
		result.append(this.valLenByNotNull(bopCfaStrdeDs.getTertype(), 2, "终止类型"));
		//6.必填项，记录终止情况编号。 终止支付编号
		result.append(this.valLenByNotNull(bopCfaStrdeDs.getTerpaycode(), 4, "终止支付编号"));
		//7.必填项，合同号
		result.append(this.lessLen(bopCfaStrdeDs.getContract(), 32, "合同号"));
		//8.必填项，格式YYYYMMDD,终止日期
		result.append(AbsReportDataVaild.checkDateFormat(bopCfaStrdeDs.getTerdate(), "yyyyMMdd", "终止日期"));
		//9.必填项，大于等于0。	终止支付金额合计折人民币   人民币结构性存款合同终止后，支付金额合计折人民币值，等于终止人民币支付金额+终止外币支付金额折人民币。
		result.append(this.isAmountAndZero22_2(bopCfaStrdeDs.getTerpayamtormb(),"终止支付金额合计折人民币"));
		result.append(this.equalOrNot(bopCfaStrdeDs));
		//10.非必填项，大于等于0，终止人民币支付金额与终止外币支付金额至少填一个。终止止人民币支付金额
		result.append(this.isAmount22_2(bopCfaStrdeDs.getTerrmbpayam(), "终止人民币支付金额 "));
		result.append(atLeastOne(bopCfaStrdeDs));
		//11.非必填项，见币种代码表。终止外币支付币种和终止外币支付金额为一组数据，两者同时为空或者不为空。  终止外币支付币种
		result.append(this.valLenByNull(bopCfaStrdeDs.getTerpaycurr(), 3, "终止外币支付币种"));
		result.append(this.sameOrNotSynchronic(bopCfaStrdeDs));
		//12.非必填项，大于等于0。终止外币支付金额
		result.append(this.isAmount22_2(bopCfaStrdeDs.getTerpaycurram(), "终止外币支付金额"));
		//13.备注
		result.append(this.lessLenNull(bopCfaStrdeDs.getRemark(), 256, "备注"));
		return result.toString();
	}
	/*
	 * 终止人民币支付金额与终止外币支付金额至少填一个
	 */
	private String atLeastOne(BopCfaStrdeDs bopCfaStrdeDs) {
		StringBuffer buff = new StringBuffer();
		BigDecimal terrmbpayam = bopCfaStrdeDs.getTerrmbpayam();
		BigDecimal terpaycurram = bopCfaStrdeDs.getTerpaycurram();
		if(terrmbpayam == null && terpaycurram == null) {
			buff.append("终止人民币支付金额与终止外币支付金额至少填一个");
		}
		return buff.toString();
	}
	/*
	 * 终止外币支付币种和终止外币支付金额
	 */
	private String sameOrNotSynchronic(BopCfaStrdeDs bopCfaStrdeDs) {
		StringBuffer buff = new StringBuffer();
		String terpaycurr = bopCfaStrdeDs.getTerpaycurr();
		BigDecimal terpaycurram  = bopCfaStrdeDs.getTerpaycurram();
		if(!(((terpaycurr == null || terpaycurr.length() == 0) && terpaycurram == null) || ((terpaycurr != null && terpaycurr.length() != 0) && terpaycurram != null))) {
			buff.append("终止外币支付币种和终止外币支付金额为一组数据，两者同时为空或者不为空!");
		}
		return buff.toString();
	}
	/*
	 * 终止支付金额合计折人民币   人民币结构性存款合同终止后，支付金额合计折人民币值，等于终止人民币支付金额+终止外币支付金额折人民币。
	 */
	private String equalOrNot(BopCfaStrdeDs bopCfaStrdeDs) {
		BigDecimal terpayamtormb = bopCfaStrdeDs.getTerpayamtormb();
		BigDecimal terrmbpayam = bopCfaStrdeDs.getTerrmbpayam();
		BigDecimal terpaycurram = bopCfaStrdeDs.getTerpaycurram();
		String terpaycurr = bopCfaStrdeDs.getTerpaycurr();
		String workDate = bopCfaStrdeDs.getTerdate();
		return equalOrNotResultString(terpaycurram, terpaycurr, workDate, terrmbpayam, terpayamtormb);
	}

	/*
	 *
	 */
	private String equalOrNotResultString(BigDecimal terpaycurram,String terpaycurr,String workDate,BigDecimal terrmbpayam,BigDecimal terpayamtormb)
	{
		StringBuffer buff = new StringBuffer();
		//如果没有终止外币支付金额
		if(terpaycurr == null || terpaycurram == null || terpaycurr.length() == 0) {
			if(!terrmbpayam.equals(terpayamtormb)) {
				buff.append("终止支付金额合计折人民币值，必须等于终止人民币支付金额!");
				return buff.toString();
			} else {
				return buff.toString();
			}
		}
		if("CNY".equalsIgnoreCase(terpaycurr))
		{
			if(!terpayamtormb.equals(terpaycurram.add(terrmbpayam))) {
				buff.append("终止支付金额合计折人民币值，必须等于终止人民币支付金额和终止外币支付金额折人民币的总和!");
				return buff.toString();
			} else {
				return buff.toString();
			}
		}
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		List<BiDayexchangerate> dayList = new ArrayList<BiDayexchangerate>();
		BiDayexchangerate biDay =null;
		BigDecimal toExCNY = new BigDecimal(0).setScale(2);
		StringBuffer hql = new StringBuffer("");
		hql.append(" from BiDayexchangerate bimon where id='"+terpaycurr+"'");
		try {
			dayList = rootdao.queryByQL2List(hql.toString());
		} catch (CommonException e) {
			// TODO Auto-generated catch block
			buff.append("查询外汇日牌价错误！");
			return buff.toString();
		}

		if(null ==dayList || dayList.size()==0)
		{
			buff.append("外汇日牌价不存在相应的记录！");
			return buff.toString();
		}

		for(Object dayObj : dayList)
		{
			biDay = (BiDayexchangerate)dayObj;
			if(null ==biDay)
			{
				buff.append("外汇日牌价不存在相应的记录！");
				return buff.toString();
			}
			if(null !=biDay && "4".equalsIgnoreCase(biDay.getSt()))
			{
				toExCNY = terpaycurram.divide(biDay.getRateUnit()).multiply(biDay.getRateMidprice());
			}else if(null !=biDay && !"4".equalsIgnoreCase(biDay.getSt()))
			{
				buff.append("请检查 外汇日牌价的[主管确认]是否已经完成！");
				return buff.toString();
			}
		}
		if(!terpayamtormb.equals(toExCNY.add(terrmbpayam))) {
			buff.append("终止支付金额合计折人民币值，必须等于终止人民币支付金额和终止外币支付金额折人民币的总和!");
		}
		return buff.toString();
	}
}
