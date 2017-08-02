package com.huateng.report.getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

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
public class BopCfaStrdeDsTerminateEntryAuditGetter extends BaseGetter {

	public Result call() throws AppException {
		try {
			PageQueryResult pageResult = getData();
			setValue2DataBus(ReportConstant.QUERY_LOG_BUSI_NAME, "商业银行人民币结构性存款终止信息审核查询");
			ResultMng.fillResultByList(
				getCommonQueryBean(),
				getCommQueryServletRequest(),
				pageResult.getQueryResult(),
				getResult());
			result.setContent(pageResult.getQueryResult());
			result.getPage().setTotalPage(pageResult.getPageCount(getResult().getPage().getEveryPage()));
			result.init();
			return result;
		}catch(AppException appEx){
			throw appEx;
		}catch(Exception ex){
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(),ex);
		}
	}

	@SuppressWarnings("rawtypes")
	private PageQueryResult getData() throws CommonException {
		Map paramsMap = getCommQueryServletRequest().getParameterMap();

		String qworkDateStart = (String) paramsMap.get("qworkDateStart");
		String qworkDateEnd = (String) paramsMap.get("qworkDateEnd");

		String qactiontype = (String) paramsMap.get("qactiontype");
		String qrecStatus = (String) paramsMap.get("qrecStatus");

		String qapproveStatus = (String) paramsMap.get("qapproveStatus");
		String qrepStatus = (String) paramsMap.get("qrepStatus");

		String qfiller2 = (String) paramsMap.get("qfiller2");
		GlobalInfo globalInfo = GlobalInfo.getCurrentInstance();
		String brNo = globalInfo.getBrno();
		List<Object> hqlObj = new ArrayList<Object>();
		StringBuffer hql = new StringBuffer();
		hql.append(" FROM BopCfaStrdeDs model WHERE model.apptype = ? AND model.currentfile = ? AND model.recStatus IN (? , ?) ");
		hqlObj.add(TopReportConstants.REPORT_APP_TYPE_CFA);
		hqlObj.add(TopReportConstants.REPORT_FILE_TYPE_CFA_FB);
		hqlObj.add(TopReportConstants.REPORT_RECSTATUS_03);
		hqlObj.add(TopReportConstants.REPORT_RECSTATUS_04);
		if(StringUtils.isNotBlank(qworkDateStart)) {
			hql.append(" AND model.workDate >= ? ");
			hqlObj.add(qworkDateStart);
		}
		if(StringUtils.isNotBlank(qworkDateEnd)) {
			hql.append(" AND model.workDate <= ? ");
			hqlObj.add(qworkDateEnd);
		}
		if(StringUtils.isNotBlank(qactiontype)) {
			hql.append(" AND model.actiontype = ? ");
			hqlObj.add(qactiontype);
		}
		if(StringUtils.isNotBlank(qrecStatus)) {
			hql.append(" AND model.approveStatus = ? ");
			hqlObj.add(qrecStatus);
		}
		if(StringUtils.isNotBlank(qapproveStatus)) {
			hql.append(" AND model.approveStatus = ? ");
			hqlObj.add(qapproveStatus);
		}
		if(StringUtils.isNotBlank(qrepStatus)) {
			hql.append(" AND model.repStatus = ? ");
			hqlObj.add(qrepStatus);
		}
		if(StringUtils.isNotBlank(qfiller2)) {
			hql.append(" AND model.filler2 LIKE ? ");
			hqlObj.add("%"+qfiller2+"%");
		}
		hql.append(" AND model.brNo = ? ORDER BY model.lstUpdTm DESC,model.workDate, model.actiontype, model.approveStatus DESC ");
		hqlObj.add(brNo);
		PageQueryCondition queryCondition = new PageQueryCondition();
		queryCondition.setQueryString(hql.toString());
		queryCondition.setPageIndex(getResult().getPage().getCurrentPage());
		queryCondition.setPageSize(getResult().getPage().getEveryPage());
		queryCondition.setObjArray(hqlObj.toArray());
		return ROOTDAOUtils.getROOTDAO().pageQueryByQL(queryCondition);
	}
}