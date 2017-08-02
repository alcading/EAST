/**
 *
 */
package com.huateng.ebank.business.common.generator;

import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.huateng.commquery.cfieldmodel.BaseGenerator;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.SystemConstant;
import com.huateng.ebank.business.common.service.BctlService;
import com.huateng.ebank.business.common.service.CommonService;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.DataFormat;

/**
 * Title: GetAppnoGenertor
 * Description: 生成申请编号
 * Copyright: Copyright (c) 2008
 * Company: Shanghai Huateng Software Systems Co., Ltd.
 * @author shen_antonio
 * @version 1.1, 2008-4-13
 */
public class GetAppnoGenerator extends BaseGenerator {

	/* (non-Javadoc)
	 * @see com.huateng.commquery.cfieldmodel.BaseGenerator#gen(java.util.Map)
	 */
	@Override
	public String gen(Object paramMap) throws CommonException{

		String custNo = (String)((Map)paramMap).get("custNo");

		/*
		int iCustNo = Integer.parseInt(custNo);
		String custNo20 = DataFormat.intToString(iCustNo, 20);
		.*/
		String custNo20 = StringUtils.rightPad(custNo, 20, '0');
		//顺序号
		int iSeqNo = CommonService.getInstance().getSeqno(SystemConstant.VALUE_NO_APPNO, custNo20);
		String seqNo10 = DataFormat.intToString(iSeqNo, 10);

		return custNo20+seqNo10;
	}

	/* (non-Javadoc)
	 * @see com.huateng.commquery.cfieldmodel.BaseGenerator#gen(java.util.Map)
	 */
	public String genBuyApptypeBrcode(Map<String,Object> paramMap) throws CommonException{
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
					+ DataFormat.getYear(GlobalInfo.getCurrentInstance().getTxdate());
		return valueIndex + DataFormat.intToString(CommonService.getInstance().getSeqno(SystemConstant.VALUE_NO_APPNO, valueIndex), 8);
	}
}
