package com.huateng.report.service;


import resource.bean.report.BopProjectInfo;
import resource.dao.base.HQLDAO;
import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;

import com.huateng.ebank.business.common.PageQueryCondition;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.business.management.common.DAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;
import com.huateng.ebank.framework.util.ExceptionUtil;

/**
 * BOP_CFA_EXDEBT_DS :外债信息表   增加、删除、查询、更新
 * @author cwenao
 * @version 1.0
 * 2012-8-28
 * */
public class BOPForDebtProjectService  {

	private static final String DATASET_ID="com.huateng.report.service.BOPForDebtProjectService";

	public synchronized static BOPForDebtProjectService getInstance() {
		return (BOPForDebtProjectService) ApplicationContextUtils.getBean(DATASET_ID);
	}

	public PageQueryResult list(int pageIndex, int pageSize, String hql) throws CommonException {
		PageQueryCondition queryCondition = new PageQueryCondition();
		queryCondition.setQueryString(hql);
		queryCondition.setPageIndex(pageIndex);
		queryCondition.setPageSize(pageSize);
		HQLDAO hqlDAO = DAOUtils.getHQLDAO();
		return hqlDAO.pageQueryByQL(queryCondition);
	}

	public BopProjectInfo load(String id) throws CommonException {
		ROOTDAO rootDao = ROOTDAOUtils.getROOTDAO();
		return (BopProjectInfo)rootDao.query(BopProjectInfo.class, id);
	}

	public void delete(String id) throws CommonException {
		ROOTDAO rootDao = ROOTDAOUtils.getROOTDAO();
		BopProjectInfo bpInfo = (BopProjectInfo) rootDao.query(BopProjectInfo.class, id);
		if(null == bpInfo)
		{
			ExceptionUtil.throwCommonException("当前记录不存在！");
		}else {
		    rootDao.delete(bpInfo.getClass(), id);
		}
	}

	public void save(BopProjectInfo bpInfo) throws CommonException {
		ROOTDAO rootDao= ROOTDAOUtils.getROOTDAO();
		BopProjectInfo bpInfoTemp = (BopProjectInfo) rootDao.query(BopProjectInfo.class, (String)bpInfo.getId());
		if(null != bpInfoTemp)
		{
			ExceptionUtil.throwCommonException("当前记录已存在！");
		}else {
			rootDao.save(bpInfo);
		}
	}

	public void update(BopProjectInfo bpInfo) throws CommonException {
		ROOTDAO rootDao = ROOTDAOUtils.getROOTDAO();
		rootDao.saveOrUpdate(bpInfo);
	}
}