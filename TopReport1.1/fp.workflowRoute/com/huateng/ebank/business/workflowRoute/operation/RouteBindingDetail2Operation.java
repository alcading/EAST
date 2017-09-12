/*
 * ==================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2004-2005 Huateng Software System.  All rights
 * reserved.
 * ==================================================================
 */
package com.huateng.ebank.business.workflowRoute.operation;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import resource.bean.pub.Bctl;

import com.huateng.ebank.business.common.BaseDAOUtils;
import com.huateng.ebank.business.common.DAOUtils;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.business.management.service.RouteService;
import com.huateng.ebank.entity.data.workflow.WorkflowRouteBinding;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.util.DataFormat;
import com.huateng.ebank.framework.util.ExceptionUtil;

/**
 * @author UU_Wu
 * @date 2009-5-11
 * @desc 审批路线绑定
 */
public class  RouteBindingDetail2Operation extends BaseOperation {
    private static Log log = LogFactory
            .getLog(RouteBindingDetail2Operation.class);

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
        String id = (String) context .getAttribute(IN_ID);
//        RouteBindingView inrouteBindingView = (RouteBindingView) context .getAttribute(IN_PARAM);

        WorkflowRouteBinding WorkflowRouteBinding = DAOUtils.getWorkflowRouteBindingDAO().query(Integer.valueOf(id));

        Integer pageSizeI = (Integer) context.getAttribute(IN_PARAM_PAGESIZE);
        Integer pageIndexI = (Integer) context.getAttribute(IN_PARAM_PAGEINDEX);
        String brclass = WorkflowRouteBinding.getBrhClass();

        //判断该审批路径适用的机构级别
        if(DataFormat.isEmpty(brclass)){

        	 List branchinfolist = BaseDAOUtils.getBctlDAO().queryByCondition("po.brno='" + WorkflowRouteBinding.getStartBrhno() + "'");
        	 if(branchinfolist.isEmpty()){
        		 ExceptionUtil.throwCommonException("开户行不存在", "BL7100");
        	 }
        	 else if(branchinfolist.size()>1){
        		 ExceptionUtil.throwCommonException("开户行有多条记录", "BL7100");
        	 }
        	 else{
        		 Bctl branchInfo = (Bctl) branchinfolist.get(0);
        		 brclass = branchInfo.getBrclass();
        	 }
        }


        RouteService routeService = RouteService.getInstance();
        PageQueryResult result = routeService.queryRouteBindingRouteInfo(WorkflowRouteBinding, pageSizeI.intValue(),pageIndexI.intValue());
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