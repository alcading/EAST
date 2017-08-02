/**
 *
 */
package com.huateng.ebank.business.common.generator;

import java.util.Map;

import com.huateng.ebank.framework.exceptions.CommonException;

/**
 * Title: GetAccumFundActno2Generator
 * Description: 公积金帐号生成器(特殊处理140101,140102)
 * Copyright: Copyright (c) 2008
 * Company: Shanghai Huateng Software Systems Co., Ltd.
 * @author shen_antonio
 * @version 1.1, 2008-4-13
 */
public class GetAccumFundActno2Generator extends GetAccumFundActnoGenerator {


	/**
	 * 生成公积金帐号(特殊处理140101,140102)
	 *
	 * @param brcode  申请机构
	 * @param term    贷款期限
	 * @param lnid    贷款小类
	 * @return
	 * @throws CommonException
	 */

	public String gen(Map paramMap) throws CommonException{
		// 需要特殊处理的小类变量字串
		String lnid = (String)paramMap.get("lnid");
		String strLnid = "140101,140102";
		if (lnid != null && !lnid.trim().equals("")
				&& strLnid.indexOf(lnid) < 0) {
			String strAfa = super.gen(paramMap);
			strAfa = strAfa.substring(0, strAfa.length() - 9) + "8"
					+ strAfa.substring(strAfa.length() - 8, strAfa.length());
			return strAfa;

		} else {
			return super.gen(paramMap);
		}
	}

}
