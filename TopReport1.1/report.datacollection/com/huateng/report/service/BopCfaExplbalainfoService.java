package com.huateng.report.service;

import java.util.Date;
import java.util.List;

import resource.bean.report.BopCfaExplbalainfo;
import resource.bean.report.BopCfaExplrmbloDs;
import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;

import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;
import com.huateng.report.utils.ReportUtils;

public class BopCfaExplbalainfoService {


	/*
	 * 获得自身实例
	 */
	public synchronized static BopCfaExplbalainfoService getInstance() {
		return (BopCfaExplbalainfoService) ApplicationContextUtils
				.getBean(BopCfaExplbalainfoService.class.getName());
	}

	@SuppressWarnings("unchecked")
	public List<BopCfaExplbalainfo> load(String uuid) throws CommonException {
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		List list = rootdao.queryByQL2List(
				" FROM BopCfaExplbalainfo WHERE recId = ? ", new Object[] { uuid },
				null);
		return list;
	}

	public void save(BopCfaExplrmbloDs bopcfa, List<BopCfaExplbalainfo> explbalainfoList) throws CommonException {
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		for(BopCfaExplbalainfo info : explbalainfoList) {
			info.setRecId(bopcfa.getId());
			info.setCrtTm(new Date());
			info.setExplbalainfoId(ReportUtils.getUUID());				
			rootdao.save(info);
		}
	}

	public void update(List<BopCfaExplbalainfo> explbalainfoList) throws CommonException {
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		for(BopCfaExplbalainfo info : explbalainfoList) {			
			rootdao.update(info);
		}
	}

	public void delete(List<BopCfaExplbalainfo> explbalainfoList) throws CommonException {
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		for(BopCfaExplbalainfo info : explbalainfoList) {
			if(null != info.getExplbalainfoId()) {
				rootdao.delete(info);
			}
		}
	}

	public void deleteAll(String uuid) throws CommonException {
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		rootdao.delete(" FROM BopCfaExplbalainfo WHERE recId = '" + uuid + "' ");
	}
}