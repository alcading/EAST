package com.huateng.report.genupreportfile.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import resource.bean.report.BopCfaCreditorDs;
import resource.bean.report.BopCfaExdebtDs;
import resource.bean.report.BopProjectInfo;
import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;

import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.report.constants.TopReportConstants;
import com.huateng.report.system.common.IGetSubFileList;

public class BufCfaAmBopCfaExdebtDsImpl implements IGetSubFileList{

	public List getSubFileResultList(Map<String, Object> paramMap)
			throws CommonException {
		String fileDate = (String) paramMap.get(IN_FILE_DATE);
		String appType = (String) paramMap.get(IN_APP_TYPE);
		String fileType = (String) paramMap.get(IN_FILE_TYPE);
		ROOTDAO rootDao = ROOTDAOUtils.getROOTDAO();
		BopCfaExdebtDs bopDebt = new BopCfaExdebtDs();
		BopProjectInfo bopProject =null;
		BopCfaCreditorDs bopCreditor=null;
		
		StringBuffer querySql = new StringBuffer();
		List listProject=null;
		List listCreditor=null;
		List listResult = new ArrayList();
		List listProjectName = new ArrayList();
		
		querySql.append(" from BopCfaExdebtDs model ");
		querySql.append(" where model.recStatus='" + TopReportConstants.REPORT_RECSTATUS_05 + "'");// 审核已确认
		if (fileDate!=null && fileDate.trim().length()>0) {
			querySql.append(" and model.workDate='" + fileDate + "'");
		}
		querySql.append(" and model.apptype='"+appType+"'");
		querySql.append(" and model.currentfile='"+fileType+"'");
		
		List list = rootDao.queryByQL2List(querySql.toString());
		
		for( Iterator it = list.iterator() ; it.hasNext();)
		{
			bopDebt = (BopCfaExdebtDs) it.next();
			StringBuffer querySqlProject = new StringBuffer();
			querySqlProject.append(" from BopProjectInfo model ");
			querySqlProject.append(" where model.recId='" + bopDebt.getId() + "'");
			
			StringBuffer querySqlCreditor = new StringBuffer();
			querySqlCreditor.append(" from BopCfaCreditorDs model ");
			querySqlCreditor.append(" where model.recId='" + bopDebt.getId() + "'");
			
			listProject = rootDao.queryByQL2List(querySqlProject.toString());
			if(!listProject.isEmpty() && listProject.size()>0)
			{
				for(Iterator itPorject = listProject.iterator() ; itPorject.hasNext();)
				{
					bopProject = (BopProjectInfo) itPorject.next();
					listProjectName.add(bopProject.getProjectname());
				}
			}
			bopDebt.setProjects(listProjectName);
			
			listCreditor = rootDao.queryByQL2List(querySqlCreditor.toString());
			
			if(!listCreditor.isEmpty() && listCreditor.size()>0)
			{
				for(Iterator itCreditor = listCreditor.iterator() ; itCreditor.hasNext();)
				{
					bopCreditor =  (BopCfaCreditorDs) itCreditor.next();
					bopDebt.setCreditorcode(bopCreditor.getCreditorcode());
					bopDebt.setCreditortype(bopCreditor.getCreditortype());
					bopDebt.setCreditorname(bopCreditor.getCreditorname());
					bopDebt.setCreditornamen(bopCreditor.getCreditornamen());
					bopDebt.setCreditorca(bopCreditor.getCreditorca());
					bopDebt.setCrehqcode(bopCreditor.getCrehqcode());
					bopDebt.setOpercode(bopCreditor.getOpercode());
				}
			}
			
			listResult.add(bopDebt);
		}

		return listResult;
	}
	
}
