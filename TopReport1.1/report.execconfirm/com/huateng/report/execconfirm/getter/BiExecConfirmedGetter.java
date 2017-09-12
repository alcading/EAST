package com.huateng.report.execconfirm.getter;

import java.util.List;

import resource.bean.report.BiExecConfirm;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;
import com.huateng.report.common.service.ReportCommonService;



public class BiExecConfirmedGetter extends BaseGetter{

	@Override
	public Result call() throws AppException {
		try {
			PageQueryResult queryResult = getData();
			ResultMng.fillResultByList(getCommonQueryBean(),
					getCommQueryServletRequest(), queryResult.getQueryResult(),
					getResult());
			result.setContent(queryResult.getQueryResult());
			result.getPage().setTotalPage(1);

			result.init();
			return result;

		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}
	private PageQueryResult getData() throws CommonException
	{
		PageQueryResult queryResult = new PageQueryResult();
		List<BiExecConfirm> biExecs = ReportCommonService.getInstance().getAllBrNoBiExecConfirm();
		queryResult.setQueryResult(biExecs);
		queryResult.setTotalCount(biExecs.size());
		return queryResult;
	}
}
