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
public class GetBreedCreditNoGenerator extends BaseGenerator {

	public static final String CREDITNOTYPE_CREDIT = "3"; // 品种额度类型
	public static final String BREED_SMALL_CLASS = "0";// 品种小类默认00

	/**
	 * 生成品种额度授信编号： 产品额度编号（16位）+授信品种大类（1位）+授信品种小类（2位）+使用方式（1位）
	 * 其中：产品额度编号=客户额度编号（11位）+ 授信使用币种（3位）+产品类型（2位）
	 * 其中：客户额度编号=分行本部地区号（3位）+年份（2位）+顺序号（6位）
	 *
	 * @param obj
	 * @return
	 * @throws CommonException
	 */
	public String gen(Object obj) throws CommonException {
		Map paramMap = (Map) obj;
		String breedCreditNo = "";
		String creditType = "000";
		String productCreditNo = (String) paramMap.get("productCreditNo");// 产品额度编号
		String useType = (String) paramMap.get("useType");// 使用方式
		String breedType = (String) paramMap.get("breedType");// 品种类型=产品类型+授信品种大类
		String index = "CB" + DataFormat.getYear(GlobalInfo.getCurrentInstance()
				.getTxdate());
//		if (breedType != null && breedType.length() == 3) {
//			creditType = breedType.substring(2, 3);// 授信品种大类（1位）
//			String breedSmallType = "0";
//			// 获取实际品种大类(misc)
//			CreditTypeDicDAO dao = DAOUtils.getCreditTypeDicDAO();
//			List list = dao
//					.queryByCondition("po.code='"
//							+ (productCreditNo.substring(productCreditNo
//									.length() - 2) + creditType) + "'");
//			if (list != null && list.size() > 0) {
//				breedSmallType = ((CreditTypeDic) list.get(0)).getMisc();
//			}
//			creditType += BREED_SMALL_CLASS + breedSmallType;
//		}
//		if (breedType != null && breedType.length() == 5) {
//			creditType = breedType.substring(2);// 授信品种大类（1位）
//		}
		return productCreditNo.substring(0, 9) + breedType + DataFormat.intToString(CommonService.getInstance().getSeqno(SystemConstant.VALUE_NO_CREDITNO, index), 5);
	}
}
