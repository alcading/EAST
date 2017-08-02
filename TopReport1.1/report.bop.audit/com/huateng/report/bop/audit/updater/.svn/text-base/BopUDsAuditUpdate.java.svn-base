package com.huateng.report.bop.audit.updater;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import resource.bean.report.MtsBopUDs;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;
import com.huateng.report.bop.collection.operation.BopUDsOperation;

public class BopUDsAuditUpdate extends BaseUpdate {

	private static final String DATASET_ID = "BopUDsAudit";

	@SuppressWarnings("rawtypes")
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean multiUpdateResultBean,
			HttpServletRequest request, HttpServletResponse respone)
			throws AppException {

		try {
			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID(DATASET_ID);
			List<MtsBopUDs> mtsBopFsDsList = new ArrayList<MtsBopUDs>();
			while (updateResultBean.hasNext())
			{
				MtsBopUDs mtsBopUDs = new MtsBopUDs();
				Map map = updateResultBean.next();
				mapToObject(mtsBopUDs,map);
				mtsBopFsDsList.add(mtsBopUDs);
			}
			String approveStatusChoose = updateResultBean.getParameter("approveStatusChoose");
			String approveResultChoose = updateResultBean.getParameter("approveResultChoose");

			OperationContext oc = new OperationContext();
			oc.setAttribute(BopUDsOperation.CMD, BopUDsOperation.CMD_AUDIT);
			oc.setAttribute(BopUDsOperation.PARAM_U, mtsBopFsDsList);
			if (null != approveStatusChoose) {
				oc.setAttribute(BopUDsOperation.IN_AUDIT_STATUS, approveStatusChoose);
			}
			if (null != approveResultChoose) {
				oc.setAttribute(BopUDsOperation.IN_AUDIT_RESULT, approveResultChoose);
			}
			OPCaller.call(BopUDsOperation.ID, oc);

			return updateReturnBean;
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}

}