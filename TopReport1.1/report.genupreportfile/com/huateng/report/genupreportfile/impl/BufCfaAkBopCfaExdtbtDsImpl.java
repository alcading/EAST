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

public class BufCfaAkBopCfaExdtbtDsImpl implements IGetSubFileList {

	public List getSubFileResultList(Map<String, Object> paramMap)
			throws CommonException {
		ROOTDAO dao = ROOTDAOUtils.getROOTDAO();
		StringBuffer hqlBuff1 = new StringBuffer();
		String fileDate = (String) paramMap.get(IGetSubFileList.IN_FILE_DATE);
		String appType = (String) paramMap.get(IGetSubFileList.IN_APP_TYPE);
		String fileType = (String) paramMap.get(IGetSubFileList.IN_FILE_TYPE);
		hqlBuff1.append(" from BopCfaExdebtDs model ").append(" where model.apptype = '"+appType).append("'")
		.append(" and model.currentfile = '"+fileType+"'");
		if (fileDate!=null && fileDate.trim().length()>0) {
			hqlBuff1.append(" and model.workDate = '"+fileDate+"'");
		}
		hqlBuff1.append(" and model.recStatus = '"+TopReportConstants.REPORT_RECSTATUS_05+"'");
		List<BopCfaExdebtDs> bopCfaExdebtDsList = dao.queryByQL2List(hqlBuff1.toString());
		
		if(bopCfaExdebtDsList != null) {
			for(BopCfaExdebtDs bopCfaExdebtDs : bopCfaExdebtDsList) {
				StringBuffer hqlBuff2 = new StringBuffer();
				hqlBuff2.append("from BopCfaCreditorDs where 1 = 1");
				hqlBuff2.append("and recId = '" + bopCfaExdebtDs.getId() + "'");
				List<BopCfaCreditorDs> bopCfaCreditorDsDsList = dao.queryByQL2List(hqlBuff2.toString());
				BopCfaCreditorDs bopCfaCreditorDs = bopCfaCreditorDsDsList.get(0);
				bopCfaExdebtDs.setCreditorcode(bopCfaCreditorDs.getCreditorcode());
				bopCfaExdebtDs.setCreditorname(bopCfaCreditorDs.getCreditorname());
				bopCfaExdebtDs.setCreditornamen(bopCfaCreditorDs.getCreditornamen());
				bopCfaExdebtDs.setCreditorca(bopCfaCreditorDs.getCreditorca());
				bopCfaExdebtDs.setCreditortype(bopCfaCreditorDs.getCreditortype());
				bopCfaExdebtDs.setCrehqcode(bopCfaCreditorDs.getCrehqcode());
				bopCfaExdebtDs.setOpercode(bopCfaCreditorDs.getOpercode());
				bopCfaExdebtDs.setCrtTm(bopCfaCreditorDs.getCrtTm());
			}
		}
		return bopCfaExdebtDsList;
	}

}
