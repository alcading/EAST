package com.huateng.ebank.business.management.getter;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.BaseDAOUtils;
import com.huateng.ebank.business.common.PageQueryCondition;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

public class WorkflowParamBindingQueryGetter extends BaseGetter {

	@Override
	public Result call() throws AppException{
		try
		{
			String procName = this.getCommQueryServletRequest().getParameter("templetName");
			String taskName = this.getCommQueryServletRequest().getParameter("nodeName");
			PageQueryCondition con = new PageQueryCondition();
			con.setPageIndex(result.getPage().getCurrentPage());
			con.setPageSize(result.getPage().getEveryPage());
			con.setQueryString("from WorkflowParamBinding po where po.processTemplate = '" + procName + "' and taskName = '" + taskName + "'");
			
			PageQueryResult pageQueryResult = BaseDAOUtils.getHQLDAO().pageQueryByQL(con);

			ResultMng.fillResultByList(
					getCommonQueryBean(),
					getCommQueryServletRequest(),
					pageQueryResult.getQueryResult(),
					getResult());
			result.setContent(pageQueryResult.getQueryResult());
			result.getPage().setTotalPage(pageQueryResult.getPageCount(getResult().getPage().getEveryPage()));
			result.init();
			return result;
		}catch(AppException appEx){
			throw appEx;
		}catch(Exception ex){
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(),ex);
		}

	}

}
