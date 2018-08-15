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
import resources.east.data.pub.EastJyls;
import resources.east.data.pub.EastJylsPK;

/**
 * 
 * @author luqh
 * @date 2017.8.12
 *
 */
public class EastJylsService {
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

	public static EastJylsService getInstance() {
		return (EastJylsService) ApplicationContextUtils.getBean("EastJylsService");
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
			return rootDAO.queryByQL("from EastJyls eastJyls where eastJyls.id='" + id + "'");
			// return rootDAO.queryBySQL("select * from sys_params where
			// PARAMGROUP_ID ='"+paramgroupid+"' and PARAM_ID='"+paramid+"'"
			// );
		} catch (CommonException e) {
			e.printStackTrace();
			return null;
		}

	}

	// 通过id来获取实体类
	public EastJyls selectById(String id) {
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		EastJyls eastJyls = null;
		try {

			eastJyls = (EastJyls) rootdao.query(EastJyls.class, id);

		} catch (CommonException e) {
			e.printStackTrace();
		}

		return eastJyls;
	}
	
	/*
	 * 删除实体
	 * @param biNationregion
	 */
	public void removeEntity(EastJyls eastJyls) {
		ROOTDAO rootDAO = ROOTDAOUtils.getROOTDAO();
		try {
			rootDAO.delete(eastJyls);
			System.out.println("已删除");
		} catch (CommonException e) {
			System.out.println("删除实体出错！ ");
			e.printStackTrace();
		}
	}
	

	public void addEntity(EastJyls eastJyls) throws CommonException {
		ROOTDAO rootDAO = ROOTDAOUtils.getROOTDAO();
		if(isExists(eastJyls.getId())) {
			ExceptionUtil.throwCommonException(" 重复");
		}
		try {
			rootDAO.save(eastJyls);
			
			System.out.println(this.getClass().getName()+" 已插入实体");
		} catch (CommonException e) {
			System.out.println(this.getClass().getName()+" 插入实体出错！ ");
		}
	}

	public void modEntity(EastJyls eastJyls) {
		ROOTDAO rootDAO = ROOTDAOUtils.getROOTDAO();
		try {
			rootDAO.update(eastJyls);
			System.out.println(this.getClass().getName()+" 已更新实体");
		} catch (CommonException e) {
			System.out.println(this.getClass().getName()+" 更新实体出错！ ");
			e.printStackTrace();
		}
	}
	
	public boolean isExists(EastJylsPK id) {
		ROOTDAO rootDAO = ROOTDAOUtils.getROOTDAO();
		try {
			EastJyls bd = (EastJyls) rootDAO.query(EastJyls.class, id);
			if(bd == null) {
				return false;
			}
		} catch (CommonException e) {
			System.out.println("判断实体是否重复出错");
		}
		return true;
	}
}
