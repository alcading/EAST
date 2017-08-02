/**
 *
 */
package com.huateng.ebank.business.common.generator;

import java.util.Map;

import com.huateng.commquery.cfieldmodel.BaseGenerator;
import com.huateng.ebank.business.common.SystemConstant;
import com.huateng.ebank.business.common.service.BctlService;
import com.huateng.ebank.business.common.service.CommonService;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.DataFormat;

/**
 * Title: GetHousenoGenerator
 * Description: 楼盘编号生成器
 * Copyright: Copyright (c) 2008
 * Company: Shanghai Huateng Software Systems Co., Ltd.
 * @author shen_antonio
 * @version 1.1, 2008-4-13
 */
public class GetHousenoGenerator extends BaseGenerator {

	/* (non-Javadoc)
	 * @see com.huateng.commquery.cfieldmodel.BaseGenerator#gen(java.util.Map)
	 */

	public String gen(Object paramMap) throws CommonException{
		// TODO Auto-generated method stub
		String brcode = (String)((Map)paramMap).get("brcode");
		BctlService bctlService = BctlService.getInstance();
		String valueIndex = bctlService.getBranchBrcode(brcode);
		if (DataFormat.isEmpty(valueIndex))
			valueIndex = brcode;
		return valueIndex
				+ DataFormat.intToString(CommonService.getInstance().getSeqno(
						SystemConstant.VALUE_NO_HOUSENO, valueIndex), 8);
	}

}
