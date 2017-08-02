/*
 * ==================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2004-2005 Huateng Software System.  All rights
 * reserved.
 * ==================================================================
 */
package resource.dao.base;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.type.Type;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.huateng.ebank.business.common.ErrorCode;
import com.huateng.ebank.business.common.PageQueryCondition;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.business.common.RangeQueryCondition;
import com.huateng.ebank.business.common.RangeQueryResult;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.ebank.framework.util.HqlUtils;

/**
 * @author valley
 * @date 2005-06-01
 * @desc 数据库访问类
 */
public class HQLDAO extends HibernateDaoSupport {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(HQLDAO.class);

	public HQLDAO() {
		super();
	}

	/**
	 * 根据输入条件查询
	 *
	 * @param hql，对象查询语句
	 * @return Iterator，对象数组集合
	 * @throws CommonException
	 */
	public Iterator queryByQL(String hql) throws CommonException {
		if (logger.isDebugEnabled()) {
			logger.debug("queryByQL(String) - start"); //$NON-NLS-1$
		}

		Iterator it = null;
		try {
			//it = this.getSession().iterate(hql);
			List list = this.getHibernateTemplate().find(hql);
			if (logger.isDebugEnabled()) {
				logger.debug("queryByQL(String) - hql hql=" + hql); //$NON-NLS-1$
			}
			Iterator returnIterator = list.iterator();
			if (logger.isDebugEnabled()) {
				logger.debug("queryByQL(String) - list end"); //$NON-NLS-1$
			}
			return returnIterator;
		} catch (Exception e) {
			logger.error("queryByQL(String)", e); //$NON-NLS-1$

			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_DAO, e);
		}

