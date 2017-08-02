package com.huateng.report.bop.collection.getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.PageQueryCondition;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.report.common.ReportConstant;
import com.huateng.ebank.framework.util.DataFormat;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;
import com.huateng.report.constants.TopReportConstants;

/**
 * @author huangcheng
 */
@SuppressWarnings("unchecked")
public class BopDDsLoadPageGetter extends BaseGetter {
	
	public Result call() throws AppException {
		try {
			PageQueryResult pageResult = getData();
			ResultMng.fillResultByList(getCommonQueryBean(),
					getCommQueryServletRequest(), pageResult.getQueryResult(),
					getResult());
			result.setContent(pageResult.getQueryResult());
			result.getPage().setTotalPage(
					pageResult.getPageCount(getResult().getPage()
							.getEveryPage()));
			result.init();
			this.setValue2DataBus(ReportConstant.QUERY_LOG_BUSI_NAME, "境内收入申报单基础信息补录页面查询");
			return result;
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}

	private PageQueryResult getData() throws CommonException {

		int pageSize = getResult().getPage().getEveryPage();
		int pageIndex = getResult().getPage().getCurrentPage();
		GlobalInfo gInfo = GlobalInfo.getCurrentInstance();
		ROOTDAO rootDAO = ROOTDAOUtils.getROOTDAO();
		PageQueryResult pageQueryResult = null;
		PageQueryCondition queryCondition = new PageQueryCondition();

		StringBuilder hql = new StringBuilder(
				" SELECT model FROM MtsBopDrDs model WHERE 1 = 1 ");
		Map<String, String> paramsMap = this.getCommQueryServletRequest().getParameterMap();
		String qworkDateStart = paramsMap.get("qworkDateStart");
		String qworkDateEnd = paramsMap.get("qworkDateEnd");
		String qrptno = paramsMap.get("qrptno");
		String qfiller2 = paramsMap.get("qfiller2");
		
		List<Object> paramentList = new ArrayList<Object>();
		if (!DataFormat.isEmpty(qworkDateStart)) {
			hql.append(" AND model.workDate >= ? ");
			paramentList.add(qworkDateStart);
		}
		if (!DataFormat.isEmpty(qworkDateEnd)) {
			hql.append(" AND model.workDate <= ? ");
			paramentList.add(qworkDateEnd);
		}
		if (!DataFormat.isEmpty(qrptno)) {
			hql.append(" AND model.rptno like ? ");
			paramentList.add("%" + qrptno + "%");
		}
		if (!DataFormat.isEmpty(qfiller2)) {
			hql.append(" AND model.filler2 LIKE ? ");
			paramentList.add("%" + qfiller2 + "%");
		}

		hql.append(" AND model.brNo = ? ");
		paramentList.add(gInfo.getBrno());

		hql.append(" AND model.apptype = ? ");
		paramentList.add(TopReportConstants.REPORT_APP_TYPE_BOP);

		hql.append(" AND model.currentfile= ? ");
		paramentList.add(TopReportConstants.REPORT_FILE_TYPE_BOP_D);		
		hql.append(" AND  model.actiontype <>'"+TopReportConstants.REPORT_ACTIONTYPE_D+"'");
	
		hql.append(" ORDER BY model.workDate, model.actiontype, model.approveStatus DESC");
		queryCondition.setQueryString(hql.toString());
		queryCondition.setPageIndex(pageIndex);
		queryCondition.setPageSize(pageSize);
		queryCondition.setObjArray(paramentList.toArray());
		pageQueryResult = rootDAO.pageQueryByQL(queryCondition);

	    return pageQueryResult;
	}
}