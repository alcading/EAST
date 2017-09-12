package com.huateng.report.operation;

import java.util.List;

import resource.bean.report.BopCfaCreditorDs;
import resource.bean.report.BopCfaExdebtDs;
import resource.bean.report.BopProjectInfo;

import com.huateng.common.log.HtLog;
import com.huateng.common.log.HtLogFactory;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.report.service.BopForDebtYinTuanService;

public class BopForDebtYinTuanOperation extends BaseOperation {
	private static final HtLog htlog = HtLogFactory.getLogger(BopForDebtYinTuanOperation.class);
	public static final String ID = "dataCollection.BopForDebtYinTuanOperation";
	public static final String CMD = "CMD";
	public static final String OP_SIGNED_NEW = "OP_SIGNED_NEW";
	public static final String OP_SIGNED_MOD = "OP_SIGNED_MOD";
	public static final String OP_SIGNED_DEL = "OP_SIGNED_DEL";
	public static final String OP_CHANGE_NEW = "OP_CHANGE_NEW";
	public static final String OP_CHANGE_MOD = "OP_CHANGE_MOD";
	public static final String OP_CHANGE_DEL = "OP_CHANGE_DEL";
	public static final String IN_SIGNED_DEBTBEAN = "IN_SIGNED_DEBTBEAN";
	public static final String IN_SIGNED_PRONEW="IN_SIGNED_PRONEW";
	public static final String IN_SIGNED_PROMOD = "IN_SIGNED_PROMOD";
	public static final String IN_SIGNED_PRODEL = "IN_SIGNED_PRODEL";
	public static final String IN_SIGNED_CRENEW = "IN_SIGNED_CRENEW";
	public static final String IN_SIGNED_CREDEL = "IN_SIGNED_CREDEL";
	public static final String IN_SIGNED_CREMOD = "IN_SIGNED_CREMOD";
	public static final String OP_SIGNED_AUDIT = "OP_SIGNED_AUDIT";
	public static final String OP_CHANGE_AUDIT = "OP_CHANGE_AUDIT";
	public static final String IN_AUDIT_LIST = "IN_AUDIT_LIST";
	public static final String IN_AUDIT_STATUS = "IN_AUDIT_STATUS";
	public static final String IN_AUDIT_RESULT = "IN_AUDIT_RESULT";

	public static final String IN_CHECK_CREDITOR = "IN_CHECK_CREDITOR";
	public static final String IN_CHECK_PROJECT = "IN_CHECK_PROJECT";

	@Override
	public void beforeProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub

	}

	@SuppressWarnings("unchecked")
	@Override
	public void execute(OperationContext context) throws CommonException {
		GlobalInfo gi = GlobalInfo.getCurrentInstance();
		String cmd = (String) context.getAttribute(CMD);
		BopForDebtYinTuanService bopForDebtYinTuanService = BopForDebtYinTuanService.getInstance();
		if(OP_SIGNED_AUDIT.equals(cmd)) {
			List<BopCfaExdebtDs> list = (List<BopCfaExdebtDs>) context.getAttribute(IN_AUDIT_LIST);
			String approveStatusChoose = (String) context.getAttribute(IN_AUDIT_STATUS);
			String approveResultChoose = (String) context.getAttribute(IN_AUDIT_RESULT);
			bopForDebtYinTuanService.auditYinTuan(approveStatusChoose, approveResultChoose, list, OP_SIGNED_AUDIT);
			gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"银团贷款签约信息审核"});
			htlog.info("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"银团贷款签约信息审核"});
		} else if (OP_CHANGE_AUDIT.equals(cmd)) {
			List<BopCfaExdebtDs> list = (List<BopCfaExdebtDs>) context.getAttribute(IN_AUDIT_LIST);
			String approveStatusChoose = (String) context.getAttribute(IN_AUDIT_STATUS);
			String approveResultChoose = (String) context.getAttribute(IN_AUDIT_RESULT);
			bopForDebtYinTuanService.auditYinTuan(approveStatusChoose, approveResultChoose, list, OP_CHANGE_AUDIT);
			gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"银团贷款变动信息审核"});
			htlog.info("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"银团贷款变动信息审核"});
		} else {
			BopCfaExdebtDs bopCfaExdebtDs = (BopCfaExdebtDs) context.getAttribute(IN_SIGNED_DEBTBEAN);
			List<BopProjectInfo> proNewList = (List<BopProjectInfo>) context.getAttribute(IN_SIGNED_PRONEW);
			List<BopProjectInfo> proModList = (List<BopProjectInfo>) context.getAttribute(IN_SIGNED_PROMOD);
			List<BopProjectInfo> proDelList = (List<BopProjectInfo>) context.getAttribute(IN_SIGNED_PRODEL);
			List<BopCfaCreditorDs> creNewList = (List<BopCfaCreditorDs>) context.getAttribute(IN_SIGNED_CRENEW);
			List<BopCfaCreditorDs> creModList = (List<BopCfaCreditorDs>) context.getAttribute(IN_SIGNED_CREMOD);
			List<BopCfaCreditorDs> creDelList = (List<BopCfaCreditorDs>) context.getAttribute(IN_SIGNED_CREDEL);

			List<BopCfaCreditorDs> checkCreditorList = (List<BopCfaCreditorDs>) context.getAttribute(IN_CHECK_CREDITOR);
			List<BopProjectInfo> checkProjectList = (List<BopProjectInfo>) context.getAttribute(IN_CHECK_PROJECT);
			bopCfaExdebtDs.setCreditors(checkCreditorList);
			bopCfaExdebtDs.setProjects(checkProjectList);

			bopForDebtYinTuanService.saveDebtYinTuan(cmd, bopCfaExdebtDs, proNewList, proModList, proDelList, creNewList, creModList, creDelList);
			if (OP_SIGNED_NEW.equals(cmd)) {
				gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"银团贷款签约信息新增"});
				htlog.info("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"银团贷款签约信息新增"});
			} else if (OP_SIGNED_MOD.equals(cmd)) {
				gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"银团贷款签约信息修改"});
				htlog.info("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"银团贷款签约信息修改"});
			} else if (OP_SIGNED_DEL.equals(cmd)) {
				gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"银团贷款签约信息删除"});
				htlog.info("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"银团贷款签约信息删除"});
			} else if (OP_CHANGE_NEW.equals(cmd)) {
				gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"银团贷款变动信息新增"});
				htlog.info("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"银团贷款变动信息新增"});
			} else if (OP_CHANGE_MOD.equals(cmd)) {
				gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"银团贷款变动信息修改"});
				htlog.info("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"银团贷款变动信息修改"});
			} else if (OP_CHANGE_DEL.equals(cmd)) {
				gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"银团贷款变动信息删除"});
				htlog.info("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"银团贷款变动信息删除"});
			}
		}
	}

	public void afterProc(OperationContext context) throws CommonException {
	}
}