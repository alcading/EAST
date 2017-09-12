package com.huateng.report.operation;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import resource.bean.report.BopCfaExplbalainfo;
import resource.bean.report.BopCfaExplrmbloDs;

import com.huateng.common.log.HtLog;
import com.huateng.common.log.HtLogFactory;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.report.common.service.ReportCommonService;
import com.huateng.report.constants.TopReportConstants;
import com.huateng.report.service.BopCfaExplrmbloDsService;
import com.huateng.report.service.BopCfaExplbalainfoService;

public class BopCfaExplrmbloDsOperation extends BaseOperation {

	private static final HtLog htlog = HtLogFactory.getLogger(BopCfaExplrmbloDsOperation.class);

	public final static String ID = "BopCfaExplrmbloDsOperation";
	public static final String CMD = "CMD";
	public static final String CMD_QUERY = "CMD_QUERY";
	public static final String CMD_INSERT = "CMD_INSERT";
	public static final String CMD_UPDATE = "CMD_UPDATE";
	public static final String CMD_DELETE = "CMD_DELETE";
	public static final String CMD_APPROVED = "CMD_APPROVED";
	public static final String IN_PARAM = "IN_PARAM";

	public static final String OPERATION_INSERT = "new";
	public static final String OPERATION_MODIFY = "mod";
	public static final String OPERATION_DELETE = "del";
	public static final String OPERATION_DETAIL = "detail";

	public static final String IN_PARAM_NEW_LIST = "IN_PARAM_NEW_List";
	public static final String IN_PARAM_MOD_LIST = "IN_PARAM_MOD_List";
	public static final String IN_PARAM_DEL_LIST = "IN_PARAM_DEL_List";


	@SuppressWarnings("unchecked")
	@Override
	public void execute(OperationContext context) throws CommonException {

		String cmd = (String) context.getAttribute(CMD);

		BopCfaExplrmbloDsService service = BopCfaExplrmbloDsService.getInstance();
		ReportCommonService logservice = ReportCommonService.getInstance();
		BopCfaExplbalainfoService explbalainfoservice = BopCfaExplbalainfoService.getInstance();

		List<BopCfaExplbalainfo> saveList = (List<BopCfaExplbalainfo>) context.getAttribute(IN_PARAM_NEW_LIST);
		List<BopCfaExplbalainfo> updateList = (List<BopCfaExplbalainfo>) context.getAttribute(IN_PARAM_MOD_LIST);
		List<BopCfaExplbalainfo> deleteList = (List<BopCfaExplbalainfo>) context.getAttribute(IN_PARAM_DEL_LIST);

		GlobalInfo gi = GlobalInfo.getCurrentInstance();
        
		if (StringUtils.equals(CMD_INSERT, cmd)) {
			
			BopCfaExplrmbloDs bopcfa = (BopCfaExplrmbloDs) context.getAttribute(IN_PARAM);
			bopcfa.setExplbalainfos(saveList);
			service.save(bopcfa);

			List<BopCfaExplbalainfo> explbalainfoList = (List<BopCfaExplbalainfo>) context.getAttribute(IN_PARAM_NEW_LIST);
			explbalainfoservice.save(bopcfa, explbalainfoList);

			logservice.saveBiDataProcessLog(bopcfa.getApptype(), bopcfa
					.getCurrentfile(), bopcfa.getId(), null, TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_EDIT, "新增", "新增 外汇质押人民币贷款签约信息 ID : " + bopcfa.getId());

			gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrcode(),"外汇质押人民币贷款签约信息新增"});
			htlog.info("Updater.log", new String[]{gi.getBrcode(),gi.getTlrno(),"外汇质押人民币贷款签约信息新增"});

		} else if (StringUtils.equals(CMD_UPDATE, cmd)) {
			BopCfaExplrmbloDs bopcfa = (BopCfaExplrmbloDs) context.getAttribute(IN_PARAM);
			bopcfa.setExplbalainfos(updateList);
			service.update(bopcfa);

			explbalainfoservice.save(bopcfa, saveList);

			explbalainfoservice.update(updateList);

			explbalainfoservice.delete(deleteList);

			logservice.saveBiDataProcessLog(bopcfa.getApptype(), bopcfa
					.getCurrentfile(), bopcfa.getId(), null, TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_EDIT, "修改", "修改 外汇质押人民币贷款签约信息 ID : " + bopcfa.getId());

			gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrcode(),"外汇质押人民币贷款签约信息修改"});
			htlog.info("Updater.log", new String[]{gi.getBrcode(),gi.getTlrno(),"外汇质押人民币贷款签约信息修改"});

		} else if (StringUtils.equals(CMD_DELETE, cmd)) {
			BopCfaExplrmbloDs bopcfa = (BopCfaExplrmbloDs) context.getAttribute(IN_PARAM);

			service.delete(bopcfa);

//			explbalainfoservice.deleteAll(bopcfa.getId());

			logservice.saveBiDataProcessLog(bopcfa.getApptype(), bopcfa
					.getCurrentfile(), bopcfa.getId(), null, TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_DEL, "删除", "删除 外汇质押人民币贷款签约信息 ID : " + bopcfa.getId());

			gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrcode(),"外汇质押人民币贷款签约信息删除"});
			htlog.info("Updater.log", new String[]{gi.getBrcode(),gi.getTlrno(),"外汇质押人民币贷款签约信息删除"});

		} else if (StringUtils.equals(CMD_APPROVED, cmd)) {
			List<BopCfaExplrmbloDs> list = (List<BopCfaExplrmbloDs>) context
					.getAttribute(IN_PARAM);
			service.approved(list);
			for (BopCfaExplrmbloDs dofoexlodds : list) {
				logservice.saveBiDataProcessLog(dofoexlodds.getApptype(), dofoexlodds
						.getCurrentfile(), dofoexlodds.getId(), null, TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_AUDIT, "审核", "审核 外汇质押人民币贷款签约信息 ID : " + dofoexlodds.getId());
			}

			gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrcode(),"外汇质押人民币贷款签约信息审核"});
			htlog.info("Updater.log", new String[]{gi.getBrcode(),gi.getTlrno(),"外汇质押人民币贷款签约信息审核"});

		}

	}

	@Override
	public void afterProc(OperationContext context) throws CommonException {
	}

	@Override
	public void beforeProc(OperationContext context) throws CommonException {
	}

}