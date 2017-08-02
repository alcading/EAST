package com.huateng.report.dataquery.getter;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.report.common.ReportConstant;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;
import com.huateng.report.constants.TopReportConstants;
import com.huateng.report.service.BopCfaExplrmbloDsService;

@SuppressWarnings("unchecked")
public class BopCfaExplrmbloDsQueryGetter extends BaseGetter {

	@Override
	public Result call() throws AppException {
		try {
			PageQueryResult queryResult = getData();
			this.setValue2DataBus(ReportConstant.QUERY_LOG_BUSI_NAME, "外汇质押人民币贷款签约信息查询");
			ResultMng.fillResultByList(
					getCommonQueryBean(),
					getCommQueryServletRequest(),
					queryResult.getQueryResult(),
					getResult());
				result.setContent(queryResult.getQueryResult());
				result.getPage().setTotalPage(queryResult.getPageCount(getResult().getPage().getEveryPage()));
				result.init();
				return result;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}

	/**
	 * 根据输入的查询条件进行查询
	 *
	 * @return PageQueryResult：返回查询的结果集
	 * @throws CommonException
	 */
	private PageQueryResult getData() throws CommonException {

		String workDateStart = getCommQueryServletRequest().getParameter("workDateStart");
		String workDateEnd = getCommQueryServletRequest().getParameter("workDateEnd");
		// 分页大小
		int pageSize = getResult().getPage().getEveryPage();
		// 页码
		int pageIndex = getResult().getPage().getCurrentPage();
		String qbrNo = getCommQueryServletRequest().getParameter("qbrNo");
		String actiontype = getCommQueryServletRequest().getParameter("qactiontype");
		String recStatus = getCommQueryServletRequest().getParameter("qrecStatus");
		String approveStatus = getCommQueryServletRequest().getParameter("qapproveStatus");
		String repStatus = getCommQueryServletRequest().getParameter("qrepStatus");
		String filler2 = getCommQueryServletRequest().getParameter("qfiller2");
		BopCfaExplrmbloDsService service = BopCfaExplrmbloDsService.getInstance();
		return service.pageQueryByHqlForExplrmblo(TopReportConstants.REPORT_FILE_TYPE_CFA_EA,pageIndex, pageSize,workDateStart,workDateEnd,qbrNo,actiontype,recStatus,approveStatus,repStatus,filler2);
	}

}
