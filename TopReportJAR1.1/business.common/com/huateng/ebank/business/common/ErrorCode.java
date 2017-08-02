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
 * @desc define error code
 */
public class ErrorCode {

	public static final String ERROR_CODE_OK = "000000"; // 交易成功代码222

	public static final String ERROR_CODE_NORMAL = "000001"; // 未知错误

	public static final String DATE_IS_NULL = "GD0009"; // 时间为空

	/**
	 * 系统错误代码 SE0001~SE0100
	 */

	public static final String ERROR_CODE_UNKNOWN = "GD0001"; //未知错误
	public static final String ERROR_CODE_DATE_FORMAT_ERR = "GD0002"; //日期格式错误
	public static final String ERROR_CODE_DATA_FORMAT_ERR = "GD0003"; //数据格式错误
	public static final String ERROR_CODE_INTERNAL_ERROR = "GD0004"; //应用系统内部错误
	public static final String ERROR_CODE_FTP = "GD0005"; //FTP错误
	public static final String ERROR_CODE_DOWNLOAD = "GD0006"; //下载文件失败
	public static final String ERROR_CODE_INVALID_FORMAT = "GD0007"; //格式错误
	public static final String ERROR_CODE_WS_COMM_ERROR = "SE0008"; // 通讯错误

	/**
	 * 个贷专用通信错误码
	 */
	public static final String ERROR_CODE_INVALID_DATA = "0001"; // 无效数据
	/**
	 * DAO错误代码 GD1001~GD2000
	 */
	public static final String ERROR_CODE_DAO = "GD1001"; //DAO错误

	/**
	 * 用户登陆,操作员信息修改 错误码 SE0101~SE0400
	 */
	public static final String ERROR_CODE_TLRNO_NO_FUNCTION = "GD0101"; // 操作员无此功能权限
	public static final String ERROR_CODE_TLRNO_SESSION_INVALID = "GD0102"; // 操作员会话无效
	public static final String ERROR_CODE_TLRNO_SESSION_BINDED = "GD0103"; // 此会话已经被其他操作员绑定
	public static final String ERROR_CODE_NO_GLOBALINFO_INSTANCE = "GD0104"; // 系统错误，没有初始化全局信息
	public static final String ERROR_CODE_GLOBALINFO_BATCH = "GD0105"; // 系统处于批量状态
	public static final String ERROR_CODE_TLRNO_ALREADY_LOGIN = "GD0106";// 用户已登录
	public static final String ERROR_CODE_TLRNO_STATUS_INVALID = "GD0107";// 用户状态无效
	public static final String ERROR_CODE_USER_NOT_EXIST = "GD0108";// 用户不存在
	public static final String ERROR_CODE_USER_PWD_INVALID = "GD0109";// 用户密码错误
	public static final String ERROR_CODE_TLRNO_PSWD_ERR_THREE_TIMES = "GD0110";// 操作员连续三次密码错误
	public static final String ERROR_CODE_TLRNO_PSWD_ERR_SIX_TIMES = "GD0111";// 操作员当日累计六次密码错误
	public static final String ERROR_CODE_CHG_PWD_SAME_CHARS = "GD0112";// 密码不能为连续相同字母
	public static final String ERROR_CODE_NEW_OLD_PWD_IS_SAME = "GD0113";// 新旧密码不能相同
	public static final String ERROR_CODE_USER_INFO_INVALID = "GD0114";// 获取用户信息失败
	public static final String ERROR_CODE_NEW_AGAIN_PWD_IS_NOT_SAME = "GD0115";// 新密码和确认密码必须相同
	public static final String ERROR_CODE_PWD_FIELDS_IS_NULL = "GD0116";// 旧密码、新密码或确认密码字段不能为空


	/**
	 * 审批路径设置错误
	 */
	public static final String ERROR_CODE_AUDIT_ROUTE_BRANCH = "BL2001"; // 机构不同
	/** 提交时值未查到审核路线 */
	public static final String ERROR_CODE_NOT_AUDIT_ROUTE_SELECT = "BL2002";
	/** 提交时值未找到批次 */
	public static final String ERROR_CODE_NOT_AUDIT_CONTRACT_SELECT = "BL2003";
	/** 提交时值未找到操作员 */
	public static final String ERROR_CODE_NOT_AUDIT_OPER_SELECT = "BL2004";
	/** 提交时值未找到业务类型 */
	public static final String ERROR_CODE_NOT_AUDIT_BUSINESS_SELECT = "BL2005";
	/** 提交时值未能成功生成审核单 */
	public static final String ERROR_CODE_NOT_AUDIT_FORM_CREATE = "BL2006";
	/** 状态不正确 */
	public static final String ERROR_CODE_AUDIT_FORM_STATUS = "BL2007";
	/** 提交的批次审核次数不正确 */
	public static final String ERROR_CODE_AUDIT_SUBMIT_TIMES = "BL2008";

	/** 授信产品不能删除 */
	public static final String ERROR_CODE_CREDIT_DELETE_ERROR = "BL2101";
	/** 授信规则设置错误 */
	public static final String ERROR_CODE_CREDIT_SET_ERROR = "BL2102";
	/** 角色不能删除 */
	public static final String ERROR_CODE_ROLE_DELETE_ERROR = "BL2111";
	/** 授信分析错误 */
	public static final String ERROR_CODE_CREDIT_ANALYZE_ERROR = "BL2121";
	/** 授信分析错误 */
	public static final String ERROR_CODE_ELECTRIC_NOT_FOUND = "BL2201";
	/** 授信协议下有授信记录 */
	public static final String ERROR_CODE_CREDIT_INFO_DELETE_ERROR = "BL2202";
	/** 授信记录删除错误 */
	public static final String ERROR_CODE_CREDIT_RECORD_DELETE_ERROR = "BL2203";
	/** 授信记录保存错误 */
	public static final String ERROR_CODE_CREDIT_RECORD_SAVE_ERROR = "BL2204";



	/**
	 * 用户登陆,操作员信息修改 错误码 GD0101~GD0400
	 */
	public static final String ERROR_CODE_TLRNO_PSWD_ERR_TIMES = "GD0110";// 操作员连续密码错误
	public static final String ERROR_CODE_TLRNO_PSWD_CHANGE = "GD0111";// 操作员密码修改
	public static final String ERROR_CODE_BRCODE = "GD0117";// 新密码和确认密码必须相同
	public static final String ERROR_CODE_USER_HAVE_EXISTED = "GD0118";// 用户已存在
	public static final String ERROR_CODE_USER_CREATE_ERROR = "GD0119";// 用户创建失败
	public static final String ERROR_CODE_PROFILE_CREATE_ERROR = "GD0120";// profile创建失败
	public static final String ERROR_CODE_BRANCH_HAVE_EXISTED = "GD0121";// 机构已存在
	public static final String ERROR_CODE_BRANCH_BELONG_EXISTED = "GD0122";// 下属机构存在

	// 授权新增 farly.yu 20090923
	public static final String ERROR_CODE_ROLE_LIST_BY_ROLETYPE = "GD0123";// 获取岗位列表错
	public static final String ERROR_CODE_AUTHORIZATION_ERR = "GD0124"; // 授权出错
	public static final String ERROR_CODE_MUST_CHG_PASSWD = "GD0125"; // 密码过期必须修改密码
	public static final String ERROR_CODE_ROLEID_NOT_EXIST = "GD0126"; // 操作员岗位不存在
	public static final String ERROR_CODE_CORE_CHECK_PASSWD = "GD0127"; // 柜员管理系统密码校验错
	public static final String ERROR_CODE_UNALLOW_SYNCROLE = "GD0128"; // 非总行操作员不允许同步岗位信息
	public static final String ERROR_CODE_CHANGE_PASSWORD = "GD0129"; // 修改密码错

	// 登陆模式
	/** add jiang@2009-11-02 BMS-2142 */
	public static final String ERROR_CODE_LOGIN_ELSEWHERE = "GD0140";// 操作员在别处登录
	public static final String ERROR_CODE_LOGIN_LOCAL = "GD0141";// 操作员在本机已登录
	/** end BMS-2142 */



	/**
	 * 机构错误代码 GD0301~GD0400
	 */
	public static final String TX_BRANCH_ERROR = "GD0300";// 交易机构错误



	public static final String ERROR_CODE_USER_ROLE_REL_DELETE = "GD1565"; // 操作员岗位关系表删除错误
	public static final String ERROR_CODE_USER_ROLE_REL_INSERT = "GD1566"; // 操作员岗位关系表插入错误
	public static final String ERROR_CODE_USER_ROLE_REL_SELECT = "GD1567"; // 操作员岗位关系表读取错误
	public static final String ERROR_CODE_USER_ROLE_REL_UPDATE = "GD1568"; // 操作员岗位关系表修改错误


	/**
	 * 未用退回错误表
	 */
	public static final String ERROR_CODE_Restitution_SUBMIT = "RES001";// 未用退回提交错误
	public static final String ERROR_CODE_Restitution_CANCEL_SUBMIT = "RES002";// 未用退回撤销错误
	public static final String ERROR_CODE_Restitution_DELETE = "RES003";// 未用退回撤销错误

	/**
	 * 挂失止付错误表
	 */
	public static final String ERROR_CODE_REPORT_OF_LOSS_SUBMIT = "ROL001";// 挂失止付提交错误
	public static final String ERROR_CODE_REPORT_OF_LOSS_CANCEL_SUBMIT = "ROL002";// 挂失止付撤销错误
	public static final String ERROR_CODE_REPORT_OF_LOSS_DELETE = "ROL003";// 挂失止付删除错误
	public static final String ERROR_CODE_CANCEL_REPORT_OF_LOSS_SUBMIT = "ROL004";// 解除挂失止付提交错误
	public static final String ERROR_CODE_CANCEL_REPORT_OF_LOSS_CANCEL_SUBMIT = "ROL005";// 解除挂失止付撤销错误

	/**
	 * 营业税率错误表
	 */
	public static final String ERROR_CODE_BUSINESS_RATE_ADD = "BR001"; // 营业税率添加提交错误
	public static final String ERROR_CODE_BUSINESS_RATE_UPDATE = "BR002";// 营业税率更新提交错误
	public static final String ERROR_CODE_BUSINESS_RATE_DELETE = "BR003";// 营业税率删除错误

	/**
	 * 成本税率错误表
	 */
	public static final String ERROR_CODE_COST_RATE_ADD = "CR001";// 成本税率添加提交错误
	public static final String ERROR_CODE_COST_RATE_UPDATE = "CR002";// 成本税率更新提交错误
	public static final String ERROR_CODE_COST_RATE_DELETE = "CR003";// 成本税率删除错误

	/**
	 * 部门管理错误表
	 */
	public static final String ERROR_CODE_DEPARTMENT_MANAGEMENT_SELECT = "DM000";// 部门查询错误
	public static final String ERROR_CODE_DEPARTMENT_MANAGEMENT_ADD = "DM001";// 部门添加提交错误
	public static final String ERROR_CODE_DEPARTMENT_MANAGEMENT_UPDATE = "DM002";// 部门更新提交错误
	public static final String ERROR_CODE_DEPARTMENT_MANAGEMENT_DELETE = "DM003";// 部门删除错误


	/**
	 * 客户经理错误表
	 */
	public static final String ERROR_CODE_CUSTOMER_MANAGER_ADD = "CM001";// 客户经理代码重复
	public static final String ERROR_CODE_CUSTOMER_MANAGER_UPDATE = "CM002";// 成本税率更新提交错误
	public static final String ERROR_CODE_CUSTOMER_MANAGER_DELETE = "CM003";// 成本税率删除错误

	/**
	 * 会计分录表表
	 */
	public static final String ERROR_CODE_TRANSCLASS_ADD = "TC001";// 会计分录添加提交错误
	public static final String ERROR_CODE_TRANSCLASS_UPDATE = "TC002";// 会计分录更新提交错误
	public static final String ERROR_CODE_TRANSCLASS_DELETE = "TC003";// 会计分录删除错误



	/**
	 * add by znh 2009-05-13 接口数据库操作错误码
	 */
	public static final String ERROR_CODE_INTERFACE_DELETE = "GDIF01"; // 接口数据表删除错误
	public static final String ERROR_CODE_INTERFACE_INSERT = "GDIF02"; // 接口数据表插入错误
	public static final String ERROR_CODE_INTERFACE_SELECT = "GDIF03"; // 接口数据表读取错误
	public static final String ERROR_CODE_INTERFACE_UPDATE = "GDIF04"; // 接口数据表修改错误



	/**
	 * 工作流错误代码 GD1721~GD1748
	 *
	 * @author wty DATE 2009-05-06
	 */
	public static final String ERROR_CODE_WORKFLOW_INS_ROUTE_DELETE = "GD1721"; // 工作流审批路线示例表删除错误
	public static final String ERROR_CODE_WORKFLOW_INS_ROUTE_INSERT = "GD1722"; // 工作流审批路线示例表插入错误
	public static final String ERROR_CODE_WORKFLOW_INS_ROUTE_SELECT = "GD1723"; // 工作流审批路线示例表读取错误
	public static final String ERROR_CODE_WORKFLOW_INS_ROUTE_UPDATE = "GD1724"; // 工作流审批路线示例表修改错误
	public static final String ERROR_CODE_WORKFLOW_PARAM_DELETE = "GD1725"; // 工作流参数配置表删除错误
	public static final String ERROR_CODE_WORKFLOW_PARAM_INSERT = "GD1726"; // 工作流参数配置表插入错误
	public static final String ERROR_CODE_WORKFLOW_PARAM_SELECT = "GD1727"; // 工作流参数配置表读取错误
	public static final String ERROR_CODE_WORKFLOW_PARAM_UPDATE = "GD1728"; // 工作流参数配置表修改错误
	public static final String ERROR_CODE_WORKFLOW_ROUTE_BINDING_DELETE = "GD1729"; // 工作流审批路线绑定表删除错误
	public static final String ERROR_CODE_WORKFLOW_ROUTE_BINDING_INSERT = "GD1730"; // 工作流审批路线绑定表插入错误
	public static final String ERROR_CODE_WORKFLOW_ROUTE_BINDING_SELECT = "GD1731"; // 工作流审批路线绑定表读取错误
	public static final String ERROR_CODE_WORKFLOW_ROUTE_BINDING_UPDATE = "GD1732"; // 工作流审批路线绑定表修改错误
	public static final String ERROR_CODE_WORKFLOW_ROUTE_DEF_DELETE = "GD1733"; // 工作流审批路线定义表删除错误
	public static final String ERROR_CODE_WORKFLOW_ROUTE_DEF_INSERT = "GD1734"; // 工作流审批路线定义表插入错误
	public static final String ERROR_CODE_WORKFLOW_ROUTE_DEF_SELECT = "GD1735"; // 工作流审批路线定义表读取错误
	public static final String ERROR_CODE_WORKFLOW_ROUTE_DEF_UPDATE = "GD1736"; // 工作流审批路线定义表修改错误
	public static final String ERROR_CODE_WORKFLOW_ROUTE_PARAM_DELETE = "GD1737"; // 工作流审批路线明细表删除错误
	public static final String ERROR_CODE_WORKFLOW_ROUTE_PARAM_INSERT = "GD1738"; // 工作流审批路线明细表插入错误
	public static final String ERROR_CODE_WORKFLOW_ROUTE_PARAM_SELECT = "GD1739"; // 工作流审批路线明细表读取错误
	public static final String ERROR_CODE_WORKFLOW_ROUTE_PARAM_UPDATE = "GD1740"; // 工作流审批路线明细表修改错误
	public static final String ERROR_CODE_WORKFLOW_TASK_INFO_DELETE = "GD1741"; // 工作流任务信息表删除错误
	public static final String ERROR_CODE_WORKFLOW_TASK_INFO_INSERT = "GD1742"; // 工作流任务信息表插入错误
	public static final String ERROR_CODE_WORKFLOW_TASK_INFO_SELECT = "GD1743"; // 工作流任务信息表读取错误
	public static final String ERROR_CODE_WORKFLOW_TASK_INFO_UPDATE = "GD1744"; // 工作流任务信息表修改错误
	public static final String ERROR_CODE_WORKFLOW_APP_INFO_DELETE = "GD1745"; // 工作流申请信息表删除错误
	public static final String ERROR_CODE_WORKFLOW_APP_INFO_INSERT = "GD1746"; // 工作流申请信息表插入错误
	public static final String ERROR_CODE_WORKFLOW_APP_INFO_SELECT = "GD1747"; // 工作流申请信息表读取错误
	public static final String ERROR_CODE_WORKFLOW_APP_INFO_UPDATE = "GD1748"; // 工作流申请信息表修改错误

	public static final String ERROR_CODE_WORKFLOW_BUSS_TEMPLET_REL_DELETE = "GD1749"; // 工作流审批路线明细表删除错误
	public static final String ERROR_CODE_WORKFLOW_BUSS_TEMPLET_REL_INSERT = "GD1750"; // 工作流审批路线明细表插入错误
	public static final String ERROR_CODE_WORKFLOW_BUSS_TEMPLET_REL_SELECT = "GD1751"; // 工作流审批路线明细表读取错误
	public static final String ERROR_CODE_WORKFLOW_BUSS_TEMPLET_REL_UPDATE = "GD1752"; // 工作流审批路线明细表修改错误
	
	public static final String ERROR_CODE_EBANK_TRADE_SEND = "GD1800";// 网银发送消息错误
	public static final String ERROR_CODE_ELCBUSINESS_TRADE_SEND = "BL1801";// 电子业务发送消息错误
	public static final String ERROR_CODE_DISCOUNT_BATCH_UPLOAD = "BL1802";// 转贴现业务excel批量导入错误

	/**
	 * 额度管理错误代码 GD3600~GD3615
	 *
	 * @author huabin.zhong DATE 2009-09-09
	 */
	public static final String ERROR_CODE_CREDIT_BASE_INFO_DELETE = "GD3600"; // 额度主表删除错误
	public static final String ERROR_CODE_CREDIT_BASE_INFO_INSERT = "GD3601"; // 额度主表插入错误
	public static final String ERROR_CODE_CREDIT_BASE_INFO_SELECT = "GD3602"; // 额度主表读取错误
	public static final String ERROR_CODE_CREDIT_BASE_INFO_UPDATE = "GD3603"; // 额度主表修改错误
	public static final String ERROR_CODE_CREDIT_DEAL_LOG_DELETE = "GD3604"; // 额度使用明细表删除错误
	public static final String ERROR_CODE_CREDIT_DEAL_LOG_INSERT = "GD3605"; // 额度使用明细表插入错误
	public static final String ERROR_CODE_CREDIT_DEAL_LOG_SELECT = "GD3606"; // 额度使用明细表读取错误
	public static final String ERROR_CODE_CREDIT_DEAL_LOG_UPDATE = "GD3607"; // 额度使用明细表修改错误
	public static final String ERROR_CODE_CREDIT_EFFECT_INFO_DELETE = "GD3608"; // 额度生效表删除错误
	public static final String ERROR_CODE_CREDIT_EFFECT_INFO_INSERT = "GD3609"; // 额度生效表插入错误
	public static final String ERROR_CODE_CREDIT_EFFECT_INFO_SELECT = "GD3610"; // 额度生效表读取错误
	public static final String ERROR_CODE_CREDIT_EFFECT_INFO_UPDATE = "GD3611"; // 额度生效表修改错误
	public static final String ERROR_CODE_CREDIT_PRO_INFO_DELETE = "GD3612"; // 授信产品表删除错误
	public static final String ERROR_CODE_CREDIT_PRO_INFO_INSERT = "GD3613"; // 授信产品表插入错误
	public static final String ERROR_CODE_CREDIT_PRO_INFO_SELECT = "GD3614"; // 授信产品表读取错误
	public static final String ERROR_CODE_CREDIT_PRO_INFO_UPDATE = "GD3615"; // 授信产品表修改错误

	/* added by yang jenny 2009-10-26 BMS-2156 begin */
	public static final String ERROR_CODE_CREDIT_PRINCIPLE_DELETE = "GD3616"; // 授信规则表删除错误
	public static final String ERROR_CODE_CREDIT_PRINCIPLE_INSERT = "GD3617"; // 授信规则表插入错误
	public static final String ERROR_CODE_CREDIT_PRINCIPLE_SELECT = "GD3618"; // 授信规则表读取错误
	public static final String ERROR_CODE_CREDIT_PRINCIPLE_UPDATE = "GD3619"; // 授信规则表修改错误
	public static final String ERROR_CODE_CREDIT_ANALYZE_RECORD_DELETE = "GD3620"; // 授信分析记录表删除错误
	public static final String ERROR_CODE_CREDIT_ANALYZE_RECORD_INSERT = "GD3621"; // 授信分析记录表插入错误
	public static final String ERROR_CODE_CREDIT_ANALYZE_RECORD_SELETE = "GD3622"; // 授信分析记录表读取错误
	public static final String ERROR_CODE_CREDIT_ANALYZE_RECORD_UPDATE = "GD3623"; // 授信分析记录表修改错误
	/**
	 * 额度使用错误代码 GD3650
	 *
	 * @author yang jenny 2009-10-22
	 */
	public static final String ERROR_CODE_CREDIT_USE_NOT_FOUND = "GD3650"; // 没有找到对应的额度信息
	public static final String ERROR_CODE_CREDIT_BAL_UNENOUGH = "GD3651"; // 可用额度不足
	public static final String ERROR_CODE_CREDIT_DATE_CHECK = "GD3652"; // 额度修改日期校验错误
	public static final String ERROR_CODE_CREDIT_GEN_CREDITNO = "GD3653"; // 额度生成编号错误
	public static final String ERROR_CODE_CREDIT_PRINCLE_NONE = "GD3654"; // 无可用额度授信规则
	public static final String ERROR_CODE_CREDIT_PRODUCT_NONE = "GD3655"; // 无可用额度产品
	public static final String ERROR_CODE_CREDIT_BASE_INFO_NONE = "GD3656"; // 无相应基础额度信息
	public static final String ERROR_CODE_CREDIT_EFFECT_INFO_NONE = "GD3657"; // 无相应生效额度信息
	public static final String ERROR_CODE_CREDIT_CHECK_DATE = "GD3658"; // 交易不在可用额度生效期内
	public static final String ERROR_CODE_CREDIT_GEN_REAL_ID = "GD3659"; // 生成关联ID错误
	/* added by yang jenny 2009-10-26 BMS-2156 end */

	/**
	 * ADD JIANG@2009-11-13 BMS-2199
	 */
	// 代保管
	public static final String ERROR_CODE_STORAGE_CONTRACT_DELETE_DETAILS = "ST1001"; // 代保管解除协议删除时有明细

	public static final String ERROR_CODE_STORAGE_CONTRACT_DETAIL_CHECK_DETAILS_DRAFTNUMBER = "ST1002";// 票号错误
	public static final String ERROR_CODE_STORAGE_CONTRACT_DETAIL_CHECK_DETAILS_FACEAMOUNT = "ST1003";// 金额错误
	public static final String ERROR_CODE_STORAGE_CONTRACT_DETAIL_CHECK_DETAILS_DATE = "ST1004"; // 日期错误
	/**
	 * END JIANG@2009-11-13 BMS-2199
	 */

	/**
	 * ADD JIANG@2009-11-14 BMS-2199
	 */
	public static final String ERROR_CODE_STORAGE_UPLOAD = "ST2001";// 代保管批量上传错误

	/** add by lizh 20091123 BMS-2241 begin* */
	public static final String ERROR_CODE_EXCEL_DATAFORMAT = "EL1001";// EXCEL数据格式有问题
	/** add by lizh 20091123 BMS-2241 end* */

	/** add by Hanziyang 20100225 begin* */
	public static final String ERROR_CODE_CURRENTCUST_RESET = "AG0100";// 重复设置当前企业
	/** add by Hanziyang 20100225 end* */

	/** add by Hanziyang 20100422 begin* */
	public static final String ERROR_CODE_EBROLE_QUERY_SELECT = "EB2000";// 角色查询错误
	/** add by Hanziyang 20100422 end* */

	/** add by Hanziyang 20100423 begin* */
	public static final String ERROR_CODE_ERROR_ACT = "EB2001";//非法的操作
	/** add by Hanziyang 20100422 end* */

	/**
	 * 网银新增错误代码GD3000-GD4000
	 */
	public static final String ERROR_CODE_TBL_EB_BUSS_BATCH_SELECT = "GD3000"; // 网银业务批次表读取错误

	public static final String ERROR_CODE_EBANK_INTERFACE_EX = "GD3001"; // 网银业务通讯接口异常

	public static final String ERROR_CODE_TBL_EB_OPERATOR_SELECT = "GD3002"; // 网银业务批次表读取错误

	public static final String ERROR_CODE_GD3003 = "GD3003"; // 该批次没有对应的票据详情

	public static final String ERROR_CODE_GD3004 = "GD3004"; // 交易信息中有部分数据没有成功处理

	/** add by junyun.lin HTEBANK-26 2010-05-21 begin */
	public static final String ERROR_CODE_GD3005 = "GD3005"; // 没有合适的人员执行一下一个任务
	/** add by junyun.lin HTEBANK-26 2010-05-21 end */




	public static final String ERROR_CODE_CHECK_AUTH_FAIL = "SE0117";//校验权限错误

	/**
	 * 贷后管理 DAO异常 SE0400~SE0900
	 */

	public static final String ERROR_CODE_FIVECLASS_DAY_MAP_SELECT = "SE0401"; // 无级分类矩阵表读取异常
	public static final String ERROR_CODE_FIVECLASS_DAY_MAP_INSERT = "SE0402"; // 无级分类矩阵表插入异常
	public static final String ERROR_CODE_FIVECLASS_DAY_MAP_UPDATE = "SE0403"; // 无级分类矩阵表更新异常
	public static final String ERROR_CODE_FIVECLASS_DAY_MAP_DELETE = "SE0404"; // 无级分类矩阵表删除异常
	public static final String ERROR_CODE_MONITORDTL_SELECT = "SE0405"; // 贷后检查记录表读取异常
	public static final String ERROR_CODE_MONITORDTL_INSERT = "SE0406"; // 贷后检查记录表插入异常
	public static final String ERROR_CODE_MONITORDTL_UPDATE = "SE0407"; // 贷后检查记录表更新异常
	public static final String ERROR_CODE_MONITORDTL_DELETE = "SE0408"; // 贷后检查记录表删除异常
	public static final String ERROR_CODE_FIVECLASSDTL_SELECT = "SE0409"; // 五级分类查询错误
	public static final String ERROR_CODE_FIVECLASSDTL_UPDATE = "SE0410"; // 五级分类更新错误
	public static final String ERROR_CODE_FIVECLASSDTL_INSERT = "SE0411"; // 五级分类插入错误
	public static final String ERROR_CODE_FIVECLASSDTL_DELETE = "SE0412"; // 五级分类删除错误
	public static final String ERROR_CODE_TRACEDTL_SELECT = "SE0413"; // 催收记录查询错误
	public static final String ERROR_CODE_TRACEDTL_UPDATE = "SE0414"; // 催收记录更新错误
	public static final String ERROR_CODE_TRACEDTL_INSERT = "SE0415"; // 催收记录插入错误
	public static final String ERROR_CODE_TRACEDTL_DELETE = "SE0416"; // 催收记录删除错误

