package com.huateng.ebank.business.datadic.service;

import resource.bean.pub.DataDic;
import resource.dao.base.HQLDAO;

import com.huateng.ebank.business.common.PageQueryCondition;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.business.management.common.DAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;

public class DataDicService {

	public PageQueryResult list(int pageIndex, int pageSize, String hql) throws CommonException {
		PageQueryCondition queryCondition = new PageQueryCondition();
		queryCondition.setQueryString(hql);
		queryCondition.setPageIndex(pageIndex);
		queryCondition.setPageSize(pageSize);
		HQLDAO hqlDAO = DAOUtils.getHQLDAO();
		return hqlDAO.pageQueryByQL(queryCondition);
	}

	public DataDic load(Integer id) {
		return DAOUtils.getDataDicDAO().findById(id);
	}

	public void delete(Integer id) {
		DAOUtils.getDataDicDAO().delete(load(id));
	}

	public void save(DataDic dd) {
		DAOUtils.getDataDicDAO().save(dd);
	}

	public void update(DataDic dd) throws CommonException {
		DAOUtils.getDataDicDAO().update(dd);
	}

}
