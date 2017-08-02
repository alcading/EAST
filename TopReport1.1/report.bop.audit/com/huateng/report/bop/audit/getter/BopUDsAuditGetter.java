package com.huateng.report.bop.audit.getter;

import java.util.Map;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.report.common.ReportConstant;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;
import com.huateng.report.bop.collection.service.BopUDsService;

@SuppressWarnings("unchecked")
public class BopUDsAuditGetter  extends BaseGetter {

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
			this.setValue2DataBus(ReportConstant.QUERY_LOG_BUSI_NAME, "境内付款/承兑通知书基础信息审核查询");
			return result;
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}

	@SuppressWarnings("rawtypes")
	private PageQueryResult getData() throws CommonException {
		int pageSize = getResult().getPage().getEveryPage();
		int pageIndex = getResult().getPage().getCurrentPage();

		Map map = getCommQueryServletRequest().getParameterMap();
		String qworkDateStart = (String) map.get("qworkDateStart");
		String qworkDateEnd = (String) map.get("qworkDateEnd");
		String qapproveStatus = (String) map.get("qapproveStatus");
		String qrepStatus = (String) map.get("qrepStatus");
		String qrecStatus = (String) map.get("qrecStatus");
		String qcustcode = (String) map.get("qcustcode");

		BopUDsService service = BopUDsService.getInstance();
	    return service.queryBopUAudit(pageIndex, pageSize, qworkDateStart, qworkDateEnd, qapproveStatus, qrepStatus, qrecStatus, qcustcode);
	}
}