package com.huateng.report.basis.updater;




import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import resource.bean.report.BiMonthexchangerate;

import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;
import com.huateng.report.basis.operation.BiMonthExchangeRateOperation;

/**
* @author huangcheng
*
*/
public class BiMonthExchangeRateUpdate extends BaseUpdate {
	
	private static final String DATASET_ID="BiMonthExchangeRate";
	@Override
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean arg0,
			HttpServletRequest arg1, HttpServletResponse arg2)
			throws AppException {
		// TODO Auto-generated method stub
		
		//返回对象
		UpdateReturnBean updateReturnBean = new UpdateReturnBean();

		//返回结果对象
		UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID(DATASET_ID);

		
		//返回日牌价对象
		BiMonthexchangerate biMonthexchangerate = new BiMonthexchangerate();
		
		OperationContext oc = new OperationContext();
		if(updateResultBean.hasNext()) {
			//属性拷贝
			Map map = updateResultBean.next();			
			BaseUpdate.mapToObject(biMonthexchangerate, map);
			if(UpdateResultBean.MODIFY==updateResultBean.getRecodeState()) {
				oc.setAttribute(BiMonthExchangeRateOperation.CMD, BiMonthExchangeRateOperation.CMD_MOD);
			}
			if(UpdateResultBean.INSERT==updateResultBean.getRecodeState()) {
				oc.setAttribute(BiMonthExchangeRateOperation.CMD, BiMonthExchangeRateOperation.CMD_ADD);
			}
			oc.setAttribute(BiMonthExchangeRateOperation.IN_PARAM, biMonthexchangerate);
			//call方式开启operation事务
			OPCaller.call(BiMonthExchangeRateOperation.ID, oc);
			return updateReturnBean;
		}
	
	return null;}
	
}

