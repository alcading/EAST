/**
 *
 */
package com.huateng.ebank.business.workflowRoute.updater;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.business.workflowRoute.operation.SaveRouteDetailUpdateOperation;
import com.huateng.ebank.entity.data.workflow.WorkflowRouteParam;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.util.DataFormat;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;
/**
 * @author UU_Wu
 *
 */
public class SaveRouteDetailUpdate extends BaseUpdate {

	@Override
	public UpdateReturnBean saveOrUpdate(
			MultiUpdateResultBean multiUpdateResultBean,
			HttpServletRequest request, HttpServletResponse response)
			throws AppException {

			String nextUrl = "";

			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			UpdateResultBean updateResultBean = multiUpdateResultBean
					.getUpdateResultBeanByID("routeDetailSet");
//			List<PostloanMngInfo> updateList = new ArrayList<PostloanMngInfo>();
			List updateList = new ArrayList();
			List delList = new ArrayList();
			List insertList = new ArrayList();
			String routeId = (String) updateResultBean.getParamMap().get("routeId");

			while (updateResultBean.hasNext()) {
				WorkflowRouteParam workflowRouteParam = new WorkflowRouteParam();
				Map map = updateResultBean.next();
				String brhClass = (String) map.get("brhClass1");
				mapToObject(workflowRouteParam, map);
				workflowRouteParam.setBrhClass(brhClass);
				if(!DataFormat.isEmpty(routeId)){
					workflowRouteParam.setRouteId(Integer.parseInt(routeId));
//					WorkflowRouteDef workflowRouteDef = DAOUtils.getWorkflowRouteDefDAO().query(Integer.parseInt(routeId));
//					String brclass = workflowRouteDef.getBrhClass();
//					if(Integer.parseInt(workflowRouteParam.getBrhClass())<Integer.parseInt(brclass)){
//						ExceptionUtil.throwCommonException("明细的机构级别不能高于审批路线模板的机构级别");
//					}
				}
				switch (updateResultBean.getRecodeState()) {
				case UpdateResultBean.INSERT:
					insertList.add(workflowRouteParam);
					break;
				case UpdateResultBean.DELETE:
					delList.add(workflowRouteParam);
					break;
				case UpdateResultBean.MODIFY:
					updateList.add(workflowRouteParam);
					break;
				default:
					break;
				}

			}

			OperationContext oc = new OperationContext();
			oc.setAttribute(SaveRouteDetailUpdateOperation.IN_DEL, delList);
			oc.setAttribute(SaveRouteDetailUpdateOperation.IN_INSERT, insertList);
			oc.setAttribute(SaveRouteDetailUpdateOperation.IN_UPDATE, updateList);

			OPCaller
					.call("Management.SaveRouteDetailUpdateOperation", oc);
			return updateReturnBean;


	}

}
