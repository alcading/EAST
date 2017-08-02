package com.huateng.report.basis.getter;

import org.apache.commons.lang.StringUtils;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;
import com.huateng.report.basis.service.CustomerReaService;

public class CustomerReaQueryGetter  extends BaseGetter{

	@Override
	public Result call() throws AppException {
		try {
			PageQueryResult  pageResult  = getData();
			GlobalInfo.getCurrentInstance().addBizLog("客户信息管理测试");
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
		PageQueryResult result = new PageQueryResult();
		
		String orgid=(String)this.getCommQueryServletRequest().getParameterMap().get("qorgId");
		String customerName = getCommQueryServletRequest().getParameter("qcustomerName");
		String customerType = getCommQueryServletRequest().getParameter("qcustomerType");
		String qpaperType = getCommQueryServletRequest().getParameter("qpaperType");
		int pageIndex = getResult().getPage().getCurrentPage();
		int pageSize = getResult().getPage().getEveryPage();
		//int maxIndex = pageIndex * pageSize;
		
		PageQueryResult pageQuertResult = new PageQueryResult();
		String hql = "select bi from  BiCustomer  bi where 1=1";
		if(!StringUtils.isEmpty(orgid)){
			hql +="and bi.orgId = '"+orgid+"'";
		}
		if(!StringUtils.isEmpty(customerName)){
			hql +=" and  bi.customerName= '"+customerName+"'";
		}
		if(!StringUtils.isEmpty(customerType)){
			hql +=" and bi.customerType='"+customerType + "'";
		}
		if(!StringUtils.isEmpty(qpaperType)){
			hql +=" and bi.paperType = '" + qpaperType+"'";
		}
		CustomerReaService customerReaService = CustomerReaService.getInstance();
		
		return customerReaService.list(pageSize, pageIndex, hql);
		//hql +="order by bi.orgid";
//		ROOTDAO rootDao = ROOTDAOUtils.getROOTDAO();
//		result.setQueryResult(rootDao.pageQueryByHql(hql,pageIndex,pageSize));
//		result.setTotalCount(1);
//		return result;
	}
}
