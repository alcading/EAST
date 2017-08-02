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
import com.huateng.report.bop.collection.service.BopUDsService;

@SuppressWarnings("unchecked")
public class BopUDsQueryGetter extends BaseGetter {

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
			setValue2DataBus(ReportConstant.QUERY_LOG_BUSI_NAME, "单位基本情况表查询页面查询");
			return result;
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}

	private PageQueryResult getData() throws CommonException {

		int pageSize = getResult().getPage().getEveryPage();
		int pageIndex = getResult().getPage().getCurrentPage();
		Map<String, String> map = getCommQueryServletRequest().getParameterMap();

		String qworkDateStart = map.get("qworkDateStart");
		String qworkDateEnd = map.get("qworkDateEnd");

		String qapproveStatus = map.get("qapproveStatus");
		String qrepStatus = map.get("qrepStatus");

		String qrecStatus = map.get("qrecStatus");
		String qbrNo = map.get("qbrNo");

		String qcustcode = map.get("qcustcode");
		String qcustname = map.get("qcustname");

		BopUDsService service = BopUDsService.getInstance();
		return service.queryBopU(pageIndex, pageSize, qworkDateStart, qworkDateEnd, qapproveStatus, qrepStatus, qrecStatus, qbrNo, qcustcode, qcustname);
	}
}