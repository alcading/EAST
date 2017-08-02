package com.huateng.report.basis.updater;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import resource.bean.report.BiCustomer;
import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;

import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;
import com.huateng.report.basis.operation.CustomerReaOperation;

public class CustomerReaUpdate  extends BaseUpdate{
	private static final String DATASET_ID="CustomerReaInfo";
	@Override
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean multiUpdateResultBean,
			HttpServletRequest request, HttpServletResponse response)
			throws AppException {
		// TODO Auto-generated method stub
		UpdateReturnBean updateReturnBean = new UpdateReturnBean();
		UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID(DATASET_ID);
		BiCustomer bi =new BiCustomer();
		
		
		OperationContext oc= new OperationContext();
		ROOTDAO rootDao = ROOTDAOUtils.getROOTDAO();
		if(updateResultBean.hasNext()){
			Map map = updateResultBean.next();
			mapToObject(bi,map);
			String op = updateResultBean.getParameter("op");
			if("new".equalsIgnoreCase(op)){
				oc.setAttribute(CustomerReaOperation.CMD, CustomerReaOperation.CMD_INSERT);
			}else if("mod".equalsIgnoreCase(op)){
				oc.setAttribute(CustomerReaOperation.CMD, CustomerReaOperation.CMD_UPDATE);
			}
			
		}
		oc.setAttribute(CustomerReaOperation.IN_PARAM, bi);
		OPCaller.call(CustomerReaOperation.ID, oc);
		
		return  updateReturnBean;
	}

}
