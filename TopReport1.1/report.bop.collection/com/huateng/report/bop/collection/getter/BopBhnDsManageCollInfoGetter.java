package com.huateng.report.bop.collection.getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import resource.bean.report.MtsBopBhnDs;
import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.report.common.ReportConstant;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

@SuppressWarnings("unchecked")
public class BopBhnDsManageCollInfoGetter extends BaseGetter {
	
	private static final String ADD = "add";
	private static final String MOD = "mod";
	private static final String DEL = "del";
	private static final String DETAIL = "detail";
	
	@Override
	public Result call() throws AppException {
		// TODO Auto-generated method stub
		try {
			PageQueryResult pageResult = getData();
			//记录日志
			String op = this.getCommQueryServletRequest().getParameter("op");
			String message = null;
			if(ADD.equals(op)) {
				message = "新增";
			} else if(MOD.equals(op)) {
				message = "修改";
			} else if(DEL.equals(op)) {
				message = "删除";
			}
			this.setValue2DataBus(ReportConstant.QUERY_LOG_BUSI_NAME, "境外汇款申请书"+message+"补录管理信息查询");
			ResultMng.fillResultByList(
				getCommonQueryBean(),
				getCommQueryServletRequest(),
				pageResult.getQueryResult(),
				getResult());
			result.setContent(pageResult.getQueryResult());
			result.getPage().setTotalPage(pageResult.getPageCount(getResult().getPage().getEveryPage()));
			result.init();
			return result;
		}catch(AppException appEx){
			throw appEx;
		}catch(Exception ex){
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(),ex);
		}
	}

	private PageQueryResult getData() throws CommonException {
		ROOTDAO dao = ROOTDAOUtils.getROOTDAO();
		Map paramsMap = this.getCommQueryServletRequest().getParameterMap();
		String op = (String) paramsMap.get("op");
		if(ADD.equals(op)) {
			PageQueryResult pageQueryResult = new PageQueryResult();
			MtsBopBhnDs ds = new MtsBopBhnDs();
			List list = new ArrayList();
			list.add(ds);
			pageQueryResult.setQueryResult(list);
			return pageQueryResult;
		} 
		if(MOD.equals(op) || DEL.equals(op) || DETAIL.equals(op)) {
			String rec_id = (String) paramsMap.get("id");
			String hql = " from MtsBopBhnDs ds where 1 = 1 ";
			hql += " and ds.id = '"+rec_id+"' order by ds.lstUpdTm desc";
			List<MtsBopBhnDs> mtsBopBhnDsInfos = dao.queryByQL2List(hql);
			for(MtsBopBhnDs ds : mtsBopBhnDsInfos) {
				String id = ds.getFiller1();
				MtsBopBhnDs collMtsBopBhnDs = dao.query(MtsBopBhnDs.class, id);
				if(collMtsBopBhnDs != null) {
					//rptno custype idcode custcod custnm oppuser txccy 
					//txamt exrate lcyamt lcyacc fcyamt fcyacc othamt othacc method buscode
					ds.setRptno(collMtsBopBhnDs.getRptno());
					ds.setCustype(collMtsBopBhnDs.getCustype());
					ds.setIdcode(collMtsBopBhnDs.getIdcode());
					ds.setCustcod(collMtsBopBhnDs.getCustcod());
					ds.setCustnm(collMtsBopBhnDs.getCustnm());
					ds.setOppuser(collMtsBopBhnDs.getOppuser());
					ds.setTxccy(collMtsBopBhnDs.getTxccy());
					ds.setTxamt(collMtsBopBhnDs.getTxamt());
					ds.setExrate(collMtsBopBhnDs.getExrate());
					ds.setLcyamt(collMtsBopBhnDs.getLcyamt());
					ds.setLcyacc(collMtsBopBhnDs.getLcyacc());
					ds.setFcyamt(collMtsBopBhnDs.getFcyamt());
					ds.setFcyacc(collMtsBopBhnDs.getFcyacc());
					ds.setOthamt(collMtsBopBhnDs.getOthamt());
					ds.setOthacc(collMtsBopBhnDs.getOthacc());
					ds.setMethod(collMtsBopBhnDs.getMethod());
					ds.setBuscode(collMtsBopBhnDs.getBuscode());
				}
			}
			PageQueryResult result = new PageQueryResult();
			result.setQueryResult(mtsBopBhnDsInfos);
			return result;
		}
		return null;
	}

}
