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

public class SubFileInfoGetter  extends BaseGetter{

	@Override
	public Result call() throws AppException {
		try {
			PageQueryResult pageResult  = getData();
			ResultMng.fillResultByList(getCommonQueryBean(),
					getCommQueryServletRequest(),
					pageResult.getQueryResult(),getResult());
			result.setContent(pageResult.getQueryResult());
			result.getPage().setTotalPage(pageResult.getPageCount(getResult().getPage().getEveryPage()));
			result.init();
			return result;
		} catch (CommonException e) {
			throw e;
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
		String packname = getCommQueryServletRequest().getParameter("packname");
		//文件名称
		String recId = getCommQueryServletRequest().getParameter("recId");
		String hql = "";
		if(StringUtils.isEmpty(recId)){
			if (packname==null||packname.length()==0) {
				return new PageQueryResult();
			}
			hql = " from SubFileInfo sf where sf.filePack='"+packname+"'";
		} else {
			hql = " from SubFileInfo sf where sf.id='"+recId+"'";
		}
		
		PageQueryCondition pc =new PageQueryCondition();
		pc.setPageIndex(pageIndex);
		pc.setPageSize(pageSize);
		pc.setQueryString(hql);
		HQLDAO hqlDao = DAOUtils.getHQLDAO();
		return hqlDao.pageQueryByQL(pc);
	}
}
