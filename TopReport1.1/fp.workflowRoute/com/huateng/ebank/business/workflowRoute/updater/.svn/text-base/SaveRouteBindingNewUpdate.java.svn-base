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
import com.huateng.ebank.business.management.bean.RouteBindingView;
import com.huateng.ebank.business.workflowRoute.operation.SaveRouteBindingUpdateOperation;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;

/**
 * @author UU_Wu
 *
 */
public class SaveRouteBindingNewUpdate extends BaseUpdate {

	@Override
	public UpdateReturnBean saveOrUpdate(
			MultiUpdateResultBean multiUpdateResultBean,
			HttpServletRequest request, HttpServletResponse response)
			throws AppException {

			String nextUrl = "";

			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			UpdateResultBean updateResultBean1 = multiUpdateResultBean.getUpdateResultBeanByID("routeBindingDetail1_Config");
//			List<PostloanMngInfo> updateList = new ArrayList<PostloanMngInfo>();
			List bindinglist = new ArrayList();

			RouteBindingView routeBindingView1 = null;
			while (updateResultBean1.hasNext()) {
				routeBindingView1 = new RouteBindingView();
				Map map = updateResultBean1.next();
				mapToObject(routeBindingView1, map);
			}
			UpdateResultBean updateResultBean2 = multiUpdateResultBean.getUpdateResultBeanByID("routeBindingDetail2_Config");
			RouteBindingView routeBindingView2 = null;
			while (updateResultBean2.hasNext()) {
				routeBindingView2 = new RouteBindingView();
				Map map = updateResultBean2.next();
				mapToObject(routeBindingView2, map);
				routeBindingView2.setBussType(routeBindingView1.getBussType());
				routeBindingView2.setBrhClass(routeBindingView1.getBrhClass());
				routeBindingView2.setDraftType(routeBindingView1.getDraftType());
				routeBindingView2.setStartBrhno(routeBindingView1.getStartBrhno());
				routeBindingView2.setStartBrhid(routeBindingView1.getStartBrhid());
				routeBindingView2.setStartBrhidName(routeBindingView1.getStartBrhidName());
				routeBindingView2.setMaxAmt(routeBindingView1.getMaxAmt());
				routeBindingView2.setId(routeBindingView1.getId());
				bindinglist.add(routeBindingView2);
//				if(temp.isSelected()){
//					routeBindingView.setRouteId(temp.getRouteId());
//					routeBindingView.setSelected(true);
////					bindinglist.add(routeBindingView);
//				}

			}

			OperationContext oc = new OperationContext();
			oc.setAttribute(SaveRouteBindingUpdateOperation.IN_LIST, bindinglist);
//			oc.setAttribute(SaveRouteDetailUpdateOperation.IN_INSERT, insertList);
//			oc.setAttribute(SaveRouteDetailUpdateOperation.IN_UPDATE, updateList);

			OPCaller
					.call("Management.SaveRouteBindingUpdateOperation", oc);
			return updateReturnBean;


	}

}
