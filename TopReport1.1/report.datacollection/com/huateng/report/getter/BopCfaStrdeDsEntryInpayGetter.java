package com.huateng.report.getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import resource.dao.base.HQLDAO;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.PageQueryCondition;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.business.management.common.DAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.report.common.ReportConstant;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;
import com.huateng.report.constants.TopReportConstants;

@SuppressWarnings("unchecked")
public class BopCfaStrdeDsEntryInpayGetter extends BaseGetter {

	public Result call() throws AppException {
		try {
			PageQueryResult pageResult = getData();
			setValue2DataBus(ReportConstant.QUERY_LOG_BUSI_NAME, "商业银行人民币结构性存款补录利息给付信息查询");
			ResultMng.fillResultByList(
				getCommonQueryBean(),
				getCommQueryServletRequest(),
				pageResult.getQueryResult(),
				getResult());
			result.setContent(pageResult.getQueryResult());
			result.getPage().setTotalPage(pageResult.getPageCount(getResult().getPage().getEveryPage()));
			result.init();
			return result;
		}catch(AppException appEx){
			throw appEx;
		}catch(Exception ex){
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(),ex);
		}
	}

	@SuppressWarnings("rawtypes")
	private PageQueryResult getData() throws CommonException {

		int pageSize = getResult().getPage().getEveryPage();
		int pageIndex = getResult().getPage().getCurrentPage();
		Map paramsMap = getCommQueryServletRequest().getParameterMap();
		String qworkDateStart = (String) paramsMap.get("qworkDateStart");
		String qworkDateEnd = (String) paramsMap.get("qworkDateEnd");
		String qactiontype = (String) paramsMap.get("qactiontype");
		String qrecStatus = (String) paramsMap.get("qrecStatus");
		String qapproveStatus = (String) paramsMap.get("qapproveStatus");
		String qrepStatus = (String) paramsMap.get("qrepStatus");
		String qfiller2 = (String) paramsMap.get("qfiller2");
		//机构号
		GlobalInfo globalInfo = GlobalInfo.getCurrentInstance();
		String brNo = globalInfo.getBrno();

		List<Object>paramentList = new ArrayList<Object>();
		StringBuffer buff = new StringBuffer();
		buff.append(" FROM BopCfaStrdeDs strde WHERE 1 = 1 ");
		if(StringUtils.isNotBlank(qworkDateStart)) {
			buff.append(" AND strde.workDate >= ? ");
			paramentList.add(qworkDateStart);
		}
		if(StringUtils.isNotBlank(qworkDateEnd)) {
			buff.append(" and strde.workDate <= ? ");
			paramentList.add(qworkDateEnd);
		}
		if(StringUtils.isNotBlank(qactiontype)) {
			buff.append(" and strde.actiontype = ? ");
			paramentList.add(qactiontype);
		}

		if(StringUtils.isNotBlank(qrecStatus)) {
			buff.append(" and strde.recStatus = ? ");
			paramentList.add(qrecStatus);
		}

		if(StringUtils.isNotBlank(qapproveStatus)) {
			buff.append(" and strde.approveStatus = ? ");
			paramentList.add(qapproveStatus);
		}
		if(StringUtils.isNotBlank(qrepStatus)) {
			buff.append(" and strde.repStatus = ? ");
			paramentList.add(qrepStatus);
		}
		if(StringUtils.isNotBlank(qfiller2)) {
			buff.append(" and strde.filler2 like ? ");
			paramentList.add("%"+qfiller2+"%");
		}
		buff.append(" AND (strde.recStatus = ? OR strde.recStatus = ? ) ");
		paramentList.add(TopReportConstants.REPORT_RECSTATUS_01);
		paramentList.add(TopReportConstants.REPORT_RECSTATUS_02);

		buff.append(" and strde.currentfile = ? ");
		paramentList.add(TopReportConstants.REPORT_FILE_TYPE_CFA_FC);

		buff.append(" and strde.apptype = ? ");
		paramentList.add(TopReportConstants.REPORT_APP_TYPE_CFA);

		buff.append(" and strde.branchcode = ? ");
		paramentList.add(brNo);
		buff.append(" ORDER BY strde.lstUpdTm DESC");
		PageQueryCondition queryCondition = new PageQueryCondition();
		queryCondition.setQueryString(buff.toString());
		queryCondition.setObjArray(paramentList.toArray());
		queryCondition.setPageIndex(pageIndex);
		queryCondition.setPageSize(pageSize);
		HQLDAO hqlDAO = DAOUtils.getHQLDAO();
		PageQueryResult result = hqlDAO.pageQueryByQL(queryCondition);
		return result;
	}
}