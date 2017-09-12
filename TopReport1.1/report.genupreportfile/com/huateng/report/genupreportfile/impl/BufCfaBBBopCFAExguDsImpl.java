package com.huateng.report.genupreportfile.impl;

import java.util.List;
import java.util.Map;

import resource.bean.report.BopCfaExguDs;
import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;

import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.report.constants.TopReportConstants;
import com.huateng.report.system.common.IGetSubFileList;

public class BufCfaBBBopCFAExguDsImpl implements IGetSubFileList {

	public List getSubFileResultList(Map<String, Object> paramMap)
			throws CommonException {
		// TODO Auto-generated method stub

		BopCfaExguDs bopCfaExguDs = new BopCfaExguDs();
		String fileDate = (String) paramMap.get(IN_FILE_DATE);
		String appType = (String) paramMap.get(IN_APP_TYPE);
		String fileType = (String) paramMap.get(IN_FILE_TYPE);
		String hql = "from BopCfaExguDs model";
		hql += " where model.recStatus='"
				+ TopReportConstants.REPORT_RECSTATUS_05 + "'";// 审核已确认
		if (fileDate!=null && fileDate.trim().length()>0) {
			hql += " and model.workDate='" + fileDate + "'";
		}
		hql += " and model.currentfile='" + fileType + "'";
		hql += " and model.apptype='"+appType+"'";

		ROOTDAO dao = ROOTDAOUtils.getROOTDAO();

		List<BopCfaExguDs> ob = dao.queryByQL2List(hql);

		return ob;
	}

}
