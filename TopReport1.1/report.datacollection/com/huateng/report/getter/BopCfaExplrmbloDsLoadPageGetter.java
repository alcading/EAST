package com.huateng.report.getter;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;
import com.huateng.report.constants.TopReportConstants;
import com.huateng.report.service.BopCfaExplrmbloDsService;

@SuppressWarnings("unchecked")
public class BopCfaExplrmbloDsLoadPageGetter  extends BaseGetter{


	@Override
	public Result call() throws AppException {
		try {
			PageQueryResult pageQueryResult = getData();

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

	public PageQueryResult getData() throws CommonException {
		// 分页大小
		int pageSize = getResult().getPage().getEveryPage();
		// 页码
		int pageIndex = getResult().getPage().getCurrentPage();

		String workDate = getCommQueryServletRequest().getParameter("workDate");
		String actiontype = getCommQueryServletRequest().getParameter("actiontype");
		String recStatus = getCommQueryServletRequest().getParameter("recStatus");
		String approveStatus = getCommQueryServletRequest().getParameter("approveStatus");
		String repStatus = getCommQueryServletRequest().getParameter("repStatus");
//		String dofoexlocode = getCommQueryServletRequest().getParameter("dofoexlocode");
		String filler2 = getCommQueryServletRequest().getParameter("filler2");

		BopCfaExplrmbloDsService service = BopCfaExplrmbloDsService.getInstance();
		return service.pageQueryByHql(pageIndex, pageSize,
				TopReportConstants.REPORT_FILE_TYPE_CFA_EA, workDate,
				actiontype, recStatus, approveStatus, repStatus, filler2, null);

	}


}
