/*
 * ==================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2004-2005 Huateng Software System.  All rights
 * reserved.
 * ==================================================================
 */
package com.huateng.ebank.business.management.operation;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.huateng.ebank.business.workflow.WorkFlowParamService;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;

/**
 * @author UU_Wu
 * @date 2009-5-16
 * @desc 工作流参数配置
 */
public class SaveWorklowParamEntryOperation extends BaseOperation {
    private static Log log = LogFactory
            .getLog(SaveWorklowParamEntryOperation.class);

    public static final String IN_DEL = "IN_DEL";

    public static final String IN_INSERT = "IN_INSERT";

    public static final String IN_UPDATE = "IN_UPDATE";

    public static final String IN_ROUTEID = "IN_ROUTEID";

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
//        /** add by jornezhang 20100108 BMS-2362  增加交易流水记录 begin */
//        TxtNumRecordUtil.getInstance().resetGlobalDataAllBlank();
//        /** add by jornezhang 20100108 BMS-2362  增加交易流水记录 end */

        List delList = (List) context.getAttribute(IN_DEL);

        List insertList = (List) context.getAttribute(IN_INSERT);

        List updateList = (List) context.getAttribute(IN_UPDATE);

//        String routeId =  (String) context.getAttribute(IN_ROUTEID);
        WorkFlowParamService workFlowParamService = WorkFlowParamService.getInstance();

        try {
			workFlowParamService.saveWorkflowParamEntry(delList,insertList,updateList);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


//        context.setAttribute(OUT_PARAM_All_RESULT,result);

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