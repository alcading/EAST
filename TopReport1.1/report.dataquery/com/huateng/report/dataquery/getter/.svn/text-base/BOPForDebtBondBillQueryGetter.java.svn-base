package com.huateng.report.dataquery.getter;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import resource.bean.report.BopCfaCreditorDs;
import resource.bean.report.BopCfaExdebtDs;
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
public class BOPForDebtBondBillQueryGetter extends BaseGetter {


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

	@SuppressWarnings("rawtypes")
	private PageQueryResult getData() throws CommonException {

		StringBuilder hql = new StringBuilder(" SELECT bds FROM BopCfaExdebtDs bds WHERE 1 = 1 ");

		String qWorkDate = getCommQueryServletRequest().getParameter("qWorkDate");
		String eWorkDate = getCommQueryServletRequest().getParameter("eWorkDate");
		String actiontype = getCommQueryServletRequest().getParameter("actiontype");
		String recStatus = getCommQueryServletRequest().getParameter("recStatus");
		String approveStatus = getCommQueryServletRequest().getParameter("approveStatus");
		String repStatus = getCommQueryServletRequest().getParameter("repStatus");
		String filler2 = getCommQueryServletRequest().getParameter("filler2");
		String qbrNo = getCommQueryServletRequest().getParameter("qbrNo");

		List<Object>paramentList = new ArrayList<Object>();
		if (StringUtils.isNotBlank(qWorkDate)) {
			hql.append(" AND bds.workDate >= ? ");
			paramentList.add(qWorkDate);
		}
		if (StringUtils.isNotBlank(eWorkDate)) {
			hql.append(" AND bds.workDate <= ? ");
			paramentList.add(eWorkDate);
		}
		if (StringUtils.isNotBlank(actiontype)) {
			hql.append(" AND bds.actiontype = ? ");
			paramentList.add(actiontype);
		}
		if (StringUtils.isNotBlank(recStatus)) {
			hql.append(" AND bds.recStatus = ? ");
			paramentList.add(recStatus);
		}
		if (StringUtils.isNotBlank(approveStatus)) {
			hql.append(" AND bds.approveStatus = ? ");
			paramentList.add(approveStatus);
		}
		if (StringUtils.isNotBlank(repStatus)) {
			hql.append(" AND bds.repStatus = ? ");
			paramentList.add(repStatus);
		}
		if (StringUtils.isNotBlank(filler2)) {
			hql.append(" AND bds.filler2 LIKE ? ");
			paramentList.add("%"+filler2+"%");
		}
		if (StringUtils.isNotBlank(qbrNo)) {
			hql.append(" AND brNo = ? ");
			paramentList.add(qbrNo);
		}

		// 只查询应用类型 为 资本项目
		hql.append(" AND bds.apptype= ? ");
		paramentList.add(TopReportConstants.REPORT_APP_TYPE_CFA);
		// 只查询文件类型 为 债券和票据
		hql.append(" AND bds.currentfile = ? ");
		paramentList.add(TopReportConstants.REPORT_FILE_TYPE_CFA_AK);

		hql.append(" ORDER BY bds.workDate, bds.approveStatus, bds.actiontype DESC");
		// 分页大小
		int pageSize = getResult().getPage().getEveryPage();
		// 页码
		int pageIndex = getResult().getPage().getCurrentPage();

		PageQueryCondition queryCondition = new PageQueryCondition();
		queryCondition.setPageIndex(pageIndex);
		queryCondition.setPageSize(pageSize);
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		queryCondition.setQueryString(hql.toString());
		queryCondition.setObjArray(paramentList.toArray());
		PageQueryResult pageQueryResult = rootdao.pageQueryByQL(queryCondition);
		List resultList = pageQueryResult.getQueryResult();
		for(int i=0;i<resultList.size();i++){
			   Object[] obj = (Object[])resultList.get(i);
			   BopCfaExdebtDs bopCfaExdebtDs = (BopCfaExdebtDs)obj[0];
			   List creditorsList = rootdao.queryByQL2List(" FROM BopCfaCreditorDs model WHERE model.recId = '"+bopCfaExdebtDs.getId().trim()+"' ");
			   BopCfaCreditorDs bopCfaCreditorDs =(BopCfaCreditorDs)creditorsList.get(0);
			   bopCfaExdebtDs.setCreditorcode(bopCfaCreditorDs.getCreditorcode());
			   bopCfaExdebtDs.setCreditorname(bopCfaCreditorDs.getCreditorname());
			   bopCfaExdebtDs.setCreditornamen(bopCfaCreditorDs.getCreditornamen());
			   bopCfaExdebtDs.setCreditortype(bopCfaCreditorDs.getCreditortype());
			   bopCfaExdebtDs.setCrehqcode(bopCfaCreditorDs.getCrehqcode());
			   bopCfaExdebtDs.setOpercode(bopCfaCreditorDs.getOpercode());
		   }
		   pageQueryResult.setQueryResult(resultList);
		return pageQueryResult;
	}
}