	/**
	 * ************************客户模块DAO错误代码 SE1002~SE1199
	 * ***********************************
	 */
	public static final String ERROR_CODE_CUSTINFO_DELETE = "SE1002"; // 客户基本信息表删除错误
	public static final String ERROR_CODE_CUSTINFO_INSERT = "SE1003"; // 客户基本信息表插入错误
	public static final String ERROR_CODE_CUSTINFO_SELECT = "SE1004"; // 客户基本信息表读取错误
	public static final String ERROR_CODE_CUSTINFO_UPDATE = "SE1005"; // 客户基本信息表修改错误
	public static final String ERROR_CODE_CORPCUSTINFO_DELETE = "SE1006"; // 对公客户基本信息表删除错误
	public static final String ERROR_CODE_CORPCUSTINFO_INSERT = "SE1007"; // 对公客户基本信息表插入错误
	public static final String ERROR_CODE_CORPCUSTINFO_SELECT = "SE1008"; // 对公客户基本信息表读取错误
	public static final String ERROR_CODE_CORPCUSTINFO_UPDATE = "SE1009"; // 对公客户基本信息表修改错误
	public static final String ERROR_CODE_INDVCUSTINFO_DELETE = "SE1010"; // 自然人基本信息表删除错误
	public static final String ERROR_CODE_INDVCUSTINFO_INSERT = "SE1011"; // 自然人基本信息表插入错误
	public static final String ERROR_CODE_INDVCUSTINFO_SELECT = "SE1012"; // 自然人基本信息表读取错误
	public static final String ERROR_CODE_INDVCUSTINFO_UPDATE = "SE1013"; // 自然人基本信息表修改错误
	public static final String ERROR_CODE_RELAINFO_DELETE = "SE1014"; // 客户关联信息表删除错误
	public static final String ERROR_CODE_RELAINFO_INSERT = "SE1015"; // 客户关联信息表插入错误
	public static final String ERROR_CODE_RELAINFO_SELECT = "SE1016"; // 客户关联信息表读取错误
	public static final String ERROR_CODE_RELAINFO_UPDATE = "SE1017"; // 客户关联信息表修改错误
	public static final String ERROR_CODE_RELACODE_SELECT = "SE1018"; // 客户关系代码表读取错误
	public static final String ERROR_CODE_CUSTOMERGREATEVENTINFO_SELECT = "SE1019"; // 客户大事记读取异常
	public static final String ERROR_CODE_CUSTOMERGREATEVENTINFO_UPDATE = "SE1020"; // 客户大事记修改异常
	public static final String ERROR_CODE_CUSTOMERGREATEVENTINFO_DELETE = "SE1021"; // 客户大事记删除异常
	public static final String ERROR_CODE_CUSTOMERGREATEVENTINFO_INSERT = "SE1022"; // 客户大事记插入异常
	public static final String ERROR_CODE_COOPPROTINFO_DELETE = "SE1023"; // 合作协议表删除错误
	public static final String ERROR_CODE_COOPPROTINFO_INSERT = "SE1024"; // 合作协议表插入错误
	public static final String ERROR_CODE_COOPPROTINFO_SELECT = "SE1025"; // 合作协议表读取错误
	public static final String ERROR_CODE_COOPPROTINFO_UPDATE = "SE1026"; // 合作协议表修改错误
	public static final String ERROR_CODE_CUSTOMER_INFRACT_RECORD_INFO_SELECT = "SE1027"; // 客户不良信息查询错误
	public static final String ERROR_CODE_CUSTOMER_INFRACT_RECORD_INFO_INSERT = "SE1028"; // 客户不良信息插入错误
	public static final String ERROR_CODE_CUSTOMER_INFRACT_RECORD_INFO_DELETE = "SE1029"; // 客户不良信息删除错误
	public static final String ERROR_CODE_CUSTOMER_INFRACT_RECORD_INFO_UPDATE = "SE1030"; // 客户不良信息更新错误
	public static final String ERROR_CODE_COOPPROTHIST_DELETE = "SE1031"; // 合作协议变更历史表删除错误
	public static final String ERROR_CODE_COOPPROTHIST_INSERT = "SE1032"; // 合作协议变更历史表插入错误
	public static final String ERROR_CODE_COOPPROTHIST_SELECT = "SE1033"; // 合作协议变更历史表读取错误
	public static final String ERROR_CODE_COOPPROTHIST_UPDATE = "SE1034"; // 合作协议变更历史表修改错误
	public static final String ERROR_CODE_CUSTOMER_INFRACT_RECORD_HIST_SELECT = "SE1035"; // 客户不良信息历史记录的读取
	public static final String ERROR_CODE_CUSTOMER_INFRACT_RECORD_HIST_UPDATE = "SE1036"; // 客户不良信息历史记录的修改
	public static final String ERROR_CODE_CUSTOMER_INFRACT_RECORD_HIST_INSERT = "SE1037"; // 客户不良信息历史记录的插入
	public static final String ERROR_CODE_CUSTOMER_INFRACT_RECORD_HIST_DELETE = "SE1038"; // 客户不良信息历史记录的删除
	public static final String ERROR_CODE_COOP_PROTOCOL_USE_SELECT = "SE1039"; // 协议额度使用明细查询失败
	public static final String ERROR_CODE_COOP_PROTOCOL_USE_INSERT = "SE1040"; // 协议额度使用明细插入失败
	public static final String ERROR_CODE_COOP_PROTOCOL_USE_DELETE = "SE1041"; // 协议额度使用明细删除失败
	public static final String ERROR_CODE_COOP_PROTOCOL_USE_UPDATE = "SE1042"; // 协议额度使用明细更新失败
	public static final String ERROR_CODE_CUSTOMER_WARNING_INFO_INSERT = "SE1043"; // 客户预警信息插入失败
	public static final String ERROR_CODE_CUSTOMER_WARNING_INFO_DELETE = "SE1044"; // 客户预警信息删除失败
	public static final String ERROR_CODE_CUSTOMER_WARNING_INFO_UPDATE = "SE1045"; // 客户预警信息更新失败
	public static final String ERROR_CODE_CUSTOMER_WARNING_INFO_SELECT = "SE1046"; // 客户预警信息查询失败
	public static final String ERROR_CODE_CUSTOMER_WARNING_INFO_SAVE_OR_UPDATE = "SE1047"; // 客户预警信息插入更新失败
	public static final String ERROR_CODE_CORP_CREDIT_HIS_INFO_INSERT = "SE1048"; // 客户征信历史信息插入失败
	public static final String ERROR_CODE_CORP_CREDIT_HIS_INFO_DELETE = "SE1049"; // 客户征信历史信息删除失败
	public static final String ERROR_CODE_CORP_CREDIT_HIS_INFO_UPDATE = "SE1050"; // 客户征息历史信息更新失败
	public static final String ERROR_CODE_CORP_CREDIT_HIS_INFO_SELECT = "SE1051"; // 客户征息历史信息查询失败
	public static final String ERROR_CODE_CORP_CREDIT_INFO_INSERT = "SE1052"; // 客户征信信息插入失败
	public static final String ERROR_CODE_CORP_CREDIT_INFO_DELETE = "SE1053"; // 客户征信信息删除失败
	public static final String ERROR_CODE_CORP_CREDIT_INFO_UPDATE = "SE1054"; // 客户征信信息更新失败
	public static final String ERROR_CODE_CORP_CREDIT_INFO_SELECT = "SE1055"; // 客户征信信息查询失败
	public static final String ERROR_CODE_CUSTOMERBLACKLISTINFO_DELETE = "SE1056"; // 黑名单信息表删除错误
	public static final String ERROR_CODE_CUSTOMERBLACKLISTINFO_INSERT = "SE1057"; // 黑名单信息表插入错误
	public static final String ERROR_CODE_CUSTOMERBLACKLISTINFO_SELECT = "SE1058"; // 黑名单信息表读取错误
	public static final String ERROR_CODE_CUSTOMERBLACKLISTINFO_UPDATE = "SE1059"; // 黑名单信息表修改错误
	public static final String ERROR_CODE_CUSTOMERBOCACCOUNTINFO_DELETE = "SE1060"; // 客户本行帐户信息表删除错误
	public static final String ERROR_CODE_CUSTOMERBOCACCOUNTINFO_INSERT = "SE1061"; // 客户本行帐户信息表插入错误
	public static final String ERROR_CODE_CUSTOMERBOCACCOUNTINFO_SELECT = "SE1062"; // 客户本行帐户信息表读取错误
	public static final String ERROR_CODE_CUSTOMERBOCACCOUNTINFO_UPDATE = "SE1063"; // 客户本行帐户信息表修改错误
	public static final String ERROR_CODE_CUSTOMER_TOT_CLIENT_SELECT = "SE1064";  //客户统计表查询失败
	public static final String ERROR_CODE_CUSTOMER_TOT_BRCODE_SELECT = "SE1065"; //客户统计分析表按机构统计查询表查询失败
	public static final String ERROR_CODE_CUSTOMER_TOT_SAVING_SELECT = "SE1066"; //客户存款统计表查询失败
	public static final String ERROR_CODE_HAIER_STORE_INFO_SELECT = "SE1067";  //客户统计表查询失败
	public static final String ERROR_CODE_HAIER_STORE_INFO_UPDATE = "SE1068"; //客户统计分析表按机构统计查询表查询失败
	public static final String ERROR_CODE_HAIER_STORE_INFO_DELETE = "SE1069"; //客户存款统计表查询失败
	public static final String ERROR_CODE_HAIER_STORE_INFO_INSERT = "SE1070"; //客户存款统计表查询失败
	public static final String ERROR_CODE_HAIER_STORE_INFO_NULL = "SE4102";//没有输入客户工贸信息
	/** ****************************************************************************************** */

	/**
	 * ************************授信模块DAO错误代码 SE1200~SE1399
	 * ***********************************
	 */
	public static final String ERROR_CODE_APPLYDT_DELETE = "SE1200"; // 审批明细信息表删除错误
	public static final String ERROR_CODE_APPLYDT_INSERT = "SE1201"; // 审批明细信息表插入错误
	public static final String ERROR_CODE_APPLYDT_SELECT = "SE1202"; // 审批明细信息表读取错误
	public static final String ERROR_CODE_APPLYDT_UPDATE = "SE1203"; // 审批明细信息表修改错误

	public static final String ERROR_CODE_CREDITGRANTAPPLYDAO_DELETE = "SE1204"; // 额度申请信息表删除错误
	public static final String ERROR_CODE_CREDITGRANTAPPLYDAO_INSERT = "SE1205"; // 额度申请信息表插入错误
	public static final String ERROR_CODE_CREDITGRANTAPPLYDAO_SELECT = "SE1206"; // 额度申请信息表读取错误
	public static final String ERROR_CODE_CREDITGRANTAPPLYDAO_UPDATE = "SE1207"; // 额度申请信息表修改错误

	public static final String ERROR_CODE_CREDITGRANTREFUSEDAO_DELETE = "SE1208"; // 额度拒绝信息表删除错误
	public static final String ERROR_CODE_CREDITGRANTREFUSEDAO_INSERT = "SE1209"; // 额度拒绝信息表插入错误
	public static final String ERROR_CODE_CREDITGRANTREFUSEDAO_SELECT = "SE1210"; // 额度拒绝信息表读取错误
	public static final String ERROR_CODE_CREDITGRANTREFUSEDAO_UPDATE = "SE1211"; // 额度拒绝信息表修改错误

	public static final String ERROR_CODE_CREDITINFODAO_DELETE = "SE1212"; // 额度信息表删除错误
	public static final String ERROR_CODE_CREDITINFODAO_INSERT = "SE1213"; // 额度信息表插入错误
	public static final String ERROR_CODE_CREDITINFODAO_SELECT = "SE1214"; // 额度信息表读取错误
	public static final String ERROR_CODE_CREDITINFODAO_UPDATE = "SE1215"; // 额度信息表修改错误

	public static final String ERROR_CODE_CREDITINFOHISTDAO_DELETE = "SE1216"; // 额度信息历史表删除错误
	public static final String ERROR_CODE_CREDITINFOHISTDAO_INSERT = "SE1217"; // 额度信息历史表插入错误
	public static final String ERROR_CODE_CREDITINFOHISTDAO_SELECT = "SE1218"; // 额度信息历史表读取错误
	public static final String ERROR_CODE_CREDITINFOHISTDAO_UPDATE = "SE1219"; // 额度信息历史表修改错误

	public static final String ERROR_CODE_PRODUCTCREDITINFODAO_DELETE = "SE1220"; // 产品额度信息表删除错误
	public static final String ERROR_CODE_PRODUCTCREDITINFODAO_INSERT = "SE1221"; // 产品额度信息表插入错误
	public static final String ERROR_CODE_PRODUCTCREDITINFODAO_SELECT = "SE1222"; // 产品额度信息表读取错误
	public static final String ERROR_CODE_PRODUCTCREDITINFODAO_UPDATE = "SE1223"; // 产品额度信息表修改错误

	public static final String ERROR_CODE_PRODUCTCREDITINFOHISTDAO_DELETE = "SE1224"; // 产品额度信息历史表删除错误
	public static final String ERROR_CODE_PRODUCTCREDITINFOHISTDAO_INSERT = "SE1225"; // 产品额度信息历史表插入错误
	public static final String ERROR_CODE_PRODUCTCREDITINFOHISTDAO_SELECT = "SE1226"; // 产品额度信息历史表读取错误
	public static final String ERROR_CODE_PRODUCTCREDITINFOHISTDAO_UPDATE = "SE1227"; // 产品额度信息历史表修改错误

	public static final String ERROR_CODE_TMPCREDITINFODAO_DELETE = "SE1228"; // 临时额度信息表删除错误
	public static final String ERROR_CODE_TMPCREDITINFODAO_INSERT = "SE1229"; // 临时额度信息表插入错误
	public static final String ERROR_CODE_TMPCREDITINFODAO_SELECT = "SE1230"; // 临时额度信息表读取错误
	public static final String ERROR_CODE_TMPCREDITINFODAO_UPDATE = "SE1231"; // 临时额度信息表修改错误

	public static final String ERROR_CODE_TMPPRODUCTCREDITINFODAO_DELETE = "SE1232"; // 临时产品额度信息表删除错误
	public static final String ERROR_CODE_TMPPRODUCTCREDITINFODAO_INSERT = "SE1233"; // 临时产品额度信息表插入错误
	public static final String ERROR_CODE_TMPPRODUCTCREDITINFODAO_SELECT = "SE1234"; // 临时产品额度信息表读取错误
	public static final String ERROR_CODE_TMPPRODUCTCREDITINFODAO_UPDATE = "SE1235"; // 临时产品额度信息表修改错误
	public static final String ERROR_CODE_CREDITDAO_DELETE = "SE1236"; // 额度相关表删除错误
	public static final String ERROR_CODE_CREDITDAO_INSERT = "SE1237"; // 额度相关表插入错误
	public static final String ERROR_CODE_CREDITDAO_SELECT = "SE1238"; // 额度相关表读取错误
	public static final String ERROR_CODE_CREDITDAO_UPDATE = "SE1239"; // 额度相关表修改错误

	/** ****************************************************************************************** */

	/**
	 * ************************放款模块DAO错误代码 SE1400~SE1599
	 * ***********************************
	 */

	/** ****************************************************************************************** */

	/**
	 * ************************公控/系统管理模块DAO错误代码 SE1600~SE1699
	 * ****************************
	 */

	public static final String ERROR_CODE_AREA_SELECT = "SE1668"; // 地区不存在
	public static final String ERROR_CODE_CURRENCY_SELECT = "SE1669"; // 币种不存在
	public static final String ERROR_CODE_RELATION_CODE_DELETE = "SE1670"; // 关系代码删除错误
	public static final String ERROR_CODE_RELATION_CODE_INSERT = "SE1671"; // 关系代码插入错误
	public static final String ERROR_CODE_RELATION_CODE_SELECT = "SE1672"; // 关系代码读取错误
	public static final String ERROR_CODE_RELATION_CODE_UPDATE = "SE1673"; // 关系代码修改错误
	public static final String ERROR_CODE_GAGE_CLASS_SELECT = "SE1674"; // 押品信息读取错误
	public static final String ERROR_CODE_GAGE_CLASS_INSERT = "SE1675"; // 押品信息插入错误
	public static final String ERROR_CODE_GAGE_CLASS_UPDATE = "SE1676"; // 押品信息修改错误
	public static final String ERROR_CODE_GAGE_CLASS_IS_EXIST = "SE1677"; // 该押品已存在
	public static final String ERROR_CODE_WARNING_CODE_SAVE_OR_UPDATE = "SE1678"; // 预警信号代码插入更新失败
	public static final String ERROR_CODE_WARNING_CODE_UPDATE = "SE1679"; // 预警信号代码更新失败
	public static final String ERROR_CODE_WARNING_CODE_SELECT = "SE1680"; // 预警信号代码查询失败
	public static final String ERROR_CODE_WARNING_CODE_DELETE = "SE1681"; // 预警信号代码删除失败
	public static final String ERROR_CODE_WARNING_CODE_INSERT = "SE1682"; // 预警信号代码插入失败
	public static final String ERROR_CODE_BOP_FINANC_ORG_CODE_INSERT = "SE1683";    //人行金融机构代码证插入错误
	public static final String ERROR_CODE_BOP_FINANC_ORG_CODE_UPDATE = "SE1684";    //人行金融机构代码证更新错误
	public static final String ERROR_CODE_BOP_FINANC_ORG_CODE_DELETE = "SE1685";    //人行金融机构代码证删除错误
	public static final String ERROR_CODE_BOP_FINANC_ORG_CODE_SELECT = "SE1686";    //人行金融机构代码证读取错误
	public static final String ERROR_CODE_TRANSATION_REVERSED = "SE7513"; // 交易被冲正

	/** ****************************************************************************************** */


	/**
	 * ************************工作流模块DAO错误代码 SE1900~SE1999
	 */

	/**
	 * 台帐DAO错误 SE8500~SE9000
	 */

	public static final String ERROR_CODE_ACTIVE_SAVE_CARD_SELECT = "SE8500";// 活期存款卡片查询失败
	public static final String ERROR_CODE_ACTIVE_SAVE_CARD_UPDATE = "SE8501";// 活期存款卡片更新失败
	public static final String ERROR_CODE_ACTIVE_SAVE_CARD_INSERT = "SE8502";// 活期存款卡片插入失败
	public static final String ERROR_CODE_ACTIVE_SAVE_CARD_DELETE = "SE8503";// 活期存款卡片删除失败
	public static final String ERROR_CODE_ACTIVE_SAVE_CARD_SAVE_OR_UPDATE = "SE8504";// 活期存款卡片保存更新失败

	public static final String ERROR_CODE_ACTIVE_SAVE_DAY_SELECT = "SE8505";// 活期存款日表查询失败
	public static final String ERROR_CODE_ACTIVE_SAVE_DAY_UPDATE = "SE8506";// 活期存款日表更新失败
	public static final String ERROR_CODE_ACTIVE_SAVE_DAY_INSERT = "SE8507";// 活期存款日表插入失败
	public static final String ERROR_CODE_ACTIVE_SAVE_DAY_DELETE = "SE8508";// 活期存款日表删除失败
	public static final String ERROR_CODE_ACTIVE_SAVE_DAY_SAVE_OR_UPDATE = "SE8509";// 活期存款日表保存更新失败

	public static final String ERROR_CODE_ACTIVE_SAVE_MONTH_SELECT = "SE8510";// 活期存款月表查询失败
	public static final String ERROR_CODE_ACTIVE_SAVE_MONTH_UPDATE = "SE8511";// 活期存款月表更新失败
	public static final String ERROR_CODE_ACTIVE_SAVE_MONTH_INSERT = "SE8512";// 活期存款月表插入失败
	public static final String ERROR_CODE_ACTIVE_SAVE_MONTH_DELETE = "SE8513";// 活期存款月表删除失败
	public static final String ERROR_CODE_ACTIVE_SAVE_MONTH_SAVE_OR_UPDATE = "SE8514";// 活期存款月表保存更新失败

	public static final String ERROR_CODE_AIRLINER_SAVE_CARD_SELECT = "SE8515";// 定期存款卡片查询失败
	public static final String ERROR_CODE_AIRLINER_SAVE_CARD_UPDATE = "SE8516";// 定期存款卡片更新失败
	public static final String ERROR_CODE_AIRLINER_SAVE_CARD_INSERT = "SE8517";// 定期存款卡片插入失败
	public static final String ERROR_CODE_AIRLINER_SAVE_CARD_DELETE = "SE8518";// 定期存款卡片删除失败
	public static final String ERROR_CODE_AIRLINER_SAVE_CARD_SAVE_OR_UPDATE = "SE8519";// 定期存款卡片保存更新失败

	public static final String ERROR_CODE_AIRLINER_SAVE_DAY_SELECT = "SE8520";// 定期存款日表查询失败
	public static final String ERROR_CODE_AIRLINER_SAVE_DAY_UPDATE = "SE8521";// 定期存款日表更新失败
	public static final String ERROR_CODE_AIRLINER_SAVE_DAY_INSERT = "SE8522";// 定期存款日表插入失败
	public static final String ERROR_CODE_AIRLINER_SAVE_DAY_DELETE = "SE8523";// 定期存款日表删除失败
	public static final String ERROR_CODE_AIRLINER_SAVE_DAY_SAVE_OR_UPDATE = "SE8524";// 定期存款日表保存更新失败

	public static final String ERROR_CODE_AIRLINER_SAVE_MONTH_SELECT = "SE8525";// 定期存款月表查询失败
	public static final String ERROR_CODE_AIRLINER_SAVE_MONTH_UPDATE = "SE8526";// 定期存款月表更新失败
	public static final String ERROR_CODE_AIRLINER_SAVE_MONTH_INSERT = "SE8527";// 定期存款月表插入失败
	public static final String ERROR_CODE_AIRLINER_SAVE_MONTH_DELETE = "SE8528";// 定期存款月表删除失败
	public static final String ERROR_CODE_AIRLINER_SAVE_MONTH_SAVE_OR_UPDATE = "SE8529";// 定期存款月表保存更新失败

	public static final String ERROR_CODE_CUSTOMER_NO_CARD = "SE8530";// 该客户没有帐户
	public static final String ERROR_CODE_BCTL_NO_CARD = "SE8531";// 该机构没有帐户
	public static final String ERROR_CODE_NO_AC_IN_SYS = "SE8532";// 系统中没有活期存款帐号
	public static final String ERROR_CODE_NO_FIXED_AC_IN_SYS = "SE8533";// 系统中没有定期存款帐号
	public static final String ERROR_CODE_NO_NOTIFY_AC_IN_SYS = "SE8534";// 系统中没有通知存款帐号
	public static final String ERROR_CODE_NO_PROTOCOL_AC_IN_SYS = "SE8535";// 系统中没有协议存款帐号

	public static final String ERROR_CODE_NOT_FIND_THAT_CARD = "SE8536";// 系统中并未发现此帐号
	public static final String ERROR_CODE_NOT_FIND_CARD_IN_THIS_CURCD = "SE8537";// 此币种下没有帐号
	public static final String ERROR_CODE_NOT_FIND_CARD_IN_THIS_BR_BY_SAVE_TYPE = "SE8538";// 在此分行下没有找到该存款类型的帐号
	public static final String ERROR_CODE_NOT_FIND_CARD_IN_THIS_BR_BY_SAVE_ACTNO = "SE8539";// 在此分行下没有找到该帐号
	public static final String ERROR_CODE_NOT_FIND_CARD_IN_THIS_BR_BY_CURCD = "SE8540";// 在此分行下没有找到符合该币种的帐号
	public static final String ERROR_CODE_NOT_FIND_ACCORD = "SE8541";// 没有找到符合条件的信息
	public static final String ERROR_CODE_FIVE_CLASS_BAL_SELECT = "SE8542"; // 五级/状态分类余额统计表读取失败
	public static final String ERROR_CODE_LOAN_CARD_SELECT = "SE8543"; //贷款卡片表查询失败
	public static final String ERROR_CODE_CUSTOMER_TOT_RISK_SELECT = "SE8544";  //客户分析统计表按风险级别统计表查询失败


	/** ****************************************************************************************** */

	/** *************************************************业务错误(Service/Operation)************************************************ */

	/**
	 * 工作流错误代码 SE2001~SE2500
	 */
	public static final String ERROR_CODE_WORKFLOW_LOCKTASK_ERROR_CLAIMED = "SE2035"; //工作流锁任务失败-任务已被声明

	/** ****************************************************************************************** */

