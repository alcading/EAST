/**
 *
 */
package com.huateng.ebank.business.taskassign.bean;

import com.huateng.ebank.business.workflow.WorkFlowConstants;
import com.huateng.ebank.entity.data.workflow.TaskAssignInfo;

/**
 * Title: TaskAssignBean
 * Description: 分配任务Bean
 * Copyright: Copyright (c) 2008
 * Company: Shanghai Huateng Software Systems Co., Ltd.
 * @author shen_antonio
 * @version 1.1, 2008-3-28
 */
public class TaskAssignInfoBean extends TaskAssignInfo{

	/** memeber variable: long　serialVersionUID. */
	private static final long serialVersionUID = 7835979669081519646L;

	/**
	 * 分配任务Bean 构造方法
	 * @param procInsId 流程实例号
	 * @param taskId 任务号
	 * @param tlrno 操作员号/岗位号
	 * @param taskDesc 任务描述
	 * @param assignMode 任务分配模式
	 * @param assign 分配工作者
	 * @param workType 任务类型（允许为空，默认为全部工作99）01-贷前 02-贷后
	 * @param brcode
	 * 2008-3-29
	 */
	public TaskAssignInfoBean(
			String procInsId,
			String taskId,
			String tlrno,
			String taskDesc,
			String assignMode,
			String assign,
			String workType, 
			String brcode) {
		super();
		this.setProcInsId(procInsId);
		this.setTaskId(taskId);
		this.setTlrno(tlrno);
		this.setTaskDesc(taskDesc);
		this.setAssignType(WorkFlowConstants.TASK_ASSIGN_TYPE_0);
		this.setAssignMode(assignMode);
		this.setAssign(assign);
		this.setWorkType(workType);
		this.setBrcode(brcode);
		this.setStatus(WorkFlowConstants.TASK_ASSIGN_STATUS_0);
	}
}
