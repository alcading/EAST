package com.huateng.report.getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import resource.bean.report.BiAnalyProcess;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;
import com.huateng.report.service.AnalyProService;

public class ExecuteResultGetter extends BaseGetter {

	@Override
	public Result call() throws AppException {
		// TODO Auto-generated method stub
		try {

			Map param = this.getCommQueryServletRequest().getParameterMap();

			String analyNo = (String) param.get("analyNo");
			BiAnalyProcess analyProcess = AnalyProService.getInstance().getBiAnalyProcessByPk(analyNo);
			List returnList = new ArrayList();
			returnList.add(analyProcess);
			ResultMng.fillResultByList(
				getCommonQueryBean(),
				getCommQueryServletRequest(),
				returnList,
				getResult());
			result.setContent(returnList);
			result.getPage().setTotalPage(1);
			result.init();
			return result;
		}catch(AppException appEx){
			throw appEx;
		}catch(Exception ex){
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(),ex);
		}
	}
}
