package com.huateng.report.getter;


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

public class BOPForDebtChangeInfoVerGetter extends BaseGetter {

	
	@Override
	public Result call() throws AppException {
		// TODO Auto-generated method stub

		try {
			this.setValue2DataBus(ReportConstant.QUERY_LOG_BUSI_NAME, "债券和票据变动信息查询");
			PageQueryResult queryResult = getData();
		
		//	HtLog logger = HtLogFactory.getLog(BOPForDebtBilLoanGetter.class);
			
		
		
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
	private PageQueryResult getData() throws CommonException
		{

		   ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		   GlobalInfo gInfo = GlobalInfo.getCurrentInstance(); 
		   //
		   int pageSize = getResult().getPage().getEveryPage();
		   //页码
		   int pageIndex = getResult().getPage().getCurrentPage();

		   PageQueryCondition queryCondition = new PageQueryCondition();

		   StringBuffer hql = new StringBuffer("select bds from BopCfaExdebtDs bds where 1=1 ");
		   String  changFileType=  getCommQueryServletRequest().getParameter("changFileType");
		   
		   String qWorkDate = getCommQueryServletRequest().getParameter("qWorkDate");
		   String eWorkDate = getCommQueryServletRequest().getParameter("eWorkDate");
		   String qActiontype = getCommQueryServletRequest().getParameter("qActiontype");
		   
		   String qRecStatus = getCommQueryServletRequest().getParameter("qRecStatus");
		   String qApproveStatus = getCommQueryServletRequest().getParameter("qApproveStatus");
		   
		   String qRepStatus = getCommQueryServletRequest().getParameter("qRepStatus");
		   String qFiller2 = getCommQueryServletRequest().getParameter("qFiller2");
		   
		   
		   
		   if (StringUtils.isNotBlank(qWorkDate)) {
				hql.append(" AND bds.workDate >= '").append(qWorkDate).append("' ");
			}
		    if (StringUtils.isNotBlank(eWorkDate)) {
				hql.append(" AND bds.workDate <= '").append(eWorkDate).append("' ");
			}
		   if(StringUtils.isNotBlank(qActiontype))
		   {
			   hql.append(" and bds.actiontype ='").append(qActiontype).append("'");
		   }
		   if(StringUtils.isNotBlank(qRecStatus))
		   {
			   hql.append(" and bds.recStatus ='").append(qRecStatus).append("'");
		   }
		   if(StringUtils.isNotBlank(qApproveStatus))
		   {
			   hql.append(" and bds.approveStatus ='").append(qApproveStatus).append("'");
		   }
		   if(StringUtils.isNotBlank(qRepStatus))
		   {
			   hql.append(" and bds.repStatus ='").append(qRepStatus).append("'");
		   }
		   if(StringUtils.isNotBlank(qFiller2))
		   {
			   hql.append(" and bds.filler2 like '%").append(qFiller2).append("%'");
		   }
		   
		   hql.append(" and bds.brNo='"+gInfo.getBrno()+"'");
		   hql.append(" and bds.apptype='"+TopReportConstants.REPORT_APP_TYPE_CFA+"'");
		   hql.append(" and bds.currentfile='"+TopReportConstants.REPORT_FILE_TYPE_CFA_AR+"'");
		   hql.append(" and bds.changeFileType='"+changFileType+"'");
		   
		   hql.append(" and  (bds.recStatus ='"+TopReportConstants.REPORT_RECSTATUS_03+"' or  bds.recStatus='"+TopReportConstants.REPORT_RECSTATUS_04+"')");
		   hql.append(" order by bds.lstUpdTm DESC,bds.workDate,bds.approveStatus,bds.actiontype desc");

		   queryCondition.setPageIndex(pageIndex);
		   queryCondition.setPageSize(pageSize);
		   queryCondition.setQueryString(hql.toString());

		   return  rootdao.pageQueryByQL(queryCondition);
		}
}
