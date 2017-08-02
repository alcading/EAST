package com.huateng.report.bop.collection.getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import resource.bean.report.MtsBopDrDs;
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
 * @version 1.1
 * 2012-10-30
 *
 * */
@SuppressWarnings("unchecked")
public class BopRDsAddGetter extends BaseGetter {

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
		PageQueryResult pageQueryResult = new PageQueryResult();
		if(NEW_CMD.equals(op)) {
			//新增
			MtsBopDrDs mtsBopDrDs = new MtsBopDrDs();
			List list = new ArrayList();
			list.add(mtsBopDrDs);
			pageQueryResult.setQueryResult(list);
			return pageQueryResult;
		}
		if(MOD_CMD.equals(op) || DELETE_CMD.equals(op) || DETAILE_CMD.equals(op)) {
			//修改和删除
			String rec_id = (String) paramsMap.get("id");
			if(StringUtils.isBlank(rec_id)) throw new NullPointerException();
			String hql = " from MtsBopDrDs ds where 1 = 1 ";
			hql += " and ds.id = '"+rec_id+"'";
			ROOTDAO dao = ROOTDAOUtils.getROOTDAO();

			List<MtsBopDrDs> list  = new ArrayList<MtsBopDrDs>();
			list =  dao.queryByQL2List(hql);
			//获取最新的基础信息
			for(MtsBopDrDs md : list){
				String idBase = md.getFiller1();
				MtsBopDrDs mtsBopDrDsBase = dao.query(MtsBopDrDs.class, idBase);
				if(mtsBopDrDsBase!=null){
				md.setRptno(mtsBopDrDsBase.getRptno());
				md.setCustype(mtsBopDrDsBase.getCustype());
				md.setIdcode(mtsBopDrDsBase.getIdcode());
				md.setCustcod(mtsBopDrDsBase.getCustcod());
				md.setCustnm(mtsBopDrDsBase.getCustnm());
				md.setOppuser(mtsBopDrDsBase.getOppuser());
				md.setTxccy(mtsBopDrDsBase.getTxccy());
				md.setTxamt(mtsBopDrDsBase.getTxamt());
				md.setExrate(mtsBopDrDsBase.getExrate());
				md.setLcyamt(mtsBopDrDsBase.getLcyamt());
				md.setLcyacc(mtsBopDrDsBase.getLcyacc());
				md.setFcyamt(mtsBopDrDsBase.getFcyamt());
				md.setFcyacc(mtsBopDrDsBase.getFcyacc());
				md.setOthamt(mtsBopDrDsBase.getOthamt());
				md.setOthacc(mtsBopDrDsBase.getOthacc());
				md.setMethod(mtsBopDrDsBase.getMethod());
				md.setBuscode(mtsBopDrDsBase.getBuscode());
				md.setInchargeccy(mtsBopDrDsBase.getInchargeccy());
				md.setInchargeamt(mtsBopDrDsBase.getInchargeamt());
				}
			}			
			pageQueryResult.setQueryResult(list);
			return pageQueryResult;
		}
		return null;
	}
}