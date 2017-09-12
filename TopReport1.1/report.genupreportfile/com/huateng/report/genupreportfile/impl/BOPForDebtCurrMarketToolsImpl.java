package com.huateng.report.genupreportfile.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import resource.bean.report.BopCfaCreditorDs;
import resource.bean.report.BopCfaExdebtDs;
import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;

import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.report.constants.TopReportConstants;
import com.huateng.report.system.common.IGetSubFileList;

public class BOPForDebtCurrMarketToolsImpl implements IGetSubFileList {

	public List getSubFileResultList(Map<String, Object> paramMap)
			throws CommonException {
		// TODO Auto-generated method stub

		String fileDate = (String) paramMap.get(IN_FILE_DATE);
		String appType = (String) paramMap.get(IN_APP_TYPE);
		String fileType = (String) paramMap.get(IN_FILE_TYPE);


		ROOTDAO rootDao = ROOTDAOUtils.getROOTDAO();
		//BopCfaLounexguDs bopCfaLounexguDs = new BopCfaLounexguDs();

		StringBuffer querySql = new StringBuffer();

		querySql.append(" from BopCfaExdebtDs model ");
		querySql.append(" where model.recStatus='" + TopReportConstants.REPORT_RECSTATUS_05 + "'");// 审核已确认
		if (fileDate!=null && fileDate.trim().length()>0) {
			querySql.append(" and model.workDate='" + fileDate + "'");
		}
		querySql.append(" and model.apptype ='"+appType+"'");
		querySql.append(" and model.currentfile ='"+fileType+"'");


		List<BopCfaExdebtDs> bopList = new ArrayList<BopCfaExdebtDs>();

		for(Iterator<BopCfaExdebtDs> it=rootDao.queryByQL(querySql.toString()); it.hasNext();){
			BopCfaExdebtDs bopCfaExdebtDs = it.next();
			String  recId = bopCfaExdebtDs.getId();

			StringBuffer hqlString = new StringBuffer();
			hqlString.append(" from BopCfaCreditorDs model  where 1=1");
			hqlString.append(" and model.recId ='"+recId+"'");

			List<BopCfaCreditorDs> bopCfaCreditorDsList = rootDao.queryByQL2List(hqlString.toString());
			if(bopCfaCreditorDsList.size()>0){
				BopCfaCreditorDs bopCfaCreditorDs = bopCfaCreditorDsList.get(0);
				bopCfaExdebtDs.setCreditorcode(bopCfaCreditorDs.getCreditorcode());
				bopCfaExdebtDs.setCreditorname(bopCfaCreditorDs.getCreditorname());
				bopCfaExdebtDs.setCreditornamen(bopCfaCreditorDs.getCreditornamen());
				bopCfaExdebtDs.setCreditorca(bopCfaCreditorDs.getCreditorca());
				bopCfaExdebtDs.setCreditortype(bopCfaCreditorDs.getCreditortype());
				bopCfaExdebtDs.setCrehqcode(bopCfaCreditorDs.getCrehqcode());
				bopCfaExdebtDs.setOpercode(bopCfaCreditorDs.getOpercode());
				bopCfaExdebtDs.setCrtTm(bopCfaCreditorDs.getCrtTm());
				bopCfaExdebtDs.setId(bopCfaCreditorDs.getRecId());
			}
			bopList.add(bopCfaExdebtDs);
		}


		return bopList;
	}
}

