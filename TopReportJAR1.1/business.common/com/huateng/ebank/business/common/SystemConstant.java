/*
 * ==================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2004-2005 Huateng Software System.  All rights
 * reserved.
 * ==================================================================
 */
package com.huateng.ebank.business.common;

/**
 * @author valley
 * @date 2004-11-16
 * @desc 系统常量定义
 */
public class SystemConstant {

	/**
	 * 是否标志
	 */
	public static final String FLAG_OFF = "0"; // 否
	public static final String FLAG_ON = "1"; // 是

	/**
	 * 有效标志/状态
	 */
	public static final String VALID_FLAG_INVALID = "0"; // 无效
	public static final String VALID_FLAG_VALID = "1"; // 有效 modify by panghong
														// 01 modify 1
	public static final String VALID_FLAG_FREEZE = "2"; // 冻结

	/**
	 * 客户状态
	 */
	public static final String CUSTOMRE_FLAG_INVALID = "0"; // 无效
	public static final String CUSTOMRE_FLAG_VALID = "1"; // 有效
	public static final String CUSTOMRE_FLAG_FREEZE = "2"; // 冻结

	/**
	 * 业务类型
	 */
	public static final String CINO_TYPE_PUB = "0";// 公共业务
	public static final String CINO_TYPE_CORP = "1";// 对公业务
	public static final String CINO_TYPE_INDV = "2";// 对私业务

	/**
	 * 黑名单状态
	 */
	public static final String BLACKLIST_YES = "1"; // 是黑名单
	public static final String BLACKLIST_NO = "0"; // 不是黑名单

	/**
	 * 大事记状态
	 */
	public static final String GREAT_EVENT_CREATEBYHAND = "00"; // 手工创建大事记
	public static final String GREAT_EVENT_NORMAL = "01";// 一般大事记
	public static final String GREAT_EVENT_YEAR_CHECK = "02";// 年检到期大事记
	public static final String GREAT_EVENT_CUSTOMER_STATUS_CHANGE = "03";// 客户状态变更大事记
	public static final String GREAT_EVENT_CUSTOMER_RELATION_CHANGE = "04";// 客户关系变更大事记
	/**
	 * 客户管理(自然人管理)管理模式
	 */
	public static final String CUST_INDV_FLAG_MODE = "0"; // 1为分行模式

	public static int TYPE_STRING = 1;
	public static int TYPE_DATE = 2;
	public static int TYPE_AMOUNT = 3;

	public static boolean CUST_CORE_CHECK_FLAG = false;// 海尔客户资料无核心同步

	public static final int CUSTOMER_CUSTNO_LENGTH = 8; // 客户长度。

	// 利率类型
	/**
	 * 利率类型-年息(百分之)
	 */
	public static final String RATE_TYPE_YEAR = "1"; // 年息
	/**
	 * 利率类型-月息(千分之)
	 */
	public static final String RATE_TYPE_MONTH = "2"; // 月息
	/**
	 * 利率类型-日息(万分之)
	 */
	public static final String RATE_TYPE_DAY = "3"; // 日息

	/**
	 * 百分之
	 */
	public static final String RATIO_TYPE_PERCENT = "1";
	/**
	 * 利率类型-月息(千分之)
	 */
	public static final String RATIO_TYPE_PER_THOUSAND = "2";
	/**
	 * 利率类型-日息(万分之)
	 */
	public static final String RATIO_TYPE_PER_TEN_THOUSAND = "3";

	public static final String RATE_TYPE_YEAR_NAME = "年息"; // 年息
	public static final String RATE_TYPE_MONTH_NAME = "月息"; // 月息
	public static final String RATE_TYPE_DAY_NAME = "日息"; // 日息

	/**
	 * 14位 日期格式
	 */
	public static final String TIME14_PATTERN = "yyyy-MM-dd HH:mm:ss";
	public static final String TIME14_PATTERN2 = "yyyyMMddHHmmss";
	/**
	 * 6位 日期格式
	 */
	public static final String TIME6_PATTERN = "hh:mm:ss";

	/**
	 * 审批状态
	 */
	public static final String APPROVE_STATE_CREATE = "0"; // 新建
	public static final String APPROVE_STATE_CHECKUP = "1";// 审批中
	public static final String APPROVE_STATE_EFFECT = "2";// 审批通过
	public static final String APPROVE_STATE_MATU = "3";// 到期
	public static final String APPROVE_STATE_ANNULMENT = "5";// 终止

	/**
	 * 客户信息更新
	 *
	 */

	public static final String CUST_UPDATE = "1";

	/**
	 * 客户信息删除
	 *
	 */
	public static final String CUST_DELETE = "0";

	/**
	 * 合作协议生效范围
	 */
	public static final String COOP_BRCODE_CLASS_HEAD = "1"; // 总行
	public static final String COOP_BRCODE_CLASS_PROVINCE = "2"; // 省行
	public static final String COOP_BRCODE_CLASS_BRANCH = "3"; // 分行
	public static final String COOP_BRCODE_CLASS_REGION = "4"; // 地区
	public static final String COOP_BRCODE_CLASS_SUBBRANCH = "5"; // 机构

	/**
	 * 币种
	 */
	public static final String CURCD_RMB = "CNY"; // 人民币

	/**
	 * 日期格式
	 */
	public static final String DATE_PATTERN = "yyyy-MM-dd";
	public static final String DATE_PATTERN_2 = "yyyyMMdd";

	// seqctl中的value_no
	public static final int VALUE_NO_APPNO = 1; // 申请编号
	public static final int VALUE_NO_CUSTCD = 2; // 客户编码

	public static final int VALUE_NO_CONTRACTNO = 3; // 合同
	public static final int VALUE_NO_PROJECTNO = 4; // 合作项目编号
	public static final int VALUE_NO_HOUSENO = 5; // 楼盘编号
	public static final int VALUE_NO_ACCUM_FUND_ACTNO = 6; // 公积金帐号
	public static final int VALUE_NO_ARCHIVE_ID = 7; // 档案要素编号
	public static final int VALUE_NO_WARNING_ID = 8; // 预警编号
	public static final int VALUE_NO_MORIIMPAWN_ID = 9;// 抵质压合同序号
	public static final int VALUE_NO_BRCODE = 10;// 机构编号
	public static final int VALUE_NO_COOP_PROTOCOLNO = 12; // 合作协议编号
	public static final int VALUE_NO_CORP_CREDIT_NO = 13; // 对公客户征信信息编号
	public static final int VALUE_NO_CORESYS = 50; // 核心交易请求流水号
	public static final int VALUE_NO_RULEFILE = 111; // 规则文件序号
	public static final int VALUE_NO_CREDITNO = 18; // 额度相关编号
	public static final int VALUE_NO_FRZNO = 19; // 额度冻结解冻顺序号
	public static final int VALUE_NO_LOANCENTER = 58;// 放款相关编号
	public static final int VALUE_NO_CREDITREALID = 67; // 额度使用明细-额度关联ID
	public static final int VALUE_NO_RULEID = 112; // 规则引擎表ID生成器


	public static final int VALUE_NO_NOTICENO = 113; // 审批通知书号

	public static final int VALUE_NO_MODEL_TYPE = 114; // 模型代码

	public static final String CREDIT_NOTICE_VALUE_INDEX = "creditnoticeno"; // 通知书编号VALUE_INDEX

	public static final String ACE_VALUE_INDEX = "ACE"; // 生成核心流水的VALUE_INDEX

	// 流程状态
	public static final String FLOW_STATUS_NOTUPLOAD = "0"; // 未上传
	public static final String FLOW_STATUS_INPROCESS = "1"; // 审批中
	public static final String FLOW_STATUS_REJECTED = "2"; // 已拒绝
	public static final String FLOW_STATUS_APPROVED = "3"; // 审批通过
	public static final String FLOW_STATUS_EXCEPTION = "4"; // 流程异常

	// seqctl中默认的value_index
	public static final String VALUE_INDEX = "00000000000000000000";

	// 公积金帐号科目(用于生成公积金帐号)
	public static final String ACCUM_FUND_ACNO = "0950";

	/**
	 * 机构级别-BCTL.BRCLASS
	 */
	public static final String BRCODE_CLASS_HEAD = "1"; // 1-总行
	public static final String BRCODE_CLASS_BRANCH = "2"; // 2-分行
	public static final String BRCODE_CLASS_SUBBRANCH = "5"; // 5-支行
	public static final String BRCODE_CLASS_MNGBRANCH = "3"; // 3-管理行
	public static final String BRCODE_CLASS_PL_CENTER = "3"; // 个贷中心
	public static final String BRCODE_CLASS_SUB_PL_CENTER = "5"; // 个贷分中心


	/**
	 * 分行级别-BCTL.BLN_BRANCH_CLASS
	 */
	public static final String BRCODE_BRANCH_CLASS_1 = "1";// 1-管理分行
	public static final String BRCODE_BRANCH_CLASS_2 = "2";// 2-直属行
	public static final String BRCODE_BRANCH_CLASS_3 = "3";// 3-辖属行

	/**
	 * 报表机构级别 主要区分：直属行、省分行、省辖分行
	 */
	public static final String RPT_BRCODE_CLASS_0 = "0";// 0-总行
	public static final String RPT_BRCODE_CLASS_1 = "1";// 1-省分行
	public static final String RPT_BRCODE_CLASS_2 = "2";// 2-直属行
	public static final String RPT_BRCODE_CLASS_3 = "3";// 3-辖属行
	public static final String RPT_BRCODE_CLASS_4 = "4";// 4-省辖分行
	public static final String RPT_BRCODE_CLASS_5 = "5";// 5-支行

	/**
	 * 总行内部机构号
	 */
	public static final String BRCODE_HEAD_9999 = "9999";// 总行内部机构号

	/**
	 * 机构类别
	 */
	public static final String BRTYPE_2 = "2"; // 国际业务部

	/**
	 * 操作员业务审批类型
	 */
	public static final String LIMIT_PARAM_BIZ_CLASS_ALL = "0"; // 全部
	public static final String LIMIT_PARAM_BIZ_CLASS_LOAN = "1"; // 贷款业务
	public static final String LIMIT_PARAM_BIZ_CLASS_PROJ = "2"; // 合作项目

	/**
	 * 岗位类型
	 */
	/* 岗位类型定义 shen_anotnio . */
	public static final String ROLE_TYPE_CREDIT_AUDIT = "2"; // 授信审查
	public static final String ROLE_TYPE_CREDIT_APPROVE = "3"; // 授信审批
	public static final String ROLE_TYPE_PAY_ARCHIVE = "4"; // 放款中心档案岗
	public static final String ROLE_TYPE_PAY_AUDIT = "5"; // 放款中心调查岗
	public static final String ROLE_TYPE_PAY_LAW = "6"; // 放款中心法律岗
	public static final String ROLE_TYPE_CIEF = "7"; // 放款中心主管岗
	public static final String ROLE_TYPE_SYS_MNG = "9"; // 系统管理
	public static final String ROLE_TYPE_AUTH_MNG = "A"; // 授权管理
	public static final String ROLE_TYPE_BUSN_MNG = "B"; // 业务管理
	public static final String ROLE_TYPE_ASSET_PROT = "C"; // 资产保全
	public static final String ROLE_TYPE_OTHER = "0"; // 其它
	public static final String ROLE_TYPE_INPUT = "2"; // 录入岗/客户经理
	public static final String ROLE_TYPE_MGR = "2"; // 客户经理
	public static final String ROLE_TYPE_AUDIT = "3"; // 贷款审查岗
	public static final String ROLE_TYPE_APPROVE = "4"; // 贷款审批岗
	public static final String ROLE_TYPE_COUNCIL = "5"; // 贷审会意见录入岗
	public static final String ROLE_TYPE_SUPERVISE = "6"; // 放款监督岗
	public static final String ROLE_TYPE_PROJ_AUDIT = "7"; // 项目审查岗
	public static final String ROLE_TYPE_PROJ_APPROVE = "8"; // 项目审批岗
	public static final String ROLE_TYPE_COUNCIL_APPROVE = "9"; // 贷审会审批岗

	/* 工作流岗位定义 shen_antonio . */
	public static final String WF_ROLE_TYPE_ROLE100 = "ROLE100";  //客户经理
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

	/**
	 * 岗位名
	 */
	public static final int ROLE_CUST_MANAGER = 100;// 客户经理
	public static final int ROLE_CUST_ZONGJINGLI = 105;// 总经理岗位
	public static final int ROLE_NPA_MANAGER = 121;// 资产保全管户岗


	/**
	 * 合作协议状态标志
	 */
	public static final String COOPPROT_VALID_FLAG_INVALID = "00";// 无效
	public static final String COOPPROT_VALID_FLAG_VALID = "01";// 有效
	public static final String COOPPROT_VALID_FLAG_FREEZE = "02";// 冻结

	/*
	 * 角色类型
	 */
	public static final int ROLE_ID_LOAN_INPUT = 100; // 资料录入/客户经理岗
	public static final int ROLE_ID_LOAN_AUDIT = 102; // 贷款审查
	public static final int ROLE_ID_LOAN_MEETING = 103; // 贷审会意见录入岗
	public static final int ROLE_ID_LOAN_APPROVE = 105; // 贷款审批
	public static final int ROLE_ID_LOAN_SUPERVISE = 110; // 放款监督
	public static final int ROLE_ID_LOAN_SAVE = 114; // 资产保全
	public static final int ROLE_ID_PROJECT_AUDIT = 119; // 项目审查
	public static final int ROLE_ID_PROJECT_APPROVE = 120; // 项目审批
	public static final int ROLE_ID_LOAN_UP_APPROVE = 121; // 贷款高级审批
	public static final int ROLE_ID_LEAVE_APPROVE = 140; // 请假审批

	/**
	 * 操作员审批控制方式
	 */
	public static final String APPROVE_TYPE_PASS_UNDER_MAX = "1"; // 审批最高金额为准
	public static final String APPROVE_TYPE_REPORT_IF_AGREE = "2"; // 审批同意上报
	public static final String APPROVE_TYPE_REPORT_ALL = "3"; // 所有审批上报
	public static final String APPROVE_TYPE_PASS_IF_AGREE = "4"; // 审批同意通过

	/**
	 * 审批意见
	 */
	public static final String APP_ATTITUDE_AGREE = "1"; // 同意
	public static final String APP_ATTITUDE_DISAGREE = "2"; // 不同意
	public static final String APP_ATTITUDE_UNTREAD_NEXT = "3"; //退回至前一级
	public static final String APP_ATTITUDE_UNTREAD = "4"; //退回调查岗重审
	public static final String APP_ATTITUDE_UNTREAD_BACK = "5"; //退回调查岗并返回退回者
	public static final String APP_ATTITUDE_CONDI_AGREE = "6"; // 有条件同意
	public static final String APP_ATTITUDE_AGREE_REPORT = "7"; // 审批同意上报


	/**
	 * 权限检查结果（流程下一步走向）
	 */
	public static final int APP_RESULT_REPORT = 0; // 审批上报
	public static final int APP_RESULT_PASS = 1; // 审批通过
	public static final int APP_RESULT_FAIL = 2; // 审批不通过
	public static final int APP_RESULT_UNTREAD = 3; // 审批退回

	/**
	 * 前续审批条件
	 */
	public static final String PRE_APP_CONDITION_NON = "0"; // 无
	public static final String PRE_APP_CONDITION_PREAPP = "1"; // 需要预审批
	public static final String PRE_APP_CONDITION_INPUT = "2"; // 需要录入贷审会意见

	/**
	 * 客户类型
	 */
	public static final String CUST_TYPE_ARTIFICIAL = "1"; // 法人
	public static final String CUST_TYPE_NATURAL = "2"; // 自然人
	public static final String CUST_TYPE_FINANCIAL = "3"; // 金融机构
	public static final String CUST_TYPE_ARTIFICIAL_AND_NATURAL = "0"; // 自然人和对公客户

	/**
	 * 特约商户类型
	 */
	public static final String CORP_TYPE_COOP = "1"; // 合作商
	public static final String CORP_TYPE_ASSURER = "2"; // 担保公司
	public static final String CORP_TYPE_LAW_AGENCY = "3"; // 法律中介
	public static final String CORP_TYPE_EVAL_AGENCY = "4"; // 评估机构

	/**
	 * 客户编码类型
	 */
	public static final String CORP_CODE_TYPE_LAND_AGENT = "F"; // 房产商
	public static final String CORP_CODE_TYPE_AUTO_DEALER = "C"; // 汽车经销商
	public static final String CORP_CODE_TYPE_RETAILER = "N"; // 批发零售企业
	public static final String CORP_CODE_TYPE_SCHOOL = "X"; // 学校
	public static final String CORP_CODE_TYPE_ACCUM_FUND = "G"; // 住房公积金管理中心
	public static final String CORP_CODE_TYPE_ASSURER = "D"; // 担保公司
	public static final String CORP_CODE_TYPE_AGENCY = "Z"; // 中介机构
	public static final String CORP_CODE_TYPE_CONSIGN = "W"; // 委托单位
	public static final String CORP_CODE_TYPE_INSURER = "B"; // 保险公司
	public static final String CORP_CODE_TYPE_OTHER = "Q"; // 其他
	public static final String CORP_CODE_TYPE_DIRECT_COOP = "9"; // 直客式合作商

	/**
	 * 直客式合作商编号
	 */
	public static final String DIRECT_COOPNO = "99999999";

	/**
	 * 客户评级
	 */
	public static final String ARTICORPLEVEL = "2"; // 人工评级
	public static final String SYSCORPLEVEL = "1"; // 内评评级

	/**
	 * 宏定义：合作协议操作类型
	 */
	public static final String COOP_PROTOCOL_OP_TYPE_CREATE = "00"; // 建立
	public static final String COOP_PROTOCOL_OP_TYPE_MODIFY = "01"; // 维护
	public static final String COOP_PROTOCOL_OP_TYPE_TERMINATE = "02";// 终止
	public static final String COOP_PROTOCOL_OP_TYPE_RENEW = "03"; // 恢复
	public static final String COOP_PROTOCOL_OP_TYPE_FREEZE = "04"; // 冻结
	public static final String COOP_PROTOCOL_OP_TYPE_UNFREEZE = "05"; // 解冻

	/**
	 * 合作协议无效
	 */
	public static final String PROTOCAL_INVALID = "00"; // 合作协议无效

	/**
	 * 宏定义
	 */
	public static final int CORE_CUST_NO_LENGTH = 13; // 核心客户号长度

	/**
	 * 规则表现形式
	 */
	public static final String INVOKE_TYPE_PKG = "0"; // 配置规则包
	public static final String INVOKE_TYPE_CHECKLIST = "1"; // 检查清单
	public static final String INVOKE_TYPE_DTABLE = "2"; // 检查清单
	public static final String PACKAGE_STATUS_VALID = "1"; // 规则组状态有效
	public static final String PACKAGE_STATUS_INVALID = "0"; // 规则组状态无效
	public static final String PACKAGE_RUN_STATUS_ACTIVE = "1"; // 规则组正在被使用
	public static final String PACKAGE_RUN_STATUS_INACTIVE = "0"; // 规则组没有被使用

	/**
	 * 证件类型
	 */
	public static final String IDTYPE_ID_CARD_HUKOU = "06"; // 户口
	public static final String IDTYPE_ID_CARD_OTHER = "07"; // 其他
	public static final String IDTYPE_ORG_ID = "01"; // 组织机构代码
	/**
	 * 证件类型
	 *
	 * @author 朱世杰 add 增加其他证件类型定义
	 *
	 * @time 2011-01-20
	 */
	public static final String IDTYPE_ID_CARD = "0"; // 身份证
	public static final String IDTYPE_ID_HKB = "1";//户口簿
	public static final String IDTYPE_ID_HZ ="2";//护照
	public static final String IDTYPE_ID_JGZ = "3";//军官证
	public static final String IDTYPE_ID_SBZ = "4";//士兵证
	public static final String IDTYPE_ID_GATXZ="5";//港澳居民来往内地通行证
	public static final String IDTYPE_ID_TWTXZ="6";//台湾同胞来往大陆内地通行证
	public static final String IDTYPE_ID_CARD_TEMP = "7"; // 临时身份证
	public static final String IDTYPE_ID_WGJLZ="8";//外国人居留证
	public static final String IDTYPE_ID_JGZH="9";//警官证
	public static final String IDTYPE_ID_X="X";//其他
	/**
	 * 婚姻状况
	 */
	public static final String MARRIAGE_UNMARRIED = "10"; // 未婚
	public static final String MARRIAGE_MARRIED = "20"; // 已婚
	public static final String MARRIAGE_WIDOWED = "30"; // 丧偶
	public static final String MARRIAGE_DIVORCED = "40";// 离婚
	public static final String MARRIAGE_UNKNOW = "90"; // 未说明婚姻状况
	public static final String MARRIAGE_MARRIED_ISSUE = MARRIAGE_MARRIED; // 已婚有子女
	public static final String MARRIAGE_MARRIED_ISSUELESS = MARRIAGE_MARRIED; // 已婚无子女
	
	/**
	 * 婚姻状况
	 */
	public static final String MARRIAGE_NEW_MARRIED = "21"; // 初婚
	public static final String MARRIAGE_DIGAMY_MARRIED = "22"; // 再婚
	public static final String MARRIAGE_REMARRIED = "23"; // 复婚
	public static final String MARRIAGE_UNSPECIFIED = "90"; // 未说明的
	
	// 额度申请表-额度申请状态
	public static final int DATA_TYPE_NO_APPLYSTATUS = 1010; // 字典表中授信状态数据类型编号
	public static final String CREDITGRANTAPPLY_STATUS_0 = "00";// 额度申请信息状态-申请
	public static final String CREDITGRANTAPPLY_STATUS_1 = "01";// 额度申请信息状态-审批中
	public static final String CREDITGRANTAPPLY_STATUS_2 = "02";// 额度申请信息状态-取消
	public static final String CREDITGRANTAPPLY_STATUS_3 = "03";// 额度申请信息状态-拒绝人工放弃
	public static final String CREDITGRANTAPPLY_STATUS_4 = "04";// 额度申请信息状态-重新申请
	public static final String CREDITGRANTAPPLY_STATUS_5 = "05";// 额度申请信息状态-拒绝自动放弃
	public static final String CREDITGRANTAPPLY_STATUS_6 = "06";// 额度申请信息状态-退回
	public static final String CREDITGRANTAPPLY_STATUS_7 = "07";// 额度申请信息状态-拒绝
	public static final String CREDITGRANTAPPLY_STATUS_8 = "08";// 额度申请信息状态-同意并结束

