/*
 * ==================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2004-2005 Huateng Software System.  All rights
 * reserved.
 * ==================================================================
 */
package com.huateng.ebank.business.management.operation;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.huateng.ebank.business.common.ErrorCode;
import com.huateng.ebank.business.management.common.DAOUtils;
import com.huateng.ebank.entity.dao.workflow.WorkflowBussTempletRelDAO;
import com.huateng.ebank.entity.data.workflow.WorkflowBussTempletRel;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.util.ExceptionUtil;

/**
 * @author UU_Wu
 * @date 2009-5-15
 * @desc
 */
public class  WorkflowBussTempletRelOperation extends BaseOperation {
    private static Log log = LogFactory
            .getLog(WorkflowBussTempletRelOperation.class);

    public static final String IN_PARAM = "IN_PARAM";

    public static final String IN_ID = "IN_ID";

    public static final String IN_PARAM_PAGESIZE = "IN_PARAM_PAGESIZE";

    public static final String IN_PARAM_PAGEINDEX = "IN_PARAM_PAGEINDEX";

    public static final String OUT_PARAM = "OUT_PARAM";

    /* (non-Javadoc)
     * @see com.huateng.ebank.framework.operation.BaseOperation#beforeProc(com.huateng.ebank.framework.operation.OperationContext)
     */
    @Override
	public void beforeProc(OperationContext context) throws CommonException {
        // TODO Auto-generated method stub
    }

    /* (non-Javadoc)
     * @see com.huateng.ebank.framework.operation.BaseOperation#execute(com.huateng.ebank.framework.operation.OperationContext)
     */
    @Override
	public void execute(OperationContext context) throws CommonException {
        if (log.isDebugEnabled()) {
            log.debug("enter into execute");
        }

        WorkflowBussTempletRel inBean  = (WorkflowBussTempletRel) context .getAttribute(IN_PARAM);
        String bussProc = inBean.getBussProc();

        WorkflowBussTempletRelDAO workflowBussTempletRelDAO = DAOUtils.getWorkflowBussTempletRelDAO();
        List outList = new ArrayList();
        outList = workflowBussTempletRelDAO.queryByCondition("bussProc = '"+bussProc+"'");
        if(outList==null||outList.size()==0){
        	//throw exception
        	ExceptionUtil.throwCommonException("业务流程模板配置表信息读取失败",ErrorCode.ERROR_CODE_WORKFLOW_BUSS_TEMPLET_REL_SELECT);
        }else{
        	WorkflowBussTempletRel workflowBussTempletRel = (WorkflowBussTempletRel)outList.get(0);
        	workflowBussTempletRel.setTempletName(inBean.getTempletName());
        	workflowBussTempletRel.setTempletDesc(inBean.getTempletDesc());
        	workflowBussTempletRelDAO.update(workflowBussTempletRel);
        }

//        context.setAttribute(OUT_PARAM,result);

        if (log.isDebugEnabled()) {
            log.debug("Exit execute");
        }
    }

    /* (non-Javadoc)
     * @see com.huateng.ebank.framework.operation.BaseOperation#afterProc(com.huateng.ebank.framework.operation.OperationContext)
     */
    @Override
	public void afterProc(OperationContext context) throws CommonException {
        // TODO Auto-generated method stub
    }

}