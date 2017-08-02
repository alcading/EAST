package com.huateng.report.bop.genupreportfile.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import resource.bean.report.MtsBopInvcountrycode;
import resource.bean.report.MtsBopOpenAccount;
import resource.bean.report.MtsBopUDs;
import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;

import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.report.constants.TopReportConstants;
import com.huateng.report.system.common.IGetSubFileList;
import com.huateng.report.utils.ReportUtils;

public class BufBopUDsImpl implements IGetSubFileList {

	private static final int PAGE_SIZE = 500;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List getSubFileResultList(Map<String, Object> paramMap)
			throws CommonException {
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		StringBuilder hql = new StringBuilder();

		String fileDate = (String) paramMap.get(IN_FILE_DATE);
		String appType = (String)paramMap.get(IN_APP_TYPE);
		String fileType = (String) paramMap.get(IN_FILE_TYPE);

		hql.append(" FROM MtsBopUDs WHERE apptype = '").append(appType).append("' ").append(" AND currentfile = '").append(fileType).append("' ");
		if(fileDate != null && fileDate.length() > 0){
			hql.append(" AND workDate = '").append(fileDate).append("' ");
		}
		hql.append(" AND recStatus = '").append(TopReportConstants.REPORT_RECSTATUS_05).append("' ");

		List<MtsBopUDs>bopuList = rootdao.queryByQL2List(hql.toString());
		List<String>idList = new ArrayList<String>();
		Map<String, List<String>>countrymap = new HashMap<String, List<String>>();
		Map<String, List<MtsBopOpenAccount>>openaccountmap = new HashMap<String, List<MtsBopOpenAccount>>();
		for (MtsBopUDs bopu : bopuList) {
			idList.add(bopu.getId());
			if (PAGE_SIZE == idList.size()) {
				countrymap.putAll(getInvcountrycodeMap(idList));

				openaccountmap.putAll(getOpenaccountMap(idList));

				idList.clear();
			}
		}
		if (!idList.isEmpty()) {
			countrymap.putAll(getInvcountrycodeMap(idList));

			openaccountmap.putAll(getOpenaccountMap(idList));

			idList.clear();
		}
		List<String>countryList = null;
		List<MtsBopOpenAccount>openaccountList = null;
		for (MtsBopUDs bopu : bopuList) {
			countryList = countrymap.get(bopu.getId());
			if (null != countryList) {
				bopu.setInvcountry(countryList);
			}

			openaccountList = openaccountmap.get(bopu.getId());
			if (null != openaccountList) {
				bopu.setBankinfos(openaccountList);
			}
		}
		return bopuList;
	}

	/**
	 * 查询投资者国别代码
	 * @param idList
	 * @return
	 * @throws CommonException
	 */
	@SuppressWarnings("unchecked")
	private Map<String,List<String>>getInvcountrycodeMap(List<String>idList) throws CommonException{
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		List<MtsBopInvcountrycode>list = rootdao.queryByQL2List(" FROM MtsBopInvcountrycode WHERE recId IN " + ReportUtils.toInString(idList));
		Map<String, List<String>>invcountrycodeMap = new HashMap<String, List<String>>();
		for (MtsBopInvcountrycode invcountrycode : list) {
			if (invcountrycodeMap.containsKey(invcountrycode.getRecId())){
				List<String>countrycodeList = invcountrycodeMap.get(invcountrycode.getRecId());
				countrycodeList.add(invcountrycode.getInvcountrycode());
			} else {
				List<String>countrycodeList = new ArrayList<String>();
				countrycodeList.add(invcountrycode.getInvcountrycode());
				invcountrycodeMap.put(invcountrycode.getRecId(), countrycodeList);
			}
		}
		return invcountrycodeMap;
	}

	/**
	 * 查询开户信息
	 * @param idList
	 * @return
	 * @throws CommonException
	 */
	@SuppressWarnings("unchecked")
	private Map<String, List<MtsBopOpenAccount>>getOpenaccountMap(List<String>idList) throws CommonException{
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		List<MtsBopOpenAccount>list = rootdao.queryByQL2List(" FROM MtsBopOpenAccount WHERE recId IN " + ReportUtils.toInString(idList));
		Map<String, List<MtsBopOpenAccount>>openaccountMap = new HashMap<String, List<MtsBopOpenAccount>>();
		for (MtsBopOpenAccount openaccount : list) {
			if (openaccountMap.containsKey(openaccount.getRecId())){
				List<MtsBopOpenAccount>openaccountList = openaccountMap.get(openaccount.getRecId());
				openaccountList.add(openaccount);
			} else {
				List<MtsBopOpenAccount>openaccountList = new ArrayList<MtsBopOpenAccount>();
				openaccountList.add(openaccount);
				openaccountMap.put(openaccount.getRecId(), openaccountList);
			}
		}
		return openaccountMap;
	}
}