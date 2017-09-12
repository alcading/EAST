/**
 *
 */
package com.huateng.ebank.business.common.generator;

import com.huateng.commquery.cfieldmodel.BaseGenerator;
import com.huateng.ebank.framework.exceptions.CommonException;

/**
 * Title: GetAccumFundActnoGenerator
 * Description: 公积金帐号生成器
 * Copyright: Copyright (c) 2008
 * Company: Shanghai Huateng Software Systems Co., Ltd.
 * @author shen_antonio
 * @version 1.1, 2008-4-13
 */
public class GetAccumFundActnoGenerator extends BaseGenerator {

	/**
	 * 生成公积金帐号
	 *
	 * @param brcode  申请机构
	 * @param term    贷款期限
	 * @return
	 * @throws CommonException
	 */
	@Override
	public String gen(Object paramMap) throws CommonException{
//		String brcode = (String)paramMap.get("brcode");
//		String term = (String)paramMap.get("term");
////		BctlDAO dao = BaseDAOUtils.getBctlDAO();
//		Bctl bctl = dao.query(brcode);
//		if (DataFormat.isEmpty(bctl.getAccumFundBrid())
//				|| DataFormat.isEmpty(bctl.getAccumFundBrcode())) {
//			ExceptionUtil
//					.throwCommonException(ErrorCode.ERROR_CODE_NO_ACCUM_FUND_BRID);
//		}
//		return bctl.getAccumFundBrid()
//				+ bctl.getAccumFundBrcode()
//				+ SystemConstant.ACCUM_FUND_ACNO
//				+ term.substring(0, 2)
//				+ DataFormat.intToString(CommonService.getInstance().getSeqno(SystemConstant.VALUE_NO_ACCUM_FUND_ACTNO, brcode), 9);
		return "";
	}

}
