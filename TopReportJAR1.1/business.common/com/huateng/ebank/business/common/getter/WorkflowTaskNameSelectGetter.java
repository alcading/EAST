package com.huateng.ebank.business.common.getter;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import resource.dao.base.HQLDAO;

import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.BaseDAOUtils;
import com.huateng.ebank.framework.util.DataFormat;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;
import com.huateng.topbpm.TopBPMConfiguration;
import com.huateng.topbpm.TopBPMContext;
import com.huateng.topbpm.graph.def.Node;
import com.huateng.topbpm.graph.def.ProcessDefinition;


public class WorkflowTaskNameSelectGetter extends BaseGetter {

	/*
	 * (non-Javadoc)
	 *
	 * @see com.huateng.commquery.process.call._CallGetter#call()
	 */

	@Override
	public Result call() throws AppException {
		// TODO Auto-generated method stub
		List list = new ArrayList();
		HQLDAO dao = BaseDAOUtils.getHQLDAO();
		/** add by jornezhang 2009-11-2 BMS-2169 对(BMS-2144)部分内容恢复 begin */
		/** add by jornezhang BMS-2144 数据库操作不合理的地方修复 begin */
		Session session = dao.getHibernateTemplate().getSessionFactory().openSession();
		//Session session = dao.getHibernateTemplate().getSessionFactory().getCurrentSession();
		/** add by jornezhang BMS-2144 数据库操作不合理的地方修复 end */
		/** add by jornezhang 2009-11-2 BMS-2169 对(BMS-2144)部分内容恢复 end */
		try {
			String procName = DataFormat.trim(this.getCommQueryServletRequest().getParameter("procNameQuery"));
			TopBPMConfiguration topbpmConfiguration = TopBPMConfiguration.getInstance();

			TopBPMContext topBPMContext= topbpmConfiguration.createTopBPMContext();
			topBPMContext.setSession(session);
			List nodelist = new ArrayList();
			List resultlist = new ArrayList();
			if(procName != null && (!procName.equals(""))){
				ProcessDefinition processDefinition = new ProcessDefinition();
				processDefinition = topBPMContext.getGraphSession().findLatestProcessDefinition(procName);
				nodelist = processDefinition.getNodes();
				for(int i =0;i<nodelist.size();i++){
					Node node = (Node) nodelist.get(i);
					String nodeName = node.getName();
					String desc = node.getDescription();
					if(!(nodeName.equals("Start")||nodeName.equals("End"))){
						resultlist.add(node);
					}
				}
			}


//		String value = DataFormat.trim(getCommQueryServletRequest()
//				.getParameter("value"));
//		int pageSize = this.getResult().getPage().getEveryPage();
//		int pageIndex = this.getResult().getPage().getCurrentPage();
//
//		PageQueryCondition condition = new PageQueryCondition();
//		condition.setPageIndex(1);
//		condition.setPageSize(99999);
//
//		StringBuffer hql = new StringBuffer();
//
//		hql.append("select po from BranchInfo po where (po.brhNo like '"+value+"' or po.brhName like '"+value+"' and po.brhAttr = '0')");
//
//		condition.setQueryString(hql.toString());
//
//		PageQueryResult result = DAOUtils.getHQLDAO().pageQueryByQL(condition);
////		int pageCount = result.getPageCount(pageSize);
//
//		Iterator it = result.getQueryResult().iterator();
//
//		while (it.hasNext()) {
//			Object[] obj = (Object[]) it.next();
//			list.add(obj[0]);
//		}

			ResultMng.fillResultByList(getCommonQueryBean(),
					getCommQueryServletRequest(), resultlist, getResult());
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
