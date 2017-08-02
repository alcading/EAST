package com.huateng.report.basis.getter;

import org.apache.commons.lang.StringUtils;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Page;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.PageQueryCondition;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.business.management.common.DAOUtils;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;
import com.huateng.report.utils.ReportEnum;


/**
 * Get the dropdown's data from DB with HQL and full the dataset to dropdown
 * @author cwenao
 * 2012-8-13
 */


@SuppressWarnings("unchecked")
public class CurrencySelectGetter extends BaseGetter {

	public Result call() throws AppException {
		try {
			StringBuffer hql = new StringBuffer(" FROM SysCurrency sc WHERE lock = '"+ReportEnum.REPORT_REC_LOCK_DEL.F.value+"' AND del = '"+ReportEnum.REPORT_REC_LOCK_DEL.F.value+"' ");
			PageQueryCondition queryCondition = new PageQueryCondition();
			Page page = result.getPage();
			String value=getCommQueryServletRequest().getParameter("value1");
			if(value!=null&&!value.equals("")){
				value = StringUtils.upperCase(value);
				hql.append(" AND sc.id like '%"+value+"%'");
			}
			hql.append(" ORDER BY sc.id");
			queryCondition.setQueryString(hql.toString());
			queryCondition.setPageSize(page.getEveryPage());
			queryCondition.setPageIndex(page.getCurrentPage());
			PageQueryResult pageResult = DAOUtils.getHQLDAO().pageQueryByQL(queryCondition);

			ResultMng.fillResultByList(getCommonQueryBean(),
					getCommQueryServletRequest(), pageResult.getQueryResult(), getResult());
			result.setContent(pageResult.getQueryResult());
			if (pageResult.getQueryResult().size() == 0) {
				result.getPage().setTotalPage(0);
			} else {
				result.getPage().setTotalPage(pageResult.getPageCount(getResult().getPage().getEveryPage()));
			}
			result.init();
			return result;
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}
}