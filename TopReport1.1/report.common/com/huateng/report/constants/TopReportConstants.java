package com.huateng.report.constants;
/**
 * 常量定义类
 * @author shishu.zhang
 *
 * 2012-8-14下午3:39:03
 */
public class TopReportConstants {

	/** 工作日历维护 日期标志--工作日 **/
	public static final Integer REPORT_BIWORKDATE_WORKFLAG_WORK = 1;

	/** 工作日历维护 日期标志--非工作日 **/
	public static final Integer REPORT_BIWORKDATE_WORKFLAG_REST = 0;

	//业务类型
	/** 业务类型BOP - 01 **/
	public static final String REPORT_BUSITYPE_BOP = "01";

	//工作完成确认  01已确认  02 未确认  03 取消确认
	/** 工作完成确认  01已确认  **/
	public static final String REPORT_CONFRIM_STATUS_01 = "01";

	/** 工作完成确认   02 未确认  **/
	public static final String REPORT_CONFRIM_STATUS_02 = "02";

	/** 工作完成确认  03 取消确认  **/
	public static final String REPORT_CONFRIM_STATUS_03 = "03";

	//工作完成上报状态 01 锁定 02 未锁定  03 取消锁定
	/** 工作完成上报状态 01 锁定 **/
	public static final String REPORT_SUBFILE_STATUS_01 = "01";

	/** 工作完成上报状态 02 未锁定 **/
	public static final String REPORT_SUBFILE_STATUS_02 = "02";

	/** 工作完成上报状态 03 取消锁定 **/
	public static final String REPORT_SUBFILE_STATUS_03 = "03";


	//流程操作记录执行类型 01- 数据导入 02 - 数据分析 03- 补录确认 04 - 审核确认 05 - 生成上报文件 06- 导入回执文件
	/**流程操作记录执行类型 01- 数据导入 **/
	public static final String REPORT_PROCESS_EXECTYPE_IMP = "01";

	/**流程操作记录执行类型 02 - 数据分析 **/
	public static final String REPORT_PROCESS_EXECTYPE_ANALY = "02";

	/**流程操作记录执行类型 03- 补录确认  **/
	public static final String REPORT_PROCESS_EXECTYPE_COLLCONFIRM = "03";

	/**流程操作记录执行类型 04 - 审核确认  **/
	public static final String REPORT_PROCESS_EXECTYPE_AUDITCONFIRM = "04";

	/**流程操作记录执行类型 05 - 生成上报文件 **/
	public static final String REPORT_PROCESS_EXECTYPE_GENREPORT = "05";

	/**流程操作记录执行类型 06- 导入回执文件 **/
	public static final String REPORT_PROCESS_EXECTYPE_LOADBACKFILE = "06";

	/**流程操作记录执行类型 07 - 文件报送 **/
	public static final String REPORT_PROCESS_EXECTYPE_SEND = "07";

	//OPER_TYPE 操作类型
	/** 操作类型 手动 -- 01 **/
	public static final String REPORT_PROCESS_OPERTYPE_MANU = "01";

	/** 操作类型 定时 -- 02 **/
	public static final String REPORT_PROCESS_OPERTYPE_TIME = "02";

	// 应用类型 BOP-国际收支
	/** 应用类型 BOP-国际收支 **/
	public static final String REPORT_APP_TYPE_BOP = "BOP";

	// 应用类型 BOP-文件类型
	/** 接口控制文件**/

