package com.huateng.report.workconfirmed.getter;

import java.util.ArrayList;
import java.util.List;

import resource.bean.report.BiExecConfirm;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;
import com.huateng.report.execconfirm.service.BiExecConfirmService;

public class BOPForBiExecConfirmedGetter extends BaseGetter {

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
		GlobalInfo gInfo = GlobalInfo.getCurrentInstance();
		String busiType = this.getCommQueryServletRequest().getParameter("busiType");
		String qappType = this.getCommQueryServletRequest().getParameter("qappType");
		
		BiExecConfirm biExecConfirm = BiExecConfirmService.getInstance().getBiExecConfirmByPk(busiType, qappType, gInfo.getBrno(), gInfo.getTxdate().toString().replaceAll("-", ""));
		PageQueryResult queryResult  = new PageQueryResult();
		if(biExecConfirm != null){
			List<BiExecConfirm> biExecConList = new ArrayList<BiExecConfirm>();
			biExecConList.add(biExecConfirm);
			queryResult.setQueryResult(biExecConList);
			queryResult.setTotalCount(1);
		}
		return queryResult;
	}


}
