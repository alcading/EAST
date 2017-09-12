package com.huateng.report.bop.collection.getter;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import resource.bean.report.MtsBopFsDs;
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
import com.huateng.report.bop.collection.service.BopFsDsService;
import com.huateng.report.constants.TopReportConstants;

/**
 * 
 * @author shishu.zhang
 *	
 * 2012-10-31下午4:07:26
 */
@SuppressWarnings("unchecked")
public class BopSDsCollectionGetter extends BaseGetter {

	public Result call() throws AppException {
		try {
			setValue2DataBus(ReportConstant.QUERY_LOG_BUSI_NAME, "境内付款/承兑通知书管理查询");
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
			List<MtsBopFsDs> list = new ArrayList<MtsBopFsDs>();
			PageQueryResult queryResult = new PageQueryResult();
			if(op.equals("new")) {
//				//机构号
//				MtsBopFsDs bopFsDs = new MtsBopFsDs();
//				//设置TODO 申报号码
//				bopFsDs.setRptno(ReportUtils.getBussinessNo(TopReportConstants.REPORT_FILE_TYPE_BOP_F));
//				list.add(bopFsDs);
			} else {
				String id = (String)map.get("id");
				ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
				MtsBopFsDs bopFsDs = rootdao.query(MtsBopFsDs.class, id);
				if(bopFsDs.getFiller1()!=null && bopFsDs.getFiller1().length() > 0){
					MtsBopFsDs cDs = rootdao.query(MtsBopFsDs.class, bopFsDs.getFiller1());
					bopFsDs.setOppuser(cDs.getOppuser());
					bopFsDs.setCustype(cDs.getCustype());
					bopFsDs.setLcyacc(cDs.getLcyacc());
					bopFsDs.setIdcode(cDs.getIdcode());
					bopFsDs.setLcyamt(cDs.getLcyamt());
					bopFsDs.setCustcod(cDs.getCustcod());
					bopFsDs.setExrate(cDs.getExrate());
					bopFsDs.setCustnm(cDs.getCustnm());
					bopFsDs.setFcyacc(cDs.getFcyacc());
					bopFsDs.setTxccy(cDs.getTxccy());
					bopFsDs.setFcyamt(cDs.getFcyamt());
					bopFsDs.setTxamt(cDs.getTxamt());
					bopFsDs.setOthacc(cDs.getOthacc());
					bopFsDs.setBuscode(cDs.getBuscode());
					bopFsDs.setOthamt(cDs.getOthamt());
					bopFsDs.setActuccy(cDs.getActuccy());
					bopFsDs.setActuamt(cDs.getActuamt());
					bopFsDs.setOutchargeccy(cDs.getOutchargeccy());
					bopFsDs.setOutchargeamt(cDs.getOutchargeamt());
					bopFsDs.setMethod(cDs.getMethod());
					bopFsDs.setLcbgno(cDs.getLcbgno());
					bopFsDs.setTenor(cDs.getTenor());
					bopFsDs.setIssdate(cDs.getIssdate());
					bopFsDs.setCfiller2(cDs.getFiller2());
				}
				list.add(bopFsDs);
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
			
			BopFsDsService bopFsDsService = BopFsDsService.getInstance();
			return bopFsDsService.queryBopFsCollection(TopReportConstants.REPORT_FILE_TYPE_BOP_S, pageIndex, pageSize, qworkDateStart, qworkDateEnd, qactiontype, qapproveStatus, qrepStatus, qrecStatus, qfiller2);
		}
	}
}
