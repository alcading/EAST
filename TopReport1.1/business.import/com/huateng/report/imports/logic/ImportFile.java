/**
 *
 */
package com.huateng.report.imports.logic;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.connection.ConnectionProvider;
import org.hibernate.engine.SessionFactoryImplementor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.topexpression.ExpressionEvaluator;
import org.topexpression.IllegalExpressionException;
import org.topexpression.datameta.Variable;

import resource.bean.report.BiImportFieldConfig;
import resource.bean.report.BiImportLog;
import resource.bean.report.BiImportLogDtl;
import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;

import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.operation.SingleOPCaller;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.report.imports.common.Constants;
import com.huateng.report.imports.common.ConvertMean;
import com.huateng.report.imports.common.FileImportUtil;
import com.huateng.report.imports.common.ReadWriteFile;
import com.huateng.report.imports.model.Constant;
import com.huateng.report.imports.model.LogInfo;
import com.huateng.report.imports.model.SqlInfo;
import com.huateng.report.imports.model.TFieldSetInfo;
import com.huateng.report.imports.model.TFieldValueInfo;
import com.huateng.report.imports.model.TFileDataInfo;
import com.huateng.report.imports.model.TFilterData;
import com.huateng.report.imports.model.TOutValue;
import com.huateng.report.imports.operation.ImportFileOP;
import com.huateng.report.imports.service.FileImportService;

/**
 * 导入文件
 *
 * @author chl_seu
 *
 */
@SuppressWarnings("unchecked")
public class ImportFile {

	private final static Logger logger = LoggerFactory
			.getLogger(ImportFile.class);

	private TFileDataInfo curImpFileInfo; // 当前导入文件信息

	private Constant constant;

	private LogInfo logInfo = new LogInfo();

	private List<SqlInfo> sqlList = new ArrayList();

