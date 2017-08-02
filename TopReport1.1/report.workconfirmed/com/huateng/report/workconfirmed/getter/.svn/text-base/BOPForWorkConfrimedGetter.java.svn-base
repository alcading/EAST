package com.huateng.report.workconfirmed.getter;

import java.util.List;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;
import com.huateng.report.dataquery.bean.SupplyEnterVerifyStateQueryBean;
import com.huateng.report.workconfirmed.service.BopForWorkConfirmedService;

public class BOPForWorkConfrimedGetter extends BaseGetter {

	@Override
	public Result call() throws AppException {
		try {
			PageQueryResult pageQueryResult = getData();

			ResultMng.fillResultByList(getCommonQueryBean(),
					getCommQueryServletRequest(), pageQueryResult.getQueryResult(),
					getResult());
			result.setContent(pageQueryResult.getQueryResult());
			result.getPage().setTotalPage(pageQueryResult.getPageCount(getResult().getPage().getEveryPage()));
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
		// 分页大小
		int pageSize = getResult().getPage().getEveryPage();
		// 页码
		int pageIndex = getResult().getPage().getCurrentPage();
		GlobalInfo gi = GlobalInfo.getCurrentInstance();
		
		String busiType = this.getCommQueryServletRequest().getParameter("busiType");
		String qappType = this.getCommQueryServletRequest().getParameter("qappType");

		List<SupplyEnterVerifyStateQueryBean> list = BopForWorkConfirmedService.getInstance().
				pageQueryByHql(gi.getTxdate().toString().replaceAll("-", ""), gi.getBrno(), busiType, qappType, "", "");
		PageQueryResult queryResult = getPageQueryResult(pageSize, pageIndex, list);
		return queryResult;
	}

	private PageQueryResult getPageQueryResult(int pageSize, int pageIndex,
			List<SupplyEnterVerifyStateQueryBean> list) {
		pageIndex -=  1;
		int startRowNum = pageIndex * pageSize;
		int endRowNum = startRowNum + pageSize > list.size() ? list.size() : startRowNum + pageSize;

		PageQueryResult queryResult = new PageQueryResult();
		queryResult.setTotalCount(list.size());
		queryResult.setQueryResult(list.subList(startRowNum, endRowNum));
		return queryResult;
	}

}
