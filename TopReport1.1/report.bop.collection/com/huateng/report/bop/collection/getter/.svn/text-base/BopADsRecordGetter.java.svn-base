package com.huateng.report.bop.collection.getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import resource.bean.report.MtsBopAgDs;
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
import com.huateng.report.bop.collection.service.BopAgDsRecordService;
import com.huateng.report.constants.TopReportConstants;
import com.huateng.report.utils.ReportUtils;

/**
 *
 * 国际收支涉外收入申报单基础信息
 * 
 * @author sujian.zhu
 *
 */
@SuppressWarnings("unchecked")
public class BopADsRecordGetter extends BaseGetter {

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
		String op = map.get("op");
		if(!DataFormat.isEmpty(op)){
			PageQueryResult queryResult = new PageQueryResult();
			String id = map.get("id");
			MtsBopAgDs bopAgDs = null;
			if (!op.equals("add")) {
				ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
				bopAgDs = rootdao.query(MtsBopAgDs.class, id);
			} else {
				// 生成申报号码
				String rptno = ReportUtils.getBussinessNo(TopReportConstants.REPORT_FILE_TYPE_BOP_A);
				bopAgDs = new MtsBopAgDs();
				bopAgDs.setRptno(rptno);
			}
			List<MtsBopAgDs> list = new ArrayList<MtsBopAgDs>();
			list.add(bopAgDs);
			queryResult.setQueryResult(list);
			//页面接收判断
			getCommQueryServletRequest().setParameter("op", op);
			return queryResult;
		} else {

			setValue2DataBus(ReportConstant.QUERY_LOG_BUSI_NAME, "国际收支信息补录-涉外收入申报单-基础信息查询");

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
			BopAgDsRecordService bopAgDsService = BopAgDsRecordService.getInstance();
			return bopAgDsService.queryBOPAgRecord(TopReportConstants.REPORT_FILE_TYPE_BOP_A, pageIndex, pageSize, qworkDateStart, qworkDateEnd, qactiontype, qapproveStatus, qrepStatus, qrecStatus, qfiller2, qbrNo);
		}
	}
}
