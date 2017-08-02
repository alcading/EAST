package com.huateng.report.service;

import com.huateng.common.log.HtLog;

import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;
import com.huateng.report.common.service.ReportCommonService;
import com.huateng.report.constants.TopReportConstants;

public class BOPForDebtCommonChangInfoService {
	/**
	 * 用于外债变动信息 做日志
	 * @author cwenao
	 * @version 1.0
	 * @date 2012-8-28
	 * */
	public static final String OPR_ADD="01";
	public static final String OPR_DEL="00";
	public static final String OPR_MOD="01";
	private static final String DATASET_ID="com.huateng.report.service.BOPForDebtCommonChangInfoService";
	

	public synchronized static BOPForDebtCommonChangInfoService getInstance() {
		
		return (BOPForDebtCommonChangInfoService) ApplicationContextUtils.getBean(DATASET_ID);
		
	}
	
	
	public String  commonLogInfo(String debtFieldType,String oprType,String colOrNot) throws CommonException 
	{
		
		/*
		AA  外债双边贷款—变动信息
		AB  外债买方信贷—变动信息
		AC  外债境外同业拆借—变动信息
		AD  外债海外代付—变动信息
		AE  外债卖出回购—变动信息
		AF  外债远期信用证—变动信息
		AG  外债银团贷款—变动信息
		AH  外债贵金属拆借—变动信息
		AI  外债其他贷款—变动信息
		AJ  外债货币市场工具—变动信息
		*/

		
		StringBuffer descInfo =new StringBuffer("");
		if("Y".equalsIgnoreCase(colOrNot))
		{
			if(OPR_ADD.equalsIgnoreCase(oprType))
			{
				descInfo.append("补录/编辑");
			}else if(OPR_DEL.equalsIgnoreCase(oprType))
			{
				descInfo.append("执行删除");
			}else if(OPR_MOD.equalsIgnoreCase(oprType))
			{
				descInfo.append("执行修改");
			}
		}
		
		
		if(TopReportConstants.REPORT_FILE_TYPE_CFA_AA.equalsIgnoreCase(debtFieldType))
		{
			descInfo.append("外债信息双边贷款变动信息");
		}else if(TopReportConstants.REPORT_FILE_TYPE_CFA_AB.equalsIgnoreCase(debtFieldType))
		{
			descInfo.append("外债信息买方信贷变动信息");
		}else if(TopReportConstants.REPORT_FILE_TYPE_CFA_AC.equalsIgnoreCase(debtFieldType))
		{
			descInfo.append("外债信息境外同业拆借变动信息");
		}else if(TopReportConstants.REPORT_FILE_TYPE_CFA_AD.equalsIgnoreCase(debtFieldType))
		{
			descInfo.append("外债信息海外代付变动信息");
		}else if(TopReportConstants.REPORT_FILE_TYPE_CFA_AE.equalsIgnoreCase(debtFieldType))
		{
			descInfo.append("外债信息卖出回购变动信息");
		}else if(TopReportConstants.REPORT_FILE_TYPE_CFA_AF.equalsIgnoreCase(debtFieldType))
		{
			descInfo.append("外债信息远期信用证变动信息");
		}else if(TopReportConstants.REPORT_FILE_TYPE_CFA_AG.equalsIgnoreCase(debtFieldType))
		{
			descInfo.append("外债信息银团贷款变动信息");
		}else if(TopReportConstants.REPORT_FILE_TYPE_CFA_AH.equalsIgnoreCase(debtFieldType))
		{
			descInfo.append("外债信息贵金属拆借变动信息");
		}else if(TopReportConstants.REPORT_FILE_TYPE_CFA_AI.equalsIgnoreCase(debtFieldType))
		{
			descInfo.append("外债信息其他贷款变动信息");
		}else if(TopReportConstants.REPORT_FILE_TYPE_CFA_AJ.equalsIgnoreCase(debtFieldType))
		{
			descInfo.append("外债信息货币市场工具变动信息");
		}
		
		if("N".equalsIgnoreCase(colOrNot))
		{
			descInfo.append("审核");
		}
		
		return descInfo.toString();
	}
	
	public void insertLogInfo (GlobalInfo gi,HtLog htLog,String debtFieldType,String oprType,String colOrNot) throws CommonException 
	{
		String logInfo = commonLogInfo( debtFieldType, oprType,colOrNot);
		
		gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),logInfo});
		htLog.info("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),logInfo});
		
	}
	
	public void reportCommonService(String apptype, String currentfile,String changId,String debtFieldType,String oprType) throws CommonException
	{
		String logInfo="";
		String op="";
		logInfo = commonLogInfo( debtFieldType, oprType,"Y");
		if(OPR_ADD.equalsIgnoreCase(oprType) || OPR_MOD.equalsIgnoreCase(oprType) )
		{
			op = "补录/编辑";
		}else if(OPR_DEL.equalsIgnoreCase(oprType))
		{
			op = "D-删除";
		}
		
		//数据处理记录表 
		ReportCommonService reportCommonService = ReportCommonService.getInstance();
		
		reportCommonService.saveBiDataProcessLog(apptype,currentfile,changId, TopReportConstants.REPORT_BUSITYPE_BOP, oprType,op,logInfo);
		
	}
	
	

}
