package com.huateng.report.operation;

import java.util.List;

import resource.bean.report.BopCfaExguDs;

import com.huateng.common.log.HtLog;
import com.huateng.common.log.HtLogFactory;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.report.service.BopCFAExguDsService;

public class BOPCFAExguInfoAuditOperation extends BaseOperation {
	private static final HtLog htlog = HtLogFactory.getLogger(BOPCFAExguInfoAuditOperation.class);
	public static final HtLog htLog = HtLogFactory.getLogger(BOPForDebtBilLoanOperation.class);
	public static final String ID = "BOPCFAExguInfoAuditOperation";
	public static final String CMD = "CMD";
	public static final String OP_LOAN_AUDIT = "OP_LOAN_AUDIT";
	public static final String IN_AUDIT_LIST = "IN_AUDIT_LIST";
	public static final String IN_AUDIT_STATUS = "IN_AUDIT_STATUS";
	public static final String IN_AUDIT_RESULT = "IN_AUDIT_RESULT";
	public static final String CHOOSE = "CHOOSE";
	public static final String QIAN_YUE = "QIAN_YUE";
	public static final String ZR_YU_E = "ZR_YU_E";
	public static final String LV_MING_XI = "LV_MING_XI";


	@Override
	public void beforeProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub

	}

	@Override
	public void execute(OperationContext context) throws CommonException {
		GlobalInfo gi = GlobalInfo.getCurrentInstance();
		String cmd = (String) context.getAttribute(CMD);
		String choose = (String) context.getAttribute(CHOOSE);
		BopCFAExguDsService serviceExgu = new BopCFAExguDsService();
		
         if (OP_LOAN_AUDIT.equals(cmd)) {
			
			List<BopCfaExguDs> bopCfaExguDsList = (List<BopCfaExguDs>) context.getAttribute(IN_AUDIT_LIST);
			String approveStatusChoose = (String) context.getAttribute(IN_AUDIT_STATUS);
			String approveResultChoose = (String) context.getAttribute(IN_AUDIT_RESULT);
			
			serviceExgu.AuditBopCFAExguDs(approveStatusChoose, approveResultChoose, bopCfaExguDsList);
			 if (QIAN_YUE.equals(choose)){
			    gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrcode(),"执行对外担保签约信息审核"});
			    htLog.info("Updater.log", new String[]{gi.getBrcode(),gi.getTlrno(),"执行对外担保签约信息审核"});
			 }
			 if (ZR_YU_E.equals(choose)){
				    gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrcode(),"执行对外担保责任余额信息审核"});
				    htLog.info("Updater.log", new String[]{gi.getBrcode(),gi.getTlrno(),"执行对外担保保责任余额信息审核"});
				 }
			 if (LV_MING_XI.equals(choose)){
				    gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrcode(),"执行对外担保履约明细审核"});
				    htLog.info("Updater.log", new String[]{gi.getBrcode(),gi.getTlrno(),"执行对外担保履约明细信息审核"});
				 }
		}
		
		
	}

	@Override
	public void afterProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub

	}

}
