package com.huateng.report.imports.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import resource.bean.report.BiImportLog;
import resource.bean.report.SubFileInfo;
import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;

import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.report.constants.TopReportConstants;
import com.huateng.report.imports.bean.ReportFeedBackBean;
import com.huateng.report.imports.common.Constants;
import com.huateng.report.utils.ReportEnum;
import com.huateng.report.utils.ReportUtils;

public class FileImportService {
	public synchronized static FileImportService getInstance() {
		return (FileImportService) ApplicationContextUtils
				.getBean(FileImportService.class.getName());
	}

	// /**
	// * 是否正在导入
	// *
	// * @return
	// * @throws CommonException
	// */
	// public boolean isImporting() throws CommonException {
	// String impStatus = CommonService.getInstance().getSysParamDef(
	// Constants.IMPORT, Constants.IS_IMPORTING, Constants.YES);
	// return Constants.YES.equalsIgnoreCase(impStatus);
	// }

	/**
	 * 导入路径
	 *
	 * @return
	 * @throws CommonException
	 */
	public String getDefaultImportPath() throws CommonException {
		String path = ReportUtils.getSysParamsValue(Constants.IMPORT,
				Constants.DEFAULT_PATH, "D:");
		if(path.endsWith("/") || path.endsWith("\\")) {
			path = path.substring(0, path.length() - 1);
		}
		return path;
	}

	// /**
	// * 更新导入状态
	// *
	// * @param impStatus
	// * @throws CommonException
	// */
	// public void updateImportStatus(String impStatus) throws CommonException {
	// PfSysParam sysParam = ROOTDAOUtils.getPfSysParamDAO().query(
	// Constants.IS_IMPORTING, Constants.IMPORT);
	// sysParam.setParamValueTx(impStatus);
	// ROOTDAOUtils.getROOTDAO().update(sysParam);
	// }

	/**
	 * 获取文件的导入状态:成功/失败/未导入
	 *
	 * @param fileName
	 * @param tableName
	 * @param workDate
	 * @return
	 * @throws CommonException
	 */
	public String getImportLogStatus(String fileName, String tableName,
			String workDate) throws CommonException {
		List list = ROOTDAOUtils.getROOTDAO().queryByQL2List(
				"from BiImportLog where fileName ='" + fileName
						+ "' and tableName='" + tableName + "' and workDate='"
						+ workDate + "' order by beginTime desc");
		if (list.isEmpty()) {
			return Constants.IMPORT_STATUS_PROCESS;
		} else {
			BiImportLog log = (BiImportLog) list.get(0);
			return log.getImportStatus();
		}
	}

	public void deleteOldRecords(String tableName, String workDate)
			throws CommonException {
		if (isTableExist(tableName)) {
			executeUpdate("delete from " + tableName + " where WORK_DATE = '"
					+ workDate + "'");
		} else {
			ExceptionUtil.throwCommonException("EIMP006",
					new Object[] { tableName });
		}
	}

	/**
	 * 行配置
	 *
	 * @param fileUUID
	 * @return
	 * @throws CommonException
	 */
	public List getFieldConfig(String fileUUID) throws CommonException {
		List list = ROOTDAOUtils.getROOTDAO().queryByQL2List(
				"from BiImportFieldConfig where importFileId ='" + fileUUID
						+ "'");

		return list;
	}

	/**
	 * XML配置
	 *
	 * @param fileUUID
	 * @return
	 * @throws CommonException
	 */
	public List getXmlConfig(String fileUUID) throws CommonException {
		List list = ROOTDAOUtils.getROOTDAO().queryByQL2List(
				"from BiImportXmlConfig where guid ='" + fileUUID
						+ "' order by nodeOrder");

		return list;
	}

	/**
	 * @param tableName
	 * @return
	 * @throws CommonException
	 */
	//modified by jianxue.zhang -2012.10.30
	public List getColumnMeta(String tableName) throws CommonException {
//		List list = executeQuery(" select tabname ,length  from SysColumns s where  s.id=Object_Id('"
//				+ tableName.toUpperCase() + "')");
		List list = new ArrayList();
//		List tabList = executeQuery("select tabid from  systables where tabname='"
//				+ tableName + "'");
//		if(tabList!=null){
//			String tabid = String.valueOf(tabList.get(0));
//			list = executeQuery(" select colname ,collength  from syscolumns where  tabid='" + tabid + "'");
//		}
		List tabList = executeQuery("select COLUMN_NAME, DATA_LENGTH from  cols where TABLE_NAME='"
				+ tableName + "'");
		return list;
	}

	/**
	 * 系统中是否存在该表
	 *
	 * @param tableName
	 * @return
	 */
	//modified by jianxue.zhang -2012.10.30
	public boolean isTableExist(String tableName) {
//		List list = executeQuery("select count(*) from  SysObjects Where XType='U' and  NAME='"
//				+ tableName + "'");
//		List list = executeQuery("select count(*) from  systables where tabname='"
//				+ tableName + "'");
		List list = executeQuery("select count(*) from  user_tables where TABLE_NAME='"
				+ tableName + "'");
		if (list.isEmpty()) {
			return false;
		} else {
			Number num = (Number) list.get(0);
			return num.intValue() > 0;
		}
	}

