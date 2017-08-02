package com.huateng.ebank.entity.dao.workflow;

import java.util.List;

import org.hibernate.type.Type;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.huateng.ebank.business.common.ErrorCode;
import com.huateng.ebank.entity.data.workflow.WorkflowParamBinding;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ExceptionUtil;

public class WorkflowParamBindingDAO extends HibernateDaoSupport {

	public void insert(WorkflowParamBinding po) throws CommonException {
		try{
			this.getHibernateTemplate().saveOrUpdate(po);
		}catch(Exception e){
			ExceptionUtil.throwCommonException("工作流表插入错误", ErrorCode.ERROR_CODE_WORKFLOW_INSERT, e);
		}
	}

	public void update(WorkflowParamBinding po) throws CommonException{
		try{
			this.getHibernateTemplate().update(po);
		}catch(Exception e){
			ExceptionUtil.throwCommonException("工作流表更新错误", ErrorCode.ERROR_CODE_WORKFLOW_UPDATE, e);
		}
	}

	public void delete(WorkflowParamBinding po) throws CommonException{
		try{
			this.getHibernateTemplate().delete(po);
		}catch(Exception e){
			ExceptionUtil.throwCommonException("工作流表删除错误", ErrorCode.ERROR_CODE_WORKFLOW_DELETE, e);
		}
	}

	public void delete(Long id) throws CommonException{
		try{
			WorkflowParamBinding po = (WorkflowParamBinding)this.getHibernateTemplate().load(WorkflowParamBinding.class, id);
			delete(po);
		}catch(Exception e){
			ExceptionUtil.throwCommonException("工作流表删除错误", ErrorCode.ERROR_CODE_WORKFLOW_DELETE, e);
		}
	}

	public WorkflowParamBinding queryById(Long id) throws CommonException{
		try{
			WorkflowParamBinding po = (WorkflowParamBinding)this.getHibernateTemplate().load(WorkflowParamBinding.class, id);
			return po;
		}catch(Exception e){
			ExceptionUtil.throwCommonException("工作流表修改错误", ErrorCode.ERROR_CODE_WORKFLOW_SELECT, e);
			return null;
		}
	}

	public List queryByCondition(String whereString, Object[] objList) throws CommonException{
		try{
			List list = this.getHibernateTemplate().find("from WorkflowParamBinding po where " + whereString, objList);
			return list;
		}catch(Exception e){
			ExceptionUtil.throwCommonException("工作流表修改错误", ErrorCode.ERROR_CODE_WORKFLOW_SELECT, e);
			return null;
		}
	}

	public List queryAll() throws CommonException{
		try{
			List list = this.getHibernateTemplate().find("from WorkflowParamBinding");
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
	 * @return 包含WorkflowParam对象的List
	 * @throws CommonException
	 */
	public List queryByCondition(String whereString) throws CommonException {
		try {
			List list = this.getHibernateTemplate().find(
					"from WorkflowParamBinding po where " + whereString);
			return list;
		} catch (Exception e) {
			ExceptionUtil.throwCommonException("工作流表查询错误",
					ErrorCode.ERROR_CODE_WORKFLOW_SELECT, e);
		}
		return null;
	}
	
	 /**
     * 根据输入的条件查询所有符合条件的记录
     *
     * @param whereString
     * @param objArray
     * @param typeArray
     * @return 包含LimitParam对象的List
     * @throws CommonException
     */
    public List queryByCondition(String whereString, Object[] objArray,
            Type[] typeArray) throws CommonException {
        try {
            List list = this.getHibernateTemplate().find(
                    "from WorkflowParamBinding po where " + whereString, objArray);
            return list;
        } catch (Exception e) {
            ExceptionUtil.throwCommonException(e.getMessage(),
                    ErrorCode.ERROR_CODE_WORKFLOW_PARAM_SELECT, e);
        }
        return null;
    }

}
