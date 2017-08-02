package com.huateng.report.imports.service;


import java.util.Iterator;
import java.util.List;
import org.apache.log4j.Logger;

import resource.bean.report.BiImportFieldConfig;
import resource.bean.report.BiImportFileConfig;
import resource.bean.report.BiImportXmlConfig;
import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;


public class ImportConfigService {
	private static final Logger logger = Logger.getLogger(ImportConfigService.class);

	/**
	 * Default constructor
	 */
	protected ImportConfigService() {
	}

	/**
	 * get instance.
	 *
	 * @return
	 */
	public synchronized static ImportConfigService getInstance() {
		return (ImportConfigService)ApplicationContextUtils.getBean(ImportConfigService.class.getName());
	}

	public void saveDelUpdata(List delList,List insertList,List updateList) throws CommonException{
		ROOTDAO  rootDAO = ROOTDAOUtils.getROOTDAO();

		//新增
		for(Iterator it = insertList.iterator();it.hasNext();)
		{
			BiImportFileConfig newwrd = (BiImportFileConfig) it.next();
			if(newwrd.getBatchNo() == null) {
				newwrd.setBatchNo(0);
			}
			if(newwrd.getSeqNo() == null) {
				newwrd.setSeqNo(0);
			}
			rootDAO.save(newwrd);
		}
		//修改
		for(Iterator it = updateList.iterator();it.hasNext();)
		{
			BiImportFileConfig newwrd = (BiImportFileConfig) it.next();
			rootDAO.update(newwrd);
		}
		//删除
		for(Iterator it = delList.iterator();it.hasNext();)
		{
			BiImportFileConfig newwrd = (BiImportFileConfig) it.next();
			String importidFileid=newwrd.getId();
//			List delimportList=rootDAO.queryByCondition("importFileId='"+importidFileid+"'", "BiImportFieldConfig");
			List delimportList=rootDAO.queryByCondition("from BiImportFieldConfig b where b.importFileId = '"+importidFileid+"'");
			List delxmlList=rootDAO.queryByCondition("from BiImportXmlConfig b where b.guid ='"+importidFileid+"'");
			for(int i=0;i<delimportList.size();i++){
				BiImportFieldConfig delimport=(BiImportFieldConfig)delimportList.get(i);
				rootDAO.delete(delimport);
			}	
			for(int i=0;i<delxmlList.size();i++){
				BiImportXmlConfig delxml=(BiImportXmlConfig)delxmlList.get(i);
				rootDAO.delete(delxml);
			}	
			rootDAO.delete(newwrd);
		}
	}
}
