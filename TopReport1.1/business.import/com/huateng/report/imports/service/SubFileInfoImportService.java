package com.huateng.report.imports.service;

import java.util.Iterator;
import java.util.List;
import org.apache.log4j.Logger;
import resource.bean.report.SubFileInfo;
import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;


public class SubFileInfoImportService {
	private static final Logger logger = Logger.getLogger(SubFileInfoImportService.class);

	/**
	 * Default constructor
	 */
	protected SubFileInfoImportService() {
	}

	/**
	 * get instance.
	 *
	 * @return
	 */
	public synchronized static SubFileInfoImportService getInstance() {
		return (SubFileInfoImportService)ApplicationContextUtils.getBean(SubFileInfoImportService.class.getName());
	}

	public void update(List insertList) throws CommonException{
		ROOTDAO  rootDAO = ROOTDAOUtils.getROOTDAO();
		//新增
		for(Iterator it = insertList.iterator();it.hasNext();)
		{
			SubFileInfo s = (SubFileInfo) it.next();
			rootDAO.update(s);
		}		
	}
}
