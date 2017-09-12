package com.huateng.report.bop.audit.operation;

import java.util.List;

import resource.bean.report.MtsBopBhnDs;

import com.huateng.common.log.HtLog;
import com.huateng.common.log.HtLogFactory;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.report.bop.audit.service.BopBhnDsAuditService;

public class BopBhnDsAuditOperation extends BaseOperation {
	
	private static final HtLog htlog = HtLogFactory.getLogger(BopBhnDsAuditOperation.class);
	
	public static final String ID = "BopBhnDsAuditOperation";
	public static final String BASIC_AUDIT_LIST_IN_PARAM = "BASIC_AUDIT_LIST_IN_PARAM";
	public static final String REPORT_AUDIT_LIST_IN_PARAM = "REPORT_AUDIT_LIST_IN_PARAM";
	public static final String MANAGE_AUDIT_LIST_IN_PARAM = "MANAGE_AUDIT_LIST_IN_PARAM";
	public static final String AUDIT_STATUS = "AUDIT_STATUS";
	public static final String AUDIT_RESULT = "AUDIT_RESULT";
	public static final String CMD = "CMD";
	public static final String CMD_BAIS_AUDIT = "CMD_BAIS_AUDIT";
	public static final String CMD_REPORT_AUDIT = "CMD_REPORT_AUDIT";
	public static final String CMD_MANAGE_AUDIT = "CMD_MANAGE_AUDIT";


	@Override
	public void beforeProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void execute(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub
		String cmd = (String) context.getAttribute(CMD);
		String approveStatusChoose = (String) context.getAttribute(AUDIT_STATUS);
		String approveResultChoose = (String) context.getAttribute(AUDIT_RESULT);
		BopBhnDsAuditService service = BopBhnDsAuditService.getInstance();
		GlobalInfo globalInfo = GlobalInfo.getCurrentInstance();
		if(CMD_BAIS_AUDIT.equals(cmd)) {
			//基础信息审核
			List<MtsBopBhnDs> mtsBopBhnDsList = (List<MtsBopBhnDs>) context.getAttribute(BASIC_AUDIT_LIST_IN_PARAM);
			service.basic_audit(mtsBopBhnDsList,approveStatusChoose,approveResultChoose);
			globalInfo.addBizLog("Updater.log", new String[]{globalInfo.getTlrno(),globalInfo.getBrcode(),"境外汇款申请书基础信息审核"});
			htlog.info("Updater.log",new String[]{globalInfo.getTlrno(),globalInfo.getBrno(),"境外汇款申请书基础信息审核"});
		} else if(CMD_REPORT_AUDIT.equals(cmd)) {
			//申报信息审核
			List<MtsBopBhnDs> mtsBopBhnDsList = (List<MtsBopBhnDs>) context.getAttribute(REPORT_AUDIT_LIST_IN_PARAM);
			service.report_audit(mtsBopBhnDsList,approveStatusChoose,approveResultChoose);
			globalInfo.addBizLog("Updater.log", new String[]{globalInfo.getTlrno(),globalInfo.getBrcode(),"境外汇款申请书申报信息审核"});
			htlog.info("Updater.log",new String[]{globalInfo.getTlrno(),globalInfo.getBrno(),"境外汇款申请书申报信息审核"});
		} else if(CMD_MANAGE_AUDIT.equals(cmd)) {
			//管理信息审核
			List<MtsBopBhnDs> mtsBopBhnDsList = (List<MtsBopBhnDs>) context.getAttribute(MANAGE_AUDIT_LIST_IN_PARAM);
			service.manage_audit(mtsBopBhnDsList,approveStatusChoose,approveResultChoose);
			globalInfo.addBizLog("Updater.log", new String[]{globalInfo.getTlrno(),globalInfo.getBrcode(),"境外汇款申请书管理信息审核"});
			htlog.info("Updater.log",new String[]{globalInfo.getTlrno(),globalInfo.getBrno(),"境外汇款申请书管理信息审核"});
		}
	}

	@Override
	public void afterProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub
		
	}

}
