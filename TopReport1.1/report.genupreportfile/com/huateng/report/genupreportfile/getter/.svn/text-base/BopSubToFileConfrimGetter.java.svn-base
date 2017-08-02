package com.huateng.report.genupreportfile.getter;

import java.util.List;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;
import com.huateng.report.genupreportfile.service.ReportCreateSubFileService;

@SuppressWarnings("unchecked")
public class BopSubToFileConfrimGetter extends BaseGetter {


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
		GlobalInfo info = GlobalInfo.getCurrentInstanceWithoutException();
		PageQueryResult pageQueryResult = new PageQueryResult();
		String busiType = this.getCommQueryServletRequest().getParameter("busiType");
		String appType = this.commQueryServletRequest.getParameter("appType");
		String workDate = info.getFileDate();
		List list =ReportCreateSubFileService.getInstance().getSubFileConfrim(busiType, appType, workDate);
		pageQueryResult.setQueryResult(list);
		return pageQueryResult;
	}

}
