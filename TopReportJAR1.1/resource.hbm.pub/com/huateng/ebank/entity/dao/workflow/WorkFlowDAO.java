package com.huateng.ebank.entity.dao.workflow;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import resource.dao.base.HQLDAO;

import com.huateng.ebank.business.common.DAOUtils;
import com.huateng.ebank.framework.util.DataFormat;
import com.huateng.topbpm.commonface.base.WIFlowInstance;
import com.huateng.topbpm.commonface.base.WIPageQueryResult;
import com.huateng.topbpm.commonface.base.WITask;
import com.huateng.topbpm.commonface.base.WIWorkflow;
import com.huateng.topbpm.commonface.base.WIWorkflowFactory;
import com.huateng.topbpm.commonface.exception.WIException;

/**
 * Title: TOPBPMWorkFlowDAO Description: Copyright: Copyright (c) 2008 Company:
 * Shanghai Huateng Software Systems Co., Ltd.
 *
 * @author shen_antonio
 * @version 1.1, 2008-4-2
 */
public class WorkFlowDAO extends HibernateDaoSupport {

	/**
	 * 启动流程
	 *
	 * @param userName
	 *            启动流程用户名
	 * @param pwd
	 *            启动流程用户密码
	 * @param assignUserNmList
	 *            分配下一步任务列表(允许为空，默认为由工作流异步分配），
	 *            如果List中只有一个元素的情况下，直接将该操作员分配给任务拥有者，多个情况分配给任务潜在用户
	 * @param flowName
	 *            启动流程名
	 * @param version
	 *            启动流程版本(允许为NULL,默认为最新流程版本） ,FLOW_LAST_VERSION
	 * @param status
	 *            启动流程操作(允许为NULL,为默认操作)
	 * @param attribute
	 *            流程参数
	 * @param key
	 *            作为快速查询所用的key
	 * @return WIFlowInstance 流程实例类
	 * @throws WIException
	 */
	public WIFlowInstance startFlow(String userName, String pwd,
			List assignUserNmList, String flowName, String version,
			String status, Map attribute, String key) throws WIException {
		Session session = this.getHibernateTemplate().getSessionFactory()
				.getCurrentSession();
		WIWorkflow wiWorkflow = WIWorkflowFactory.getInstance(session);
		WIFlowInstance wiFlowInstance = wiWorkflow.startFlow(userName, pwd,
				assignUserNmList, flowName, version, status, attribute, key);
//		session.flush();
		try {
			session.connection().commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return wiFlowInstance;
	}

	/**
	 * 操作任务
	 *
	 * @param userName
	 *            操作用户名
	 * @param password
	 *            操作用户密码
	 * @param taskId
	 *            任务号
	 * @param assignUserNmList
	 *            分配下一步任务列表(允许为空，默认为由工作流异步分配），
	 *            如果List中只有一个元素的情况下，直接将该操作员分配给任务拥有者，多个情况分配给任务潜在用户
	 * @param status
	 *            任务操作
	 * @param valueMap
	 *            任务值
	 * @return 下部任务
	 * @param comment
	 *            执行任务留言(允许为NULL)
	 * @throws WIException
	 */
	public WITask doTask(String userName, String password, String taskId,
			List assignUserNameList, String status, Map valueMap, String comment)
			throws WIException {
		Session session = this.getHibernateTemplate().getSessionFactory()
				.getCurrentSession();
		WIWorkflow wiWorkflow = WIWorkflowFactory.getInstance(session);
		WITask wiTask = wiWorkflow.doTask(DataFormat.trim(userName), DataFormat.trim(password), DataFormat.trim(taskId),
				assignUserNameList, DataFormat.trim(status), valueMap, DataFormat.trim(comment));
		return wiTask;
	}

	/**
	 * 转交节点
	 *
	 * @param taskId
	 *            任务号
	 * @param newUserName
	 *            新分配的用户
	 * @throws WIException
	 */
	public void forwardTask(String taskId, String newUserName)
			throws WIException {
		Session session = this.getHibernateTemplate().getSessionFactory()
				.getCurrentSession();
		WIWorkflow wiWorkflow = WIWorkflowFactory.getInstance(session);
		wiWorkflow.forwardTask(taskId, newUserName);
	}

	/**
	 * 转交该用户所有的任务给指定的人
	 *
	 * @param userName
	 *            待移交任务的用户名
	 * @param password
	 *            待移交任务的用户密码
	 * @param newUserName
	 *            给予任务用户名
	 * @throws WIException
	 */
	public void forwardAllTask(String userName, String password,
			String newUserName) throws WIException {
		Session session = this.getHibernateTemplate().getSessionFactory()
				.getCurrentSession();
		WIWorkflow wiWorkflow = WIWorkflowFactory.getInstance(session);
		wiWorkflow.forwardAllTask(userName, password, newUserName);
	}

	/** modified by jornezhang 20100805 begin */
	/**
	 * 修改代办任务查询，改成分页查询，可以通过Map传参数，进行分页查询
	 * */
	/**
	 * 列出用户所有的任务
	 *
	 * @param userName
	 *            用户名(允许为空，默认是所有用户）
	 * @param password
	 *            用户密码(允许为空，默认是所有用户）
	 * @param pageIndex 当前页
	 * @param pageSize 一页显示多少条记录
	 * @param transMap 参数
	 * @return List<WITask>
	 * @throws WIException
	 */
	public WIPageQueryResult getTaskList(String userName, String password, String taskState ,Integer pageIndex,Integer pageSize,Map transMap)
			throws WIException {
		Session session = this.getHibernateTemplate().getSessionFactory()
				.getCurrentSession();
		WIWorkflow wiWorkflow = WIWorkflowFactory.getInstance(session);
		return wiWorkflow.getTaskList(userName, password, taskState, pageIndex, pageSize, transMap);
	}

	/**
	 * 列出指定用户和流程类型的任务类表
	 *
	 * @param userName
	 *            用户名(允许为空，默认是所有用户）
	 * @param password
	 *            用户密码(允许为空，默认是所有用户）
	 * @param flowName
	 *            流程名
	 * @param version
	 *            流程版本号（允许为空，默认获取最近版本）,或者FLOW_ALL_VERSION，FLOW_LAST_VERSION
	 * @return List<WITask>
	 * @throws WIException
	 */
	public WIPageQueryResult getTaskList(String userName, String password, String flowName,
			String version, String taskState, Integer pageIndex,Integer pageSize,Map transMap) throws WIException {
//		Session session = this.getHibernateTemplate().getSessionFactory()
//				.getCurrentSession();
		WIPageQueryResult taslList = new WIPageQueryResult();
		Session session = null;
		HQLDAO hqlDAO = DAOUtils.getHQLDAO();
		try{
			session = hqlDAO.getSessionFactory().openSession();
			WIWorkflow wiWorkflow = WIWorkflowFactory.getInstance(session);

			taslList = wiWorkflow.getTaskList(DataFormat.trim(userName), DataFormat.trim(password), DataFormat.trim(flowName), DataFormat.trim(version),
					null, DataFormat.trim(taskState) , pageIndex, pageSize, transMap);
		} catch (WIException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}
		finally{
			try{
				if(session != null && session.isOpen()){
					session.close();
				}
			}catch(Exception e){
				logger.error("close session error",e);
			}
		}
		return taslList;
	}

	/**
	 * 列出指定用户、流程和任务的任务类表
	 *
	 * @param userName
	 *            用户名(允许为空，默认是所有用户）
	 * @param password
	 *            用户密码(允许为空，默认是所有用户）
	 * @param flowName
	 *            流程名
	 * @param version
	 *            流程版本号（允许为空，默认获取最近版本）,或者FLOW_ALL_VERSION，FLOW_LAST_VERSION
	 * @param taskName
	 *            任务名
	 * @return
	 * @throws WIException
	 */
	public WIPageQueryResult getTaskList(String userName, String password, String flowName,
			String version, String taskName, String taskState, Integer pageIndex,Integer pageSize,Map transMap)
			throws WIException {
		Session session = this.getHibernateTemplate().getSessionFactory()
				.getCurrentSession();
		WIWorkflow wiWorkflow = WIWorkflowFactory.getInstance(session);
		return wiWorkflow.getTaskList(userName, password, flowName, version,
				taskName, taskState, pageIndex, pageSize, transMap);
	}
	/** modified by jornezhang 20100805 end */

	/**
	 * 列出系统中某个工作流流程的所有实例
	 *
	 * @param userName
	 *            用户名用户名(允许为空，默认是所有用户）
	 * @param password
	 *            用户密码(允许为空，默认是所有用户）
	 * @param flowName
	 *            流程名(允许为空,默认所有流程)
	 * @param version
	 *            启动流程版本(允许为空,默认为最新流程版本）,或者FLOW_ALL_VERSION，FLOW_LAST_VERSION
	 * @param key
	 *            流程实例快速查询Key(允许为空）
	 * @return List<WIFlowInstance>
	 * @throws WIException
	 */
	public List getFlowInstanceList(String userName, String password,
			String flowName, String version, String key) throws WIException {
		Session session = this.getHibernateTemplate().getSessionFactory()
				.getCurrentSession();
		WIWorkflow wiWorkflow = WIWorkflowFactory.getInstance(session);
		return wiWorkflow.getFlowInstanceList(userName, password, flowName,
				version, key);
	}

	/**
	 * 获取指定流程号的流程信息
	 *
	 * @param flowInsId
	 *            流程号
	 * @return WIFlowInstance
	 * @throws WIException
	 */
	public WIFlowInstance getFlowInstance(String flowInsId) throws WIException {
		Session session = this.getHibernateTemplate().getSessionFactory()
				.getCurrentSession();
		WIWorkflow wiWorkflow = WIWorkflowFactory.getInstance(session);
		return wiWorkflow.getFlowInstance(flowInsId);
	}

	/**
	 * 关闭流程实例
	 *
	 * @param flowInsId
	 *            流程实例号
	 * @throws WIException
	 */
	public void closeFlowInstance(String flowInsId) throws WIException {
		Session session = this.getHibernateTemplate().getSessionFactory()
				.getCurrentSession();
		WIWorkflow wiWorkflow = WIWorkflowFactory.getInstance(session);
		wiWorkflow.closeFlowInstance(flowInsId);
	}

	/**
	 * @param taskId
	 *            任务号
	 * @return 任务变量值Map
	 * @throws WIException
	 */
	public Map getValue(String taskId) throws WIException {
		Session session = this.getHibernateTemplate().getSessionFactory()
				.getCurrentSession();
		WIWorkflow wiWorkflow = WIWorkflowFactory.getInstance(session);
		return wiWorkflow.getValue(taskId);
	}

	/**
	 * 修改节点所有变量的值
	 *
	 * @param taskId
	 *            任务号
	 * @param value
	 *            变量的值Map
	 * @throws WIException
	 */
	public void setValue(String taskId, Map value) throws WIException {
		Session session = this.getHibernateTemplate().getSessionFactory()
				.getCurrentSession();
		WIWorkflow wiWorkflow = WIWorkflowFactory.getInstance(session);
		wiWorkflow.setValue(taskId, value);
	}

	/**
	 * 声明任务节点
	 *
	 * @param userName
	 *            任务操作者
	 * @param taskId
	 *            任务号
	 * @throws WIException
	 */
	public void lockTask(String userName, String taskId) throws WIException {
		Session session = this.getHibernateTemplate().getSessionFactory()
				.getCurrentSession();
		WIWorkflow wiWorkflow = WIWorkflowFactory.getInstance(session);
		wiWorkflow.lockTask(userName, taskId);
	}

	/**
	 * 取消声明节点
	 *
	 * @param taskId
	 *            任务号
	 * @return
	 */
	public void releaseTask(String taskId) throws WIException {
		Session session = this.getHibernateTemplate().getSessionFactory()
				.getCurrentSession();
		WIWorkflow wiWorkflow = WIWorkflowFactory.getInstance(session);
		wiWorkflow.releaseTask(taskId);
	}

	/**
	 * 保留节点
	 *
	 * @param taskId
	 *            任务号
	 * @return
	 * @exception WIException
	 *                任务不存在
	 */
	public void keepTask(String taskId) throws WIException {
		Session session = this.getHibernateTemplate().getSessionFactory()
				.getCurrentSession();
		WIWorkflow wiWorkflow = WIWorkflowFactory.getInstance(session);
		wiWorkflow.keepTask(taskId);
	}
	/**
	 * 获取任务信息
	 *
	 * @param taskId
	 *            任务号
	 * @return
	 * @exception WIException
	 *                任务不存在
	 */
	public WITask getTask(String taskId)throws WIException{
		Session session = this.getHibernateTemplate().getSessionFactory().getCurrentSession();
		WIWorkflow wiWorkflow = WIWorkflowFactory.getInstance(session);
		return wiWorkflow.getTask(taskId);
	}


}
