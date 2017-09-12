package com.huateng.report.jsh.audit.updater;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import resource.bean.report.MtsJshDefgDs;
import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;

import com.huateng.report.jsh.audit.operation.JshEgDsAuditOperation;
public class JshGDsAuditUpdate extends BaseUpdate {
	
	private static final String DATASET_ID="JshGDsAudit";
	@Override
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean multiUpdateResultBean,
			HttpServletRequest request, HttpServletResponse respone)
			throws AppException {
		
		try {
			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID(DATASET_ID);
			List<MtsJshDefgDs> mtsJshDefgDsList = new ArrayList<MtsJshDefgDs>();
			while (updateResultBean.hasNext())
			{
				MtsJshDefgDs mtsJshDefgDs = new MtsJshDefgDs();
				Map map = updateResultBean.next();
				mapToObject(mtsJshDefgDs,map);
				mtsJshDefgDsList.add(mtsJshDefgDs);
			}
			String approveStatusChoose = updateResultBean.getParameter("approveStatusChoose");
			String approveResultChoose = updateResultBean.getParameter("approveResultChoose");
			
			OperationContext oc = new OperationContext();
			oc.setAttribute(JshEgDsAuditOperation.CMD, JshEgDsAuditOperation.OP_LOAN_AUDIT);
			oc.setAttribute(JshEgDsAuditOperation.IN_AUDIT_LIST, mtsJshDefgDsList);
			oc.setAttribute(JshEgDsAuditOperation.IN_AUDIT_STATUS, approveStatusChoose);
			oc.setAttribute(JshEgDsAuditOperation.IN_AUDIT_RESULT, approveResultChoose);
			oc.setAttribute(JshEgDsAuditOperation.CHOOSE, JshEgDsAuditOperation.JI_CHU);
			OPCaller.call(JshEgDsAuditOperation.ID, oc);
			
			return updateReturnBean;
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}

}
