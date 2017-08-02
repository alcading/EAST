package com.huateng.report.basis.updater;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import resource.bean.report.BiAccount;

import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;
import com.huateng.report.basis.operation.BiAccountOperation;

public class BiAccountManDelUpdate extends BaseUpdate {

	private static final String DATASET_ID="BiAccountEntry";
	@Override
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean multiUpdateResultBean,
			HttpServletRequest request, HttpServletResponse response)
			throws AppException {
		//返回对象
		UpdateReturnBean updateReturnBean = new UpdateReturnBean();

		//
		UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID(DATASET_ID);

		//

		BiAccount biAccount = new BiAccount();

		OperationContext oc = new OperationContext();

		if(updateResultBean.hasNext())
		{
			Map map = updateResultBean.next();
			mapToObject(biAccount,map);
			oc.setAttribute(BiAccountOperation.CMD, BiAccountOperation.CMD_DELETE);
		}

		oc.setAttribute(BiAccountOperation.IN_PARAM, biAccount);
		OPCaller.call(BiAccountOperation.ID, oc);

		return updateReturnBean;
	}

}
