package com.huateng.ebank.business.workflow;

public class WorkflowConstant {

	/**
	 * 工作流配置文件名
	 */
	public static final String WORKFLOW_PROPERTIES = "workflow";

	// 承兑业务流程节点
	public static final String TASK_NAME_DRAWBILL = "DrawBillTask"; // 出票节点
	public static final String TASK_NAME_ACCOUNT = "AccountTask"; // 记账节点
	public static final String TASK_NAME_APPROVE = "ApproveTask";// 审批节点
	public static final String TASK_NAME_CONFIRM = "ConfirmTask";// 客户经理确认节点
	public static final String TASK_NAME_LAUNCH = "LaunchApplicationTask";// 发送签收
	//add by GuoFusong begin
	public static final String TASK_NAME_DOFAIL = "FailHandleTask";// 发送失败确认节点
	//add by GuoFusong end

	/**
	 * 实物票据流程
	 */
	/*实物票据承兑流程PROCNAME_P_BILLACCEPTENCE=P-BillAcceptance.*/
	public static final String PROCNAME_P_BILLACCEPTENCE="PROCNAME_P_BILLACCEPTENCE";
	/*实物转贴现买入流程PROCNAME_P_TRANSDISCOUNTBUY=P-TransDiscountBuy.*/
	public static final String PROCNAME_P_TRANSDISCOUNTBUY = "PROCNAME_P_TRANSDISCOUNTBUY";
	/*实物贴现买入流程PROCNAME_P_DISCOUNTBUY=P-DiscountBuy.*/
	public static final String PROCNAME_P_DISCOUNTBUY = "PROCNAME_P_DISCOUNTBUY";
	/*实物转贴现卖出流程/实物再贴现卖出流程PROCNAME_P_REDISCOUNTSELL=P-RediscountSell.*/
	public static final String PROCNAME_P_REDISCOUNTSELL = "PROCNAME_P_REDISCOUNTSELL";
	/*查询查复PROCNAME_QUERYCHECK=QueryCheck.*/
	public static final String PROCNAME_QUERYCHECK = "PROCNAME_QUERYCHECK";
	/*超权限利率审批流程PROCNAME_BEYONDPERMISSIONRATE=BeyondPermissionRate.*/
	public static final String PROCNAME_BEYONDPERMISSIONRATE="PROCNAME_BEYONDPERMISSIONRATE";
	/*实物未用退回PROCNAME_P_ACCEPTCANCEL=P-AcceptCancel.*/
	/** 目前不使用，不走流程.*/
	public static final String PROCNAME_P_ACCEPTCANCEL = "PROCNAME_P_ACCEPTCANCEL";
	/*实物到期回购PROCNAME_P_DUETOBUY=P-DueToBuy.*/
	public static final String PROCNAME_P_DUETOBUY = "PROCNAME_P_DUETOBUY";
	/*实物到期返售PROCNAME_P_DUETOSELL=P-DueToSell.*/
	public static final String PROCNAME_P_DUETOSELL = "PROCNAME_P_DUETOSELL";

	/** add by farly.yu 20090831 合并福州商行质押模块 */
	/*实物票据质押查询查复add by weikun.wang*/
	public static final String PROCNAME_COLLZTNQUERYCHECK = "PROCNAME_COLLZTNQUERYCHECK";
	/*实物票据质押审批流程add by weikun.wang*/
	public static final String PROCNAME_P_COLLZTNAPPLY = "PROCNAME_P_COLLZTNAPPLY";
	/*实物票据解除质押审批流程add by weikun.wang*/
	public static final String PROCNAME_P_UNCOLLZTNAPPLY = "PROCNAME_P_UNCOLLZTNAPPLY";
	/*福商实物到期回购PROCNAME_P_FSDUETOBUY=P-FsDueToBuy.	|add by weikun.wang*/
	public static final String PROCNAME_P_FSDUETOBUY = "PROCNAME_P_FSDUETOBUY";
	/*福商实物到期返售PROCNAME_P_FSDUETOSELL=P-FsDueToSell. |add by weikun.wang*/
	public static final String PROCNAME_P_FSDUETOSELL = "PROCNAME_P_FSDUETOSELL";
	/** add end 20090831 */

