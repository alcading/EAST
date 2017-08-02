package com.huateng.report.scheduler.updater;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import resource.bean.report.ReportJobConfig;

import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;
import com.huateng.report.scheduler.operation.BopTimedSchedulerOperation;

public class BopTimedScheudlerJobUpdate extends BaseUpdate {

	@Override
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean arg0,
			HttpServletRequest arg1, HttpServletResponse arg2)
			throws AppException {
		//返回对象
		UpdateReturnBean updateReturnBean = new UpdateReturnBean();
		//取得结果集对象
		UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID("bopTimedScheduler");
		//开始处理
		ReportJobConfig jobConfig = null;
		if(updateResultBean.hasNext()){
			jobConfig = new ReportJobConfig();
			Map map = updateResultBean.next();
			mapToObject(jobConfig, map);
		}
		
		OperationContext oc = new OperationContext();
		oc.setAttribute(BopTimedSchedulerOperation.CMD, BopTimedSchedulerOperation.OP_UPDATE);
		oc.setAttribute(BopTimedSchedulerOperation.IN_BEAN, jobConfig);
		OPCaller.call(BopTimedSchedulerOperation.ID, oc);
		
		return updateReturnBean;
	}

}
