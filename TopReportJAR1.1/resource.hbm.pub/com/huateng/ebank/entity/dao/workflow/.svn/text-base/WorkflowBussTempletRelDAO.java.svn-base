package com.huateng.ebank.entity.dao.workflow;


import java.util.List;

import org.hibernate.type.Type;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.huateng.ebank.business.common.ErrorCode;
import com.huateng.ebank.entity.data.workflow.WorkflowBussTempletRel;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ExceptionUtil;

/**
 * @author valley
 * @date 2005-06-01
 * @desc
 */
public class WorkflowBussTempletRelDAO extends HibernateDaoSupport {

    public WorkflowBussTempletRelDAO() {
        super();
    }

    /**
     *
     *
     * @param id
     * @return LimitParam
     * @throws CommonException
     */
    public WorkflowBussTempletRel query(long id) throws CommonException {
        try {
            return (WorkflowBussTempletRel) this.getHibernateTemplate().load(
            		WorkflowBussTempletRel.class, new Long(id));
        } catch (Exception e) {
            ExceptionUtil.throwCommonException(e.getMessage(),
                    ErrorCode.ERROR_CODE_WORKFLOW_BUSS_TEMPLET_REL_SELECT, e);
        }
        return null;
    }



    /**
     *
     *
     * @param whereString
     * @param objArray
     * @param typeArray
     * @return
     * @throws CommonException
     */
    public List queryByCondition(String whereString, Object[] objArray,
            Type[] typeArray) throws CommonException {
        try {
            List list = this.getHibernateTemplate().find(
                    "from WorkflowBussTempletRel po where " + whereString, objArray);
            return list;
        } catch (Exception e) {
            ExceptionUtil.throwCommonException(e.getMessage(),
                    ErrorCode.ERROR_CODE_WORKFLOW_BUSS_TEMPLET_REL_SELECT, e);
        }
        return null;
    }

    /**
     *
     *
     * @param whereString
     * @return
     * @throws CommonException
     */
    public List queryByCondition(String whereString) throws CommonException {
        try {
            List list = this.getHibernateTemplate().find(
                    "from WorkflowBussTempletRel po where " + whereString);
            return list;
        } catch (Exception e) {
            ExceptionUtil.throwCommonException(e.getMessage(),
                    ErrorCode.ERROR_CODE_WORKFLOW_BUSS_TEMPLET_REL_SELECT, e);
        }
        return null;
    }

    /**
     *
     *
     * @param po
     * @throws CommonException
     */
    public void update(WorkflowBussTempletRel po) throws CommonException {
        try {
            this.getHibernateTemplate().update(po);
        } catch (Exception e) {
            ExceptionUtil.throwCommonException(e.getMessage(),
                    ErrorCode.ERROR_CODE_WORKFLOW_BUSS_TEMPLET_REL_UPDATE, e);
        }
    }

    /**
     *
     *
     * @param po
     * @throws CommonException
     */
    public void insert(WorkflowBussTempletRel po) throws CommonException {
        try {
            this.getHibernateTemplate().save(po);
        } catch (Exception e) {
            ExceptionUtil.throwCommonException(e.getMessage(),
                    ErrorCode.ERROR_CODE_WORKFLOW_BUSS_TEMPLET_REL_INSERT, e);
        }
    }

    /**
     *
     *
     * @param po
     * @throws CommonException
     */
    public void delete(WorkflowBussTempletRel po) throws CommonException {
        try {
            this.getHibernateTemplate().delete(po);
        } catch (Exception e) {
            ExceptionUtil.throwCommonException(e.getMessage(),
                    ErrorCode.ERROR_CODE_WORKFLOW_BUSS_TEMPLET_REL_DELETE, e);
        }
//    	 try {
//    		 delete(po.getId());
//         } catch (Exception e) {
//             ExceptionUtil.throwCommonException(e.getMessage(),
//                     ErrorCode.ERROR_CODE_WORKFLOW_ROUTE_PARAM_DELETE, e);
//         }
    }

    /**
     *
     *
     * @param id
     * @throws CommonException
     */
    public void delete(Integer id) throws CommonException {
        try {
            this.getHibernateTemplate().delete(query(id));
        } catch (Exception e) {
            ExceptionUtil.throwCommonException(e.getMessage(),
                    ErrorCode.ERROR_CODE_WORKFLOW_BUSS_TEMPLET_REL_DELETE, e);
        }
    }
}