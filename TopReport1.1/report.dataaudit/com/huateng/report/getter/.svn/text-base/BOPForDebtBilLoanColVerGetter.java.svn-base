package com.huateng.report.getter;

import java.util.ArrayList;
import java.util.List;

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
import com.huateng.report.bean.BOPForDebtBilLoanVer;

public class BOPForDebtBilLoanColVerGetter extends BaseGetter {

	@Override
	public Result call() throws AppException {
		// TODO Auto-generated method stub

		try {
			List<BOPForDebtBilLoanVer> list = new ArrayList<BOPForDebtBilLoanVer>();

			BOPForDebtBilLoanVer bopForLoan = new BOPForDebtBilLoanVer();
			bopForLoan.setActionType("A");
			bopForLoan.setActionDesc("");
			bopForLoan.setExdebtCode("ABCD");
			bopForLoan.setDebtorCode("BCD");
			bopForLoan.setDebType("CD");

			list.add(bopForLoan);

			ResultMng.fillResultByList(getCommonQueryBean(),
					getCommQueryServletRequest(), list,
					getResult());
			result.setContent(list);
			result.getPage().setTotalPage(1); //queryResult.getPageCount(getResult().getPage().getEveryPage())

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

		   StringBuffer hql = new StringBuffer("select sc from SysCurrency sc where 1=1 ");

		   String qCurrencyCode = getCommQueryServletRequest().getParameter("qCurrencyCode");
		   String qCurrencyName = getCommQueryServletRequest().getParameter("qCurrencyName");

		   if(StringUtils.isNotBlank(qCurrencyCode))
		   {
			   hql.append(" and sc.id ='").append(qCurrencyCode).append("'");
		   }
		   if(StringUtils.isNotBlank(qCurrencyName))
		   {
			   hql.append(" and sc.currencyName like '%").append(qCurrencyCode).append("%'");
		   }

		   hql.append(" order by sc.id,sc.currencyName");

		   queryCondition.setPageIndex(pageIndex);
		   queryCondition.setPageSize(pageSize);
		   queryCondition.setQueryString(hql.toString());

		   return (PageQueryResult) rootdao.pageQueryByQL(queryCondition);

		}

}
