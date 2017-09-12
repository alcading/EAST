package com.huateng.report.getter;


import java.util.List;
import java.util.Map;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;
import com.huateng.report.service.AnalyProService;

public class AnalyseDataRecordGetter  extends BaseGetter{

	/*
	 * 数据分析getter
	 */
	@Override
	public Result call() throws AppException {
		// TODO Auto-generated method stub
		try {
			List list = getData();
			Map param = this.getCommQueryServletRequest().getParameterMap();
			/*处理分页*/
			int everypage = Integer.parseInt(param.get("everyPage").toString());
			int nextpage = Integer.parseInt(param.get("nextPage").toString());
			int maxIndex = nextpage * everypage;
			/*处理最后页*/
			if(maxIndex > list.size()) {
				maxIndex = list.size();
			}
			List returnList = list.subList((nextpage-1)*everypage, maxIndex);
			ResultMng.fillResultByList(
				getCommonQueryBean(),
				getCommQueryServletRequest(),
				returnList,
				getResult());
			result.setContent(returnList);
			result.getPage().setTotalPage((list.size() - 1) / everypage + 1);
			result.init();
			return result;
		}catch(AppException appEx){
			throw appEx;
		}catch(Exception ex){
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(),ex);
		}
	}

	private List getData() throws CommonException {
		//查询数据分析记录表bi_analy_process
		//获取查询参数
		Map paramsMap = this.commQueryServletRequest.getParameterMap();
		String qworkDate = (String) paramsMap.get("qworkDate");
		String qbusiType = (String) paramsMap.get("qbusiType");
		String qappType = (String) paramsMap.get("qappType");
		return AnalyProService.getInstance().queryByqworkDateAndqBusiType(qworkDate, qbusiType,qappType);
	}
}

