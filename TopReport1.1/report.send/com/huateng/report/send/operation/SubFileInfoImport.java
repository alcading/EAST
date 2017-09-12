package com.huateng.report.send.operation;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
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
import com.huateng.ebank.framework.report.common.ReportConstant;
import com.huateng.ebank.framework.util.DateUtil;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;
import com.huateng.report.common.service.ReportCommonService;
import com.huateng.report.constants.TopReportConstants;
import com.huateng.report.imports.bean.ReportFeedBackBean;
import com.huateng.report.imports.operation.RepFileErrOperation;
import com.huateng.report.send.translate.ITranslate;
import com.huateng.report.send.translate.TransFactory;
import com.huateng.report.utils.ReportEnum;
import com.huateng.report.utils.ReportUtils;

public class SubFileInfoImport extends BaseUpdate {

	private static final HtLog htlog = HtLogFactory.getLogger(SubFileInfoImport.class);

	@Override
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean multiUpdateResultBean, HttpServletRequest request,
			HttpServletResponse response) throws AppException {
		ITranslate translate = null;
		GlobalInfo globalInfo = GlobalInfo.getCurrentInstance();

		String busiType = TopReportConstants.REPORT_BUSITYPE_BOP;

		try {
			List<ReportFeedBackBean> feedBackList = new ArrayList<ReportFeedBackBean>();
			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID("receiptPackImport");
			while (updateResultBean.hasNext()) {
				Map<String, String> map = updateResultBean.next();
				String isHashFeedBack = map.get("isHashFeedBack");
				if (isHashFeedBack.equals(ReportEnum.REPORT_IS.NO.value)) {
					ReportFeedBackBean bean = new ReportFeedBackBean();
					mapToObject(bean, map);
					feedBackList.add(bean);
				}
			}
			if (feedBackList.size() > 0) {
				Map<String, String> retMap = new HashMap<String, String>();
				Map<String, List<ReportFeedBackBean>> appMap = new HashMap<String, List<ReportFeedBackBean>>();
				for(int i = 0; i < feedBackList.size(); i++){
					ReportFeedBackBean bean = feedBackList.get(i);
					if(appMap.containsKey(bean.getAppType())){
						List<ReportFeedBackBean> tempList = appMap.get(bean.getAppType());
						tempList.add(bean);
					} else {
						List<ReportFeedBackBean> tempList = new ArrayList<ReportFeedBackBean>();
						tempList.add(bean);
						appMap.put(bean.getAppType(), tempList);
					}
				}
				
				for (Iterator iterator = appMap.keySet().iterator(); iterator.hasNext();) {
					String appType = (String) iterator.next();
					Date startTm = new Date();
					List<ReportFeedBackBean> tempList = appMap.get(appType);
					for (int i = 0; i < tempList.size(); i++) {
						ReportFeedBackBean bean = tempList.get(i);
						if (bean.getBusiType().equals(TopReportConstants.REPORT_BUSITYPE_BOP)) {
							OperationContext ocx = new OperationContext();
							//检查本地
							String repPackName = bean.getPackName() + ReportConstant.BOP_SUB_FILE_FEEDBACK;

							ocx.setAttribute(RepFileErrOperation.IN_REPPACK_NAME, repPackName);

							String repTtFileName = repPackName + ".xml";
							String srcpath = ReportUtils.getSysParamsValue(ReportConstant.REPORT_LOACL_DATA_PARAMGROUP, bean.getAppType(), "/");
							String destpath = ReportUtils.getSysParamsValue(ReportConstant.REPORT_REMOTE_DATA_PARAMGROUP, bean.getAppType(), "/");
							ocx.setAttribute(RepFileErrOperation.IN_PARAM_SRCPACH, srcpath);
							ocx.setAttribute(RepFileErrOperation.IN_PARAM_DESTPACH, destpath);
							String ttFilePath = ReportUtils.getFeedbackFilePath(srcpath, repPackName, repTtFileName);
							if (ReportUtils.isFileExist(ttFilePath)) {//从本地导入
								ocx.setAttribute(RepFileErrOperation.CMD,"local");
							}else{
								// 连接服务器
								if (translate == null) {
									translate = TransFactory.getInstence();
									boolean flag = translate.init(null, null);
									if (!flag) {
										retMap.put(bean.getPackName(), "失败:连接服务器异常");
										continue;
									}
								}
								ocx.setAttribute(RepFileErrOperation.CMD,"server");
								ocx.setAttribute(RepFileErrOperation.IN_PARAM_TRAN_OBJ, translate);
							}
							ocx.setAttribute(RepFileErrOperation.IN_BUSI_TYPE, bean.getBusiType());
							ocx.setAttribute(RepFileErrOperation.IN_PARAM_FEEDBACK_OBJ, bean);
							ocx.setAttribute(RepFileErrOperation.IN_PARAM_ERRSIGN, ReportConstant.BOP_SUB_FILE_FEEDBACK);
							ocx.setAttribute(RepFileErrOperation.IN_PARAM_TLRNO, globalInfo.getTlrno());

							OPCaller.call(RepFileErrOperation.ID, ocx);

							String retStr = (String) ocx.getAttribute(RepFileErrOperation.RET_RESULT);
							retMap.put(bean.getPackName(), retStr);
						}
					}
					// 写入操作日志
					Date endTm = new Date();
					ReportCommonService.getInstance().saveBiProcessLog(DateUtil.dateToNumber(globalInfo.getTxdate()),
							busiType, appType, globalInfo.getBrno(), TopReportConstants.REPORT_PROCESS_EXECTYPE_LOADBACKFILE,
							startTm, endTm, TopReportConstants.REPORT_PROCESS_OPERTYPE_MANU);
				}
				StringBuffer returnStr = new StringBuffer();
				for (Iterator<String> iterator = retMap.keySet().iterator(); iterator.hasNext();) {
					String name = iterator.next();
					String value = retMap.get(name);
					returnStr.append(name);
					returnStr.append(":");
					if (value.equals(ITranslate.RESCODE_SUCCESS)) {
						returnStr.append("导入执行成功!");
					}else if (value.equals(ITranslate.RESCODE_NOT_RES)) {
						returnStr.append("系统尚未收到回执!");
					}else if (value.equals(ITranslate.RESCODE_PROCESS)) {
						returnStr.append("系统正在下载回执!");
					}else if (value.equals(ITranslate.RESCODE_FAILED)) {
						returnStr.append("发生未知错误!");
					}else{
						returnStr.append(value);
					}
					returnStr.append("@@");
				}

				updateReturnBean.setParameter("ERRMSG", returnStr.toString());

				globalInfo.addBizLog("Updater.log", new String[] { globalInfo.getTlrno(), globalInfo.getBrno(),
						"导入回执文件，业务类型【" + busiType + "】" });
				htlog.info("Updater.log", new String[] { globalInfo.getTlrno(), globalInfo.getBrno(),
						"导入回执文件，业务类型【" + busiType + "】" });
			} else {
				ExceptionUtil.throwCommonException("没有需要下载导入回执的信息！");
			}
			return updateReturnBean;
		} catch (CommonException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE, Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		} finally {
			if (translate != null) {
				translate.close();
			}
		}
	}
}
