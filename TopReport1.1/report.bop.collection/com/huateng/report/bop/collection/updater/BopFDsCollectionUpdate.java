package com.huateng.report.bop.collection.updater;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import resource.bean.report.MtsBopFsDs;

import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;
import com.huateng.report.bop.collection.operation.BopFsDsOperation;

public class BopFDsCollectionUpdate extends BaseUpdate {
	
	@Override
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean arg0,
			HttpServletRequest arg1, HttpServletResponse arg2)
			throws AppException {
		//返回对象
		UpdateReturnBean updateReturnBean = new UpdateReturnBean();
		//结果集对象
		UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID("BopFDsCollection");
		//更新对象
		MtsBopFsDs bopFsDs = new MtsBopFsDs();
		//Operation参数
		if(updateResultBean.hasNext()) {
			Map map = updateResultBean.next();
			mapToObject(bopFsDs, map);
			OperationContext context = new OperationContext();
			String op = updateResultBean.getParameter("op");
			if ("new".equals(op)) {
				context.setAttribute(BopFsDsOperation.CMD, BopFsDsOperation.OP_F_NEW);
				context.setAttribute(BopFsDsOperation.IN_F_NEW, bopFsDs);
			} else if ("modify".equals(op)){
				context.setAttribute(BopFsDsOperation.CMD, BopFsDsOperation.OP_F_MOD);
				context.setAttribute(BopFsDsOperation.IN_F_MOD, bopFsDs);
			} else if ("delete".equals(op)){
				context.setAttribute(BopFsDsOperation.CMD, BopFsDsOperation.OP_F_DEL);
				context.setAttribute(BopFsDsOperation.IN_F_DEL, bopFsDs);
			}
			OPCaller.call(BopFsDsOperation.ID, context);
		}
		return updateReturnBean;
	}
	
}
