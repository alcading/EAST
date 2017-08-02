package com.huateng.report.getter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import resource.bean.report.BopCfaExplrmbloDs;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.report.common.ReportConstant;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;
import com.huateng.report.constants.TopReportConstants;
import com.huateng.report.operation.BopCfaExplrmbloDsOperation;
import com.huateng.report.service.BopCfaExplrmbloDsService;
import com.huateng.report.utils.ReportUtils;

@SuppressWarnings("unchecked")
public class BopCfaExplrmbloDsChangeInfoGetter extends BaseGetter {

	@Override
	public Result call() throws AppException {
		try {
			PageQueryResult queryResult = getData();
			setValue2DataBus(ReportConstant.QUERY_LOG_BUSI_NAME, "外汇质押人民币贷款变动信息补录查询");
			if (!queryResult.getQueryResult().isEmpty()) {
				ResultMng.fillResultByList(getCommonQueryBean(),
						getCommQueryServletRequest(), queryResult
								.getQueryResult(), getResult());
				result.setContent(queryResult.getQueryResult());
				result.getPage().setTotalPage(
						queryResult.getPageCount(getResult().getPage()
								.getEveryPage()));
				result.init();
			} else {
				result.setContent(Collections.emptyList());
				result.getPage().setTotalPage(0);
				result.init();
			}
			return result;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}

	/**
	 * 根据输入的查询条件进行查询
	 *
	 * @return PageQueryResult：返回查询的结果集
	 * @throws CommonException
	 */
	private PageQueryResult getData() throws CommonException {

		String op = getCommQueryServletRequest().getParameter("op");
		if (StringUtils.equals(op, BopCfaExplrmbloDsOperation.OPERATION_INSERT)) {
			BopCfaExplrmbloDs bopcfa = new BopCfaExplrmbloDs();
			bopcfa.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_A);
			bopcfa.setRecStatus(TopReportConstants.REPORT_RECSTATUS_02);
			bopcfa.setApproveStatus(TopReportConstants.REPORT_APPROVESTATUS_00);
			bopcfa.setRepStatus(TopReportConstants.REPORT_APPROVESTATUS_00);
			bopcfa.setSubSuccess(TopReportConstants.REPORT_IS_SUB_SUCCESS_NO);
			bopcfa.setApptype(TopReportConstants.REPORT_APP_TYPE_CFA);
			bopcfa.setCurrentfile(TopReportConstants.REPORT_FILE_TYPE_CFA_EB);
			bopcfa.setChangeno(ReportUtils.getTempStr(null, 4));//生成变动编号
			bopcfa.setCrtTm(new Date());

			GlobalInfo ginfo = GlobalInfo.getCurrentInstance();
			bopcfa.setCreditorcode(ginfo.getBrno());// 设置债权人代码

			List<BopCfaExplrmbloDs> list = new ArrayList<BopCfaExplrmbloDs>(1);
			list.add(bopcfa);
			PageQueryResult queryResult = new PageQueryResult();
			queryResult.setQueryResult(list);
			queryResult.setTotalCount(list.size());
			return queryResult;
		} else if (StringUtils.equals(op, BopCfaExplrmbloDsOperation.OPERATION_MODIFY)
				|| StringUtils.equals(op, BopCfaExplrmbloDsOperation.OPERATION_DELETE)
				|| StringUtils.equals(op, BopCfaExplrmbloDsOperation.OPERATION_DETAIL)) {
			String id = getCommQueryServletRequest().getParameter("id");

			BopCfaExplrmbloDsService service = BopCfaExplrmbloDsService.getInstance();
			List<BopCfaExplrmbloDs> list = new ArrayList<BopCfaExplrmbloDs>(1);
			BopCfaExplrmbloDs bopcfa = service.loadChangeInfo(id);
			if (null != bopcfa) {
				if (StringUtils.equals(op, BopCfaExplrmbloDsOperation.OPERATION_MODIFY)){
					if (StringUtils.equals(bopcfa.getSubSuccess(), TopReportConstants.REPORT_IS_SUB_SUCCESS_NO)) {
						bopcfa.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_A);
					} else {
						bopcfa.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_C);
					}
				} else if (StringUtils.equals(op, BopCfaExplrmbloDsOperation.OPERATION_DELETE)) {
					bopcfa.setActiontype(TopReportConstants.REPORT_ACTIONTYPE_D);
				}
				if(StringUtils.equals(op, BopCfaExplrmbloDsOperation.OPERATION_MODIFY)
						|| StringUtils.equals(op, BopCfaExplrmbloDsOperation.OPERATION_DELETE)){
					bopcfa.setRecStatus(TopReportConstants.REPORT_RECSTATUS_02);
					bopcfa.setRepStatus(TopReportConstants.REPORT_REPSTATUS_00);
					bopcfa.setApproveStatus(TopReportConstants.REPORT_APPROVESTATUS_00);
					if (StringUtils.equals(op, BopCfaExplrmbloDsOperation.OPERATION_MODIFY)) {
						bopcfa.setActiondesc(null);
					}
				}
				list.add(bopcfa);
			}
			PageQueryResult queryResult = new PageQueryResult();
			queryResult.setQueryResult(list);
			queryResult.setTotalCount(list.size());
			return queryResult;
		} else {
			String qworkDateStart = getCommQueryServletRequest().getParameter("qworkDateStart");
			if (StringUtils.isNotBlank(qworkDateStart)) {
				// 分页大小
				int pageSize = getResult().getPage().getEveryPage();
				// 页码
				int pageIndex = getResult().getPage().getCurrentPage();

				BopCfaExplrmbloDsService service = BopCfaExplrmbloDsService.getInstance();
				String qworkDateEnd = getCommQueryServletRequest().getParameter("qworkDateEnd");
				String actiontype = getCommQueryServletRequest().getParameter("actiontype");
				String recStatus = getCommQueryServletRequest().getParameter("recStatus");
				String approveStatus = getCommQueryServletRequest().getParameter("approveStatus");
				String repStatus = getCommQueryServletRequest().getParameter("repStatus");
				String filler2 = getCommQueryServletRequest().getParameter("filler2");

				String brno = GlobalInfo.getCurrentInstance().getBrno();

				return service.pageQueryByEdit(pageIndex, pageSize,
						TopReportConstants.REPORT_FILE_TYPE_CFA_EB, qworkDateStart,qworkDateEnd,
						actiontype, recStatus, approveStatus, repStatus,
						filler2, brno);
			} else {
				PageQueryResult presult = new PageQueryResult();
				presult.setTotalCount(0);
				presult.setQueryResult(Collections.emptyList());
				return presult;
			}
		}
	}
}