	/**
	 * 电子票流程
	 */
	/** BMSA-88 双重授权 解付受理	by zhiyang.he begin */
	/*电子票据解付流程PROCNAME_E_BILLDualControlAcceptancePayDealEntry=E-DualControlAcceptancePayDealEntry.*/
	public static final String PROCNAME_E_BILLDualControlAcceptancePayDealEntry = "PROCNAME_E_BILLDualControlAcceptancePayDealEntry";
	/** BMSA-88 双重授权 解付受理	by zhiyang.he end */
	/*电子票据承兑流程PROCNAME_E_BILLACCEPTANCE=E-Accept.*/
	public static final String PROCNAME_E_BILLACCEPTANCE = "PROCNAME_E_BILLACCEPTANCE";
	/*贴现买入流程PROCNAME_E_DISCOUNTBUY=E-DiscountBuy.*/
	public static final String PROCNAME_E_DISCOUNTBUY = "PROCNAME_E_DISCOUNTBUY";
	/*转贴现买入PROCNAME_E_REDISCOUNTBUY=E-TransDiscountBuy.*/
	public static final String PROCNAME_E_REDISCOUNTBUY = "PROCNAME_E_REDISCOUNTBUY";
	/*转贴现卖出/再贴现卖出PROCNAME_E_REDISCOUNTSELL=E-RediscountSell.*/
	public static final String PROCNAME_E_REDISCOUNTSELL = "PROCNAME_E_REDISCOUNTSELL";
	/*贴现买入驳回流程PROCNAME_E_DISCOUNTREJECT=E-DiscountReject.*/
	public static final String PROCNAME_E_DISCOUNTREJECT = "PROCNAME_E_DISCOUNTREJECT";
	/*转贴现买入驳回PROCNAME_E_TRANSDISCOUNTREJECT=E-TransDiscountReject.*/
	public static final String PROCNAME_E_TRANSDISCOUNTREJECT = "PROCNAME_E_TRANSDISCOUNTREJECT";
	/*承兑驳回PROCNAME_E_ACCEPTREJECT=E-AcceptReject.*/
	public static final String PROCNAME_E_ACCEPTREJECT = "PROCNAME_E_ACCEPTREJECT";
	/*转贴现到期返售PROCNAME_E_DUETOSELL=E-DueToTransDiscountSell.*/
	public static final String PROCNAME_E_DUETOSELL = "PROCNAME_E_DUETOSELL";
	/*转贴现到期回购PROCNAME_E_DUETOBUY=E-DueToTransDiscountBuy.*/
	public static final String PROCNAME_E_DUETOBUY = "PROCNAME_E_DUETOBUY";
	/*转贴现到期回购驳回PROCNAME_E_DUETOBUYREJECT=E-DueToTransDiscountBuyReject.*/
	public static final String PROCNAME_E_DUETOBUYREJECT = "PROCNAME_E_DUETOBUYREJECT";
	/** add by jornezhang 20091119 BMS-2244 电子质押增加协议层改造 begin */
	/*质押签收PROCNAME_E_COLLZTNAPPLY=E-CollztnApply.*/
	public static final String PROCNAME_E_COLLZTNAPPLY = "PROCNAME_E_COLLZTNAPPLY";
	/*质押申请PROCNAME_E_COLLZTNAPPLYSEND=E-CollztnApplySend.*/
	public static final String PROCNAME_E_COLLZTNAPPLYSEND = "PROCNAME_E_COLLZTNAPPLYSEND";
	/*解除质押签收PROCNAME_E_UNCOLLZTNAPPLY=E-UnCollztnApply.*/
	public static final String PROCNAME_E_UNCOLLZTNAPPLY = "PROCNAME_E_UNCOLLZTNAPPLY";
	/*解除质押申请PROCNAME_E_UNCOLLZTNAPPLYSEND=E-UnCollztnApplySend.*/
	public static final String PROCNAME_E_UNCOLLZTNAPPLYSEND = "PROCNAME_E_UNCOLLZTNAPPLYSEND";
	/** add by jornezhang 20091119 BMS-2244 电子质押增加协议层改造 end */
	/** add by weikun.wang 20100701   BMS-2788 电子票据保证增加协议层改造 begin */
	/*保证申请流程PROCNAME_E_ELCGUARANTSEND=E-ElcGuarantSend.*/
	public static final String PROCNAME_E_ELCGUARANTSEND = "PROCNAME_E_ELCGUARANTSEND";
	/*保证签收流程PROCNAME_E_ELCGUARANTSIGN=E-ElcGuarantSign.*/
	public static final String PROCNAME_E_ELCGUARANTSIGN = "PROCNAME_E_ELCGUARANTSIGN";
	/** add by weikun.wang 20100701   BMS-2788 电子票据保证增加协议层改造 end */


