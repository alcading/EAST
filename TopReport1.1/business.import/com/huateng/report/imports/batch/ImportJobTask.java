package com.huateng.report.imports.batch;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;

import resource.report.dao.ROOTDAOUtils;

import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.operation.SingleOPCaller;
import com.huateng.ebank.framework.report.common.ReportConstant;
import com.huateng.ebank.framework.util.DataFormat;
import com.huateng.ebank.framework.util.DateUtil;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.report.imports.bean.ImportFileBean;
import com.huateng.report.imports.common.Constants;
import com.huateng.report.imports.common.FileImportUtil;
import com.huateng.report.imports.model.Constant;
import com.huateng.report.imports.operation.ImportFileOP;
import com.huateng.report.imports.service.FileImportService;
import com.huateng.report.utils.ReportEnum;
import com.huateng.report.utils.ReportUtils;

import east.creatfile.CreatFile;

public class ImportJobTask {
	private static final Logger logger = Logger.getLogger(ImportJobTask.class);

	/**
	 * 文件导入及分析导入步骤：
	 * 1：检查后台导数是否执行
	 * 2：检查后台导数是否正确完成
	 * 3：前台导数
	 * 4：检查前台导数是否正确完成
	 * 5：执行数据分析
	 * @throws CommonException
	 */
	public void doBiz() throws CommonException {
		String workdate = DataFormat.dateToNumber(DateUtil.getTbsDay());
		
		//1：检查后台导数是否执行
		StringBuffer checkSql = new StringBuffer();
		checkSql.append("select * from BH_PROC_LOG where 1=1 ");
		checkSql.append(" and step='1'");
		checkSql.append(" and bhdate=to_date('"+workdate+"','yyyy-mm-dd')");
		List logList = ROOTDAOUtils.getROOTDAO().queryBySQLList(checkSql.toString());
		if(!logList.isEmpty()){
			logger.info("后台导数步骤已执行。");
			System.out.println("后台导数步骤已执行。");
		}else{
			ExceptionUtil.throwCommonException("后台导数步骤未执行，请先执行后台导数步骤!");
		}
		
		//2：检查后台导数是否正确完成
		//拼装错误文件路径，格式如：/home/jgbs/source_data/20150228/error
		String filePath = ReportUtils.getSysParamsValue(Constants.PARAM_DIR, Constants.PARAM_DIR_0001, "D:/bad");
		filePath = filePath.substring(0, filePath.lastIndexOf("/")) + "/source_data/" + workdate + filePath.substring( filePath.lastIndexOf("/"));
		File errDir = new File(filePath);
		if (errDir.isDirectory() && errDir.exists()) {
			if(errDir.listFiles().length>0){
//				ExceptionUtil.throwCommonException("后台执行batch.sh出错，请检查对应" + filePath + "文件夹下的文件！");
			}
		}else{
			System.out.println("请注意：目录" + filePath + "不存在！");
		}
		
		//3：前台导数
		logger.info("begin import " + workdate + "'s files");
		String datepath = FileImportUtil.getFilePath(workdate);
		File dir = new File(datepath);
		System.out.println("检查导入文件是否存在:"+dir.isDirectory() +"==="+dir.exists());
		if (dir.isDirectory() && dir.exists()) {
			System.out.println("查手工导入数据情况!");
			try {
				String filename = null;
				String[] fn = null;
				ImportFileBean bean = null;
				List list = new ArrayList();
				for (File file : dir.listFiles()) {
					if (file.isFile()) {
						filename = file.getName();
						fn = filename.split("[_.]");
						bean = new ImportFileBean();
						bean.setWorkDate(workdate);
						if(filename.endsWith("xls")){
							bean.setFileName(filename.substring(0,filename.lastIndexOf("_"))+ ".xls");
						}else if(filename.endsWith("unl.00")){
							bean.setFileName(fn[0] + "." + fn[2] + "." + fn[3]);
						}else{
							continue;
						}
						
						bean.setFileNameFull(filename);
						bean.setExist(true);

						list = ROOTDAOUtils.getROOTDAO().queryByQL2List(
								"from BiImportFileConfig where fileName = '" + bean.getFileName() + "' and status = '"
										+ Constants.YES + "'");
						if (list.isEmpty()) {
							logger.warn(bean.getFileName() + " not configured or unvaliable.");
						}
						for (Object obj : list) {
							try {
								BeanUtils.copyProperties(bean, obj);
								bean.setImpStatus(FileImportService.getInstance().getImportLogStatus(
										bean.getFileNameFull(), bean.getTableName(), workdate));
							} catch (Exception e) {
								logger.warn("copyproperties failed:", e);
								// continue;
							}
							if (Constants.IMPORT_STATUS_SUCCESS.equals(bean.getImpStatus())
									|| Constants.IMPORT_STATUS_FAILED.equals(bean.getImpStatus())) {
								continue;
							}

							logger.error("importing " + bean.getFileNameFull() + " ...");
							OperationContext oc = new OperationContext();
							oc.setAttribute(ImportFileOP.CMD, ImportFileOP.DO_IMPORT);
							oc.setAttribute(ImportFileOP.PARAM, bean);
							oc.setAttribute(ImportFileOP.PROGRESS, new Constant());
							SingleOPCaller.call(ImportFileOP.ID, oc);
						}
					}
				}
			} catch (CommonException e) {
				ExceptionUtil.throwCommonException(workdate + "导入文件异常：" + e.getMessage());
			}
		}
		System.out.println("导入手工上传的文件!");
		try {
			if (dir.isDirectory() && dir.exists()) {
				// 4:检查前台导数是否正确完成
				String impsta = FileImportService.getInstance().queryImportIsSuccessByWorkDate(workdate);
				if (impsta.equals(ReportEnum.REPORT_IMP_FILE_ERR_TYPE.NO_DATA_ERR.value)) {
					ExceptionUtil.throwCommonException("未执行数据导入！");
				} else if (impsta.equals(ReportEnum.REPORT_IMP_FILE_ERR_TYPE.IMP_ERR.value)) {
					ExceptionUtil.throwCommonException("导入存在错误信息，请修正后执行分析！");
				}
			}
		} catch (Exception e) {
			ExceptionUtil.throwCommonException(workdate + "手工上传数据导入失败：" + e.getMessage());
		}		
		
		try {
			System.out.println("数据分析开始:"+ReportConstant.IMP_FILE_IS_AUTO_ANALY);
			if (ReportConstant.IMP_FILE_IS_AUTO_ANALY) {
				//5：执行数据分析
				CreatFile.creatJgbsFile(null);
			}
		} catch (Exception e) {
			ExceptionUtil.throwCommonException(workdate + "执行数据分析：" + e.getMessage());
		}

		logger.info("end import " + workdate + "'s files");
	}
}
