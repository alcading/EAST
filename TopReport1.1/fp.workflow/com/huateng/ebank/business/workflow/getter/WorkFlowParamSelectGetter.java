/**
 *
 */
package com.huateng.ebank.business.workflow.getter;

import java.util.ArrayList;
import java.util.List;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.workflow.bean.WorkFlowConfig;
import com.huateng.ebank.business.workflow.bean.WorkFlowParamSelectBean;
import com.huateng.ebank.framework.util.DataFormat;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

/**
 * @author user
 *
 */
public class WorkFlowParamSelectGetter extends BaseGetter {

	/* (non-Javadoc)
	 * @see com.huateng.commquery.process.call._CallGetter#call()
	 */
	@Override
	public Result call() throws AppException {
		try {

	        List resultlist = new ArrayList();

            String[] template=DataFormat.trim(WorkFlowConfig.getValue("PROCESS.TEMPLATGE.LIST")).split(",");
            for(int i=0;i<template.length;i++){
            	WorkFlowParamSelectBean wfpSelectBean=new WorkFlowParamSelectBean();
            	wfpSelectBean.setProcessTemplate(template[i]);
            	String templateName=DataFormat.trim(WorkFlowConfig.getValue(template[i]+"_NAME"));
            	wfpSelectBean.setProcessTemplateName(templateName);
            	resultlist.add(wfpSelectBean);
            }

	        ResultMng.fillResultByList(getCommonQueryBean(),
					getCommQueryServletRequest(), resultlist,
					getResult());
	        result.setContent(resultlist);
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
