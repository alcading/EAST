package com.huateng.report.getter;

import java.lang.reflect.InvocationTargetException;
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
 * 境外联行及附属机构往来
 * @author wenhao.chen
 * @version 1.0
 * 2012-8-30
 *
 * */
@SuppressWarnings("unchecked")
public class BOPForDebtAndSubSidGetter extends BaseGetter {

	public Result call() throws AppException {
		try {
			setValue2DataBus(ReportConstant.QUERY_LOG_BUSI_NAME, "境外联行及附属机构往来签约信息查询");
			PageQueryResult queryResult = getData();

			ResultMng.fillResultByList(getCommonQueryBean(),
					getCommQueryServletRequest(), queryResult.getQueryResult(),
					getResult());
			result.setContent(queryResult.getQueryResult());
			result.getPage().setTotalPage(queryResult.getPageCount(getResult().getPage().getEveryPage()));
			result.init();
			return result;

		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}

	@SuppressWarnings("rawtypes")
	private PageQueryResult getData() throws CommonException, IllegalAccessException, InvocationTargetException
	{
		int pageSize = getResult().getPage().getEveryPage();
		//页码
		int pageIndex = getResult().getPage().getCurrentPage();
		Map map = getCommQueryServletRequest().getParameterMap();
		String qworkDate = (String) map.get("qworkDate");
		String eworkDate = (String) map.get("eworkDate");

		String qactiontype = (String) map.get("qactiontype");
		String qRecStatus = (String)map.get("qRecStatus");

		String qapproveStatus = (String) map.get("qapproveStatus");
		String qrepStatus = (String) map.get("qrepStatus");

		String qfiller2 = (String) map.get("qfiller2");

		BopForDebtYinTuanService debtYinTuanService = BopForDebtYinTuanService.getInstance();
		return  debtYinTuanService.queryAuditFeiOrgSave("signeds", pageIndex, pageSize, qworkDate, eworkDate, qactiontype, qRecStatus, qapproveStatus, qrepStatus, qfiller2);
	}
}