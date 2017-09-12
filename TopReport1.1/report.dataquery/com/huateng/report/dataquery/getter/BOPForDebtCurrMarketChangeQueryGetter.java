package com.huateng.report.dataquery.getter;



import java.util.Map;

import org.apache.commons.lang.StringUtils;

import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.PageQueryCondition;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;
import com.huateng.report.constants.TopReportConstants;

/**
 * 
 * 外债信息表Getter
 * @author wenhao.chen
 * @version 1.0
 * 2012-8-30
 * 
 * */

public class BOPForDebtCurrMarketChangeQueryGetter extends BaseGetter {

	@Override
	public Result call() throws AppException {

		try {
			
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
		   //
		   int pageSize = getResult().getPage().getEveryPage();
		   //页码
		   int pageIndex = getResult().getPage().getCurrentPage();

		   PageQueryCondition queryCondition = new PageQueryCondition();

		   StringBuffer hql = new StringBuffer("select bds from BopCfaExdebtDs bds where 1=1 ");
		   Map map = getCommQueryServletRequest().getParameterMap();
		   String qbrNo = (String) map.get("qbrNo");
		   String qworkDate = (String)map.get("qworkDate");
		   String eworkDate = (String)map.get("eworkDate");
		   String qactiontype = (String) map.get("qactiontype");
		   String qrecStatus = (String) map.get("qrecStatus");
		   String qapproveStatus = (String) map.get("qapproveStatus");
		   String qrepStatus = (String) map.get("qrepStatus");
		   String qexdebtcode = (String) map.get("qexdebtcode");
		   if(StringUtils.isNotBlank(qbrNo))
		   {
			   hql.append(" and bds.brNo ='").append(qbrNo).append("'");
		   }
		   if(StringUtils.isNotBlank(qworkDate))
		   {
			   hql.append(" and bds.workDate >='" + qworkDate + "'");
		   }
		   if(StringUtils.isNotBlank(eworkDate))
		   {
			   hql.append(" and bds.workDate <='" + eworkDate + "'");
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
		   if(StringUtils.isNotBlank(qexdebtcode))
		   {
			   hql.append(" and bds.exdebtcode like '%").append(qexdebtcode).append("%'");
		   }
		   hql.append(" and bds.apptype='"+TopReportConstants.REPORT_APP_TYPE_CFA+"'");
		   hql.append(" and bds.currentfile='"+TopReportConstants.REPORT_FILE_TYPE_CFA_AR+"'");
		   hql.append(" and bds.changeFileType='" + TopReportConstants.REPORT_FILE_TYPE_CFA_AJ + "'");
		   hql.append(" order by bds.lstUpdTm desc");

		   queryCondition.setPageIndex(pageIndex);
		   queryCondition.setPageSize(pageSize);
		   queryCondition.setQueryString(hql.toString());

		   return  rootdao.pageQueryByQL(queryCondition);
		}

}
