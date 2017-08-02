package com.huateng.report.update;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import resource.bean.report.BopCfaStrdeDs;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;
import com.huateng.report.operation.BopCfaStrdeDsOperation;
/*
 * 终止信息变更(增加，修改，删除)
 */
public class BopCfaStrdeDsTerminateUpdate extends BaseUpdate {
	private static final String DATASET_ID = "bopCfaStrdeDsEntryTerminateAdd";
	private static final String updateType = "TERMINATE_";

	@SuppressWarnings("rawtypes")
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean multiUpdateResultBean,
			HttpServletRequest request, HttpServletResponse response)
			throws AppException {
		try {
			//返回对象
			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			//结果集对象
			UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID(DATASET_ID);
			//更新对象
			BopCfaStrdeDs bopCfaStrdeDs = new BopCfaStrdeDs();
			//Operation参数
			OperationContext context = new OperationContext();
			while (updateResultBean.hasNext()) {
				//属性拷贝
				Map map = updateResultBean.next();
				String op = updateResultBean.getParameter("op");
				mapToObject(bopCfaStrdeDs, map);
				//获得终止信息备注
				bopCfaStrdeDs.setRemark((String)map.get("remark1"));

				context.setAttribute(BopCfaStrdeDsOperation.CMD, updateType+op);
				context.setAttribute(BopCfaStrdeDsOperation.TERMINATE_IN_PARAM, bopCfaStrdeDs);
				OPCaller.call(BopCfaStrdeDsOperation.ID, context);
				return updateReturnBean;
			}
		} catch (AppException appe) {
			throw appe;
		} catch (Exception e) {
			throw new AppException(Module.SYSTEM_MODULE,Rescode.DEFAULT_RESCODE,e.getMessage(),e);
		}
		return null;
	}
}