package com.huateng.report.dataquery.getter;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.PageQueryCondition;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.DataFormat;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;
import com.huateng.report.constants.TopReportConstants;

/**
 *
 * @author shishu.zhang
 *
 * 2012-8-15上午10:54:59
 */
@SuppressWarnings("unchecked")
public class BOPForDebtNobleMetalQueryChangeGetter extends BaseGetter {

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

	public PageQueryResult getData() throws CommonException, IllegalAccessException, InvocationTargetException{
		int pageSize = this.getResult().getPage().getEveryPage();
		int pageIndex = this.getResult().getPage().getCurrentPage();
		Map map = getCommQueryServletRequest().getParameterMap();
		String qbrNo = (String) map.get("qbrNo");
		String qworkDate = (String)map.get("qworkDate");
		String qactiontype = (String) map.get("qactiontype");
		String qrecStatus = (String) map.get("qrecStatus");
		String qapproveStatus = (String) map.get("qapproveStatus");
		String qrepStatus = (String) map.get("qrepStatus");
		String qFiller2 = (String) map.get("qFiller2");

		List<Object> objs = new ArrayList<Object>();
		StringBuilder hql = new StringBuilder(" SELECT model FROM BopCfaExdebtDs model WHERE ");

		hql.append(" model.apptype=? AND model.currentfile=? AND model.changeFileType = ? ");
		objs.add(TopReportConstants.REPORT_APP_TYPE_CFA);
//		objs.add(TopReportConstants.REPORT_FILE_TYPE_CFA_AS);//文件类型
		objs.add(TopReportConstants.REPORT_FILE_TYPE_CFA_AR);
		objs.add(TopReportConstants.REPORT_FILE_TYPE_CFA_AH);//变动对于的签约的文件类型

		if(!DataFormat.isEmpty(qbrNo)){
			hql.append(" AND model.brNo = ? ");
			objs.add(qbrNo);
		}
		if (!DataFormat.isEmpty(qworkDate)) {
			hql.append(" AND model.workDate = ? ");
			objs.add(qworkDate);
		}
		if (!DataFormat.isEmpty(qrecStatus)) {
			hql.append(" AND model.recStatus = ? ");
			objs.add(qrecStatus);
		}
		if (!DataFormat.isEmpty(qactiontype)) {
			hql.append(" AND model.actiontype = ? ");
			objs.add(qactiontype);
		}
		if (!DataFormat.isEmpty(qapproveStatus)) {
			hql.append(" AND model.approveStatus = ? ");
			objs.add(qapproveStatus);
		}
		if (!DataFormat.isEmpty(qrepStatus)) {
			hql.append(" AND model.repStatus = ? ");
			objs.add(qrepStatus);
		}
		if (!DataFormat.isEmpty(qFiller2)) {
			hql.append(" AND model.filler2 LIKE ? ");
			objs.add("%" + qFiller2 + "%");
		}
		hql.append(" order by model.lstUpdTm desc");

		PageQueryCondition queryCondition = new PageQueryCondition();
		queryCondition.setPageIndex(pageIndex);
		queryCondition.setPageSize(pageSize);
		queryCondition.setQueryString(hql.toString());
		queryCondition.setObjArray(objs.toArray());

		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		return rootdao.pageQueryByQL(queryCondition);


//		BopForDebtYinTuanService debtYinTuanService = BopForDebtYinTuanService.getInstance();
//		return debtYinTuanService.queryFeiOrgSaveQuery("oversQuery", pageIndex, pageSize, qbrNo, qrecStatus, qactiontype, qapproveStatus, qrepStatus, qFiller2, qworkDate);
	}
}
