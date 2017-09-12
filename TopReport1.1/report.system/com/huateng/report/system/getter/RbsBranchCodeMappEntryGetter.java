package com.huateng.report.system.getter;

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
import com.huateng.report.system.service.RbsBranchCodeMappService;

public class RbsBranchCodeMappEntryGetter extends BaseGetter {

	@Override
	public Result call() throws AppException {
		// TODO Auto-generated method stub
		try {
			PageQueryResult pageResult = getData();
			this.setValue2DataBus(ReportConstant.QUERY_LOG_BUSI_NAME, "系统维护-系统配置信息-机构信息维护查询");
			ResultMng.fillResultByList(
				getCommonQueryBean(),
				getCommQueryServletRequest(),
				pageResult.getQueryResult(),
				getResult());
			result.setContent(pageResult.getQueryResult());
			result.getPage().setTotalPage(pageResult.getPageCount(getResult().getPage().getEveryPage()));
			result.init();
			return result;
		}catch(AppException appEx){
			throw appEx;
		}catch(Exception ex){
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(),ex);
		}
	}

	private PageQueryResult getData() throws CommonException {
		// TODO Auto-generated method stub
		//获得查询参数
		Map<String,String> paramsMap = this.getCommQueryServletRequest().getParameterMap();
		String qrbsbranchcode = paramsMap.get("qrbsbranchcode");
		String qbusitype = paramsMap.get("qbusitype");
		String qbranchcode = paramsMap.get("qbranchcode");
		int pageIndex = this.getResult().getPage().getCurrentPage();
		int maxRows = this.getResult().getPage().getEveryPage();
		return RbsBranchCodeMappService.getInstance().pageQueryByHql(pageIndex, maxRows, qrbsbranchcode, qbusitype, qbranchcode);
	}

}
