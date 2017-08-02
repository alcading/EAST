package com.huateng.report.operation;

import java.util.List;

import resource.bean.report.BopCfaLounexguDs;

import com.huateng.common.log.HtLog;
import com.huateng.common.log.HtLogFactory;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.report.common.service.ReportCommonService;
import com.huateng.report.service.BOPCfaLounexguRecordService;

public class BOPCfaLounexguRecordVerOperation  extends BaseOperation{
	private static final HtLog htLog = HtLogFactory.getLogger(BopAccDsOperation.class);
	public static final String ID="BOPCfaLounexguRecordVerOperation";
	public static final String CMD = "CMD";
	public static final String CMD_QUERY = "CMD_QUERY";
	public static final String CMD_INSERT = "CMD_INSERT";
	public static final String CMD_UPDATE = "CMD_UPDATE";
	public static final String CMD_DELETE = "CMD_DELETE";
	
	public static final String CMD_AUDIT = "CMD_AUDIT";
	public static final String CMD_CHANGE_AUDIT = "CMD_CHANGE_AUDIT";
	
	public static final String IN_AUDIT_LIST = "IN_AUDIT_LIST";
	public static final String IN_AUDIT_CHANGE_LIST = "IN_AUDIT_CHANGE_LIST";
	public static final String IN_AUDIT_STATUS = "IN_AUDIT_STATUS";
	public static final String IN_AUDIT_RESULT = "IN_AUDIT_RESULT";
	public static final String IN_PARAM = "IN_PARAM";
	
	@Override
	public void beforeProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void execute(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub
		GlobalInfo gi = GlobalInfo.getCurrentInstance();
		String cmd = (String) context.getAttribute(CMD);
		String approveStatusChoose  = (String)context.getAttribute(IN_AUDIT_STATUS);
		String approveResultChoose  = (String)context.getAttribute(IN_AUDIT_RESULT);
		BOPCfaLounexguRecordService  bopLounexguRecordService = BOPCfaLounexguRecordService.getInstance();
		ReportCommonService reportCommonService = ReportCommonService.getInstance();
		GlobalInfo gb = GlobalInfo.getCurrentInstance();
		String creditorcode = gb.getBrno();
		if(CMD_AUDIT.equals(cmd)){
			List<BopCfaLounexguDs> list = (List<BopCfaLounexguDs>) context.getAttribute(IN_AUDIT_LIST);
			bopLounexguRecordService.auditBean(list, approveStatusChoose, approveResultChoose, CMD_AUDIT);
			gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrcode(),"境外担保境内贷款签约信息审核"});
			htLog.info("Updater.log", new String[]{gi.getBrcode(),gi.getTlrno(),"境外担保境内贷款签约信息审核"});
		}else if(CMD_CHANGE_AUDIT.equals(cmd)){
			List<BopCfaLounexguDs> list = (List<BopCfaLounexguDs>) context.getAttribute(IN_AUDIT_CHANGE_LIST);
			bopLounexguRecordService.auditBean(list, approveStatusChoose, approveResultChoose, CMD_CHANGE_AUDIT);
			gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrcode(),"境外担保境内贷款变动信息审核"});
			htLog.info("Updater.log", new String[]{gi.getBrcode(),gi.getTlrno(),"境外担保境内贷款变动信息审核"});
		}
			
	}

	@Override
	public void afterProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub
		
	}

}
