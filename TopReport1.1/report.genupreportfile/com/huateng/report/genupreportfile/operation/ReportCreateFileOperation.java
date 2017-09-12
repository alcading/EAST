package com.huateng.report.genupreportfile.operation;

import java.util.List;

import com.huateng.common.log.HtLog;
import com.huateng.common.log.HtLogFactory;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.report.genupreportfile.service.ReportCreateSubFileService;

public class ReportCreateFileOperation extends BaseOperation {
	private static final HtLog htlog = HtLogFactory.getLogger(ReportCreateFileOperation.class);
	public static final String ID = "BOP.ReportCreateFileOperation";
	public static final String CMD = "CMD";
	public static final String IN_FILE_DATE = "IN_FILE_DATE";
	public static final String IN_BUSI_TYPE = "IN_BUSI_TYPE";
	public static final String RET_FILE_RESULT = "RET_FILE_RESULT";
	public static final String IN_APP_TYPE = "IN_APP_TYPE";
	@Override
	public void afterProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeProc(OperationContext context) throws CommonException {


	}

	@Override
	public void execute(OperationContext context) throws CommonException {
		ReportCreateSubFileService service = ReportCreateSubFileService.getInstance();
		String busiType = (String) context.getAttribute(IN_BUSI_TYPE);
		String appType = (String) context.getAttribute(IN_APP_TYPE);
		String fileDate = (String) context.getAttribute(IN_FILE_DATE);
		
		List<String> packList = service.createSubFile(fileDate, busiType, appType);
		context.setAttribute(RET_FILE_RESULT, packList);
	}

}