	/**
	 * @param constant2
	 * @param logName
	 * @function 导入单个文件
	 * @param lcurImpFileInfo当前导入文件信息
	 * @throws IOException
	 */
	public boolean importFile(TFileDataInfo lcurImpFileInfo, String sPath,
			Constant constant2) throws Exception {
		constant = constant2;
		curImpFileInfo = lcurImpFileInfo;
		constant.id = curImpFileInfo.getGuid();
		int c1 = FileImportService.getInstance().getMaxSeqNoFromLog(
				curImpFileInfo.getGuid(), curImpFileInfo.getTradeDate());
		constant.sericalNo = c1 + 1;
		Map logMap = new HashMap();
		logMap.put("guid", curImpFileInfo.getGuid());
		logMap.put("fileName", curImpFileInfo.getFileName());// 导入文件名称
		logMap.put("tableName", curImpFileInfo.getTableName());
		logMap.put("workDate", lcurImpFileInfo.getTradeDate());
		logMap.put("fileOwner", curImpFileInfo.getFileOwner());
		logMap.put("sericalNo", constant.sericalNo);
		logMap.put("beginTime", curImpFileInfo.getBeginTime());
		logMap.put("batchNo", curImpFileInfo.getBatchNo());
		logMap.put("errorNumber", 0);
		logMap.put("totalRows", 0);
		logMap.put("correctRows", 0);
		logMap.put("filterRows", 0);
		String errorFileName = "";
		String errorFilePath = "";
		if (curImpFileInfo.getErrFlg() == 0) {
			errorFileName = new StringBuffer("[")
					.append(curImpFileInfo.getFileName()).append("-")
					.append(curImpFileInfo.getBatchNo()).append("-")
					.append(constant.sericalNo).append("].txt").toString();
			errorFilePath = new StringBuffer(sPath).append("error")
					.append(File.separator).toString();
		} else {
			String tmpFileName = curImpFileInfo.getFileName();
			tmpFileName = tmpFileName.substring(0,
					tmpFileName.lastIndexOf("-") + 1);
			errorFileName = new StringBuffer(tmpFileName)
					.append(constant.sericalNo).append("].txt").toString();
			errorFilePath = sPath;
		}
		ReadWriteFile readWriteFile = new ReadWriteFile(errorFilePath,
				errorFileName);
		TOutValue osMessage = new TOutValue(); // 系统运行信息
		// 初始化内部变量
		curImpFileInfo = lcurImpFileInfo;
		// 将文件内容读取出来，保存在impFileContentList中
		List impFileContentList = null;
		TOutValue existCount = new TOutValue();

		StringBuffer strLog = new StringBuffer();
		strLog.append("表名").append(curImpFileInfo.getTableName())
				.append(",路径:").append(sPath);
		logger.debug(strLog.toString());
		if (!FileImportService.getInstance().isTableExist(
				curImpFileInfo.getTableName())) {
			logger.debug("数据库中目的表不存在!");
			constant.errorMessage = "数据库中目的表不存在";
			logMap.put("importStatus", ImportFileVar.IMPORT_STATUS_FALSE);
			logMap.put("errorMessage", "数据库中目的表不存在");
			logMap.put("endTime", FileImportUtil.getCurTime());
			saveLog(logMap);
			return false;
		}

		// 初始化文件的各个字段，与数据库中相应表的字段对应
		if (!initFieldSet(curImpFileInfo)) {
			logger.debug("初始化数据字段失败!");
			constant.errorMessage = "初始化数据字段失败！";
			logMap.put("importStatus", ImportFileVar.IMPORT_STATUS_FALSE);
			logMap.put("errorMessage", "初始化数据字段失败");
			logMap.put("endTime", FileImportUtil.getCurTime());
			saveLog(logMap);
			return false;
		}

		// 读取Excel文件
		if (Constants.FILEDATA_FORMATTYPE_EXCEL.equals(curImpFileInfo
				.getFormatType())) {
			ExcelOp excelOp = new ExcelOp();
			if (!excelOp.readFileContent(curImpFileInfo, sPath, sPath
					+ curImpFileInfo.getFileName(), constant)) {
				strLog.delete(0, strLog.length());
				strLog.append("读取Excel文件:")
						.append(curImpFileInfo.getFileName()).append("内容出错");
				logger.debug(strLog.toString());
				constant.errorMessage = strLog.toString();
				logMap.put("importStatus", ImportFileVar.IMPORT_STATUS_FALSE);
				logMap.put("errorMessage", strLog.toString());
				logMap.put("endTime", FileImportUtil.getCurTime());
				saveLog(logMap);
				return false;
			}
			impFileContentList = excelOp.getFileContentList();
			curImpFileInfo.setListSeparator("\\|"); // excel文件默认分隔符
			constant.sumRow = impFileContentList.size();

			// 读取DBF文件
		} else if (Constants.FILEDATA_FORMATTYPE_DBF.equals(curImpFileInfo
				.getFormatType())) {
			DbfOp dbfOp = new DbfOp();
			if (!dbfOp.readFileContent(sPath + curImpFileInfo.getFileName(),
					constant)) {
				strLog.delete(0, strLog.length());
				strLog.append("读取DBF文件:").append(curImpFileInfo.getFileName())
						.append("内容出错");
				constant.errorMessage = strLog.toString();
				logMap.put("importStatus", ImportFileVar.IMPORT_STATUS_FALSE);
				logMap.put("errorMessage", strLog.toString());
				logMap.put("endTime", FileImportUtil.getCurTime());
				saveLog(logMap);
				return false;
			}
			impFileContentList = dbfOp.getFileContentList();
			curImpFileInfo.setListSeparator("\\|"); // DBF文件默认分隔符
			constant.sumRow = impFileContentList.size();

			// 读取XML文件
		} else if (Constants.FILEDATA_FORMATTYPE_XML.equals(curImpFileInfo
				.getFormatType())) {
			XmlOp xmlOp = new XmlOp();
			if (!xmlOp.init(curImpFileInfo, sPath) || !xmlOp.readXml()) {
				strLog.delete(0, strLog.length());
				strLog.append("读取XML文件:").append(curImpFileInfo.getFileName())
						.append("内容出错");
				constant.errorMessage = strLog.toString();
				logMap.put("importStatus", ImportFileVar.IMPORT_STATUS_FALSE);
				logMap.put("errorMessage", strLog.toString());
				logMap.put("endTime", FileImportUtil.getCurTime());
				saveLog(logMap);
				return false;
			}
			impFileContentList = xmlOp.getFileContentList();
			curImpFileInfo.setListSeparator("\\|");
			constant.sumRow = impFileContentList.size();

			// 读取文本文件
		} else {
			try {
				curImpFileInfo.fileContentList = curImpFileInfo
						.readFileContent(curImpFileInfo.getStartRow(), sPath
								+ curImpFileInfo.getFileName(),
								curImpFileInfo.getListSeparator());

				if ("|".equals(curImpFileInfo.getListSeparator())
						|| ",".equals(curImpFileInfo.getListSeparator())) {
					curImpFileInfo.setListSeparator("\\|");
				}
			} catch (Exception e) {
				strLog.delete(0, strLog.length());
				strLog.append("读取文本文件:").append(curImpFileInfo.getFileName())
						.append("内容出错");
				constant.errorMessage = strLog.toString();
				logMap.put("importStatus", ImportFileVar.IMPORT_STATUS_FALSE);
				logMap.put("errorMessage", strLog.toString());
				logMap.put("endTime", FileImportUtil.getCurTime());
				saveLog(logMap);
				return false;
			}
			impFileContentList = curImpFileInfo.getFileContentList();
			constant.sumRow = impFileContentList.size();
		}

		// 开始逐行验证并将正确行导入
		logMap.put("totalRows", constant.sumRow);
		logMap.put("beginTime", curImpFileInfo.getBeginTime());

		int N = 10000;
		for (int i = constant.startRow; i < constant.sumRow; i++) {
			constant.progress = (int) (100 * (float) (i + 1) / (float) constant.sumRow)
					+ "%";
			Map logDtlMap = new HashMap();
			logDtlMap.put("guid", curImpFileInfo.getGuid());
			logDtlMap.put("fileName", curImpFileInfo.getFileName());// 添加文件名称
			logDtlMap.put("workDate", curImpFileInfo.getTradeDate());
			logDtlMap.put("fileOwner", curImpFileInfo.getFileOwner());
			logDtlMap.put("beginTime", curImpFileInfo.getBeginTime());
			logDtlMap.put("sericalNo", constant.sericalNo);
			logDtlMap.put("lineNo", i);
			logDtlMap.put("posNo", "");
			logDtlMap.put("errFileName", "");
			String sLine = (String) impFileContentList.get(i);
			sLine = sLine.replace("\'", "\'\'");
			// 替换全角空格 add by chl_seu@20090318
			sLine = sLine.replaceAll("　", " ");
			// 清除上一条记录相关数据
			clearFieldValueList();
			curImpFileInfo.getFRowValue().clear();
			if (sLine.trim().equals("")) {
				strLog.delete(0, strLog.length());
				strLog.append("行号=[");
				strLog.append(i);
				strLog.append("] 文件名=[");
				strLog.append(curImpFileInfo.getFileName());
				strLog.append("] 表名=[");
				strLog.append(curImpFileInfo.getTableName());
				strLog.append("] 第 ");
				strLog.append(i);
				strLog.append("条记录为空！记录被过滤！");
				logger.debug(strLog.toString());
				constant.filterRow++;
				continue;
			}
			// 定义临时数组变量存储个字段值
			String tmpArr[] = null;
			// TAB键分隔
			if (ImportFileVar.FILEDATA_FORMATTYPE_TAB.equals(curImpFileInfo
					.getSplitType())) {
				tmpArr = sLine.split("\t", -1);// -1
												// 是为了防止行数据后几个项目为空时，用split方法无法取得数据。
				for (int j = 0; j < tmpArr.length; j++) {
					curImpFileInfo.getFRowValue().add(tmpArr[j]);
				}
			}
			// 固定长度分隔
			else if (ImportFileVar.FILEDATA_FORMATTYPE_FIXED
					.equals(curImpFileInfo.getSplitType())) {
				curImpFileInfo.getFRowValue().add(sLine);
			}
			// 指定字符分隔
			else {
				if ("".equals(curImpFileInfo.getListSeparator())) {
					curImpFileInfo.setListSeparator(" ");
				}
				tmpArr = sLine.split(curImpFileInfo.getListSeparator(), -1);// -1
																			// 是为了防止行数据后几个项目为空时，用split方法无法取得数据。
				for (int j = 0; j < tmpArr.length; j++) {
					curImpFileInfo.getFRowValue().add(tmpArr[j]);
				}
			}

			// 判断记录是否过滤
			int liRet = this.CheckFilter(i, existCount, osMessage);
			if (liRet == -1) { // 错误
				strLog.delete(0, strLog.length());
				strLog.append("行号=[").append(i).append("] 过滤:")
						.append(osMessage.outvalue);
				logger.error(strLog.toString());
				logDtlMap.put("endTime", FileImportUtil.getCurTime());
				logDtlMap.put("errFileName", curImpFileInfo.getFileName());
				logDtlMap.put("errorMessage", osMessage.outvalue);
				logDtlMap.put("posNo", osMessage.errorNumber);
				logDtlMap.put("errFileName", errorFileName);
				saveDtlLog(logDtlMap);
				readWriteFile.creatTxtFile();
				readWriteFile.writeTxtFile(sLine);
				constant.errorNumber++;
				constant.errorMessage = osMessage.outvalue;
				continue;
			} else if (liRet == 0) { // 过滤
				strLog.delete(0, strLog.length());
				strLog.append("行号=[").append(i).append("] ")
						.append(osMessage.outvalue);
				logger.debug(strLog.toString());
				constant.filterRow++;
				continue;
			}

			// 判断文件配置中记录存在修改方法是否匹配
			liRet = this.checkKeyFlag(i, osMessage);
			if (liRet == -1) { // 错误
				strLog.delete(0, strLog.length());
				strLog.append("行号=[").append(i).append("] 主键:")
						.append(osMessage.outvalue);
				logger.error(strLog.toString());
				logDtlMap.put("endTime", FileImportUtil.getCurTime());
				logDtlMap.put("errFileName", curImpFileInfo.getFileName());
				logDtlMap.put("errorMessage", osMessage.outvalue);
				logDtlMap.put("posNo", osMessage.errorNumber);
				logDtlMap.put("errFileName", errorFileName);
				saveDtlLog(logDtlMap);
				readWriteFile.creatTxtFile();
				readWriteFile.writeTxtFile(sLine);
				constant.errorNumber++;
				constant.errorMessage = osMessage.outvalue;
				continue;
			} else if (liRet == 0) { // 过滤
				strLog.delete(0, strLog.length());
				strLog.append("行号=[").append(i).append("] ")
						.append(osMessage.outvalue);
				logger.debug(strLog.toString());
				constant.filterRow++;
				continue;
			}

			// 计算入库字段值
			if (!CalcUpdateFieldsValue(i, osMessage)) {
				strLog.delete(0, strLog.length());
				strLog.append("行号=[").append(i).append("] 计算字段值:")
						.append(osMessage.outvalue);
				logger.error(strLog.toString());
				logDtlMap.put("endTime", FileImportUtil.getCurTime());
				logDtlMap.put("errFileName", curImpFileInfo.getFileName());
				logDtlMap.put("errorMessage", osMessage.outvalue);
				logDtlMap.put("posNo", osMessage.errorNumber);
				logDtlMap.put("errFileName", errorFileName);
				saveDtlLog(logDtlMap);
				readWriteFile.creatTxtFile();
				readWriteFile.writeTxtFile(sLine);
				constant.errorNumber++;
				constant.errorMessage = osMessage.outvalue;
				continue;
			}
			// 导入一行数据
			this.importRowData(osMessage, i, logDtlMap, readWriteFile,
					errorFileName, impFileContentList, sLine);



			if(i>0 && i%N==0) {
				// ======================批处理开始====================================================//
				boolean batchFlag = excuteBatchSql();
				Iterator iterator = sqlList.iterator();
				if (batchFlag) {
					String endTime = FileImportUtil.getCurTime();
					while (iterator.hasNext()) {
						SqlInfo sqlInfo = (SqlInfo) iterator.next();
						Map logDtlMap1 = sqlInfo.getLogDtlMap();
						logDtlMap1.put("endTime", endTime);
						// saveDtlLog(logDtlMap);
					}
				} else {
					int tmpNum = 0;
					while (iterator.hasNext()) {
						SqlInfo sqlInfo = (SqlInfo) iterator.next();
						Map logDtlMap2 = sqlInfo.getLogDtlMap();
						int tmpFlg = FileImportService.getInstance().updateOne(
								(String) sqlInfo.getParamMap().get(Constants.STR_SQL));
						if (tmpFlg == 0) {
							strLog.delete(0, strLog.length());
							strLog = new StringBuffer("第" + sqlInfo.getRowNumber()
									+ "行执行入库sql出错");
							logger.error("执行入库sql出错");
							logDtlMap2.put("endTime", FileImportUtil.getCurTime());
							logDtlMap2.put("errFileName", curImpFileInfo.getFileName());
							logDtlMap2.put("errorMessage", "执行入库sql出错");
							logDtlMap2.put("posNo", "" + sqlInfo.getRowNumber());
							logDtlMap2.put("errFileName", errorFileName);
							saveDtlLog(logDtlMap2);
							readWriteFile.creatTxtFile();
							readWriteFile.writeTxtFile((String) impFileContentList
									.get(tmpNum));
							constant.errorNumber++;
						} else if (tmpFlg == -1) {
							strLog.delete(0, strLog.length());
							strLog = new StringBuffer("第" + sqlInfo.getRowNumber()
									+ "行执行入库sql出错");
							logger.error("执行入库sql出错");
							logDtlMap2.put("endTime", FileImportUtil.getCurTime());
							logDtlMap2.put("errFileName", curImpFileInfo.getFileName());
							logDtlMap2.put("errorMessage", "执行入库sql出错");
							logDtlMap2.put("posNo", "" + sqlInfo.getRowNumber());
							logDtlMap2.put("errFileName", errorFileName);
							saveDtlLog(logDtlMap2);
							readWriteFile.creatTxtFile();
							readWriteFile.writeTxtFile((String) impFileContentList
									.get(tmpNum));
							constant.errorNumber++;
						} else {
							logDtlMap2.put("endTime", FileImportUtil.getCurTime());
							// saveDtlLog(logDtlMap);
							constant.rightRow++;
						}
						tmpNum++;
					}
				}
				// ==========================批处理结束======================================================//
				sqlList.clear();
			}
		}
		if (sqlList.size()>0) {
			// ======================批处理开始====================================================//
			boolean batchFlag = excuteBatchSql();
			Iterator iterator = sqlList.iterator();
			if (batchFlag) {
				String endTime = FileImportUtil.getCurTime();
				while (iterator.hasNext()) {
					SqlInfo sqlInfo = (SqlInfo) iterator.next();
					Map logDtlMap1 = sqlInfo.getLogDtlMap();
					logDtlMap1.put("endTime", endTime);
					// saveDtlLog(logDtlMap);
				}
			} else {
				int tmpNum = 0;
				while (iterator.hasNext()) {
					SqlInfo sqlInfo = (SqlInfo) iterator.next();
					Map logDtlMap2 = sqlInfo.getLogDtlMap();
					int tmpFlg = FileImportService.getInstance().updateOne(
							(String) sqlInfo.getParamMap().get(Constants.STR_SQL));
					if (tmpFlg == 0) {
						strLog.delete(0, strLog.length());
						strLog = new StringBuffer("第" + sqlInfo.getRowNumber()
								+ "行执行入库sql出错");
						logger.error("执行入库sql出错");
						logDtlMap2.put("endTime", FileImportUtil.getCurTime());
						logDtlMap2.put("errFileName", curImpFileInfo.getFileName());
						logDtlMap2.put("errorMessage", "执行入库sql出错");
						logDtlMap2.put("posNo", "" + sqlInfo.getRowNumber());
						logDtlMap2.put("errFileName", errorFileName);
						saveDtlLog(logDtlMap2);
						readWriteFile.creatTxtFile();
						readWriteFile.writeTxtFile((String) impFileContentList
								.get(tmpNum));
						constant.errorNumber++;
					} else if (tmpFlg == -1) {
						strLog.delete(0, strLog.length());
						strLog = new StringBuffer("第" + sqlInfo.getRowNumber()
								+ "行执行入库sql出错");
						logger.error("执行入库sql出错");
						logDtlMap2.put("endTime", FileImportUtil.getCurTime());
						logDtlMap2.put("errFileName", curImpFileInfo.getFileName());
						logDtlMap2.put("errorMessage", "执行入库sql出错");
						logDtlMap2.put("posNo", "" + sqlInfo.getRowNumber());
						logDtlMap2.put("errFileName", errorFileName);
						saveDtlLog(logDtlMap2);
						readWriteFile.creatTxtFile();
						readWriteFile.writeTxtFile((String) impFileContentList
								.get(tmpNum));
						constant.errorNumber++;
					} else {
						logDtlMap2.put("endTime", FileImportUtil.getCurTime());
						// saveDtlLog(logDtlMap);
						constant.rightRow++;
					}
					tmpNum++;
				}
			}
			// ==========================批处理结束======================================================//
			sqlList.clear();
		}
//		// ======================批处理开始====================================================//
//		boolean batchFlag = excuteBatchSql();
//		Iterator iterator = sqlList.iterator();
//		if (batchFlag) {
//			String endTime = FileImportUtil.getCurTime();
//			while (iterator.hasNext()) {
//				SqlInfo sqlInfo = (SqlInfo) iterator.next();
//				Map logDtlMap = sqlInfo.getLogDtlMap();
//				logDtlMap.put("endTime", endTime);
//				// saveDtlLog(logDtlMap);
//			}
//		} else {
//			int tmpNum = 0;
//			while (iterator.hasNext()) {
//				SqlInfo sqlInfo = (SqlInfo) iterator.next();
//				Map logDtlMap = sqlInfo.getLogDtlMap();
//				int tmpFlg = FileImportService.getInstance().updateOne(
//						(String) sqlInfo.getParamMap().get(Constants.STR_SQL));
//				if (tmpFlg == 0) {
//					strLog.delete(0, strLog.length());
//					strLog = new StringBuffer("第" + sqlInfo.getRowNumber()
//							+ "行执行入库sql出错");
//					logger.error("执行入库sql出错");
//					logDtlMap.put("endTime", FileImportUtil.getCurTime());
//					logDtlMap.put("errFileName", curImpFileInfo.getFileName());
//					logDtlMap.put("errorMessage", "执行入库sql出错");
//					logDtlMap.put("posNo", "" + sqlInfo.getRowNumber());
//					logDtlMap.put("errFileName", errorFileName);
//					saveDtlLog(logDtlMap);
//					readWriteFile.creatTxtFile();
//					readWriteFile.writeTxtFile((String) impFileContentList
//							.get(tmpNum));
//					constant.errorNumber++;
//				} else if (tmpFlg == -1) {
//					strLog.delete(0, strLog.length());
//					strLog = new StringBuffer("第" + sqlInfo.getRowNumber()
//							+ "行执行入库sql出错");
//					logger.error("执行入库sql出错");
//					logDtlMap.put("endTime", FileImportUtil.getCurTime());
//					logDtlMap.put("errFileName", curImpFileInfo.getFileName());
//					logDtlMap.put("errorMessage", "执行入库sql出错");
//					logDtlMap.put("posNo", "" + sqlInfo.getRowNumber());
//					logDtlMap.put("errFileName", errorFileName);
//					saveDtlLog(logDtlMap);
//					readWriteFile.creatTxtFile();
//					readWriteFile.writeTxtFile((String) impFileContentList
//							.get(tmpNum));
//					constant.errorNumber++;
//				} else {
//					logDtlMap.put("endTime", FileImportUtil.getCurTime());
//					// saveDtlLog(logDtlMap);
//					constant.rightRow++;
//				}
//				tmpNum++;
//			}
//		}
//		// ==========================批处理结束======================================================//
//		sqlList.clear();
		logMap.put("errorNumber", constant.errorNumber);
		// 有错误时,记录下产生错误文件的路径和名称
		if (constant.errorNumber > 0) {
			logMap.put("errFileNamePath", errorFilePath);
			logMap.put("errFileName", errorFileName);
		}
		logMap.put("correctRows", constant.rightRow);
		logMap.put("filterRows", constant.filterRow);
		logMap.put("importStatus", ImportFileVar.IMPORT_STATUS_TRUE);
		logMap.put("endTime", FileImportUtil.getCurTime());
		saveLog(logMap);
		// importStatus(0);//标志为导入完成
		constant.progress = "100%";
		impFileContentList.clear();
		return true;
	}

