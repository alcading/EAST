package com.huateng.report.basis.service;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import resource.bean.report.BiDayexchangerate;
import resource.bean.report.SysTaskInfo;
import resource.dao.base.HQLDAO;
import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;

import com.huateng.ebank.business.common.ErrorCode;
import com.huateng.ebank.business.common.PageQueryCondition;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.business.management.common.DAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.report.utils.ReportEnum;

public class BiDayExchangeRateService {

	public PageQueryResult list(int pageIndex, int pageSize, String hql) throws CommonException {
		PageQueryCondition queryCondition = new PageQueryCondition();
		queryCondition.setQueryString(hql);
		queryCondition.setPageIndex(pageIndex);
		queryCondition.setPageSize(pageSize);
		HQLDAO hqlDAO = DAOUtils.getHQLDAO();
		return hqlDAO.pageQueryByQL(queryCondition);
	}
	
	public <BiDayExchangeRate> List lode (String id) {
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		return rootdao.getHibernateTemplate().findByNamedQuery(id);
	}

	/*
	 * 获取一个实例
	 * @param paramgroupId 参数段编号
	 */

	public static BiDayExchangeRateService getInstance() {
		// TODO Auto-generated method stub
		return (BiDayExchangeRateService)ApplicationContextUtils.getBean("BiDayExchangeRateService");
	}
	
	public PageQueryResult pageQueryByHql(int pageIndex, int pageSize,
			String ratecut, String rateDate1,String qst) {
		// TODO Auto-generated method stub
		ROOTDAO rootDAO = ROOTDAOUtils.getROOTDAO();
		PageQueryResult pageQueryResult = null;
		PageQueryCondition queryCondition = new PageQueryCondition();
		String hql = "from BiDayexchangerate bder where bder.del='F'";
		if(ratecut != null && !"".equals(ratecut)) {
			hql += ("and bder.id like '"+ratecut.trim()+"'");
		}
		if(rateDate1 != null && !"".equals(rateDate1)) {
			hql += ("and bder.rateDate like '"+rateDate1.trim()+"'");
		}
		  if(qst!=null && qst.length()>0){
			   hql += (" and  bder.st ='"+qst+"'");
		   }else{
			   hql += (" and  bder.st<>'"+ReportEnum.REPORT_ST1.N.value+"'");
		   }
		try {
			queryCondition.setQueryString(hql);
			queryCondition.setPageIndex(pageIndex);
			queryCondition.setPageSize(pageSize);
			pageQueryResult = rootDAO.pageQueryByQL(queryCondition);
		} catch (CommonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pageQueryResult;
	}

	/*
	 * 查询
	 * @param paramgroupId 参数段编号
	 */
	public List getAllBrnListForCDSH() throws CommonException {
		ROOTDAO rootDAO = ROOTDAOUtils.getROOTDAO();
		List list = rootDAO.queryByQL2List("1=1");
		for (int i = 0; i < list.size(); i++) {
			BiDayexchangerate bder = (BiDayexchangerate) list.get(i);
			list.set(i, bder);
		}
		return list;
	}
	/*
	 * 币种筛选框
	 * @param paramgroupId 参数段编号
	 */
	public PageQueryResult paramgroupIdSelect(int pageIndex, int pageSize,
			String paramgroupId) {
		// TODO Auto-generated method stub
		String hql = "from BiDayexchangerate bder ";
		if(paramgroupId != null && !"".equals(paramgroupId)){
			hql += " where bder.id like '"+paramgroupId+"'";}
		ROOTDAO rootDAO = ROOTDAOUtils.getROOTDAO();
		PageQueryCondition queryCondition = new PageQueryCondition();
		queryCondition.setPageIndex(pageIndex);
		queryCondition.setPageSize(pageSize);
		queryCondition.setQueryString(hql);
		List<BiDayexchangerate> list = new ArrayList<BiDayexchangerate>();
		PageQueryResult pageQueryResult = null;
		try {
			pageQueryResult = rootDAO.pageQueryByQL(queryCondition);
		} catch (CommonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pageQueryResult;
	
	}
	
	/*
	 * 删除实体
	 * @param biNationregion
	 */
	public void removeEntity(BiDayexchangerate biDayexchangerate) {
		ROOTDAO rootDAO = ROOTDAOUtils.getROOTDAO();
		try {
			rootDAO.delete(biDayexchangerate);
			System.out.println(this.getClass().getName()+"已删除");
		} catch (CommonException e) {
			System.out.println(this.getClass().getName()+"删除实体出错！ ");
			e.printStackTrace();
		}
	}
	/*
	 * 插入或者更新实体
	 * @param biNationregion
	 */
//	public void modOrAddEntity(BiDayexchangerate biDayexchangerate) {
//		ROOTDAO rootDAO = ROOTDAOUtils.getROOTDAO();
//		try {
//			rootDAO.saveOrUpdate(biDayexchangerate);
//			System.out.println(this.getClass().getName()+" 已插入或更新");
//		} catch (CommonException e) {
//			System.out.println(this.getClass().getName()+" 插入或更新出错！ ");
//			e.printStackTrace();
//		}
//	}

	public void addEntity(BiDayexchangerate biDayexchangerate) throws CommonException {
		// TODO Auto-generated method stub
		ROOTDAO rootDAO = ROOTDAOUtils.getROOTDAO();
		if(isExists(biDayexchangerate.getId())) {
			ExceptionUtil.throwCommonException(" 币种重复", ErrorCode.ERROR_CODE_DUP_INSERT);
		}
		try {
			rootDAO.save(biDayexchangerate);
			System.out.println(this.getClass().getName()+" 已插入或更新实体");
		} catch (CommonException e) {
			System.out.println(this.getClass().getName()+" 插入或更新实体！ ");
		}
	}
	public boolean isExists(String id) {
		ROOTDAO rootDAO = ROOTDAOUtils.getROOTDAO();
		try {
			BiDayexchangerate bd = (BiDayexchangerate) rootDAO.query(BiDayexchangerate.class, id);
			if(bd == null) {
				return false;
			}
		} catch (CommonException e) {
			// TODO Auto-generated catch block
			System.out.println("判断实体是否重复出错");
		}
		return true;
	}

	public void modEntity(BiDayexchangerate biDayexchangerate) {
		// TODO Auto-generated method stub
		ROOTDAO rootDAO = ROOTDAOUtils.getROOTDAO();
		try {
			rootDAO.update(biDayexchangerate);
			System.out.println(this.getClass().getName()+" 已插入或更新实体biNationregion");
		} catch (CommonException e) {
			System.out.println(this.getClass().getName()+" 插入或更新实体biNationregion出错！ ");
			e.printStackTrace();
		}
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
 //author  by  计翔 2012.9.5    获得要操作的Item
	public Iterator selectByid(String id){
			
			
			ROOTDAO rootDAO = ROOTDAOUtils.getROOTDAO();
		
			try {
			return	rootDAO.queryByQL("from BiDayexchangerate biDayechangerate where biDayechangerate.id='"+id+"'");
				
			} catch (CommonException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
			
				
			
			
		}

	//author  by  计翔 2012.9.5  通过id来获取实体类
  public BiDayexchangerate  selectById(String id){
	  ROOTDAO rootdao=ROOTDAOUtils.getROOTDAO();
	  BiDayexchangerate  bidayexchangerate = null;
	  try {
		
		 bidayexchangerate=  (BiDayexchangerate)rootdao.query(BiDayexchangerate.class, id);
		 
		 	} catch (CommonException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return bidayexchangerate;
  }

	

	
}
