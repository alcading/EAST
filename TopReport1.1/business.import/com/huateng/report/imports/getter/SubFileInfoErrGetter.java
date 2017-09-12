package com.huateng.report.imports.getter;

import org.apache.commons.lang.StringUtils;

import resource.dao.base.HQLDAO;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.DAOUtils;
import com.huateng.ebank.business.common.PageQueryCondition;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

public class SubFileInfoErrGetter extends BaseGetter {

	@Override
	public Result call() throws AppException {
		// TODO Auto-generated method stub
		try {
			PageQueryResult pageResult  = getData();
			ResultMng.fillResultByList(getCommonQueryBean(), 
					getCommQueryServletRequest(), 
					pageResult.getQueryResult(),getResult());
			result.setContent(pageResult.getQueryResult());
			result.getPage().setTotalPage(pageResult.getPageCount(getResult().getPage().getEveryPage()));
			result.init();
			return result;
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	} 
	
	private PageQueryResult getData() throws CommonException{
		int pageIndex = getResult().getPage().getCurrentPage();
		int pageSize = getResult().getPage().getEveryPage();
		String fileName = getCommQueryServletRequest().getParameter("fileName");
		String hql = "select sf,rf from SubFileInfo sf,RepFileErrDet rf  where sf.id = rf.repFileName";
		 if(StringUtils.isNotBlank(fileName)){
			 hql +=" and sf.id = '"+fileName+"'";
		 }
		PageQueryCondition pc =new PageQueryCondition();
		pc.setPageIndex(pageIndex);
		pc.setPageSize(pageSize);
		pc.setQueryString(hql);
		HQLDAO hqlDao = DAOUtils.getHQLDAO();
		return hqlDao.pageQueryByQL(pc);
		
	}
}
