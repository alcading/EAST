package com.huateng.report.bop.collection.getter;

import java.util.Collections;
import java.util.List;

import resource.bean.report.MtsBopOpenAccount;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.report.common.ReportConstant;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;
import com.huateng.report.bop.collection.service.BopUDsService;

@SuppressWarnings("unchecked")
public class BopOpenDsCollectionGetter extends BaseGetter {

	public Result call() throws AppException {
		try {
			setValue2DataBus(ReportConstant.QUERY_LOG_BUSI_NAME, "单位基本情况表页面查询");
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
		String id = getCommQueryServletRequest().getParameter("id");
		BopUDsService service = BopUDsService.getInstance();
		List<MtsBopOpenAccount> openaccountList = service.loadOpenAccount(id);
		if (null == openaccountList) {
			openaccountList = Collections.emptyList();
		}
		PageQueryResult queryResult = new PageQueryResult();
		queryResult.setQueryResult(openaccountList);
		queryResult.setTotalCount(openaccountList.size());
		return queryResult;
	}
}
