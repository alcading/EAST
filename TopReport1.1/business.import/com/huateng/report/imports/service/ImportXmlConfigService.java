package com.huateng.report.imports.service;


import java.util.Iterator;
import java.util.List;
import org.apache.log4j.Logger;
import resource.bean.report.BiImportXmlConfig;
import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;


public class ImportXmlConfigService {
	private static final Logger logger = Logger.getLogger(ImportXmlConfigService.class);

	/**
	 * Default constructor
	 */
	protected ImportXmlConfigService() {
	}

	/**
	 * get instance.
	 *
	 * @return
	 */
	public synchronized static ImportXmlConfigService getInstance() {
		return (ImportXmlConfigService)ApplicationContextUtils.getBean(ImportXmlConfigService.class.getName());
	}

	public void saveDelUpdata(List delList,List insertList,List updateList) throws CommonException{
		ROOTDAO  rootDAO = ROOTDAOUtils.getROOTDAO();

		//新增
		for(Iterator it = insertList.iterator();it.hasNext();)
		{
			BiImportXmlConfig newwrd = (BiImportXmlConfig) it.next();
			rootDAO.save(newwrd);
		}
		//修改
		for(Iterator it = updateList.iterator();it.hasNext();)
		{
			BiImportXmlConfig newwrd = (BiImportXmlConfig) it.next();
			rootDAO.update(newwrd);
		}
		//删除
		for(Iterator it = delList.iterator();it.hasNext();)
		{
			BiImportXmlConfig newwrd = (BiImportXmlConfig) it.next();
			rootDAO.delete(newwrd);
		}
	}
}
