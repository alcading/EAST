package com.huateng.ebank.business.management.updater;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.management.operation.BrhWorkFlowMngOperation;
import com.huateng.ebank.entity.data.workflow.BrhWorkflowDef;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;

public class BrhWorkFlowMngUpdate extends BaseUpdate {

	@Override
	public UpdateReturnBean saveOrUpdate(
			MultiUpdateResultBean multiUpdateResultBean,
			HttpServletRequest request, HttpServletResponse response)
			throws AppException {
		// TODO Auto-generated method stub
		try {
			GlobalInfo g = GlobalInfo.getCurrentInstance();
//			if(!g.isHeadBrcode()) {
//				ExceptionUtil.throwCommonException("非总行系统管理员不能处理机构流程管理",
//						ErrorCode.ERROR_CODE_NO_PERMISSION);
//			}

			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			UpdateResultBean updateResultBean = multiUpdateResultBean
					.getUpdateResultBeanByID("Management_BrhWorkFlowMng");
			List<BrhWorkflowDef> updateList = new ArrayList<BrhWorkflowDef>();
			List<BrhWorkflowDef> delList = new ArrayList<BrhWorkflowDef>();
			List<BrhWorkflowDef> insertList = new ArrayList<BrhWorkflowDef>();
			while (updateResultBean.hasNext()) {
				BrhWorkflowDef brhWorkflowDef = new BrhWorkflowDef();
				mapToObject(brhWorkflowDef, updateResultBean.next());
//				Map map = updateResultBean.next();
//				brhWorkflowDef.setId(new Long((String)map.get("id")));
//				brhWorkflowDef.setBrcode((String)map.get("brcode"));
//				brhWorkflowDef.setApptype((String)map.get("apptype"));
//				brhWorkflowDef.setBizClass((String)map.get("bizClass"));
//				brhWorkflowDef.setProcessTemplate((String)map.get("processTemplate"));


			switch (updateResultBean.getRecodeState()) {
			case UpdateResultBean.INSERT:
				insertList.add(brhWorkflowDef);
				break;
			case UpdateResultBean.DELETE:
				delList.add(brhWorkflowDef);
				break;
			case UpdateResultBean.MODIFY:
				updateList.add(brhWorkflowDef);
				break;
			default:
				break;
				}
			}
			OperationContext oc = new OperationContext();
			oc.setAttribute(BrhWorkFlowMngOperation.DELETE_LIST, delList);
			oc.setAttribute(BrhWorkFlowMngOperation.INSERT_LIST, insertList);
			oc.setAttribute(BrhWorkFlowMngOperation.UPDATE_LIST, updateList);
	        OPCaller.call(BrhWorkFlowMngOperation.ID, oc);
			return updateReturnBean;
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}

}

