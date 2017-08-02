package com.huateng.report.dataquery.getter;



import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import resource.bean.report.BopCfaCreditorDs;
import resource.bean.report.BopCfaExdebtDs;
import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.PageQueryCondition;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.report.common.ReportConstant;
import com.huateng.ebank.framework.util.DataFormat;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;
import com.huateng.report.bean.BopForDebtFeiOrgSave;
import com.huateng.report.constants.TopReportConstants;


/**
 * @author zhuhongyong
 * for(外债 远期信用证)
 *
 */
@SuppressWarnings("unchecked")
public class BOPForDebtUsanceLeOfCreditQueryGetter extends BaseGetter {

	public static final String SIGNED = "sign";//判断是签约信息页面的请求
	public static final String CHANGE = "change";//判断是变动信息页面请求

	public Result call() throws AppException {
		try {
			setValue2DataBus(ReportConstant.QUERY_LOG_BUSI_NAME, "远期信用证签约信息查询");

			PageQueryResult queryResult = getData();
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

	private PageQueryResult getData() throws CommonException,
			IllegalAccessException, InvocationTargetException {

		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
//		GlobalInfo glbalInfo = GlobalInfo.getCurrentInstance();
		int pageSize = getResult().getPage().getEveryPage();
		int pageIndex = getResult().getPage().getCurrentPage();

		PageQueryCondition queryCondition = new PageQueryCondition();

		Map paramsMap = getCommQueryServletRequest().getParameterMap();

		String qbrNo = (String) paramsMap.get("qbrNo");
		String qworkDateBegin = (String) paramsMap.get("qWorkDateBegin");
		String qworkDateOver = (String) paramsMap.get("qWorkDateOver");
		String qactiontype = (String) paramsMap.get("qactiontype");
		String qrecStatus = (String) paramsMap.get("qrecStatus");
		String qapproveStatus = (String) paramsMap.get("qapproveStatus");
		String qrepStatus = (String) paramsMap.get("qrepStatus");
		String qfiller2 = (String) paramsMap.get("qfiller2");
		//区分是签约签约信息还是变动信息
		String getType = (String) paramsMap.get("getType");

		List<Object> objs = new ArrayList<Object>();

		StringBuffer hql = new StringBuffer();
		hql.append(" FROM BopCfaExdebtDs ds WHERE ds.apptype = ?");
		objs.add(TopReportConstants.REPORT_APP_TYPE_CFA);

		//判断是签约信息还是变动信息
		if (SIGNED.equalsIgnoreCase(getType)) {
			hql.append(" AND ds.currentfile = ? ");
			objs.add(TopReportConstants.REPORT_FILE_TYPE_CFA_AF);
		} else if (CHANGE.equalsIgnoreCase(getType)) {
			hql.append(" AND ds.currentfile = ? ");
			objs.add(TopReportConstants.REPORT_FILE_TYPE_CFA_AR);
			hql.append(" AND ds.changeFileType = ? ");
			objs.add(TopReportConstants.REPORT_FILE_TYPE_CFA_AF);
		}
		if (!DataFormat.isEmpty(qbrNo)) {
			hql.append(" AND ds.brNo = ? ");
			objs.add(qbrNo);
		}
		if (!DataFormat.isEmpty(qworkDateBegin)) {
			hql.append(" AND ds.workDate >= ? ");
			objs.add(qworkDateBegin);
		}
		if (!DataFormat.isEmpty(qworkDateOver)) {
			hql.append(" AND ds.workDate <= ? ");
			objs.add(qworkDateOver);
		}
		if (!DataFormat.isEmpty(qactiontype)) {
			hql.append(" AND ds.actiontype = ? ");
			objs.add(qactiontype);
		}
		if (!DataFormat.isEmpty(qrecStatus)) {
			hql.append(" AND ds.recStatus = ? ");
			objs.add(qrecStatus);
		}
		if (!DataFormat.isEmpty(qapproveStatus)) {
			hql.append(" AND ds.approveStatus = ? ");
			objs.add(qapproveStatus);
		}
		if (!DataFormat.isEmpty(qrepStatus)) {
			hql.append(" AND ds.repStatus = ? ");
			objs.add(qrepStatus);
		}
		if (!DataFormat.isEmpty(qfiller2)) {
			hql.append(" AND ds.filler2 LIKE ? ");
			objs.add("%" + qfiller2 + "%");
		}
		hql.append(" ORDER BY ds.workDate, ds.actiontype, ds.approveStatus DESC");

		queryCondition.setPageIndex(pageIndex);
		queryCondition.setPageSize(pageSize);
		queryCondition.setQueryString(hql.toString());
		queryCondition.setObjArray(objs.toArray());

		PageQueryResult queryResult = new PageQueryResult();
		queryResult = rootdao.pageQueryByQL(queryCondition);
		List<BopForDebtFeiOrgSave> debtFeiOrgSaves = new ArrayList<BopForDebtFeiOrgSave>();
		List list = queryResult.getQueryResult();
		if (list != null) {
			Iterator it = list.iterator();
			while (it.hasNext()) {
				Object o = it.next();
				Object[] os = (Object[]) o;
				BopCfaExdebtDs cfaExdebtDs = (BopCfaExdebtDs) os[0];
				BopForDebtFeiOrgSave debtFeiOrgSave = new BopForDebtFeiOrgSave();
				BeanUtils.copyProperties(debtFeiOrgSave, cfaExdebtDs);
				String creHql = " FROM BopCfaCreditorDs model WHERE model.recId = '" + cfaExdebtDs.getId() + "' ";
				BopCfaCreditorDs cfaCreditorDs = (BopCfaCreditorDs) rootdao.queryByQL2List(creHql).get(0);
				debtFeiOrgSave.setRecId(cfaCreditorDs.getRecId());
				debtFeiOrgSave.setCreditorca(cfaCreditorDs.getCreditorca());
				debtFeiOrgSave.setCreditorcode(cfaCreditorDs.getCreditorcode()); //债权人代码
				debtFeiOrgSave.setCreditorname(cfaCreditorDs.getCreditorname());//债权人中文名称
				debtFeiOrgSave.setCreditornamen(cfaCreditorDs.getCreditornamen());//债权人英文名称
				debtFeiOrgSave.setCreditortype(cfaCreditorDs.getCreditortype());//债权人类型代码
				debtFeiOrgSave.setCrehqcode(cfaCreditorDs.getCrehqcode());//债权人总部所在国家（地区）代码
				debtFeiOrgSave.setOpercode(cfaCreditorDs.getOpercode());//债权人经营地所在国家（地区）代码
				debtFeiOrgSaves.add(debtFeiOrgSave);
			}
		}
		queryResult.setQueryResult(debtFeiOrgSaves);
		return queryResult;
	}
}