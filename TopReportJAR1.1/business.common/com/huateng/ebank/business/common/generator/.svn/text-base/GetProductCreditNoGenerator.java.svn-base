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
public class GetProductCreditNoGenerator extends BaseGenerator {

	public static final String CREDITNOTYPE_CREDIT = "2"; // 产品额度类型

	/**
	 * 生成产品额度授信编号:客户额度编号（11位）+ 授信使用币种（3位）+产品类型（2位）
	 * 其中：客户额度编号=分行本部地区号（3位）+年份（2位）+顺序号（6位）
	 * @param obj
	 * @return
	 * @throws CommonException
	 */
	public String gen(Object obj) throws CommonException {
		Map paramMap = (Map) obj;
		String custCreditNo = (String) paramMap.get("custCreditNo");//客户额度编号
		//String curcd = (String) paramMap.get("curcd");// 使用币种
		String productType = (String) paramMap.get("productType");// 产品类型
		String index = "CP" + DataFormat.getYear(GlobalInfo.getCurrentInstance()
				.getTxdate());
		return custCreditNo	 + productType + DataFormat.intToString(CommonService.getInstance().getSeqno(SystemConstant.VALUE_NO_CREDITNO, index), 5);
	}
}
