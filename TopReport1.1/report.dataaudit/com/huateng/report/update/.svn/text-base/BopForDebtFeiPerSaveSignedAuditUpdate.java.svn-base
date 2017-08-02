package com.huateng.report.update;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;
import com.huateng.report.bean.BopForDebtFeiPerSave;
import com.huateng.report.operation.BopForDebtFeiPerSaveOperation;

public class BopForDebtFeiPerSaveSignedAuditUpdate extends BaseUpdate{
	
	@Override
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean multiUpdateResultBean,
			HttpServletRequest request, HttpServletResponse respone)
			throws AppException {
		
		try {
			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID("bopForDebtFeiPerSaveSignedAudit");
			List<BopForDebtFeiPerSave> debtFeiPerSaves = new ArrayList<BopForDebtFeiPerSave>();
			while (updateResultBean.hasNext())
			{
				BopForDebtFeiPerSave debtFeiPerSave = new BopForDebtFeiPerSave();
				Map map = updateResultBean.next();
				mapToObject(debtFeiPerSave,map);
				debtFeiPerSaves.add(debtFeiPerSave);
			}
			String approveStatusChoose = updateResultBean.getParameter("approveStatusChoose");
			String approveResultChoose = updateResultBean.getParameter("approveResultChoose");
			
			OperationContext oc = new OperationContext();
			oc.setAttribute(BopForDebtFeiPerSaveOperation.CMD, BopForDebtFeiPerSaveOperation.OP_SIGNED_AUDIT);
			oc.setAttribute(BopForDebtFeiPerSaveOperation.IN_AUDIT_LIST, debtFeiPerSaves);
			oc.setAttribute(BopForDebtFeiPerSaveOperation.IN_AUDIT_STATUS, approveStatusChoose);
			oc.setAttribute(BopForDebtFeiPerSaveOperation.IN_AUDIT_RESULT, approveResultChoose);
			OPCaller.call(BopForDebtFeiPerSaveOperation.ID, oc);
			
			return updateReturnBean;
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}

}
