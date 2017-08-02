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
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;
import com.huateng.report.common.service.ReportCommonService;
import com.huateng.report.constants.TopReportConstants;
import com.huateng.report.genupreportfile.operation.ReportSendFileOperation;

public class ReportSubFileUpdate extends BaseUpdate {
	private static final HtLog htlog = HtLogFactory.getLogger(ReportSubFileUpdate.class);
	@Override
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean arg0, HttpServletRequest arg1, HttpServletResponse arg2)
			throws AppException {
		try {
			Date startTm = new Date();
			GlobalInfo info = GlobalInfo.getCurrentInstance();
			String busiType = TopReportConstants.REPORT_BUSITYPE_BOP;
			String brNo = info.getBrno();
			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID("reportSubFile");
			String packName = null;
			String appType = null;
			if (updateResultBean.hasNext()) {
				Map<String, String> map = updateResultBean.next();
				packName = map.get("packName");
				appType = map.get("appType");
			}
			if (packName!=null) {
				OperationContext context = new OperationContext();
				context.setAttribute(ReportSendFileOperation.CMD, TopReportConstants.REPORT_SUB_FILE_TYPE_02);
				context.setAttribute(ReportSendFileOperation.IN_FILE_PACK, packName);
				OPCaller.call(ReportSendFileOperation.ID, context);
			}
			Date endTm = new Date();
			ReportCommonService.getInstance().saveBiProcessLog(DateUtil.dateToNumber(info.getTxdate()), busiType, appType,
					brNo, TopReportConstants.REPORT_PROCESS_EXECTYPE_SEND, startTm, endTm,
					TopReportConstants.REPORT_PROCESS_OPERTYPE_MANU);

			info.addBizLog("Updater.log", new String[] { info.getTlrno(), brNo, "上报文件导出报送，业务类型【" + busiType + "】" });
			htlog.info("Updater.log", new String[] { info.getTlrno(), brNo, "上报文件导出报送，业务类型【" + busiType + "】" });
			return updateReturnBean;
		} catch (CommonException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE, Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}

}
