package com.huateng.report.imports.getter;

import org.apache.commons.lang.StringUtils;

import resource.report.dao.ROOTDAOUtils;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.PageQueryCondition;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.framework.report.common.ReportConstant;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

@SuppressWarnings("unchecked")
public class ImportFileLogGetter extends BaseGetter {

	@Override
	public Result call() throws AppException {
		try {
			// 分页大小
			int pageSize = getResult().getPage().getEveryPage();
			// 页码
			int pageIndex = getResult().getPage().getCurrentPage();

			StringBuffer hql = new StringBuffer(
					"from BiImportLog where 1=1 ");

			String qWorkDateStart = getCommQueryServletRequest().getParameter(
					"qWorkDateStart");
			String qWorkDateEnd = getCommQueryServletRequest().getParameter(
					"qWorkDateEnd");
			String qFileName = getCommQueryServletRequest().getParameter(
					"qFileName");
			String qImpStatus = getCommQueryServletRequest().getParameter(
					"qImpStatus");
			if (StringUtils.isNotBlank(qWorkDateStart)) {
				hql.append("and workDate >= '" + qWorkDateStart + "' ");
			}
			if (StringUtils.isNotBlank(qWorkDateEnd)) {
				hql.append("and workDate <= '" + qWorkDateEnd + "' ");
			}
			if (StringUtils.isNotBlank(qFileName)) {
				hql.append("and fileName like '%" + qFileName + "%' ");
			}
			if (StringUtils.isNotBlank(qImpStatus)) {
				hql.append("and importStatus = '" + qImpStatus + "' ");
			}
			hql.append(" order by beginTime desc");
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
			
			this.setValue2DataBus(ReportConstant.QUERY_LOG_BUSI_NAME, "文件导入日志查询");
			
			return result;
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}

}
