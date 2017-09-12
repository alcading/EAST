package com.huateng.report.update;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import resource.bean.report.BopCfaExguDs;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;
import com.huateng.report.operation.BOPCFAExguInfoAuditOperation;
public class BOPCFAExguInfoAuditUpdate extends BaseUpdate {
	
	private static final String DATASET_ID="BOPCFAExguInfoAudit";
	@Override
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean multiUpdateResultBean,
			HttpServletRequest request, HttpServletResponse respone)
			throws AppException {
		
		try {
			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID(DATASET_ID);
			List<BopCfaExguDs> bopCfaExguDsList = new ArrayList<BopCfaExguDs>();
			while (updateResultBean.hasNext())
			{
				BopCfaExguDs bopCfaExguDs = new BopCfaExguDs();
				Map map = updateResultBean.next();
				mapToObject(bopCfaExguDs,map);
				bopCfaExguDsList.add(bopCfaExguDs);
			}
			String approveStatusChoose = updateResultBean.getParameter("approveStatusChoose");
			String approveResultChoose = updateResultBean.getParameter("approveResultChoose");
			
			OperationContext oc = new OperationContext();
			oc.setAttribute(BOPCFAExguInfoAuditOperation.CMD, BOPCFAExguInfoAuditOperation.OP_LOAN_AUDIT);
			oc.setAttribute(BOPCFAExguInfoAuditOperation.IN_AUDIT_LIST, bopCfaExguDsList);
			oc.setAttribute(BOPCFAExguInfoAuditOperation.IN_AUDIT_STATUS, approveStatusChoose);
			oc.setAttribute(BOPCFAExguInfoAuditOperation.IN_AUDIT_RESULT, approveResultChoose);
			oc.setAttribute(BOPCFAExguInfoAuditOperation.CHOOSE, BOPCFAExguInfoAuditOperation.QIAN_YUE);
			OPCaller.call(BOPCFAExguInfoAuditOperation.ID, oc);
			
			return updateReturnBean;
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}

}
