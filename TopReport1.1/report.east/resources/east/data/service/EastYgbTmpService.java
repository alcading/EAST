package resources.east.data.service;



import com.huateng.ebank.business.common.PageQueryCondition;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.business.management.common.DAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;

import resource.dao.base.HQLDAO;
import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;
import resources.east.data.pub.EastYgbTmp;

public class EastYgbTmpService {
	public PageQueryResult list(int pageIndex, int pageSize, String hql) throws CommonException {
		PageQueryCondition queryCondition = new PageQueryCondition();
		queryCondition.setQueryString(hql);
		queryCondition.setPageIndex(pageIndex);
		queryCondition.setPageSize(pageSize);
		HQLDAO hqlDAO = DAOUtils.getHQLDAO();
		return hqlDAO.pageQueryByQL(queryCondition);
	}
	
	
	/*
	 * 获取一个实例
	 * @param paramgroupId 参数段编号
	 */

	public static EastYgbTmpService getInstance() {
		// TODO Auto-generated method stub
		return (EastYgbTmpService)ApplicationContextUtils.getBean("EastYgbTmpService");
	}
	
	public PageQueryResult pageQueryByHql(int pageIndex, int pageSize,String gh, String nbjgh) {
		// TODO Auto-generated method stub
		ROOTDAO rootDAO = ROOTDAOUtils.getROOTDAO();
		PageQueryResult pageQueryResult = null;
		PageQueryCondition queryCondition = new PageQueryCondition();
		String hql = "from EastYgbTmp ygb where 1=1  ";
		//EastYgbPK eastYgbPK = new EastYgbPK(); 
		//eastYgbPK.setGh(gh);
		//eastYgbPK.setNbjgh(nbjgh);
		if(gh != null && !"".equals(gh)) {
			hql += ("and ygb.id.gh = '"+gh.trim()+"'");
		}
		if(nbjgh != null && !"".equals(nbjgh)) {
			hql += ("and ygb.id.nbjgh = '"+nbjgh.trim()+"'");
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


	

	public boolean isExists(String id) {
		ROOTDAO rootDAO = ROOTDAOUtils.getROOTDAO();
		try {
			EastYgbTmp eastYgbTmp = (EastYgbTmp) rootDAO.query(EastYgbTmp.class, id);
			if(eastYgbTmp == null) {
				return false;
			}
		} catch (CommonException e) {
			// TODO Auto-generated catch block
			System.out.println("判断实体是否重复出错");
		}
		return true;
	}

	public void modEntity(EastYgbTmp eastYgbTmp) {
		// TODO Auto-generated method stub
		ROOTDAO rootDAO = ROOTDAOUtils.getROOTDAO();
		try {
			rootDAO.update(	eastYgbTmp);
			System.out.println(this.getClass().getName()+" 已插入或更新实体");
		} catch (CommonException e) {
			System.out.println(this.getClass().getName()+" 插入或更新实体出错！ ");
			e.printStackTrace();
		}
	}
		

	
	//author  by 通过id来获取实体类
	 public EastYgbTmp  selectById(String id){
		  ROOTDAO rootdao=ROOTDAOUtils.getROOTDAO();
		  EastYgbTmp  eastYgbTmp = null;
		  try {
			
			  eastYgbTmp=  (EastYgbTmp)rootdao.query(EastYgbTmp.class, id);
			 
			 	} catch (CommonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return eastYgbTmp;
	  }

	
}