		if (logger.isDebugEnabled()) {
			logger.debug("queryByQL(String) - end"); //$NON-NLS-1$
		}
		return it;
	}

	/**
	 * 根据输入条件查询
	 *
	 * @param hql，对象查询语句
	 * @return List，对象数组集合
	 * @throws CommonException
	 */
	public List queryByQL2List(String hql) throws CommonException {
		if (logger.isDebugEnabled()) {
			logger.debug("queryByQL2List(String) - start"); //$NON-NLS-1$
		}

		List list = null;
		try {
			list = this.getHibernateTemplate().find(hql);
			if (logger.isDebugEnabled()) {
				logger.debug("queryByQL2List(String) - hql hql=" + hql); //$NON-NLS-1$
			}
			if (logger.isDebugEnabled()) {
				logger.debug("queryByQL2List(String) - list end"); //$NON-NLS-1$
			}
			return list;
		} catch (Exception e) {
			logger.error("queryByQL2List(String)", e); //$NON-NLS-1$

			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_DAO, e);
		}

		if (logger.isDebugEnabled()) {
			logger.debug("queryByQL2List(String) - end"); //$NON-NLS-1$
		}
		return list;
	}

	/**
	 * 根据输入条件查询
	 *
	 * @param hql，对象查询语句
	 * @return List，对象数组集合
	 * @throws CommonException
	 */
	public List queryByQL2List(String hql ,Object[] objArg, Type[] typeArg ) throws CommonException {
		if (logger.isDebugEnabled()) {
			logger.debug("queryByQL2List(String) - start"); //$NON-NLS-1$
		}

		List list = null;
		try {
			list = this.getHibernateTemplate().find(hql,objArg);
			if (logger.isDebugEnabled()) {
				logger.debug("queryByQL2List(String, Object[], Type[]) - hql hql=" + hql); //$NON-NLS-1$
			}
			if (logger.isDebugEnabled()) {
				logger.debug("queryByQL2List(String, Object[], Type[]) - list end"); //$NON-NLS-1$
			}
			return list;
		} catch (Exception e) {
			logger.error("queryByQL2List(String, Object[], Type[])", e); //$NON-NLS-1$

			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_DAO, e);
		}

		if (logger.isDebugEnabled()) {
			logger.debug("queryByQL2List(String) - end"); //$NON-NLS-1$
		}
		return list;
	}

	/**
	 * 根据输入条件查询
	 *
	 * @param sql，SQL查询语句
	 * @return Iterator，返回数组集合
	 * @throws CommonException
	 */
	public Iterator queryBySQL(String sql) throws CommonException {
		if (logger.isDebugEnabled()) {
			logger.debug("queryBySQL(String) - start"); //$NON-NLS-1$
		}
		final String tempSql = sql;
		Iterator it = null;
		try {
			it = (Iterator)getHibernateTemplate().execute(new HibernateCallback()
			{
			   public Object doInHibernate(Session session)
			     throws HibernateException
			   {
				 if (logger.isDebugEnabled()) {
					   logger.debug("queryBySQL(String) - sql sql=" + tempSql); //$NON-NLS-1$
				 }
			     SQLQuery sqlQuery = session.createSQLQuery(tempSql);
			     return sqlQuery.list().iterator();
			    }
			   });
			if (logger.isDebugEnabled()) {
				logger.debug("queryBySQL(String) - list end"); //$NON-NLS-1$
			}
		} catch (Exception e) {
			logger.error("queryBySQL(String)", e); //$NON-NLS-1$
			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_DAO, e);
		}

		if (logger.isDebugEnabled()) {
			logger.debug("queryBySQL(String) - end"); //$NON-NLS-1$
		}
		return it;
	}
	/**
	 * 根据输入条件查询
	 *	@author jianxue.zhang
	 * @param sql，SQL查询语句
	 * @return List，返回数组集合
	 * @throws CommonException
	 */
	public List queryBySQLList(String sql) throws CommonException {
		if (logger.isDebugEnabled()) {
			logger.debug("queryBySQL(String) - start"); //$NON-NLS-1$
		}
		final String tempSql = sql;
		List it = null;
		try {
			it = (List)getHibernateTemplate().execute(new HibernateCallback()
			{
			   public Object doInHibernate(Session session)
			     throws HibernateException
			   {
				 if (logger.isDebugEnabled()) {
					   logger.debug("queryBySQL(String) - sql sql=" + tempSql); //$NON-NLS-1$
				 }
			     SQLQuery sqlQuery = session.createSQLQuery(tempSql);
			     return sqlQuery.list();
			    }
			   });
			if (logger.isDebugEnabled()) {
				logger.debug("queryBySQL(String) - list end"); //$NON-NLS-1$
			}
		} catch (Exception e) {
			logger.error("queryBySQL(String)", e); //$NON-NLS-1$
			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_DAO, e);
		}

		if (logger.isDebugEnabled()) {
			logger.debug("queryBySQL(String) - end"); //$NON-NLS-1$
		}
		return it;
	}
	/**
	 * 根据输入条件查询
	 *
	 * @param hql，对象查询语句
	 * @param objArg
	 *            Object[] 值对象
	 * @param typeArg
	 *            Type[] 类型对象
	 * @return Iterator，对象数组集合
	 * @throws CommonException
	 */
	public Iterator queryByQL(String hql, Object[] objArg, Type[] typeArg)
			throws CommonException {
		if (logger.isDebugEnabled()) {
			logger.debug("queryByQL(String, Object[], Type[]) - start"); //$NON-NLS-1$
		}

		Iterator it = null;
		try {
//			it = this.getSession().iterate(hql, objArg, typeArg);
			List list = this.getHibernateTemplate().find(hql, objArg);

			Iterator returnIterator = list.iterator();
			if (logger.isDebugEnabled()) {
				logger.debug("queryByQL(String, Object[], Type[]) - end"); //$NON-NLS-1$
			}
			return returnIterator;
		} catch (Exception e) {
			logger.error("queryByQL(String, Object[], Type[])", e); //$NON-NLS-1$

			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_DAO, e);
		}

		if (logger.isDebugEnabled()) {
			logger.debug("queryByQL(String, Object[], Type[]) - end"); //$NON-NLS-1$
		}
		return it;
	}

	/**
	 * 根据输入条件查询
	 *
	 * @param sql，SQL查询语句
	 * @param objArg Object[] 值对象
	 * @param typeArg Type[] 类型对象
	 * @return Iterator，对象数组集合
	 * @throws CommonException
	 */
	public Iterator queryBySQL(final String sql,final Object[] objArg, final Type[] typeArg) throws CommonException {
		if (logger.isDebugEnabled()) {
			logger.debug("queryByQL(String sql, Object[] objArg, Type[] typeArg) - start"); //$NON-NLS-1$
		}
		final String tempSql = sql;
		Iterator it = null;
		try {
			it = (Iterator)getHibernateTemplate().execute(new HibernateCallback()
			{
			   public Object doInHibernate(Session session)
			     throws HibernateException
			   {
			     SQLQuery sqlQuery = session.createSQLQuery(tempSql);
				 if (null != objArg) {
						for (int i = 0; i < objArg.length; i++) {
							if (logger.isDebugEnabled()) {
								logger.debug("i="+i);
								logger.debug("values[i]="+objArg[i]);
								logger.debug("types[i]="+objArg[i]);
							}
							if (typeArg != null) {
								sqlQuery.setParameter(i, objArg[i], typeArg[i]);
							} else {
								sqlQuery.setParameter(i, objArg[i]);
							}
						}
					}
				 if (logger.isDebugEnabled()) {
						logger.debug("queryByQL(String sql, Object[] objArg, Type[] typeArg) - end"); //$NON-NLS-1$
					}
			     return sqlQuery.list().iterator();
			    }
			   });
		} catch (Exception e) {
			logger.error("queryByQL(String sql, Object[] objArg, Type[] typeArg)", e); //$NON-NLS-1$
			ExceptionUtil.throwCommonException(e.getMessage(),ErrorCode.ERROR_CODE_DAO, e);
		}
		return it;
	}

	public Iterator iterator(String hql, Object[] objArg, Type[] typeArg) throws CommonException{
		if (logger.isDebugEnabled()) {
			logger.debug("iterator(String, Object[], Type[]) - start"); //$NON-NLS-1$
		}

		Iterator it = null;
		try {
			it = this.getHibernateTemplate().iterate(hql,objArg);
		} catch (Exception e) {
			logger.error("iterator(String, Object[], Type[])", e); //$NON-NLS-1$

			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_DAO, e);
		}

		if (logger.isDebugEnabled()) {
			logger.debug("iterator(String, Object[], Type[]) - end"); //$NON-NLS-1$
		}
		return it;
	}

	/**
	 * 根据条件删除
	 *
	 * @param hql，对象查询语句
	 * @throws CommonException
	 */
	public Integer delete(final String hql) throws CommonException {
		if (logger.isDebugEnabled()) {
			logger.debug("delete(String) - start"); //$NON-NLS-1$
		}
		Integer count = new Integer(-1);
		try {
			count = (Integer)this.getHibernateTemplate().execute(new HibernateCallback() {
                public Object doInHibernate(Session session)
                throws HibernateException, SQLException {
                	return new Integer(session.createQuery("delete " + hql).executeUpdate());
            }
        }
       );
		} catch (Exception e) {
			logger.error("delete(String)", e); //$NON-NLS-1$
			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_DAO, e);
		}
		if (logger.isDebugEnabled()) {
			logger.debug("delete(String) - end"); //$NON-NLS-1$
		}
		return count;
	}

	/**
	 * flush函数,强制数据库操作进行flush.
	 * @throws CommonException
	 */
	public void flush() throws CommonException {
		if (logger.isDebugEnabled()) {
			logger.debug("flush() - start"); //$NON-NLS-1$
		}

		try {
			this.getHibernateTemplate().flush();
		} catch (Exception e) {
			logger.error("flush()", e); //$NON-NLS-1$

			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_DAO, e);
		}

		if (logger.isDebugEnabled()) {
			logger.debug("flush() - end"); //$NON-NLS-1$
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

	/**
	 * SQL分页查询方法
	 * @return PageQueryResult
	 */
	public PageQueryResult pageQueryBySQL(PageQueryCondition queryCondition)
			throws CommonException {
		if (logger.isDebugEnabled()) {
			logger.debug("pageQueryByQL(PageQueryCondition) - start"); //$NON-NLS-1$
		}

		try {
			PageQueryCallbackForSQL callback = new PageQueryCallbackForSQL(queryCondition);

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
	/** add by shen_antonio 20091030 jira:BMS-2140 begin .*/

	/**
	* @Title: 分页查询方法
	* @Description: 使用count(*)获取总记录数，效率高，局限性对于union不支持，请使用pageQueryByQL
	* @param @param queryCondition
	* @param @return
	* @param @throws CommonException
	* @return PageQueryResult
	* @author shenantonio
	* @date 2009-10-30 下午02:46:10
	* @throws
	*/
	public PageQueryResult pageQueryByQLWithCount(PageQueryCondition queryCondition)
			throws CommonException {
		if (logger.isDebugEnabled()) {
			logger.debug("pageQueryByQL(PageQueryCondition) - start"); //$NON-NLS-1$
		}

		try {
			PageQueryCallbackWithCount callback = new PageQueryCallbackWithCount(queryCondition);
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
	/** add by shen_antonio 20091030 jira: BMS-2140 end .*/

	/**
	 * 范围查询方法
	 * @return PageQueryResult
	 */
	public RangeQueryResult rangeQueryByQL(RangeQueryCondition queryCondition)
			throws CommonException {
		if (logger.isDebugEnabled()) {
			logger.debug("rangeQueryByQL(RangeQueryCondition) - start"); //$NON-NLS-1$
		}

		try {
			RangeQueryCallback callback = new RangeQueryCallback(queryCondition);
			RangeQueryResult returnRangeQueryResult = (RangeQueryResult) this.getHibernateTemplate().execute(callback);
			if (logger.isDebugEnabled()) {
				logger.debug("rangeQueryByQL(RangeQueryCondition) - end"); //$NON-NLS-1$
			}
			return returnRangeQueryResult;
		} catch (Exception e) {
			logger.error("rangeQueryByQL(RangeQueryCondition)", e); //$NON-NLS-1$

			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_DAO, e);
		}

		if (logger.isDebugEnabled()) {
			logger.debug("rangeQueryByQL(RangeQueryCondition) - end"); //$NON-NLS-1$
		}
		return null;
	}

	/**
	 * 根据输入条件查询
	 *
	 * @param hql，对象查询语句
	 * @param objArg
	 *            Object[] 值对象
	 * @param typeArg
	 *            Type[] 类型对象
	 * @return Iterator，对象数组集合
	 * @throws CommonException
	 */
	public Iterator createQuery(String hql)
			throws CommonException {
		if (logger.isDebugEnabled()) {
			logger.debug("queryByQL(String, Object[], Type[]) - start"); //$NON-NLS-1$
		}
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		Iterator it = null;
		try {

			Query query = session.createQuery(hql);

			Iterator returnIterator = query.iterate();
			if (logger.isDebugEnabled()) {
				logger.debug("queryByQL(String, Object[], Type[]) - end"); //$NON-NLS-1$
			}
			return returnIterator;
		} catch (Exception e) {
			session.close();
			logger.error("queryByQL(String, Object[], Type[])", e); //$NON-NLS-1$

			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_DAO, e);
		}
		if (logger.isDebugEnabled()) {
			logger.debug("queryByQL(String, Object[], Type[]) - end"); //$NON-NLS-1$
		}
		return it;
	}

}
/** add by shen_antonio 20091030 jira: BMS-2140 begin .*/
/**
* @Title: 分页方法回调类
* @Package com.huateng.ebank.entity.base
* @Description: 使用count方法的分页查询
* @author shen_antonio
* @date 2009-10-30 下午02:48:45
* Copyright: Copyright (c) 2009
* Company: Shanghai Huateng Software Systems Co., Ltd.
* @version V1.0
*/
class PageQueryCallbackWithCount implements HibernateCallback {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(PageQueryCallback.class);

	private PageQueryCondition queryCondition = null;

	public PageQueryCallbackWithCount(PageQueryCondition queryCondition) {
		this.queryCondition = queryCondition;
	}

	public Object doInHibernate(Session session) throws HibernateException {
		if (logger.isDebugEnabled()) {
			logger.debug("doInHibernate(Session) - start"); //$NON-NLS-1$
		}
		Query queryObject = session.createQuery(queryCondition.getQueryString());
		String countHQL = HqlUtils.transferCountHQL(queryCondition.getQueryString());
		if(logger.isInfoEnabled()){
			logger.info("COUNTHQL = " + countHQL);
		}
		Query queryCount = session.createQuery(countHQL);
		Long totleCount = (Long)queryCount.uniqueResult();

		PageQueryResult queryResult = new PageQueryResult();
		queryResult.setQueryResult(new ArrayList());
		queryResult.setTotalCount(totleCount.intValue());
		if(totleCount > 0){
			int pageSize = queryCondition.getPageSize();
			int pageIndex = queryCondition.getPageIndex() - 1;
			int startRowNum = pageIndex * pageSize;
			queryObject.setFirstResult(startRowNum);
			queryObject.setMaxResults(pageSize);
			ScrollableResults sr = queryObject.scroll();
			while(sr.next()){
				queryResult.getQueryResult().add(sr.get());
			}

		}
		if (logger.isDebugEnabled()) {
			logger.debug("doInHibernate(Session) - end"); //$NON-NLS-1$
		}
		return queryResult;
}
}


/** add by shen_antonio 20091030 jira:BMS-2140 end .*/
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

/**
*
* 分页查询的回调类.
*/
class PageQueryCallbackForSQL implements HibernateCallback {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(PageQueryCallback.class);

	private PageQueryCondition queryCondition = null;

	public PageQueryCallbackForSQL(PageQueryCondition queryCondition) {
		this.queryCondition = queryCondition;
	}

	public Object doInHibernate(Session session) throws HibernateException {
		if (logger.isDebugEnabled()) {
			logger.debug("doInHibernate(Session) - start"); //$NON-NLS-1$
		}

		SQLQuery queryObject = session.createSQLQuery(queryCondition.getQueryString());
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




/**
 *
 * 范围查询的回调类.
 */
class RangeQueryCallback implements HibernateCallback {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(RangeQueryCallback.class);

	private RangeQueryCondition queryCondition = null;

	public RangeQueryCallback(RangeQueryCondition queryCondition) {
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
			RangeQueryResult queryResult = new RangeQueryResult();
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

			int startRowNum = queryCondition.getStart();
			if (false == sr.setRowNumber(startRowNum)) {
				if (logger.isDebugEnabled()) {
					logger.debug("doInHibernate(Session) - end"); //$NON-NLS-1$
				}
				return queryResult;
			}

			List list = queryResult.getQueryResult();
			for (int i = 0; i < queryCondition.getCount(); i++) {
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