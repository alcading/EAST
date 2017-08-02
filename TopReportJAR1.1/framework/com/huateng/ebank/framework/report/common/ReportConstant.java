/*
 * ==================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2004-2005 Huateng Software System.  All rights
 * reserved.
 * ==================================================================
 */
//jianxue.zhang
package com.huateng.ebank.framework.report.common;

import java.util.HashSet;
import java.util.Set;

public class ReportConstant {
	public static final String CURRENT_COUNTY_CODE = "CHN";
	public static final String APPROVE_FUNC_ID = "1008";// 主管确认功能编码
	public static final String QUERY_INFO_FUNC_ID = "1806";// 补录审核信息查询
	public static final String FORDEBT_LEFT_NAV_CODE = "02";// 外债左侧导航编码

	public static final String FORDEBT_TRACK_FUNC_ID = "1402";// 外债补录功能编码
	public static final String FORDEBT_APPROVE_FUNC_ID = "1502";// 外债审核功能编码
	public static final String FORDEBT_QUERY_FUNC_ID = "180602";// 外债查询功能编码
	public static final Set<String> FILTER_FUNC_ID_SET = new HashSet<String>() {
		{
			add(APPROVE_FUNC_ID);// 主管确认功能编码
			add(FORDEBT_TRACK_FUNC_ID);// 外债补录功能编码
			add(FORDEBT_APPROVE_FUNC_ID);// 外债审核功能编码
			add(QUERY_INFO_FUNC_ID);
			add(FORDEBT_QUERY_FUNC_ID);
		}
	};

	public static final String BAK_FILE_EXT = ".bak";

	public static final String BAK_DATA_FILE_NAME = "TopReport_DataBak.zip";

	public static final String BAK_DATA_UNZIP_ = "TEMP_";

	public static final boolean BOP_SUB_FILE_BRNO_TYPE = false;// 是否采用当前登录机构号作为上报文件生成机构号
																// true为是，flase采用参数配置的机构号

	public static final String DOWN_LOAD_PACK_ZIP_EXT = ".zip";

	public static final boolean SUB_FILE_CREATE_AUTO_SEND = true;// 生成上报文件后是否自动上传

	public static final boolean IMP_FILE_IS_AUTO_ANALY = true;// 定时导入后是否自动进行数据分析

	public static final boolean CREATE_SUB_FILE_IS_WORKDATE = false;// 是否按工作日期生成上报文件，还是只检查审核已确认的记录

	public static final String QUERY_EXP_EXCEl_SPLIT = ",";

	public static final String SAVE_QUERY_LOG_SIGN = "isSaveLog";

	public static final String QUERY_LOG_BUSI_NAME = "QUERY_LOG_BUSI_NAME";

	public static final String BOP_SUB_FILE_FEEDBACK = "ERR";// bop接口反馈文件标识

	public static final String SUB_FILE_DATE_TYPE = "01";// 01-系统日期 02-工作日期
															// //上报文件名及包名

	public static final int TASK_VALUE_NO = 1001;// 复核流程序号

	public static final int SUB_FILE_NO = 2001;// 文件序号

	public static final int SUB_FILE_REC_ROW = 5000;// 每个上报文件记录行数

	public static final int DATA_DIC_BUSI_TYPE_NO = 35;// 业务类型

	public static final int DATA_DIC_BOP_APP_TYPE_NO = 17;// 应用类型

	public static final boolean BUSINESS_NO_DATE_CURRENT = false;// 编号尚未生成日期是否采用当前工作日期

	public static final String BOP_ANALY_PROCESS_COUNT = "BOP0001";// 01-BOP用于统计处理文件数量
	// start-----jianxue.zhang
	public static final int BIZ_LOG_NO = 1002;// 日志生成序号
	public static final String MANGAGE_ROLE_ID = "101";// 销售的角色号
	public static final String MANGAGEMENT_ROLE_ID = "100";// 销售主管的角色号
	public static final String VIP_FLG = "1";// 澳新银行vip标志
	public static final String VIP_CLASS_FLG = "1";// 澳新银行合格vip标志
	public static final String VIP_CLASS_FLG_NO = "0";// 澳新银行不合格的vip标志
	public static final String PROJECT_NAME = "TopReport1.1";// 销售主管的角色号
	// public static final String OPENSUM = "1";//澳新银行vip标志
	// public static final String VIP_FLG = "1";//澳新银行vip标志
	// end------jianxue.zhang
	public static final String BUSI_NO_CODE = "*";

	public static final String REPORT_FLAG = "1-0-0-0-0";

	public final static String POINT = ".";

	public static final String PDF_FILE_POSTFIX = "pdf";

	public static final String EXCEL_FILE_POSTFIX = "xls";

	public static final String HTML_FILE_POSTFIX = "html";

	public static final String XMLJ_FILE_POSTFIX = "xml";

	public static final String RTF_FILE_POSTFIX = "rtf";

	public static final String CSV_FILE_POSTFIX = "csv";

	public static final String REPORT_PROPERTY_REPORT_GEN_PATH = "reportGenPath";

	public static final String REPORT_PROPERTY_JASPER_FILE_PATH = "reportJasperFilePath";
	public static final String REPORT_LOACL_DATA_PARAMGROUP = "LOCDATA";
	public static final String REPORT_REMOTE_DATA_PARAMGROUP="REMODATA";
}
