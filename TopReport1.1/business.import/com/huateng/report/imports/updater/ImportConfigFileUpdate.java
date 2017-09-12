package com.huateng.report.imports.updater;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import resource.bean.report.BiImportFileConfig;

import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;
import com.huateng.report.imports.operation.ImportConfigFileOperation;

/**
 * @author UU_Wu
 *
 */
public class ImportConfigFileUpdate extends BaseUpdate {

	@Override
	public UpdateReturnBean saveOrUpdate(
			MultiUpdateResultBean multiUpdateResultBean,
			HttpServletRequest request, HttpServletResponse response)
			throws AppException {
		// TODO Auto-generated method stub

			String nextUrl = "";

			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			UpdateResultBean updateResultBean = multiUpdateResultBean
					.getUpdateResultBeanByID("ImportConfig");


			List updateList = new ArrayList();
			List delList = new ArrayList();
			List insertList = new ArrayList();


			while (updateResultBean.hasNext()) {
				BiImportFileConfig importFileBean=new BiImportFileConfig();
				Map map = updateResultBean.next();
				mapToObject(importFileBean, map);
				importFileBean.setSeperator((String)map.get("seperator"));
				switch (updateResultBean.getRecodeState()) {
				case UpdateResultBean.INSERT:
					insertList.add(importFileBean);
					break;				
				case UpdateResultBean.DELETE:
					delList.add(importFileBean);
					break;
				case UpdateResultBean.MODIFY:
					updateList.add(importFileBean);
					break;
				default:
					break;
				}

			}
			OperationContext oc = new OperationContext();
			oc.setAttribute(ImportConfigFileOperation.IN_DEL, delList);
			oc.setAttribute(ImportConfigFileOperation.IN_INSERT, insertList);
			oc.setAttribute(ImportConfigFileOperation.IN_UPDATE, updateList);
			OPCaller.call("ImportConfigFileOperation", oc);
			return updateReturnBean;


	}

}
