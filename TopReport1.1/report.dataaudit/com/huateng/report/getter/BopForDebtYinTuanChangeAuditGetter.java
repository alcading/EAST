package com.huateng.report.getter;

import java.util.Map;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.report.common.ReportConstant;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;
import com.huateng.report.service.BopForDebtYinTuanService;

/**
 *
 * @author shishu.zhang
 *
 * 2012-8-15上午10:54:59
 */
@SuppressWarnings("unchecked")
public class BopForDebtYinTuanChangeAuditGetter extends BaseGetter {

	public Result call() throws AppException {
		try {
			PageQueryResult pageQueryResult = getData();

			setValue2DataBus(ReportConstant.QUERY_LOG_BUSI_NAME, "外债-银团贷款审核-变动信息查询");

			ResultMng.fillResultByList(getCommonQueryBean(),
					getCommQueryServletRequest(), pageQueryResult.getQueryResult(),
					getResult());
			result.setContent(pageQueryResult.getQueryResult());
			result.getPage().setTotalPage(pageQueryResult.getPageCount(getResult().getPage().getEveryPage()));
			result.init();
			return result;
		} catch (CommonException e) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, e.getMessage());
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}

	@SuppressWarnings("rawtypes")
	public PageQueryResult getData() throws CommonException{
		int pageSize = this.getResult().getPage().getEveryPage();
		int pageIndex = this.getResult().getPage().getCurrentPage();
		Map map = getCommQueryServletRequest().getParameterMap();
		String qStartDate = (String) map.get("qStartDate");
		String qEndDate = (String) map.get("qEndDate");

//		String eworkDate = (String) map.get("eworkDate");
		String qactiontype = (String) map.get("qactiontype");

		String qRecStatus = (String) map.get("qRecStatus");
		String qapproveStatus = (String) map.get("qapproveStatus");

		String qrepStatus = (String) map.get("qrepStatus");
		String qfiller2 = (String) map.get("qfiller2");

		BopForDebtYinTuanService debtYinTuanService = BopForDebtYinTuanService.getInstance();
		return debtYinTuanService.queryAuditYinTuan("change", pageIndex, pageSize, qStartDate, qEndDate, qactiontype, qRecStatus, qapproveStatus, qrepStatus, qfiller2);
//		return debtYinTuanService.queryAuditYinTuan("change", pageIndex, pageSize, qworkDate, eworkDate,qactiontype, qRecStatus, qapproveStatus, qrepStatus, qfiller2);
	}
}
