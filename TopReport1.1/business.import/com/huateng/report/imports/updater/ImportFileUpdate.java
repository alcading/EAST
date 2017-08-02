package com.huateng.report.imports.updater;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.util.ApplicationContextUtils;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;
import com.huateng.report.imports.bean.ImportFileBean;
import com.huateng.report.imports.common.Constants;
import com.huateng.report.imports.model.Constant;
import com.huateng.report.imports.operation.ImportFileOP;

public class ImportFileUpdate extends BaseUpdate {

	private static Logger logger = Logger.getLogger(ImportFileUpdate.class
			.getName());

	@Override
	public UpdateReturnBean saveOrUpdate(
			MultiUpdateResultBean multiUpdateResultBean,
			HttpServletRequest request, HttpServletResponse response)
			throws AppException {
		List<Constant> progress = new ArrayList<Constant>();
		setSessionObject(Constants.PROGRESS, progress);
		Constant pv = null;
		try {
			String isImporting = (String) getSessionObject(Constants.IS_IMPORTING);

			// 是否正在导入
			if (Constants.YES.equals(isImporting)) {
				ExceptionUtil.throwCommonException("EIMP001");
			}

			// 开始导入
			setSessionObject(Constants.IS_IMPORTING, Constants.YES);

			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			UpdateResultBean updateResultBean = multiUpdateResultBean
					.getUpdateResultBeanByID("ImportFile");

			ImportFileBean bean = null;
			while (updateResultBean.hasNext()) {
				Map<String, String> map = updateResultBean.next();
				bean = new ImportFileBean();
				mapToObject(bean, map);
				bean.setSeperator((String) map.get("seperator"));
				if (bean.isSelect()) {
					pv = new Constant();
					progress.add(pv);
					try {
						OperationContext oc = new OperationContext();
						oc.setAttribute(ImportFileOP.CMD,
								ImportFileOP.DO_IMPORT);
						oc.setAttribute(ImportFileOP.PARAM, bean);
						oc.setAttribute(ImportFileOP.PROGRESS, pv);
						//OPCaller.call(ImportFileOP.ID, oc);
						BaseOperation operation = (BaseOperation) ApplicationContextUtils
						.getBean(ImportFileOP.ID);
						operation.execute(oc);
					} catch (CommonException cEx) {
						pv.errorMessage = cEx.getMessage();
					} catch (AppException appEx) {
						pv.errorMessage = appEx.getMessage();
					} catch (Exception ex) {
						pv.errorMessage = ex.getMessage();
					}
				}
			}

			return updateReturnBean;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		} finally {
			// 结束导入
			setSessionObject(Constants.IS_IMPORTING, Constants.NO);
			pv.stopFlag = true;
		}
	}
}
