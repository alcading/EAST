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
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.report.common.ReportConstant;
import com.huateng.ebank.framework.util.DataFormat;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;
import com.huateng.report.bop.collection.service.BopCkpDsService;
import com.huateng.report.constants.TopReportConstants;

/**
 * 
 * @author shishu.zhang
 *	
 * 2012-10-31下午4:07:26
 */
@SuppressWarnings("unchecked")
public class BopPDsCollectionGetter extends BaseGetter {

	public Result call() throws AppException {
		try {
			setValue2DataBus(ReportConstant.QUERY_LOG_BUSI_NAME, "对外付款/承兑通知书申报查询");
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
//				//机构号
//				MtsBopCkpDs bopCkpDs = new MtsBopCkpDs();
//				//设置TODO 申报号码
//				GlobalInfo globalinfo = GlobalInfo.getCurrentInstance();
//				bopCkpDs.setBrNo(globalinfo.getBrno());
//				bopCkpDs.setRptno(ReportUtils.getBussinessNo(TopReportConstants.REPORT_FILE_TYPE_BOP_K));
//				list.add(bopCkpDs);
			} else {
				String id = (String)map.get("id");
				ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
				MtsBopCkpDs bopCkpDs = rootdao.query(MtsBopCkpDs.class, id);
				if(bopCkpDs.getFiller1()!=null && bopCkpDs.getFiller1().length() > 0){
					MtsBopCkpDs cDs = rootdao.query(MtsBopCkpDs.class, bopCkpDs.getFiller1());
					bopCkpDs.setOppuser(cDs.getOppuser());
					bopCkpDs.setCustype(cDs.getCustype());
					bopCkpDs.setLcyacc(cDs.getLcyacc());
					bopCkpDs.setIdcode(cDs.getIdcode());
					bopCkpDs.setLcyamt(cDs.getLcyamt());
					bopCkpDs.setCustcod(cDs.getCustcod());
					bopCkpDs.setExrate(cDs.getExrate());
					bopCkpDs.setCustnm(cDs.getCustnm());
					bopCkpDs.setFcyacc(cDs.getFcyacc());
					bopCkpDs.setTxccy(cDs.getTxccy());
					bopCkpDs.setFcyamt(cDs.getFcyamt());
					bopCkpDs.setTxamt(cDs.getTxamt());
					bopCkpDs.setOthacc(cDs.getOthacc());
					bopCkpDs.setBuscode(cDs.getBuscode());
					bopCkpDs.setOthamt(cDs.getOthamt());
					bopCkpDs.setActuccy(cDs.getActuccy());
					bopCkpDs.setActuamt(cDs.getActuamt());
					bopCkpDs.setOutchargeccy(cDs.getOutchargeccy());
					bopCkpDs.setOutchargeamt(cDs.getOutchargeamt());
					bopCkpDs.setMethod(cDs.getMethod());
					bopCkpDs.setLcbgno(cDs.getLcbgno());
					bopCkpDs.setTenor(cDs.getTenor());
					bopCkpDs.setIssdate(cDs.getIssdate());
					bopCkpDs.setCfiller2(cDs.getFiller2());
				}
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
			return bopCkpDsService.queryBopCkpCollection(TopReportConstants.REPORT_FILE_TYPE_BOP_P, pageIndex, pageSize, qworkDateStart, qworkDateEnd, qactiontype, qapproveStatus, qrepStatus, qrecStatus, qfiller2);
		}
	}
}
