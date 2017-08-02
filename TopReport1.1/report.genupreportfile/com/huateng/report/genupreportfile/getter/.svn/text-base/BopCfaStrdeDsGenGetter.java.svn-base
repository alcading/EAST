package com.huateng.report.genupreportfile.getter;

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
import com.huateng.report.genupreportfile.service.BopCfaStrdeDsGenService;

/**
 * @author zhuhongyong
 * 商业银行人民币结构性存款生成上报文件
 */
public class BopCfaStrdeDsGenGetter extends BaseGetter{
	
	public static final String GET_TYPE_CONTRACT = "contract";
	public static final String GET_TYPE_TERMINATE = "terminate";
	public static final String GET_TYPE_INPAY = "inpay";
	public static final String GET_TYPE_INOUTMO = "inoutMo";
	
	@Override
	public Result call() throws AppException {
		// TODO Auto-generated method stub
		try {
			PageQueryResult pageResult = getData();
			String getType = this.getCommQueryServletRequest().getParameter("getType");
			String logValue = "";
			if(GET_TYPE_CONTRACT.equalsIgnoreCase(getType)) logValue = "商业银行人民币结构性存款签约信息上报文件页面查询";
			if(GET_TYPE_TERMINATE.equalsIgnoreCase(getType)) logValue = "商业银行人民币结构性存款终止信息上报文件页面查询";
			if(GET_TYPE_INPAY.equalsIgnoreCase(getType)) logValue = "商业银行人民币结构性存款利息给付信息上报文件页面查询";
			if(GET_TYPE_INOUTMO.equalsIgnoreCase(getType)) logValue = "商业银行人民币结构性存款资金流出入和结购汇信息信息上报文件页面查询";
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
		Map<String,String> paramsMap = this.getCommQueryServletRequest().getParameterMap();
		String qactiontype = paramsMap.get("qactiontype");
		String qbrNo = paramsMap.get("qbrNo");
		String qfiller2 = paramsMap.get("qfiller2");
		String getType = paramsMap.get("getType");
		int pageSize = this.getResult().getPage().getEveryPage();
		int pageIndex = this.getResult().getPage().getCurrentPage();
		return BopCfaStrdeDsGenService.getInstance().pageQueryByHql(getType,qactiontype, qbrNo, qfiller2, pageSize, pageIndex);
	}
}
