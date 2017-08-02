package com.huateng.ebank.business.management.getter;

import java.util.List;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.BaseDAOUtils;
import com.huateng.ebank.entity.data.workflow.WorkflowBussTempletRel;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

public class WorkflowProcNameGetter extends BaseGetter {

	@Override
	public Result call() throws AppException{
		try
		{

//			String procName = DataFormat.trim(getValueFromDataBus("TEMPLET_DESC"));
			String bussProc = this.getCommQueryServletRequest().getParameter("bussProc");
			List list = BaseDAOUtils.getWorkflowBussTempletRelDAO().queryByCondition("po.bussProc = '" + bussProc + "' order by id");
			WorkflowBussTempletRel workflowBussTempletRel = new WorkflowBussTempletRel();
			if(list != null && list.size() > 0){
				workflowBussTempletRel = (WorkflowBussTempletRel)list.get(0);
			}
				
	
			ResultMng.fillResultByObject(
					getCommonQueryBean(),
					getCommQueryServletRequest(),
					workflowBussTempletRel,
					getResult());
			result.setContent(list);
			result.getPage().setTotalPage(1);
			result.init();
			return result;
		}catch(AppException appEx){
			throw appEx;
		}catch(Exception ex){
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(),ex);
		}

	}
}
