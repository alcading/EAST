package com.huateng.report.getter;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import resource.dao.base.HQLDAO;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.DAOUtils;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.PageQueryCondition;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.framework.report.common.ReportConstant;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;
import com.huateng.report.constants.TopReportConstants;

@SuppressWarnings("unchecked")
public class BOPCfaLounexguRecordVerGetter extends BaseGetter {

	@Override
	public Result call() throws AppException {
		try {
			setValue2DataBus(ReportConstant.QUERY_LOG_BUSI_NAME, "境外担保项下境内贷款信息审核签约信息查询");

			PageQueryResult list = getData();
			ResultMng.fillResultByList(getCommonQueryBean(), getCommQueryServletRequest(), list.getQueryResult(),
					getResult());
			result.setContent(list.getQueryResult());
			result.getPage().setTotalPage(list.getPageCount(getResult().getPage().getEveryPage()));
			result.init();
			return result;
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE, Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}

	private PageQueryResult getData() throws AppException {
		int pageIndex = getResult().getPage().getCurrentPage();
		int pageSize = getResult().getPage().getEveryPage();

		String qworkDate = getCommQueryServletRequest().getParameter("qworkDate");
		String eworkDate = getCommQueryServletRequest().getParameter("eworkDate");
		String qactiontype = getCommQueryServletRequest().getParameter("qactiontype");
		String qrecStatus = getCommQueryServletRequest().getParameter("qrecStatus");
		String qapproveStatus = getCommQueryServletRequest().getParameter("qapproveStatus");
		String qrepStatus = getCommQueryServletRequest().getParameter("qrepStatus");
		String qfiller2 = getCommQueryServletRequest().getParameter("qfiller2");

		StringBuilder hqlString = new StringBuilder(" SELECT bd FROM BopCfaLounexguDs bd WHERE bd.currentfile = ? AND (bd.recStatus = ? OR bd.recStatus = ? ) ");

		List<Object>paramentList = new ArrayList<Object>();
		paramentList.add(TopReportConstants.REPORT_FILE_TYPE_CFA_DA);
		paramentList.add(TopReportConstants.REPORT_RECSTATUS_03);
		paramentList.add(TopReportConstants.REPORT_RECSTATUS_04);

		if (StringUtils.isNotBlank(qworkDate)) {
			hqlString.append(" AND workDate >= ? ");
			paramentList.add(qworkDate);
		}
		if (StringUtils.isNotBlank(eworkDate)) {
			hqlString.append(" AND workDate <= ? ");
			paramentList.add(eworkDate);
		}
		if (StringUtils.isNotBlank(qactiontype)) {
			hqlString.append(" AND actiontype = ? ");
			paramentList.add(qactiontype);
		}
		if (StringUtils.isNotBlank(qrecStatus)) {
			hqlString.append(" AND recStatus = ? ");
			paramentList.add(qrecStatus);
		}
		if (StringUtils.isNotBlank(qapproveStatus)) {
			hqlString.append(" AND approveStatus = ? ");
			paramentList.add(qapproveStatus);
		}
		if (StringUtils.isNotBlank(qrepStatus)) {
			hqlString.append(" AND repStatus = ? ");
			paramentList.add(qrepStatus);
		}
		if (StringUtils.isNotBlank(qfiller2)) {
			hqlString.append(" AND filler2 LIKE ? ");
			paramentList.add("%" + qfiller2 + "%");
		}
		GlobalInfo gi = GlobalInfo.getCurrentInstance();
		if (StringUtils.isNotBlank(gi.getBrno())) {
			hqlString.append(" AND brNo = ? ");
			paramentList.add(gi.getBrno());
		}
		hqlString.append(" ORDER BY lstUpdTm DESC,workDate, actiontype, approveStatus DESC ");

		PageQueryCondition pc = new PageQueryCondition();
		pc.setPageIndex(pageIndex);
		pc.setPageSize(pageSize);
		pc.setQueryString(hqlString.toString());
		pc.setObjArray(paramentList.toArray());
		HQLDAO hqlDao = DAOUtils.getHQLDAO();
		PageQueryResult pageQueryResult = hqlDao.pageQueryByQL(pc);
		return pageQueryResult;

	}
}
