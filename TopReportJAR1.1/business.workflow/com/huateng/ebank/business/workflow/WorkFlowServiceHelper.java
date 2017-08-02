/**
 *
 */
package com.huateng.ebank.business.workflow;

/**
 * Title: WorkFlowServiceHelper
 * Description:
 * Copyright: Copyright (c) 2008
 * Company: Shanghai Huateng Software Systems Co., Ltd.
 * @author shen_antonio
 * @version 1.1, 2008-8-13
 */
public class WorkFlowServiceHelper {

	//任务准备状态
	public final static String TASK_STATUS_READY = "0";
	//任务已被声明状态
	public final static String TASK_STATUS_CLAIMED = "1";

	//流程流转
	/* mod by kangbyron 20110124 审批意见修改  现在只用这5种意见 begin*/
	public final static String WORKFLOW_TRANS_AGREE = "Agree"; //同意
	public final static String WORKFLOW_TRANS_GOBACK = "GoBack"; //退回至调查岗
	public final static String WORKFLOW_TRANS_GOBACK_LAST = "GoBackLast"; //退回至上一节点
	public final static String WORKFLOW_TRANS_GOBACK_RETURN = "GoBackReturn"; //退回调查岗返回退回者
	public final static String WORKFLOW_TRANS_REFUSE = "Refuse";//不同意(只有审批岗才结束流程)
	/* mod by kangbyron 20110124 审批意见修改 现在只用这5种意见 end*/

	/** modify by jimmypyh 20091208 BMS-2315 经办业务-客户经理主动退回OR结束流程 begin */
	public final static String WORKFLOW_TRANS_REFUSETOEND = "RefuseToEnd";
	/** modify by jimmypyh 20091208 BMS-2315 经办业务-客户经理主动退回OR结束流程 end */

	public final static String WORKFLOW_TRANS_AGREETOSUBMIT = "AgreeToSubmit";
	public final static String WORKFLOW_TRANS_AGREETOEND = "AgreeToEnd";
	public final static String WORKFLOW_TRANS_REJECT = "Reject";
	//节点类型
	public final static String NODE_TYPE_1 = "1";//一般节点
	public final static String NODE_TYPE_2 = "2";//审批节点
	public final static String NODE_TYPE_3 = "3";//自动节点

	//流程审核状态
	public static String AUDIT_RESULT_AGREE = "1";//同意
	public static String AUDIT_RESULT_DISAGREE = "2";//不同意
	public static String AUDIT_RESULT_GOBACK = "3";	//退回

	//流程参数分配方式
	public static String WORKFLOWPARAM_ASSIGNTYPE_1 = "1";//分配到岗位
	public static String WORKFLOWPARAM_ASSIGNTYPE_2 = "2";//分配给发起人

	//错误分配
	public static final String  TASKASSIGN_NONE1= "XXXXXXXX1"; // 无适用的工作流参数配置
	public static final String  TASKASSIGN_NONE2= "XXXXXXXX2"; // 多条适用的工作流参数配置
	public static final String  TASKASSIGN_NONE3= "XXXXXXXX3"; // 根据工作流参数配置找不到符合条件的操作员
}
