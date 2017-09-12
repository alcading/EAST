/**
 *
 */
package com.huateng.ebank.business.workflowRoute.updater;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.business.common.DAOUtils;
import com.huateng.ebank.business.management.bean.RouteBindingView;
import com.huateng.ebank.business.workflowRoute.operation.SaveRouteBindingEntryOperation;
import com.huateng.ebank.entity.dao.workflow.WorkflowBussTempletRelDAO;
import com.huateng.ebank.entity.dao.workflow.WorkflowParamDAO;
import com.huateng.ebank.entity.data.workflow.WorkflowBussTempletRel;
import com.huateng.ebank.entity.data.workflow.WorkflowParam;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;

/**
 * @author UU_Wu
 *
 */
public class SaveApproveNodeRouteBindingUpdate extends BaseUpdate {

	@Override
	public UpdateReturnBean saveOrUpdate(
			MultiUpdateResultBean multiUpdateResultBean,
			HttpServletRequest request, HttpServletResponse response)
			throws AppException {

			String nextUrl = "";


			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			UpdateResultBean updateResultBean = multiUpdateResultBean
					.getUpdateResultBeanByID("approveNodeRouteBinding");
//			List<PostloanMngInfo> updateList = new ArrayList<PostloanMngInfo>();
			List updateList = new ArrayList();
			List delList = new ArrayList();
			List insertList = new ArrayList();

			while (updateResultBean.hasNext()) {
				RouteBindingView routeBindingView = new RouteBindingView();

				String bussProc = "";
				Map map = updateResultBean.next();
				if(!StringUtils.isEmpty(map.get("bussProc").toString())){
					bussProc = map.get("bussProc").toString();
				}else{
					//
				}

				List relList = new ArrayList();
				List relList2 = new ArrayList();
				WorkflowBussTempletRelDAO workflowBussTempletRelDAO= DAOUtils.getWorkflowBussTempletRelDAO();
				relList = workflowBussTempletRelDAO.queryByCondition("po.bussProc = '"+bussProc+"'");
				if(relList==null||relList.size()==0){
					//
				}
				WorkflowBussTempletRel relBean = new WorkflowBussTempletRel();
				relBean = (WorkflowBussTempletRel)relList.get(0);
				String bussType = relBean.getBussProc();//process
				String procTemplet = relBean.getTempletName();
				WorkflowParamDAO workflowParamDAO = DAOUtils.getWorkflowParamDAO();
				relList2 = workflowParamDAO.queryByCondition("po.processTemplate = '"+procTemplet+"'");
				if(relList2==null||relList2.size()==0){
					//
				}
				WorkflowParam paramBean = new WorkflowParam();
				paramBean = (WorkflowParam)relList2.get(0);
				String draftType = paramBean.getApptype();//apptype

				if(StringUtils.isEmpty(map.get("startBrhid").toString())){
					map.put("startBrhid", map.get("startBrhLevel"));
				}

				String line = (String)map.get("bizType");
				if(StringUtils.isEmpty(line)){
					map.put("bizType", "0000");
				}
//				map.put("bussType", map.get("bussType").toString() + map.get("bizType").toString());
				map.put("bussType", bussType);
				map.put("draftType", draftType + map.get("bizType").toString());

				mapToObject(routeBindingView, map);

				switch (updateResultBean.getRecodeState()) {
				case UpdateResultBean.INSERT:
					insertList.add(routeBindingView);
					break;
				case UpdateResultBean.DELETE:
					delList.add(routeBindingView);
					break;
				case UpdateResultBean.MODIFY:
					updateList.add(routeBindingView);
					break;
				default:
					break;
				}

			}

			OperationContext oc = new OperationContext();
			oc.setAttribute(SaveRouteBindingEntryOperation.IN_DEL, delList);
			oc.setAttribute(SaveRouteBindingEntryOperation.IN_INSERT, insertList);
			oc.setAttribute(SaveRouteBindingEntryOperation.IN_UPDATE, updateList);

			OPCaller
					.call("Management.SaveRouteBindingEntryOperation", oc);
			return updateReturnBean;


	}

}
