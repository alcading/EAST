package resources.east.data.service;

import com.huateng.ebank.business.common.PageQueryCondition;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;

import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;
import resources.east.data.pub.EastProcessLog;

public class EastProcessLogService {
	public PageQueryResult pageQueryByHql(int pageIndex, int pageSize) {
		// TODO Auto-generated method stub
		ROOTDAO rootDAO = ROOTDAOUtils.getROOTDAO();
		PageQueryResult pageQueryResult = null;
		PageQueryCondition queryCondition = new PageQueryCondition();
		String hql = "from EastProcessLog epl where 1=1  ";
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
	 * 获取一个实例
	 * @param paramgroupId 参数段编号
	 */

	public static EastProcessLogService getInstance() {
		// TODO Auto-generated method stub
		return (EastProcessLogService)ApplicationContextUtils.getBean("EastProcessLogService");
	}
	

	
//  通过id来获取实体类
	 public EastProcessLog  selectById(String id){
		  ROOTDAO rootdao=ROOTDAOUtils.getROOTDAO();
		  EastProcessLog  evr = null;
		  try {
			
			  evr=  (EastProcessLog)rootdao.query(EastProcessLog.class, id);
			 
			 	} catch (CommonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return evr;
	  }
}