	public boolean excuteBatchSql() throws CommonException {
		int sqlNumber = sqlList.size();
		if (sqlNumber == 0) {
			return true;
		}

		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		SessionFactory sf = rootdao.getSessionFactory();
		ConnectionProvider cp = ((SessionFactoryImplementor) sf).getConnectionProvider();
		Connection conn = null;
		Statement st = null;
		int[] rows = null;
		String exsql = "";
		try {
			conn = cp.getConnection();
			conn.setAutoCommit(false);
			st = conn.createStatement();
			
			for (SqlInfo sql : sqlList) {
				exsql = (String) sql.getParamMap().get("strSql");
				st.addBatch(exsql);
			}
			rows = st.executeBatch();
			conn.commit();
			st.clearBatch();
		} catch (SQLException e1) {
			ExceptionUtil.throwCommonException(e1.getMessage()+"exsql=["+exsql+"]");
			//e1.printStackTrace();
			if (conn!=null) {
				try {
					conn.rollback();
					
				} catch (SQLException e) {
					logger.error(e.getMessage());
					ExceptionUtil.throwCommonException(e.getMessage());
				}
			}
		} finally {
			try {
				if (st != null) {
					st.close();
				}
				if (conn != null) {
					conn.setAutoCommit(true);
					if (cp != null) {
						cp.closeConnection(conn);
					} else {
						// ignore
					}
				}
			} catch (SQLException e) {
				ExceptionUtil.throwCommonException(e.getMessage());
			}
		}
//		if (sqlNumber!=rows.length) {
//			ExceptionUtil.throwCommonException("执行成功行数："+rows.length+",总行数："+sqlNumber);
//		}

//		OperationContext context = new OperationContext();
//		context.setAttribute(ImportFileOP.CMD, ImportFileOP.DO_EXESQL);
//
//		context.setAttribute(ImportFileOP.PARAM, sqlList);
//		try {
//			SingleOPCaller.call(ImportFileOP.ID, context);
//		} catch (Exception e) {
//			logger.error(e.getMessage());
//			e.printStackTrace();
//			return false;
//		}
//
//		Object[] object = (Object[]) context.getAttribute(ImportFileOP.RESULT);
//		for (int obj : rows) {
//			if (obj<0) {
//				StringBuffer strLog = new StringBuffer("执行批处理入库sql出错");
//				logger.error(strLog.toString());
//				return false;
//			}
//		}
		// 正确行数
		constant.rightRow += sqlNumber;
		return true;
	}

