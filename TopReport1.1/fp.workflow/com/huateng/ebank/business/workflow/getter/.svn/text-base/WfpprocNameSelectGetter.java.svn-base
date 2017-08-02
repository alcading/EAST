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
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

/**
 * @author 4ire4ox
 *
 */
public class WfpprocNameSelectGetter extends BaseGetter {

	/* (non-Javadoc)
	 * @see com.huateng.commquery.process.call._CallGetter#call()
	 */
	
	public Result call() throws AppException {
		// TODO Auto-generated method stub
		try {

		    List resultlist = new ArrayList();

		    
            String[] templateName=WorkFlowConfig.getValue("templateName").split(",");
            String[] processName = WorkFlowConfig.getValue("processName").split(",");
            for(int i=0;i<templateName.length;i++){
            	WorkFlowParamSelectBean wfpSelectBean=new WorkFlowParamSelectBean();
            	if(templateName[i].trim().equals("")){
            		continue;
            	}
            	wfpSelectBean.setProcName(processName[i].trim());
            	wfpSelectBean.setProcNameName(templateName[i].trim());
            	resultlist.add(wfpSelectBean);
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
