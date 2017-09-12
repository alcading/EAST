/**
 *
 */
package com.huateng.ebank.business.workflow;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.huateng.business.workflow.rule.WorkflowContext;
import com.huateng.business.workflow.rule.base.IWorkflowRule;
import com.huateng.business.workflow.rule.base.IWorkflowTaskRule;
import com.huateng.ebank.business.common.ErrorCode;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.exception.AppException;

/**
 * Title: WorkflowRuleEngine
 * Description: 工作流执行引擎
 * Copyright: Copyright (c) 2008
 * Company: Shanghai Huateng Software Systems Co., Ltd.
 * @author shen_antonio
 * @version 1.1, 2008-4-2
 */
public class WorkflowRuleEngine implements IWorkflowRuleEngine{
	/** memeber variable: Log　log. */
	private static Log log = LogFactory.getLog(WorkflowRuleEngine.class);

	/**
	 * 启动指定流程流程
	 * @param beanName
	 * @param workflowContext
	 * @throws CommonException
	 */
	public static void startFlow(String flowBeanName,WorkflowContext context)throws CommonException{
		try{
			IWorkflowRule workflowRule = (IWorkflowRule)ApplicationContextUtils.getBean(flowBeanName);
				if(log.isInfoEnabled()){
					log.info("******************WorkflowRuleEngine Begin************************");
				}
			if( workflowRule.isNeed() ){
				if(log.isInfoEnabled()){
					log.info("****************** Start " + workflowRule.getId() + "[" +
							workflowRule.getDesc() + "] FlowRule ***********************");
				}
				workflowRule.start(context);
			}else{
				if(log.isInfoEnabled()){
					log.info("****************** " + workflowRule.getId() + "[" +
							workflowRule.getDesc() + "] FlowRule is Ignored*********************");
				}
			}
			if(log.isInfoEnabled()){
					log.info("******************WorkflowRuleEngine End************************");
			}

		}catch(CommonException cex){
			throw cex;
		}catch(AppException appex){
			appex.printStackTrace();
			ExceptionUtil.throwCommonException(appex.getLocalizedMessage(),ErrorCode.ERROR_CODE_WORKFLOW_START_ERROR);
		}catch(Exception ex){
			ex.printStackTrace();
			ExceptionUtil.throwCommonException(ex.getLocalizedMessage(),ErrorCode.ERROR_CODE_WORKFLOW_START_ERROR);
		}
	}

	/**
	 * 执行指定流程任务
	 * @param beanName
	 * @param taskName
	 * @param workflowContext
	 * @throws CommonException
	 */
	public static void doTask(String flowBeanName,String taskName,WorkflowContext context)throws CommonException{
		try{
			if(log.isInfoEnabled()){
				log.info("******************WorkflowRuleEngine Begin************************");
			}
			IWorkflowRule workflowRule = (IWorkflowRule)ApplicationContextUtils.getBean(flowBeanName);
			IWorkflowTaskRule taskRule = workflowRule.getTaskRule(taskName);
			if( taskRule.isNeed() ){
				if(log.isInfoEnabled()){
					log.info("****************** Start " + taskRule.getDesc() + " TaskRule ***********************");
				}
				taskRule.doTask(context);
			}else{
				if(log.isInfoEnabled()){
					log.info("****************** " + taskRule.getDesc() + " TaskRule is Ignored*********************");
				}
			}
			if(log.isInfoEnabled()){
				log.info("******************WorkflowRuleEngine   End************************");
			}
		}catch(CommonException cex){
			throw cex;
		}catch(AppException appex){
			appex.printStackTrace();
			ExceptionUtil.throwCommonException(appex.getLocalizedMessage(),ErrorCode.ERROR_CODE_WORKFLOW_DOFINISH_ERROR);
		}catch(Exception ex){
			ex.printStackTrace();
			ExceptionUtil.throwCommonException(ex.getLocalizedMessage(),ErrorCode.ERROR_CODE_WORKFLOW_DOFINISH_ERROR);
		}
	}
}