	/** add by zhen.huang 20100903  BMS-2832 电子票据保证驳回协议层改造 begin */
	/*保证协议驳回流程PROCNAME_E_ELCGUARANTSIGNREJECT=E-ElcGuarantSignReject.*/
	public static final String PROCNAME_E_ELCGUARANTSIGNREJECT = "PROCNAME_E_ELCGUARANTSIGNREJECT";
	/** add by zhen.huang 20100903  BMS-2832 电子票据保证驳回协议层改造 end */

	//added BMSA-84 4Eye功能—提示付款申请—工作流开发 by yequan.song on 20110915 begin
	public static final String PROCNAME_E_ELCCOLLECTIONSEND = "PROCNAME_E_ELCCOLLECTIONSEND";
	//added BMSA-84 4Eye功能—提示付款申请—工作流开发 by yequan.song on 20110915 end

	/** add by LiChr 票据查验申请增加工作流begin	 */
	public static final String PROCNAME_E_DRAFTSHOWSEND = "PROCNAME_E_DRAFTSHOWSEND";
	/** add by LiChr 票据查验申请增加工作流end	 */

	/**
	 * 代保管/代保管解除流程 add by huangy bms-2199
	 */
	public static final String PROCNAME_P_CANCLESTORAGE = "PROCNAME_P_CANCLESTORAGE";
	public static final String PROCNAME_P_STORAGE = "PROCNAME_P_STORAGE";


	/**
	 * 票据池/票据池解除流程 add by lidi BMSA-126
	 */
	public static final String PROCNAME_P_DRAFTPOOL = "PROCNAME_P_DRAFTPOOL";
	public static final String PROCNAME_P_CANCLEDRAFTPOOL = "PROCNAME_P_CANCLEDRAFTPOOL";

	/**
	 * 抹账流程 add by huangy
	 */
	public static final String PROCNAME_P_WIPE = "PROCNAME_P_WIPE";

	/** add by jornezhang 20100311 BMS-2501 v1.4电子合同BMS交易开发 begin */
	//电子合同发送
	public static final String PROCNAME_E_ELCCTRCTSEND = "PROCNAME_E_ELCCTRCTSEND";
	//电子合同签收
	public static final String PROCNAME_E_ELCCTRCTSIGN = "PROCNAME_E_ELCCTRCTSIGN";
	//电子合同解除发送
	public static final String PROCNAME_E_ELCCTRCTCANCELSEND = "PROCNAME_E_ELCCTRCTCANCELSEND";
	//电子哈同解除签收
	public static final String PROCNAME_E_ELCCTRCTCANCELSIGN = "PROCNAME_E_ELCCTRCTCANCELSIGN";
	/** add by jornezhang 20100311 BMS-2501 v1.4电子合同BMS交易开发 end */



