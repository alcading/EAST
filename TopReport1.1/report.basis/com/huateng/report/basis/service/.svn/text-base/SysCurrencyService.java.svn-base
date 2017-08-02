package com.huateng.report.basis.service;

import java.util.Iterator;

import resource.bean.report.SysCurrency;
import resource.bean.report.SysTaskInfo;
import resource.dao.base.HQLDAO;
import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;

import com.huateng.ebank.business.common.PageQueryCondition;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.business.management.common.DAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;
import com.huateng.ebank.framework.util.ExceptionUtil;

public class SysCurrencyService {

	private static final String DATASET_ID="com.huateng.report.basis.service.SysCurrencyService";

	private ROOTDAO rootDao ;

	public synchronized static SysCurrencyService getInstance() {
		return (SysCurrencyService) ApplicationContextUtils.getBean(DATASET_ID);
		}

	public PageQueryResult list(int pageIndex, int pageSize, String hql) throws CommonException {
		PageQueryCondition queryCondition = new PageQueryCondition();
		queryCondition.setQueryString(hql);
		queryCondition.setPageIndex(pageIndex);
		queryCondition.setPageSize(pageSize);
		HQLDAO hqlDAO = DAOUtils.getHQLDAO();
		return hqlDAO.pageQueryByQL(queryCondition);
	}

	public SysCurrency load(Integer id) throws CommonException {

		rootDao= ROOTDAOUtils.getROOTDAO();

		return (SysCurrency)rootDao.query(SysCurrency.class, id);
	}

	public void delete(String id) throws CommonException {

		rootDao= ROOTDAOUtils.getROOTDAO();
		SysCurrency sysCurrency = (SysCurrency) rootDao.query(SysCurrency.class, id);

		if(null == sysCurrency)
		{
			ExceptionUtil.throwCommonException("当前记录不存在！");
		}else
		    rootDao.delete(sysCurrency.getClass(), id);
	}

	public void save(SysCurrency sysCurrency) throws CommonException {

		rootDao= ROOTDAOUtils.getROOTDAO();
		SysCurrency eCurrency = (SysCurrency) rootDao.query(SysCurrency.class, (String)sysCurrency.getId());

		if(null != eCurrency)
		{
			ExceptionUtil.throwCommonException("当前记录已存在！");
		}else
			rootDao.save(sysCurrency);

	}

	public void update(SysCurrency sysCurrency) throws CommonException {

		rootDao= ROOTDAOUtils.getROOTDAO();

		rootDao.update(sysCurrency);

	}
	 //author  by  计翔 2012.9.5 序列化对象写入taskinfo表
	public void addTosystaskinfo(SysTaskInfo systackinfo){
		ROOTDAO rootDAO = ROOTDAOUtils.getROOTDAO();
		try {
			rootDAO.saveOrUpdate(systackinfo);
		} catch (CommonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//获得要操作的Item
	public Iterator selectByid(String id){
			
			
			ROOTDAO rootDAO = ROOTDAOUtils.getROOTDAO();
		
			try {
			return	rootDAO.queryByQL("from SysCurrency sysCurrency where sysCurrency.id='"+id+"'");
				//return	rootDAO.queryBySQL("select * from sys_params  where PARAMGROUP_ID ='"+paramgroupid+"'  and PARAM_ID='"+paramid+"'" 
							//);
			} catch (CommonException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
			
				
			
			
		}
	
	//通过id来获取实体映射类
	 public SysCurrency selectById(String id){
		  ROOTDAO rootdao=ROOTDAOUtils.getROOTDAO();
		  SysCurrency  currency = null;
		  try {
			
			  currency=  (SysCurrency)rootdao.query(SysCurrency.class, id);
			 
			 	} catch (CommonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return currency;
	  }
}
