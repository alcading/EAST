package com.huateng.ebank.business.management.getter;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.business.management.operation.RouteBindingEntryQueryOperation;
import com.huateng.ebank.business.management.operation.WorkflowParamEntryQueryOperation;
import com.huateng.ebank.business.workflow.bean.WorkflowParamBean;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

public class WorkflowNodeListGetter extends BaseGetter {

	@Override
	public Result call() throws AppException{
		try
		{

		PageQueryResult pageResult = getData();
		ResultMng.fillResultByList(
				getCommonQueryBean(),
				getCommQueryServletRequest(),
				pageResult.getQueryResult(),
				getResult());
		result.setContent(pageResult.getQueryResult());
		result.getPage().setTotalPage(pageResult.getPageCount(getResult().getPage().getEveryPage()));
		result.init();
		return result;
		}catch(AppException appEx){
			throw appEx;
		}catch(Exception ex){
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(),ex);
		}

	}

	protected PageQueryResult getData() throws AppException
    {
		PageQueryResult pageResult = new PageQueryResult();

			OperationContext oc = new OperationContext();

//		PageQueryResult pageQueryResult = new PageQueryResult();
			String procName = this.getCommQueryServletRequest().getParameter("templetName");
//		String procName = (String)getCommQueryServletRequest().getParameterMap().get("procNameQuery");

			WorkflowParamBean workflowParamBean = new WorkflowParamBean();
			workflowParamBean.setProcName(procName);

			int PageIndex = getResult().getPage().getCurrentPage();
			int PageSize = getResult().getPage().getEveryPage();

			oc.setAttribute(WorkflowParamEntryQueryOperation.IN_PARAM, workflowParamBean);
			oc.setAttribute(WorkflowParamEntryQueryOperation.IN_PARAM_PAGESIZE, PageSize);
			oc.setAttribute(WorkflowParamEntryQueryOperation.IN_PARAM_PAGEINDEX, PageIndex);
			OPCaller.call("Management.WorkflowParamEntryQueryOperation", oc);

			pageResult = (PageQueryResult) oc
				.getAttribute(RouteBindingEntryQueryOperation.OUT_PARAM);

		return pageResult;

    }
}
