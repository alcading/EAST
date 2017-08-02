package com.huateng.report.update;

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

public class BopForDebtFeiPerSaveOverUpdate extends BaseUpdate{
	
	@Override
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean multiUpdateResultBean,
			HttpServletRequest request, HttpServletResponse respone)
			throws AppException {
		
		try {
			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			
			//外债主信息
			UpdateResultBean BcedUpdateResultBean = multiUpdateResultBean.getUpdateResultBeanByID("bopForDebtFeiPerSaveOver");
			BopForDebtFeiPerSave debtFeiPerSave = null ;
			while (BcedUpdateResultBean.hasNext()){
				debtFeiPerSave = new BopForDebtFeiPerSave();
				mapToObject(debtFeiPerSave,BcedUpdateResultBean.next());
			}
			
			String op = BcedUpdateResultBean.getParameter("op");
			OperationContext oc = new OperationContext();
			if (op.equals("new")) {
				oc.setAttribute(BopForDebtFeiPerSaveOperation.CMD, BopForDebtFeiPerSaveOperation.OP_OVER_NEW);
			} else if (op.equals("modify")) {
				oc.setAttribute(BopForDebtFeiPerSaveOperation.CMD, BopForDebtFeiPerSaveOperation.OP_OVER_MOD);
			} else if (op.equals("delete")) {
				oc.setAttribute(BopForDebtFeiPerSaveOperation.CMD, BopForDebtFeiPerSaveOperation.OP_OVER_DEL);
			}
			oc.setAttribute(BopForDebtFeiPerSaveOperation.IN_SIGNED_FEIPERSAVE, debtFeiPerSave);
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
