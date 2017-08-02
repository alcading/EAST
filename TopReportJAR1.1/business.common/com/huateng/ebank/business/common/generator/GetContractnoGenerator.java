/**
 *
 */
package com.huateng.ebank.business.common.generator;

import java.text.SimpleDateFormat;
import java.util.Map;

import com.huateng.commquery.cfieldmodel.BaseGenerator;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.SystemConstant;
import com.huateng.ebank.business.common.service.BctlService;
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
public class GetContractnoGenerator extends BaseGenerator {

	/*
	 * (non-Javadoc)
	 *
	 * @see com.huateng.commquery.cfieldmodel.BaseGenerator#gen(java.util.Map)
	 */

	public String gen(Object paramMap) throws CommonException {
		String brcode = (String) ((Map)paramMap).get("brcode");
		String lnid = (String) ((Map)paramMap).get("lnid");
		// TODO Auto-generated method stub
		// 取外部机构号
		String extBrno = BctlService.getInstance().getExtBrno(brcode);
		String year = DataFormat.getYear(GlobalInfo.getCurrentInstance()
				.getTxdate());
		String valueIndex = brcode + year;
		SimpleDateFormat simpleDateFormat =
			new SimpleDateFormat("yyyyMM");
		String txdate = simpleDateFormat.format(GlobalInfo.getCurrentInstance().getTxdate());
		int seqno = CommonService.getInstance().getSeqno(SystemConstant.VALUE_NO_CONTRACTNO, valueIndex);
		//机构所号4位+年份后两位+05（个贷业务）+贷款品种大类编号3位+4位序号
		return extBrno + year.substring(2,4) + SystemConstant.BUSINESS_LOAN+ lnid + DataFormat.intToString(seqno, 4);
	}

}