	/**
	 * 公控错误代码 SE3001~SE4000
	 */
	public static final String ERROR_CODE_DATE_LIMIT = "SE3006"; // 失效日期不能小于生效日期
	public static final String ERROR_CODE_SET_GAGE_CLASS_AFTER_SAVE = "SE3007"; // 设置押品小类请事先保存押品大类
	public static final String ERROR_CODE_NONE_INTRATE = "SE3008"; // 没有利率信息
	public static final String ERROR_CODE_NONE_BRANCH = "SE3009"; // 没有分行信息
	public static final String ERROR_CODE_NONE_HOLIDAY = "SE3010"; // 没有节假日信息
	public static final String ERROR_CODE_DUPICATE_SEQUENCE = "SE3011"; // 序列号重复
	public static final String ERROR_CODE_BRANCH_NOT_SELF = "SE3012"; // 输入分行不为本分行
	public static final String ERROR_CODE_IS_BRANCH_NOT_SELF = "SE3013"; // 输入的机构号为分行,但不为本分行
	public static final String ERROR_CODE_NOT_RANGE_IN_BRANCH = "SE3014"; // 输入的机构不在本分行管辖范围内
	public static final String ERROR_CODE_TLR_BE_DELETE = "SE3015"; //操作员已被删除
	public static final String ERROR_CODE_TLR_NO_EFFECT ="SE3016"; //操作员并未生效，生效日期为：
	public static final String ERROR_CODE_TLR_IS_EXPIRE ="SE3017"; //操作员已失效，失效日期为：
	/**
	 * 客户模块错误代码 SE4001~SE4500
	 */
	public static final String ERROR_CODE_CUSTCORP_INPUT_ERROR = "SE4020";// 客户号和组织机构代码证必输其一
	public static final String ERROR_CODE_STOCK_NUM_IS_NULL = "SE4021"; // 持股数不能为空
	public static final String ERROR_CODE_STOCK_AMT_IS_NULL = "SE4022"; // 持股金额不能为空
	public static final String ERROR_CODE_STOCK_PROPORTION_IS_NULL = "SE4023"; // 持股比例不能为空
	public static final String ERROR_CODE_RELA_CUST_NOT_EXIST = "SE4024";// 关联客户号不存在,请关联客户先申请客户号
	public static final String ERROR_CODE_DATE_FOR_CGEI_MIS = "SE4025"; // 发生日不能与结束日同一天
	public static final String ERROR_CODE_COOPPROTQRY_INPUT_ERROR = "SE4026"; // 客户号和地区号+组织机构代码证必输其一
	public static final String ERROR_CODE_CUSTCD_IS_DELETE = "SE4027"; // 该客户已删除
	public static final String ERROR_CODE_CUSTCD_IS_FREEZE = "SE4028"; // 该客户已冻结
	public static final String ERROR_CODE_BRANCHBRCODE_IS_NULL = "SE4029"; // 生效分行号为空
	public static final String ERROR_CODE_AREACD_IS_NULL = "SE4030"; // 生效地区号为空
	public static final String ERROR_CODE_DEPTCD_IS_NULL = "SE4031"; // 生效机构号为空
	public static final String ERROR_CODE_END_DATE_ERROR = "SE4032"; // 结束日期小于起始日期
	public static final String ERROR_CODE_TERMCOOPQRY_INPUT_IS_NULL = "SE4033"; // 查询条件至少输入一项
	public static final String ERROR_CODE_COOPPROT_IS_INVALID = "SE4034"; // 合作协议已经失效
	public static final String ERROR_CODE_COOPPROT_IS_FREEZE = "SE4035"; // 合作协议已经冻结
	public static final String ERROR_CODE_COOPPROT_IS_VALID = "SE4036"; // 合作协议有效
	public static final String ERROR_CODE_CUSTFREEZE_INPUT_ERROR = "SE4037"; // 客户号、主管客户经理、证件类型+证件号码必输其中一项
	public static final String ERROR_CODE_CUSTOMER_AIDANCE_MANAGE_INFO_SELECT = "SE4038";// 客户协管经理信息查询错误
	public static final String ERROR_CODE_CUSTOMER_AIDANCE_MANAGE_INFO_DELETE = "SE4039";// 客户协管经理信息删除错误
	public static final String ERROR_CODE_CUSTOMER_AIDANCE_MANAGE_INFO_INSERT = "SE4040";// 客户协管经理信息插入错误
	public static final String ERROR_CODE_CUSTOMER_AIDANCE_MANAGE_INFO_UPDATE = "SE4041";// 客户协管经理信息更新错误
	public static final String ERROR_CODE_SELECT_CUST_AIDANCE_MANAGE_INFO = "SE4042";// 需要查询客户协管经理信息,必须至少输入客户号、组织机构代码证、地区号其中一项
	public static final String ERROR_CODE_ORGCODE_BY_REGIONNO = "SE4043";// 根据组织机构号查询时,必须输入地区号
	public static final String ERROR_CODE_REGIONNO_BY_ORGCODE = "SE4044";// 根据地区号查询时,必须输入组织机构号
	public static final String ERROR_CODE_CUSTOMER_AIDANCE_MANAGE_INFO_BY_ORGCODE_AND_REGIONNO = "SE4045";// 没有找到符合条件的客户
	public static final String ERROR_CODE_CUSTCD_IS_VALID = "SE4046"; // 该客户有效
	public static final String ERROR_CODE_PLEASE_INPUT_IDNO_AND_REGIONNO = "SE4047"; // 请输入证件号与地区号
	public static final String ERROR_CODE_PLEASE_INPUT_IDTYPE_AND_REGIONNO = "SE4048"; // 请输入证件类型与地区号
	public static final String ERROR_CODE_PLEASE_INPUT_IDNO_AND_IDTYPE = "SE4049"; // 请输入证件号与证件类型
	public static final String ERROR_CODE_PLEASE_INPUT_REGIONNO = "SE4050"; // 请输入地区号
	public static final String ERROR_CODE_PLEASE_INPUT_IDNO = "SE4051"; // 请输入证件号
	public static final String ERROR_CODE_PLEASE_INPUT_IDTYPE = "SE4052"; // 请输入证件类型
	public static final String ERROR_CODE_NOT_CORP_CUSTOMER = "SE4053"; // 不是对公客户
	public static final String ERROR_CODE_NOT_INDV_CUSTOMER = "SE4054"; // 不是自然人客户
	public static final String ERROR_CODE_STOCK_PROPORTION_IS_LARGER = "SE4055"; // 持股比例大于100.00
	public static final String ERROR_CODE_CUST_HANDOVER_INPUT_ERROR = "SE4056"; // 原主管信贷部门和原主管客户经理必输一项
	public static final String ERROR_CODE_RELA_CUSTTYPE_IS_NULL = "SE4057"; // 关联客户类型为必输项
	public static final String ERROR_CODE_RELA_CUSTNO_IS_NULL = "SE4058"; // 关联客户号为必输项
	public static final String ERROR_CODE_CUST_INFO_IS_EXIST = "SE4059"; // 该客户基本信息已经建立
	public static final String ERROR_CODE_CUST_INFO_IS_NULL = "SE4060"; // 该客户基本信息未建立，请先建立客户基本信息
	public static final String ERROR_CODE_RELACODE_IS_UNIQUE = "SE4061"; // 该关系代码信息已经存在（唯一性），不需要新建
	public static final String ERROR_CODE_RELA_CUSTCD_IS_NULL = "SE4062"; // 关联客户号为空，请查询关联客户信息
	public static final String ERROR_CODE_RELA_CUSTCD_IS_SELF = "SE4063"; // 关联客户不能是客户本身
	public static final String ERROR_CODE_RELACODE_INFO_IS_EXIST = "SE4064"; // 该关联客户相关的关系代码信息已经存在，不需要新建
	public static final String ERROR_CODE_TLRNO_IS_NOT_IN_BRODE = "SE4065"; // 新客户经理不在所输入的新信贷部门
	public static final String ERROR_CODE_CORP_ORG_CD_IS_EXIST = "SE4066"; // 本地区,该组织机构代码证的对公客户信息已经存在。
	public static final String ERROR_CODE_iNDV_IDTYPE_IDNO_IS_EXIST = "SE4067"; // 本地区，该证件类型+证件号码的自然人客户信息已经存在。
	public static final String ERROR_ODE_DOCUMENT_ERROR = "SE4068"; // document处理出错
	public static final String ERROR_CODE_CUSTCD_DIRECTORMANAGERNO_IS_ERROR = "SE4069"; // 本柜员非该客户的主管客户经理,不能对其基本信息进行维护
	public static final String ERROR_CODE_CUSTOMER_INFO_LIST_IS_NULL = "SE4070"; // 没有找到符合条件的客户记录
	public static final String ERROR_CODE_BLACKLISTQRY_INPUT_ERROR = "SE4071"; // 客户号和批次号必输其一
	public static final String ERROR_CODE_CREDIT_GRADE_ERROR = "SE4072"; // 评级信息错误
	public static final String ERROR_CODE_BIRTH_DATE_IS_ERROR = "SE4073"; // 出生日期日期不能大于系统会计日期
	public static final String ERROR_CODE_CREDIT_INFO_DATE_IS_ERROR = "SE4074"; // 征信信息日期不能大于系统会计日期
	public static final String ERROR_CODE_CORP_CREATE_DATE_IS_ERROR = "SE4075"; // 开户日期不能大于系统会计日期
	public static final String ERROR_CODE_CUSTOMER_MANAGE_ROLE_IS_NULL = "SE4076"; // 输入的操作员无客户经理岗位
	public static final String ERROR_CODE_BRCODE_CLASS_BRANCH_ERROR = "SE4077"; // 输入生效分行号的机构级别非分行级别
	public static final String ERROR_CODE_BRCODE_CLASS_SUBBRANCH_ERROR = "SE4078"; // 输入生效机构号的机构级别非支行级别
	public static final String ERROR_CODE_CUST_INFO_REGIONNO_ERROR = "SE4079";    //该客户号非本地区的客户
	public static final String ERROR_CODE_COOPPROTINFO_IS_NULL = "SE4080";      //无符合条件的合作协议信息
	public static final String ERROR_CODE_CUST_NO_LENGTH_IS_ERROR ="SE4081";   //客户号长度不正确
	public static final String ERROR_CODE_RELACODE_IS_CORP = "SE4082";  //该关系代码对应的关联客户类型必须是对公
	public static final String ERROR_CODE_RELACODE_IS_INDV = "SE4083";   // 该关系代码对应的关联客户类型必须是自然人
	public static final String ERROR_CODE_COOPPROT_NO_INFO_NOT_EXIST = "SE4084";  // 该协议编号的协议信息不存在
	public static final String ERROR_CODE_CUSTOMER_COMMON = "SE4085"; //客户管理异常
	public static final String ERROR_CODE_CUST_CANNOT_DELETE = "SE4086";//客户不能删除
    public static final String ERROR_CODE_CUSTOMER_INPUT1_ERROR="SE4087"; //客户号和主管经理必输一项
    public static final String ERROR_CODE_BLACKLIST_IS_NO = "SE4088" ; // 该客户不是黑名单客户
    public static final String ERROR_CODE_CUST_INCOME_IS_NULL = "SE4089"; // 改客户未录入家庭财务信息
    public static final String ERROR_CODE_CUSTNO_LENGTH_ERROR = "SE4090" ; // 客户号长度为13位
    public static final String ERROR_CODE_CORP_TERM_IS_ERROR = "SE4091"; // 	本行帐户信息期限长度为3位。
    public static final String ERROR_CODE_CORP_TERM_FORMAT_IS_ERROR = "SE4092" ; // 期限格式错误。
    public static final String ERROR_CODE_MKUP_START_END_DATE_ERROR = "SE4093" ; // 起始日期不能大于结束日期。
    public static final String ERROR_CODE_CUSTAIDANCE_INPUT_ERROR = "SE4094" ; // 客户号、证件类型+证件号码必输其中一项
    public static final String ERROR_CODE_CUST_MANAGEDATE_IS_ERROR = "SE4095"; // 法定结业日期不能小于法定开业日期
    public static final String ERROR_CODE_AIDANCE_IS_NOT_DIFF = "SE4096"; // 不能建立相同的协管客户经理信息
    public static final String ERROR_CODE_TERM_FIRST_IS_ERROR = "SE4097" ; // 期限(D/M/Y)第一位只能为数字
    public static final String ERROR_CODE_TERM_Free_IS_ERROR = "SE4098" ; // 谁冻结谁解冻
    public static final String ERROR_CODE_CREDITCOVERAMT_IS_ERROR = "SE4099" ; // 汇率数据没有更新
    public static final String ERROR_CODE_BCTL_CREDIT_LIST_IS_ERROR = "SE4100" ; // 按照机构统计部门的授信业务余额信息
    public static final String ERROR_CODE_LICENSE_NO_IS_EXIST = "SE4101"; // 营业执照/批准证书 已存在
    public static final String ERROR_CODE_MUST_ENTER_GRADE_INFO = "SE4102"; // 请输入工贸信息
    public static final String ERROR_CODE_CREDIT_CARD_NO_LENGTH = "SE4103"; // 贷款卡号长度必须是16位



	/**
	 * 授信模块错误代码 SE4601~SE5000
	 */
	public static final String ERROR_CODE_MAX_BREED_AMT_BEYOND_PRODCUT_AMT = "SE4508"; // 品种额度金额最大值大于产品额度金额
	public static final String ERROR_CODE_CUST_FRZED_ONLY_BAIL = "SE4509"; // 该客户有产品已冻结，只能申请全额保证金额度
	public static final String ERROR_CODE_BRCODE_NOT_VALID = "SE4510"; // 额度使用部门非法
	public static final String ERROR_CODE_CURCD_NOT_VALID = "SE4511"; // 额度币种非法
	public static final String ERROR_CODE_CREDIT_OP_NOT_VALID = "SE4512"; // 额度操作类型错误
	public static final String ERROR_CODE_PROJECT_FRZED = "SE4613"; // 产品额度已冻结
	public static final String ERROR_CODE_PROJECT_NOT_ENOUGH_BAL_AMT = "SE4514"; // 占用额度大于产品可用额度
	public static final String ERROR_CODE_BREED_NOT_ENOUGH_BAL_AMT = "SE4515"; // 占用额度大于品种可用额度
	public static final String ERROR_CODE_PRODUCT_STATUS_CANNOT_OCCUPY = "SE4516"; // 产品额度状态不可占用
	public static final String ERROR_CODE_BREED_STATUS_CANNOT_OCCUPY = "SE4517"; // 品种额度状态不可占用
	public static final String ERROR_CODE_APPLY_DATE_2EARLY = "SE4518"; // 占用日期小于额度申请日期
	public static final String ERROR_CODE_DUE_DATE_BEYOND = "SE4519"; // 占用到期日大于额度到期日
	public static final String ERROR_CODE_OCCUPYCREDIT = "SE4520"; // 合同生效提交错误
	public static final String ERROR_CODE_DRAWNCREDIT = "SE4521"; // 凭证生效提交错误
	public static final String ERROR_CODE_RULEVAILD = "SE4522"; // 规则引擎校验错误
	public static final String ERROR_CODE_PARAMETEREVAILD = "SE4523"; // 传入参数错误
	public static final String ERROR_CODE_RESUMEVALID = "SE4524"; // 额度恢复错误

	/**
	 * 放款模块错误代码 SE5001~SE5500
	 */
	public static final String ERROR_CODE_OCCUPY_NOCONT = "SE5012";// 合同不存在
	public static final String ERROR_CODE_OCCUPY_STATEERROR = "SE5013";// 合同占(提)用状态错误
	public static final String ERROR_CODE_OCCUPY_OUTOFTERM = "SE5014";// 合同占(提)用日期错误
	public static final String ERROR_CODE_OCCUYP_OUTOFAMT = "SE5015";// 合同占(提)用金额错误



	/**
	 * 贷后变更及台账错误代码 SE6001~SE7000
	 */

	/** start 减免罚金  by qianlong 2011/2/10 */
	public static final String ERROR_CODE_PENALTY_REDUCTION_APPLY = "SE6011"; // 罚金减免申请错误
	/** end 减免罚金  by qianlong 2011/2/10 */
	public static final String ERROR_CODE_FIVECLASS_CHANGE = "SE6021"; // 五级分类变更错误
	public static final String ERROR_CODE_POSTLOAN_COMMON = "SE6022"; // 贷后管理异常
	public static final String ERROR_CODE_POSTLOAN_GET_CUST_INFO = "SE6023"; // 查询客户信息
	public static final String ERROR_CODE_POSTLOAN_GET_APPLY_DTL_LIST = "SE6024"; // 查询审批明细异常
	public static final String ERROR_CODE_POSTLOAN_GET_PRODUCT_CREDIT_INFO = "SE6025"; // 查询产品额度信息异常

	public static final String ERROR_CODE_MONITOR_COMMON = "SE6026"; // 贷后监控异常
	public static final String ERROR_CODE_MONITOR_INPUT = "SE6027"; // 贷后监控录入参数异常
	public static final String ERROR_CODE_MONITOR_GET_CREDIT_LIST = "SE6028"; // 查询产品授信信息异常
	public static final String ERROR_CODE_MONITOR_GET_CREDENCE_LIST = "SE6029"; // 查询凭证信息异常
	public static final String ERROR_CODE_MONITOR_INSERT_MONITOR = "SE6030"; // 插入监控信息异常
	public static final String ERROR_CODE_MONITOR_GET_MONITOR = "SE6031"; // 查询监控信息异常

	public static final String ERROR_CODE_MONITOR_GET_TASK_LIST = "SE6032"; // 查询工作流任务列表异常
	public static final String ERROR_CODE_MONITOR_CLAIM_TASK = "SE6033"; // 我要办理异常
	public static final String ERROR_CODE_MONITOR_UPLOAD_TASK = "SE6034"; // 上传任务异常
	public static final String ERROR_CODE_MONITOR_CANCLE_CLAIM_TASK = "SE6035"; // 取消办理异常
	public static final String ERROR_CODE_MONITOR_UPDATE_MONITOR = "SE6036"; // 更新监控信息异常
	public static final String ERROR_CODE_MONITOR_CANCLE_PROCESS = "SE6037"; // 取消流程异常
	public static final String ERROR_CODE_MONITOR_APPROVE_TASK = "SE6038"; // 审批异常

	public static final String ERROR_CODE_TRACE_COMMON = "SE6039"; // 催收登记异常
	public static final String ERROR_CODE_TRACE_INPUT = "SE6040"; // 催收登记录入参数异常
	public static final String ERROR_CODE_TRACE_GET_OVD = "SE6041"; // 查询凭证逾期信息异常
	public static final String ERROR_CODE_TRACE_GET_TRACEDTL_LIST = "SE6042"; // 查询催收历史异常
	public static final String ERROR_CODE_TRACE_INSERT_TRACEDTL = "SE6043"; // 插入催收记录异常
	public static final String ERROR_CODE_STATANALYZED_NOT_FOUND_QRY = "SE6044"; //没有查询到结果集
	public static final String ERROR_CODE_QUERY_THIS_ORG_HAVENT_CUST = "SE6045"; //该机构下未查询到客户


	/**
	 * 接口错误代码 SE9001~SE9500
	 */

	public static final String ERROR_CODE_RIRS_COMM = "SE9001";  //SEMS至RIRS联机交易通讯出错
	public static final String ERROR_CODE_RIRS_RET = "SE9002";  //RIRS返回交易失败回执
	public static final String ERROR_CODE_RIRS_IF = "SE9003";  //SEMS至RIRS联机交易接口出错
	public static final String ERROR_CODE_CBK_TIMEOUT = "SE9004";  //SEMS至核心联机交易接口超时
	public static final String ERROR_CODE_RIRS_INVALID = "SE9005"; //SEMS至RIRS的接口数据不全


	/**
	 * 财务分析报表模块错误代码 SE8001~SE8499
	 */
	public static final String ERROR_CODE_RPTANALYSEDATA_DELETE = "SE8001"; // 财务分析指标结果数据存放表删除错误
	public static final String ERROR_CODE_RPTANALYSEDATA_INSERT = "SE8002"; // 财务分析指标结果数据存放表插入错误
	public static final String ERROR_CODE_RPTANALYSEDATA_SELECT = "SE8003"; // 财务分析指标结果数据存放表读取错误
	public static final String ERROR_CODE_RPTANALYSEDATA_UPDATE = "SE8004"; // 财务分析指标结果数据存放表修改错误
	public static final String ERROR_CODE_RPTANALYSEINDEX_DELETE = "SE8005"; // 财务分析指标定义表删除错误
	public static final String ERROR_CODE_RPTANALYSEINDEX_INSERT = "SE8006"; // 财务分析指标定义表插入错误
	public static final String ERROR_CODE_RPTANALYSEINDEX_SELECT = "SE8007"; // 财务分析指标定义表读取错误
	public static final String ERROR_CODE_RPTANALYSEINDEX_UPDATE = "SE8008"; // 财务分析指标定义表修改错误
	public static final String ERROR_CODE_RPTBALANCECHECK_DELETE = "SE8009"; // 平衡检查公式表删除错误
	public static final String ERROR_CODE_RPTBALANCECHECK_INSERT = "SE8010"; // 平衡检查公式表插入错误
	public static final String ERROR_CODE_RPTBALANCECHECK_SELECT = "SE8011"; // 平衡检查公式表读取错误
	public static final String ERROR_CODE_RPTBALANCECHECK_UPDATE = "SE8012"; // 平衡检查公式表修改错误
	public static final String ERROR_CODE_RPTBSDATA_DELETE = "SE8013"; // 资产负债表数据存放表删除错误
	public static final String ERROR_CODE_RPTBSDATA_INSERT = "SE8014"; // 资产负债表数据存放表插入错误
	public static final String ERROR_CODE_RPTBSDATA_SELECT = "SE8015"; // 资产负债表数据存放表读取错误
	public static final String ERROR_CODE_RPTBSDATA_UPDATE = "SE8016"; // 资产负债表数据存放表修改错误
	public static final String ERROR_CODE_RPTCFDATA_DELETE = "SE8017"; // 现金流量表数据存放表删除错误
	public static final String ERROR_CODE_RPTCFDATA_INSERT = "SE8018"; // 现金流量表数据存放表插入错误
	public static final String ERROR_CODE_RPTCFDATA_SELECT = "SE8019"; // 现金流量表数据存放表读取错误
	public static final String ERROR_CODE_RPTCFDATA_UPDATE = "SE8020"; // 现金流量表数据存放表修改错误
	public static final String ERROR_CODE_RPTDATABASEINFO_DELETE = "SE8021"; // 客户财务报表基本信息表删除错误
	public static final String ERROR_CODE_RPTDATABASEINFO_INSERT = "SE8022"; // 客户财务报表基本信息表插入错误
	public static final String ERROR_CODE_RPTDATABASEINFO_SELECT = "SE8023"; // 客户财务报表基本信息表读取错误
	public static final String ERROR_CODE_RPTDATABASEINFO_UPDATE = "SE8024"; // 客户财务报表基本信息表修改错误
	public static final String ERROR_CODE_RPTDATADIC_DELETE = "SE8025"; // 报表科目数据项字典表删除错误
	public static final String ERROR_CODE_RPTDATADIC_INSERT = "SE8026"; // 报表科目数据项字典表插入错误
	public static final String ERROR_CODE_RPTDATADIC_SELECT = "SE8027"; // 报表科目数据项字典表读取错误
	public static final String ERROR_CODE_RPTDATADIC_UPDATE = "SE8028"; // 报表科目数据项字典表修改错误
	public static final String ERROR_CODE_RPTDATAMAP_DELETE = "SE8029"; // 财务报表映射表删除错误
	public static final String ERROR_CODE_RPTDATAMAP_INSERT = "SE8030"; // 财务报表映射表插入错误
	public static final String ERROR_CODE_RPTDATAMAP_SELECT = "SE8031"; // 财务报表映射表读取错误
	public static final String ERROR_CODE_RPTDATAMAP_UPDATE = "SE8032"; // 财务报表映射表修改错误
	public static final String ERROR_CODE_RPTFINAALARMDATA_DELETE = "SE8033"; // 财务预警指标结果数据存放表删除错误
	public static final String ERROR_CODE_RPTFINAALARMDATA_INSERT = "SE8034"; // 财务预警指标结果数据存放表插入错误
	public static final String ERROR_CODE_RPTFINAALARMDATA_SELECT = "SE8035"; // 财务预警指标结果数据存放表读取错误
	public static final String ERROR_CODE_RPTFINAALARMDATA_UPDATE = "SE8036"; // 财务预警指标结果数据存放表修改错误
	public static final String ERROR_CODE_RPTFINAALARMINDEX_DELETE = "SE8037"; // 预警指标定义表删除错误
	public static final String ERROR_CODE_RPTFINAALARMINDEX_INSERT = "SE8038"; // 预警指标定义表插入错误
	public static final String ERROR_CODE_RPTFINAALARMINDEX_SELECT = "SE8039"; // 预警指标定义表读取错误
	public static final String ERROR_CODE_RPTFINAALARMINDEX_UPDATE = "SE8040"; // 预警指标定义表修改错误
	public static final String ERROR_CODE_RPTISDATA_DELETE = "SE8041"; // 损益表数据存放表删除错误
	public static final String ERROR_CODE_RPTISDATA_INSERT = "SE8042"; // 损益表数据存放表插入错误
	public static final String ERROR_CODE_RPTISDATA_SELECT = "SE8043"; // 损益表数据存放表读取错误
	public static final String ERROR_CODE_RPTISDATA_UPDATE = "SE8044"; // 损益表数据存放表修改错误
	public static final String ERROR_CODE_RPTTYPEINFO_DELETE = "SE8045"; // 财务报表种类定义表删除错误
	public static final String ERROR_CODE_RPTTYPEINFO_INSERT = "SE8046"; // 财务报表种类定义表插入错误
	public static final String ERROR_CODE_RPTTYPEINFO_SELECT = "SE8047"; // 财务报表种类定义表读取错误
	public static final String ERROR_CODE_RPTTYPEINFO_UPDATE = "SE8048"; // 财务报表种类定义表修改错误
	public static final String ERROR_CODE_TMPRPTDATA_DELETE = "SE8049"; // 报表数据临时存放表删除错误
	public static final String ERROR_CODE_TMPRPTDATA_INSERT = "SE8050"; // 报表数据临时存放表插入错误
	public static final String ERROR_CODE_TMPRPTDATA_SELECT = "SE8051"; // 报表数据临时存放表读取错误
	public static final String ERROR_CODE_TMPRPTDATA_UPDATE = "SE8052"; // 报表数据临时存放表修改错误

	public static final String ERROR_CODE_RPT_TYPE_DIFF = "SE8053"; //报表格式不一致









	/******
	 * TODO 个贷Error code
	 */




