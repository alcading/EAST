package com.huateng.report.genupreportfile.getter;



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

public class BOPForDebtOtherLoansChangeGenGetter extends BaseGetter {

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
		   GlobalInfo gInfo = GlobalInfo.getCurrentInstance();
		   //
		   int pageSize = getResult().getPage().getEveryPage();
		   //页码
		   int pageIndex = getResult().getPage().getCurrentPage();

		   PageQueryCondition queryCondition = new PageQueryCondition();

		   StringBuffer hql = new StringBuffer("select bds from BopCfaExdebtDs bds where 1=1 ");

		   String qbrNo = getCommQueryServletRequest().getParameter("qbrNo");
		   String qActiontype = getCommQueryServletRequest().getParameter("qActiontype");

		   String qfiller2 = getCommQueryServletRequest().getParameter("qfiller2");



		   if(StringUtils.isNotBlank(qbrNo))
		   {
			   hql.append(" and bds.brNo ='").append(qbrNo).append("'");
		   }
		   if(StringUtils.isNotBlank(qActiontype))
		   {
			   hql.append(" and bds.actiontype ='").append(qActiontype).append("'");
		   }
		   if(StringUtils.isNotBlank(qfiller2))
		   {
			   hql.append(" and bds.filler2 like '%").append(qfiller2).append("%'");
		   }
		   hql.append(" and bds.workDate='" + gInfo.getFileDate() + "'");
		   hql.append(" and bds.apptype='"+TopReportConstants.REPORT_APP_TYPE_CFA+"'");
		   hql.append(" and bds.currentfile='"+TopReportConstants.REPORT_FILE_TYPE_CFA_AR+"'");
		   hql.append(" and bds.changeFileType='"+TopReportConstants.REPORT_FILE_TYPE_CFA_AI+"'");
		   hql.append(" and bds.recStatus ='"+TopReportConstants.REPORT_RECSTATUS_05+"'");
		   hql.append(" order by bds.lstUpdTm desc");

		   queryCondition.setPageIndex(pageIndex);
		   queryCondition.setPageSize(pageSize);
		   queryCondition.setQueryString(hql.toString());

		   return  rootdao.pageQueryByQL(queryCondition);
		}

}
