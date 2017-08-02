package com.huateng.report.operation;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import resource.bean.report.BopCfaDofoexloDs;

import com.huateng.common.log.HtLog;
import com.huateng.common.log.HtLogFactory;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.report.common.service.ReportCommonService;
import com.huateng.report.constants.TopReportConstants;
import com.huateng.report.service.BopCfaDofoexloDsService;

public class BopCfaDofoexloDsOperation extends BaseOperation {

	private static final HtLog htlog = HtLogFactory.getLogger(BopCfaDofoexloDsOperation.class);

	public final static String ID = "BopCfaDofoexloDsOperation";
	public static final String CMD = "CMD";
	public static final String CMD_QUERY = "CMD_QUERY";
	public static final String CMD_INSERT = "CMD_INSERT";
	public static final String CMD_UPDATE = "CMD_UPDATE";
	public static final String CMD_DELETE = "CMD_DELETE";
	public static final String CMD_APPROVED = "CMD_APPROVED";
	public static final String IN_PARAM = "IN_PARAM";


	@SuppressWarnings("unchecked")
	@Override
	public void execute(OperationContext context) throws CommonException {

		String cmd = (String) context.getAttribute(CMD);

		BopCfaDofoexloDsService service = BopCfaDofoexloDsService.getInstance();
		ReportCommonService logservice = ReportCommonService.getInstance();
		GlobalInfo gi = GlobalInfo.getCurrentInstance();

		if (StringUtils.equals(CMD_INSERT, cmd)) {
			BopCfaDofoexloDs bopcfa = (BopCfaDofoexloDs) context.getAttribute(IN_PARAM);
			service.save(bopcfa);
			logservice.saveBiDataProcessLog(bopcfa.getApptype(), bopcfa
					.getCurrentfile(), bopcfa.getId(), null, TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_EDIT, "新增", "新增 国内外汇贷款签约信息 ID : " + bopcfa.getId());

			gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrcode(),"国内外汇贷款签约信息新增"});
			htlog.info("Updater.log", new String[]{gi.getBrcode(),gi.getTlrno(),"国内外汇贷款签约信息新增"});

		} else if (StringUtils.equals(CMD_UPDATE, cmd)) {
			BopCfaDofoexloDs bopcfa = (BopCfaDofoexloDs) context.getAttribute(IN_PARAM);
			service.update(bopcfa);

			logservice.saveBiDataProcessLog(bopcfa.getApptype(), bopcfa
					.getCurrentfile(), bopcfa.getId(), null, TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_EDIT, "补录", "补录 国内外汇贷款签约信息 ID : " + bopcfa.getId());

			gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrcode(),"国内外汇贷款签约信息修改"});
			htlog.info("Updater.log", new String[]{gi.getBrcode(),gi.getTlrno(),"国内外汇贷款签约信息修改"});

		} else if (StringUtils.equals(CMD_DELETE, cmd)) {
			BopCfaDofoexloDs bopcfa = (BopCfaDofoexloDs) context.getAttribute(IN_PARAM);
			service.delete(bopcfa);

			logservice.saveBiDataProcessLog(bopcfa.getApptype(), bopcfa
					.getCurrentfile(), bopcfa.getId(), null, TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_DEL, "删除", "删除 国内外汇贷款签约信息 ID : " + bopcfa.getId());

			gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrcode(),"国内外汇贷款签约信息删除"});
			htlog.info("Updater.log", new String[]{gi.getBrcode(),gi.getTlrno(),"国内外汇贷款签约信息删除"});

		} else if (StringUtils.equals(CMD_APPROVED, cmd)) {
			List<BopCfaDofoexloDs> list = (List<BopCfaDofoexloDs>) context.getAttribute(IN_PARAM);
			service.approved(list);
			for (BopCfaDofoexloDs dofoexlodds : list) {
				logservice.saveBiDataProcessLog(dofoexlodds.getApptype(), dofoexlodds
						.getCurrentfile(), dofoexlodds.getId(), null, TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_AUDIT, "审核", "审核 国内外汇贷款签约信息 ID : " + dofoexlodds.getId());
			}

			gi.addBizLog("Updater.log", new String[]{gi.getTlrno(),gi.getBrcode(),"国内外汇贷款签约信息审核"});
			htlog.info("Updater.log", new String[]{gi.getBrcode(),gi.getTlrno(),"国内外汇贷款签约信息审核"});

		}
	}

	@Override
	public void afterProc(OperationContext context) throws CommonException {
	}

	@Override
	public void beforeProc(OperationContext context) throws CommonException {
	}
}