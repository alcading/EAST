package com.huateng.report.bop.collection.operation;

import resource.bean.report.MtsBopBhnDs;

import com.huateng.common.log.HtLog;
import com.huateng.common.log.HtLogFactory;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.report.bop.collection.service.BopBhnDsCollService;
import com.huateng.report.operation.BopCfaStrdeDsOperation;

/*
 * 境外汇款申请书
 */
public class BopBhnDsOperation extends BaseOperation {
	
	private static final HtLog htlog = HtLogFactory.getLogger(BopCfaStrdeDsOperation.class);
	
	public static final String ID = "BopBhnDsOperation";
	public static final String IN_PARAM = "IN_PARAM";
	public static final String CMD = "CMD";
	public static final String BASIC_CMD_ADD = "BASIC_CMD_ADD";
	public static final String BASIC_CMD_MOD = "BASIC_CMD_MOD";
	public static final String BASIC_CMD_DEL = "BASIC_CMD_DEL";
	public static final String REPORT_CMD_ADD = "REPORT_CMD_ADD";
	public static final String REPORT_CMD_MOD = "REPORT_CMD_MOD";
	public static final String REPORT_CMD_DEL = "REPORT_CMD_DEL";
	public static final String MANAGE_CMD_ADD = "MANAGE_CMD_ADD";
	public static final String MANAGE_CMD_MOD = "MANAGE_CMD_MOD";
	public static final String MANAGE_CMD_DEL = "MANAGE_CMD_DEL";
	
	@Override
	public void beforeProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void execute(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub
		String cmd = (String) context.getAttribute(CMD);
		MtsBopBhnDs ds = (MtsBopBhnDs) context.getAttribute(IN_PARAM);
		BopBhnDsCollService service = BopBhnDsCollService.getInstance();
		GlobalInfo globalInfo = GlobalInfo.getCurrentInstance();
		//基础信息
		if(BASIC_CMD_ADD.equals(cmd)) {
			service.collBasicAdd(ds);
			globalInfo.addBizLog("Updater.log", new String[]{globalInfo.getTlrno(),globalInfo.getBrcode(),"境外汇款申请书基础信息新增"});
			htlog.info("Updater.log",new String[]{globalInfo.getTlrno(),globalInfo.getBrno(),"境外汇款申请书基础信息新增"});
		} else if (BASIC_CMD_MOD.equals(cmd)) {
			service.collBasicMod(ds);
			globalInfo.addBizLog("Updater.log", new String[]{globalInfo.getTlrno(),globalInfo.getBrcode(),"境外汇款申请书基础信息修改"});
			htlog.info("Updater.log",new String[]{globalInfo.getTlrno(),globalInfo.getBrno(),"境外汇款申请书基础信息修改"});
		} else if(BASIC_CMD_DEL.equals(cmd)) {
			service.collBasicDel(ds);
			globalInfo.addBizLog("Updater.log", new String[]{globalInfo.getTlrno(),globalInfo.getBrcode(),"境外汇款申请书基础信息删除"});
			htlog.info("Updater.log",new String[]{globalInfo.getTlrno(),globalInfo.getBrno(),"境外汇款申请书基础信息删除"});
		} else if(REPORT_CMD_ADD.equals(cmd)) {
			service.collReportAdd(ds);
			globalInfo.addBizLog("Updater.log", new String[]{globalInfo.getTlrno(),globalInfo.getBrcode(),"境外汇款申请书申报信息新增"});
			htlog.info("Updater.log",new String[]{globalInfo.getTlrno(),globalInfo.getBrno(),"境外汇款申请书申报信息新增"});
		} else if(REPORT_CMD_MOD.equals(cmd)) {
			service.collReportMod(ds);
			globalInfo.addBizLog("Updater.log", new String[]{globalInfo.getTlrno(),globalInfo.getBrcode(),"境外汇款申请书申报信息修改"});
			htlog.info("Updater.log",new String[]{globalInfo.getTlrno(),globalInfo.getBrno(),"境外汇款申请书申报信息修改"});
		} else if(REPORT_CMD_DEL.equals(cmd)) {
			service.collReportDel(ds);
			globalInfo.addBizLog("Updater.log", new String[]{globalInfo.getTlrno(),globalInfo.getBrcode(),"境外汇款申请书申报信息删除"});
			htlog.info("Updater.log",new String[]{globalInfo.getTlrno(),globalInfo.getBrno(),"境外汇款申请书申报信息删除"});			
		} else if(MANAGE_CMD_ADD.equals(cmd)) {
			service.collManageAdd(ds);
			globalInfo.addBizLog("Updater.log", new String[]{globalInfo.getTlrno(),globalInfo.getBrcode(),"境外汇款申请书管理信息新增"});
			htlog.info("Updater.log",new String[]{globalInfo.getTlrno(),globalInfo.getBrno(),"境外汇款申请书管理信息新增"});
		} else if(MANAGE_CMD_MOD.equals(cmd)) {
			service.collManageMod(ds);
			globalInfo.addBizLog("Updater.log", new String[]{globalInfo.getTlrno(),globalInfo.getBrcode(),"境外汇款申请书管理信息修改"});
			htlog.info("Updater.log",new String[]{globalInfo.getTlrno(),globalInfo.getBrno(),"境外汇款申请书管理信息修改"});
		} else if(MANAGE_CMD_DEL.equals(cmd)) {
			service.collManageDel(ds);
			globalInfo.addBizLog("Updater.log", new String[]{globalInfo.getTlrno(),globalInfo.getBrcode(),"境外汇款申请书管理信息删除"});
			htlog.info("Updater.log",new String[]{globalInfo.getTlrno(),globalInfo.getBrno(),"境外汇款申请书管理信息删除"});
		}
	}

	@Override
	public void afterProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub
		
	}

}
