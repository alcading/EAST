package com.huateng.report.getter;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
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
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.report.common.ReportConstant;
import com.huateng.ebank.framework.util.DataFormat;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;
import com.huateng.report.bean.BopForDebtFeiOrgSave;
import com.huateng.report.constants.TopReportConstants;
import com.huateng.report.service.BopForDebtYinTuanService;
import com.huateng.report.utils.ReportUtils;

/**
 *
 * @author xinyun.zhang
 *
 * 2012-8-15上午10:54:59
 */
@SuppressWarnings("unchecked")
public class BopForCorAndAffOrgContactGetter extends BaseGetter {

	public Result call() throws AppException {
		try {
			setValue2DataBus(ReportConstant.QUERY_LOG_BUSI_NAME, "境外联行及附属机构往来签约信息查询");
			PageQueryResult pageQueryResult = getData();
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
	public PageQueryResult getData() throws CommonException, IllegalAccessException, InvocationTargetException{
		int pageSize = this.getResult().getPage().getEveryPage();
		int pageIndex = this.getResult().getPage().getCurrentPage();
		Map map = getCommQueryServletRequest().getParameterMap();
		String op = (String) map.get("op");
		if (!DataFormat.isEmpty(op)) {
			List<BopForDebtFeiOrgSave> list = new ArrayList<BopForDebtFeiOrgSave>();
			PageQueryResult queryResult = new PageQueryResult();
			if(op.equals("new")) {
				//机构号
				BopForDebtFeiOrgSave feiOrgSaveBean = new BopForDebtFeiOrgSave();
				String exdebtcode = ReportUtils.getBussinessNo(TopReportConstants.REPORT_FILE_TYPE_CFA_AM);
				ReportUtils.setObjectPro(feiOrgSaveBean, TopReportConstants.REPORT_FILE_TYPE_CFA_AM);
				feiOrgSaveBean.setExdebtcode(exdebtcode);
				GlobalInfo globalinfo = GlobalInfo.getCurrentInstance();
				feiOrgSaveBean.setDebtorcode(globalinfo.getBrno());
				list.add(feiOrgSaveBean);
			} else {
				String id = (String) map.get("id");
				ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
				BopCfaExdebtDs bopCfaExdebtDs = rootdao.query(BopCfaExdebtDs.class, id);
				String creHql = "from BopCfaCreditorDs model where model.recId ='" + bopCfaExdebtDs.getId() + "'";
				BopCfaCreditorDs cfaCreditorDs = (BopCfaCreditorDs) rootdao.queryByQL2List(creHql).get(0);
				BopForDebtFeiOrgSave feiOrgSaveBean = new BopForDebtFeiOrgSave();
//				BeanUtils.copyProperties(feiOrgSaveBean, cfaCreditorDs); //先拷贝债权人不然会覆盖主信息中的id
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
			String qworkDateStart = (String) map.get("qworkDateStart");
			String qworkDateEnd = (String) map.get("qworkDateEnd");
			String qactiontype = (String) map.get("qactiontype");
			String qapproveStatus = (String) map.get("qapproveStatus");
			String qrepStatus = (String) map.get("qrepStatus");
			String qfiller2 = (String) map.get("qfiller2");
			String qRecStatus = (String) map.get("qRecStatus");

			BopForDebtYinTuanService debtYinTuanService = BopForDebtYinTuanService.getInstance();
			return debtYinTuanService.queryRecordCorOrgContact("signed", pageIndex, pageSize, qworkDateStart,qworkDateEnd,qactiontype, qapproveStatus, qrepStatus,qfiller2, qRecStatus);
		}
	}
}
