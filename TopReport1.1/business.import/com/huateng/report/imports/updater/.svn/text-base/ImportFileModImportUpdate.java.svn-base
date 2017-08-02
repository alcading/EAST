package com.huateng.report.imports.updater;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import resource.bean.report.BiImportLog;
import resource.report.dao.ROOTDAOUtils;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;
import com.huateng.report.imports.common.Constants;
import com.huateng.report.imports.model.Constant;
import com.huateng.report.imports.operation.ImportFileOP;

public class ImportFileModImportUpdate extends BaseUpdate {

	@Override
	public UpdateReturnBean saveOrUpdate(
			MultiUpdateResultBean multiUpdateResultBean,
			HttpServletRequest request, HttpServletResponse response)
			throws AppException {
		try {
			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			UpdateResultBean updateResultBean = multiUpdateResultBean
					.getUpdateResultBeanByID("ImportFileLog");
			
			Constant constant = new Constant();
			BiImportLog bean = null;
			while (updateResultBean.hasNext()) {
				Map<String, String> map = updateResultBean.next();
				bean = new BiImportLog();
				mapToObject(bean, map);
//				bean.setBeginTime(null);
//				bean.setEndTime(null);
				bean = ROOTDAOUtils.getROOTDAO().query(BiImportLog.class, bean.getId());
				OperationContext oc = new OperationContext();
				oc.setAttribute(ImportFileOP.CMD, ImportFileOP.DO_MOD_IMPORT);
				oc.setAttribute(ImportFileOP.PARAM, bean);
				oc.setAttribute(ImportFileOP.PROGRESS, constant);
				OPCaller.call(ImportFileOP.ID, oc);
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
