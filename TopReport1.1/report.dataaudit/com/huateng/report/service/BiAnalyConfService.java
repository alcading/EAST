package com.huateng.report.service;

import resource.bean.report.BiAnalyConf;
import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;

import com.huateng.ebank.business.common.PageQueryCondition;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;

public class BiAnalyConfService {

	/*
	 * 获得自身实例
	 */
	public synchronized static BiAnalyConfService getInstance() {
		return (BiAnalyConfService) ApplicationContextUtils.getBean(BiAnalyConfService.class.getName());
	}

	/*
	 * 分页服务
	 */
	public PageQueryResult pageQueryByHql(int pageIndex,int maxRows,String hql) throws CommonException {
		ROOTDAO rootDAO = ROOTDAOUtils.getROOTDAO();
		PageQueryResult pageQueryResult = null;
		PageQueryCondition queryCondition = new PageQueryCondition();
		queryCondition.setQueryString(hql);
		queryCondition.setPageIndex(pageIndex);
		queryCondition.setPageSize(maxRows);
		pageQueryResult = rootDAO.pageQueryByQL(queryCondition);
		return pageQueryResult;
	}
	/*
	 * 更改数据库有效/无效状态
	 */

	public void updateBiAnalyConfByConfVaild( BiAnalyConf biAnalyConf) throws CommonException {
		ROOTDAO rootDAO = ROOTDAOUtils.getROOTDAO();
		rootDAO.update(biAnalyConf);
	}
}
