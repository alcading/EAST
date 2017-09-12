package com.huateng.report.getter;

import java.util.Collections;

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

@SuppressWarnings("unchecked")
public class NotCnyCurrencySelectGetter  extends BaseGetter {

	private static final String RMB_CODE = "%CNY%";

	private static final String SEARCH_CURRENCY = " FROM SysCurrency sc WHERE lock = ? AND del = ? AND sc.id LIKE ? ORDER BY sc.id";

	private static final String IS_LOCK_TRUE = "T";

	public Result call() throws AppException {
		try {
			String value=getCommQueryServletRequest().getParameter("value1");
			PageQueryResult pageResult = null;
			if(!StringUtils.equalsIgnoreCase(value, RMB_CODE)) {
				Page page = result.getPage();
				boolean lock = false;
				if (StringUtils.equals(ReportEnum.REPORT_REC_LOCK_DEL.F.value, IS_LOCK_TRUE)){
					lock = true;
				}
				value = StringUtils.upperCase(value);
				Object[] args = new Object[]{lock, lock, value};
				PageQueryCondition queryCondition = new PageQueryCondition();
				queryCondition.setQueryString(SEARCH_CURRENCY);
				queryCondition.setPageSize(page.getEveryPage());
				queryCondition.setObjArray(args);
				queryCondition.setPageIndex(page.getCurrentPage());
				pageResult = DAOUtils.getHQLDAO().pageQueryByQL(queryCondition);
			} else {
				pageResult = new PageQueryResult();
				pageResult.setQueryResult(Collections.emptyList());
			}
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