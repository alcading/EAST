package com.huateng.report.imports.getter;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.framework.util.DataFormat;
import com.huateng.ebank.framework.util.DateUtil;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;
import com.huateng.report.imports.bean.ImportFileBean;
import com.huateng.report.imports.common.Constants;
import com.huateng.report.utils.ReportUtils;

@SuppressWarnings("unchecked")
public class ImportBadFileGetter extends BaseGetter{
	@Override
	public Result call() throws AppException {
		try {
			//拼装错误文件路径，格式如：/home/jgbs/source_data/20150228/error
			String filePath = ReportUtils.getSysParamsValue(Constants.PARAM_DIR, Constants.PARAM_DIR_0001, "D:/bad");
			String workdate = DataFormat.dateToNumber(DateUtil.getTbsDay());
			filePath = filePath.substring(0, filePath.lastIndexOf("/")) + "/source_data/" + workdate + filePath.substring( filePath.lastIndexOf("/"));
			File dir = new File(filePath);
			List list = new ArrayList();
			if (dir.isDirectory() && dir.exists()) {
				String filename = null;
				String[] fn = null;
				ImportFileBean bean = null;
				for (File file : dir.listFiles()) {
					if (file.isFile()) {
						bean = new ImportFileBean();
						filename = file.getName();
						fn = filename.split("[.]");
						bean.setFileName(fn[0]);
						bean.setFileNameFull(filename);
						list.add(bean);
					}
				}
			}
			ResultMng.fillResultByList(getCommonQueryBean(),
					getCommQueryServletRequest(), list, getResult());
			result.setContent(list);
			result.getPage().setTotalPage(1);
			result.init();
			return result;
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}	

}