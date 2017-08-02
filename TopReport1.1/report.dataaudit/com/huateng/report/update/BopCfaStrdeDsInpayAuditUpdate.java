package com.huateng.report.update;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import resource.bean.report.BopCfaStrdeDs;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;
import com.huateng.report.operation.BopCfaStrdeDsAuditOperation;
/*
 * 利息给付信息审核
 */
public class BopCfaStrdeDsInpayAuditUpdate extends BaseUpdate {
	private static final String DATASET_ID = "bopCfaStrdeDsInpayEntryAudit";
	@Override
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean multiUpdateResultBean,
			HttpServletRequest request, HttpServletResponse response)
			throws AppException {
		try {
			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID(DATASET_ID);
			OperationContext context = new OperationContext();
			List<BopCfaStrdeDs> bopCfaStrdeDsList = new ArrayList<BopCfaStrdeDs>();
			while(updateResultBean.hasNext()) {
				Map map = updateResultBean.next();
				BopCfaStrdeDs bopCfaStrdeDs = new BopCfaStrdeDs();
				mapToObject(bopCfaStrdeDs, map);
				bopCfaStrdeDsList.add(bopCfaStrdeDs);
			}
			String approveStatusChoose = updateResultBean.getParameter("approveStatusChoose");
			String approveResultChoose = updateResultBean.getParameter("approveResultChoose");
			context.setAttribute(BopCfaStrdeDsAuditOperation.TERMINATE_AUDIT_LIST_IN_PARAM,bopCfaStrdeDsList);
			context.setAttribute(BopCfaStrdeDsAuditOperation.AUDIT_STATUS, approveStatusChoose);
			context.setAttribute(BopCfaStrdeDsAuditOperation.AUDIT_RESULT, approveResultChoose);
			context.setAttribute(BopCfaStrdeDsAuditOperation.CMD, BopCfaStrdeDsAuditOperation.TERMINATE_AUDIT_CMD);
			OPCaller.call(BopCfaStrdeDsAuditOperation.ID, context);
			return updateReturnBean;
		} catch (AppException appe) {
			throw appe;
		} catch (Exception e) {
			throw new AppException(Module.SYSTEM_MODULE,Rescode.DEFAULT_RESCODE,e.getMessage(),e);
		}
		
	}

}
