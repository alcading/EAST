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
import resources.east.data.pub.EastDgxdywjj;
import resources.east.data.pub.EastDgxdywjjPK;

/**
 * 
 * @author luqh
 * @date 2017.8.12
 *
 */
public class EastDgxdywjjService {
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

		public static EastDgxdywjjService getInstance() {
			return (EastDgxdywjjService) ApplicationContextUtils.getBean("EastDgxdywjjService");
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
				return rootDAO.queryByQL("from EastDgxdywjj A where A.id='" + id + "'");
				// return rootDAO.queryBySQL("select * from sys_params where
				// PARAMGROUP_ID ='"+paramgroupid+"' and PARAM_ID='"+paramid+"'"
				// );
			} catch (CommonException e) {
				e.printStackTrace();
				return null;
			}

		}

		// 通过id来获取实体类
		public EastDgxdywjj selectById(String id) {
			ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
			EastDgxdywjj eastXdhtb = null;
			try {

				eastXdhtb = (EastDgxdywjj) rootdao.query(EastDgxdywjj.class, id);

			} catch (CommonException e) {
				e.printStackTrace();
			}

			return eastXdhtb;
		}

		/*
		 * 删除实体
		 * 
		 * @param biNationregion
		 */
		public void removeEntity(EastDgxdywjj eastXmdkxxb) {
			ROOTDAO rootDAO = ROOTDAOUtils.getROOTDAO();
			try {
				rootDAO.delete(eastXmdkxxb);
				System.out.println("已删除");
			} catch (CommonException e) {
				System.out.println("删除实体出错！ ");
				e.printStackTrace();
			}
		}

		public void addEntity(EastDgxdywjj eastDgxdywjj) throws CommonException {
			ROOTDAO rootDAO = ROOTDAOUtils.getROOTDAO();
			if (isExists(eastDgxdywjj.getId())) {
				ExceptionUtil.throwCommonException(" 机构重复");
			}
			try {
				rootDAO.save(eastDgxdywjj);

				System.out.println(this.getClass().getName() + " 已插入实体");
			} catch (CommonException e) {
				System.out.println(this.getClass().getName() + " 插入实体出错！ ");
			}
		}

		public void modEntity(EastDgxdywjj eastXmdkxxb) {
			ROOTDAO rootDAO = ROOTDAOUtils.getROOTDAO();
			try {
				rootDAO.update(eastXmdkxxb);
				System.out.println(this.getClass().getName() + " 已更新实体");
			} catch (CommonException e) {
				System.out.println(this.getClass().getName() + " 更新实体出错！ ");
				e.printStackTrace();
			}
		}

		public boolean isExists(EastDgxdywjjPK id) {
			ROOTDAO rootDAO = ROOTDAOUtils.getROOTDAO();
			try {
				EastDgxdywjj bd = (EastDgxdywjj) rootDAO.query(EastDgxdywjj.class, id);
				if (bd == null) {
					return false;
				}
			} catch (CommonException e) {
				System.out.println("判断实体是否重复出错");
			}
			return true;
		}
}
