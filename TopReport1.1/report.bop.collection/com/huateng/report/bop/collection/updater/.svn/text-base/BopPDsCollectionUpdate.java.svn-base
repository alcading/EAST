package com.huateng.report.bop.collection.updater;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import resource.bean.report.MtsBopCkpDs;

import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;
import com.huateng.report.bop.collection.operation.BopCkpDsOperation;

public class BopPDsCollectionUpdate extends BaseUpdate {
	
	@Override
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean arg0,
			HttpServletRequest arg1, HttpServletResponse arg2)
			throws AppException {
		//返回对象
		UpdateReturnBean updateReturnBean = new UpdateReturnBean();
		//结果集对象
		UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID("BopPDsCollection");
		//更新对象
		MtsBopCkpDs bopCkpDs = new MtsBopCkpDs();
		//Operation参数
		if(updateResultBean.hasNext()) {
			Map map = updateResultBean.next();
			mapToObject(bopCkpDs, map);
			OperationContext context = new OperationContext();
			String op = updateResultBean.getParameter("op");
			if ("new".equals(op)) {
				context.setAttribute(BopCkpDsOperation.CMD, BopCkpDsOperation.OP_P_NEW);
				context.setAttribute(BopCkpDsOperation.IN_P_NEW, bopCkpDs);
			} else if ("modify".equals(op)){
				context.setAttribute(BopCkpDsOperation.CMD, BopCkpDsOperation.OP_P_MOD);
				context.setAttribute(BopCkpDsOperation.IN_P_MOD, bopCkpDs);
			} else if ("delete".equals(op)){
				context.setAttribute(BopCkpDsOperation.CMD, BopCkpDsOperation.OP_P_DEL);
				context.setAttribute(BopCkpDsOperation.IN_P_DEL, bopCkpDs);
			}
			OPCaller.call(BopCkpDsOperation.ID, context);
		}
		return updateReturnBean;
	}
	
}
