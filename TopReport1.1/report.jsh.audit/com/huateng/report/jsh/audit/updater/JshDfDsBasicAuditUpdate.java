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
import com.huateng.report.jsh.audit.operation.JshDfDsAuditOperation;

public class JshDfDsBasicAuditUpdate extends BaseUpdate {

	public static final String DATA_SET_BASIC_ID = "JshDfDsAuditEntry";
	
	@Override
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean arg0,
			HttpServletRequest arg1, HttpServletResponse arg2)
			throws AppException {
		// TODO Auto-generated method stub
		try {
			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID(DATA_SET_BASIC_ID);
			OperationContext context = new OperationContext();
			List<MtsJshDefgDs> list = new ArrayList<MtsJshDefgDs>();
			while(updateResultBean.hasNext()) {
				Map map = updateResultBean.next();
				MtsJshDefgDs ds = new MtsJshDefgDs();
				mapToObject(ds, map);
				list.add(ds);
			}
			String approveStatusChoose = updateResultBean.getParameter("approveStatusChoose");
			String approveResultChoose = updateResultBean.getParameter("approveResultChoose");
			context.setAttribute(JshDfDsAuditOperation.BASIC_AUDIT_LIST_IN_PARAM,list);
			context.setAttribute(JshDfDsAuditOperation.AUDIT_STATUS, approveStatusChoose);
			context.setAttribute(JshDfDsAuditOperation.AUDIT_RESULT, approveResultChoose);
			context.setAttribute(JshDfDsAuditOperation.CMD, JshDfDsAuditOperation.CMD_BASIC_AUDIT);
			OPCaller.call(JshDfDsAuditOperation.ID, context);
			return updateReturnBean;
		} catch (AppException appe) {
			throw appe;
		} catch (Exception e) {
			throw new AppException(Module.SYSTEM_MODULE,Rescode.DEFAULT_RESCODE,e.getMessage(),e);
		}
	}

}
