package com.huateng.report.jsh.audit.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import resource.bean.report.MtsJshDefgDs;
import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;

import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;
import com.huateng.ebank.framework.util.DateUtil;
import com.huateng.report.common.service.ReportCommonService;
import com.huateng.report.constants.TopReportConstants;
import com.huateng.report.utils.ReportUtils;

public class JshDfDsAuditService {
	
	public static synchronized JshDfDsAuditService getInstance() {
		return (JshDfDsAuditService) ApplicationContextUtils.getBean(JshDfDsAuditService.class.getName());
	}
	/*
	 * 基础信息审核
	 */
	public void basic_audit(List<MtsJshDefgDs> mtsJshDefgDsList,
			String approveStatusChoose, String approveResultChoose) throws CommonException {
		// TODO Auto-generated method stub
		ROOTDAO dao = ROOTDAOUtils.getROOTDAO();
		GlobalInfo globalInfo = GlobalInfo.getCurrentInstance();
		ReportCommonService commonService = ReportCommonService.getInstance();
		String approveStatusChooseName = "";
		if(TopReportConstants.REPORT_APPROVESTATUS_01.equals(approveStatusChoose)) {
			approveStatusChooseName = "通过";
		} else if(TopReportConstants.REPORT_APPROVESTATUS_02.equals(approveStatusChoose)) {
			approveStatusChooseName = "不通过";
		}
		List<String> mtsJshDefgDsIdList = new ArrayList<String>();
		for(MtsJshDefgDs ds : mtsJshDefgDsList) {
			mtsJshDefgDsIdList.add(ds.getId());
		}
		String hql = " from MtsJshDefgDs model where model.id in "+ReportUtils.toInString(mtsJshDefgDsIdList);
		List<MtsJshDefgDs> list = dao.queryByQL2List(hql);
		for(MtsJshDefgDs ds : list) {
			ds.setLstUpdTlr(globalInfo.getTlrno());
			ds.setLstUpdTm(new Date());
			ds.setApproveResult(approveResultChoose);
			ds.setRecStatus(TopReportConstants.REPORT_RECSTATUS_04);
			ds.setApproveStatus(approveStatusChoose);
			ds.setWorkDate(DateUtil.getWorkDate());
			dao.update(ds);
			//记录到数据处理记录表
			String appType = TopReportConstants.REPORT_APP_TYPE_JSH;
			String currentFile = TopReportConstants.REPORT_FILE_TYPE_JSH_D;
			String recId = ds.getId();
			String busiNo = ds.getRptno();
			String execType = TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_AUDIT;
			String execResult = approveStatusChoose;
			String execRemark = null;
			if(TopReportConstants.REPORT_ACTIONTYPE_D.equals(ds.getActiontype()) && TopReportConstants.REPORT_IS_SUB_SUCCESS_YES.equals(ds.getSubSuccess())) {
				execRemark = "删除成功";
			} else {
				execRemark = approveResultChoose;
			}
			//记录到数据处理记录表
			commonService.saveBiDataProcessLog(appType, currentFile, recId, busiNo, execType, execResult, execRemark);
		}
	}
	/*
	 * 管理信息审核
	 */
	public void manage_audit(List<MtsJshDefgDs> mtsJshDefgDsList,
			String approveStatusChoose, String approveResultChoose) throws CommonException {
		// TODO Auto-generated method stub
		ROOTDAO dao = ROOTDAOUtils.getROOTDAO();
		GlobalInfo globalInfo = GlobalInfo.getCurrentInstance();
		ReportCommonService commonService = ReportCommonService.getInstance();
		String approveStatusChooseName = "";
		if(TopReportConstants.REPORT_APPROVESTATUS_01.equals(approveStatusChoose)) {
			approveStatusChooseName = "通过";
		} else if(TopReportConstants.REPORT_APPROVESTATUS_02.equals(approveStatusChoose)) {
			approveStatusChooseName = "不通过";
		}
		List<String> mtsJshDefgDsIdList = new ArrayList<String>();
		for(MtsJshDefgDs ds : mtsJshDefgDsList) {
			mtsJshDefgDsIdList.add(ds.getId());
		}
		String hql = " from MtsJshDefgDs model where model.id in "+ReportUtils.toInString(mtsJshDefgDsIdList);
		List<MtsJshDefgDs> list = dao.queryByQL2List(hql);
		for(MtsJshDefgDs ds : list) {
			ds.setLstUpdTlr(globalInfo.getTlrno());
			ds.setLstUpdTm(new Date());
			ds.setApproveResult(approveResultChoose);
			ds.setRecStatus(TopReportConstants.REPORT_RECSTATUS_04);
			ds.setApproveStatus(approveStatusChoose);
			ds.setWorkDate(DateUtil.dateToNumber(globalInfo.getTxdate()));
			dao.saveOrUpdate(ds);
			//记录到数据处理记录表
			String appType = TopReportConstants.REPORT_APP_TYPE_JSH;
			String currentFile = TopReportConstants.REPORT_FILE_TYPE_JSH_F;
			String recId = ds.getId();
			String busiNo = ds.getRptno();
			String execType = TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_AUDIT;
			String execResult = approveStatusChoose;
			String execRemark = null;
			if(TopReportConstants.REPORT_ACTIONTYPE_D.equals(ds.getActiontype()) && TopReportConstants.REPORT_IS_SUB_SUCCESS_YES.equals(ds.getSubSuccess())) {
				execRemark = "删除成功";
			} else {
				execRemark = approveResultChoose;
			}
			//记录到数据处理记录表
			commonService.saveBiDataProcessLog(appType, currentFile, recId, busiNo, execType, execResult, execRemark);
		}
	}
}
