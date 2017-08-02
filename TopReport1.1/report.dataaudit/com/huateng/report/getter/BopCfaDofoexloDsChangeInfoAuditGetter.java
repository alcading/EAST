package com.huateng.report.getter;

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
import com.huateng.report.service.BopCfaDofoexloDsService;

@SuppressWarnings("unchecked")
public class BopCfaDofoexloDsChangeInfoAuditGetter extends BaseGetter{

	@Override
	public Result call() throws AppException {
		try {
			PageQueryResult queryResult = getData();

			setValue2DataBus(ReportConstant.QUERY_LOG_BUSI_NAME, "国内外汇贷款审核-国内外汇贷款变动信息查询");

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
		String actiontype = getCommQueryServletRequest().getParameter("actiontype");
		String recStatus = getCommQueryServletRequest().getParameter("recStatus");
		String approveStatus = getCommQueryServletRequest().getParameter("approveStatus");
		String repStatus = getCommQueryServletRequest().getParameter("repStatus");
//		String dofoexlocode = getCommQueryServletRequest().getParameter("dofoexlocode");
		String filler2 = getCommQueryServletRequest().getParameter("filler2");
		String qstartDate = getCommQueryServletRequest().getParameter("qstartDate");
		String qendDate = getCommQueryServletRequest().getParameter("qendDate");
		String brno = GlobalInfo.getCurrentInstance().getBrno();
		BopCfaDofoexloDsService service = BopCfaDofoexloDsService.getInstance();
		return service.pageQueryByAudit(pageIndex, pageSize,
			TopReportConstants.REPORT_FILE_TYPE_CFA_CB, qstartDate,qendDate,
			actiontype, recStatus, approveStatus, repStatus,
			filler2, brno);
	}
}