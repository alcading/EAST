/**
 *
 */
package com.huateng.ebank.business.common.generator;

import com.huateng.commquery.cfieldmodel.BaseGenerator;
import com.huateng.ebank.business.common.SystemConstant;
import com.huateng.ebank.business.common.service.CommonService;
import com.huateng.ebank.framework.exceptions.CommonException;

/**
 * Title: GetMortImpawnIDGenerator
 * Description: 抵押、质押序号生成器
 * Copyright: Copyright (c) 2008
 * Company: Shanghai Huateng Software Systems Co., Ltd.
 * @author shen_antonio
 * @version 1.1, 2008-4-13
 */
public class GetInsurerNoticeNoGenerator extends BaseGenerator {

	/* (non-Javadoc)
	 * @see com.huateng.commquery.cfieldmodel.BaseGenerator#gen(java.util.Map)
	 */
	public String gen(Object obj) throws CommonException {
		// TODO Auto-generated method stub
		return String.valueOf(CommonService.getInstance().getSeqno(SystemConstant.VALUE_NO_NOTICENO, SystemConstant.CREDIT_NOTICE_VALUE_INDEX));
	}

}
