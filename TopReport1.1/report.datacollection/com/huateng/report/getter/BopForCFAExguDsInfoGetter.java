package com.huateng.report.getter;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import resource.bean.report.BopCfaExguDs;
import resource.bean.report.BopExguTorDs;
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
import com.huateng.report.common.service.ReportCommonService;
import com.huateng.report.constants.TopReportConstants;

@SuppressWarnings("unchecked")
public class BopForCFAExguDsInfoGetter extends BaseGetter {
	/*
	 * 对外担保信息
	 *
	 * @author huangcheng
	 */
	public Result call() throws AppException {
		try {
			PageQueryResult pageResult = getData();
			setValue2DataBus(ReportConstant.QUERY_LOG_BUSI_NAME, "对外担保签约信息补录页面查询");
			ResultMng.fillResultByList(getCommonQueryBean(),
					getCommQueryServletRequest(), pageResult.getQueryResult(),
					getResult());
			result.setContent(pageResult.getQueryResult());
			result.getPage().setTotalPage(
					pageResult.getPageCount(getResult().getPage()
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

	@SuppressWarnings("rawtypes")
	private PageQueryResult getData() throws CommonException {

		int pageSize = getResult().getPage().getEveryPage();
		int pageIndex = getResult().getPage().getCurrentPage();


		StringBuilder hql = new StringBuilder(" SELECT bds FROM BopCfaExguDs bds WHERE 1 = 1 ");

		String qstartDate = getCommQueryServletRequest().getParameter("qstartDate");
		String qendDate = getCommQueryServletRequest().getParameter("qendDate");

		String qActiontype = getCommQueryServletRequest().getParameter("qActiontype");
		String qRecStatus = getCommQueryServletRequest().getParameter("qRecStatus");

		String qApproveStatus = getCommQueryServletRequest().getParameter("qApproveStatus");
		String qRepStatus = getCommQueryServletRequest().getParameter("qRepStatus");

		String qfiller2 = getCommQueryServletRequest().getParameter("qfiller2");

		List<Object> paramentList = new ArrayList<Object>();
		if (!DataFormat.isEmpty(qstartDate)) {
			hql.append(" AND bds.workDate >= ? ");
			paramentList.add(qstartDate);
		}
		if (!DataFormat.isEmpty(qendDate)) {
			hql.append(" AND bds.workDate <= ? ");
			paramentList.add(qendDate);
		}
		if (StringUtils.isNotBlank(qActiontype)) {
			hql.append(" AND bds.actiontype = ? ");
			paramentList.add(qActiontype);
		}
		if (StringUtils.isNotBlank(qRecStatus)) {
			hql.append(" AND bds.recStatus = ? ");
			paramentList.add(qRecStatus);
		}
		if (StringUtils.isNotBlank(qApproveStatus)) {
			hql.append(" AND bds.approveStatus = ? ");
			paramentList.add(qApproveStatus);
		}
		if (StringUtils.isNotBlank(qRepStatus)) {
			hql.append(" AND bds.repStatus = ? ");
			paramentList.add(qRepStatus);
		}
		if (StringUtils.isNotBlank(qfiller2)) {
			hql.append(" AND bds.filler2 LIKE ? ");
			paramentList.add("%" + qfiller2 + "%");
		}

		hql.append(" AND bds.brNo = ? ");
		GlobalInfo gInfo = GlobalInfo.getCurrentInstance();
		paramentList.add(gInfo.getBrno());

		hql.append(" AND bds.apptype = ? ");
		paramentList.add(TopReportConstants.REPORT_APP_TYPE_CFA);

		hql.append(" AND bds.currentfile= ? ");
		paramentList.add(TopReportConstants.REPORT_FILE_TYPE_CFA_BA);

		hql.append(" AND ( bds.recStatus = ? OR  bds.recStatus= ? ) ");
		paramentList.add(TopReportConstants.REPORT_RECSTATUS_01);
		paramentList.add(TopReportConstants.REPORT_RECSTATUS_02);

		hql.append(" ORDER BY bds.lstUpdTm desc , bds.workDate, bds.actiontype, bds.approveStatus DESC");

		PageQueryCondition queryCondition = new PageQueryCondition();
		queryCondition.setQueryString(hql.toString());
		queryCondition.setPageIndex(pageIndex);
		queryCondition.setPageSize(pageSize);
		queryCondition.setObjArray(paramentList.toArray());

		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		PageQueryResult pageQueryResult = rootdao.pageQueryByQL(queryCondition);

		List resultList = pageQueryResult.getQueryResult();
		for (int i = 0; i < resultList.size(); i++) {
			Object[] obs = (Object[]) resultList.get(i);
			BopCfaExguDs bopCfaExguDs = (BopCfaExguDs) obs[0];
			ReportCommonService commservice = ReportCommonService.getInstance();
			bopCfaExguDs.setBeneficiary(commservice.getBopExguTorBen(bopCfaExguDs.getId()));
			bopCfaExguDs.setGuarantore(commservice.getBopExguTorGua(bopCfaExguDs.getId()));
			List<BopExguTorDs> exguTorList = new ArrayList<BopExguTorDs>();
			exguTorList = rootdao.queryByQL2List(" FROM BopExguTorDs model WHERE model.recId= '" + bopCfaExguDs.getId().trim() + "' AND torType = '03'");
			bopCfaExguDs.setGuappname(exguTorList.get(0).getTorName());
			bopCfaExguDs.setGuappcode(exguTorList.get(0).getTorCode());
			bopCfaExguDs.setGuappnamen(exguTorList.get(0).getTorEnname());
		}
		return pageQueryResult;
	}
}