package com.huateng.report.getter;

import java.util.Collections;
import java.util.List;

import resource.bean.report.BopCfaExplbalainfo;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;
import com.huateng.report.service.BopCfaExplbalainfoService;

@SuppressWarnings("unchecked")
public class BopCfaExplcurrinfoGetter extends BaseGetter {

	@Override
	public Result call() throws AppException {
		try {
			PageQueryResult queryResult = getData();
			if (!queryResult.getQueryResult().isEmpty()) {
				ResultMng.fillResultByList(getCommonQueryBean(),
						getCommQueryServletRequest(), queryResult
								.getQueryResult(), getResult());
				result.setContent(queryResult.getQueryResult());
				result.getPage().setTotalPage(
						queryResult.getPageCount(getResult().getPage()
								.getEveryPage()));
				result.init();
			} else {
				result.setContent(Collections.emptyList());
				result.getPage().setTotalPage(0);
				result.init();
			}
			return result;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}

	/**
	 * 根据输入的查询条件进行查询
	 *
	 * @return PageQueryResult：返回查询的结果集
	 * @throws CommonException
	 */
	private PageQueryResult getData() throws CommonException {
		String id = getCommQueryServletRequest().getParameter("id");
		BopCfaExplbalainfoService service = BopCfaExplbalainfoService.getInstance();
		List<BopCfaExplbalainfo> explbalainfoList = service.load(id);
		if (null == explbalainfoList) {
			explbalainfoList = Collections.emptyList();
		}
		PageQueryResult queryResult = new PageQueryResult();
		queryResult.setQueryResult(explbalainfoList);
		queryResult.setTotalCount(explbalainfoList.size());
		return queryResult;
	}

}
