package com.huateng.report.genupreportfile.dwr;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import resource.bean.report.SubFileInfo;

import com.huateng.common.log.HtLog;
import com.huateng.common.log.HtLogFactory;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.util.DateUtil;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.exception.AppException;
import com.huateng.report.common.service.ReportCommonService;
import com.huateng.report.constants.TopReportConstants;
import com.huateng.report.genupreportfile.bean.ReportShowCreateFileBean;
import com.huateng.report.genupreportfile.operation.ReportCreateFileOperation;
import com.huateng.report.genupreportfile.operation.ReportSendFileOperation;
import com.huateng.report.genupreportfile.service.ReportCreateSubFileService;
import com.huateng.report.genupreportfile.utils.ReportSubUtils;
import com.huateng.report.genupreportfile.utils.SubFileShowAware;
import com.huateng.report.imports.service.FileImportService;
import com.huateng.report.send.translate.ITranslate;
import com.huateng.report.send.translate.TransFactory;

/**
 * 生成上报文件
 *
 * @author NING-PENG
 *
 */
public class DwrCreateSubFileService {
	private static final HtLog htlog = HtLogFactory.getLogger(DwrCreateSubFileService.class);

	private void setGlobalInfo(HttpServletRequest request) {
		HttpSession httpSession = request.getSession(false);
		if (null != httpSession) {
			Object o = httpSession.getAttribute(GlobalInfo.KEY_GLOBAL_INFO);
			if (null != o && o instanceof GlobalInfo) {
				GlobalInfo globalInfo = (GlobalInfo) o;
				GlobalInfo.setCurrentInstance(globalInfo);
			}
		}
	}

	/**
	 * 查询是否有可上报文件数量
	 *
	 * @param request
	 * @return
	 * @throws CommonException
	 */
	public int getSubFileInfoCount(HttpServletRequest request, String busiType, String appType) throws CommonException {
		setGlobalInfo(request);
		GlobalInfo info = GlobalInfo.getCurrentInstance();
		String fileDate = info.getFileDate();
		int count = ReportCreateSubFileService.getInstance().getSubFileCountAndSaveSubFile(
				busiType, appType, fileDate);
		return count;
	}

	/**
	 * 生成并上传上报文件
	 *
	 * @param request
	 * @return
	 * @throws CommonException
	 */
	public List<String> createSubFile(HttpServletRequest request,String busiType,String appType) throws CommonException {

		List<String> packList = null;
		setGlobalInfo(request);
		GlobalInfo info = GlobalInfo.getCurrentInstance();
		String fileDate = info.getFileDate();

		try {
			SubFileShowAware.putEvent("开始生成上报文件...");
			// 上报文件的生成
			OperationContext context = new OperationContext();
			context.setAttribute(ReportCreateFileOperation.IN_FILE_DATE, fileDate);
			context.setAttribute(ReportCreateFileOperation.IN_BUSI_TYPE, busiType);
			context.setAttribute(ReportCreateFileOperation.IN_APP_TYPE, appType);
			ReportSubUtils.IS_CREATE_FILE_BOP = "1";
			OPCaller.call(ReportCreateFileOperation.ID, context);
			packList = (List<String>) context.getAttribute(ReportCreateFileOperation.RET_FILE_RESULT);
			SubFileShowAware.putEvent("上报文件生成成功!");
		} catch (CommonException e) {
			SubFileShowAware.putEvent("上报文件生成失败:" + e.getMessage());
			packList = null;
		} finally {
			ReportSubUtils.IS_CREATE_FILE_BOP = "0";
		}
		return packList;
	}

