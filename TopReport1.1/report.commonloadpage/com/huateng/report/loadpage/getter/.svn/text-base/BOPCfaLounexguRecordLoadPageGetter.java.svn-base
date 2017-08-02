package com.huateng.report.loadpage.getter;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import resource.dao.base.HQLDAO;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.DAOUtils;
import com.huateng.ebank.business.common.PageQueryCondition;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;
import com.huateng.report.constants.TopReportConstants;

@SuppressWarnings("unchecked")
public class BOPCfaLounexguRecordLoadPageGetter extends BaseGetter{

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

	private PageQueryResult getData() throws CommonException{
		int pageIndex = getResult().getPage().getCurrentPage();
		int pageSize = getResult().getPage().getEveryPage();

		String workDate = getCommQueryServletRequest().getParameter("workDate");
		String qactiontype = getCommQueryServletRequest().getParameter("qactiontype");
		String qrecStatus = getCommQueryServletRequest().getParameter("qrecStatus");
		String qapproveStatus = getCommQueryServletRequest().getParameter("qapproveStatus");
		String qrepStatus = getCommQueryServletRequest().getParameter("qrepStatus");
		String qfiller2 = getCommQueryServletRequest().getParameter("qfiller2");

		StringBuilder hql = new StringBuilder(" SELECT bd FROM BopCfaLounexguDs bd WHERE bd.currentfile = ? AND bd.actiontype != ? ");
		List<Object>paramentList = new ArrayList<Object>();
		paramentList.add(TopReportConstants.REPORT_FILE_TYPE_CFA_DA);
		paramentList.add(TopReportConstants.REPORT_ACTIONTYPE_D);
		if(StringUtils.isNotBlank(workDate)){
			hql.append(" AND bd.workDate = ? ");
			paramentList.add(workDate);
		}
		if(StringUtils.isNotBlank(qactiontype)){
			hql.append(" AND bd.actiontype = ? ");
			paramentList.add(qactiontype);
		}
		if(StringUtils.isNotBlank(qrecStatus)){
			hql.append(" and bd.recStatus = ? ");
			paramentList.add(qrecStatus);
		}
		if(StringUtils.isNotBlank(qapproveStatus)){
			hql.append(" and bd.approveStatus = ? ") ;
			paramentList.add(qapproveStatus);
		}
		if(StringUtils.isNotBlank(qrepStatus)){
			hql.append(" and bd.repStatus = ? ");
			paramentList.add(qrepStatus);
		}
		if(StringUtils.isNotBlank(qfiller2)){
			hql.append(" and bd.filler2 like ? ");
			paramentList.add("%"+qfiller2 +"%");
		}
		PageQueryCondition pc = new PageQueryCondition();
		pc.setPageIndex(pageIndex);
		pc.setPageSize(pageSize);
		pc.setQueryString(hql.toString());
		pc.setObjArray(paramentList.toArray());
		HQLDAO hqlDao = DAOUtils.getHQLDAO();
		PageQueryResult pageQueryResult = hqlDao.pageQueryByQL(pc);
		return pageQueryResult;
	}
}