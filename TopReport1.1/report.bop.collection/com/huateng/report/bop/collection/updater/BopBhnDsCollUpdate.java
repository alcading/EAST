package com.huateng.report.bop.collection.updater;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import resource.bean.report.MtsBopBhnDs;

import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;
import com.huateng.report.bop.collection.operation.BopBhnDsOperation;

public class BopBhnDsCollUpdate extends BaseUpdate {
	
	private static final String DATASET_ID = "BopBhnDsCollInfo";
	private static final String PREFIX = "BASIC_CMD_";
	
	@Override
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean arg0,
			HttpServletRequest arg1, HttpServletResponse arg2)
			throws AppException {
		// TODO Auto-generated method stub
		//返回对象
		UpdateReturnBean updateReturnBean = new UpdateReturnBean();
		//结果集对象
		UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID(DATASET_ID);
		//更新对象
		MtsBopBhnDs mtsBopBhnDs = new MtsBopBhnDs();
		//Operation参数
		OperationContext context = new OperationContext();
		if(updateResultBean.hasNext()) {
			Map map = updateResultBean.next();
			String op = updateResultBean.getParameter("op");
			BaseUpdate.mapToObject(mtsBopBhnDs, map);
			if(StringUtils.isNotBlank(op))
			context.setAttribute(BopBhnDsOperation.CMD, PREFIX+op.toUpperCase());
			context.setAttribute(BopBhnDsOperation.IN_PARAM, mtsBopBhnDs);
			OPCaller.call(BopBhnDsOperation.ID, context);
		}
		return updateReturnBean;
	}
	
}
