package com.huateng.report.bop.audit.updater;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import resource.bean.report.MtsBopDrDs;
import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;
import com.huateng.report.bop.audit.operation.BopDRDsAuditOperation;

public class BopRDsAuditUpdate extends BaseUpdate {
	
	private static final String DATASET_ID="BopRDsAudit";
	@Override
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean multiUpdateResultBean,
			HttpServletRequest request, HttpServletResponse respone)
			throws AppException {
		try {
			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID(DATASET_ID);
			List<MtsBopDrDs> mtsBopDrDsList = new ArrayList<MtsBopDrDs>();
			while (updateResultBean.hasNext())
			{
				MtsBopDrDs mtsBopDrDs = new MtsBopDrDs();
				Map map = updateResultBean.next();
				mapToObject(mtsBopDrDs,map);
				mtsBopDrDsList.add(mtsBopDrDs);
			}
			String approveStatusChoose = updateResultBean.getParameter("approveStatusChoose");
			String approveResultChoose = updateResultBean.getParameter("approveResultChoose");
			
			OperationContext oc = new OperationContext();
			oc.setAttribute(BopDRDsAuditOperation.CMD, BopDRDsAuditOperation.OP_LOAN_AUDIT);
			oc.setAttribute(BopDRDsAuditOperation.IN_AUDIT_LIST, mtsBopDrDsList);
			oc.setAttribute(BopDRDsAuditOperation.IN_AUDIT_STATUS, approveStatusChoose);
			oc.setAttribute(BopDRDsAuditOperation.IN_AUDIT_RESULT, approveResultChoose);
			oc.setAttribute(BopDRDsAuditOperation.CHOOSE, BopDRDsAuditOperation.GUAN_LI);
			OPCaller.call(BopDRDsAuditOperation.ID, oc);
			
			return updateReturnBean;
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}
}