	/**
	 * 通讯错误代码 GD0401~GD0500
	 */
	public static final String ERROR_CODE_SOP_PUT_VALUE = "GD0401"; //向SOP中填充数值错误
	public static final String ERROR_CODE_SOP_EXEC = "GD0402"; //SOP执行出错




// Add End
    public static final String ERROR_CODE_ACCUM_FUND_INFO_DELETE = "GD1101"; //客户公积金信息表删除错误
    public static final String ERROR_CODE_ACCUM_FUND_INFO_INSERT = "GD1102"; //客户公积金信息表插入错误
    public static final String ERROR_CODE_ACCUM_FUND_INFO_SELECT = "GD1103"; //客户公积金信息表读取错误
    public static final String ERROR_CODE_ACCUM_FUND_INFO_UPDATE = "GD1104"; //客户公积金信息表修改错误
    public static final String ERROR_CODE_ACMR_DELETE = "GD1105"; //科目总帐表删除错误
    public static final String ERROR_CODE_ACMR_INSERT = "GD1106"; //科目总帐表插入错误
    public static final String ERROR_CODE_ACMR_SELECT = "GD1107"; //科目总帐表读取错误
    public static final String ERROR_CODE_ACMR_UPDATE = "GD1108"; //科目总帐表修改错误
    public static final String ERROR_CODE_ADV_RTN_APPLY_DELETE = "GD1109"; //提前还款申请表删除错误
    public static final String ERROR_CODE_ADV_RTN_APPLY_INSERT = "GD1110"; //提前还款申请表插入错误
    public static final String ERROR_CODE_ADV_RTN_APPLY_SELECT = "GD1111"; //提前还款申请表读取错误
    public static final String ERROR_CODE_ADV_RTN_APPLY_UPDATE = "GD1112"; //提前还款申请表修改错误
    public static final String ERROR_CODE_APPLYDTL_DELETE = "GD1113"; //审批意见明细表删除错误
    public static final String ERROR_CODE_APPLYDTL_INSERT = "GD1114"; //审批意见明细表插入错误
    public static final String ERROR_CODE_APPLYDTL_SELECT = "GD1115"; //审批意见明细表读取错误
    public static final String ERROR_CODE_APPLYDTL_UPDATE = "GD1116"; //审批意见明细表修改错误
    public static final String ERROR_CODE_ARCHIVE_BRCODE_PARAM_DELETE = "GD1117"; //机构使用档案要素表删除错误
    public static final String ERROR_CODE_ARCHIVE_BRCODE_PARAM_INSERT = "GD1118"; //机构使用档案要素表插入错误
    public static final String ERROR_CODE_ARCHIVE_BRCODE_PARAM_SELECT = "GD1119"; //机构使用档案要素表读取错误
    public static final String ERROR_CODE_ARCHIVE_BRCODE_PARAM_UPDATE = "GD1120"; //机构使用档案要素表修改错误
    public static final String ERROR_CODE_ARCHIVE_DELETE = "GD1121"; //档案信息删除错误
    public static final String ERROR_CODE_ARCHIVE_INSERT = "GD1122"; //档案信息插入错误
    public static final String ERROR_CODE_ARCHIVE_ITEM_PARAM_DELETE = "GD1123"; //档案要素表删除错误
    public static final String ERROR_CODE_ARCHIVE_ITEM_PARAM_INSERT = "GD1124"; //档案要素表插入错误
    public static final String ERROR_CODE_ARCHIVE_ITEM_PARAM_SELECT = "GD1125"; //档案要素表读取错误
    public static final String ERROR_CODE_ARCHIVE_ITEM_PARAM_UPDATE = "GD1126"; //档案要素表修改错误
    public static final String ERROR_CODE_ARCHIVE_SELECT = "GD1127"; //档案信息读取错误
    public static final String ERROR_CODE_ARCHIVE_UPDATE = "GD1128"; //档案信息修改错误
    public static final String ERROR_CODE_ARCH_CUST_DELETE = "GD1129"; //借款人原始信息表删除错误
    public static final String ERROR_CODE_ARCH_CUST_INSERT = "GD1130"; //借款人原始信息表插入错误
    public static final String ERROR_CODE_ARCH_CUST_SELECT = "GD1131"; //借款人原始信息表读取错误
    public static final String ERROR_CODE_ARCH_CUST_UPDATE = "GD1132"; //借款人原始信息表修改错误
    public static final String ERROR_CODE_ARCH_LNINFO_DELETE = "GD1133"; //合同原始信息表删除错误
    public static final String ERROR_CODE_ARCH_LNINFO_INSERT = "GD1134"; //合同原始信息表插入错误
    public static final String ERROR_CODE_ARCH_LNINFO_SELECT = "GD1135"; //合同原始信息表读取错误
    public static final String ERROR_CODE_ARCH_LNINFO_UPDATE = "GD1136"; //合同原始信息表修改错误
    public static final String ERROR_CODE_ARCH_OPR_DELETE = "GD1137"; //档案/权利品操作记录表删除错误
    public static final String ERROR_CODE_ARCH_OPR_INSERT = "GD1138"; //档案/权利品操作记录表插入错误
    public static final String ERROR_CODE_ARCH_OPR_SELECT = "GD1139"; //档案/权利品操作记录表读取错误
    public static final String ERROR_CODE_ARCH_OPR_UPDATE = "GD1140"; //档案/权利品操作记录表修改错误
    public static final String ERROR_CODE_ASSUREINFO_DELETE = "GD1141"; //保证信息表删除错误
    public static final String ERROR_CODE_ASSUREINFO_INSERT = "GD1142"; //保证信息表插入错误
    public static final String ERROR_CODE_ASSUREINFO_SELECT = "GD1143"; //保证信息表读取错误
    public static final String ERROR_CODE_ASSUREINFO_UPDATE = "GD1144"; //保证信息表修改错误
    public static final String ERROR_CODE_AUTH_PARAM_DELETE = "GD1145"; //授权参数删除错误
    public static final String ERROR_CODE_AUTH_PARAM_INSERT = "GD1146"; //授权参数插入错误
    public static final String ERROR_CODE_AUTH_PARAM_SELECT = "GD1147"; //授权参数读取错误
    public static final String ERROR_CODE_AUTH_PARAM_UPDATE = "GD1148"; //授权参数修改错误
    public static final String ERROR_CODE_BATCHCLR_DELETE = "GD1149"; //批量数据清理表删除错误
    public static final String ERROR_CODE_BATCHCLR_INSERT = "GD1150"; //批量数据清理表插入错误
    public static final String ERROR_CODE_BATCHCLR_SELECT = "GD1151"; //批量数据清理表读取错误
    public static final String ERROR_CODE_BATCHCLR_UPDATE = "GD1152"; //批量数据清理表修改错误
    public static final String ERROR_CODE_BATCHJOB_DELETE = "GD1153"; //批量工作组类型表删除错误
    public static final String ERROR_CODE_BATCHJOB_INSERT = "GD1154"; //批量工作组类型表插入错误
    public static final String ERROR_CODE_BATCHJOB_SELECT = "GD1155"; //批量工作组类型表读取错误
    public static final String ERROR_CODE_BATCHJOB_UPDATE = "GD1156"; //批量工作组类型表修改错误
    public static final String ERROR_CODE_BATCHNO_DELETE = "GD1157"; //批量步骤配置表删除错误
    public static final String ERROR_CODE_BATCHNO_INSERT = "GD1158"; //批量步骤配置表插入错误
    public static final String ERROR_CODE_BATCHNO_SELECT = "GD1159"; //批量步骤配置表读取错误
    public static final String ERROR_CODE_BATCHNO_UPDATE = "GD1160"; //批量步骤配置表修改错误
    public static final String ERROR_CODE_BATCHPROC_DELETE = "GD1161"; //批量断点信息表删除错误
    public static final String ERROR_CODE_BATCHPROC_INSERT = "GD1162"; //批量断点信息表插入错误
    public static final String ERROR_CODE_BATCHPROC_SELECT = "GD1163"; //批量断点信息表读取错误
    public static final String ERROR_CODE_BATCHPROC_UPDATE = "GD1164"; //批量断点信息表修改错误
    public static final String ERROR_CODE_BATCHPST_DELETE = "GD1165"; //批量程序状态表删除错误
    public static final String ERROR_CODE_BATCHPST_INSERT = "GD1166"; //批量程序状态表插入错误
    public static final String ERROR_CODE_BATCHPST_SELECT = "GD1167"; //批量程序状态表读取错误
    public static final String ERROR_CODE_BATCHPST_UPDATE = "GD1168"; //批量程序状态表修改错误
    public static final String ERROR_CODE_BATCHSYS_DELETE = "GD1169"; //批量步骤进程表删除错误
    public static final String ERROR_CODE_BATCHSYS_INSERT = "GD1170"; //批量步骤进程表插入错误
    public static final String ERROR_CODE_BATCHSYS_SELECT = "GD1171"; //批量步骤进程表读取错误
    public static final String ERROR_CODE_BATCHSYS_UPDATE = "GD1172"; //批量步骤进程表修改错误
    public static final String ERROR_CODE_BCTL_DELETE = "GD1173"; //机构控制表删除错误
    public static final String ERROR_CODE_BCTL_INSERT = "GD1174"; //机构控制表插入错误
    public static final String ERROR_CODE_BCTL_SELECT = "GD1175"; //机构控制表读取错误
    public static final String ERROR_CODE_BCTL_UPDATE = "GD1176"; //机构控制表修改错误
    public static final String ERROR_CODE_BIZ_LOG_DELETE = "GD1177"; //交易日志表删除错误
    public static final String ERROR_CODE_BIZ_LOG_INSERT = "GD1178"; //交易日志表插入错误
    public static final String ERROR_CODE_BIZ_LOG_SELECT = "GD1179"; //交易日志表读取错误
    public static final String ERROR_CODE_BIZ_LOG_UPDATE = "GD1180"; //交易日志表修改错误
    public static final String ERROR_CODE_BRANCH_LOAN_STAT_DELETE = "GD1181"; //支行个贷业务统计表删除错误
    public static final String ERROR_CODE_BRANCH_LOAN_STAT_INSERT = "GD1182"; //支行个贷业务统计表插入错误
    public static final String ERROR_CODE_BRANCH_LOAN_STAT_SELECT = "GD1183"; //支行个贷业务统计表读取错误
    public static final String ERROR_CODE_BRANCH_LOAN_STAT_UPDATE = "GD1184"; //支行个贷业务统计表修改错误
    public static final String ERROR_CODE_CLIENT_ANALYSE_DELETE = "GD1185"; //客户分析删除错误
    public static final String ERROR_CODE_CLIENT_ANALYSE_INSERT = "GD1186"; //客户分析插入错误
    public static final String ERROR_CODE_CLIENT_ANALYSE_SELECT = "GD1187"; //客户分析读取错误
    public static final String ERROR_CODE_CLIENT_ANALYSE_UPDATE = "GD1188"; //客户分析修改错误
    public static final String ERROR_CODE_CLIENT_ANALYSE_VIEW_DELETE = "GD1189"; //客户分析视图删除错误
    public static final String ERROR_CODE_CLIENT_ANALYSE_VIEW_INSERT = "GD1190"; //客户分析视图插入错误
    public static final String ERROR_CODE_CLIENT_ANALYSE_VIEW_SELECT = "GD1191"; //客户分析视图读取错误
    public static final String ERROR_CODE_CLIENT_ANALYSE_VIEW_UPDATE = "GD1192"; //客户分析视图修改错误
    public static final String ERROR_CODE_CONJUNCT_LOAN_INFO_DELETE = "GD1193"; //参贷人信息表删除错误
    public static final String ERROR_CODE_CONJUNCT_LOAN_INFO_INSERT = "GD1194"; //参贷人信息表插入错误
    public static final String ERROR_CODE_CONJUNCT_LOAN_INFO_SELECT = "GD1195"; //参贷人信息表读取错误
    public static final String ERROR_CODE_CONJUNCT_LOAN_INFO_UPDATE = "GD1196"; //参贷人信息表修改错误
    public static final String ERROR_CODE_COOP_ANALYSE_DELETE = "GD1197"; //合作商统计分析删除错误
    public static final String ERROR_CODE_COOP_ANALYSE_INSERT = "GD1198"; //合作商统计分析插入错误
    public static final String ERROR_CODE_COOP_ANALYSE_SELECT = "GD1199"; //合作商统计分析读取错误
    public static final String ERROR_CODE_COOP_ANALYSE_UPDATE = "GD1200"; //合作商统计分析修改错误
    public static final String ERROR_CODE_COOP_PROJ_APPLY_DELETE = "GD1201"; //合作项目申请表删除错误
    public static final String ERROR_CODE_COOP_PROJ_APPLY_INSERT = "GD1202"; //合作项目申请表插入错误
    public static final String ERROR_CODE_COOP_PROJ_APPLY_SELECT = "GD1203"; //合作项目申请表读取错误
    public static final String ERROR_CODE_COOP_PROJ_APPLY_UPDATE = "GD1204"; //合作项目申请表修改错误
    public static final String ERROR_CODE_COOP_PROJ_AUTO_INFO_DELETE = "GD1205"; //合作项目汽车信息删除错误
    public static final String ERROR_CODE_COOP_PROJ_AUTO_INFO_INSERT = "GD1206"; //合作项目汽车信息插入错误
    public static final String ERROR_CODE_COOP_PROJ_AUTO_INFO_SELECT = "GD1207"; //合作项目汽车信息读取错误
    public static final String ERROR_CODE_COOP_PROJ_AUTO_INFO_UPDATE = "GD1208"; //合作项目汽车信息修改错误
    public static final String ERROR_CODE_COOP_PROJ_BASE_INFO_DELETE = "GD1209"; //合作项目基本信息表删除错误
    public static final String ERROR_CODE_COOP_PROJ_BASE_INFO_INSERT = "GD1210"; //合作项目基本信息表插入错误
    public static final String ERROR_CODE_COOP_PROJ_BASE_INFO_SELECT = "GD1211"; //合作项目基本信息表读取错误
    public static final String ERROR_CODE_COOP_PROJ_BASE_INFO_TEMP_DELETE = "GD1212"; //合作项目基本信息修改临时表删除错误
    public static final String ERROR_CODE_COOP_PROJ_BASE_INFO_TEMP_INSERT = "GD1213"; //合作项目基本信息修改临时表插入错误
    public static final String ERROR_CODE_COOP_PROJ_BASE_INFO_TEMP_SELECT = "GD1214"; //合作项目基本信息修改临时表读取错误
    public static final String ERROR_CODE_COOP_PROJ_BASE_INFO_TEMP_UPDATE = "GD1215"; //合作项目基本信息修改临时表修改错误
    public static final String ERROR_CODE_COOP_PROJ_BASE_INFO_UPDATE = "GD1216"; //合作项目基本信息表修改错误
    public static final String ERROR_CODE_COOP_PROJ_COMMUNION_DELETE = "GD1217"; //合作项目支行共享信息删除错误
    public static final String ERROR_CODE_COOP_PROJ_COMMUNION_INSERT = "GD1218"; //合作项目支行共享信息插入错误
    public static final String ERROR_CODE_COOP_PROJ_COMMUNION_SELECT = "GD1219"; //合作项目支行共享信息读取错误
    public static final String ERROR_CODE_COOP_PROJ_COMMUNION_UPDATE = "GD1220"; //合作项目支行共享信息修改错误
    public static final String ERROR_CODE_COOP_PROJ_CON_INFO_DELETE = "GD1221"; //合作项目消费品信息删除错误
    public static final String ERROR_CODE_COOP_PROJ_CON_INFO_INSERT = "GD1222"; //合作项目消费品信息插入错误
    public static final String ERROR_CODE_COOP_PROJ_CON_INFO_SELECT = "GD1223"; //合作项目消费品信息读取错误
    public static final String ERROR_CODE_COOP_PROJ_CON_INFO_UPDATE = "GD1224"; //合作项目消费品信息修改错误
    public static final String ERROR_CODE_COOP_PROJ_EDU_INFO_DELETE = "GD1225"; //合作项目助学信息删除错误
    public static final String ERROR_CODE_COOP_PROJ_EDU_INFO_INSERT = "GD1226"; //合作项目助学信息插入错误
    public static final String ERROR_CODE_COOP_PROJ_EDU_INFO_SELECT = "GD1227"; //合作项目助学信息读取错误
    public static final String ERROR_CODE_COOP_PROJ_EDU_INFO_UPDATE = "GD1228"; //合作项目助学信息修改错误
    public static final String ERROR_CODE_COOP_PROJ_HOUSE_H_DELETE = "GD1229"; //合作项目房屋历史价格信息删除错误
    public static final String ERROR_CODE_COOP_PROJ_HOUSE_H_INSERT = "GD1230"; //合作项目房屋历史价格信息插入错误
    public static final String ERROR_CODE_COOP_PROJ_HOUSE_H_SELECT = "GD1231"; //合作项目房屋历史价格信息读取错误
    public static final String ERROR_CODE_COOP_PROJ_HOUSE_H_UPDATE = "GD1232"; //合作项目房屋历史价格信息修改错误
    public static final String ERROR_CODE_COOP_PROJ_HOUSE_INFO_DELETE = "GD1233"; //合作项目房屋信息删除错误
    public static final String ERROR_CODE_COOP_PROJ_HOUSE_INFO_INSERT = "GD1234"; //合作项目房屋信息插入错误
    public static final String ERROR_CODE_COOP_PROJ_HOUSE_INFO_SELECT = "GD1235"; //合作项目房屋信息读取错误
    public static final String ERROR_CODE_COOP_PROJ_HOUSE_INFO_UPDATE = "GD1236"; //合作项目房屋信息修改错误
    public static final String ERROR_CODE_CORP_BASIC_INFO_DELETE = "GD1237"; //法人基本信息表删除错误
    public static final String ERROR_CODE_CORP_BASIC_INFO_INSERT = "GD1238"; //法人基本信息表插入错误
    public static final String ERROR_CODE_CORP_BASIC_INFO_SELECT = "GD1239"; //法人基本信息表读取错误
    public static final String ERROR_CODE_CORP_BASIC_INFO_UPDATE = "GD1240"; //法人基本信息表修改错误
    public static final String ERROR_CODE_CORP_FINANCE_INFO_DELETE = "GD1245"; //法人财务信息表删除错误
    public static final String ERROR_CODE_CORP_FINANCE_INFO_INSERT = "GD1246"; //法人财务信息表插入错误
    public static final String ERROR_CODE_CORP_FINANCE_INFO_SELECT = "GD1247"; //法人财务信息表读取错误
    public static final String ERROR_CODE_CORP_FINANCE_INFO_UPDATE = "GD1248"; //法人财务信息表修改错误
    public static final String ERROR_CODE_CORP_INVEST_INFO_DELETE = "GD1249"; //法人投资购成信息删除错误
    public static final String ERROR_CODE_CORP_INVEST_INFO_INSERT = "GD1250"; //法人投资购成信息插入错误
    public static final String ERROR_CODE_CORP_INVEST_INFO_SELECT = "GD1251"; //法人投资购成信息读取错误
    public static final String ERROR_CODE_CORP_INVEST_INFO_UPDATE = "GD1252"; //法人投资购成信息修改错误
    public static final String ERROR_CODE_CREDIT_GRANT_APPLY_DELETE = "GD1253"; //额度申请表删除错误
    public static final String ERROR_CODE_CREDIT_GRANT_APPLY_INSERT = "GD1254"; //额度申请表插入错误
    public static final String ERROR_CODE_CREDIT_GRANT_APPLY_SELECT = "GD1255"; //额度申请表读取错误
    public static final String ERROR_CODE_CREDIT_GRANT_APPLY_UPDATE = "GD1256"; //额度申请表修改错误
    public static final String ERROR_CODE_CURRRATE_DELETE = "GD1257"; //汇率表删除错误
    public static final String ERROR_CODE_CURRRATE_INSERT = "GD1258"; //汇率表插入错误
    public static final String ERROR_CODE_CURRRATE_SELECT = "GD1259"; //汇率表读取错误
    public static final String ERROR_CODE_CURRRATE_UPDATE = "GD1260"; //汇率表修改错误
    public static final String ERROR_CODE_CUSTOMER_CLASSIFICATION_DELETE = "GD1261"; //客户分类标准表删除错误
    public static final String ERROR_CODE_CUSTOMER_CLASSIFICATION_INSERT = "GD1262"; //客户分类标准表插入错误
    public static final String ERROR_CODE_CUSTOMER_CLASSIFICATION_SELECT = "GD1263"; //客户分类标准表读取错误
    public static final String ERROR_CODE_CUSTOMER_CLASSIFICATION_UPDATE = "GD1264"; //客户分类标准表修改错误
    public static final String ERROR_CODE_CUSTOMER_INFO_DELETE = "GD1265"; //客户基本信息表删除错误
    public static final String ERROR_CODE_CUSTOMER_INFO_INSERT = "GD1266"; //客户基本信息表插入错误
    public static final String ERROR_CODE_CUSTOMER_INFO_SELECT = "GD1267"; //客户基本信息表读取错误
    public static final String ERROR_CODE_CUSTOMER_INFO_UPDATE = "GD1268"; //客户基本信息表修改错误
    public static final String ERROR_CODE_CUSTOMER_RELATION_INFO_DELETE = "GD1269"; //客户关系表删除错误
    public static final String ERROR_CODE_CUSTOMER_RELATION_INFO_INSERT = "GD1270"; //客户关系表插入错误
    public static final String ERROR_CODE_CUSTOMER_RELATION_INFO_INSERT1 = "GD12701"; //客户关系表插入错误
    public static final String ERROR_CODE_CUSTOMER_RELATION_INFO_SELECT = "GD1271"; //客户关系表读取错误
    public static final String ERROR_CODE_CUSTOMER_RELATION_INFO_UPDATE = "GD1272"; //客户关系表修改错误
    public static final String ERROR_CODE_DATA_DIC_DELETE = "GD1273"; //数据字典表删除错误
    public static final String ERROR_CODE_DATA_DIC_INSERT = "GD1274"; //数据字典表插入错误
    public static final String ERROR_CODE_DATA_DIC_MAP_DELETE = "GD1275"; //数据字典映射表删除错误
    public static final String ERROR_CODE_DATA_DIC_MAP_INSERT = "GD1276"; //数据字典映射表插入错误
    public static final String ERROR_CODE_DATA_DIC_MAP_SELECT = "GD1277"; //数据字典映射表读取错误
    public static final String ERROR_CODE_DATA_DIC_MAP_UPDATE = "GD1278"; //数据字典映射表修改错误
    public static final String ERROR_CODE_DATA_DIC_SELECT = "GD1279"; //数据字典表读取错误
    public static final String ERROR_CODE_DATA_DIC_UPDATE = "GD1280"; //数据字典表修改错误
    public static final String ERROR_CODE_DIRECT_COOP_DELETE = "GD1281"; //直客式合作商信息表删除错误
    public static final String ERROR_CODE_DIRECT_COOP_INSERT = "GD1282"; //直客式合作商信息表插入错误
    public static final String ERROR_CODE_DIRECT_COOP_SELECT = "GD1283"; //直客式合作商信息表读取错误
    public static final String ERROR_CODE_DIRECT_COOP_UPDATE = "GD1284"; //直客式合作商信息表修改错误
    public static final String ERROR_CODE_DUN_MODE_PARAM_DELETE = "GD1285"; //逾期催收方式设置表删除错误
    public static final String ERROR_CODE_DUN_MODE_PARAM_INSERT = "GD1286"; //逾期催收方式设置表插入错误
    public static final String ERROR_CODE_DUN_MODE_PARAM_SELECT = "GD1287"; //逾期催收方式设置表读取错误
    public static final String ERROR_CODE_DUN_MODE_PARAM_UPDATE = "GD1288"; //逾期催收方式设置表修改错误
    public static final String ERROR_CODE_ERR_CODE_DEFINE_DELETE = "GD1289"; //错误代码定义表删除错误
    public static final String ERROR_CODE_ERR_CODE_DEFINE_INSERT = "GD1290"; //错误代码定义表插入错误
    public static final String ERROR_CODE_ERR_CODE_DEFINE_SELECT = "GD1291"; //错误代码定义表读取错误
    public static final String ERROR_CODE_ERR_CODE_DEFINE_UPDATE = "GD1292"; //错误代码定义表修改错误
    public static final String ERROR_CODE_FUNCTION_INFO_DELETE = "GD1293"; //交易定义表删除错误
    public static final String ERROR_CODE_FUNCTION_INFO_INSERT = "GD1294"; //交易定义表插入错误
    public static final String ERROR_CODE_FUNCTION_INFO_SELECT = "GD1295"; //交易定义表读取错误
    public static final String ERROR_CODE_FUNCTION_INFO_UPDATE = "GD1296"; //交易定义表修改错误
    public static final String ERROR_CODE_FUND_REPAY_CHG_APPLY_DELETE = "GD1297"; //公积金冲还贷变更申请表删除错误
    public static final String ERROR_CODE_FUND_REPAY_CHG_APPLY_INSERT = "GD1298"; //公积金冲还贷变更申请表插入错误
    public static final String ERROR_CODE_FUND_REPAY_CHG_APPLY_SELECT = "GD1299"; //公积金冲还贷变更申请表读取错误
    public static final String ERROR_CODE_FUND_REPAY_CHG_APPLY_UPDATE = "GD1300"; //公积金冲还贷变更申请表修改错误
    public static final String ERROR_CODE_GLOBALINFO_DELETE = "GD1301"; //系统表删除错误
    public static final String ERROR_CODE_GLOBALINFO_INSERT = "GD1302"; //系统表插入错误
    public static final String ERROR_CODE_GLOBALINFO_SELECT = "GD1303"; //系统表读取错误
    public static final String ERROR_CODE_GLOBALINFO_UPDATE = "GD1304"; //系统表修改错误
    public static final String ERROR_CODE_GRADE_CLS_APPLY_DELETE = "GD1305"; //五级分类申请表删除错误
    public static final String ERROR_CODE_GRADE_CLS_APPLY_INSERT = "GD1306"; //五级分类申请表插入错误
    public static final String ERROR_CODE_GRADE_CLS_APPLY_SELECT = "GD1307"; //五级分类申请表读取错误
    public static final String ERROR_CODE_GRADE_CLS_APPLY_UPDATE = "GD1308"; //五级分类申请表修改错误
    public static final String ERROR_CODE_GUARANTEESET_DELETE = "GD1309"; //权利品信息删除错误
    public static final String ERROR_CODE_GUARANTEESET_INSERT = "GD1310"; //权利品信息插入错误
    public static final String ERROR_CODE_GUARANTEESET_SELECT = "GD1311"; //权利品信息读取错误
    public static final String ERROR_CODE_GUARANTEESET_UPDATE = "GD1312"; //权利品信息修改错误
    public static final String ERROR_CODE_GUARANTEE_CHG_APPLY_DELETE = "GD1313"; //变更担保信息申请表删除错误
    public static final String ERROR_CODE_GUARANTEE_CHG_APPLY_INSERT = "GD1314"; //变更担保信息申请表插入错误
    public static final String ERROR_CODE_GUARANTEE_CHG_APPLY_SELECT = "GD1315"; //变更担保信息申请表读取错误
    public static final String ERROR_CODE_GUARANTEE_CHG_APPLY_UPDATE = "GD1316"; //变更担保信息申请表修改错误
    public static final String ERROR_CODE_GUAT_LIMIT_PARAM_DELETE = "GD1317"; //担保额度参数表删除错误
    public static final String ERROR_CODE_GUAT_LIMIT_PARAM_INSERT = "GD1318"; //担保额度参数表插入错误
    public static final String ERROR_CODE_GUAT_LIMIT_PARAM_SELECT = "GD1319"; //担保额度参数表读取错误
    public static final String ERROR_CODE_GUAT_LIMIT_PARAM_UPDATE = "GD1320"; //担保额度参数表修改错误
    public static final String ERROR_CODE_HOLIDAY_DELETE = "GD1321"; //日期控制表删除错误
    public static final String ERROR_CODE_HOLIDAY_INSERT = "GD1322"; //日期控制表插入错误
    public static final String ERROR_CODE_HOLIDAY_SELECT = "GD1323"; //日期控制表读取错误
    public static final String ERROR_CODE_HOLIDAY_UPDATE = "GD1324"; //日期控制表修改错误
    public static final String ERROR_CODE_IMPAWN_DELETE = "GD1325"; //质押信息表删除错误
    public static final String ERROR_CODE_IMPAWN_INSERT = "GD1326"; //质押信息表插入错误
    public static final String ERROR_CODE_IMPAWN_SELECT = "GD1327"; //质押信息表读取错误
    public static final String ERROR_CODE_IMPAWN_UPDATE = "GD1328"; //质押信息表修改错误
    public static final String ERROR_CODE_INDV_BASIC_INFO_DELETE = "GD1329"; //自然人基本信息表删除错误
    public static final String ERROR_CODE_INDV_BASIC_INFO_INSERT = "GD1330"; //自然人基本信息表插入错误
    public static final String ERROR_CODE_INDV_BASIC_INFO_SELECT = "GD1331"; //自然人基本信息表读取错误
    public static final String ERROR_CODE_INDV_BASIC_INFO_UPDATE = "GD1332"; //自然人基本信息表修改错误
    public static final String ERROR_CODE_INDV_INCOME_INFO_DELETE = "GD1333"; //家庭财务信息表删除错误
    public static final String ERROR_CODE_INDV_INCOME_INFO_INSERT = "GD1334"; //家庭财务信息表插入错误
    public static final String ERROR_CODE_INDV_INCOME_INFO_SELECT = "GD1335"; //家庭财务信息表读取错误
    public static final String ERROR_CODE_INDV_INCOME_INFO_UPDATE = "GD1336"; //家庭财务信息表修改错误
    public static final String ERROR_CODE_INFRACT_RECORD_INFO_DELETE = "GD1337"; //客户违规记录删除错误
    public static final String ERROR_CODE_INFRACT_RECORD_INFO_INSERT = "GD1338"; //客户违规记录插入错误
    public static final String ERROR_CODE_INFRACT_RECORD_INFO_SELECT = "GD1339"; //客户违规记录读取错误
    public static final String ERROR_CODE_INFRACT_RECORD_INFO_UPDATE = "GD1340"; //客户违规记录修改错误
    public static final String ERROR_CODE_INSURANCE_DELETE = "GD1341"; //履约保险信息删除错误
    public static final String ERROR_CODE_INSURANCE_INSERT = "GD1342"; //履约保险信息插入错误
    public static final String ERROR_CODE_INSURANCE_SELECT = "GD1343"; //履约保险信息读取错误
    public static final String ERROR_CODE_INSURANCE_UPDATE = "GD1344"; //履约保险信息修改错误
    public static final String ERROR_CODE_INSURER_ANALYSE_DELETE = "GD1345"; //保险公司分析删除错误
    public static final String ERROR_CODE_INSURER_ANALYSE_INSERT = "GD1346"; //保险公司分析插入错误
    public static final String ERROR_CODE_INSURER_ANALYSE_SELECT = "GD1347"; //保险公司分析读取错误
    public static final String ERROR_CODE_INSURER_ANALYSE_UPDATE = "GD1348"; //保险公司分析修改错误
    public static final String ERROR_CODE_INSURER_ANALYSE_VIEW_DELETE = "GD1349"; //保险公司分析视图删除错误
    public static final String ERROR_CODE_INSURER_ANALYSE_VIEW_INSERT = "GD1350"; //保险公司分析视图插入错误
    public static final String ERROR_CODE_INSURER_ANALYSE_VIEW_SELECT = "GD1351"; //保险公司分析视图读取错误
    public static final String ERROR_CODE_INSURER_ANALYSE_VIEW_UPDATE = "GD1352"; //保险公司分析视图修改错误
    public static final String ERROR_CODE_INTRATE_CHG_APPLY_DELETE = "GD1353"; //利率变更申请表删除错误
    public static final String ERROR_CODE_INTRATE_CHG_APPLY_INSERT = "GD1354"; //利率变更申请表插入错误
    public static final String ERROR_CODE_INTRATE_CHG_APPLY_SELECT = "GD1355"; //利率变更申请表读取错误
    public static final String ERROR_CODE_INTRATE_CHG_APPLY_UPDATE = "GD1356"; //利率变更申请表修改错误
    public static final String ERROR_CODE_INTRATE_DELETE = "GD1357"; //利率表删除错误
    public static final String ERROR_CODE_INTRATE_INSERT = "GD1358"; //利率表插入错误
    public static final String ERROR_CODE_INTRATE_SELECT = "GD1359"; //利率表读取错误
    public static final String ERROR_CODE_INTRATE_UPDATE = "GD1360"; //利率表修改错误
    public static final String ERROR_CODE_INTLOANMAP_DELETE = "GD1357"; //利率表删除错误
    public static final String ERROR_CODE_INTLOANMAP_INSERT = "GD1358"; //利率表插入错误
    public static final String ERROR_CODE_INTLOANMAP_SELECT = "GD1359"; //利率表读取错误
    public static final String ERROR_CODE_INTLOANMAP_UPDATE = "GD1360"; //利率表修改错误
    public static final String ERROR_CODE_INVEST_REPORT_DELETE = "GD1361"; //调查报告删除错误
    public static final String ERROR_CODE_INVEST_REPORT_INSERT = "GD1362"; //调查报告插入错误
    public static final String ERROR_CODE_INVEST_REPORT_SELECT = "GD1363"; //调查报告读取错误
    public static final String ERROR_CODE_INVEST_REPORT_UPDATE = "GD1364"; //调查报告修改错误
    public static final String ERROR_CODE_LIMIT_PARAM_DELETE = "GD1365"; //业务审批权限参数删除错误
    public static final String ERROR_CODE_LIMIT_PARAM_INSERT = "GD1366"; //业务审批权限参数插入错误
    public static final String ERROR_CODE_LIMIT_PARAM_SELECT = "GD1367"; //业务审批权限参数读取错误
    public static final String ERROR_CODE_LIMIT_PARAM_UPDATE = "GD1368"; //业务审批权限参数修改错误
    public static final String ERROR_CODE_LNHTR_DELETE = "GD1369"; //贷款台帐明细表删除错误
    public static final String ERROR_CODE_LNHTR_INSERT = "GD1370"; //贷款台帐明细表插入错误
    public static final String ERROR_CODE_LNHTR_SELECT = "GD1371"; //贷款台帐明细表读取错误
    public static final String ERROR_CODE_LNHTR_UPDATE = "GD1372"; //贷款台帐明细表修改错误
    public static final String ERROR_CODE_LNOWEDTL_DELETE = "GD1373"; //贷款期供明细表删除错误
    public static final String ERROR_CODE_LNOWEDTL_INSERT = "GD1374"; //贷款期供明细表插入错误
    public static final String ERROR_CODE_LNOWEDTL_SELECT = "GD1375"; //贷款期供明细表读取错误
    public static final String ERROR_CODE_LNOWEDTL_UPDATE = "GD1376"; //贷款期供明细表修改错误
    public static final String ERROR_CODE_LNTYPE_INFO_DELETE = "GD1377"; //贷款大类删除错误
    public static final String ERROR_CODE_LNTYPE_INFO_INSERT = "GD1378"; //贷款大类插入错误
    public static final String ERROR_CODE_LNTYPE_INFO_SELECT = "GD1379"; //贷款大类读取错误
    public static final String ERROR_CODE_LNTYPE_INFO_UPDATE = "GD1380"; //贷款大类修改错误
    public static final String ERROR_CODE_LN_CLR_STRUCT_ANALYSE_DELETE = "GD1381"; //个贷五级分类结构分析删除错误
    public static final String ERROR_CODE_LN_CLR_STRUCT_ANALYSE_INSERT = "GD1382"; //个贷五级分类结构分析插入错误
    public static final String ERROR_CODE_LN_CLR_STRUCT_ANALYSE_SELECT = "GD1383"; //个贷五级分类结构分析读取错误
    public static final String ERROR_CODE_LN_CLR_STRUCT_ANALYSE_UPDATE = "GD1384"; //个贷五级分类结构分析修改错误
    public static final String ERROR_CODE_LN_GUAT_CLR_ANALYSE_DELETE = "GD1385"; //个贷担保方式的五级分类分析删除错误
    public static final String ERROR_CODE_LN_GUAT_CLR_ANALYSE_INSERT = "GD1386"; //个贷担保方式的五级分类分析插入错误
    public static final String ERROR_CODE_LN_GUAT_CLR_ANALYSE_SELECT = "GD1387"; //个贷担保方式的五级分类分析读取错误
    public static final String ERROR_CODE_LN_GUAT_CLR_ANALYSE_UPDATE = "GD1388"; //个贷担保方式的五级分类分析修改错误
    public static final String ERROR_CODE_LN_GUAT_STATUS_ANALYSE_DELETE = "GD1389"; //个贷担保方式的形态结构分析删除错误
    public static final String ERROR_CODE_LN_GUAT_STATUS_ANALYSE_INSERT = "GD1390"; //个贷担保方式的形态结构分析插入错误
    public static final String ERROR_CODE_LN_GUAT_STATUS_ANALYSE_SELECT = "GD1391"; //个贷担保方式的形态结构分析读取错误
    public static final String ERROR_CODE_LN_GUAT_STATUS_ANALYSE_UPDATE = "GD1392"; //个贷担保方式的形态结构分析修改错误
    public static final String ERROR_CODE_LN_GUAT_STRUCT_ANALYSE_DELETE = "GD1393"; //个贷担保方式结构分析删除错误
    public static final String ERROR_CODE_LN_GUAT_STRUCT_ANALYSE_INSERT = "GD1394"; //个贷担保方式结构分析插入错误
    public static final String ERROR_CODE_LN_GUAT_STRUCT_ANALYSE_SELECT = "GD1395"; //个贷担保方式结构分析读取错误
    public static final String ERROR_CODE_LN_GUAT_STRUCT_ANALYSE_UPDATE = "GD1396"; //个贷担保方式结构分析修改错误
    public static final String ERROR_CODE_LN_OVD_STRUCT_ANALYSE_DELETE = "GD1397"; //个贷逾期结构分析删除错误
    public static final String ERROR_CODE_LN_OVD_STRUCT_ANALYSE_INSERT = "GD1398"; //个贷逾期结构分析插入错误
    public static final String ERROR_CODE_LN_OVD_STRUCT_ANALYSE_SELECT = "GD1399"; //个贷逾期结构分析读取错误
    public static final String ERROR_CODE_LN_OVD_STRUCT_ANALYSE_UPDATE = "GD1400"; //个贷逾期结构分析修改错误
    public static final String ERROR_CODE_LN_RTN_TYPE_ANALYSE_DELETE = "GD1401"; //个贷还款方式结构分析删除错误
    public static final String ERROR_CODE_LN_RTN_TYPE_ANALYSE_INSERT = "GD1402"; //个贷还款方式结构分析插入错误
    public static final String ERROR_CODE_LN_RTN_TYPE_ANALYSE_SELECT = "GD1403"; //个贷还款方式结构分析读取错误
    public static final String ERROR_CODE_LN_RTN_TYPE_ANALYSE_UPDATE = "GD1404"; //个贷还款方式结构分析修改错误
    public static final String ERROR_CODE_LN_STATUS_STRUCT_ANALYSE_DELETE = "GD1405"; //个贷贷款形态结构分析删除错误
    public static final String ERROR_CODE_LN_STATUS_STRUCT_ANALYSE_INSERT = "GD1406"; //个贷贷款形态结构分析插入错误
    public static final String ERROR_CODE_LN_STATUS_STRUCT_ANALYSE_SELECT = "GD1407"; //个贷贷款形态结构分析读取错误
    public static final String ERROR_CODE_LN_STATUS_STRUCT_ANALYSE_UPDATE = "GD1408"; //个贷贷款形态结构分析修改错误
    public static final String ERROR_CODE_LN_TERM_STRUCT_ANALYSE_DELETE = "GD1409"; //个贷品种期限结构分析删除错误
    public static final String ERROR_CODE_LN_TERM_STRUCT_ANALYSE_INSERT = "GD1410"; //个贷品种期限结构分析插入错误
    public static final String ERROR_CODE_LN_TERM_STRUCT_ANALYSE_SELECT = "GD1411"; //个贷品种期限结构分析读取错误
    public static final String ERROR_CODE_LN_TERM_STRUCT_ANALYSE_UPDATE = "GD1412"; //个贷品种期限结构分析修改错误
    public static final String ERROR_CODE_LOANCINO_DELETE = "GD1413"; //贷款借据信息删除错误
    public static final String ERROR_CODE_LOANCINO_INSERT = "GD1414"; //贷款借据信息插入错误
    public static final String ERROR_CODE_LOANCINO_SELECT = "GD1415"; //贷款借据信息读取错误
    public static final String ERROR_CODE_LOANCINO_UPDATE = "GD1416"; //贷款借据信息修改错误
    public static final String ERROR_CODE_LOANINFO_DELETE = "GD1417"; //贷款合同信息删除错误
    public static final String ERROR_CODE_LOANINFO_INSERT = "GD1418"; //贷款合同信息插入错误
    public static final String ERROR_CODE_LOANINFO_SELECT = "GD1419"; //贷款合同信息读取错误
    public static final String ERROR_CODE_LOANINFO_UPDATE = "GD1420"; //贷款合同信息修改错误
    public static final String ERROR_CODE_LOAN_AUTO_DELETE = "GD1421"; //汽车贷款附属信息删除错误
    public static final String ERROR_CODE_LOAN_AUTO_INSERT = "GD1422"; //汽车贷款附属信息插入错误
    public static final String ERROR_CODE_LOAN_AUTO_SELECT = "GD1423"; //汽车贷款附属信息读取错误
    public static final String ERROR_CODE_LOAN_AUTO_UPDATE = "GD1424"; //汽车贷款附属信息修改错误
    public static final String ERROR_CODE_LOAN_CONSUMABLE_DELETE = "GD1425"; //消费品贷款附属信息删除错误
    public static final String ERROR_CODE_LOAN_CONSUMABLE_INSERT = "GD1426"; //消费品贷款附属信息插入错误
    public static final String ERROR_CODE_LOAN_CONSUMABLE_SELECT = "GD1427"; //消费品贷款附属信息读取错误
    public static final String ERROR_CODE_LOAN_CONSUMABLE_UPDATE = "GD1428"; //消费品贷款附属信息修改错误
    public static final String ERROR_CODE_LOAN_EDUCATION_DELETE = "GD1429"; //助学贷款附属信息删除错误
    public static final String ERROR_CODE_LOAN_EDUCATION_INSERT = "GD1430"; //助学贷款附属信息插入错误
    public static final String ERROR_CODE_LOAN_EDUCATION_SELECT = "GD1431"; //助学贷款附属信息读取错误
    public static final String ERROR_CODE_LOAN_EDUCATION_UPDATE = "GD1432"; //助学贷款附属信息修改错误
    public static final String ERROR_CODE_LOAN_GRANT_APPLY_DELETE = "GD1433"; //贷款申请表删除错误
    public static final String ERROR_CODE_LOAN_GRANT_APPLY_INSERT = "GD1434"; //贷款申请表插入错误
    public static final String ERROR_CODE_LOAN_GRANT_APPLY_SELECT = "GD1435"; //贷款申请表读取错误
    public static final String ERROR_CODE_LOAN_GRANT_APPLY_UPDATE = "GD1436"; //贷款申请表修改错误
    public static final String ERROR_CODE_LOAN_GRANT_PLAN_DELETE = "GD1437"; //助学贷款放款计划表删除错误
    public static final String ERROR_CODE_LOAN_GRANT_PLAN_INSERT = "GD1438"; //助学贷款放款计划表插入错误
    public static final String ERROR_CODE_LOAN_GRANT_PLAN_SELECT = "GD1439"; //助学贷款放款计划表读取错误
    public static final String ERROR_CODE_LOAN_GRANT_PLAN_UPDATE = "GD1440"; //助学贷款放款计划表修改错误
    public static final String ERROR_CODE_LOAN_HOUSE_DELETE = "GD1441"; //购房贷款附属信息删除错误
    public static final String ERROR_CODE_LOAN_HOUSE_INSERT = "GD1442"; //购房贷款附属信息插入错误
    public static final String ERROR_CODE_LOAN_HOUSE_SELECT = "GD1443"; //购房贷款附属信息读取错误
    public static final String ERROR_CODE_LOAN_HOUSE_UPDATE = "GD1444"; //购房贷款附属信息修改错误
    public static final String ERROR_CODE_LOAN_PARAM_DELETE = "GD1445"; //贷款产品定义表删除错误
    public static final String ERROR_CODE_LOAN_PARAM_INSERT = "GD1446"; //贷款产品定义表插入错误
    public static final String ERROR_CODE_LOAN_PARAM_SELECT = "GD1447"; //贷款产品定义表读取错误
    public static final String ERROR_CODE_LOAN_PARAM_UPDATE = "GD1448"; //贷款产品定义表修改错误
    public static final String ERROR_CODE_LOAN_TO_BAD_APPLY_DELETE = "GD1449"; //贷款转呆滞/呆帐申请表删除错误
    public static final String ERROR_CODE_LOAN_TO_BAD_APPLY_INSERT = "GD1450"; //贷款转呆滞/呆帐申请表插入错误
    public static final String ERROR_CODE_LOAN_TO_BAD_APPLY_SELECT = "GD1451"; //贷款转呆滞/呆帐申请表读取错误
    public static final String ERROR_CODE_LOAN_TO_BAD_APPLY_UPDATE = "GD1452"; //贷款转呆滞/呆帐申请表修改错误
    public static final String ERROR_CODE_LOAN_WORKING_DELETE = "GD1453"; //生产经营性贷款附属信息删除错误
    public static final String ERROR_CODE_LOAN_WORKING_INSERT = "GD1454"; //生产经营性贷款附属信息插入错误
    public static final String ERROR_CODE_LOAN_WORKING_SELECT = "GD1455"; //生产经营性贷款附属信息读取错误
    public static final String ERROR_CODE_LOAN_WORKING_UPDATE = "GD1456"; //生产经营性贷款附属信息修改错误
    public static final String ERROR_CODE_MANAGE_BCTL_DELETE = "GD1457"; //管理机构控制表删除错误
    public static final String ERROR_CODE_MANAGE_BCTL_INSERT = "GD1458"; //管理机构控制表插入错误
    public static final String ERROR_CODE_MANAGE_BCTL_SELECT = "GD1459"; //管理机构控制表读取错误
    public static final String ERROR_CODE_MANAGE_BCTL_UPDATE = "GD1460"; //管理机构控制表修改错误
    public static final String ERROR_CODE_MANAGE_PARAM_DELETE = "GD1461"; //贷款管理参数删除错误
    public static final String ERROR_CODE_MANAGE_PARAM_INSERT = "GD1462"; //贷款管理参数插入错误
    public static final String ERROR_CODE_MANAGE_PARAM_SELECT = "GD1463"; //贷款管理参数读取错误
    public static final String ERROR_CODE_MANAGE_PARAM_UPDATE = "GD1464"; //贷款管理参数修改错误
    public static final String ERROR_CODE_MATERIAL_DELETE = "GD1465"; //档案资料类型信息删除错误
    public static final String ERROR_CODE_MATERIAL_INSERT = "GD1466"; //档案资料类型信息插入错误
    public static final String ERROR_CODE_MATERIAL_SELECT = "GD1467"; //档案资料类型信息读取错误
    public static final String ERROR_CODE_MATERIAL_UPDATE = "GD1468"; //档案资料类型信息修改错误
    public static final String ERROR_CODE_MEMORABILIA_INFO_DELETE = "GD1469"; //客户大事记删除错误
    public static final String ERROR_CODE_MEMORABILIA_INFO_INSERT = "GD1470"; //客户大事记插入错误
    public static final String ERROR_CODE_MEMORABILIA_INFO_SELECT = "GD1471"; //客户大事记读取错误
    public static final String ERROR_CODE_MEMORABILIA_INFO_UPDATE = "GD1472"; //客户大事记修改错误
    public static final String ERROR_CODE_MORTAGAGE_CLASSIFICATION_DELETE = "GD1477"; //抵押物分类标准表删除错误
    public static final String ERROR_CODE_MORTAGAGE_CLASSIFICATION_H_DELETE = "GD1478"; //抵押物分类历史表删除错误
    public static final String ERROR_CODE_MORTAGAGE_CLASSIFICATION_H_INSERT = "GD1479"; //抵押物分类历史表插入错误
    public static final String ERROR_CODE_MORTAGAGE_CLASSIFICATION_H_SELECT = "GD1480"; //抵押物分类历史表读取错误
    public static final String ERROR_CODE_MORTAGAGE_CLASSIFICATION_H_UPDATE = "GD1481"; //抵押物分类历史表修改错误
    public static final String ERROR_CODE_MORTAGAGE_CLASSIFICATION_INSERT = "GD1482"; //抵押物分类标准表插入错误
    public static final String ERROR_CODE_MORTAGAGE_CLASSIFICATION_SELECT = "GD1483"; //抵押物分类标准表读取错误
    public static final String ERROR_CODE_MORTAGAGE_CLASSIFICATION_UPDATE = "GD1484"; //抵押物分类标准表修改错误
    public static final String ERROR_CODE_MORTAGAGE_DELETE = "GD1485"; //抵押信息表删除错误
    public static final String ERROR_CODE_MORTAGAGE_INSERT = "GD1486"; //抵押信息表插入错误
    public static final String ERROR_CODE_MORTAGAGE_SELECT = "GD1487"; //抵押信息表读取错误
    public static final String ERROR_CODE_MORTAGAGE_UPDATE = "GD1488"; //抵押信息表修改错误
    public static final String ERROR_CODE_MORT_EVAL_HISTORY_DELETE = "GD1489"; //抵押物历史评估记录删除错误
    public static final String ERROR_CODE_MORT_EVAL_HISTORY_INSERT = "GD1490"; //抵押物历史评估记录插入错误
    public static final String ERROR_CODE_MORT_EVAL_HISTORY_SELECT = "GD1491"; //抵押物历史评估记录读取错误
    public static final String ERROR_CODE_MORT_EVAL_HISTORY_UPDATE = "GD1492"; //抵押物历史评估记录修改错误
    public static final String ERROR_CODE_NOTARIZATION_DELETE = "GD1493"; //公证信息表删除错误
    public static final String ERROR_CODE_NOTARIZATION_INSERT = "GD1494"; //公证信息表插入错误
    public static final String ERROR_CODE_NOTARIZATION_SELECT = "GD1495"; //公证信息表读取错误
    public static final String ERROR_CODE_NOTARIZATION_UPDATE = "GD1496"; //公证信息表修改错误
    public static final String ERROR_CODE_NOTE_DELETE = "GD1497"; //记事本删除错误
    public static final String ERROR_CODE_NOTE_INSERT = "GD1498"; //记事本插入错误
    public static final String ERROR_CODE_NOTE_SELECT = "GD1499"; //记事本读取错误
    public static final String ERROR_CODE_NOTE_UPDATE = "GD1500"; //记事本修改错误
    public static final String ERROR_CODE_PHASESDTL_DELETE = "GD1501"; //阶段还款计划表删除错误
    public static final String ERROR_CODE_PHASESDTL_INSERT = "GD1502"; //阶段还款计划表插入错误
    public static final String ERROR_CODE_PHASESDTL_SELECT = "GD1503"; //阶段还款计划表读取错误
    public static final String ERROR_CODE_PHASESDTL_UPDATE = "GD1504"; //阶段还款计划表修改错误
    public static final String ERROR_CODE_PL_TLRCTL_DELETE = "GD1505"; //电子操作员表删除错误
    public static final String ERROR_CODE_PL_TLRCTL_INSERT = "GD1506"; //电子操作员表插入错误
    public static final String ERROR_CODE_PL_TLRCTL_SELECT = "GD1507"; //电子操作员表读取错误
    public static final String ERROR_CODE_PL_TLRCTL_UPDATE = "GD1508"; //电子操作员表修改错误
    public static final String ERROR_CODE_PROJECT_ANALYSE_DELETE = "GD1509"; //合作项目统计分析删除错误
    public static final String ERROR_CODE_PROJECT_ANALYSE_INSERT = "GD1510"; //合作项目统计分析插入错误
    public static final String ERROR_CODE_PROJECT_ANALYSE_SELECT = "GD1511"; //合作项目统计分析读取错误
    public static final String ERROR_CODE_PROJECT_ANALYSE_UPDATE = "GD1512"; //合作项目统计分析修改错误
    public static final String ERROR_CODE_QUERY_CONDITION_DELETE = "GD1513"; //贷款查询条件临时表删除错误
    public static final String ERROR_CODE_QUERY_CONDITION_INSERT = "GD1514"; //贷款查询条件临时表插入错误
    public static final String ERROR_CODE_QUERY_CONDITION_SELECT = "GD1515"; //贷款查询条件临时表读取错误
    public static final String ERROR_CODE_QUERY_CONDITION_UPDATE = "GD1516"; //贷款查询条件临时表修改错误
    public static final String ERROR_CODE_QUERY_RESULT_DELETE = "GD1517"; //贷款查询结果临时表删除错误
    public static final String ERROR_CODE_QUERY_RESULT_INSERT = "GD1518"; //贷款查询结果临时表插入错误
    public static final String ERROR_CODE_QUERY_RESULT_SELECT = "GD1519"; //贷款查询结果临时表读取错误
    public static final String ERROR_CODE_QUERY_RESULT_UPDATE = "GD1520"; //贷款查询结果临时表修改错误
    public static final String ERROR_CODE_RISK_ALARM_PARAM_DELETE = "GD1521"; //风险预警参数设置表删除错误
    public static final String ERROR_CODE_RISK_ALARM_PARAM_INSERT = "GD1522"; //风险预警参数设置表插入错误
    public static final String ERROR_CODE_RISK_ALARM_PARAM_SELECT = "GD1523"; //风险预警参数设置表读取错误
    public static final String ERROR_CODE_RISK_ALARM_PARAM_UPDATE = "GD1524"; //风险预警参数设置表修改错误
    public static final String ERROR_CODE_ROLE_FUNC_RELATION_DELETE = "GD1525"; //岗位交易权限表删除错误
    public static final String ERROR_CODE_ROLE_FUNC_RELATION_INSERT = "GD1526"; //岗位交易权限表插入错误
    public static final String ERROR_CODE_ROLE_FUNC_RELATION_SELECT = "GD1527"; //岗位交易权限表读取错误
    public static final String ERROR_CODE_ROLE_FUNC_RELATION_UPDATE = "GD1528"; //岗位交易权限表修改错误
    public static final String ERROR_CODE_ROLE_INFO_DELETE = "GD1529"; //岗位定义表删除错误
    public static final String ERROR_CODE_ROLE_INFO_INSERT = "GD1530"; //岗位定义表插入错误
    public static final String ERROR_CODE_ROLE_INFO_SELECT = "GD1531"; //岗位定义表读取错误
    public static final String ERROR_CODE_ROLE_INFO_UPDATE = "GD1532"; //岗位定义表修改错误
    public static final String ERROR_CODE_ROLE_REPORT_PARAM_DELETE = "GD1533"; //岗位报表权限表删除错误
    public static final String ERROR_CODE_ROLE_REPORT_PARAM_INSERT = "GD1534"; //岗位报表权限表插入错误
    public static final String ERROR_CODE_ROLE_REPORT_PARAM_SELECT = "GD1535"; //岗位报表权限表读取错误
    public static final String ERROR_CODE_ROLE_REPORT_PARAM_UPDATE = "GD1536"; //岗位报表权限表修改错误
    public static final String ERROR_CODE_RTN_ACTNO_CHG_APPLY_DELETE = "GD1537"; //还款帐号变更申请表删除错误
    public static final String ERROR_CODE_RTN_ACTNO_CHG_APPLY_INSERT = "GD1538"; //还款帐号变更申请表插入错误
    public static final String ERROR_CODE_RTN_ACTNO_CHG_APPLY_SELECT = "GD1539"; //还款帐号变更申请表读取错误
    public static final String ERROR_CODE_RTN_ACTNO_CHG_APPLY_UPDATE = "GD1540"; //还款帐号变更申请表修改错误
    public static final String ERROR_CODE_RTN_DATE_CHG_APPLY_DELETE = "GD1541"; //约定扣款日变更申请表删除错误
    public static final String ERROR_CODE_RTN_DATE_CHG_APPLY_INSERT = "GD1542"; //约定扣款日变更申请表插入错误
    public static final String ERROR_CODE_RTN_DATE_CHG_APPLY_SELECT = "GD1543"; //约定扣款日变更申请表读取错误
    public static final String ERROR_CODE_RTN_DATE_CHG_APPLY_UPDATE = "GD1544"; //约定扣款日变更申请表修改错误
    public static final String ERROR_CODE_RTN_TYPE_CHG_APPLY_DELETE = "GD1545"; //还款方式变更申请表删除错误
    public static final String ERROR_CODE_RTN_TYPE_CHG_APPLY_INSERT = "GD1546"; //还款方式变更申请表插入错误
    public static final String ERROR_CODE_RTN_TYPE_CHG_APPLY_SELECT = "GD1547"; //还款方式变更申请表读取错误
    public static final String ERROR_CODE_RTN_TYPE_CHG_APPLY_UPDATE = "GD1548"; //还款方式变更申请表修改错误
    public static final String ERROR_CODE_SEQCTL_DELETE = "GD1549"; //序号控制表删除错误
    public static final String ERROR_CODE_SEQCTL_INSERT = "GD1550"; //序号控制表插入错误
    public static final String ERROR_CODE_SEQCTL_SELECT = "GD1551"; //序号控制表读取错误
    public static final String ERROR_CODE_SEQCTL_UPDATE = "GD1552"; //序号控制表修改错误
    public static final String ERROR_CODE_TELLER_LOAN_STAT_DELETE = "GD1553"; //信贷员业务统计表删除错误
    public static final String ERROR_CODE_TELLER_LOAN_STAT_INSERT = "GD1554"; //信贷员业务统计表插入错误
    public static final String ERROR_CODE_TELLER_LOAN_STAT_SELECT = "GD1555"; //信贷员业务统计表读取错误
    public static final String ERROR_CODE_TELLER_LOAN_STAT_UPDATE = "GD1556"; //信贷员业务统计表修改错误
    public static final String ERROR_CODE_TERM_CHG_APPLY_DELETE = "GD1557"; //期限变更申请表删除错误
    public static final String ERROR_CODE_TERM_CHG_APPLY_INSERT = "GD1558"; //期限变更申请表插入错误
    public static final String ERROR_CODE_TERM_CHG_APPLY_SELECT = "GD1559"; //期限变更申请表读取错误
    public static final String ERROR_CODE_TERM_CHG_APPLY_UPDATE = "GD1560"; //期限变更申请表修改错误
    public static final String ERROR_CODE_TLR_INFO_DELETE = "GD1561"; //操作员定义表删除错误
    public static final String ERROR_CODE_TLR_INFO_INSERT = "GD1562"; //操作员定义表插入错误
    public static final String ERROR_CODE_TLR_INFO_SELECT = "GD1563"; //操作员定义表读取错误
    public static final String ERROR_CODE_TLR_INFO_UPDATE = "GD1564"; //操作员定义表修改错误
    public static final String ERROR_CODE_TLR_ROLE_RELATION_DELETE = "GD1565"; //操作员岗位关系表删除错误
    public static final String ERROR_CODE_TLR_ROLE_RELATION_INSERT = "GD1566"; //操作员岗位关系表插入错误
    public static final String ERROR_CODE_TLR_ROLE_RELATION_SELECT = "GD1567"; //操作员岗位关系表读取错误
    public static final String ERROR_CODE_TLR_ROLE_RELATION_UPDATE = "GD1568"; //操作员岗位关系表修改错误
    public static final String ERROR_CODE_TRANS_PARAM_DELETE = "GD1573"; //业务开办参数删除错误
    public static final String ERROR_CODE_TRANS_PARAM_INSERT = "GD1574"; //业务开办参数插入错误
    public static final String ERROR_CODE_TRANS_PARAM_SELECT = "GD1575"; //业务开办参数读取错误
    public static final String ERROR_CODE_TRANS_PARAM_UPDATE = "GD1576"; //业务开办参数修改错误
    public static final String ERROR_CODE_CREDIT_SCORE_PARAM_DELETE = "GD1577"; //评分参数表删除错误
    public static final String ERROR_CODE_CREDIT_SCORE_PARAM_INSERT = "GD1578"; //评分参数表插入错误
    public static final String ERROR_CODE_CREDIT_SCORE_PARAM_SELECT = "GD1579"; //评分参数表读取错误
    public static final String ERROR_CODE_CREDIT_SCORE_PARAM_UPDATE = "GD1580"; //评分参数表修改错误
    public static final String ERROR_CODE_CREDIT_DATA_TYPE_NO= "SE7514"; //该指标要素静态数据表DATA_TYPE_NO值配置错误!

