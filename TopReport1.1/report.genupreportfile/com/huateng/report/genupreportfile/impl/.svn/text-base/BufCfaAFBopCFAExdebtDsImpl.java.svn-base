package com.huateng.report.genupreportfile.impl;

import java.util.List;
import java.util.Map;

import resource.bean.report.BopCfaCreditorDs;
import resource.bean.report.BopCfaExdebtDs;
import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;

import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.report.constants.TopReportConstants;
import com.huateng.report.system.common.IGetSubFileList;

public class BufCfaAFBopCFAExdebtDsImpl implements IGetSubFileList {

	public List getSubFileResultList(Map<String, Object> paramMap)
			throws CommonException {
		// TODO Auto-generated method stub
		 
		BopCfaExdebtDs bopCfaExdebtDs = new BopCfaExdebtDs();
		String fileDate = (String) paramMap.get(IN_FILE_DATE);
		String appType = (String) paramMap.get(IN_APP_TYPE);
		String fileType = (String) paramMap.get(IN_FILE_TYPE);

		String hql = "from BopCfaExdebtDs model";
		hql += " where model.recStatus='"
				+ TopReportConstants.REPORT_RECSTATUS_05 + "'";// 审核已确认
		if (fileDate!=null && fileDate.trim().length()>0) {
			hql += " and model.workDate='" + fileDate + "'";
		}
		hql += " and model.apptype='" + appType + "'";
		hql += " and model.currentfile='" + fileType + "'";

		ROOTDAO dao = ROOTDAOUtils.getROOTDAO();

		List<BopCfaExdebtDs> ob = dao.queryByQL2List(hql);
		for (int i = 0; i < ob.size(); i++) {
			String torHql = "from BopCfaCreditorDs model where model.recId = '"
					+ ob.get(i).getId() + "'";
			BopCfaCreditorDs bopCfaCreditorDs = (BopCfaCreditorDs) dao
					.queryByQL2List(torHql).get(0);

			ob.get(i).setCreditorcode(bopCfaCreditorDs.getCreditorcode());
			ob.get(i).setCreditorname(bopCfaCreditorDs.getCreditorname());
			ob.get(i).setCreditornamen(bopCfaCreditorDs.getCreditornamen());
			ob.get(i).setCreditortype(bopCfaCreditorDs.getCreditortype());
			ob.get(i).setCrehqcode(bopCfaCreditorDs.getCrehqcode());
			ob.get(i).setOpercode(bopCfaCreditorDs.getOpercode());

		}

		return ob;
	}

}
