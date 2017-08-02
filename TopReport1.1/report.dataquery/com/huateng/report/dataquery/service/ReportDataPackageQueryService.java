package com.huateng.report.dataquery.service;

import java.util.List;

import resource.bean.report.AlreadySubInfo;
import resource.bean.report.SubFileInfo;
import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;

import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;

public class ReportDataPackageQueryService {


	public synchronized static ReportDataPackageQueryService getInstance() {
		return (ReportDataPackageQueryService) ApplicationContextUtils.getBean(ReportDataPackageQueryService.class.getName());
	}

	public AlreadySubInfo getAlreadySubInfo(String recid,String busiType,String fileType) throws CommonException{
		ROOTDAO rootDao = ROOTDAOUtils.getROOTDAO();
		List list = rootDao.queryByQL2List(" from AlreadySubInfo model where model.recId='"+recid+"' and model.apptype='"+busiType+"' and model.currentfile='"+fileType+"'");
		if (list.size()==1) {
			return (AlreadySubInfo) list.get(0);
		}
		return null;
	}

	public SubFileInfo getSubFileInfo(String fileName) throws CommonException{
		ROOTDAO rootDao = ROOTDAOUtils.getROOTDAO();
		return rootDao.query(SubFileInfo.class, fileName);
	}

	public List getReportErrDetailList(String busiCode,String repFileName,String busiType,String fileType) throws CommonException{
		ROOTDAO rootDao = ROOTDAOUtils.getROOTDAO();
		StringBuffer hql = new StringBuffer();
		hql.append(" from RepFileErrDet model where model.repFileName='"+repFileName+"' and model.apptype='"+busiType+"' and model.currentfile='"+fileType+"'");
		if (busiCode!=null && busiCode.trim().length()>0) {
			hql.append(" and model.bussno='"+busiCode+"'");
		}
		List list =  rootDao.queryByQL2List(hql.toString());
		return list;
	}


}
