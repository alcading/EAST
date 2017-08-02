package com.huateng.report.operation;

import java.util.List;

import resource.bean.report.BopCfaExdebtDs;

import com.huateng.common.log.HtLog;
import com.huateng.common.log.HtLogFactory;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.report.constants.TopReportConstants;
import com.huateng.report.service.BOPForDebtBilLoanService;
import com.huateng.report.service.BOPForDebtCommonChangInfoService;


/**
 * 
 * 外债信息 - 双边贷款 - 签约信息 Operation, 用于update delete insert
 * @author wenhao.chen
 * @version 1.0
 * 2012-8-30
 * 
 * */


public class BOPForDebtChangeInfoOperation extends BaseOperation {


	public static final String ID = "BOPForDebtChangeInfoOperation";
	private static final HtLog htLog = HtLogFactory.getLogger(BOPForDebtBuyerLoanOperation.class);
    
	//外债信息表cmd
	public static final String CMD = "CMD";
	//项目信息表cmd - insert delete update
	public static final String PROJECT_INSERT_CMD = "PROJECT_INSERT_CMD";
	public static final String PROJECT_DELETE_CMD = "PROJECT_DELETE_CMD";
	public static final String PROJECT_UPDATE_CMD = "PROJECT_UPDATE_CMD";
	
	public static final String CMD_QUERY = "CMD_QUERY";
	public static final String CMD_INSERT = "CMD_INSERT";
	public static final String CMD_UPDATE = "CMD_UPDATE";
	public static final String CMD_DELETE = "CMD_DELETE";
	//外债信息表、债权人 param
	public static final String IN_PARAM_EXDEBT = "IN_PARAM_EXDEBT";
	public static final String IN_PARAM_BCC = "IN_PARAM_BCC";
	
	//项目信息表 param
	public static final String IN_PARAM_BPINFO_INSERT = "IN_PARAM_BPINFO_INSERT";
	public static final String IN_PARAM_BPINFO_DEL = "IN_PARAM_BPINFO_DEL";
	public static final String IN_PARAM_BPINFO_MOD = "IN_PARAM_BPINFO_MOD";
	
	//Log - Opr
	public static final String OPR_ADD="01";
	public static final String OPR_DEL="00";
	public static final String OPR_MOD="01";
	
	public static final String OP_CHANG_AUDIT = "OP_CHANG_AUDIT";
	
	public static final String IN_AUDIT_LIST = "IN_AUDIT_LIST";
	public static final String IN_AUDIT_RESULT = "IN_AUDIT_RESULT";
	public static final String IN_AUDIT_STATUS = "IN_AUDIT_STATUS";
	
	//文件类型
	public static final String IN_FIELD_TYPE="IN_FIELD_TYPE";
	
	
	@Override
	public void afterProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub

	}

	@Override
	public void execute(OperationContext context) throws CommonException {

		String cmd = (String)context.getAttribute(CMD);
		
		String fieldType = (String)context.getAttribute(IN_FIELD_TYPE); 

		//外债信息表
		BopCfaExdebtDs bpExdebt = (BopCfaExdebtDs) context.getAttribute(IN_PARAM_EXDEBT);
		
		//获得Service对象
		BOPForDebtBilLoanService bpDebtService = BOPForDebtBilLoanService.getInstance();
		
		
		//BOPForDebtCommonChangInfoServcie
		BOPForDebtCommonChangInfoService bopDebtCommon = BOPForDebtCommonChangInfoService.getInstance();
		
		//变动信息需要对  外债信息表 ：BOP_CFA_EXDEBT_DS, 项目信息表 :BOP_PROJECT_INFO,债权人信息表 :BOP_CFA_CREDITOR_DS 进行处理
		
		//变动信息  - 外债信息表 ,债权人信息表 update insert delete
		if(CMD_INSERT.equalsIgnoreCase(cmd))
		{
			GlobalInfo gi = GlobalInfo.getCurrentInstance();
			bpDebtService.save(bpExdebt);
			
			bopDebtCommon.reportCommonService(bpExdebt.getApptype(), bpExdebt.getCurrentfile(), bpExdebt.getId(), fieldType, TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_EDIT);
			bopDebtCommon.insertLogInfo(gi, htLog,fieldType , OPR_ADD,"Y");
			
		}else if(CMD_UPDATE.equalsIgnoreCase(cmd))
		{
			GlobalInfo gi = GlobalInfo.getCurrentInstance();
			
			if(!(TopReportConstants.REPORT_RECSTATUS_02.equalsIgnoreCase( bpExdebt.getRecStatus()) || TopReportConstants.REPORT_RECSTATUS_01.equalsIgnoreCase( bpExdebt.getRecStatus())) )
			{				
				ExceptionUtil.throwCommonException("不能修改当前签约信息记录,当前记录状态为    "+bpExdebt.getRecStatus()+"" );
			}
			
			bpDebtService.update(bpExdebt);
			
			bopDebtCommon.reportCommonService(bpExdebt.getApptype(), bpExdebt.getCurrentfile(), bpExdebt.getId(), fieldType, TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_EDIT);
			bopDebtCommon.insertLogInfo(gi, htLog,fieldType , OPR_ADD,"Y");
	
		}else if(CMD_DELETE.equalsIgnoreCase(cmd))
		{
			GlobalInfo gi = GlobalInfo.getCurrentInstance();
			
			if(!(TopReportConstants.REPORT_RECSTATUS_02.equalsIgnoreCase( bpExdebt.getRecStatus()) || TopReportConstants.REPORT_RECSTATUS_01.equalsIgnoreCase( bpExdebt.getRecStatus())) )
			{				
				ExceptionUtil.throwCommonException("不能删除当前签约信息记录,当前记录状态为    "+bpExdebt.getRecStatus()+"" );
			}

			bpDebtService.delete(bpExdebt);
			bopDebtCommon.reportCommonService(bpExdebt.getApptype(), bpExdebt.getCurrentfile(), bpExdebt.getId(), fieldType, TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_DEL);
			
			bopDebtCommon.insertLogInfo(gi, htLog,fieldType , OPR_ADD,"Y");
		}
		else if (OP_CHANG_AUDIT.equals(cmd)) {
			
			GlobalInfo gi = GlobalInfo.getCurrentInstance();
			List<BopCfaExdebtDs> bopCfaExdebtDsList = (List<BopCfaExdebtDs>) context.getAttribute(IN_AUDIT_LIST);
			String approveStatusChoose = (String) context.getAttribute(IN_AUDIT_STATUS);
			String approveResultChoose = (String) context.getAttribute(IN_AUDIT_RESULT);
			
			bpDebtService.auditBopCfaExdebtDs(approveStatusChoose, approveResultChoose, bopCfaExdebtDsList, OP_CHANG_AUDIT);
			
			bopDebtCommon.insertLogInfo(gi, htLog,fieldType , OPR_ADD,"Y");
			
			
		}
	}

}