	/**
	 * 个人关系
	 */
	public static final String PERSONAL_RELATION_MYSELF = "0"; // 自己
	public static final String PERSONAL_RELATION_MATE = "1"; // 配偶
	public static final String PERSONAL_RELATION_PARENT = "2"; // 父母
	public static final String PERSONAL_RELATION_CHILDREN = "3"; // 子女
	public static final String PERSONAL_RELATION_GRANDPARENT = "4"; // 祖父母
	public static final String PERSONAL_RELATION_GRANDCHILDREN = "5"; // 孙子女
	public static final String PERSONAL_RELATION_SIBLING = "6"; // 兄弟姐妹
	public static final String PERSONAL_RELATION_OTHER = "7"; // 其他

	/**
	 * 合作项目类型
	 */
	public static final String PROJECT_TYPE_HOUSE = "1"; // 购房贷款
	public static final String PROJECT_TYPE_AUTO = "2"; // 汽车贷款
	public static final String PROJECT_TYPE_CONSUMABLE = "3"; // 消费品贷款
	public static final String PROJECT_TYPE_EDUCATION = "4"; // 助学贷款
	public static final String PROJECT_TYPE_TOUR = "5"; // 旅游贷款
	public static final String PROJECT_TYPE_CONSIGN = "6"; // 委托贷款
	public static final String PROJECT_TYPE_WORKING = "7"; // 经营性贷款
	public static final String PROJECT_TYPE_ACCUM_FUND = "8"; // 公积金贷款
	public static final String PROJECT_TYPE_OTHER = "9"; // 其它贷款
	public static final String PROJECT_TYPE_ASSURE = "A"; // 担保协议
	/**
	 * 合作项目类型
	 */
	public static final String PROJECT_TYPE_ALL = "0"; // 不限

	/**
	 * 虚拟合作项目编号
	 */
	public static final String DUMMY_PROJECTNO = "999999999999";

	/**
	 * 合作项目额度控制方式
	 */
	public static final String LIMIT_MODE_UNLIMITED = "0"; // 不设上限
	public static final String LIMIT_MODE_SUM = "1"; // 非循环
	public static final String LIMIT_MODE_BAL = "2"; // 循环

	/**
	 * 审批状态/流程状态
	 */
	public static final String FLOW_STATUS_APPROVING = "0"; // 审批中
	public static final String FLOW_STATUS_FINISH = "1"; // 审批结束
	public static final String FLOW_STATUS_REJECT = "2"; // 拒绝
	public static final String FLOW_STATUS_BACK_LAST = "3"; // 审批退回上一级
	public static final String FLOW_STATUS_BACK = "4"; // 审批退回至流程发起者重审
	public static final String FLOW_STATUS_BACK_BACK = "5"; //退回调查岗并返回退回者
	public static final String FLOW_STATUS_CORE_SUCCESS = "6"; // 发送核心返回成功
	public static final String FLOW_STATUS_SIGN_CONT = "7"; // 合同已签订(只对贷款和授信申请有效)
	public static final String FLOW_STATUS_NEVER_APPROVE = "8"; // 未审批(录入未上传)
	public static final String FLOW_STATUS_CANCEL = "9"; // 已取消申请
	public static final String FLOW_STATUS_GRANT_APPROVING = "A"; // 出账审批中
	public static final String FLOW_STATUS_GRANT_FINISH = "B"; // 出账审批结束

	/**
	 * 房贷卡授信额度申请状态/流程状态 审批中 1-审批通过 2-审批同意结束 3-审批拒绝结束
	 */
	public static final String CARD_APPLY_STATUS_APPROVING = "0"; // 审批中
	public static final String CARD_APPLY_STATUS_PASS = "1"; // 审批通过
	public static final String CARD_APPLY_STATUS_AGREE_FINISH = "2"; // 审批同意结束
	public static final String CARD_APPLY_STATUS_REJECT_FINISH = "3"; // 审批拒绝结束

	/**
	 * 贷款借据发放状态
	 */
	public static final String GRANT_STATUS_UNGRANT = "0"; // 未入账
	public static final String GRANT_STATUS_GRANTED = "1"; // 已入账
	public static final String GRANT_STATUS_RETRACTED = "2"; // 已撤销
	public static final String GRANT_STATUS_OVER = "3"; // 已终止

	/**
	 * 逾期天数状态
	 */
	public static final String OVD_DAYS_STAT_NORMAL = "01"; // 正常

	/**
	 * 五级分类
	 */
	public static final String CLR_CLASS_NORMAL = "0"; // 正常
	public static final String CLR_CLASS_ATTENTION = "1"; // 关注
	public static final String CLR_CLASS_LESSER = "2"; // 次级
	public static final String CLR_CLASS_SHADINESS = "3"; // 可疑
	public static final String CLR_CLASS_LOSS = "4"; // 损失

	/**
	 * 五级分类方式
	 */
	public static final String CLR_MODE_AUTO = "1"; // 自动
	public static final String CLR_MODE_HAND = "2"; // 手工

	/**
	 * 贷款发放方式
	 */
	public static final String GRANT_MODE_ONE_OFF = "0"; // 一次性发放
	public static final String GRANT_MODE_MULTI_TIMES = "1"; // 分次发放
	public static final String GRANT_MODE_PLAN = "2"; // 按计划发放

	/**
	 * 存款类别
	 */
	public static final String DEPOSIT_SAVE_TYPE_CURRENT = "0";// 活期存款
	public static final String DEPOSIT_SAVE_TYPE_FIXED = "1";// 定期存款
	public static final String DEPOSIT_SAVE_TYPE_NOTIFY = "2";// 通知存款
	public static final String DEPOSIT_SAVE_TYPE_PROTOCOL = "3";// 协议存款

	/**
	 * 定期活期存款类别
	 */
	public static final String ACTIVE_DEPOSIT = "0";// 活期
	public static final String AIRLINER_DEPOSIT = "0";// 定期
	public static final String AIRLINER_NOTIFY_DEPOSIT = "1";// 通知
	public static final String AIRLINER_PROTOCOL = "2";// 协议

	/**
	 * 存款状态
	 */
	public static final String DEPOSIT_STATUS_NORMAL = "0";// 正常
	public static final String DEPOSIT_STATUS_CANCEL = "1";// 作废

	/**
	 * 报表种类
	 */
	public static final String REPORT_CODE_ORG_PART = "1";// 按机构划分报表
	public static final String REPORT_CODE_IBSTYPE_PART = "2";// 按授信业务种类划分报表
	public static final String REPORT_CODE_TRADE_PART = "3";// 按行业划分报表
	public static final String REPORT_CODE_LOANTYPE_PART = "4";// 按贷款种类划分报表
	public static final String REPORT_CODE_OTHERSYN_PART = "5";// 其他综合类报表
	public static final String REPORT_CODE_WARDSHIP_PART = "6";// 监管报表
	public static final String REPORT_CODE_DAILY_AND_BILL_PART = "7";// 日报及清单

	public static final int CUSTOMER_BE_CREATE = 0; // 客户状态变更的创建
	public static final int CUSTOMER_BE_DELETE = 1; // 客户状态变更的删除
	public static final int CUSTOMER_BE_FREEZE = 2; // 客户状态变更的冻结
	public static final int CUSTOMER_BE_ICEOUT = 3; // 客户状态变更的解冻
	public static final int CUSTOMER_BE_RESUME = 4; // 客户状态变更的恢复
	public static final int CUSTOMER_RELATION_CREATE = 0; // 客户关系人变更的创建
	public static final int CUSTOMER_RELATION_DELETE = 1; // 客户关系人变更的删除
	public static final int CUSTOMER_RELATION_MODIFY = 2; // 客户关系人变更的修改

	/**
	 * 客户不良信息
	 */
	public static final int CUST_INFRACT_NO = 4; // 客户不良信息序号

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
	public static final String INVOKE_KEY_LOANINT = "loanint"; // 放款完整性规则

	/*
	 * 规则服务刷新模式
	 */
	public static final int RULE_REFRESH_IMMDIATE = 0; // 0-即时生效
	public static final int RULE_REFRESH_UNTILTIME = 1; // 1-到时生效

	/**
	 * 额度信息查询类型
	 */
	public static final String CREDIT_QUERY_MODE_1 = "1";// 临时
	public static final String CREDIT_QUERY_MODE_2 = "2";// 正式
	public static final String CREDIT_QUERY_MODE_3 = "3";// 历史

	/**
	 * 标志
	 */
	public static final String CREDIT_END = "1";// 额度结束

	/**
	 * 额度新建
	 */
	public static final String CREDIT_CREATE = "0"; // 额度新建

	/**
	 * 行业种类和企业性质种类 add by hyurain_yang
	 */
	public static final String TRADE_TYPE = "2";// 行业种类
	public static final String CORP_TYPE = "1";// 企业种类
	/**
	 * 企业性质种类
	 */
	public static final String CORP_TYPE_00 = "00-国有";// 00国有
	public static final String CORP_TYPE_01 = "01-集体";// 01 集体
	public static final String CORP_TYPE_02 = "02-私营";// 02 私营
	public static final String CORP_TYPE_03 = "03-个体";// 03 个体
	public static final String CORP_TYPE_04 = "04-联营";// 04 联营
	public static final String CORP_TYPE_05 = "05-股份";// 05 股份
	public static final String CORP_TYPE_06 = "06-外资";// 06 外资
	public static final String CORP_TYPE_07 = "07-港澳台";// 07 港澳台
	public static final String CORP_TYPE_08 = "08-中外合资";// 08 中外合资
	public static final String CORP_TYPE_09 = "09-中外合作";// 09 中外合作
	public static final String CORP_TYPE_10 = "10-合伙";// 10 合伙
	public static final String CORP_TYPE_11 = "11-其他";// 11 其他
	/**
	 * 行业种类
	 */
	public static final String TRADE_TYPE_00 = "00-农、林、牧、渔业";// 00农、林、牧、渔业
	public static final String TRADE_TYPE_01 = "01-采掘业";// 01采掘业
	public static final String TRADE_TYPE_02 = "02-制造业";// 02制造业
	public static final String TRADE_TYPE_03 = "03-电力、燃气及水的生产和供应业";// 03电力、燃气及水的生产和供应业
	public static final String TRADE_TYPE_04 = "04-建筑业";// 04建筑业
	public static final String TRADE_TYPE_05 = "05-交通运输、仓储和邮政业";// 05交通运输、仓储和邮政业
	public static final String TRADE_TYPE_06 = "06-信息传输、计算机服务和软件业";// 06信息传输、计算机服务和软件业
	public static final String TRADE_TYPE_07 = "07-批发和零售业";// 07批发和零售业
	public static final String TRADE_TYPE_08 = "08-住宿和餐饮业";// 08住宿和餐饮业
	public static final String TRADE_TYPE_09 = "09-金融业";// 09金融业
	public static final String TRADE_TYPE_10 = "10-房地产业";// 10房地产业
	public static final String TRADE_TYPE_11 = "11-租赁和商务服务业";// 11租赁和商务服务业
	public static final String TRADE_TYPE_12 = "12-科学研究、技术服务业和地质勘察业";// 12科学研究、技术服务业和地质勘察业
	public static final String TRADE_TYPE_13 = "13-水利、环境和公共设施管理业";// 13水利、环境和公共设施管理业
	public static final String TRADE_TYPE_14 = "14-居民服务和其他服务业";// 14居民服务和其他服务业
	public static final String TRADE_TYPE_15 = "15-教育";// 15教育
	public static final String TRADE_TYPE_16 = "16-卫生、社会保障和社会福利业";// 16卫生、社会保障和社会福利业
	public static final String TRADE_TYPE_17 = "17-文化、体育和娱乐业";// 17文化、体育和娱乐业
	public static final String TRADE_TYPE_18 = "18-公共管理和社会组织";// 18公共管理和社会组织
	public static final String TRADE_TYPE_19 = "19-国际组织";// 19国际组织
	public static final String TRADE_TYPE_20 = "20-未知";// 20未知
	/**
	 * 贷款卡片---流动资金贷款余额
	 */
	public static final String FLOW_FINANC_LOAN_BAL = "P2101";// 流动资金贷款余额
	/**
	 * 行业门类
	 */

	public static final String TRADE_TYPE_A = "A";// 00农、林、牧、渔业
	public static final String TRADE_TYPE_B = "B";// 01采掘业
	public static final String TRADE_TYPE_C = "C";// 02制造业
	public static final String TRADE_TYPE_D = "D";// 03电力、燃气及水的生产和供应业
	public static final String TRADE_TYPE_E = "E";// 04建筑业
	public static final String TRADE_TYPE_F = "F";// 05交通运输、仓储和邮政业
	public static final String TRADE_TYPE_G = "G";// 06信息传输、计算机服务和软件业
	public static final String TRADE_TYPE_H = "H";// 07批发和零售业
	public static final String TRADE_TYPE_I = "I";// 08住宿和餐饮业
	public static final String TRADE_TYPE_J = "J";// 09金融业
	public static final String TRADE_TYPE_K = "K";// 10房地产业
	public static final String TRADE_TYPE_L = "L";// 11租赁和商务服务业
	public static final String TRADE_TYPE_M = "M";// 12科学研究、技术服务业和地质勘察业
	public static final String TRADE_TYPE_N = "N";// 13水利、环境和公共设施管理业
	public static final String TRADE_TYPE_O = "O";// 14居民服务和其他服务业
	public static final String TRADE_TYPE_P = "P";// 15教育
	public static final String TRADE_TYPE_Q = "Q";// 16卫生、社会保障和社会福利业
	public static final String TRADE_TYPE_R = "R";// 17文化、体育和娱乐业
	public static final String TRADE_TYPE_S = "S";// 18公共管理和社会组织
	public static final String TRADE_TYPE_T = "T";// 19国际组织
	public static final String TRADE_TYPE_U = "U";// 20未知

	/**
	 * 贷款卡片状态
	 */
	public static final String LOAN_CARD_STATUS_0 = "0";// 正常
	public static final String LOAN_CARD_STATUS_1 = "1";// 作废
	public static final String LOAN_CARD_STATUS_2 = "2";// 洁清

	public static final String FILE_PATH = "/home/finfo_t/upload";

	public static final String SCCBA_FILE_PATH = "SCCBA_FILE_PATH";

	//public static final String SCCBA_FILE_PATH = "/home/sccba/finfo_t/upload/sccba";

	/**
	 * 根据新规则生成合同号和从合同号时所用的机构号
	 */
	public static final String CONTRACT_NO_BRNO = "010";// 机构号为合同签署机构代号，由3位阿拉伯数字组成，为010

	/**
	 * 生成合同号时的顺序号
	 */
	public static final int SEQCTL_VALUE_NO_CONTRACT = 601;

	/**
	 * 生成从合同号时的顺序号
	 */
	public static final int SEQCTL_VALUE_NO_ACONTRACT = 602;

	/**
	 * 工作流中用了区分个贷和信贷的。
	 */
	public static final String SYSTYPE_LONSYSWEB = "1";
	public static final String SYSTYPE_PLONSYSWEB ="2";

	/**
	 * 授信涉及到的数据字典
	 */

	public static final String CREDIT_NO_NAME = "无授信";

	public static final String CREDIT_PRODUCTYPE_S = "S"; // 专项授信
	public static final String CREDIT_PRODUCTYPE_C = "C"; // 综合授信

	/**
	 * 是否结清
	 */
	public static final String CLRGLG_OFF = "0"; // 否
	public static final String CLRGLG_ON = "1"; // 是

	public static final String FREEZE_FLAG_HANDFREEZE = "2"; // 手工冻结

	/**
	 * 联机文件下载临时存放目录
	 */
	public final static String FILE_PATH_ONLINE_TMP = "filedownload.temp.path";

	/**
	 * 核心系统合同号长度
	 */
	public static final int CONTRACTNO_LENGTH = 15;

	// seqctl中的value_no
	public static final int VALUE_NO_BLACKNO = 44; // 黑名单客户编号
	public static final int VALUE_NO_QUESTION_NO = 11; // 问题编号
	public static final int VALUE_NO_GRADE_NO = 91; // 评分编号

	// 评分模型号常量
	public static final String GRADE_NO = "GRADE_NO";

	/**
	 * 性别
	 */
	public static final String MALE = "0";// 男
	public static final String FEMALE = "1";// 女

	/**
	 * 机构级别_成商
	 */

	public static final String CS_BRCODE_CLASS_HEAD = "1"; // 总行

	/**
	 * 管理机构级别
	 */
	public static final String MANAGE_BRCODE_CLASS_HEAD = "0"; // 总行
	public static final String MANAGE_BRCODE_CLASS_BRANCH = "1"; // 分行
	public static final String MANAGE_BRCODE_CLASS_SUBBRANCH = "2"; // 支行

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
	 * 黑名单客户类型
	 */
	public static final String BLACK_TYPE_NATURAL = "1"; // 1个人客户
	public static final String BLACK_TYPE_ARTIFICIAL = "2"; // 2法人客户
	/**
	 * 黑名单关注级别
	 */
	public static final String BLACK_LEVEL_NORMAL = "1"; // 1-正常级别
	public static final String BLACK_LEVEL_SERIOUS = "2"; // 2-严重级别

	/**
	 * 合作项目额度控制方式不限下的默认金额
	 */
	public static final double UNLIMITED_PROJ_LOAN_LIMIT = 9.99999999999999E11;

	/**
	 * 贷款大类
	 */
	public static final String LNTYPE_HOUSE = "001"; // 个人一手房购房贷款
	public static final String LNTYPE_SECONDHAND_HOUSE = "002"; // 个人二手房购房贷款
	public static final String LNTYPE_BIZ_HOUSE = "003"; // 个人商业用房抵押贷款，广州银行为：一手商业用房按揭贷款
	public static final String LNTYPE_SECONDHAND_BIZ_HOUSE = "102";//二手商业用房按揭贷款
	public static final String LNTYPE_AUTO = "004"; // 个人汽车贷款
	public static final String LNTYPE_CONSUMABLE = "005"; // 个人消费贷款
	public static final String LNTYPE_PAY_HOUSE = "021"; // 个人赎楼贷款
	public static final String LNTYPE_TRIPLOAN = "103";//个人旅游贷款
	public static final String LNTYPE_DECORATE = "104";//个人装修贷款
	public static final String LNTYPE_WORKING = "006"; // 个人生产经营贷款
	public static final String LNTYPE_LAIDOFF_WORKERS = "105";//下岗职工小额担保贷款
	public static final String LNTYPE_BANKBOOK_IMPAWN = "010"; // 个人存单质押贷款
	public static final String LNTYPE_NATIONAL_DEBT_IMPAWN = "011"; // 个人国债质押贷款
	public static final String LNTYPE_OFFICIAL = "106";//公务员贷款
	public static final String LNTYPE_ACCUM_FUND = "100"; // 公积金贷款
	public static final String LNTYPE_ENTRUST = "101";//个人委托贷款

	//以下贷款大类，广州银行暂时未开通
	public static final String LNTYPE_EDUCATION = "007"; // 个人助学贷款
	public static final String LNTYPE_EDUCATION_SH = "008"; // 个人助学贷款(上海教委担保)
	public static final String LNTYPE_STUDY_ABROAD = "009"; // 个人留学贷款
	public static final String LNTYPE_GUARANTEE_SLIP_IMPAWN = "012"; //个人保单质押贷款
	public static final String LNTYPE_FX_IMPAWN = "013"; // 个人外汇宝质押贷款
	public static final String LNTYPE_SECURITIES_IMPAWN = "014"; //个人有价单证质押贷款
	public static final String LNTYPE_OTHER_IMPAWN = "015"; // 个人其他财产抵、质押贷款
	public static final String LNTYPE_OCCUPATION_FUND_ASSURE = "016"; //就业基金担保贷款
	public static final String LNTYPE_CASH_HOUSE_MORTAGAGE = "017"; //商品房抵押贷款
	public static final String LNTYPE_NATIONAL_CREDIT = "018"; // 个人信用贷款
	public static final String LNTYPE_LOANCARD_CREDIT = "019"; // 房贷信用卡贷款
	public static final String LNTYPE_HOUSE_ADD = "020"; // 加按贷款


	/**
	 * 合作项目测试标志,True时不调用工作流,False时调用工作流, 工作流开发完成后需改成False
	 */
	public static boolean CORP_PROJ_TEST_DEBUG = true;

	public static final String ROLE_TYPE_CHECK = "2"; // 复核岗(广发新增)

	/**
	 * 贷款大类(荆州)
	 */
	public static final String LNTYPE_001 = "001"; // 住房公积金委托贷款
	public static final String LNTYPE_003 = "003"; // 个人住房贷款
	public static final String LNTYPE_004 = "004"; // 员工住房贷款
	public static final String LNTYPE_005 = "005"; // 个人商用房贷款
	public static final String LNTYPE_006 = "006"; // 个人二手住房贷款
	public static final String LNTYPE_007 = "007"; // 个人二手商用房贷款
	public static final String LNTYPE_008 = "008"; // 个人住房装修贷款
	public static final String LNTYPE_009 = "009"; // 个人商用房装修贷款
	public static final String LNTYPE_011 = "011"; // 个人固定利率住房贷款
	public static final String LNTYPE_013 = "013"; // 个人汽车消费贷款
	public static final String LNTYPE_016 = "016"; // 旅游贷款
	public static final String LNTYPE_018 = "018"; // 下岗失业人员小额担保贷款
	public static final String LNTYPE_019 = "019"; // 大额耐用消费品贷款
	public static final String LNTYPE_020 = "020"; // 个人经营（创业）贷款
	public static final String LNTYPE_021 = "021"; // 个人其他贷款
	public static final String LNTYPE_022 = "022"; // 授信额度贷款
	public static final String LNTYPE_999 = "999"; // 个人授信额度

