package com.huateng.report.bop.collection.operation;

import java.util.ArrayList;
import java.util.List;

import resource.bean.report.MtsBopCkpDs;

import com.huateng.common.log.HtLog;
import com.huateng.common.log.HtLogFactory;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.report.bop.collection.service.BopCkpDsService;

public class BopCkpDsOperation extends BaseOperation {
	private static final HtLog htlog = HtLogFactory.getLogger(BopCkpDsOperation.class);
	public static final String ID = "collandaudit.BopCkpDsOperation";
	public static final String CMD = "CMD";
	public static final String OP_C_NEW = "OP_C_NEW";
	public static final String IN_C_NEW = "IN_C_NEW";
	public static final String OP_C_MOD = "OP_C_MOD";
	public static final String IN_C_MOD = "IN_C_MOD";
	public static final String OP_C_DEL = "OP_C_DEL";
	public static final String IN_C_DEL = "IN_C_DEL";
	public static final String OP_K_NEW = "OP_K_NEW";
	public static final String IN_K_NEW = "IN_K_NEW";
	public static final String OP_K_MOD = "OP_K_MOD";
	public static final String IN_K_MOD = "IN_K_MOD";
	public static final String OP_K_DEL = "OP_K_DEL";
	public static final String IN_K_DEL = "IN_K_DEL";
	public static final String OP_P_NEW = "OP_P_NEW";
	public static final String IN_P_NEW = "IN_P_NEW";
	public static final String OP_P_MOD = "OP_P_MOD";
	public static final String IN_P_MOD = "IN_P_MOD";
	public static final String OP_P_DEL = "OP_P_DEL";
	public static final String IN_P_DEL = "IN_P_DEL";
	
	public static final String OP_C_AUDIT = "OP_C_AUDIT";
	public static final String OP_K_AUDIT = "OP_K_AUDIT";
	public static final String OP_P_AUDIT = "OP_P_AUDIT";
	public static final String IN_AUDIT_LIST = "IN_AUDIT_LIST";
	public static final String IN_AUDIT_STATUS = "IN_AUDIT_STATUS";
	public static final String IN_AUDIT_RESULT = "IN_AUDIT_RESULT";

	@Override
	public void beforeProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub

	}

	@Override
	public void execute(OperationContext context) throws CommonException {
		GlobalInfo gi = GlobalInfo.getCurrentInstance();
		String cmd = (String) context.getAttribute(CMD);
		BopCkpDsService bopCkpDsService = BopCkpDsService.getInstance();
		if (OP_C_NEW.equals(cmd)) {
			MtsBopCkpDs bopCkpDs =  (MtsBopCkpDs) context.getAttribute(IN_C_NEW);
			bopCkpDsService.saveCkpDs(bopCkpDs, OP_C_NEW);
			gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"对外付款/承兑通知书基础信息新增"});
			htlog.info("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"对外付款/承兑通知书基础信息新增"});
		} else if (OP_C_MOD.equals(cmd)){
			MtsBopCkpDs bopCkpDs =  (MtsBopCkpDs) context.getAttribute(IN_C_MOD);
			bopCkpDsService.saveCkpDs(bopCkpDs, OP_C_MOD);
			gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"对外付款/承兑通知书基础信息修改"});
			htlog.info("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"对外付款/承兑通知书基础信息修改"});
		} else if (OP_C_DEL.equals(cmd)) {
			MtsBopCkpDs bopCkpDs =  (MtsBopCkpDs) context.getAttribute(IN_C_DEL);
			bopCkpDsService.saveCkpDs(bopCkpDs, OP_C_DEL);
			gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"对外付款/承兑通知书基础信息删除"});
			htlog.info("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"对外付款/承兑通知书基础信息删除"});
		} else if (OP_K_NEW.equals(cmd)) {
			MtsBopCkpDs bopCkpDs =  (MtsBopCkpDs) context.getAttribute(IN_K_NEW);
			bopCkpDsService.saveCkpDs(bopCkpDs, OP_K_NEW);
			gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"对外付款/承兑通知书申报信息新增"});
			htlog.info("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"对外付款/承兑通知书申报信息新增"});
		} else if (OP_K_MOD.equals(cmd)){
			MtsBopCkpDs bopCkpDs =  (MtsBopCkpDs) context.getAttribute(IN_K_MOD);
			bopCkpDsService.saveCkpDs(bopCkpDs, OP_K_MOD);
			gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"对外付款/承兑通知书申报信息修改"});
			htlog.info("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"对外付款/承兑通知书申报信息修改"});
		} else if (OP_K_DEL.equals(cmd)) {
			MtsBopCkpDs bopCkpDs =  (MtsBopCkpDs) context.getAttribute(IN_K_DEL);
			bopCkpDsService.saveCkpDs(bopCkpDs, OP_K_DEL);
			gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"对外付款/承兑通知书申报信息删除"});
			htlog.info("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"对外付款/承兑通知书申报信息删除"});
		}else if (OP_P_NEW.equals(cmd)) {
			MtsBopCkpDs bopCkpDs =  (MtsBopCkpDs) context.getAttribute(IN_P_NEW);
			bopCkpDsService.saveCkpDs(bopCkpDs, OP_P_NEW);
			gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"对外付款/承兑通知书管理信息新增"});
			htlog.info("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"对外付款/承兑通知书管理信息新增"});
		} else if (OP_P_MOD.equals(cmd)){
			MtsBopCkpDs bopCkpDs =  (MtsBopCkpDs) context.getAttribute(IN_P_MOD);
			bopCkpDsService.saveCkpDs(bopCkpDs, OP_P_MOD);
			gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"对外付款/承兑通知书管理信息修改"});
			htlog.info("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"对外付款/承兑通知书管理信息修改"});
		} else if (OP_P_DEL.equals(cmd)) {
			MtsBopCkpDs bopCkpDs =  (MtsBopCkpDs) context.getAttribute(IN_P_DEL);
			bopCkpDsService.saveCkpDs(bopCkpDs, OP_P_DEL);
			gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"对外付款/承兑通知书管理信息删除"});
			htlog.info("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"对外付款/承兑通知书管理信息删除"});
		} else if(OP_C_AUDIT.equals(cmd) || OP_K_AUDIT.equals(cmd) || OP_P_AUDIT.equals(cmd)){
			List<MtsBopCkpDs> list = (List<MtsBopCkpDs>) context.getAttribute(IN_AUDIT_LIST);
			List<String> ids = new ArrayList<String>();
			for(MtsBopCkpDs bopCkpDs : list){
				ids.add(bopCkpDs.getId());
			}
			String approveStatusChoose = (String) context.getAttribute(IN_AUDIT_STATUS);
			String approveResultChoose = (String) context.getAttribute(IN_AUDIT_RESULT);
			bopCkpDsService.auditBopCkpDs(approveStatusChoose, approveResultChoose, ids, cmd);
			if(OP_C_AUDIT.equals(cmd)){
				gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"对外付款/承兑通知书基础信息审核"});
				htlog.info("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"对外付款/承兑通知书基础信息审核"});
			} else if(OP_K_AUDIT.equals(cmd)){
				gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"对外付款/承兑通知书申报信息审核"});
				htlog.info("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"对外付款/承兑通知书基申报息审核"});
			} else {
				gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"对外付款/承兑通知书管理信息审核"});
				htlog.info("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"对外付款/承兑通知书基管理息审核"});
			}
		}
	}

	@Override
	public void afterProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub

	}

}
