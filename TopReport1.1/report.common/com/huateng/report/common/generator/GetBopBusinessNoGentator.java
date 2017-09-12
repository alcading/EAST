package com.huateng.report.common.generator;

import java.util.Map;

import com.huateng.commquery.cfieldmodel.BaseGenerator;
import com.huateng.ebank.business.common.service.CommonService;
import com.huateng.ebank.framework.report.common.ReportConstant;
import com.huateng.ebank.framework.util.DataFormat;
import com.huateng.exception.AppException;
import com.huateng.report.system.common.IGenBopBusinessNo;
/**
 * 产生BOP外债编号
 * @author NING-PENG
 *
 */
public class GetBopBusinessNoGentator extends BaseGenerator {



	@Override
	public String gen(Object arg0) throws AppException {
		Map<String, String> parMap = (Map<String, String>) arg0;
		String parValue = parMap.get(IGenBopBusinessNo.PARAM_VALUE);
		String busiType = parMap.get(IGenBopBusinessNo.BUSI_TYPE).trim();
		String appType = parMap.get(IGenBopBusinessNo.APP_TYPE).trim();
		String workDate = parMap.get(IGenBopBusinessNo.WORK_DATE).replaceAll("-", "").trim();
		String busiNo = parMap.get(IGenBopBusinessNo.BUSINSESS_NO).trim();
		int startIndex = busiNo.indexOf(parValue);
		if (startIndex<0) {
			return busiNo;
		}
		String defaultBusiNo = busiNo.substring(0,startIndex);
		String tmpBusiNo = busiNo.substring(0,startIndex-8);
		if (ReportConstant.BUSINESS_NO_DATE_CURRENT) {//对编号中日期进行替换,采用新日期
			String dt = busiNo.substring(startIndex-8,startIndex);
			if (!dt.equals(workDate)) {
				defaultBusiNo= tmpBusiNo+workDate;
			}
		}
		String valueIndex = appType+defaultBusiNo;

		StringBuffer result = new StringBuffer();
		result.append(defaultBusiNo);
		int seq = CommonService.getInstance().getSeqno(busiType, valueIndex);
		result.append(DataFormat.intToString(seq, busiNo.length()-startIndex));
		return result.toString();
	}

}
