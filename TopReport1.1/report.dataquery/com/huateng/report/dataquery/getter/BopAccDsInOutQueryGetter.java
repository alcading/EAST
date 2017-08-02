package com.huateng.report.dataquery.getter;

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
import com.huateng.report.service.BopAccDsService;

/**
 *
 * @author shishu.zhang
 *
 * 2012-8-15上午10:54:59
 */
@SuppressWarnings("unchecked")
public class BopAccDsInOutQueryGetter extends BaseGetter {

	@Override
	public Result call() throws AppException {
		try {
			PageQueryResult pageQueryResult = getData();

			setValue2DataBus(ReportConstant.QUERY_LOG_BUSI_NAME, "外汇账户补录信息查询-收支余额信息查询");

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

	public PageQueryResult getData() throws CommonException{
		int pageSize = this.getResult().getPage().getEveryPage();
		int pageIndex = this.getResult().getPage().getCurrentPage();
		Map map = getCommQueryServletRequest().getParameterMap();

		String qbrNo = (String) map.get("qbrNo");
//		String qworkDate = (String) map.get("qworkDate");
		String qactiontype = (String) map.get("qactiontype");
		String qapproveStatus = (String) map.get("qapproveStatus");
		String qrecStatus = (String) map.get("qrecStatus");
		String qrepStatus = (String) map.get("qrepStatus");
		String qaccountno = (String) map.get("qaccountno");

		String qstartDate = (String) map.get("qstartDate");
		String qendDate = (String) map.get("qendDate");

		BopAccDsService bopAccDsService = BopAccDsService.getInstance();
		return bopAccDsService.queryBopAccDsQuery("InOut", pageIndex, pageSize, qbrNo, qactiontype, qrecStatus, qapproveStatus, qrepStatus, null, qaccountno, qstartDate, qendDate);
	}
}
