package com.huateng.ebank.business.common.generator;

import com.huateng.commquery.cfieldmodel.BaseGenerator;
import com.huateng.ebank.business.common.SystemConstant;
import com.huateng.ebank.business.common.service.CommonService;
import com.huateng.ebank.framework.exceptions.CommonException;

/**
 * Title: GetCreditnoGenerator Description: 授信冻结解冻序号生成器 Copyright: Copyright (c)
 * 2008 Company: Shanghai Huateng Software Systems Co., Ltd.
 */
public class GetCreditFrzSeqGenerator extends BaseGenerator {

	/**
	 * 生成客户额度冻结解冻 顺序号（10位）
	 *
	 * @param obj
	 * @return
	 * @throws CommonException
	 */
	public String gen(Object obj) throws CommonException {
		return String.valueOf(CommonService.getInstance().getSeqno(
				SystemConstant.VALUE_NO_FRZNO, SystemConstant.VALUE_INDEX));
	}

}
