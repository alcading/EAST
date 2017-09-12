package resource.dao.pub;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.huateng.ebank.business.common.ErrorCode;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ExceptionUtil;

import resource.bean.pub.DepartmentInfo;

/**
 * A data access object (DAO) providing persistence and search support for
 * DepartmentInfo entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 *
 * @see com.resource.bean.pub.entity.data.mng.DepartmentInfo
 * @author MyEclipse Persistence Tools
 */

public class DepartmentInfoDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(DepartmentInfoDAO.class);
	// property constants
	public static final String DEPARTMENT_NAME = "departmentName";
	public static final String BRCODE = "brcode";
	public static final String STATUS = "status";
	public static final String LAST_UPD_TLR = "lastUpdTlr";
	public static final String LAST_UPD_DATE = "lastUpdDate";
	public static final String BZ = "BZ";
	public static final String MISC = "MISC";
	public static final String MISC2 = "MISC2";
	public static final String MISC3 = "MISC3";
	public static final String MISC4 = "MISC4";

	@Override
	protected void initDao() {
		// do nothing
	}

	public void save(DepartmentInfo transientInstance) {
		log.debug("saving DepartmentInfo instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(DepartmentInfo persistentInstance) {
		log.debug("deleting DepartmentInfo instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public DepartmentInfo findById(java.lang.Integer id) {
		log.debug("getting DepartmentInfo instance with id: " + id);
		try {
			DepartmentInfo instance = (DepartmentInfo) getHibernateTemplate()
					.get(DepartmentInfo.class.getName(), id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(DepartmentInfo instance) {
		log.debug("finding DepartmentInfo instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding DepartmentInfo instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from DepartmentInfo model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/*public List findByDepartNo(Object departNo) {
		return findByProperty(DEPART_NO, departNo);
	}

	public List findByDepartName(Object departName) {
		return findByProperty(DEPART_NAME, departName);
	}

	public List findByBranchId(Object branchId) {
		return findByProperty(BRANCH_ID, branchId);
	}

	public List findByContacter(Object contacter) {
		return findByProperty(CONTACTER, contacter);
	}

	public List findByContactTel(Object contactTel) {
		return findByProperty(CONTACT_TEL, contactTel);
	}

	public List findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}

	public List findByLastUpdOperId(Object lastUpdOperId) {
		return findByProperty(LAST_UPD_OPER_ID, lastUpdOperId);
	}

	public List findByLastUpdTime(Object lastUpdTime) {
		return findByProperty(LAST_UPD_TIME, lastUpdTime);
	}*/

	public List findAll() {
		log.debug("finding all DepartmentInfo instances");
		try {
			String queryString = "from DepartmentInfo";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/**
	 * 根据Hibernate ID查询记录，如果没有找到记录，则抛出异常
	 *
	 * @param id
	 * @return DepartmentInfo
	 * @throws CommonException
	 */
	public DepartmentInfo query(String id) throws CommonException {
		this.getHibernateTemplate().setCacheQueries(true);
		if (logger.isDebugEnabled()) {
			logger.debug("query(String) - start"); //$NON-NLS-1$
		}
		try {
			long departmentCode = Long.valueOf(id);
			DepartmentInfo returnBctl = (DepartmentInfo)this.getHibernateTemplate().get(DepartmentInfo.class, departmentCode);
			if (logger.isDebugEnabled()) {
				logger.debug("query(String) - end"); //$NON-NLS-1$
			}
			return returnBctl;
		} catch (Exception e) {
			logger.error("query(String)", e); //$NON-NLS-1$

			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_DEPARTMENT_MANAGEMENT_SELECT, e);
		}
		if (logger.isDebugEnabled()) {
			logger.debug("query(String) - end"); //$NON-NLS-1$
		}
		return null;
	}

	public DepartmentInfo merge(DepartmentInfo detachedInstance) {
		log.debug("merging DepartmentInfo instance");
		try {
			DepartmentInfo result = (DepartmentInfo) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(DepartmentInfo instance) {
		log.debug("attaching dirty DepartmentInfo instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(DepartmentInfo instance) {
		log.debug("attaching clean DepartmentInfo instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static DepartmentInfoDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (DepartmentInfoDAO) ctx.getBean("DepartmentInfoDAO");
	}

	/**
	 * 根据输入的条件查询所有符合条件的记录
	 *
	 * @param whereString
	 * @return 包含DepartmentInfo对象的List
	 * @throws CommonException
	 */
	public List queryByCondition(String whereString) throws CommonException{
		this.getHibernateTemplate().setCacheQueries(true);
		if (logger.isDebugEnabled()) {
			logger.debug("queryByCondition(String) - start"); //$NON-NLS-1$
		}
		try {
			List list = this.getHibernateTemplate().find("from DepartmentInfo po where " + whereString);
			if(logger.isDebugEnabled()){
				logger.debug("queryByCondition(String) - end"); //$NON-NLS-1$
			}
			return list;
		}catch (Exception e) {
			logger.error("queryByCondition(String)", e); //$NON-NLS-1$
			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_RECORD_NOTFOUND, e);
		}
		if (logger.isDebugEnabled()) {
			logger.debug("queryByCondition(String) - end"); //$NON-NLS-1$
		}
		return null;
	}

	/**
	 * 根据Hibernate ID查询记录，如果没有找到记录，则抛出异常
	 *
	 * @param id
	 * @return DepartmentInfo
	 * @throws CommonException
	 */
	public DepartmentInfo query(Long departmentCode)throws CommonException{
		this.getHibernateTemplate().setCacheQueries(true);
		if(logger.isDebugEnabled()){
			logger.debug("query(String) - start");
		}
		try{
			DepartmentInfo returnDepartmentInfo = (DepartmentInfo)this.getHibernateTemplate().get(DepartmentInfo.class, departmentCode);
			if(logger.isDebugEnabled()){
				logger.debug("query(String) - end");
			}
			return returnDepartmentInfo;
		}catch (Exception e) {
			logger.error("query(String)", e); //$NON-NLS-1$

			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_RECORD_NOTFOUND, e);
		}
		if (logger.isDebugEnabled()) {
			logger.debug("query(String) - end"); //$NON-NLS-1$
		}
		return null;
	}

	/**
	 * 更新记录
	 *
	 * @param po
	 * @throws CommonException
	 */

	public void update(DepartmentInfo po) throws CommonException{
		this.getHibernateTemplate().setCacheQueries(false);
		if(logger.isDebugEnabled()){
			logger.debug("update(DepartmentInfo) - start");
		}
		try{
			this.getHibernateTemplate().update(po);
		}catch (Exception e) {
			logger.error("update(DepartmentInfo)", e); //$NON-NLS-1$

			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_CANNOT_SUBMIT, e);
		}
		if (logger.isDebugEnabled()) {
			logger.debug("update(DepartmentInfo) - end"); //$NON-NLS-1$
		}
	}

	/**
	 * 插入记录
	 *
	 * @param po
	 * @throws CommonException
	 */
	public void insert(DepartmentInfo po) throws CommonException{
		this.getHibernateTemplate().setCacheQueries(false);
		if(logger.isDebugEnabled()){
			logger.debug("insert(DepartmentInfo) - start");
		}
		try{
			this.getHibernateTemplate().save(po);
		}catch (Exception e) {
			logger.error("insert(DepartmentInfo)", e); //$NON-NLS-1$
			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_CANNOT_SUBMIT, e);
		}
		if (logger.isDebugEnabled()) {
			logger.debug("insert(DepartmentInfo) - end"); //$NON-NLS-1$
		}
	}
}