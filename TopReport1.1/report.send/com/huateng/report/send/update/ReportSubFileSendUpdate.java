package com.huateng.report.send.update;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.common.log.HtLog;
import com.huateng.common.log.HtLogFactory;
import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.util.DateUtil;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;
import com.huateng.report.common.service.ReportCommonService;
import com.huateng.report.constants.TopReportConstants;
import com.huateng.report.genupreportfile.bean.ReportShowCreateFileBean;
import com.huateng.report.genupreportfile.operation.ReportSendFileOperation;
import com.huateng.report.send.translate.ITranslate;
import com.huateng.report.send.translate.TransFactory;

public class ReportSubFileSendUpdate extends BaseUpdate {
	private static final HtLog htlog = HtLogFactory.getLogger(ReportSubFileSendUpdate.class);

	@Override
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean arg0, HttpServletRequest arg1, HttpServletResponse arg2)
			throws AppException {
		ITranslate tran = null;
		try {
			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID("reportSubFile");
			String packName = null;
			String appType = null;
			if (updateResultBean.hasNext()) {
				Map<String, String> map = updateResultBean.next();
				packName = map.get("packName");
				appType = map.get("appType");
			}
			GlobalInfo info = GlobalInfo.getCurrentInstance();
			String busiType = TopReportConstants.REPORT_BUSITYPE_BOP;
			String brNo = info.getBrno();
			Date startTm = new Date();
			tran = TransFactory.getInstence();
			if (packName != null) {
				boolean initbl = tran.init(null, null);
				if (initbl) {
					ReportShowCreateFileBean bean = new ReportShowCreateFileBean();
					bean.setPackName(packName);
					OperationContext context = new OperationContext();
					context.setAttribute(ReportSendFileOperation.CMD, TopReportConstants.REPORT_SUB_FILE_TYPE_01);
					context.setAttribute(ReportSendFileOperation.IN_FILE_OBJ, tran);
					context.setAttribute(ReportSendFileOperation.IN_FILE_PACK, packName);
					OPCaller.call(ReportSendFileOperation.ID, context);
					context.getAttribute(ReportSendFileOperation.RET_FILE_RESULT);
					bean.setSendSuccess(true);
				} else {
					ExceptionUtil.throwCommonException("连接服务器异常!");
				}
				Date endTm = new Date();
				ReportCommonService.getInstance().saveBiProcessLog(DateUtil.dateToNumber(info.getTxdate()), busiType, appType,
						brNo, TopReportConstants.REPORT_PROCESS_EXECTYPE_SEND, startTm, endTm,
						TopReportConstants.REPORT_PROCESS_OPERTYPE_MANU);

				info.addBizLog("Updater.log", new String[] { info.getTlrno(), brNo, "上报文件手工上传，业务类型【" + busiType + "】" });
				htlog.info("Updater.log", new String[] { info.getTlrno(), brNo, "上报文件手工上传，业务类型【" + busiType + "】" });
			}
			return updateReturnBean;
		} catch (CommonException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE, Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		} finally {
			if (tran != null) {
				tran.close();
			}
		}
	}

}
