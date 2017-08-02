package com.huateng.report.bop.collection.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;

import com.huateng.ebank.business.common.PageQueryCondition;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;
import com.huateng.ebank.framework.util.DataFormat;
import com.huateng.report.constants.TopReportConstants;

public class BopAgDsRecordService {

	protected static final Logger logger = Logger.getLogger(BopAgDsRecordService.class);

	protected BopAgDsRecordService() {
		
	}

	public synchronized static BopAgDsRecordService getInstance() {
		return (BopAgDsRecordService) ApplicationContextUtils.getBean(BopAgDsRecordService.class.getName());
	}

	/**
	 * BOP涉外收入申报单记录查询
	 * @param pageIndex
	 * @param pageSize
	 * @param qstartDate
	 * @param qendDate
	 * @param qactiontype
	 * @param qrecStatus
	 * @param qapproveStatus
	 * @param qrepStatus
	 * @param qfiller2
	 * @param brNo
	 * @return
	 * @throws CommonException
	 */
	public PageQueryResult queryBOPAgRecord(String queryType, int pageIndex, int pageSize, String qstartDate, String qendDate, String qactiontype,
			String qapproveStatus, String qrepStatus, String qrecStatus, String qfiller2, String brNo) throws CommonException {
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		List<Object> objs = new ArrayList<Object>();
		StringBuffer hql = new StringBuffer(" SELECT model FROM MtsBopAgDs model WHERE ");
		hql.append(" model.apptype = ? AND model.currentfile = ? AND model.recStatus IN (?, ?) ");
		objs.add(TopReportConstants.REPORT_APP_TYPE_BOP);
		if (queryType.equals("A")) {
			objs.add(TopReportConstants.REPORT_FILE_TYPE_BOP_A);
		} else if(queryType.equals("G")) {
			objs.add(TopReportConstants.REPORT_FILE_TYPE_BOP_G);
		}
 		objs.add(TopReportConstants.REPORT_RECSTATUS_01);
		objs.add(TopReportConstants.REPORT_RECSTATUS_02);
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
		if(!DataFormat.isEmpty(qfiller2)){
			hql.append(" AND model.filler2 like '%" + qfiller2 + "%'");
		}
		hql.append(" AND model.brNo = ? ORDER BY model.lstUpdTm DESC ");
		objs.add(brNo);

		PageQueryCondition queryCondition = new PageQueryCondition();
		queryCondition.setPageIndex(pageIndex);
		queryCondition.setPageSize(pageSize);
		queryCondition.setQueryString(hql.toString());
		queryCondition.setObjArray(objs.toArray());
		return rootdao.pageQueryByQL(queryCondition);
	}
	
	/**
	 * BOP涉外收入申报单拾取记录查询
	 * @param pageIndex
	 * @param pageSize
	 * @param qstartDate
	 * @param qendDate
	 * @param qrptno
	 * @param qfiller2
	 * @param qbrNo
	 * @return
	 * @throws CommonException
	 */
	public PageQueryResult queryBOPAForG(int pageIndex, int pageSize, String qworkDateStart, String qworkDateEnd, String qrptno, String qfiller2,
			String qbrNo) throws CommonException {
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		List<Object> objs = new ArrayList<Object>();
		StringBuffer hql = new StringBuffer(" SELECT model FROM MtsBopAgDs model WHERE ");
		hql.append(" model.apptype = ? AND model.currentfile = ? AND model.actiontype <> ? ");
		objs.add(TopReportConstants.REPORT_APP_TYPE_BOP);
		objs.add(TopReportConstants.REPORT_FILE_TYPE_BOP_A);
		objs.add(TopReportConstants.REPORT_ACTIONTYPE_D);
		if (!DataFormat.isEmpty(qworkDateStart)) {
			hql.append(" AND model.workDate >= ? ");
			objs.add(qworkDateStart);
		}
		if (!DataFormat.isEmpty(qworkDateEnd)) {
			hql.append(" AND model.workDate <= ? ");
			objs.add(qworkDateEnd);
		}
		if (!DataFormat.isEmpty(qrptno)) {
			hql.append(" AND model.rptno like ? ");
			objs.add("%" + qrptno + "%");
		}
		if (!DataFormat.isEmpty(qfiller2)) {
			hql.append(" AND model.filler2 LIKE ? ");
			objs.add("%" + qfiller2 + "%");
		}
		hql.append(" AND model.brNo = ? ORDER BY model.lstUpdTm DESC ");
		objs.add(qbrNo);

		PageQueryCondition queryCondition = new PageQueryCondition();
		queryCondition.setPageIndex(pageIndex);
		queryCondition.setPageSize(pageSize);
		queryCondition.setQueryString(hql.toString());
		queryCondition.setObjArray(objs.toArray());
		return rootdao.pageQueryByQL(queryCondition);
	}
}