    public static final String ERROR_CODE_REPORT_INFO_DELETE = "GD1581"; //报表定义表删除错误
    public static final String ERROR_CODE_REPORT_INFO_INSERT = "GD1582"; //报表定义表插入错误
    public static final String ERROR_CODE_REPORT_INFO_SELECT = "GD1583"; //报表定义表读取错误
    public static final String ERROR_CODE_REPORT_INFO_UPDATE = "GD1584"; //报表定义表修改错误
    public static final String ERROR_CODE_PROCESS_LOAN_DELETE = "GD1585"; //已移交合同表删除错误
    public static final String ERROR_CODE_PROCESS_LOAN_INSERT = "GD1586"; //已移交合同表插入错误
    public static final String ERROR_CODE_PROCESS_LOAN_SELECT = "GD1587"; //已移交合同表读取错误
    public static final String ERROR_CODE_PROCESS_LOAN_UPDATE = "GD1588"; //已移交合同表修改错误
    public static final String ERROR_CODE_LNDAYANALYSE_SELECT = "GD1589"; //日处理报表读取错误
    public static final String ERROR_CODE_LNDAYANALYSE_UPDATE = "GD1590"; //日处理报表更新错误
    public static final String ERROR_CODE_LNDAYANALYSE_DELETE = "GD1591"; //日处理报表删除错误
    public static final String ERROR_CODE_LNDAYANALYSE_INSERT = "GD1592"; //日处理报表插入错误
    public static final String ERROR_CODE_FUND_BRANCH_TRANSFER_SELECT = "GD1593"; //分行资金划拨台帐表读取错误
    public static final String ERROR_CODE_FUND_BRANCH_TRANSFER_UPDATE = "GD1594"; //分行资金划拨台帐表更新错误
    public static final String ERROR_CODE_FUND_BRANCH_TRANSFER_DELETE = "GD1595"; //分行资金划拨台帐表删除错误
    public static final String ERROR_CODE_FUND_BRANCH_TRANSFER_INSERT = "GD1596"; //分行资金划拨台帐表插入错误
    public static final String ERROR_CODE_FUND_SUBBRANCH_TRANSFER_SELECT = "GD1597"; //支行资金划拨台帐表读取错误
    public static final String ERROR_CODE_FUND_SUBBRANCH_TRANSFER_UPDATE = "GD1598"; //支行资金划拨台帐表更新错误
    public static final String ERROR_CODE_FUND_SUBBRANCH_TRANSFER_DELETE = "GD1599"; //支行资金划拨台帐表删除错误
    public static final String ERROR_CODE_FUND_SUBBRANCH_TRANSFER_INSERT = "GD1600"; //支行资金划拨台帐表插入错误
    public static final String ERROR_CODE_LN_FIXED_INT_CHG_SELECT = "GD1601"; //固定利率贷款变更历史记录读取错误
    public static final String ERROR_CODE_LN_FIXED_INT_CHG_UPDATE = "GD1602"; //固定利率贷款变更历史记录更新错误
    public static final String ERROR_CODE_LN_FIXED_INT_CHG_DELETE = "GD1603"; //固定利率贷款变更历史记录删除错误
    public static final String ERROR_CODE_LN_FIXED_INT_CHG_INSERT = "GD1604"; //固定利率贷款变更历史记录插入错误
    public static final String ERROR_CODE_FUND_USE_SELECT = "GD1605"; //公积金基金使用情况表读取错误
    public static final String ERROR_CODE_FUND_USE_UPDATE = "GD1606"; //公积金基金使用情况表更新错误
    public static final String ERROR_CODE_FUND_USE_DELETE = "GD1607"; //公积金基金使用情况表删除错误
    public static final String ERROR_CODE_FUND_USE_INSERT = "GD1608"; //公积金基金使用情况表插入错误

