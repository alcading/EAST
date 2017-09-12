package com.huateng.report.bop.dataquery.getter;

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
import com.huateng.report.bop.collection.service.BopFsDsService;
import com.huateng.report.constants.TopReportConstants;

/**
 * 
 * @author shishu.zhang
 *	
 * 2012-11-7上午10:59:24
 */
@SuppressWarnings("unchecked")
public class BopFDsQueryGetter extends BaseGetter {
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
			this.setValue2DataBus(ReportConstant.QUERY_LOG_BUSI_NAME, "境内付款/承兑通知书基础信息查询页面查询");
			return result;
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}

	private PageQueryResult getData() throws CommonException {

		int pageSize = this.getResult().getPage().getEveryPage();
		int pageIndex = this.getResult().getPage().getCurrentPage();
		Map<String, String> map = getCommQueryServletRequest().getParameterMap();
		String qbrNo = map.get("qbrNo");
		String qworkDateStart = map.get("qworkDateStart");
		String qworkDateEnd = map.get("qworkDateEnd");
		String qactiontype = map.get("qactiontype");
		String qrecStatus = map.get("qrecStatus");
		String qapproveStatus = map.get("qapproveStatus");
		String qrepStatus = map.get("qrepStatus");
		String qfiller2 = map.get("qfiller2");
		
		BopFsDsService bopFsDsService = BopFsDsService.getInstance();
		return bopFsDsService.queryFsDs(TopReportConstants.REPORT_FILE_TYPE_BOP_F, pageIndex, pageSize, qbrNo, qrecStatus, 
				qactiontype, qapproveStatus, qrepStatus, qworkDateStart, qworkDateEnd, qfiller2);
	}
}
