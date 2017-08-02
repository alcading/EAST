package com.huateng.ebank.business.workflowRoute.getter;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.business.management.bean.RouteBindingView;
import com.huateng.ebank.business.management.operation.RouteBindingEntryQueryOperation;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.util.DataFormat;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

public class RouteBindingEntryQueryGetter extends BaseGetter {

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

		String bussType = (String)getCommQueryServletRequest().getParameterMap().get("bussType");
		String stringid = (String)getCommQueryServletRequest().getParameterMap().get("id");
		/** modify by shen_antonio 20091214 jira: BMS-2334 begin .*/
		String startBrhId = (String)getCommQueryServletRequest().getParameterMap().get("startBrhid");
		/** modify by shen_antonio 20091214 jira: BMS-2334 end .*/
		String startBrhClass = (String)getCommQueryServletRequest().getParameterMap().get("startBrhClass");
		if(!StringUtils.isEmpty(startBrhClass)){
			startBrhId = startBrhClass;
		}
		RouteBindingView routeBindingView = new RouteBindingView();
		/** modify by shen_antonio 20091214 jira: BMS-2334 begin .*/
		if(NumberUtils.isNumber(startBrhId)){
			routeBindingView.setStartBrhid(startBrhId);
		}
		/** modify by shen_antonio 20091214 jira: BMS-2334 end .*/
		routeBindingView.setBussType(bussType);
		if(!DataFormat.isEmpty(stringid)){
			Integer id = Integer.valueOf(stringid);
			routeBindingView.setId(id);
		}

		int PageIndex = getResult().getPage().getCurrentPage();
		int PageSize = getResult().getPage().getEveryPage();

		oc.setAttribute(RouteBindingEntryQueryOperation.IN_PARAM, routeBindingView);
		oc.setAttribute(RouteBindingEntryQueryOperation.IN_PARAM_PAGESIZE, PageSize);
		oc.setAttribute(RouteBindingEntryQueryOperation.IN_PARAM_PAGEINDEX, PageIndex);
		OPCaller.call("Management.RouteBindingEntryQueryOperation", oc);

		PageQueryResult pageResult = (PageQueryResult) oc
				.getAttribute(RouteBindingEntryQueryOperation.OUT_PARAM);
		return pageResult;

    }
}
