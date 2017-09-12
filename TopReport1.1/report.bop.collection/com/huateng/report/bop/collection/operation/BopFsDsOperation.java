package com.huateng.report.bop.collection.operation;

import java.util.ArrayList;
import java.util.List;

import resource.bean.report.MtsBopFsDs;

import com.huateng.common.log.HtLog;
import com.huateng.common.log.HtLogFactory;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.report.bop.collection.service.BopFsDsService;

public class BopFsDsOperation extends BaseOperation {
	private static final HtLog htlog = HtLogFactory.getLogger(BopFsDsOperation.class);
	public static final String ID = "collandaudit.BopFsDsOperation";
	public static final String CMD = "CMD";
	public static final String OP_F_NEW = "OP_F_NEW";
	public static final String IN_F_NEW = "IN_F_NEW";
	public static final String OP_F_MOD = "OP_F_MOD";
	public static final String IN_F_MOD = "IN_F_MOD";
	public static final String OP_F_DEL = "OP_F_DEL";
	public static final String IN_F_DEL = "IN_F_DEL";
	public static final String OP_S_NEW = "OP_S_NEW";
	public static final String IN_S_NEW = "IN_S_NEW";
	public static final String OP_S_MOD = "OP_S_MOD";
	public static final String IN_S_MOD = "IN_S_MOD";
	public static final String OP_S_DEL = "OP_S_DEL";
	public static final String IN_S_DEL = "IN_S_DEL";
	
	public static final String OP_F_AUDIT = "OP_F_AUDIT";
	public static final String OP_S_AUDIT = "OP_S_AUDIT";
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
		BopFsDsService bopCkpDsService = BopFsDsService.getInstance();
		if (OP_F_NEW.equals(cmd)) {
			MtsBopFsDs bopFsDs =  (MtsBopFsDs) context.getAttribute(IN_F_NEW);
			bopCkpDsService.saveFsDs(bopFsDs, OP_F_NEW);
			gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"境内付款/承兑通知书基础信息新增"});
			htlog.info("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"境内付款/承兑通知书基础信息新增"});
		} else if (OP_F_MOD.equals(cmd)){
			MtsBopFsDs bopFsDs =  (MtsBopFsDs) context.getAttribute(IN_F_MOD);
			bopCkpDsService.saveFsDs(bopFsDs, OP_F_MOD);
			gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"境内付款/承兑通知书基础信息修改"});
			htlog.info("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"境内付款/承兑通知书基础信息修改"});
		} else if (OP_F_DEL.equals(cmd)) {
			MtsBopFsDs bopFsDs =  (MtsBopFsDs) context.getAttribute(IN_F_DEL);
			bopCkpDsService.saveFsDs(bopFsDs, OP_F_DEL);
			gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"境内付款/承兑通知书基础信息删除"});
			htlog.info("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"境内付款/承兑通知书基础信息删除"});
		} else if (OP_S_NEW.equals(cmd)) {
			MtsBopFsDs bopFsDs =  (MtsBopFsDs)context.getAttribute(IN_S_NEW);
			bopCkpDsService.saveFsDs(bopFsDs, OP_S_NEW);
			gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"境内付款/承兑通知书管理信息新增"});
			htlog.info("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"境内付款/承兑通知书管理信息新增"});
		} else if (OP_S_MOD.equals(cmd)){
			MtsBopFsDs bopFsDs =  (MtsBopFsDs) context.getAttribute(IN_S_MOD);
			bopCkpDsService.saveFsDs(bopFsDs, OP_S_MOD);
			gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"境内付款/承兑通知书管理信息修改"});
			htlog.info("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"境内付款/承兑通知书管理信息修改"});
		} else if (OP_S_DEL.equals(cmd)) {
			MtsBopFsDs bopFsDs =  (MtsBopFsDs) context.getAttribute(IN_S_DEL);
			bopCkpDsService.saveFsDs(bopFsDs, OP_S_DEL);
			gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"境内付款/承兑通知书管理信息删除"});
			htlog.info("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"境内付款/承兑通知书管理信息删除"});
		} else if(OP_F_AUDIT.equals(cmd) || OP_S_AUDIT.equals(cmd)){
			List<MtsBopFsDs> list = (List<MtsBopFsDs>) context.getAttribute(IN_AUDIT_LIST);
			List<String> ids = new ArrayList<String>();
			for(MtsBopFsDs bopFsDs : list){
				ids.add(bopFsDs.getId());
			}
			String approveStatusChoose = (String) context.getAttribute(IN_AUDIT_STATUS);
			String approveResultChoose = (String) context.getAttribute(IN_AUDIT_RESULT);
			bopCkpDsService.auditBopFsDs(approveStatusChoose, approveResultChoose, ids, cmd);
			if(OP_F_AUDIT.equals(cmd)){
				gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"境内付款/承兑通知书基础信息审核"});
				htlog.info("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"境内付款/承兑通知书基础信息审核"});
			} else {
				gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"境内付款/承兑通知书管理信息审核"});
				htlog.info("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"境内付款/承兑通知书基管理息审核"});
			}
		}
	}

	@Override
	public void afterProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub

	}

}
