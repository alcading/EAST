package com.huateng.ebank.business.workflowRoute.updater;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.business.workflowRoute.operation.SaveRouteTemplateUpdateOperation;
import com.huateng.ebank.entity.data.workflow.WorkflowRouteDef;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;

/**
 * @author UU_Wu
 *
 */
public class SaveRouteTemplateUpdate extends BaseUpdate {

	@Override
	public UpdateReturnBean saveOrUpdate(
			MultiUpdateResultBean multiUpdateResultBean,
			HttpServletRequest request, HttpServletResponse response)
			throws AppException {
		// TODO Auto-generated method stub

			String nextUrl = "";

			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			UpdateResultBean updateResultBean = multiUpdateResultBean
					.getUpdateResultBeanByID("routeTemplateSet");
//			List<PostloanMngInfo> updateList = new ArrayList<PostloanMngInfo>();

			List updateList = new ArrayList();
			List delList = new ArrayList();
			List insertList = new ArrayList();


			while (updateResultBean.hasNext()) {
				WorkflowRouteDef workflowRouteDef = new WorkflowRouteDef();
				Map map = updateResultBean.next();
				mapToObject(workflowRouteDef, map);

				switch (updateResultBean.getRecodeState()) {
				case UpdateResultBean.INSERT:
					insertList.add(workflowRouteDef);
					break;
				case UpdateResultBean.DELETE:
					delList.add(workflowRouteDef);
					break;
				case UpdateResultBean.MODIFY:
					updateList.add(workflowRouteDef);
					break;
				default:
					break;
				}

			}
			OperationContext oc = new OperationContext();
			oc.setAttribute(SaveRouteTemplateUpdateOperation.IN_DEL, delList);
			oc.setAttribute(SaveRouteTemplateUpdateOperation.IN_INSERT, insertList);
			oc.setAttribute(SaveRouteTemplateUpdateOperation.IN_UPDATE, updateList);
			OPCaller
					.call("Management.SaveRouteTemplateUpdateOperation", oc);
			return updateReturnBean;


	}

}
