package com.huateng.ebank.business.common.cqGetter;

import java.util.List;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.exception.AppException;

public class BctlAllSelectGetter extends BaseGetter {


	public Result call() throws AppException {
		try {
			OperationContext oc = new OperationContext();
//			CustomerQueryCondition qc = new CustomerQueryCondition();
//			BeanUtils.populate(qc, getCommQueryServletRequest()
//					.getParameterMap());

	        List list = null ;

			list = BctlService.getInstance().getAllEnableBctl();
			//------------------------------------------------------------
	        ResultMng.fillResultByList(getCommonQueryBean(),
					getCommQueryServletRequest(), list,
					getResult());
	        result.setContent(list);
			result.getPage().setTotalPage(1);
			result.init();
			return result;
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}

}
