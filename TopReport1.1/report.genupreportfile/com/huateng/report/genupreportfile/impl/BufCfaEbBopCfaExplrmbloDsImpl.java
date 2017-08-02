package com.huateng.report.genupreportfile.impl;

import java.util.List;
import java.util.Map;

import resource.bean.report.BopCfaExplbalainfo;
import resource.bean.report.BopCfaExplrmbloDs;
import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;

import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.report.constants.TopReportConstants;
import com.huateng.report.system.common.IGetSubFileList;

public class BufCfaEbBopCfaExplrmbloDsImpl implements IGetSubFileList {

	public List getSubFileResultList(Map<String, Object> paramMap)
			throws CommonException {
		ROOTDAO dao = ROOTDAOUtils.getROOTDAO();
		StringBuffer hqlBuff1 = new StringBuffer();
		String fileDate = (String) paramMap.get(IGetSubFileList.IN_FILE_DATE);
		String appType = (String) paramMap.get(IGetSubFileList.IN_APP_TYPE);
		String fileType = (String) paramMap.get(IGetSubFileList.IN_FILE_TYPE);
		hqlBuff1.append(" from BopCfaExplrmbloDs model ").append(" where model.apptype = '"+appType).append("'")
		.append(" and model.currentfile = '"+fileType+"'");
		if (fileDate!=null && fileDate.trim().length()>0) {
			hqlBuff1.append(" and model.workDate = '"+fileDate+"'");
		}
		hqlBuff1.append(" and model.recStatus = '"+TopReportConstants.REPORT_RECSTATUS_05+"'");
		List<BopCfaExplrmbloDs> BopCfaExplrmbloDsList = dao.queryByQL2List(hqlBuff1.toString());

		if(BopCfaExplrmbloDsList != null) {
			for(BopCfaExplrmbloDs bopCfaExplrmbloDs : BopCfaExplrmbloDsList) {
				StringBuffer hqlBuff2 = new StringBuffer();
				hqlBuff2.append("from BopCfaExplbalainfo model where 1 = 1 ");
				hqlBuff2.append("and model.recId = '" + bopCfaExplrmbloDs.getId() + "'");
				List<BopCfaExplbalainfo> bopCfaExplbalainfoList = dao.queryByQL2List(hqlBuff2.toString());
				if(bopCfaExplbalainfoList != null) {
					for(BopCfaExplbalainfo bopCfaExplbalainfo : bopCfaExplbalainfoList) {
						bopCfaExplbalainfo.setExplbala(bopCfaExplbalainfo.getExplamount());
					}
				}
				bopCfaExplrmbloDs.setExplbalainfos(bopCfaExplbalainfoList);
			}
		}
		return BopCfaExplrmbloDsList;
	}

}
