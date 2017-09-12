package com.huateng.ebank.entity.dao.workflow;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.type.Type;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.huateng.ebank.business.common.ErrorCode;
import com.huateng.ebank.business.common.PageQueryCondition;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.entity.data.workflow.WorkflowAppInfo;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ExceptionUtil;

public class WorkflowAppInfoDAO extends HibernateDaoSupport {

	public void insert(WorkflowAppInfo po) throws CommonException {
		try{
			this.getHibernateTemplate().save(po);
		}catch(Exception e){
			ExceptionUtil.throwCommonException("工作流表插入错误", ErrorCode.ERROR_CODE_WORKFLOW_INSERT, e);
		}
	}

	public void update(WorkflowAppInfo po) throws CommonException{
		try{
			this.getHibernateTemplate().update(po);
		}catch(Exception e){
			ExceptionUtil.throwCommonException("工作流表更新错误", ErrorCode.ERROR_CODE_WORKFLOW_UPDATE, e);
		}
	}

	public WorkflowAppInfo queryById(String appno) throws CommonException{
		try{
			WorkflowAppInfo po = (WorkflowAppInfo)this.getHibernateTemplate().get(WorkflowAppInfo.class, appno);
			return po;
		}catch(Exception e){
			ExceptionUtil.throwCommonException("工作流表修改错误", ErrorCode.ERROR_CODE_WORKFLOW_SELECT, e);
			return null;
		}
	}

	public List queryByCondition(String whereString, Object[] objList) throws CommonException{
		try{
			List list = this.getHibernateTemplate().find("from WorkflowAppInfo po where " + whereString, objList);
			return list;
		}catch(Exception e){
			ExceptionUtil.throwCommonException("工作流表修改错误", ErrorCode.ERROR_CODE_WORKFLOW_SELECT, e);
			return null;
		}
	}

	/**
	 * 分页查询方法
	 * @return PageQueryResult
	 */
	public PageQueryResult pageQueryByQL(PageQueryCondition queryCondition)
			throws CommonException {
		if (logger.isDebugEnabled()) {
			logger.debug("pageQueryByQL(PageQueryCondition) - start"); //$NON-NLS-1$
		}

		try {
			String queryString = queryCondition.getQueryString();
			queryCondition.setQueryString("from WorkflowAppInfo po where " + queryString);

			PageQueryCallback callback = new PageQueryCallback(queryCondition);

			PageQueryResult returnPageQueryResult = (PageQueryResult) this.getHibernateTemplate().execute(callback);
			if (logger.isDebugEnabled()) {
				logger.debug("pageQueryByQL(PageQueryCondition) - end"); //$NON-NLS-1$
			}
			return returnPageQueryResult;
		} catch (Exception e) {
			logger.error("pageQueryByQL(PageQueryCondition)", e); //$NON-NLS-1$

			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_DAO, e);
		}

		if (logger.isDebugEnabled()) {
			logger.debug("pageQueryByQL(PageQueryCondition) - end"); //$NON-NLS-1$
		}
		return null;
	}

}

/**
*
* 分页查询的回调类.
*/
class PageQueryCallback implements HibernateCallback {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(PageQueryCallback.class);

	private PageQueryCondition queryCondition = null;

	public PageQueryCallback(PageQueryCondition queryCondition) {
		this.queryCondition = queryCondition;
	}

	public Object doInHibernate(Session session) throws HibernateException {
		if (logger.isDebugEnabled()) {
			logger.debug("doInHibernate(Session) - start"); //$NON-NLS-1$
		}

		Query queryObject = session
				.createQuery(queryCondition.getQueryString());
		Object[] values = queryCondition.getObjArray();
		Type[] types = queryCondition.getTypeArray();
		if (null != values) {
			for (int i = 0; i < values.length; i++) {
				if (logger.isDebugEnabled()) {
					logger.debug("i="+i);
					logger.debug("values[i]="+values[i]);
					logger.debug("types[i]="+types[i]);
				}
				if (types != null) {
					queryObject.setParameter(i, values[i], types[i]);
				} else {
					queryObject.setParameter(i, values[i]);
				}
			}
		}

		ScrollableResults sr = null;
		try {
			PageQueryResult queryResult = new PageQueryResult();
			queryResult.setQueryResult(new ArrayList());
			queryResult.setTotalCount(0);

			sr = queryObject.scroll();
			if (false == sr.last()) {

				if (logger.isDebugEnabled()) {
					logger.debug("doInHibernate(Session) - end"); //$NON-NLS-1$
				}
				return queryResult;
			}

			int totalCount = sr.getRowNumber();
			queryResult.setTotalCount(totalCount + 1);

			int pageSize = queryCondition.getPageSize();
			int pageIndex = queryCondition.getPageIndex() - 1;

			int startRowNum = pageIndex * pageSize;
			if (false == sr.setRowNumber(startRowNum)) {
				if (logger.isDebugEnabled()) {
					logger.debug("doInHibernate(Session) - end"); //$NON-NLS-1$
				}
				return queryResult;
			}

			List list = queryResult.getQueryResult();
			for (int i = 0; i < pageSize; i++) {
				list.add(sr.get());
				if (false == sr.next()) {
					break;
				}
			}

			if (logger.isDebugEnabled()) {
				logger.debug("doInHibernate(Session) - end"); //$NON-NLS-1$
			}
			return queryResult;
		} finally {
			if (null != sr)
				sr.close();
		}
	}
}
