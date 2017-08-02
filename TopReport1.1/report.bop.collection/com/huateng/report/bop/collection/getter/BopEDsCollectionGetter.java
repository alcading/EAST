package com.huateng.report.bop.collection.getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import resource.bean.report.MtsBopEqDs;
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
import com.huateng.report.bop.collection.service.BopEqDsCollectionService;
import com.huateng.report.constants.TopReportConstants;
import com.huateng.report.utils.ReportUtils;

/**
 *
 * @author jiaoqiangqiang
 *
 * 2012-8-15上午10:54:59
 */
@SuppressWarnings("unchecked")
public class BopEDsCollectionGetter extends BaseGetter {

	@Override
	public Result call() throws AppException {
		try {
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

	public PageQueryResult getData() throws AppException {
		int pageSize = this.getResult().getPage().getEveryPage();
		int pageIndex = this.getResult().getPage().getCurrentPage();
		Map<String, String> map = getCommQueryServletRequest().getParameterMap();
		String op = (String) map.get("op");
		if(!DataFormat.isEmpty(op)){
			PageQueryResult queryResult = new PageQueryResult();
			String id = (String) map.get("id");
			MtsBopEqDs bopEqDs = null;
			if (!op.equals("add")) {
				ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
				bopEqDs = rootdao.query(MtsBopEqDs.class, id);
			} else {
				// 生成申报号码
				String rptno = ReportUtils.getBussinessNo(TopReportConstants.REPORT_FILE_TYPE_BOP_E);
				bopEqDs = new MtsBopEqDs();
				bopEqDs.setRptno(rptno);
			}
			List<MtsBopEqDs> list = new ArrayList<MtsBopEqDs>();
			list.add(bopEqDs);
			queryResult.setQueryResult(list);
			//页面接收判断
			getCommQueryServletRequest().setParameter("op", op);
			return queryResult;
		} else {

			setValue2DataBus(ReportConstant.QUERY_LOG_BUSI_NAME, "国际收支信息补录-境内汇款申请书-基础信息查询");

			String qworkDateStart = map.get("qworkDateStart");
			String qworkDateEnd = map.get("qworkDateEnd");
			String qactiontype = map.get("qactiontype");
			String qrecStatus = map.get("qrecStatus");
			String qapproveStatus = map.get("qapproveStatus");
			String qrepStatus = map.get("qrepStatus");
			String qfiller2 = map.get("qfiller2");
			//只能查当前机构号
			GlobalInfo globalInfo = GlobalInfo.getCurrentInstance();
			String qbrNo = globalInfo.getBrno();
			BopEqDsCollectionService bopEqDsCollectionService = BopEqDsCollectionService.getInstance();
			return bopEqDsCollectionService.queryBOPEqRecord(TopReportConstants.REPORT_FILE_TYPE_BOP_E, pageIndex, pageSize, qworkDateStart, qworkDateEnd, qactiontype, qapproveStatus, qrepStatus, qrecStatus, qfiller2, qbrNo);
		}
	}
}
