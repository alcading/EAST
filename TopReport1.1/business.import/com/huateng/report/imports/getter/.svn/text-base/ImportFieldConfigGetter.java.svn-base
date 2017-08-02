package com.huateng.report.imports.getter;



import org.apache.commons.lang.StringUtils;
import resource.dao.base.HQLDAO;
import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.business.management.common.DAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

public class ImportFieldConfigGetter extends BaseGetter {
	@Override
	public Result call() throws AppException {
		try {			
			PageQueryResult pageResult = getData();
			ResultMng.fillResultByList(getCommonQueryBean(),
					getCommQueryServletRequest(), pageResult.getQueryResult(),
					getResult());
			result.setContent(pageResult.getQueryResult());
			result.getPage().setTotalPage(1);
			result.init();
			return result;
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}
	
	private PageQueryResult getData() throws CommonException {
		String importFileId = getCommQueryServletRequest().getParameter("importFileId");
		StringBuffer hql = new StringBuffer("select dd from BiImportFieldConfig dd where 1=1");			
		if (StringUtils.isNotBlank(importFileId)) {
			//hql.append(" and dd.importFileId like '%").append(importFileId).append("%'");
			hql.append(" and dd.importFileId ='").append(importFileId).append("'");
		}
		HQLDAO hqlDAO = DAOUtils.getHQLDAO();
		PageQueryResult pageResult=new PageQueryResult();
		pageResult.setQueryResult(hqlDAO.queryByQL2List(hql.toString()));
		return pageResult;
	
	}
}
