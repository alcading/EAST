package com.huateng.report.jsh.collection.getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import resource.bean.report.MtsJshDefgDs;
import resource.report.dao.ROOTDAO;
import resource.report.dao.ROOTDAOUtils;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;


/**
 * @author huang cheng
 * @version 1.0
 * 2012-10-30
 * */
@SuppressWarnings("unchecked")
public class JshGDsAddGetter extends BaseGetter {

	private static final String DELETE_CMD="del";
	private static final String NEW_CMD="new";
	private static final String MOD_CMD="mod";
	private static final String DETAILE_CMD="detail";
	@Override
	public Result call() throws AppException {
		// TODO Auto-generated method stub
		try {
			PageQueryResult pageResult = getData();
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

	@SuppressWarnings("rawtypes")
	private PageQueryResult getData() throws CommonException {
		// TODO Auto-generated method stub
		Map paramsMap = this.getCommQueryServletRequest().getParameterMap();
		String op = (String) paramsMap.get("op");
		System.out.println("op="+op);
		PageQueryResult pageQueryResult = new PageQueryResult();
		if(NEW_CMD.equals(op)) {
			//新增
			
			MtsJshDefgDs mtsJshDefgDs = new MtsJshDefgDs();
			List list = new ArrayList();
			list.add(mtsJshDefgDs);
			pageQueryResult.setQueryResult(list);
			return pageQueryResult;
		}
		if(MOD_CMD.equals(op) || DELETE_CMD.equals(op) || DETAILE_CMD.equals(op)) {
			//修改和删除
			String rec_id = (String) paramsMap.get("id");
			if(StringUtils.isBlank(rec_id)) throw new NullPointerException();
			String hql = " from MtsJshDefgDs model where 1 = 1 ";
			hql += " and model.id = '"+rec_id+"' order by model.lstUpdTm desc";
		
			ROOTDAO dao = ROOTDAOUtils.getROOTDAO();
			
			List<MtsJshDefgDs> list = dao.queryByQL2List(hql);
			for(MtsJshDefgDs mjsh : list){
				MtsJshDefgDs mtsJshDefgDsQuery = dao.query(MtsJshDefgDs.class, mjsh.getFiller1());
				if(mtsJshDefgDsQuery!=null){
					mjsh.setRptno(mtsJshDefgDsQuery.getRptno());  
					mjsh.setBuscode(mtsJshDefgDsQuery.getBuscode()) ;
					mjsh.setCustype(mtsJshDefgDsQuery.getCustype());  
					mjsh.setCustcod(mtsJshDefgDsQuery.getCustcod()) ;
					mjsh.setIdcode(mtsJshDefgDsQuery.getIdcode());  
					mjsh.setCustnm(mtsJshDefgDsQuery.getCustnm());   
					mjsh.setLcyacc(mtsJshDefgDsQuery.getLcyacc()) ; 
					mjsh.setFcyacc(mtsJshDefgDsQuery.getFcyacc()) ; 
					mjsh.setOppuser(mtsJshDefgDsQuery.getOppuser());  
					mjsh.setOppbank(mtsJshDefgDsQuery.getOppbank()) ; 
					mjsh.setLcyamt(mtsJshDefgDsQuery.getLcyamt());  
					mjsh.setLcyccy(mtsJshDefgDsQuery.getLcyccy()) ;  
					mjsh.setExrate(mtsJshDefgDsQuery.getExrate()); 
				} 
			}
			pageQueryResult.setQueryResult(list);
			return pageQueryResult;
			
		}
		return null;
	}
}