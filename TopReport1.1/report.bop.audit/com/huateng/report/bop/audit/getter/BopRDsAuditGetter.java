package com.huateng.report.bop.audit.getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

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
 * 境内收入申报单管理信息审核查询
 * @author huangcheng
 */
@SuppressWarnings("unchecked")
public class BopRDsAuditGetter extends BaseGetter {
	
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
			this.setValue2DataBus(ReportConstant.QUERY_LOG_BUSI_NAME, "境内收入申报单管理信息审核页面查询");
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
	
		Map<String, String> map = getCommQueryServletRequest().getParameterMap();
		String qworkDateStart = map.get("qworkDateStart");
		String qworkDateEnd = map.get("qworkDateEnd");
		String qactiontype = map.get("qactiontype");
		String qrecStatus = map.get("qrecStatus");
		String qapproveStatus = map.get("qapproveStatus");
		String qrepStatus = map.get("qrepStatus");
		String qfiller2 = map.get("qfiller2");

		List<Object> paramentList = new ArrayList<Object>();
		if (!DataFormat.isEmpty(qworkDateStart)) {
			hql.append(" AND model.workDate >= ? ");
			paramentList.add(qworkDateStart);
		}
		if (!DataFormat.isEmpty(qworkDateEnd)) {
			hql.append(" AND model.workDate <= ? ");
			paramentList.add(qworkDateEnd);
		}
		if (StringUtils.isNotBlank(qactiontype)) {
			hql.append(" AND model.actiontype = ? ");
			paramentList.add(qactiontype);
		}
		if (StringUtils.isNotBlank(qrecStatus)) {
			hql.append(" AND model.recStatus = ? ");
			paramentList.add(qrecStatus);
		}
		if (StringUtils.isNotBlank(qapproveStatus)) {
			hql.append(" AND model.approveStatus = ? ");
			paramentList.add(qapproveStatus);
		}
		if (StringUtils.isNotBlank(qrepStatus)) {
			hql.append(" AND model.repStatus = ? ");
			paramentList.add(qrepStatus);
		}
		if (StringUtils.isNotBlank(qfiller2)) {
			hql.append(" AND model.filler2 LIKE ? ");
			paramentList.add("%" + qfiller2 + "%");
		}

		hql.append(" AND model.brNo = ? ");
		paramentList.add(gInfo.getBrno());
		hql.append(" AND model.apptype = ? ");
		paramentList.add(TopReportConstants.REPORT_APP_TYPE_BOP);
		hql.append(" AND model.currentfile= ? ");
		paramentList.add(TopReportConstants.REPORT_FILE_TYPE_BOP_R);
		hql.append(" AND ( model.recStatus = ? OR  model.recStatus= ? ) ");
		paramentList.add(TopReportConstants.REPORT_RECSTATUS_03);
		paramentList.add(TopReportConstants.REPORT_RECSTATUS_04);

		hql.append(" ORDER BY model.lstUpdTm DESC");
		queryCondition.setQueryString(hql.toString());
		queryCondition.setPageIndex(pageIndex);
		queryCondition.setPageSize(pageSize);
		queryCondition.setObjArray(paramentList.toArray());
		pageQueryResult = rootDAO.pageQueryByQL(queryCondition);

	    return pageQueryResult;
	}
}