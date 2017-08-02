package com.huateng.report.service;


import java.util.List;

import resource.bean.report.BopCfaExdebtDs;
import resource.dao.base.HQLDAO;
import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;

import com.huateng.ebank.business.common.PageQueryCondition;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.business.management.common.DAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.report.constants.TopReportConstants;

/**
 * BOP_CFA_EXDEBT_DS :外债信息表 ->双边贷款 -> 变动信息   增加、删除、查询、更新
 * @author cwenao
 * @version 1.0
 * 2012-8-28
 * */

public class BOPForDebtChangeInfoService  {

	private static final String DATASET_ID="com.huateng.report.service.BOPForDebtChangeInfoService";

	public synchronized static BOPForDebtChangeInfoService getInstance() {
		return (BOPForDebtChangeInfoService) ApplicationContextUtils.getBean(DATASET_ID);
	}

	public PageQueryResult list(int pageIndex, int pageSize, String hql) throws CommonException {
		PageQueryCondition queryCondition = new PageQueryCondition();
		queryCondition.setQueryString(hql);
		queryCondition.setPageIndex(pageIndex);
		queryCondition.setPageSize(pageSize);
		HQLDAO hqlDAO = DAOUtils.getHQLDAO();
		return hqlDAO.pageQueryByQL(queryCondition);
	}

	@SuppressWarnings("rawtypes")
	public List queryChangeInfo(String filler1Id) throws CommonException
	{
		ROOTDAO rootDao = ROOTDAOUtils.getROOTDAO();
		/** 根据recStatus是否为07判断余额信息是否被删除 ，如果recStatus为07表示被删除，不为07表示没有被删除 */
		StringBuilder hql = new StringBuilder(" FROM BopCfaExdebtDs WHERE filler1 = ? AND apptype = ? AND currentfile = ? AND recStatus <> ? ");
		return rootDao.queryByQL2List(hql.toString(), new Object[]{filler1Id, TopReportConstants.REPORT_APP_TYPE_CFA, TopReportConstants.REPORT_FILE_TYPE_CFA_AR, TopReportConstants.REPORT_RECSTATUS_07}, null);
	}

	public BopCfaExdebtDs load(Integer id) throws CommonException {
		ROOTDAO rootDao = ROOTDAOUtils.getROOTDAO();
		return (BopCfaExdebtDs)rootDao.query(BopCfaExdebtDs.class, id);
	}

	public void delete(BopCfaExdebtDs bpExdebt) throws CommonException {
		ROOTDAO rootDao = ROOTDAOUtils.getROOTDAO();
		BopCfaExdebtDs bpExdebtTemp = (BopCfaExdebtDs) rootDao.query(BopCfaExdebtDs.class, bpExdebt.getId());

		if(null == bpExdebtTemp)
		{
			ExceptionUtil.throwCommonException("当前记录不存在！");
		}else {
		    rootDao.saveOrUpdate(bpExdebt);
		}
	}

	public void save(BopCfaExdebtDs bpExdebt) throws CommonException {
		ROOTDAO rootDao = ROOTDAOUtils.getROOTDAO();
		rootDao.save(bpExdebt);
	}

	public void update(BopCfaExdebtDs bpExdebt) throws CommonException  {
		ROOTDAO rootDao = ROOTDAOUtils.getROOTDAO();
		rootDao.saveOrUpdate(bpExdebt);
	}
}