	/**
	 * modify by shen_antonio 20080327 for TlrLvdayService 销假状态
	 */
	public static final String TLRLV_CL_STATUS_0 = "0";// 未销假
	public static final String TLRLV_CL_STATUS_1 = "1";// 已销假
	/**
	 * modify by shen_antonio 20080327 增加操作员休假标志 3
	 */
	public static final String TLR_NO_STATE_LVDAY = "3";// 休假
	/**
	 * modify by shen_antonio 20080328 for TaskAssignService 工作类型、工作分配描述
	 */
	/** memeber variable: String TASK_ASSIGN_TYPE_0 工作安排方式:自动分配. */
	public static final String TASK_ASSIGN_TYPE_0 = "0";
	/** memeber variable: String TASK_ASSIGN_TYPE_1 工作安排方式:人工分配. */
	public static final String TASK_ASSIGN_TYPE_1 = "1";
	/** memeber variable: String TASK_ASSIGN_MODE_O 分配到岗位(强件模式). */
	public static final String TASK_ASSIGN_MODE_O = "0";
	/** memeber variable: String TASK_ASSIGN_MODE_1 分配到指定人（按工作量分配). */
	public static final String TASK_ASSIGN_MODE_1 = "1";
	/** memeber variable: String TASK_ASSIGN_MODE_2 分配到人（随机分配）. */
	public static final String TASK_ASSIGN_MODE_2 = "2";
	/** memeber variable: String TASK_WORK_TYPE_99 全部工作. */
	public static final String TASK_WORK_TYPE_99 = "99";
	/** memeber variable: String TASK_WORK_TYPE_01 贷前工作. */
	public static final String TASK_WORK_TYPE_01 = "01";
	/** memeber variable: String TASK_WORK_TYPE_02 贷后工作. */
	public static final String TASK_WORK_TYPE_02 = "02";
	/** memeber variable: String TASK_ASSIGN_STATUS_0 分配工作有效标志:有效. */
	public static final String TASK_ASSIGN_STATUS_0 = "0";
	/** memeber variable: String TASK_ASSGIN_STATUS_1 分配工作有效标志:无效,任务任务被移交. */
	public static final String TASK_ASSGIN_STATUS_1 = "1";
	/** memeber variable: String TASK_ASSGIN_STATUS_2 分配工作有效标志:无效，任务被删除. */
	public static final String TASK_ASSGIN_STATUS_2 = "2";

	/**
	 * 工作流意见 add by zsy
	 */
	public static final String WORKFLOW_ATTITUDE_AGREE = "1";// 工作流意见
	public static final String WORKFLOW_ATTITUDE_DISAGREE = "2";// 工作流意见
	public static final String WORKFLOW_ATTITUDE_GOBACK = "3";// 工作流意见
	public static final String WORKFLOW_ATTITUDE_AGREETOSUBMIT = "4";// 工作流意见
	public static final String WORKFLOW_ATTITUDE_AGREETOEND = "5";// 工作流意见
	public static final String WORKFLOW_ATTITUDE_SUBMIT = "6";// 工作流意见
	public static final String WORKFLOW_ATTITUDE_REFUSETOEND = "7";// 工作流意见

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
	//兴业需求
	public static final String WORKFLOW_ATTRIBUTE_NEEDINNERFLAG = "NEED_INNERFLAG";// 是否需要有系统内外标识

	public static final String WORKFLOW_ATTRIBUTE_LASTAPPROVEROLEID = "LAST_APPROVE_ROLEID";// 最后审批操作员岗位ID
	//德意志 BMSA-89 add by jian.yu
	public static final String DUALTASKPOOL = "PROCNAME_E_DualTaskPool";

	//add by nirvana.li BMSA-125 20111123
	public static final String PROCNAME_QUERYCHECKN = "PROCNAME_QUERYCHECKN";//查询查复
}