package com.huateng.report.basis.updater;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import resource.bean.report.BiCustomer;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;
import com.huateng.report.basis.operation.CustomerReaOperation;

public class CustomerReaDelUpdate extends BaseUpdate{
	
	private static final String DATASET_ID = "CustomerReaEntry";
	
	@Override
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean multiUpdateResultBean,
			HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
			throws AppException {
		// TODO Auto-generated method stub
	
		try {
			UpdateReturnBean updateRetrunBean = new UpdateReturnBean();
			UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID(DATASET_ID);
			BiCustomer bi = new BiCustomer();
			//Operation 的参数
			OperationContext oc = new OperationContext();
			
			if(updateResultBean.hasNext()){
				Map map = updateResultBean.next();
				oc.setAttribute(CustomerReaOperation.CMD, CustomerReaOperation.CMD_DELETE);
				//属性拷贝
				mapToObject(bi, map);
			}
			oc.setAttribute(CustomerReaOperation.IN_PARAM, bi);
			OPCaller.call(CustomerReaOperation.ID, oc);
			return updateRetrunBean;
			
		} catch (AppException Ae) {
			// TODO: handle exception
			throw Ae;
		}catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}
	
}
