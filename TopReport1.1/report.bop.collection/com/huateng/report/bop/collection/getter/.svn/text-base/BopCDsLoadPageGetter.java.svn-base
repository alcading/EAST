package com.huateng.report.bop.collection.getter;

import java.lang.reflect.InvocationTargetException;
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

/**
 * 
 * @author shishu.zhang
 *	
 * 2012-10-31下午4:07:26
 */
@SuppressWarnings("unchecked")
public class BopCDsLoadPageGetter extends BaseGetter {

	public Result call() throws AppException {
		try {
			setValue2DataBus(ReportConstant.QUERY_LOG_BUSI_NAME, "对外付款/承兑通知书拾取页面查询");
			PageQueryResult pageQueryResult = getData();
			ResultMng.fillResultByList(getCommonQueryBean(),
					getCommQueryServletRequest(), pageQueryResult.getQueryResult(),
					getResult());
			result.setContent(pageQueryResult.getQueryResult());
			result.getPage().setTotalPage(pageQueryResult.getPageCount(getResult().getPage().getEveryPage()));
			result.init();
			return result;
		} catch (CommonException e) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, e.getMessage());
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}

	public PageQueryResult getData() throws CommonException, IllegalAccessException, InvocationTargetException{
		Map<String, String> paramsMap = this.getCommQueryServletRequest().getParameterMap();
		String qworkDateStart = paramsMap.get("qworkDateStart");
		String qworkDateEnd = paramsMap.get("qworkDateEnd");
		String qrptno = paramsMap.get("qrptno");
		String qfiller2 = paramsMap.get("qfiller2");
		//本机构
		GlobalInfo globalInfo = GlobalInfo.getCurrentInstance();
		String brNo = globalInfo.getBrno();
		StringBuffer buff = new StringBuffer();
		buff.append(" from MtsBopCkpDs ds where 1 = 1");
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
		buff.append(" and ds.currentfile = '"+TopReportConstants.REPORT_FILE_TYPE_BOP_C+"'");
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
