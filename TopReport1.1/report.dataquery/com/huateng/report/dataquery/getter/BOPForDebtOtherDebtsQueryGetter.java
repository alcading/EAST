package com.huateng.report.dataquery.getter;

import org.apache.commons.lang.StringUtils;

import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.PageQueryCondition;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.report.common.ReportConstant;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;
import com.huateng.report.constants.TopReportConstants;

@SuppressWarnings("unchecked")
public class BOPForDebtOtherDebtsQueryGetter extends BaseGetter{



	@Override
	public Result call() throws AppException {
		try {
			PageQueryResult queryResult = getData();

			setValue2DataBus(ReportConstant.QUERY_LOG_BUSI_NAME, "外债-其他外债补录信息查询-签约信息查询");

			ResultMng.fillResultByList(getCommonQueryBean(),
					getCommQueryServletRequest(), queryResult.getQueryResult(),
					getResult());
			result.setContent(queryResult.getQueryResult());
			result.getPage().setTotalPage(
					queryResult.getPageCount(getResult().getPage()
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

	private PageQueryResult getData() throws CommonException {

		StringBuffer hql = new StringBuffer(" SELECT bds FROM BopCfaExdebtDs bds WHERE 1 = 1 ");
		String qstartdate = getCommQueryServletRequest().getParameter("qstartdate");
		String qenddate = getCommQueryServletRequest().getParameter("qenddate");
		String actiontype = getCommQueryServletRequest().getParameter("actiontype");
		String recStatus = getCommQueryServletRequest().getParameter("recStatus");
		String approveStatus = getCommQueryServletRequest().getParameter("approveStatus");
		String repStatus = getCommQueryServletRequest().getParameter("repStatus");
		String filler2 = getCommQueryServletRequest().getParameter("filler2");
		String qbrNo = getCommQueryServletRequest().getParameter("qbrNo");

		if (StringUtils.isNotBlank(qstartdate)) {
			hql.append(" AND bds.workDate >= '").append(qstartdate).append("'");
		}
		if (StringUtils.isNotBlank(qenddate)) {
			hql.append(" AND bds.workDate <= '").append(qenddate).append("'");
		}
		if (StringUtils.isNotBlank(actiontype)) {
			hql.append(" AND bds.actiontype = '").append(actiontype).append("'");
		}
		if (StringUtils.isNotBlank(recStatus)) {
			hql.append(" AND bds.recStatus = '").append(recStatus).append("'");
		}
		if (StringUtils.isNotBlank(approveStatus)) {
			hql.append(" AND bds.approveStatus = '").append(approveStatus).append("'");
		}
		if (StringUtils.isNotBlank(repStatus)) {
			hql.append(" AND bds.repStatus = '").append(repStatus).append("'");
		}
		if (StringUtils.isNotBlank(filler2)) {
			hql.append(" AND bds.filler2 LIKE '%").append(filler2).append("%'");
		}
		if (StringUtils.isNotBlank(qbrNo)) {
			hql.append(" AND brNo = '").append(qbrNo).append("' ");
		}

		// 只查询应用类型 为 资本项目
		hql.append(" AND bds.apptype = '" + TopReportConstants.REPORT_APP_TYPE_CFA + "'");
		// 只查询文件类型 为 其他外债
		hql.append(" AND bds.currentfile = '" + TopReportConstants.REPORT_FILE_TYPE_CFA_AQ + "'");

//		hql.append(" ORDER BY bds.workDate,bds.approveStatus,bds.actiontype DESC ");
		hql.append(" ORDER BY bds.lstUpdTm DESC ");

		// 分页大小
		int pageSize = getResult().getPage().getEveryPage();
		// 页码
		int pageIndex = getResult().getPage().getCurrentPage();
		PageQueryCondition queryCondition = new PageQueryCondition();
		queryCondition.setPageIndex(pageIndex);
		queryCondition.setPageSize(pageSize);
		queryCondition.setQueryString(hql.toString());

		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		return rootdao.pageQueryByQL(queryCondition);
	}

}