	/**
	 * 贷款大类
	 */
	public static final String LNTYPE_HOUSE_CH = "个人一手房购房贷款"; // 个人一手房购房贷款
	public static final String LNTYPE_SECONDHAND_HOUSE_CH = "个人二手房购房贷款"; // 个人二手房购房贷款
	public static final String LNTYPE_BIZ_HOUSE_CH = "个人商业用房抵押贷款"; // 个人商业用房抵押贷款
	public static final String LNTYPE_AUTO_CH = "个人汽车贷款"; // 个人汽车贷款
	public static final String LNTYPE_CONSUMABLE_CH = "个人消费贷款"; // 个人消费贷款
	public static final String LNTYPE_WORKING_CH = "个人生产经营贷款"; // 个人生产经营贷款
	public static final String LNTYPE_EDUCATION_CH = "个人助学贷款"; // 个人助学贷款
	public static final String LNTYPE_EDUCATION_SH_CH = "个人助学贷款(上海教委担保)"; // 个人助学贷款(上海教委担保)
	public static final String LNTYPE_STUDY_ABROAD_CH = "个人留学贷款"; // 个人留学贷款
	public static final String LNTYPE_BANKBOOK_IMPAWN_CH = "个人存单质押贷款"; // 个人存单质押贷款
	public static final String LNTYPE_NATIONAL_DEBT_IMPAWN_CH = "个人国债质押贷款"; // 个人国债质押贷款
	public static final String LNTYPE_GUARANTEE_SLIP_IMPAWN_CH = "个人保单质押贷款"; // 个人保单质押贷款
	public static final String LNTYPE_FX_IMPAWN_CH = "个人外汇宝质押贷款"; // 个人外汇宝质押贷款
	public static final String LNTYPE_SECURITIES_IMPAWN_CH = "个人有价单证质押贷款"; // 个人有价单证质押贷款
	public static final String LNTYPE_OTHER_IMPAWN_CH = "个人其他财产抵、质押贷款"; // 个人其他财产抵、质押贷款
	public static final String LNTYPE_OCCUPATION_FUND_ASSURE_CH = "就业基金担保贷款"; // 就业基金担保贷款
	public static final String LNTYPE_CASH_HOUSE_MORTAGAGE_CH = "商品房抵押贷款"; // 商品房抵押贷款
	public static final String LNTYPE_NATIONAL_CREDIT_CH = "个人信用贷款"; // 个人信用贷款
	public static final String LNTYPE_LOANCARD_CREDIT_CH = "房贷信用卡贷款	"; // 房贷信用卡贷款
	public static final String LNTYPE_HOUSE_ADD_CH = "加按贷款"; // 加按贷款
	public static final String LNTYPE_PAY_HOUSE_CH = "赎楼贷款"; // 赎楼贷款
	public static final String LNTYPE_ACCUM_FUND_CH = "公积金贷款"; // 公积金贷款
	public static final String LNTYPE_CARD_CH = "轻松智业卡授信额度"; // 轻松智业卡授信额度
	public static final String LNTYPE_CREDIT_CH = "个人授信额度"; // 个人授信额度

	public static final String LNTYPE_010 = "010"; // 个人信用消费信贷
	/**
	 * 贷款小类
	 */
	public static final String LNID_CREDIT_3_MONTH = "110101"; // 个人信用消费信贷-3月期
	public static final String LNID_CREDIT_6_MONTH = "110201"; // 个人信用消费信贷-6月期
	public static final String LNID_CREDIT_1_YEAR = "110301"; // 个人信用消费信贷-1年期
	public static final String LNID_CREDIT_LOAN = "101003";	//个人消费信贷

	/**
	 * 用于参数设置和统计分析
	 */
	public static final String LNTYPE_ALL = "000"; // 不限
	public static final String LNID_ALL = "000000"; // 不限
	public static final String LNTYPE_HOUSE_CREDIT = "888"; // 房贷授信
	public static final String LNTYPE_CREDIT = "999"; // 授信贷款
	public static final String LNID_CREDIT = "999999"; // 授信贷款
	public static final String LNTYPE_CARD = "888888"; // 房贷授信贷款

	/**
	 * 贷款性质
	 */
	public static final String LOAN_ATTR_ALL = "0"; // 所有
	public static final String LOAN_ATTR_CONSUMABLE = "1"; // 消费类贷款
	public static final String LOAN_ATTR_WORKING = "2"; // 经营类贷款

	/**
	 * 贷款类型
	 */
	public static final String LNTYPE_NATURE_OTHER = "0"; // 其它
	public static final String LNTYPE_NATURE_HOUSE = "1"; // 购房贷款
	public static final String LNTYPE_NATURE_AUTO = "2"; // 汽车贷款
	public static final String LNTYPE_NATURE_CONSUMABLE = "3"; // 消费贷款
	public static final String LNTYPE_NATURE_EDU = "4"; // 助学贷款
	public static final String LNTYPE_NATURE_WORKING = "5"; // 生产经营贷款
	public static final String LNTYPE_NATURE_TOUR = "6"; // 旅游贷款
	/**
	 * 合同性质
	 */
	public static final String LOAN_NATURE_NORMAL = "1"; // 一般贷款合同
	public static final String LOAN_NATURE_COMB = "2"; // 组合贷款合同
	public static final String LOAN_NATURE_ADD = "3"; // 加按贷款合同
	public static final String LOAN_NATURE_CREDIT = "4"; // 授信贷款合同
	public static final String LOAN_NATURE_CREDIT_EXT_LOAN = "5"; // 授信借款合同
	public static final String LOAN_NATURE_CREDIT_DIR_USE = "6"; // 授信直接出款合同

	/**
	 * 申请审批状态/合同状态
	 */
	public static final String APPSTAT_INPUTED = "0"; // 已录入
	public static final String APPSTAT_SENDED = "1"; // 已上传
	public static final String APPSTAT_AUDITED = "2"; // 审批中
	public static final String APPSTAT_APPROVED = "3"; // 已审批
	public static final String APPSTAT_REJECTED = "4"; // 已拒绝
	public static final String APPSTAT_FINAL_APPROVED = "5"; // 放款监督已确认
	public static final String APPSTAT_GRANTED = "6"; // 已会计入账
	public static final String APPSTAT_RETRACTED = "7"; // 已撤销发放
	public static final String APPSTAT_SIGNCONT = "8"; // 已签订合同 //shijie.zhu add
	public static final String APPSTAT_CANCEL = "9"; // 已取消申请
	public static final String APPSTAT_GRANT_APPROVING = "A"; // 出账审批中
	public static final String APPSTAT_GRANT_APPROVED = "B"; // 出账审批通过

	/**
	 * 贷款形态
	 */
	public static final String TRM_CLASS_NORMAL = "0"; // 正常
	public static final String TRM_CLASS_OVERDUE = "1"; // 逾期
	public static final String TRM_CLASS_IDLE = "2"; // 呆滞
	public static final String TRM_CLASS_BAD = "3"; // 呆帐
	public static final String TRM_CLASS_CLOSE = "4"; // 结清
	public static final String TRM_CLASS_LOSS = "5"; // 核销 //update by
														// wuzhiwei 2008-8-19

	/**
	 * 贷款形态(贷款销户交易）
	 */
	public static final String LOANDELACCOUNT_TRM_CLASS_NORMAL = "正常"; // 正常
	public static final String LOANDELACCOUNT_TRM_CLASS_OVERDUE = "逾期"; // 逾期
	public static final String LOANDELACCOUNT_TRM_CLASS_IDLE = "呆滞"; // 呆滞
	public static final String LOANDELACCOUNT_TRM_CLASS_BAD = "呆帐"; // 呆帐
	public static final String LOANDELACCOUNT_TRM_CLASS_CLOSE = "结清"; // 结清

	/**
	 * 贷款期供状态(贷款期供期供表交易)
	 */
	public static final String LOAN_LNPLANMR_NORMAL = "1"; // 正常
	public static final String LOAN_LNPLANMR_OVERDUE = "2"; // 逾期
	public static final String LOAN_LNPLANMR_IDLE = "3"; // 非应计


	//广州个贷核算的还款方式常量和管理的还款方式常量统一
	// 还款方式
	public static final String RTN_ONE_INT = "1"; //  利随本清(一次还本付息)
	public static final String RTN_TYPE_ONE_OFF = "2"; // 一次还本多次还息
	public static final String RTN_TYPE_BALINT_EQUAL = "3"; // 等额本息还款
	public static final String RTN_TYPE_BAL_EQUAL = "4"; // 等额本金还款
	public static final String RTN_TYPE_TIMES_INT = "5"; // 多次还息多次还本
	public static final String RTN_TYPE_BALLOON = "7"; //气球贷还款

	public static final String RTN_TYPE_INCREASE = "H"; // 等额递增还款
	public static final String RTN_TYPE_DESCENDING = "I"; // 等额递减还款
	public static final String RTN_TYPE_BAL_EQUAL_AD = "G"; // 利随本清
	public static final String RTN_TYPE_PHASE = "8"; // 阶段还款方式
	public static final String RTN_PRM_TYPE_INCREASE = "9"; // 等额本息递增
	public static final String RTN_PRM_TYPE_DESCENDING = "A"; // 等额本息递减
	public static final String RTN_BAV_TYPE_INCREASE = "B"; // 等比本金递增
	public static final String RTN_BAV_TYPE_DESCENDING = "C"; // 等比本金递减
	public static final String RTN_TYPE_ELASTIC = "E"; //灵活还款
	public static final String RTN_TYPE_FEE = "F"; //手续费还款


	/**
	 * 消费信贷分摊方式
	 */
	public static final String CONSUMER_CREDIT_TYPE_BUSI = "0"; // 商户全额分摊
	public static final String CONSUMER_CREDIT_TYPE_CUST = "1"; // 客户全额分摊
	public static final String CONSUMER_CREDIT_TYPE_PROTOCOL = "2"; // 协议分摊


	/**
	 * 组合还款还款方式
	 */
	public static final String RTN_TYPE_PHASE_BAL_EQUAL = "2"; // 等额本金还款
	public static final String RTN_TYPE_PHASE_BALINT_EQUAL = "1"; // 等额本息还款
	public static final String RTN_TYPE_PHASE_TIMES = "3"; // 分期付息
	public static final String RTN_TYPE_PHASE_TIMES_INT = "4"; // 分期付息一次还本
	public static final String RTN_TYPE_PHASE_BAL_FIXED = "5"; // 固定本金还款方式

	/**
	 * 不等额方式
	 */
	public static final String NON_EQUAL_MODE_FIRST_RTN = "1"; // 指定首期还款金额
	public static final String NON_EQUAL_MODE_PER_INCREASE = "2"; // 指定每期递增/减金额

	/**
	 * 还款途径
	 */
	public static final String RTN_MODE_CARD = "0"; // 东方卡
	public static final String RTN_MODE_PASSBOOK = "1"; // 一本通
	public static final String RTN_MODE_BANKBOOK = "2"; // 存折
	public static final String RTN_MODE_NON = "3"; // 暂无

	public static final String RTN_MODE_BANK_CARD = "1"; // 银行卡卡
	public static final String RTN_MODE_BANK_BOOK = "2"; // 存折

	/**
	 * 还款日期确定方式
	 */
	public static final String RTN_DATE_TYPE_ISDATE = "0"; // 借款日为还款日
	public static final String RTN_DATE_TYPE_SPECIFY = "1"; // 指定还款日期

	/**
	 * 扣款日默认日期
	 */
	public static final int RTN_DATE_DEFAULT_DATE = 20; // 默认每月20号为扣款日

	/**
	 * 默认出款有效期默认值
	 */
	public static final String GRANT_DURATION = "6";// 默认出款有效期,6个月

	/**
	 * 手续费收取方式
	 */
	public static final String FEETYPE_FETCH_MODE_NO = "0";// 不收取
	public static final String FEETYPE_FETCH_MODE_AMT = "1";// 按金额收取
	public static final String FEETYPE_FETCH_MODE_RATIO = "2";// 按比率收取

	/**
	 * 宽限期控制方式
	 */
	public static final String DOGTYPE_CTL_NO = "0";// 无宽限期
	public static final String DOGTYPE_CTL_DATE = "1";// 按日方式

	/**
	 * 贷款期限控制类型
	 */
	public static final String TERMTYPE_YEAR = "0";// 按年
	public static final String TERMTYPE_MONTH = "1";// 按月
	public static final String TERMTYPE_DATE = "2";// 按天


	/**
	 * 阶段还款标志
	 */
	public static final String PHASE_FLAG_OFF = "0"; // 非阶段还款
	public static final String PHASE_FLAG_ON = "1"; // 阶段还款

	/**
	 * 利率调整方式
	 */
	public static final String INT_ADJ_FIXED = "0"; // 固定利率
	public static final String INT_ADJ_MONTHLY = "1"; // 按月调整
	public static final String INT_ADJ_SEASON = "2"; // 按季调整
	public static final String INT_ADJ_YEARLY = "3"; // 按年调整
	public static final String INT_ADJ_YEAR_DATE = "4"; // 一年一调
	public static final String INT_ADJ_INT_DATE = "5"; // 结息日
	public static final String INT_ADJ_HALFYEAR = "6"; // 按半年

	/**
	 * 罚息浮动选项
	 */
	public static final String PUN_INT_OPT_FIXED = "0"; // 固定罚息率
	public static final String PUN_INT_OPT_FLOAT = "1"; // 按合同利率浮动

	/**
	 * 划款方向
	 */
	public static final String PAY_DIRECT_INDV = "0"; // 收款人为借款人
	public static final String PAY_DIRECT_COOP = "1"; // 合作商
	public static final String PAY_DIRECT_INNER = "2"; // 指定帐号
	public static final String PAY_DIRECT_OTHER = "3"; // 其他帐号

	/**
	 * 公积金冲还贷方式
	 */
	public static final String FUND_REPAY_MODE_ONE_OFF = "1"; // 一次性还贷法
	public static final String FUND_REPAY_MODE_MONTHLY = "2"; // 逐月还贷法

	/**
	 * 公积金冲还贷月份
	 */
	public static final String FUND_REPAY_MONTH_APRIL = "1"; // 4月份
	public static final String FUND_REPAY_MONTH_SEPTEMBER = "2"; // 9月份

	/**
	 * 按位表示的担保方式，每个下标位置所表示的担保方式
	 */
	public static final int GUATTYPE_SUBSCRIPT_CREDIT = 0; // 信用
	public static final int GUATTYPE_SUBSCRIPT_ASSURE = 1; // 保证
	public static final int GUATTYPE_SUBSCRIPT_MORTAGAGE = 2; // 抵押
	public static final int GUATTYPE_SUBSCRIPT_IMPAWN = 3; // 质押
	public static final int GUATTYPE_SUBSCRIPT_INSURANCE = 4; // 履约保险

	/**
	 * 担保方式
	 */
	public static final String GUATCODE_IMPAWN = "1"; // 质押
	public static final String GUATCODE_MORTAGAGE = "2"; // 抵押
	public static final String GUATCODE_ASSURE = "3"; // 保证
	public static final String GUATCODE_CREDIT = "4"; // 信用/免担保
	public static final String GUATCODE_COMBINED_INC_ASSURE = "5"; // 组合(含保证)
	public static final String GUATCODE_COMBINED_EX_ASSURE = "6"; // 组合(不含保证)
	public static final String GUATCODE_INSURANCE = "7"; // 履约保险
	public static final String GUATCODE_OTHER = "9"; // 其它

	public static final String GUATCODE_ALL = "0"; // 不限

	/**
	 * 贷款期限类型
	 */
	public static final String LOAN_TERM_TYPE_SHORT = "1"; // 短期贷款
	public static final String LOAN_TERM_TYPE_MEDIUM = "2"; // 中期贷款
	public static final String LOAN_TERM_TYPE_LONG = "3"; // 长期贷款

	/**
	 * 客户帐单寄送地址
	 */
	public static final String BILL_MAIL_ADDR_FAMILY = "1"; // 家庭地址
	public static final String BILL_MAIL_ADDR_COMPANY = "2"; // 单位地址
	public static final String BILL_MAIL_ADDR_CONTACT1 = "3"; // 联系地址1
	public static final String BILL_MAIL_ADDR_CONTACT2 = "4"; // 联系地址2
	public static final String BILL_MAIL_ADDR_CONTACT3 = "5"; // 联系地址3

	/**
	 * 助学贷款放款计划发放状态
	 */
	public static final String LOAN_PLAN_STATUS_UNGRANT = "0"; // 未发放
	public static final String LOAN_PLAN_STATUS_GRANTED = "1"; // 已发放
	public static final String LOAN_PLAN_STATUS_TERMINATED = "2"; // 已终止发放

	/**
	 * 助学贷款分类
	 */
	public static final String EDU_LOAN_TYPE_NONE = "0"; // 不分类
	public static final String EDU_LOAN_TYPE_TUITION = "1"; // 学费
	public static final String EDU_LOAN_TYPE_ALIMONY = "2"; // 生活费

	/**
	 * 房屋状况
	 */
	public static final String HOUSE_STAT_SPOT = "10"; // 现房
	public static final String HOUSE_STAT_FUTURES = "20"; // 预售房
	public static final String HOUSE_STAT_OTHER = "99"; // 其他

	/**
	 * 抵押物大类
	 */
	public static final String MORT_CLASS_ESTATE = "1"; // 房产
	public static final String MORT_CLASS_CHATTEL = "2"; // 动产
	public static final String MORT_CLASS_OTHER = "3"; // 其他

	/**
	 * 抵押物类型
	 */
	public static final String MORT_TYPE_HOUSE = "1"; // 住房
	public static final String MORT_TYPE_WORKING_HOUSE = "2"; // 写字楼
	public static final String MORT_TYPE_BIZ_HOUSE = "3"; // 商铺
	public static final String MORT_TYPE_CHATTEL = "4"; // 动产
	public static final String MORT_TYPE_OTHER = "5"; // 其他

	/**
	 * 质物种类
	 */
	public static final String IMPAWN_TYPE_BANKBOOK = "1"; // 存单
	public static final String IMPAWN_TYPE_STOCK = "2"; // 股票
	public static final String IMPAWN_TYPE_GUARANTEE_SLIP = "3"; // 保单
	public static final String IMPAWN_TYPE_POSTBOOK = "4"; // 邮储存单
	public static final String IMPAWN_TYPE_OTHER_BANKBOOK = "5"; // 他行存单
	public static final String IMPAWN_TYPE_NATIONAL_DEBT = "6"; // 凭证式国债
	public static final String IMPAWN_TYPE_REGISTERED_RIGHTS = "7"; // 记名式金融债权
	public static final String IMPAWN_TYPE_OTHER_SECURITIES = "8"; // 其它有价证券

	/**
	 * 额度冻结状态
	 */
	public static final String FREZ_STATUS_NORMAL = "0"; // 正常
	public static final String FREZ_STATUS_FREZ = "1"; // 冻结
	/**
	 * 额度冻结操作
	 */
	public static final String FREZ_OPR_THAW = "0"; // 解冻
	public static final String FREZ_OPR_FREZ = "1"; // 冻结

	/**
	 * 档案状态
	 */
	public static final String DOC_STATE_REGISTER = "1"; // 已登记
	public static final String DOC_STATE_STORAGE = "2"; // 已入库
	public static final String DOC_STATE_DRAW = "3"; // 已出库
	public static final String DOC_STATE_DESTROY = "4"; // 已销毁

	/**
	 * 权利品状态
	 */
	public static final String GUA_STATE_SORT = "1"; // 已建档
	public static final String GUA_STATE_STORAGE = "2"; // 已入库
	public static final String GUA_STATE_APPLY_DRAW = "3"; // 已申请领取
	public static final String GUA_STATE_DRAW = "4"; // 已出库

	/**
	 * 公证状态
	 */
	public static final String NOTARIZATION_STATUS_UNDONE = "0"; // 未办理
	public static final String NOTARIZATION_STATUS_PROCESSING = "1"; // 办理中
	public static final String NOTARIZATION_STATUS_DONE = "2"; // 已公证

	/**
	 * 抵押状态
	 */
	public static final String MORTAGAGE_STATUS_UNDONE = "0"; // 未办理
	public static final String MORTAGAGE_STATUS_PROCESSING = "1"; // 办理抵押中
	public static final String MORTAGAGE_STATUS_PREPARE = "2"; // 期房抵押(预抵押)
	public static final String MORTAGAGE_STATUS_DONE = "3"; // 已抵押
	public static final String MORTAGAGE_STATUS_INVALID = "4"; // 失效

	/**
	 * 保险状态
	 */
	public static final String INSURANCE_STATUS_UNDONE = "0"; // 未办理
	public static final String INSURANCE_STATUS_DONE = "1"; // 已保险

	/**
	 * 核心帐户状态
	 */
	public static final String ACCOUNT_STATUS_VALID = "0"; // 正常
	public static final String ACCOUNT_STATUS_INVALID = "1"; // 不正常

	/**
	 * 处置状态
	 */
	public static final String PROCESS_STATUS_NORMAL = "0"; // 正常
	public static final String PROCESS_STATUS_MGR_PROCESS = "1"; // 审批移交
	public static final String PROCESS_STATUS_CUST_PROCESS = "2"; // 客户移交

	/**
	 * 处置状态_成商
	 */
	public static final String PROCESS_STATUS_CS_NORMAL = "0"; // 正常
	public static final String PROCESS_STATUS_CS_PROCESS = "1"; // 移交
	/**
	 * 贷款交易明细类型
	 */
	public static final String LNHTR_TXTYPE_GRANT = "1"; // 放款
	public static final String LNHTR_TXTYPE_RTN = "2"; // 还款
	public static final String LNHTR_TXTYPE_TRM = "3"; // 形态转换
	public static final String LNHTR_TXTYPE_CLR = "4"; // 五级分类
	public static final String LNHTR_TXTYPE_ALTER = "5"; // 贷后变更
	// add by zxyue 2008-11-07
	public static final String LNHTR_TXTYPE_ASSET = "6";// 资产保全

