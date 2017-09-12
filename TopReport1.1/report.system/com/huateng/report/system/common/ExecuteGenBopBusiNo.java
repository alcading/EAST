package com.huateng.report.system.common;

import java.util.HashMap;
import java.util.Map;

import resource.bean.report.BiBusiNoConf;

import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.report.common.service.ReportCommonService;

public class ExecuteGenBopBusiNo {

	public static void execute(String workDate, String busiType, String appType, String fileType, String paramValue,Object obj) throws CommonException {

		ReportCommonService commservice = ReportCommonService.getInstance();
		BiBusiNoConf conf = commservice.getBiBusiNoConfByPk(busiType, appType, fileType);
		if (conf != null && conf.getConfpath() != null && conf.getConfpath().trim().length() > 0) {
			String confPath = conf.getConfpath().trim();
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put(IGenBopBusinessNo.APP_TYPE, appType);
			paramMap.put(IGenBopBusinessNo.BUSI_TYPE, busiType);
			paramMap.put(IGenBopBusinessNo.PARAM_VALUE, paramValue);
			paramMap.put(IGenBopBusinessNo.WORK_DATE, workDate);
			paramMap.put(IGenBopBusinessNo.OBJECT_BEAN, obj);
			paramMap.put(IGenBopBusinessNo.FILE_TYPE, fileType);
			try {
				Class cls = Class.forName(confPath);
				IGenBopBusinessNo genBop = (IGenBopBusinessNo) cls.newInstance();
				genBop.updateBopBusiNo(paramMap);
			} catch (Exception e) {
				ExceptionUtil.throwCommonException(e.getMessage());
			}
		}
	}
}
