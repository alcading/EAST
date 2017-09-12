package com.huateng.report.jsh.audit.operation;

import java.util.List;

import resource.bean.report.MtsJshDefgDs;

import com.huateng.common.log.HtLog;
import com.huateng.common.log.HtLogFactory;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.report.jsh.audit.service.JshDfDsAuditService;

public class JshDfDsAuditOperation extends BaseOperation {
	
	private static final HtLog htlog = HtLogFactory.getLog(JshDfDsAuditOperation.class);
	
	public static final String ID = "JshDfDsAuditOperation";
	public static final String BASIC_AUDIT_LIST_IN_PARAM = "BASIC_AUDIT_LIST_IN_PARAM";
	public static final String MANAGE_AUDIT_LIST_IN_PARAM = "MANAGE_AUDIT_LIST_IN_PARAM";
	public static final String CMD = "CMD";
	public static final String CMD_BASIC_AUDIT = "CMD_BASIC_AUDIT";
	public static final String CMD_MANAGE_AUDIT = "CMD_MANAGE_AUDIT";
	public static final String AUDIT_STATUS = "AUDIT_STATUS";
	public static final String AUDIT_RESULT = "AUDIT_RESULT";
	
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
		JshDfDsAuditService service = JshDfDsAuditService.getInstance();
		GlobalInfo globalInfo = GlobalInfo.getCurrentInstance();
		if(CMD_BASIC_AUDIT.equals(cmd)) {
			//基础信息审核
			List<MtsJshDefgDs> mtsJshDefgDsList = (List<MtsJshDefgDs>) context.getAttribute(BASIC_AUDIT_LIST_IN_PARAM);
			service.basic_audit(mtsJshDefgDsList,approveStatusChoose,approveResultChoose);
			globalInfo.addBizLog("Updater.log", new String[]{globalInfo.getTlrno(),globalInfo.getBrcode(),"外汇账户内结汇基础信息审核"});
			htlog.info("Updater.log",new String[]{globalInfo.getTlrno(),globalInfo.getBrno(),"外汇账户内结汇基础信息审核"});
		} else if(CMD_MANAGE_AUDIT.equals(cmd)) {
			//申报信息审核
			List<MtsJshDefgDs> mtsJshDefgDsList = (List<MtsJshDefgDs>) context.getAttribute(MANAGE_AUDIT_LIST_IN_PARAM);
			service.manage_audit(mtsJshDefgDsList,approveStatusChoose,approveResultChoose);
			globalInfo.addBizLog("Updater.log", new String[]{globalInfo.getTlrno(),globalInfo.getBrcode(),"外汇账户内结汇管理信息审核"});
			htlog.info("Updater.log",new String[]{globalInfo.getTlrno(),globalInfo.getBrno(),"外汇账户内结汇管理信息审核"});
		} 
	}

	@Override
	public void afterProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub
		
	}

}
