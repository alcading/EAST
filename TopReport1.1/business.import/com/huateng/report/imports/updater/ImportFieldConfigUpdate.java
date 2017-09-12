package com.huateng.report.imports.updater;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import resource.bean.report.BiImportFieldConfig;

import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;
import com.huateng.report.imports.operation.ImportFieldConfigOperation;

/**
 * @author UU_Wu
 *
 */
public class ImportFieldConfigUpdate extends BaseUpdate {

	@Override
	public UpdateReturnBean saveOrUpdate(
			
			MultiUpdateResultBean multiUpdateResultBean,
			HttpServletRequest request, HttpServletResponse response)
			throws AppException {
		// TODO Auto-generated method stub

			String nextUrl = "";

			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			UpdateResultBean updateResultBean = multiUpdateResultBean
					.getUpdateResultBeanByID("ImportFieldConfig");


			List updateList = new ArrayList();
			List delList = new ArrayList();
			List insertList = new ArrayList();


			while (updateResultBean.hasNext()) {
				BiImportFieldConfig importFieldBean=new BiImportFieldConfig();
				Map map = updateResultBean.next();
				mapToObject(importFieldBean, map);

				switch (updateResultBean.getRecodeState()) {
				case UpdateResultBean.INSERT:
					insertList.add(importFieldBean);
					break;				
				case UpdateResultBean.DELETE:
					delList.add(importFieldBean);
					break;
				case UpdateResultBean.MODIFY:
					updateList.add(importFieldBean);
					break;
				default:
					break;
				}

			}
			OperationContext oc = new OperationContext();
			oc.setAttribute(ImportFieldConfigOperation.IN_DEL, delList);
			oc.setAttribute(ImportFieldConfigOperation.IN_INSERT, insertList);
			oc.setAttribute(ImportFieldConfigOperation.IN_UPDATE, updateList);
			OPCaller.call("ImportFieldConfigOperation", oc);
			return updateReturnBean;


	}

}
