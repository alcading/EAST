package com.huateng.report.basis.getter;

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



public class BiAccountEntryGetter extends BaseGetter{

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
	private PageQueryResult getData() throws CommonException
		{

		   ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		   //
		   int pageSize = getResult().getPage().getEveryPage();
		   //页码
		   int pageIndex = getResult().getPage().getCurrentPage();

		   PageQueryCondition queryCondition = new PageQueryCondition();

		   StringBuffer hql = new StringBuffer("select ba from BiAccount ba where 1=1 ");

		   String qCurrencyCode = getCommQueryServletRequest().getParameter("qAccountId");
		   String qAccountCur = getCommQueryServletRequest().getParameter("qAccountCur");
		   String qCustomerId = getCommQueryServletRequest().getParameter("qCustomerId");
		   String qAccountType = getCommQueryServletRequest().getParameter("qAccountType");

		   if(StringUtils.isNotBlank(qCurrencyCode))
		   {
			   hql.append(" and ba.Id ='").append(qCurrencyCode).append("'");
		   }
		   if(StringUtils.isNotBlank(qAccountCur))
		   {
			   hql.append(" and ba.accountCur like '%").append(qAccountCur).append("%'");
		   }
		   if(StringUtils.isNotBlank(qCustomerId))
		   {
			   hql.append(" and ba.customerId like '%").append(qCustomerId).append("%'");
		   }
		   if(StringUtils.isNotBlank(qAccountType))
		   {
			   hql.append(" and ba.accountType like '%").append(qAccountType).append("%'");
		   }


		   hql.append(" order by ba.id,ba.accountCur");

		   queryCondition.setPageIndex(pageIndex);
		   queryCondition.setPageSize(pageSize);
		   queryCondition.setQueryString(hql.toString());

		   return (PageQueryResult) rootdao.pageQueryByQL(queryCondition);

		}
}
