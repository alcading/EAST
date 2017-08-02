package com.huateng.report.genupreportfile.impl;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import resource.bean.report.BopCfaExdebtDs;
import resource.bean.report.BopProjectInfo;
import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;

import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.report.system.common.IGetSubFileList;
import com.huateng.report.utils.ReportUtils;

public class BufBOPForDebtOtherLoansImpl implements IGetSubFileList{

	private static final String SEARCH_PROJECTINFO = " FROM BopProjectInfo WHERE recId IN ";
	/**
	 * 分页查询的最大行数
	 */
	private static final int PAGESIZE = 500;

	@SuppressWarnings("unchecked")
	public List getSubFileResultList(Map<String, Object> paramMap)
			throws CommonException {
		BufBOPForDebtOverseaLendingImpl impl = new BufBOPForDebtOverseaLendingImpl();
		List<BopCfaExdebtDs>exdebtdsList = impl.getSubFileResultList(paramMap);

		Map<String, BopCfaExdebtDs>bopcfadexdebtdsMap = new HashMap<String, BopCfaExdebtDs>();
		for (BopCfaExdebtDs bopcfaexdebtds : exdebtdsList) {
			bopcfadexdebtdsMap.put(bopcfaexdebtds.getId(), bopcfaexdebtds);
		}

		List<String>uuidList = new LinkedList<String>();
		for (BopCfaExdebtDs cfa : exdebtdsList) {
			uuidList.add(cfa.getId());
			if(PAGESIZE == uuidList.size()){
				assemblyExdebtDs(uuidList, bopcfadexdebtdsMap);
				uuidList.clear();
			}
		}

		if(!uuidList.isEmpty()){
			assemblyExdebtDs(uuidList, bopcfadexdebtdsMap);
		}

		return exdebtdsList;
	}

	@SuppressWarnings("unchecked")
	private void assemblyExdebtDs(List<String> uuidList,
			Map<String, BopCfaExdebtDs> exdebtdsMap) throws CommonException {
		String hql = SEARCH_PROJECTINFO + ReportUtils.toInString(uuidList);
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		List<BopProjectInfo>list = rootdao.queryByQL2List(hql);
		for(BopProjectInfo projectinfo : list) {
			BopCfaExdebtDs bopcfaexdebtds = exdebtdsMap.get(projectinfo.getRecId());
			if(null != bopcfaexdebtds) {
				bopcfaexdebtds.setProjectname(projectinfo.getProjectname());
			}
		}
	}
}