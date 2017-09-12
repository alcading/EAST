package com.huateng.ebank.business.common.generator;

import com.huateng.commquery.cfieldmodel.BaseGenerator;
import com.huateng.ebank.business.common.SystemConstant;
import com.huateng.ebank.business.common.service.CommonService;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.DataFormat;

public class GetCustomerInfractIdGenerator extends BaseGenerator {

	public String gen(Object obj) throws CommonException {
		return DataFormat.intToString(CommonService.getInstance().getSeqno(SystemConstant.CUST_INFRACT_NO, "ciri072008"),0);
	}

}