    public static final String ERROR_CODE_MGRNO_CHG_APPLY_SELECT = "GD1609"; //客户经理变更表读取错误
    public static final String ERROR_CODE_MGRNO_CHG_APPLY_UPDATE = "GD1611"; //客户经理变更表更新错误
    public static final String ERROR_CODE_MGRNO_CHG_APPLY_DELETE = "GD1612"; //客户经理变更表删除错误
    public static final String ERROR_CODE_MGRNO_CHG_APPLY_INSERT = "GD1613"; //客户经理变更表插入错误

    public static final String ERROR_CODE_TMP_MGRNO_CHG_SELECT = "GD1614"; //客户经理变更合同临时表读取错误
    public static final String ERROR_CODE_TMP_MGRNO_CHG_UPDATE = "GD1615"; //客户经理变更合同临时表更新错误
    public static final String ERROR_CODE_TMP_MGRNO_CHG_DELETE = "GD1616"; //客户经理变更合同临时表删除错误
    public static final String ERROR_CODE_TMP_MGRNO_CHG_INSERT = "GD1617"; //客户经理变更合同临时表插入错误

    public static final String ERROR_CODE_TMP_LOAN_PARAM_CHG_SELECT = "GD1618"; //贷款产品参数变更临时表读取错误
    public static final String ERROR_CODE_TMP_LOAN_PARAM_CHG_UPDATE = "GD1619"; //贷款产品参数变更临时表更新错误
    public static final String ERROR_CODE_TMP_LOAN_PARAM_CHG_DELETE = "GD1620"; //贷款产品参数变更临时表删除错误
    public static final String ERROR_CODE_TMP_LOAN_PARAM_CHG_INSERT = "GD1621"; //贷款产品参数变更临时表插入错误

    public static final String ERROR_CODE_PARAM_CHG_APPLY_SELECT = "GD1622"; //贷款产品参数变更申请表读取错误
    public static final String ERROR_CODE_PARAM_CHG_APPLY_UPDATE = "GD1623"; //贷款产品参数变更申请表更新错误
    public static final String ERROR_CODE_PARAM_CHG_APPLY_DELETE = "GD1624"; //贷款产品参数变更申请表删除错误
    public static final String ERROR_CODE_PARAM_CHG_APPLY_INSERT = "GD1625"; //贷款产品参数变更申请表插入错误

    public static final String ERROR_CODE_LOAN_PARAM_RESOLVE_SELECT = "GD1626"; //贷款产品参数解释表读取错误
    public static final String ERROR_CODE_LOAN_PARAM_RESOLVE_UPDATE = "GD1627"; //贷款产品参数解释表更新错误
    public static final String ERROR_CODE_LOAN_PARAM_RESOLVE_DELETE = "GD1628"; //贷款产品参数解释表删除错误
    public static final String ERROR_CODE_LOAN_PARAM_RESOLVE_INSERT = "GD1629"; //贷款产品参数解释表插入错误

    public static final String ERROR_CODE_TMP_GUAT_LIMIT_PARAM_SELECT = "GD1630"; //贷款产品参数解释表读取错误
    public static final String ERROR_CODE_TMP_GUAT_LIMIT_PARAM_UPDATE = "GD1631"; //贷款产品参数解释表更新错误
    public static final String ERROR_CODE_TMP_GUAT_LIMIT_PARAM_DELETE = "GD1632"; //贷款产品参数解释表删除错误
    public static final String ERROR_CODE_TMP_GUAT_LIMIT_PARAM_INSERT = "GD1633"; //贷款产品参数解释表插入错误

    //组合还款方式阶段
    public static final String ERROR_CODE_PHASEDTL_DELETE = "GD1641"; //组合还款方式阶段信息表删除错误
    public static final String ERROR_CODE_PHASEDTL_INSERT = "GD1642"; //组合还款方式阶段信息表插入错误
    public static final String ERROR_CODE_PHASEDTL_SELECT = "GD1643"; //组合还款方式阶段信息表读取错误
    public static final String ERROR_CODE_PHASEDTL_UPDATE = "GD1644"; //组合还款方式阶段信息表修改错误

    /*
    //房贷卡授信信息表
    public static final String ERROR_CODE_LOANCARD_DELETE = "GD1645"; //房贷卡授信信息表删除错误
    public static final String ERROR_CODE_LOANCARD_INSERT = "GD1656"; //房贷卡授信信息表插入错误
    public static final String ERROR_CODE_LOANCARD_SELECT = "GD1647"; //房贷卡授信信息表读取错误
    public static final String ERROR_CODE_LOANCARD_UPDATE = "GD1648"; //房贷卡授信信息表修改错误

    //房贷卡授信附属信息表
    public static final String ERROR_CODE_LNCARDCREDIT_DELETE = "GD1649"; //房贷卡授信附属信息表删除错误
    public static final String ERROR_CODE_LNCARDCREDIT_INSERT = "GD1650"; //房贷卡授信附属信息表插入错误
    public static final String ERROR_CODE_LNCARDCREDIT_SELECT = "GD1651"; //房贷卡授信附属信息表读取错误
    public static final String ERROR_CODE_LNCARDCREDIT_UPDATE = "GD1652"; //房贷卡授信附属信息表修改错误

    //房贷卡授信额度申请表
    public static final String ERROR_CODE_LOANCARDAPPLY_DELETE = "GD1653"; //房贷卡授信额度申请表删除错误
    public static final String ERROR_CODE_LOANCARDAPPLY_INSERT = "GD1654"; //房贷卡授信额度申请表插入错误
    public static final String ERROR_CODE_LOANCARDAPPLY_SELECT = "GD1655"; //房贷卡授信额度申请表读取错误
    public static final String ERROR_CODE_LOANCARDAPPLY_UPDATE = "GD1656"; //房贷卡授信额度申请表修改错误
    */

    //通讯日志信息表
	/** add by shen_antonio 20080508 .*/
	public static final String ERROR_CODE_COMM_LOG_SELECT = "GD1645";//通讯日志信息表读取错误
	public static final String ERROR_CODE_COMM_LOG_INSERT = "GD1656";//通讯日志信息表插入错误
	public static final String ERROR_CODE_COMM_LOG_UPDATE = "GD1647";//通讯日志信息表修改错误
	public static final String ERROR_CODE_COMM_LOG_DELETE = "GD1648";//通讯日志信息表删除错误

    //客户行政区划信息表
    public static final String ERROR_CODE_CUSTOMERCANTON_DELETE = "GD1657"; //客户行政区划信息表删除错误
    public static final String ERROR_CODE_CUSTOMERCANTON_INSERT = "GD1658"; //客户行政区划信息表插入错误
    public static final String ERROR_CODE_CUSTOMERCANTON_SELECT = "GD1659"; //客户行政区划信息表读取错误
    public static final String ERROR_CODE_CUSTOMERCANTON_UPDATE = "GD1660"; //客户行政区划信息表修改错误
    public static final String ERROR_CODE_NO_CANTON             = "GD1661"; //无此行政区划代码
    public static final String ERROR_CODE_CANTONINFO_DELETE     = "GD1662"; //客户行政区划信息参数表删除错误
    public static final String ERROR_CODE_CANTONINFO_INSERT     = "GD1663"; //客户行政区划信息参数表插入错误
    public static final String ERROR_CODE_CANTONINFO_SELECT     = "GD1664"; //客户行政区划信息参数表读取错误
    public static final String ERROR_CODE_CANTONINFO_UPDATE     = "GD1665"; //客户行政区划信息参数表修改错误

    //赎楼转按贷款关联表
    public static final String ERROR_CODE_PAYHOUSE_LOAN_RELATION_DELETE = "GD1666"; //赎楼转按贷款关联表删除错误
    public static final String ERROR_CODE_PAYHOUSE_LOAN_RELATION_INSERT = "GD1667"; //赎楼转按贷款关联表插入错误
    public static final String ERROR_CODE_PAYHOUSE_LOAN_RELATION_SELECT = "GD1668"; //赎楼转按贷款关联表读取错误
    public static final String ERROR_CODE_PAYHOUSE_LOAN_RELATION_UPDATE = "GD1669"; //赎楼转按贷款关联表修改错误

    //机构流程关联表
	public static final String ERROR_CODE_JBPM_BRH_WORKFLOW_DEF_SELECT  = "GD1700";//机构流程关联表读取错误
	public static final String ERROR_CODE_JBPM_BRH_WORKFLOW_DEF_INSERT = "GD1701";// 机构流程关联表插入错误
	public static final String ERROR_CODE_JBPM_BRH_WORKFLOW_DEF_UPDATE  = "GD1702";//机构流程关联表修改错误
	public static final String ERROR_CODE_JBPM_BRH_WORKFLOW_DEF_DELETE  = "GD1703";//机构流程关联表删除错误

    //委托人信息表
	public static final String ERROR_CODE_CUST_ENTRUST_INFO_SELECT  = "GD1704";//委托人信息表读取错误
	public static final String ERROR_CODE_CUST_ENTRUST_INFO_INSERT  = "GD1705";// 委托人信息表插入错误
	public static final String ERROR_CODE_CUST_ENTRUST_INFO_UPDATE  = "GD1706";//委托人信息表修改错误
	public static final String ERROR_CODE_CUST_ENTRUST_INFO_DELETE  = "GD1707";//委托人信息表删除错误

	//授信合同属性信息表
	public static final String ERROR_CODE_CREDIT_INFO_SELECT = "GD1708";//授信合同属性信息表读取错误
	public static final String ERROR_CODE_CREDIT_INFO_INSERT = "GD1709";//授信合同属性信息表插入错误
	public static final String ERROR_CODE_CREDIT_INFO_UPDATE = "GD1710";//授信合同属性信息表修改错误
	public static final String ERROR_CODE_CREDIT_INFO_DELETE = "GD1711";//授信合同属性信息表删除错误

	// 黑名单
	public static final String ERROR_CODE_BLACKLIST_INFO_SELECT = "GD1800"; // 黑名单列表读取错误
	public static final String ERROR_CODE_BLACKLIST_INFO_DELETE = "GD1801"; // 黑名单列表删除错误
	public static final String ERROR_CODE_BLACKLIST_INFO_UPDATE = "GD1802"; // 黑名单列表修改错误
	public static final String ERROR_CODE_BLACKLIST_INFO_INSERT = "GD1803"; // 黑名单列表插入错误
	public static final String ERROR_CODE_BLACKDTL_INFO_SELECT = "GD1804"; // 黑名单明细读取错误
	public static final String ERROR_CODE_BLACKDTL_INFO_DELETE = "GD1805"; // 黑名单明细删除错误
	public static final String ERROR_CODE_BLACKDTL_INFO_UPDATE = "GD1806"; // 黑名单明细修改错误
	public static final String ERROR_CODE_BLACKDTL_INFO_INSERT = "GD1807"; // 黑名单明细插入错误

    public static final String ERROR_CODE_HOLIDAY_INFO_DELETE = "GD1808"; //请假表删除错误
    public static final String ERROR_CODE_HOLIDAY_INFO_INSERT = "GD1809"; //请假表插入错误
    public static final String ERROR_CODE_HOLIDAY_INFO_SELECT = "GD1810"; //请假表读取错误
    public static final String ERROR_CODE_HOLIDAY_INFO_UPDATE = "GD1811"; //请假表修改错误

    public static final String ERROR_CODE_FOCUS_CUST_INFO_DELETE = "GD1812"; //重点客户信息表删除错误
    public static final String ERROR_CODE_FOCUS_CUST_INFO_INSERT = "GD1813"; //重点客户信息表插入错误
    public static final String ERROR_CODE_FOCUS_CUST_INFO_SELECT = "GD1814"; //重点客户信息表读取错误
    public static final String ERROR_CODE_FOCUS_CUST_INFO_UPDATE = "GD1815"; //重点客户信息表修改错误

    public static final String ERROR_CODE_RTN_APPLY_DELETE = "GD1816"; //还款申请除错误
    public static final String ERROR_CODE_RTN_APPLY_INSERT = "GD1817"; //请假表插入错误
    public static final String ERROR_CODE_RTN_APPLY_SELECT = "GD1818"; //请假表读取错误
    public static final String ERROR_CODE_RTN_APPLY_UPDATE = "GD1819"; //请假表修改错误
	/**
	 * 工作流错误代码 GD2001~GD2500
	 */
	public static final String ERROR_CODE_WORK_FLOW_SUBMIT = "GD2001"; //提交工作流实例失败
	public static final String ERROR_CODE_AUDIT_USER_ONLY_GDZX = "GD2002"; //只有个贷分中心和个贷中心的人员可以进行贷款审核
	public static final String ERROR_CODE_APPROVE_LIMIT_PARAM = "GD2003"; //没有审批权限
	public static final String ERROR_CODE_WORKFLOW_NO_USER_LIST = "GD2004"; //工作流接口中没有找到对应的人员列表
	public static final String ERROR_CODE_APPROVER_ASSIGN = "GD2005"; //审批人员配置错误
	public static final String ERROR_CODE_WORKFLOW_NO_APPROVER = "GD2006"; //没有找到合适的审批人员
	public static final String ERROR_CODE_WORKFLOW_CONCLUSION_STATUS = "GD2007"; //错误的返回代码
	public static final String ERROR_CODE_WORKFLOW_FUNCTION_ID = "GD2008"; //错误的功能编号
	public static final String ERROR_CODE_WORKFLOW_FLOWTYPE = "GD2009"; //错误的流程类型
	public static final String ERROR_CODE_INVALID_TOKEN = "GD2010"; //无效的Token
	public static final String ERROR_CODE_PROC_UNFOUND = "GD2011"; //找不到流程配置

	/**
	 * 公共错误代码 GD3001~GD3500
	 */
	public static final String ERROR_CODE_QUERY_CONDITION_CANNOT_BEEN_NULL = "GD3001"; //查询条件不能全空
	public static final String ERROR_CODE_RECORD_NOTFOUND = "GD3002"; //没有找到符合条件的记录
	public static final String ERROR_CODE_NO_BRCODE = "GD3003"; //该机构号不存在
	public static final String ERROR_CODE_CANNOT_SUBMIT = "GD3004"; //不能提交
	public static final String ERROR_CODE_TIME_LIMIT = "GD3005"; //次数超限
	public static final String ERROR_CODE_NO_LNCINO = "GD3006"; //该借据号不存在
	/**
	 * 客户管理错误代码 GD4001~GD4500
	 */
	public static final String ERROR_CODE_CUSTCD_IS_EMPTY = "GD4001"; //客户号为空
	public static final String ERROR_CODE_CUSTOMER_ALREADY_EXIST = "GD4002"; //客户已存在
	public static final String ERROR_CODE_CUST_IDTYPE_IDNO_MUST_INPUTBOTH = "GD4003"; //证件种类证件号必须同时输入
	public static final String ERROR_CODE_IDCARD_ERROR = "GD4004"; //身份证号码错误
	public static final String ERROR_CODE_CUSTNO_NOT_EXIST = "GD4005"; //客户号不存在
	public static final String ERROR_CODE_INCOME_ERROR = "GD4006"; //家庭收入应大于个人收入
	public static final String ERROR_CODE_CUST_INPUT_ERROR = "GD4007"; //客户信息输入错误
	public static final String ERROR_CODE_NO_MATE = "GD4008"; //该客户已婚但无配偶信息
	public static final String ERROR_CODE_MATE_IS_EXIST_FOR_OTHER = "GD4009"; //该配偶存在非当前客户的其它配偶
	public static final String ERROR_CODE_NO_INCOME_INFO = "GD4010"; //没有录入家庭财务信息
	public static final String ERROR_CODE_CUSTOMER_INFO_NOT_INPUT = "GD4011"; //客户信息不全
	public static final String ERROR_CODE_CUSTOMER_NOT_MARRIED = "GD4012"; //客户未婚
	public static final String ERROR_CODE_CUSTCD_ERROR = "GD4013"; //客户号错误
	public static final String ERROR_CODE_ONLE_ONE_MATE = "GD4014"; //最多只能有一个配偶
	public static final String ERROR_CODE_CUST_INFO_ERROR = "GD4015"; //客户信息错误
	public static final String ERROR_CODE_CUST_NOT_EXIST = "GD4016"; //指定的客户记录不存在
	public static final String ERROR_CODE_CUST_TYPE = "GD4017"; //客户类型错误
	public static final String ERROR_CODE_DATE_AFTER_TXDATE = "GD4018"; //指定的日期不能在交易日期之后
	public static final String ERROR_CODE_PAYHOUSE_CONTRACTNO_IS_EMPTY = "GD4001"; //赎搂贷款合同号为空
	public static final String ERROR_CODE_DATE_OVERLIMIT = "GD4019"; //日期超过限制


