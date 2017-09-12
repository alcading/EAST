package resources.east.data.service;

import com.huateng.ebank.business.common.PageQueryCondition;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.business.management.common.DAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;

import resource.dao.base.HQLDAO;
import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;
import resources.east.data.pub.EastJgbb;

public class EastJgbbService {

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

		public static EastJgbbService getInstance() {
			// TODO Auto-generated method stub
			return (EastJgbbService)ApplicationContextUtils.getBean("EastJgbbService");
		}
		

		public PageQueryResult pageQueryByHql(int pageIndex, int pageSize,String eastTable, String eastTableName) {
			// TODO Auto-generated method stub
			ROOTDAO rootDAO = ROOTDAOUtils.getROOTDAO();
			PageQueryResult pageQueryResult = null;
			PageQueryCondition queryCondition = new PageQueryCondition();
			String hql = "from EastJgbb jgbb where 1=1  ";
			if( null != eastTable && !"".equals(eastTable)) {
				hql += ("and jgbb.id like '%"+eastTable.trim()+"%'");
			}
			if(null != eastTableName && !"".equals(eastTableName)) {
				hql += ("and east_table_name like '%"+eastTableName.trim()+"%'");
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

	//  通过id来获取实体类
		 public EastJgbb  selectById(String id){
			  ROOTDAO rootdao=ROOTDAOUtils.getROOTDAO();
			  EastJgbb  eastJgbb = null;
			  try {
				
				  eastJgbb=  (EastJgbb)rootdao.query(EastJgbb.class, id);
				 
				 	} catch (CommonException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return eastJgbb;
		  }
}
