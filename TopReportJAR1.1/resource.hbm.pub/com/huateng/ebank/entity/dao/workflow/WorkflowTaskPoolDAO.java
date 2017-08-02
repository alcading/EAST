package com.huateng.ebank.entity.dao.workflow;

import java.util.List;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.huateng.ebank.business.common.ErrorCode;
import com.huateng.ebank.entity.data.workflow.WorkflowTaskPool;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ExceptionUtil;

public class WorkflowTaskPoolDAO extends HibernateDaoSupport {
	public void insert(WorkflowTaskPool po) throws CommonException {
		try{
			this.getHibernateTemplate().save(po);
		}catch(Exception e){
			ExceptionUtil.throwCommonException("工作流表插入错误", ErrorCode.ERROR_CODE_WORKFLOW_INSERT, e);
		}
	}

	public void update(WorkflowTaskPool po) throws CommonException{
		try{
			this.getHibernateTemplate().update(po);
		}catch(Exception e){
			ExceptionUtil.throwCommonException("工作流表更新错误", ErrorCode.ERROR_CODE_WORKFLOW_UPDATE, e);
		}
	}

	public void delete(WorkflowTaskPool po) throws CommonException{
		try{
			this.getHibernateTemplate().delete(po);
		}catch(Exception e){
			ExceptionUtil.throwCommonException("工作流表删除错误", ErrorCode.ERROR_CODE_WORKFLOW_DELETE, e);
		}
	}

	public void delete(Long id) throws CommonException{
		try{
			WorkflowTaskPool po = (WorkflowTaskPool)this.getHibernateTemplate().load(WorkflowTaskPool.class, id);
			delete(po);
		}catch(Exception e){
			ExceptionUtil.throwCommonException("工作流表删除错误", ErrorCode.ERROR_CODE_WORKFLOW_DELETE, e);
		}
	}

	public WorkflowTaskPool queryById(Long id) throws CommonException{
		try{
			WorkflowTaskPool po = (WorkflowTaskPool)this.getHibernateTemplate().load(WorkflowTaskPool.class, id);
			return po;
		}catch(Exception e){
			ExceptionUtil.throwCommonException("工作流表修改错误", ErrorCode.ERROR_CODE_WORKFLOW_SELECT, e);
			return null;
		}
	}

	public List queryByCondition(String whereString, Object[] objList) throws CommonException{
		try{
			List list = this.getHibernateTemplate().find("from WorkflowTaskPool po where " + whereString, objList);
			return list;
		}catch(Exception e){
			ExceptionUtil.throwCommonException("工作流表修改错误", ErrorCode.ERROR_CODE_WORKFLOW_SELECT, e);
			return null;
		}
	}
	/**
	 * 根据输入的条件查询所有符合条件的记录
	 *
	 * @param whereString
	 * @return 包含LntypeInfo对象的List
	 * @throws CommonException
	 */
	public List queryByCondition(String whereString) throws CommonException {
		try {
			List list = this.getHibernateTemplate().find(
					"from WorkflowTaskPool po where " + whereString);
			return list;
		} catch (Exception e) {
			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_LNTYPE_INFO_SELECT, e);
		}
		return null;
	}
	/**
	 * 根据procInsId查询记录，如果没有找到记录，则抛出异常
	 * @param procInsId
	 * @return WorkflowTaskPool
	 * @throws CommonException
	 * 	Added by UU_Wu	2008-8-15
	 */
	public List queryByProcInsId(String procInsId) throws CommonException {
		try {
			List list = queryByCondition("po.procInsId = '" + procInsId + "'");
			return list;
		} catch (Exception e) {
			ExceptionUtil.throwCommonException("工作流任务信息表查询错误-" + e.getMessage(),
					ErrorCode.ERROR_CODE_DAO, e);
		}
		return null;
	}

	/**
	 * 根据业务主键taskId查询记录，如果没有找到记录，则抛出异常
	 * @param taskId
	 * @return WorkflowTaskPool
	 * @throws CommonException
	 * 	Added by UU_Wu	2008-8-15
	 */
	public WorkflowTaskPool queryByTask(String taskName,String procInsId) throws CommonException {
		try {
			List list = queryByCondition("po.procInsId = '" + procInsId + "' and po.taskName = '"+taskName+"' ");
			  if (list.size() == 1){
				  return (WorkflowTaskPool) list.get(0);
			  }
		} catch (Exception e) {
			ExceptionUtil.throwCommonException("工作流任务信息表查询错误-" + e.getMessage(),
					ErrorCode.ERROR_CODE_DAO, e);
		}
		ExceptionUtil.throwCommonException("工作流任务信息表查询错误-该[proc_ins_id = " + procInsId +
				" , task_name = " + taskName + "]任务记录失败",ErrorCode.ERROR_CODE_TASK_FORWARD_ERROR);
		return null;
	}

	/**
	 * 根据业务主键taskId查询记录，如果没有找到记录，则抛出异常
	 * @param taskId
	 * @return WorkflowTaskPool
	 * @throws CommonException
	 * 	Added by UU_Wu	2008-8-15
	 */
	public WorkflowTaskPool queryByTaskId(String taskId) throws CommonException {
		try {
//			 List list = queryByCondition("po.taskId = '" + taskId + "'");
			List list = this.getHibernateTemplate().find(
					"from WorkflowTaskPool po where po.taskId = '" + taskId + "'" );
			  if (list.size() == 1)
	                return (WorkflowTaskPool) list.get(0);
		} catch (Exception e) {
			ExceptionUtil.throwCommonException("工作流任务信息表查询错误-" + e.getMessage(),
					ErrorCode.ERROR_CODE_DAO, e);
		}
		return null;
	}
}
