package com.huateng.report.getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import resource.bean.report.BopAccDs;
import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.report.common.ReportConstant;
import com.huateng.ebank.framework.util.DataFormat;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;
import com.huateng.report.service.BopAccDsService;

/**
 *
 * @author shishu.zhang
 *
 * 2012-8-15上午10:54:59
 */
@SuppressWarnings("unchecked")
public class BopAccDsRecordInOutGetter extends BaseGetter {

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
		} catch (CommonException e) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, e.getMessage());
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}

	@SuppressWarnings("rawtypes")
	public PageQueryResult getData() throws AppException{
		int pageSize = getResult().getPage().getEveryPage();
		int pageIndex = getResult().getPage().getCurrentPage();
		Map map = getCommQueryServletRequest().getParameterMap();
		String op = (String) map.get("op");
		if(!DataFormat.isEmpty(op)){
			PageQueryResult queryResult = new PageQueryResult();
			String id = (String) map.get("id");
			ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
			BopAccDs bopAccDs = rootdao.query(BopAccDs.class, id);
			// 反查账户开关信息显示余页面
			BopAccDs accountBopAccDs = rootdao.query(BopAccDs.class, bopAccDs.getFiller1());
			bopAccDs.setAmtype(accountBopAccDs.getAmtype());
			bopAccDs.setEnCode(accountBopAccDs.getEnCode());
			bopAccDs.setEnName(accountBopAccDs.getEnName());
			bopAccDs.setCurrencyCode(accountBopAccDs.getCurrencyCode());
			bopAccDs.setAccountCata(accountBopAccDs.getAccountCata());
			bopAccDs.setFileNumber(accountBopAccDs.getFileNumber());
			bopAccDs.setLimitType(accountBopAccDs.getLimitType());
			bopAccDs.setAccountLimit(accountBopAccDs.getAccountLimit());
			bopAccDs.setAccountType(accountBopAccDs.getAccountType());
			if(StringUtils.equals("modify", op)){
				bopAccDs.setActiondesc(null);
			}
			List<BopAccDs> list = new ArrayList<BopAccDs>();
			list.add(bopAccDs);
			queryResult.setQueryResult(list);
			// 页面接收判断
			getCommQueryServletRequest().setParameter("op", op);
			return queryResult;
		} else {

			setValue2DataBus(ReportConstant.QUERY_LOG_BUSI_NAME, "外汇账户信息补录-账户收支余额信息查询");

			String qstartDate = (String) map.get("qstartDate");
			String qendDate = (String) map.get("qendDate");

			String qactiontype = (String) map.get("qactiontype");
			String qrecStatus = (String) map.get("qrecStatus");

			String qapproveStatus = (String) map.get("qapproveStatus");
			String qrepStatus = (String) map.get("qrepStatus");
			String qaccountno = (String) map.get("qaccountno");

			BopAccDsService bopAccDsService = BopAccDsService.getInstance();
			return bopAccDsService.queryRecordInOut(pageIndex, pageSize, qstartDate, qendDate, qactiontype, qapproveStatus, qrepStatus, qaccountno, qrecStatus);
		}
	}
}
