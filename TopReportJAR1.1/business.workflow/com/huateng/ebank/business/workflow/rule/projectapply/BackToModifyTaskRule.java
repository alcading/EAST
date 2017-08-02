/**
 *
 */
package com.huateng.ebank.business.workflow.rule.projectapply;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.huateng.business.workflow.rule.base.IWorkflowContext;
import com.huateng.ebank.business.workflow.rule.base.BankBaseWorkflowTaskRule;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.topbpm.commonface.base.WITask;

/**
 * Title: LoanCtrAuditTaskRule
 * Description:
 * Copyright: Copyright (c) 2008
 * Company: Shanghai Huateng Software Systems Co., Ltd.
 * @author shen_antonio
 * @version 1.1, 2008-4-3
 */
public class BackToModifyTaskRule extends BankBaseWorkflowTaskRule {

	/**
	 * 执行任务前操作
	 * 准备待选操作员列表
	 * 流转控制,不推荐进行业务处理
	 * @param context
	 * @throws CommonException
	 */
	public void preDoTask(IWorkflowContext context)throws CommonException{
		List list = new ArrayList();
		String nextRoleId = (String)((Map)context.getTxnInParam()).get("nextRoldId");
		list.add(nextRoleId);
		//组装数据
		context.setTlrList(list);
	}

	/**
	 * 执行任务后操作
	 * @param context
	 * @throws CommonException
	 */
	public void postDoTask(IWorkflowContext context)throws CommonException{
		WITask wiTask = (WITask)context.getWorkflowReturnParam();
		if( wiTask != null ){
		System.out.println("process instance id = " + wiTask.getProcInsId());
		System.out.println("process version = " + wiTask.getProcVersion());
		System.out.println("process instance key = " + wiTask.getProcKey());
		System.out.println("next task id = " + wiTask.getTaskId());
		System.out.println("next task name = " + wiTask.getTaskName());
		System.out.println("next tlrno = " + wiTask.getUserName());
		}
	}
}
