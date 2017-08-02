package com.huateng.report.service;


import resource.bean.report.BopCfaCreditorDs;
import resource.dao.base.HQLDAO;
import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;

import com.huateng.common.log.HtLog;
import com.huateng.common.log.HtLogFactory;
import com.huateng.ebank.business.common.PageQueryCondition;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.business.management.common.DAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;
import com.huateng.ebank.framework.util.ExceptionUtil;

/**
 * BOP_CFA_CREDITOR_DS :债权人信息表  增加、删除、查询、更新
 * @author cwenao
 * @version 1.0
 * 2012-8-28
 * */

public class BopCfaCreditorDsService {

	private static final String DATASET_ID="com.huateng.report.service.BopCfaCreditorDsService";
	private static HtLog htLog = HtLogFactory.getLog(BopCfaCreditorDsService.class);

	public synchronized static BopCfaCreditorDsService getInstance() {
		return (BopCfaCreditorDsService) ApplicationContextUtils.getBean(DATASET_ID);
	}

	public PageQueryResult list(int pageIndex, int pageSize, String hql) throws CommonException {
		PageQueryCondition queryCondition = new PageQueryCondition();
		queryCondition.setQueryString(hql);
		queryCondition.setPageIndex(pageIndex);
		queryCondition.setPageSize(pageSize);
		HQLDAO hqlDAO = DAOUtils.getHQLDAO();
		return hqlDAO.pageQueryByQL(queryCondition);
	}

	public BopCfaCreditorDs load(String id) throws CommonException {
		ROOTDAO rootDao= ROOTDAOUtils.getROOTDAO();
		return (BopCfaCreditorDs)rootDao.query(BopCfaCreditorDs.class, id);
	}

	public void delete(String id) throws CommonException {
		htLog.info("开始删除债权人信息表记录 ,表记录ID："+id);
		ROOTDAO rootDao= ROOTDAOUtils.getROOTDAO();
		BopCfaCreditorDs bcc = (BopCfaCreditorDs) rootDao.query(BopCfaCreditorDs.class, id);

		if(null == bcc)
		{
			ExceptionUtil.throwCommonException("当前记录不存在！");
		}else
		{
		    rootDao.delete(bcc.getClass(), id);
		}
	}

	public void save(BopCfaCreditorDs bcc) throws CommonException {

		htLog.info("开始插入债权人信息表记录 ,表记录ID："+bcc.getId());

		ROOTDAO rootDao= ROOTDAOUtils.getROOTDAO();
		BopCfaCreditorDs bccTemp = (BopCfaCreditorDs) rootDao.query(BopCfaCreditorDs.class, (String)bcc.getId());

		if(null != bccTemp)
		{
			ExceptionUtil.throwCommonException("当前记录已存在！");
		}else{
			rootDao.save(bcc);
		}

	}

	public void update(BopCfaCreditorDs bcc) throws CommonException {
		htLog.info("开始更新债权人信息表记录 ,表记录ID："+bcc.getId());
		ROOTDAO rootDao= ROOTDAOUtils.getROOTDAO();
		rootDao.saveOrUpdate(bcc);
	}
}