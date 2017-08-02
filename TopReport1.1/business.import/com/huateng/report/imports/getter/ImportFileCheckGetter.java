package com.huateng.report.imports.getter;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import resource.bean.report.BiImportFileConfig;
import resource.report.dao.ROOTDAOUtils;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;
import com.huateng.report.imports.bean.ImportFileBean;
import com.huateng.report.imports.common.Constants;
import com.huateng.report.imports.common.FileImportUtil;
import com.huateng.report.imports.service.FileImportService;

@SuppressWarnings("unchecked")
public class ImportFileCheckGetter extends BaseGetter {

	@Override
	public Result call() throws AppException {
		try {
			String isImporting = (String) getSessionObject(Constants.IS_IMPORTING);

			List rs = ROOTDAOUtils.getROOTDAO().queryByQL2List(
					"from BiImportFileConfig where status = '" + Constants.YES
							+ "'");
			List list = new ArrayList();

			ImportFileBean bean = null;
			String workdate = FileImportUtil
					.getWorkDate(getCommQueryServletRequest().getParameter(
							"qWorkDate"));
			for (int i = 0; i < rs.size(); i++) {
				BiImportFileConfig bfc = (BiImportFileConfig) rs.get(i);
				bean = new ImportFileBean();
				BeanUtils.copyProperties(bean, bfc);

				bean.setFileNameFull(FileImportUtil.getFileNameFull(workdate,
						bean.getFileName()));
				if (bean.getFileName() == null) {
					bean.setExist(false);
				} else {
					bean.setExist(FileImportUtil.isExist(workdate,
							bean.getFileNameFull()));
				}
				bean.setWorkDate(workdate);
				bean.setImpStatus(FileImportService.getInstance()
						.getImportLogStatus(bean.getFileNameFull(),
								bean.getTableName(), workdate));
				bean.setImporting(Constants.YES.equals(isImporting));
				list.add(bean);
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
