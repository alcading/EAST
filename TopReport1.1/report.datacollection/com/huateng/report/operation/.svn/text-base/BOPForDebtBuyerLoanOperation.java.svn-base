package com.huateng.report.operation;


import java.util.Iterator;
import java.util.List;

import resource.bean.report.BopCfaCreditorDs;
import resource.bean.report.BopCfaExdebtDs;
import resource.bean.report.BopProjectInfo;

import com.huateng.common.log.HtLog;
import com.huateng.common.log.HtLogFactory;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.report.common.service.ReportCommonService;
import com.huateng.report.constants.TopReportConstants;
import com.huateng.report.service.BOPForDebtBilLoanService;
import com.huateng.report.service.BOPForDebtChangeInfoService;
import com.huateng.report.service.BOPForDebtProjectService;
import com.huateng.report.service.BopCfaCreditorDsService;


/**
 *
 * 外债信息 - 双边买方信贷 - 签约信息 Operation, 用于update delete insert
 * @author wenhao.chen
 * @version 1.0
 * 2012-8-30
 *
 * */


public class BOPForDebtBuyerLoanOperation extends BaseOperation {

	public static final HtLog htLog = HtLogFactory.getLogger(BOPForDebtBuyerLoanOperation.class);
	public static final String ID = "BOPForDebtBuyerLoanOperation";
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

	//双边贷款签约信息审核
	public static final String OP_LOAN_AUDIT = "OP_LOAN_AUDIT";
	public static final String OP_CHANG_AUDIT = "OP_CHANG_AUDIT";
	public static final String IN_AUDIT_LIST = "IN_AUDIT_LIST";
	public static final String IN_AUDIT_RESULT = "IN_AUDIT_RESULT";
	public static final String IN_AUDIT_STATUS = "IN_AUDIT_STATUS";

	//项目信息表 param
	public static final String IN_PARAM_BPINFO_INSERT = "IN_PARAM_BPINFO_INSERT";
	public static final String IN_PARAM_BPINFO_DEL = "IN_PARAM_BPINFO_DEL";
	public static final String IN_PARAM_BPINFO_MOD = "IN_PARAM_BPINFO_MOD";

	private static final HtLog htlog = HtLogFactory.getLogger(BOPForDebtBuyerLoanOperation.class);


