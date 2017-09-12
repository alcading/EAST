package com.huateng.report.genupreportfile.getter;

import java.util.Collections;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.report.common.ReportConstant;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;
import com.huateng.report.constants.TopReportConstants;
import com.huateng.report.service.BopCfaExplrmbloDsService;

@SuppressWarnings("unchecked")
public class BopCfaExplrmbloDsChangeInfoGenGetter extends BaseGetter {

	@Override
	public Result call() throws AppException {
		try {
			PageQueryResult queryResult = getData();
			this.setValue2DataBus(ReportConstant.QUERY_LOG_BUSI_NAME, "外汇质押人民币贷款变动信息上报文件查询");
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

		// 分页大小
		int pageSize = getResult().getPage().getEveryPage();
		// 页码
		int pageIndex = getResult().getPage().getCurrentPage();

		String workDate = GlobalInfo.getCurrentInstance().getFileDate();
		String actiontype = getCommQueryServletRequest().getParameter("actiontype");
		String filler2 = getCommQueryServletRequest().getParameter("qfiller2");
		String brcode = getCommQueryServletRequest().getParameter("qbrNo");

		BopCfaExplrmbloDsService service = BopCfaExplrmbloDsService.getInstance();
		return service.pageQueryByAlreadyAudit(pageIndex, pageSize,
				TopReportConstants.REPORT_FILE_TYPE_CFA_EB, workDate,
				actiontype, null, null, null,
				filler2, brcode);
	}

}
