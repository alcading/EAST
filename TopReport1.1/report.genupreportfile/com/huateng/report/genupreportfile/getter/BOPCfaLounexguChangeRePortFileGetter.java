package com.huateng.report.genupreportfile.getter;

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

public class BOPCfaLounexguChangeRePortFileGetter extends BaseGetter {

	@Override
	public Result call() throws AppException {
		// TODO Auto-generated method stub
		try {
				PageQueryResult list = getData(); 
				ResultMng.fillResultByList(getCommonQueryBean(), getCommQueryServletRequest(), list.getQueryResult(), getResult());
				result.setContent(list.getQueryResult());
				result.getPage().setTotalPage(list.getPageCount(getResult().getPage().getEveryPage()));
				result.init();
				return result;
			} catch (AppException appEx) {
					throw appEx;
			} catch (Exception ex) {
					throw new AppException(Module.SYSTEM_MODULE,
							Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
			}
	}

	private PageQueryResult getData() throws AppException{
		this.setValue2DataBus(ReportConstant.QUERY_LOG_BUSI_NAME, "境外担保项下境内贷款信息上报变动及履约信息查询");
		int pageIndex = getResult().getPage().getCurrentPage();
		int pageSize = getResult().getPage().getEveryPage();
		GlobalInfo gi = GlobalInfo.getCurrentInstance();
		String hqlString = "select bd from BopCfaLounexguDs bd where 1=1 and bd.recStatus ='"+TopReportConstants.REPORT_RECSTATUS_05+"' and bd.workDate ='"+gi.getFileDate()
				+"' and  bd.currentfile = '"+TopReportConstants.REPORT_FILE_TYPE_CFA_DB+"'" ;
		String qactiontype = getCommQueryServletRequest().getParameter("qactiontype");
		String qfiller2 = getCommQueryServletRequest().getParameter("qfiller2");
		String qbrNo = getCommQueryServletRequest().getParameter("qbrNo");
				if(StringUtils.isNotBlank(qbrNo)){
					hqlString += " and bd.brNo = '"+qbrNo +"'";
				}
				if(StringUtils.isNotBlank(qactiontype)){
					hqlString += " and bd.actiontype = '"+qactiontype +"'";
				}
				if(StringUtils.isNotBlank(qfiller2)){
					hqlString += " and bd.filler2 like'%"+qfiller2 +"%'";
				}
			
		PageQueryCondition pc = new PageQueryCondition();
		pc.setPageIndex(pageIndex);
		pc.setPageSize(pageSize);
		pc.setQueryString(hqlString);
		
		HQLDAO hqlDao = DAOUtils.getHQLDAO();
		return hqlDao.pageQueryByQL(pc);
	}

}
