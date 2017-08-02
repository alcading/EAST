package com.huateng.report.imports.service;


import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

import resource.bean.report.BiImportFieldConfig;
import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;

import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;


public class ImportFieldConfigService {
	private static final Logger logger = Logger.getLogger(ImportFieldConfigService.class);

	/**
	 * Default constructor
	 */
	protected ImportFieldConfigService() {
	}

	/**
	 * get instance.
	 *
	 * @return
	 */
	public synchronized static ImportFieldConfigService getInstance() {
		return (ImportFieldConfigService)ApplicationContextUtils.getBean(ImportFieldConfigService.class.getName());
	}

	public void saveDelUpdata(List delList,List insertList,List updateList) throws CommonException{
		ROOTDAO  rootDAO = ROOTDAOUtils.getROOTDAO();

		//新增
		for(Iterator it = insertList.iterator();it.hasNext();)
		{
			BiImportFieldConfig newwrd = (BiImportFieldConfig) it.next();
			if(newwrd.getBatchNo() == null) {
				newwrd.setBatchNo(0);
			}
			rootDAO.save(newwrd);
		}
		//修改
		for(Iterator it = updateList.iterator();it.hasNext();)
		{
			BiImportFieldConfig newwrd = (BiImportFieldConfig) it.next();
			rootDAO.update(newwrd);
		}
		//删除
		for(Iterator it = delList.iterator();it.hasNext();)
		{
			BiImportFieldConfig newwrd = (BiImportFieldConfig) it.next();
			rootDAO.delete(newwrd);
		}
	}
}
