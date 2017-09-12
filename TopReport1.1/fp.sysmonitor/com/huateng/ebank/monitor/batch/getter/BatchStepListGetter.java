package com.huateng.ebank.monitor.batch.getter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.ebank.monitor.batch.bean.BatchConstant;
import com.huateng.ebank.monitor.batch.service.BatchMonitorService;
import com.huateng.ebank.monitor.globalInfo.service.GlobalInfoService;
import com.huateng.exception.AppException;

/**
 * 获得批量步骤列表
 * @author wangpeng
 *
 */
public class BatchStepListGetter extends BaseGetter {

	/* (non-Javadoc)
	 * @see com.huateng.commquery.process.call._CallGetter#call()
	 */
	@Override
	public Result call() throws AppException {
		try {
			/** 获取查询条件 */
			Map param = this.getCommQueryServletRequest().getParameterMap();
			String bhDate=(String)param.get("bhdate");
			String statusCode=(String)param.get("statuscode");

			if(bhDate==null || bhDate.trim().equals("")){
			/**批量日期为空 查询当前批量日期*/
			GlobalInfoService globalService=GlobalInfoService.getInstance();
//			Globalinfo globalInfo=globalService.getCurrentGlobalInfo();
//			bhDate=new SimpleDateFormat(BatchConstant.DATE_PARTTEN).format(globalInfo.getBhdate());
			bhDate=new SimpleDateFormat(BatchConstant.DATE_PARTTEN).format(new Date());
			}
			
			/** 获取everyPage：每页包含的记录数 */
			int everypage = Integer.parseInt(param.get("everyPage").toString());

			/** 获取nextPage：表示下一页是第几页 */
			int nextpage = Integer.parseInt(param.get("nextPage").toString());

			/** 获取所有查询结果 */
		    BatchMonitorService service=BatchMonitorService.getInstance();
			List list = service.getBatchStepList(bhDate, statusCode);

			int maxIndex = nextpage * everypage;

			/** 对最后一页的处理 */
			if (maxIndex > list.size()) {
				maxIndex = list.size();
			}
			List resultList = list.subList((nextpage - 1) * everypage, maxIndex);
			ResultMng.fillResultByList(getCommonQueryBean(),
					getCommQueryServletRequest(), resultList, getResult());

			result.setContent(resultList);

			result.getPage().setTotalPage((list.size() - 1) / everypage + 1);
			result.init();
			return result;
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}

}
