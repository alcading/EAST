package com.huateng.report.bop.collection.operation;

import resource.bean.report.MtsBopEqDs;

import com.huateng.common.log.HtLog;
import com.huateng.common.log.HtLogFactory;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.report.bop.collection.service.BopEqDsUpdateService;

public class BopEqDsOperation extends BaseOperation {
	
	private static final HtLog htlog = HtLogFactory.getLogger(BopEqDsOperation.class);
	public static final String ID = "com.huateng.report.bop.collection.operation.BopEqDsOperation";
	public static final String CMD = "CMD";
	
	public static final String OP_E_NEW = "OP_E_NEW";
	public static final String OP_E_MOD = "OP_E_MOD";
	public static final String OP_E_DEL = "OP_E_DEL";
	
	public static final String OP_Q_NEW = "OP_Q_NEW";
	public static final String OP_Q_MOD = "OP_Q_MOD";
	public static final String OP_Q_DEL = "OP_Q_DEL";
	
	public static final String IN_E_NEW = "IN_E_NEW";
	public static final String IN_E_MOD = "IN_E_MOD";
	public static final String IN_E_DEL = "IN_E_DEL";
	
	public static final String IN_Q_NEW = "IN_Q_NEW";
	public static final String IN_Q_MOD = "IN_Q_MOD";
	public static final String IN_Q_DEL = "IN_Q_DEL";

	@Override
	public void beforeProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub

	}

	@Override
	public void execute(OperationContext context) throws CommonException {
		GlobalInfo gi = GlobalInfo.getCurrentInstance();
		String cmd = (String) context.getAttribute(CMD);
		BopEqDsUpdateService bopEqDsUpdateService = BopEqDsUpdateService.getInstance();
		if (OP_E_NEW.equals(cmd)) {
			MtsBopEqDs bopEqDs = (MtsBopEqDs) context.getAttribute(IN_E_NEW);
			bopEqDsUpdateService.saveBopEqDs(bopEqDs, OP_E_NEW);
			gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"境内汇款申请书—基础信息新增"});
			htlog.info("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"境内汇款申请书—基础信息新增"});
		} else if (OP_E_MOD.equals(cmd)) {
			MtsBopEqDs bopEqDs = (MtsBopEqDs) context.getAttribute(IN_E_MOD);
			bopEqDsUpdateService.saveBopEqDs(bopEqDs, OP_E_MOD);
			gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"境内汇款申请书—基础信息修改"});
			htlog.info("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"境内汇款申请书—基础信息修改"});
		} else if (OP_E_DEL.equals(cmd)) {
			MtsBopEqDs bopEqDs = (MtsBopEqDs) context.getAttribute(IN_E_DEL);
			bopEqDsUpdateService.saveBopEqDs(bopEqDs, OP_E_DEL);
			gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"境内汇款申请书—基础信息删除"});
			htlog.info("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"境内汇款申请书—基础信息删除"});
		} else if (OP_Q_NEW.equals(cmd)) {
			MtsBopEqDs bopEqDs = (MtsBopEqDs) context.getAttribute(IN_Q_NEW);
			bopEqDsUpdateService.saveBopEqDs(bopEqDs, OP_Q_NEW);
			gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"境内汇款申请书—管理信息新增"});
			htlog.info("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"境内汇款申请书—管理信息新增"});
		} else if (OP_Q_MOD.equals(cmd)) {
			MtsBopEqDs bopEqDs = (MtsBopEqDs) context.getAttribute(IN_Q_MOD);
			bopEqDsUpdateService.saveBopEqDs(bopEqDs, OP_Q_MOD);
			gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"境内汇款申请书—管理信息修改"});
			htlog.info("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"境内汇款申请书—管理信息修改"});
		} else if (OP_Q_DEL.equals(cmd)) {
			MtsBopEqDs bopEqDs = (MtsBopEqDs) context.getAttribute(IN_Q_DEL);
			bopEqDsUpdateService.saveBopEqDs(bopEqDs, OP_Q_DEL);
			gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"境内汇款申请书—管理信息删除"});
			htlog.info("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"境内汇款申请书—管理信息删除"});
		}
	}

	@Override
	public void afterProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub

	}

}
