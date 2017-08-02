package com.huateng.report.common.generator;

import java.util.Map;

import com.huateng.common.log.HtLog;
import com.huateng.common.log.HtLogFactory;
import com.huateng.commquery.cfieldmodel.BaseGenerator;
import com.huateng.ebank.business.common.service.CommonService;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.report.common.ReportConstant;
import com.huateng.ebank.framework.util.DataFormat;
import com.huateng.ebank.framework.util.DateUtil;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.exception.AppException;
import com.huateng.report.common.bean.ReportBopAndJshRetNoBean;
import com.huateng.report.system.common.IGenBopBusinessNo;
import com.huateng.report.utils.ReportBopJshRetNoUtil;
import com.huateng.report.utils.ReportEnum;

/**
 * 产生BOP/JSH申报号码
 *
 * @author NING-PENG
 *
 */
public class GetBOPJSHRptNoGentator extends BaseGenerator {
	private static final HtLog htlog = HtLogFactory.getLogger(GetBOPJSHRptNoGentator.class);

	@SuppressWarnings("unchecked")
	@Override
	public String gen(Object arg0) throws AppException {
		Map<String, String> parMap = (Map<String, String>) arg0;
		String parValue = parMap.get(IGenBopBusinessNo.PARAM_VALUE);
		String busiType = parMap.get(IGenBopBusinessNo.BUSI_TYPE).trim();
		String appType = parMap.get(IGenBopBusinessNo.APP_TYPE).trim();
		String workDate = parMap.get(IGenBopBusinessNo.WORK_DATE).replaceAll("-", "").trim();
		String retNo = parMap.get(IGenBopBusinessNo.BUSINSESS_NO).trim();
		String fileType = parMap.get(IGenBopBusinessNo.FILE_TYPE).trim();
		String cusType = parMap.get(IGenBopBusinessNo.CUS_TYPE);
		int startIndex = retNo.indexOf(parValue);
		if (startIndex < 0) {
			return retNo;
		}

		String defaultRetNo = retNo.substring(0, startIndex);// 12位机构号+6位日期
		String tmpRetNo = retNo.substring(0, startIndex - 6);
		if (ReportConstant.BUSINESS_NO_DATE_CURRENT) {// 对编号中日期进行替换,采用新日期
			String dt = retNo.substring(startIndex - 6, startIndex);
			String covdt = DateUtil.convterDateFmt(workDate);
			if (!dt.equals(covdt)) {
				defaultRetNo = tmpRetNo + covdt;
			}
		}
		StringBuffer valueIndex = new StringBuffer();
		valueIndex.append(appType);
		valueIndex.append(fileType);
		String cusTypeTemp = null;
		Map<String, ReportBopAndJshRetNoBean> confMap = ReportBopJshRetNoUtil.getReportBopJshMap();
		if (confMap == null) {
			htlog.warn("BI_BOPJSH_RET_NO申报号码规则未设置");
		}
		if (cusType != null && cusType.trim().length() > 0) {
			String key = appType+fileType;
			if (confMap != null && confMap.containsKey(key)) {
				ReportBopAndJshRetNoBean bean = confMap.get(key);
				if(bean.isDistCusType()){
					cusTypeTemp = ReportEnum.CUS_TYPE_MAPPING.valueof(cusType.trim());
					valueIndex.append(cusTypeTemp);
				}
			}
		}
		valueIndex.append(defaultRetNo);

		StringBuffer result = new StringBuffer();
		result.append(defaultRetNo);
		int seq = CommonService.getInstance().getSeqno(busiType, valueIndex.toString());
		if (seq == 0) {
			ExceptionUtil.throwCommonException("申报号码生成错误,编号不能小于1，" + valueIndex);
		}
		int len = retNo.length() - startIndex;
		result.append(getConvertNo(appType, fileType, len, seq, cusTypeTemp,confMap));
		return result.toString();
	}

	private String getConvertNo(String appType, String fileType, int len, int seq, String cusTypeTemp,Map<String, ReportBopAndJshRetNoBean> confMap)
			throws CommonException {
		String code = null;
		String key = appType + fileType;
		if (confMap != null && confMap.containsKey(key)) {
			ReportBopAndJshRetNoBean bean = confMap.get(key);
			int maxSeq = bean.getMaxSeq();
			String comb = bean.getRetNoComb();
			if (comb.equals(ReportEnum.COMB_TYPE.NO.value)) {
				if (seq > maxSeq) {
					ExceptionUtil.throwCommonException("当前申报号码" + seq + ",允许最大编号" + maxSeq, key);
				}
				code = DataFormat.intToString(seq, len);
			} else {
				String[] strs = null;
				if (bean.isDistCusType()) {
					Map<String, String[]> map = bean.getCusTypeMap();
					if (map.containsKey(cusTypeTemp)) {
						strs = map.get(cusTypeTemp);
					}
				} else {
					strs = bean.getCusTypes();
				}
				if (strs == null) {
					ExceptionUtil.throwCommonException("申报号码规则设置错误!", key);
				}
				int divNum = seq / maxSeq;// 除数
				int thenNum = seq % maxSeq;// 余数
				int idx = divNum;
				if (thenNum == 0) {
					idx = divNum - 1;
					thenNum = maxSeq;
				}
				if (idx<0 && idx > strs.length - 1) {
					ExceptionUtil.throwCommonException("申报号码错误,超出设置范围("+idx+")!", key);
				}
				String lett = strs[idx].toUpperCase();
				String tmpCode = DataFormat.intToString(thenNum, len - lett.length());
				if (comb.equals(ReportEnum.COMB_TYPE.LEFT.value)) {
					code = lett + tmpCode;
				} else if (comb.equals(ReportEnum.COMB_TYPE.RIGHT.value)) {
					code = tmpCode + lett;
				}
			}

		} else {
			code = DataFormat.intToString(seq, len);
			htlog.warn(key + "申报号码规则未设置,采用左侧补0处理!");
		}
		if (code == null) {
			ExceptionUtil.throwCommonException("申报号码生成错误!", key);
		}
		return code;
	}
}