	/** 应用类型BOP-文件类型 T 接口控制文件 **/
	public static final String REPORT_FILE_TYPE_BOP_T = "T";
//	A 涉外收入申报单—基础信息
	/** 应用类型BOP: 文件类型A 涉外收入申报单—基础信息 **/
	public static final String REPORT_FILE_TYPE_BOP_A = "A";
//	B 境外汇款申请书—基础信息
	/** 应用类型 BOP: 文件类型B 境外汇款申请书—基础信息 **/
	public static final String REPORT_FILE_TYPE_BOP_B = "B";
//	C 对外付款/承兑通知书—基础信息
	/** 应用类型BOP: 文件类型C 对外付款/承兑通知书—基础信息 **/
	public static final String REPORT_FILE_TYPE_BOP_C = "C";
//	D 境内收入申报单-基础信息
	/** 应用类型 BOP: 文件类型D 境内收入申报单-基础信息 **/
	public static final String REPORT_FILE_TYPE_BOP_D = "D";
//	E 境内汇款申请书—基础信息
	/** 应用类型BOP: 文件类型E 境内汇款申请书—基础信息 **/
	public static final String REPORT_FILE_TYPE_BOP_E = "E";
//	F 境内付款/承兑通知书—基础信息
	/** 应用类型 BOP: 文件类型F 境内付款/承兑通知书—基础信息 **/
	public static final String REPORT_FILE_TYPE_BOP_F = "F";
//	G 涉外收入申报单—申报信息
	/** 应用类型BOP: 文件类型G 涉外收入申报单—申报信息 **/
	public static final String REPORT_FILE_TYPE_BOP_G = "G";
//	H 境外汇款申请书—申报信息
	/** 应用类型 BOP: 文件类型H 境外汇款申请书—申报信息 **/
	public static final String REPORT_FILE_TYPE_BOP_H = "H";
//	K 对外付款/承兑通知书—申报信息
	/** 应用类型BOP: 文件类型K 对外付款/承兑通知书—申报信息 **/
	public static final String REPORT_FILE_TYPE_BOP_K = "K";
//	N 境外汇款申请书—管理信息
	/** 应用类型 BOP: 文件类型N 境外汇款申请书—管理信息 **/
	public static final String REPORT_FILE_TYPE_BOP_N = "N";	
//	P 对外付款/承兑通知书—管理信息
	/** 应用类型BOP: 文件类型P 对外付款/承兑通知书—管理信息 **/
	public static final String REPORT_FILE_TYPE_BOP_P = "P";
//	Q 境内汇款申请书—管理信息
	/** 应用类型 BOP: 文件类型Q 境内汇款申请书—管理信息 **/
	public static final String REPORT_FILE_TYPE_BOP_Q = "Q";
//	R 境内收入申报单—管理信息
	/** 应用类型 BOP: 文件类型R 境内收入申报单—管理信息 **/
	public static final String REPORT_FILE_TYPE_BOP_R = "R";
//	S 境内付款/承兑通知书—管理信息
	/** 应用类型BOP: 文件类型S 境内付款/承兑通知书—管理信息 **/
	public static final String REPORT_FILE_TYPE_BOP_S = "S";
//	U 单位基本情况表
	/** 应用类型 BOP: 文件类型U 单位基本情况表 **/
	public static final String REPORT_FILE_TYPE_BOP_U = "U";
	
	// 应用类型 JSH-外汇账户内结售汇
	/** 应用类型 JSH-外汇账户内结售汇 **/
	public static final String REPORT_APP_TYPE_JSH = "JSH";
	
	// 应用类型JSH-文件类型
	/** 接口控制文件**/

	/** 应用类型 JSH-文件类型 TT 接口控制文件 **/
	public static final String REPORT_FILE_TYPE_JSH_T = "T";
//	D 结汇申请书—基础信息
	/** 应用类型 JSH: 文件类型D 结汇申请书—基础信息 **/
	public static final String REPORT_FILE_TYPE_JSH_D = "D";
//	E 购汇申请书—基础信息
	/** 应用类型 JSH: 文件类型 E 购汇申请书—基础信息 **/
	public static final String REPORT_FILE_TYPE_JSH_E = "E";
//	F 结汇申请书—管理信息
	/** 应用类型 JSH: 文件类型F 结汇申请书—管理信息 **/
	public static final String REPORT_FILE_TYPE_JSH_F = "F";
//	G 购汇申请书—管理信息
	/** 应用类型 JSH: 文件类型G 购汇申请书—管理信息 **/
	public static final String REPORT_FILE_TYPE_JSH_G = "G";
	
	//应用类型 ACC-外汇账户
	/** 应用类型 ACC-外汇账户 **/
	public static final String REPORT_APP_TYPE_ACC = "ACC";

//	应用类型 ACC-文件类型
	/** 接口控制文件**/

