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

@SuppressWarnings("unchecked")
public class BOPForDebtBondBillAuditGetter extends BaseGetter {


	@Override
	public Result call() throws AppException {
		try {
			setValue2DataBus(ReportConstant.QUERY_LOG_BUSI_NAME, "债券和票据签约信息查询");
			PageQueryResult queryResult = getData();

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

		String qWorkDate = getCommQueryServletRequest().getParameter("qWorkDate");
		String eWorkDate = getCommQueryServletRequest().getParameter("eWorkDate");
		String qActiontype = getCommQueryServletRequest().getParameter("qActiontype");
		String qRecStatus = getCommQueryServletRequest().getParameter("qRecStatus");
		String qApproveStatus = getCommQueryServletRequest().getParameter("qApproveStatus");
		String qRepStatus = getCommQueryServletRequest().getParameter("qRepStatus");
		String filler2 = getCommQueryServletRequest().getParameter("filler2");

		StringBuffer hql = new StringBuffer(" SELECT bds FROM BopCfaExdebtDs bds WHERE 1 = 1 ");

		List<Object>paramentList = new ArrayList<Object>();
		if (StringUtils.isNotBlank(qWorkDate)) {
			hql.append(" AND bds.workDate >= ? ");
			paramentList.add(qWorkDate);
		}
		if (StringUtils.isNotBlank(eWorkDate)) {
			hql.append(" AND bds.workDate <= ? ");
			paramentList.add(eWorkDate);
		}
		if (StringUtils.isNotBlank(qActiontype)) {
			hql.append(" AND bds.actiontype = ? ");
			paramentList.add(qActiontype);
		}
		if (StringUtils.isNotBlank(qRecStatus)) {
			hql.append(" AND bds.recStatus = ? ");
			paramentList.add(qRecStatus);
		}
		if (StringUtils.isNotBlank(qApproveStatus)) {
			hql.append(" AND bds.approveStatus = ? ");
			paramentList.add(qApproveStatus);
		}
		if (StringUtils.isNotBlank(qRepStatus)) {
			hql.append(" AND bds.repStatus = ? ");
			paramentList.add(qRepStatus);
		}
		if (StringUtils.isNotBlank(filler2)) {
			hql.append(" AND bds.filler2 LIKE ? ");
			paramentList.add("%"+filler2+"%");
		}

		GlobalInfo gInfo = GlobalInfo.getCurrentInstance();
		hql.append(" AND bds.brNo = ? ");
		paramentList.add(gInfo.getBrno());

		hql.append(" AND bds.apptype = ? ");
		paramentList.add(TopReportConstants.REPORT_APP_TYPE_CFA);

		hql.append(" AND bds.currentfile = ? ");
		paramentList.add(TopReportConstants.REPORT_FILE_TYPE_CFA_AK);

		hql.append(" AND (bds.recStatus = ? OR  bds.recStatus= ? ) ");
		paramentList.add(TopReportConstants.REPORT_RECSTATUS_03);
		paramentList.add(TopReportConstants.REPORT_RECSTATUS_04);

		hql.append(" ORDER by bds.lstUpdTm DESC,bds.workDate, bds.actiontype, bds.approveStatus DESC ");


		int pageSize = getResult().getPage().getEveryPage();
		//页码
		int pageIndex = getResult().getPage().getCurrentPage();

		PageQueryCondition queryCondition = new PageQueryCondition();
		queryCondition.setPageIndex(pageIndex);
		queryCondition.setPageSize(pageSize);
		queryCondition.setQueryString(hql.toString());
		queryCondition.setObjArray(paramentList.toArray());
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		return rootdao.pageQueryByQL(queryCondition);
	}

}
