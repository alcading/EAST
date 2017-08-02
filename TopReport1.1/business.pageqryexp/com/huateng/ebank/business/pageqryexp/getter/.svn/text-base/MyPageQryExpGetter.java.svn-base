package com.huateng.ebank.business.pageqryexp.getter;

import org.apache.commons.lang.StringUtils;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.business.pageqryexp.service.MyPageQryExpService;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

@SuppressWarnings("unchecked")
public class MyPageQryExpGetter extends BaseGetter {
	@Override
	public Result call() throws AppException {
		try {
			PageQueryResult pageResult = getData();

			ResultMng.fillResultByList(getCommonQueryBean(),
					getCommQueryServletRequest(), pageResult.getQueryResult(),
					getResult());
			result.setContent(pageResult.getQueryResult());
			result.getPage().setTotalPage(
					pageResult.getPageCount(getResult().getPage()
							.getEveryPage()));
			result.init();
			return result;
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}

	}

	private PageQueryResult getData() throws CommonException {

		// 分页大小
		int pageSize = getResult().getPage().getEveryPage();
		// 页码
		int pageIndex = getResult().getPage().getCurrentPage();

		MyPageQryExpService service = new MyPageQryExpService();
		StringBuffer hql = new StringBuffer(
				"select tsk from TblCSFileExportTskInf tsk where tskStartOp = '" + GlobalInfo.getCurrentInstance().getTlrno() + "' ");

		String qFileNm = getCommQueryServletRequest().getParameter("qFileNm");
		String qTskStat = getCommQueryServletRequest().getParameter("qTskStat");
		String qTskStartDt = getCommQueryServletRequest().getParameter("qTskStartDt");
		if (StringUtils.isNotBlank(qTskStat)) {
			hql.append(" and tsk.tskStat=").append(qTskStat);
		}
		if (StringUtils.isNotBlank(qFileNm)) {
			hql.append(" and tsk.taskDesc like '%").append(qFileNm).append("%'");
		}
		if (StringUtils.isNotBlank(qTskStartDt)) {
			hql.append(" and tsk.tskStartTms like '").append(qTskStartDt).append("%'");
		}
		hql.append(" order by tsk.tskStartTms desc");
		return service.list(pageIndex, pageSize, hql.toString());

	}
}
