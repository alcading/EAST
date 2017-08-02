package com.huateng.report.bop.collection.operation;

import resource.bean.report.MtsBopAgDs;

import com.huateng.common.log.HtLog;
import com.huateng.common.log.HtLogFactory;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.report.bop.collection.service.BopAgDsUpdateService;

public class BopAgDsOperation extends BaseOperation {
	
	private static final HtLog htlog = HtLogFactory.getLogger(BopAgDsOperation.class);
	public static final String ID = "com.huateng.report.bop.collection.operation.BopAgDsOperation";
	public static final String CMD = "CMD";
	
	public static final String OP_A_NEW = "OP_A_NEW";
	public static final String OP_A_MOD = "OP_A_MOD";
	public static final String OP_A_DEL = "OP_A_DEL";
	
	public static final String OP_G_NEW = "OP_G_NEW";
	public static final String OP_G_MOD = "OP_G_MOD";
	public static final String OP_G_DEL = "OP_G_DEL";
	
	public static final String IN_A_NEW = "IN_A_NEW";
	public static final String IN_A_MOD = "IN_A_MOD";
	public static final String IN_A_DEL = "IN_A_DEL";
	
	public static final String IN_G_NEW = "IN_G_NEW";
	public static final String IN_G_MOD = "IN_G_MOD";
	public static final String IN_G_DEL = "IN_G_DEL";
	
	@Override
	public void beforeProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub

	}

	@Override
	public void execute(OperationContext context) throws CommonException {
		GlobalInfo gi = GlobalInfo.getCurrentInstance();
		String cmd = (String) context.getAttribute(CMD);
		BopAgDsUpdateService bopAgDsUpdateService = BopAgDsUpdateService.getInstance();
		if (OP_A_NEW.equals(cmd)) {
			MtsBopAgDs bopAgDs = (MtsBopAgDs) context.getAttribute(IN_A_NEW);
			bopAgDsUpdateService.saveBopAgDs(bopAgDs, OP_A_NEW);
			gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"涉外收入申报单—基础信息新增"});
			htlog.info("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"涉外收入申报单—基础信息新增"});
		} else if (OP_A_MOD.equals(cmd)) {
			MtsBopAgDs bopAgDs = (MtsBopAgDs) context.getAttribute(IN_A_MOD);
			bopAgDsUpdateService.saveBopAgDs(bopAgDs, OP_A_MOD);
			gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"涉外收入申报单—基础信息修改"});
			htlog.info("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"涉外收入申报单—基础信息修改"});
		} else if (OP_A_DEL.equals(cmd)) {
			MtsBopAgDs bopAgDs = (MtsBopAgDs) context.getAttribute(IN_A_DEL);
			bopAgDsUpdateService.saveBopAgDs(bopAgDs, OP_A_DEL);
			gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"涉外收入申报单—基础信息删除"});
			htlog.info("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"涉外收入申报单—基础信息删除"});
		} else if (OP_G_NEW.equals(cmd)) {
			MtsBopAgDs bopAgDs = (MtsBopAgDs) context.getAttribute(IN_G_NEW);
			bopAgDsUpdateService.saveBopAgDs(bopAgDs, OP_G_NEW);
			gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"涉外收入申报单—申报信息新增"});
			htlog.info("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"涉外收入申报单—申报信息新增"});
		} else if (OP_G_MOD.equals(cmd)) {
			MtsBopAgDs bopAgDs = (MtsBopAgDs) context.getAttribute(IN_G_MOD);
			bopAgDsUpdateService.saveBopAgDs(bopAgDs, OP_G_MOD);
			gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"涉外收入申报单—申报信息修改"});
			htlog.info("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"涉外收入申报单—申报信息修改"});
		} else if (OP_G_DEL.equals(cmd)) {
			MtsBopAgDs bopAgDs = (MtsBopAgDs) context.getAttribute(IN_G_DEL);
			bopAgDsUpdateService.saveBopAgDs(bopAgDs, OP_G_DEL);
			gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"涉外收入申报单—申报信息删除"});
			htlog.info("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"涉外收入申报单—申报信息删除"});
		}
	}

	@Override
	public void afterProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub

	}
}
