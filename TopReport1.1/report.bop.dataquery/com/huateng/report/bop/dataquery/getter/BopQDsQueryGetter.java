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
import com.huateng.report.bop.dataquery.service.BopEqDsQueryService;
import com.huateng.report.constants.TopReportConstants;

/**
 * 境内汇款申请书-管理信息
 * 
 * @author zhusujian
 */
@SuppressWarnings("unchecked")
public class BopQDsQueryGetter extends BaseGetter {
	
	@Override
	public Result call() throws AppException {
		try {
			PageQueryResult pageQueryResult = getData();

			ResultMng.fillResultByList(getCommonQueryBean(),
					getCommQueryServletRequest(), pageQueryResult.getQueryResult(),
					getResult());
			result.setContent(pageQueryResult.getQueryResult());
			result.getPage().setTotalPage(pageQueryResult.getPageCount(getResult().getPage().getEveryPage()));
			result.init();
			return result;
		} catch (CommonException e) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, e.getMessage());
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}

	public PageQueryResult getData() throws AppException {
		setValue2DataBus(ReportConstant.QUERY_LOG_BUSI_NAME, "国际收支信息补录查询-境内汇款申请书-管理信息查询");
		int pageSize = this.getResult().getPage().getEveryPage();
		int pageIndex = this.getResult().getPage().getCurrentPage();
		Map<String,String> map = getCommQueryServletRequest().getParameterMap();
		String qbrNo = (String) map.get("qbrNo");
		String qworkDateStart = map.get("qworkDateStart");
		String qworkDateEnd = map.get("qworkDateEnd");
		String qactiontype = map.get("qactiontype");
		String qrecStatus = map.get("qrecStatus");
		String qapproveStatus = map.get("qapproveStatus");
		String qrepStatus = map.get("qrepStatus");
		String qfiller2 = map.get("qfiller2");
		
		BopEqDsQueryService bopEqDsService = BopEqDsQueryService.getInstance();
		return bopEqDsService.queryBOPEqRecord(TopReportConstants.REPORT_FILE_TYPE_BOP_Q, pageIndex, pageSize, qbrNo, qrecStatus, 
				qactiontype, qapproveStatus, qrepStatus, qworkDateStart, qworkDateEnd, qfiller2);
	}
}
