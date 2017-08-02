package com.huateng.report.getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
import com.huateng.report.service.BopForDebtYinTuanService;

/**
 *
 * @author shishu.zhang
 *
 * 2012-8-15上午10:54:59
 */
@SuppressWarnings("unchecked")
public class BopForDebtYinTuanChangeGetter extends BaseGetter {

	@Override
	public Result call() throws AppException {
		try {
			PageQueryResult pageQueryResult = getData();

			setValue2DataBus(ReportConstant.QUERY_LOG_BUSI_NAME, "外债-银团贷款信息补录-变动信息查询");

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

	public PageQueryResult getData() throws CommonException{
		int pageSize = this.getResult().getPage().getEveryPage();
		int pageIndex = this.getResult().getPage().getCurrentPage();
		Map map = getCommQueryServletRequest().getParameterMap();
		String op = (String) map.get("op");
		if(!DataFormat.isEmpty(op)){
			List<BopCfaExdebtDs> list = new ArrayList<BopCfaExdebtDs>();
			PageQueryResult queryResult = new PageQueryResult();
			if(op.equals("new")) {
				//TODO
			} else {
				String id = (String) map.get("id");
				ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
				BopCfaExdebtDs bopCfaExdebtDs = rootdao.query(BopCfaExdebtDs.class, id);
				BopCfaExdebtDs signedExdebt = rootdao.query(BopCfaExdebtDs.class, bopCfaExdebtDs.getFiller1());

				bopCfaExdebtDs.setContractcurr(signedExdebt.getContractcurr());
				bopCfaExdebtDs.setDebtype(signedExdebt.getDebtype());
				bopCfaExdebtDs.setDebtorcode(signedExdebt.getDebtorcode());
				bopCfaExdebtDs.setContractamount(signedExdebt.getContractamount());
				bopCfaExdebtDs.setValuedate(signedExdebt.getValuedate());
				bopCfaExdebtDs.setMaturity(signedExdebt.getMaturity());
				bopCfaExdebtDs.setFloatrate(signedExdebt.getFloatrate());
				bopCfaExdebtDs.setAnninrate(signedExdebt.getAnninrate());
				bopCfaExdebtDs.setInprterm(signedExdebt.getInprterm());
				bopCfaExdebtDs.setSpapfeboindex(signedExdebt.getSpapfeboindex());
				bopCfaExdebtDs.setDebtyperema(signedExdebt.getRemark());

				list.add(bopCfaExdebtDs);
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
			String qRecStatus = (String) map.get("qRecStatus");//记录状态查询条件

			BopForDebtYinTuanService debtYinTuanService = BopForDebtYinTuanService.getInstance();
			return debtYinTuanService.queryRecordYinTuan("change", pageIndex, pageSize, qworkDateStart, qworkDateEnd, qfiller2,qactiontype, qapproveStatus, qrepStatus, qRecStatus);
		}
	}
}
