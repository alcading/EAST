/**
 *
 */
package com.huateng.ebank.business.common.generator;

import java.util.Map;

import com.huateng.commquery.cfieldmodel.BaseGenerator;
import com.huateng.ebank.business.common.SystemConstant;
import com.huateng.ebank.business.common.service.CommonService;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.DataFormat;

/**
 * Title: GetCreditNoGenerator
 * Description: 生成申请编号
 * Copyright: Copyright (c) 2008
 * Company: Shanghai Huateng Software Systems Co., Ltd.
 * @author yang jenny
 */
public class GetCreditNoGenerator extends BaseGenerator {

	/* (non-Javadoc)
	 * @see com.huateng.commquery.cfieldmodel.BaseGenerator#gen(java.util.Map)
	 */
	@Override
	public String gen(Object paramMap) throws CommonException{
		String preIndex= (String)((Map)paramMap).get("preIndex");
		String busiType = (String)((Map)paramMap).get("busiType");

		preIndex += DataFormat.initString('0', 12-preIndex.length());
		String valueIndex = preIndex+ busiType;
		return valueIndex + DataFormat.intToString(CommonService.getInstance().getSeqno(SystemConstant.VALUE_NO_CREDITNO, valueIndex), 6);
	}
}
