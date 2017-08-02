package com.huateng.report.getter;

import java.util.List;
import java.util.Map;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;
import com.huateng.report.service.MakeupConfirmServices;

@SuppressWarnings("unchecked")
public class MakeupConfirmGetter extends BaseGetter {


	public Result call() throws AppException {
		try {
			PageQueryResult pageResult = getData();
			ResultMng.fillResultByList(getCommonQueryBean(), getCommQueryServletRequest(), pageResult.getQueryResult(),
					getResult());
			result.setContent(pageResult.getQueryResult());
			result.getPage().setTotalPage(1);
			result.init();
			return result;
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE, Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}

	// 获取查询的数据
	private PageQueryResult getData() throws CommonException {
		Map paramMap = this.getCommQueryServletRequest().getParameterMap();
		GlobalInfo info = GlobalInfo.getCurrentInstanceWithoutException();
		PageQueryResult pageQueryResult = new PageQueryResult();
		String busiType = (String) paramMap.get("busiType");
		String workDateStart = (String) paramMap.get("workDateStart");
		String workDateEnd = (String) paramMap.get("workDateEnd");
		String isShowZero = (String) paramMap.get("isShowZero");
		String qappType = (String) paramMap.get("qappType");
		List list = MakeupConfirmServices.getInstance().getMakeUpConfirmList(busiType, qappType, workDateStart, workDateEnd, info.getBrno(),isShowZero);
		pageQueryResult.setQueryResult(list);
		return pageQueryResult;
	}

}
