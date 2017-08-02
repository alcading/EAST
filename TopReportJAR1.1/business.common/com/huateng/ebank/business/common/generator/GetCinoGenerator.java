/**
 *
 */
package com.huateng.ebank.business.common.generator;

import java.util.Map;

import com.huateng.commquery.cfieldmodel.BaseGenerator;
import com.huateng.ebank.business.common.ErrorCode;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.DataFormat;
import com.huateng.ebank.framework.util.ExceptionUtil;

/**
 * Title: GetCinoGenerator
 * Description: 借据号生成器
 * Copyright: Copyright (c) 2008
 * Company: Shanghai Huateng Software Systems Co., Ltd.
 * @author shen_antonio
 * @version 1.1, 2008-4-13
 */
public class GetCinoGenerator extends BaseGenerator {


	/**
	 * 生成借据号
	 *
	 * @param contractno
	 * @param seqno
	 * @return
	 * @throws CommonException
	 */
	public String gen(Object paramMap) throws CommonException{
		// TODO Auto-generated method stub
		String contractno = (String)((Map)paramMap).get("contractno");
		int seqno = ((Integer)((Map)paramMap).get("seqno")).intValue();
		if (seqno > 99) {
			ExceptionUtil.throwCommonException("同一笔合同下借据数不能超过99笔",
					ErrorCode.ERROR_CODE_GEN_CINO_ERROR);
		}
		return contractno + DataFormat.intToString(seqno, 4);
	}

}