	/**
	 * 贷款结清类型/还款类型
	 */
	public static final String CLOSE_TYPE_ADVANCE = "1"; // 提前结清/提前还款
	public static final String CLOSE_TYPE_ONTIME = "2"; // 按时结清/按时还款
	public static final String CLOSE_TYPE_OVERDUE = "3"; // 逾期结清/逾期还款
	public static final String CLOSE_TYPE_LOSS = "4"; // 核销
	public static final String CLOSE_TYPE_TRANSFER = "5"; // 转呆滞/呆帐
	public static final String CLOSE_TYPE_OTHER = "6"; // 其它情况的终止/其它情况的还款

	/**
	 * 提前还款方式
	 */
	public static final String RTN_FLAG_BAL = "1"; // 部分提前还款
	public static final String RTN_FLAG_PERI = "2"; // 全部提前还款

	/**
	 * 催收方式
	 */
	public static final String DUN_MODE_PHONE = "1"; // 电话
	public static final String DUN_MODE_MAIL = "2"; // 信函
	public static final String DUN_MODE_MAIL_AND_DROP_IN = "3"; // 信函和上门
	public static final String DUN_MODE_DROP_IN = "4"; // 上门
	public static final String DUN_MODE_NOTE = "5"; // 短信
	public static final String DUN_MODE_EMAIL = "6"; // Email
	public static final String DUN_MODE_LAW_MAIL = "7"; // 律师函
	public static final String DUN_MODE_OTHER = "8"; // 其它

	/**
	 * 保单类型
	 */
	public static final String INSURE_TYPE_ESTATE = "1"; // 财产保险
	public static final String INSURE_TYPE_ASSUMPSIT = "2"; // 履约保险

	/**
	 * 审批意见退回标志
	 */
	public static final String APPLYDTL_UNTREAD_NO = "0"; // 未退回
	public static final String APPLYDTL_UNTREAD_YES = "1"; // 已退回
	public static final String APPLYDTL_UNTREAD_LAST = "2"; // 最近一次退回

	/**
	 * 房贷卡关联状态
	 */
	public static final String LOANCARD_STATUS_AVALID = "0"; // 无效
	public static final String LOANCARD_STATUS_VALID = "1"; // 有效
	public static final String LOANCARD_STATUS_AUTO_PAUSE = "2"; // 自动暂停
	public static final String LOANCARD_STATUS_MANUAL_PAUSE = "3"; // 手动暂停
	public static final String LOANCARD_STATUS_OVER = "4"; // 终止

	/*
	 * 申请类型
	 */
	public static final String APPTYPE_FIVECLASS_MODE = "49"; // 五级分类方式
	public static final String APPTYPE_FIVECLASS_UP = "32"; // 五级分类方式上调
	public static final String APPTYPE_FIVECLASS_DOWN = "31"; // 五级分类方式下调

	/**
	 * 数据字典项类型
	 */
	public static final int DATADIC_TYPE_LNAMT = 1; // 贷款金额
	public static final int DATADIC_TYPE_INDV_INCOME = 2; // 月收入
	public static final int DATADIC_TYPE_FAMILY_INCOME = 3; // 家庭月收入
	public static final int DATADIC_TYPE_CREDIT_GRADE = 4; // 信用等级
	public static final int DATADIC_TYPE_TERM = 5; // 贷款期限
	public static final int DATADIC_TYPE_EDU_LEVEL = 6; // 教育程度
	public static final int DATADIC_TYPE_OCCUPATION = 7; // 职业
	public static final int DATADIC_TYPE_CORP_PROPERTY = 8; // 单位性质
	public static final int DATADIC_TYPE_DUTY = 9; // 职务
	public static final int DATADIC_TYPE_TITLE = 10; // 职称
	public static final int DATADIC_TYPE_MARRIAGE = 11; // 婚姻状况
	public static final int DATADIC_TYPE_SEX = 12; // 性别
	public static final int DATADIC_TYPE_HUKOU_TYPE = 13; // 户籍性质
	public static final int DATADIC_TYPE_GUATTYPE = 14; // 担保方式
	public static final int DATADIC_TYPE_RTN_TYPE = 16; // 还款方式
	public static final int DATADIC_TYPE_RTN_INTERVAL = 17; // 还款间隔
	public static final int DATADIC_TYPE_RTN_DATE_TYPE = 18; // 还款日期确定方式
	public static final int DATADIC_TYPE_TRM_CLASS = 19; // 贷款状态(一逾两呆)
	public static final int DATADIC_TYPE_OVD_DAYS_STAT = 20; // 逾期天数状态
	public static final int DATADIC_TYPE_PHASE_RTN_TYPE = 21; // 组合还款还款方式
	public static final int DATADIC_TYPE_RTN_MODE = 19001; // 还款途径
	public static final int DATADIC_TYPE_CLIENT_ANLS_CONTENT = 23; // 客户分析指标
	public static final int DATADIC_TYPE_CLIENT_MODE_CONTENT = 24; // 客户分类指标
	public static final int DATADIC_TYPE_PHASENO = 25; // 阶段还款可用的最大阶段数
	public static final int DATADIC_TYPE_CERTIFICATE_IDTYPE = 29; // 法人证件类型
	public static final int DATADIC_TYPE_INDV_IDTYPE = 30; // 个人证件类型
	public static final int DATADIC_TYPE_PROJECT_TYPE = 31; // 合作项目类型
	public static final int DATADIC_TYPE_CLR_MODE = 34; // 五级分类方式
	public static final int DATADIC_TYPE_CLR_CLASS = 35; // 五级分类
	public static final int DATADIC_TYPE_HOUSE_STAT = 36; // 房屋状态
	public static final int DATADIC_TYPE_INT_ADJ_TPYE = 43; // 利率调整方式
	public static final int DATADIC_TYPE_LIMIT_TYPE = 51; // 操作员审批类型
	public static final int DATADIC_TYPE_PROCESS_STATUS = 53; // 处置状态
	public static final int DATADIC_TYPE_ADV_RTN_FLAG = 54; // 提前还款方式
	// public static final int DATADIC_TYPE_LNCARD_OVERDRAFT = 60; //房贷卡透支取现比率
	public static final int DATADIC_TYPE_LNCARD_MAXBAL = 61; // 房贷信用卡贷款授信最高额度
	// public static final int DATADIC_TYPE_LNCARD_FLOAT_RATIO = 62;
	// //房贷卡授信总额度特殊日期浮动比率
	public static final int DATADIC_TYPE_LNCARD_MAXOVD_RATIO = 63; // 房贷信用卡贷款允许的最高划转比率
	// public static final int DATADIC_TYPE_LNCARD_CUSTCD_MAXAMT = 64;
	// //房贷授信允许的最高划转额度
	public static final int DATADIC_TYPE_LNCARD_TEDATE_XFYC = 65; // 房贷卡消费到期日与授信到期日月差
	public static final int DATADIC_TYPE_LNCARD_MINAMOUNT = 66; // 房贷卡授信额度发放基数
	public static final int DATADIC_TYPE_CUST_MAX_AMOUNT = 67; // 客户单户最高使用额度
	public static final int DATADIC_TYPE_LNTYPE_MAX_AMOUNT = 68; // 客户单户最高使用额度检查涉及的贷款大类
	public static final int DATADIC_TYPE_DUN_CONTACTER = 69; // 逾期贷款催收联系人
	public static final int DATADIC_TYPE_DUN_REASON = 70; // 逾期违约的原因
	public static final int DATADIC_TYPE_DUN_RESULT = 71; // 催收处理结果
	public static final int DATADIC_TYPE_LNCARD_BASEBAL_CTRL = 72; // 智业信用卡基础额度控制
	public static final int DATADIC_TYPE_LNUSE = 100; // 贷款用途
	public static final int DATADIC_TYPE_GRANT_MODE = 101; // 发放方式
	public static final int DATADIC_TYPE_NON_EQUAL_MODE = 102; // 不等额方式
	public static final int DATADIC_TYPE_PAY_DIRECT = 103; // 划款方向
	public static final int DATADIC_TYPE_LOAN_LIMIT_FORM = 112; // 合作项目额度控制方式
	public static final int DATADIC_TYPE_LNATTR = 116; // 贷款性质(消费类贷款、经营类贷款)
	public static final int DATADIC_TYPE_APPSTAT = 117; // 合同状态
	public static final int DATADIC_TYPE_ATTITUDE_ALL = 118; // 审批意见ALL
																// 审批表打印使用
	public static final int DATADIC_TYPE_ATTITUDE = 120; // 审批意见
	public static final int DATADIC_TYPE_ATTITUDE1 = 121; // 贷后审批意见
	public static final int DATADIC_TYPE_ATTITUDE2 = 122; // 审查意见
	public static final int DATADIC_TYPE_ATTITUDE3 = 123; // 复核、终审意见
	public static final int DATADIC_TYPE_INSURANCE_TYPE = 140; // 保单类型
	public static final int DATADIC_TYPE_CURCD = 202; // 币种
	public static final int DATADIC_TYPE_IMPAWN_TYPE = 203; // 质物种类
	public static final int DATADIC_TYPE_CUST_TYPE = 206; // 客户类型
	public static final int DATADIC_TYPE_CORP_TYPE = 207; // 特约商户类型
	public static final int DATADIC_TYPE_CORP_CODE_TYPE = 208; // 客户内部编码类型
	public static final int DATADIC_TYPE_CORP_ECO_FORM = 209; // 经营组织形式
	public static final int DATADIC_TYPE_CORP_COWER_MODE = 210; // 经济性质
	public static final int DATADIC_TYPE_CORP_ORG_TYPE = 211; // 机构类型
	public static final int DATADIC_TYPE_CORP_BIZ_TYPE = 212; // 行业类别
	public static final int DATADIC_TYPE_CORP_SCALE = 213; // 企业规模
	public static final int DATADIC_TYPE_INDV_CORP_SCALE = 214; // 借款人单位规模
	public static final int DATADIC_TYPE_CREDIT_MODEL = 215; // 消费信贷分摊方式
	public static final int DATADIC_TYPE_FOLK = 300; // 民族
	public static final int DATADIC_TYPE_HOUSE_PROPERTY = 302; // 住宅性质
	public static final int DATADIC_TYPE_COUNTRY = 303; // 国籍
	public static final int DATADIC_TYPE_TRADE = 306; // 行业
	public static final int DATADIC_TYPE_FLAG = 308; // 是否标志
	public static final int DATADIC_TYPE_STATUS = 309; // 有效标志
	public static final int DATADIC_TYPE_LIMIT_MODE = 310; // 操作员审批控制方式
	public static final int DATADIC_TYPE_BRCLASS = 401; // 机构级别
	public static final int DATADIC_TYPE_MANAGE_BRCLASS = 402; // 管理机构级别
	public static final int DATADIC_TYPE_DEGREE = 403; // 学位
	public static final int DATADIC_TYPE_DUN_MODE = 404; // 催收方式
	public static final int DATADIC_TYPE_FUND_REPAY_MODE = 405; // 公积金冲还贷方式
	public static final int DATADIC_TYPE_FUND_REPAY_MONTH = 406; // 公积金冲还贷月份
	public static final int DATADIC_TYPE_HOUSE_TYPE = 407; // 房屋类型
	public static final int DATADIC_TYPE_MORT_TYPE = 408; // 抵押物类型
	public static final int DATADIC_TYPE_PHASE_FLAG = 409; // 阶段还款标志
	public static final int DATADIC_TYPE_PRELATION = 410; // 个人关系
	public static final int DATADIC_TYPE_PUN_INT_OPT = 411; // 罚息浮动选项
	public static final int DATADIC_TYPE_BRANCH_MAIL_ADDR = 412; // 机构帐单寄送地址
	public static final int DATADIC_TYPE_PL_CENTER_TYPE = 413; // 个贷中心模式
	public static final int DATADIC_TYPE_TERM_TYPE = 414; // 贷款期限类型(短、中、长)
	public static final int DATADIC_TYPE_PRE_APP_CONDITION = 415; // 前续审批条件
	public static final int DATADIC_TYPE_GUATCODE = 416; // 担保方式
	public static final int DATADIC_TYPE_RISK_GUIDE_LINE = 417; // 风险指标
	public static final int DATADIC_TYPE_HOUSE_PRICE_LEVEL = 418; // 楼盘四级分类
	public static final int DATADIC_TYPE_CORP_REPORT_TYPE = 419; // 企业报表类型
	public static final int DATADIC_TYPE_INFRACT_TYPE = 420; // 客户信用记录来源
	public static final int DATADIC_TYPE_DOC_CONS_MODE = 421; // 档案调阅方式
	public static final int DATADIC_TYPE_CUST_MAIL_ADDR = 422; // 客户帐单寄送地址
	public static final int DATADIC_TYPE_HOUSE_STRUCT = 423; // 房屋结构
	public static final int DATADIC_TYPE_HOUSE_BIZ_BPROPERTY = 424; // 房屋性质
	public static final int DATADIC_TYPE_HOUSE_SELL_PROPERTY = 425; // 销售性质
	public static final int DATADIC_TYPE_HOUSE_BUY_REASON = 426; // 购房原因
	public static final int DATADIC_TYPE_AUTO_USAGE = 427; // 汽车用途
	public static final int DATADIC_TYPE_AUTO_HANDS = 428; // 一手车/二手车标志
	public static final int DATADIC_TYPE_EDU_LOAN_TYPE = 429; // 助学贷款分类
	public static final int DATADIC_TYPE_EDU_LOAN_GRANT_STATUS = 430; // 助学贷款放款计划发放状态
	public static final int DATADIC_TYPE_MORT_STATUS = 431; // 抵押状态
	public static final int DATADIC_TYPE_MORT_PRELATION = 432; // 权属人与借款人关系
	public static final int DATADIC_TYPE_MORT_OWNERSHIP = 433; // 抵押物所有权属
	public static final int DATADIC_TYPE_INSURE_FEE_TYPE = 434; // 保险费缴费方式
	public static final int DATADIC_TYPE_INVEST_MODE = 435; // 调查方式
	public static final int DATADIC_TYPE_PBC_INQUIRY_RESULT = 436; // 人民银行征信系统查询结论
	public static final int DATADIC_TYPE_NOTARIZATION_STATUS = 437; // 公证办理状态
	public static final int DATADIC_TYPE_CLOSE_TYPE = 438; // 还款类型/结清类型
	public static final int DATADIC_TYPE_NOTE_TYPE = 439; // 记事类型
	public static final int DATADIC_TYPE_MORT_USAGE_KIND = 440; // 抵押物使用情况
	public static final int DATADIC_TYPE_ROLE_TYPE = 441; // 抵押物使用情况
	public static final int DATADIC_TYPE_CONTRIBUTE_DEGREE = 442; // 业务贡献度
	public static final int DATADIC_TYPE_LNCI_STATUS = 443; // 借据发放状态
	public static final int DATADIC_TYPE_HAVE_NO = 444; // 有无标志
	public static final int DATADIC_TYPE_ARCHIVE_STATUS = 445; // 档案状态
	public static final int DATADIC_TYPE_MITAPE = 447; // 抵质押物显示类型
	public static final int DATADIC_TYPE_GUARANTEETYPE = 450;// 权利品类型
	public static final int DATADIC_TYPE_MISP_PUN_INT_OPT = 460; // 挪用罚息浮动选项
	public static final int DATADIC_TYPE_FUNCTION_CODE = 465; // 联机交易名称
	public static final int DATADIC_TYPE_LNSTAT = 472;// 贷款形态
	public static final int DATADIC_TYPE_ACTSTAT_TYPE = 473; // 贷款入账状态
	/**
	 * 征信数据字典映射类型
	 */
	public static final int DATADIC_TYPE_CUSTCREDIT_HKPL = 480;// 征信还款频率
	public static final int DATADIC_TYPE_CUSTCREDIT_ZHZT = 481;// 征信账户状态
	public static final int DATADIC_TYPE_CUSTCREDIT_DBFS = 482;// 征信担保方式
	public static final int DATADIC_TYPE_CUSTCREDIT_WJFL = 483;// 征信五级分类
	public static final int DATADIC_TYPE_CUSTCREDIT_HKZT = 484;// 征信还款状态
	public static final int DATADIC_TYPE_CUSTCREDIT_BZ = 485;// 征信币种
	public static final int DATADIC_TYPE_CUSTCREDIT_ZHYYZXXTS = 486;// 征信账户拥有者信息提示
	public static final int DATADIC_TYPE_CUSTCREDIT_ZJLX = 487;// 征信证件类型
	public static final int DATADIC_TYPE_CUSTCREDIT_DBZT = 488;// 征信担保状态
	public static final int DATADIC_TYPE_CUSTCREDIT_TSJYLX = 489;// 征信特殊交易类型
	public static final int DATADIC_TYPE_CUSTCREDIT_FLAG = 490;// 征信修改上传标志
	public static final int DATADIC_TYPE_INCOMESOURCE = 490;// 家庭主要经济来源（广发）
	/**
	 * 核算数据字典映射类型
	 */

	public static final int DATADIC_TYPE_ACE_SUJ_LEVEL = 500; // 科目级别
	public static final int DATADIC_TYPE_ACE_SUJ_TYPE = 501; // 科目类型
	public static final int DATADIC_TYPE_ACE_BAL_TYPE = 502; // 余额方向
	public static final int DATADIC_TYPE_ACE_LN_ACT_TYPE = 503; // 贷款账号类型

	public static final int DATADIC_TYPE_LSRQ_TYPE = 520; // loan_supervise_risk_question_TYPE
															// 后督登记问题分类
	public static final int DATADIC_TYPE_CUSTOMER_CONFIRM = 521; // 客户问题确认
	public static final int DATADIC_TYPE_PFMQ_SHEET = 522; // prev_fake_mort_qst
															// 预防假按揭问题涉及表
	public static final int DATADIC_TYPE_PFMQ_SHEET_CI = 523; // prev_fake_mort_qst_CustomerInfo
																// 预防假按揭问题涉及表-客户信息表
	public static final int DATADIC_TYPE_PFMQ_SHEET_IBI = 524; // prev_fake_mort_qst_IndvBasicInfo
																// 预防假按揭问题涉及表-自然人信息表
	public static final int DATADIC_TYPE_PFMQ_SHEET_LI = 525; // prev_fake_mort_qst_LoanInfo
																// 预防假按揭问题涉及表-贷款合同信息表
	public static final int DATADIC_TYPE_PFMQ_SHEET_LC = 526; // prev_fake_mort_qst_Loancino
																// 预防假按揭问题涉及表-贷款借据信息表
	public static final int DATADIC_TYPE_PFMQ_SHEET_LH = 527; // prev_fake_mort_qst_LoanHouse
																// 预防假按揭问题涉及表-购房贷款附属信息
	public static final int DATADIC_TYPE_PFMQ_TYPE = 528; // prev_fake_mort_qst_TYPE
															// 预防假按揭问题类型

	public static final int DATADIC_TYPE_CERTTYPE = 551;// 权属证书类型
	public static final int DATADIC_TYPE_ASSETTYPE = 552;// 抵债资产类型
	public static final int DATADIC_TYPE_AFFIRMTYPE = 553;// 价值确认方式
	public static final int DATADIC_TYPE_BIZCLASS = 3633;// 审批类型
	public static final int DATADIC_TYPE_STATUS_COOP = 840; // 合作项目有效标志
	public static final int DATADIC_TYPE_ATTITUDE_JZ_ALL = 10301;// 工作流审批意见
	public static final int DATADIC_TYPE_ATTITUDE_TRANS = 6003;// 审批意见于流转对应

	public static final int DATADIC_TYPE_RTN_TYPE_NEW = 8003;// 还款方式(包含组合贷款和灵活还款)
	public static final int DATADIC_TYPE_DOG_TYPE = 8001;//宽限期方式

	public static final int DATADIC_TYPE_INTRATEFLOAT_MODE = 19003; // 利率浮动方式
	public static final int DATADIC_TYPE_PINTRATE_MODE = 19000; // 罚息收取方式
	/** **评分数据字典映射类型*** */
	public static final String DATADIC_TYPE_GRADE_STATE = "7050"; // 评分要素状态(0-已评分,
																	// 1-无值可忽略,
																	// 2-无值不可忽略,
																	// 3-不参与评分,
																	// 4-无法评分可忽略,
																	// 5-无法评分不可忽略
																	// )
	public static final String DATA_DIC_TYPE_NO_HEAD_BRANCH_SUB = "9003";

	public static final String DATADIC_NAME_A = "1";// 评分信用等级A
	public static final String DATADIC_NAME_B = "2";// 评分信用等级B
	public static final String DATADIC_NAME_C = "3";// 评分信用等级C
	public static final String DATADIC_NAME_D = "4";// 评分信用等级D
	/**
	 * 数据字典映射类型
	 */
	public static final int DATADIC_MAPTYPE_GUAT_TYPE = 1; // 担保方式：将按位表示的担保方式映射为一位表示的担保方式
	public static final int DATADIC_MAPTYPE_MORT_TYPE = 2; // 抵押物类型：将抵押物类型映射为抵押物大类
	public static final int DATADIC_MAPTYPE_PERSONAL_RELATION = 3; // 个人关系：将个人关系映射为其反向的关系
	// modify jiang@20080630
	public static final int DATADIC_MAPTYPE_LNUSE = 80; // 贷款用途：将贷款大类映射为贷款用途
	public static final int DATADIC_MAPTYPE_CURCD = 5; // 币种：将币种代号映射为币种符号

	// 与核心系统的字典转换
	public static final int DATADIC_MAPTYPE_MARRIAGE = 101; // 婚姻状况：将婚姻状况映射为婚姻状况
	public static final int DATADIC_MAPTYPE_EDU_LEVEL = 102; // 学历
	public static final int DATADIC_MAPTYPE_TITLE = 103; // 职称
	public static final int DATADIC_MAPTYPE_RTN_MODE = 104; // 还款途径
	public static final int DATADIC_MAPTYPE_INTRATE_ADJ = 105; // 利率调整方式
	public static final int DATADIC_MAPTYPE_ACTTYPE = 106; // 帐户类型
	public static final int DATADIC_MAPTYPE_CLASS_MODE = 107; // 五级分类方式
	public static final int DATADIC_MAPTYPE_LOANCINO_STATUS = 108; // 借据记录状态
	public static final int DATADIC_MAPTYPE_IDTYPE = 109; // 证件类型

