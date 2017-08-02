/*
 * ==================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2004-2005 Huateng Software System.  All rights
 * reserved.
 * ==================================================================
 */
package com.huateng.ebank.entity.dao.workflow;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.type.Type;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.huateng.ebank.business.common.ErrorCode;
import com.huateng.ebank.business.common.SystemConstant;
import com.huateng.ebank.entity.data.workflow.LimitParam;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ExceptionUtil;

/**
 * @author valley
 * @date 2005-06-01
 * @desc 数据库访问类
 */
public class LimitParamDAO extends HibernateDaoSupport {

    public LimitParamDAO() {
        super();
    }

    /**
     * 根据Hibernate ID查询记录，如果没有找到记录，则抛出异常
     *
     * @param id
     * @return LimitParam
     * @throws CommonException
     */
    public LimitParam query(Long id) throws CommonException {
        try {
            return (LimitParam) this.getHibernateTemplate().load(
                    LimitParam.class, id);
        } catch (Exception e) {
            ExceptionUtil.throwCommonException(e.getMessage(),
                    ErrorCode.ERROR_CODE_LIMIT_PARAM_SELECT, e);
        }
        return null;
    }

    /**
     * 根据业务主键查询，如果没有找到记录，则返回null
     *
     * @param oprNo
     * @param draftType
     * @param bussType
     * @return LimitParam
     * @throws CommonException
*/
    public LimitParam query(String oprNo, Integer branchId, String bussType, String status)
            throws CommonException {
        List list = new ArrayList();
        try {
            StringBuffer whereString = new StringBuffer();
            whereString.append("po.tlrno = '").append(oprNo).append(
                    "' and po.bizClass = ").append(branchId).append(
                    " and po.bizSubclass = '").append(bussType).append("' and po.status = '" + status + "'");
            list = queryByCondition(whereString.toString());
        } catch (Exception e) {
            ExceptionUtil.throwCommonException(e.getMessage(),
                    ErrorCode.ERROR_CODE_LIMIT_PARAM_SELECT, e);
        }

        if (list.size() != 1) {
            return null;
        } else {
            return (LimitParam) list.get(0);
        }
    }

    /**
     * 根据业务主键查询，如果没有找到记录，则返回null
     *
     * @param tlrno
     * @param bizClass
     * @param bizSubClass
     * @param status=1
     * @return LimitParam
     * @throws CommonException
	*/
    public LimitParam query4status(String tlrno, String bizClass, String bizSubClass)
            throws CommonException {
        List list = new ArrayList();
        try {
            StringBuffer whereString = new StringBuffer();
            whereString.append("po.tlrno = '").append(tlrno).append(
                    "' and po.bizClass = '").append(bizClass).append(
                    "' and po.bizSubclass = '").append(bizSubClass).append(
                    "' and po.status = '").append(SystemConstant.VALID_FLAG_VALID).append("'");
            list = queryByCondition(whereString.toString());
        } catch (Exception e) {
            ExceptionUtil.throwCommonException(e.getMessage(),
                    ErrorCode.ERROR_CODE_LIMIT_PARAM_SELECT, e);
        }

        if (list.size() != 1) {
            return null;
        } else {
            return (LimitParam) list.get(0);
        }
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
                    "from LimitParam po where " + whereString, objArray);
            return list;
        } catch (Exception e) {
            ExceptionUtil.throwCommonException(e.getMessage(),
                    ErrorCode.ERROR_CODE_LIMIT_PARAM_SELECT, e);
        }
        return null;
    }

    /**
     * 根据输入的条件查询所有符合条件的记录
     *
     * @param whereString
     * @return 包含LimitParam对象的List
     * @throws CommonException
     */
    public List queryByCondition(String whereString) throws CommonException {
        try {
            List list = this.getHibernateTemplate().find(
                    "from LimitParam po where " + whereString);
            return list;
        } catch (Exception e) {
            ExceptionUtil.throwCommonException(e.getMessage(),
                    ErrorCode.ERROR_CODE_LIMIT_PARAM_SELECT, e);
        }
        return null;
    }

    /**
     * 更新记录
     *
     * @param po
     * @throws CommonException
     */
    public void update(LimitParam po) throws CommonException {
        try {
            this.getHibernateTemplate().update(po);
        } catch (Exception e) {
            ExceptionUtil.throwCommonException(e.getMessage(),
                    ErrorCode.ERROR_CODE_LIMIT_PARAM_UPDATE, e);
        }
    }

    /**
     * 插入记录
     *
     * @param po
     * @throws CommonException
     */
    public void insert(LimitParam po) throws CommonException {
        try {
            this.getHibernateTemplate().save(po);
        } catch (Exception e) {
            ExceptionUtil.throwCommonException(e.getMessage(),
                    ErrorCode.ERROR_CODE_LIMIT_PARAM_INSERT, e);
        }
    }

    /**
     * 删除记录
     *
     * @param po
     * @throws CommonException
     */
    public void delete(LimitParam po) throws CommonException {
        try {
            this.getHibernateTemplate().delete(po);
        } catch (Exception e) {
            ExceptionUtil.throwCommonException(e.getMessage(),
                    ErrorCode.ERROR_CODE_LIMIT_PARAM_DELETE, e);
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
        } catch (Exception e) {
            ExceptionUtil.throwCommonException(e.getMessage(),
                    ErrorCode.ERROR_CODE_LIMIT_PARAM_DELETE, e);
        }
    }

    /**
     * 根据业务主键查询，如果没有找到记录，则返回null
     *
     * @param tlrno
     * @param bizClass
     * @param bizSubClass
     * @return LimitParam
     * @throws CommonException
     */
    public LimitParam query(String tlrno, String bizClass, String bizSubClass)
            throws CommonException {
        List list = new ArrayList();
        try {
            StringBuffer whereString = new StringBuffer();
            whereString.append("po.tlrno = '").append(tlrno).append(
                    "' and po.bizClass = '").append(bizClass).append(
                    "' and po.bizSubclass = '").append(bizSubClass).append("'");
            list = queryByCondition(whereString.toString());
        } catch (Exception e) {
            ExceptionUtil.throwCommonException(e.getMessage(),
                    ErrorCode.ERROR_CODE_LIMIT_PARAM_SELECT, e);
        }

        if (list.size() != 1) {
            return null;
        } else {
            return (LimitParam) list.get(0);
        }
    }
}