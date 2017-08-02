package com.huateng.report.genupreportfile.getter;

import java.util.Collections;

import org.apache.commons.lang.StringUtils;

import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.PageQueryCondition;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;
import com.huateng.report.constants.TopReportConstants;

@SuppressWarnings("unchecked")
public class BOPForDebtBondBillGenGetter extends BaseGetter {

	@Override
	public Result call() throws AppException {
		try {
			PageQueryResult queryResult = getData();
			if (!queryResult.getQueryResult().isEmpty()) {
				ResultMng.fillResultByList(getCommonQueryBean(),
						getCommQueryServletRequest(), queryResult
								.getQueryResult(), getResult());
				result.setContent(queryResult.getQueryResult());
				result.getPage().setTotalPage(
						queryResult.getPageCount(getResult().getPage()
								.getEveryPage()));
				result.init();
			} else {
				result.setContent(Collections.emptyList());
				result.getPage().setTotalPage(0);
				result.init();
			}
			return result;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}

	/**
	 * 根据输入的查询条件进行查询
	 *
	 * @return PageQueryResult：返回查询的结果集
	 * @throws CommonException
	 * @throws CommonException
	 */
	private PageQueryResult getData() throws CommonException {

		StringBuilder hql = new StringBuilder(" SELECT bds FROM BopCfaExdebtDs bds WHERE 1 = 1 ");

		String workDate = GlobalInfo.getCurrentInstance().getFileDate();
		String actiontype = getCommQueryServletRequest().getParameter("actiontype");
//		String repStatus = getCommQueryServletRequest().getParameter("repStatus");
		String filler2 = getCommQueryServletRequest().getParameter("filler2");
		String brcode = getCommQueryServletRequest().getParameter("qbrNo");

		if (StringUtils.isNotBlank(workDate)) {
			hql.append(" AND bds.workDate = '").append(workDate).append("' ");
		}
		if (StringUtils.isNotBlank(actiontype)) {
			hql.append(" AND bds.actiontype = '").append(actiontype).append("' ");
		}
//		if (StringUtils.isNotBlank(repStatus)) {
//			hql.append(" AND bds.repStatus = '").append(repStatus).append("' ");
//		}
		if (StringUtils.isNotBlank(filler2)) {
			hql.append(" AND bds.filler2 LIKE '%").append(filler2).append("%' ");
		}
		if (StringUtils.isNotBlank(brcode)) {
			hql.append(" AND brNo = '").append(brcode).append("' ");
		}

		// 只查询应用类型 为 资本项目
		hql.append(" AND bds.apptype= '" + TopReportConstants.REPORT_APP_TYPE_CFA + "'");
		// 只查询文件类型 为 债券和票据
		hql.append(" AND bds.currentfile= '" + TopReportConstants.REPORT_FILE_TYPE_CFA_AK + "'");
		// 只查询记录状态为可编辑何编辑待确认的记录
		hql.append(" AND bds.recStatus = '" + TopReportConstants.REPORT_RECSTATUS_05 + "' ");
		hql.append(" ORDER BY bds.workDate, bds.approveStatus, bds.actiontype DESC");

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
