package com.huateng.report.bop.audit.getter;

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
public class BopBhnDsManageAuditGetter extends BaseGetter {

	@Override
	public Result call() throws AppException {
		// TODO Auto-generated method stub
		try {
			PageQueryResult pageResult = getData();
			this.setValue2DataBus(ReportConstant.QUERY_LOG_BUSI_NAME, "境外汇款申请书管理信息审核查询");
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

	private PageQueryResult getData() throws CommonException {
		Map<String, String> map = getCommQueryServletRequest().getParameterMap();
		String qworkDateStart = map.get("qworkDateStart");
		String qworkDateEnd = map.get("qworkDateEnd");
		String qactiontype = map.get("qactiontype");
		String qrecStatus = map.get("qrecStatus");
		String qapproveStatus = map.get("qapproveStatus");
		String qrepStatus = map.get("qrepStatus");
		String qfiller2 = map.get("qfiller2");
		GlobalInfo globalInfo = GlobalInfo.getCurrentInstance();
		String brNo = globalInfo.getBrno();
		List<Object> hqlObj = new ArrayList<Object>();
		StringBuffer hql = new StringBuffer();
		hql.append(" from MtsBopBhnDs model where model.apptype = ? and model.currentfile = ? and model.recStatus in (?,?)");
		hqlObj.add(TopReportConstants.REPORT_APP_TYPE_BOP);
		hqlObj.add(TopReportConstants.REPORT_FILE_TYPE_BOP_N);
		hqlObj.add(TopReportConstants.REPORT_RECSTATUS_03);
		hqlObj.add(TopReportConstants.REPORT_RECSTATUS_04);
		if(StringUtils.isNotBlank(qworkDateStart)) {
			hql.append(" and model.workDate >= ?");
			hqlObj.add(qworkDateStart);
		}
		if(StringUtils.isNotBlank(qworkDateEnd)) {
			hql.append(" and model.workDate <= ?");
			hqlObj.add(qworkDateEnd);
		}
		if(StringUtils.isNotBlank(qactiontype)) {
			hql.append(" and model.actiontype = ?");
			hqlObj.add(qactiontype);
		}
		if(StringUtils.isNotBlank(qrecStatus)) {
			hql.append(" and model.recStatus = ?");
			hqlObj.add(qrecStatus);
		}
		if(StringUtils.isNotBlank(qapproveStatus)) {
			hql.append(" and model.approveStatus = ?");
			hqlObj.add(qapproveStatus);
		}
		if(StringUtils.isNotBlank(qrepStatus)) {
			hql.append(" and model.repStatus = ?");
			hqlObj.add(qrepStatus);
		}
		if(StringUtils.isNotBlank(qfiller2)) {
			hql.append(" and model.filler2 like ?");
			hqlObj.add("%"+qfiller2+"%");
		}
		hql.append(" and model.brNo = ? order by model.lstUpdTm desc");
		hqlObj.add(brNo);
		PageQueryCondition queryCondition = new PageQueryCondition();
		queryCondition.setQueryString(hql.toString());
		queryCondition.setPageIndex(this.getResult().getPage().getCurrentPage());
		queryCondition.setPageSize(this.getResult().getPage().getEveryPage());
		queryCondition.setObjArray(hqlObj.toArray());
		return ROOTDAOUtils.getROOTDAO().pageQueryByQL(queryCondition);
	}

}
