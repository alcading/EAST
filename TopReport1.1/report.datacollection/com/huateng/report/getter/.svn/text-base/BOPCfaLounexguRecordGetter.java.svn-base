package com.huateng.report.getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import resource.bean.report.BopCfaLounexguDs;
import resource.dao.base.HQLDAO;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.DAOUtils;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.PageQueryCondition;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.framework.report.common.ReportConstant;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;
import com.huateng.report.constants.TopReportConstants;
import com.huateng.report.utils.ReportUtils;

@SuppressWarnings("unchecked")
public class BOPCfaLounexguRecordGetter extends BaseGetter {

	public Result call() throws AppException {
		try {
			PageQueryResult list = getData();
			ResultMng.fillResultByList(getCommonQueryBean(),
					getCommQueryServletRequest(), list.getQueryResult(),
					getResult());
			result.setContent(list.getQueryResult());
			result.getPage().setTotalPage(
					list.getPageCount(getResult().getPage().getEveryPage()));
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
	private PageQueryResult getData() throws AppException {
		int pageIndex = getResult().getPage().getCurrentPage();
		int pageSize = getResult().getPage().getEveryPage();

		StringBuilder hqlString = new StringBuilder(" SELECT bd FROM BopCfaLounexguDs bd WHERE 1 = 1 ");

		List<Object>paramentList = new ArrayList<Object>();
		hqlString.append(" AND bd.currentfile = ? ");
		paramentList.add(TopReportConstants.REPORT_FILE_TYPE_CFA_DA);
		PageQueryResult pageQueryResult = new PageQueryResult();
		String op = getCommQueryServletRequest().getParameter("op");
		if ("new".equals(op)) {
			// 业务类型标识
			String bsType = TopReportConstants.REPORT_FILE_TYPE_CFA_DA;
			// 机构号
			GlobalInfo gb = GlobalInfo.getCurrentInstance();
			String creditorcode = gb.getBrno();
			String lounexgucode = ReportUtils.getBussinessNo(bsType);

			Map<String, String> map = new HashMap<String, String>();
			map.put("lounexgucode", lounexgucode);
			map.put("creditorcode", creditorcode);

			List list = new ArrayList();
			list.add(map);
			pageQueryResult.setQueryResult(list);

		} else if ("mod".equals(op) || "del".equals(op) || "detail".equalsIgnoreCase(op) || "delInfo".equalsIgnoreCase(op)) {
			String id = getCommQueryServletRequest().getParameter("id");
			if (StringUtils.isNotBlank(id)) {
				hqlString.append(" AND id = ? ");
				paramentList.add(id);
				PageQueryCondition pc = new PageQueryCondition();
				pc.setPageIndex(pageIndex);
				pc.setPageSize(pageSize);
				pc.setObjArray(paramentList.toArray());
				pc.setQueryString(hqlString.toString());
				HQLDAO hqlDao = DAOUtils.getHQLDAO();
				pageQueryResult = hqlDao.pageQueryByQL(pc);

				if (StringUtils.equals("mod", op)) {
					if (!pageQueryResult.getQueryResult().isEmpty()) {
						Object[] values = (Object[])pageQueryResult.getQueryResult().get(0);
						BopCfaLounexguDs lounexgu = (BopCfaLounexguDs) values[0];
						lounexgu.setActiondesc(null);
					}
				}
			}
		} else {
			String workDateStart = getCommQueryServletRequest().getParameter("workDateStart");
			String workDateEnd = getCommQueryServletRequest().getParameter("workDateEnd");
			String qactiontype = getCommQueryServletRequest().getParameter("qactiontype");
			String qrecStatus = getCommQueryServletRequest().getParameter("qrecStatus");
			String qapproveStatus = getCommQueryServletRequest().getParameter("qapproveStatus");
			String qrepStatus = getCommQueryServletRequest().getParameter("qrepStatus");
			String qfiller2 = getCommQueryServletRequest().getParameter("qfiller2");

			setValue2DataBus(ReportConstant.QUERY_LOG_BUSI_NAME,"境外担保项下境内贷款信息补录签约信息查询");
			hqlString.append(" AND (bd.recStatus = ? OR bd.recStatus = ? ) ");
			paramentList.add(TopReportConstants.REPORT_RECSTATUS_01);
			paramentList.add(TopReportConstants.REPORT_RECSTATUS_02);


			if (StringUtils.isNotBlank(workDateStart)) {
				hqlString.append(" AND bd.workDate >= ? ");
				paramentList.add(workDateStart);
			}
			if (StringUtils.isNotBlank(workDateEnd)) {
				hqlString.append(" AND bd.workDate <= ? ");
				paramentList.add(workDateEnd);
			}
			if (StringUtils.isNotBlank(qactiontype)) {
				hqlString.append(" AND bd.actiontype = ? ");
				paramentList.add(qactiontype);
			}
			if (StringUtils.isNotBlank(qrecStatus)) {
				hqlString.append(" AND bd.recStatus = ? ");
				paramentList.add(qrecStatus);
			}
			if (StringUtils.isNotBlank(qapproveStatus)) {
				hqlString.append(" AND bd.approveStatus = ? ");
				paramentList.add(qapproveStatus);
			}
			if (StringUtils.isNotBlank(qrepStatus)) {
				hqlString.append(" AND bd.repStatus = ? ");
				paramentList.add(qrepStatus);
			}
			if (StringUtils.isNotBlank(qfiller2)) {
				hqlString.append(" AND bd.filler2 LIKE ? ");
				paramentList.add("%" + qfiller2 + "%");
			}

			GlobalInfo gi = GlobalInfo.getCurrentInstance();
			if (StringUtils.isNotBlank(gi.getBrno())) {
				hqlString.append(" AND bd.brNo = ? ");
				paramentList.add(gi.getBrno());
			}
			hqlString.append(" ORDER BY bd.lstUpdTm DESC, bd.workDate, bd.actiontype, bd.approveStatus DESC ");

			PageQueryCondition pc = new PageQueryCondition();
			pc.setPageIndex(pageIndex);
			pc.setPageSize(pageSize);
			pc.setQueryString(hqlString.toString());
			pc.setObjArray(paramentList.toArray());
			HQLDAO hqlDao = DAOUtils.getHQLDAO();
			pageQueryResult = hqlDao.pageQueryByQL(pc);
		}
		return pageQueryResult;
	}
}
