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
import com.huateng.report.operation.BOPForDebtOtherDebtsOperation;

public class BOPForDebtOtherDebtsAuditUpdate extends BaseUpdate {

	private static final String DATASET_ID = "BOPForDebtOtherDebtsAudit";

	@Override
	@SuppressWarnings("unchecked")
	public UpdateReturnBean saveOrUpdate(
			MultiUpdateResultBean multiUpdateResultBean,
			HttpServletRequest request, HttpServletResponse respone)
			throws AppException {

		try {
			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID(DATASET_ID);

			List<BopCfaExdebtDs> bopcfaList = new ArrayList<BopCfaExdebtDs>();
			BopCfaExdebtDs bopcfa = null;
			while (updateResultBean.hasNext()) {
				bopcfa = new BopCfaExdebtDs();
				Map map = updateResultBean.next();
				mapToObject(bopcfa, map);
				bopcfaList.add(bopcfa);
			}

			String approveStatusChoose = updateResultBean.getParameter("approveStatusChoose");
			String approveResultChoose = updateResultBean.getParameter("approveResultChoose");

			OperationContext oc = new OperationContext();
			oc.setAttribute(BOPForDebtOtherDebtsOperation.CMD, BOPForDebtOtherDebtsOperation.CMD_APPROVE);
			oc.setAttribute(BOPForDebtOtherDebtsOperation.IN_AUDIT_LIST, bopcfaList);
			oc.setAttribute(BOPForDebtOtherDebtsOperation.IN_AUDIT_STATUS, approveStatusChoose);
			oc.setAttribute(BOPForDebtOtherDebtsOperation.IN_AUDIT_RESULT, approveResultChoose);
			OPCaller.call(BOPForDebtOtherDebtsOperation.ID, oc);

			return updateReturnBean;
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}

}
