package com.huateng.report.common.getter;

import java.util.List;
import java.util.Map;

import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;
import com.huateng.report.common.bean.ReportApproveResultBean;
import com.huateng.report.constants.TopReportConstants;

/**
 *
 * @author shishu.zhang
 *
 * 2012-8-15上午10:54:59
 */
public class ReportApproveResultGetter extends BaseGetter {

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
	
	public PageQueryResult getData() throws CommonException{
		Map map = getCommQueryServletRequest().getParameterMap();
		PageQueryResult queryResult = new PageQueryResult();
		String id = (String) map.get("id");
		String appType = (String) map.get("appType");
		String currentfile = (String) map.get("currentfile");
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		String queryModelName = "";
		if (appType.equals(TopReportConstants.REPORT_APP_TYPE_ACC) && currentfile.startsWith("C")) {
			queryModelName = "BopAccDs";
		} else if (appType.equals(TopReportConstants.REPORT_APP_TYPE_CFA)){
			if(currentfile.startsWith("A")) {
				queryModelName = "BopCfaExdebtDs";
			} else if(currentfile.startsWith("B")){
				queryModelName = "BopCfaExguDs";
			} else if (currentfile.startsWith("C")) {
				queryModelName = "BopCfaDofoexloDs";
			} else if (currentfile.startsWith("D")) {
				queryModelName = "BopCfaLounexguDs";
			} else if (currentfile.startsWith("E")) {
				queryModelName = "BopCfaExplrmbloDs";
			} else if (currentfile.startsWith("F")) {
				queryModelName = "BopCfaStrdeDs";
			}
		}
		String hql = "from " + queryModelName + " model where model.id = '" + id + "'";
		List<ReportApproveResultBean> list = rootdao.queryByQL2List(hql);
		queryResult.setQueryResult(list);
		return queryResult;
	}
}
