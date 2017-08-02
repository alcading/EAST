package com.huateng.ebank.business.workflowRoute.getter;

import java.util.List;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.business.workflowRoute.operation.RouteDetailQueryOperation;
import com.huateng.ebank.entity.data.workflow.WorkflowRouteParam;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

public class RouteDetailQueryGetter extends BaseGetter {

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

		String id = (String)getCommQueryServletRequest().getParameterMap().get("id");
		if(id ==null){
			id = (String)getCommQueryServletRequest().getParameterMap().get("routeId");
		}
		if(id.equals("")){
			ExceptionUtil.throwCommonException("请先保存审批路线模板");
		}
		WorkflowRouteParam workflowRouteParam = new WorkflowRouteParam();
		workflowRouteParam.setRouteId(Integer.valueOf(id));

		int PageIndex = getResult().getPage().getCurrentPage();
		int PageSize = getResult().getPage().getEveryPage();

		oc.setAttribute(RouteDetailQueryOperation.IN_PARAM, workflowRouteParam);
		oc.setAttribute(RouteDetailQueryOperation.IN_PARAM_PAGESIZE, PageSize);
		oc.setAttribute(RouteDetailQueryOperation.IN_PARAM_PAGEINDEX, PageIndex);
		OPCaller.call("Management.RouteDetailQueryOperation", oc);

		PageQueryResult pageResult = (PageQueryResult) oc
				.getAttribute(RouteDetailQueryOperation.OUT_PARAM);
		List resultlist  = pageResult.getQueryResult();
		Integer laststopId = 0;
		for(int i=0;i<resultlist.size();i++){
			WorkflowRouteParam resultwrp = (WorkflowRouteParam) resultlist.get(i);
			if(resultwrp.getStopId().compareTo(laststopId)>0){
				laststopId = resultwrp.getStopId();
			}else{
				continue;
			}
		}
		result.setParameter("lastStopId", laststopId.toString());
		return pageResult;

    }
}
