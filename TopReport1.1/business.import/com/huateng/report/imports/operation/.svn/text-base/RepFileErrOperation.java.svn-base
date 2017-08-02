/*
 * Created on 2005-5-11
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.huateng.report.imports.operation;

import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.report.constants.TopReportConstants;
import com.huateng.report.imports.bean.ReportFeedBackBean;
import com.huateng.report.imports.service.RepFileErrService;
import com.huateng.report.send.translate.ITranslate;

public class RepFileErrOperation extends BaseOperation {
	public static final String ID = "RepFileErrOperation";
	public static final String CMD = "CMD";
	public static final String IN_PARAM_TRAN_OBJ = "IN_PARAM_TRAN_OBJ";
	public static final String IN_PARAM_FEEDBACK_OBJ = "IN_PARAM_FEEDBACK_OBJ";
	public static final String IN_PARAM_SRCPACH = "IN_PARAM_SRCPACH";
	public static final String IN_PARAM_DESTPACH = "IN_PARAM_DESTPACH";
	public static final String IN_PARAM_ERRSIGN = "IN_PARAM_ERRSIGN";
	public static final String IN_PARAM_TLRNO = "IN_PARAM_TLRNO";
	public static final String IN_REPPACK_NAME = "IN_REPPACK_NAME";
	public static final String IN_BUSI_TYPE = "IN_BUSI_TYPE";
	public static final String RET_RESULT = "RET_RESULT";

	/*
	 * (non-Javadoc)
	 *
	 * @see com.huateng.ebank.framework.operation.IOperation#execute(com.huateng.ebank.framework.operation.OperationContext)
	 */
	public void execute(OperationContext context) throws CommonException {
		String retMsg = null;
		String cmd = (String) context.getAttribute(CMD);
		String busiType = (String) context.getAttribute(IN_BUSI_TYPE);
		String repPackName = (String) context.getAttribute(IN_REPPACK_NAME);
		String srcPath = (String) context.getAttribute(IN_PARAM_SRCPACH);
		String destPath = (String) context.getAttribute(IN_PARAM_DESTPACH);
		String errSign = (String) context.getAttribute(IN_PARAM_ERRSIGN);
		ReportFeedBackBean bean = (ReportFeedBackBean) context.getAttribute(IN_PARAM_FEEDBACK_OBJ);
		String tlrNo = (String) context.getAttribute(IN_PARAM_TLRNO);
		if (busiType.equals(TopReportConstants.REPORT_BUSITYPE_BOP)) {
			if (cmd.equalsIgnoreCase("local")) {// 从本地导入
				retMsg = RepFileErrService.getInstance().importRepFile(repPackName, srcPath, bean, errSign, tlrNo);
			} else if (cmd.equalsIgnoreCase("server")) {
				ITranslate translate = (ITranslate) context.getAttribute(IN_PARAM_TRAN_OBJ);
				retMsg = RepFileErrService.getInstance().repFileDownAndImportByBop(repPackName, translate, bean,
						srcPath, destPath, errSign, tlrNo);
			}
		}
		context.setAttribute(RET_RESULT, retMsg);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.huateng.ebank.framework.operation.IOperation#beforeProc(com.huateng.ebank.framework.operation.OperationContext)
	 */
	public void beforeProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.huateng.ebank.framework.operation.IOperation#afterProc(com.huateng.ebank.framework.operation.OperationContext)
	 */
	public void afterProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub

	}
}