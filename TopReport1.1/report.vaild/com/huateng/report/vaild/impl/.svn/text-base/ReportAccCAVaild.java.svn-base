package com.huateng.report.vaild.impl;

import java.util.List;

import resource.bean.report.BopAccDs;

import com.huateng.report.constants.TopReportConstants;
import com.huateng.report.vaild.absbean.AbsReportDataVaild;

import edu.emory.mathcs.backport.java.util.Arrays;

public class ReportAccCAVaild extends AbsReportDataVaild {

	@Override
	public String executeDataVaild( Object obj) {
		BopAccDs ds = (BopAccDs) obj;
		StringBuffer result = new StringBuffer();
		result.append(this.lessLen(ds.getBranchName(), 128, "金融机构名称"));
		result.append(this.lessLen(ds.getAccountno(),64,"账号"));
		if (ds.getCurrentfile().equals(TopReportConstants.REPORT_FILE_TYPE_ACC_CA)) {
			result.append(this.valLenByNotNull(ds.getBranchCode(), 12, "金融机构标识码"));
			result.append(this.valLenByNotNull(ds.getAccountstat(),2, "账户状态"));
			result.append(this.valLenByNotNull(ds.getAmtype(),2, "开户主体类型"));
			result.append(this.lessLen(ds.getEnCode(), 18, "开户主体代码"));
			result.append(this.lessLen(ds.getEnName(), 128, "开户主体名称"));
			result.append(this.valLenByNotNull(ds.getAccountType(), 4, "账户性质代码"));
			result.append(this.valLenByNotNull(ds.getAccountCata(), 2, "账户类别"));
			result.append(this.valLenByNotNull(ds.getCurrencyCode(), 3, "账户类别"));
			result.append(this.valLenByNotNull(ds.getBusinessDate(), 8, "业务发生日期"));
			//FILE_NUMBER	外汇局批件号/备案表号/业务编号	变长字符型，28	非必填项。
			//对除“境内划入保证金专用账户”以外的各类资本项目外汇账户的开立、变更、关户，为必填项。
			String[] accountTypes = new String[]{"2101","2102","2103","2104","2106","2107","2108","2109","2110","2111","2112","2201","2202","2301","2302","2303","2304","2305",
					"2306","2401","2402","2403","2404","2405","2406","2407","2408","2409","2410","2411","2412","2413","2414","2415","2416",
					"2417","2418","2419","2420","2421","2499","2901","2902","2903"};
			List<String> accountTypeList = Arrays.asList(accountTypes);
			if(accountTypeList.contains(ds.getAccountType())){
				result.append(this.lessLen(ds.getFileNumber(), 28, "外汇局批件号/备案表号/业务编号"));
			} else{
				result.append(this.lessLenNull(ds.getFileNumber(), 28, "外汇局批件号/备案表号/业务编号"));
			}
			result.append(this.valLenByNotNull(ds.getLimitType(), 2, "限额类型"));
			//ACCOUNT_LIMIT	账户限额	变长数值型，22.2	非必填项。如果“限额类型”选择“12”或“13”，则必填。
			if (!ds.getLimitType().equals("11")) {
				result.append(this.isAmountAndZero22_2NotNull(ds.getAccountLimit(),"账户限额"));
			} else {
				result.append(this.isAmountAndZero22_2(ds.getAccountLimit(),"账户限额"));
			}
			result.append(this.lessLenNull(ds.getRemark1(), 256, "备注"));
		} else {
			result.append(this.valLenByNotNull(ds.getDealDate(), 8, "发生日期"));
			result.append(this.lessLenNull(ds.getRemark2(), 256, "备注"));
			result.append(this.isAmountAndZero22_2(ds.getCredit(),"当日贷方发生额"));
			result.append(this.isAmountAndZero22_2(ds.getDebit(),"当日借方发生额"));
			result.append(this.isAmountAndZero22_2NotNull(ds.getBalance(),"账户余额"));
		}

		return result.toString();
	}

}
