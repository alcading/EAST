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
import com.huateng.commquery.servlet.CommQueryServletRequest;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.PageQueryCondition;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.business.management.common.DAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.report.common.ReportConstant;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;
import com.huateng.report.constants.TopReportConstants;

/*
 * 终止信息新增拾取页面getter
 */
@SuppressWarnings("unchecked")
public class BopCfaStrdeDsLoadPageGetter extends BaseGetter {
	private static final String terminate_type = "terminate";
	private static final String inpay_type = "inpay";
	private static final String inoutmo_type = "inoutmo";

	public Result call() throws AppException {
		try {
			PageQueryResult pageResult = getData();
			CommQueryServletRequest request = getCommQueryServletRequest();
			setValue2DataBus(ReportConstant.QUERY_LOG_BUSI_NAME, "商业银行人民币结构性存款拾取页面查询");
			String type = request.getParameter("type");
			if(terminate_type.equals(type)) {
				request.setParameter("type", terminate_type);
			} else if(inpay_type.equals(type)) {
				request.setParameter("type", inpay_type);
			} else if(inoutmo_type.equals(type)) {
				request.setParameter("type", inoutmo_type);
			}
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
		Map paramsMap = getCommQueryServletRequest().getParameterMap();
		int pageSize = getResult().getPage().getEveryPage();
		int pageIndex = getResult().getPage().getCurrentPage();

		String qworkDateStart = (String) paramsMap.get("qworkDateStart");
		String qworkDateEnd = (String) paramsMap.get("qworkDateEnd");
		String qfiller2 = (String) paramsMap.get("qfiller2");
		String qbranchcode = (String) paramsMap.get("qbranchcode");
		String qcontract = (String) paramsMap.get("qcontract");
		//本机构
		GlobalInfo globalInfo = GlobalInfo.getCurrentInstance();
		String brNo = globalInfo.getBrno();

		List<Object>paramentList = new ArrayList<Object>();
		StringBuffer buff = new StringBuffer(" FROM BopCfaStrdeDs ds WHERE 1 = 1");
		if(StringUtils.isNotBlank(qworkDateStart)) {
			buff.append(" AND ds.workDate >= ? ");
			paramentList.add(qworkDateStart);
		}
		if(StringUtils.isNotBlank(qworkDateEnd)) {
			buff.append(" AND ds.workDate <= ? ");
			paramentList.add(qworkDateEnd);
		}
		if(StringUtils.isNotBlank(qfiller2)) {
			buff.append(" AND ds.filler2 LIKE ? ");
			paramentList.add("%"+qfiller2+"%");
		}
		if(StringUtils.isNotBlank(qbranchcode)) {
			buff.append(" AND ds.branchcode LIKE ? ");
			paramentList.add("%"+qbranchcode+"%");
		}
		if(StringUtils.isNotBlank(qcontract)) {
			buff.append(" AND ds.contract LIKE ? ");
			paramentList.add("%"+qcontract+"%");
		}
		//拾取的是签约信息
		buff.append(" and ds.currentfile = ? ");
		paramentList.add(TopReportConstants.REPORT_FILE_TYPE_CFA_FA);

		buff.append(" and ds.apptype = ? ");
		paramentList.add(TopReportConstants.REPORT_APP_TYPE_CFA);

		buff.append(" and ds.branchcode = ? ");
		paramentList.add(brNo);

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