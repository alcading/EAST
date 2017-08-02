package com.huateng.report.getter;

import java.lang.reflect.InvocationTargetException;
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
import com.huateng.report.service.BopForDebtYinTuanService;

/**
 *
 * @author shishu.zhang
 *
 * 2012-8-15上午10:54:59
 */
public class BopForDebtFeiPerSaveLoadPageGetter extends BaseGetter {

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

	@SuppressWarnings("unchecked")
	public PageQueryResult getData() throws IllegalAccessException, InvocationTargetException, AppException{

		this.setValue2DataBus(ReportConstant.QUERY_LOG_BUSI_NAME, "外债-非居民个人存款补录-签约信息拾取查询");

		int pageSize = this.getResult().getPage().getEveryPage();
		int pageIndex = this.getResult().getPage().getCurrentPage();
		Map map = getCommQueryServletRequest().getParameterMap();

		String workdate = (String) map.get("qworkDate");
		String qactiontype = (String) map.get("qactiontype");
		String qrecStatus = (String) map.get("qrecStatus");
		String qapproveStatus = (String) map.get("qapproveStatus");
		String qrepStatus = (String) map.get("qrepStatus");

		String qFiller2 = (String) map.get("qFiller2");
		String qdebtorcode = (String) map.get("qdebtorcode");

		BopForDebtYinTuanService debtYinTuanService = BopForDebtYinTuanService.getInstance();
		return debtYinTuanService.queryFeiPerSaveLoadPage(pageIndex, pageSize,workdate,qactiontype,qrecStatus,qapproveStatus,qrepStatus, qFiller2, qdebtorcode);
	}
}
