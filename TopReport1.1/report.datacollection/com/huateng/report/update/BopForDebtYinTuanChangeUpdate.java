package com.huateng.report.update;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import resource.bean.report.BopCfaExdebtDs;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;
import com.huateng.report.operation.BopForDebtYinTuanOperation;

public class BopForDebtYinTuanChangeUpdate extends BaseUpdate{
	
	@Override
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean multiUpdateResultBean,
			HttpServletRequest request, HttpServletResponse respone)
			throws AppException {
		
		try {
			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			
			//外债主信息
			UpdateResultBean BcedUpdateResultBean = multiUpdateResultBean.getUpdateResultBeanByID("bopForDebtYinTuanChange");
			BopCfaExdebtDs bopCfaExdebtDs = null ;
			while (BcedUpdateResultBean.hasNext()){
				bopCfaExdebtDs = new BopCfaExdebtDs();
				mapToObject(bopCfaExdebtDs,BcedUpdateResultBean.next());
			}
			
			String op = BcedUpdateResultBean.getParameter("op");
			OperationContext oc = new OperationContext();
			if (op.equals("new")) {
				oc.setAttribute(BopForDebtYinTuanOperation.CMD, BopForDebtYinTuanOperation.OP_CHANGE_NEW);
			} else if (op.equals("modify")) {
				oc.setAttribute(BopForDebtYinTuanOperation.CMD, BopForDebtYinTuanOperation.OP_CHANGE_MOD);
			} else if (op.equals("delete")) {
				oc.setAttribute(BopForDebtYinTuanOperation.CMD, BopForDebtYinTuanOperation.OP_CHANGE_DEL);
			}
			oc.setAttribute(BopForDebtYinTuanOperation.IN_SIGNED_DEBTBEAN, bopCfaExdebtDs);
			OPCaller.call(BopForDebtYinTuanOperation.ID, oc);
			
			return updateReturnBean;
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}

}
