package com.huateng.report.imports.common;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.service.CommonService;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.DataFormat;
import com.huateng.report.imports.service.FileImportService;

public class FileImportUtil {

	public static String getWorkDate(String workdate) throws CommonException {
		if (DataFormat.isEmpty(workdate)) {
			workdate = DataFormat.dateToNumber(GlobalInfo.getCurrentInstance()
					.getTxdate());
		}
		return workdate;
	}

	/**
	 * 获取拼接工作日期后的文件名
	 * 
	 * @param workdate
	 * @param filename
	 * @return
	 * @throws CommonException
	 */
	public static String getFileNameFull(String workdate, String filename) {
		int ind = filename.lastIndexOf(".");
		String filepath = null;
		if (ind == -1) {
			filepath = filename + workdate;
		} else {
			//modified by xuhong 2015-3-27添加拼接xls文件名 begin
			if(filename.endsWith("xls")){
				filepath = filename.substring(0, ind) + "_" + workdate
				+ filename.substring(ind);
			}else{
				filepath = filename.substring(0, ind-4) + "." + workdate
				+ filename.substring(ind-4);
			}
			//modified by xuhong 2015-3-27添加拼接xls文件名 end
			
		}
		return filepath;
	}
	//工作日期的格式为 121030
	public static String getFileNameFullWithout(String workdate, String filename) {
		int ind = filename.lastIndexOf(".");
		String filepath = null;
		if(null != workdate && !"".equals(workdate))
		{
			workdate = workdate.substring(2, 8);
		}
		if (ind == -1) {
			filepath = filename + workdate;
		} else {
			filepath = filename.substring(0, ind) + workdate
					+ filename.substring(ind);
		}
		return filepath;
	}
	/**
	 * 判断当前工作日下的导入文件是否存在
	 * 
	 * @param workdate
	 * @param filename
	 * @return
	 * @throws CommonException
	 */
	public static boolean isExist(String workdate, String filename)
			throws CommonException {
		File f = new File(FileImportService.getInstance()
				.getDefaultImportPath()
				+ File.separator
				+ workdate
				+ File.separator + filename);
		return f.isDirectory() ? false : f.exists();
	}
	//工作日期的格式为 121030
	public static boolean isExistWithout(String workdate, String filename)
			throws CommonException {
		if(null != workdate && !"".equals(workdate))
		{
			workdate = workdate.substring(2, 8);
		}
		File f = new File(FileImportService.getInstance()
				.getDefaultImportPath()
				+ File.separator
				+ workdate
				+ File.separator + filename);
		return f.isDirectory() ? false : f.exists();
	}

	public static String getFilePath(String workdate) throws CommonException {
		return FileImportService.getInstance().getDefaultImportPath()
				+ File.separator + workdate + File.separator;
	}

	public static String getCurTime() throws CommonException {
		return new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
	}

	public static boolean isReceiveFileExist(String apptype, String pack, String filename) {
		try {
			String srcAccPath = CommonService.getInstance().getSysParamDef("RDIR","LOCAL_" + apptype.toUpperCase(), "/");
			String srcFeedbackPath = CommonService.getInstance().getSysParamDef("RDIR","LOCAL_FEEDBACK", "/");
			String errfilename = filename.replaceAll("\\.", "ERR.");
			String filepath = srcAccPath + srcFeedbackPath + pack +"ERR"+ File.separator + errfilename;
			File f = new File(filepath);
			return f.isDirectory() ? false : f.exists();
		} catch (CommonException e) {
			e.printStackTrace();
			return false;
		}
	}
	public static boolean isReceiveDirExist(String apptype, String pack) {
		try {
			String srcAccPath = CommonService.getInstance().getSysParamDef("RDIR","LOCAL_" + apptype.toUpperCase(), "/");
			String srcFeedbackPath = CommonService.getInstance().getSysParamDef("RDIR","LOCAL_FEEDBACK", "/");
			String filepath = srcAccPath + srcFeedbackPath + pack;
			File f = new File(filepath);
			return f.isDirectory() && f.exists();
		} catch (CommonException e) {
			e.printStackTrace();
			return false;
		}
	}
}
