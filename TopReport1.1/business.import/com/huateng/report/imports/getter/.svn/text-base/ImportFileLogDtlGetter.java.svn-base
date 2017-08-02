package com.huateng.report.imports.getter;

import org.apache.commons.lang.StringUtils;

import resource.report.dao.ROOTDAOUtils;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.PageQueryCondition;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

@SuppressWarnings("unchecked")
public class ImportFileLogDtlGetter extends BaseGetter {

	@Override
	public Result call() throws AppException {
		try {
			// 分页大小
			int pageSize = getResult().getPage().getEveryPage();
			// 页码
			int pageIndex = getResult().getPage().getCurrentPage();

			StringBuffer hql = new StringBuffer(
					"from BiImportLogDtl where 1=1 ");
			
			String logid = getCommQueryServletRequest().getParameter(
					"logid");
			if (StringUtils.isNotBlank(logid)) {
				hql.append("and log.id = '" + logid + "' ");
			}
			hql.append(" order by lineNo");
			PageQueryCondition queryCondition = new PageQueryCondition();
			queryCondition.setQueryString(hql.toString());
			queryCondition.setPageIndex(pageIndex);
			queryCondition.setPageSize(pageSize);

			PageQueryResult pageResult = ROOTDAOUtils.getROOTDAO()
					.pageQueryByQL(queryCondition);

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

}
