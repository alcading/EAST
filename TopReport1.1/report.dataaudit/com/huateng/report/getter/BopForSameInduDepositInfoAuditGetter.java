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
import com.huateng.ebank.framework.report.common.ReportConstant;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;
import com.huateng.report.constants.TopReportConstants;

@SuppressWarnings("unchecked")
public class BopForSameInduDepositInfoAuditGetter extends BaseGetter {

	public Result call() throws AppException {
	try {
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

	private PageQueryResult getData() throws AppException
	{
		setValue2DataBus(ReportConstant.QUERY_LOG_BUSI_NAME, "境外同业存放审核信息签约信息查询");
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		int pageSize = getResult().getPage().getEveryPage();
		//页码
		int pageIndex = getResult().getPage().getCurrentPage();

		PageQueryCondition pc = new PageQueryCondition();

		StringBuffer hql = new StringBuffer("");
		hql.append(" SELECT bds  FROM BopCfaExdebtDs bds  WHERE 1 = 1 ");

		String qworkDate = getCommQueryServletRequest().getParameter("qworkDate");
		String eworkDate = getCommQueryServletRequest().getParameter("eworkDate");
		String qactiontype = getCommQueryServletRequest().getParameter("qactiontype");

		String qrecStatus = getCommQueryServletRequest().getParameter("qrecStatus");
		String qapproveStatus = getCommQueryServletRequest().getParameter("qapproveStatus");

		String qrepStatus = getCommQueryServletRequest().getParameter("qrepStatus");
		String qfiller2 = getCommQueryServletRequest().getParameter("qfiller2");

		List<Object>paramentList = new ArrayList<Object>();
		if(StringUtils.isNotBlank(qworkDate) ){
			hql.append(" AND bds.workDate >= ? ");
			paramentList.add(qworkDate);
		}
		if(StringUtils.isNotBlank(eworkDate)){
			hql.append(" AND bds.workDate <= ? ");
			paramentList.add(eworkDate);
		}
		if(StringUtils.isNotBlank(qactiontype))
		{
			hql.append(" AND bds.actiontype = ? ");
			paramentList.add(qactiontype);
		}
		if(StringUtils.isNotBlank(qrecStatus))
		{
			hql.append(" AND bds.recStatus = ? ");
			paramentList.add(qrecStatus);
		}
		if(StringUtils.isNotBlank(qapproveStatus))
		{
			hql.append(" AND bds.approveStatus = ? ");
			paramentList.add(qapproveStatus);
		}
		if(StringUtils.isNotBlank(qrepStatus))
		{
			hql.append(" AND bds.repStatus = ? ");
			paramentList.add(qrepStatus);
		}
		if(StringUtils.isNotBlank(qfiller2))
		{
			hql.append(" AND bds.filler2 LIKE ? ");
			paramentList.add("%"+qfiller2+"%");
		}
		hql.append(" AND bds.currentfile = ? "  );
		paramentList.add(TopReportConstants.REPORT_FILE_TYPE_CFA_AL);

		hql.append(" AND (bds.recStatus = ? OR bds.recStatus= ? ) ");
		paramentList.add(TopReportConstants.REPORT_RECSTATUS_03);
		paramentList.add(TopReportConstants.REPORT_RECSTATUS_04);

		GlobalInfo gInfo = GlobalInfo.getCurrentInstance();
		hql.append(" AND bds.brNo = ? ");
		paramentList.add(gInfo.getBrno());

		hql.append(" ORDER BY bds.lstUpdTm DESC,bds.workDate, bds.actiontype, bds.approveStatus DESC ");
		pc.setPageIndex(pageIndex);
		pc.setPageSize(pageSize);
		pc.setQueryString(hql.toString());
		pc.setObjArray(paramentList.toArray());
		return  rootdao.pageQueryByQL(pc);
	}
}