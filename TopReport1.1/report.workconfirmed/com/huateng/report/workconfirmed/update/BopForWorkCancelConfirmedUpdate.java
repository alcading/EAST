package com.huateng.report.workconfirmed.update;

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
import com.huateng.report.workconfirmed.operation.BopForWorkConfirmedOperation;

public class BopForWorkCancelConfirmedUpdate extends BaseUpdate {

	private static final String DATASET_ID="BOPForBiExecConfirmedEntry";

	@Override
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean multiUpdateResultBean,
			HttpServletRequest request, HttpServletResponse respone)
			throws AppException {
		
		try {
			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID(DATASET_ID);

			//TODO
			
			String confirmRemark = updateResultBean.getParameter("confirmRemark");
			String busiType = updateResultBean.getParameter("busiType");
			String appType = updateResultBean.getParameter("appType");
			if(null==confirmRemark)
			{
				confirmRemark="";
			}
			
			OperationContext oc = new OperationContext();
			oc.setAttribute(BopForWorkConfirmedOperation.CMD,BopForWorkConfirmedOperation.OP_UNLOCK);
			oc.setAttribute(BopForWorkConfirmedOperation.IN_REMARK, confirmRemark);
			oc.setAttribute(BopForWorkConfirmedOperation.IN_BUSITYPE, busiType);
			oc.setAttribute(BopForWorkConfirmedOperation.IN_APPTYPE, appType);
			OPCaller.call(BopForWorkConfirmedOperation.ID, oc);
			
			return updateReturnBean;
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}
}
