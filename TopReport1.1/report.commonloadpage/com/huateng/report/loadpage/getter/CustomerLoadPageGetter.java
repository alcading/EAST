package com.huateng.report.loadpage.getter;

import org.apache.commons.lang.StringUtils;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;
import com.huateng.report.basis.service.CustomerReaService;

public class CustomerLoadPageGetter extends BaseGetter{

	@Override
	public Result call() throws AppException {
		try {
			PageQueryResult  pageResult  = getData();
			ResultMng.fillResultByList(getCommonQueryBean(), 
					getCommQueryServletRequest(), 
					pageResult.getQueryResult(),getResult());
			result.setContent(pageResult.getQueryResult());
			result.getPage().setTotalPage(pageResult.getPageCount(getResult().getPage()
					.getEveryPage()));
			result.init();
			return result;
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}
	
	protected PageQueryResult getData() throws Exception {
		
		String loadFromType=this.getCommQueryServletRequest().getParameter("loadFromType");
		this.getCommQueryServletRequest().setParameter("loadFromType", loadFromType);
		
		String id=(String)this.getCommQueryServletRequest().getParameterMap().get("qId");
		String customerName = getCommQueryServletRequest().getParameter("qcustomerName");
		int pageIndex = getResult().getPage().getCurrentPage();
		int pageSize = getResult().getPage().getEveryPage();
		String hql = "select bi from  BiCustomer  bi where 1=1";
		if(!StringUtils.isEmpty(id)){
			hql +="and bi.id = '"+id+"'";
		}
		if(!StringUtils.isEmpty(customerName)){
			hql +=" and  bi.customerName like '%"+customerName+"%'";
		}
		hql += " order by bi.id";
		CustomerReaService customerReaService = CustomerReaService.getInstance();
		return customerReaService.list(pageSize, pageIndex, hql);
	}
}
