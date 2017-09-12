package com.huateng.report.genupreportfile.getter;

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
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;
import com.huateng.report.constants.TopReportConstants;

/**
 * @author zhuhongyong 卖出回购 生成上报文件页面
 * 
 */
public class BOPForDebtSellRepurchaseGenGetter extends BaseGetter {

	public static final String CONTRACT = "contract";// 签约信息标识
	public static final String CHANGE = "change";// 变动信息标识

	@Override
	public Result call() throws AppException {
		// TODO Auto-generated method stub
		try {
			this.setValue2DataBus(ReportConstant.QUERY_LOG_BUSI_NAME, "卖出回购签约信息查询");
			PageQueryResult queryResult = getData();
			ResultMng.fillResultByList(getCommonQueryBean(),
					getCommQueryServletRequest(), queryResult.getQueryResult(),
					getResult());
			result.setContent(queryResult.getQueryResult());
			result.getPage().setTotalPage(
					queryResult.getPageCount(getResult().getPage()
							.getEveryPage()));
			result.init();
			return result;

		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}

	}

	private PageQueryResult getData() throws CommonException {
		// TODO Auto-generated method stub
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		GlobalInfo gInfo = GlobalInfo.getCurrentInstance();
		int pageSize = getResult().getPage().getEveryPage();
		int pageIndex = getResult().getPage().getCurrentPage();
		PageQueryCondition queryCondition = new PageQueryCondition();
		StringBuffer hql = new StringBuffer(
				"select bds from BopCfaExdebtDs bds where 1=1 ");
		String qBrNo = getCommQueryServletRequest().getParameter("qBrNo");
		String qActiontype = getCommQueryServletRequest().getParameter(
				"qActiontype");
		String qFiller2 = getCommQueryServletRequest().getParameter(
				"qFiller2");
		if(StringUtils.isNotBlank(qBrNo)) {
			hql.append(" and bds.brNo = '").append(qBrNo).append("'");
		}
		if (StringUtils.isNotBlank(qActiontype)) {
			hql.append(" and bds.actiontype ='").append(qActiontype)
					.append("'");
		}
		if(StringUtils.isNotBlank(qFiller2)) {
			hql.append(" and bds.filler2 like '%").append(qFiller2).append("%'");
		}
		hql.append(" and bds.apptype='"
				+ TopReportConstants.REPORT_APP_TYPE_CFA + "'");
		//区分签约信息和变动信息
		String getType = this.getCommQueryServletRequest().getParameter("getType");
		hql.append(" and bds.apptype = '"+TopReportConstants.REPORT_APP_TYPE_CFA+"'");
		if(CONTRACT.equalsIgnoreCase(getType)) {
			hql.append(" and bds.currentfile='"
				+ TopReportConstants.REPORT_FILE_TYPE_CFA_AE + "'");
		} else if(CHANGE.equalsIgnoreCase(getType)) {
			hql.append(" and bds.currentfile = '").append(TopReportConstants.REPORT_FILE_TYPE_CFA_AR+"'");
			hql.append(" and bds.changeFileType = '").append(TopReportConstants.REPORT_FILE_TYPE_CFA_AE).append("'");
		}
		hql.append(" and bds.workDate = '"+gInfo.getFileDate()+"'");
		hql.append(" order by bds.workDate,bds.approveStatus,bds.actiontype desc");
		queryCondition.setPageIndex(pageIndex);
		queryCondition.setPageSize(pageSize);
		queryCondition.setQueryString(hql.toString());
		System.out.println(hql.toString());
		return rootdao.pageQueryByQL(queryCondition);
	}
}