	/**
	 * 合作项目错误代码 GD4501~GD5000
	 */
	public static final String ERROR_CODE_PROJ_LIMIT_FORM = "GD4501"; //合作项目额度控制方式错误
	public static final String ERROR_CODE_PROJ_LIMIT_OVERFLOW = "GD4502"; //合作项目额度已超标
	public static final String ERROR_CODE_PROJ_INVALIDATION = "GD4503"; //无效的合作项目
	public static final String ERROR_CODE_PROJ_BRCODE_ERROR = "GD4504"; //非本行的合作项目
	public static final String ERROR_CODE_START_END_DATE_ERROR = "GD4505"; //合作项目起始日终止日设置错误
	public static final String ERROR_CODE_PROJECT_SENDED = "GD4506"; //合作项目已经在审批流程中
	public static final String ERROR_CODE_PROJECT_LOCK = "GD4507"; //合作项目修改有申请还未审批，不能进行新的申请
	public static final String ERROR_CODE_PROJECT_FREEZE = "GD4508"; //合作项目已经冻结，不能重复冻结
	public static final String ERROR_CODE_PROJECT_CLOSE = "GD4508";//合作项目已经到期
	public static final String ERROR_CODE_PROJECT_LOAN_RATIO_LIMIT_ERROR = "GD4509";//合作项目贷款成数错误
	public static final String ERROR_CODE_PROJECT_LOAN_TERM_LIMIT_ERROR = "GD4510";//合作项目贷款期限错误
	public static final String ERROR_CODE_PROJECT_LOAN_LIMIT_AMT_ERROR = "GD4511";//合作项目贷款单笔最高贷款金额超限

	/**
	 * 档案管理错误代码 GD5001~GD5500
	 */
	public static final String ERROR_CODE_ARCH_BADSTATUS = "GD5001"; //档案状态错误
	public static final String ERROR_CODE_GUA_NO_RECORD = "GD5002"; //权利品查询无记录
	public static final String ERROR_CODE_GUA_NO_BRANCH_EST = "GD5003"; //权利品未在支行建档
	public static final String ERROR_CODE_ARCH_REG_AGAIN = "GD5004"; //档案已登记
	public static final String ERROR_CODE_GUA_BADSTATUS = "GD5005"; //权利品状态错误
	public static final String ERROR_CODE_ARCH_NUM_ERROR = "GD5006"; //档案数量错误
	public static final String ERROR_CODE_ARCH_MUST_SUBMIT = "GD5007"; //档案需要上缴
	public static final String ERROR_CODE_LNCARD_NOTCLOSE = "GD5008"; //存在关联房贷卡，权利品不能出库
	public static final String ERROR_CODE_FUND_NOTCLOSE = "GD5009"; //存在加按房贷的公积金，权利品不能出库
	public static final String ERROR_CODE_MORTGAGE_APPLYING = "GD5010"; //加按贷款仍在申请中，权利品不能出库
	public static final String ERROR_CODE_NOTCLOSE = "GD5011"; //没有结清
	public static final String ERROR_CODE_NOTCLOSE_UPDATE = "GD5012"; //档案未入库前才能修改

	/**
	 * 贷款、额度申请审批错误代码 GD5501~GD6000
	 */
	public static final String ERROR_CODE_NO_ACCUM_FUND_BRID = "GD5501"; //没有设置公积金支行识别号
	public static final String ERROR_CODE_LOAN_PARAM_TERM_BEYOND = "GD5502"; //贷款期限超限
	public static final String ERROR_CODE_LOAN_PARAM_AMOUNT_BEYOND = "GD5503"; //贷款金额超限
	public static final String ERROR_CODE_LOAN_PARAM_RATIO = "GD5504"; //贷款额度超限
	public static final String ERROR_CODE_LOAN_PARAM_FLT_INTRATE_BEYOND = "GD5505"; //浮动利率超限
	public static final String ERROR_CODE_LOAN_PARAM_AGE_BEYOND = "GD5506"; //借款人年龄超限
	public static final String ERROR_CODE_LOAN_PARAM_DOG_BEYOND = "GD5507"; //宽限期天数超限
	public static final String ERROR_CODE_NON_EQUAL_MODE_ERR = "GD5508"; //不等额方式和还款方式不匹配
	public static final String ERROR_CODE_NON_EQUAL_AMT_ERR = "GD5509"; //不等额金额错误
	public static final String ERROR_CODE_LOAN_PARAM_PHASE_FLAG_BEYOND = "GD5510"; //不允许分阶段还款
	public static final String ERROR_CODE_LOAN_PARAM_RTN_TYPE_BEYOND = "GD5511"; //该还款方式不允许
	public static final String ERROR_CODE_LOAN_PARAM_GUAT_TYPE_BEYOND = "GD5512"; //该担保方式不允许
	public static final String ERROR_CODE_LOAN_PARAM_EXTEND_NOT_VALID = "GD5513"; //不允许展期
	public static final String ERROR_CODE_LOAN_PARAM_EXTEND_TIMES_BEYOND = "GD5514"; //展期次数超限
	public static final String ERROR_CODE_LOAN_PARAM_EXTEND_TERM_BEYOND = "GD5515"; //展期期限超限
	public static final String ERROR_CODE_LOAN_PARAM_ADD_NOT_VALID = "GD5516"; //不允许加按
	public static final String ERROR_CODE_LOAN_PARAM_TRANS_NOT_VALID = "GD5517"; //不允许转按
	public static final String ERROR_CODE_LOAN_PARAM_DELAY_NOT_VALID = "GD5518"; //不允许延期
	public static final String ERROR_CODE_LOAN_PARAM_DELAY_TIMES_NOT_VALID = "GD5519"; //延期次数超限
	public static final String ERROR_CODE_LOAN_PARAM_DELAY_TERM_NOT_VALID = "GD5520"; //延期期限超限
	public static final String ERROR_CODE_LOAN_PARAM_REDUCE_NOT_VALID = "GD5521"; //不允许缩期
	public static final String ERROR_CODE_LOAN_PARAM_REDUCE_TIMES_NOT_VALID = "GD5522"; //缩期次数超限
	public static final String ERROR_CODE_LOAN_PARAM_REDUCE_TERM_NOT_VALID = "GD5523"; //缩期期限超限
	public static final String ERROR_CODE_PHASENO_SHOULD_BE_ZERO = "GD5524"; //不分段还款时，分段数应为0
	public static final String ERROR_CODE_PHASENO_ERR = "GD5525"; //分段还款时，分段数必须在2到5之间
	public static final String ERROR_CODE_PHASENO_NOT_MATCH = "GD5526"; //分段数和实际的分段不符
	public static final String ERROR_CODE_PHASE_RTNTYPE_ERR = "GD5527"; //分段还款时还款方式必须为等额还款
	public static final String ERROR_CODE_PHASE_CANT_MULTI_GRANT = "GD5528"; //多次发放的贷款不允许分段还款
	public static final String ERROR_CODE_PHASE_NULL_RTNAMT = "GD5529"; //每段还款额不能为0
	public static final String ERROR_CODE_PHASE_RTNAMT_SUM_ERR = "GD5530"; //每段还款额之和应等于贷款金额
	public static final String ERROR_CODE_PHASE_NULL_PERI = "GD5531"; //每段还款期数不能为0
	public static final String ERROR_CODE_PHASE_PERI_SUM_ERR = "GD5532"; //每段还款期数之和应等于贷款总期数
	public static final String ERROR_CODE_LA_GUATTYPE_NOT_MATCH = "GD5533"; //担保类型与录入资料不一致
	public static final String ERROR_CODE_LA_CONTRACTNO = "GD5534"; //合同号错误
	public static final String ERROR_CODE_LA_BRCODE_LNID = "GD5535"; //机构贷款品种开办权限错误
	public static final String ERROR_CODE_LA_LOAN_NATURE = "GD5536"; //贷款性质错误
	public static final String ERROR_CODE_LA_GRANT_CNT = "GD5537"; //贷款发放次数错误
	public static final String ERROR_CODE_LA_GRANT_MODE = "GD5538"; //发放方式错误
	public static final String ERROR_CODE_EDU_LOAN_TYPE_ERR = "GD5539"; //助学贷款分类错误
	public static final String ERROR_CODE_LNID_INVALID = "GD5540"; //无效的贷款种类
	public static final String ERROR_CODE_ACTNO_STATUS_ERROR = "GD5541"; //帐户状态错误
	public static final String ERROR_CODE_LNUSE_ERROR = "GD5542"; //贷款用途错误
	public static final String ERROR_CODE_TRSF_DATE_ERROR = "GD5543"; //转等额日错误
	public static final String ERROR_CODE_NO_GRANT_PLAN = "GD5544"; //没有录入放款计划
	public static final String ERROR_CODE_PLAN_DATE_ERROR = "GD5545"; //计划放款日期错误
	public static final String ERROR_CODE_CINO_ERROR = "GD5546"; //借据号错误
	public static final String ERROR_CODE_LNAMT_ERROR = "GD5547"; //放款金额错误
	public static final String ERROR_CODE_GUAT_RATIO_ERROR = "GD5548"; //抵质押比例超限
	public static final String ERROR_CODE_INFO_NOT_INPUT = "GD5549"; //资料录入不全
	public static final String ERROR_CODE_CAN_NOT_FUND_REPAY = "GD5550"; //不能提取公积金冲还贷
	public static final String ERROR_CODE_CAN_NOT_GRANT = "GD5551"; //贷款不能发放
	public static final String ERROR_CODE_GEN_CINO_ERROR = "GD5552"; //生成借据号错误
	public static final String ERROR_CODE_RTN_TYPE_ERROR = "GD5553"; //还款方式错误
	public static final String ERROR_CODE_LNCI_STATUS_ERROR = "GD5554"; //借据状态错误
	public static final String ERROR_CODE_GUATTYPE_ERROR = "GD5555"; //担保方式错误
	public static final String ERROR_CODE_RTN_MODE_ERROR = "GD5556"; //还款途径错误
	public static final String ERROR_CODE_CONTRACT_STATUS_ERROR = "GD5557"; //合同状态错误
	public static final String ERROR_CODE_NO_ACTNO = "GD5558"; //没有还款帐号
	public static final String ERROR_CODE_LA_APPSTAT_CANNOT_MODIFY = "GD5559"; //当前申请状态下不可修改
	public static final String ERROR_CODE_CAN_NOT_UPLOAD = "GD5560"; //不能上传
	public static final String ERROR_CODE_LA_APPLOCK_SUBMITED = "GD5561"; //贷款申请已上传
	public static final String ERROR_CODE_LA_APP_RESULT = "GD5562"; //审查审批结果错误
	public static final String ERROR_CODE_CREDIT_NOT_ENOUGH = "GD5563"; //可用额度不足
	public static final String ERROR_CODE_NEW_CREDIT_ERROR = "GD5564"; //重新设定额度错误
	public static final String ERROR_CODE_TEDATE_ERROR = "GD5565"; //到期日期错误
	public static final String ERROR_CODE_ASSURER_ERROR = "GD5566"; //担保人信息错误
	public static final String ERROR_CODE_LOANCARD_ERROR = "GD5567"; //房贷授信合同错误
	public static final String ERROR_CODE_ACCUM_NOT_ACCT = "GD5568"; //加按贷款的关联合同未入账
	public static final String ERROR_CODE_NOT_ACCUM_MULTI_HOUSE = "GD5569"; //不能关联多笔房贷
	public static final String ERROR_CODE_NOT_HOUSE_ADD_EXCEPTION = "GD5570"; //不能做例外加按贷款
	public static final String ERROR_CODE_LOAN_PARAM_DOGTYPE_NOT_VALID = "GD5571"; //不允许宽限期

	/**
	 * 贷后变更错误代码 GD6001~GD6500
	 */
	public static final String ERROR_CODE_APPSTAT_ERR = "GD6001"; //贷款申请状态错误
	public static final String ERROR_CODE_CLR_MODE = "GD6002"; //五级分类方式错误
	public static final String ERROR_CODE_CLR_CLASS = "GD6003"; //五级分类级别错误
	public static final String ERROR_CODE_APP_LOCK = "GD6004"; //贷款有申请还未审批，不能进行新的申请
	public static final String ERROR_CODE_OVERDUE = "GD6005"; //贷款已逾期，且逾期部分未还清
	public static final String ERROR_CODE_TERM_OR_EDATE = "GD6006"; //贷款期限或到期日错误
	public static final String ERROR_CODE_TXAMT_ERR = "GD6007"; //金额错误
	public static final String ERROR_CODE_PART_REPAY_TERM = "GD6008"; //没有达到部分提前还款期限限制
	public static final String ERROR_CODE_PART_REPAY_AMOUNT = "GD6009"; //没有达到部分提前还款金额限制
	public static final String ERROR_CODE_BRANCH_ERROR = "GD6010"; //交易行错误
	public static final String ERROR_CODE_GUACHG_APPSTAT_ERR = "GD6011"; //担保方式变更申请状态错误
	public static final String ERROR_CODE_POSTLOAN_NO_RECORD = "GD6012"; //贷后查询无记录
	public static final String ERROR_CODE_COMMIT_POSTLOAN = "GD6013"; //贷后交易提交失败
	public static final String ERROR_CODE_QUERY_CONDITION = "GD6014"; //贷款查询条件错误
	public static final String ERROR_CODE_EDU_LOAN_ERROR = "GD6015"; //助学贷款不能做此交易
	public static final String ERROR_CODE_PLAN_STATUS_ERROR = "GD6016"; //发放状态错误
	public static final String ERROR_CODE_MGRNO_APPLY_LOCK = "GD6017"; //客户经理变更有申请还未审批，不能进行新的申请
	public static final String ERROR_CODE_LOAN_CONTRACTNO = "GD6018"; //授信房贷卡，不能修改还款帐号
	public static final String ERROR_CODE_LOANCARD_CONN = "GD6019"; //该笔房贷已经和房贷卡授信关联，不能修改还款帐号
	public static final String ERROR_CODE_TRM_CLASS = "GD6020"; //贷款形态错误
	public static final String ERROR_CODE_RTN_TYPE = "GD6021"; //还款方式错误
	public static final String ERROR_CODE_LNID = "GD6022"; //贷款种类错误
	public static final String ERROR_CODE_APPLY_DATE = "GD6023"; //申请时间错误
	public static final String ERROR_CODE_DO_TWICE = "GD6024"; //贷款已做变更，不允许重复变更
	public static final String ERROR_CODE_APPSTAT = "GD6025";//贷款还在审批流程中，不能进行全部进行客户经理业务变更
	public static final String ERROR_CODE_PART_REPAY_TYPE = "GD6026"; //个人消费信贷，提前还款方式必须选择2-全部
	public static final String ERROR_CODE_DISC_TYPE = "GD6027"; //贴现凭证，不允许做提前还款试算

	/**
	 * 系统参数设置的错误代码  GD7001~GD7500
	 */
	public static final String ERROR_CODE_NO_PERMISSION = "GD7001";//权限不足错误
	public static final String ERROR_CODE_UPDATE_PK = "GD7002";//更新主键错误
	public static final String ERROR_CODE_DUP_INSERT = "GD7003";//重复插入错误
	public static final String ERROR_CODE_OVER_HEAD = "GD7004";//参数超出总行允许的范围错误
	public static final String ERROR_CODE_NO_UPCODE_PERMISSION = "GD7005";//上级机构没有开办业务错误
	public static final String ERROR_CODE_POSTNO = "GD7006";//邮编填写错误
	public static final String ERROR_CODE_NO_TLRNO_EXIST = "GD7007";//该柜员不存在错误
	public static final String ERROR_CODE_NO_RIGHT_ROLEID = "GD7008";//操作员不具备审批角色错误
	public static final String ERROR_CODE_NO_RANGE = "GD7009";//该操作员不在本行管辖内错误
	public static final String ERROR_CODE_YES_DOWNCODE_PERMISSION = "GD7010";//下级机构仍在开办此项业务
	public static final String ERROR_CODE_LOAN_PARAM = "GD7011";//贷款产品参数错误
	public static final String ERROR_CODE_EAPPROVE_PARAM_ERROR="GD7012";//电子审批参数错误

	/**
	 * 渠道错误代码
	 */
	public static final String ERROR_CODE_CHANNEL_CINO_EMPTY = "GDE0001"; //借据号不能为空.
	public static final String ERROR_CODE_CHANNEL_NO_RECORD = "GDE0002"; //记录没有找到
	public static final String ERROR_CODE_CHANNEL_DATE_FORMAT = "GDE0003"; //日期格式不正确
	public static final String ERROR_CODE_CHANNEL_QISHBS_EMPTY = "GDE0004"; //起始笔数为空
	public static final String ERROR_CODE_CHANNEL_CXUNBS_EMPTY = "GDE0005"; //查询笔数为空
	public static final String ERROR_CODE_CHANNEL_NUMBER_ERROR = "GDE0006"; //数字格式错误

	/**
	 * 组合还款方式错误代码 GD7501~GD8000
	 */
	public static final String ERROR_CODE_PHASE_COUNT_MISMATCH = "GD7501"; //还款阶段数错误
	public static final String ERROR_CODE_PHASE_TERM_MISMATCH = "GD7502"; //还款阶段起止期数错误
	public static final String ERROR_CODE_PHASE_TYPE_MISMATCH = "GD7503"; //还款方式组合错误
	public static final String ERROR_CODE_PHASE_TOTAMT_MISMATCH = "GD7504"; //?8?3 还款总金额计算错误
	public static final String ERROR_CODE_PHASE_PERAMT_MISMATCH = "GD7505"; //还款金额计算错误






	/**
	 * add by Robin 2007-11-21
	 * 会计错误码 GDA001 ~ GDA999
	 */
	public static final String ERROR_CODE_SUJ_NO_IS_EXIST = "GDA001"; // 科目号已存在
	public static final String ERROR_CODE_UP_SUJ_NO_NOT_EXIST = "GDA002"; // 上级科目号不存在


	/**
	 * add by Robin 2007-11-28
	 * 贷后管理错误码
	 */

	public static final String ERROR_CODE_TRACEDTL_EXIST = "GD6501";//当天该合同已做过追帐管理
	public static final String ERROR_CODE_LAWSUIT_EXIST = "GD6502";//当天该合同已做过诉讼理赔管理
	public static final String ERROR_CODE_DEBT_INSERT = "GD6503";//贷款转抵债表信息插入错误
	public static final String ERROR_CODE_DEBT_QUERY = "GD6504";//读取贷款转抵债表信息表错误
	public static final String ERROR_CODE_BAD_DEBT_QUERY = "GD6505";//呆账贷款核销表读取错误
	public static final String ERROR_CODE_LOAN_DEBT_UPDATE = "GD6506";//贷款转抵债资产表更新错误
	public static final String ERROR_CODE_BAD_DEBT_INSERT = "GD6507";//呆账贷款核销表插入错误
	public static final String ERROR_CODE_LAW_SUIT_QUERY = "GD6508";//诉讼申请表查询错误
	public static final String ERROR_CODE_LAW_SUIT_INSERT = "GD6509";//诉讼申请表插入错误
	public static final String ERROR_CODE_LAW_SUIT_UPDATE = "GD6510";//诉讼申请表更新错误
	public static final String ERROR_CODE_BAD_DEBT_UPDATE = "GD6511";//呆账贷款核销表更新错误

	public static final String ERROR_CODE_CUSTMODEL_QUERY= "GD6512";//客户评分模型表读取错误
	public static final String ERROR_CODE_CUSTMODEL_INSERT= "GD6513";//客户评分模型表插入错误
	public static final String ERROR_CODE_CUSTMODEL_UPDATE= "GD6514";//客户评分模型表更新错误
	public static final String ERROR_CODE_CUSTMODEL_DELETE= "GD6515";//客户评分模型表删除错误

	public static final String ERROR_AUTO_CANCEL_LIST_QUERY= "GD6612";//自动冲正列表读取错误
	public static final String ERROR_AUTO_CANCEL_LIST_INSERT= "GD6613";//自动冲正列表插入错误
	public static final String ERROR_AUTO_CANCEL_LIST_UPDATE= "GD6614";//自动冲正列表更新错误
	public static final String ERROR_AUTO_CANCEL_LIST_DELETE= "GD6615";//自动冲正列表删除错误


	public static final String ERROR_CODE_MORTGUARANTVIEW_QUERY = "GD7001"; //权利品视图读取错误
	public static final String ERROR_CODE_IDCARD_QUERY_HUKOU = "GDC001"; //证件类型不能为户口或其他
	public static final String ERROR_CODE_TXT_CREATE = "GD7003"; //文本创建错误

	/**
	 * add by shen_antonio 2008-03-27
	 * 工作流相关任务分配错误码
	 */
	public static final String ERROR_CODE_TLRLVDAY_ERROR ="GDW001";//休假起始日不能在休假结束日之后
	public static final String ERROR_CODE_TLRVDAY_APPLY_ERROR = "GDW002";//休假申请失败
	public static final String ERROR_CODE_TLRVDAY_CANCEL_ERROR = "GDW003";//销假失败
	public static final String ERROR_CODE_TASK_GET_ASSIGN_TLRNO_ERROR = "GDW004";//工作流获得该该分配的操作员失败
	public static final String ERROR_CODE_TASK_ASSIGN_ERROR = "GDW005";//工作流分配任务失败
	public static final String ERROR_CODE_TASK_ASSIGN_DOFINISH_ERROR = "GDW006";//工作流完成任务操作失败
	public static final String ERROR_CODE_IU_TLR_WL_HS_ERROR = "GDW007";//操作员每日工作量统计表错误(记录重复，单个操作员单日，同种工作类型的记录有多条)
	public static final String ERROR_CODE_IU_TLR_WORKLOAD_ERROR = "GDW008";//操作员工作量统计表错误(记录重复，操作员，同种工作类型的记录有多条)
	public static final String ERROR_CODE_TASK_FORWARD_ERROR = "GDW009";//操作员工作移交失败
	public static final String ERROR_CODE_WORKFLOW_START_ERROR = "GDW010";//工作流服务启动工作流失败
	public static final String ERROR_CODE_WORKFLOW_DOFINISH_ERROR = "GDW011";//工作流服务执行任务失败
	public static final String ERROR_CODE_WORKFLOW_FORWARD_ERROR = "GDW012";//工作流服务任务移交失败
	public static final String ERROR_CODE_WORKFLOW_GETTASKLIST_ERROR = "GDW013";//工作流服务获取工作列表失败
	public static final String ERROR_CODE_WORKFLOW_GETTASKVALUE_ERROR = "GDW014";//工作流服务获取任务参数失败
	public static final String ERROR_CODE_WORKFLOW_SETTASKVALUE_ERROR = "GDW015";//工作流服务设置任务参数失败
	public static final String ERROR_CODE_WORKFLOW_LOCKTASK_ERROR = "GDW016";//工作流服务锁任务失败
	public static final String ERROR_CODE_WORKFLOW_RELEASETASK_ERROR = "GDW017";//工作流服务释放任务失败
	public static final String ERROR_CODE_WORKFLOW_KEEPTASK_ERROR = "GDW018";//工作流服务保留任务失败
	public static final String ERROR_CODE_WORKFLOW_GETFLOWINS_ERROR = "GDW019";//工作流服务获取流程实例失败
	public static final String ERROR_CODE_WORKFLOW_CLOSEFLOWINS_ERROR = "GDW020";//工作流服务结束流程实例失败
	public static final String ERROR_CODE_WORKFLOWRULE_DYN_FLOWNAME_EMPTY = "GDW021";//工作流规则启动错误，设置动态路由，没有对应流程名
	public static final String ERROR_CODE_WORKFLOWTASKRULE_CONTEXT= "GDW022";//工作流工作规则启动错误,输入参数错误(TaskId 不能为空 ProcId 不能为空 TlrList 不能为空 Status 不能为空)
	public static final String ERROR_CODE_WORKFLOWCONTEXT_COPY_TASKINFO= "GDW023";//工作流工作内容拷贝出错
	public static final String ERROR_CODE_TASK_ENDPROCTASK = "GDW024";//取消操作员任务分配记录

	//额度品种控制表
	public static final String ERROR_CODE_CREDIT_LNID_SELECT = "GD1708";//额度品种控制表读取错误
	public static final String ERROR_CODE_CREDIT_LNID_INSERT = "GD1709";//额度品种控制表插入错误
	public static final String ERROR_CODE_CREDIT_LNID_UPDATE = "GD1710";//额度品种控制表修改错误
	public static final String ERROR_CODE_CREDIT_LNID_DELETE = "GD1711";//额度品种控制表删除错误

	/**
	 * add by weikun wang 2008-04-13
	 * 批量步骤表分配错误码
	 */
	public static final String ERROR_CODE_BHPROC_STEP_SELECT = "GDF001"; //批量步骤表读入错误
	public static final String ERROR_CODE_BHPROC_STEP_INSERT = "GDF002"; //批量步骤表插入错误
	public static final String ERROR_CODE_BHPROC_STEP_UPDATE = "GDF003"; //批量步骤表更新错误
	public static final String ERROR_CODE_BHPROC_STEP_DELETE = "GDF004"; //批量步骤表删除错误
	public static final String ERROR_CODE_BHPROC_STEP_PARAM  = "GDF005"; //批量步骤表参数错误

