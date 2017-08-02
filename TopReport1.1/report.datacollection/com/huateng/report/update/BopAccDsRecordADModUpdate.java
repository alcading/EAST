package com.huateng.report.update;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import resource.bean.report.BopAccDs;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;
import com.huateng.report.operation.BopAccDsOperation;

public class BopAccDsRecordADModUpdate extends BaseUpdate{

	@Override
	@SuppressWarnings("unchecked")
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean multiUpdateResultBean,
			HttpServletRequest request, HttpServletResponse respone)
			throws AppException {

		try {
			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID("bopAccDsRecordADInfo");
			BopAccDs bopAccDs = null ;
			while (updateResultBean.hasNext())
			{
				bopAccDs = new BopAccDs();
				Map map = updateResultBean.next();
				mapToObject(bopAccDs,map);
			}

			String op = updateResultBean.getParameter("op");
			if (op.equals("modify")) {
				bopAccDs.setActiondesc(null);
				OperationContext oc = new OperationContext();
				oc.setAttribute(BopAccDsOperation.CMD, BopAccDsOperation.OP_AD_MOD);
				oc.setAttribute(BopAccDsOperation.IN_AD_MOD, bopAccDs);
				OPCaller.call(BopAccDsOperation.ID, oc);
			}
			if (op.equals("delete")) {
				OperationContext oc = new OperationContext();
				oc.setAttribute(BopAccDsOperation.CMD, BopAccDsOperation.OP_AD_DEL);
				oc.setAttribute(BopAccDsOperation.IN_AD_DEL, bopAccDs);
				OPCaller.call(BopAccDsOperation.ID, oc);
			}
			return updateReturnBean;
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}

}
