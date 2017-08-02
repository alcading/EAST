package com.huateng.report.bop.audit.updater;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import resource.bean.report.MtsBopBhnDs;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;
import com.huateng.report.bop.audit.operation.BopBhnDsAuditOperation;

public class BopBhnDsBasicAuditUpdate extends BaseUpdate {
	
	public static final String DATA_SET_BASIC_ID = "BopBhnDsAuditEntry";
	
	@Override
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean arg0,
			HttpServletRequest arg1, HttpServletResponse arg2)
			throws AppException {
		// TODO Auto-generated method stub
		try {
			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID(DATA_SET_BASIC_ID);
			OperationContext context = new OperationContext();
			List<MtsBopBhnDs> list = new ArrayList<MtsBopBhnDs>();
			while(updateResultBean.hasNext()) {
				Map map = updateResultBean.next();
				MtsBopBhnDs ds = new MtsBopBhnDs();
				mapToObject(ds, map);
				list.add(ds);
			}
			String approveStatusChoose = updateResultBean.getParameter("approveStatusChoose");
			String approveResultChoose = updateResultBean.getParameter("approveResultChoose");
			context.setAttribute(BopBhnDsAuditOperation.BASIC_AUDIT_LIST_IN_PARAM,list);
			context.setAttribute(BopBhnDsAuditOperation.AUDIT_STATUS, approveStatusChoose);
			context.setAttribute(BopBhnDsAuditOperation.AUDIT_RESULT, approveResultChoose);
			context.setAttribute(BopBhnDsAuditOperation.CMD, BopBhnDsAuditOperation.CMD_BAIS_AUDIT);
			OPCaller.call(BopBhnDsAuditOperation.ID, context);
			return updateReturnBean;
		} catch (AppException appe) {
			throw appe;
		} catch (Exception e) {
			throw new AppException(Module.SYSTEM_MODULE,Rescode.DEFAULT_RESCODE,e.getMessage(),e);
		}
	}

}
