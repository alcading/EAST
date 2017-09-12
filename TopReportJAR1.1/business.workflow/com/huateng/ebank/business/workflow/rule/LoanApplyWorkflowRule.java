/**
 *
 */
package com.huateng.ebank.business.workflow.rule;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.huateng.ebank.business.workflow.bean.BankTaskInfo;
import com.huateng.ebank.business.workflow.bean.BankWorkflowContext;
import com.huateng.ebank.business.workflow.rule.base.BankBaseWorkflowRule;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.topbpm.commonface.base.WIFlowInstance;

/**
 * Title: LoanApplyWorkflowRule
 * Description:贷款申请流程规则
 * Copyright: Copyright (c) 2008
 * Company: Shanghai Huateng Software Systems Co., Ltd.
 * @author shen_antonio
 * @version 1.1, 2008-4-2
 */
public class LoanApplyWorkflowRule extends BankBaseWorkflowRule {
	/**
	 * 流程启动前处理,
	 * 进行待选操作员信息列表
	 * 流程判断,不推荐进行业务处理
	 * @param workflowContext
	 * @return
	 * @throws CommonException
	 */
	public  void preStart(BankWorkflowContext workflowContext)throws CommonException{
		/** 获取传入的业务参数.*/
		Map param = (Map)workflowContext.getTxnInParam();
		/** 待选操作员列表.*/
		List list = new ArrayList();
		list.add("10100720");
		list.add("10100896");
		list.add("10101043");
		list.add("10101181");
		list.add("10101210");
		list.add("10101658");
		list.add("10101690");
		list.add("10102063");
		list.add("10102065");
		list.add("10105263");
		list.add("10105312");
		list.add("10110031");
		list.add("10110039");
		list.add("10110147");
		list.add("10110304");
		list.add("10111049");
		list.add("10111126");
		list.add("10111139");
		list.add("10111239");

		/** 构造BankTaskInfo对象.*/
		BankTaskInfo bankTaskInfo = new BankTaskInfo(
				(String)param.get("contractno"),
				(String)param.get("appno"),
				Double.valueOf((String)param.get("amount")).doubleValue(),
				(String)param.get("customer"),
				(String)param.get("starter"));
		/** 设置流程参数 .*/
		workflowContext.setBankTaskInfo(bankTaskInfo);
		/** 设置流程key .*/
		workflowContext.setKey((String)param.get("contractno"));
		/** 设置配选流程用户列表.*/
		workflowContext.setTlrList(list);
	}

	/**
	 * 流程启动后处理
	 * 后处理中将可获取流程实例WIFlowInstance
	 * 进行更新申请表信息,将启动的流程实例号记录在申请表中
	 * 同样不推荐进行业务处理
	 * @param workflowContext
	 * @return
	 * @throws CommonException
	 */
	public void postStart(BankWorkflowContext workflowContext)throws CommonException{
		WIFlowInstance wiFlowInstance = (WIFlowInstance)workflowContext.getWorkflowReturnParam();
		System.out.println("flow instance id = " +wiFlowInstance.getFID());
	    System.out.println("next task id = " +  wiFlowInstance.getNextTaskId());
	    System.out.println("flow start time = " + wiFlowInstance.getStartTime());
	    System.out.println("flow name =" + wiFlowInstance.getFlow().getFlowName());
	    System.out.println("flow version =" + wiFlowInstance.getFlow().getFlowVersion());
	    System.out.println("flow id =" + wiFlowInstance.getFlow().getFlowId());
	    System.out.println("assign tlrno = " + wiFlowInstance.getCurrentUserName());
	    System.out.println("flow instance param map = " + wiFlowInstance.getValueMap());
	    System.out.println("flow instance key = " + wiFlowInstance.getKey());
	}

}
