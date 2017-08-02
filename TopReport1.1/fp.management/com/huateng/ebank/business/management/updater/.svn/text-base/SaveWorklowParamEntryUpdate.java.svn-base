/**
 *
 */
package com.huateng.ebank.business.management.updater;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.business.management.operation.SaveWorklowParamEntryOperation;
import com.huateng.ebank.business.workflow.bean.WorkflowParamBean;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;

/**
 * @author UU_Wu
 *
 */
public class SaveWorklowParamEntryUpdate extends BaseUpdate {

	@Override
	public UpdateReturnBean saveOrUpdate(
			MultiUpdateResultBean multiUpdateResultBean,
			HttpServletRequest request, HttpServletResponse response)
			throws AppException {

			String nextUrl = "";

			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			UpdateResultBean updateResultBean = multiUpdateResultBean
					.getUpdateResultBeanByID("workflowParamEntry");
//			List<PostloanMngInfo> updateList = new ArrayList<PostloanMngInfo>();
			List updateList = new ArrayList();
			List delList = new ArrayList();
			List insertList = new ArrayList();

			while (updateResultBean.hasNext()) {
				WorkflowParamBean workflowParamBean = new WorkflowParamBean();
				Map map = updateResultBean.next();
				mapToObject(workflowParamBean, map);
				mapToObject(workflowParamBean.getWorkflowParam(), map);

				switch (updateResultBean.getRecodeState()) {
				case UpdateResultBean.INSERT:
					insertList.add(workflowParamBean);
					break;
				case UpdateResultBean.DELETE:
					delList.add(workflowParamBean);
					break;
				case UpdateResultBean.MODIFY:
					updateList.add(workflowParamBean);
					break;
				default:
					break;
				}

			}

			OperationContext oc = new OperationContext();
			oc.setAttribute(SaveWorklowParamEntryOperation.IN_DEL, delList);
			oc.setAttribute(SaveWorklowParamEntryOperation.IN_INSERT, insertList);
			oc.setAttribute(SaveWorklowParamEntryOperation.IN_UPDATE, updateList);

			OPCaller
					.call("Management.SaveWorklowParamEntryOperation", oc);
			return updateReturnBean;


	}

}
