package com.huateng.report.basis.updater;



import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import resource.bean.report.BiMonthexchangerate;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;
import com.huateng.report.basis.operation.BiMonthExchangeRateOperation;


/*

 * 
 */
public class BiMonthExchangeRateDEL extends BaseUpdate {

	private static final String DATASET_ID = "BiMonthExchangeRate";
	@Override
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean multiUpdateResultBean,
			HttpServletRequest request, HttpServletResponse response)
			throws AppException {
		try {
			//返回对象
			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			//结果集对象
			UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID(DATASET_ID);
			//更新对象
			BiMonthexchangerate biMonthexchangerate = new BiMonthexchangerate();
			//Operation参数
			OperationContext context = new OperationContext();
			if(updateResultBean.hasNext()) {
				//属性拷贝
				Map map = updateResultBean.next();
				context.setAttribute(BiMonthExchangeRateOperation.CMD,BiMonthExchangeRateOperation.CMD_DEL);
				BaseUpdate.mapToObject(biMonthexchangerate, map);
				//call方式开启operation事务
				context.setAttribute(BiMonthExchangeRateOperation.IN_PARAM, biMonthexchangerate);
				OPCaller.call(BiMonthExchangeRateOperation.ID, context);
				return updateReturnBean;
			}
		} catch (AppException appe) {
			throw appe;
		} catch (Exception e) {
			throw new AppException(Module.SYSTEM_MODULE,Rescode.DEFAULT_RESCODE,e.getMessage(),e);
		}
		return null;
	}
	
}

