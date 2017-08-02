/**
 *
 */
package com.huateng.ebank.business.common.generator;

import java.util.Map;

import com.huateng.commquery.cfieldmodel.BaseGenerator;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.SystemConstant;
import com.huateng.ebank.business.common.service.BctlService;
import com.huateng.ebank.business.common.service.CommonService;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.DataFormat;

/**
 * Title: GetWarningIDGenerator Description: 预警编号生成器 Copyright: Copyright (c)
 * 2008 Company: Shanghai Huateng Software Systems Co., Ltd.
 *
 * @author shen_antonio
 * @version 1.1, 2008-4-13
 */
public class GetWarningIDGenerator extends BaseGenerator {

	/**
	 * 生成预警编号
	 *
	 * @param brcode
	 *            预警机构
	 * @return
	 * @throws CommonException
	 */

	public String gen(Object paramMap) throws CommonException {
		String brcode = (String) ((Map)paramMap).get("brcode");
		String extBrno = BctlService.getInstance().getExtBrno(brcode);
		String valueIndex = brcode
				+ DataFormat.dateToNumber(GlobalInfo.getCurrentInstance()
						.getTxdate());
		return valueIndex
				+ DataFormat.intToString(CommonService.getInstance().getSeqno(
						SystemConstant.VALUE_NO_WARNING_ID, valueIndex), 4);
	}

}
