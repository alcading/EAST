package com.huateng.report.genupreportfile.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import resource.bean.report.BopAccDs;
import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;

import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.report.constants.TopReportConstants;
import com.huateng.report.system.common.IGetSubFileList;

public class BufAccCbBopAccDsImpl implements IGetSubFileList  {

	public List getSubFileResultList(Map<String, Object> paramMap)
			throws CommonException {
		ROOTDAO dao = ROOTDAOUtils.getROOTDAO();
		StringBuffer hqlBuff = new StringBuffer();
		List<BopAccDs> list = new ArrayList<BopAccDs>();

		String fileDate = (String) paramMap.get(IGetSubFileList.IN_FILE_DATE);
		String appType = (String) paramMap.get(IGetSubFileList.IN_APP_TYPE);
		String fileType = (String) paramMap.get(IGetSubFileList.IN_FILE_TYPE);

		hqlBuff.append(" from BopAccDs model ").append(" where model.apptype = '"+appType).append("'")
		.append(" and model.currentfile = '"+fileType+"'");
		if (fileDate!=null && fileDate.trim().length()>0) {
			hqlBuff.append(" and model.workDate = '"+fileDate+"'");
		}
		hqlBuff.append(" and model.recStatus = '"+TopReportConstants.REPORT_RECSTATUS_05+"'");

		List<BopAccDs> listDs = dao.queryByQL2List(hqlBuff.toString());

		for(BopAccDs bopDsTemp : listDs)
		{

			bopDsTemp.setBranch_code(bopDsTemp.getBranchCode());
			bopDsTemp.setCurrency_code(bopDsTemp.getCurrencyCode());
			bopDsTemp.setDeal_date(bopDsTemp.getDealDate());

			list.add(bopDsTemp);

		}

		return list;
	}

}
