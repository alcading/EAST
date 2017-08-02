package com.huateng.ebank.business.workflowRoute.getter;


import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.business.workflowRoute.operation.RouteTemplateQueryOperation;
import com.huateng.ebank.entity.data.workflow.WorkflowRouteDef;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

public class RouteTemplateQueryGetter extends BaseGetter {

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
		}catch(CommonException e){
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, e.getMessage());
		}catch(AppException appEx){
			throw appEx;
		}catch(Exception ex){
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(),ex);
		}

	}

	protected PageQueryResult getData() throws CommonException
    {
		OperationContext oc = new OperationContext();

//		PageQueryResult pageQueryResult = new PageQueryResult();

		String brhClass = (String)getCommQueryServletRequest().getParameterMap().get("brhClass");


		WorkflowRouteDef workflowRouteDef = new WorkflowRouteDef();
		workflowRouteDef.setBrhClass(brhClass);

		int PageIndex = getResult().getPage().getCurrentPage();
		int PageSize = getResult().getPage().getEveryPage();

		oc.setAttribute(RouteTemplateQueryOperation.IN_PARAM, workflowRouteDef);
		oc.setAttribute(RouteTemplateQueryOperation.IN_PARAM_PAGESIZE, PageSize);
		oc.setAttribute(RouteTemplateQueryOperation.IN_PARAM_PAGEINDEX, PageIndex);
		OPCaller.call("Management.RouteTemplateQueryOperation", oc);

		PageQueryResult pageResult = (PageQueryResult) oc
				.getAttribute(RouteTemplateQueryOperation.OUT_PARAM);
		return pageResult;

    }
}
