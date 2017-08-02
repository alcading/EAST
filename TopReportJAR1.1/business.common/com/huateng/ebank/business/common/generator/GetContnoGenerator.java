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
 * Title: GetContractnoGenerator Description: 合同号生成器 Copyright: Copyright (c)
 * 2008 Company: Shanghai Huateng Software Systems Co., Ltd.
 *
 * @author shen_antonio
 * @version 1.1, 2008-4-13
 */
public class GetContnoGenerator extends BaseGenerator {

	/*
	 * (non-Javadoc)
	 *
	 * @see com.huateng.commquery.cfieldmodel.BaseGenerator#gen(java.util.Map)
	 */
	public String gen(Object obj) throws CommonException {
		// TODO Auto-generated method stub
		// 取外部机构号
		Map paramMap = (Map) obj;
		String brno = (String) paramMap.get("brno");
		String contType = (String) paramMap.get("contType");
		String valueIndex = "S"
				+ brno
				+ contType
				+ DataFormat.getYear(GlobalInfo.getCurrentInstance()
						.getTxdate());
		return valueIndex
				+ DataFormat.intToString(CommonService.getInstance().getSeqno(
						SystemConstant.VALUE_NO_LOANCENTER, "CN082008"), 7);
	}

	/**
	 * add 20100813 angelo.tian
	 */
	public String genNew(Object obj) throws CommonException {
		String year = DataFormat.getYear(GlobalInfo.getCurrentInstance()
				.getTxdate());
		String date =  DataFormat.getYear(GlobalInfo.getCurrentInstance()
				.getTxdate())
				+DataFormat.getMonth(GlobalInfo.getCurrentInstance()
						.getTxdate());

		Map paramMap = (Map) obj;
		String contTypeSmall = (String) paramMap.get("contTypeSmall");
 		//contTypeSmall=contTypeSmall.length()>4?contTypeSmall.substring(1,5):contTypeSmall;
		String valueIndex = "P"
				+SystemConstant.CONTRACT_NO_BRNO
				+ contTypeSmall
				+ date;
		return valueIndex
				+ DataFormat.intToString(CommonService.getInstance().getSeqno(
						SystemConstant.VALUE_NO_LOANCENTER, "LM"+year), 4);
	}

}
