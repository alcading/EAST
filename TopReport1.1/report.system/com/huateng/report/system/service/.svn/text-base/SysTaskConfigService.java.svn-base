package com.huateng.report.system.service;

import java.util.Iterator;
import java.util.List;

import resource.bean.report.SysTaskConfig;
import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;

import com.huateng.ebank.business.common.PageQueryCondition;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;
import com.huateng.ebank.framework.util.ExceptionUtil;

//jianxue.zhang
public class SysTaskConfigService {
	public static synchronized SysTaskConfigService getInstance() {
		return (SysTaskConfigService) ApplicationContextUtils.getBean("SysTaskConfigService");
	}
	public PageQueryResult list(int pageIndex, int pageSize, String hql) throws CommonException {
		PageQueryCondition queryCondition = new PageQueryCondition();
		queryCondition.setQueryString(hql);
		queryCondition.setPageIndex(pageIndex);
		queryCondition.setPageSize(pageSize);
		ROOTDAO rootDao = ROOTDAOUtils.getROOTDAO();
		return rootDao.pageQueryByQL(queryCondition);
	}
	
	public void saveOrUpdate(List insert,List update)throws CommonException {
		ROOTDAO rootDao = ROOTDAOUtils.getROOTDAO();
		if(!insert.isEmpty()){
			Iterator it= insert.iterator();
			while(it.hasNext()){
				Object ob=it.next();
			if(rootDao.query(SysTaskConfig.class, ((SysTaskConfig)ob).getId())!=null)
			{
				ExceptionUtil.throwCommonException("主键冲突!");
			}
			else{
				rootDao.save(ob);
			}
			}
		}
		if(!update.isEmpty()){
			Iterator it= update.iterator();
			while(it.hasNext()){
				rootDao.update(it.next());
			}
		}
		
	}

}
