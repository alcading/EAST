package resource.report.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.huateng.ebank.business.common.ErrorCode;
import com.huateng.ebank.business.common.PageQueryCondition;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.business.common.SystemConstant;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ExceptionUtil;

public class ROOTDAO extends resource.dao.base.HQLDAO {

	private static final Logger log = Logger.getLogger(ROOTDAO.class);

	public ROOTDAO() {
		super();

	}

	/**
	 * ���Hibernate ID��ѯ��¼
	 *
	 * @param id
	 * @return Object
	 * @throws CommonException
	 */
	public <T> T query(Class<T> cls, Serializable id) throws CommonException {
		this.getHibernateTemplate().setCacheQueries(true);
		if (log.isDebugEnabled()) {
			log.debug("query(Class,String) - start"); //$NON-NLS-1$
		}
		try {

			Object reObj = this.getHibernateTemplate().get(cls, id);
			if (log.isDebugEnabled()) {
				log.debug("query(Class,String) - end"); //$NON-NLS-1$
			}
			return (T)reObj;
		} catch (Exception e) {
			log.error("query(String)", e); //$NON-NLS-1$

			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_DAO, e);
		}

		if (log.isDebugEnabled()) {
			log.debug("query(Class,String) - end"); //$NON-NLS-1$
		}
		return null;
	}

	/**
	 * �����¼
	 *
	 * @param obj
	 * @return
	 * @throws CommonException
	 */
	public Object save(Object obj) throws CommonException {
		this.getHibernateTemplate().setCacheQueries(false);
		if (log.isDebugEnabled()) {
			log.debug("save(Object) - start"); //$NON-NLS-1$
		}
		Object reObj = null;

		try {
			if (obj != null) {
				reObj = this.getHibernateTemplate().save(obj);
			}
		} catch (Exception e) {
			log.error("save(Object)", e); //$NON-NLS-1$
			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_DAO, e);
		}
		if (log.isDebugEnabled()) {
			log.debug("save(Object) - end"); //$NON-NLS-1$
		}
		return reObj;
	}

	/**
	 * ���¼�¼
	 *
	 * @param po
	 * @throws CommonException
	 */
	public void update(Object obj) throws CommonException {
		this.getHibernateTemplate().setCacheQueries(false);
		if (log.isDebugEnabled()) {
			log.debug("update(Object) - start"); //$NON-NLS-1$
		}

		try {
			this.getHibernateTemplate().update(obj);
		} catch (Exception e) {
			log.error("update(Object)", e); //$NON-NLS-1$

			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_DAO, e);
		}

		if (log.isDebugEnabled()) {
			log.debug("update(Object) - end"); //$NON-NLS-1$
		}
	}

	/**
	 * �������¼�¼
	 *
	 * @param obj
	 * @return
	 * @throws CommonException
	 */
	public Object saveOrUpdate(Object obj) throws CommonException {
		this.getHibernateTemplate().setCacheQueries(false);

		if (log.isDebugEnabled()) {
			log.debug("saveOrUpdate(Object) - start"); //$NON-NLS-1$
		}
		Object reObj = null;
		try {
			reObj = this.getHibernateTemplate().merge(obj);
		} catch (Exception e) {
			log.error("saveOrUpdate(Object)", e); //$NON-NLS-1$

			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_DAO, e);
		}

		if (log.isDebugEnabled()) {
			log.debug("saveOrUpdate(Object) - end"); //$NON-NLS-1$
		}

		return reObj;
	}

	/**
	 * ���ݶ���ɾ��
	 *
	 * @param obj
	 * @throws CommonException
	 */
	public void delete(Object obj) throws CommonException {
		this.getHibernateTemplate().setCacheQueries(false);
		if (log.isDebugEnabled()) {
			log.debug("delete(Object) - start"); //$NON-NLS-1$
		}
		try {
			if (obj != null) {
				this.getHibernateTemplate().delete(obj);
			}
		} catch (Exception e) {
			log.error("save(Object)", e); //$NON-NLS-1$
			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_DAO, e);
		}
		if (log.isDebugEnabled()) {
			log.debug("save(Object) - end"); //$NON-NLS-1$
		}

	}

	/**
	 * ���Hibernate IDɾ���¼
	 *
	 * @param id
	 * @throws CommonException
	 */
	public void delete(Class cls, String id) throws CommonException {
		this.getHibernateTemplate().setCacheQueries(false);
		if (log.isDebugEnabled()) {
			log.debug("delete(Class,String) - start"); //$NON-NLS-1$
		}

		try {
			this.getHibernateTemplate().delete(query(cls, id));
		} catch (Exception e) {
			log.error("delete(Class,String)", e); //$NON-NLS-1$

			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_DAO, e);
		}

		if (log.isDebugEnabled()) {
			log.debug("delete(Class,String) - end"); //$NON-NLS-1$
		}
	}

	/**
	 * ��ҳ��ѯ
	 * @param hql
	 * @param startPage
	 * @param maxRows
	 * @return
	 * @throws CommonException
	 */
	public List pageQueryByHql(String hql, int startPage, int maxRows)
			throws CommonException {
		this.getHibernateTemplate().setCacheQueries(true);
		if (log.isDebugEnabled()) {
			log.debug("pageQueryByHql(String, int, int) - start"); //$NON-NLS-1$
		}

		List returnValue = new ArrayList();
		startPage = startPage >= 1 ? startPage : 1;
		int firstResult = (startPage - 1)
				* (maxRows > 0 ? maxRows : SystemConstant.MAX_ROWS);
		int rows = maxRows;
		rows = (rows == 0 ? SystemConstant.MAX_ROWS : rows);

		try {
			Query query = this.getSession().createQuery(hql);
			query.setFirstResult(firstResult);
			if (rows != -1) {
				query.setMaxResults(rows + 1);
			}
			returnValue = query.list();

		} catch (HibernateException e) {
			log.error("queryByCondition(String, int, int)", e); //$NON-NLS-1$
			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_DAO, e);
		}

		if (log.isDebugEnabled()) {
			log.debug("queryByCondition(String, int, int) - end"); //$NON-NLS-1$
		}
		return returnValue;
	}


	public PageQueryResult pageQueryByHql(int pageIndex, int pageSize, String hql) throws CommonException {
		PageQueryCondition queryCondition = new PageQueryCondition();
		queryCondition.setQueryString(hql);
		queryCondition.setPageIndex(pageIndex);
		queryCondition.setPageSize(pageSize);
		return pageQueryByQL(queryCondition);
	}

	/**
	 * ����hql��ѯ����
	 * @param hql
	 * @return
	 * @throws CommonException
	 */
	public Integer queryByHqlToCount(String hql) throws CommonException{
		return  Integer.parseInt(this.queryByQL(hql).next().toString());
	}

	public Object queryByHqlMax(String hql)  throws CommonException{
		return getSession().createQuery(hql).uniqueResult();
	}


	public List queryByCondition(String whereString) throws CommonException {
		try {
			List list = this.getHibernateTemplate().find(whereString);
			return list;
		} catch (Exception e) {
			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_GLOBALINFO_SELECT, e);
		}
		return null;
	}

	public int executeSql(String sql){
		org.hibernate.SQLQuery queryObject = getSession().createSQLQuery(sql);
		return queryObject.executeUpdate();
	}
}
