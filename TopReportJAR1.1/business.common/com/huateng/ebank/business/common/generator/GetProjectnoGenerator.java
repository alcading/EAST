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
 * Title: GetProjectnoGenerator Description: 合作项目编号生成器 Copyright: Copyright (c)
 * 2008 Company: Shanghai Huateng Software Systems Co., Ltd.
 *
 * @author shen_antonio
 * @version 1.1, 2008-4-13
 */
public class GetProjectnoGenerator extends BaseGenerator {

	/*
	 * (non-Javadoc)
	 *
	 * @see com.huateng.commquery.cfieldmodel.BaseGenerator#gen(java.util.Map)
	 */

	public String gen(Object paramMap) throws CommonException {
		// TODO Auto-generated method stub
		String brcode = (String) ((Map)paramMap).get("brcode");
		//机构号
		String extBrno = BctlService.getInstance().getExtBrno(brcode);
		/*String valueIndex = brcode
				+ DataFormat.getYear(GlobalInfo.getCurrentInstance()
						.getTxdate());*/
//		return valueIndex
//				+ DataFormat.intToString(CommonService.getInstance().getSeqno(
//						SystemConstant.VALUE_NO_PROJECTNO, valueIndex), 4);
		/*DataFormat df = new DataFormat();
		String txdate = df.getYear(GlobalInfo.getCurrentInstance().getTxdate());*/
		//2位年份
		String txdate=DataFormat.getYear(GlobalInfo.getCurrentInstance().getTxdate()).substring(2, 4);
        /**   4位机构号+2位年份+4位顺序号  **/
		return extBrno + txdate + DataFormat.intToString(CommonService.getInstance().getSeqno(SystemConstant.VALUE_NO_CUSTCD, "0"), 4);
	}

}
