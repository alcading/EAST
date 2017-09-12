package com.huateng.report.jsh.audit.operation;

import java.util.List;

import resource.bean.report.MtsJshDefgDs;

import com.huateng.common.log.HtLog;
import com.huateng.common.log.HtLogFactory;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.report.jsh.collection.service.JshEgDsService;

public class JshEgDsAuditOperation extends BaseOperation {
	public static final HtLog htLog = HtLogFactory.getLogger(JshEgDsAuditOperation.class);
	public static final String ID = "JshEgDsAuditOperation";
	public static final String CMD = "CMD";
	public static final String OP_LOAN_AUDIT = "OP_LOAN_AUDIT";
	public static final String IN_AUDIT_LIST = "IN_AUDIT_LIST";
	public static final String IN_AUDIT_STATUS = "IN_AUDIT_STATUS";
	public static final String IN_AUDIT_RESULT = "IN_AUDIT_RESULT";
	public static final String CHOOSE = "CHOOSE";
	public static final String JI_CHU = "JI_CHU";
	public static final String GUAN_LI = "GUAN_LI";

	@Override
	public void beforeProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub
	}
	@Override
	public void execute(OperationContext context) throws CommonException {
		GlobalInfo gi = GlobalInfo.getCurrentInstance();
		String cmd = (String) context.getAttribute(CMD);
		String choose = (String) context.getAttribute(CHOOSE);
		JshEgDsService service = new JshEgDsService();
		
         if (OP_LOAN_AUDIT.equals(cmd)) {		
			List<MtsJshDefgDs> mtsJshDefgDsList = (List<MtsJshDefgDs>) context.getAttribute(IN_AUDIT_LIST);
			String approveStatusChoose = (String) context.getAttribute(IN_AUDIT_STATUS);
			String approveResultChoose = (String) context.getAttribute(IN_AUDIT_RESULT);
			
			service.AuditMtsJshDefgDs(approveStatusChoose, approveResultChoose, mtsJshDefgDsList);
			 if (JI_CHU.equals(choose)){
			    gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrcode(),"执行境内收入申报单基础信息审核"});
			    htLog.info("Updater.log", new String[]{gi.getBrcode(),gi.getTlrno(),"执行境内收入申报单基础信息审核"});
			 }
			 if (GUAN_LI.equals(choose)){
				    gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrcode(),"执行境内收入申报单管理信息审核"});
				    htLog.info("Updater.log", new String[]{gi.getBrcode(),gi.getTlrno(),"执行境内收入申报单管理信息审核"});
				 }			 
		}		
	}
	@Override
	public void afterProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub
	}
}
