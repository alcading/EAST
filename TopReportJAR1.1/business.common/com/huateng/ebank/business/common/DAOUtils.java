package com.huateng.ebank.business.common;

import com.huateng.ebank.entity.dao.mng.TBLCSFileExportTskDAO;
import com.huateng.ebank.entity.dao.mng.TblBizLogDAO;
import com.huateng.ebank.framework.util.ApplicationContextUtils;

public class DAOUtils extends BaseDAOUtils {
	/** 查询结果 - 批量下载  */
	public static TBLCSFileExportTskDAO getExportTskDAO() {
		return (TBLCSFileExportTskDAO) ApplicationContextUtils.getBean(TBLCSFileExportTskDAO.SPRING_BEAN_ANME);
	}
	
	/** 日志 */
	public static TblBizLogDAO getTblBizLogDAO() {
		return (TblBizLogDAO) ApplicationContextUtils.getBean("TblBizLogDAO");
	}
}
