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
import com.huateng.ebank.business.management.bean.RouteBindingView;
import com.huateng.ebank.business.workflowRoute.operation.SaveRouteBindingEntryOperation;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;

/**
 * @author UU_Wu
 *
 */
public class SaveRouteBindingEntryUpdate extends BaseUpdate {

	@Override
	public UpdateReturnBean saveOrUpdate(
			MultiUpdateResultBean multiUpdateResultBean,
			HttpServletRequest request, HttpServletResponse response)
			throws AppException {

			String nextUrl = "";

			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			UpdateResultBean updateResultBean = multiUpdateResultBean
					.getUpdateResultBeanByID("routeBindingEntry");
//			List<PostloanMngInfo> updateList = new ArrayList<PostloanMngInfo>();
			List updateList = new ArrayList();
			List delList = new ArrayList();
			List insertList = new ArrayList();

			while (updateResultBean.hasNext()) {
				RouteBindingView routeBindingView = new RouteBindingView();

				Map map = updateResultBean.next();
				
				if(StringUtils.isEmpty(map.get("startBrhid").toString())){
					map.put("startBrhid", map.get("startBrhLevel"));
				}
				
				String line = (String)map.get("bizType");
				if(StringUtils.isEmpty(line)){
					map.put("bizType", "0000");
				}
				map.put("bussType", map.get("bussType").toString() + map.get("bizType").toString());
				
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
