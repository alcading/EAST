package com.huateng.report.bop.dataquery.service;

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

public class BopEqDsQueryService {

	protected static final Logger logger = Logger.getLogger(BopEqDsQueryService.class);

	protected BopEqDsQueryService() {
		
	}

	public synchronized static BopEqDsQueryService getInstance() {
		return (BopEqDsQueryService) ApplicationContextUtils.getBean(BopEqDsQueryService.class.getName());
	}
	
	/**
	 * 上报数据查询
	 * @param queryType
	 * @param pageIndex
	 * @param pageSize
	 * @param qbrNo
	 * @param qrecStatus
	 * @param qactiontype
	 * @param qapproveStatus
	 * @param qrepStatus
	 * @param qworkDate
	 * @param eworkDate
	 * @param qfiller2 
	 * @return
	 * @throws CommonException 
	 */
	public PageQueryResult queryBOPEqRecord(String queryType, int pageIndex,
			int pageSize, String qbrNo, String qrecStatus, String qactiontype,
			String qapproveStatus, String qrepStatus, String qworkDate,
			String eworkDate, String qfiller2) throws CommonException {
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		List<Object> objs = new ArrayList<Object>();
		StringBuffer hql = new StringBuffer(" SELECT model FROM MtsBopEqDs model WHERE model.apptype = ? ");
		objs.add(TopReportConstants.REPORT_APP_TYPE_BOP);
		if (queryType.equals("E")) {
			hql.append(" AND model.currentfile = ? ");
			objs.add(TopReportConstants.REPORT_FILE_TYPE_BOP_E);
		} else if (queryType.equals("Q")) {
			hql.append(" AND model.currentfile = ? ");
			objs.add(TopReportConstants.REPORT_FILE_TYPE_BOP_Q);
		}
		if (!DataFormat.isEmpty(qworkDate)) {
			hql.append(" AND model.workDate >= ? ");
			objs.add(qworkDate);
		}
		if (!DataFormat.isEmpty(eworkDate)) {
			hql.append(" AND model.workDate <= ? ");
			objs.add(eworkDate);
		}
		if (!DataFormat.isEmpty(qrecStatus)) {
			hql.append(" AND model.recStatus = ? ");
			objs.add(qrecStatus);
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
		if(!DataFormat.isEmpty(qbrNo)){
			hql.append(" AND model.brNo = ? ");
			objs.add(qbrNo);
		}
		if(!DataFormat.isEmpty(qfiller2)){
			hql.append(" AND model.filler2 like '%" + qfiller2 + "%'");
		}
		hql.append(" ORDER BY model.lstUpdTm DESC ");

		PageQueryCondition queryCondition = new PageQueryCondition();
		queryCondition.setPageIndex(pageIndex);
		queryCondition.setPageSize(pageSize);
		queryCondition.setQueryString(hql.toString());
		queryCondition.setObjArray(objs.toArray());
		return rootdao.pageQueryByQL(queryCondition);
	}
}
