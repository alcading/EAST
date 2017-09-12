package com.huateng.report.basis.service;

import resource.bean.report.BiAccount;
import resource.dao.base.HQLDAO;
import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;

import com.huateng.ebank.business.common.PageQueryCondition;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.business.management.common.DAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;
import com.huateng.ebank.framework.util.ExceptionUtil;

public class BiAccountService {

	private static final String DATASET_ID="com.huateng.report.basis.service.BiAccountService";

	private ROOTDAO rootDao ;

	public synchronized static BiAccountService getInstance() {
		return (BiAccountService) ApplicationContextUtils.getBean(DATASET_ID);
		}

	public PageQueryResult list(int pageIndex, int pageSize, String hql) throws CommonException {
		PageQueryCondition queryCondition = new PageQueryCondition();
		queryCondition.setQueryString(hql);
		queryCondition.setPageIndex(pageIndex);
		queryCondition.setPageSize(pageSize);
		HQLDAO hqlDAO = DAOUtils.getHQLDAO();
		return hqlDAO.pageQueryByQL(queryCondition);
	}

	public BiAccount load(Integer id) throws CommonException {

		rootDao= ROOTDAOUtils.getROOTDAO();

		return (BiAccount)rootDao.query(BiAccount.class, id);
	}

	public void delete(String id) throws CommonException {

		rootDao= ROOTDAOUtils.getROOTDAO();
		BiAccount biAccount = (BiAccount) rootDao.query(BiAccount.class, id);

		if(null == biAccount)
		{
			ExceptionUtil.throwCommonException("当前记录不存在！");
		}else
		    rootDao.delete(biAccount.getClass(), id);
	}

	public void save(BiAccount biAccount) throws CommonException {

		rootDao= ROOTDAOUtils.getROOTDAO();
		BiAccount eAccount = (BiAccount) rootDao.query(BiAccount.class, (String)biAccount.getId());

		if(null != eAccount)
		{
			ExceptionUtil.throwCommonException("当前记录已存在！");
		}else
			rootDao.save(biAccount);

	}

	public void update(BiAccount biAccount) throws CommonException {

		rootDao= ROOTDAOUtils.getROOTDAO();

		rootDao.saveOrUpdate(biAccount);

	}

}
