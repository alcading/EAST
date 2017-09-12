package com.huateng.report.dataquery.getter;

import java.util.Map;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.report.common.ReportConstant;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;
import com.huateng.report.dataquery.service.BopCfaStrdeDsQueryService;


/**
 * @author zhuhongyong
 * for BopCfaStrdeDs (签约信息,终止信息,利息给付信息)
 *	
 */
public class BopCfaStrdeDsQueryGetter extends BaseGetter {
	
	public static final String GET_TYPE_CONTRACT = "contract";
	public static final String GET_TYPE_TERMINATE = "terminate";
	public static final String GET_TYPE_INPAY = "inpay";
	
	@Override
	public Result call() throws AppException {
		// TODO Auto-generated method stub
		try {
			PageQueryResult pageResult = getData();
			String getType = this.getCommQueryServletRequest().getParameter("getType");
			String logValue="";
			if(GET_TYPE_CONTRACT.equalsIgnoreCase(getType)) logValue = "商业银行人民币结构性存款签约信息查询";
			if(GET_TYPE_TERMINATE.equalsIgnoreCase(getType)) logValue="商业银行人民币结构性存款终止信息查询";
			if(GET_TYPE_INPAY.equalsIgnoreCase(getType)) logValue="商业银行人民币结构性存款利息给付信息查询";
			this.setValue2DataBus(ReportConstant.QUERY_LOG_BUSI_NAME, logValue);
			ResultMng.fillResultByList(
				getCommonQueryBean(),
				getCommQueryServletRequest(),
				pageResult.getQueryResult(),
				getResult());
			result.setContent(pageResult.getQueryResult());
			result.getPage().setTotalPage(pageResult.getPageCount(getResult().getPage().getEveryPage()));
			result.init();
			return result;
		}catch(AppException appEx){
			throw appEx;
		}catch(Exception ex){
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(),ex);
		}
	}

	private PageQueryResult getData() throws CommonException {
		// TODO Auto-generated method stub
		Map<String,String> map = this.getCommQueryServletRequest().getParameterMap();
		String qbrNo = map.get("qbrNo");
		String qworkDateStart = map.get("qworkDateStart");
		String qworkDateEnd = map.get("qworkDateEnd");
		String qactiontype = map.get("qactiontype");
		String qrecStatus = map.get("qrecStatus");
		String qapproveStatus = map.get("qapproveStatus");
		String qrepStatus = map.get("qrepStatus");
		String qfiller2 = map.get("qfiller2");
		//页面标识(判断哪个页面传来的参数)
		String getType = map.get("getType");
		int pageSize = this.getResult().getPage().getEveryPage();
		int pageIndex = this.getResult().getPage().getCurrentPage();
		return BopCfaStrdeDsQueryService.getInstance().pageQueryByQL(getType,qbrNo,qworkDateStart,qworkDateEnd,qactiontype,qrecStatus,qapproveStatus,qrepStatus,qfiller2,pageSize,pageIndex);
	}

}
