package com.huateng.report.bop.audit.operation;

import java.util.List;

import resource.bean.report.MtsBopEqDs;

import com.huateng.common.log.HtLog;
import com.huateng.common.log.HtLogFactory;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.report.bop.audit.service.BopEqDsAuditService;
import com.huateng.report.constants.TopReportConstants;

public class BopEqDsAuditOperation extends BaseOperation {
	
	public static final HtLog htLog = HtLogFactory.getLogger(BopEqDsAuditOperation.class);
	
	public static final String ID = "com.huateng.report.bop.audit.operation.BopEqDsAuditOperation";
	
	public static final String CMD = "CMD";
	public static final String OP_E_AUDIT = "OP_E_AUDIT";
	public static final String OP_Q_AUDIT = "OP_Q_AUDIT";
	public static final String IN_AUDIT_LIST = "IN_AUDIT_LIST";
	public static final String IN_AUDIT_RESULT = "IN_AUDIT_RESULT";
	public static final String IN_AUDIT_STATUS = "IN_AUDIT_STATUS";


	@Override
	public void beforeProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub

	}

	@Override
	public void execute(OperationContext context) throws CommonException {
		GlobalInfo gi = GlobalInfo.getCurrentInstance();
		String cmd = (String) context.getAttribute(CMD);
		BopEqDsAuditService service = BopEqDsAuditService.getInstance();
		List<MtsBopEqDs> bopEqDsList = (List<MtsBopEqDs>) context.getAttribute(IN_AUDIT_LIST);
		String approveStatusChoose = (String) context.getAttribute(IN_AUDIT_STATUS);
		String approveResultChoose = (String) context.getAttribute(IN_AUDIT_RESULT);
		
		if (OP_E_AUDIT.equals(cmd)) {
			service.auditBopEqDs(TopReportConstants.REPORT_FILE_TYPE_BOP_E, bopEqDsList, approveStatusChoose, approveResultChoose);
			gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrcode(), "境内汇款申请书基础信息审核"});
		    htLog.info("Updater.log", new String[]{gi.getBrcode(),gi.getTlrno(), "境内汇款申请书基础信息审核"});
		} else if(OP_Q_AUDIT.equals(cmd)) {
			service.auditBopEqDs(TopReportConstants.REPORT_FILE_TYPE_BOP_Q, bopEqDsList, approveStatusChoose, approveResultChoose);
			gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrcode(), "境内汇款申请书管理信息审核"});
		    htLog.info("Updater.log", new String[]{gi.getBrcode(),gi.getTlrno(), "境内汇款申请书管理信息审核"});
		}
	}

	@Override
	public void afterProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub

	}

}
