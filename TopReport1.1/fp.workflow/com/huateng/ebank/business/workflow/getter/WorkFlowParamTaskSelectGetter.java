package com.huateng.ebank.business.workflow.getter;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.workflow.bean.WorkFlowConfig;
import com.huateng.ebank.business.workflow.bean.WorkFlowParamSelectBean;
import com.huateng.ebank.framework.util.DataFormat;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

public class WorkFlowParamTaskSelectGetter extends BaseGetter {

	public Result call() throws AppException {

		try {

			List resultlist = new ArrayList();
			String selectTemplateValue = this.getCommQueryServletRequest().getParameter("selectTemplate");
			if (!StringUtils.isEmpty(selectTemplateValue)) {
				String[] taskValue = DataFormat.trim(WorkFlowConfig.getValue(selectTemplateValue)).split(",");
				for (int i = 0; i < taskValue.length; i++) {
					WorkFlowParamSelectBean wfpSelectBean = new WorkFlowParamSelectBean();
					wfpSelectBean.setTaskName(taskValue[i]);
					String taskNameTable = DataFormat.trim(WorkFlowConfig.getValue(taskValue[i] + "_NAME"));
					wfpSelectBean.setTaskNameLable(taskNameTable);
					resultlist.add(wfpSelectBean);
				}
			}
			ResultMng.fillResultByList(getCommonQueryBean(),
					getCommQueryServletRequest(), resultlist, getResult());
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
