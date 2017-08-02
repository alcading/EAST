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

public class BOPForDebtBalanceInfoOperation extends  BaseOperation{

	public static final String ID = "BOPForDebtBalanceInfoOperation";
	private static final HtLog htLog = HtLogFactory.getLogger(BOPForDebtBuyerLoanOperation.class);
	//外债信息表cmd
	public static final String CMD = "CMD";

	public static final String CMD_QUERY = "CMD_QUERY";
	public static final String CMD_INSERT = "CMD_INSERT";
	public static final String CMD_UPDATE = "CMD_UPDATE";
	public static final String CMD_DELETE = "CMD_DELETE";

	public static final String  PARAM_BALANCE = "PARAM_BALANCE";

	public static final String OP_BALANCE_AUDIT = "OP_BALANCE_AUDIT";

	public static final String IN_AUDIT_LIST = "IN_AUDIT_LIST";
	public static final String IN_AUDIT_RESULT = "IN_AUDIT_RESULT";
	public static final String IN_AUDIT_STATUS = "IN_AUDIT_STATUS";

	public void afterProc(OperationContext context) throws CommonException {
	}

	public void beforeProc(OperationContext context) throws CommonException {
	}

	@SuppressWarnings("unchecked")
	public void execute(OperationContext context) throws CommonException {

		String cmd = (String)context.getAttribute(CMD);
		//获得Service对象
		BOPForDebtBilLoanService bpDebtService = BOPForDebtBilLoanService.getInstance();

		if(CMD_INSERT.equalsIgnoreCase(cmd))
		{
			GlobalInfo gi = GlobalInfo.getCurrentInstance();
			//外债信息表
			BopCfaExdebtDs bpExdebt = (BopCfaExdebtDs) context.getAttribute(PARAM_BALANCE);
			bpDebtService.save(bpExdebt);
			gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrcode(),"变动信息新增"});
			htLog.info("Updater.log", new String[]{gi.getBrcode(),gi.getTlrno(),"变动信息新增"});

		}else if(CMD_UPDATE.equalsIgnoreCase(cmd))
		{
			GlobalInfo gi = GlobalInfo.getCurrentInstance();

			//外债信息表
			BopCfaExdebtDs bpExdebt = (BopCfaExdebtDs) context.getAttribute(PARAM_BALANCE);

			if(!(TopReportConstants.REPORT_RECSTATUS_02.equalsIgnoreCase( bpExdebt.getRecStatus()) || TopReportConstants.REPORT_RECSTATUS_01.equalsIgnoreCase( bpExdebt.getRecStatus())) )
			{
				ExceptionUtil.throwCommonException("不能修改当前签约信息记录,当前记录状态为    "+bpExdebt.getRecStatus()+"" );
			}
			bpDebtService.update(bpExdebt);
			gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrcode(),"变动信息新增"});
			htLog.info("Updater.log", new String[]{gi.getBrcode(),gi.getTlrno(),"变动信息新增"});
		}else if(CMD_DELETE.equalsIgnoreCase(cmd))
		{
			GlobalInfo gi = GlobalInfo.getCurrentInstance();
			//外债信息表
			BopCfaExdebtDs bpExdebt = (BopCfaExdebtDs) context.getAttribute(PARAM_BALANCE);
			if(!(TopReportConstants.REPORT_RECSTATUS_02.equalsIgnoreCase( bpExdebt.getRecStatus()) || TopReportConstants.REPORT_RECSTATUS_01.equalsIgnoreCase( bpExdebt.getRecStatus())) )
			{
				ExceptionUtil.throwCommonException("不能删除当前签约信息记录,当前记录状态为    "+bpExdebt.getRecStatus()+"" );
			}
			bpDebtService.delete(bpExdebt);
			gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrcode(),"变动信息新增"});
			htLog.info("Updater.log", new String[]{gi.getBrcode(),gi.getTlrno(),"变动信息新增"});
		}
		else if (OP_BALANCE_AUDIT.equals(cmd)) {

			GlobalInfo gi = GlobalInfo.getCurrentInstance();
			List<BopCfaExdebtDs> bopCfaExdebtDsList = (List<BopCfaExdebtDs>) context.getAttribute(IN_AUDIT_LIST);
			String approveStatusChoose = (String) context.getAttribute(IN_AUDIT_STATUS);
			String approveResultChoose = (String) context.getAttribute(IN_AUDIT_RESULT);

			bpDebtService.auditBopCfaExdebtDs(approveStatusChoose, approveResultChoose, bopCfaExdebtDsList, null);

			gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrcode(),"变动信息新增"});
			htLog.info("Updater.log", new String[]{gi.getBrcode(),gi.getTlrno(),"变动信息新增"});
		}
	}
}
