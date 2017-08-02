package com.huateng.report.dataAnaly.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import resource.bean.report.BiAnalyConf;
import resource.bean.report.BiAnalyDetail;
import resource.bean.report.BiAnalyDetailPars;
import resource.bean.report.BiAnalyProcess;

import com.huateng.report.utils.ReportEnum;
import com.huateng.report.utils.ReportUtils;

public class ReportDataAnalyUtil {

	public static final String PARAM_ANALY_ID = "PARAM_ANALY_ID";
	public static final String PARAM_BUSI_TYPE="PARAM_BUSI_TYPE";
	public static final String PARAM_APP_TYPE = "PARAM_APP_TYPE";
	public static final String PARAM_WORK_DATE = "PARAM_WORK_DATE";
	public static final String PARAM_BR_NO = "PARAM_BR_NO";
	public static final String PARAM_TLR_NO = "PARAM_TLR_NO";


	public static Map<String, String> getAnalyParamMap(){
		Map<String, String> map = new HashMap<String, String>();
		map.put(PARAM_ANALY_ID, "分析记录ID");
		map.put(PARAM_BUSI_TYPE, "业务类型");
		map.put(PARAM_APP_TYPE, "应用类型");
		map.put(PARAM_WORK_DATE, "工作日期");
		map.put(PARAM_BR_NO, "机构号");
		map.put(PARAM_TLR_NO, "执行人");
		return map;
	}

	public static String getConfAnalyParamIds(){
		Map<String, String> paramMap = getAnalyParamMap();
		StringBuffer result = new StringBuffer();
		for (Iterator<String> it = paramMap.keySet().iterator(); it.hasNext();) {
			String key =  it.next();
			result.append(key);
			result.append(",");
			result.append(paramMap.get(key));
			result.append(";");
		}
		return result.toString();
	}

	public static BiAnalyDetail analyConfToDetail(BiAnalyProcess process,BiAnalyConf conf,Map<String, String> paramMap){
		BiAnalyDetail det = new BiAnalyDetail();
		String detId = ReportUtils.getUUID();
		det.setId(detId);
		det.setAnalyNo(process.getId());
		det.setConfType(conf.getConfType());
		det.setConfClassPath(conf.getConfClassPath());
		det.setConfIsRet(conf.getConfIsRet());
		//对参数进行转换
		String confstr = conf.getConfParamIds();
		if (confstr!=null && confstr.trim().length()>0) {
			String[] pars = confstr.split(",");
			for (int i = 0; i < pars.length; i++) {
				String par = pars[i];
				if(par!=null && par.trim().length()>0){
					String[] values = par.trim().split("=");
					if(values!=null){
						BiAnalyDetailPars detparBean = new BiAnalyDetailPars();
						detparBean.setId(ReportUtils.getUUID());
						detparBean.setDetId(detId);
						detparBean.setParSeq(Integer.parseInt(values[0]));
						detparBean.setParName(values[1].trim());
						if (paramMap.containsKey(detparBean.getParName())) {
							detparBean.setParValue(paramMap.get(detparBean.getParName()));
						}
						det.getParsList().add(detparBean);
					}
				}
			}
		}
		det.setConfRetClass(conf.getConfRetClass());
		det.setExecSta(ReportEnum.REPORT_ANALY_STAUS.NOEXEC.value);
		det.setExecuteResult(ReportEnum.REPORT_ANALY_RESULT.NOEXEC.value);
		det.setConfSeq(conf.getConfSeq());
		det.setConfId(conf.getId());
		det.setConfDesc(conf.getConfInfo());
		return det;
	}
}