	/**
	 * 申请类型
	 */

	public static final String APPLY_TYPE_NORMAL_LOAN = "01"; // 贷款申请
	public static final String APPLY_TYPE_COMBINATION_LOAN = "02"; // 组合贷款申请
	public static final String APPLY_TYPE_ADDITION_LOAN = "03"; // 加按申请
	public static final String APPLY_TYPE_TRANSFER_LOAN = "04"; // 转按申请

	public static final String APPLY_TYPE_EXTEND_LOAN = "05"; // 展期申请

	public static final String APPLY_TYPE_CREDIT_APPLY = "11"; // 授信额度申请
	public static final String APPLY_TYPE_CREDIT_INCREASE = "12"; // 额度增加申请
	public static final String APPLY_TYPE_CREDIT_REVOKE = "13"; // 额度收回申请
	public static final String APPLY_TYPE_CREDIT_DECREASE = "14"; // 额度缩减申请
	public static final String APPLY_TYPE_CREDIT_FREEZE = "15"; // 额度冻结
	public static final String APPLY_TYPE_CREDIT_UNFREEZE = "16";//额度解冻申请

	public static final String APPLY_TYPE_PROJECT_APPLY = "21"; // 合作项目申请
	public static final String APPLY_TYPE_PROJECT_ALTER = "22"; // 合作项目修改申请
	public static final String APPLY_TYPE_PROJECT_TERMINATE = "23"; // 合作项目终止申请
	public static final String APPLY_TYPE_PROJECT_FREEZE = "24"; // 合作项目冻结申请
	public static final String APPLY_TYPE_PROJECT_UNFREEZE = "25"; // 合作项目解冻申请

	public static final String APPLY_TYPE_CLR_CLASS = "30"; // 五级分类变更申请
	// public static final String APPLY_TYPE_CLR_CLASS_DOWN = "31"; // 五级分类下调申请
	// public static final String APPLY_TYPE_CLR_CLASS_UP = "32"; // 五级分类上调申请
	public static final String APPLY_TYPE_ADV_RTN = "33"; // 提前还款申请
	public static final String APPLY_TYPE_LOAN_TO_BAD = "34"; // 贷款转呆滞/呆帐申请
	public static final String APPLY_TYPE_CHG_GUARANTEE = "35"; // 变更担保信息申请
	public static final String APPLY_TYPE_CHG_INTRATE = "36"; // 贷款利率变更申请
	public static final String APPLY_TYPE_TERM_DEFER = "37"; // 贷款期限延长申请 --海尔统一到37
	public static final String APPLY_TYPE_TERM_SHORTEN = "38"; // 贷款期限缩短申请 --海尔统一到37
	public static final String APPLY_TYPE_CHG_RTN_TYPE = "39"; // 还款方式变更申请
	public static final String APPLY_TYPE_CHG_RTN_DATE = "40"; // 约定扣款日变更申请
	public static final String APPLY_TYPE_CHG_PHASE_DTL = "41"; // 阶段还款信息变更申请
	public static final String APPLY_TYPE_CHG_RTN_ACTNO = "42"; // 还款帐号变更申请
	public static final String APPLY_TYPE_CREDIT_INTRATE = "43"; // 额度利率变更申请
	public static final String APPLY_TYPE_EDU_LOAN_EXTEND = "44"; // 助学贷款展期申请
	public static final String APPLY_TYPE_EDU_LOAN_TRSF_DATE = "45"; // 助学贷款转等额日变更申请
	public static final String APPLY_TYPE_EDU_LOAN_GRANT_PLAN = "46"; // 助学贷款放款计划变更申请
	public static final String APPLY_TYPE_CHG_FUND_REPAY_MODE = "47"; // 公积金冲还贷方式变更申请
	public static final String APPLY_TYPE_CHG_CONJUNCTER = "48"; // 参贷人变更申请

	public static final String APPLY_TYPE_MGRNO_CHG = "49"; // 客户经理变更申请
	public static final String APPLY_TYPE_LOAN_PARAM_CHG = "50"; // 贷款产品参数变更申请
	public static final String APPLY_TYPE_GUAT_LIMIT_PARAM_CHG = "51"; // 担保额度参数变更申请

	public static final String APPLY_TYPE_LOAN_CARD_APPLY = "61"; // 房贷卡授信额度申请
	public static final String APPLY_TYPE_LOAN_CARD_INCREASE = "62"; // 房贷卡授信额度增加申请
	public static final String APPLY_TYPE_LOAN_CARD_REVOKE = "63"; // 房贷卡授信额度收回申请
	public static final String APPLY_TYPE_LOAN_CARD_DECREASE = "64"; // 房贷卡授信额度缩减申请
	public static final String APPLY_TYPE_LOAN_CARD_PAUSE_RESUME = "65"; // 房贷卡授信额度暂停/恢复申请
	public static final String APPLY_TYPE_LOAN_CARD_OTHER = "66"; // 其他
	// Add by zxyue 新增流程五级分类变更及贷款转抵债
	public static final String APPLY_TYPE_CHG_FIVE_CLASS = "67"; // 五级分类方式与级别变更
	public static final String APPLY_TYPE_CHG_DEBT = "68";// 贷款转抵债
	public static final String APPLY_TYPE_CHG_BAD_DEBT = "69";// 呆账贷款核销
	public static final String APPLY_TYPE_LAW_SUIT = "70";// 贷款诉讼
	public static final String APPLY_TYPE_CHG_SLACK = "71";// 呆滞转呆账
	public static final String APPLY_TYPE_CHG_INTRATE4C = "72"; // 贷款利率变更申请

	//批量五级分类 gz
	public static final String APPLY_TYPE_POSTLOAN_CHECK = "84"; //批量五级分类调整

	//贷后检查gz
	public static final String APPLY_TYPE_POSTLOAN_CHECK_ONLY = "85"; //贷后检查

	//出账审核申请
	public static final String APPLY_TYPE_PAY_CHECK = "80";//出账申请

	// Add by xubin （5.9.6） 定制台账查询条件
	public static final String APPLY_TYPE_CREATE_MACHINE_ACCOUNT_QRY = "71";// 定制台账查询条件

	public static final String APPLY_TYPE_LOAN_CARD_RESUME = "0"; // 恢复
	public static final String APPLY_TYPE_LOAN_CARD_PAUSE = "1"; // 暂停

	/**
	 * 字符串长度
	 */
	public static final int STRING_BUFFER_LEN_MID = 1024;
	public static final int STRING_BUFFER_LEN_MIN = 256;
	public static final int STRING_BUFFER_LEN_MAX = 4096;

	/**
	 * globalinfo表ID
	 */
	public static final int TABLE_GLOBAL_INFO_ID = 1;

	/**
	 * session ID的常量定义
	 */
	public static final String WEB_SESSION_ID = "jsessionid";

	/**
	 * 批量状态
	 */
	public static final String GLOBAL_INFO_STATE_ONLINE = "0"; // 联机状态
	public static final String GLOBAL_INFO_STATE_BATCH = "1"; // 批量状态

	/**
	 * 交易性质
	 */
	public static final String FUNC_TYPE_INQUIRY = "0"; // 查询类
	public static final String FUNC_TYPE_UPDATE = "1"; // 修改类

	/**
	 * 机构帐单寄送地址
	 */
	public static final String BRANCH_MAIL_ADDR_PL_CENTER = "1"; // 个贷中心
	public static final String BRANCH_MAIL_ADDR_ACCOUNT = "2"; // 帐务机构

	/**
	 * 记事类型
	 */
	public static final String NOTE_TYPE_LOAN = "1"; // 合同
	public static final String NOTE_TYPE_INDV = "2"; // 客户
	public static final String NOTE_TYPE_COOP = "3"; // 特约商户
	public static final String NOTE_TYPE_PROJECT = "4"; // 合作项目
	public static final String NOTE_TYPE_OTHER = "5"; // 其它

	/**
	 * 风险指标
	 */
	public static final String RISK_GUIDE_LINE_LNBAL = "1"; // 贷款余额
	public static final String RISK_GUIDE_LINE_ILL_BAL = "2"; // 不良贷款余额
	public static final String RISK_GUIDE_LINE_ILL_BAL_RATE = "3"; // 不良贷款率
	public static final String RISK_GUIDE_LINE_ESTIMATE_LOSS_RATE = "4"; // 估计贷款损失率
	public static final String RISK_GUIDE_LINE_NORMAL_TRANSFER_RATIO = "5"; // 正常类贷款迁徙率
	public static final String RISK_GUIDE_LINE_ATTENTION_TRANSFER_RATIO = "6"; // 关注类贷款迁徙率
	public static final String RISK_GUIDE_LINE_LESSER_TRANSFER_RATIO = "7"; // 次级类贷款迁徙率
	public static final String RISK_GUIDE_LINE_SHADINESS_TRANSFER_RATIO = "8"; // 可疑类贷款迁徙率

	/**
	 * 客户分析指标
	 */
	public static final String CUST_GUIDE_LINE_SEX = "01"; // 性别
	public static final String CUST_GUIDE_LINE_OCCUPATION = "02"; // 职业
	public static final String CUST_GUIDE_LINE_TRADE = "03"; // 行业
	public static final String CUST_GUIDE_LINE_DUTY = "04"; // 职务
	public static final String CUST_GUIDE_LINE_TITLE = "05"; // 职称
	public static final String CUST_GUIDE_LINE_CORP_PROPERTY = "06"; // 单位性质
	public static final String CUST_GUIDE_LINE_MARRIAGE = "07"; // 婚姻状况
	public static final String CUST_GUIDE_LINE_HUKOU_TYPE = "08"; // 户籍性质
	public static final String CUST_GUIDE_LINE_EDU_LEVEL = "09"; // 文化程度
	public static final String CUST_GUIDE_LINE_INDV_INCOME = "10"; // 月收入
	public static final String CUST_GUIDE_LINE_FAMILY_INCOME = "11"; // 家庭月总收入
	public static final String CUST_GUIDE_LINE_CREDIT_GRADE = "12"; // 信用评估得分
	public static final String CUST_GUIDE_LINE_LNTYPE = "13"; // 贷款种类
	public static final String CUST_GUIDE_LINE_LNAMT = "14"; // 贷款金额
	public static final String CUST_GUIDE_LINE_TERM = "15"; // 贷款期限
	public static final String CUST_GUIDE_LINE_GUATCODE = "16"; // 担保方式
	public static final String CUST_GUIDE_LINE_RTN_TYPE = "17"; // 还款方式
	public static final String CUST_GUIDE_LINE_RTN_INTERVAL = "18"; // 还款间隔
	public static final String CUST_GUIDE_LINE_RTN_DATE_TYPE = "19"; // 还款日期确定方式

	/**
	 * 客户分类指标
	 */
	public static final String CUST_MODE_A = "A"; // A类客户
	public static final String CUST_MODE_B = "B"; // B类客户
	public static final String CUST_MODE_C = "C"; // C类客户
	public static final String CUST_MODE_NO = "0"; // 未分类客户

	public static final String EXTRA_DEFAULT_LIKE_STRING = "%%";

	// Info: 后督标志 ; Add By Kejun.zhang ; 2006.08.30
	public static final String STR_LRS_FLAG_DO = "已后督";
	public static final String STR_LRS_FLAG_UNDO = "未后督";
	public static final String STR_LRS_FLAG_VALUE_DO = "1";
	public static final String STR_LRS_FLAG_VALUE_UNDO = "0";

	public static final String STR_LRS_STATUS_VALUE_UNKOWN = "0"; // 未录入
	public static final String STR_LRS_STATUS_VALUE_REGISTER = "1"; // 已录入
	public static final String STR_LRS_STATUS_VALUE_AFFIRM = "2"; // 已确认
	// Info: 后督标志 ; Add By Kejun.zhang ; 2006.08.30 End

	// 后督问题分类
	public static final String LRS_TYPE_WITHOUT_QU = "0"; // 无问题
	public static final String LRS_TYPE_NOT_AFFIRM = "9"; // 待确定

	// 额度划转方向
	public static final String CRED_TURN_DIRECTION_IN = "1"; // 转入
	public static final String CRED_TURN_DIRECTION_OU = "2"; // 转出

	// 业务准入岗代码有效标志
	public static final boolean VALID_FLAG_ADMITTANCE_CODE = true;
	// 例外贷款代码有效标志
	public static final boolean VALID_FLAG_EXPLOAN_CODE = true;

	// 业务准入审批结果
	public static final String OPADMITTANCE_ATTITUDE_AGREE_0 = "0"; // 审批同意--提前还款流程添加
	public static final String OPADMITTANCE_ATTITUDE_AGREE_1 = "1"; // 审批不同意--提前还款流程添加
	public static final String OPADMITTANCE_ATTITUDE_AGREE = "1"; // 审批同意
	public static final String OPADMITTANCE_ATTITUDE_DISAGREE = "2"; // 审批不同意

	// Info: 合作项目是否一定为虚拟项目 ; Kejun.zhang Add 2006-10-24
	public static final String STR_LNTYPE_MISCFLAG_FOUR_N = "2"; // 必需为虚拟项目
	public static final String STR_LNTYPE_MISCFLAG_FOUR_U = "1"; // 不能为虚拟项目

	public static final String STR_LNTYPE_MISCFLAG_FIVE_N = "1"; // 需要抵押物信息
	// Info: 合作项目是否一定为虚拟项目 ; Kejun.zhang Add 2006-10-24 End

	public static final int CINO_WARNING_LIMIT = 6; // 对借据预警的次数控制

	public static final String DATA_NO_LNCARD_MIN_BASEBAL = "1"; // 智业信用卡最小基础额度
	public static final String DATA_NO_LNCARD_MAX_BASEBAL = "2"; // 智业信用卡最大基础额度

	public static final String CUSTTYPE_LOAN = "1";// 借款人
	public static final String CUSTTYPE_GUARANTOR = "2";// 保证人
	public static final String CUSTTYPE_ENTERLOAN = "3";// 参贷人
	public static final String CUSTTYPE_TRUSOTOR = "4";// 委托人

	/**
	 * 变更担保信息申请审批状态
	 */
	public static final String GUARANTEE_CHG_APPLY_STATUS_APPROVING = "0"; // 审批中
	public static final String GUARANTEE_CHG_APPLY_STATUS_AGREE_FINISH = "1"; // 审批同意结束
	public static final String GUARANTEE_CHG_APPLY_STATUS_REJECT_FINISH = "2"; // 审批拒绝结束
	public static final String GUARANTEE_CHG_APPLY_STATUS_UNTREAD = "8"; // 退回
	public static final String GUARANTEE_CHG_APPLY_STATUS_INPUT_UNUPLOAD = "9"; // 录入未上传

	/**
	 * 单页最大记录数设置
	 */
	public static final int MAX_ROWS = 20;

	public static final int MAX_ROWS_4_SUM = 21;

	/**
	 * add by NT 2007-09-20 来源于交行个贷 缺省功能代码
	 */
	public static final int FUNC_CODE = 999999;

	/**
	 * add by NT 2007-09-20 来源于交行个贷 渠道来源
	 */
	public static final String COUNTER_CHANNEL = "00000"; // 柜面交易

	/**
	 * add by NT 2007-09-20 来源于交行个贷 缺省用户代码
	 */
	public static final String DEFAULT_TLR_NO = "9999999";

	/**
	 * 缺省根菜单代码
	 */
	public static final long DEFAULT_ROOT_MENU = 1000000;
	/**
	 * add by NT 2007-09-20 来源于交行个贷 缺省用户密码加密密钥
	 */
	public static final String DEFAULT_PASSWORD_KEY = "Huateng.gd.Ocean's Fourteen.DWMNTH2CJFLCWL";

	/**
	 * add by NT 2007-09-18 为兼容交行个贷用户权限管理及登录的配置文件，同交行个贷的bocompl.properties文件。
	 * 现在使用的是BocomplJAR.jar包中的SystemConstant.java
	 */
	public static final String CONFFILENAME = "commonResources";

	public static final String GZCONFFILENAME = "gzbankcomm";
	/**
	 * add by NT 2007-09-29 来源于交行个贷 缺省用户密码明文
	 */
	public static final String DEFAULT_PASSWORD = "123456";

	/**
	 * add by NT 2007-09-20 来源于交行个贷 用户密码错误次数
	 */
	public static final int ERR_PWD_TIMES_CONTINUE = 3;

	public static final int ERR_PWD_TIMES_SUM = 6;

	/**
	 * add by NT 2007-09-20 来源于交行个贷 柜员状态
	 */
	public static final String TLR_NO_STATE_LOGOUT = "0"; // 签退

	public static final String TLR_NO_STATE_LOGIN = "1"; // 签到

	public static final String TLR_NO_STATE_QUIT = "2"; // 离职

	/**
	 * add by NT 2007-09-20 来源于交行个贷 岗位信息，需要更改。
	 */
	public static final int ROLE_ID_BRANCH_OPERATION_ADMIN = 210; // 分行业务管理岗

	public static final int ROLE_ID_SUB_BRANCH_OPERATION_ADMIN = 310; // 支行业务管理岗

	/**
	 * add by NT 2007-09-28 日期格式
	 */
	public static final String FULLTIME_PATTERN = "yyyy-MM-dd.HH.mm.ss.SSS";

	public static final String OUT_USER_SESSION_INFO = "USER_SESSION_INFO";

	public static final String ERRORS_MSG_KEY = "errors.message";

	/**
	 * add by NT 2007-09-29 未筛选，有未使用的变量 角色 范围：100－999 第一位： 1：总行，2：分行，3：支行
	 * 第二、三位：岗位编号 1XX：总行 2XX：分行（个贷中心） 3XX：支行
	 */
	public static final int ROLE_ID_HEAD_BRANCH_SYS_ADMIN = 100; // 总行系统管理岗
	public static final int ROLE_ID_HEAD_BRANCH_OPERATION_ADMIN = 110;

	public static final int ROLE_ID_BRANCH_SYS_ADMIN = 211; // 分行系统管理岗
	public static final int ROLE_ID_BRANCH_CHIEF = 220; // 分行主管行长
	public static final int ROLE_ID_BRANCH_PF_MANAGER = 221; // 分行私金处处长
	public static final int ROLE_ID_BRANCN_PL_MANAGER = 222; // 分行个贷中心主任
	public static final int ROLE_ID_BRANCH_LAW = 223; // 分行法律岗
	public static final int ROLE_ID_BRANCH_ARCHIVE = 224; // 分行档案管理岗
	public static final int ROLE_ID_BRANCH_DUN = 225; // 分行追帐岗
	public static final int ROLE_ID_BRANCH_AGENCY = 226; // 分行中介岗
	public static final int ROLE_ID_BRANCH_COLLIGATE = 227; // 分行综合岗
	public static final int ROLE_ID_BRANCH_APPROVE = 228; // 分行审批岗
	public static final int ROLE_ID_BRANCH_AUDIT = 229; // 分行审查岗
	public static final int ROLE_ID_BRANCH_ACCOUNTANT = 230; // 分行会计岗
	public static final int ROLE_ID_BRANCH_VERIFY = 231; // 分行核查岗

	public static final int ROLE_ID_SUB_BRANCH_SYS_ADMIN = 300; // 支行系统管理岗
	public static final int ROLE_ID_SUB_BRANCH_CHIEF = 320; // 支行行长
	public static final int ROLE_ID_SUB_BRANCH_ARCHIVE = 321; // 支行档案管理岗
	public static final int ROLE_ID_SUB_BRANCH_DUE = 322; // 支行追帐岗
	public static final int ROLE_ID_SUB_BRANCH_AGENCY = 323; // 支行中介岗
	public static final int ROLE_ID_SUB_BRANCH_COLLIGATE = 324; // 支行综合岗
	public static final int ROLE_ID_SUB_BRANCH_APPROVE = 325; // 支行审批岗
	public static final int ROLE_ID_SUB_BRANCH_AUDIT = 326; // 支行审查岗
	public static final int ROLE_ID_SUB_BRANCH_SALES = 327; // 支行信贷营销岗
	public static final int ROLE_ID_SUB_BRANCH_LAW = 328; // 支行法律岗
	public static final int ROLE_ID_SUB_BRANCH_VERIFY = 329; // 支行核查岗

	public static final String PROC_NAME_PROJECT_APPLY_NO = "01";
	public static final String PROC_NAME_PROJECT_APPLY_1_NO = "02";
	public static final String PROC_NAME_PROJECT_APPLY_2_NO = "03";
	public static final String PROC_NAME_PROJECT_APPLY_A_NO = "04";
	public static final String PROC_NAME_LOAN_ALTER_A_NO = "05";
	public static final String PROC_NAME_LOAN_ALTER_A1_NO = "06";
	public static final String PROC_NAME_LOAN_ALTER_A2_NO = "07";
	public static final String PROC_NAME_LOAN_ALTER_A3_NO = "08";
	public static final String PROC_NAME_LOAN_ALTER_B_NO = "09";
	public static final String PROC_NAME_LOAN_ALTER_B1_NO = "10";
	public static final String PROC_NAME_LOAN_ALTER_B2_NO = "11";
	public static final String PROC_NAME_LOAN_ALTER_B3_NO = "12";
	public static final String PROC_NAME_LOAN_ALTER_B4_NO = "13";
	public static final String PROC_NAME_LOAN_ALTER_B5_NO = "14";
	public static final String PROC_NAME_CREDIT_APPLY_NO = "15";
	// public static final String PROC_NAME_LOAN_ALTER_C = "LoanAlterC";
	public static final String PROC_NAME_LOAN_APPLY_NO = "16";
	public static final String PROC_NAME_LOAN_APPLYAAA_NO = "17";

	public static final String PROC_NAME_PROjECT_APPLYALTER_RATE = "LoanAlter";// 贷款利率变更