	/** 应用类型 ACC-文件类型 TT 接口控制文件 **/
	public static final String REPORT_FILE_TYPE_ACC_TT = "TT";
//	CA 账户开关户信息
	/** 应用类型 ACC: 文件类型 CA - 账户开关户信息 **/
	public static final String REPORT_FILE_TYPE_ACC_CA = "CA";
//	CB 账户收支余信息
	/** 应用类型 ACC: 文件类型 CB - 账户收支余信息 **/
	public static final String REPORT_FILE_TYPE_ACC_CB = "CB";

	/** 应用类型 CFA-资本项目 **/
	public static final String REPORT_APP_TYPE_CFA = "CFA";

//	应用类型 CFA-文件类型

//	TT 接口控制文件
	/** 应用类型 CFA: 文件类型 TT- 接口控制文件 **/
	public static final String REPORT_FILE_TYPE_CFA_TT = "TT";
//	AA 外债双边贷款—签约信息
	/** 应用类型 CFA: 文件类型 AA- 外债双边贷款—签约信息 **/
	public static final String REPORT_FILE_TYPE_CFA_AA = "AA";
//	AB  外债买方信贷—签约信息
	/** 应用类型 CFA: 文件类型 AB - 外债买方信贷—签约信息 **/
	public static final String REPORT_FILE_TYPE_CFA_AB = "AB";
//	AC  外债境外同业拆借—签约信息
	/** 应用类型 CFA: 文件类型 AC - 外债境外同业拆借—签约信息 **/
	public static final String REPORT_FILE_TYPE_CFA_AC = "AC";
//	AD  外债海外代付—签约信息
	/** 应用类型 CFA: 文件类型 AD - 外债海外代付—签约信息 **/
	public static final String REPORT_FILE_TYPE_CFA_AD = "AD";

//	AE  外债卖出回购—签约信息
	/** 应用类型 CFA: 文件类型 AE - 外债卖出回购—签约信息 **/
	public static final String REPORT_FILE_TYPE_CFA_AE = "AE";
//	AF  外债远期信用证—签约信息
	/** 应用类型 CFA: 文件类型 AF - 外债远期信用证—签约信息 **/
	public static final String REPORT_FILE_TYPE_CFA_AF = "AF";
//	AG  外债银团贷款—签约信息
	/** 应用类型 CFA: 文件类型 AG - 外债银团贷款—签约信息 **/
	public static final String REPORT_FILE_TYPE_CFA_AG = "AG";
//	AH  外债贵金属拆借—签约信息
	/** 应用类型 CFA: 文件类型 AH - 外债贵金属拆借—签约信息 **/
	public static final String REPORT_FILE_TYPE_CFA_AH = "AH";
//	AI  外债其他贷款—签约信息
	/** 应用类型 CFA: 文件类型 AI - 外债其他贷款—签约信息 **/
	public static final String REPORT_FILE_TYPE_CFA_AI = "AI";
//	AJ  外债货币市场工具—签约信息
	/** 应用类型 CFA: 文件类型 AJ - 外债货币市场工具—签约信息 **/
	public static final String REPORT_FILE_TYPE_CFA_AJ = "AJ";
//	AK  外债债券和票据—签约信息
	/** 应用类型 CFA: 文件类型 AK - 外债债券和票据—签约信息 **/
	public static final String REPORT_FILE_TYPE_CFA_AK = "AK";
//	AL  外债境外同业存放—签约信息
	/** 应用类型 CFA: 文件类型 AL - 外债境外同业存放—签约信息 **/
	public static final String REPORT_FILE_TYPE_CFA_AL = "AL";
//	AM  外债境外联行及附属机构往来—签约信息
	/** 应用类型 CFA: 文件类型 AM - 外债境外联行及附属机构往来—签约信息 **/
	public static final String REPORT_FILE_TYPE_CFA_AM = "AM";
//	AN  外债非居民机构存款—签约信息
	/** 应用类型 CFA: 文件类型 AN - 外债非居民机构存款—签约信息 **/
	public static final String REPORT_FILE_TYPE_CFA_AN = "AN";
//	AP  外债非居民个人存款—签约信息
	/** 应用类型 CFA: 文件类型  AP - 外债非居民个人存款—签约信息 **/
	public static final String REPORT_FILE_TYPE_CFA_AP = "AP";
//	AQ  外债其他外债—签约信息
	/** 应用类型 CFA: 文件类型  AQ - 外债其他外债—签约信息 **/
	public static final String REPORT_FILE_TYPE_CFA_AQ = "AQ";
//	AR  外债—变动信息
	/** 应用类型 CFA: 文件类型  AR - 外债—变动信息 **/
	public static final String REPORT_FILE_TYPE_CFA_AR = "AR";
//	AS  外债—余额信息
	/** 应用类型 CFA: 文件类型  AS - 外债—余额信息**/
	public static final String REPORT_FILE_TYPE_CFA_AS = "AS";
//	BA 对外担保—签约信息
	/** 应用类型 CFA: 文件类型  BA - 对外担保—签约信息**/
	public static final String REPORT_FILE_TYPE_CFA_BA = "BA";
//	BB 对外担保—责任余额信息
	/** 应用类型 CFA: 文件类型  BB - 对外担保—责任余额信息**/
	public static final String REPORT_FILE_TYPE_CFA_BB = "BB";
//	BC  对外担保-履约信息
	/** 应用类型 CFA: 文件类型  BC - 对外担保-履约信息**/
	public static final String REPORT_FILE_TYPE_CFA_BC = "BC";
//	CA 国内外汇贷款—签约信息
	/** 应用类型 CFA: 文件类型  CA - 国内外汇贷款—签约信息**/
	public static final String REPORT_FILE_TYPE_CFA_CA = "CA";
//	CB 国内外汇贷款—变动信息
	/** 应用类型 CFA: 文件类型  CB - 国内外汇贷款—变动信息**/
	public static final String REPORT_FILE_TYPE_CFA_CB = "CB";
//	DA 境外担保项下境内贷款—签约信息
	/** 应用类型 CFA: 文件类型  DA - 境外担保项下境内贷款—签约信息**/
	public static final String REPORT_FILE_TYPE_CFA_DA = "DA";
//	DB 境外担保项下境内贷款—变动及履约信息
	/** 应用类型 CFA: 文件类型  DB - 境外担保项下境内贷款—变动及履约信息**/
	public static final String REPORT_FILE_TYPE_CFA_DB = "DB";
//	EA 外汇质押人民币贷款—签约信息
	/** 应用类型 CFA: 文件类型  EA - 外汇质押人民币贷款—签约信息**/
	public static final String REPORT_FILE_TYPE_CFA_EA = "EA";
//	EB 外汇质押人民币贷款—变动信息
	/** 应用类型 CFA: 文件类型  EB - 外汇质押人民币贷款—变动信息**/
	public static final String REPORT_FILE_TYPE_CFA_EB = "EB";
//	FA 商业银行人民币结构性存款—签约信息
	/** 应用类型 CFA: 文件类型  FA - 商业银行人民币结构性存款—签约信息**/
	public static final String REPORT_FILE_TYPE_CFA_FA = "FA";
//	FB 商业银行人民币结构性存款—终止信息
	/** 应用类型 CFA: 文件类型  FB - 商业银行人民币结构性存款—终止信息**/
	public static final String REPORT_FILE_TYPE_CFA_FB = "FB";
//	FC 商业银行人民币结构性存款—利息给付信息
	/** 应用类型 CFA: 文件类型  FC - 商业银行人民币结构性存款—利息给付信息**/
	public static final String REPORT_FILE_TYPE_CFA_FC = "FC";
//	FD 商业银行人民币结构性存款—资金流出入和结购汇信息
	/** 应用类型 CFA: 文件类型  FD - 商业银行人民币结构性存款—资金流出入和结购汇信息**/
	public static final String REPORT_FILE_TYPE_CFA_FD = "FD";

