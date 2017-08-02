package com.huateng.report.genupreportfile.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;

import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.report.constants.TopReportConstants;
import com.huateng.report.system.common.IGetSubFileList;

public class BufCfaAsBopCfaExdebtDsImpl implements IGetSubFileList{

	public List getSubFileResultList(Map<String, Object> paramMap)
			throws CommonException {
		String fileDate = (String) paramMap.get(IN_FILE_DATE);
		String appType = (String) paramMap.get(IN_APP_TYPE);
		String fileType = (String) paramMap.get(IN_FILE_TYPE);
		ROOTDAO rootDao = ROOTDAOUtils.getROOTDAO();
		StringBuffer querySql = new StringBuffer();

		List listResult = new ArrayList();

		querySql.append(" from BopCfaExdebtDs model ");
		querySql.append(" where model.recStatus='" + TopReportConstants.REPORT_RECSTATUS_05 + "'");// 审核已确认
		if (fileDate!=null && fileDate.trim().length()>0) {
			querySql.append(" and model.workDate='" + fileDate + "'");
		}
		querySql.append(" and model.apptype='"+appType+"'");
		querySql.append(" and model.currentfile='"+fileType+"'");

	    listResult = rootDao.queryByQL2List(querySql.toString());

		return listResult;
	}

}
