package com.huateng.report.bop.collection.getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import resource.bean.report.MtsBopBhnDs;
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
import com.huateng.report.utils.ReportUtils;

public class BopBhnDsCollInfoGetter extends BaseGetter {
	
	private static final String GETTER_OP_ADD = "add"; 
	private static final String GETTER_OP_MOD = "mod"; 
	private static final String GETTER_OP_DEL = "del"; 
	private static final String GETTER_OP_DETAIL = "detail"; 
	@Override
	public Result call() throws AppException {
		// TODO Auto-generated method stub
		try {
			PageQueryResult pageResult = getData();
			//记录日志
			String op = this.getCommQueryServletRequest().getParameter("op");
			String message = null;
			if(GETTER_OP_ADD.equals(op)) {
				message = "新增";
			} else if(GETTER_OP_MOD.equals(op)) {
				message = "修改";
			} else if(GETTER_OP_DEL.equals(op)) {
				message = "删除";
			}
			this.setValue2DataBus(ReportConstant.QUERY_LOG_BUSI_NAME, "境外汇款申请书"+message+"补录基础信息查询");
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
		Map paramsMap = this.getCommQueryServletRequest().getParameterMap();
		String op = (String) paramsMap.get("op");
		if(GETTER_OP_ADD.equals(op)) {
			PageQueryResult pageQueryResult = new PageQueryResult();
			MtsBopBhnDs ds = new MtsBopBhnDs();
			//申报号码
//			//测试用
//			String rptno = UUID.randomUUID().toString().replace("-", "").substring(0,22);
			String rptno = ReportUtils.getBussinessNo(TopReportConstants.REPORT_FILE_TYPE_BOP_B);
			ds.setRptno(rptno);
			List list = new ArrayList();
			list.add(ds);
			pageQueryResult.setQueryResult(list);
			return pageQueryResult;
		}
		if(GETTER_OP_MOD.equals(op) || GETTER_OP_DEL.equals(op) || GETTER_OP_DETAIL.equals(op)) {
			String rec_id = (String) paramsMap.get("id");
			String hql = " from MtsBopBhnDs ds where 1 = 1 ";
			hql += " and ds.id = '"+rec_id+"'";
			int pageIndex = this.getResult().getPage().getCurrentPage();
			int maxRows = this.getResult().getPage().getEveryPage();
			PageQueryCondition pageQueryCondition = new PageQueryCondition();
			pageQueryCondition.setPageIndex(pageIndex);
			pageQueryCondition.setPageSize(maxRows);
			pageQueryCondition.setQueryString(hql);
			return ROOTDAOUtils.getROOTDAO().pageQueryByQL(pageQueryCondition);
		}
		return null;
	}

}
