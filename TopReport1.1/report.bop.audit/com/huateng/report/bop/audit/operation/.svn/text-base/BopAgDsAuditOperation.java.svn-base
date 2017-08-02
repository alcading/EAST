package com.huateng.report.bop.audit.operation;

import java.util.List;

import resource.bean.report.MtsBopAgDs;

import com.huateng.common.log.HtLog;
import com.huateng.common.log.HtLogFactory;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.report.bop.audit.service.BopAgDsAuditService;
import com.huateng.report.constants.TopReportConstants;

public class BopAgDsAuditOperation extends BaseOperation {
	
	public static final HtLog htLog = HtLogFactory.getLogger(BopAgDsAuditOperation.class);
	
	public static final String ID = "com.huateng.report.bop.audit.operation.BopAgDsAuditOperation";
	
	public static final String CMD = "CMD";
	public static final String OP_A_AUDIT = "OP_A_AUDIT";
	public static final String OP_G_AUDIT = "OP_G_AUDIT";
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
		BopAgDsAuditService service = BopAgDsAuditService.getInstance();
		List<MtsBopAgDs> bopAgDsList = (List<MtsBopAgDs>) context.getAttribute(IN_AUDIT_LIST);
		String approveStatusChoose = (String) context.getAttribute(IN_AUDIT_STATUS);
		String approveResultChoose = (String) context.getAttribute(IN_AUDIT_RESULT);
		
		if (OP_A_AUDIT.equals(cmd)) {
			service.auditBopAgDs(TopReportConstants.REPORT_FILE_TYPE_BOP_A, bopAgDsList, approveStatusChoose, approveResultChoose);
			gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrcode(), "涉外收入申报单基础信息审核"});
		    htLog.info("Updater.log", new String[]{gi.getBrcode(),gi.getTlrno(), "涉外收入申报单基础信息审核"});
		} else if(OP_G_AUDIT.equals(cmd)) {
			service.auditBopAgDs(TopReportConstants.REPORT_FILE_TYPE_BOP_G, bopAgDsList, approveStatusChoose, approveResultChoose);
			gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrcode(), "涉外收入申报单申报信息审核"});
		    htLog.info("Updater.log", new String[]{gi.getBrcode(),gi.getTlrno(), "涉外收入申报单申报信息审核"});
		}
	}

	@Override
	public void afterProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub

	}
}
