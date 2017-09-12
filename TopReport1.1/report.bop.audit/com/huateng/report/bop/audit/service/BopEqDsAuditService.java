package com.huateng.report.bop.audit.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import resource.bean.report.MtsBopEqDs;
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

public class BopEqDsAuditService {
	
	protected static final Logger logger = Logger.getLogger(BopEqDsAuditService.class);

	protected BopEqDsAuditService() {
	}

	public synchronized static BopEqDsAuditService getInstance() {
		return (BopEqDsAuditService) ApplicationContextUtils.getBean(BopEqDsAuditService.class.getName());
	}
	
	/**
	 * BOP境内汇款申请书 审核查询
	 * @param queryType
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
	public PageQueryResult queryBOPEqAudit(String queryType, int pageIndex, int pageSize,
			String qstartDate, String qendDate, String qactiontype, String qrecStatus, String qapproveStatus, 
			String qrepStatus, String qfiller2) throws CommonException {
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		List<Object> objs = new ArrayList<Object>();
		StringBuffer hql = new StringBuffer(" SELECT model FROM MtsBopEqDs model WHERE ");
		hql.append(" model.apptype = ? AND model.currentfile = ? AND model.recStatus IN (?, ?)");
		objs.add(TopReportConstants.REPORT_APP_TYPE_BOP);
		if (queryType.equals("E")) {
			objs.add(TopReportConstants.REPORT_FILE_TYPE_BOP_E);
		} else if(queryType.equals("Q")) {
			objs.add(TopReportConstants.REPORT_FILE_TYPE_BOP_Q);
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
	 * 审核国际收支BOP境内汇款申请书相关信息
	 * 
	 * @param queryType
	 * @param bopEqDsList
	 * @param approveStatusChoose
	 * @param approveResultChoose
	 * 
	 * @throws CommonException
	 */
	@SuppressWarnings("unchecked")
	public void auditBopEqDs(String queryType, List<MtsBopEqDs> bopEqDsList,
				String approveStatusChoose, String approveResultChoose) throws CommonException {
		GlobalInfo gi = GlobalInfo.getCurrentInstance();
		List<String> bopEqDsIds = new ArrayList<String>();
		for(MtsBopEqDs bopEqDs : bopEqDsList){
			bopEqDsIds.add(bopEqDs.getId());
		}
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		ReportCommonService commonService = ReportCommonService.getInstance();
		String hql = "from MtsBopEqDs model where model.id in" + ReportUtils.toInString(bopEqDsIds);
		List<MtsBopEqDs> dbBopEqDsList = rootdao.queryByQL2List(hql);

		String approveStatusChooseName = "";
		if(TopReportConstants.REPORT_APPROVESTATUS_01.equals(approveStatusChoose)) {
			approveStatusChooseName = "通过";
		} else if(TopReportConstants.REPORT_APPROVESTATUS_02.equals(approveStatusChoose)) {
			approveStatusChooseName = "不通过";
		}

		for (MtsBopEqDs bopEqDs : dbBopEqDsList) {
			bopEqDs.setLstUpdTlr(gi.getTlrno());
			bopEqDs.setLstUpdTm(new Date());
			bopEqDs.setApproveResult(approveResultChoose);
			bopEqDs.setRecStatus(TopReportConstants.REPORT_RECSTATUS_04);
			bopEqDs.setApproveStatus(approveStatusChoose);
			bopEqDs.setWorkDate(DateUtil.dateToNumber(gi.getTxdate()));
			rootdao.saveOrUpdate(bopEqDs);
			//记录到数据处理记录表
			String appType = TopReportConstants.REPORT_APP_TYPE_BOP;
			String currentFile = null;
			if(queryType.equals("E")) {
				currentFile = TopReportConstants.REPORT_FILE_TYPE_BOP_E;
			} else if (queryType.equals("Q")) {
				currentFile = TopReportConstants.REPORT_FILE_TYPE_BOP_Q;
			}
			String recId = bopEqDs.getId();
			String rptno = bopEqDs.getRptno();
			String execType = TopReportConstants.REPORT_DATAPROCESS_EXECTYPE_AUDIT;
			String execResult = approveStatusChooseName;
			String execRemark = null;
			if(bopEqDs.getActiontype().equals(TopReportConstants.REPORT_ACTIONTYPE_D) && bopEqDs.getSubSuccess().equals(TopReportConstants.REPORT_IS_SUB_SUCCESS_YES)){
				execRemark = "删除成功";
			} else {
				execRemark = approveResultChoose;
			}
			//数据处理记录表保存
			commonService.saveBiDataProcessLog(appType, currentFile, recId, rptno, execType, execResult, execRemark);
		}
	}
}
