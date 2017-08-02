package com.huateng.report.bop.audit.updater;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import resource.bean.report.MtsBopAgDs;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;
import com.huateng.report.bop.audit.operation.BopAgDsAuditOperation;

public class BopGDsAuditUpdate extends BaseUpdate {
	
	private static final String DATASET_ID="bopGDsAudit";
	
	@Override
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean multiUpdateResultBean,
			HttpServletRequest request, HttpServletResponse respone)
			throws AppException {
		
		try {
			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID(DATASET_ID);
			List<MtsBopAgDs> bopAgDsList = new ArrayList<MtsBopAgDs>();
			while (updateResultBean.hasNext()) {
				MtsBopAgDs bopAgDs = new MtsBopAgDs();
				Map map = updateResultBean.next();
				mapToObject(bopAgDs,map);
				bopAgDsList.add(bopAgDs);
			}
			String approveStatusChoose = updateResultBean.getParameter("approveStatusChoose");
			String approveResultChoose = updateResultBean.getParameter("approveResultChoose");
			
			OperationContext oc = new OperationContext();
			oc.setAttribute(BopAgDsAuditOperation.CMD, BopAgDsAuditOperation.OP_G_AUDIT);
			oc.setAttribute(BopAgDsAuditOperation.IN_AUDIT_LIST, bopAgDsList);
			oc.setAttribute(BopAgDsAuditOperation.IN_AUDIT_STATUS, approveStatusChoose);
			oc.setAttribute(BopAgDsAuditOperation.IN_AUDIT_RESULT, approveResultChoose);
			OPCaller.call(BopAgDsAuditOperation.ID, oc);
			
			return updateReturnBean;
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}

}
