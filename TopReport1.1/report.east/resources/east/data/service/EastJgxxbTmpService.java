package resources.east.data.service;

import java.util.List;

import com.huateng.ebank.business.common.PageQueryCondition;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.business.management.common.DAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;
import com.huateng.ebank.framework.util.ExceptionUtil;

import resource.dao.base.HQLDAO;
import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;
import resources.east.data.pub.EastJgxxbTmp;
/**
 * 
 * @author luqh
 * @date 2017.8.12
 *
 */
public class EastJgxxbTmpService {
   //根据查询hql语句进行分页查询
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

	public static EastJgxxbTmpService getInstance() {
		// TODO Auto-generated method stub
		return (EastJgxxbTmpService)ApplicationContextUtils.getBean("EastJgxxbTmpService");
	}
	

	public PageQueryResult pageQueryByHql(int pageIndex, int pageSize) {
		// TODO Auto-generated method stub
		ROOTDAO rootDAO = ROOTDAOUtils.getROOTDAO();
		PageQueryResult pageQueryResult = null;
		PageQueryCondition queryCondition = new PageQueryCondition();
		String hql = "from EastJgxxbTmp jgxxb where 1=1  ";
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
			EastJgxxbTmp bder = (EastJgxxbTmp) list.get(i);
			list.set(i, bder);
		}
		return list;
	}

	/*
	 * 删除实体
	 * @param biNationregion
	 */
	public void removeEntity(EastJgxxbTmp eastJgxxb) {
		ROOTDAO rootDAO = ROOTDAOUtils.getROOTDAO();
		try {
			rootDAO.delete(eastJgxxb);
			System.out.println("已删除");
		} catch (CommonException e) {
			System.out.println("删除实体出错！ ");
			e.printStackTrace();
		}
	}
	

	public void addEntity(EastJgxxbTmp eastJgxxb) throws CommonException {
		// TODO Auto-generated method stub
		ROOTDAO rootDAO = ROOTDAOUtils.getROOTDAO();
		if(isExists(eastJgxxb.getId())) {
			ExceptionUtil.throwCommonException(" 机构重复");
		}
		try {
			rootDAO.save(eastJgxxb);
			
			System.out.println(this.getClass().getName()+" 已插入或更新实体");
		} catch (CommonException e) {
			System.out.println(this.getClass().getName()+" 插入或更新实体！ ");
		}
	}
	

	public boolean isExists(String id) {
		ROOTDAO rootDAO = ROOTDAOUtils.getROOTDAO();
		try {
			EastJgxxbTmp bd = (EastJgxxbTmp) rootDAO.query(EastJgxxbTmp.class, id);
			if(bd == null) {
				return false;
			}
		} catch (CommonException e) {
			// TODO Auto-generated catch block
			System.out.println("判断实体是否重复出错");
		}
		return true;
	}

	public void modEntity(EastJgxxbTmp eastJgxxb) {
		ROOTDAO rootDAO = ROOTDAOUtils.getROOTDAO();
		try {
			rootDAO.update(	eastJgxxb);
			System.out.println(this.getClass().getName()+" 已插入或更新实体");
		} catch (CommonException e) {
			System.out.println(this.getClass().getName()+" 插入或更新实体出错！ ");
			e.printStackTrace();
		}
	}
		
	
	//  通过id来获取实体类
	 public EastJgxxbTmp  selectById(String id){
		  ROOTDAO rootdao=ROOTDAOUtils.getROOTDAO();
		  EastJgxxbTmp  eastJgxxb = null;
		  try {
			
			  eastJgxxb=  (EastJgxxbTmp)rootdao.query(EastJgxxbTmp.class, id);
			 
			 	} catch (CommonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return eastJgxxb;
	  }
	  


	

		

}
