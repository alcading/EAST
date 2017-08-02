package com.huateng.report.send.operation;

import java.util.List;

import resource.bean.report.SubFileInfo;
import resource.report.dao.ROOTDAOUtils;

import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;

public class ReportFileInfoOP extends BaseOperation {

	public static String ID = "ReportFileInfoOP";
	public static String CMD = "CMD";

	public static String DO_SAVE_REPORT_FILE_INFO = "DO_SAVE_REPORT_FILE_INFO";

	public static String PARAM = "PARAM";

	@Override
	public void execute(OperationContext context) throws CommonException {
		String cmd = (String) context.getAttribute(CMD);
		if (DO_SAVE_REPORT_FILE_INFO.equals(cmd)) {
			List<SubFileInfo> list = (List<SubFileInfo>) context
					.getAttribute(PARAM);
			for (SubFileInfo fi : list) {
				ROOTDAOUtils.getROOTDAO().saveOrUpdate(fi);
			}
		}
	}

	@Override
	public void beforeProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub

	}

}
