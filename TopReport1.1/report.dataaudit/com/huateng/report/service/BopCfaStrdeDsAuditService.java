package com.huateng.report.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import resource.bean.report.BopCfaStrdeDs;
import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;

import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;
import com.huateng.ebank.framework.util.DateUtil;
import com.huateng.report.common.service.ReportCommonService;
import com.huateng.report.constants.TopReportConstants;
import com.huateng.report.utils.ReportUtils;

/*
 * 商业银行人民币结构性存款审核service
 */
public class BopCfaStrdeDsAuditService {
	
	public static BopCfaStrdeDsAuditService getInstance() {
		return (BopCfaStrdeDsAuditService) ApplicationContextUtils.getBean(BopCfaStrdeDsAuditService.class.getName());
	}
	/*
	 * 签约信息审核
	 */
	public void contract_audit(List<BopCfaStrdeDs> bopCfaStrdeDsList, String approveStatusChoose, String approveResultChoose) throws CommonException {
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
		List<String> bopCfaStrdeDsIdList = new ArrayList<String>();
		for(BopCfaStrdeDs ds : bopCfaStrdeDsList) {
			bopCfaStrdeDsIdList.add(ds.getId());
		}
		String hql = " from BopCfaStrdeDs model where model.id in "+ReportUtils.toInString(bopCfaStrdeDsIdList);
		List<BopCfaStrdeDs> list = dao.queryByQL2List(hql);
		for(BopCfaStrdeDs ds : list) {
			ds.setLstUpdTlr(globalInfo.getTlrno());
			ds.setLstUpdTm(new Date());
			ds.setApproveResult(approveResultChoose);
			ds.setRecStatus(TopReportConstants.REPORT_RECSTATUS_04);
			ds.setApproveStatus(approveStatusChoose);
			ds.setWorkDate(DateUtil.dateToNumber(globalInfo.getTxdate()));
			dao.saveOrUpdate(ds);
			//记录到数据处理记录表
			String appType = TopReportConstants.REPORT_APP_TYPE_CFA;
			String currentFile = TopReportConstants.REPORT_FILE_TYPE_CFA_FA;
			String recId = ds.getId();
			String busiNo = ds.getStrdecode();
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
	 * 终止信息审核
	 */
	public void terminate_audit(List<BopCfaStrdeDs> bopCfaStrdeDsList,
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
		List<String> bopCfaStrdeDsIdList = new ArrayList<String>();
		for(BopCfaStrdeDs ds : bopCfaStrdeDsList) {
			bopCfaStrdeDsIdList.add(ds.getId());
		}
		String hql = " from BopCfaStrdeDs model where model.id in "+ReportUtils.toInString(bopCfaStrdeDsIdList);
		List<BopCfaStrdeDs> list = dao.queryByQL2List(hql);
		for(BopCfaStrdeDs ds : list) {
			ds.setLstUpdTlr(globalInfo.getTlrno());
			ds.setLstUpdTm(new Date());
			ds.setApproveResult(approveResultChoose);
			ds.setRecStatus(TopReportConstants.REPORT_RECSTATUS_04);
			ds.setApproveStatus(approveStatusChoose);
			ds.setWorkDate(DateUtil.dateToNumber(globalInfo.getTxdate()));
			dao.saveOrUpdate(ds);
			//记录到数据处理记录表
			String appType = TopReportConstants.REPORT_APP_TYPE_CFA;
			String currentFile = TopReportConstants.REPORT_FILE_TYPE_CFA_FB;
			String recId = ds.getId();
			String busiNo = ds.getStrdecode();
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
	 * 利息给付信息审核
	 */
	public void inpay_audit(List<BopCfaStrdeDs> bopCfaStrdeDsList,
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
		List<String> bopCfaStrdeDsIdList = new ArrayList<String>();
		for(BopCfaStrdeDs ds : bopCfaStrdeDsList) {
			bopCfaStrdeDsIdList.add(ds.getId());
		}
		String hql = " from BopCfaStrdeDs model where model.id in "+ReportUtils.toInString(bopCfaStrdeDsIdList);
		List<BopCfaStrdeDs> list = dao.queryByQL2List(hql);
		for(BopCfaStrdeDs ds : list) {
			ds.setLstUpdTlr(globalInfo.getTlrno());
			ds.setLstUpdTm(new Date());
			ds.setApproveResult(approveResultChoose);
			ds.setRecStatus(TopReportConstants.REPORT_RECSTATUS_04);
			ds.setApproveStatus(approveStatusChoose);
			ds.setWorkDate(DateUtil.dateToNumber(globalInfo.getTxdate()));
			dao.saveOrUpdate(ds);
			//记录到数据处理记录表
			String appType = TopReportConstants.REPORT_APP_TYPE_CFA;
			String currentFile = TopReportConstants.REPORT_FILE_TYPE_CFA_FC;
			String recId = ds.getId();
			String busiNo = ds.getStrdecode();
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
	 * 资金流出入和结购汇信息审核
	 */
	public void inoutMo_audit(List<BopCfaStrdeDs> bopCfaStrdeDsList,
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
		List<String> bopCfaStrdeDsIdList = new ArrayList<String>();
		for(BopCfaStrdeDs ds : bopCfaStrdeDsList) {
			bopCfaStrdeDsIdList.add(ds.getId());
		}
		String hql = " from BopCfaStrdeDs model where model.id in "+ReportUtils.toInString(bopCfaStrdeDsIdList);
		List<BopCfaStrdeDs> list = dao.queryByQL2List(hql);
		for(BopCfaStrdeDs ds : list) {
			ds.setLstUpdTlr(globalInfo.getTlrno());
			ds.setLstUpdTm(new Date());
			ds.setApproveResult(approveResultChoose);
			ds.setRecStatus(TopReportConstants.REPORT_RECSTATUS_04);
			ds.setApproveStatus(approveStatusChoose);
			ds.setWorkDate(DateUtil.dateToNumber(globalInfo.getTxdate()));
			dao.saveOrUpdate(ds);
			//记录到数据处理记录表
			String appType = TopReportConstants.REPORT_APP_TYPE_CFA;
			String currentFile = TopReportConstants.REPORT_FILE_TYPE_CFA_FD;
			String recId = ds.getId();
			String busiNo = ds.getStrdecode();
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
