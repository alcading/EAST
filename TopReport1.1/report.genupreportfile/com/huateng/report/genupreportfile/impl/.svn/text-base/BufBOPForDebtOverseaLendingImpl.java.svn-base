package com.huateng.report.genupreportfile.impl;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import resource.bean.report.BopCfaCreditorDs;
import resource.bean.report.BopCfaExdebtDs;
import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;

import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.report.constants.TopReportConstants;
import com.huateng.report.system.common.IGetSubFileList;
import com.huateng.report.utils.ReportUtils;

import edu.emory.mathcs.backport.java.util.Collections;

public class BufBOPForDebtOverseaLendingImpl implements IGetSubFileList {


	private static final String SEARCH_REPORT_DATA_FOR_BOP_CFAEXDEBT_DS = " FROM BopCfaExdebtDs WHERE workDate = ? AND recStatus = ? AND apptype = ? AND currentfile = ? ";

	private static final String SEARCH_REPORT_FOR_REC_STATUS = " FROM BopCfaExdebtDs WHERE recStatus = ? AND apptype = ? AND currentfile = ? ";

	private static final String SEARCH_CREDITOR_INFO =" FROM BopCfaCreditorDs WHERE recId IN ";
	/**
	 * 分页查询的最大行数
	 */
	private static final int PAGESIZE = 500;

	@SuppressWarnings("unchecked")
	public List getSubFileResultList(Map<String, Object> paramMap)
			throws CommonException {

		String workdate = (String) paramMap.get(IN_FILE_DATE);
		String apptype  = (String) paramMap.get(IN_APP_TYPE);
		String filetype = (String) paramMap.get(IN_FILE_TYPE);

		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		List<BopCfaExdebtDs> exdebtdsList = Collections.emptyList();
		if (workdate!=null && workdate.trim().length()>0) {
			Object[] para = new Object[] { workdate,
				TopReportConstants.REPORT_RECSTATUS_05, apptype, filetype };

			exdebtdsList = rootdao.queryByQL2List(
				SEARCH_REPORT_DATA_FOR_BOP_CFAEXDEBT_DS, para, null);
		} else {
			Object[] para = new Object[] {
					TopReportConstants.REPORT_RECSTATUS_05, apptype, filetype };

			exdebtdsList = rootdao.queryByQL2List(
					SEARCH_REPORT_FOR_REC_STATUS, para, null);
		}
		Map<String, BopCfaExdebtDs> exdebtdsMap = new HashMap<String, BopCfaExdebtDs>(exdebtdsList.size());
		for(BopCfaExdebtDs cfa : exdebtdsList) {
			exdebtdsMap.put(cfa.getId(), cfa);
		}

		List<String>uuidList = new LinkedList<String>();
		for(BopCfaExdebtDs cfa : exdebtdsList) {
			uuidList.add(cfa.getId());
			if(PAGESIZE == uuidList.size()){
				assemblyExdebtds(uuidList, exdebtdsMap);
				uuidList.clear();
			}
		}
		if(!uuidList.isEmpty()){
			assemblyExdebtds(uuidList, exdebtdsMap);
			uuidList.clear();
		}

		return exdebtdsList;
	}

	@SuppressWarnings("unchecked")
	private void assemblyExdebtds(List<String> uuidList,
			Map<String, BopCfaExdebtDs> exdebtdsMap) throws CommonException {
		String hql = SEARCH_CREDITOR_INFO + ReportUtils.toInString(uuidList);
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		List<BopCfaCreditorDs>list = rootdao.queryByQL2List(hql);
		for(BopCfaCreditorDs creditor : list) {
			BopCfaExdebtDs bopcfaexdebtds = exdebtdsMap.get(creditor.getRecId());
			if(null != bopcfaexdebtds) {
				bopcfaexdebtds.setCreditorcode(creditor.getCreditorcode());
				bopcfaexdebtds.setCreditorname(creditor.getCreditorname());
				bopcfaexdebtds.setCreditornamen(creditor.getCreditornamen());
				bopcfaexdebtds.setCreditortype(creditor.getCreditortype());
				bopcfaexdebtds.setCrehqcode(creditor.getCrehqcode());
				bopcfaexdebtds.setOpercode(creditor.getOpercode());
			}
		}
	}
}