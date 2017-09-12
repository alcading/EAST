package com.huateng.report.bop.collection.updater;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import resource.bean.report.MtsBopEqDs;

import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;
import com.huateng.report.bop.collection.operation.BopEqDsOperation;

/**
 * 境外汇款申请书-管理信息更新
 * 
 * @author Zhusujian
 *
 */
public class BopQDsCollectionUpdate extends BaseUpdate  {
	
	private static final String DATASET_ID="BopQDsCollectionInfo";
	private static final String RECORD_DEL="del";
	private static final String RECORD_ADD="add";
	private static final String RECORD_MOD="mod";
	
	@SuppressWarnings("rawtypes")
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean arg0,
			HttpServletRequest arg1, HttpServletResponse arg2)
			throws AppException {
		// 返回对象
		UpdateReturnBean updateReturnBean = new UpdateReturnBean();
		// 结果集对象
		UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID(DATASET_ID);
		// 更新对象
		MtsBopEqDs bopEqDs = new MtsBopEqDs();
		// Operation参数
		if (updateResultBean.hasNext()) {
			Map map = updateResultBean.next();
			mapToObject(bopEqDs, map);
			OperationContext context = new OperationContext();
			String op = updateResultBean.getParameter("op");
			if (RECORD_ADD.equals(op)) {
				context.setAttribute(BopEqDsOperation.CMD, BopEqDsOperation.OP_Q_NEW);
				context.setAttribute(BopEqDsOperation.IN_Q_NEW, bopEqDs);
			} else if (RECORD_MOD.equals(op)) {
				context.setAttribute(BopEqDsOperation.CMD, BopEqDsOperation.OP_Q_MOD);
				context.setAttribute(BopEqDsOperation.IN_Q_MOD, bopEqDs);
			} else if (RECORD_DEL.equals(op)) {
				context.setAttribute(BopEqDsOperation.CMD, BopEqDsOperation.OP_Q_DEL);
				context.setAttribute(BopEqDsOperation.IN_Q_DEL, bopEqDs);
			}
			OPCaller.call(BopEqDsOperation.ID, context);
		}
		return updateReturnBean;
	}
}