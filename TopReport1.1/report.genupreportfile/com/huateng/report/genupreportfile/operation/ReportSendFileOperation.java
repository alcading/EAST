package com.huateng.report.genupreportfile.operation;

import java.util.List;

import resource.bean.report.SubFileInfo;

import com.huateng.common.log.HtLog;
import com.huateng.common.log.HtLogFactory;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.report.constants.TopReportConstants;
import com.huateng.report.genupreportfile.service.ReportCreateSubFileService;
import com.huateng.report.send.translate.ITranslate;

public class ReportSendFileOperation extends BaseOperation {
	private static final HtLog htlog = HtLogFactory.getLogger(ReportSendFileOperation.class);
	public static final String CMD = "CMD";
	public static final String ID = "BOP.ReportSendFileOperation";
	public static final String IN_FILE_OBJ = "IN_FILE_OBJ";
	public static final String IN_FILE_PACK = "IN_FILE_PACK";
	public static final String RET_FILE_RESULT = "RET_FILE_RESULT";

	@Override
	public void afterProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeProc(OperationContext context) throws CommonException {

	}

	@Override
	public void execute(OperationContext context) throws CommonException {
		String cmd = (String) context.getAttribute(CMD);
		ReportCreateSubFileService service = ReportCreateSubFileService.getInstance();
		if (cmd.equalsIgnoreCase(TopReportConstants.REPORT_SUB_FILE_TYPE_01)) {
			String packname = (String) context.getAttribute(IN_FILE_PACK);
			ITranslate tran = (ITranslate) context.getAttribute(IN_FILE_OBJ);
			boolean bl = service.subFileUpLoad(tran, packname);
			context.setAttribute(RET_FILE_RESULT, bl);
		}else if(cmd.equalsIgnoreCase(TopReportConstants.REPORT_SUB_FILE_TYPE_02)){
			String packname = (String) context.getAttribute(IN_FILE_PACK);
			List<SubFileInfo> subFileInfoList = service.getSubFileInfoListByPack(packname.trim());
			service.updateSubFileInfoBySend(subFileInfoList);
		}
	}

}
