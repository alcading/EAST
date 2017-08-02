package com.huateng.report.execconfirm.updater;

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
import com.huateng.report.execconfirm.operation.BiExecConfirmOperation;

public class BiExecConfirmUnLockUpdate extends BaseUpdate{
	
	@Override
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean multiUpdateResultBean,
			HttpServletRequest request, HttpServletResponse respone)
			throws AppException {
		
		try {
			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID("genReportFile");

			String appType = updateResultBean.getParameter("appType");
			String busiType = updateResultBean.getParameter("busiType");
			String subfileRemark = updateResultBean.getParameter("subfileRemark");
			
			OperationContext oc = new OperationContext();
			oc.setAttribute(BiExecConfirmOperation.CMD, BiExecConfirmOperation.OP_UNLOCK);
			oc.setAttribute(BiExecConfirmOperation.IN_BUSITYPE, busiType);
			oc.setAttribute(BiExecConfirmOperation.IN_APPTYPE, appType);
			oc.setAttribute(BiExecConfirmOperation.IN_REMARK, subfileRemark);
			OPCaller.call(BiExecConfirmOperation.ID, oc);
			
			return updateReturnBean;
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}

}
