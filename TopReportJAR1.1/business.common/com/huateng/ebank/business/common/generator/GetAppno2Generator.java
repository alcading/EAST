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
 * Title: GetAppno2Genertor
 * Description:
 * @deprecated
 * Copyright: Copyright (c) 2008
 * Company: Shanghai Huateng Software Systems Co., Ltd.
 * @author shen_antonio
 * @version 1.1, 2008-4-13
 */
public class GetAppno2Generator extends BaseGenerator {


	/**
	 * 生成定制贷款查询申请号
	 *
	 * @param apptype 申请类型
	 * @param brcode  申请机构
	 * @return
	 * @throws CommonException
	 */
	public String gen(Object obj) throws CommonException {
		Map paramMap = (Map)obj;
		String apptype = (String)paramMap.get("apptype");
		String brcode = (String)paramMap.get("brcode");
		BctlService bctlService = BctlService.getInstance();
		String valueIndex;
		if (bctlService.getBrclass(brcode).equals(
				SystemConstant.BRCODE_CLASS_HEAD))
			valueIndex = apptype
					+ brcode
					+ DataFormat.getYear(GlobalInfo.getCurrentInstance()
							.getTxdate());
		else
			valueIndex = apptype
					+ bctlService.getBranchBrcode(brcode)
					+ DataFormat.getYear(GlobalInfo.getCurrentInstance()
							.getTxdate());
		return valueIndex
				+ DataFormat.getMonth(GlobalInfo.getCurrentInstance()
						.getTxdate())
				+ DataFormat
						.getDay(GlobalInfo.getCurrentInstance().getTxdate())
				+ DataFormat.intToString(CommonService.getInstance().getSeqno(SystemConstant.VALUE_NO_APPNO, valueIndex) % 10000, 4);
	}

}
