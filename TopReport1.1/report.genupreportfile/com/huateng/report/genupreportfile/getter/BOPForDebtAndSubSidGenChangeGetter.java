package com.huateng.report.genupreportfile.getter;



import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;
import com.huateng.report.service.BopForDebtYinTuanService;

/**
 * 
 * 境外联行及附属机构往来
 * @author wenhao.chen
 * @version 1.0
 * 2012-8-30
 * 
 * */

public class BOPForDebtAndSubSidGenChangeGetter extends BaseGetter {

	@Override
	public Result call() throws AppException {

		try {
			
			PageQueryResult queryResult = getData();
		
		//	HtLog logger = HtLogFactory.getLog(BOPForDebtBilLoanGetter.class);
			
		
			ResultMng.fillResultByList(getCommonQueryBean(),
					getCommQueryServletRequest(), queryResult.getQueryResult(),
					getResult());
			result.setContent(queryResult.getQueryResult());
			result.getPage().setTotalPage(queryResult.getPageCount(getResult().getPage().getEveryPage())); 
			result.init();
			return result;

		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}
	private PageQueryResult getData() throws CommonException, IllegalAccessException, InvocationTargetException
	{

		   ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		   GlobalInfo gInfo = GlobalInfo.getCurrentInstance();
		   //
		   int pageSize = getResult().getPage().getEveryPage();
		   //页码
		   int pageIndex = getResult().getPage().getCurrentPage();
		   Map map = getCommQueryServletRequest().getParameterMap();
		   String qbrNo = (String) map.get("qbrNo");
			String qactiontype = (String) map.get("qactiontype");
			String qfiller2 = (String) map.get("qfiller2");
			BopForDebtYinTuanService debtYinTuanService = BopForDebtYinTuanService.getInstance();
			return debtYinTuanService.queryFeiOrgSaveGen("overs", pageIndex, pageSize, qbrNo, qactiontype, qfiller2);
	}

}
