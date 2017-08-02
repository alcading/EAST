package com.huateng.ebank.business.workflowRoute.getter;

import org.apache.commons.lang.StringUtils;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.business.workflowRoute.operation.RouteBindingDetail2Operation;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

public class RouteBindingDetail2Getter extends BaseGetter {

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

	protected PageQueryResult getData() throws CommonException
    {
		OperationContext oc = new OperationContext();

//		PageQueryResult pageQueryResult = new PageQueryResult();

//		String routeId = (String)getCommQueryServletRequest().getParameterMap().get("routeId");
//		String bussType = (String)getCommQueryServletRequest().getParameterMap().get("bussType");
//		String brhClass = (String)getCommQueryServletRequest().getParameterMap().get("brhClass");
//		String draftType = (String)getCommQueryServletRequest().getParameterMap().get("draftType");
//		String startBrhno = (String)getCommQueryServletRequest().getParameterMap().get("startBrhno");
//		String maxAmt = (String)getCommQueryServletRequest().getParameterMap().get("maxAmt");
//		String isBand = (String)getCommQueryServletRequest().getParameterMap().get("isBand");
		String id = getCommQueryServletRequest().getParameter("id");

//		RouteBindingView routeBindingView = new RouteBindingView();
//		routeBindingView.setBussType(bussType);
//		routeBindingView.setBrhClass(brhClass);
//		routeBindingView.setDraftType(draftType);
//		routeBindingView.setStartBrhno(startBrhno);
//		routeBindingView.setMaxAmt(new BigDecimal(maxAmt));
//		routeBindingView.setId(Integer.valueOf(id));
//		if(!routeId.equals("")){
//			routeBindingView.setRouteId(Integer.valueOf(routeId));
//		}else{
//			routeBindingView.setRouteId(0);
//		}
//		routeBindingView.setIsBand(isBand);
//		List resultList = new ArrayList();
//		resultList.add(routeBindingView);
//		pageQueryResult.setTotalCount(resultList.size());
//		pageQueryResult.setQueryResult(resultList);

		if(StringUtils.isEmpty(id)){
			ExceptionUtil.throwCommonException("请先保存之前信息再进行绑定");
		}
		int PageIndex = getResult().getPage().getCurrentPage();
		int PageSize = getResult().getPage().getEveryPage();

		oc.setAttribute(RouteBindingDetail2Operation.IN_ID, id);
//		oc.setAttribute(RouteBindingDetail2Operation.IN_PARAM, routeBindingView);
		oc.setAttribute(RouteBindingDetail2Operation.IN_PARAM_PAGESIZE, PageSize);
		oc.setAttribute(RouteBindingDetail2Operation.IN_PARAM_PAGEINDEX, PageIndex);
		OPCaller.call("Management.RouteBindingDetail2Operation", oc);

		PageQueryResult pageResult = (PageQueryResult) oc
				.getAttribute(RouteBindingDetail2Operation.OUT_PARAM);
		return pageResult;

    }
}
