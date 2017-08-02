/**
 *
 */
package com.huateng.ebank.business.common.generator;

import com.huateng.commquery.cfieldmodel.BaseGenerator;
import com.huateng.ebank.business.common.SystemConstant;
import com.huateng.ebank.business.common.service.CommonService;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.DataFormat;

/**
 * Title: GetBrcodeIDGenerator
 * Description: 机构编号生成器
 * Copyright: Copyright (c) 2008
 * Company: Shanghai Huateng Software Systems Co., Ltd.
 * @author shen_antonio
 * @version 1.1, 2008-4-13
 */
public class GetBrcodeIDGenerator extends BaseGenerator{


	/**
	 * 生成机构编号
	 * @return
	 * @throws CommonException
	 */
	public String gen(Object obj) throws CommonException{
		return DataFormat.intToString(CommonService.getInstance().getSeqno(SystemConstant.VALUE_NO_BRCODE,SystemConstant.VALUE_INDEX), 4);
	}

}
