package com.huateng.ebank.framework.web.commQuery;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.huateng.commquery.config.bean.base.ICommonQueryBean;
import com.huateng.commquery.dao.ICommQueryDAO;
import com.huateng.commquery.result.Page;
import com.huateng.commquery.result.PageUtil;
import com.huateng.commquery.result.Result;


/**
 * Title: 通用查询 DAO
 * Description: Data Access Objects
 * Copyright: Copyright (c) 2006
 * Company: Shanghai Huateng Software Systems Co., Ltd.
 * @author shen_antonio
 * @version 1.0, 12/05/06
 */

public class BankCommQueryDAO extends HibernateDaoSupport implements ICommQueryDAO {

	/** memeber variable: ICommonQueryBean　commonQueryBean. */
	private ICommonQueryBean commonQueryBean;

    public BankCommQueryDAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
     * Execute a query.
     * @param query a query expressed in Hibernate's query language
     * @return a distinct list of instances (or arrays of instances)
     */
    public List find(String query) {
        return getHibernateTemplate().find(query);
    }

    /**
     * Obtain an instance of Query for a named query string defined in the mapping file.
     * @param name the name of a query defined externally
     * @return Query
     */
    public List findByNamedQuery(String name) {
        return getHibernateTemplate().findByNamedQuery(name);
    }

    public List findByNamedQuery(final String name, final int begin, final int count) {
        return getHibernateTemplate().executeFind(
            new HibernateCallback() {
                public Object doInHibernate(Session session)
                    throws HibernateException, SQLException {
                    Query query = session.getNamedQuery(name);
                    if( begin >= 0 ) {
                        query.setFirstResult(begin);
                        query.setMaxResults(count);
                    }
                    return query.list();
                }
            }
        );
    }

    /**
     * Obtain an instance of Query for a named query string defined in the mapping file.
     * Use the parameters give
     * @param name the name of a query defined externally
     * @param params the parameter Map
     * @return Query
     */
    public List findByNamedQuery(final String name, final Map params) {
        return findByNamedQuery(name, params, -1, -1);
    }

    public List findByNamedQuery(final String name, final Map params, final int begin, final int count) {
        return getHibernateTemplate().executeFind(
            new HibernateCallback() {
                public Object doInHibernate(Session session)
                    throws HibernateException, SQLException {
                    Query query = session.getNamedQuery(name);
                    if (null != params) {
                        for (Iterator i=params.entrySet().iterator(); i.hasNext(); ) {
                            Map.Entry entry = (Map.Entry) i.next();
                            query.setParameter((String) entry.getKey(), entry.getValue());
                        }
                    }
                    if( begin >= 0 ) {
                        query.setFirstResult(begin);
                        query.setMaxResults(count);
                    }
                    return query.list();
                }
            }
        );
    }

    /**
     * Obtain an instance of Query for a named query string defined in the mapping file.
     * Use the parameters give
     * @param name the name of a query defined externally
     * @param params the parameter array
     * @return Query
     */
    public List findByNamedQuery(final String name, final Serializable[] params) {
        return findByNamedQuery(name, params, -1, -1);
    }

    /**
     * Obtain an instance of Query for a named query string defined in the mapping file.
     * Use the parameters give
     * @param name the name of a query defined externally
     * @param params the parameter array
     * @return Query
     */
    public List findByNamedQuery(final String name, final Serializable[] params, final int begin, final int count) {
        return getHibernateTemplate().executeFind(
            new HibernateCallback() {
                public Object doInHibernate(Session session)
                    throws HibernateException, SQLException {
                    Query query = session.getNamedQuery(name);
                    if (null != params) {
                        for (int i = 0; i < params.length; i++) {
                            query.setParameter(i, params[i]);
                        }
                    }
                    if( begin >= 0 ) {
                        query.setFirstResult(begin);
                        query.setMaxResults(count);
                    }
                    return query.list();
                }
            }
        );
    }

    /* (non-Javadoc)
     * @see com.huateng.commquery.dao.ICommQueryObj#findBySQLQuery(java.lang.String, int, int)
     */
    public java.util.List findBySQLQuery(final String sql,final int begin, final int count){
    	 return getHibernateTemplate().executeFind(
    	            new HibernateCallback() {
    	                public Object doInHibernate(Session session)
    	                    throws HibernateException, SQLException {
    	                    Query query = session.createQuery(sql);
    	                    if( begin >= 0 ) {
    	                        query.setFirstResult(begin);
    	                        query.setMaxResults(count);
    	                    }
    	                    return query.list();
    	                }
    	            }
    	        );
    }

    /* (non-Javadoc)
     * @see com.huateng.commquery.dao.ICommQueryObj#findBySQLQuery(java.lang.String, java.lang.String, int, int)
     */
    public Result findBySQLQuery(final String sql,final String countSql,final int begin, final int count){
    	int currentPage = begin/count;
    	if(begin%count != 0){
    		currentPage++;
    	}
    	String allCount = findCountBySQLQuery(countSql);
    	List data = getHibernateTemplate().executeFind(
	            new HibernateCallback() {
	                public Object doInHibernate(Session session)
	                    throws HibernateException, SQLException {
	                    Query query = session.createSQLQuery(sql);
	                    if( begin >= 0 ) {
	                        query.setFirstResult(begin);
	                        query.setMaxResults(count);
	                    }
	                    return query.list();
	                }
	            }
	    );

    	Page page = PageUtil.createPage(count,currentPage + 1,Integer.parseInt(allCount));
    	return new Result(page,data);
    }

    /* (non-Javadoc)
     * @see com.huateng.commquery.dao.ICommQueryObj#findCountBySQLQuery(java.lang.String)
     */
    public String findCountBySQLQuery(final String countSql){
    	List data = getHibernateTemplate().executeFind(
	            new HibernateCallback() {
	                public Object doInHibernate(Session session)
	                    throws HibernateException, SQLException {

	                	  Query query = session.createSQLQuery(countSql);
	                    return query.list();
	                }
	            }
	    );
    	return data.get(0).toString();
    }

    /*
     * (non-Javadoc)
     * @see com.huateng.commquery.dao.ICommQueryObj#findBySQLQuery(java.lang.String)
     */
	public Result findBySQLQuery(final String sql){
		List data = getHibernateTemplate().executeFind(
	            new HibernateCallback() {
	                public Object doInHibernate(Session session)
	                    throws HibernateException, SQLException {
	                	  Query query = session.createSQLQuery(sql);
	                    return query.list();
	                }
	            }
	    );
		int count = data.size() == 0?0:1;
		Page page = PageUtil.createPage(-1,1,count);
    	return new Result(page,data);
	}

    public void flush() {
		getHibernateTemplate().flush();
    }

    /**
	 * @param params
	 * @param begin
	 * @param count
	 * @return
	 */
	public Result findCallService(final Map params,final int begin,final int count){
		return null;
	}
	/**
	 * @param params
	 * @return
	 */
	public Result findCallService(final Map params){
		return null;
	}

	/**
	 * @param commonQueryBean
	 */
	public void setCommonQueryBean(ICommonQueryBean commonQueryBean){
		this.commonQueryBean = commonQueryBean;
	}


	/**
	 * @return
	 */
	public ICommonQueryBean getCommonQueryBean(){
		return this.commonQueryBean;
	}
}



