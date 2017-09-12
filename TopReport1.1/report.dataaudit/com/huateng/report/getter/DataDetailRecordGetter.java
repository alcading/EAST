package com.huateng.report.getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Page;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.PageQueryCondition;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;
import com.huateng.report.service.AnalyProService;

public class DataDetailRecordGetter extends BaseGetter{

	@Override
	public Result call() throws AppException {
		try {


			Map para=this.getCommQueryServletRequest().getParameterMap();
			Map queryPara=new HashMap();
			PageQueryCondition queryCondition=new PageQueryCondition();
			Page page = result.getPage();
			queryPara.put("analyNo", para.get("analyNo"));
			queryCondition.setPageSize(page.getEveryPage());
			queryCondition.setPageIndex(page.getCurrentPage());
			PageQueryResult queryresult = AnalyProService.getInstance().getAnalyProcessDetail(queryCondition,queryPara);
			List list=queryresult.getQueryResult();

			ResultMng.fillResultByList(getCommonQueryBean(),
					getCommQueryServletRequest(),list, getResult());
			getResult().setContent(list);
			getResult().getPage().setTotalPage(queryresult.getPageCount(page.getEveryPage()));
			getResult().init();
			return getResult();
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

}
