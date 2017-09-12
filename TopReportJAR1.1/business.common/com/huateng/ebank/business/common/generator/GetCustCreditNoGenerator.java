package com.huateng.ebank.business.common.generator;

import java.util.Map;

import com.huateng.commquery.cfieldmodel.BaseGenerator;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.SystemConstant;
import com.huateng.ebank.business.common.service.CommonService;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.DataFormat;

/**
 * Title: GetCreditnoGenerator Description: 授信合同号生成器 Copyright: Copyright (c)
 * 2008 Company: Shanghai Huateng Software Systems Co., Ltd.
 */
public class GetCustCreditNoGenerator extends BaseGenerator {

	public static final String CREDITNOTYPE_CUST = "1"; // 客户额度类型

	/**
	 * 生成客户额度授信编号 分行本部地区号（3位）+年份（2位）+顺序号（6位）
	 *
	 * @param obj
	 * @return
	 * @throws CommonException
	 */
	public String gen(Object obj) throws CommonException {
		Map paramMap = (Map) obj;
		String brcode = (String) paramMap.get("brcode");// 行号
		String custno = (String) paramMap.get("custno");// 核心客户号
		//String areano = BctlService.getInstance().getRegId(brcode);// 地区号
		String valueIndex = CREDITNOTYPE_CUST + DataFormat.getYear(GlobalInfo.getCurrentInstance()
						.getTxdate());
		int seqno = CommonService.getInstance().getSeqno(
				SystemConstant.VALUE_NO_CREDITNO, valueIndex);
		return CREDITNOTYPE_CUST
				+ DataFormat.getYear(GlobalInfo.getCurrentInstance()
						.getTxdate()).substring(2) + DataFormat.intToString(seqno, 6);
	}


}
