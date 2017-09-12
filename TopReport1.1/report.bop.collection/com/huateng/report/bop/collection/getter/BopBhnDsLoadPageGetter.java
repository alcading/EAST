package com.huateng.report.bop.collection.getter;

import java.util.Map;

import org.apache.commons.lang.StringUtils;

import resource.report.dao.ROOTDAOUtils;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.commquery.servlet.CommQueryServletRequest;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.PageQueryCondition;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.report.common.ReportConstant;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;
import com.huateng.report.constants.TopReportConstants;

@SuppressWarnings("unchecked")
public class BopBhnDsLoadPageGetter extends BaseGetter {
	
	private static final String TYPE_REPORT = "report";
	private static final String TYPE_MAMAGE = "manage";
	
	@Override
	public Result call() throws AppException {
		try {
			PageQueryResult pageResult = getData();
			CommQueryServletRequest request = this.getCommQueryServletRequest();
			this.setValue2DataBus(ReportConstant.QUERY_LOG_BUSI_NAME, "境外汇款申请书拾取页面查询");
			String type = request.getParameter("type");
			if(TYPE_REPORT.equals(type)) {
				request.setParameter("type", TYPE_REPORT);
			} else if(TYPE_MAMAGE.equals(type)) {
				request.setParameter("type", TYPE_MAMAGE);
			}
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
		Map<String, String> paramsMap = this.getCommQueryServletRequest().getParameterMap();
		String qworkDateStart = paramsMap.get("qworkDateStart");
		String qworkDateEnd = paramsMap.get("qworkDateEnd");
		String qrptno = paramsMap.get("qrptno");
		String qfiller2 = paramsMap.get("qfiller2");
		//本机构
		GlobalInfo globalInfo = GlobalInfo.getCurrentInstance();
		String brNo = globalInfo.getBrno();
		StringBuffer buff = new StringBuffer();
		buff.append(" from MtsBopBhnDs ds where 1 = 1");
		if(StringUtils.isNotBlank(qworkDateStart))
			buff.append(" and ds.workDate >= '"+qworkDateStart+"'");
		if(StringUtils.isNotBlank(qworkDateEnd))
			buff.append(" and ds.workDate <= '"+qworkDateEnd+"'");
		if(StringUtils.isNotBlank(qrptno)) {
			buff.append(" and ds.rptno like '%"+qrptno+"%'");
		}
		if (StringUtils.isNotBlank(qfiller2)){
			buff.append(" and ds.filler2 like '%" + qfiller2 + "%'");
		}
		buff.append(" and ds.actiontype != '"+TopReportConstants.REPORT_ACTIONTYPE_D+"'");
		//拾取的是基础信息
		buff.append(" and ds.currentfile = '"+TopReportConstants.REPORT_FILE_TYPE_BOP_B+"'");
		buff.append(" and ds.apptype = '"+TopReportConstants.REPORT_APP_TYPE_BOP+"'");
		buff.append(" and ds.brNo = '"+brNo+"'");
		int pageSize = this.getResult().getPage().getEveryPage();
		int pageIndex = this.getResult().getPage().getCurrentPage();
		PageQueryCondition pageQueryCondition = new PageQueryCondition();
		pageQueryCondition.setPageSize(pageSize);
		pageQueryCondition.setPageIndex(pageIndex);
		pageQueryCondition.setQueryString(buff.toString());
		return ROOTDAOUtils.getROOTDAO().pageQueryByQL(pageQueryCondition);
	}

}
