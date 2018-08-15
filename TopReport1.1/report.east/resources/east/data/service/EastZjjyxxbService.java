package resources.east.data.service;

import java.util.Iterator;

import com.huateng.ebank.business.common.PageQueryCondition;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.business.management.common.DAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;
import com.huateng.ebank.framework.util.ExceptionUtil;

import resource.dao.base.HQLDAO;
import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;
import resources.east.data.pub.EastZjjyxxb;
import resources.east.data.pub.EastZjjyxxbPK;

/**
 * 
 * @author luqh
 * @date 2017.8.12
 *
 */
public class EastZjjyxxbService {
	// 根据查询hql语句进行分页查询
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
	 * 
	 * @param paramgroupId 参数段编号
	 */

	public static EastZjjyxxbService getInstance() {
		return (EastZjjyxxbService) ApplicationContextUtils.getBean("EastZjjyxxbService");
	}

	public PageQueryResult pageQueryByHql(int pageIndex, int maxRows, String hql) throws CommonException {
		ROOTDAO rootDAO = ROOTDAOUtils.getROOTDAO();
		PageQueryResult pageQueryResult = null;
		PageQueryCondition queryCondition = new PageQueryCondition();
		queryCondition.setQueryString(hql);
		queryCondition.setPageIndex(pageIndex);
		queryCondition.setPageSize(maxRows);
		pageQueryResult = rootDAO.pageQueryByQL(queryCondition);
		return pageQueryResult;
	}

	// 获得要操作的Item
	@SuppressWarnings("rawtypes")
	public Iterator selectByid(String id) {

		ROOTDAO rootDAO = ROOTDAOUtils.getROOTDAO();

		try {
			return rootDAO.queryByQL("from EastZjjyxxb eastZjjyxxb where eastZjjyxxb.id='" + id + "'");
			// return rootDAO.queryBySQL("select * from sys_params where
			// PARAMGROUP_ID ='"+paramgroupid+"' and PARAM_ID='"+paramid+"'"
			// );
		} catch (CommonException e) {
			e.printStackTrace();
			return null;
		}

	}

	// 通过id来获取实体类
	public EastZjjyxxb selectById(String id) {
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		EastZjjyxxb eastZjjyxxb = null;
		try {

			eastZjjyxxb = (EastZjjyxxb) rootdao.query(EastZjjyxxb.class, id);

		} catch (CommonException e) {
			e.printStackTrace();
		}

		return eastZjjyxxb;
	}
	
	/*
	 * 删除实体
	 * @param biNationregion
	 */
	public void removeEntity(EastZjjyxxb eastZjjyxxb) {
		ROOTDAO rootDAO = ROOTDAOUtils.getROOTDAO();
		try {
			rootDAO.delete(eastZjjyxxb);
			System.out.println("已删除");
		} catch (CommonException e) {
			System.out.println("删除实体出错！ ");
			e.printStackTrace();
		}
	}
	

	public void addEntity(EastZjjyxxb eastZjjyxxb) throws CommonException {
		ROOTDAO rootDAO = ROOTDAOUtils.getROOTDAO();
		if(isExists(eastZjjyxxb.getId())) {
			ExceptionUtil.throwCommonException(" 重复");
		}
		try {
			rootDAO.save(eastZjjyxxb);
			
			System.out.println(this.getClass().getName()+" 已插入实体");
		} catch (CommonException e) {
			System.out.println(this.getClass().getName()+" 插入实体出错！ ");
		}
	}

	public void modEntity(EastZjjyxxb eastZjjyxxb) {
		ROOTDAO rootDAO = ROOTDAOUtils.getROOTDAO();
		try {
			rootDAO.update(eastZjjyxxb);
			System.out.println(this.getClass().getName()+" 已更新实体");
		} catch (CommonException e) {
			System.out.println(this.getClass().getName()+" 更新实体出错！ ");
			e.printStackTrace();
		}
	}
	
	public boolean isExists(EastZjjyxxbPK id) {
		ROOTDAO rootDAO = ROOTDAOUtils.getROOTDAO();
		try {
			EastZjjyxxb bd = (EastZjjyxxb) rootDAO.query(EastZjjyxxb.class, id);
			if(bd == null) {
				return false;
			}
		} catch (CommonException e) {
			System.out.println("判断实体是否重复出错");
		}
		return true;
	}
}