	//数据处理记录执行类型
	/** 数据处理记录操作类型   00-删除 **/
	public static final String REPORT_DATAPROCESS_EXECTYPE_DEL="00";

	/** 数据处理记录操作类型  01-补录/编辑 **/
	public static final String REPORT_DATAPROCESS_EXECTYPE_EDIT = "01";

	/** 数据处理记录操作类型  02-审核 **/
	public static final String REPORT_DATAPROCESS_EXECTYPE_AUDIT = "02";

	/** 数据处理记录操作类型  03-生成文件 **/
	public static final String REPORT_DATAPROCESS_EXECTYPE_GENREPORT = "03";

	/** 数据处理记录操作类型  04-回执导入 **/
	public static final String REPORT_DATAPROCESS_EXECTYPE_LOADBACK = "04";


	//操作类型
	/** 操作类型-A 创建 **/
	public static final String REPORT_ACTIONTYPE_A = "A";

	/** 操作类型-C 修改 **/
	public static final String REPORT_ACTIONTYPE_C = "C";

	/** 操作类型-D 删除 **/
	public static final String REPORT_ACTIONTYPE_D = "D";

	//记录状态
	/** 记录状态 - 01 -可编辑 **/
	public static final String REPORT_RECSTATUS_01 = "01";

	/** 记录状态 - 02-编辑待确认 **/
	public static final String REPORT_RECSTATUS_02 = "02";

