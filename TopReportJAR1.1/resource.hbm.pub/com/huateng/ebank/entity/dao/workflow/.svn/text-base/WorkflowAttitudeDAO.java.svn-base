/**
 *
 */
package com.huateng.ebank.entity.dao.workflow;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.huateng.ebank.business.common.ErrorCode;
import com.huateng.ebank.entity.data.workflow.WorkflowAttitude;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ExceptionUtil;

/**
 * @author chenjz by 20080812
 *
 */
public class WorkflowAttitudeDAO extends HibernateDaoSupport {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(WorkflowAttitudeDAO.class);

	public WorkflowAttitudeDAO() {
		super();
	}


    /**
	 * 根据输入的条件查询所有符合条件的记录
	 *
	 * @param whereString
	 * @return 包含WorkflowAttitude对象的List
	 * @throws CommonException
	 */
	public List queryByCondition(String whereString) throws CommonException {
		try {
			List list = this.getHibernateTemplate().find(
					"from WorkflowAttitude po where " + whereString);
			return list;
		} catch (Exception e) {
			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_WORKFLOW_GETFLOWINS_ERROR, e);
		}
		return null;
	}



	/**
	 * 更新记录
	 *
	 * @param po
	 * @throws CommonException
	 */
	public void update(WorkflowAttitude po) throws CommonException {
		try {
			this.getHibernateTemplate().update(po);
		} catch (Exception e) {
			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_BHPROC_STEP_UPDATE, e);
		}
	}
	/**
	 * 插入记录
	 *
	 * @param po
	 * @throws CommonException
	 */
	public void insert(WorkflowAttitude po) throws CommonException {
		try {
			this.getHibernateTemplate().save(po);
		} catch (Exception e) {
			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_BHPROC_STEP_INSERT, e);
		}
	}
	/**
	 * 删除记录
	 *
	 * @param po
	 * @throws CommonException
	 */
	public void delete(WorkflowAttitude po) throws CommonException {
		try {
			this.getHibernateTemplate().delete(po);
		} catch (Exception e) {
			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_BHPROC_STEP_DELETE, e);
		}
	}
	/**
	 * 根据Hibernate ID删除记录
	 *
	 * @param id
	 * @throws CommonException
	 */
	public void delete(int id) throws CommonException {
		try {
			this.getHibernateTemplate().delete(query(id));
		} catch (Exception e) {
			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_BHPROC_STEP_DELETE, e);
		}
	}

	/**
	 * 根据Hibernate ID查询记录，如果没有找到记录，则抛出异常
	 *
	 * @param id
	 * @return BhProcStep
	 * @throws CommonException
	 */
	public WorkflowAttitude query(int id) throws CommonException {
		try {
			return (WorkflowAttitude) this.getHibernateTemplate().load(WorkflowAttitude.class,
					new Integer(id));
		} catch (Exception e) {
			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_BHPROC_STEP_SELECT, e);
		}
		return null;
	}
}
