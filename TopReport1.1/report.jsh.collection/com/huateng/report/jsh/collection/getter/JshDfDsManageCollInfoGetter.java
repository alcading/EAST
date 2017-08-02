package com.huateng.report.jsh.collection.getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import resource.bean.report.MtsJshDefgDs;
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

public class JshDfDsManageCollInfoGetter extends BaseGetter {
	
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
			this.setValue2DataBus(ReportConstant.QUERY_LOG_BUSI_NAME, "外汇账户内结汇"+message+"补录管理信息查询");
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
		Map paramsMap = this.getCommQueryServletRequest().getParameterMap();
		String op = (String) paramsMap.get("op");
		if(ADD.equals(op)) {
			PageQueryResult pageQueryResult = new PageQueryResult();
			MtsJshDefgDs ds = new MtsJshDefgDs();
			List list = new ArrayList();
			list.add(ds);
			pageQueryResult.setQueryResult(list);
			return pageQueryResult;
		} 
		if(MOD.equals(op) || DEL.equals(op) || DETAIL.equals(op)) {
			ROOTDAO dao = ROOTDAOUtils.getROOTDAO();
			String rec_id = (String) paramsMap.get("id");
			String hql = " from MtsJshDefgDs ds where 1 = 1 ";
			hql += " and ds.id = '"+rec_id+"' order by ds.lstUpdTm desc";
			List<MtsJshDefgDs> mtsJshDefgDsInfos = dao.queryByQL2List(hql);
			for(MtsJshDefgDs ds : mtsJshDefgDsInfos) {
				String id = ds.getFiller1();
				MtsJshDefgDs collMtsJshDefgDs = dao.query(MtsJshDefgDs.class, id);
				if(collMtsJshDefgDs != null) {
					//rptno,buscode,custype,custcod,idcode,custnm,fcyacc,lcyacc
					//oppuser,oppbank,fcyamt,fcyccy,exrate
					ds.setRptno(collMtsJshDefgDs.getRptno());
					ds.setBuscode(collMtsJshDefgDs.getBuscode());
					ds.setCustype(collMtsJshDefgDs.getCustype());
					ds.setCustcod(collMtsJshDefgDs.getCustcod());
					ds.setIdcode(collMtsJshDefgDs.getIdcode());
					ds.setCustnm(collMtsJshDefgDs.getCustnm());
					ds.setFcyacc(collMtsJshDefgDs.getFcyacc());
					ds.setLcyacc(collMtsJshDefgDs.getLcyacc());
					ds.setOppuser(collMtsJshDefgDs.getOppuser());
					ds.setOppbank(collMtsJshDefgDs.getOppbank());
					ds.setFcyamt(collMtsJshDefgDs.getFcyamt());
					ds.setFcyccy(collMtsJshDefgDs.getFcyccy());
					ds.setExrate(collMtsJshDefgDs.getExrate());
				}
			}
			PageQueryResult result = new PageQueryResult();
			result.setQueryResult(mtsJshDefgDsInfos);
			return result;
		}
		return null;
	}

}
