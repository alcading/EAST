/**
 *
 */
package com.huateng.ebank.business.workflow.rule.base;

import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.huateng.business.workflow.rule.BaseWorkflowTaskRule;
import com.huateng.business.workflow.rule.base.IWorkflowContext;
import com.huateng.ebank.business.common.ErrorCode;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.workflow.WorkFlowService;
import com.huateng.ebank.business.workflow.bean.WorkFlowDoTaskBean;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.exception.AppException;
import com.huateng.topbpm.commonface.base.WITask;

/**
 * Title: BankBaseWorkflowTaskRule
 * Description: 工作流任务引擎
 * Copyright: Copyright (c) 2008
 * Company: Shanghai Huateng Software Systems Co., Ltd.
 * @author shen_antonio
 * @version 1.1, 2008-4-3
 */
public abstract class BankBaseWorkflowTaskRule extends BaseWorkflowTaskRule {

	/* (non-Javadoc)
	 * @see com.huateng.business.workflow.rule.BaseWorkflowTaskRule#doTask(com.huateng.business.workflow.rule.base.IWorkflowContext)
	 */
	
	public void doTask(IWorkflowContext context) throws AppException {
		// TODO Auto-generated method stub
		//run preDoTask
		preDoTask(context);

		String brcode = GlobalInfo.getCurrentInstance().getBrcode();
		String tlrno = GlobalInfo.getCurrentInstance().getTlrno();
		Map param = (Map)context.getParamMap();
		//检查参数完整性
		checkContextInfo(context);
		WorkFlowDoTaskBean workFlowDoTaskBean = new WorkFlowDoTaskBean(
				context.getTlrList(),
				brcode,
				getWorkType(),
				getAssignMode(),
				isAsnWorkType(),
				isLv(),
				tlrno,
				context.getProcId(),
				context.getTaskId(),
				param,
				context.getStatus(),
				context.getComment()
				);
		WorkFlowService workFlowService = WorkFlowService.getInstance();
		WITask wiTask = workFlowService.doTask(workFlowDoTaskBean);
		if( wiTask != null){
		 context.setWorkflowReturnPaream(wiTask);
		}
		//run postDoTask
		postDoTask(context);
	}

	/**
	 * 执行任务前操作
	 * @param context
	 * @throws CommonException
	 */
	public abstract void preDoTask(IWorkflowContext context)throws CommonException;

	/**
	 * 执行任务后操作
	 * @param context
	 * @throws CommonException
	 */
	public abstract void postDoTask(IWorkflowContext context)throws CommonException;

	/**
	 * 检查执行任务前的WorkflowContext信息
	 * TaskId 不能为空
	 * ProcId 不能为空
	 * TlrList 不能为空
	 * Status 不能为空
	 * @param context
	 * @throws CommonException
	 */
	private void checkContextInfo(IWorkflowContext context)throws CommonException{
		if( (StringUtils.isEmpty(context.getTaskId()))
				||(StringUtils.isEmpty(context.getProcId()))
			    ||( context.getTlrList() == null || context.getTlrList().isEmpty() )
			    || StringUtils.isEmpty(context.getStatus())){
			ExceptionUtil.throwCommonException("检查执行任务前的WorkflowContext信息错误",
					ErrorCode.ERROR_CODE_WORKFLOWTASKRULE_CONTEXT);
		}
	}

}
