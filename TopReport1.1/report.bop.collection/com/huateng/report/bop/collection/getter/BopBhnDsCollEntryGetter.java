package com.huateng.report.bop.collection.getter;

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
public class BopBhnDsCollEntryGetter extends BaseGetter {

	@Override
	public Result call() throws AppException {
		try {
			PageQueryResult pageResult = getData();
			this.setValue2DataBus(ReportConstant.QUERY_LOG_BUSI_NAME, "境外汇款申请书补录基础信息查询");
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
		//获得查询参数，生成hql
		Map<String, String> paramsMap = this.getCommQueryServletRequest().getParameterMap();
		String qworkDateStart = paramsMap.get("qworkDateStart");
		String qworkDateEnd = paramsMap.get("qworkDateEnd");
		String qactiontype = paramsMap.get("qactiontype");
		String qrecStatus = paramsMap.get("qrecStatus");
		String qapproveStatus = paramsMap.get("qapproveStatus");
		String qrepStatus = paramsMap.get("qrepStatus");
		String qfiller2 = paramsMap.get("qfiller2");
		//只能查当前机构号
		GlobalInfo globalInfo = GlobalInfo.getCurrentInstance();
		String brNo = globalInfo.getBrno();
		String hql = getHql(qworkDateStart,qworkDateEnd, qactiontype, qrecStatus, qapproveStatus, qrepStatus, qfiller2,brNo);
		//查询,返回结果
		int pageSize = this.getResult().getPage().getEveryPage();
		int pageIndex = this.getResult().getPage().getCurrentPage();
		PageQueryCondition pageQueryCondition = new PageQueryCondition();
		pageQueryCondition.setPageIndex(pageIndex);
		pageQueryCondition.setPageSize(pageSize);
		pageQueryCondition.setQueryString(hql);
		return ROOTDAOUtils.getROOTDAO().pageQueryByQL(pageQueryCondition);
	}
	
	private String getHql(String qworkDateStart,String qworkDateEnd,String qactiontype,String qrecStatus,String qapproveStatus,String qrepStatus,String qfiller2,String brNo) {
		StringBuffer buff = new StringBuffer();
		buff.append(" from MtsBopBhnDs ds where 1 = 1 ");
		if(StringUtils.isNotBlank(qworkDateStart)) {
			buff.append(" and ds.workDate >= '"+qworkDateStart+"'");
		}
		if(StringUtils.isNotBlank(qworkDateEnd)) {
			buff.append(" and ds.workDate <= '"+qworkDateEnd+"'");
		}
		if(StringUtils.isNotBlank(qactiontype)) {
			buff.append(" and ds.actiontype like '"+qactiontype+"'");
		}
		if(StringUtils.isBlank(qrecStatus)) {
			buff.append(" and (ds.recStatus = '"+TopReportConstants.REPORT_RECSTATUS_01+"'"+" or "+"ds.recStatus = '"+TopReportConstants.REPORT_RECSTATUS_02+"')");
		} else {
			if(TopReportConstants.REPORT_RECSTATUS_01.equalsIgnoreCase(qrecStatus) || TopReportConstants.REPORT_RECSTATUS_02.equalsIgnoreCase(qrecStatus)) {
				buff.append(" and ds.recStatus like '"+qrecStatus+"'");
			} else {
				buff.append(" and ds.recStatus in ('"+TopReportConstants.REPORT_RECSTATUS_01+"','"+TopReportConstants.REPORT_RECSTATUS_02+"')");
			}
		}
		if(StringUtils.isNotBlank(qapproveStatus)) {
			buff.append(" and ds.approveStatus like '"+qapproveStatus+"'");
		}
		if(StringUtils.isNotBlank(qrepStatus)) {
			buff.append(" and ds.repStatus like '"+qrepStatus+"'");
		}
		if(StringUtils.isNotBlank(qfiller2)) {
			buff.append(" and ds.filler2 like '%"+qfiller2+"%'");
		}
		buff.append(" and ds.apptype = '"+TopReportConstants.REPORT_APP_TYPE_BOP+"'");
		buff.append(" and ds.currentfile = '"+TopReportConstants.REPORT_FILE_TYPE_BOP_B+"'");
		buff.append(" and ds.brNo = '"+brNo+"'");
		buff.append(" order by ds.lstUpdTm desc");
		return buff.toString();
	}

}