	/**
	 * add by Joseph.Bao 2008-04-24
	 * 客户经理绩效考核分析表错误码
	 */
	public static final String ERROR_CODE_TLR_ASSESS_ANALYSE_SELECT = "GDF006";//客户经理绩效考核分析表读取错误
	public static final String ERROR_CODE_TLR_ASSESS_ANALYSE_UPDATE = "GDF007";//客户经理绩效考核分析表修改错误
	public static final String ERROR_CODE_TLR_ASSESS_ANALYSE_INSERT = "GDF008";//客户经理绩效考核分析表插入错误
	public static final String ERROR_CODE_TLR_ASSESS_ANALYSE_DELETE = "GDF009";//客户经理绩效考核分析表删除错误

	/**
	 * add by weikun wang 2008-04-28
	 * 贷款分析表分配错误码
	 */
	public static final String ERROR_CODE_LOAN_ANALYSE_CD_SELECT = "GDF011"; //贷款分析表读入错误
	public static final String ERROR_CODE_LOAN_ANALYSE_CD_INSERT = "GDF012"; //贷款分析表插入错误
	public static final String ERROR_CODE_LOAN_ANALYSE_CD_UPDATE = "GDF013"; //贷款分析表更新错误
	public static final String ERROR_CODE_LOAN_ANALYSE_CD_DELETE = "GDF014"; //贷款分析表删除错误
	public static final String ERROR_CODE_LOAN_ANALYSE_CD_PARAM  = "GDF015"; //贷款分析表参数错误




	/**
	 * add by znh 2008-04-29
	 * 贷款品种流程配置表错误码
	 * */
	public static final String ERROR_CODE_BRH_WORKFLOW_DEF_DELETE = "GD7100"; //贷款品种流程配置表删除错误
    public static final String ERROR_CODE_BRH_WORKFLOW_DEF_INSERT = "GD7101"; //贷款品种流程配置表插入错误
    public static final String ERROR_CODE_BRH_WORKFLOW_DEF_SELECT = "GD7102"; //贷款品种流程配置表读取错误
    public static final String ERROR_CODE_BRH_WORKFLOW_DEF_UPDATE = "GD7103"; //贷款品种流程配置表修改错误

   /**
    * add by maik chen 2008-06-03
    * 个贷系统跟核心系统比较账户：个贷系统传入的账号/卡号
    */
    public static final String ERROR_CODE_HOST_DB_CHECK="GDH001";//账户有效性不正确

    public static final String ERROR_CODE_POSTLOAN_ERROR="GDH002";//贷后管理错误

    /**
     * 灵活还款
     */
    public static final String ERROR_CODE_RtnPlanAgile_ERROR = "GDJ001"; //该笔贷款无放款记录
    /**
     * 征信错误码  GDC001~GDC999
     */
    public static final String ERROR_CODE_CREDIT_SELECT_ERROR="GDC001";//征信信息读取错误
    public static final String ERROR_CODE_CREDIT_UPDATE = "GDC002"; //征信信息更新错误
    public static final String ERROR_CODE_CREDIT_DELETE = "GDC003"; //征信信息删除错误
    public static final String ERROR_CODE_CREDIT_INSERT = "GDC004"; //征信信息插入错误

    /**
	 * *************************规则模块DAO错误代码 SE1700~SE1799
	 * **********************************
	 */
	public static final String ERROR_CODE_RULES_DELETE = "SE1700"; // 规则表删除错误
	public static final String ERROR_CODE_RULES_INSERT = "SE1701"; // 规则表插入错误
	public static final String ERROR_CODE_RULES_SELECT = "SE1702"; // 规则表读取错误
	public static final String ERROR_CODE_RULES_UPDATE = "SE1703"; // 规则表修改错误
	public static final String ERROR_CODE_WORKFLOW_DELETE = "SE1704"; // 工作流表删除错误
	public static final String ERROR_CODE_WORKFLOW_INSERT = "SE1705"; // 工作流表插入错误
	public static final String ERROR_CODE_WORKFLOW_SELECT = "SE1706"; // 工作流表读取错误
	public static final String ERROR_CODE_WORKFLOW_UPDATE = "SE1707"; // 工作流表修改错误
	public static final String ERROR_CODE_RULE_INVOKE = "SE5572"; // 规则调用错误
	public static final String ERROR_CODE_RULE_NAMEOCCUR = "SE5573"; // 规则资源重名
	public static final String ERROR_CODE_RULE_GEN = "SE5574";// 规则文件生成错误
	public static final String ERROR_CODE_RULE_EXECUTE = "SE5575"; // 规则执行错误
	public static final String ERROR_CODE_RULE_DELFILE = "SE5576"; // 删除规则脚本失败
	public static final String ERROR_CODE_RULE_COPY = "SE5577"; // 规则资源复制错误

	public static final String ERROR_CODE_RULE_DELREF = "SE5571"; // 不能删除正在使用的资源


	public static final String ERROR_CODE_E_APPROVE_OPEN_PARAM_INSERT= "GDJ001"; // 电子审批开办参数插入错
	public static final String ERROR_CODE_E_APPROVE_OPEN_PARAM_SELECT= "GDJ002"; // 电子审批开办参数读取错误
	public static final String ERROR_CODE_E_APPROVE_OPEN_PARAM_UPDATE= "GDJ003"; // 电子审批开办参数更新错误
	public static final String ERROR_CODE_E_APPROVE_OPEN_PARAM_DELETE= "GDJ004"; // 电子审批开办参数删除错误


	public static final String ERROR_CODE_E_APPROVE_PARAM_INSERT= "GDJ005"; // 电子审批参数插入错
	public static final String ERROR_CODE_E_APPROVE_PARAM_SELECT= "GDJ006"; // 电子审批参数读取错误
	public static final String ERROR_CODE_E_APPROVE_PARAM_UPDATE= "GDJ007"; // 电子审批参数更新错误
	public static final String ERROR_CODE_E_APPROVE_PARAM_DELETE= "GDJ008"; // 电子审批参数删除错误

	public static final String ERROR_CODE_RISK_FILTER_PARAM_INSERT= "GDJ009"; // 风险过滤参数插入错
	public static final String ERROR_CODE_RISK_FILTER_PARAM_SELECT= "GDJ010"; // 风险过滤参数读取错误
	public static final String ERROR_CODE_RISK_FILTER_PARAM_UPDATE= "GDJ011"; // 风险过滤参数更新错误
	public static final String ERROR_CODE_RISK_FILTER_PARAM_DELETE= "GDJ012"; // 风险过滤参数删除错误

	public static final String ERROR_CODE_RISK_FILTER_SMALL_LOAN_PARAM_INSERT= "GDJ013"; // 风险过滤小额贷款余额参数插入错
	public static final String ERROR_CODE_RISK_FILTER_SMALL_LOAN_PARAM_SELECT= "GDJ014"; // 风险过滤小额贷款余额参数读取错误
	public static final String ERROR_CODE_RISK_FILTER_SMALL_LOAN_PARAM_UPDATE= "GDJ015"; // 风险过滤小额贷款余额参数更新错误
	public static final String ERROR_CODE_RISK_FILTER_SMALL_LOAN_PARAM_DELETE= "GDJ016"; // 风险过滤小额贷款余额参数删除错误

    //浮动利率变更申请表
    public static final String ERROR_CODE_FLTINTRATE_CHG_APPLY_DELETE = "GD1678"; //浮动利率变更申请表删除错误
    public static final String ERROR_CODE_FLTINTRATE_CHG_APPLY_INSERT = "GD1679"; //浮动利率变更申请表插入错误
    public static final String ERROR_CODE_FLTINTRATE_CHG_APPLY_SELECT = "GD1680"; //浮动利率变更申请表读取错误
    public static final String ERROR_CODE_FLTINTRATE_CHG_APPLY_UPDATE = "GD1681"; //浮动利率变更申请表修改错误


    //预防假按揭问题表
    public static final String ERROR_CODE_PREV_FAKE_MORT_QST_DELETE = "GD1670"; //预防假按揭问题表删除错误
    public static final String ERROR_CODE_PREV_FAKE_MORT_QST_INSERT = "GD1671"; //预防假按揭问题表插入错误
    public static final String ERROR_CODE_PREV_FAKE_MORT_QST_SELECT = "GD1672"; //预防假按揭问题表读取错误
    public static final String ERROR_CODE_PREV_FAKE_MORT_QST_UPDATE = "GD1673"; //预防假按揭问题表修改错误

    //预防假按揭访谈记录表
    public static final String ERROR_CODE_PREV_FAKE_MORT_ITV_DELETE = "GD1674"; //预防假按揭访谈记录表删除错误
    public static final String ERROR_CODE_PREV_FAKE_MORT_ITV_INSERT = "GD1675"; //预防假按揭访谈记录表插入错误
    public static final String ERROR_CODE_PREV_FAKE_MORT_ITV_SELECT = "GD1676"; //预防假按揭访谈记录表读取错误
    public static final String ERROR_CODE_PREV_FAKE_MORT_ITV_UPDATE = "GD1677"; //预防假按揭访谈记录表修改错误

    //客户来访记录表
    public static final String ERROR_CODE_CUST_VISIT_INFO_DELETE = "GD1682"; //客户来访记录表删除错误
    public static final String ERROR_CODE_CUST_VISIT_INFO_INSERT = "GD1683"; //客户来访记录表插入错误
    public static final String ERROR_CODE_CUST_VISIT_INFO_SELECT = "GD1684"; //客户来访记录表读取错误
    public static final String ERROR_CODE_CUST_VISIT_INFO_UPDATE = "GD1685"; //客户来访记录表修改错误

    //评分卡模块错误码 GDG001~GDG999
    public static final String ERROR_CODE_GRADE_RESULT = "GDG001";//评分错误;



    //风险评估信息表  add by joan.wu 20091202
    public static final String ERROR_CODE_CUST_RISK_INFO_INSERT = "GD8003"; //风险评估信息表插入错误
    public static final String ERROR_CODE_CUST_RISK_INFO_DELETE = "GD8002"; //风险评估信息表删除错误
    public static final String ERROR_CODE_CUST_RISK_INFO_SELECT = "GD8004"; //风险评估信息表读取错误
    public static final String ERROR_CODE_CUST_RISK_INFO_UPDATE = "GD8005"; //风险评估信息表修改错误
    public static final String ERROR_CODE_ASSET_SUM_ZERO = "GD8018"; //资产负债表的总资产合计为0
    public static final String ERROR_CODE_RISK_EVAL_LACK = "GD8001"; //不能做例外加按贷款

    //风险评估项目表  add by joan.wu 20091203
    public static final String ERROR_CODE_CUST_RISK_ITEM_DELETE = "GD8010"; //风险评估项目表删除错误
    public static final String ERROR_CODE_CUST_RISK_ITEM_INSERT = "GD8011"; //风险评估项目表插入错误
    public static final String ERROR_CODE_CUST_RISK_ITEM_SELECT = "GD8012"; //风险评估项目表读取错误
    public static final String ERROR_CODE_CUST_RISK_ITEM_UPDATE = "GD8013"; //风险评估项目表修改错误

    //风险评估提示信息表
    public static final String ERROR_CODE_CUST_REMIND_INFO_DELETE = "GD8006"; //风险评估提示信息表删除错误
    public static final String ERROR_CODE_CUST_REMIND_INFO_INSERT = "GD8007"; //风险评估提示信息表插入错误
    public static final String ERROR_CODE_CUST_REMIND_INFO_SELECT = "GD8008"; //风险评估提示信息表读取错误
    public static final String ERROR_CODE_CUST_REMIND_INFO_UPDATE = "GD8009"; //风险评估提示信息表修改错误

    //风险评估参数表
    public static final String ERROR_CODE_CUST_RISK_PARAM_DELETE = "GD8014"; //风险评估参数表删除错误
    public static final String ERROR_CODE_CUST_RISK_PARAM_INSERT = "GD8015"; //风险评估参数表插入错误
    public static final String ERROR_CODE_CUST_RISK_PARAM_SELECT = "GD8016"; //风险评估参数表读取错误
    public static final String ERROR_CODE_CUST_RISK_PARAM_UPDATE = "GD8017"; //风险评估参数表修改错误

    public static final String ERROR_CODE_GROSS_INTRATE_INFO_DELETE = "GD1649"; //主要产品信息表删除错误
    public static final String ERROR_CODE_GROSS_INTRATE_INFO_INSERT = "GD1650"; //主要产品信息表插入错误
    public static final String ERROR_CODE_GROSS_INTRATE_INFO_SELECT = "GD1651"; //主要产品信息表读取错误
    public static final String ERROR_CODE_GROSS_INTRATE_INFO_UPDATE = "GD1652"; //主要产品信息表修改错误



    public static final String ERROR_CODE_LETCRIEDT_PAY_DTL_DELETE = "SE9100"; //信用证付款明细记录表删除错误
    public static final String ERROR_CODE_LETCRIEDT_PAY_DTL_INSERT = "SE9101"; //信用证付款明细记录表插入错误
    public static final String ERROR_CODE_LETCRIEDT_PAY_DTL_SELECT = "SE9102"; //信用证付款明细记录表读取错误
    public static final String ERROR_CODE_LETCRIEDT_PAY_DTL_UPDATE = "SE9103"; //信用证付款明细记录表修改错误








    /*********
     * TODO 核算错误码
     */

	/**
	 * add by znh 2008-04-29 核算数据库操作错误码
	 */
	public static final String ERROR_CODE_ACE_DELETE = "GDAC01"; // 核算数据表删除错误
	public static final String ERROR_CODE_ACE_INSERT = "GDAC02"; // 核算数据表插入错误
	public static final String ERROR_CODE_ACE_SELECT = "GDAC03"; // 核算数据表读取错误
	public static final String ERROR_CODE_ACE_UPDATE = "GDAC04"; // 核算数据表修改错误

	/**
	 * add by Robin Suo 2008-05-22 核算系统的检查错误码
	 */
	public static final String ERROR_CODE_ACE_DB_IS_BLANK = "GDAC05"; // 借方不得为空
	public static final String ERROR_CODE_ACE_CR_IS_BLANK = "GDAC06"; // 贷方不得为空


	public static final String ERROR_CODE_E_APPROVE_PARAM_BRCODE = "GDJ001"; //必须先设置总行级别参数

	public static final String ERROR_CODE_E_APPROVE_PARAM_DEFINE  = "GDJ002"; // 设置参数错误

	public static final String ERROR_CODE_E_APPROVE_PARAM = "GDJ003"; //必须先设置总行级别参数

	public static final String ERROR_CODE_BRCODE_SPECIFY = "GDJ100";//只能更新本机构所在分行参数

	public static final String ERROR_CODE_WRONG_EFFECT_DATE = "GDJ101";//生效日期错误

	public static final String ERROR_CODE_WRONG_DEFINE_PARAM="GDJ102";//参数错误

	public static final String ERROR_CODE_HAS_SAME_PARAM="GDJ103";//参数生效日相同

	public static final String ERROR_CODE_NO_EDIT="GDJ104";//不得修改只读项

	public static final String ERROR_CODE_SET_LOAN_INTR_FAV_PARAM = "GDJ105"; // 必须先设置总行级别参数


	/**
	 * add by tanyang 2010-10-14 城联盟人员培训管理错误码
	 */

	public static final String ERROR_CODE_TRAINING_INSERT = "MM8001"; // 人员培训管理表插入错误
	public static final String ERROR_CODE_TRAINING_SELECT = "MM8002"; // 人员培训管理表读取错误
	public static final String ERROR_CODE_TRAINING_UPDATE = "MM8003"; // 人员培训管理表修改错误
	public static final String ERROR_CODE_TRAINING_DELETE = "MM8004"; // 人员培训管理表删除错误
	/**
	 * add by xiaoqing.zhou 2010-10-14 城联盟客户管理错误码
	 */
	public static final String ERROR_CODE_CUSTOMER_DELETE = "MM7001"; //客户删除错误
	public static final String ERROR_CODE_CUSTOMER_RESUME = "MM7002"; //客户恢复错误
	public static final String ERROR_CODE_CUSTOMER_FREEZE = "MM7003"; //客户冻结错误
	public static final String ERROR_CODE_CUSTOMER_UNFREEZE = "MM7004"; //客户解冻错误
	/**
	 * 资产保全模块错误码
	 */

	public static final String ERROR_CODE_NOSELECT_CONTRACT = "NPA0001"; // 请先选择合同
	public static final String ERROR_CODE_REPEATADD_CONTRACT = "NPA0002"; // 重复添加合同
	public static final String ERROR_CODE_BEFORESAVE_CONTRACT = "NPA0003"; // 保存后再选择合同
	public static final String ERROR_CODE_NOSAVE_LAWSUIT_INFO = "NPA0004"; // 请先登记案件信息再选择合同
	public static final String ERROR_CODE_NOSELECT_NPATRANS = "NPA0005"; // 请至少选择一笔不良资产
	public static final String ERROR_CODE_NOSEND_NPATRANS = "NPA0006"; // 已做清收或收现，不可逆分发

	public static final String ERROR_CODE_NOMODIFY_CURRENT = "NPA0007"; // 请修改后再提交
	public static final String ERROR_CODE_HAIMODIFY_PLACESUBMIT = "NPA0008"; // 请先点击灵活定制

	/** add by fan.jiang 20100110 start
	 * 核算
	 */
	public static final String ERROR_CODE_LNCIAPPDTL_SELECT = "LN0110"; // 五级分类查询错误
	public static final String ERROR_CODE_LNCIAPPDTL_UPDATE = "LN0111"; // 五级分类更新错误
	public static final String ERROR_CODE_LNCIAPPDTL_DELETE = "LN0112"; // 五级分类删除错误
	public static final String ERROR_CODE_LNCIAPPDTL_INSERT = "LN0113"; // 五级分类插入错误

	/** add by qianlong 20110121 start
	 * 罚金减免申请
	 */
	public static final String ERROR_CODE_TLAREDUCEPAMTAPPLY_SELECT = "TRA110"; // 罚金减免申请查询错误
	public static final String ERROR_CODE_TLAREDUCEPAMTAPPLY_UPDATE = "TRA111"; // 罚金减免申请插入错误
	public static final String ERROR_CODE_TLAREDUCEPAMTAPPLY_DELETE = "TRA112"; // 罚金减免申请删除错误
	public static final String ERROR_CODE_TLAREDUCEPAMTAPPLY_INSERT = "TRA113"; // 罚金减免申请更新错误
    /** add by qianlong 20110121 end 罚金减免申请 */

	/*
	 * 合作项目模块错误码
	 * */

	public static final String ERROR_CODE_PROJ_CHECK = "GD4512"; //合作项目复核错误
	public static final String ERROR_CODE_PROJ_REFUSE = "GD4513"; //已拒绝的合作项目

	public static final String ERROR_CODE_COOP_PROJ_TOUR_INFO_SELECT = "GD1721"; // 合作项目旅游信息读取错误
	public static final String ERROR_CODE_COOP_PROJ_TOUR_INFO_UPDATE = "GD1722"; // 合作项目旅游信息修改错误
	public static final String ERROR_CODE_COOP_PROJ_TOUR_INFO_INSERT = "GD1723"; // 合作项目旅游信息插入错误
	public static final String ERROR_CODE_COOP_PROJ_TOUR_INFO_DELETE = "GD1724"; // 合作项目旅游信息删除错误


	// 批文件流水表
	 /***
	  *  zhushijie add  2011-01-18 17:54:35
	  */
	public static final String ERROR_CODE_BATCHFILELOG_INFO_SELECT = "GD1808"; // 批文件流水表读取错误
	public static final String ERROR_CODE_BATCHFILELOG_INFO_DELETE = "GD1809"; // 批文件流水表删除错误
	public static final String ERROR_CODE_BATCHFILELOG_INFO_UPDATE = "GD1810"; // 批文件流水表修改错误
	public static final String ERROR_CODE_BATCHFILELOG_INFO_INSERT = "GD1811"; // 批文件流水表插入错误

	//档案资料表
	public static final String ERROR_CODE_ARCHIVE_MATERIAL_SELECT = "GD1944";//档案资料表读取错误
	public static final String ERROR_CODE_ARCHIVE_MATERIAL_UPDATE = "GD1945";//档案资料表更新错误
	public static final String ERROR_CODE_ARCHIVE_MATERIAL_INSERT = "GD1946";//档案资料表插入错误
	public static final String ERROR_CODE_ARCHIVE_MATERIAL_DELETE = "GD1947";//档案资料表删除错误

	// 操作员请假表   tlr_lvday_info
	public static final String ERROR_CODE_TLRIVDAY_INFO_DELETE = "GD1754"; // 操作员请假表删除错误
	public static final String ERROR_CODE_TLRIVDAY_INFO_INSERT = "GD1755"; // 操作员请假表插入错误
	public static final String ERROR_CODE_TLRIVDAY_INFO_SELECT = "GD1756"; // 操作员请假表读取错误
	public static final String ERROR_CODE_TLRIVDAY_INFO_UPDATE = "GD1757"; // 操作员请假表修改错误



	/**
	 * DAO错误代码段 GD1670~GD1699, GD1712-GD2000,请不要定义超过2000的DAO错误码
	 */
	// 个人经营信息表  shijie.zhu
	public static final String ERROR_CODE_INDV_INDUSTRY_INFO_DELETE = "PGD1670"; // 个人经营信息表删除错误
	public static final String ERROR_CODE_INDV_INDUSTRY_INFO_INSERT = "PGD1671"; // 个人经营信息表插入错误
	public static final String ERROR_CODE_INDV_INDUSTRY_INFO_SELECT = "PGD1672"; // 个人经营信息表读取错误
	public static final String ERROR_CODE_INDV_INDUSTRY_INFO_UPDATE = "PGD1673"; // 个人经营信息表修改错误


	//贷款合同历史表 gz
	public static final String ERROR_CODE_LOANINFO_HISTORY_EXT_SELECT = "GD7700"; // 贷款合同历史表读取错误
	public static final String ERROR_CODE_LOANINFO_HISTORY_EXT_UPDATE = "GD7701"; // 贷款合同历史表修改错误
	public static final String ERROR_CODE_LOANINFO_HISTORY_EXT_INSERT = "GD7702"; // 贷款合同历史表插入错误
	public static final String ERROR_CODE_LOANINFO_HISTORY_EXT_DELETE = "GD7703"; // 贷款合同历史表删除错误


	//贷款借据历史信息表gz
	public static final String ERROR_CODE_LOANCINOHISTORY_EXT_SELECT = "GD7704"; // 贷款借据历史信息表读取错误
	public static final String ERROR_CODE_LOANCINOHISTORY_EXT_UPDATE = "GD7705"; // 贷款借据历史信息表修改错误
	public static final String ERROR_CODE_LOANCINOHISTORY_EXT_INSERT = "GD7706"; // 贷款借据历史信息表插入错误
	public static final String ERROR_CODE_LOANCINOHISTORY_EXT_DELETE = "GD7707"; // 贷款借据历史信息表删除错误


	//批量五级分类gz
	public static final String ERROR_CODE_POSTLOAN_EXAM_BATCH_APPLY_DELETE = "GD1788"; //批量贷后检查申请表删除错误
	public static final String ERROR_CODE_POSTLOAN_EXAM_BATCH_APPLY_INSERT = "GD1789";//批量贷后检查申请表插入错误
	public static final String ERROR_CODE_POSTLOAN_EXAM_BATCH_APPLY_SELECT = "GD1790";//批量贷后检查申请表读取错误
	public static final String ERROR_CODE_POSTLOAN_EXAM_BATCH_APPLY_UPDATE = "GD1791";//批量贷后检查申请表更新错误



	// 贷款审查审批修改明细表 add by learncy.zou
	public static final String ERROR_CODE_LOAN_CHG_HISTORY_DELETE = "GD1712"; // 贷款审查审批修改明细表删除错误
	public static final String ERROR_CODE_LOAN_CHG_HISTORY_INSERT = "GD1713"; // 贷款审查审批修改明细表插入错误
	public static final String ERROR_CODE_LOAN_CHG_HISTORY_SELECT = "GD1714"; // 贷款审查审批修改明细表读取错误
	public static final String ERROR_CODE_LOAN_CHG_HISTORY_UPDATE = "GD1715"; // 贷款审查审批修改明细表修改错误

	//借据支付信息表 add by learncy.zou
	public static final String ERROR_CODE_LOAN_PAY_INFO_SELECT = "GD1940";//借据支付信息表读取错误
	public static final String ERROR_CODE_LOAN_PAY_INFO_UPDATE = "GD1941";//借据支付信息表更新错误
	public static final String ERROR_CODE_LOAN_PAY_INFO_INSERT = "GD1942";//借据支付信息表插入错误
	public static final String ERROR_CODE_LOAN_PAY_INFO_DELETE = "GD1943";//借据支付信息表删除错误

	public static final String ERROR_CODE_CARDNO_CHG_NO_PERMISSION = "GD5575"; // 该借据不允许做出款前卡号变更
	public static final String ERROR_CODE_GRANT_NO_PERMISSION = "GD5576"; // 该贷款不符合出账要求
	public static final String ERROR_CODE_RTNMODE_MACTH_ERROR = "GD5578"; // 还款方式信息设置有误
	public static final String ERROR_CODE_CREDIT_NUMS_ERROR = "GD5579"; // 客户额度数目超过允许范围

	//出帐审核申请表  add by learncy.zou
	public static final String ERROR_CODE_LOAN_PAY_CHECK_DELETE = "GD1766"; // 出帐审核申请表删除错误
	public static final String ERROR_CODE_LOAN_PAY_CHECK_INSERT = "GD1767"; // 出帐审核申请表插入错误
	public static final String ERROR_CODE_LOAN_PAY_CHECK_SELECT = "GD1768"; // 出帐审核申请表读取错误
	public static final String ERROR_CODE_LOAN_PAY_CHECK_UPDATE = "GD1769"; // 出帐审核申请表修改错误

	//lilinfeng add 信贷规模参数表
	public static final String ERROR_CODE_CREDIT_SCALE_PARAM_SELECT = "GD1725"; // 信贷规模参数表读取错误
	public static final String ERROR_CODE_CREDIT_SCALE_PARAM_UPDATE = "GD1726"; // 信贷规模参数表修改错误
	public static final String ERROR_CODE_CREDIT_SCALE_PARAM_INSERT = "GD1727"; // 信贷规模参数表插入错误
	public static final String ERROR_CODE_CREDIT_SCALE_PARAM_DELETE = "GD1728"; // 信贷规模参数表删除错误



	public static final String ERROR_CODE_PREVENT_TIME = "GD0130";// 不允许在N小时内再次修改密码
	public static final String ERROR_CODE_REPEAT_INTERVAL = "GD0131";// 用户密码不能与最近{0}次修改的密码相同

}
