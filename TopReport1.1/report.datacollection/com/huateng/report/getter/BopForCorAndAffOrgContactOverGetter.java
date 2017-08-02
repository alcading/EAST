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
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.report.common.ReportConstant;
import com.huateng.ebank.framework.util.DataFormat;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;
import com.huateng.report.bean.BopForDebtFeiOrgSave;
import com.huateng.report.service.BopForDebtYinTuanService;

/**
 *
 * @author xinyun.zhang
 *
 * 2012-8-15上午10:54:59
 */
public class BopForCorAndAffOrgContactOverGetter extends BaseGetter {

	@Override
	public Result call() throws AppException {
		try {
			this.setValue2DataBus(ReportConstant.QUERY_LOG_BUSI_NAME, "境外联行及附属机构往来余额信息查询");
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

	public PageQueryResult getData() throws CommonException, IllegalAccessException, InvocationTargetException{
		int pageSize = this.getResult().getPage().getEveryPage();
		int pageIndex = this.getResult().getPage().getCurrentPage();
		Map map = getCommQueryServletRequest().getParameterMap();
		String op = (String) map.get("op");
		if(!DataFormat.isEmpty(op)){
			List<BopForDebtFeiOrgSave> list = new ArrayList<BopForDebtFeiOrgSave>();
			PageQueryResult queryResult = new PageQueryResult();
			if(op.equals("new")) {
				//TODO
			} else {
				String id = (String) map.get("id");
				ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
				BopCfaExdebtDs bopCfaExdebtDs = rootdao.query(BopCfaExdebtDs.class, id);

				BopForDebtFeiOrgSave feiOrgSaveBean = new BopForDebtFeiOrgSave();
				BopCfaExdebtDs signCfaExdebtDs = (BopCfaExdebtDs) rootdao.query(BopCfaExdebtDs.class, bopCfaExdebtDs.getFiller1());
				String creHql = "from BopCfaCreditorDs model where model.recId ='" + signCfaExdebtDs.getId() + "'";
				BopCfaCreditorDs cfaCreditorDs = (BopCfaCreditorDs) rootdao.queryByQL2List(creHql).get(0);
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
				feiOrgSaveBean.setDebtype(signCfaExdebtDs.getDebtype());
				feiOrgSaveBean.setDebtorcode(signCfaExdebtDs.getDebtorcode());
				feiOrgSaveBean.setLimitType(signCfaExdebtDs.getLimitType());
				feiOrgSaveBean.setValuedate(signCfaExdebtDs.getValuedate());
				feiOrgSaveBean.setContractcurr(signCfaExdebtDs.getContractcurr());
				feiOrgSaveBean.setFloatrate(signCfaExdebtDs.getFloatrate());
				feiOrgSaveBean.setAnninrate(signCfaExdebtDs.getAnninrate());
				feiOrgSaveBean.setSpapfeboindex(signCfaExdebtDs.getSpapfeboindex());
				feiOrgSaveBean.setDebtyperema(signCfaExdebtDs.getRemark());
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
			return debtYinTuanService.queryRecordCorOrgContact("over", pageIndex, pageSize, qworkDateStart,qworkDateEnd,qactiontype, qapproveStatus, qrepStatus,qfiller2, qRecStatus);
		}
	}
}
