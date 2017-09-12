/**
 *
 */
package com.huateng.ebank.business.common.generator;

import java.util.Map;

import com.huateng.commquery.cfieldmodel.BaseGenerator;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.SystemConstant;
import com.huateng.ebank.business.common.service.CommonService;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.DataFormat;

/**
 * Title: GetArchiveIDGenerator Description: 档案要素编号生成器 Copyright: Copyright (c)
 * 2008 Company: Shanghai Huateng Software Systems Co., Ltd.
 *
 * @author shen_antonio
 * @version 1.1, 2008-4-13
 */
public class GetAcontnoGenerator extends BaseGenerator {

	/**
	 * 生成档案要素编号
	 *
	 * @return
	 * @throws CommonException
	 */
	public String gen(Object obj) throws CommonException {
		String year =  DataFormat.getYear(GlobalInfo.getCurrentInstance()
				.getTxdate());
		Map paramMap = (Map) obj;
		String contTypeSmall = (String) paramMap.get("contTypeSmall");
		//contTypeSmall=contTypeSmall.length()>4?contTypeSmall.substring(1,5):contTypeSmall;
		String valueIndex = SystemConstant.CONTRACT_NO_BRNO
				+ contTypeSmall
				+ year;
		return valueIndex
				+ DataFormat.intToString(CommonService.getInstance().getSeqno(
						SystemConstant.VALUE_NO_LOANCENTER, "LA"+year), 8);
//		// TODO Auto-generated method stub
//		Map paramMap = (Map) obj;
//		String brno = (String) paramMap.get("brno");
//		String acontType = (String) paramMap.get("acontType");
//		String valueIndex = brno
//				+ acontType
//				+ DataFormat.getYear(GlobalInfo.getCurrentInstance()
//						.getTxdate());
//		return valueIndex
//				+ DataFormat.intToString(CommonService.getInstance().getSeqno(
//						SystemConstant.VALUE_NO_LOANCENTER, "AN082008"), 8);
	}

}
