package com.huateng.report.system.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import resource.bean.report.SubFileConf;

import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.report.common.ReportConstant;
import com.huateng.ebank.framework.util.ExceptionUtil;

public class ExecuteSubFileConf {

	public static List execute(String fileDate,  Object obj, SubFileConf conf,String filePack, String controlFileTypeName) throws CommonException {
		List retList = new ArrayList();
		String classpath = conf.getFileResultPath();
		if (classpath != null && classpath.trim().length() > 0) {
			Map<String, Object> paramMap = new HashMap<String, Object>();
			if (ReportConstant.CREATE_SUB_FILE_IS_WORKDATE) {
				paramMap.put(IGetSubFileList.IN_FILE_DATE, fileDate);
			}else{
				paramMap.put(IGetSubFileList.IN_FILE_DATE, null);
			}
			paramMap.put(IGetSubFileList.IN_PARAM_OTHER, obj);
			paramMap.put(IGetSubFileList.IN_APP_TYPE, conf.getId().getAppType());
			paramMap.put(IGetSubFileList.IN_FILE_TYPE, conf.getId().getFileType());
			paramMap.put(IGetSubFileList.IN_CONTROL_NAME, controlFileTypeName);
			try {
				Class cls = Class.forName(classpath);
				IGetSubFileList getFileList = (IGetSubFileList) cls.newInstance();
				retList = getFileList.getSubFileResultList(paramMap);
			} catch (Exception e) {
				ExceptionUtil.throwCommonException(e.getMessage());
			}
		}
		return retList;
	}
}
