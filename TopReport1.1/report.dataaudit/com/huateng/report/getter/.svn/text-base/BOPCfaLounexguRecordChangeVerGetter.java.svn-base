package com.huateng.report.getter;

import java.util.ArrayList;
import java.util.List;

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

@SuppressWarnings("unchecked")
public class BOPCfaLounexguRecordChangeVerGetter extends BaseGetter {

	public Result call() throws AppException {
		try {
			PageQueryResult list = getData();
			ResultMng.fillResultByList(getCommonQueryBean(), getCommQueryServletRequest(), list.getQueryResult(), getResult());
			result.setContent(list.getQueryResult());
			result.getPage().setTotalPage(list.getPageCount(getResult().getPage().getEveryPage()));
			result.init();
			return result;
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}


	private PageQueryResult getData() throws AppException{
		int pageIndex = getResult().getPage().getCurrentPage();
		int pageSize = getResult().getPage().getEveryPage();

		StringBuilder hqlString = new StringBuilder(" SELECT bd FROM BopCfaLounexguDs bd WHERE bd.currentfile = ? AND (bd.recStatus = ? OR  bd.recStatus = ? ) ");

		List<Object>paramentList = new ArrayList<Object>();
		paramentList.add(TopReportConstants.REPORT_FILE_TYPE_CFA_DB);
		paramentList.add(TopReportConstants.REPORT_RECSTATUS_03);
		paramentList.add(TopReportConstants.REPORT_RECSTATUS_04);

		PageQueryResult pageQueryResult = new PageQueryResult();
		String op = getCommQueryServletRequest().getParameter("op");
		if("new".equals(op)){
			//业务类型标识
			BopCfaLounexguDs bopCfaLounexguDs = new BopCfaLounexguDs();
			List<BopCfaLounexguDs>list = new ArrayList<BopCfaLounexguDs>();
			list.add(bopCfaLounexguDs);
			pageQueryResult.setQueryResult(list);

		}else if("mod".equals(op) || "del".equals(op)){
			String  id = getCommQueryServletRequest().getParameter("id");

			if(StringUtils.isNotBlank(id)){
				hqlString.append(" AND id = ? ");
				paramentList.add(id);
				PageQueryCondition pc = new PageQueryCondition();
				pc.setPageIndex(pageIndex);
				pc.setPageSize(pageSize);
				pc.setQueryString(hqlString.toString());
				pc.setObjArray(paramentList.toArray());
				HQLDAO hqlDao = DAOUtils.getHQLDAO();
				pageQueryResult = hqlDao.pageQueryByQL(pc);
			}
		}
		else{
			String qworkDate = getCommQueryServletRequest().getParameter("qworkDate");
			String eworkDate = getCommQueryServletRequest().getParameter("eworkDate");
			String qactiontype = getCommQueryServletRequest().getParameter("qactiontype");
			String qrecStatus = getCommQueryServletRequest().getParameter("qrecStatus");
			String qapproveStatus = getCommQueryServletRequest().getParameter("qapproveStatus");
			String qrepStatus = getCommQueryServletRequest().getParameter("qrepStatus");
			String qfiller2 = getCommQueryServletRequest().getParameter("qfiller2");

			setValue2DataBus(ReportConstant.QUERY_LOG_BUSI_NAME, "境外担保项下境内贷款信息审核变动及履约信息查询");
			if(StringUtils.isNotBlank(qworkDate)){
				hqlString.append(" AND bd.workDate >= ? ");
				paramentList.add(qworkDate);
			}
			if(StringUtils.isNotBlank(eworkDate)){
				hqlString.append(" AND bd.workDate <= ? ");
				paramentList.add(eworkDate);
			}
			if(StringUtils.isNotBlank(qactiontype)){
				hqlString.append(" AND bd.actiontype = ? ");
				paramentList.add(qactiontype);
			}
			if(StringUtils.isNotBlank(qrecStatus)){
				hqlString.append(" AND bd.recStatus = ? ");
				paramentList.add(qrecStatus);
			}
			if(StringUtils.isNotBlank(qapproveStatus)){
				hqlString.append(" AND bd.approveStatus = ? ");
				paramentList.add(qapproveStatus);
			}
			if(StringUtils.isNotBlank(qrepStatus)){
				hqlString.append(" AND bd.repStatus = ? ");
				paramentList.add(qrepStatus);
			}
			if(StringUtils.isNotBlank(qfiller2)){
				hqlString.append(" AND bd.filler2 LIKE ? ");
				paramentList.add("%"+qfiller2 +"%");
			}
			GlobalInfo gi = GlobalInfo.getCurrentInstance();
			if (StringUtils.isNotBlank(gi.getBrno())) {
				hqlString.append(" AND bd.brNo = ? ");
				paramentList.add(gi.getBrno());
			}
			hqlString.append(" ORDER BY bd.lstUpdTm DESC,bd.workDate, bd.actiontype, bd.approveStatus DESC ");

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