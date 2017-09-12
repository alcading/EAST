package com.huateng.report.bop.genupreportfile.impl;

import java.util.List;
import java.util.Map;

import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;

import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.report.constants.TopReportConstants;
import com.huateng.report.system.common.IGetSubFileList;

public class BufBopFDsImpl implements IGetSubFileList{

	public List getSubFileResultList(Map<String, Object> paramMap)
			throws CommonException {
		
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		StringBuffer sb = new StringBuffer();
		
		String fileDate = (String) paramMap.get(IN_FILE_DATE);
		String appType = (String) paramMap.get(IN_APP_TYPE);		
		String fileType = (String) paramMap.get(IN_FILE_TYPE);
		
		sb.append("select model from MtsBopFsDs model where model.apptype='").append(appType).append("'")
			.append(" and model.currentfile='").append(fileType).append("'");
		if(fileDate != null && fileDate.length() > 0){
			sb.append(" and model.workDate='").append(fileDate).append("'");
		}
		sb.append(" and model.recStatus='").append(TopReportConstants.REPORT_RECSTATUS_05).append("'");
		
		return rootdao.queryByQL2List(sb.toString());
	}

}
