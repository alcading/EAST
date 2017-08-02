package com.huateng.report.update;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import resource.bean.report.BopCfaDofoexloDs;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;
import com.huateng.report.operation.BopCfaDofoexloDsOperation;

public class BopCfaDofoexloDsAuditUpdate extends BaseUpdate {

	private static final String DATASET_ID = "BopCfaDofoexloDsAudit";

	@Override
	@SuppressWarnings("unchecked")
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean multiUpdateResultBean,
			HttpServletRequest request, HttpServletResponse response)
			throws AppException {

		try {
			//返回对象
			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			//结果集对象
			UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID(DATASET_ID);
			List<BopCfaDofoexloDs>approveList = new ArrayList<BopCfaDofoexloDs>();
			BopCfaDofoexloDs bopcfa = null;
			while (updateResultBean.hasNext()) {
				// 属性拷贝
				Map map = updateResultBean.next();
				bopcfa = new BopCfaDofoexloDs();
				mapToObject(bopcfa, map);
				Object select = map.get("select");
				if (null != select) {
					if (Boolean.valueOf(String.valueOf(select))) {
						approveList.add(bopcfa);
					}
				}
			}
			String approveStatus = updateResultBean.getParameter("approveStatusChoose");
			String approveResult = updateResultBean.getParameter("approveResultChoose");
			for(BopCfaDofoexloDs dofoexlods : approveList){
				dofoexlods.setApproveStatus(approveStatus);
				dofoexlods.setApproveResult(approveResult);
			}

			//Operation参数
			OperationContext context = new OperationContext();
			context.setAttribute(BopCfaDofoexloDsOperation.CMD, BopCfaDofoexloDsOperation.CMD_APPROVED);
			context.setAttribute(BopCfaDofoexloDsOperation.IN_PARAM, approveList);
			//call方式开启operation事务
			OPCaller.call(BopCfaDofoexloDsOperation.ID, context);
			return updateReturnBean;
		} catch (AppException appe) {
			throw appe;
		} catch (Exception e) {
			throw new AppException(Module.SYSTEM_MODULE,Rescode.DEFAULT_RESCODE,e.getMessage(),e);
		}
	}

}
