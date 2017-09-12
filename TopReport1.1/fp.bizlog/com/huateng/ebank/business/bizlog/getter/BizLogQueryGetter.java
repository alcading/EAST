package com.huateng.ebank.business.bizlog.getter;


import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.bizlog.bean.BizLogQueryBean;
import com.huateng.ebank.business.bizlog.operation.BizLogQueryOP;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.util.DataFormat;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;




/**交易流水查询getter
 * @author JorneZhang
 * @version
 * 创建时间：2010-1-5 下午03:09:03
 */
@SuppressWarnings("unchecked")
public class BizLogQueryGetter extends BaseGetter {

	@Override
	public Result call() throws AppException {
		OperationContext context = new OperationContext();
		Integer pageSize = new Integer(getResult().getPage().getEveryPage());
		Integer pageIndex = new Integer(getResult().getPage().getCurrentPage());

		String tlrno = DataFormat.trim(this.getCommQueryServletRequest().getParameter("tlrno"));
		String branchId = DataFormat.trim(this.getCommQueryServletRequest().getParameter("branchId"));
		String txnDateStart = DataFormat.trim(this.getCommQueryServletRequest().getParameter("txnDateStart"));
		String txnDateEnd = DataFormat.trim(this.getCommQueryServletRequest().getParameter("txnDateEnd"));
		String bizFuncType = DataFormat.trim(this.getCommQueryServletRequest().getParameter("bizFuncType"));

		BizLogQueryBean bean = new BizLogQueryBean();
		bean.setTlrno(tlrno);
		bean.setBranchId(branchId);
		bean.setTxnDateStart(txnDateStart);
		bean.setTxnDateEnd(txnDateEnd);
		bean.setBizFuncType(bizFuncType);

		//设置OP命令状态为查询
		context.setAttribute(BizLogQueryOP.CMDTYPE, BizLogQueryOP.CMD_QUERY);
		context.setAttribute(BizLogQueryOP.IN_PAGESIZE, pageSize);
		context.setAttribute(BizLogQueryOP.IN_PAGEINDEX, pageIndex);
		context.setAttribute(BizLogQueryOP.IN_BEAN, bean);
		OPCaller.call(BizLogQueryOP.ID, context);
		//得到返回值
		PageQueryResult list= (PageQueryResult)context.getAttribute(BizLogQueryOP.OUT_LIST);
		ResultMng.fillResultByList(getCommonQueryBean(),getCommQueryServletRequest(),list.getQueryResult(),getResult());
		result.getPage().setTotalPage(list.getPageCount(result.getPage().getEveryPage()));
		result.init();
		return result;
	}

}