	/**
	 * 释放计算出的字段数据
	 *
	 */
	private void clearFieldValueList() {
		curImpFileInfo.getFUpdateFieldsValue().clear();
		curImpFileInfo.getFKeyFieldsValue().clear();
		curImpFileInfo.getFFilterFieldsValue().clear();
	}

	/**
	 * 初始化字段配置
	 *
	 * @param curImpFileInfo当前导入文件信息
	 */
	private boolean initFieldSet(TFileDataInfo curImpFileInfo) {

		curImpFileInfo.getFFieldList().clear();
		curImpFileInfo.getFFilterList().clear();
		curImpFileInfo.getFKeyFieldList().clear();
		// curImpFileInfo.getFAntiKeyFieldList().clear();
		try {
			Map mapParam = new HashMap();
			mapParam.put("guid", curImpFileInfo.getGuid());
			// 初始化所有字段列表
			List<Map> rstList = FileImportService.getInstance().getFieldConfig(
					curImpFileInfo.getGuid());
			List rstListTemp = FileImportService.getInstance().getColumnMeta(
					curImpFileInfo.getTableName());
			for (Object obj : rstList) {
				BiImportFieldConfig rst = (BiImportFieldConfig) obj;
				int fieldLenth = 0;
				for (int i = 0; i < rstListTemp.size(); i++) {
					Object[] rst2 = (Object[]) rstListTemp.get(i);
					String colName = (String) rst2[0];
					if (colName.equalsIgnoreCase(rst.getFieldName())) {
						fieldLenth = Integer.parseInt(String.valueOf(rst2[1]));
						break;
					}
				}
				TFieldSetInfo lcFieldSetInfo = new TFieldSetInfo();
				lcFieldSetInfo.guid = rst.getId();
				lcFieldSetInfo.FieldName = rst.getFieldName();
				lcFieldSetInfo.expression = rst.getMapFunction();
				lcFieldSetInfo.dataType = rst.getFieldType();
				lcFieldSetInfo.updateWay = rst.getFieldUpdateType();
				lcFieldSetInfo.uniquekeyFlag = rst.getUniqueFlag();
				lcFieldSetInfo.updateFlag = rst.getFieldUpdateFlag();
				lcFieldSetInfo.filterFlag = rst.getFilterFlag();
				lcFieldSetInfo.FieldLength = fieldLenth;
				curImpFileInfo.getFFieldList().put(lcFieldSetInfo.FieldName,
						lcFieldSetInfo);// 放入list时要排序，让filter在前面

				// 初始化过滤字段列表
				if (Constants.YES.equals(rst.getFilterFlag())) {
					TFilterData lcFilterData = new TFilterData();
					lcFilterData.guid = rst.getId();
					lcFilterData.datatype = rst.getFieldType();
					lcFilterData.updateflag = rst.getFieldUpdateFlag();
					lcFilterData.FieldName = rst.getFieldName();
					lcFilterData.expression = rst.getFilterFunction();
					curImpFileInfo.getFFilterList().put(lcFilterData.FieldName,
							lcFilterData);
				}

				// 初始化主键字段列表
				if (ImportFileVar.DBFIELDDEF_UKFLAG_UNIQUEKEY.equals(rst
						.getUniqueFlag())) {
					curImpFileInfo.getFKeyFieldList().put(
							lcFieldSetInfo.FieldName, lcFieldSetInfo);
				}

				// // 初始化主键取反字段列表
				// if (ImportFileVar.DBFIELDDEF_UKFLAG_ANTIUNIQUEKEY.equals(rst
				// .getUniqueFlag())) {
				// curImpFileInfo.getFAntiKeyFieldList().put(
				// lcFieldSetInfo.FieldName, lcFieldSetInfo);
				// }

			}
		} catch (Exception e) {
			logger.error("初始化字段列表失败.");
			return false;
		}
		return true;

	}