	/**
	 * SQL方式更新
	 *
	 * @param sql
	 * @return
	 */
	public int executeUpdate(final String sql) {
		return (Integer) ROOTDAOUtils.getROOTDAO().getHibernateTemplate()
				.execute(new HibernateCallback() {
					public Integer doInHibernate(Session session)
							throws HibernateException, SQLException {
						return session.createSQLQuery(sql).executeUpdate();
					}
				});
	}

	/**
	 * SQL方式查询
	 *
	 * @param sql
	 * @return
	 */
	public List executeQuery(final String sql) {
		return (List) ROOTDAOUtils.getROOTDAO().getHibernateTemplate()
				.execute(new HibernateCallback() {
					public List doInHibernate(Session session)
							throws HibernateException, SQLException {
						return session.createSQLQuery(sql).list();
					}
				});
	}

	public Integer selectCount(String sql) {
		List list = new ArrayList();
		try {
			list = executeQuery(sql);
		} catch (Exception e) {
			return null;
		}
		if (list.size() == 1) {
			Number n = (Number) list.get(0);
			if (n == null) {
				return 0;
			} else {
				return n.intValue();
			}
		}
		return 0;

	}

	public int updateOne(String sql) {
		try {
			return executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	public int getMaxSeqNoFromLog(String fileUUID, String workDate)
			throws CommonException {
		List list = ROOTDAOUtils.getROOTDAO().queryByQL2List(
				"select max(seqNo) from BiImportLog where fuid='" + fileUUID
						+ "' and workDate='" + workDate + "'");
		if (list.isEmpty()) {
			return 0;
		} else {
			Number n = (Number) list.get(0);
			if (n == null) {
				return 0;
			} else {
				return n.intValue();
			}
		}
	}

	public List  getFeedbackImportByPack(String qworkDate,String qbusiType, String qappType,String isSub) throws CommonException{
		ROOTDAO dao = ROOTDAOUtils.getROOTDAO();
		List retList = new ArrayList();
		StringBuffer sb = new StringBuffer(" from SubFileInfo sf where sf.currentfile='"+TopReportConstants.REPORT_FILE_TYPE_ACC_TT+"'");
		if(StringUtils.isNotBlank(qworkDate)){
			sb.append(" and  sf.workdate = '"+qworkDate+"'");
		}
		if (StringUtils.isNotBlank(qbusiType)) {
			sb.append(" and  sf.busiType = '"+qbusiType+"'");
		}
		if (StringUtils.isNotBlank(qappType)) {
			sb.append(" and  sf.apptype = '"+qappType+"'");
		}
		if (isSub!=null && isSub.length()>0) {
			sb.append(" and sf.isSub='"+isSub+"'");
		}
		sb.append(" order by sf.crtTm desc");
		String counthql = "select count(model) from SubFileInfo model where model.filePack=";
		List list = dao.queryByQL2List(sb.toString());

		for (int i = 0; i < list.size(); i++) {
			SubFileInfo info = (SubFileInfo) list.get(i);
			ReportFeedBackBean bean = new ReportFeedBackBean();
			bean.setBusiType(info.getBusiType());
			bean.setAppType(info.getApptype());
			bean.setPackName(info.getFilePack());
			bean.setIsHashFeedBack(info.getIsImpRep());// 是否已导入回执
			bean.setFeedBackDate(info.getSubTm());
			int count = dao.queryByHqlToCount(counthql+"'"+info.getFilePack()+"'");
			bean.setFileCount(count);// 上报文件数
			bean.setIsSub(info.getIsSub());
			bean.setCrtDate(info.getCrtTm());
			bean.setSubType(info.getSubType());
			retList.add(bean);
		}
		return retList;
	}

	/**
	 * 查询导入是否全部成功
	 * @param workDate
	 * @return
	 * @throws CommonException
	 */
	public String queryImportIsSuccessByWorkDate(String workDate) throws CommonException{
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		//判断是否导入
		int count  = rootdao.queryByHqlToCount("select count(model) from BiImportLog model where model.workDate='"+workDate+"'");
		if (count==0) {
			return ReportEnum.REPORT_IMP_FILE_ERR_TYPE.NO_DATA_ERR.value;//未执行导入
		}
		count = rootdao.queryByHqlToCount("select count(model) from BiImportLog model where model.workDate='"+workDate+"' and model.errorRows>0 and model.modFlg is null or model.modFlg!='2'");
		if (count>0) {
			return ReportEnum.REPORT_IMP_FILE_ERR_TYPE.IMP_ERR.value;//存在导入错误信息
		}
		return ReportEnum.REPORT_IMP_FILE_ERR_TYPE.NO_ERR.value;//已导入且全部成功
	}

}