	public static final String PROC_NAME_PROJECT_APPLY = "ProjectApply"; // 合作项目建立
	public static final String PROC_NAME_PROJECT_APPLY_1 = "ProjectApply1"; // 合作项目基本信息修改
	public static final String PROC_NAME_PROJECT_APPLY_2 = "ProjectApply2"; // 合作项目终止
	public static final String PROC_NAME_PROJECT_APPLY_A = "ProjectApplyA"; // 合作项目建立（多级审批）
	public static final String PROC_NAME_LOAN_ALTER_A = "LoanAlterA"; // 变更担保方式
	public static final String PROC_NAME_LOAN_ALTER_A1 = "LoanAlterA1"; // 贷款利率变更
	public static final String PROC_NAME_LOAN_ALTER_A2 = "LoanAlterA2"; // 贷款期限变更
	public static final String PROC_NAME_LOAN_ALTER_A3 = "LoanAlterA3"; // 助学贷款展期申请
	public static final String PROC_NAME_LOAN_ALTER_B = "LoanAlterB"; // 提前还款申请
	public static final String PROC_NAME_LOAN_ALTER_B1 = "LoanAlterB1"; // 还款方式变更申请
	public static final String PROC_NAME_LOAN_ALTER_B2 = "LoanAlterB2"; // 约定扣款日变更申请
	public static final String PROC_NAME_LOAN_ALTER_B3 = "LoanAlterB3"; // 助学贷款转等额日变更申请
	public static final String PROC_NAME_LOAN_ALTER_B4 = "LoanAlterB4"; // 助学贷款放款计划变更申请
	public static final String PROC_NAME_LOAN_ALTER_B5 = "LoanAlterB5"; // 参贷人变更申请
	public static final String PROC_NAME_CREDIT_APPLY = "CreditApply"; // 授信额度申请
	public static final String PROC_NAME_LOAN_ALTER_C = "LoanAlterC";
	public static final String PROC_NAME_LOAN_APPLY = "LoanApply"; // 贷款申请
	public static final String PROC_NAME_LOAN_APPLYAAA = "LoanApplyAAA"; // 贷款申请（多级审批）
	public static final String PROC_NAME_LOAN_APPLY_BRANCH_MODE = "LoanApplyBranchMode"; // 贷款申请(直属支行模式)
	public static final String PROC_NAME_LOAN_APPLY_CENTER_MODE = "LoanApplyCenterMode"; // 贷款申请（个贷中心模式）
	public static final String PROC_NAME_FIVECLASS_ALTER_A = "FiveClassAlterA";// Add
																				// FiveClassChg
																				// 新增五级分类审查节点
																				// Add
																				// by
																				// zxyue
	public static final String PROC_NAME_DEBT_ALTER_A = "DebtAlterA"; // 新增贷款转抵债
																		// Add
																		// by
																		// zxyue
	public static final String PROC_NAME_BAD_DEBT_ALTER_A = "BadDebtApplyA"; // 新增呆账贷款核销
																				// Add
																				// by
																				// zxyue
	public static final String PROC_NAME_LAWSUIT_APPLY_A = "LawSuitApplyA"; // 新增贷款诉讼申请
	public static final String PROC_NAME_CREDIT_FREEZE_APPLY = "CreditFreezeApply"; // 额度冻结/解冻申请
	public static final String PROC_NAME_CREDIT_ALTER = "CreditAlter"; // 授信额度增加申请
	public static final String PROC_NAME_CREDIT_ALTER1 = "CreditAlter1"; // 授信额度收回申请
	public static final String PROC_NAME_CREDIT_ALTER2 = "CreditAlter2"; // 授信额度缩减申请
	public static final String PROC_NAME_LOAN_ALTER = "LoanAlter"; // 提前还款
	public static final String PROC_NAME_LOAN_ALTER1 = "LoanAlter1"; // 五级分类变更
	public static final String PROC_NAME_LOAN_ALTER2 = "LoanAlter2"; // 担保信息变更
	public static final String PROC_NAME_LOAN_ALTER3 = "LoanAlter3"; // 利率变更
	public static final String PROC_NAME_LOAN_ALTER4 = "LoanAlter4"; // 还款方式变更
	public static final String PROC_NAME_LOAN_ALTER5 = "LoanAlter5"; // 贷款期限变更
	public static final String PROC_NAME_LOAN_ALTER6 = "LoanAlter6"; // 参贷人变更
	public static final String PROC_NAME_LOAN_ALTER7 = "LoanAlter7"; // 客户经理变更
	public static final String PROC_NAME_RTN_DATE_CHG = "RtnDateChg"; // 约定扣款日变更
	public static final String PROC_NAME_POST_LOAN_MNG1 = "PostLoanMng1"; // 呆账贷款核销
	public static final String PROC_NAME_CREDIT_FREEZE_PROCESS = "PCreditFreezeProcess"; // 授信冻结
	public static final String PROC_NAME_CREDIT_UNFREEZE_PROCESS = "PCreditUnFreezeProcess"; // 授信解冻
	public static final String PROC_NAME_CREDIT_BACK_PROCESS = "PCreditBackProcess"; // 授信收回

	/** 贷款长流程 */
	public static final String PROC_NAME_LOAN_LONG_FLOW = "LoanApplyLongProcess";
	/** 贷款短流程 */
	public static final String PROC_NAME_LOAN_SHORT_FLOW = "LongApplyShortProcess";

	public static final String PROC_LOAN_ALTER_LONG_FLOW = "LoanAlterLongProcess";

	/** 贷款期限变更长流程 */
	public static final String PROC_NAME_POST_LOAN_TERM_CHG_FLOW = "PostLoanTermChgProcess";

	//担保方式变更长流程
	public static final String PROC_POST_LOAN_GUATTYPE_CHG_FLOW = "PostLoanGuattypeChgProcess";

	//利率变更长流程
	public static final String PROC_POST_LOAN_RATE_CHG_FLOW = "PostLoanRateChgProcess";

	// 企贷利率变更长流程
	public static final String PROC_POST_LOAN_RATE_CHG_FLOW4C = "PostLoanRateChgProcess4C";

	// 还款账号变更流程
	public static final String PROC_POST_LOAN_RTNACTNO_CHG_FLOW = "RtnActnoChgApprove";

	//个贷合同审批流程
	public static final String PROC_PLOAN_APPLY_PROCESS = "PLoanApplyProcess";

	//客户黑名单审批流程
	public static final String PROC_BLACKLIST = "BlackList";

	/*
	 * 提前还款审批流程
	 */
	public static final String PROC_RTNPLANQUERY_PROCESS = "RtnplanqueryProcess";

	// 流程名（兴业银银优化版）
	public static final String PROC_NAME_CREDIT_INCREASE = "CreditIncrease"; // 授信额度增加申请
	public static final String PROC_NAME_CREDIT_DECREASE = "CreditDecrease"; // 授信额度缩减申请
	public static final String PROC_NAME_CREDIT_REVOKE = "CreditRevoke"; // 授信额度收回申请
	public static final String PROC_NAME_CREDIT_FREEZE = "CreditFreeze"; // 授信额度冻结/解冻申请

	public static final String PROC_NAME_LAW_SUIT = "LawSuit"; // 诉讼申请
	public static final String PROC_NAME_DEBT_APPLY = "DebtApply"; // 贷款转抵债
	public static final String PROC_NAME_CONJUNCT_CHG = "ConjunctChg"; // 参贷人变更
	public static final String PROC_NAME_MGRNO_CHG = "MgrnoChg"; // 参贷人变更

	public static final String PROC_NAME_PROJECT_APPLY_CH = "合作项目建立";
	public static final String PROC_NAME_PROJECT_APPLY_1_CH = "合作项目修改";
	public static final String PROC_NAME_PROJECT_APPLY_2_CH = "合作项目终止";
	public static final String PROC_NAME_PROJECT_APPLY_A_CH = "合作项目建立(上海)";
	public static final String PROC_NAME_LOAN_ALTER_A_CH = "变更担保方式";
	public static final String PROC_NAME_LOAN_ALTER_A1_CH = "贷款利率变更";
	public static final String PROC_NAME_LOAN_ALTER_A2_CH = "贷款期限变更";
	public static final String PROC_NAME_LOAN_ALTER_A3_CH = "助学贷款展期申请";
	public static final String PROC_NAME_LOAN_ALTER_B_CH = "提前还款申请";
	public static final String PROC_NAME_LOAN_ALTER_B1_CH = "还款方式变更申请";
	public static final String PROC_NAME_LOAN_ALTER_B2_CH = "约定扣款日变更申请";
	public static final String PROC_NAME_LOAN_ALTER_B3_CH = "助学贷款转等额日变更申请";
	public static final String PROC_NAME_LOAN_ALTER_B4_CH = "助学贷款放款计划变更申请";
	public static final String PROC_NAME_LOAN_ALTER_B5_CH = "参贷人变更申请";
	public static final String PROC_NAME_CREDIT_APPLY_CH = "授信额度申请";
	public static final String PROC_NAME_CREDIT_EXTENSION_CH = "授信额度申请";
	public static final String PROC_NAME_LOAN_ALTER_C_CH = "LoanAlterC";
	public static final String PROC_NAME_LOAN_APPLY_CH = "贷款申请";
	public static final String PROC_NAME_LOAN_APPLYAAA_CH = "贷款申请";
	public static final String PROC_NAME_LOAN_APPLY_BRANCH_MODE_CH = "贷款申请(直属支行模式)";
	public static final String PROC_NAME_LOAN_APPLY_CENTER_MODE_CH = "贷款申请（个贷中心模式）";
	public static final String PROC_NAME_CREDIT_FREEZE_APPLY_CH = "额度冻结/解冻申请";
	public static final String PROC_NAME_CREDIT_ALTER_CH = "授信额度增加申请";
	public static final String PROC_NAME_CREDIT_ALTER1_CH = "授信额度收回申请";
	public static final String PROC_NAME_CREDIT_ALTER2_CH = "授信额度缩减申请";
	public static final String PROC_NAME_LOAN_ALTER_CH = "提前还款申请";
	public static final String PROC_NAME_LOAN_ALTER1_CH = "五级分类变更申请";

	public static final String PROC_NAME_LOAN_ALTER2_CH = "担保信息变更申请";
	public static final String PROC_NAME_LOAN_ALTER3_CH = "利率变更申请";
	public static final String PROC_NAME_LOAN_ALTER4_CH = "还款方式变更申请";
	public static final String PROC_NAME_LOAN_ALTER5_CH = "贷款期限变更申请";
	public static final String PROC_NAME_LOAN_ALTER6_CH = "参贷人变更申请";
	public static final String PROC_NAME_LOAN_ALTER7_CH = "客户经理变更申请";
	public static final String PROC_NAME_RTN_DATE_CHG_CH = "约定扣款日申请";

	public static final String PROC_NAME_POST_LOAN_MNG1_CH = "呆账贷款核销申请";

	public static final String TASK_NAME_AUDIT_TASK = "AuditTask";
	public static final String TASK_NAME_APPROVE_TASK = "ApproveTask";
	public static final String TASK_NAME_HEAD_APPROVE_TASK = "HeadApproveTask";
	public static final String TASK_NAME_FINAL_APPROVE_TASK = "FinalApproveTask";
	public static final String TASK_NAME_LOAN_FINAL_APPROVE_TASK = "LoanFinalApproveTask";
	public static final String TASK_NAME_CHECK_TASK = "CheckTask";
	public static final String TASK_NAME_LOAN_AUDIT_TASK = "LoanAuditTask";
	public static final String TASK_NAME_LOAN_APPROVE_TASK = "LoanApproveTask";


	//授信申请---临时 add  by huangy
	public static final String TASK_NAME_CREDIT_CHECK_TASK = "CreditCheckTask";
	public static final String TASK_NAME_CREDIT_INSURE_TASK = "CreditInsureTask";
	public static final String TASK_NAME_CREDIT_AUDIT_TASK = "CreditAuditTask";
	public static final String TASK_NAME_CREDIT_APPROVE_TASK = "CreditApproveTask";
	public static final String TASK_NAME_CREDIT_BACK_TASK = "CreditBackToModifyTask";

	//授信冻结、解冻
	public static final String TASK_NAME_CREDIT_FREEZE_APPROVE_TASK = "CreditFreezeApproveTask";
	// public static final String TASK_NAME_LOAN_SUPERVISER_TASK =
	// "LoanSuperviserTask";
	public static final String TASK_NAME_LOAN_CTR_APPROVE_TASK = "LoanCtrApproveTask";
	public static final String TASK_NAME_LOAN_CTR_AUDIT_TASK = "LoanCtrAuditTask";
	public static final String TASK_NAME_BRANCH_AUDIT_TASK = "BranchAuditTask";
	public static final String TASK_NAME_BRANCH_APPROVE_TASK = "BranchApproveTask";
	public static final String TASK_NAME_SUB_BRANCH_AUDIT_TASK = "SubBranchAuditTask";
	public static final String TASK_NAME_SUB_BRANCH_APPROVE_TASK = "SubBranchApproveTask";
	public static final String TASK_NAME_BRANCH_UP_APPROVE_TASK = "BranchUpApproveTask";
	public static final String TASK_NAME_LOAN_MODIFY_TASK = "LoanModifyTask";
	public static final String TASK_NAME_BACK_TO_MODIFY_TASK = "BackToModifyTask";
	public static final String TASK_NAME_LOAN_CTR_SUPERVISE_TASK = "LoanCtrSupervise";
	public static final String TASK_NAME_BRANCH_SUPERVISE_TASK = "BranchSupervise";
	public static final String TASK_NAME_LOAN_SUPERVISE_TASK = "LoanSuperviseTask";
	public static final String TASK_NAME_MGR_CONFIRM_TASK = "MgrConfirmTask";
	public static final String TASK_NAME_DEMAND_LOAN_TASK = "DemandLoanTask";
	/*
	 * 五级分类变更申请 Add by zxyue 2008 02-29
	 */
	public static final String PROC_NAME_FIVE_CLASS_A_CH = "五级分类变更申请";

	/*
	 * 贷款转抵债申请 Add by zxyue 2008 03-05
	 */
	public static final String PROC_NAME_DEBT_APPLY_A_CH = "贷款转抵债申请";

	/*
	 * 呆账核销申请
	 */
	public static final String PROC_NAME_BADDEBT_APPLY_A_CH = "呆账核销申请";

	/*
	 * 诉讼申请
	 */
	public static final String PROC_NAME_LAWSUIT_APPLY_A_CH = "诉讼申请";

	public static final String TASK_NAME_AUDIT_TASK_CH = "审查";
	public static final String TASK_NAME_LOAN_CTR_AUDIT_TASK_CH = "个贷中心审查";
	public static final String TASK_NAME_BRANCH_AUDIT_TASK_CH = "个贷中心审查";
	public static final String TASK_NAME_SUB_BRANCH_AUDIT_TASK_CH = "支行审查";
	public static final String TASK_NAME_APPROVE_TASK_CH = "审批";
	public static final String TASK_NAME_LOAN_SUPERVISER_TASK = "LoanSuperviserTask";
	public static final String TASK_NAME_LOAN_CTR_APPROVE_TASK_CH = "个贷中心审批";
	public static final String TASK_NAME_BRANCH_APPROVE_TASK_CH = "个贷中心审批";
	public static final String TASK_NAME_SUB_BRANCH_APPROVE_TASK_CH = "支行审批";
	public static final String TASK_NAME_BRANCH_UP_APPROVE_TASK_CH = "个贷中心高级审批";
	public static final String TASK_NAME_HEAD_APPROVE_TASK_CH = "总行审批";
	public static final String TASK_NAME_FINAL_APPROVE_TASK_CH = "审批";
	public static final String TASK_NAME_CHECK_TASK_CH = "复核";
	public static final String TASK_NAME_LOAN_AUDIT_TASK_CH = "贷审会审批";
	public static final String TASK_NAME_LOAN_SUPERVISER_TASK_CH = "放款监督";
	public static final String TASK_NAME_LOAN_CTR_SUPERVISE_TASK_CH = "个贷中心放款监督";
	public static final String TASK_NAME_BRANCH_SUPERVISE_TASK_CH = "分行放款监督";
	public static final String TASK_NAME_LOAN_FINALAPPROVE_TASK_CH = "终审";
	public static final String TASK_NAME_LOAN_MODIFY_TASK_CH = "退回修改";
	public static final String TASK_NAME_MGR_CONFIRM_TASK_CH = "客户经理确认";
	public static final String TASK_NAME_BACK_TO_MODIFY_TASK_CH = "退回修改";
	public static final String TASK_NAME_LOAN_SUPERVISE_TASK_CH = "放款监督";
	public static final String TASK_NAME_DEMAND_LOAN_TASK_CH = "放款";

	public static final String TASK_NAME_AUDIT_TASK_CH_STANDBY = "待审查";
	public static final String TASK_NAME_LOAN_CTR_AUDIT_TASK_CH_STANDBY = "待个贷中心审查";
	public static final String TASK_NAME_BRANCH_AUDIT_TASK_CH_STANDBY = "待个贷中心审查";
	public static final String TASK_NAME_SUB_BRANCH_AUDIT_TASK_CH_STANDBY = "待支行审查";
	public static final String TASK_NAME_APPROVE_TASK_CH_STANDBY = "待审批";
	public static final String TASK_NAME_LOAN_CTR_APPROVE_TASK_CH_STANDBY = "待个贷中心审批";
	public static final String TASK_NAME_BRANCH_APPROVE_TASK_CH_STANDBY = "待个贷中心审批";
	public static final String TASK_NAME_SUB_BRANCH_APPROVE_TASK_CH_STANDBY = "待支行审批";
	public static final String TASK_NAME_BRANCH_UP_APPROVE_TASK_CH_STANDBY = "待个贷中心高级审批";
	public static final String TASK_NAME_HEAD_APPROVE_TASK_CH_STANDBY = "待总行审批";
	public static final String TASK_NAME_FINAL_APPROVE_TASK_CH_STANDBY = "待审批";
	public static final String TASK_NAME_CHECK_TASK_CH_STANDBY = "待复核";
	public static final String TASK_NAME_LOAN_AUDIT_TASK_CH_STANDBY = "待贷审会审批";
	public static final String TASK_NAME_LOAN_SUPERVISER_TASK_CH_STANDBY = "待放款监督";
	public static final String TASK_NAME_LOAN_CTR_SUPERVISE_TASK_CH_STANDBY = "待个贷中心放款监督";
	public static final String TASK_NAME_BRANCH_SUPERVISE_TASK_CH_STANDBY = "待分行放款监督";
	public static final String TASK_NAME_LOAN_FINALAPPROVE_TASK_CH_STANDBY = "待终审";
	public static final String TASK_NAME_LOAN_MODIFY_TASK_CH_STANDBY = "待退回修改";
	public static final String TASK_NAME_MGR_CONFIRM_TASK_CH_STANDBY = "待客户经理确认";
	public static final String TASK_NAME_BACK_TO_MODIFY_TASK_CH_STANDBY = "待退回修改";
	public static final String TASK_NAME_LOAN_SUPERVISE_TASK_CH_STANDBY = "待放款监督";
	public static final String TASK_NAME_DEMAND_LOAN_TASK_CH_STANDBY = "待放款";

	public static final String WORK_FLOW_STATUS_UPLOAD = "已上传";
	public static final String WORK_FLOW_STATUS_AUDIT = "已审查";
	public static final String WORK_FLOW_STATUS_AUDIT_CTR = "已个贷中心审查";
	public static final String WORK_FLOW_STATUS_AUDIT_BRANCH = "已个贷中心审查";
	public static final String WORK_FLOW_STATUS_AUDIT_SUB_BRANCH = "已支行审查";
	public static final String WORK_FLOW_STATUS_APPROVE = "已审批";
	public static final String WORK_FLOW_STATUS_APPROVE_CTR = "已个贷中心审批";
	public static final String WORK_FLOW_STATUS_APPROVE_BRANCH = "已个贷中心审批";
	public static final String WORK_FLOW_STATUS_APPROVE_SUB_BRANCH = "已支行审批";
	public static final String WORK_FLOW_STATUS_UP_APPROVE_BRANCH = "已个贷中心高级审批";
	public static final String WORK_FLOW_STATUS_CHECK = "已复核";
	public static final String WORK_FLOW_STATUS_AUDIT_MEETING = "已贷审会审批";
	public static final String WORK_FLOW_STATUS_BACK = "已退回";
	//add huangy
	public static final String WORK_FLOW_STATUS_INSURE = "已核准";

	public static final String BIZ_CLASS_PROJECT = "商户管理";
	public static final String BIZ_CLASS_POST_LOAN_ALTER = "贷后变更";
	public static final String BIZ_CLASS_CREDIT = "额度管理";
	public static final String BIZ_CLASS_LOAN = "贷款申请";
	public static final String BIZ_CLASS_POST_LOAN_MNG = "贷后管理";
	public static final String BIZ_CLASS_ASSET_PROTECTION = "资产保全";

	public static final int WORK_FLOW_STATUS_AGREE = 0;
	public static final int WORK_FLOW_STATUS_TOSUBCTR = 1;
	public static final int WORK_FLOW_STATUS_TOCTR = 2;
	public static final int WORK_FLOW_STATUS_SUBBRHPREAPV = 3;
	public static final int WORK_FLOW_STATUS_SUBBRHMEETING = 4;
	public static final int WORK_FLOW_STATUS_SUBBRHAPV = 5;
	public static final int WORK_FLOW_STATUS_TOTBRHPREAPV = 6;
	public static final int WORK_FLOW_STATUS_TOTBRHAPV = 7;
	public static final int WORK_FLOW_STATUS_LOAN = 8;
	public static final int WORK_FLOW_STATUS_REFUSE = 9;
	public static final int WORK_FLOW_STATUS_GOBACK = 10;
	public static final int WORK_FLOW_STATUS_SUBMIT = 11;
	public static final int WORK_FLOW_STATUS_SKIP = 12;
	public static final int WORK_FLOW_STATUS_TOEND = 99;
	public static final int WORK_FLOW_STATUS_TONEXT = 100;

