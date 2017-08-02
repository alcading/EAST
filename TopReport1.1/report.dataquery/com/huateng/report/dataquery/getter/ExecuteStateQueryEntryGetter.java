package com.huateng.report.dataquery.getter;

import java.util.Collections;

import org.apache.commons.lang.StringUtils;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.report.common.ReportConstant;
import com.huateng.ebank.framework.util.DateUtil;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;
import com.huateng.report.dataquery.service.ExecuteStateQueryService;

@SuppressWarnings("unchecked")
public class ExecuteStateQueryEntryGetter extends BaseGetter {


	@Override
	public Result call() throws AppException {
		try {
				String workDate = getCommQueryServletRequest().getParameter(
						"qworkDate");
				if (workDate==null || workDate.trim().length()==0) {
					workDate = DateUtil.dateToNumber(GlobalInfo.getCurrentInstance().getTxdate());
				}
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
				
				this.setValue2DataBus(ReportConstant.QUERY_LOG_BUSI_NAME, "业务操作日志查询");
				
			return result;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}

	/**
	 * 根据输入的查询条件进行查询
	 * @return PageQueryResult：返回查询的结果集
	 * @throws CommonException
	 */
	private PageQueryResult getData() throws CommonException {

		// 分页大小
		int pageSize = getResult().getPage().getEveryPage();
		// 页码
		int pageIndex = getResult().getPage().getCurrentPage();

		ExecuteStateQueryService statequeryservice = ExecuteStateQueryService
				.getInstance();

		StringBuilder queryhql = new StringBuilder(
				" FROM BiProcessLog WHERE 1 = 1 ");

		String busiType = getCommQueryServletRequest().getParameter(
				"qbusiType");
		String workDateStart = getCommQueryServletRequest().getParameter("qworkDateStart");
		String workDateEnd = getCommQueryServletRequest().getParameter("qworkDateEnd");
		String brno = getCommQueryServletRequest().getParameter("qbrNo");
		String brname = getCommQueryServletRequest().getParameter("qbrName");
		String appType = getCommQueryServletRequest().getParameter("qappType");

		if (StringUtils.isNotBlank(busiType)) {
			queryhql.append(" AND busiType = '").append(busiType).append("' ");
		}
		if (StringUtils.isNotBlank(appType)) {
			queryhql.append(" AND appType = '").append(appType).append("' ");
		}
		if (StringUtils.isNotBlank(workDateStart)) {
			queryhql.append(" AND workDate >= '").append(workDateStart).append("' ");
		}
		if (StringUtils.isNotBlank(workDateEnd)) {
			queryhql.append(" AND workDate <= '").append(workDateEnd).append("' ");
		}
		if (StringUtils.isNotBlank(brno)) {
			queryhql.append(" AND brNo LIKE '%").append(brno).append("%' ");
		}
		if (StringUtils.isNotBlank(brname)) {
			brno = statequeryservice.getBrno(brname);
			queryhql.append(" AND brNo = '").append(brno).append("' ");
		}

		queryhql.append(" order by executeTm desc");

		return statequeryservice.pageQueryByHql(pageIndex, pageSize, queryhql
				.toString());
	}
}