	/**
	 * 判断文件配置中定义的记录存在修改方法是否满足
	 *
	 * @param iiLineNum记录行号
	 * @param osMessage输出错误信息
	 * @return 1-->不过滤,导入，0-->过滤，不导入，-1-->错误
	 */
	private int checkKeyFlag(int iiLineNum, TOutValue osMessage) {
		String lbUpdFlag;
		String lbFilterFlag;
		TFieldValueInfo lcFieldValueInfo;
		// // 取得主关键字取反行
		// Enumeration en = curImpFileInfo.getFAntiKeyFieldList().keys();
		// while (en.hasMoreElements()) {
		// String key = (String) en.nextElement();
		// TFieldSetInfo lcFieldSetInfo = (TFieldSetInfo) curImpFileInfo
		// .getFAntiKeyFieldList().get(key);
		// if (lcFieldSetInfo == null) {
		// continue;
		// }
		// lbUpdFlag = lcFieldSetInfo.updateFlag;
		// lbFilterFlag = lcFieldSetInfo.filterFlag;
		// lcFieldValueInfo = new TFieldValueInfo();
		// // 计算字段值成功
		// if (this.calcFinalFieldValue(lcFieldSetInfo, lcFieldValueInfo,
		// iiLineNum, osMessage)) {
		// // 主关键字（取反）为空，则过滤
		// if ((lcFieldValueInfo.FieldValue == null)
		// || (lcFieldValueInfo.FieldValue.trim().equals(""))) {
		// StringBuffer strLog = new StringBuffer("文件配置中文件名=[");
		// strLog.append(curImpFileInfo.getFileName())
		// .append("] 表名=[")
		// .append(curImpFileInfo.getTableName())
		// .append("] 字段名=[")
		// .append(lcFieldValueInfo.FieldName)
		// .append("]为主关键字(取反)，字段值为空，则过滤 。");
		// logger.debug(strLog.toString());
		// return 0;
		// }
		// // 主键字段值列表
		// curImpFileInfo.getFAntiKeyFieldsValue().put(
		// lcFieldValueInfo.FieldName, lcFieldValueInfo);
		// // 入库字段值列表
		// if (!ImportFileVar.DBFIELDDEF_UPDFLG_NOTUPDATE
		// .equals(lbUpdFlag)) {
		// if (!curImpFileInfo.getFUpdateFieldsValue().contains(
		// lcFieldValueInfo)) {
		// curImpFileInfo.getFUpdateFieldsValue().put(
		// lcFieldValueInfo.FieldName, lcFieldValueInfo);
		// }
		// }
		// // 过滤字段列表
		// if (lbFilterFlag
		// .equals(ImportFileVar.DBFIELDDEF_FILTERFLAG_CHECK)) {
		// if (!curImpFileInfo.getFFilterFieldsValue().contains(
		// lcFieldValueInfo)) {
		// curImpFileInfo.getFFilterFieldsValue().put(
		// lcFieldValueInfo.FieldName, lcFieldValueInfo);
		// }
		// }
		// } else {
		// return -1;
		// }
		// }

		// 取得主关键字行
		Enumeration en = curImpFileInfo.getFKeyFieldList().keys();
		while (en.hasMoreElements()) {
			String key = (String) en.nextElement();
			TFieldSetInfo lcFieldSetInfo = (TFieldSetInfo) curImpFileInfo
					.getFKeyFieldList().get(key);
			if (lcFieldSetInfo == null) {
				continue;
			}
			lbUpdFlag = lcFieldSetInfo.updateFlag;
			lbFilterFlag = lcFieldSetInfo.filterFlag;
			lcFieldValueInfo = new TFieldValueInfo();
			// 计算字段值成功
			if (this.calcFinalFieldValue(lcFieldSetInfo, lcFieldValueInfo,
					iiLineNum, osMessage)) {
				// 主关键字为空，则过滤
				if ((lcFieldValueInfo.FieldValue == null)
						|| (lcFieldValueInfo.FieldValue.equals(""))) {
					StringBuffer strLog = new StringBuffer("文件配置中文件名=[");
					strLog.append(curImpFileInfo.getFileName())
							.append("] 表名=[")
							.append(curImpFileInfo.getTableName())
							.append("] 字段名=[")
							.append(lcFieldValueInfo.FieldName)
							.append("]为主关键字，字段值为空，则过滤 。");
					logger.debug(strLog.toString());
					return 0;
				}
				// 主键字段值列表
				curImpFileInfo.getFKeyFieldsValue().put(
						lcFieldValueInfo.FieldName, lcFieldValueInfo);

				// 入库字段值列表
				if (!ImportFileVar.DBFIELDDEF_UPDFLG_NOTUPDATE
						.equals(lbUpdFlag)) {
					if (!curImpFileInfo.getFUpdateFieldsValue().contains(
							lcFieldValueInfo)) {
						curImpFileInfo.getFUpdateFieldsValue().put(
								lcFieldValueInfo.FieldName, lcFieldValueInfo);
					}
				}

				// 过滤字段列表
				if (lbFilterFlag
						.equals(ImportFileVar.DBFIELDDEF_FILTERFLAG_CHECK)) {
					if (!curImpFileInfo.getFFilterFieldsValue().contains(
							lcFieldValueInfo)) {
						curImpFileInfo.getFFilterFieldsValue().put(
								lcFieldValueInfo.FieldName, lcFieldValueInfo);
					}
				}
			} else {
				return -1;
			}
		}

		return 1;
	}

	/**
	 * 判断文件配置中定义的记录存在修改方法是否满足
	 *
	 * @param iiLineNum记录行号
	 * @param osMessage输出错误信息
	 * @return 1-->不过滤,导入，0-->过滤，不导入，-1-->错误
	 */
	private int CheckFilter(int iiLineNum, TOutValue ExistCount,
			TOutValue osMessage) {
		String lsUpdFlag;
		String lsFieldName;
		String lsFieldValue;
		TFieldValueInfo lcFieldValueInfo = new TFieldValueInfo();
		TFieldSetInfo lcFieldSetInfo;
		String lsDataType;
		Double lexFieldValue;
		TOutValue lsql = new TOutValue();
		boolean retflg = false;

		// 过滤字段且非主关键字段
		Enumeration en = curImpFileInfo.getFFilterList().keys();
		while (en.hasMoreElements()) {
			String key = (String) en.nextElement();
			retflg = false;
			TFilterData lcFilterValue = (TFilterData) curImpFileInfo
					.getFFilterList().get(key);
			if (lcFilterValue == null) {
				continue;
			}
			lsFieldName = lcFilterValue.FieldName;
			lsUpdFlag = lcFilterValue.updateflag;
			if (curImpFileInfo.getFKeyFieldsValue().containsKey(lsFieldName)) {
				lcFieldValueInfo = (TFieldValueInfo) curImpFileInfo
						.getFKeyFieldsValue().get(lsFieldName);
			} else {
				if (!curImpFileInfo.getFFieldList().containsKey(lsFieldName)) {
					StringBuffer strLog = new StringBuffer(
							"字段配置表中没有过滤字段的配置信息，文件名=[");
					strLog.append(curImpFileInfo.getFileName())
							.append("] 表名=[")
							.append(curImpFileInfo.getTableName())
							.append("] 字段名=[").append(lsFieldName).append("]");
					logger.debug(strLog.toString());
					return -1;
				}
			}
			lcFieldSetInfo = (TFieldSetInfo) curImpFileInfo.getFFieldList()
					.get(lsFieldName);
			lcFieldValueInfo = new TFieldValueInfo();
			// 计算字段值失败
			if (!this.calcFinalFieldValue(lcFieldSetInfo, lcFieldValueInfo,
					iiLineNum, osMessage)) {
				return -1;
			}
			lsDataType = lcFilterValue.datatype;
			String tempValue = "";

			if (ImportFileVar.DBFILTER_DATATYPE_NUM.equals(lsDataType)) {
				try {
					lexFieldValue = Double.valueOf(lcFieldValueInfo.FieldValue);
					tempValue = lexFieldValue.toString();
				} catch (Exception e) {
					osMessage.outvalue = "过滤表达式转换类型错误";
					return -1;
				}

			} else if (ImportFileVar.DBFILTER_DATATYPE_CHAR.equals(lsDataType)) {
				lsFieldValue = lcFieldValueInfo.FieldValue;
				tempValue = lsFieldValue;
			} else {
				osMessage.outvalue = "过滤表达式数据类型不正确";
				return -1;
			}
			String strExp = lcFilterValue.expression;
			strExp = ConvertMean.replace(strExp, "${value}", "value");
			ArrayList<Variable> variables = new ArrayList<Variable>();
			variables.add(Variable.createVariable("value", tempValue));
			Object result = "";
			try {
				strExp = strExp == null ? "false" : strExp;
				result = ExpressionEvaluator.evaluate(strExp, variables);
			} catch (IllegalExpressionException e) {
				logger.error("解析过滤表达式出错！" + e.getMessage());
				osMessage.outvalue = "解析过滤表达式出错." + e.getMessage();
				osMessage.errorNumber = errorNumber(lcFilterValue.expression);
				return -1;
			}
			retflg = (Boolean) result;//Integer.valueOf(result.toString()).intValue();
			// 不导入
			if (retflg) {
				return 0;
			}
			// 入库字段值列表
			if (!ImportFileVar.DBFIELDDEF_UPDFLG_NOTUPDATE.equals(lsUpdFlag)) {
				if (!curImpFileInfo.getFUpdateFieldsValue().contains(
						lcFieldValueInfo.FieldName)) {
					curImpFileInfo.getFUpdateFieldsValue().put(
							lcFieldValueInfo.FieldName, lcFieldValueInfo);
				}
			}
		}

//		if (!this.getTableData("count(0)", curImpFileInfo.getTableName(), lsql,
		if (!this.getTableData("count(*)", curImpFileInfo.getTableName(), lsql,
				osMessage)) {
			StringBuffer strLog = new StringBuffer("过滤配置中的检查方法=");
			strLog.append("文件名=[").append(curImpFileInfo.getFileName())
					.append("] 表名=[").append(curImpFileInfo.getTableName())
					.append("] 字段名=[").append(lcFieldValueInfo.FieldName)
					.append("] 错误信息=[").append(osMessage.outvalue).append("]");
			logger.debug(strLog.toString());
			return -1;
		}

		return 1;

	}

