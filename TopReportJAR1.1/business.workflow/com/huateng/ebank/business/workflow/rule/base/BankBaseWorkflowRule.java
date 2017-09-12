/**
 *
 */
package com.huateng.ebank.business.workflow.rule.base;

import org.apache.commons.lang.StringUtils;

import com.huateng.business.workflow.rule.BaseWorkflowRule;
import com.huateng.business.workflow.rule.base.IWorkflowContext;
import com.huateng.ebank.business.common.ErrorCode;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.workflow.WorkFlowService;
import com.huateng.ebank.business.workflow.bean.BankWorkflowContext;
import com.huateng.ebank.business.workflow.bean.WorkFlowStartBean;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.exception.AppException;
import com.huateng.topbpm.commonface.base.WIFlowInstance;

/**
 * Title: BankBaseWorkflowRule
 * Description:
 * Copyright: Copyright (c) 2008
 * Company: Shanghai Huateng Software Systems Co., Ltd.
 * @author shen_antonio
 * @version 1.1, 2008-4-3
 */
public abstract class BankBaseWorkflowRule extends BaseWorkflowRule {

	/* (non-Javadoc)
	 * @see com.huateng.business.workflow.rule.BaseWorkflowRule#start(com.huateng.business.workflow.rule.base.IWorkflowContext)
	 */
	
	public void start(IWorkflowContext workflowContext) throws AppException {
		// TODO Auto-generated method stub
		preStart((BankWorkflowContext)workflowContext);
		WorkFlowService workFlowService = WorkFlowService.getInstance();
		String brcode = GlobalInfo.getCurrentInstance().getBrcode();
		String flowName = getId();
		String flowVersion = getVersion();

		//检查出入参数的完整性
		checkContextInfo(workflowContext);
		//动态路由模式下,用户自行设定启动流程
		if( isDynamic()){
			flowName = workflowContext.getFlowName();
			flowVersion = workflowContext.getFlowVersion();
		}
		WorkFlowStartBean workFlowStartBean = new WorkFlowStartBean(
				workflowContext.getTlrList(),
				brcode,
				flowName,
				flowVersion,
				workflowContext.getParamMap(),
				workflowContext.getKey(),
				workflowContext.getStatus(),
				getWorkType(),
				getAssignMode(),
				isAsnWorkType(),
				isLv());
		WIFlowInstance wiFlowInstance = workFlowService.startFlow(workFlowStartBean);
		workflowContext.setWorkflowReturnPaream(wiFlowInstance);
		postStart((BankWorkflowContext)workflowContext);
	}

	/**
	 * 流程启动前处理,
	 * 进行待选操作员信息列表
	 * 流程判断,不推荐进行业务处理
	 * @param workflowContext
	 * @return
	 * @throws CommonException
	 */
	public abstract void preStart(BankWorkflowContext workflowContext)throws CommonException;

	/**
	 * 流程启动后处理
	 * 后处理中将可获取流程实例WIFlowInstance
	 * 进行更新申请表信息,将启动的流程实例号记录在申请表中
	 * 同样不推荐进行业务处理
	 * @param workflowContext
	 * @return
	 * @throws CommonException
	 */
	public abstract void postStart(BankWorkflowContext workflowContext)throws CommonException;


	/**
	 * 检查启动流程前的WorkflowContext信息
	 * 允许动态路由的情况下,FlowName字段不能为空
	 * @param context
	 * @throws CommonException
	 */
	private void checkContextInfo(IWorkflowContext context)throws CommonException{
		if( isDynamic()){
			//检查当设置是动态路由的情况下,参数FLOW_NAME不能为空
				if(StringUtils.isEmpty( context.getFlowName())){
					ExceptionUtil.throwCommonException("动态路由模式需要指定FLOW_NAME",
							ErrorCode.ERROR_CODE_WORKFLOWRULE_DYN_FLOWNAME_EMPTY);
				}
		}

	}

}
