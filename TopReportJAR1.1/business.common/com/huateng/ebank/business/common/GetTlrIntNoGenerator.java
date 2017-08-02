/**
 *
 */
package com.huateng.ebank.business.common;

import java.util.Map;

import com.huateng.ebank.business.common.service.CommonService;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.DataFormat;

/*
* ===================================================================
* The Huateng Software License, Version 1.1
*
* Copyright (c) 2004-2009 Huateng Software System. All rights reserved.
* ===================================================================
* <p>@Title: 内部柜员号生成器，按顺序编号8位长度，从10000000开始</p>
* <p>@Created time: 2008-6-6- 下午12:08:19</p>
* <p>@Company:上海华腾软件系统有限公司</p>
* <p>@description:</p>
* <p>@Auther: farly.yu</p>
* <p>@Version: 1.0 </p>
*/
public class GetTlrIntNoGenerator{

	/* (non-Javadoc)
	 * @see com.huateng.commquery.cfieldmodel.BaseGenerator#gen(java.util.Map)
	 */
	public String gen(Map<String,Object> paramMap) throws CommonException{
		return DataFormat.intToString(CommonService.getInstance().getSeqno(
						SystemConstant.VALUE_NO_TLRINTNO,SystemConstant.VALUE_INDEX), 8);
	}
}