	/**
	 * 导入一行记录入库
	 *
	 * @param iiExistCount记录行号
	 * @param osMessage输出错误信息
	 * @return True-->成功，False-->失败
	 * @throws IOException
	 * @throws CommonException
	 */
	private boolean importRowData(TOutValue osMessage, int rowNumber,
			Map logDtlMap, ReadWriteFile readWriteFile, String errorFileName,
			List impFileContentList, String sLine) throws IOException,
			CommonException {
		String lsWhereSql;
		TFieldValueInfo lcFieldValueInfo;
		String lsMessage = "";
		String lsSql = "";
		lsWhereSql = " Where 1 = 1 ";
		byte flag = 0;

		// Enumeration en = curImpFileInfo.getFAntiKeyFieldsValue().keys();
		// while (en.hasMoreElements()) {
		// String key = (String) en.nextElement();
		// lcFieldValueInfo = (TFieldValueInfo) curImpFileInfo
		// .getFAntiKeyFieldsValue().get(key);
		// StringBuffer temp = new StringBuffer(lsWhereSql);
		// if (ImportFileVar.DBFILTER_DATATYPE_NUM
		// .equals(lcFieldValueInfo.DataType)) {
		// temp.append("and ");
		// temp.append(lcFieldValueInfo.FieldName);
		// temp.append(" <> ");
		// temp.append(ConvertMean.conertSql(lcFieldValueInfo.FieldValue));
		// lsWhereSql = temp.toString();
		// } else {
		// temp.append("and ");
		// temp.append(lcFieldValueInfo.FieldName);
		// temp.append(" <> '");
		// temp.append(ConvertMean.conertSql(lcFieldValueInfo.FieldValue));
		// temp.append("'");
		// lsWhereSql = temp.toString();
		// }
		// }

		Enumeration en = curImpFileInfo.getFKeyFieldsValue().keys();
		while (en.hasMoreElements()) {
			String key = (String) en.nextElement();
			lcFieldValueInfo = (TFieldValueInfo) curImpFileInfo
					.getFKeyFieldsValue().get(key);
			StringBuffer temp = new StringBuffer(lsWhereSql);
			if(ImportFileVar.DBFIELDDEF_POINTERDATATYPE_DATE
					.equals(lcFieldValueInfo.DataType)){
				String value = ConvertMean.conertSql(lcFieldValueInfo.FieldValue);
				if(value!=null & !"".equals(value)){//日期不为空时才拼接to_date
					temp.append(" and ");
					temp.append(lcFieldValueInfo.FieldName);
					temp.append(" = to_date('");
					temp.append(ConvertMean
							.conertSql(lcFieldValueInfo.FieldValue));
					temp.append("','yyyy-mm-dd')");
					lsWhereSql = temp.toString();
				}
				
			}else if (ImportFileVar.DBFILTER_DATATYPE_NUM
					.equals(lcFieldValueInfo.DataType)) {
				temp.append(" and ");
				temp.append(lcFieldValueInfo.FieldName);
				temp.append(" = ");
				temp.append(ConvertMean.conertSql(lcFieldValueInfo.FieldValue));
				lsWhereSql = temp.toString();
			} else {
				temp.append(" and ");
				temp.append(lcFieldValueInfo.FieldName);
				temp.append(" = '");
				temp.append(ConvertMean.conertSql(lcFieldValueInfo.FieldValue));
				temp.append("'");
				lsWhereSql = temp.toString();
			}
		}

		// 入库SQL语句
		StringBuffer temp = new StringBuffer("select count(*) from ");
		temp.append(curImpFileInfo.getTableName());
		temp.append(lsWhereSql);
		Integer flg = new Integer(0);
		if (curImpFileInfo.getKeyFlag() != ImportFileVar.FILEDATA_KEYFLG_INSERT
				&& curImpFileInfo.getKeyFlag() != ImportFileVar.FILEDATA_KEYFLG_UPDATE) {
			flg = FileImportService.getInstance().selectCount(temp.toString());
			// sql执行出错
			if (flg == null) {
				Map tmpParam = new HashMap();
				tmpParam.put(Constants.STR_SQL, lsSql);
				SqlInfo sqlInfo = new SqlInfo(rowNumber, lsSql, tmpParam, flag,
						logDtlMap);
				StringBuffer strLog = new StringBuffer("第"
						+ sqlInfo.getRowNumber() + "行执行入库sql出错");
				logger.error("查询主键值时出错,类型不匹配");
				logDtlMap.put("endTime", FileImportUtil.getCurTime());
				logDtlMap.put("errFileName", curImpFileInfo.getFileName());
				logDtlMap.put("errorMessage", "查询主键值时出错,类型不匹配");
				logDtlMap.put("posNo", "" + sqlInfo.getRowNumber());
				logDtlMap.put("errFileName", errorFileName);
				saveDtlLog(logDtlMap);
				// saveLog(logDtlMap);
				// 错误行数加1
				constant.errorNumber++;
				// 将有错误的数据生成文件
				readWriteFile.creatTxtFile();
				readWriteFile.writeTxtFile(sLine);
				flg = -1;
			}
		}

		if ((curImpFileInfo.getKeyFlag() == ImportFileVar.FILEDATA_KEYFLG_UPDATE)
				|| (curImpFileInfo.getKeyFlag() == ImportFileVar.FILEDATA_KEYFLG_ALL && flg
						.intValue() > 0)
				|| (curImpFileInfo.getKeyFlag() == ImportFileVar.FILEDATA_KEYFLG_ONE && flg
						.intValue() == 1)
				|| (curImpFileInfo.getKeyFlag() == ImportFileVar.FILEDATA_KEYFLG_ZEROONE && flg
						.intValue() == 1)) {
			Enumeration len = curImpFileInfo.getFUpdateFieldsValue().keys();
			curImpFileInfo.setModType("U");
			while (len.hasMoreElements()) {
				String key = (String) len.nextElement();
				lcFieldValueInfo = (TFieldValueInfo) curImpFileInfo
						.getFUpdateFieldsValue().get(key);
				// 空值不更新
				if (lcFieldValueInfo.FieldValue == null
						|| "".equals(lcFieldValueInfo.FieldValue.trim())) {
					continue;
				}
				// 关键字不更新
				if (curImpFileInfo.getFKeyFieldsValue().containsKey(key)) {
					continue;
				}

				// 只插入不更新
				if (ImportFileVar.DBFIELDDEF_UPDFLG_NOTUPDATEIN
						.equals(lcFieldValueInfo.bUpdateFlag)) {
					continue;
				}
				temp = new StringBuffer(lsSql);
				if(ImportFileVar.DBFIELDDEF_POINTERDATATYPE_DATE
						.equals(lcFieldValueInfo.DataType)){
					String value = ConvertMean.conertSql(lcFieldValueInfo.FieldValue);
					if(value!=null & !"".equals(value)){//日期不为空时才拼接to_date
						temp.append(lcFieldValueInfo.FieldName);
						temp.append(" = to_date('");
						temp.append(ConvertMean
								.conertSql(lcFieldValueInfo.FieldValue));
						temp.append("','yyyy-mm-dd'),");
						lsSql = temp.toString();
					}
					
				}else if (ImportFileVar.DBFIELDDEF_POINTERDATATYPE_CHAR
						.equals(lcFieldValueInfo.DataType)) {
					temp.append(lcFieldValueInfo.FieldName);
					temp.append(" = '");
					temp.append(ConvertMean
							.conertSql(lcFieldValueInfo.FieldValue));
					temp.append("',");
					lsSql = temp.toString();
				} else {
					temp.append(lcFieldValueInfo.FieldName);
					temp.append(" = ");
					temp.append(ConvertMean
							.conertSql(lcFieldValueInfo.FieldValue));
					temp.append(",");
					lsSql = temp.toString();
				}
			}
			if (!"".equals(lsSql.trim())) {
				if (lsSql.substring(lsSql.length() - 1).equals(",")) {
					lsSql = lsSql.substring(0, lsSql.length() - 1);
				}
				
				//added by xuhong 2015-3-10 数据不变时更新CHANGE_FLAG为1，有修改时更新CHANGE_FLAG保持为0；
//				temp = new StringBuffer("select count(*) from ");
//				temp.append(curImpFileInfo.getTableName());
//				temp.append(lsWhereSql);
//				temp.append(" and ");
//				lsSql = lsSql.replace("','yyyy-mm-dd')", "@");
//				lsSql = lsSql.replace(",", " and ");
//				lsSql = lsSql.replace("@", "','yyyy-mm-dd')");
//				temp.append(lsSql);
//				int retFlag = FileImportService.getInstance().selectCount(temp.toString());
//				int retFlag = 0;
				
				temp = new StringBuffer("update ");
				temp.append(curImpFileInfo.getTableName());
				temp.append(" set ");
				temp.append(lsSql.replace("and", ","));
//				if(retFlag==1){
//					temp.append(",CHANGE_FLAG='1'");
//				}else{
//					temp.append(",CHANGE_FLAG='0'");
//				}
				temp.append(lsWhereSql);
				lsSql = temp.toString();
			}
			flag = 2;
		} else if ((curImpFileInfo.getKeyFlag() == ImportFileVar.FILEDATA_KEYFLG_INSERT)
				|| (curImpFileInfo.getKeyFlag() == ImportFileVar.FILEDATA_KEYFLG_ZEROONE && flg
						.intValue() == 0)
				|| (curImpFileInfo.getKeyFlag() == ImportFileVar.FILEDATA_KEYFLG_ZEROADD && flg
						.intValue() == 0)) {
			Enumeration len = curImpFileInfo.getFUpdateFieldsValue().keys();
			curImpFileInfo.setModType("I");
			String lsSqlTemp = "";
			while (len.hasMoreElements()) {
				String key = (String) len.nextElement();
				lcFieldValueInfo = (TFieldValueInfo) curImpFileInfo
						.getFUpdateFieldsValue().get(key);
				temp = new StringBuffer(lsSql);
				temp.append(lcFieldValueInfo.FieldName);
				temp.append(",");
				lsSql = temp.toString();
				temp = new StringBuffer(lsSqlTemp);
				if(ImportFileVar.DBFIELDDEF_POINTERDATATYPE_DATE
						.equals(lcFieldValueInfo.DataType)){
					String value = ConvertMean.conertSql(lcFieldValueInfo.FieldValue);
					if(value!=null & !"".equals(value)){//日期不为空时才拼接to_date
						temp.append(" to_date('");
						temp.append(ConvertMean
								.conertSql(lcFieldValueInfo.FieldValue));
						temp.append("','yyyy-mm-dd'),");
						lsSqlTemp = temp.toString();
					}else{
						temp.append("'',");
						lsSqlTemp = temp.toString();
					}
					
				}else if (ImportFileVar.DBFIELDDEF_POINTERDATATYPE_CHAR
						.equals(lcFieldValueInfo.DataType)) {
					temp.append("'");
					temp.append(ConvertMean
							.conertSql(lcFieldValueInfo.FieldValue));
					temp.append("',");
					lsSqlTemp = temp.toString();
				} else {
					//modified by jianxue.zhang
					temp.append(ConvertMean
							.conertSql(lcFieldValueInfo.FieldValue.trim().equals("")? "0":lcFieldValueInfo.FieldValue));
					temp.append(",");
					lsSqlTemp = temp.toString();
				}
			}

			if (!lsSqlTemp.trim().equals("")) {
				if (lsSql.substring(lsSql.length() - 1).equals(",")) {
					lsSql = lsSql.substring(0, lsSql.length() - 1);
					lsSqlTemp = lsSqlTemp.substring(0, lsSqlTemp.length() - 1);
				}
				temp = new StringBuffer("insert into ");
				temp.append(curImpFileInfo.getTableName());
				temp.append(" (");
				temp.append(lsSql);
				//added by xuhong 2015-3-10增加change_flag标志，新增为0 begin
//				temp.append(",CHANGE_FLAG");
				//added by xuhong 2015-3-10增加change_flag标志，新增为0 begin
				temp.append(")");
				temp.append(" Values ");
				temp.append("(");
				temp.append(lsSqlTemp);
				//added by xuhong 2015-3-10增加change_flag标志，新增为0 begin
//				temp.append(",0");
				//added by xuhong 2015-3-10增加change_flag标志，新增为0 begin
				temp.append(")");
				lsSql = temp.toString();
			} else {
				lsSql = "";
			}
			flag = 1;
		} else if ((curImpFileInfo.getKeyFlag() == ImportFileVar.FILEDATA_KEYFLG_ONEDELETE && flg
				.intValue() == 1)
				|| (curImpFileInfo.getKeyFlag() == ImportFileVar.FILEDATA_KEYFLG_DELETE && flg
						.intValue() > 0)) {
			curImpFileInfo.setModType("D");
			temp = new StringBuffer("delete from ");
			temp.append(curImpFileInfo.getTableName());
			temp.append(lsWhereSql);
			lsSql = temp.toString();
			flag = 3;
		}

		if (!"".equals(lsSql.trim())) {
			Map tmpParam = new HashMap();
			tmpParam.put(Constants.STR_SQL, lsSql);
			SqlInfo sqlInfo = new SqlInfo(rowNumber, lsSql, tmpParam, flag,
					logDtlMap);
			// 单行处理
			// int
			// tmpFlg=myBatisSessionTemplate.update("com.huateng.report.imports.sqlmap.Import.select13",sqlInfo.getParamMap());
			// if (tmpFlg == 0) {
			// StringBuffer strLog=new
			// StringBuffer("第"+sqlInfo.getRowNumber()+"行执行入库sql出错");
			// log.error("执行入库sql出错");
			// logDtlMap.put("endTime", DateUtils.dateToNumber5(new Date()));
			// logDtlMap.put("errFileName", curImpFileInfo.getFileName());
			// logDtlMap.put("errorMessage", "执行入库sql出错");
			// logDtlMap.put("posNo", sqlInfo.getRowNumber());
			// logDtlMap.put("errFileName",errorFileName);
			// saveDtlLog(logDtlMap);
			// readWriteFile.creatTxtFile();
			// readWriteFile.writeTxtFile((String)impFileContentList.get(rowNumber));
			// constant.errorNumber++;
			// }else if(tmpFlg == -1){
			// //SQL执行入库操作时出错
			// StringBuffer strLog=new
			// StringBuffer("第"+sqlInfo.getRowNumber()+"行执行入库sql出错");
			// log.error("执行入库sql出错");
			// logDtlMap.put("endTime", DateUtils.dateToNumber5(new Date()));
			// logDtlMap.put("errFileName", curImpFileInfo.getFileName());
			// logDtlMap.put("errorMessage", "执行入库sql出错");
			// logDtlMap.put("posNo", sqlInfo.getRowNumber());
			// logDtlMap.put("errFileName",errorFileName);
			// saveDtlLog(logDtlMap);
			// readWriteFile.creatTxtFile();
			// readWriteFile.writeTxtFile((String)impFileContentList.get(rowNumber));
			// constant.errorNumber++;
			// }else{
			// logDtlMap.put("endTime", DateUtils.dateToNumber5(new Date()));
			// // saveDtlLog(logDtlMap);
			// constant.rightRow++;
			// }
			// 批处理
			sqlList.add(sqlInfo);
		}
		return true;
	}

