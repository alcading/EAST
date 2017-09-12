package com.huateng.report.update;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
import com.huateng.report.operation.BOPForDebtBalanceInfoOperation;

public class BOPForDebtBalanceInfoAuditUpdate extends BaseUpdate {

	@SuppressWarnings("rawtypes")
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean multiUpdateResultBean,
			HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
			throws AppException {
		try {
			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID("BOPForDebtBalanceInfoAudit");
			List<BopCfaExdebtDs> bopCfaExDsList = new ArrayList<BopCfaExdebtDs>();
			while (updateResultBean.hasNext())
			{
				BopCfaExdebtDs bopCfaExdebtDs = new BopCfaExdebtDs();
				Map map = updateResultBean.next();
				mapToObject(bopCfaExdebtDs,map);
				bopCfaExDsList.add(bopCfaExdebtDs);
			}
			String approveStatusChoose = updateResultBean.getParameter("approveStatusChoose");
			String approveResultChoose = updateResultBean.getParameter("approveResultChoose");

			OperationContext oc = new OperationContext();
			oc.setAttribute(BOPForDebtBalanceInfoOperation.CMD, BOPForDebtBalanceInfoOperation.OP_BALANCE_AUDIT);
			oc.setAttribute(BOPForDebtBalanceInfoOperation.IN_AUDIT_LIST, bopCfaExDsList);
			oc.setAttribute(BOPForDebtBalanceInfoOperation.IN_AUDIT_STATUS, approveStatusChoose);
			oc.setAttribute(BOPForDebtBalanceInfoOperation.IN_AUDIT_RESULT, approveResultChoose);
			OPCaller.call(BOPForDebtBalanceInfoOperation.ID, oc);

			return updateReturnBean;
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}

	}
}