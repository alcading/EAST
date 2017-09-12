package com.huateng.report.scheduler.updater;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.business.innerinterface.ITimedScheduler;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;
import com.huateng.report.scheduler.operation.BopTimedSchedulerOperation;

public class BopTimedScheudlerJobStatusUpdate extends BaseUpdate {

	@Override
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean arg0,
			HttpServletRequest arg1, HttpServletResponse arg2)
			throws AppException {
		//返回对象
		UpdateReturnBean updateReturnBean = new UpdateReturnBean();
		//取得结果集对象
		UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID("bopTimedScheduler");
		//开始处理
		String jobStatus = updateResultBean.getParameter("jobStatus");
		String id = updateResultBean.getParameter("id");

		OperationContext oc = new OperationContext();
		oc.setAttribute(BopTimedSchedulerOperation.IN_ID_VALUE, id);
		if(jobStatus.equals(ITimedScheduler.TIMED_STATUS_1)){
			oc.setAttribute(BopTimedSchedulerOperation.CMD, BopTimedSchedulerOperation.OP_START);
		} else {
			oc.setAttribute(BopTimedSchedulerOperation.CMD, BopTimedSchedulerOperation.OP_STOP);
		}
		OPCaller.call(BopTimedSchedulerOperation.ID, oc);

		return updateReturnBean;
	}

}
