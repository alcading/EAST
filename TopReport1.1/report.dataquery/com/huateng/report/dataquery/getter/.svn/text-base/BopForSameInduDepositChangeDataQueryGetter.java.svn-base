package com.huateng.report.dataquery.getter;


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

public class BopForSameInduDepositChangeDataQueryGetter  extends BaseGetter{

	@Override
	public Result call() throws AppException {
		// TODO Auto-generated method stub
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
	   this.setValue2DataBus(ReportConstant.QUERY_LOG_BUSI_NAME, "境外同业存放信息余额信息查询");
	   ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
	   //
	   int pageSize = getResult().getPage().getEveryPage();
	   //页码
	   int pageIndex = getResult().getPage().getCurrentPage();

	   PageQueryCondition pc = new PageQueryCondition();
	   GlobalInfo gi =GlobalInfo.getCurrentInstance();
	   StringBuffer hql = new StringBuffer("");
	   
		// 获取外债信息表、债权人信息表记录 以外债id left join on
		hql.append(" SELECT bds  FROM BopCfaExdebtDs bds  WHERE 1 = 1 ");
	//	hql.append("    FROM BopCfaExdebtDs bds LEFT JOIN BopCfaCreditorDs bcd ON bds.id = bcd.recId WHERE 1 = 1 ");
		
	   
	   String qbrNo = getCommQueryServletRequest().getParameter("qbrNo");
	  
	   String qworkDate = getCommQueryServletRequest().getParameter("qworkDate");
	   String eworkDate = getCommQueryServletRequest().getParameter("eworkDate");
	   String qactiontype = getCommQueryServletRequest().getParameter("qactiontype");
	   
	   String qrecStatus = getCommQueryServletRequest().getParameter("qrecStatus");
	   String qapproveStatus = getCommQueryServletRequest().getParameter("qapproveStatus");
	   
	   String qrepStatus = getCommQueryServletRequest().getParameter("qrepStatus");
	   String qfiller2 = getCommQueryServletRequest().getParameter("qfiller2");
	   
	   
	   
	   
	   if(StringUtils.isNotBlank(qbrNo))
	   {
		   hql.append(" and bds.brNo ='").append(qbrNo).append("'");
	   }
	   if(StringUtils.isNotBlank(qworkDate) ){
			hql.append(" and bds.workDate >='"+qworkDate+"'");
		}
	   if(StringUtils.isNotBlank(eworkDate)){
		   hql.append("and  bds.workDate <='"+eworkDate+"'");
	   }
	   if(StringUtils.isNotBlank(qactiontype))
	   {
		   hql.append(" and bds.actiontype ='").append(qactiontype).append("'");
	   }
	   if(StringUtils.isNotBlank(qrecStatus))
	   {
		   hql.append(" and bds.recStatus ='").append(qrecStatus).append("'");
	   }
	   if(StringUtils.isNotBlank(qapproveStatus))
	   {
		   hql.append(" and bds.approveStatus ='").append(qapproveStatus).append("'");
	   }
	   if(StringUtils.isNotBlank(qrepStatus))
	   {
		   hql.append(" and bds.repStatus ='").append(qrepStatus).append("'");
	   }
	   if(StringUtils.isNotBlank(qfiller2))
	   {
		   hql.append(" and bds.filler2 like '%").append(qfiller2).append("%'");
	   }
	 // hql.append(" and bds.workDate ='").append(gi.getFileDate()).append("'");
	 // hql.append(" and  bds.recStatus ='"+TopReportConstants.REPORT_RECSTATUS_05+"'");
	   hql.append(" and bds.currentfile ='"+TopReportConstants.REPORT_FILE_TYPE_CFA_AS+"' and balanceFileType = '"+TopReportConstants.REPORT_FILE_TYPE_CFA_AL+"'"  );
//	   hql.append(" order by bds.workDate,bds.approveStatus,bds.actiontype desc");

	   pc.setPageIndex(pageIndex);
	   pc.setPageSize(pageSize);
	   pc.setQueryString(hql.toString());

	   return  rootdao.pageQueryByQL(pc);
	}

}