	@Override
	public void afterProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub

	}

	@SuppressWarnings("unchecked")
	public void execute(OperationContext context) throws CommonException {
		GlobalInfo gi = GlobalInfo.getCurrentInstance();
		String cmd = (String)context.getAttribute(CMD);
		String projectInsertCmd = (String)context.getAttribute(PROJECT_INSERT_CMD);
		String projectDeleteCmd = (String)context.getAttribute(PROJECT_DELETE_CMD);
		String projectUpdateCmd = (String)context.getAttribute(PROJECT_UPDATE_CMD);
		//外债信息表
		BopCfaExdebtDs bpExdebt = (BopCfaExdebtDs) context.getAttribute(IN_PARAM_EXDEBT);
		//债权人信息表
		BopCfaCreditorDs bcc =  (BopCfaCreditorDs) context.getAttribute(IN_PARAM_BCC);
		//项目信息表
		//BopProjectInfo bpInfo =  null;

		//一个外债主键对应多个项目记录
		List<BopProjectInfo> delProjectList = (List<BopProjectInfo>)context.getAttribute(IN_PARAM_BPINFO_DEL);
		List<BopProjectInfo> inserProjecttList = (List<BopProjectInfo>)context.getAttribute(IN_PARAM_BPINFO_INSERT);
		List<BopProjectInfo> updateProjecttList = (List<BopProjectInfo>)context.getAttribute(IN_PARAM_BPINFO_MOD);

		//获得Service对象
		BopCfaCreditorDsService bccService = BopCfaCreditorDsService.getInstance();
		BOPForDebtBilLoanService bpDebtService = BOPForDebtBilLoanService.getInstance();
		BOPForDebtProjectService bpProjectService = BOPForDebtProjectService.getInstance();

		BOPForDebtChangeInfoService bopDebtChInfo= BOPForDebtChangeInfoService.getInstance();

		BopProjectInfo projectinfo = new BopProjectInfo();

		//数据处理记录表
		ReportCommonService reportCommonService = ReportCommonService.getInstance();


		//买方信贷-签约信息需要对  外债信息表 ：BOP_CFA_EXDEBT_DS, 项目信息表 :BOP_PROJECT_INFO,债权人信息表 :BOP_CFA_CREDITOR_DS 进行处理

		//项目信息的 update insert delete
		if(CMD_INSERT.equalsIgnoreCase(projectInsertCmd))
		{
			for(Iterator<BopProjectInfo> it = inserProjecttList.iterator();it.hasNext();)
			{
				projectinfo = it.next();
				bpProjectService.save(projectinfo);
				reportCommonService.saveBiDataProcessLog(bpExdebt.getApptype(),
						bpExdebt.getCurrentfile(), bpExdebt.getId(), TopReportConstants.REPORT_BUSITYPE_BOP,
						TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_EDIT, "A-创建",
						"创建外债信息买方信贷-签约信息-项目信息        签约信息ID ："+bpExdebt.getId() +"    项目名称："+projectinfo.getProjectname());

				gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"执行创建外债信息买方信贷签约信息项目信息"});
				htLog.info("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"执行创建外债信息买方信贷签约信息项目信息"});
			}
		}
		 if(CMD_UPDATE.equalsIgnoreCase(projectUpdateCmd))
		{
			for(Iterator<BopProjectInfo> it = updateProjecttList.iterator();it.hasNext();)
			{
				projectinfo = it.next();
				bpProjectService.update(projectinfo);
				reportCommonService.saveBiDataProcessLog(bpExdebt.getApptype(),
						bpExdebt.getCurrentfile(), bpExdebt.getId(), TopReportConstants.REPORT_BUSITYPE_BOP,
						TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_EDIT, "C-修改",
						"修改外债信息买方信贷-签约信息-项目信息          签约信息ID ："+bpExdebt.getId() +"    项目名称："+projectinfo.getProjectname());
				gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"执行修改外债信息买方信贷签约信息项目信息"});
				htLog.info("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"执行修改买外债信息方信贷签约信息项目信息"});
			}
		}
		 if(CMD_DELETE.equalsIgnoreCase(projectDeleteCmd))
		{
			for(Iterator<BopProjectInfo> it = delProjectList.iterator();it.hasNext();)
			{
				projectinfo = it.next();
				bpProjectService.delete(projectinfo.getId());
				reportCommonService.saveBiDataProcessLog(bpExdebt.getApptype(),
						bpExdebt.getCurrentfile(), bpExdebt.getId(), TopReportConstants.REPORT_BUSITYPE_BOP,
						TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_DEL, "D-删除",
						"删除外债信息买方信贷-签约信息-项目信息          签约信息ID ："+bpExdebt.getId() +"    项目名称："+projectinfo.getProjectname());

				gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"执行删除外债信息买方信贷签约信息项目信息"});
				htLog.info("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"执行删除外债信息买方信贷签约信息项目信息"});

			}
		}


		//双边贷款-签约信息  - 外债信息表 ,债权人信息表 update insert delete
		if(CMD_INSERT.equalsIgnoreCase(cmd))
		{

			bpDebtService.save(bpExdebt);
			bccService.save(bcc);

			reportCommonService.saveBiDataProcessLog(bpExdebt.getApptype(), bpExdebt.getCurrentfile(), bpExdebt.getId(),
					TopReportConstants.REPORT_BUSITYPE_BOP, TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_EDIT,
					"A-创建","创建外债信息买方信贷-签约信息        签约信息ID ："+bpExdebt.getId());
			gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"执行创建外债信息买方信贷签约信息"});
			htLog.info("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"执行创建外债信息买方信贷签约信息"});

		}else if(CMD_UPDATE.equalsIgnoreCase(cmd))
		{
			if(!(TopReportConstants.REPORT_RECSTATUS_02.equalsIgnoreCase( bpExdebt.getRecStatus()) || TopReportConstants.REPORT_RECSTATUS_01.equalsIgnoreCase( bpExdebt.getRecStatus())) )
			{
				ExceptionUtil.throwCommonException("不能修改当前签约信息记录,当前记录状态为    "+bpExdebt.getRecStatus()+"" );
			}

			bpDebtService.update(bpExdebt);
			bccService.update(bcc);

			reportCommonService.saveBiDataProcessLog(bpExdebt.getApptype(), bpExdebt.getCurrentfile(), bpExdebt.getId(),
					TopReportConstants.REPORT_BUSITYPE_BOP, TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_EDIT,"C-修改",
					"修改外债信息买方信贷-签约信息          签约信息ID ："+bpExdebt.getId());

			gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"执行修改外债信息买方信贷签约信息"});
			htLog.info("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"执行修改买外债信息方信贷签约信息"});

		}else if(CMD_DELETE.equalsIgnoreCase(cmd))
		{
			if(!(TopReportConstants.REPORT_RECSTATUS_02.equalsIgnoreCase( bpExdebt.getRecStatus()) || TopReportConstants.REPORT_RECSTATUS_01.equalsIgnoreCase( bpExdebt.getRecStatus())) )
			{
				ExceptionUtil.throwCommonException("不能删除当前签约信息记录,当前记录状态为    "+bpExdebt.getRecStatus()+"" );
			}

			List<BopCfaExdebtDs> list = bopDebtChInfo.queryChangeInfo(bpExdebt.getId());

			if(!list.isEmpty())
			{
				ExceptionUtil.throwCommonException("无法删除,当前签约信息记录下存在变动信息记录！");
			}

			bpDebtService.delete(bpExdebt);

			reportCommonService.saveBiDataProcessLog(bpExdebt.getApptype(), bpExdebt.getCurrentfile(), bpExdebt.getId(),
					TopReportConstants.REPORT_BUSITYPE_BOP, TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_DEL,
					"D-删除","删除外债信息买方信贷-签约信息          签约信息ID ："+bpExdebt.getId());

			gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"执行删除外债信息买方信贷签约信息"});
			htLog.info("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"执行删除外债信息买方信贷签约信息"});

		}
		else if (OP_LOAN_AUDIT.equals(cmd)) {

			List<BopCfaExdebtDs> bopCfaExdebtDsList = (List<BopCfaExdebtDs>) context.getAttribute(IN_AUDIT_LIST);
			String approveStatusChoose = (String) context.getAttribute(IN_AUDIT_STATUS);
			String approveResultChoose = (String) context.getAttribute(IN_AUDIT_RESULT);
			bpDebtService.auditBopCfaExdebtDs(approveStatusChoose, approveResultChoose, bopCfaExdebtDsList, OP_LOAN_AUDIT);

			gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrcode(),"执行外债信息买方信贷签约信息审核"});
			htlog.info("Updater.log", new String[]{gi.getBrcode(),gi.getTlrno(),"执行外债信息买方信贷签约信息审核"});

		}
	}

}