	/** 记录状态 - 03-确认待审核 **/
	public static final String REPORT_RECSTATUS_03 = "03";

	/** 记录状态 - 04-审核未确认 **/
	public static final String REPORT_RECSTATUS_04 = "04";

	/** 记录状态 - 05-审核已确认 **/
	public static final String REPORT_RECSTATUS_05 = "05";

	/** 记录状态 - 06-已生成文件 **/
	public static final String REPORT_RECSTATUS_06 = "06";

	/** 记录状态 - 07-已删除 **/
	public static final String REPORT_RECSTATUS_07 = "07";

	//回执状态
	/** 回执状态 - 00-未返回 **/
	public static final String REPORT_REPSTATUS_00 = "00";

	/** 回执状态 - 01-回执成功 **/
	public static final String REPORT_REPSTATUS_01 = "01";

	/** 回执状态 - 02-回执失败 **/
	public static final String REPORT_REPSTATUS_02 = "02";

	//审批状态
	/** 审批状态 - 00-未审核 **/
	public static final String REPORT_APPROVESTATUS_00 = "00";

	/** 审批状态 - 01-通过 **/
	public static final String REPORT_APPROVESTATUS_01 = "01";

	/** 审批状态 - 02-不通过 **/
	public static final String REPORT_APPROVESTATUS_02 = "02";

	//是否已成功上报
	/** 是否已成功上报 - 1 - 是 **/
	public static final String REPORT_IS_SUB_SUCCESS_YES = "1";

	/** 是否已成功上报 - 0 - 否 **/
	public static final String REPORT_IS_SUB_SUCCESS_NO = "0";

	//数据上报方式
	/** 数据上报方式 - 01 - 生成上传 **/
	public static final String REPORT_SUB_FILE_TYPE_01 = "01";

	/** 数据上报方式 - 02 - 生成下载 **/
	public static final String REPORT_SUB_FILE_TYPE_02 = "02";


	/** 账户类别 12-现汇*/
	public static final String ACCOUNT_CATA_SPOT_EXCHANGE_12 = "12";

	/** 限额类型 13-贷方流入限额*/
	public static final String CREDIT_INTO_LIMIT_13="13";

	/** 账户状态 11-开户 */
	public static final String OPEN_ACCOUNT_TYPE_11 = "11";

	/** 账户状态 13-关户 */
	public static final String CLOSE_ACCOUNT_TYPE_13="13";

	/** 对公客户 */
	public static final String CUSTOMER_COPR = "11";

	/** 对公居民 */
	public static final String CUSTOMER_PRIV_RESIDENT = "13";

	/** 对公非居民 */
	public static final String CUSTOMER_PRIV_NON_RESIDENT = "13";

}