	/**
	 * 计算非过滤和非主关键字段的字段值
	 *
	 * @param iiLineNum记录行号
	 * @param osMessage输出错误信息
	 * @return True-->成功，False-->失败
	 */
	private boolean CalcUpdateFieldsValue(int iiLineNum, TOutValue osMessage) {

		TFieldValueInfo lcFieldValueInfo;
		String lsFieldName;
		TFieldSetInfo lcFieldSetInfo;

		// 非过滤和非主关键字段
		Enumeration en = curImpFileInfo.getFFieldList().keys();
		while (en.hasMoreElements()) {
			String key = (String) en.nextElement();
			lcFieldSetInfo = (TFieldSetInfo) curImpFileInfo.getFFieldList()
					.get(key);
			if (ImportFileVar.DBFIELDDEF_UPDFLG_NOTUPDATE
					.equals(lcFieldSetInfo.updateFlag)) {
				continue;
			}
			lsFieldName = lcFieldSetInfo.FieldName;
			if (!curImpFileInfo.getFUpdateFieldsValue()
					.containsKey(lsFieldName)) {
				lcFieldValueInfo = new TFieldValueInfo();
				// 计算字段值失败
				if (!this.calcFinalFieldValue(lcFieldSetInfo, lcFieldValueInfo,
						iiLineNum, osMessage)) {
					return false;
				} else {
					curImpFileInfo.getFUpdateFieldsValue().put(lsFieldName,
							lcFieldValueInfo);
				}
			}
		}
		return true;
	}

