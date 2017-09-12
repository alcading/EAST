/**
 *
 */
package com.huateng.ebank.business.common.generator;

import com.huateng.commquery.cfieldmodel.BaseGenerator;
import com.huateng.ebank.business.common.SystemConstant;
import com.huateng.ebank.business.common.service.CommonService;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.DataFormat;

/*
* ===================================================================
* The Huateng Software License, Version 1.1
*
* Copyright (c) 2004-2009 Huateng Software System. All rights reserved.
* ===================================================================
* <p>@Title: 贷款产品代码生成器: 3位贷款大类+3位顺序号</p>
* <p>@Created time: 2008-5-6- 上午11:49:31</p>
* <p>@Company:上海华腾软件系统有限公司</p>
* <p>@description:</p>
* <p>@Auther: farly.yu</p>
* <p>@Version: 1.0 </p>
*/
public class GetLnidGenerator extends BaseGenerator {
	@Override
	public String gen(Object arg0) throws CommonException {
		return arg0.toString() + DataFormat.intToString(CommonService.getInstance().getSeqno(
				SystemConstant.VALUE_NO_LNID,SystemConstant.VALUE_INDEX), 3);
	}

}

