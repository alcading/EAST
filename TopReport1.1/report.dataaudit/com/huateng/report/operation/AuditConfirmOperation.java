package com.huateng.report.operation;

import java.util.Date;

import com.huateng.common.log.HtLog;
import com.huateng.common.log.HtLogFactory;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.util.DateUtil;
import com.huateng.report.common.service.ReportCommonService;
import com.huateng.report.constants.TopReportConstants;
import com.huateng.report.service.AuditConfirmServices;

public class AuditConfirmOperation extends BaseOperation{
	public final static String ID = "AuditConfirmOperation";
	public final static String WORK_DATE = "WORK_DATE";
	public final static String BUSI_TYPE = "BUSI_TYPE";
	public static final String APP_TYPE = "APP_TYPE";
	private static final HtLog htlog = HtLogFactory.getLogger(AuditConfirmOperation.class);
	
	@Override
	public void beforeProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub

	}

	@Override
	public void execute(OperationContext context) throws CommonException {
		GlobalInfo globalInfo = GlobalInfo.getCurrentInstance();
		String workDate = (String) context.getAttribute(WORK_DATE);
		String busiType = (String) context.getAttribute(BUSI_TYPE);
		String appType = (String) context.getAttribute(APP_TYPE);
		String brNo = globalInfo.getBrno().trim();
		Date startTm = new Date();
		AuditConfirmServices.getInstance().excue(busiType, appType, globalInfo.getTlrno(),brNo, workDate);
		Date endTm = new Date();
		ReportCommonService.getInstance().saveBiProcessLog(DateUtil.dateToNumber(globalInfo.getTxdate()), busiType, appType, brNo, TopReportConstants.REPORT_PROCESS_EXECTYPE_AUDITCONFIRM, startTm, endTm, TopReportConstants.REPORT_PROCESS_OPERTYPE_MANU);
		

		globalInfo.addBizLog("Updater.log", new String[]{globalInfo.getTlrno(), brNo, "审核完成确认，业务类型【"+busiType+"】,应用类型【" + appType + "】"});
		htlog.info("Updater.log", new String[]{globalInfo.getTlrno(), brNo, "审核完成确认，业务类型【"+busiType+"】,应用类型【" + appType + "】"});
	}

	@Override
	public void afterProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub

	}

}
