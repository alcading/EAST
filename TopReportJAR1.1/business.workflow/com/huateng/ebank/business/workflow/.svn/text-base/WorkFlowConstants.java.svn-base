package com.huateng.ebank.business.workflow;

public class WorkFlowConstants {
	/**
	 * modify by shen_antonio 20080328 for TaskAssignService
	 * 工作类型、工作分配描述
	 */
	/** memeber variable: String　TASK_ASSIGN_TYPE_0 工作安排方式:自动分配. */
	public static final String TASK_ASSIGN_TYPE_0 = "0";
	/** memeber variable: String　TASK_ASSIGN_TYPE_1 工作安排方式:人工分配. */
	public static final String TASK_ASSIGN_TYPE_1 = "1";
	/** memeber variable: String　TASK_ASSIGN_MODE_O 分配到岗位(强件模式). */
	public static final String TASK_ASSIGN_MODE_O = "0";
	/** memeber variable: String　TASK_ASSIGN_MODE_1 分配到指定人（按工作量分配). */
	public static final String TASK_ASSIGN_MODE_1 = "1";
	/** memeber variable: String　TASK_ASSIGN_MODE_2 分配到人（随机分配）. */
	public static final String TASK_ASSIGN_MODE_2 = "2";
	/** memeber variable: String　TASK_WORK_TYPE_99 全部工作. */
	public static final String TASK_WORK_TYPE_99 = "99";
	/** memeber variable: String　TASK_WORK_TYPE_01 贷前工作. */
	public static final String TASK_WORK_TYPE_01 = "01";
	/** memeber variable: String　TASK_WORK_TYPE_02 贷后工作. */
	public static final String TASK_WORK_TYPE_02 = "02";
	/** memeber variable: String　TASK_ASSIGN_STATUS_0 分配工作有效标志:有效. */
	public static final String TASK_ASSIGN_STATUS_0 = "0";
	/** memeber variable: String　TASK_ASSGIN_STATUS_1 分配工作有效标志:无效,任务任务被移交. */
	public static final String TASK_ASSGIN_STATUS_1 = "1";
	/** memeber variable: String　TASK_ASSGIN_STATUS_2 分配工作有效标志:无效，任务被删除. */
	public static final String TASK_ASSGIN_STATUS_2 = "2";

	/*
	 * 角色类型
	 */
	public static final int ROLE_ID_LOAN_INPUT = 100; // 资料录入/客户经理岗
	public static final int ROLE_ID_LOAN_AUDIT = 102; // 贷款审查
	public static final int ROLE_ID_LOAN_MEETING = 103; // 贷审会意见录入岗
	public static final int ROLE_ID_LOAN_APPROVE = 105; //贷款审批
	public static final int ROLE_ID_LOAN_SUPERVISE = 110; //放款监督
	public static final int ROLE_ID_LOAN_SAVE = 114; //资产保全
	public static final int ROLE_ID_PROJECT_AUDIT = 119; // 项目审查
	public static final int ROLE_ID_PROJECT_APPROVE = 120; // 项目审批
	public static final int ROLE_ID_LOAN_UP_APPROVE = 121; // 贷款高级审批

	public static final int ROLE_ID_LEAVE_APPROVE = 140; // 请假审批

    /**
     * 工作流人员分配默认值
     */
    public static final String ROLE_DEFINFE_TLRNO="XXXXXXXX" ;  //默认值分配

    /**
     * 经受任务查询 各流程的业务主键
     * add by UU_Wu 2008-10-15
     */
    public static final int CHECK_ISERROR = 0;  //未能找到业务主键
    public static final int CHECK_ISCON = 1;  //合同号为业务主键
    public static final int CHECK_ISJJ = 2;  //借据号为业务主键
    public static final int CHECK_ISPROJ = 3;  //合作项目编号为业务主键

	/**
	 * 审批状态/流程状态
	 */
	public static final String FLOW_STATUS_APPROVING = "0"; // 审批中
	public static final String FLOW_STATUS_FINISH = "1"; // 审批同意结束
	public static final String FLOW_STATUS_REJECT = "2"; // 审批拒绝结束
	public static final String FLOW_STATUS_BACK = "3"; // 审批退回结束

	/**
	 * 房贷卡授信额度申请状态/流程状态 审批中 1-审批通过 2-审批同意结束 3-审批拒绝结束
	 */
	public static final String CARD_APPLY_STATUS_APPROVING = "0"; // 审批中
	public static final String CARD_APPLY_STATUS_PASS = "1"; // 审批通过
	public static final String CARD_APPLY_STATUS_AGREE_FINISH = "2"; // 审批同意结束
	public static final String CARD_APPLY_STATUS_REJECT_FINISH = "3"; // 审批拒绝结束

