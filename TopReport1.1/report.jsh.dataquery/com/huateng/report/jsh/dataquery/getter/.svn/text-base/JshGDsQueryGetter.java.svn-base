package com.huateng.report.jsh.dataquery.getter;

import java.util.ArrayList;
import java.util.List;

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
import com.huateng.ebank.framework.report.common.ReportConstant;
import com.huateng.ebank.framework.util.DataFormat;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;
import com.huateng.report.constants.TopReportConstants;

@SuppressWarnings("unchecked")
public class JshGDsQueryGetter extends BaseGetter {
	/**
	 * @author huangcheng
	 */
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
			this.setValue2DataBus(ReportConstant.QUERY_LOG_BUSI_NAME, "外汇账户内购汇管理信息补录页面查询");
			return result;
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}

	private PageQueryResult getData() throws CommonException {

		int pageSize = getResult().getPage().getEveryPage();
		int pageIndex = getResult().getPage().getCurrentPage();
		GlobalInfo gInfo = GlobalInfo.getCurrentInstance();
		ROOTDAO rootDAO = ROOTDAOUtils.getROOTDAO();
		PageQueryResult pageQueryResult = null;
		PageQueryCondition queryCondition = new PageQueryCondition();

		StringBuilder hql = new StringBuilder(
				" SELECT model FROM MtsJshDefgDs model WHERE 1 = 1 ");
	
		String qstartDate = getCommQueryServletRequest().getParameter("qstartDate");
		String qendDate = getCommQueryServletRequest().getParameter("qendDate");

		String qActiontype = getCommQueryServletRequest().getParameter("qActiontype");
		String qRecStatus = getCommQueryServletRequest().getParameter("qRecStatus");

		String qApproveStatus = getCommQueryServletRequest().getParameter("qApproveStatus");
		String qRepStatus = getCommQueryServletRequest().getParameter("qRepStatus");

		String qfiller2 = getCommQueryServletRequest().getParameter("qfiller2");

		List<Object> paramentList = new ArrayList<Object>();
		if (!DataFormat.isEmpty(qstartDate)) {
			hql.append(" AND model.workDate >= ? ");
			paramentList.add(qstartDate);
		}
		if (!DataFormat.isEmpty(qendDate)) {
			hql.append(" AND model.workDate <= ? ");
			paramentList.add(qendDate);
		}
		if (StringUtils.isNotBlank(qActiontype)) {
			hql.append(" AND model.actiontype = ? ");
			paramentList.add(qActiontype);
		}
		if (StringUtils.isNotBlank(qRecStatus)) {
			hql.append(" AND model.recStatus = ? ");
			paramentList.add(qRecStatus);
		}
		if (StringUtils.isNotBlank(qApproveStatus)) {
			hql.append(" AND model.approveStatus = ? ");
			paramentList.add(qApproveStatus);
		}
		if (StringUtils.isNotBlank(qRepStatus)) {
			hql.append(" AND model.repStatus = ? ");
			paramentList.add(qRepStatus);
		}
		if (StringUtils.isNotBlank(qfiller2)) {
			hql.append(" AND model.filler2 LIKE ? ");
			paramentList.add("%" + qfiller2 + "%");
		}

		hql.append(" AND model.brNo = ? ");
		paramentList.add(gInfo.getBrno());

		hql.append(" AND model.apptype = ? ");
		paramentList.add(TopReportConstants.REPORT_APP_TYPE_JSH);

		hql.append(" AND model.currentfile= ? ");
		paramentList.add(TopReportConstants.REPORT_FILE_TYPE_JSH_G);

		hql.append(" ORDER BY model.workDate, model.actiontype, model.approveStatus DESC");
		queryCondition.setQueryString(hql.toString());
		queryCondition.setPageIndex(pageIndex);
		queryCondition.setPageSize(pageSize);
		queryCondition.setObjArray(paramentList.toArray());
		pageQueryResult = rootDAO.pageQueryByQL(queryCondition);

	    return pageQueryResult;
	}
}