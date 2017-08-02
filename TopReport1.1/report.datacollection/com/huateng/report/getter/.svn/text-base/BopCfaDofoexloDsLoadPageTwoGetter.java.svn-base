package com.huateng.report.getter;

import org.apache.commons.lang.StringUtils;

import resource.dao.base.HQLDAO;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.PageQueryCondition;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.business.management.common.DAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.report.common.ReportConstant;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;
import com.huateng.report.constants.TopReportConstants;

@SuppressWarnings("unchecked")
public class BopCfaDofoexloDsLoadPageTwoGetter  extends BaseGetter{


	@Override
	public Result call() throws AppException {
		try {
			PageQueryResult pageQueryResult = getData();

			setValue2DataBus(ReportConstant.QUERY_LOG_BUSI_NAME, "国内外汇贷款补录-国内外汇贷款签约信息查询");

			ResultMng.fillResultByList(getCommonQueryBean(),
					getCommQueryServletRequest(), pageQueryResult.getQueryResult(),
					getResult());
			result.setContent(pageQueryResult.getQueryResult());
			result.getPage().setTotalPage(pageQueryResult.getPageCount(getResult().getPage().getEveryPage()));
			result.init();
			return result;
		} catch (CommonException e) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, e.getMessage());
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}

	public PageQueryResult getData() throws CommonException {
		// 分页大小
		int pageSize = getResult().getPage().getEveryPage();
		// 页码
		int pageIndex = getResult().getPage().getCurrentPage();
		StringBuilder queryhql = new StringBuilder(
				" FROM BopCfaDofoexloDs  model WHERE model.currentfile = '"+TopReportConstants.REPORT_FILE_TYPE_CFA_CA+"'");
//		queryhql.append(" and model.recStatus ='"+TopReportConstants.REPORT_RECSTATUS_05+"'" );
		queryhql.append(" and model.currence !='CNY'");
		String workDate = getCommQueryServletRequest().getParameter("workDate");
		String actiontype = getCommQueryServletRequest().getParameter("actiontype");
		String recStatus = getCommQueryServletRequest().getParameter("recStatus");
		String approveStatus = getCommQueryServletRequest().getParameter("approveStatus");
		String repStatus = getCommQueryServletRequest().getParameter("repStatus");
		String dofoexlocode = getCommQueryServletRequest().getParameter("dofoexlocode");

		if (StringUtils.isNotBlank(workDate)) {
			queryhql.append("and model.workDate ='"+workDate+"'");
		}
		if (StringUtils.isNotBlank(actiontype)) {
			queryhql.append(" and model.actiontype ='"+actiontype+"'");
		}
		if (StringUtils.isNotBlank(recStatus)) {
			queryhql.append(" and model.recStatus ='"+recStatus+"'");
		}
		if (StringUtils.isNotBlank(approveStatus)) {
			queryhql.append(" and model.approveStatus ='"+approveStatus+"'");
		}
		if (StringUtils.isNotBlank(repStatus)) {
			queryhql.append(" and model.repStatus ='"+repStatus+"'");
		}
		if (StringUtils.isNotBlank(dofoexlocode)) {
			queryhql.append(" and model.dofoexlocode ='"+dofoexlocode+"'");
		}

		PageQueryCondition queryCondition = new PageQueryCondition();
		queryCondition.setQueryString(queryhql.toString());
		queryCondition.setPageIndex(pageIndex);
		queryCondition.setPageSize(pageSize);
		HQLDAO hqlDAO = DAOUtils.getHQLDAO();
		PageQueryResult result = hqlDAO.pageQueryByQL(queryCondition);
		return result;

	}

}
