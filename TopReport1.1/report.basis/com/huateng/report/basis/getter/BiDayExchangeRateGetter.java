package com.huateng.report.basis.getter;
import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.framework.report.common.ReportConstant;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;
import com.huateng.report.basis.service.BiDayExchangeRateService;



@SuppressWarnings("unchecked")
public class BiDayExchangeRateGetter extends BaseGetter {
	/*
	 * 获取日牌价列表
	 * @author huangcheng
	 */
	@Override
	public Result call() throws AppException {
		try {
			
			this.setValue2DataBus(ReportConstant.QUERY_LOG_BUSI_NAME, "外汇日牌价维护查询");
			
			PageQueryResult pageResult = getData();
		
			ResultMng.fillResultByList(getCommonQueryBean(),getCommQueryServletRequest(),
			pageResult.getQueryResult(),getResult());
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

			private PageQueryResult getData() {
		
			String ratecut = (String) getCommQueryServletRequest().getParameterMap()
					.get("ratecut");
			String rateDate = (String) getCommQueryServletRequest().getParameterMap()
					.get("rateDate");
			String qst=getCommQueryServletRequest().getParameter("st");
			int pageSize = this.getResult().getPage().getEveryPage();
			int pageIndex = this.getResult().getPage().getCurrentPage();
			PageQueryResult pqr= BiDayExchangeRateService.getInstance().pageQueryByHql(pageIndex, pageSize,ratecut,rateDate, qst);
			return pqr;
			}
			}



