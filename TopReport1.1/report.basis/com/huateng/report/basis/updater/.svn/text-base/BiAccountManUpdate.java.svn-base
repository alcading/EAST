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

public class BiAccountManUpdate extends BaseUpdate {

	private static final String DATASET_ID="BiAccountEntry";

	@Override
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean arg0,
			HttpServletRequest arg1, HttpServletResponse arg2)
			throws AppException {
		//返回对象
		UpdateReturnBean updateReturnBean = new UpdateReturnBean();

		//取得结果集对象
		UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID(DATASET_ID);

		//开始处理

		BiAccount biAccount = new BiAccount();

		OperationContext oc = new OperationContext();

		if(updateResultBean.hasNext())
		{
			Map map = updateResultBean.next();

			switch (updateResultBean.getRecodeState())
			{
			case UpdateResultBean.INSERT:
				oc.setAttribute(BiAccountOperation.CMD, BiAccountOperation.CMD_INSERT);
				mapToObject(biAccount,map);
				break;
			case UpdateResultBean.MODIFY:
				oc.setAttribute(BiAccountOperation.CMD, BiAccountOperation.CMD_UPDATE);
				mapToObject(biAccount,map);
				break;
			default :
				break;

			}
		}
		oc.setAttribute(BiAccountOperation.IN_PARAM, biAccount);
		OPCaller.call(BiAccountOperation.ID, oc);


		return updateReturnBean;
	}

}
