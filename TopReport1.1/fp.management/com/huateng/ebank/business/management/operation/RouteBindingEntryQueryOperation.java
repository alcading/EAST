/*
 * ==================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2004-2005 Huateng Software System.  All rights
 * reserved.
 * ==================================================================
 */
package com.huateng.ebank.business.management.operation;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.business.management.bean.RouteBindingView;
import com.huateng.ebank.business.management.service.RouteService;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;

/**
 * @author UU_Wu
 * @date 2009-5-7
 * @desc 审批路线绑定查询
 */
public class  RouteBindingEntryQueryOperation extends BaseOperation {
    private static Log log = LogFactory
            .getLog(RouteBindingEntryQueryOperation.class);

    public static final String IN_PARAM = "IN_PARAM";

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

        RouteBindingView routeBindingView  = (RouteBindingView) context .getAttribute(IN_PARAM);

        Integer pageSizeI = (Integer) context.getAttribute(IN_PARAM_PAGESIZE);
        Integer pageIndexI = (Integer) context.getAttribute(IN_PARAM_PAGEINDEX);

        RouteService routeService = RouteService.getInstance();
        PageQueryResult result = routeService.queryRouteBindingBussInfo(routeBindingView, pageSizeI.intValue(),pageIndexI.intValue());


        context.setAttribute(OUT_PARAM,result);

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