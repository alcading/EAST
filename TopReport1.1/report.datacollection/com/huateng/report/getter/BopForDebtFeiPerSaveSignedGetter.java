package com.huateng.report.getter;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;

import resource.bean.report.BopCfaCreditorDs;
import resource.bean.report.BopCfaExdebtDs;
import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.report.common.ReportConstant;
import com.huateng.ebank.framework.util.DataFormat;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;
import com.huateng.report.bean.BopForDebtFeiPerSave;
import com.huateng.report.constants.TopReportConstants;
import com.huateng.report.service.BopForDebtYinTuanService;
import com.huateng.report.utils.ReportUtils;

/**
 *
 * @author shishu.zhang
 *
 * 2012-8-15上午10:54:59
 */
@SuppressWarnings("unchecked")
public class BopForDebtFeiPerSaveSignedGetter extends BaseGetter {

	public Result call() throws AppException {
		try {
			PageQueryResult pageQueryResult = getData();

			setValue2DataBus(ReportConstant.QUERY_LOG_BUSI_NAME, "外债非居民个人存款补录-外债非居民个人存款签约信息查询");

			ResultMng.fillResultByList(getCommonQueryBean(),
					getCommQueryServletRequest(), pageQueryResult.getQueryResult(),
					getResult());
			result.setContent(pageQueryResult.getQueryResult());
			result.getPage().setTotalPage(pageQueryResult.getPageCount(getResult().getPage().getEveryPage()));
			result.init();
			return result;
		} catch (CommonException e) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, e.getMessage());
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}

	@SuppressWarnings("rawtypes")
	public PageQueryResult getData() throws IllegalAccessException, InvocationTargetException, AppException{
		int pageSize = getResult().getPage().getEveryPage();
		int pageIndex = getResult().getPage().getCurrentPage();
		Map map = getCommQueryServletRequest().getParameterMap();
		String op = (String) map.get("op");
		if(!DataFormat.isEmpty(op)){
			List<BopForDebtFeiPerSave> list = new ArrayList<BopForDebtFeiPerSave>();
			PageQueryResult queryResult = new PageQueryResult();
			if(op.equals("new")) {
				BopForDebtFeiPerSave feiOrgSaveBean = new BopForDebtFeiPerSave();
				feiOrgSaveBean.setExdebtcode(ReportUtils.getBussinessNo(TopReportConstants.REPORT_FILE_TYPE_CFA_AP));
				GlobalInfo globalinfo = GlobalInfo.getCurrentInstance();
				feiOrgSaveBean.setDebtorcode(globalinfo.getBrno());
				ReportUtils.setObjectPro(feiOrgSaveBean, TopReportConstants.REPORT_FILE_TYPE_CFA_AP);
				list.add(feiOrgSaveBean);
			} else {
				String id = (String) map.get("id");
				ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
				BopCfaExdebtDs bopCfaExdebtDs = rootdao.query(BopCfaExdebtDs.class, id);
				if (StringUtils.equals("modify", op)) {
					bopCfaExdebtDs.setActiondesc(null);
				}
				String creHql = " FROM BopCfaCreditorDs model WHERE model.recId = '" + bopCfaExdebtDs.getId() + "' ";
				BopCfaCreditorDs cfaCreditorDs = (BopCfaCreditorDs) rootdao.queryByQL2List(creHql).get(0);
				BopForDebtFeiPerSave feiOrgSaveBean = new BopForDebtFeiPerSave();
				BeanUtils.copyProperties(feiOrgSaveBean, bopCfaExdebtDs);
				feiOrgSaveBean.setRecId(cfaCreditorDs.getRecId());
				feiOrgSaveBean.setCreditorca(cfaCreditorDs.getCreditorca());
				feiOrgSaveBean.setCreditorcode(cfaCreditorDs.getCreditorcode()); //债权人代码
				feiOrgSaveBean.setCreditorname(cfaCreditorDs.getCreditorname());//债权人中文名称
				feiOrgSaveBean.setCreditornamen(cfaCreditorDs.getCreditornamen());//债权人英文名称
				feiOrgSaveBean.setCreditortype(cfaCreditorDs.getCreditortype());//债权人类型代码
				feiOrgSaveBean.setCrehqcode(cfaCreditorDs.getCrehqcode());//债权人总部所在国家（地区）代码
				feiOrgSaveBean.setOpercode(cfaCreditorDs.getOpercode());//债权人经营地所在国家（地区）代码
				list.add(feiOrgSaveBean);
			}
			queryResult.setQueryResult(list);
			//页面接收判断
			getCommQueryServletRequest().setParameter("op", op);
			return queryResult;
		} else {

			setValue2DataBus(ReportConstant.QUERY_LOG_BUSI_NAME, "外债-非居民个人存款补录-签约信息查询");

			String qstartdate = (String) map.get("startdate");
			String qenddate = (String) map.get("enddate");
			String qactiontype = (String) map.get("qactiontype");
			String qapproveStatus = (String) map.get("qapproveStatus");
			String qrepStatus = (String) map.get("qrepStatus");
			String qRecStatus = (String) map.get("qRecStatus");
			String filler2 = (String) map.get("filler2");

			BopForDebtYinTuanService debtYinTuanService = BopForDebtYinTuanService.getInstance();
			return debtYinTuanService.queryRecordFeiPerSave("signed", pageIndex, pageSize, qstartdate, qenddate, qactiontype, qapproveStatus, qrepStatus, qRecStatus, filler2);
		}
	}
}