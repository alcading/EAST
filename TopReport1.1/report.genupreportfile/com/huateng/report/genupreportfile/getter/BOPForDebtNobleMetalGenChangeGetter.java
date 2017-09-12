package com.huateng.report.genupreportfile.getter;


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
 * 境外联行及附属机构往来
 * @author wenhao.chen
 * @version 1.0
 * 2012-8-30
 *
 * */

public class BOPForDebtNobleMetalGenChangeGetter extends BaseGetter {

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

		int pageSize = this.getResult().getPage().getEveryPage();
		int pageIndex = this.getResult().getPage().getCurrentPage();
		Map map = getCommQueryServletRequest().getParameterMap();

		String qbrNo = (String) map.get("qbrNo");
		String qactiontype = (String) map.get("qactiontype");
		String qFiller2 = (String) map.get("qFiller2");

		List<Object> objs = new ArrayList<Object>();
		StringBuilder hql = new StringBuilder(" SELECT model FROM BopCfaExdebtDs model WHERE ");

		hql.append(" model.apptype=? and model.currentfile=? and model.changeFileType= ? and model.recStatus=?");
		objs.add(TopReportConstants.REPORT_APP_TYPE_CFA);
//		objs.add(TopReportConstants.REPORT_FILE_TYPE_CFA_AS);//文件类型
		objs.add(TopReportConstants.REPORT_FILE_TYPE_CFA_AR);
		objs.add(TopReportConstants.REPORT_FILE_TYPE_CFA_AH);//变动对于的签约的文件类型
		objs.add(TopReportConstants.REPORT_RECSTATUS_05);
		if(!DataFormat.isEmpty(qbrNo)){
			hql.append(" AND model.brNo = ? ");
			objs.add(qbrNo);
		}
		if (!DataFormat.isEmpty(qactiontype)) {
			hql.append(" AND model.actiontype = ? ");
			objs.add(qactiontype);
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



//		   ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
//		   GlobalInfo gInfo = GlobalInfo.getCurrentInstance();
//		   //
//		   int pageSize = getResult().getPage().getEveryPage();
//		   //页码
//		   int pageIndex = getResult().getPage().getCurrentPage();
//		   Map map = getCommQueryServletRequest().getParameterMap();
//		   String qbrNo = (String) map.get("qbrNo");
//			String qactiontype = (String) map.get("qactiontype");
//			String qFiller2 = (String) map.get("qFiller2");
//			BopForDebtYinTuanService debtYinTuanService = BopForDebtYinTuanService.getInstance();
//			return debtYinTuanService.queryFeiOrgSaveGen("oversQuery", pageIndex, pageSize, qbrNo, qactiontype, qFiller2);
	}

}
