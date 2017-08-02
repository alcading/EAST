package com.huateng.report.bop.collection.getter;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import resource.bean.report.MtsBopCkpDs;
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
import com.huateng.report.bop.collection.service.BopCkpDsService;
import com.huateng.report.constants.TopReportConstants;
import com.huateng.report.utils.ReportUtils;

/**
 * 
 * @author shishu.zhang
 *	
 * 2012-10-30下午3:13:44
 */
@SuppressWarnings("unchecked")
public class BopCDsCollectionGetter extends BaseGetter {

	public Result call() throws AppException {
		try {
			setValue2DataBus(ReportConstant.QUERY_LOG_BUSI_NAME, "对外付款/承兑通知书基础信息查询");
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
		Map<String, String> map = getCommQueryServletRequest().getParameterMap();
		String op = (String) map.get("op");
		if (!DataFormat.isEmpty(op)) {
			List<MtsBopCkpDs> list = new ArrayList<MtsBopCkpDs>();
			PageQueryResult queryResult = new PageQueryResult();
			if(op.equals("new")) {
				//机构号
				MtsBopCkpDs bopCkpDs = new MtsBopCkpDs();
				//设置TODO 申报号码
				GlobalInfo globalinfo = GlobalInfo.getCurrentInstance();
				bopCkpDs.setBrNo(globalinfo.getBrno());
				bopCkpDs.setRptno(ReportUtils.getBussinessNo(TopReportConstants.REPORT_FILE_TYPE_BOP_C));
				list.add(bopCkpDs);
			} else {
				String id = (String)map.get("id");
				ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
				MtsBopCkpDs bopCkpDs = rootdao.query(MtsBopCkpDs.class, id);
				list.add(bopCkpDs);
			}
			queryResult.setQueryResult(list);
			//页面接收判断
			getCommQueryServletRequest().setParameter("op", op);
			return queryResult;
		} else {
			String qworkDateStart = map.get("qworkDateStart");
			String qworkDateEnd = map.get("qworkDateEnd");
			String qactiontype = map.get("qactiontype");
			String qrecStatus = map.get("qrecStatus");
			String qapproveStatus = map.get("qapproveStatus");
			String qrepStatus = map.get("qrepStatus");
			String qfiller2 = map.get("qfiller2");

			BopCkpDsService bopCkpDsService = BopCkpDsService.getInstance();
			return bopCkpDsService.queryBopCkpCollection(TopReportConstants.REPORT_FILE_TYPE_BOP_C, pageIndex, pageSize, qworkDateStart, qworkDateEnd, qactiontype, qapproveStatus, qrepStatus, qrecStatus, qfiller2);
		}
	}
}
