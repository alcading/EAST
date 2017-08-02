package com.huateng.report.bop.audit.updater;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import resource.bean.report.MtsBopEqDs;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;
import com.huateng.report.bop.audit.operation.BopEqDsAuditOperation;

public class BopEDsAuditUpdate extends BaseUpdate {
	
	private static final String DATASET_ID="BopEDsAudit";
	@Override
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean multiUpdateResultBean,
			HttpServletRequest request, HttpServletResponse respone)
			throws AppException {
		
		try {
			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID(DATASET_ID);
			List<MtsBopEqDs> bopEqDsList = new ArrayList<MtsBopEqDs>();
			while (updateResultBean.hasNext()) {
				MtsBopEqDs bopEqDs = new MtsBopEqDs();
				Map map = updateResultBean.next();
				mapToObject(bopEqDs,map);
				bopEqDsList.add(bopEqDs);
			}
			String approveStatusChoose = updateResultBean.getParameter("approveStatusChoose");
			String approveResultChoose = updateResultBean.getParameter("approveResultChoose");
			
			OperationContext oc = new OperationContext();
			oc.setAttribute(BopEqDsAuditOperation.CMD, BopEqDsAuditOperation.OP_E_AUDIT);
			oc.setAttribute(BopEqDsAuditOperation.IN_AUDIT_LIST, bopEqDsList);
			oc.setAttribute(BopEqDsAuditOperation.IN_AUDIT_STATUS, approveStatusChoose);
			oc.setAttribute(BopEqDsAuditOperation.IN_AUDIT_RESULT, approveResultChoose);
			OPCaller.call(BopEqDsAuditOperation.ID, oc);
			
			return updateReturnBean;
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}

}
