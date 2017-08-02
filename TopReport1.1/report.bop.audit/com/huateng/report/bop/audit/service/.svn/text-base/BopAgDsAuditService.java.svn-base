package com.huateng.report.bop.audit.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import resource.bean.report.MtsBopAgDs;
import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;

import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.PageQueryCondition;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;
import com.huateng.ebank.framework.util.DataFormat;
import com.huateng.ebank.framework.util.DateUtil;
import com.huateng.report.common.service.ReportCommonService;
import com.huateng.report.constants.TopReportConstants;
import com.huateng.report.utils.ReportUtils;

public class BopAgDsAuditService {
	
	protected static final Logger logger = Logger.getLogger(BopAgDsAuditService.class);

	protected BopAgDsAuditService() {
	}

	public synchronized static BopAgDsAuditService getInstance() {
		return (BopAgDsAuditService) ApplicationContextUtils.getBean(BopAgDsAuditService.class.getName());
	}
	
	/**
	 * BOP涉外收入申报单 审核查询
	 * @param pageIndex
	 * @param pageSize
	 * @param qstartDate
	 * @param qendDate
	 * @param qactiontype
	 * @param qrecStatus
	 * @param qapproveStatus
	 * @param qrepStatus
	 * @param qfiller2
	 * @return
	 * @throws CommonException
	 */
	public PageQueryResult queryBOPAgAudit(String queryType, int pageIndex, int pageSize,
			String qstartDate, String qendDate, String qactiontype, String qrecStatus, String qapproveStatus, 
			String qrepStatus, String qfiller2) throws CommonException {
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		List<Object> objs = new ArrayList<Object>();
		StringBuffer hql = new StringBuffer(" SELECT model FROM MtsBopAgDs model WHERE ");
		hql.append(" model.apptype = ? AND model.currentfile = ? AND model.recStatus IN (?, ?)");
		objs.add(TopReportConstants.REPORT_APP_TYPE_BOP);
		if (queryType.equals("A")) {
			objs.add(TopReportConstants.REPORT_FILE_TYPE_BOP_A);
		} else if(queryType.equals("G")) {
			objs.add(TopReportConstants.REPORT_FILE_TYPE_BOP_G);
		} 
		objs.add(TopReportConstants.REPORT_RECSTATUS_03);
		objs.add(TopReportConstants.REPORT_RECSTATUS_04);
		if(!DataFormat.isEmpty(qstartDate)){
			hql.append(" AND model.workDate >= ? ");
			objs.add(qstartDate);
		}
		if(!DataFormat.isEmpty(qendDate)){
			hql.append(" AND model.workDate <= ? ");
			objs.add(qendDate);
		}
		if (!DataFormat.isEmpty(qactiontype)) {
			hql.append(" AND model.actiontype = ? ");
			objs.add(qactiontype);
		}
		if (!DataFormat.isEmpty(qrecStatus)) {
			hql.append(" AND model.recStatus = ? ");
			objs.add(qrecStatus);
		}
		if (!DataFormat.isEmpty(qapproveStatus)) {
			hql.append(" AND model.approveStatus = ? ");
			objs.add(qapproveStatus);
		}
		if (!DataFormat.isEmpty(qrepStatus)) {
			hql.append(" AND model.repStatus = ? ");
			objs.add(qrepStatus);
		}
		if (!DataFormat.isEmpty(qfiller2)) {
			hql.append(" AND model.filler2 LIKE ? ");
			objs.add("%" + qfiller2 + "%");
		}
		hql.append(" AND model.brNo = ? ORDER BY model.lstUpdTm DESC ");
		GlobalInfo gi = GlobalInfo.getCurrentInstance();
		objs.add(gi.getBrno());

		PageQueryCondition queryCondition = new PageQueryCondition();
		queryCondition.setPageIndex(pageIndex);
		queryCondition.setPageSize(pageSize);
		queryCondition.setQueryString(hql.toString());
		queryCondition.setObjArray(objs.toArray());
		return rootdao.pageQueryByQL(queryCondition);
	}
	
	/**
	 * 审核国际收支BOP涉外收入申报单相关信息
	 * 
	 * @param queryType
	 * @param bopAgDsList
	 * @param approveStatusChoose
	 * @param approveResultChoose
	 * 
	 * @throws CommonException
	 */
	@SuppressWarnings("unchecked")
	public void auditBopAgDs(String queryType, List<MtsBopAgDs> bopAgDsList,
				String approveStatusChoose, String approveResultChoose) throws CommonException {
		GlobalInfo gi = GlobalInfo.getCurrentInstance();
		List<String> bopAgDsIds = new ArrayList<String>();
		for(MtsBopAgDs bopAgDs : bopAgDsList){
			bopAgDsIds.add(bopAgDs.getId());
		}
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		ReportCommonService commonService = ReportCommonService.getInstance();
		String hql = "from MtsBopAgDs model where model.id in" + ReportUtils.toInString(bopAgDsIds);
		List<MtsBopAgDs> dbBopAgDsList = rootdao.queryByQL2List(hql);

		String approveStatusChooseName = "";
		if(TopReportConstants.REPORT_APPROVESTATUS_01.equals(approveStatusChoose)) {
			approveStatusChooseName = "通过";
		} else if(TopReportConstants.REPORT_APPROVESTATUS_02.equals(approveStatusChoose)) {
			approveStatusChooseName = "不通过";
		}

		for (MtsBopAgDs bopAgDs : dbBopAgDsList) {
			bopAgDs.setLstUpdTlr(gi.getTlrno());
			bopAgDs.setLstUpdTm(new Date());
			bopAgDs.setApproveResult(approveResultChoose);
			bopAgDs.setRecStatus(TopReportConstants.REPORT_RECSTATUS_04);
			bopAgDs.setApproveStatus(approveStatusChoose);
			bopAgDs.setWorkDate(DateUtil.dateToNumber(gi.getTxdate()));
			rootdao.saveOrUpdate(bopAgDs);
			//记录到数据处理记录表
			String appType = TopReportConstants.REPORT_APP_TYPE_BOP;
			String currentFile = null;
			if(queryType.equals("A")) {
				currentFile = TopReportConstants.REPORT_FILE_TYPE_BOP_A;
			} else if (queryType.equals("G")) {
				currentFile = TopReportConstants.REPORT_FILE_TYPE_BOP_G;
			}
			String recId = bopAgDs.getId();
			String rptno = bopAgDs.getRptno();
			String execType = TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_AUDIT;
			String execResult = approveStatusChooseName;
			String execRemark = null;
			if(bopAgDs.getActiontype().equals(TopReportConstants.REPORT_ACTIONTYPE_D) && bopAgDs.getSubSuccess().equals(TopReportConstants.REPORT_IS_SUB_SUCCESS_YES)){
				execRemark = "删除成功";
			} else {
				execRemark = approveResultChoose;
			}
			//数据处理记录表保存
			commonService.saveBiDataProcessLog(appType, currentFile, recId, rptno, execType, execResult, execRemark);
		}
	}
}