	// 转逾/转非应计
	public static final String LOAN_TO_OVERDUE = "1"; // 转逾
	public static final String LOAN_TO_IDLE = "2"; // 转非应计

	// 登记档案（权利品）操作流水
	public static final String OPRTYPE_DOC = "1"; // 档案
	public static final String OPRTYPE_GUA = "2"; // 权利品

	// 权利品类型
	public static final String GUARANTEETYPE_MORT = "1"; // 抵押
	public static final String GUARANTEETYPE_IMPAWN = "2"; // 质押

	// 权利品出借状态
	public static final String LENDSTATE_YES = "1"; // 已出借
	public static final String LENDSTATE_NO = "0"; // 未出借

	/**
	 * modify by shen_antonio 20080327 for TlrLvdayService 销假状态
	 */
	public static final String TLRLV_CL_STATUS_0 = "0";// 休假申请中(未销假)
	public static final String TLRLV_CL_STATUS_1 = "1";// 申请已同意
	public static final String TLRLV_CL_STATUS_2 = "2";// 申请已拒绝
	public static final String TLRLV_CL_STATUS_3 = "3";// 已销假
	public static final String TLRLV_CL_STATUS_4 = "4";// 申请已撤销
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

	public static final String CONTEXT_BIZ_LOG_MISC = "biz_log_misc"; // 用于记录流水的上下文键值

	/**
	 * add by zxyue 2008-04-11
	 */
	public static final int TERM_TYPE_CHG = 190;// 贷款期限变更方式

	/**
	 * add by fan 2008-7-2 贷后变更交易码
	 */
	public static final String FUNC_CODE_FIVE_CLASS_APPLY = "60101";// 五级分类变更申请

	public static final String FUNC_CODE_FIVE_CLASS_APPROVE = "60102";// 五级分类变更审批

	public static final String FUNC_CODE_RTN_ADV_APPLY = "60201";// 提前还款申请

	public static final String FUNC_CODE_RTN_ADV_APPROVE = "60202";// 提前还款审批

	public static final String FUNC_CODE_GUARANTEE_CHG_APPLY = "60301";// 变更担保信息申请

	public static final String FUNC_CODE_GUARANTEE_CHG_UPLOAD = "60302";// 变更担保信息申请上传

	public static final String FUNC_CODE_GUARANTEE_CHG_APPROVE = "60303";// 变更担保信息审批

	public static final String FUNC_CODE_INTRATE_CHG_APPLY = "60401";// 贷款利率变更申请

	public static final String FUNC_CODE_INTRATE_CHG_APPROVE = "60402";// 贷款利率变更审批

	public static final String FUNC_CODE_TERM_EXTEND_APPLY = "60501";// 贷款期限变更申请

	public static final String FUNC_CODE_TERM_EXTEND_APPROVE = "60502";// 贷款期限变更审批

	public static final String FUNC_CODE_RTN_TYPE_CHG_APPLY = "60601";// 还款方式变更申请

	public static final String FUNC_CODE_RTN_TYPE_CHG_APPROVE = "60602";// 还款方式变更审批

	public static final String FUNC_CODE_RTN_DATE_CHG_APPLY = "60701";// 约定扣款日变更

	public static final String FUNC_CODE_RTN_ACTNO_CHG_APPROVE = "60801";// 还款帐号变更

	public static final String FUNC_CODE_ADDR_CHG_APPLY = "60901";// 帐单地址变更

	/*
	 * 商行金融机构代码 人行征信使用 add jiang@20080725
	 */
	public static final String BANK_CODE_JINGZHOU = "D10025370H0004";// 荆州

	// 与征信系统的字典转换 add by wuzhiwei
	public static final int DATADIC_MAPTYPE_INTERVAL = 17; // 还款频率

	/**
	 * 虚拟合作项目,合作尚
	 */
	public static final String TEMP_PROJECT_NO = "999999999999"; // 虚拟合作项目编号
	public static final String TEMP_PROJECT_NAME = "虚拟合作项目"; // 虚拟合作项目名称

	public static final String TEMP_CORP_IDNO = "99999999"; // 虚拟商编号
	public static final String TEMP_CORP_IDNAME = "虚拟合作商"; // 虚拟商名称
	/**
	 * 贷款种类
	 */
	public static final String BRCODE_LNID_HEAD = "9999"; // 9999-总行标志
	public static final String WORK_FLOW_PARAM_CONFFILENAME = "workflowparam";// 为工作流参数配置表页面下拉设置

	/**
	 * 主机-核心系统处理过返回文件存放路径
	 */
	public static final String maturityOrOverdue = "aceResultFilePath";

	/**
	 * 到期/逾期
	 */

	public static final String MATURITY_OR_OVERDUE_MATURITY = "1";// 到期

	public static final String MATURITY_OR_OVERDUE_OVERDUE = "2";// 逾期

	public static final String MATURITY_OR_OVERDUE_MATURITY_SELECT = "到期提醒";

	public static final String MATURITY_OR_OVERDUE_OVERDUE_SELECT = "逾期提醒";

	public static final String DATA_DIC_HEAD_SUB = "1";

	public static final String DATA_DIC_HEAD_BRANCH_SUB = "2";

	/**
	 * 工作流人员分配默认值
	 */
	public static final String ROLE_DEFINFE_TLRNO = "XXXXXXXX"; // 默认值分配

	/**
	 * 查询类下载 合同信息查询 add by wuzhiwei 2008-10-6
	 */
	public static final String LOAN_INFO_QUERY = "loanInfoQuery"; // 默认值分配

	/**
	 * 查询类下载 客户信息查询 add by wuzhiwei 2008-10-6
	 */
	public static final String CUSTOMER_INFO_QUERY = "customerInfoQuery"; // 默认值分配

	/**
	 * 查询类下载 借据信息查询 add by wuzhiwei 2008-10-6
	 */
	public static final String LOAN_CINO_QUERY = "loanCinoQuery"; // 默认值分配
	public static final String LN_DEFAULT_CLR_DATE = "3999-12-31";// 默认截止日期

	/**
	 * 查询类下载 贷款汇总信息查询 add by wuzhiwei 2008-10-6
	 */
	public static final String COLLECT_QUERY = "CollectQuery"; // 默认值分配

	/**
	 * 查询类下载 贷款明细信息查询 add by wuzhiwei 2008-10-6
	 */
	public static final String LOAN_LOG_INFO_QUERY = "LoanLogInfoQuery"; // 默认值分配

	/**
	 * 查询类下载 贷款汇总信息查询 add by wuzhiwei 2008-10-6
	 */
	public static final String RTN_PLAN_QUERY = "RtnPlanQuery"; // 默认值分配

	/**
	 * 查询类下载 贷款汇总信息查询 add by wuzhiwei 2008-10-6
	 */
	public static final String TLA_LNPLANMR_QUERY = "TlaLnplanmrQuery"; // 默认值分配
	/**
	 * 经受任务查询 各流程的业务主键 add by UU_Wu 2008-10-15
	 */
	public static final int CHECK_ISERROR = 0; // 未能找到业务主键
	public static final int CHECK_ISCON = 1; // 合同号为业务主键
	public static final int CHECK_ISJJ = 2; // 借据号为业务主键
	public static final int CHECK_ISPROJ = 3; // 合作项目编号为业务主键

	/**
	 * 显示条件 add by UU_Wu 2008-10-15
	 */
	public static final String DISPLAY_CONDITION_ALL = "1"; // 1-所有
	public static final String DISPLAY_CONDITION_NOT_MATURITY = "2"; // 2-未到期
	public static final String DISPLAY_CONDITION_OWE_AND_NOT_MATURITY = "3"; // 3-欠款+未到期
	public static final String DISPLAY_CONDITION_OWE = "4"; // 4-欠款

	/**
	 * 灵活查询 还款周期 add by wuzhiwei 2008-10-22
	 */
	public static final String RTN_LOAN_AIGLE_DAY = "0";// 日
	public static final String RTN_LOAN_AIGLE_MTH = "1";// 月
	public static final String RTN_LOAN_AIGLE_THREE_MTH = "2";// 季
	public static final String RTN_LOAN_AIGLE_YEEA = "3";// 年
	public static final String RTN_LOAN_AIGLE_HALF_YEAR = "4";// 半年

	/**
	 * 贷款宽限期 计息标志 1-是 2-否
	 */
	public static final String RTN_IS_DOGFLAG = "1";// 是
	public static final String RTN_NOT_IS_DOGFLAG2_NO = "2";// 否

	/**
	 * 宽限期标志
	 */
	public static final String DOGTYPE_NONE = "0";// 无宽限期
	public static final String DOGTYPE_DAY = "1";// 按日计算
	public static final String DOGTYPE_MONTH_END = "2";// 宽限至月底

	/**
	 * 与核心交互的核心标准设置 0-不与核心交互false 1-与核心交互 true
	 */

	public static final boolean CORE_GD_IS_FLAG = true;// 1-与核心交互 true
	public static final boolean CORE_GD_NOT_IS_FLAG = false;// 0-不与核心交互false

	/**
	 * 评分要素
	 */
	public static final int CUSTGRADE_MODEL_SEX = 1;// 性别 0
	public static final int CUSTGRADE_MODEL_MARRIAGE = 2;// 婚姻状况 0
	public static final int CUSTGRADE_MODEL_AGE = 3;// 年龄 2

	public static final int CUSTGRADE_MODEL_EDULEVEL = 5;// 文化程度 0
	public static final int CUSTGRADE_MODEL_SOCIALSECURITSTATUS = 6;// 社会保障状态 0
	public static final int CUSTGRADE_MODEL_HEALTHSTATUS = 7;// 健康状况 0
	public static final int CUSTGRADE_MODEL_CURRRESIDEYEARS = 8;// 居住年限 1

	public static final int CUSTGRADE_MODEL_CORPPRO = 9;// 单位性质 0
	public static final int CUSTGRADE_MODEL_TITLE = 10;// 职称 0
	public static final int CUSTGRADE_MODEL_POSTPRO = 11;// 岗位性质 0
	public static final int CUSTGRADE_MODEL_JOBYEARS = 12;// 工作年限 1

	public static final int CUSTGRADE_MODEL_INDVINCOME = 13;// 月收入 2
	public static final int CUSTGRADE_MODEL_FAMILYINCOME = 14;// 家庭月收入 2
	public static final int CUSTGRADE_MODEL_RTNRATE = 15;// 还贷比 1
	public static final int CUSTGRADE_MODEL_HOUSEWORTH = 16;// 房产价值 1
	public static final int CUSTGRADE_MODEL_OTHERWORTH = 17;// 其他价值 1
	public static final int CUSTGRADE_MODEL_AVERAGEBAL = 18;// 日均收入 1

	public static final int CUSTGRADE_MODEL_CREDITSTATUS = 20;// 人行征信情况 0
	public static final int CUSTGRADE_MODEL_OTHERCREDIT = 21;// 其他信用情况 0
	public static final int CUSTGRADE_MODEL_ACCOUNTSTATUS = 22;// 帐户开立情况 0

	/**
	 * Calendar 日期常量 add by wuzhiwei 2009-1-8
	 */
	public static final int CURRENT_MONTH = 1;// 本月份
	public static final int PREVIOUS_MONTH = 2;// 上月份
	public static final int NEXT_MONTH = 0;// 下月份

	/**
	 * 征信状态设定
	 */
	public static final String NOUPDATA_UPLOAD = "0";// 不需修改，已上报
	public static final String WAIT_UPDATA = "1";// 待修改
	public static final String UPDATA_WAITUPLOAD = "2";// 修改完待重报
	public static final String REUPLOAD = "3";// 已重报

	/**
	 * 自然人身份描述
	 */
	public static final String CUSTTYPE_LOAN_LOANER = "借款人"; // 借款人
	public static final String CUSTTYPE_GUARANTOR_LOANER = "关系人"; // 关系人
	public static final String CUSTTYPE_ENTERLOAN_GUARANTEE = "参贷人"; // 参贷人

	/**
	 * 年月天数转换标量
	 */
	public static final int DAYS_NUM_OF_YEAR = 365; // 一年按365天算
	public static final int DAYS_NUM_OF_MONTH = 30; // 一月按30天算

	/**
	 * 客户确认问题
	 */
	public static final int CUSTOMER_CONFIRM_QUESTION_TYPENUMBER = 3; // 问题类型数量
	public static final int CUSTOMER_CONFIRM_QUESTION_PERTYPECOUNT = 1; // 每类问题题目数

	// 广发贷后检查报告状态
	public static final String GF_MONTITOR_STATUS_IN = "0"; // 已录入（修改）
	public static final String GF_MONITOR_STATUS_OUT = "1"; // 已退回
	public static final String GF_MONITOR_STATUS_CHECK = "3"; // 已复核
	public static final String GF_MONITOR_STATUS_SEND = "2"; // 已提交 add by
																// huabin
																// 2008-8-13
	public static final String GF_MONITOR_STATUS_CONFIRM = "4"; // 已认定 gz
	public static final String MONTITOR_SPOTE_STATUS_CHECKED = "0"; // 未抽查
	public static final String MONTITOR_SPOTE_STATUS_UNCHECKED = "1"; // 已抽查

	// 广发五级分类调整状态
	public static final String CLR_CLASS_STATUS_ZHCH = "0"; // 正常(借据信息的调整字段);
	public static final String CLR_CLASS_STATUS_YCF = "1"; // 已初分(支行贷后检查岗);
	public static final String CLR_CLASS_STATUS_YCS = "2"; // 已认定（或已复核，支行贷后检查复核岗）;
	public static final String CLR_CLASS_STATUS_YFS = "3"; // 已复审(或已审批);
	public static final String CLR_CLASS_STATUS_YSD = "4"; // 已审定(分行复分认定岗)
	public static final String CLR_CLASS_STATUS_NO = "5"; // 已拒绝


	// 广发总行清分类型
	public static final String CLR_CLASS_TYPE_DAILY = "1"; // 日常清分
	public static final String CLR_CLASS_TYPE_MONTHLY = "2"; // 月度清分
	public static final String CLR_CLASS_TYPE_ELSE = "3"; // 其它月份

	/**
	 * WPS中使用的审批意见
	 */
	public static final String GF_APP_ATTITUDE_AGREE = "0"; // 0-同意
	public static final String GF_APP_ATTITUDE_REJECT = "1"; // 1-拒绝
	public static final String GF_APP_ATTITUDE_BACKTO_LATEST = "2"; // 2-退回前一级
	public static final String GF_APP_ATTITUDE_BACKTO_FIRST = "3"; // 3-退回修改
	public static final String GF_APP_ATTITUDE_NOT_AGREE = "4"; // 4-不同意(该参数不在WPS中使用,审查岗使用该意见,但是在流程中需要转换成0-同意)

	public final static String GF_APP_OVERFLAG_0 = "0";// 没有超限
	public final static String GF_APP_OVERFLAG_1 = "1";// 超限

	/**
	 * 广发合作项目service
	 */
	public static final int SEND_QUERY_FLAG = 1;
	public static final int MODIFY_QUERY_FLAG = 2;
	public static final int QUERY_FLAG = 3;
	public static final int STOP_QUERY_FLAG = 4;
	public static final int FREEZE_QUERY_FLAG = 6;
	public static final int UNFREEZE_QUERY_FLAG = 7;

	/**
	 * 自然人身份描述
	 */
	public static final String CUST_INDV_DESCRIBE_MAIN_LOANER = "主借款人"; // 借款人
	public static final String CUST_INDV_DESCRIBE_OTHER_LOANER = "共同借款人"; // 共同借款人
	public static final String CUST_INDV_DESCRIBE_GUARANTEE = "担保人"; // 担保人
	public static final String CUST_INDV_DESCRIBE_OTHER = "其他"; // 其他
	public static final String CUST_INDV_DESCRIBE_RELATION = "关系人"; // 关系人

	// 统计分析 start
	public static final String BRCODE_CLASS_HEAD_CENTER = "A"; // 总行审批中心
	public static final String BRCODE_CLASS_NETBRANCH = "3"; // 网点
	public static final String BRCODE_CLASS_AREA_CENTER = "B"; // 区域审批中心

	/**
	 * 统计类型 huabin 20080729
	 */
	public final static String GF_STATISTIC_DAY = "1"; // 日
	public final static String GF_STATISTIC_XUN = "2"; // 旬
	public final static String GF_STATISTIC_MONTH = "3"; // 月
	public final static String GF_STATISTIC_YEAR = "4"; // 年

	/**
	 * 逾期天数状态
	 */
	public static final String OVD_DAYS_STAT_EXPTHIRTY = "02"; // 1-30天逾期
	public static final String OVD_DAYS_STAT_EXPSIXTY = "03"; // 30-60天逾期
	public static final String OVD_DAYS_STAT_EXPNINETY = "04"; // 60-90天逾期
	public static final String OVD_DAYS_STAT_EXPHANTWE = "05"; // 90-120天逾期
	public static final String OVD_DAYS_STAT_EXPHANFIF = "06"; // 120-150天逾期
	public static final String OVD_DAYS_STAT_EXPHANEIT = "07"; // 150-180天逾期
	public static final String OVD_DAYS_STAT_EXPTHANTE = "08"; // 180-210天逾期
	public static final String OVD_DAYS_STAT_EXPTHANTEU = "09"; // 210天以上逾期

	/**
	 * 贷款期限范围 huabin 20080801
	 */
	public static final String TERM_RANGE_ONE_MONTH = "01"; // 1个月以内贷款
	public static final String TERM_RANGE_ONETOTHREE_MONTH = "02"; // 1-3个月贷款
	public static final String TERM_RANGE_THREETOSIX_MONTH = "03"; // 3-6个月贷款
	public static final String TERM_RANGE_SIXTONINE_MONTH = "04"; // 6-9个月贷款
	public static final String TERM_RANGE_ONE_YEAR = "05"; // 9-12个月贷款
	public static final String TERM_RANGE_ONETOTWO_YEAR = "06"; // 1-2年贷款
	public static final String TERM_RANGE_TWOTOTHREE_YEAR = "07"; // 2-3年贷款
	public static final String TERM_RANGE_THREETOTHIRD_YEAR = "08"; // 3-4年贷款
	public static final String TERM_RANGE_THIRDTOFIVE_YEAR = "09"; // 4-5年贷款
	public static final String TERM_RANGE_FIVETOTEN_YEAR = "10"; // 5-10年贷款
	public static final String TERM_RANGE_TENTOFIFTY_YEAR = "11"; // 10-15年贷款
	public static final String TERM_RANGE_FIFTYTOTWENTY_YEAR = "12"; // 15-20年贷款
	public static final String TERM_RANGE_TWENTYUP_YEAR = "13"; // 20年以上

	// add by huabin 2008-8-2
	public static final int DATADIC_TYPE_OVDDAYVALUE = 6006;// 贷款逾期天数(分析指标)

	// 统计分析 end

	public static final String GRADE_TYPE_CUSTOMER_ELEMENT = "0"; // 个人因素
	public static final String GRADE_TYPE_CORP_ELEMENT = "1"; // 专卖店因素
	public static final String GRADE_TYPE_BUSINESS_ELEMENT = "2"; // 对公因素

	// 客户评分模型
	public static final int DATADIC_TYPE_GRADE_CUST = 7001; // 要素类别-客户要素
	public static final int DATADIC_TYPE_GRADE_CORP = 7002; // 要素类别-客户要素
	public static final int DATADIC_TYPE_GRADE_BIZ = 7003; // 要素类别-业务要素

	// 放款信息确认
	public static final String ATTITUDE_ISCUSTOMS_HASGRANT = "3"; // 个贷放款申请通过
	public static final String ATTITUDE_ISCUSTOMS_HASNOT_APPLY = "2"; // 个贷客户经理未确认
	public static final String ATTITUDE_ISCUSTOMS_HASAPPLY = "0"; // 个贷放款审批通过

	/**
	 * 树型结构定义用于生成页面权限
	 */
	public static int TREE_ROOT = 0;
	public static int TREE_TREE_FLAG = 1;
	public static int TREE_MENU_FLAG = 2;

	public static final String ADV_RTN_APPLYED = "0";// 提前还款提交
	public static final String ADV_RTN_APPROVED = "1";// 提前还款审批通过
	public static final String ADV_RTN_AUDITED = "2";// 提前还款复核通过
	public static final String ADV_RTN_REFUSED = "3";// 提前还款申请被拒绝
	public static final String ADV_RTN_CANCELED = "4";// 提前还款申请被撤回

	/**
	 * 调用SBS核心接口开关
	 */
	public static final String SBS_SWITCH = "0";// 1-打开 0-关闭

	/**
	 * 顺延方式 add by znh
	 */
	public static final String DELAY_VALUE_FLAG_YES = "Y";// YES
	public static final String DELAY_VALUE_FLAG_NO = "N";// NO
	public static final String DELAY_VALUE_FLAG_CUST = "C";// 用户自定义
	public static final String DELAY_VALUE_FLAG_CUST_IN = "A";// 用户手工设置

	/**
	 * Yes or No
	 */
	public static final String VALUE_FLAG_YES = "Y";// YES
	public static final String VALUE_FLAG_NO = "N";// NO

	/**记账系统参数标志
	 * */
	public static final String ACE_PRARM = "SYSTEMACE";// 记账参数群
	public static final String ACE_PRARM_IS = "0";// 是否记账
	public static final String ACE_PRARM_NUMBER = "0";// 是否进行账户处理
	public static final String ACE_PRARM_SINGLE = "2";//是否允许记单边账 是/否

	/**
	 * 凭证品种定义
	 */
	public static final String CREDENCETYPE_B0 = "B0";// 五级分类人工认定用-个贷
	public static final String CREDENCETYPE_B1 = "B1";// 借款凭证
	public static final String CREDENCETYPE_B2 = "B2";// 贴现凭证
	public static final String CREDENCETYPE_B3 = "B3";// 信用证凭证
	public static final String CREDENCETYPE_B4 = "B4";// 保函凭证
	public static final String CREDENCETYPE_B5 = "B5";// 展期凭证
	public static final String CREDENCETYPE_B6 = "B6";// 承兑凭证
	public static final String CREDENCETYPE_B7 = "B7";// 委托凭证


