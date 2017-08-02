package com.huateng.report.operation;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import com.huateng.common.log.HtLog;
import com.huateng.common.log.HtLogFactory;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.report.bean.BopForDebtFeiOrgSave;
import com.huateng.report.service.BopForDebtYinTuanService;

public class BopForCorAndAffOrgContactOperation extends BaseOperation {
	private static final HtLog htlog = HtLogFactory.getLogger(BopForCorAndAffOrgContactOperation.class);
	public static final String ID = "dataCollection.BopForCorAndAffOrgContactOperation";
	public static final String CMD = "CMD";
	public static final String OP_SIGNED_NEW = "OP_SIGNED_NEW";
	public static final String OP_SIGNED_MOD = "OP_SIGNED_MOD";
	public static final String OP_SIGNED_DEL = "OP_SIGNED_DEL";
	public static final String OP_OVER_NEW = "OP_OVER_NEW";
	public static final String OP_OVER_MOD = "OP_OVER_MOD";
	public static final String OP_OVER_DEL = "OP_OVER_DEL";
	public static final String IN_SIGNED_FEIORGSAVE = "IN_SIGNED_FEIORGSAVE";
	public static final String OP_SIGNED_AUDIT = "OP_SIGNED_AUDIT";
	public static final String IN_AUDIT_LIST = "IN_AUDIT_LIST";
	public static final String IN_AUDIT_STATUS = "IN_AUDIT_STATUS";
	public static final String IN_AUDIT_RESULT = "IN_AUDIT_RESULT";
	public static final String OP_OVER_AUDIT = "OP_OVER_AUDIT";
	
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
		if (OP_SIGNED_AUDIT.equals(cmd)) {
			List<BopForDebtFeiOrgSave> list = (List<BopForDebtFeiOrgSave>) context.getAttribute(IN_AUDIT_LIST);
			List<String> ids = new ArrayList<String>();
			for(BopForDebtFeiOrgSave feiOrgSave : list){
				ids.add(feiOrgSave.getId());
			}
			String approveStatusChoose = (String) context.getAttribute(IN_AUDIT_STATUS);
			String approveResultChoose = (String) context.getAttribute(IN_AUDIT_RESULT);
			bopForDebtYinTuanService.auditFeiOrgSave(approveStatusChoose, approveResultChoose, ids, OP_SIGNED_AUDIT);
			gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"境外联行及附属机构往来信息审核"});
			htlog.info("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"境外联行及附属机构往来信息审核"});
		} else if (OP_OVER_AUDIT.equals(cmd)) {
			List<BopForDebtFeiOrgSave> list = (List<BopForDebtFeiOrgSave>) context.getAttribute(IN_AUDIT_LIST);
			List<String> ids = new ArrayList<String>();
			for(BopForDebtFeiOrgSave cfaExdebtDs : list){
				ids.add(cfaExdebtDs.getId());
			}
			String approveStatusChoose = (String) context.getAttribute(IN_AUDIT_STATUS);
			String approveResultChoose = (String) context.getAttribute(IN_AUDIT_RESULT);
			bopForDebtYinTuanService.auditFeiOrgSave(approveStatusChoose, approveResultChoose, ids, OP_SIGNED_AUDIT);
			gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"境外联行及附属机构往来余额信息审核"});
			htlog.info("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"境外联行及附属机构往来余额信息审核"});
		} else {
			BopForDebtFeiOrgSave debtFeiOrgSave = (BopForDebtFeiOrgSave) context.getAttribute(IN_SIGNED_FEIORGSAVE);
			try {
				bopForDebtYinTuanService.saveCorOrgContact(cmd, debtFeiOrgSave);
			} catch (IllegalAccessException e) {
				ExceptionUtil.throwCommonException("实体属性拷贝错误"); 
			} catch (InvocationTargetException e) {
				ExceptionUtil.throwCommonException("实体属性拷贝错误"); 
			}
			if (OP_SIGNED_NEW.equals(cmd)) {
				gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"境外联行及附属机构往来信息新增"});
				htlog.info("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"境外联行及附属机构信往来息新增"});
			} else if (OP_SIGNED_MOD.equals(cmd)) {
				gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"境外联行及附属机构往来信息修改"});
				htlog.info("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"境外联行及附属机构信往来息修改"});
			} else if (OP_SIGNED_DEL.equals(cmd)) {
				gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"境外联行及附属机构往来信息删除"});
				htlog.info("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"境外联行及附属机构信往来息删除"});
			} else if (OP_OVER_NEW.equals(cmd)) {
				gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"境外联行及附属机构往来余额信息新增"});
				htlog.info("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"境外联行及附属机构往来余额信息新增"});
			} else if (OP_OVER_MOD.equals(cmd)) {
				gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"境外联行及附属机构往来余额信息修改"});
				htlog.info("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"境外联行及附属机构往来余额信息修改"});
			} else if (OP_OVER_DEL.equals(cmd)) {
				gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"境外联行及附属机构往来余额信息删除"});
				htlog.info("Updater.log", new String[]{gi.getTlrno(),gi.getBrno(),"境外联行及附属机构余往来额信息删除"});
			}
		}
	}

	@Override
	public void afterProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub

	}

}
