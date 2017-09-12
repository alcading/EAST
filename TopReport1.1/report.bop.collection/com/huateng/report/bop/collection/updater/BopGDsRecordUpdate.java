package com.huateng.report.bop.collection.updater;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import resource.bean.report.MtsBopAgDs;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;
import com.huateng.report.bop.collection.operation.BopAgDsOperation;

public class BopGDsRecordUpdate extends BaseUpdate{
	
	private static final String DATASET_ID="bopGDsRecordInfo";
	private static final String RECORD_DEL="del";
	private static final String RECORD_ADD="add";
	private static final String RECORD_MOD="mod";
	
	@SuppressWarnings("rawtypes")
	@Override
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean multiUpdateResultBean,
			HttpServletRequest request, HttpServletResponse respone)
			throws AppException {

		try {
			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID(DATASET_ID);
			MtsBopAgDs bopAgDs = null ;
			while (updateResultBean.hasNext()) {
				bopAgDs = new MtsBopAgDs();
				Map map = updateResultBean.next();
				mapToObject(bopAgDs,map);
			}

			String op = updateResultBean.getParameter("op");
			if (RECORD_ADD.equals(op)) {
				OperationContext oc = new OperationContext();
				oc.setAttribute(BopAgDsOperation.CMD, BopAgDsOperation.OP_G_NEW);
				oc.setAttribute(BopAgDsOperation.IN_G_NEW, bopAgDs);
				OPCaller.call(BopAgDsOperation.ID, oc);
			} else if (RECORD_MOD.equals(op)) {
				OperationContext oc = new OperationContext();
				oc.setAttribute(BopAgDsOperation.CMD, BopAgDsOperation.OP_G_MOD);
				oc.setAttribute(BopAgDsOperation.IN_G_MOD, bopAgDs);
				OPCaller.call(BopAgDsOperation.ID, oc);
			} else if (RECORD_DEL.equals(op)) {
				OperationContext oc = new OperationContext();
				oc.setAttribute(BopAgDsOperation.CMD, BopAgDsOperation.OP_G_DEL);
				oc.setAttribute(BopAgDsOperation.IN_G_DEL, bopAgDs);
				OPCaller.call(BopAgDsOperation.ID, oc);
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
