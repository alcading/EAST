package com.huateng.report.imports.getter;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import resource.bean.report.BiImportLog;
import resource.report.dao.ROOTDAOUtils;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;
import com.huateng.report.imports.bean.ImportFileModBean;
import com.huateng.report.imports.common.ReadWriteFile;

@SuppressWarnings("unchecked")
public class ImportFileModGetter extends BaseGetter {

	@Override
	public Result call() throws AppException {
		try {
			String logid = getCommQueryServletRequest().getParameter("logid");
			List list = new ArrayList();
			ImportFileModBean bean = new ImportFileModBean();
			BiImportLog log = ROOTDAOUtils.getROOTDAO().query(BiImportLog.class, logid);
			if (StringUtils.isNotBlank(log.getErrFilePath()) && StringUtils.isNotBlank(log.getErrFile())) {
				ReadWriteFile readWriteFile=new ReadWriteFile(log.getErrFilePath(),log.getErrFile());
				String str=readWriteFile.readTxtFile();
				bean.setId(logid);
				bean.setDescription(str);
				bean.setErrFile(log.getErrFile());
				bean.setErrFilePath(log.getErrFilePath());
			}
			list.add(bean);
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
