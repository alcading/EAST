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
import resources.east.data.pub.EastGrjcxx;
import resources.east.data.pub.EastGrjcxxPK;

/**
 * 
 * @author luqh
 * @date 2017.8.12
 *
 */
public class EastGrjcxxService {
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

	public static EastGrjcxxService getInstance() {
		return (EastGrjcxxService) ApplicationContextUtils.getBean("EastGrjcxxService");
	}

	public PageQueryResult pageQueryByHql(int pageIndex, int pageSize) {
		ROOTDAO rootDAO = ROOTDAOUtils.getROOTDAO();
		PageQueryResult pageQueryResult = null;
		PageQueryCondition queryCondition = new PageQueryCondition();
		String hql = "from EastGrjcxx Grjcxx   ";
		try {
			queryCondition.setQueryString(hql);
			queryCondition.setPageIndex(pageIndex);
			queryCondition.setPageSize(pageSize);
			pageQueryResult = rootDAO.pageQueryByQL(queryCondition);
		} catch (CommonException e) {
			e.printStackTrace();
		}
		return pageQueryResult;
	}

	// 获得要操作的Item
	@SuppressWarnings("rawtypes")
	public Iterator selectByid(String id) {

		ROOTDAO rootDAO = ROOTDAOUtils.getROOTDAO();

		try {
			return rootDAO.queryByQL("from EastGrjcxx eastGrjcxx where eastGrjcxx.id='" + id + "'");
			// return rootDAO.queryBySQL("select * from sys_params where
			// PARAMGROUP_ID ='"+paramgroupid+"' and PARAM_ID='"+paramid+"'"
			// );
		} catch (CommonException e) {
			e.printStackTrace();
			return null;
		}

	}

	// 通过id来获取实体类
	public EastGrjcxx selectById(String id) {
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		EastGrjcxx eastGrjcxx = null;
		try {

			eastGrjcxx = (EastGrjcxx) rootdao.query(EastGrjcxx.class, id);

		} catch (CommonException e) {
			e.printStackTrace();
		}

		return eastGrjcxx;
	}

	/*
	 * 删除实体
	 * 
	 * @param biNationregion
	 */
	public void removeEntity(EastGrjcxx eastGrjcxx) {
		ROOTDAO rootDAO = ROOTDAOUtils.getROOTDAO();
		try {
			rootDAO.delete(eastGrjcxx);
			System.out.println("已删除");
		} catch (CommonException e) {
			System.out.println("删除实体出错！ ");
			e.printStackTrace();
		}
	}

	public void addEntity(EastGrjcxx eastGrjcxx) throws CommonException {
		ROOTDAO rootDAO = ROOTDAOUtils.getROOTDAO();
		if (isExists(eastGrjcxx.getId())) {
			ExceptionUtil.throwCommonException(" 机构重复");
		}
		try {
			rootDAO.save(eastGrjcxx);

			System.out.println(this.getClass().getName() + " 已插入实体");
		} catch (CommonException e) {
			System.out.println(this.getClass().getName() + " 插入实体出错！ ");
		}
	}

	public void modEntity(EastGrjcxx eastGrjcxx) {
		ROOTDAO rootDAO = ROOTDAOUtils.getROOTDAO();
		try {
			rootDAO.update(eastGrjcxx);
			System.out.println(this.getClass().getName() + " 已更新实体");
		} catch (CommonException e) {
			System.out.println(this.getClass().getName() + " 更新实体出错！ ");
			e.printStackTrace();
		}
	}

	public boolean isExists(EastGrjcxxPK id) {
		ROOTDAO rootDAO = ROOTDAOUtils.getROOTDAO();
		try {
			EastGrjcxx bd = (EastGrjcxx) rootDAO.query(EastGrjcxx.class, id);
			if (bd == null) {
				return false;
			}
		} catch (CommonException e) {
			System.out.println("判断实体是否重复出错");
		}
		return true;
	}
}
