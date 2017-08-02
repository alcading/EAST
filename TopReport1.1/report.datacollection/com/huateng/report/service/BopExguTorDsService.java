package com.huateng.report.service;



import resource.bean.report.BopExguTorDs;
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


public class BopExguTorDsService {
	
	private static HtLog htLog = HtLogFactory.getLog(BopCfaCreditorDsService.class);
	private ROOTDAO rootDao ;
	

	/*
	 * 获取一个实例
	 * @param paramgroupId 参数段编号
	 */

	public static BopExguTorDsService getInstance() {
		// TODO Auto-generated method stub
		return (BopExguTorDsService)ApplicationContextUtils.getBean("BopExguTorDsService");
	}
	
	public PageQueryResult list(int pageIndex, int pageSize, String hql) throws CommonException {
		PageQueryCondition queryCondition = new PageQueryCondition();
		queryCondition.setQueryString(hql);
		queryCondition.setPageIndex(pageIndex);
		queryCondition.setPageSize(pageSize);
		HQLDAO hqlDAO = DAOUtils.getHQLDAO();
		return hqlDAO.pageQueryByQL(queryCondition);
	}
	
	
	//保存BopExguTorDs
	public void delete(String id) throws CommonException {
		htLog.info("开始删除对外担保责任余额信息记录 ,表记录ID："+id);
		rootDao= ROOTDAOUtils.getROOTDAO();
		BopExguTorDs bpInfo = (BopExguTorDs) rootDao.query(BopExguTorDs.class, id);

		if(null == bpInfo)
		{
			ExceptionUtil.throwCommonException("当前记录不存在！");
		}else
		    rootDao.delete(bpInfo.getClass(), id);
		
	}

	public void save(BopExguTorDs bpInfo) throws CommonException {
		htLog.info("开始插入对外担保责任余额信息记录 ,表记录ID："+bpInfo.getId());
		rootDao= ROOTDAOUtils.getROOTDAO();
		BopExguTorDs bpInfoTemp = (BopExguTorDs) rootDao.query(BopExguTorDs.class, (String)bpInfo.getId());

		if(null != bpInfoTemp)
		{
			ExceptionUtil.throwCommonException("当前记录已存在！");
		}else
			rootDao.save(bpInfo);

	}

	public void update(BopExguTorDs bpInfo) throws CommonException {
		
		//htLog.info("开始更新项目信息表记录 ,表记录ID："+bpInfo.getId());
		rootDao= ROOTDAOUtils.getROOTDAO();

		rootDao.saveOrUpdate(bpInfo);

	}

	public BopExguTorDs load(String id) throws CommonException {
		// TODO Auto-generated method stub
		rootDao= ROOTDAOUtils.getROOTDAO();

		return (BopExguTorDs)rootDao.query(BopExguTorDs.class, id);
	}



	

	
}
