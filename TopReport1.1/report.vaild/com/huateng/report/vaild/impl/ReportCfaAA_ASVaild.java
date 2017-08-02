package com.huateng.report.vaild.impl;


import java.math.BigDecimal;
import java.util.List;

import resource.bean.report.BopCfaCreditorDs;
import resource.bean.report.BopCfaExdebtDs;
import resource.bean.report.BopProjectInfo;
import resource.bean.report.base.BaseBopProjectInfo;

import com.huateng.report.constants.TopReportConstants;
import com.huateng.report.vaild.absbean.AbsReportDataVaild;

public class ReportCfaAA_ASVaild extends AbsReportDataVaild {

	@SuppressWarnings("unchecked")
	public String executeDataVaild( Object obj) {
		BopCfaExdebtDs eds = (BopCfaExdebtDs) obj;
		StringBuffer result = new StringBuffer();

		if (TopReportConstants.REPORT_FILE_TYPE_CFA_AA.equals(eds.getCurrentfile())) {
			result.append(exbuiSeNumVaild(eds.getActiontype(), eds.getCurrentfile(), eds.getFiller2(), eds.getBrNo()));
			result.append(checkActiontype(eds.getActiontype()));
//			result.append(lessLen(eds.getActiontype(), 1, "操作类型"));
			result.append(isDelRemarkVaild(eds.getActiontype(), eds.getActiondesc()));
			result.append(lessLenNull(eds.getActiondesc(), 128, "删除原因"));
			result.append(valLenByNotNull(eds.getExdebtcode(), 28, "外债编号"));
			result.append(lessLen(eds.getDebtorcode(), 12, "债务人代码"));
			result.append(valLenByNotNull(eds.getDebtype(), 4, "债务类型"));
			result.append(valLenByNotNull(eds.getContractdate(), 8, "签约日期"));
			result.append(dateltCheckDateOrEqual(eds.getContractdate(),"签约日期"));
			result.append(checkDateFormat(eds.getContractdate(), "yyyyMMdd", "签约日期"));
			result.append(valLenByNotNull(eds.getValuedate(), 8, "起息日"));
			result.append(checkDateFormat(eds.getValuedate(), "yyyyMMdd", "起息日"));
			result.append(dateLessCheckDateOrEqual(eds.getContractdate(), eds.getValuedate(), "签约日期", "起息日"));
			result.append(valLenByNotNull(eds.getContractcurr(), 3, "签约币种"));
			result.append(isAmountAndZero22_2NotNull(eds.getContractamount(), "签约金额"));
			result.append(valLenByNotNull(eds.getMaturity(), 8, "到期日"));
			result.append(checkDateFormat(eds.getMaturity(), "yyyyMMdd", "到期日"));
			result.append(dateLessCheckDateOrEqual(eds.getValuedate(), eds.getMaturity(), "起息日", "到期日"));
//			result.append(this.lessLen(eds.getFloatrate(), 1, "是否浮动利率"));
			result.append(isYorNAndNotNull(eds.getFloatrate(), "是否浮动利率"));

			result.append(isRatesAndZero13_8NotNull(eds.getAnninrate(), "年化利率值"));
			result.append(lessLenNull(eds.getCreditorcode(), 11, "债权人代码"));
			result.append(validateCreditorCodeNull(eds.getCreditortype(), eds.getCreditorcode(), TopReportConstants.REPORT_FILE_TYPE_CFA_AA, eds.getCrehqcode()));

			result.append(optionOne(eds.getCreditorname(), eds.getCreditornamen(), "债权人中文名称或英文名称"));
			result.append(lessLenNull(eds.getCreditorname(), 128, "债权人中文名称"));
			result.append(lessLenNull(eds.getCreditornamen(), 128, "债权人英文名称"));

			result.append(valLenByNotNull(eds.getCreditortype(), 8, "债权人类型代码"));
			result.append(valLenByNotNull(eds.getCrehqcode(), 3, "债权人总部所在国家（地区）代码"));
			result.append(valLenByNotNull(eds.getOpercode(), 3, "债权人经营地所在国家（地区）代码"));
//			result.append(this.lessLen(eds.getInprterm(), 1, "是否有利息本金化条款"));
			result.append(isYorNAndNotNull(eds.getInprterm(), "是否有利息本金化条款"));
			result.append(isYorNAndNotNull(eds.getSpapfeboindex(), "是否经外汇局特批不需占用指标"));

			if(eds.getProjects() != null && eds.getProjects().size() != 0) {
				for(Object pj : eds.getProjects()) {
					BaseBopProjectInfo projectInfo = (BaseBopProjectInfo)pj;
					result.append(lessLen(projectInfo.getProjectname(), 128, "项目名称"));
				}
			}
			result.append(lessLenNull(eds.getRemark(), 256, "备注"));
		}else if(TopReportConstants.REPORT_FILE_TYPE_CFA_AB.equals( eds.getCurrentfile()))
		{
			result.append(exbuiSeNumVaild(eds.getActiontype(), eds.getCurrentfile(), eds.getFiller2(), eds.getBrNo()));
			result.append(checkActiontype(eds.getActiontype()));
//			result.append(this.lessLen(eds.getActiontype(), 1, "操作类型"));
			result.append(isDelRemarkVaild(eds.getActiontype(), eds.getActiondesc()));
			result.append(lessLenNull(eds.getActiondesc(), 128, "删除原因"));
			result.append(valLenByNotNull(eds.getExdebtcode(), 28, "外债编号"));
			result.append(lessLen(eds.getDebtorcode(), 12, "债务人代码"));
			result.append(valLenByNotNull(eds.getDebtype(), 4, "债务类型"));
			result.append(valLenByNotNull(eds.getContractdate(), 8, "签约日期"));
			result.append(dateltCheckDateOrEqual(eds.getContractdate(),"签约日期"));
			result.append(checkDateFormat(eds.getContractdate(), "yyyyMMdd", "签约日期"));
			result.append(valLenByNotNull(eds.getValuedate(), 8, "起息日"));
			result.append(checkDateFormat(eds.getValuedate(), "yyyyMMdd", "起息日"));
			result.append(dateLessCheckDateOrEqual(eds.getContractdate(), eds.getValuedate(), "签约日期", "起息日"));
			result.append(valLenByNotNull(eds.getContractcurr(), 3, "签约币种"));
			result.append(isAmountAndZero22_2NotNull(eds.getContractamount(), "签约金额"));
			result.append(valLenByNotNull(eds.getMaturity(), 8, "到期日"));
			result.append(checkDateFormat(eds.getMaturity(), "yyyyMMdd", "到期日"));
			result.append(dateLessCheckDateOrEqual(eds.getValuedate(), eds.getMaturity(), "起息日", "到期日"));
			result.append(isYorNAndNotNull(eds.getFloatrate(), "是否浮动利率"));
			result.append(isRatesAndZero13_8NotNull(eds.getAnninrate(), "年化利率值"));
			result.append(lessLenNull(eds.getCreditorcode(), 11, "债权人代码"));
			result.append(validateCreditorCodeNull(eds.getCreditortype(), eds.getCreditorcode(), TopReportConstants.REPORT_FILE_TYPE_CFA_AB, eds.getCrehqcode()));
			result.append(optionOne(eds.getCreditorname(), eds.getCreditornamen(), "债权人中文名称或英文名称"));
			result.append(lessLenNull(eds.getCreditorname(), 128, "债权人中文名称"));
			result.append(lessLenNull(eds.getCreditornamen(), 128, "债权人英文名称"));
			result.append(valLenByNotNull(eds.getCreditortype(), 8, "债权人类型代码"));
			result.append(valLenByNotNull(eds.getCrehqcode(), 3, "债权人总部所在国家（地区）代码"));
			result.append(valLenByNotNull(eds.getOpercode(), 3, "债权人经营地所在国家（地区）代码"));
			result.append(isYorNAndNotNull(eds.getInprterm(), "是否有利息本金化条款"));
			result.append(isYorNAndNotNull(eds.getSpapfeboindex(), "是否经外汇局特批不需占用指标"));
			if(eds.getProjects() != null && eds.getProjects().size() != 0) {
				for(Object pj : eds.getProjects()) {
					BaseBopProjectInfo projectInfo = (BaseBopProjectInfo)pj;
					result.append(lessLen(projectInfo.getProjectname(), 128, "项目名称"));
				}
			}
			result.append(lessLenNull(eds.getRemark(), 256, "备注"));
		}else if(TopReportConstants.REPORT_FILE_TYPE_CFA_AC.equals( eds.getCurrentfile()))
		{
			result.append(exbuiSeNumVaild(eds.getActiontype(), eds.getCurrentfile(), eds.getFiller2(), eds.getBrNo()));
			result.append(checkActiontype(eds.getActiontype()));
//			result.append(this.lessLen(eds.getActiontype(), 1, "操作类型"));
			result.append(isDelRemarkVaild(eds.getActiontype(), eds.getActiondesc()));
			result.append(lessLenNull(eds.getActiondesc(), 128, "删除原因"));
			result.append(valLenByNotNull(eds.getExdebtcode(), 28, "外债编号"));
			result.append(lessLen(eds.getDebtorcode(), 12, "债务人代码"));
			result.append(valLenByNotNull(eds.getDebtype(), 4, "债务类型"));
			result.append(valLenByNotNull(eds.getValuedate(), 8, "起息日"));
			result.append(checkDateFormat(eds.getValuedate(), "yyyyMMdd", "起息日"));
			result.append(valLenByNotNull(eds.getContractcurr(), 3, "签约币种"));
			result.append(isAmountAndZero22_2NotNull(eds.getContractamount(), "签约金额"));
			result.append(valLenByNotNull(eds.getMaturity(), 8, "到期日"));
			result.append(checkDateFormat(eds.getMaturity(), "yyyyMMdd", "到期日"));
			result.append(dateLessCheckDateOrEqual(eds.getValuedate(), eds.getMaturity(), "起息日", "到期日"));
			result.append(isYorNAndNotNull(eds.getFloatrate(), "是否浮动利率"));
			result.append(isRatesAndZero13_8NotNull(eds.getAnninrate(), "年化利率值"));
			result.append(lessLenNull(eds.getCreditorcode(), 11, "债权人代码"));
			result.append(validateCreditorCodeNull(eds.getCreditortype(), eds.getCreditorcode(), TopReportConstants.REPORT_FILE_TYPE_CFA_AC, eds.getCrehqcode()));
			result.append(optionOne(eds.getCreditorname(), eds.getCreditornamen(), "债权人中文名称或英文名称"));
			result.append(lessLenNull(eds.getCreditorname(), 128, "债权人中文名称"));
			result.append(lessLenNull(eds.getCreditornamen(), 128, "债权人英文名称"));

			result.append(valLenByNotNull(eds.getCreditortype(), 8, "债权人类型代码"));
			result.append(valLenByNotNull(eds.getCrehqcode(), 3, "债权人总部所在国家（地区）代码"));
			result.append(valLenByNotNull(eds.getOpercode(), 3, "债权人经营地所在国家（地区）代码"));
			result.append(isYorNAndNotNull(eds.getInprterm(), "是否有利息本金化条款"));
			result.append(isYorNAndNotNull(eds.getSpapfeboindex(), "是否经外汇局特批不需占用指标"));
			result.append(lessLenNull(eds.getRemark(), 256, "备注"));
		}else if(TopReportConstants.REPORT_FILE_TYPE_CFA_AD.equals( eds.getCurrentfile()))
		{
			result.append(exbuiSeNumVaild(eds.getActiontype(), eds.getCurrentfile(), eds.getFiller2(), eds.getBrNo()));
			result.append(checkActiontype(eds.getActiontype()));
//			result.append(this.lessLen(eds.getActiontype(), 1, "操作类型"));
			result.append(isDelRemarkVaild(eds.getActiontype(), eds.getActiondesc()));
			result.append(lessLenNull(eds.getActiondesc(), 128, "删除原因"));
			result.append(valLenByNotNull(eds.getExdebtcode(), 28, "外债编号"));
			result.append(lessLen(eds.getDebtorcode(), 12, "债务人代码"));
			result.append(valLenByNotNull(eds.getDebtype(), 4, "债务类型"));
			result.append(valLenByNotNull(eds.getValuedate(), 8, "起息日"));
			result.append(checkDateFormat(eds.getValuedate(), "yyyyMMdd", "起息日"));
			result.append(valLenByNotNull(eds.getContractcurr(), 3, "签约币种"));
			result.append(isAmountAndZero22_2NotNull(eds.getContractamount(), "签约金额"));
			result.append(valLenByNotNull(eds.getMaturity(), 8, "到期日"));
			result.append(checkDateFormat(eds.getMaturity(), "yyyyMMdd", "到期日"));
			result.append(dateLessCheckDateOrEqual(eds.getValuedate(), eds.getMaturity(), "起息日", "到期日"));
			result.append(isYorNAndNotNull(eds.getFloatrate(), "是否浮动利率"));
			result.append(isRatesAndZero13_8NotNull(eds.getAnninrate(), "年化利率值"));
			result.append(lessLenNull(eds.getCreditorcode(), 11, "债权人代码"));
			result.append(validateCreditorCodeNull(eds.getCreditortype(), eds.getCreditorcode(), TopReportConstants.REPORT_FILE_TYPE_CFA_AD, eds.getCrehqcode()));
			result.append(optionOne(eds.getCreditorname(), eds.getCreditornamen(), "债权人中文名称或英文名称"));
			result.append(valLenByNotNull(eds.getCreditortype(), 8, "债权人类型代码"));
			result.append(valLenByNotNull(eds.getCrehqcode(), 3, "债权人总部所在国家（地区）代码"));
			result.append(valLenByNotNull(eds.getOpercode(), 3, "债权人经营地所在国家（地区）代码"));
			result.append(lessLenNull(eds.getAppcode(), 18, "申请人代码"));
			result.append(lessLen(eds.getAppname(), 128, "申请人名称"));
			result.append(lessLenNull(eds.getInltcabuscode(), 32, "承继的远期信用证承兑银行业务参号"));
			result.append(isYorNAndNotNull(eds.getSpapfeboindex(), "是否经外汇局特批不需占用指标"));
			result.append(lessLenNull(eds.getRemark(), 256, "备注"));
		} else if (TopReportConstants.REPORT_FILE_TYPE_CFA_AE.equals(eds.getCurrentfile())) {
			result.append(checkActiontype(eds.getActiontype()));
			if (eds.getActiontype().equals(TopReportConstants.REPORT_ACTIONTYPE_D)) {
				result.append(isDelRemarkVaild(eds.getActiontype(), eds.getActiondesc()));
				result.append(lessLen(eds.getActiondesc(), 128, "删除原因"));
			} else {
				result.append(isDelRemarkVaild(eds.getActiontype(), eds.getActiondesc()));

				result.append(exbuiSeNumVaild(eds.getActiontype(), eds.getCurrentfile(), eds.getFiller2(), eds.getBrNo()));
				result.append(valLenByNotNull(eds.getExdebtcode(), 28, "外债编号"));
				result.append(lessLen(eds.getDebtorcode(), 12, "债务人代码"));
				result.append(valLenByNotNull(eds.getDebtype(), 4, "债务类型"));
				result.append(valLenByNotNull(eds.getValuedate(), 8, "起息日"));
				result.append(checkDateFormat(eds.getValuedate(), "yyyyMMdd", "起息日"));

				result.append(valLenByNotNull(eds.getContractcurr(), 3, "签约币种"));
				result.append(isAmountAndZero22_2(eds.getContractamount(), "签约金额"));
				result.append(valLenByNotNull(eds.getMaturity(), 8, "到期日"));
				result.append(checkDateFormat(eds.getMaturity(), "yyyyMMdd", "到期日"));

				result.append(dateLessCheckDateOrEqual(eds.getValuedate(), eds.getMaturity(), "起息日", "到期日"));
				result.append(isYorNAndNotNull(eds.getFloatrate(), "是否浮动利率"));
				result.append(isRatesAndZero13_8(eds.getAnninrate(), "年化利率值"));
				result.append(isAmountAndZero22_2(eds.getInpriamount(), "利息本金化金额"));
				result.append(lessLenNull(eds.getCreditorcode(), 11, "债权人代码"));
				result.append(validateCreditorCodeNull(eds.getCreditortype(), eds.getCreditorcode(), TopReportConstants.REPORT_FILE_TYPE_CFA_AE, eds.getCrehqcode()));

				result.append(optionOne(eds.getCreditorname(), eds.getCreditornamen(), "债权人中文名称或英文名称"));
				result.append(lessLenNull(eds.getCreditorname(), 128, "债权人中文名称"));
				result.append(lessLenNull(eds.getCreditornamen(), 128, "债权人英文名称"));

				result.append(valLenByNotNull(eds.getCreditortype(), 8, "债权人类型代码"));
				result.append(valLenByNotNull(eds.getCrehqcode(), 3, "债权人总部所在国家（地区）代码"));
				result.append(valLenByNotNull(eds.getOpercode(), 3, "债权人经营地所在国家（地区）代码"));
				result.append(isYorNAndNotNull(eds.getSpapfeboindex(), "是否经外汇局特批不需占用指标"));
				result.append(lessLenNull(eds.getRemark(), 256, "备注"));
			}
			return result.toString();

		} else if (TopReportConstants.REPORT_FILE_TYPE_CFA_AF.equals(eds.getCurrentfile())) {
			result.append(checkActiontype(eds.getActiontype()));
			if (eds.getActiontype().equals(TopReportConstants.REPORT_ACTIONTYPE_D)) {
				result.append(isDelRemarkVaild(eds.getActiontype(), eds.getActiondesc()));
				result.append(lessLen(eds.getActiondesc(), 128, "删除原因"));
			} else {

				result.append(isDelRemarkVaild(eds.getActiontype(), eds.getActiondesc()));

				result.append(exbuiSeNumVaild(eds.getActiontype(), eds.getCurrentfile(), eds.getFiller2(), eds.getBrNo()));
				result.append(valLenByNotNull(eds.getExdebtcode(), 28, "外债编号"));
				result.append(lessLen(eds.getDebtorcode(), 12, "债务人代码"));
				result.append(valLenByNotNull(eds.getDebtype(), 4, "债务类型"));
				result.append(valLenByNotNull(eds.getValuedate(), 8, "起息日"));
				result.append(checkDateFormat(eds.getValuedate(), "yyyyMMdd", "起息日"));

				result.append(valLenByNotNull(eds.getContractcurr(), 3, "签约币种"));
				result.append(isAmountAndZero22_2(eds.getContractamount(), "签约金额"));

				result.append(valLenByNotNull(eds.getMaturity(), 8, "到期日"));
				result.append(checkDateFormat(eds.getMaturity(), "yyyyMMdd", "到期日"));
				result.append(dateLessCheckDateOrEqual(eds.getValuedate(), eds.getMaturity(), "起息日", "到期日"));

				result.append(lessLenNull(eds.getAppcode(), 18, "开证申请人代码"));
				result.append(lessLen(eds.getAppname(), 128, "开证申请人名称"));
				result.append(lessLenNull(eds.getCreditorcode(), 11, "债权人代码"));
				result.append(validateCreditorCodeNull(eds.getCreditortype(), eds.getCreditorcode(), TopReportConstants.REPORT_FILE_TYPE_CFA_AF, eds.getCrehqcode()));

				result.append(optionOne(eds.getCreditorname(), eds.getCreditornamen(), "债权人中文名称或英文名称"));
				result.append(lessLenNull(eds.getCreditorname(), 128, "债权人中文名称"));
				result.append(lessLenNull(eds.getCreditornamen(), 128, "债权人英文名称"));

				result.append(valLenByNotNull(eds.getCreditortype(), 8, "债权人类型代码"));
				result.append(valLenByNotNull(eds.getCrehqcode(), 3, "债权人总部所在国家（地区）代码"));
				result.append(valLenByNotNull(eds.getOpercode(), 3, "债权人经营地所在国家（地区）代码"));

				result.append(isYorNAndNotNull(eds.getSpapfeboindex(), "是否经外汇局特批不需占用指标"));
				result.append(lessLenNull(eds.getRemark(), 256, "备注"));
			}
			return result.toString();
		} else if (TopReportConstants.REPORT_FILE_TYPE_CFA_AG.equals(eds
				.getCurrentfile())) {
			result.append(checkActiontype(eds.getActiontype()));
			if (eds.getActiontype().equals(TopReportConstants.REPORT_ACTIONTYPE_D)) {
				result.append(isDelRemarkVaild(eds.getActiontype(), eds.getActiondesc()));
				result.append(lessLen(eds.getActiondesc(), 128, "删除原因"));
			} else {
				result.append(isDelRemarkVaild(eds.getActiontype(), eds.getActiondesc()));

				result.append(exbuiSeNumVaild(eds.getActiontype(), eds.getCurrentfile(), eds.getFiller2(), eds.getBrNo()));
				result.append(valLenByNotNull(eds.getExdebtcode(), 28, "外债编号"));
				result.append(lessLen(eds.getDebtorcode(), 12, "债务人代码"));
				result.append(valLenByNotNull(eds.getDebtype(), 4, "债务类型"));
				result.append(valLenByNotNull(eds.getValuedate(), 8, "起息日"));
				result.append(checkDateFormat(eds.getValuedate(), "yyyyMMdd", "起息日"));

				result.append(valLenByNotNull(eds.getContractcurr(), 3, "签约币种"));
				result.append(isAmountAndZero22_2(eds.getContractamount(), "签约金额"));
				result.append(valLenByNotNull(eds.getMaturity(), 8, "到期日"));
				result.append(checkDateFormat(eds.getMaturity(), "yyyyMMdd", "到期日"));

				result.append(dateLessCheckDateOrEqual(eds.getValuedate(), eds.getMaturity(), "起息日", "到期日"));
				result.append(isYorNAndNotNull(eds.getFloatrate(), "是否浮动利率"));
				result.append(isRatesAndZero13_8(eds.getAnninrate(), "年化利率值"));
				List<BopCfaCreditorDs> queryBopCfaCreditorDsList = eds.getCreditors();
				BigDecimal allamount = new BigDecimal(0);
				for (BopCfaCreditorDs ds : queryBopCfaCreditorDsList) {

					result.append(lessLenNull(ds.getCreditorcode(), 11, "债权人代码"));
					result.append(valLenByNotNull(ds.getCreditortype(), 8, "债权人类型代码"));
					result.append(validateCreditorCodeNull(ds.getCreditortype(), ds.getCreditorcode(), TopReportConstants.REPORT_FILE_TYPE_CFA_AG, ds.getCrehqcode()));

					result.append(optionOne(ds.getCreditorname(), ds.getCreditornamen(), "债权人中文名称或英文名称"));
					result.append(lessLenNull(ds.getCreditorname(), 128, "债权人中文名称"));
					result.append(lessLenNull(ds.getCreditornamen(), 128, "债权人英文名称"));

					result.append(isAmountAndZero22_2(ds.getCreditorca(), "债权人签约金额"));


					result.append(valLenByNotNull(ds.getCrehqcode(), 3, "债权人总部所在国家（地区）代码"));
					result.append(valLenByNotNull(ds.getOpercode(), 3, "债权人经营地所在国家（地区）代码"));
					allamount = allamount.add(ds.getCreditorca());
				}
				result.append(isAmountEqual(allamount,eds.getContractamount(), "所有债权人签约金额之和", "签约金额"));
				List<BopProjectInfo> queryBopProjectInfoList = eds.getProjects();
				for (BopProjectInfo project : queryBopProjectInfoList) {
					result.append(lessLenNull(project.getProjectname(), 128, "项目名称"));
				}
				result.append(isYorNAndNotNull(eds.getInprterm(), "是否有利息本金化条款"));
				result.append(isYorNAndNotNull(eds.getSpapfeboindex(), "是否经外汇局特批不需占用指标"));

				result.append(lessLenNull(eds.getRemark(), 256, "备注"));
			}
			return result.toString();

		} else if (TopReportConstants.REPORT_FILE_TYPE_CFA_AH.equals(eds.getCurrentfile())) {
			result.append(checkActiontype(eds.getActiontype()));
			if (eds.getActiontype().equals(TopReportConstants.REPORT_ACTIONTYPE_D)) {
				result.append(isDelRemarkVaild(eds.getActiontype(), eds.getActiondesc()));
				result.append(lessLen(eds.getActiondesc(), 128, "删除原因"));
			} else {

				result.append(isDelRemarkVaild(eds.getActiontype(), eds.getActiondesc()));

				result.append(exbuiSeNumVaild(eds.getActiontype(), eds.getCurrentfile(), eds.getFiller2(), eds.getBrNo()));
				result.append(valLenByNotNull(eds.getExdebtcode(), 28, "外债编号"));
				result.append(lessLen(eds.getDebtorcode(), 12, "债务人代码"));
				result.append(valLenByNotNull(eds.getDebtype(), 4, "债务类型"));
				result.append(valLenByNotNull(eds.getValuedate(), 8, "起息日"));
				result.append(checkDateFormat(eds.getValuedate(), "yyyyMMdd", "起息日"));

				result.append(valLenByNotNull(eds.getContractcurr(), 3, "签约币种"));
				result.append(isAmountAndZero22_2(eds.getContractamount(), "签约金额"));
				result.append(valLenByNotNull(eds.getMaturity(), 8, "到期日"));
				result.append(checkDateFormat(eds.getMaturity(), "yyyyMMdd", "到期日"));
				result.append(dateLessCheckDateOrEqual(eds.getValuedate(), eds.getMaturity(), "起息日", "到期日"));

				result.append(isYorNAndNotNull(eds.getFloatrate(), "是否浮动利率"));
				result.append(isRatesAndZero13_8(eds.getAnninrate(), "年化利率值"));
				result.append(lessLenNull(eds.getCreditorcode(), 11, "债权人代码"));
				result.append(validateCreditorCodeNull(eds.getCreditortype(), eds.getCreditorcode(), TopReportConstants.REPORT_FILE_TYPE_CFA_AH, eds.getCrehqcode()));

				result.append(lessLenNull(eds.getCreditorname(), 128, "债权人中文名称"));
				result.append(lessLenNull(eds.getCreditornamen(), 128, "债权人英文名称"));
				result.append(optionOne(eds.getCreditorname(), eds.getCreditornamen(), "债权人中文名称或英文名称"));

				result.append(valLenByNotNull(eds.getCreditortype(), 8, "债权人类型代码"));
				result.append(valLenByNotNull(eds.getCrehqcode(), 3, "债权人总部所在国家（地区）代码"));
				result.append(valLenByNotNull(eds.getOpercode(), 3, "债权人经营地所在国家（地区）代码"));
				result.append(isYorNAndNotNull(eds.getInprterm(), "是否有利息本金化条款"));
				result.append(isYorNAndNotNull(eds.getSpapfeboindex(), "是否经外汇局特批不需占用指标"));
				result.append(lessLenNull(eds.getRemark(), 256, "备注"));
			}
			return result.toString();

		} else if (TopReportConstants.REPORT_FILE_TYPE_CFA_AI.equals(eds.getCurrentfile())) {
			/** AI 其他贷款 Begin **/
			// 操作类型	字符型，1	必填项， A－新建 C－修改 D－删除，一旦银行报送了该外债编号下的变动信息，就不可以删除了。
			result.append(checkActiontype(eds.getActiontype()));
			// 删除原因	字符型，128	如果ACTIONTYPE字段值为D，则此字段为必填字段。
			result.append(isDelRemarkVaild(eds.getActiontype(), eds.getActiondesc()));
			result.append(lessLenNull(eds.getActiondesc(), 128, "删除原因"));
			// 外债编号	字符型，28	必填项， 外债唯一性编码。
			result.append(valLenByNotNull(eds.getExdebtcode(), 28, "外债编号"));
			// 债务人代码	字符型，12	必填项， 金融机构标识码。
			result.append(valLenByNotNull(eds.getDebtorcode(), 12, "债务人代码"));
			// 债务类型	字符型，4	必填项，见债务类型代码表。
			result.append(valLenByNotNull(eds.getDebtype(), 4, "债务类型"));
			// 债务类型备注	字符型，128	必填项。
			result.append(lessLen(eds.getDebtyperema(), 128, "债务类型备注"));
			// 起息日	日期型，8	必填项，格式YYYYMMDD。
			result.append(valLenByNotNull(eds.getValuedate(), 8, "起息日"));
			result.append(checkDateFormat(eds.getValuedate(), "yyyyMMdd", "起息日"));
			// 签约币种	字符型，3	必填项
			result.append(valLenByNotNull(eds.getContractcurr(), 3, "签约币种"));
			// 签约金额	数值型，22.2	必填项，大于等于0。
			result.append(isAmountAndZero22_2(eds.getContractamount(), "签约金额"));
			// 到期日 必填项，格式YYYYMMDD，大于等于起息日。
			result.append(valLenByNotNull(eds.getMaturity(), 8, "到期日"));
			result.append(checkDateFormat(eds.getMaturity(), "yyyyMMdd", "到期日"));
			result.append(dateLessCheckDateOrEqual(eds.getValuedate(), eds.getMaturity(), "起息日", "到期日"));
			// 是否浮动利率 必填项，是-Y，否-N，默认为否，填写N。
			result.append(isYorNAndNotNull(eds.getFloatrate(), "是否浮动利率"));
			// 年化利率值	数值型，13.8	必填项，大于等于0，按小数填写，如利率为3.21%，则填写0.0321。
			result.append(isRatesAndZero13_8NotNull(eds.getAnninrate(), "年化利率值"));
			// 是否有利息本金化条款	字符型，1	必填项，是-Y，否-N，默认为否，填写N。
			result.append(isYorNAndNotNull(eds.getInprterm(), "是否有利息本金化条款"));
			// 是否经外汇局特批不需占用指标	字符型，1	必填项，是-Y，否-N，默认为否，填写N。
			result.append(isYorNAndNotNull(eds.getSpapfeboindex(), "是否经外汇局特批不需占用指标"));
			// REMARK	备注	字符型，256	非必填项。
			result.append(lessLenNull(eds.getRemark(), 256, "备注"));
			// 取得债权人信息做验证
			if(eds.getCreditors() == null || eds.getCreditors().size() == 0) {
				result.append("债权人信息不能为空！");
			} else {
				BopCfaCreditorDs creditords = (BopCfaCreditorDs)eds.getCreditors().get(0);
				// 债权人代码	字符型，11	非必填项。
				result.append(lessLenNull(creditords.getCreditorcode(), 11, "债权人代码"));
				// 债权人类型代码	字符型，8	必填项，见境外主体类型代码表。
				result.append(valLenByNotNull(creditords.getCreditortype(), 8, "债权人类型代码"));
				result.append(validateCreditorCodeNull(creditords.getCreditortype(), creditords.getCreditorcode(), TopReportConstants.REPORT_FILE_TYPE_CFA_AI, eds.getCrehqcode()));

				// 债权人中文名称	字符型，128	非必填项， 债权人中文名称和债权人英文名称至少填写一个。
				// 债权人英文名称	字符型，128	非必填项， 债权人中文名称和债权人英文名称至少填写一个。
				result.append(optionOne(creditords.getCreditorname(), creditords.getCreditornamen(), "债权人中文名称和债权人英文名称"));
				result.append(lessLenNull(creditords.getCreditorname(), 128, "债权人中文名称"));
				result.append(lessLenNull(creditords.getCreditornamen(), 128, "债权人英文名称"));

				// 债权人总部所在国家（地区）代码	字符型，3	必填项，见国家地区代码表。
				result.append(valLenByNotNull(creditords.getCrehqcode(), 3, "债权人总部所在国家（地区）代码"));
				// 债权人经营地所在国家（地区）代码	字符型，3	必填项，见国家地区代码表。
				result.append(valLenByNotNull(creditords.getOpercode(), 3, "债权人经营地所在国家（地区）代码"));
			}
			//PROJECTNAME	项目名称	字符型，128	非必填项。

			/** AI 其他贷款 End **/
		} else if (TopReportConstants.REPORT_FILE_TYPE_CFA_AJ.equals(eds.getCurrentfile())) {
			/** AJ货币市场工具 Begin **/
			// 操作类型	字符型，1	必填项， A－新建 C－修改 D－删除，一旦银行报送了该外债编号下的变动信息，就不可以删除了。
			result.append(checkActiontype(eds.getActiontype()));
			// 删除原因	字符型，128	如果ACTIONTYPE字段值为D，则此字段为必填字段。
			result.append(isDelRemarkVaild(eds.getActiontype(), eds.getActiondesc()));
			result.append(lessLenNull(eds.getActiondesc(), 128, "删除原因"));
			// 外债编号	字符型，28	必填项， 外债唯一性编码。
			result.append(valLenByNotNull(eds.getExdebtcode(), 28, "外债编号"));
			// 债务人代码	字符型，12	必填项， 金融机构标识码。
			result.append(valLenByNotNull(eds.getDebtorcode(), 12, "债务人代码"));
			// 债务类型	字符型，4	必填项，见债务类型代码表。
			result.append(valLenByNotNull(eds.getDebtype(), 4, "债务类型"));
			// 起息日	日期型，8	必填项，格式YYYYMMDD。
			result.append(valLenByNotNull(eds.getValuedate(), 8, "起息日"));
			result.append(checkDateFormat(eds.getValuedate(), "yyyyMMdd", "起息日"));
			// 签约币种	字符型，3	必填项， 见币种代码表。
			result.append(valLenByNotNull(eds.getContractcurr(), 3, "签约币种"));
			// 签约金额	数值型，22.2	必填项，大于等于0。
			result.append(isAmountAndZero22_2(eds.getContractamount(), "签约金额"));
			// 到期日	日期型，8	必填项， 格式YYYYMMDD，大于等于起息日。
			result.append(valLenByNotNull(eds.getMaturity(), 8, "到期日"));
			result.append(checkDateFormat(eds.getMaturity(), "yyyyMMdd", "到期日"));
			result.append(dateLessCheckDateOrEqual(eds.getValuedate(), eds.getMaturity(), "起息日", "到期日"));
			// 是否浮动利率	字符型，1	必填项，是-Y，否-N，默认为否，填写N。
			result.append(isYorNAndNotNull(eds.getFloatrate(), "是否浮动利率"));
			// 年化利率值	数值型，13.8	必填项，大于等于0，按小数填写，如利率为3.21%，则填写0.0321。
			result.append(isRatesAndZero13_8NotNull(eds.getAnninrate(), "年化利率值"));
			// 是否经外汇局特批不需占用指标	字符型，1	必填项，是-Y，否-N，默认为否，填写N。
			result.append(isYorNAndNotNull(eds.getSpapfeboindex(), "是否经外汇局特批不需占用指标"));
			// ISIN CODE	字符型，12	必填项，国际证券识别编码，  ISIN CODE的编码规则为：共12位。第1-2位为字母，用于标识国别；第3-11位为数字和字母，为国内证券识别编码；第12位为数字，为校对码。
			result.append(isInCodeVaild(eds.getIsincode()));
			// 备注	字符型，256	非必填项。
			result.append(lessLenNull(eds.getRemark(), 256, "备注"));
			// 取得债权人信息做验证
			if(eds.getCreditors() == null || eds.getCreditors().size() == 0) {
				result.append("债权人信息不能为空！");
			} else {
				BopCfaCreditorDs creditords = (BopCfaCreditorDs)eds.getCreditors().get(0);
				// 债权人代码	字符型，11	必填项。
				result.append(lessLen(creditords.getCreditorcode(), 11, "债权人代码"));
				// 债权人类型代码	字符型，8	必填项，应为资本市场所对应的债权人类型代码。
				result.append(valLenByNotNull(creditords.getCreditortype(), 8, "债权人类型代码"));
				result.append(validateCreditorCodeNull(creditords.getCreditortype(), creditords.getCreditorcode(), TopReportConstants.REPORT_FILE_TYPE_CFA_AJ, creditords.getCrehqcode()));

				// 债权人中文名称	字符型，128	非必填项， 债权人中文名称和债权人英文名称至少填写一个。
				// 债权人英文名称	字符型，128	非必填项， 债权人中文名称和债权人英文名称至少填写一个。
				result.append(optionOne(creditords.getCreditorname(), creditords.getCreditornamen(), "债权人中文名称和债权人英文名称"));
				result.append(lessLenNull(creditords.getCreditorname(), 128, "债权人中文名称"));
				result.append(lessLenNull(creditords.getCreditornamen(), 128, "债权人英文名称"));

				// 债权人总部所在国家（地区）代码	字符型，3	必填项，见国家地区代码表。
				result.append(valLenByNotNull(creditords.getCrehqcode(), 3, "债权人总部所在国家（地区）代码"));
				// 债权人经营地所在国家（地区）代码	字符型，3	必填项，见国家地区代码表。
				result.append(valLenByNotNull(creditords.getOpercode(), 3, "债权人经营地所在国家（地区）代码"));
			}
			/** AJ货币市场工具 End **/
		} else if (TopReportConstants.REPORT_FILE_TYPE_CFA_AK.equals(eds.getCurrentfile())) {
			/** AK债券和票据 Begin **/
			// 操作类型	字符型，1	必填项， A－新建 C－修改 D－删除，一旦银行报送了该外债编号下的变动信息，就不可以删除了。
			result.append(checkActiontype(eds.getActiontype()));
			// 删除原因	字符型，128	如果ACTIONTYPE字段值为D，则此字段为必填字段。
			result.append(isDelRemarkVaild(eds.getActiontype(), eds.getActiondesc()));
			result.append(lessLenNull(eds.getActiondesc(), 128, "删除原因"));
			// 外债编号	字符型，28	必填项， 外债唯一性编码。
			result.append(valLenByNotNull(eds.getExdebtcode(), 28, "外债编号"));
			// 债务人代码	字符型，12	必填项， 金融机构标识码。
			result.append(valLenByNotNull(eds.getDebtorcode(), 12, "债务人代码"));
			// 债务类型	字符型，4	必填项， 见债务类型代码表。
			result.append(valLenByNotNull(eds.getDebtype(), 4, "债务类型"));
			// 起息日	日期型，8	必填项， 格式YYYYMMDD。
			result.append(valLenByNotNull(eds.getValuedate(), 8, "起息日"));
			result.append(checkDateFormat(eds.getValuedate(), "yyyyMMdd", "起息日"));
			// 签约币种	字符型，3	必填项， 见币种代码表。
			result.append(valLenByNotNull(eds.getContractcurr(), 3, "签约币种"));
			// 签约金额	数值型，22.2	必填项，大于等于0。
			result.append(isAmountAndZero22_2(eds.getContractamount(), "签约金额"));
			// 到期日	日期型，8	必填项，格式YYYYMMDD，大于等于起息日。
			result.append(valLenByNotNull(eds.getMaturity(), 8, "到期日"));
			result.append(checkDateFormat(eds.getMaturity(), "yyyyMMdd", "到期日"));
			result.append(dateLessCheckDateOrEqual(eds.getValuedate(), eds.getMaturity(), "起息日", "到期日"));
			// 是否浮动利率	字符型，1	必填项，是-Y，否-N，默认为否，填写N。
			result.append(isYorNAndNotNull(eds.getFloatrate(), "是否浮动利率"));
			// 年化利率值	数值型，13.8	必填项，大于等于0，按小数填写，如利率为3.21%，则填写0.0321。
			result.append(isRatesAndZero13_8NotNull(eds.getAnninrate(), "年化利率值"));
			// 是否经外汇局特批不需占用指标	字符型，1	必填项，是-Y，否-N，默认为否，填写N。
			result.append(isYorNAndNotNull(eds.getSpapfeboindex(), "是否经外汇局特批不需占用指标"));
			// ISIN CODE	字符型，12	必填项，国际证券识别编码 ISIN CODE的编码规则为：共12位。第1-2位为字母，用于标识国别；第3-11位为数字和字母，为国内证券识别编码；第12位为数字，为校对码。
			result.append(isInCodeVaild(eds.getIsincode()));
			// 备注	字符型，256	非必填项。
			result.append(lessLenNull(eds.getRemark(), 256, "备注"));
			// 取得债权人信息做验证
			if(eds.getCreditors() == null || eds.getCreditors().size() == 0) {
				result.append("债权人信息不能为空！");
			} else {
				BopCfaCreditorDs creditords = (BopCfaCreditorDs)eds.getCreditors().get(0);
				// 债权人代码	字符型，11	必填项。
				result.append(lessLen(creditords.getCreditorcode(), 11, "债权人代码"));
				// 债权人类型代码	字符型，8	必填项，，应为资本市场所对应的债权人类型代码。
				result.append(valLenByNotNull(creditords.getCreditortype(), 8, "债权人类型代码"));

				result.append(validateCreditorCodeNull(creditords.getCreditortype(), creditords.getCreditorcode(), TopReportConstants.REPORT_FILE_TYPE_CFA_AK, creditords.getCrehqcode()));
				// 债权人中文名称	字符型，128	非必填项， 债权人中文名称和债权人英文名称至少填写一个。
				// 债权人英文名称	字符型，128	非必填项， 债权人中文名称和债权人英文名称至少填写一个。
				result.append(optionOne(creditords.getCreditorname(), creditords.getCreditornamen(), "债权人中文名称和债权人英文名称"));
				result.append(lessLenNull(creditords.getCreditorname(), 128, "债权人中文名称"));
				result.append(lessLenNull(creditords.getCreditornamen(), 128, "债权人英文名称"));

				// 债权人总部所在国家（地区）代码	字符型，3	必填项，见国家地区代码表。
				result.append(valLenByNotNull(creditords.getCrehqcode(), 3, "债权人总部所在国家（地区）代码"));
				// 债权人经营地所在国家（地区）代码	字符型，3	必填项，见国家地区代码表。
				result.append(valLenByNotNull(creditords.getOpercode(), 3, "债权人经营地所在国家（地区）代码"));
			}
			/** AK债券和票据 End **/
		} else if (TopReportConstants.REPORT_FILE_TYPE_CFA_AL.equals(eds.getCurrentfile())) {
			/** AL境外同业存放 Begin **/
			// 操作类型	字符型，1	必填项， A－新建 C－修改 D－删除，一旦银行报送了该外债编号下的变动信息，就不可以删除了。
			result.append(checkActiontype(eds.getActiontype()));
			// 删除原因	字符型，128	如果ACTIONTYPE字段值为D，则此字段为必填字段。
			result.append(isDelRemarkVaild(eds.getActiontype(), eds.getActiondesc()));
			result.append(lessLenNull(eds.getActiondesc(), 128, "删除原因"));
			// 外债编号	字符型，28	必填项， 外债唯一性编码。
			result.append(valLenByNotNull(eds.getExdebtcode(), 28, "外债编号"));
			// 债务人代码	字符型，12	必填项， 金融机构标识码。
			result.append(valLenByNotNull(eds.getDebtorcode(), 12, "债务人代码"));
			// 债务类型	字符型，4	必填项， 见债务类型代码表。
			result.append(valLenByNotNull(eds.getDebtype(), 4, "债务类型"));
			// 起息日	日期型，8	必填项， 格式YYYYMMDD。
			result.append(valLenByNotNull(eds.getValuedate(), 8, "起息日"));
			result.append(checkDateFormat(eds.getValuedate(), "yyyyMMdd", "起息日"));
			// 签约币种	字符型，3	必填项， 见币种代码表。
			result.append(valLenByNotNull(eds.getContractcurr(), 3, "签约币种"));
			// 是否浮动利率	字符型，1	必填项，是-Y，否-N，默认为否，填写N。
			result.append(isYorNAndNotNull(eds.getFloatrate(), "是否浮动利率"));
			// 年化利率值	数值型，13.8	必填项，大于等于0，按小数填写，如利率为3.21%，则填写0.0321。
			result.append(isRatesAndZero13_8NotNull(eds.getAnninrate(), "年化利率值"));
			// 是否经外汇局特批不需占用指标	字符型，1	必填项，是-Y，否-N，默认为否，填写N。
			result.append(isYorNAndNotNull(eds.getSpapfeboindex(),  "是否经外汇局特批不需占用指标"));
			// 备注	字符型，256	非必填项。
			result.append(lessLenNull(eds.getRemark(), 256, "备注"));
			// 取得债权人信息做验证
			if(eds.getCreditors() == null || eds.getCreditors().size() == 0) {
				result.append("债权人信息不能为空！");
			} else {
				BopCfaCreditorDs creditords = (BopCfaCreditorDs)eds.getCreditors().get(0);
				// 债权人代码	字符型，11	非必填项。
				result.append(lessLenNull(creditords.getCreditorcode(), 11, "债权人代码"));
				//债权人类型代码	字符型，8	必填项，见境外主体类型代码表。
				result.append(valLenByNotNull(creditords.getCreditortype(), 8, "债权人类型代码"));

				result.append(validateCreditorCodeNull(creditords.getCreditortype(), creditords.getCreditorcode(), TopReportConstants.REPORT_FILE_TYPE_CFA_AL, creditords.getCrehqcode()));

				// 债权人中文名称	字符型，128	非必填项， 债权人中文名称和债权人英文名称至少填写一个。
				// 债权人英文名称	字符型，128	非必填项， 债权人中文名称和债权人英文名称至少填写一个。
				result.append(optionOne(creditords.getCreditorname(), creditords.getCreditornamen(), "债权人中文名称和债权人英文名称"));
				result.append(lessLenNull(creditords.getCreditorname(), 128, "债权人中文名称"));
				result.append(lessLenNull(creditords.getCreditornamen(), 128, "债权人英文名称"));
				// 债权人总部所在国家（地区）代码	字符型，3	必填项，见国家地区代码表。
				result.append(valLenByNotNull(creditords.getCrehqcode(), 3, "债权人总部所在国家（地区）代码"));
				// 债权人经营地所在国家（地区）代码	字符型，3	必填项，见国家地区代码表。
				result.append(valLenByNotNull(creditords.getOpercode(), 3, "债权人经营地所在国家（地区）代码"));
			}
			/** AL境外同业存放 End **/
		} else if (TopReportConstants.REPORT_FILE_TYPE_CFA_AM.equals(eds.getCurrentfile())) {
			/** AM境外联行及附属机构往来 Begin **/
			// 操作类型	字符型，1	必填项， A－新建 C－修改 D－删除，一旦银行报送了该外债编号下的变动信息，就不可以删除了。
			result.append(checkActiontype(eds.getActiontype()));
			// 删除原因	字符型，128	如果ACTIONTYPE字段值为D，则此字段为必填字段。
			result.append(isDelRemarkVaild(eds.getActiontype(), eds.getActiondesc()));
			result.append(lessLenNull(eds.getActiondesc(), 128, "删除原因"));
			// 外债编号	字符型，28	必填项， 外债唯一性编码。
			result.append(valLenByNotNull(eds.getExdebtcode(), 28, "外债编号"));
			// 债务人代码	字符型，12	必填项， 金融机构标识码。
			result.append(valLenByNotNull(eds.getDebtorcode(), 12, "债务人代码"));
			// 债务类型	字符型，4	必填项， 见债务类型代码表。
			result.append(valLenByNotNull(eds.getDebtype(), 4, "债务类型"));
			// 起息日	日期型，8	必填项， 格式YYYYMMDD。
			result.append(valLenByNotNull(eds.getValuedate(), 8, "起息日"));
			result.append(checkDateFormat(eds.getValuedate(), "yyyyMMdd", "起息日"));
			// 签约币种	字符型，3	必填项， 见币种代码表。
			result.append(valLenByNotNull(eds.getContractcurr(), 3, "签约币种"));
			// 是否浮动利率	字符型，1	必填项，是-Y，否-N，默认为否，填写N。
			result.append(isYorNAndNotNull(eds.getFloatrate(), "是否浮动利率"));
			// 年化利率值	数值型，13.8	必填项，大于等于0，按小数填写，如利率为3.21%，则填写0.0321。
			result.append(isRatesAndZero13_8NotNull(eds.getAnninrate(), "年化利率值"));
			// 是否经外汇局特批不需占用指标	字符型，1	必填项，是-Y，否-N，默认为否，填写N。
			result.append(isYorNAndNotNull(eds.getSpapfeboindex(), "是否经外汇局特批不需占用指标"));
			// 备注	字符型，256	非必填项。
			result.append(lessLenNull(eds.getRemark(), 256, "备注"));
			// 取得债权人信息做验证
			if(eds.getCreditors() == null || eds.getCreditors().size() == 0) {
				result.append("债权人信息不能为空！");
			} else {
				BopCfaCreditorDs creditords = (BopCfaCreditorDs)eds.getCreditors().get(0);
				// 债权人代码	字符型，11	非必填项。
				result.append(lessLenNull(creditords.getCreditorcode(), 11, "债权人代码"));

				result.append(validateCreditorCodeNull(creditords.getCreditortype(), creditords.getCreditorcode(), TopReportConstants.REPORT_FILE_TYPE_CFA_AM, creditords.getCrehqcode()));

				// 债权人中文名称	字符型，128	非必填项， 债权人中文名称和债权人英文名称至少填写一个。
				// 债权人英文名称	字符型，128	非必填项， 债权人中文名称和债权人英文名称至少填写一个。
				result.append(optionOne(creditords.getCreditorname(), creditords.getCreditornamen(), "债权人中文名称和债权人英文名称"));
				result.append(lessLenNull(creditords.getCreditorname(), 128, "债权人中文名称"));
				result.append(lessLenNull(creditords.getCreditornamen(), 128, "债权人英文名称"));
				// 债权人类型代码	字符型，8	必填项，见境外主体类型代码表。
				result.append(valLenByNotNull(creditords.getCreditortype(), 8, "债权人类型代码"));
				// 债权人总部所在国家（地区）代码	字符型，3	必填项，见国家地区代码表。
				result.append(valLenByNotNull(creditords.getCrehqcode(), 3, "债权人总部所在国家（地区）代码"));
				// 债权人经营地所在国家（地区）代码	字符型，3	必填项，见国家地区代码表。
				result.append(valLenByNotNull(creditords.getOpercode(), 3, "债权人经营地所在国家（地区）代码"));
			}
			/** AM境外联行及附属机构往来 End **/
		}else if(TopReportConstants.REPORT_FILE_TYPE_CFA_AN.equals( eds.getCurrentfile()))
		{
			result.append(checkActiontype(eds.getActiontype()));

			result.append(isDelRemarkVaild(eds.getActiontype(), eds.getActiondesc()));
			result.append(lessLenNull(eds.getActiondesc(), 128, "删除原因"));

			result.append(valLenByNotNull(eds.getExdebtcode(), 28, "外债编号"));
			result.append(lessLen(eds.getLimitType(), 4, "账户类型"));
			result.append(lessLen(eds.getDebtorcode(), 12, "债务人代码"));
			result.append(valLenByNotNull(eds.getDebtype(), 4, "债务类型"));
			result.append(valLenByNotNull(eds.getValuedate(), 8, "起息日"));
			result.append(checkDateFormat(eds.getValuedate(), "yyyyMMdd", "起息日"));

			result.append(valLenByNotNull(eds.getContractcurr(), 3, "签约币种"));
			result.append(isYorNAndNotNull(eds.getFloatrate(), "是否浮动利率"));
			result.append(isRatesAndZero13_8NotNull(eds.getAnninrate(), "年化利率值"));
			result.append(isYorNAndNotNull(eds.getSpapfeboindex(), "是否经外汇局特批不需占用指标"));
			result.append(lessLenNull(eds.getRemark(), 256, "备注"));

			result.append(lessLenNull(eds.getCreditorcode(), 11, "债权人代码"));
			result.append(valLenByNotNull(eds.getCreditortype(), 8, "债权人类型代码"));
			if(null != eds.getCreditortype()) {
				result.append(isEqual(eds.getCreditortype(), "20001699", "债权人类型", "其他企业"));
			}
			result.append(validateCreditorCodeNull(eds.getCreditortype(), eds.getCreditorcode(), TopReportConstants.REPORT_FILE_TYPE_CFA_AN, eds.getCrehqcode()));

			result.append(optionOne(eds.getCreditorname(), eds.getCreditornamen(), "债权人中文名称和债权人英文名称"));
			result.append(lessLenNull(eds.getCreditorname(), 128, "债权人中文名称"));
			result.append(lessLenNull(eds.getCreditornamen(), 128, "债权人英文名称"));

			result.append(valLenByNotNull(eds.getCrehqcode(), 3, "债权人总部所在国家（地区）代码"));
			result.append(valLenByNotNull(eds.getOpercode(), 3, "债权人经营地所在国家（地区）代码"));


		}else if(TopReportConstants.REPORT_FILE_TYPE_CFA_AP.equals( eds.getCurrentfile()))
		{
			result.append(checkActiontype(eds.getActiontype()));

			result.append(isDelRemarkVaild(eds.getActiontype(), eds.getActiondesc()));
			result.append(lessLenNull(eds.getActiondesc(), 128, "删除原因"));

			result.append(valLenByNotNull(eds.getExdebtcode(), 28, "外债编号"));

			result.append(lessLen(eds.getDebtorcode(), 12, "债务人代码"));

			result.append(valLenByNotNull(eds.getDebtype(), 4, "债务类型"));
			result.append(valLenByNotNull(eds.getContractcurr(), 3, "签约币种"));
			result.append(isYorNAndNotNull(eds.getFloatrate(), "是否浮动利率"));
			result.append(isRatesAndZero13_8NotNull(eds.getAnninrate(), "年化利率值"));
			result.append(isYorNAndNotNull(eds.getSpapfeboindex(), "是否经外汇局特批不需占用指标"));
			result.append(lessLenNull(eds.getRemark(), 256, "备注"));

			result.append(lessLen(eds.getCreditorcode(), 6, "债权人代码"));

			result.append(valLenByNotNull(eds.getCreditortype(), 8, "债权人类型代码"));
			result.append(countySubTypeCode(eds.getCrehqcode(), eds.getCreditortype(), "债权人类型代码"));

			result.append(validateCreditorCodeNull(eds.getCreditortype(), eds.getCreditorcode(), TopReportConstants.REPORT_FILE_TYPE_CFA_AP, eds.getCrehqcode()));

			result.append(optionOne(eds.getCreditorname(), eds.getCreditornamen(), "债权人中文名称和债权人英文名称"));
			result.append(lessLenNull(eds.getCreditorname(), 128, "债权人中文名称"));
			result.append(lessLenNull(eds.getCreditornamen(), 128, "债权人英文名称"));




			result.append(valLenByNotNull(eds.getCrehqcode(), 3, "债权人国家（地区）代码"));

		}else if(TopReportConstants.REPORT_FILE_TYPE_CFA_AQ.equals( eds.getCurrentfile()))
		{
			result.append(checkActiontype(eds.getActiontype()));

			result.append(isDelRemarkVaild(eds.getActiontype(), eds.getActiondesc()));
			result.append(lessLenNull(eds.getActiondesc(), 128, "删除原因"));

			result.append(valLenByNotNull(eds.getExdebtcode(), 28, "外债编号"));

			result.append(lessLen(eds.getDebtorcode(), 12, "债务人代码"));

			result.append(valLenByNotNull(eds.getDebtype(), 4, "债务类型"));

			result.append(lessLen(eds.getDebtyperema(), 128, "债务类型备注"));

			result.append(valLenByNotNull(eds.getValuedate(), 8, "起息日"));
			result.append(checkDateFormat(eds.getValuedate(), "yyyyMMdd", "起息日"));

			result.append(valLenByNotNull(eds.getContractcurr(), 3, "签约币种"));
			result.append(isAmountAndZero22_2NotNull(eds.getContractamount(), "签约金额"));

			result.append(valLenByNotNull(eds.getMaturity(), 8, "到期日"));
			result.append(checkDateFormat(eds.getMaturity(), "yyyyMMdd", "到期日"));

			if (null != eds.getValuedate() && null != eds.getMaturity()) {
				result.append(dateLessCheckDateOrEqual(eds.getValuedate(), eds.getMaturity(), "起息日", "到期日"));
			}

			result.append(isYorNAndNotNull(eds.getFloatrate(), "是否浮动利率"));

			result.append(isRatesAndZero13_8NotNull(eds.getAnninrate(), "年化利率值"));

			result.append(isYorNAndNotNull(eds.getInprterm(), "是否有利息本金化条款"));

			result.append(isYorNAndNotNull(eds.getSpapfeboindex(), "是否经外汇局特批不需占用指标"));

			result.append(lessLenNull(eds.getRemark(), 256, "备注"));

			result.append(lessLenNull(eds.getCreditorcode(), 11, "债权人代码"));
			result.append(valLenByNotNull(eds.getCreditortype(), 8, "债权人类型代码"));
			if (null != eds.getCreditortype()) {
				result.append(countySubTypeCode(eds.getCrehqcode(), eds.getCreditortype(), "债权人类型代码"));
			}
			result.append(validateCreditorCodeNull(eds.getCreditortype(), eds.getCreditorcode(), TopReportConstants.REPORT_FILE_TYPE_CFA_AQ, eds.getCrehqcode()));

			result.append(optionOne(eds.getCreditorname(), eds.getCreditornamen(), "债权人中文名称和债权人英文名称"));

			result.append(lessLenNull(eds.getCreditorname(), 128, "债权人中文名称"));

			result.append(lessLenNull(eds.getCreditornamen(), 128, "债权人英文名称"));

			result.append(valLenByNotNull(eds.getCrehqcode(), 3, "债权人总部所在国家（地区）代码"));
			result.append(valLenByNotNull(eds.getOpercode(), 3, "债权人经营地所在国家（地区）代码"));


		}else if(TopReportConstants.REPORT_FILE_TYPE_CFA_AR.equals( eds.getCurrentfile()))
		{
			result.append(checkActiontype(eds.getActiontype()));

			result.append(isDelRemarkVaild(eds.getActiontype(), eds.getActiondesc()));
			result.append(lessLenNull(eds.getActiondesc(), 128, "删除原因"));

			result.append(valLenByNotNull(eds.getExdebtcode(), 28, "外债编号"));

			result.append(lessLen(eds.getBuscode(), 32, "银行业务参号"));

			result.append(valLenByNotNull(eds.getChangeno(), 4, "变动编号"));

			result.append(valLenByNotNull(eds.getChangtype(), 4, "变动类型"));

			result.append(valLenByNotNull(eds.getChdate(), 8, "变动日期"));
			result.append(checkDateFormat(eds.getChdate(), "yyyyMMdd", "变动日期"));

			result.append(valLenByNotNull(eds.getChcurrency(), 3, "变动币种"));

			result.append(isAmountAndZero22_2NotNull(eds.getChamount(), "变动金额"));

			result.append(isFariValue(eds.getFairvalue()));

			result.append(lessLenNull(eds.getRemark(), 256, "备注"));

		}else if(TopReportConstants.REPORT_FILE_TYPE_CFA_AS.equals( eds.getCurrentfile()))
		{
			result.append(checkActiontype(eds.getActiontype()));

			result.append(isDelRemarkVaild(eds.getActiontype(), eds.getActiondesc()));
			result.append(lessLenNull(eds.getActiondesc(), 128, "删除原因"));

			result.append(valLenByNotNull(eds.getExdebtcode(), 28, "外债编号"));

			result.append(valLenByNotNull(eds.getChangeno(), 4, "变动编号"));

			result.append(lessLen(eds.getBuscode(), 32, "银行业务参号"));

			result.append(isAmountAndZero22_2NotNull(eds.getAccoamount(), "外债余额"));

			result.append(valLenByNotNull(eds.getChdate(), 8, "变动日期"));
			result.append(checkDateFormat(eds.getChdate(), "yyyyMMdd", "变动日期"));

			result.append(lessLenNull(eds.getRemark(), 256, "备注"));
		}
		return result.toString();
	}
}