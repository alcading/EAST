/**
 *
 */
package com.huateng.ebank.business.parammng.cqGetter;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.business.workflow.operation.GetTaskListOperation;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

/**
 * Title: TaskListGetter
 * Description:
 * Copyright: Copyright (c) 2008
 * Company: Shanghai Huateng Software Systems Co., Ltd.
 * @author shen_antonio
 * @version 1.1, 2008-4-1
 */
public class ForwardTaskListGetter extends BaseGetter {

	/* (non-Javadoc)
	 * @see com.huateng.commquery.process.call._CallGetter#call()
	 */

	public Result call() throws AppException {
		// TODO Auto-generated method stub
		int pageSize = 10;
		int pageIndex = 0;
		OperationContext oc = new OperationContext();
		String tlrno = (String)getCommQueryServletRequest().getParameterMap().get("tlrno");
        oc.setAttribute(GetTaskListOperation.REQ_TLRNO,tlrno);
        oc.setAttribute("Page",result.getPage());
//        oc.setAttribute(GetTaskListOperation.PAGE_INDEX,new Integer(pageIndex));
//        oc.setAttribute(GetTaskListOperation.PAGE_SIZE,new Integer(pageSize));
        OPCaller.call(GetTaskListOperation.ID, oc);
        PageQueryResult pageResult = (PageQueryResult)oc.getAttribute(GetTaskListOperation.RSP_TASK_LIST);

		ResultMng.fillResultByList(
				getCommonQueryBean(),
				getCommQueryServletRequest(),
				pageResult.getQueryResult(),
				getResult());
		result.setContent(pageResult.getQueryResult());
		result.getPage().setTotalPage(pageResult.getPageCount(getResult().getPage().getEveryPage()));
		result.init();
		return result;
	}

}
