package com.huateng.report.getter;



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
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;
import com.huateng.report.constants.TopReportConstants;

/**
 *
 * 外债信息表Getter
 * @author wenhao.chen
 * @version 1.0
 * 2012-8-30
 *
 * */
@SuppressWarnings("unchecked")
public class BOPForDebtNobleMetalLendingGetter extends BaseGetter {

	public Result call() throws AppException {
		try {
			setValue2DataBus(ReportConstant.QUERY_LOG_BUSI_NAME, "外债信息贵金属拆借签约信息查询");
			PageQueryResult queryResult = getData();

			ResultMng.fillResultByList(getCommonQueryBean(),
					getCommQueryServletRequest(), queryResult.getQueryResult(),
					getResult());
			result.setContent(queryResult.getQueryResult());
			result.getPage().setTotalPage(queryResult.getPageCount(getResult().getPage().getEveryPage()));
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

		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		GlobalInfo gInfo = GlobalInfo.getCurrentInstance();
		//
		int pageSize = getResult().getPage().getEveryPage();
		// 页码
		int pageIndex = getResult().getPage().getCurrentPage();

		PageQueryCondition queryCondition = new PageQueryCondition();

		StringBuffer hql = new StringBuffer(" SELECT bds FROM BopCfaExdebtDs bds WHERE 1 = 1 ");

		String qworkDateStart = getCommQueryServletRequest().getParameter("qworkDateStart");
		String qworkDateEnd = getCommQueryServletRequest().getParameter("qworkDateEnd");
		String qactiontype = getCommQueryServletRequest().getParameter("qactiontype");

		String qRecStatus = getCommQueryServletRequest().getParameter("qRecStatus");
		String qapproveStatus = getCommQueryServletRequest().getParameter("qapproveStatus");

		String qrepStatus = getCommQueryServletRequest().getParameter("qrepStatus");
		String qfiller2 = getCommQueryServletRequest().getParameter("qfiller2");

		List<Object> paramentList = new ArrayList<Object>();
		if (StringUtils.isNotBlank(qworkDateStart)) {
			hql.append(" AND bds.workDate >= ? ");
			paramentList.add(qworkDateStart);
		}
		if (StringUtils.isNotBlank(qworkDateEnd)) {
			hql.append(" AND bds.workDate <= ? ");
			paramentList.add(qworkDateEnd);
		}
		if (StringUtils.isNotBlank(qactiontype)) {
			hql.append(" AND bds.actiontype = ? ");
			paramentList.add(qactiontype);
		}
		if (StringUtils.isNotBlank(qRecStatus)) {
			hql.append(" AND bds.recStatus = ? ");
			paramentList.add(qRecStatus);
		}
		if (StringUtils.isNotBlank(qapproveStatus)) {
			hql.append(" AND bds.approveStatus = ? ");
			paramentList.add(qapproveStatus);
		}
		if (StringUtils.isNotBlank(qrepStatus)) {
			hql.append(" AND bds.repStatus = ? ");
			paramentList.add(qrepStatus);
		}
		if (StringUtils.isNotBlank(qfiller2)) {
			hql.append(" AND bds.filler2 like ? ");
			paramentList.add("%" + qfiller2 + "%");
		}

		hql.append(" AND bds.brNo= ? ");
		paramentList.add(gInfo.getBrno());

		hql.append(" AND bds.apptype = ? ");
		paramentList.add(TopReportConstants.REPORT_APP_TYPE_CFA);

		hql.append(" AND bds.currentfile = ? ");
		paramentList.add(TopReportConstants.REPORT_FILE_TYPE_CFA_AH);

		hql.append(" AND ( bds.recStatus = ? or  bds.recStatus = ? ) ");
		paramentList.add(TopReportConstants.REPORT_RECSTATUS_01);
		paramentList.add(TopReportConstants.REPORT_RECSTATUS_02);

		hql.append(" ORDER BY bds.lstUpdTm DESC,bds.workDate, bds.actiontype, bds.approveStatus DESC ");

		queryCondition.setPageIndex(pageIndex);
		queryCondition.setPageSize(pageSize);
		queryCondition.setQueryString(hql.toString());
		queryCondition.setObjArray(paramentList.toArray(new Object[0]));
		return rootdao.pageQueryByQL(queryCondition);
	}

}
