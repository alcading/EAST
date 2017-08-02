package com.huateng.report.basis.updater;




import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import resource.bean.report.BiDayexchangerate;

import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;
import com.huateng.report.basis.operation.BiDayExchangeRateOperation;

/**
* @author huangcheng
*
*/
public class BiDayExchangeRateUpdate extends BaseUpdate {
	
	private static final String DATASET_ID="BiDayExchangeRate";
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
		BiDayexchangerate biDayexchangerate = new BiDayexchangerate();
		
		OperationContext oc = new OperationContext();
		if(updateResultBean.hasNext()) {
			//属性拷贝
			Map map = updateResultBean.next();			
			BaseUpdate.mapToObject(biDayexchangerate, map);
			if(UpdateResultBean.MODIFY==updateResultBean.getRecodeState()) {
				oc.setAttribute(BiDayExchangeRateOperation.CMD, BiDayExchangeRateOperation.CMD_MOD);
			}
			if(UpdateResultBean.INSERT==updateResultBean.getRecodeState()) {
				oc.setAttribute(BiDayExchangeRateOperation.CMD, BiDayExchangeRateOperation.CMD_ADD);
			}
			oc.setAttribute(BiDayExchangeRateOperation.IN_PARAM, biDayexchangerate);
			//call方式开启operation事务
			OPCaller.call(BiDayExchangeRateOperation.ID, oc);
			return updateReturnBean;
		}
	
	return null;}
	
}