	/**
	 * 审批意见(新)
	 */
	public static final String APP_ATTITUDE_AGREE_TO_NEXT = "0"; // 同意到下一步
	public static final String APP_ATTITUDE_AGREE_TO_SUBMIT = "1"; // 同意并上报
	public static final String APP_ATTITUDE_AGREE_TO_END = "2"; // 同意并结束流程
	public static final String APP_ATTITUDE_CONDI_AGREE_TO_NEXT = "3"; // 有条件同意到下一步
	public static final String APP_ATTITUDE_CONDI_AGREE_TO_SUBMIT = "4"; // 有条件同意并上报
	public static final String APP_ATTITUDE_DISAGREE_TO_NEXT = "5"; // 不同意并到下一步
	public static final String APP_ATTITUDE_DISAGREE_TO_END = "6"; // 不同意并结束流程
	public static final String APP_ATTITUDE_UNTREAD_TO_LAST = "7"; // 退回到上一步
	public static final String APP_ATTITUDE_UNTREAD_TO_BACK = "8"; // 退回到退回节点
	public static final String APP_ATTITUDE_TASK_FORWARD = "A"; // 任务移交

	/**
	 * 是否标志
	 */
	public static final String FLAG_OFF = "0"; // 否
	public static final String FLAG_ON = "1"; // 是

	/* 工作流岗位定义 shen_antonio . */
	public static final String WF_ROLE_TYPE_ROLE100 = "ROLE100"; // 客户经理
	public static final String WF_ROLE_TYPE_ROLE101 = "ROLE101"; // 客户经理
	public static final String WF_ROLE_TYPE_ROLE102 = "ROLE102"; // 支行行长
	public static final String WF_ROLE_TYPE_ROLE103 = "ROLE103"; // 分行审查岗
	public static final String WF_ROLE_TYPE_ROLE104 = "ROLE104"; // 分行高级经理
	public static final String WF_ROLE_TYPE_ROLE105 = "ROLE105"; // 分行分管行长

	public static final String WF_ROLE_TYPE_ROLE106 = "ROLE106"; // 放款中心档案岗
	public static final String WF_ROLE_TYPE_ROLE107 = "ROLE107"; // 放款中心调查岗
	public static final String WF_ROLE_TYPE_ROLE108 = "ROLE108"; // 放款中心法律岗
	public static final String WF_ROLE_TYPE_ROLE109 = "ROLE109"; // 放款中心主管岗
	public static final String WF_ROLE_TYPE_ROLE110 = "ROLE110"; // 放款中心放款岗

	public static final String WF_ROLE_TYPE_ROLE111 = "ROLE111"; // 系统管理
	public static final String WF_ROLE_TYPE_ROLE112 = "ROLE112"; // 授权管理
	public static final String WF_ROLE_TYPE_ROLE113 = "ROLE113"; // 业务管理
	public static final String WF_ROLE_TYPE_ROLE114 = "ROLE114"; // 资产保全
	public static final String WF_ROLE_TYPE_ROLE115 = "ROLE115"; // 贷审会秘书
	public static final String WF_ROLE_TYPE_ROLE116 = "ROLE116"; // 贷后管理岗


	// 流程状态
	public static final String FLOW_STATUS_NOTUPLOAD = "0"; // 未上传
	public static final String FLOW_STATUS_INPROCESS = "1"; // 审批中
	public static final String FLOW_STATUS_REJECTED = "2"; // 已拒绝
	public static final String FLOW_STATUS_APPROVED = "3"; // 审批通过
	public static final String FLOW_STATUS_EXCEPTION = "4"; // 流程异常

	/**
	 * 规则引擎
	 */
	public static final String INVOKE_KEY_APPLYINT = "applyint"; // 授信申请完整性规则
	public static final String INVOKE_KEY_PREAPPLY = "preapply"; // 预申请规则
	public static final String INVOKE_KEY_PRODUCT = "product"; // 产品规则
	public static final String INVOKE_KEY_AUTOREJECT = "autoreject"; // 自动拒绝规则
	public static final String INVOKE_KEY_FLOWSEL = "flowsel"; // 流程选择规则
	public static final String INVOKE_KEY_AUTOAPPROVE = "autoapprove"; // 自动审批规则
	public static final String INVOKE_KEY_APPROVEAUTH = "approveauth"; // 授信授权规则
	public static final String INVOKE_KEY_LOANINT = "loanint"; //放款完整性规则

	/**
	 * modify by shen_antonio 20080327 for TlrLvdayService 销假状态
	 */
	public static final String TLRLV_CL_STATUS_0 = "0";// 未销假
	public static final String TLRLV_CL_STATUS_1 = "1";// 已销假
	/**
	 * modify by shen_antonio 20080327 增加操作员休假标志 3
	 */
	public static final String TLR_NO_STATE_LVDAY = "3";// 休假


	/** 合并票据工作流到信贷系统 by zhouxuejing 20101026 begin*/
	/**
	 * 工作流分配情况 Added by UU_Wu 2009-7-4
	 */
	public static final String WORKFLOW_ASSIGN_NONE = "无人分配";// 无人分配
	public static final String WORKFLOW_ASSIGN_MORETHANONE = "多人抢件";// 多人分配

