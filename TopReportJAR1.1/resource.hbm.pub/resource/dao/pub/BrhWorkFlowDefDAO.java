/**
 *
 */
package resource.dao.pub;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.type.Type;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.huateng.ebank.business.common.ErrorCode;
import com.huateng.ebank.entity.data.workflow.BrhWorkflowDef;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ExceptionUtil;

/**
 * @author user
 *
 */
public class BrhWorkFlowDefDAO extends HibernateDaoSupport {

	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(BrhWorkFlowDefDAO.class);

	public BrhWorkFlowDefDAO() {
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
					"from BrhWorkflowDef po where " + whereString);
			return list;
		} catch (Exception e) {
			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_BRH_WORKFLOW_DEF_SELECT, e);
		}
		return null;
	}

	/**
	 * 根据输入的条件查询所有符合条件的记录
	 *
	 * @param whereString
	 * @param objArray
	 * @param typeArray
	 * @return 包含AccumFundInfo对象的List
	 * @throws CommonException
	 */
	public List queryByCondition(String whereString, Object[] objArray,
			Type[] typeArray) throws CommonException {
		try {
			List list = this.getHibernateTemplate().find(
					"from BrhWorkflowDef po where " + whereString, objArray
					);
			return list;
		} catch (Exception e) {
			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_BRH_WORKFLOW_DEF_SELECT, e);
		}
		return null;
	}



	/**
	 * 更新记录
	 *
	 * @param po
	 * @throws CommonException
	 */
	public void update(BrhWorkflowDef po) throws CommonException {
		try {
			this.getHibernateTemplate().update(po);
//			this.getHibernateTemplate().evict(po);
		} catch (Exception e) {
			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_BRH_WORKFLOW_DEF_UPDATE, e);
		}
	}
	/**
	 * 插入记录
	 *
	 * @param po
	 * @throws CommonException
	 */
	public void insert(BrhWorkflowDef po) throws CommonException {
		try {
			this.getHibernateTemplate().save(po);
//			this.getHibernateTemplate().evict(po);
		} catch (Exception e) {
			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_BRH_WORKFLOW_DEF_INSERT, e);
		}
	}
	/**
	 * 删除记录
	 *
	 * @param po
	 * @throws CommonException
	 */
	public void delete(BrhWorkflowDef po) throws CommonException {
		try {
			this.getHibernateTemplate().delete(po);
		} catch (Exception e) {
			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_BRH_WORKFLOW_DEF_DELETE, e);
		}
	}
	/**
	 * 根据Hibernate ID删除记录
	 *
	 * @param id
	 * @throws CommonException
	 */
	public void delete(Long id) throws CommonException {
		try {
			this.getHibernateTemplate().delete(query(id));
//			this.getHibernateTemplate().evict(query(id));
		} catch (Exception e) {
			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_BRH_WORKFLOW_DEF_DELETE, e);
		}
	}

	/**
	 * 根据Hibernate ID查询记录，如果没有找到记录，则抛出异常
	 *
	 * @param id
	 * @return BhProcStep
	 * @throws CommonException
	 */
	public BrhWorkflowDef query(Long id) throws CommonException {
		try {
			return (BrhWorkflowDef) this.getHibernateTemplate().get(BrhWorkflowDef.class,
					new Long(id));
		} catch (Exception e) {
			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_BRH_WORKFLOW_DEF_SELECT, e);
		}
		return null;
	}


	 /**
	 * 根据输入的条件查询所有符合条件的记录
	 *	机构号、申请类型、贷款种类
	 * @param whereString
	 * @return 包含WorkflowAttitude对象的List
	 * @throws CommonException
	 */
	public BrhWorkflowDef queryByUk(String brcode,String apptype,String bizClass) throws CommonException {
		try {
			BrhWorkflowDef brhWorkflowDef = null;
			List list = this.getHibernateTemplate().find(
					"from BrhWorkflowDef po where po.brcode = '" + brcode + "' and po.apptype = '" + apptype + "' and po.bizClass = '" + bizClass + "'");

			if(list.size()!=0){
				brhWorkflowDef = (BrhWorkflowDef)list.get(0);
			}
			return brhWorkflowDef;
		} catch (Exception e) {
			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_BRH_WORKFLOW_DEF_SELECT, e);
		}
		return null;
	}

	 /**
	 * 根据输入的条件查询所有符合条件的记录
	 * 	机构号、申请类型、贷款种类、贷款性质
	 * @param whereString
	 * @return 包含WorkflowAttitude对象的List
	 * @throws CommonException
	 */
	public BrhWorkflowDef queryByUk(String brcode,String apptype,String bizClass,String bizSubclass) throws CommonException {
		try {
			BrhWorkflowDef brhWorkflowDef = null;
			List list = this.getHibernateTemplate().find(
					"from BrhWorkflowDef po where po.brcode = '" + brcode + "' and po.apptype = '" + apptype + "' and po.bizClass = '" + bizClass + "'" +
							" and po.bizSubclass = '"+bizSubclass+"'");

			if(list.size()!=0){
				brhWorkflowDef = (BrhWorkflowDef)list.get(0);
			}
			return brhWorkflowDef;
		} catch (Exception e) {
			ExceptionUtil.throwCommonException(e.getMessage(),
					ErrorCode.ERROR_CODE_BRH_WORKFLOW_DEF_SELECT, e);
		}
		return null;
	}
}