	/** 规则引擎参数配置
	 * Added By HuangWeijing 20100908 TLS-396 Begin */

	/** 规则引擎参数 PF_SYS_PARAM ID*/
	public static final String RULE_SYSPARAM_ID = "RULE";

	/** 规则引擎开关 MAGIC_ID */
	public static final String RULE_SWITCH_MAGIC_ID = "RULE_SWITCH";
	/** 规则引擎开关 1-打开 */
	public static final String RULE_SWITCH_ON = "1";
	/** 规则引擎开关 0-关闭 */
	public static final String RULE_SWITCH_OFF = "0";

	/** TLS-396 End */

	/** 操作日志参数 PF_SYS_PARAM ID */
	public static final String SYSPARAM_ID_BIZ_LOG = "BLOG";
	/** 是否需要记录操作日志 */
	public static final String MAGIC_ID_NEEDLOG = "NEEDLOG";
	/** 是否需要记录查询类日志 */
	public static final String MAGIC_ID_NEEDQUERYLOG = "NEEDQUERYLOG";


	/** 贷款审批金额分隔线，大于等于的走长流程，小于的走短流程*/
	public static final double LOAN_AMT_SEPARATOR = 10000;

	public static final String LOAN_CREDIT_TYPE = "N10";//贷款大类-消费信贷

	/** 贷后变更 交易种类
	 * 1-提前还款
	 * 2-担保信息变更
	 * 3-贷款利率变更
	 * 4-贷款期限变更
	 * 5-还款方式变更
	 * 6-还款账号变更
	 * 7-账单地址变更
	 * 8-约定扣款日变更
	 * 9-五级分类变更
	 * */
	public static final String POST_LOAN_MNG_ADVRTN = "1";
	public static final String POST_LOAN_MNG_GUATTYPE = "2";
	public static final String POST_LOAN_MNG_INTCHG = "3";
	public static final String POST_LOAN_MNG_TERM = "4";
	public static final String POST_LOAN_MNG_RTNWAY = "5";
	public static final String POST_LOAN_MNG_RTNACTNO = "6";
	public static final String POST_LOAN_MNG_ADDCHG = "7";
	public static final String POST_LOAN_MNG_RTNDATE = "8";
	public static final String POST_LOAN_MNG_FIVECLASS = "9";



	/**[流水日志用交易码表 交易类型
	 * 00-查询类 01-额度类 02-放款类 03-贷后管理类 04-客户管理类 99-系统管理类
	 * */
	public static final String BIZ_FUNC_TYPE_QUERY = "00";
	public static final String BIZ_FUNC_TYPE_CREDIT = "01";
	public static final String BIZ_FUNC_TYPE_GRANT_LOAN = "02";
	public static final String BIZ_FUNC_TYPE_POST_LOAN = "03";
	public static final String BIZ_FUNC_TYPE_CUSTMNG = "04";
	public static final String BIZ_FUNC_TYPE_SYSMNG = "99";

	//是否查询下属机构标志
	public static final String BRANCH_FLAG_SELF = "1";   //本机构
	public static final String BRANCH_FLAG_DOWN = "2";   //本机构及其下属机构

	/**
	 * 顺延方式
	 */
	public static final String DELAYTYPE_1 = "1";// 系统自动调整顺延天数
	public static final String DELAYTYPE_2 = "2";// 用户自由指定顺延天数

	public static final String BRCODE_INTER = "1302";//国际业务部
	public static final String BUSINESSDEPARMENT="1391";    //公司业务部

	/* add by kangbyron 不良资产 begin  */


	/**
	 * 不良资产移交类型
	 */
	public static final String NPA_TRANS_TYPE_TRANS = "1";	//1-向资产保全部移交
	public static final String NPA_TRANS_TYPE_SEND = "2";	//2-分发
	public static final String NPA_TRANS_TYPE_RETRANS = "3";	//3-资产保全部逆移交
	public static final String NPA_TRANS_TYPE_DISSEND = "4";	//2-分发


	/**
	 * 资产保全岗位
	 */
	public static final int NPA_ROLE_SEND = 120;  // 资产保全分发岗
	public static final int NPA_ROLE_MANAGER = 121;  // 资产保全管户岗

	public static final int VALUE_NO_ASSETS = 1;  // 抵债资产编号生成valueNo
	public static final String VALUE_INDEX_ASSETS = "ASSET_NO";  // 抵债资产编号生成valueIndex
	public static final int VALUE_NO_EVALUATION = 1;  // 价值评估编号生成valueNo
	public static final String VALUE_INDEX_EVALUATION = "EVALUATION_NO";  // 价值评估编号生成valueIndex

	public static final String NPA_RELA_TYPE_LAWSUIT="01";   //01-案件信息
	public static final String NPA_RELA_TYPE_ASSETS="02";   //02-抵债资产信息

	public static final String NPA_PRO_TYPE_01 = "01"; //01-出租
	public static final String NPA_PRO_TYPE_02 = "02"; //02-拍卖
	public static final String NPA_PRO_TYPE_03 = "03"; //03-协议转让
	public static final String NPA_PRO_TYPE_04 = "04"; //04-转固定资产

	/* add by kangbyron 不良资产 end  */

	/*********评分评级模型相关常定义***********begin:*********/
		/**
		 * 评分模型设置指标值类型
		 */
		public static final String LIMIT_FLAG_0 = "0"; //数据字典型定值
		public static final String LIMIT_FLAG_1 = "1"; //区间型定值
		public static final String LIMIT_FLAG_2 = "2"; //其它  可能存在没有指标业务当前值的情况
		//public static final String LIMIT_FLAG_3 = "3"; //设置上下限


		/**
		 * 评分指标值表达方式
		 * 1-数值定值
		 * 2-公式表示值
		 */
		public static final String SCORE_TYPE_1 = "1"; //数值定值
		public static final String SCORE_TYPE_2 = "2"; //公式表示值

		/**
		 * 定义指标得分公式中特殊代码
		 */
		        /****指标当前值***/
		public static final String MODEL_INDEX_CURRENT_VALUE = "X";
		       /****指标权重分***/
		public static final String MODEL_INDEX_WEIGHT_SCORE = "Y";

	      /****指标计划值***/
		public static final String MODEL_INDEX_PLAN_VALUE = "P";

	      /****指标得分标准***/
		public static final String MODEL_INDEX_STAND_SCORE = "S";
		/**
		 * */
		public static final String IS_SAVAVALUE_NO_EXAM = "0";  //0 - 保留模型指标业务具体值并不评分
		public static final String IS_YES_SAVAVALUE_EXAM = "1"; //1 - 同时保留模型指标业务值和评分

	/*********评分评级模型相关常定义***********end*********/

	/** 合并票据工作流到信贷系统 by zhouxuejing 20101026 begin*/
	/** 默认不限业务种类 0000 */
	public static final String DEFAULT_BUSSTYPE = "0000"; // 默认不限业务种类

	public static final String DEFAULT_BIZTYPE = "000000"; // 默认不限业务小类

	public static final String BRCODE_CLASS_SELF = "0"; // 发起行同级机构（工作流参数配置使用）
	/** 合并票据工作流到信贷系统 by zhouxuejing 20101026 end */


	/** 评分模型类型 */
	/** 1-客户评分类 */
	public static final String GRADE_MODEL_TYPE_CUST = "1";
	/** 2-机构考核评分类 */
	public static final String GRADE_MODEL_TYPE_BRANCH = "2";
	/** 3-人员考核评分类 */
	public static final String GRADE_MODEL_TYPE_PERSONAL = "3";
	/** 4-债项评分类 */
	public static final String GRADE_MODEL_TYPE_DEBT = "4";
	/** 5-利率定价类 */
	public static final String GRADE_MODEL_TYPE_RATE = "5";


	 /**
	  * 普通贷款凭证审批状态
	  */
		public static final String COMM_CREDENCE_INFO_PROVIDE_STATE_0 = "0";// - 未建立
		public static final String COMM_CREDENCE_INFO_PROVIDE_STATE_1 = "1";// - 已发送，但未收到IBS响应
		public static final String COMM_CREDENCE_INFO_PROVIDE_STATE_2 = "2";// - 资料建立
		public static final String COMM_CREDENCE_INFO_PROVIDE_STATE_3 = "3";// - 会计确认
		public static final String COMM_CREDENCE_INFO_PROVIDE_STATE_4 = "4";// - 会计确认取消
		public static final String COMM_CREDENCE_INFO_PROVIDE_STATE_5 = "5";// - 部分还款
		public static final String COMM_CREDENCE_INFO_PROVIDE_STATE_8 = "8";// -  垫款结清
		public static final String COMM_CREDENCE_INFO_PROVIDE_STATE_9 = "9";// -  结清

	/**
	 * 普通贷款凭证审批状态
	 */
		public static final String COMM_CREDENCE_INFO_APPROVE_STATE_X = "X"; //X- 无效
		public static final String COMM_CREDENCE_INFO_APPROVE_STATE_0 = "0"; //0 - 新建
		public static final String COMM_CREDENCE_INFO_APPROVE_STATE_1 = "1"; //1 - 审批中
		public static final String COMM_CREDENCE_INFO_APPROVE_STATE_2 = "2"; //2 - 审批通过
		public static final String COMM_CREDENCE_INFO_APPROVE_STATE_3 = "3"; //3 - 到期
		public static final String COMM_CREDENCE_INFO_APPROVE_STATE_4 = "4"; //4 - 取消

	/* add by kangbyron 20101113 城商联盟评分等级 begin  */
		public static final String GRADE_VALUE_1 = "1"; //1-AAA
		public static final String GRADE_VALUE_2 = "2"; //2-AA
		public static final String GRADE_VALUE_3 = "3"; //3-A
		public static final String GRADE_VALUE_4 = "4"; //4-BBB
		public static final String GRADE_VALUE_5 = "5"; //5-BB
		public static final String GRADE_VALUE_6 = "6"; //6-B
		public static final String GRADE_VALUE_7 = "7"; //7-CCC
		public static final String GRADE_VALUE_8 = "8"; //8-CC
		public static final String GRADE_VALUE_9 = "9"; //9-C
		public static final String GRADE_VALUE_10 = "10"; //10-D
		public static final String GRADE_VALUE_11 = "11"; //11-未评级

		public static final String GRADE_TERM_TYPE_MONTH="1"; //1-月
		public static final String GRADE_TERM_TYPE_SEASON="2"; //2-季
		public static final String GRADE_TERM_TYPE_HALF="3"; //3-半年
		public static final String GRADE_TERM_TYPE_YEAR="4"; //4-年

		public static final String GRADE_TERM_TYPE_LOAN="1"; //1-合同
		public static final String DEBT_GRADE_TYPE_CREDIT="2"; //2-授信

		//授信客户评级规则
		public static final String PF_SYS_PARAM_ID_101="101";
		public static final String PF_SYS_PARAM_MAGIC_ID_101="Special"; //专项授信
		public static final String PF_SYS_PARAM_ID_102="102";
		public static final String PF_SYS_PARAM_MAGIC_ID_102="Composite"; //综合授信
		//授信评级开关
		public static final String PF_SYS_PARAM_ID_103="103";
		public static final String PF_SYS_PARAM_MAGIC_ID_103="RatingSwitch";

		//还款方式变更标志
		public static final String APPLY_TYPE_CHG_RTN_ACTNO_PARARM="rtntype";




	/* add by kangbyron 20101113 城商联盟评分等级 end  */

		/* add by learncy.zou 20101230 begin*/
		//罚息收取方式
		public static final String PINTRATE_MODE_RATIO = "0";// 按比率收取
		public static final String PINTRATE_MODE_AMT = "1";// 按金额收取

		//业务类型
		public static final String BUSINESS_LOAN = "05";// 贷款业务
		public static final String BUSINESS_CREDIT = "SX";// 授信业务

		//利率浮动方式
		public static final String INTRATE_FLOATMODE_FLOAT = "0";// 0-浮动利率
		public static final String INTRATE_FLOATMODE = "1";// 1-固定利率

		public static final int DATADIC_TYPE_LOAN_TERM_TYPE_CTL = 459;// 贷款期限控制方式,按年,按月,按天

		public static final String LOAN_PAY_STATUS_NORMAL = "1";//支付状态-正常
		public static final String LOAN_PAY_STATUS_BACK = "2";//支付状态-退回(用于后台系统的退回)

		public static final String LOAN_PAY_TYPE_SELF = "1";//支付类型-自主支付
		public static final String LOAN_PAY_TYPE_COMPANY = "2";//支付类型-受托支付

		/**
		 * 额度循环标志
		 */
		public static String CYCLE_FLAG_ON = "1";//1-循环
		public static String CYCLE_FLAG_OFF = "2";//2-非循环

		//一次还本付息与一次还本分期付息，贷款期限控制 ,目前设置不能超过1年
		public static final int TERM_OF_ONE_RTN = 1;

	    /**
	     * 对于一次性还本分期付息和一次性还本付息的还款方式，是否适用与一年以上期限的贷款，在DATA_DIC_MAP中的key
	     */
	    public static final int DATADIC_MAPTYPE_LNID_RTNTYPE_RELATION = 445;

		//还款间隔
		public static final String RTN_INTERVAL_ONE_OFF = "1"; // 一次性还款
		public static final String RTN_INTERVAL_ONE_WEEK = "2";// 单周
		public static final String RTN_INTERVAL_TWO_WEEKS = "3";// 双周
		public static final String RTN_INTERVAL_MONTHLY = "4"; // 按月还款
		public static final String RTN_INTERVAL_SEASON = "5"; // 按季还款
		public static final String RTN_INTERVAL_HALF_YEAR = "6"; // 按半年还款
		public static final String RTN_INTERVAL_YEARLY = "7"; // 按年还款
		public static final String RTN_INTERVAL_FIXED_PERIOD = "8";// 固定周期(广发没有用到该参数,暂保留,这样以前的程序可以不改)
		public static final String RTN_INTERVAL_STUDY_ABROAD = "9"; // 按留学半年(广发没有用到该参数,暂保留,这样以前的程序可以不改)


		//出账审核类型
		public static final String PROC_FLAG_LOAN_PAY = "01";//普通贷款申请首次出账(该种类型在出帐审核流程中暂时不涉及,做预留,普通贷款的出帐在主贷款流程中)
		public static final String PROC_FLAG_LOAN_EXTRA_PAY = "02";//多次出账(包括普通贷款多次出账和授信子合同的多次出帐)
		public static final String PROC_FLAG_LOAN_CREDIT_DIRECT_PAY = "03"; //授信直接出账
		public static final String PROC_FLAG_LOAN_CREDIT_LOAN_PAY = "04";//授信子合同首次出账

//		出账审核类型描述
		public static final String PROC_FLAG_LOAN_PAY_DESC = "普通贷款申请首次出账";//普通贷款申请首次出账(该种类型在出帐审核流程中暂时不涉及,做预留,普通贷款的出帐在主贷款流程中)
		public static final String PROC_FLAG_LOAN_EXTRA_PAY_DESC = "多次出账";//多次出账(包括普通贷款多次出账和授信子合同的多次出帐)
		public static final String PROC_FLAG_LOAN_CREDIT_DIRECT_PAY_DESC = "授信直接出账"; //授信直接出账
		public static final String PROC_FLAG_LOAN_CREDIT_LOAN_PAY_DESC = "授信子合同首次出账";//授信子合同首次出账


		// 贷款申请节点描述
		public static final String TASK_NAME_LOAN_CHECK_DESC  = "复核";//贷款复核
		public static final String TASK_NAME_LOAN_PRE_AUDIT_DESC   = "初审";// 贷款初审
		public static final String TASK_NAME_SUB_LOAN_AUDIT_DESC   = "支行审查"; //支行审查
		public static final String TASK_NAME_SUB_LOAN_APPROVE_DESC   = "支行审批";// 支行审批
		public static final String TASK_NAME_BRANCH_LOAN_AUDIT_DESC   =  "分行审查";//分行审查
		public static final String TASK_NAME_BRANCH_LOAN_APPROVE_DESC   = "分行审批";// 分行审批
		public static final String TASK_NAME_DIST_LOAN_AUDIT_DESC   = "区域中心审查" ;//区域中心审查
		public static final String TASK_NAME_DIST_LOAN_APPROVE_DESC   = "区域中心审批";// 区域中心审批
		public static final String TASK_NAME_HEAD_LOAN_AUDIT_DESC  = "总行审查";// 总行审查
		public static final String TASK_NAME_HEAD_LOAN_APPROVE_DESC   = "总行审批";// 总行审批
		public static final String TASK_NAME_CVO_APPROVE_DESC   = "首席风险官审批";// 首席风险官审批
		public static final String TASK_NAME_CONT_SIGN_DESC   = "合同签订";// 合同签订
		public static final String TASK_NAME_PAY_CHECK_DESC   = "出账审核";// 出账审核
		public static final String TASK_NAME_UNTREAD_MODIFY_DESC   = "贷款申请退回修改";// 资料退回修改
		public static final String TASK_NAME_PAY_CHECK_BACK_DESC = "出账退回修改";//出账申请退回修改

		/* add by learncy.zou 20101230 end*/

	/*  zhushijie add */
		/**
		 * 批文件流水表业务种类
		 */
		public static final String TYPE_CODE_BLACK = "0001"; // 关注客户批量导入文件
		public static final String TYPE_CODE_FUND = "0002"; // 公积金冲还贷上送文件
		/**
		 * 批文件流水表批处理状态
		 */
		public static final String BATCH_STA_CD_NO = "0"; // 未处理
		public static final String BATCH_STA_CD_YES = "1"; // 已处理
		public static final String BATCH_STA_CD_INVALID = "2"; // 无效批文件
		/**
		 * 自然人客户类型
		 */
		public static final String CUST_INDV_TYPE_MAIN_LOANER = "1"; // 借款人
		public static final String CUST_INDV_TYPE_OTHER = "2"; // 其他


		public static final int VALUE_NO_LNID = 45; // 贷款品种代码 Add lilinfeng


		//操作员状态

		public static final String TLR_NO_STATE_INVALID = "0"; // 请假

		public static final String TLR_NO_STATE_NORMAL = "1"; // 有效

		//public static final String TLR_NO_STATE_QUIT = "2"; // 离职

		//public static final String TLR_NO_STATE_LVDAY = "3";// 休假

		public static final String TLR_NO_STATE_UNUSE = "4"; // 暂停使用

		//add gz   诉讼
		public static final int DATADIC_TYPE_LAWSUITRESULT = 554;// 诉讼结果
		public static final int DATADIC_TYPE_LAWSUITTYPE = 555;// 诉讼类型


		  /**
	     * 登记催收结果状态 gz
	     */
	    public static final String TRACEDTL_PROCESS_FLAG_OFF = "0"; //0-任务未完成；
	    public static final String TRACEDTL_PROCESS_FLAG_ON = "1"; //1-任务已登记；
	    public static final String TRACEDTL_PROCESS_FLAG_AUTOON = "2"; //2-主动登记任务；


	  //批量贷后申请 gz
		public static final String POSTLOAN_BATCH_STATUS_1 = "1"; // 已提交
		public static final String POSTLOAN_BATCH_STATUS_2 = "2";// 已复核
		public static final String POSTLOAN_BATCH_STATUS_3 = "3";// 已认定
		public static final String POSTLOAN_BATCH_STATUS_4 = "4";// 已确认


		public static final int VALUE_NO_TLRINTNO = 46; // 内部操作员号 Add lilinfeng


		public static final String BRCODE_HEAD_UP_BRCODE_DEFAULT = "9999"; // 总行上级机构默认值 add lilinfeng

		public static final String COMM_TXN_CODE_QUERY_ZONEINFO = "990003"; // 查询机构信息 add lilinfeng
		public static final String COMM_TXN_KEY_TEMPLATECODENAME = "templateCodeName"; // 交易模板 add lilinfengs
		public static final String TEMPLATE_CODE_NAME_TELL = "000005"; // 柜员管理系统交易模板 add lilinfeng
		public static final String COMM_TXN_KEY_G_TRANSCODE = "G_TRANSCODE"; // 交易代码 add lilinfeng
		public static final String COMM_TXN_KEY_MAINSYSID = "mainsysId"; // 系统标识 add lilinfeng
		public static final String MAIN_SYS_ID_TELL =  "4"; //柜员管理系统对个贷系统的标识 add lilinfeng
		public static final String COMM_TXN_KEY_ZONENO ="zoneno";  //机构号 add lilinfeng
		public static final String COMM_TXN_KEY_ORDERMODE ="orderMode";  //查询模式 add lilinfeng
		public static final String COMM_TXN_KEY_DUTYMAN  = "dutyMan";   //负责人 add lilinfeng
		public static final String COMM_TXN_KEY_ZONETYPE = "zoneType";   //机构级别 add lilinfeng
		public static final String COMM_TXN_KEY_ZONENAME = "zoneName";   //机构简称 add lilinfeng
		public static final String COMM_TXN_KEY_FHH = "fhh";   //分行号 add lilinfeng
		public static final String COMM_TXN_KEY_ZHH  = "zhh";   //支行号 add lilinfeng
		public static final String COMM_TXN_KEY_ZONEINFO = "zoneInfo";   //机构全称 add lilinfeng
		public static final String COMM_TXN_KEY_TOPZONENO = "topZoneno";   //管辖机构 add lilinfeng
		public static final String COMM_TXN_KEY_POSTNO  = "postno";   //邮政编码 add lilinfeng
		public static final String COMM_TXN_KEY_TELEPHONE = "telephone";   //电话号码 liinfeng
		public static final String COMM_TXN_KEY_ZONEADDRESS = "zoneAddress";   //机构地址 add lilinfeng
		public static final String COMM_TXN_KEY_NOTE = "Note";   //备注 add lilinfeng
		public static final String COMM_TXN_KEY_MODDATE = "modDate";   //修改日期 add lilinfeng

		//add by kangbyron 2011-02-10 操作员审批默认阀值
		public static final String MAX_WL_DEFAULT = "10";

		public static final String TASKPOOL_UNASSIGN = "0";
		public static final String TASKPOOL_ASSIGNED = "1";

}