package com.huateng.report.operation;

import java.util.List;

import resource.bean.report.BopAccDs;

import com.huateng.common.log.HtLog;
import com.huateng.common.log.HtLogFactory;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.report.service.BopAccDsService;

public class BopAccDsOperation extends BaseOperation {
	private static final HtLog htlog = HtLogFactory.getLogger(BopAccDsOperation.class);
	public static final String ID = "dataCollection.BopAccDsOperation";
	public static final String CMD = "CMD";
	public static final String OP_AD_NEW="OP_AD_NEW";
	public static final String OP_AD_MOD = "OP_AD_MOD";
	public static final String OP_AD_DEL = "OP_AD_DEL";
	public static final String OP_INOUT_NEW = "OP_INOUT_NEW";
	public static final String OP_INOUT_MOD = "OP_INOUT_MOD";
	public static final String OP_INOUT_DEL = "OP_INOUT_DEL";
	public static final String IN_AD_NEW = "IN_AD_NEW";
	public static final String IN_AD_MOD = "IN_AD_MOD";
	public static final String IN_AD_DEL = "IN_AD_DEL";
	public static final String IN_INOUT_NEW = "IN_INOUT_NEW";
	public static final String IN_INOUT_MOD = "IN_INOUT_MOD";
	public static final String IN_INOUT_DEL = "IN_INOUT_DEL";

	public static final String OP_AD_AUDIT = "OP_AD_AUDIT";
	public static final String OP_INOUT_AUDIT = "OP_INOUT_AUDIT";
	public static final String IN_AUDIT_LIST = "IN_AUDIT_LIST";
	public static final String IN_AUDIT_RESULT = "IN_AUDIT_RESULT";
	public static final String IN_AUDIT_STATUS = "IN_AUDIT_STATUS";

	public void beforeProc(OperationContext context) throws CommonException {
	}

	@SuppressWarnings("unchecked")
	public void execute(OperationContext context) throws CommonException {
		GlobalInfo gi = GlobalInfo.getCurrentInstance();
		String cmd = (String) context.getAttribute(CMD);
		BopAccDsService bopAccDsService = BopAccDsService.getInstance();
		if (OP_AD_NEW.equals(cmd)) {
			BopAccDs bopAccDs =  (BopAccDs) context.getAttribute(IN_AD_NEW);
			bopAccDsService.saveAccDs(bopAccDs, OP_AD_NEW);
			gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"外汇开关账户信息新增"});
			htlog.info("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"外汇开关账户信息新增"});
		} else if (OP_AD_MOD.equals(cmd)) {
			BopAccDs bopAccDs =  (BopAccDs) context.getAttribute(IN_AD_MOD);
			bopAccDsService.saveAccDs(bopAccDs, OP_AD_MOD);
			gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"外汇开关账户信息修改"});
			htlog.info("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"外汇开关账户信息修改"});
		} else if (OP_AD_DEL.equals(cmd)) {
			BopAccDs bopAccDs =  (BopAccDs) context.getAttribute(IN_AD_DEL);
			bopAccDsService.saveAccDs(bopAccDs, OP_AD_DEL);
			gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"外汇开关账户信息删除"});
			htlog.info("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"外汇开关账户信息删除"});
		} else if (OP_INOUT_NEW.equals(cmd)) {
			BopAccDs bopAccDs =  (BopAccDs) context.getAttribute(IN_INOUT_NEW);
			bopAccDsService.saveAccDs(bopAccDs, OP_INOUT_NEW);
			gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"外汇账户收支余信息新增"});
			htlog.info("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"外汇账户收支余信息新增"});
		} else if (OP_INOUT_MOD.equals(cmd)) {
			BopAccDs bopAccDs =  (BopAccDs) context.getAttribute(IN_INOUT_MOD);
			bopAccDsService.saveAccDs(bopAccDs, OP_INOUT_MOD);
			gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"外汇账户收支余信息修改"});
			htlog.info("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"外汇账户收支余信息修改"});
		} else if (OP_INOUT_DEL.equals(cmd)) {
			BopAccDs bopAccDs =  (BopAccDs) context.getAttribute(IN_INOUT_DEL);
			bopAccDsService.saveAccDs(bopAccDs, OP_INOUT_DEL);
			gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"外汇账户收支余信息删除"});
			htlog.info("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"外汇账户收支余信息删除"});
		} else if (OP_AD_AUDIT.equals(cmd)) {
			List<BopAccDs> bopAccDsList = (List<BopAccDs>) context.getAttribute(IN_AUDIT_LIST);
			String approveStatusChoose = (String) context.getAttribute(IN_AUDIT_STATUS);
			String approveResultChoose = (String) context.getAttribute(IN_AUDIT_RESULT);
			bopAccDsService.auditAccDs(approveStatusChoose, approveResultChoose, bopAccDsList, OP_AD_AUDIT);
			gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"外汇账户开关信息审核"});
			htlog.info("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"外汇账户开关信息审核"});
		} else if (OP_INOUT_AUDIT.equals(cmd)) {
			List<BopAccDs> bopAccDsList = (List<BopAccDs>) context.getAttribute(IN_AUDIT_LIST);
			String approveStatusChoose = (String) context.getAttribute(IN_AUDIT_STATUS);
			String approveResultChoose = (String) context.getAttribute(IN_AUDIT_RESULT);
			bopAccDsService.auditAccDs(approveStatusChoose, approveResultChoose, bopAccDsList, OP_INOUT_AUDIT);
			gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"外汇账户收支余信息审核"});
			htlog.info("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"外汇账户收支余信息审核"});
		}
	}

	public void afterProc(OperationContext context) throws CommonException {
	}
}