	/**
	 * 计算字段最值
	 *
	 * @param icFieldSetInfo字段导入配置
	 * @param ocFieldValue存放字段最终值
	 * @param iiLineNum行号
	 * @param osMessage错误信息
	 * @return True-->成功，False-->失败
	 */
	private boolean calcFinalFieldValue(TFieldSetInfo icFieldSetInfo,
			TFieldValueInfo ocFieldValue, int iiLineNum, TOutValue osMessage) {
		String strExp = icFieldSetInfo.expression;
		strExp = ConvertMean.replace(strExp, "${value}", "curImpFileInfo");
		ArrayList<Variable> variables = new ArrayList<Variable>();
		variables
				.add(Variable.createVariable("curImpFileInfo", curImpFileInfo));
		Object result = "";
		try {
			// 解析表达式
			result = ExpressionEvaluator.evaluate(strExp, variables);
		} catch (IllegalExpressionException e) {
			logger.error("解析字段表达式出错" + e.getMessage());
			osMessage.outvalue = "解析字段表达式出错" + e.getMessage();
			osMessage.opStation = e.getErrorPosition();
			osMessage.errorNumber = errorNumber(icFieldSetInfo.expression);
			return false;
		}
		ocFieldValue.FieldValue = result.toString();
		ocFieldValue.FieldName = icFieldSetInfo.FieldName;
		ocFieldValue.FieldLength = icFieldSetInfo.FieldLength;
		ocFieldValue.bUpdateFlag = icFieldSetInfo.updateFlag;
		ocFieldValue.DataType = icFieldSetInfo.dataType;
		if (!ImportFileVar.DBFIELDDEF_UPDFLG_NOTUPDATE
				.equals(icFieldSetInfo.updateFlag)) {
			// 根据字段长度，截取数据
			if (ImportFileVar.DBFIELDDEF_POINTERDATATYPE_CHAR
					.equals(ocFieldValue.DataType)) {
				if (ocFieldValue.FieldLength > 0) {
					ocFieldValue.FieldValue = ConvertMean.subStringUTF8(
							ocFieldValue.FieldValue, ocFieldValue.FieldLength);
				}
			}
		}
		return true;
	}

	/**
	 * 得到数据表的字段结构
	 *
	 * @param isFieldStr字段名
	 * @param isTableName表名
	 * @param lsql输出SQL
	 * @param osMessage存放错误信息
	 * @return True-->执行成功，False-->执行失败
	 */
	private boolean getTableData(String isFieldStr, String isTableName,
			TOutValue lsql, TOutValue osMessage) {
		String lsWhereSql = " Where 1 = 1 ";
		TFieldValueInfo lcFieldValueInfo;
		String lsSql;

		Enumeration en = curImpFileInfo.getFKeyFieldsValue().keys();
		while (en.hasMoreElements()) {
			String key = (String) en.nextElement();
			lcFieldValueInfo = (TFieldValueInfo) curImpFileInfo
					.getFKeyFieldsValue().get(key);
			StringBuffer temp = new StringBuffer(lsWhereSql);
			if (lcFieldValueInfo.DataType
					.equals(ImportFileVar.DBFILTER_DATATYPE_NUM)) {
				temp.append("and ");
				temp.append(lcFieldValueInfo.FieldName);
				temp.append(" = ");
				// 2009-01-09 013 lyg edit start 修改单引号为双引号
				temp.append(ConvertMean.conertSql(lcFieldValueInfo.FieldValue));
				lsWhereSql = temp.toString();
			} else {
				temp.append("and ");
				temp.append(lcFieldValueInfo.FieldName);
				temp.append(" = '");
				temp.append(ConvertMean.conertSql(lcFieldValueInfo.FieldValue));
				// 2009-01-09 013 lyg edit end
				temp.append("'");
				lsWhereSql = temp.toString();
			}
		}

		// en = curImpFileInfo.getFAntiKeyFieldsValue().keys();
		// while (en.hasMoreElements()) {
		// String key = (String) en.nextElement();
		// lcFieldValueInfo = (TFieldValueInfo) curImpFileInfo
		// .getFAntiKeyFieldsValue().get(key);
		// StringBuffer temp = new StringBuffer(lsWhereSql);
		// if (lcFieldValueInfo.DataType
		// .equals(ImportFileVar.DBFILTER_DATATYPE_NUM)) {
		// temp.append("and ");
		// temp.append(lcFieldValueInfo.FieldName);
		// temp.append(" <> ");
		// // 2009-01-09 015 lyg edit start 修改单引号为双引号
		// temp.append(ConvertMean.conertSql(lcFieldValueInfo.FieldValue));
		// lsWhereSql = temp.toString();
		// } else {
		// temp.append("and ");
		// temp.append(lcFieldValueInfo.FieldName);
		// temp.append(" <> '");
		// temp.append(ConvertMean.conertSql(lcFieldValueInfo.FieldValue));
		// // 2009-01-09 015 lyg edit end
		// temp.append("'");
		// lsWhereSql = temp.toString();
		// }
		// }

		StringBuffer temp = new StringBuffer("");
		temp.append("select ");
		temp.append(isFieldStr);
		temp.append(" from ");
		temp.append(isTableName);
		temp.append(lsWhereSql);
		lsSql = temp.toString();
		// Log.errorImport(constant.logName, lsSql);
		try {
			FileImportService.getInstance().selectCount(lsSql);
			lsql.outvalue = lsSql;
			return true;
		} catch (Exception e) {
			logger.error("得到数据表的字段结构失败." + e.getMessage());
			osMessage.outvalue = "得到数据表的字段结构失败." + e.getMessage();
			return false;
		}
	}

	public static String errorNumber(String strSource) {
		strSource = ConvertMean.replace(strSource, "${value}", "@");
		String[] strs = strSource.split("@,", -1);// -1
													// 是为了防止行数据后几个项目为空时，用split方法无法取得数据。
		String strTmp = "";
		for (int i = 1; i < strs.length; i++) {
			strTmp += "[" + strs[i].substring(0, strs[i].indexOf(")")) + "],";

		}
		if (!"".equals(strTmp)) {
			strTmp = strTmp.substring(0, strTmp.lastIndexOf(","));
		}
		return strTmp;

	}

	public void saveLog(Map map) {
		logInfo.setLogMan(map);
		saveLogInfo(this.logInfo);
	}

	public void saveDtlLog(Map map) {

		logInfo.getLogDtl().add(map);

	}

	public void saveLogInfo(LogInfo logInfo) {
		BiImportLog importLog = new BiImportLog();
		Map mainLog = logInfo.getLogMan();
		importLog.setFileName((String) mainLog.get("fileName"));
		importLog.setTableName((String) mainLog.get("tableName"));
		importLog.setWorkDate((String) mainLog.get("workDate"));
		// importLog.setFileOwner((String) mainLog.get("fileOwner"));
		importLog.setBatchNo((Integer) mainLog.get("batchNo"));
		importLog.setSeqNo((Integer) mainLog.get("sericalNo"));
		importLog.setBeginTime((String) mainLog.get("beginTime"));
		importLog.setErrorRows((Integer) mainLog.get("errorNumber"));
		importLog.setTotalRows((Integer) mainLog.get("totalRows"));
		importLog.setCorrectRows((Integer) mainLog.get("correctRows"));
		importLog.setFilterRows((Integer) mainLog.get("filterRows"));
		importLog.setImportStatus((String) mainLog.get("importStatus"));
		importLog.setErrorMessage((String) mainLog.get("errorMessage"));
		importLog.setEndTime((String) mainLog.get("endTime"));
		importLog.setErrFilePath((String) mainLog.get("errFileNamePath"));
		importLog.setErrFile((String) mainLog.get("errFileName"));
		importLog.setFuid((String) mainLog.get("guid"));

		BiImportLogDtl logDtl = null;
		for (int i = 0; i < logInfo.getLogDtl().size(); i++) {
			logDtl = new BiImportLogDtl();
			Map dtlMap = (Map) logInfo.getLogDtl().get(i);
			logDtl.setLog(importLog);
			logDtl.setBeginTime((String) dtlMap.get("beginTime"));
			logDtl.setFileName((String) dtlMap.get("fileName"));
			logDtl.setTableName((String) mainLog.get("tableName"));
			logDtl.setWorkDate((String) dtlMap.get("workDate"));
			// logDtl.setFileOwner((String) dtlMap.get("fileOwner"));
			logDtl.setSeqNo((Integer) dtlMap.get("sericalNo"));
			logDtl.setLineNo((Integer) dtlMap.get("lineNo"));
			logDtl.setPosNo((String) dtlMap.get("posNo"));
			logDtl.setErrFile((String) dtlMap.get("errFileName"));
			logDtl.setErrorMessage((String) dtlMap.get("errorMessage"));
			logDtl.setEndTime((String) dtlMap.get("endTime"));
			importLog.getLogDtls().add(logDtl);
		}

		OperationContext context = new OperationContext();
		context.setAttribute(ImportFileOP.CMD, ImportFileOP.DO_SAVELOG);
		context.setAttribute(ImportFileOP.PARAM, importLog);
		try {
			SingleOPCaller.call(ImportFileOP.ID, context);
		} catch (CommonException e) {
			logger.error(e.getMessage());
		}

	}

}
