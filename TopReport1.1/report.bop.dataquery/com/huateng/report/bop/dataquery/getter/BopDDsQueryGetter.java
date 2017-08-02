package com.huateng.report.bop.dataquery.getter;

import java.util.Map;
import org.apache.commons.lang.StringUtils;
import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;
import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.PageQueryCondition;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.report.common.ReportConstant;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;
import com.huateng.report.constants.TopReportConstants;

/**
 * 境内收入基础信息查询
 * @author huangcheng
 */
@SuppressWarnings("unchecked")
public class BopDDsQueryGetter extends BaseGetter {
	
	@Override
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
			this.setValue2DataBus(ReportConstant.QUERY_LOG_BUSI_NAME, "境内收入申报单基础信息查询页面查询");
			return result;
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}

	private PageQueryResult getData() throws CommonException {
		Map<String, String> paramMap = this.getCommQueryServletRequest().getParameterMap();
		int pageSize = this.getResult().getPage().getEveryPage();
		int pageIndex = this.getResult().getPage().getCurrentPage();
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();	
		PageQueryResult pageQueryResult = null;
		PageQueryCondition queryCondition = new PageQueryCondition();
		
		String hql ="select model from MtsBopDrDs model where 1=1 ";

		String qbrNo = paramMap.get("qbrNo");
		String qworkDateStart = paramMap.get("qworkDateStart");
		String qworkDateEnd = paramMap.get("qworkDateEnd");
		String qactiontype = paramMap.get("qactiontype");
		String qrecStatus = paramMap.get("qrecStatus");
		String qapproveStatus = paramMap.get("qapproveStatus");
		String qrepStatus = paramMap.get("qrepStatus");
		String qfiller2 = paramMap.get("qfiller2");

		if (StringUtils.isNotBlank(qworkDateStart)) {
			hql += " and model.workDate >='" + qworkDateStart + "'";
		}
		if (StringUtils.isNotBlank(qworkDateEnd)) {
			hql += " and model.workDate <='" + qworkDateEnd + "'";
		}
		if (StringUtils.isNotBlank(qactiontype)) {
			hql += " and model.actiontype ='" + qactiontype + "'";
		}
		if (StringUtils.isNotBlank(qrecStatus)) {
			hql += " and model.recStatus ='" + qrecStatus + "'";
		}
		if (StringUtils.isNotBlank(qapproveStatus)) {
			hql += " and model.approveStatus ='" + qapproveStatus + "'";
		}
		if (StringUtils.isNotBlank(qrepStatus)) {
			hql += " and model.repStatus ='" + qrepStatus + "'";
		}
		if (StringUtils.isNotBlank(qfiller2)) {
			hql += " and model.filler2 like '%" + qfiller2 + "%'";
		}
		if (StringUtils.isNotBlank(qbrNo)) {
			hql += " and model.brNo ='" + qbrNo + "'";
		}

		hql += " and model.apptype='" + TopReportConstants.REPORT_APP_TYPE_BOP
				+ "'";
		hql += " and model.currentfile='"
				+ TopReportConstants.REPORT_FILE_TYPE_BOP_D + "'";
		hql += " order by model.workDate,model.approveStatus,model.actiontype desc";
		queryCondition.setQueryString(hql);
		queryCondition.setPageIndex(pageIndex);
		queryCondition.setPageSize(pageSize);
		pageQueryResult = rootdao.pageQueryByQL(queryCondition);
		return pageQueryResult;
	}
}