	public List<ReportShowCreateFileBean> showCreateFile(List<String> packList) throws CommonException {
		List<ReportShowCreateFileBean> showList = new ArrayList<ReportShowCreateFileBean>();
		for (int i = 0; i < packList.size(); i++) {
			String packName = packList.get(i).trim();
			List subFileList = ReportCreateSubFileService.getInstance().getSubFileInfoListByPack(packName);
			if (subFileList.size() > 0) {
				SubFileInfo info = (SubFileInfo) subFileList.get(0);
				String appType = info.getApptype();
				String appTypeName = ReportCommonService.getInstance().getAppTypeName(appType);

				ReportShowCreateFileBean bean = new ReportShowCreateFileBean();
				bean.setAppType(appType);
				bean.setAppTypeName(appTypeName);
				bean.setPackName(packName);
				for (int j = 0; j < subFileList.size(); j++) {
					SubFileInfo fileinfo = (SubFileInfo) subFileList.get(j);
					bean.getFileNameList().add(fileinfo.getId());
				}
				showList.add(bean);
			}
		}
		return showList;
	}

	public List<ReportShowCreateFileBean> sendSubFileList(HttpServletRequest request, List<String> packList, String appType)
			throws CommonException {
		List<ReportShowCreateFileBean> showList = new ArrayList<ReportShowCreateFileBean>();
		setGlobalInfo(request);
		GlobalInfo info = GlobalInfo.getCurrentInstance();
		String busiType = TopReportConstants.REPORT_BUSITYPE_BOP;
		String brNo = info.getBrno();
		Date startTm = new Date();
		SubFileShowAware.putEvent("开始进行文件上报...");
		ITranslate tran = null;
		try {
			tran = TransFactory.getInstence();
			boolean initbl = tran.init(null, null);
			if (initbl) {
				for (int i = 0; i < packList.size(); i++) {
					String packName = packList.get(i);
					if (packName==null||packName.trim().length()==0) {
						continue;
					}
					ReportShowCreateFileBean bean = new ReportShowCreateFileBean();
					bean.setPackName(packName);
					OperationContext context = new OperationContext();
					try {
						context.setAttribute(ReportSendFileOperation.CMD, TopReportConstants.REPORT_SUB_FILE_TYPE_01);
						context.setAttribute(ReportSendFileOperation.IN_FILE_OBJ, tran);
						context.setAttribute(ReportSendFileOperation.IN_FILE_PACK, packName);
						OPCaller.call(ReportSendFileOperation.ID, context);
						context.getAttribute(ReportSendFileOperation.RET_FILE_RESULT);
						SubFileShowAware.putEvent(packName + " 上报成功！");
						bean.setSendSuccess(true);
						showList.add(bean);
					} catch (Exception e) {
						SubFileShowAware.putEvent(packName + " 上报失败:" + e.getMessage());
						bean.setSendSuccess(false);
						showList.add(bean);
						continue;
					}
				}
			} else {
				ExceptionUtil.throwCommonException("连接服务器异常!");
			}
		} catch (AppException e1) {
			SubFileShowAware.putEvent("文件上报失败:" + e1.getMessage());
		} finally {
			if (tran != null) {
				tran.close();
			}
		}
		Date endTm = new Date();
		ReportCommonService.getInstance().saveBiProcessLog(DateUtil.dateToNumber(info.getTxdate()), busiType, appType, brNo,
				TopReportConstants.REPORT_PROCESS_EXECTYPE_SEND, startTm, endTm,
				TopReportConstants.REPORT_PROCESS_OPERTYPE_TIME);

		info.addBizLog("Updater.log", new String[] { info.getTlrno(), brNo, "上报文件上传，业务类型【" + busiType + "】" });
		htlog.info("Updater.log", new String[] { info.getTlrno(), brNo, "上报文件上传，业务类型【" + busiType + "】" });

		return showList;
	}

	public String isAnalyExecute(String workDate) throws CommonException{
		return FileImportService.getInstance().queryImportIsSuccessByWorkDate(workDate);
	}

	/**
	 * 校验是否所有机构都已锁定完成
	 * @return
	 * @throws CommonException 
	 */
	public boolean getIsAllOrgFinished() throws CommonException{
		return ReportCommonService.getInstance().isAllOrgFinished();
	}

}
