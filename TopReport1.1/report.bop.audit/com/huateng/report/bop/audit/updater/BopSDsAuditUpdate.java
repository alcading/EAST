package com.huateng.report.bop.audit.updater;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import resource.bean.report.MtsBopFsDs;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;
import com.huateng.report.bop.collection.operation.BopFsDsOperation;
public class BopSDsAuditUpdate extends BaseUpdate {
	
	@Override
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean multiUpdateResultBean,
			HttpServletRequest request, HttpServletResponse respone)
			throws AppException {
		
		try {
			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID("BopSDsAudit");
			List<MtsBopFsDs> mtsBopFsDsList = new ArrayList<MtsBopFsDs>();
			while (updateResultBean.hasNext())
			{
				MtsBopFsDs mtsBopFsDs = new MtsBopFsDs();
				Map map = updateResultBean.next();
				mapToObject(mtsBopFsDs,map);
				mtsBopFsDsList.add(mtsBopFsDs);
			}
			String approveStatusChoose = updateResultBean.getParameter("approveStatusChoose");
			String approveResultChoose = updateResultBean.getParameter("approveResultChoose");
			
			OperationContext oc = new OperationContext();
			oc.setAttribute(BopFsDsOperation.CMD, BopFsDsOperation.OP_S_AUDIT);
			oc.setAttribute(BopFsDsOperation.IN_AUDIT_LIST, mtsBopFsDsList);
			oc.setAttribute(BopFsDsOperation.IN_AUDIT_STATUS, approveStatusChoose);
			oc.setAttribute(BopFsDsOperation.IN_AUDIT_RESULT, approveResultChoose);
			OPCaller.call(BopFsDsOperation.ID, oc);
			
			return updateReturnBean;
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}

}
