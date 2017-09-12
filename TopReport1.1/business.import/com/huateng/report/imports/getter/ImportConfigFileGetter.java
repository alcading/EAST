package com.huateng.report.imports.getter;

import resource.dao.base.HQLDAO;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.PageQueryCondition;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.business.datadic.service.DataDicService;
import com.huateng.ebank.business.management.common.DAOUtils;
import com.huateng.ebank.framework.report.common.ReportConstant;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

public class ImportConfigFileGetter extends BaseGetter {
	@Override
	public Result call() throws AppException {
		try {			
			PageQueryResult pageResult = getData();
			ResultMng.fillResultByList(getCommonQueryBean(),
					getCommQueryServletRequest(), pageResult.getQueryResult(),
					getResult());
			result.setContent(pageResult.getQueryResult());
			result.getPage().setTotalPage(
					pageResult.getPageCount(getResult().getPage()
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
	
	private PageQueryResult getData() throws AppException {
		this.setValue2DataBus(ReportConstant.QUERY_LOG_BUSI_NAME, "文件导入配置信息查询");
		//分页大小
		int pageSize = getResult().getPage().getEveryPage();
		//页码
		int pageIndex = getResult().getPage().getCurrentPage();
		
		DataDicService service = new DataDicService();
		StringBuffer hql = new StringBuffer("select dd from BiImportFileConfig dd where 1=1");
		
		PageQueryCondition queryCondition = new PageQueryCondition();
		queryCondition.setQueryString(hql.toString());
		queryCondition.setPageIndex(pageIndex);
		queryCondition.setPageSize(pageSize);
		HQLDAO hqlDAO = DAOUtils.getHQLDAO();
		
		return hqlDAO.pageQueryByQL(queryCondition);
	
	}
}
