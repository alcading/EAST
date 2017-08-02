package com.huateng.ebank.business.common.getter;

import java.util.ArrayList;
import java.util.List;

import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.DAOUtils;
import com.huateng.ebank.entity.dao.workflow.WorkflowBussTempletRelDAO;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;


/**
 * @author fubo
 * @company huateng
 * @date 2010-4-19 下午02:42:47
 * @desc 工作流参数设置
 */
public class WorkflowBussProcNameSelectGetter extends BaseGetter {

	/*
	 * (non-Javadoc)
	 *
	 * @see com.huateng.commquery.process.call._CallGetter#call()
	 */

	@Override
	public Result call() throws AppException {

		List list = new ArrayList();
//		HQLDAO dao = BaseDAOUtils.getHQLDAO();
//
//		Session session = dao.getHibernateTemplate().getSessionFactory().openSession();
//
//
//		try {
//			TopBPMConfiguration topbpmConfiguration = TopBPMConfiguration.getInstance();
//
//			TopBPMContext topBPMContext= topbpmConfiguration.createTopBPMContext();
//			topBPMContext.setSession(session);
//
//			List proclist = topBPMContext.getGraphSession().findLatestProcessDefinitions();

			List resultList = new ArrayList();

			WorkflowBussTempletRelDAO workflowBussTempletRelDAO = DAOUtils.getWorkflowBussTempletRelDAO();
			resultList = workflowBussTempletRelDAO.queryByCondition("1=1");

			ResultMng.fillResultByList(getCommonQueryBean(),
					getCommQueryServletRequest(), resultList, getResult());
			getResult().setContent(list);
			getResult().getPage().setTotalPage(1);
			getResult().init();
//		} catch (RuntimeException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally{
//			if(session!=null && session.isOpen()){
//				session.close();
//			}
//		}
		return getResult();
	}

}
