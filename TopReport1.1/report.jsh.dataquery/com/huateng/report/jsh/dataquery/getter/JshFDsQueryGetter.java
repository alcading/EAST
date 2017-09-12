package com.huateng.report.jsh.dataquery.getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

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

public class JshFDsQueryGetter extends BaseGetter {

	@Override
	public Result call() throws AppException {
		// TODO Auto-generated method stub
		try {
			PageQueryResult pageResult = getData();
			this.setValue2DataBus(ReportConstant.QUERY_LOG_BUSI_NAME, "外汇账户内结汇补录查询管理信息查询");
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

	private PageQueryResult getData() throws CommonException {
		// TODO Auto-generated method stub
		Map<String,String> map = this.getCommQueryServletRequest().getParameterMap();
		String qbrNo = map.get("qbrNo");
		String qworkDateStart = map.get("qworkDateStart");
		String qworkDateEnd = map.get("qworkDateEnd");
		String qactiontype = map.get("qactiontype");
		String qrecStatus = map.get("qrecStatus");
		String qapproveStatus = map.get("qapproveStatus");
		String qrepStatus = map.get("qrepStatus");
		String qfiller2 = map.get("qfiller2");
		int pageSize = this.getResult().getPage().getEveryPage();
		int pageIndex = this.getResult().getPage().getCurrentPage();
		StringBuffer buff = new StringBuffer();
		List<Object> objs = new ArrayList<Object>();
		buff.append(" from MtsJshDefgDs model where model.apptype = ?");
		objs.add(TopReportConstants.REPORT_APP_TYPE_JSH);
		buff.append(" and model.currentfile= ? ");
		objs.add(TopReportConstants.REPORT_FILE_TYPE_JSH_F);
		// qbrNo,qworkDate,qrecStatus,qapproveStatus,qrepStatus,qstrdecode
		if(StringUtils.isNotBlank(qbrNo)) {
			buff.append(" and model.brNo = ?");
			objs.add(qbrNo);
		} 
		if(StringUtils.isNotBlank(qworkDateStart)) {
			buff.append(" and model.workDate >= ?");
			objs.add(qworkDateStart);
		}
		if(StringUtils.isNotBlank(qworkDateEnd)) {
			buff.append(" and model.workDate <= ?");
			objs.add(qworkDateEnd);
		}
		if(StringUtils.isNotBlank(qactiontype)) {
			buff.append(" and model.actiontype = ?");
			objs.add(qactiontype);
		}
		if(StringUtils.isNotBlank(qrecStatus)) {
			buff.append(" and model.recStatus = ?");
			objs.add(qrecStatus);
		}
		if(StringUtils.isNotBlank(qapproveStatus)) {
			buff.append(" and model.approveStatus = ?");
			objs.add(qapproveStatus);
		}
		if(StringUtils.isNotBlank(qrepStatus)) {
			buff.append(" and model.repStatus = ?");
			objs.add(qrepStatus);
		}
		if(StringUtils.isNotBlank(qfiller2)) {
			buff.append(" and model.filler2 like ?");
			objs.add("%"+qfiller2+"%");
		}
		PageQueryCondition queryCondition = new PageQueryCondition();
		queryCondition.setObjArray(objs.toArray());
		queryCondition.setPageIndex(pageIndex);
		queryCondition.setPageSize(pageSize);
		queryCondition.setQueryString(buff.toString());
		System.out.println(buff.toString());
		System.out.println(objs);
		return ROOTDAOUtils.getROOTDAO().pageQueryByQL(queryCondition);
	}

}
