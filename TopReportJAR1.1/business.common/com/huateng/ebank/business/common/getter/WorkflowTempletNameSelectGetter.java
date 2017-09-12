package com.huateng.ebank.business.common.getter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;

import resource.dao.base.HQLDAO;

import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.BaseDAOUtils;
import com.huateng.ebank.business.common.DAOUtils;
import com.huateng.ebank.business.workflow.bean.WorkflowTempletBean;
import com.huateng.ebank.entity.dao.workflow.WorkflowBussTempletRelDAO;
import com.huateng.ebank.entity.data.workflow.WorkflowBussTempletRel;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;
import com.huateng.topbpm.TopBPMConfiguration;
import com.huateng.topbpm.TopBPMContext;
import com.huateng.topbpm.graph.def.ProcessDefinition;


/**
 * @author fubo
 * @company huateng
 * @date 2010-4-19 下午02:42:47
 * @desc 工作流参数设置
 */
public class WorkflowTempletNameSelectGetter extends BaseGetter {

	/*
	 * (non-Javadoc)
	 *
	 * @see com.huateng.commquery.process.call._CallGetter#call()
	 */

	@Override
	public Result call() throws AppException {

		List list = new ArrayList();
		HQLDAO dao = BaseDAOUtils.getHQLDAO();

		Session session = dao.getHibernateTemplate().getSessionFactory().openSession();
		String bussProc = getCommQueryServletRequest().getParameter("bussProc");
		List relList = new ArrayList();
		String templetName = "";

		try {

			WorkflowBussTempletRelDAO WorkflowBussTempletRelDAO = DAOUtils.getWorkflowBussTempletRelDAO();
			relList = WorkflowBussTempletRelDAO.queryByCondition("bussProc = '"+bussProc+"'");
			if(relList!=null&&relList.size()!=0){
				WorkflowBussTempletRel workflowBussTempletRel = new WorkflowBussTempletRel();
				workflowBussTempletRel = (WorkflowBussTempletRel)relList.get(0);
				templetName = workflowBussTempletRel.getTempletName();
			}

			TopBPMConfiguration topbpmConfiguration = TopBPMConfiguration.getInstance();

			TopBPMContext topBPMContext= topbpmConfiguration.createTopBPMContext();
			topBPMContext.setSession(session);

			List proclist = topBPMContext.getGraphSession().findLatestProcessDefinitions();

			List resultList = new ArrayList();
			Iterator iter = proclist.iterator();

			while(iter.hasNext()){
				WorkflowTempletBean outBean = new WorkflowTempletBean();
				ProcessDefinition processDefinition = new ProcessDefinition();
				processDefinition = (ProcessDefinition)iter.next();
				outBean.setId(processDefinition.getId());
				outBean.setName(processDefinition.getName());
				outBean.setDescription(processDefinition.getDescription());
				if(templetName==null){
					outBean.setSelect(false);
				}else{
					if(templetName.equals(processDefinition.getName())){
						outBean.setSelect(true);
					}else{
						outBean.setSelect(false);
					}
				}
				resultList.add(outBean);
			}

			ResultMng.fillResultByList(getCommonQueryBean(),
					getCommQueryServletRequest(), resultList, getResult());
			getResult().setContent(list);
			getResult().getPage().setTotalPage(1);
			getResult().init();
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(session!=null && session.isOpen()){
				session.close();
			}
		}
		return getResult();
	}

}
