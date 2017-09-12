package com.huateng.report.system.updater;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import resource.bean.report.RbsBranchCodeMapp;

import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;
import com.huateng.report.system.operation.RbsBranchCodeMappOperation;


/**
 * 机构信息维护(新增，修改，有效/无效)
 * @author Administrator
 *
 */
public class RbsBranchCodeMappUpdate extends BaseUpdate {
	
	private static final String DATASET_ID = "RbsBranchCodeMappEntry";
	private static final String VALID = "valid";//有效性设置请求的标识
	
	@Override
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean arg0,
			HttpServletRequest arg1, HttpServletResponse arg2)
			throws AppException {
		// TODO Auto-generated method stub
		UpdateReturnBean updateReturnBean = new UpdateReturnBean();
		UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID(DATASET_ID);
		RbsBranchCodeMapp bean = new RbsBranchCodeMapp();
		OperationContext context = new OperationContext();
		while(updateResultBean.hasNext()) {
			Map map = updateResultBean.next();
			String valid = updateResultBean.getParameter("valid");
			BaseUpdate.mapToObject(bean, map);
			context.setAttribute(RbsBranchCodeMappOperation.IN_PARAMS, bean);
			if(VALID.equalsIgnoreCase(valid)) {
				//设置有效性
				context.setAttribute(RbsBranchCodeMappOperation.CMD,RbsBranchCodeMappOperation.CMD_VALID);
			} else if(updateResultBean.getRecodeState() == updateResultBean.MODIFY) {
				//修改
				context.setAttribute(RbsBranchCodeMappOperation.CMD, RbsBranchCodeMappOperation.CMD_MOD);
			} else if(updateResultBean.getRecodeState() == updateResultBean.INSERT) {
				context.setAttribute(RbsBranchCodeMappOperation.CMD, RbsBranchCodeMappOperation.CMD_ADD);
			}
			//调用operation
			OPCaller.call(RbsBranchCodeMappOperation.ID, context);
		}
		return updateReturnBean;
	}

}
