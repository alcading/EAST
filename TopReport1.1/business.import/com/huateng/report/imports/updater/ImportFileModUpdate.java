package com.huateng.report.imports.updater;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import resource.bean.report.BiImportLog;
import resource.report.dao.ROOTDAOUtils;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;
import com.huateng.report.imports.bean.ImportFileModBean;
import com.huateng.report.imports.common.Constants;
import com.huateng.report.imports.common.ReadWriteFile;

public class ImportFileModUpdate extends BaseUpdate {

	@Override
	public UpdateReturnBean saveOrUpdate(
			MultiUpdateResultBean multiUpdateResultBean,
			HttpServletRequest request, HttpServletResponse response)
			throws AppException {
		try {
			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			UpdateResultBean updateResultBean = multiUpdateResultBean
					.getUpdateResultBeanByID("ImportFileMod");

			ImportFileModBean bean = null;
			while (updateResultBean.hasNext()) {
				Map<String, String> map = updateResultBean.next();
//				bean = new ImportFileModBean();
//				mapToObject(bean, map);

				BiImportLog log = ROOTDAOUtils.getROOTDAO().query(
						BiImportLog.class, map.get("id"));
				if (StringUtils.isNotBlank(log.getErrFilePath())
						&& StringUtils.isNotBlank(log.getErrFile())) {
					ReadWriteFile readWriteFile = new ReadWriteFile(
							log.getErrFilePath(), log.getErrFile());
					try {
						// 先读取原有文件内容，然后进行写入操作
						readWriteFile.replaceTxtFile(map.get("description").replaceAll("\\^p", "\r\n"));
						log.setModFlg(Constants.MOD_FLG_FINISH);
						ROOTDAOUtils.getROOTDAO().saveOrUpdate(log);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}

			return updateReturnBean;
		} catch (CommonException cEx) {
			throw cEx;
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		} finally {
			// 结束导入
			setSessionObject(Constants.IS_IMPORTING, Constants.NO);
		}
	}
}