	/**
	 * 工作流退回提交意见 Added by UU_Wu 2009-7-9
	 */
	public static final String WORKFLOW_GOBACKSUBMIT_REASON = "审核退回，重新提交";// 轮询间隔时间

	/**
	 * 工作流轮询间隔时间 Added by UU_Wu 2009-7-7
	 */
	public static final String WORKFLOW_TIMER_REPEAT = "TIMER_REPEAT";// 轮询间隔时间

	/**
	 * 工作流轮询检查 票据状态是否能去记账 Added by UU_Wu 2009-7-7
	 */
	public static final String WORKFLOW_REPLYTRANS_NORMALTOACCOUNT = "1";// 一般申请到记账
	public static final String WORKFLOW_REPLYTRANS_NORMALTOCONFIRM = "2";// 一般申请拒绝去确认
	public static final String WORKFLOW_REPLYTRANS_REJECTTOCONFIRM = "3";// 驳回申请去确认
	public static final String WORKFLOW_REPLYTRANS_DEFAULT = "4";// 无需进行状态校验的默认情况
	/**
	 * 传入流程的业务属性 Added by UU_Wu 2009-8-28
	 */
	public static final String WORKFLOW_ATTRIBUTE_ACCTBRHID = "ACCTBRHID";// 入账机构
	public static final String WORKFLOW_ATTRIBUTE_ISNEED = "ISNEED";// 当前审批路线明细是否必经
	public static final String WORKFLOW_ATTRIBUTE_PROCINSID = "PROC_INS_ID";// 流程实例号
	public static final String WORKFLOW_ATTRIBUTE_CURRSTOPID = "CURR_STOPID";// 当前审批路线明细ID
	public static final String WORKFLOW_ATTRIBUTE_ROUTEID = "ROUTE_ID";// 当前审批路线模板ID
	public static final String WORKFLOW_ATTRIBUTE_CANFINALAPPROVE = "CAN_FINAL_APPROVE";// 是否能终审标志
	public static final String WORKFLOW_ATTRIBUTE_OPRANOARR = "OPRNO_ARR";// 当前操作员
	public static final String WORKFLOW_ATTRIBUTE_STATUS = "STATUS";// 上个任务的审批结果
	public static final String WORKFLOW_ATTRIBUTE_ROLEID = "ROLEID";// 当前岗位
	public static final String WORKFLOW_ATTRIBUTE_TASKID = "TASKID";// 任务号
	public static final String WORKFLOW_ATTRIBUTE_CURRBRHID = "CURR_BRHID";// 当前机构



	public static final String WORKFLOW_ATTRIBUTE_AMOUNT = "AMOUNT";// 申请金额
	public static final String WORKFLOW_ATTRIBUTE_APPNO = "APPNO";// 申请号
	public static final String WORKFLOW_ATTRIBUTE_BUSSTYPE = "BUSS_TYPE";// 业务种类(四位码)
	public static final String WORKFLOW_ATTRIBUTE_CONTRACTID = "CONTRACTID";// 协议ID
	public static final String WORKFLOW_ATTRIBUTE_CUSTCD = "CUSTCD";// 客户ID
	public static final String WORKFLOW_ATTRIBUTE_CUSTNAME  = "CUSTNAME";// 客户名称
	public static final String WORKFLOW_ATTRIBUTE_DRAFTATTR = "DRAFT_ATTR";// 票据属性（1-实物2-电子）
	public static final String WORKFLOW_ATTRIBUTE_DRAFTTYPE = "DRAFT_TYPE";// 票据类型(1-银票 2-商票)
	public static final String WORKFLOW_ATTRIBUTE_STARTER = "STARTER";// 发起人ID
	public static final String WORKFLOW_ATTRIBUTE_STARTBRHID = "START_BRHID";// 发起行ID
	public static final String WORKFLOW_ATTRIBUTE_STARTBRHNO = "START_BRHNO";// 发起行NO
	public static final String WORKFLOW_ATTRIBUTE_TRANSNO = "TRANSNO";// 协议NO

	public static final String WORKFLOW_ATTRIBUTE_LASTAPPROVEROLEID = "LAST_APPROVE_ROLEID";// 最后审批操作员岗位ID

	/*超权限利率审批流程PROCNAME_BEYONDPERMISSIONRATE=BeyondPermissionRate.*/
	public static final String PROCNAME_BEYONDPERMISSIONRATE="PROCNAME_BEYONDPERMISSIONRATE";

	/**
	 * 工作流配置文件名
	 */
	public static final String WORKFLOW_PROPERTIES = "workflow";
	/** 合并票据工作流到信贷系统 by zhouxuejing 20101026 end*/
	//合同上传TASK_NAME
	public static final String WORKFLOW_TASK_NAME_LOANUPLOAD = "LoanUpload";

}
